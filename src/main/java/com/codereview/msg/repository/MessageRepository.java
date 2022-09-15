package com.codereview.msg.repository;

import com.codereview.msg.data.Chat;
import com.codereview.msg.data.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByChatOrderByCreated_atDesc(Chat chat);
}
