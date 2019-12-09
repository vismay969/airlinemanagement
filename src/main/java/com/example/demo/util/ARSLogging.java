package com.example.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ARSLogging {
    public static Logger log = LogManager.getLogger(ARSLogging.class);
    static void loggingmessage(String message)
    {
        log.debug("from logging func code");
    }
    public static void main(String[] args) {
        log.info("System started");
        log.debug("debuging code");
        log.error("System error");
        log.warn("warnings ");
        log.fatal("fatal error");
        log.trace("Trace system");
        ARSLogging.loggingmessage("log");
        System.out.println("System end");
    }

}
