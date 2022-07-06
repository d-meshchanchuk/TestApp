package com.application.test.mapper;

import com.application.test.dto.PictureDto;
import com.application.test.model.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    PictureDto PictureDtoFromPicture(Picture picture);

    Picture toPicture(PictureDto pictureDtoЩ);
}
