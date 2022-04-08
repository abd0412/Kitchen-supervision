package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.config.WxAPIV3AesUtil;
import cn.guet.kitchen.entity.AccessToken;
import cn.guet.kitchen.entity.OpenId;
import cn.guet.kitchen.mapper.AccessTokenMapper;
import cn.guet.kitchen.mapper.OpenIdMapper;
import cn.guet.kitchen.service.MiniProgramPaymentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Slf4j
public class MiniProgramPaymentServiceImpl implements MiniProgramPaymentService {
    @Resource
    private AccessTokenMapper accessTokenMapper;

    @Resource
    private OpenIdMapper openIdMapper;

    //餐饮企业小程序应用ID
    String repastAppid = "wxc2c2d16a2d9ab49d";

    //支付所用直连商户号
    String repastMchid = "1608995427";

    //餐饮企业小程序唯一凭证密钥
    String repastAppSecret = "13d7cb73d1f7a373c635860445bfba37";

    //运维端小程序Appid
    String operationAppid = "wx8e7d3fe50fc485b9";

    //运维端小程序AppSecret
    String operationAppSecret = "9c7b4c607e89241dae04a0e464e1c7bb";

    private static final Map<String, Certificate> CERTIFICATE_MAP = new ConcurrentHashMap<String, java.security.cert.Certificate>();
    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public JSONObject getAccessToken(String appletsType, String grant_type) throws Exception {
        JSONObject responseObject = new JSONObject();
        try {
            String appid = "";
            String secret = "";
            if("repast".equals(appletsType)){
                appid = repastAppid;
                secret = repastAppSecret;
            }else if("operation".equals(appletsType)){
                appid = operationAppid;
                secret = operationAppSecret;
            }else{
                responseObject.put("errcode", 40004);
                responseObject.put("errmsg", "invalid appletsType");
                return responseObject;
            }
            // 创建Httpclient对象
            CloseableHttpClient Httpclient = HttpClients.createDefault ();
            // 定义请求的参数
            URI uri = new URIBuilder( "https://api.weixin.qq.com/cgi-bin/token" ).setParameter ( "grant_type", grant_type ).addParameter("appid", appid ).addParameter ( "secret", secret ).build ();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet ( uri );
            //response 对象
            CloseableHttpResponse response = null;
            try {
                // 执行http get请求
                response = Httpclient.execute ( httpGet );
                String content = EntityUtils.toString ( response.getEntity (), "UTF-8" );
                responseObject = JSONObject.parseObject ( content );
                // 若返回状态是否为200，则把token放入数据库
                if (response.getStatusLine ().getStatusCode () == 200) {
                    //记录token生成时间
                    String oneAccessToken = responseObject.getString ("access_token");
                    int expiresIn = responseObject.getInteger ("expires_in");
                    int hmExpiresIn = expiresIn*1000;
                    Date date = new Date();
                    Long nowTime = date.getTime();
                    nowTime += hmExpiresIn;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String deadLine = dateFormat.format(nowTime);
                    AccessToken accessToken = new AccessToken();
                    accessToken.setAppid(appid);
                    accessToken.setAccessToken(oneAccessToken);
                    accessToken.setExpiresIn(expiresIn);
                    accessToken.setDeadLine(deadLine);
                    //将获取到的token放入数据库
                    accessTokenMapper.updateByPrimaryKeySelective(accessToken);
                }
            } finally {
                if (response != null) {
                    response.close ();
                }
                Httpclient.close ();
            }
        } catch (Exception e) {
            log.error("出现异常", e);
            return responseObject;
        }
        return responseObject;
    }

