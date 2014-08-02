package org.xander.model;

import org.apache.log4j.Logger;

public class LoggerExample {

    final static Logger logger = Logger.getLogger(LoggerExample.class);

    public static void main(String[] args) {
        LoggerExample obj = new LoggerExample();
        obj.runMe("test");

        try{
            obj.divide();
        }catch(ArithmeticException ex){
            logger.error("Sorry, something wrong!", ex);
        }

    }

    private void runMe(String parameter) {

        if (logger.isDebugEnabled()) {
            logger.debug("This is debug : " + parameter);
        }

        if (logger.isInfoEnabled()) {
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter + "\n");
    }

    private void divide(){
        int i = 10 /0;
    }
}