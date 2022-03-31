package com.codereview.msg.service;

import com.codereview.msg.data.Users;
import com.codereview.msg.exception.ServiceException;

import java.util.List;

public interface UserService {
    List<Users> findAll();
    Users findById(Long id) throws ServiceException;
    List<Users> findAllWithDeleted();
    Users update(Users user) throws ServiceException;
    Long save(Users user) throws ServiceException;
    boolean findByUserName(String userName);
    void delete(Users user) throws ServiceException;
    void deleteById(Long id) throws ServiceException;
    boolean findUser(Users users);
}
