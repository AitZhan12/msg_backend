package com.codereview.msg.controller;

import com.codereview.msg.data.Chat;
import com.codereview.msg.data.Users;
import com.codereview.msg.exception.ErrorCode;
import com.codereview.msg.exception.ServiceException;
import com.codereview.msg.responses.SuccessResponse;
import com.codereview.msg.service.ChatService;
import com.codereview.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/chats")
public class ChatController extends BaseController {

    @Autowired
    ChatService chatService;

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> startChat(@RequestBody Chat chat) throws ServiceException {

        if (Objects.isNull(chat.getName()))
            throw ServiceException.builder().message("chat name is null").code(ErrorCode.CHAT_NAME_IS_NULL).build();

        if (chatService.existsChatName(chat.getName()))
            throw ServiceException.builder().message("chat name is already exists").code(ErrorCode.ALREADY_EXISTS).build();

       Long chatId = chatService.startChat(chat);
       return buildResponse(SuccessResponse.builder().message("started chat between users").data(chatId).build(), HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<?> getChatsByUser(@RequestBody Users users) {
        return ResponseEntity.ok(chatService.getChatListByUser(users.getId()));
    }

}
