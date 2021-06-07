package com.llazar.user_service.service;

import java.util.logging.LogManager;

import java.util.logging.Logger;

public class LoggerService
{

    public Logger getLogger(Class classObj)
    {
        Logger logger = LogManager.getLogManager().getLogger(String.valueOf(classObj));
        return logger;
    }
}
