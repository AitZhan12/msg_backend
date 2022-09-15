package com.codereview.msg.service.impl;

import com.codereview.msg.data.Users;
import com.codereview.msg.exception.ErrorCode;
import com.codereview.msg.exception.ServiceException;
import com.codereview.msg.repository.UserRepository;
import com.codereview.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(Long id) throws ServiceException {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Users> findAllWithDeleted() {
        return null;
    }

    @Override
    public Users update(Users user) throws ServiceException {
        return null;
    }

    @Override
    public Long save(Users user) throws ServiceException {
        if(findByUserName(user.getUsername())) {
            throw ServiceException.builder().message("user name already exists").code(ErrorCode.ALREADY_EXISTS).build();
        }
        Users users = userRepository.save(user);
        return users.getId();
    }

    @Override
    public boolean findByUserName(String userName) {
        return userRepository.existsByUsername(userName);
    }

    @Override
    public void delete(Users user) throws ServiceException {

    }

    @Override
    public void deleteById(Long id) throws ServiceException {

    }

    @Override
    public boolean findUser(Users users) {
        Long userId = users.getId();
        return userRepository.findById(userId).isPresent();
    }
}
