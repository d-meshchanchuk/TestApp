package com.application.test.service.impl;

import com.application.test.dto.PictureDto;
import com.application.test.mapper.PictureMapper;
import com.application.test.model.Picture;
import com.application.test.model.User;
import com.application.test.repository.PictureRepository;
import com.application.test.repository.UserRepository;
import com.application.test.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final PictureMapper pictureMapper;

    @Override
    public List<PictureDto> findAll() {
        List<Picture> pictures = pictureRepository.findAll();
        List<PictureDto> result = pictures.stream().map(pictureMapper::PictureDtoFromPicture)
                .collect(Collectors.toList());
        log.info("IN findAll - {} pictures found", result.size());
        return result;
    }

    @Override
    public PictureDto findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        Picture picture = pictureRepository.findByUser(user);

        if (picture == null) {
            log.warn("IN findByUserName - no user found by username: {}", username);
        }

        log.info("IN findByUsername - user: {} found by username: {}", picture, username);
        return pictureMapper.PictureDtoFromPicture(picture);
    }

    @Override
    public PictureDto findById(Long id) {
        //todo
        Optional<Picture> picture = pictureRepository.findById(id);
        return null;
    }

    @Transactional
    @Override
    public void save(PictureDto pictureDto) {
        Picture picture = pictureMapper.toPicture(pictureDto);
        pictureRepository.save(picture);
        log.info("IN save - picture: {} successfully created", picture);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       pictureRepository.deleteById(id);
        log.info("IN delete - picture with id: {} successfully deleted", id);
    }
}
