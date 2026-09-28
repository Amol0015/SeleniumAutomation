package com.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	  // दुरुस्ती: आपण संपूर्ण क्लासचा अचूक रेफरन्स (Log.class) दिला आहे, जेणेकरून Log4j2 याला ओळखेल
  

    public static void main(String[] args) {
    	   Logger log = LogManager.getLogger(Log.class);
        System.out.println("this is logger demo");
        
        // आता हे सर्व मेसेजेस कंसोल आणि फाईलमध्ये प्रिंट होतील
        log.info("for log only");
        log.debug("for debug");
        log.error("error msg");
        log.warn("warning msg");
    }
}
