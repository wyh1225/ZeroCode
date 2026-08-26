package com.ai.zerocode.core.saver;

import cn.hutool.core.util.StrUtil;
import com.ai.zerocode.ai.model.MultiFileCodeResult;
import com.ai.zerocode.exception.BusinessException;
import com.ai.zerocode.exception.ErrorCode;
import com.ai.zerocode.model.enums.CodeGenTypeEnum;

/**
 * 多文件代码保存器
 */
public class MultiFileCodeFileSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.MULTI_FILE;
    }

    @Override
    protected void saveFiles(MultiFileCodeResult result, String baseDirPath) {
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
        writeToFile(baseDirPath, "style.css", result.getCssCode());
        writeToFile(baseDirPath, "script.js", result.getJsCode());
    }

    @Override
    protected void validateInput(MultiFileCodeResult result) {
        super.validateInput(result);
        // HTML 代码不能为空, JS 和 CSS 允许为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML 代码不能为空");
        }
    }
}
