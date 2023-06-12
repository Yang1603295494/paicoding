package com.github.paicoding.forum.service.chatai.service.impl.chatgpt;

import com.github.paicoding.forum.api.model.enums.AISourceEnum;
import com.github.paicoding.forum.api.model.vo.chat.ChatItemVo;
import com.github.paicoding.forum.api.model.vo.chat.ChatRecordsVo;
import com.github.paicoding.forum.service.chatai.service.AbsChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

/**
 * @author YiHui
 * @date 2023/6/12
 */
@Slf4j
@Service
public class ChatGptAiServiceImpl extends AbsChatService {
    @Autowired
    private ChatGptIntegration chatGptIntegration;

    @Override
    public boolean doAnswer(String user, ChatItemVo chat) {
        return chatGptIntegration.gptReturn(Long.valueOf(user), chat);
    }

    @Override
    public boolean doAsyncAnswer(String user, ChatRecordsVo response, BiConsumer<Boolean, ChatRecordsVo> consumer) {
        return false;
    }

    @Override
    public AISourceEnum source() {
        return AISourceEnum.CHAT_GPT_3_5;
    }
}
