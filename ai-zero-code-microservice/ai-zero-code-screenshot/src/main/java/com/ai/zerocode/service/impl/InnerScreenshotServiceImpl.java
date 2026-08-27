package com.ai.zerocode.service.impl;

import com.ai.zerocode.innerservice.InnerScreenshotService;
import com.ai.zerocode.service.ScreenshotService;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class InnerScreenshotServiceImpl implements InnerScreenshotService {

    @Resource
    private ScreenshotService screenshotService;

    @Override
    public String generateAndUploadScreenshot(String webUrl) {
        return screenshotService.generateAndUploadScreenshot(webUrl);
    }
}
