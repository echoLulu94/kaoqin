package com.cxs.extension.ath.controller;

import com.cxs.extension.sys.interceptor.NoAuth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    /**
     * @return
     */
    @GetMapping(value = "/login")
    @NoAuth
    public String  index() {
        return "login";
    }
}
