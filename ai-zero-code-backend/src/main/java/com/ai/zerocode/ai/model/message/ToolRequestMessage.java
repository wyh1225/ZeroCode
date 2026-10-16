package com.ai.zerocode.ai.model.message;

import dev.langchain4j.model.chat.response.PartialToolCall;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 工具调用消息
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class ToolRequestMessage extends StreamMessage {

    private int index;

    private String id;

    private String name;

    private String partialArguments;

    public ToolRequestMessage(PartialToolCall partialToolCall) {
        super(StreamMessageTypeEnum.TOOL_REQUEST.getValue());
        this.index = partialToolCall.index();
        this.id = partialToolCall.id();
        this.name = partialToolCall.name();
        this.partialArguments = partialToolCall.partialArguments();
    }
}
