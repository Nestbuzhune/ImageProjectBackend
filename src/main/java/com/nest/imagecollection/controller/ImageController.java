package com.nest.imagecollection.controller;

import com.nest.imagecollection.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ImageResponse uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String imageUrl = imageService.saveImage(imageFile);
        return new ImageResponse(imageUrl);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        // Retrieve the image from the database based on the provided id
        byte[] imageData = imageService.getImageData(id);

        // Set the appropriate content type and headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Modify the media type based on your image format
        headers.setContentLength(imageData.length);

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

    // You can add more endpoints as needed, such as listing all images, deleting images, etc.
}
