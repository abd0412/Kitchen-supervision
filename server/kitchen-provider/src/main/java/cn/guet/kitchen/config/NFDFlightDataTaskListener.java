package cn.guet.kitchen.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/18
 **/
public class NFDFlightDataTaskListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        new TimerManager();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}
