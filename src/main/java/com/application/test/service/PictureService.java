package com.application.test.service;

import com.application.test.dto.PictureDto;

import java.util.List;

public interface PictureService {

    List<PictureDto> findAll();

    PictureDto findByUsername(String username);

    PictureDto findById(Long id);

    void save(PictureDto picture);

    void delete(Long id);
}
