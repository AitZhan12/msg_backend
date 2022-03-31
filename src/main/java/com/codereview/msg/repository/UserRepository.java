package com.codereview.msg.repository;

import com.codereview.msg.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByUsername(String userName);

}
