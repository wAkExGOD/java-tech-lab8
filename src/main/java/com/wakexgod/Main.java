package com.wakexgod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Test Log4j2:
        logger.info("Start program...");

        WordCounter.execute();

        // Test Log4j2:
        logger.info("End program.");
    }
}