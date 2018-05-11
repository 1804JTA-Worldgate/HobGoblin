package com.worldgate.request;

import com.worldgate.test.RunTest;
import com.worldgate.util.LogUtil;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

    static String process(HttpServletRequest req) {
        LogUtil.log.info("hit RH");
        switch (req.getRequestURI()) {
            case "/AngularHG/src/app/cucumber/cucumber.do":
                return RunTest.testCucumber(req);
            case "/html/home.do":
                return "html/FailedLogin.html";
            default:
                return "html/FailedLogin.html";
        }
    }


}
