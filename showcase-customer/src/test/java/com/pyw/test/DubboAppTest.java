package com.pyw.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class DubboAppTest {

    private static Logger logger = LoggerFactory.getLogger(DubboAppTest.class);

    public static void main (String[] args) {

        logger.debug("start dubbo test");
        try {
            logger.info("reday to start dubbo test");

            com.alibaba.dubbo.container.Main.main(args);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
//    com.alibaba.dubbo.common.logger.LoggerFactory
}
