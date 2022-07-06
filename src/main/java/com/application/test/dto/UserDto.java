package com.application.test.dto;

import com.application.test.model.Status;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Status status;
}
