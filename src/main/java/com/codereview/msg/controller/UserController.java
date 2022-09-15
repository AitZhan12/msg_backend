package com.codereview.msg.controller;

import com.codereview.msg.data.Users;
import com.codereview.msg.exception.ErrorCode;
import com.codereview.msg.exception.ServiceException;
import com.codereview.msg.responses.SuccessResponse;
import com.codereview.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody Users users) throws ServiceException {
        if (userService.findByUserName(users.getUsername())) {
            throw ServiceException.builder().message("username already exists").code(ErrorCode.ALREADY_EXISTS).build();
        }
        Long userId = userService.save(users);
        return buildResponse(SuccessResponse.builder().message("added").data(userId).build(), HttpStatus.OK);
    }
}
