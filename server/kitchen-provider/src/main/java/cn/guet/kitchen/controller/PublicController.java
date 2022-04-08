package cn.guet.kitchen.controller;

import cn.guet.kitchen.GPSUtil;
import cn.guet.kitchen.entity.DataDingyao;
import cn.guet.kitchen.service.DataDingyaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/**
 * @Description 公共controller
 * @Author JiaFei
 * @Date 2020/5/11 15:41
 **/
@Api(description = "公共controller")
@RestController
@RequestMapping("/kitchen")
public class PublicController {

    @Autowired
    private DataDingyaoService dataDingyaoService;

    @ApiOperation("测试")
    @PostMapping("/test")
    public List<DataDingyao> list(String deviceCode, @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startTime, @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date endTime, Integer pageNo, Integer pageSize) {
        List<DataDingyao>  datas = dataDingyaoService.selectAllByImsi(deviceCode,startTime,endTime,pageNo,pageSize);
        for (DataDingyao data:datas) {
            double[] a = GPSUtil.gps84_To_Gcj02(Double.valueOf(data.getLat()),Double.valueOf(data.getLng()));

            data.setLat(String.valueOf(a[0]));
            data.setLng(String.valueOf(a[1]));

        }


        return datas;
    }
}
