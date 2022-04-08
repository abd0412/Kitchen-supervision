package cn.guet.kitchen.config;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/18
 **/
@Slf4j
public class NFDFlightDataTimerTask extends TimerTask {
    @Override
    public void run() {
        try {
            // 在这里写你要执行的内容
            System.out.println("功能方法写在这里了...");
        } catch (Exception e) {
            log.info("-------------解析信息发生异常--------------");
        }
    }
}
