package com.codereview.msg.data;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(columnDefinition = "chat_id")
    private Chat chat;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
    private Users author;

    private String text;

    @CreationTimestamp
    private Date created_at;
}
