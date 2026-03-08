package com.ai.zerocode.service;

import jakarta.servlet.http.HttpServletResponse;

public interface ProjectDownloadService {

    /**
     * 下载项目为 zip文件
     *
     * @param projectPath
     * @param downloadFileName
     * @param response
     * @return
     */
    void downloadProjectAsZip(String projectPath, String downloadFileName, HttpServletResponse response);
}
