package com.zero.aizero.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.zero.aizero.model.dto.chathistory.ChatHistoryQueryRequest;
import com.zero.aizero.model.entity.ChatHistory;
import com.zero.aizero.model.entity.User;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加对话历史
     *
     * @param appId       应用id
     * @param message     消息
     * @param messageType 消息类型
     * @param userId      用户id
     * @return 是否添加成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用 id 删除对话历史
     *
     * @param appId 应用id
     * @return 是否删除成功
     */
    boolean deleteByAppId(Long appId);

    /**
     * 分页查询 APP 的对话历史
     *
     * @param appId       应用id
     * @param pageSize    分页大小
     * @param lastCreateTime 最后创建时间
     * @param loginUser   登录用户
     * @return 分页结果
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    /**
     * 加载 对话历史到内存
     *
     * @param appId       应用id
     * @param chatMemory  对话历史缓存
     * @param maxCount    最大加载数量
     * @return 加载成功的数量
     */
    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);

    /**
     * 构造查询条件
     *
     * @param chatHistoryQueryRequest 查询条件
     * @return 查询条件
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);
}
