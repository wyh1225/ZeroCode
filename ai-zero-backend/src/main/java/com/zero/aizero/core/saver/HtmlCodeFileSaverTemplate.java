package com.zero.aizero.core.saver;

import cn.hutool.core.util.StrUtil;
import com.zero.aizero.ai.model.HtmlCodeResult;
import com.zero.aizero.exception.BusinessException;
import com.zero.aizero.exception.ErrorCode;
import com.zero.aizero.service.impl.CodeGenTypeEnum;

/**
 * HTML 文件保存器
 */
public class HtmlCodeFileSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult> {

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    protected void saveFiles(HtmlCodeResult result, String baseDirPath) {
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
    }

    @Override
    protected void validateInput(HtmlCodeResult result) {
        super.validateInput(result);
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML 代码不能为空");
        }
    }
}
