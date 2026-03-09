package com.ai.zerocode.langgraph4j.node;

import com.ai.zerocode.ai.AiCodeGenTypeRoutingService;
import com.ai.zerocode.langgraph4j.state.WorkflowContext;
import com.ai.zerocode.model.enums.CodeGenTypeEnum;
import com.ai.zerocode.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

/**
 * 智能路由节点
 */
@Slf4j
public class RouterNode {
    public static AsyncNodeAction<MessagesState<String>> create() {
        return node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            log.info("执行节点：智能路由");
            CodeGenTypeEnum generationType;
            try {
                // 获取 AI 路由服务
                AiCodeGenTypeRoutingService routingService = SpringContextUtil.getBean(AiCodeGenTypeRoutingService.class);
                // 根据原始提示词进行智能路由
                generationType = routingService.routeCodeGenType(context.getOriginalPrompt());
                log.info("AI 智能路由完成，选择类型：{}（{}）", generationType.getText(), generationType.getValue());
            } catch (Exception e) {
                log.error("AI 智能路由失败，默认使用 HTML 类型：{}", e.getMessage());
                generationType = CodeGenTypeEnum.HTML;
            }
            // 更新状态
            context.setCurrentStep("智能路由");
            context.setGenerationType(generationType);
            return WorkflowContext.saveContext(context);
        });
    }
}
