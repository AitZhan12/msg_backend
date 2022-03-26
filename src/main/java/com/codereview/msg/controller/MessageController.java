package com.codereview.msg.controller;

import com.codereview.msg.data.Chat;
import com.codereview.msg.data.Message;
import com.codereview.msg.exception.ErrorCode;
import com.codereview.msg.exception.ServiceException;
import com.codereview.msg.responses.ErrorResponse;
import com.codereview.msg.responses.SuccessResponse;
import com.codereview.msg.service.MessageService;
import com.codereview.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController extends BaseController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {

        if (!userService.findUser(message.getAuthor()))
            buildErrorResponse(ServiceException.builder().message("user not found").code(ErrorCode.USER_NOT_FOUND).build());

        Long messageId = messageService.sendMessage(message);
        return buildResponse(SuccessResponse.builder().message("message sent").data(messageId).build(), HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<?> getMessages(@RequestBody Chat chat) {
        return ResponseEntity.ok(messageService.getAllMessagesInChat(chat));
    }
}