    @Override
    public JSONObject toObtainOpenid(String appletsType, String js_code, String grant_type) {
        JSONObject responseObject = new JSONObject();
        try {
            String appid = "";
            String secret = "";
            if("repast".equals(appletsType)){
                appid = repastAppid;
                secret = repastAppSecret;
            }else if("operation".equals(appletsType)){
                appid = operationAppid;
                secret = operationAppSecret;
            }else{
                responseObject.put("errcode", 40004);
                responseObject.put("errmsg", "invalid appletsType");
                return responseObject;
            }
            // 创建Httpclient对象
            CloseableHttpClient Httpclient = HttpClients.createDefault ();
            // 定义请求的参数
            URI uri = new URIBuilder( "https://api.weixin.qq.com/sns/jscode2session" ).setParameter ( "appid", appid ).addParameter("secret", secret ).addParameter ( "js_code", js_code ).addParameter ( "grant_type", grant_type ).build ();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet ( uri );
            //response 对象
            CloseableHttpResponse response = null;
            try {
                // 执行http get请求
                response = Httpclient.execute ( httpGet );
                String content = EntityUtils.toString ( response.getEntity (), "UTF-8" );
                responseObject = JSONObject.parseObject ( content );
                // 若返回状态是否为200，则把token放入数据库
                if (response.getStatusLine ().getStatusCode () == 200) {
                    OpenId openId = JSON.parseObject(content, OpenId.class);
                    OpenId openIdSlt = openIdMapper.selectByPrimaryKey(openId.getOpenid());
                    if(openIdSlt.getOpenid()==null){
                        //将获取到的相关openid信息放入数据库
                        openIdMapper.insertSelective(openId);
                    }
                }
            } finally {
                if (response != null) {
                    response.close ();
                }
                Httpclient.close ();
            }
        } catch (Exception e) {
            log.error("出现异常", e);
            return responseObject;
        }
        return responseObject;
    }

