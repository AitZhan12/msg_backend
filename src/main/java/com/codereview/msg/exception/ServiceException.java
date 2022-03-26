package com.codereview.msg.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends Exception {
    protected ErrorCode code;
    protected String message;
}
