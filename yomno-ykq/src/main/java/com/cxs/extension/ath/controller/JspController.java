package com.cxs.extension.ath.controller;

import com.cxs.extension.sys.interceptor.NoAuth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping(value = "/login")
    @NoAuth
    public String testF2F() {
        return "login";
    }

}