    /**
     * 获得签名值
     */
    public String calculationSign(byte[] message) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException {
        Signature sign = Signature.getInstance("SHA256withRSA");
        PrivateKey yourPrivateKey = getPrivateKey("/root/1608995427_20210507_cert/apiclient_key.pem");
        System.out.println("yourPrivateKey==>"+yourPrivateKey);
        sign.initSign(yourPrivateKey);
        sign.update(message);

        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public String buildSignatureString(String appid, long timestamp, String nonceStr, String prepay_id) {
        return appid + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + "prepay_id="+prepay_id + "\n";
    }

    @Override
    public JSONObject getPrepaidOrder(String json) throws Exception {
        JSONObject responseObject = new JSONObject();
        try {
            String appid = "";
            JSONObject askJsonObject = JSONObject.parseObject(json);
            // 创建Httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault ();
            //请求URL
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi");
            //通知地址
            String notify_url = "https://m170973k01.51mypc.cn/kitcken_api/payment/receive/notification";
            // 请求body参数
            String appletsType = askJsonObject.getString("appletsType");
            if(appletsType.equals("repast")){
                askJsonObject.put("appid", repastAppid);
                askJsonObject.put("mchid", repastMchid);
                appid = repastAppid;
            }else{
                responseObject.put("errcode", 40004);
                responseObject.put("errmsg", "invalid appletsType");
                return responseObject;
            }
            askJsonObject.remove("appletsType");
            askJsonObject.put("notify_url", notify_url);
            StringEntity entity = new StringEntity(askJsonObject.toString(), "UTF-8");
            String postBody = EntityUtils.toString ( entity, "UTF-8" );
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            //获取签名信息
            HttpUrl httpurl = HttpUrl.parse("https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi");
            String signatureValue0 = getToken("POST", httpurl, postBody);
            String certificationType = "WECHATPAY2-SHA256-RSA2048";
            String authorization = certificationType + " " + signatureValue0;
            System.out.println("authorization==>"+authorization);
            httpPost.setHeader("Authorization", authorization);

            //完成签名并执行请求
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                String content = EntityUtils.toString ( response.getEntity (), "UTF-8" );
                System.out.println("content==>"+content);
                responseObject = JSONObject.parseObject ( content );
                int statusCode = response.getStatusLine().getStatusCode();
                //如果成功取到预支付交易会话标识
                if (statusCode == 200) {
                    String prepay_id = responseObject.getString("prepay_id");
                    long timestamp = System.currentTimeMillis() / 1000;
                    StringBuffer sb = new StringBuffer();
                    Random random = new Random();
                    for (int i = 0; i < 32; i++) {
                        sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
                    }
                    String nonceStr = sb.toString();
                    //构造签名串
                    String message = buildSignatureString(appid, timestamp, nonceStr, prepay_id);
                    System.out.println("message==>"+message);
                    //计算签名值
                    String signatureValue = calculationSign(message.getBytes("utf-8"));
                    System.out.println("signatureValue==>"+signatureValue);
                    responseObject.put("appid", appid);
                    responseObject.put("timeStamp", timestamp);
                    responseObject.put("nonceStr", nonceStr);
                    responseObject.put("paySign", signatureValue);
                }else {
                    throw new IOException("request failed");
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            log.error("出现异常", e);
            return responseObject;
        }
        return responseObject;
    }

    /**
     * 1、4、刷新获取微信支付平台证书序列号-公钥
     */
    public void refreshCertificate() throws GeneralSecurityException, IOException {
        String aPIv3Key = "DEKIoTAPIv3456789123huijkx234567";
        String serialNo = "";
        String nonce0 = "";
        String associatedData0 = "";
        String ciphertext0 = "";
        //获取签名
        HttpUrl httpurl = HttpUrl.parse("https://api.mch.weixin.qq.com/v3/certificates");
        String signatureValue = getToken("GET", httpurl,"");
        //获取平台证书列表
        JSONArray jsonArray = getCertificatesList(signatureValue);
        for(int i = 0; i<jsonArray.size(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            serialNo = jsonObject.getString("serial_no");
            nonce0 = jsonObject.getJSONObject("encrypt_certificate").getString("nonce");
            associatedData0 = jsonObject.getJSONObject("encrypt_certificate").getString("associated_data");
            ciphertext0 = jsonObject.getJSONObject("encrypt_certificate").getString("ciphertext");
        }
        //解密获得真正的微信平台证书公钥
        //String publicKey = decryptResponseBody(aPIv3Key, associatedData0, nonce0, ciphertext0);
        byte[] key = aPIv3Key.getBytes("UTF-8");
        WxAPIV3AesUtil aesUtil = new WxAPIV3AesUtil(key);
        String publicKey = aesUtil.decryptToString(associatedData0.getBytes("UTF-8"), nonce0.getBytes("UTF-8"), ciphertext0);
        System.out.println("publicKey==>"+publicKey);
        System.out.println("serialNo==>"+serialNo);
        final CertificateFactory cf = CertificateFactory.getInstance("X509");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(publicKey.getBytes(StandardCharsets.UTF_8));
        java.security.cert.Certificate certificate = null;
        try {
            certificate =  cf.generateCertificate(inputStream);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        //String responseSerialNo = objectNode.get("serial_no").asText();
        // 清理HashMap
        CERTIFICATE_MAP.clear();
        // 放入证书
        CERTIFICATE_MAP.put(serialNo, certificate);
    }

    /**
     * 2、获得签名信息
     */
    public String getToken(String method, HttpUrl url, String body) throws IOException, SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        String nonceStr = sb.toString();
        System.out.println("nonceStr==>"+nonceStr);
        //生成修改时间
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println("time==>"+time);
        long timestamp = System.currentTimeMillis() / 1000;
        String message = buildMessage(method, url, timestamp, nonceStr, body);//构造签名串
        System.out.println("message==>"+message);
        String signature = sign(message.getBytes("utf-8"));//计算签名值
        System.out.println("signature==>"+signature);

        return "mchid=\"" + "1608995427" + "\","
                + "nonce_str=\"" + nonceStr + "\","
                + "timestamp=\"" + timestamp + "\","
                + "serial_no=\"" + "5B081B878294733509F44EDED35FA0DE8D96F07C" + "\","
                + "signature=\"" + signature + "\"";
    }

    public String sign(byte[] message) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException {
        Signature sign = Signature.getInstance("SHA256withRSA");
        PrivateKey yourPrivateKey = getPrivateKey("/root/1608995427_20210507_cert/apiclient_key.pem");
        System.out.println("yourPrivateKey==>"+yourPrivateKey);
        sign.initSign(yourPrivateKey);
        sign.update(message);

        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public String buildMessage(String method, HttpUrl url, long timestamp, String nonceStr, String body) {
        String canonicalUrl = url.encodedPath();
        if (url.encodedQuery() != null) {
            canonicalUrl += "?" + url.encodedQuery();
        }

        return method + "\n"
                + canonicalUrl + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + body + "\n";
    }

    /**
     * 3、获取微信支付平台证书列表
     */
    public JSONArray getCertificatesList(String signatureValue){
        JSONArray responseArray = new JSONArray();
        try {
            // 创建Httpclient对象
            CloseableHttpClient Httpclient = HttpClients.createDefault ();
            // 定义请求的参数
            URI uri = new URIBuilder( "https://api.mch.weixin.qq.com/v3/certificates" ).build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet ( uri );
            //response 对象
            CloseableHttpResponse response = null;
            //认证类型
            String certificationType = "WECHATPAY2-SHA256-RSA2048";
            String authorization = certificationType + " " + signatureValue;
            System.out.println("authorization==>"+authorization);
            try {
                httpGet.addHeader("Authorization", authorization);
                httpGet.addHeader("Accept", "application/json");
                httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
                // 执行http get请求
                response = Httpclient.execute ( httpGet );
                String content = EntityUtils.toString ( response.getEntity (), "UTF-8" );
                JSONObject responseObject = JSONObject.parseObject ( content );
                System.out.println("responseObject==>"+responseObject);
                // 若返回状态是否为200，则把token放入数据库
                if (response.getStatusLine ().getStatusCode () == 200) {
                    responseArray = responseObject.getJSONArray("data");
                }
            } finally {
                if (response != null) {
                    response.close ();
                }
                Httpclient.close ();
            }
        } catch (Exception e) {
            log.error("出现异常", e);
            return responseArray;
        }
        return responseArray;
    }

    /**
     * 5、解密响应体.
     *
     * @param apiV3Key       API V3 KEY  API v3密钥 商户平台设置的32位字符串
     * @param associatedData  response.body.data[i].encrypt_certificate.associated_data
     * @param nonce          response.body.data[i].encrypt_certificate.nonce
     * @param ciphertext     response.body.data[i].encrypt_certificate.ciphertext
     * @return the string
     * @throws GeneralSecurityException the general security exception
     */
    public String decryptResponseBody(String apiV3Key,String associatedData, String nonce, String ciphertext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            SecretKeySpec key = new SecretKeySpec(apiV3Key.getBytes(StandardCharsets.UTF_8), "AES");
            GCMParameterSpec spec = new GCMParameterSpec(128, nonce.getBytes(StandardCharsets.UTF_8));

            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));

            byte[] bytes;
            try {
                bytes = cipher.doFinal(Base64Utils.decodeFromString(ciphertext));
            } catch (GeneralSecurityException e) {
                throw new IllegalArgumentException(e);
            }
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new IllegalStateException(e);
        } catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 2.1、获取私钥。
     *
     * @param filename 私钥文件路径  (required)
     * @return 私钥对象
     */
    public static PrivateKey getPrivateKey(String filename) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filename)), "utf-8");
        try {
            String privateKey = content.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("无效的密钥格式");
        }
    }

    /**
     * 获取证书。
     *
     * @param filename 证书文件路径  (required)
     * @return X509证书
     */
    public static X509Certificate getCertificate(String filename) throws IOException {
        InputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);

        try {
            CertificateFactory cf = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(bis);
            cert.checkValidity();
            return cert;
        } catch (CertificateExpiredException e) {
            throw new RuntimeException("证书已过期", e);
        } catch (CertificateNotYetValidException e) {
            throw new RuntimeException("证书尚未生效", e);
        } catch (CertificateException e) {
            throw new RuntimeException("无效的证书文件", e);
        } finally {
            bis.close();
        }
    }

    /**
     * 接收支付通知
     */
    @Override
    public JSONObject toReceiveNotification(String weChatPayTimestamp, String weChatPayNonce, String requestBody, String weChatPaySerial, String weChatPaySignature) throws GeneralSecurityException, IOException {
        JSONObject returnJSONObject = new JSONObject();
        String aPIv3Key = "DEKIoTAPIv3456789123huijkx234567";
        if (CERTIFICATE_MAP.isEmpty() || !CERTIFICATE_MAP.containsKey("weChatPaySerial")) {
            refreshCertificate();
        }
        java.security.cert.Certificate certificate = CERTIFICATE_MAP.get("6BA2283B2EC6F4D0D85BFA0086B9984A61F4D533");
        System.out.println("certificate==>"+certificate);
        //签名验证
        // 构造验签名串
        String signatureStr = Stream.of(weChatPayTimestamp, weChatPayNonce, requestBody).collect(Collectors.joining("\n", "", "\n"));
        System.out.println("signatureStr==>"+signatureStr);
        // 加载SHA256withRSA签名器
        Signature signer = Signature.getInstance("SHA256withRSA");
        // 用微信平台公钥对签名器进行初始化
        signer.initVerify(certificate);
        // 把我们构造的验签名串更新到签名器中
        signer.update(signatureStr.getBytes(StandardCharsets.UTF_8));
        // 把请求头中微信服务器返回的签名用Base64解码 并使用签名器进行验证
        boolean signerVerifyFlag = signer.verify(Base64Utils.decodeFromString(weChatPaySignature));//weChatPaySignature
        System.out.println("signerVerifyFlag==>"+signerVerifyFlag);
        if(signerVerifyFlag) {
            //解密
            try {
                JSONObject receiveJsonObject = JSONObject.parseObject(requestBody);
                String nonce = receiveJsonObject.getJSONObject("resource").getString("nonce");
                String associatedData = receiveJsonObject.getJSONObject("resource").getString("associated_data");
                String cipherText = receiveJsonObject.getJSONObject("resource").getString("ciphertext");
                //String decryptToString = decryptResponseBody(aPIv3Key, associatedData, nonce, cipherText);

                byte[] key = aPIv3Key.getBytes("UTF-8");
                WxAPIV3AesUtil aesUtil = new WxAPIV3AesUtil(key);
                String decryptToString = aesUtil.decryptToString(associatedData.getBytes("UTF-8"), nonce.getBytes("UTF-8"), cipherText);
                log.info("decryptToString" + decryptToString);

            } catch (Exception e) {
                log.error("出现异常", e);
                returnJSONObject.put("code", "FAIL");
                returnJSONObject.put("message", "失败");
                return returnJSONObject;
            }
            returnJSONObject.put("code", "SUCCESS");
            returnJSONObject.put("message", "成功");
            return returnJSONObject;
        }else{
            returnJSONObject.put("code", "FAIL");
            returnJSONObject.put("message", "失败");
            return returnJSONObject;
        }
    }

    /**
     * 查询订单状态
     */
    @Override
    public JSONObject toStatusSelect(String mchid, String out_trade_no) {
        JSONObject responseObject = new JSONObject();
        try {
            // 创建Httpclient对象
            CloseableHttpClient Httpclient = HttpClients.createDefault ();
            // 定义请求的参数
            URI uri = new URIBuilder( "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/" + out_trade_no).setParameter ( "mchid", mchid ).build ();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet ( uri );
            //response 对象
            CloseableHttpResponse response = null;
            try {
                // 执行http get请求
                response = Httpclient.execute ( httpGet );
                String content = EntityUtils.toString ( response.getEntity (), "UTF-8" );
                responseObject = JSONObject.parseObject ( content );
            } finally {
                if (response != null) {
                    response.close ();
                }
                Httpclient.close ();
            }
        } catch (Exception e) {
            log.error("出现异常", e);
            return responseObject;
        }
        return responseObject;
    }
}
