package com.ai.zerocode.service;

/**
 * 截图服务
 */
public interface ScreenshotService {

    /**
     * 通用的截图服务，可以得到访问地址
     *
     * @param webUrl 要截图的网页 URL
     * @return
     */
    String generateAndUploadScreenshot(String webUrl);
}
