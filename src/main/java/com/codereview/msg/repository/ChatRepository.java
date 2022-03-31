package com.codereview.msg.repository;

import com.codereview.msg.data.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    boolean existsByName(String name);

    @Query(nativeQuery = true, value = "SELECT * from chat c JOIN chat_users cu ON c.id = cu.chat_id WHERE user_id: userId ORDER BY created_at desc")
    List<Chat> getAllByUserId(@Param("userId") Long userId);
}
