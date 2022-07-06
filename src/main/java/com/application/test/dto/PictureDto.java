package com.application.test.dto;

import com.application.test.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PictureDto {
    private Long id;
    private String description;
    private LocalDateTime created;
    private String pictureUrl;
    private User user;
}
