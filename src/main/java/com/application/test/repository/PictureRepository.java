package com.application.test.repository;

import com.application.test.model.Picture;
import com.application.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByUser(User user);
}
