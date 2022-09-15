package com.codereview.msg.service.impl;

import com.codereview.msg.data.Chat;
import com.codereview.msg.data.Message;
import com.codereview.msg.repository.MessageRepository;
import com.codereview.msg.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Long sendMessage(Message message) {
        Message m = messageRepository.save(message);
        return m.getId();
    }

    @Override
    public List<Message> getAllMessagesInChat(Chat chat) {
        return messageRepository.findAllByChatOrderByCreated_atDesc(chat);
    }
}
