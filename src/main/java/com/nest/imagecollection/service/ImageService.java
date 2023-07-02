package com.nest.imagecollection.service;
import com.nest.imagecollection.Repository.ImageRepository;
import com.nest.imagecollection.entity.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String saveImage(MultipartFile imageFile) {
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());

        try {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setFileName(fileName);
            imageEntity.setData(imageFile.getBytes());
            imageRepository.save(imageEntity);
            return "/api/images/" + imageEntity.getId(); // Assuming images are served from "/api/images/{id}"
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public byte[] getImageData(Long id) {
        return new byte[0];
    }
}
