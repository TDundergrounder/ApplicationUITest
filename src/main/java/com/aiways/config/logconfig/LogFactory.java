package com.aiways.config.logconfig;

import org.apache.log4j.Logger;

public class LogFactory {

    protected  static Class _className;

    protected  static Logger _logger ;

    static {
        set_logger();
    }

    private static Logger set_logger(){
        _logger = Logger.getLogger(_className);
        return _logger;
    }
}
