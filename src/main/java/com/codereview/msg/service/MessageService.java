package com.codereview.msg.service;

import com.codereview.msg.data.Chat;
import com.codereview.msg.data.Message;

import java.util.List;

public interface MessageService {

    Long sendMessage(Message message);

    List<Message> getAllMessagesInChat(Chat chat);
}
