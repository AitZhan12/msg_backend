package com.codereview.msg.service.impl;

import com.codereview.msg.data.Chat;
import com.codereview.msg.repository.ChatRepository;
import com.codereview.msg.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Long startChat(Chat chat) {
        Chat c = chatRepository.save(chat);
        return c.getId();
    }

    @Override
    public boolean existsChatName(String chatName) {
        return chatRepository.existsByName(chatName);
    }

    @Override
    public List<Chat> getChatListByUser(Long userId) {
        return chatRepository.getAllByUserId(userId);
    }
}
