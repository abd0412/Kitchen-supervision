package cn.gxhunter.tourism.common.util;

import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CommonUtil {

	/**
	 * 去掉BigDecimal后面多余的0
	 * 
	 * @author liangd
	 * 
	 * @param b
	 * @return
	 */
	public static BigDecimal removeTailZero(BigDecimal b) {
		if (b == null) {
			return b;
		}
		String s = b.toString();
		if (s.indexOf(".") == -1) {
			return b;
		}
		int i, len = s.length();
		for (i = 0; i < len; i++)
			if (s.charAt(len - 1 - i) != '0')
				break;
		if (s.charAt(len - i - 1) == '.')
			return new BigDecimal(s.substring(0, len - i - 1));
		return new BigDecimal(s.substring(0, len - i));
	}

	/**
	 * 取得指定精度的Double值
	 * 
	 * @author liangd
	 * 
	 * @param d
	 * @param scale
	 * @return
	 */
	public static Double getDecimalByScale(Double d, int scale) {

		if (d != null) {
			String s = d.toString();
			BigDecimal b = new BigDecimal(s);
			// 只保留小数点后x位（参数决定）
			b = b.setScale(scale, BigDecimal.ROUND_DOWN);
			// 去掉小数点后多余的零
			b = removeTailZero(b);
			return b.doubleValue();
		}
		return d;
	}

	/**
	 * 取得默认精度（3位小数）的Double值
	 * 
	 * @author liangd
	 * 
	 * @param d
	 * @return
	 */
	public static Double getDecimalByScale(Double d) {

		if (d != null) {
			String s = d.toString();
			BigDecimal b = new BigDecimal(s);
			// 只保留小数点后3位
			b = b.setScale(3, BigDecimal.ROUND_DOWN);
			// 去掉小数点后多余的零
			b = removeTailZero(b);
			return b.doubleValue();
		}
		return d;
	}

	/**
	 * 取得默认精度（3位小数）的Double值
	 * 
	 * @author liangd
	 * 
	 * @param d
	 * @return
	 */
	public static String getDecimalByScale(String d) {

		if (d != null && d.trim().length() > 0) {
			String s = d.toString();
			BigDecimal b = new BigDecimal(s);
			// 只保留小数点后3位
			b = b.setScale(3, BigDecimal.ROUND_DOWN);
			// 去掉小数点后多余的零
			b = removeTailZero(b);
			return b.toString();
		}
		return d;
	}

	/**
	 * 解析字符串为Integer，当字符串为null或者空时，返回默认值
	 * 
	 * @author liangd
	 * 
	 * @param str
	 * @param defaultReturn
	 * @return
	 */
	public static Integer parseInt(String str, Integer defaultReturn) {
		if (str == null || str.trim().length() == 0) {
			return defaultReturn;
		}
		try {
			if (str != null && str.trim().length() > 0) {
				return Integer.parseInt(str.trim());
			}
		} catch (Exception e) {
			// 如果发生异常，则不做处理，最后返回传进来的默认值
		}
		return defaultReturn;
	}

	public static BigDecimal parseDecimal(String str, String defaultReturn) {
		if (str == null || str.trim().length() == 0) {
			if (isEmpty(defaultReturn)) {
				return null;
			}
			return new BigDecimal(defaultReturn);
		}
		try {
			if (str != null && str.trim().length() > 0) {
				return new BigDecimal(str.trim());
			}
		} catch (Exception e) {
			// 如果发生异常，则不做处理，最后返回传进来的默认值
		}
		return new BigDecimal(defaultReturn);
	}

	/**
	 * 将数组拼接成用指定分隔符隔开的字符串
	 * 
	 * @author liangd
	 * @param array
	 * @param separator
	 * @return
	 */
	public static String toSplitStr(String[] array, String separator) {
		StringBuffer splitStr = new StringBuffer();
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				if (i != 0) {
					splitStr.append(separator);
				}
				splitStr.append(array[i]);
			}
		}

		return splitStr.toString();
	}

	/**
	 * 将Integer转化为String
	 * 
	 * @param value
	 * @return
	 */
	public static String toString(Integer value) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}

	/**
	 * 
	 * @Title: toString
	 * @Create：qiny 2011-05-17
	 * @Description: 将BigDecimal转化为String
	 * @param
	 * @param value
	 * @return String 返回类型
	 * @throws
	 */
	public static String toString(BigDecimal value) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}

	/**
	 * 
	 * @Title: toString
	 * @Create：qiny 2011-05-18
	 * @Description: 将Date转化为String
	 * @param
	 * @param value
	 * @return String 返回类型
	 * @throws
	 */
	public static String toString(Date value) {
		if (value != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(value);
		}
		return null;
	}

	/**
	 * 
	 * @Title: bSubstring
	 * @Create：qiny 2011-08-30
	 * @Description: 按字节长度截取字符串
	 * @param
	 * @param s
	 * @param
	 * @param length
	 * @param
	 * @throws Exception
	 *             设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String bSubstring(String s, int length) throws Exception {
		/*
		 * c#及java采用Unicode 16（UCS2）编码 byte[] bytes = s.getBytes("Unicode")
		 * 生成的字节数组中前两个字节是标志位，bytes[0] = -2，bytes[1] = -1，因此，
		 * 要从第三个字节开始扫描，对于一个英文或数字字符，UCS2编码的第二个字节是相应 的ASCII，第一个字节是0，如a的UCS2编码是0
		 * 97，而汉字两个字节都不为0， 因此，可以利于UCS2编码的这个规则来计算实际的字节数。
		 */
		byte[] bytes = s.getBytes("Unicode");

		int n = 0; // 表示当前的字节数
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++) {
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1) {
				n++; // 在UCS2第二个字节时n加1
			} else {
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1)

		{
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}

		return new String(bytes, 0, i, "Unicode");
	}

	/**
	 * return String 格式化文件大小，如1024b改为1KB，1024kb改为1MB
	 * 
	 * @param fileSize
	 * @return
	 * @author mas Jun 23, 2010
	 */
	public static String getFileSizeStyle(Long fileSize) {
		DecimalFormat df = new DecimalFormat("###.##");
		float f;
		if (fileSize < 1024 * 1024) {
			f = (float) ((float) fileSize / (float) 1024);
			return (df.format(new Float(f).doubleValue()) + "KB");
		} else {
			f = (float) ((float) fileSize / (float) (1024 * 1024));
			return (df.format(new Float(f).doubleValue()) + "MB");
		}
	}

	 /**
     * 判断对象是否为空
     * add by xufl
     * 注意：""的字符串是不是空对象,调用此函数会返回false
     * @param obj
     * @return 
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.toString().equals("")) {
            return true;
        }
        return false;
    }
	
	public static boolean isEmpty(String value) {
		if (value == null || value.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean notEmpty(String value) {
		if (value == null || value.trim().length() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * return String 读文件内容成字符串
	 * 
	 * @param filePathAndName
	 *            文件路径
	 * @param encoding
	 *            文件格式如"utf-8"
	 * @return
	 * @throws IOException
	 * @author mas Jun 30, 2010
	 */
	public static String readFile(String filePathAndName, String encoding) throws IOException {
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";
		FileInputStream fs = null;
		InputStreamReader isr = null;
		try {
			fs = new FileInputStream(filePathAndName);
			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			BufferedReader br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					str.append(data + "\r\n");
				}
			} catch (IOException e) {
				str.append(e.toString());
			}
			st = str.toString();
		} catch (IOException es) {
			throw es;
		} finally {
			if (fs != null) {
				fs.close();
			}
			if (isr != null) {
				isr.close();
			}
		}
		return st;
	}

	/**
	 * return void 创建文件
	 * 
	 * @param filePathAndName
	 *            文件路径
	 * @param fileContent
	 *            字符串内容
	 * @param encoding
	 *            文件格式如"utf-8"
	 * @throws Exception
	 * @author mas Jun 30, 2010
	 */
	public static void createFile(String filePathAndName, String fileContent, String encoding) throws Exception {
		PrintWriter myFile = null;
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
		} catch (Exception e) {
			throw new Exception("创建文件操作出错", e);
		} finally {
			if (myFile != null) {
				myFile.close();
			}
		}
	}

	/**
	 * return void 写文件
	 * 
	 * @author mas Jun 30, 2010
	 */
	private void writeFile(String path, String fileContent) {
		try {
			FileWriter fw = new FileWriter(path);
			PrintWriter out = new PrintWriter(fw);
			out.print("hi,this will be wirte into the file!");
			out.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Uh oh, got an IOException error!");
			e.printStackTrace();
		}
	}

	/**
	 * 数组添加长度
	 * 
	 * @param
	 * @param
	 * @param
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static Object arrayAddLength(Object oldArray, int addLength) {
		Class c = oldArray.getClass();
		if (!c.isArray())
			return null;
		Class componentType = c.getComponentType();
		int length = Array.getLength(oldArray);
		int newLength = length + addLength;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(oldArray, 0, newArray, 0, length);
		return newArray;
	}

	/**
	 * 共通方法 复制对应的字段值
	 * 
	 * @author LXL
	 * @param beanFrom
	 * @param beanTo
	 * @param properties
	 * @throws Exception
	 */
	public static void copyProperties(Object beanFrom, Object beanTo, List<String> properties) throws Exception {
		Class cls = beanFrom.getClass();
		Class cls2 = beanTo.getClass();
		for (String fieldName : properties) {
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			Method method = cls.getMethod(methodName, new Class[0]); // 取得无参数方法

			Object inputValue = method.invoke(beanFrom, new Object[0]);// 调用方法取得返回值

			String methodName2 = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			Class reClass = method.getReturnType();

			// 由于是get方法，按照规约，是必定有返回值的，所以不需要考虑null的情况
			Class[] argClass = new Class[] { reClass };

			Method method2 = cls2.getMethod(methodName2, argClass);

			Object args[] = new Object[] { inputValue };
			method2.invoke(beanTo, args);
		}
	}

	/**
	 * 共通方法 复制对应的字段值，从form到bean
	 * 
	 * @author LXL
	 * @param beanFrom
	 * @param beanTo
	 * @param properties
	 * @throws Exception
	 */
	public static void copyFormToBean(Object beanFrom, Object beanTo, List<String> properties) throws Exception {
		Class cls = beanFrom.getClass();
		Class cls2 = beanTo.getClass();
		for (String fieldName : properties) {
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			Method method = cls.getMethod(methodName, new Class[0]); // 取得无参数方法

			Object inputValue = method.invoke(beanFrom, new Object[0]);// 调用方法取得返回值

			String methodName2 = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			Class reClass = method.getReturnType();

			if (methodName2.startsWith("setErdDecimalData")) {
				if (inputValue != null && inputValue.toString().trim().length() > 0) {
					inputValue = new BigDecimal(inputValue.toString());
				} else {
					inputValue = null;
				}

				reClass = BigDecimal.class;
			}

			// 由于是get方法，按照规约，是必定有返回值的，所以不需要考虑null的情况
			Class[] argClass = new Class[] { reClass };

			Method method2 = cls2.getMethod(methodName2, argClass);

			Object args[] = new Object[] { inputValue };
			method2.invoke(beanTo, args);
		}
	}

	/**
	 * 共通方法 复制对应的字段值，从form到bean
	 * 
	 * @author LXL
	 * @param beanFrom
	 * @param beanTo
	 * @param properties
	 * @throws Exception
	 */
	public static void copyBeanToForm(Object beanFrom, Object beanTo, List<String> properties) throws Exception {
		Class cls = beanFrom.getClass();
		Class cls2 = beanTo.getClass();
		for (String fieldName : properties) {
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			Method method = cls.getMethod(methodName, new Class[0]); // 取得无参数方法

			Object inputValue = method.invoke(beanFrom, new Object[0]);// 调用方法取得返回值

			String methodName2 = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			Class reClass = method.getReturnType();

			if (methodName.startsWith("getErdDecimalData")) {
				if (inputValue != null) {
					inputValue = inputValue.toString();
				} else {
					inputValue = "";
				}

				reClass = String.class;
			}

			// 由于是get方法，按照规约，是必定有返回值的，所以不需要考虑null的情况
			Class[] argClass = new Class[] { reClass };

			Method method2 = cls2.getMethod(methodName2, argClass);

			Object args[] = new Object[] { inputValue };
			method2.invoke(beanTo, args);
		}
	}

	public static String getHtmlAsText(String inputString) {
		if (inputString == null) {
			return "";
		}
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		java.util.regex.Matcher m_script;
		Pattern p_style;
		java.util.regex.Matcher m_style;
		Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>

			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>

			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr.replace("&nbsp;", " ");// 返回文本字符串
	}

	// 允许上传的文件类型
	private static String ALLOWED_FILE = ".(7z|aiff|asf|avi|bmp|csv|doc|fla|flv|gif|gz|gzip|jpeg|jpg|mid|mov|mp3|mp4|mpc|mpeg|mpg|ods|odt|pdf|png|ppt|pxd|qt|ram|rar|rm|rmi|rmvb|rtf|sdc|sitd|swf|sxc|sxw|tar|tgz|tif|tiff|txt|vsd|wav|wma|wmv|xls|xml|zip|xlsx|docx|pptx)$";

	private static String ALLOWED_IMAGE = ".(jpg|gif|jpeg|png|bmp)$";

	public static boolean checkFileType(String pattern, String fileName) {

		// 文件拓展名检查
		int index = fileName.lastIndexOf(".");
		if (index == -1 || fileName.substring(index).length() < 2) {
			return false;
		}
		String type = fileName.substring(index);
		type = type.toLowerCase();

		// 禁止上传危险文件
		if (!type.matches(ALLOWED_FILE)) {
			return false;
		}

		// XXX 只可以上传图片文件
		if ("mmdAdd".equals(pattern)) {// 【企业问题申报】
			if (!type.matches(ALLOWED_IMAGE)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回true
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	private static boolean equalObject(Object baseValue, Object value) {
		if (baseValue != null) {
			return baseValue.equals(value);
		} else if (value != null) {
			return false;
		}

		return true;
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回true
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean equal(String baseValue, String value) {
		return equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回true
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean equal(Integer baseValue, Integer value) {
		return equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回true
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean equal(Date baseValue, Date value) {
		return equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回true
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean equal(BigDecimal baseValue, BigDecimal value) {
		return equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回false
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean notEqual(String baseValue, String value) {

		return !equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回false
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean notEqual(Integer baseValue, Integer value) {

		return !equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回false
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean notEqual(BigDecimal baseValue, BigDecimal value) {

		return !equalObject(baseValue, value);
	}

	/**
	 * 比较两个对象的内容是否一样，调用对象的equal方法，当两个对象都为null时，返回false
	 * 
	 * @param baseValue
	 * @param value
	 * @return
	 */
	public static boolean notEqual(Date baseValue, Date value) {

		return !equalObject(baseValue, value);
	}
	
	//将字符串两边的空格（包括全角和半角）去掉(注意:字符串内部的空格不会去掉)
	public static String delSpace(String str) throws Exception {  
        if (str == null) {  
            return null;  
        }  
        String regStartSpace = "^[　 ]*";  
        String regEndSpace = "[　 ]*$";  
          
        // 连续两个 replaceAll   
        // 第一个是去掉前端的空格， 第二个是去掉后端的空格  
        String strDelSpace = str.replaceAll(regStartSpace, "").replaceAll(regEndSpace, "");  
        return strDelSpace;  
    } 
	
	/** pzw20140827add
	 * 用于: 整形转换成指定长度的字符串,不够长时,在前面用0填充
	 * @param i : 将要转换的数字
	 * @param length:转换后的字符串的长度
	 * @return
	 */
	public static String intToStringFillWithZero(int i, int length) {
		String result = Integer.toString(i);
		int iLength = result.length();
		if(iLength < length){
			for(int j=0; j<(length - iLength); j++){
				result = "0" + result;
			}
		}
		return result; 
	}
	
	/**
	 * 字符串转化为日期
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date stringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * @description:分页结果及总记录数以map返回的统一方法
	 * @author: shiliuyong
	 * @date: 2020/2/14 14:25
	 * @param: list 查询到的分页记录
	 * @param: total 查询到的总记录数
	 * @return: java.util.Map<java.lang.String,java.lang.Object>
	 */
	public static Map<String, Object> getResult(List<?> list,Integer total) {
		//将查询数据放入result
		Map<String,Object> result = new HashMap<>();
		result.put("list",list);
        result.put("total",total);

		return result;
	}

	/**
	 * @Description 生成最新编号
	 * @Author      BinXiang
	 * @Date        2020-03-26 16:33
	 * @param upCode	上级编号
	 * @param code		数据库最新单据编号
	 * @return: java.lang.String
	 **/
	public static String getLastCode(String upCode, String code){
		String endStr = "";

		if (!StringUtils.isEmpty(code)){
			//截取最后两位
			endStr = code.substring(code.length() - 2);
			//转Integer,+1
			Integer endNum = Integer.parseInt(endStr) + 1;
			//转为String
			endStr = new DecimalFormat("00").format(endNum);
		}else {
			endStr = "01";
		}

		if (upCode.equals("0")){
			upCode = "";
		}
		//拼接
		String resultCode = upCode.concat(endStr);

		return resultCode;
	}
}
