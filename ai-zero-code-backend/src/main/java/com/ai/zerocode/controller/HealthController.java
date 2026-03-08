package com.ai.zerocode.controller;

import com.ai.zerocode.common.BaseResponse;
import com.ai.zerocode.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthTest() {
        return ResultUtils.success("ok");
    }
}
