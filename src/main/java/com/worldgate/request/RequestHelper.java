package com.worldgate.request;

import com.worldgate.util.LogUtil;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

    static String process(HttpServletRequest req) {
        LogUtil.log.info("hit RH");
        switch (req.getRequestURI()) {
            case "cucumber.do":
                //return RunTest.testCucumber(req);
                return "html/FailedLogin.html";
            case "/html/home.do":
                return "html/FailedLogin.html";
            default:
                return "html/FailedLogin.html";
        }
    }


}
