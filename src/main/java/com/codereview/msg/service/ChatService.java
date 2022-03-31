package com.codereview.msg.service;

import com.codereview.msg.data.Chat;
import com.codereview.msg.exception.ServiceException;

import java.util.List;

public interface ChatService {
    Long startChat(Chat chat) throws ServiceException;

    boolean existsChatName(String chatName);

    List<Chat> getChatListByUser(Long id);

}
