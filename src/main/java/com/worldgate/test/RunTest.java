package com.worldgate.test;

import com.worldgate.util.LogUtil;

import javax.servlet.http.HttpServletRequest;

public class RunTest {


    public static String testCucumber(HttpServletRequest req) {
        LogUtil.log.info("Log Reached");
        return "Servlet Working";
    }
}
