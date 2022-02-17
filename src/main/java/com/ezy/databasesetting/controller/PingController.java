package com.ezy.databasesetting.controller;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller("/api/v1")
public class PingController {


    @DoGet("/ping")
    public String ping() {
        return "OK!";
    }
}
