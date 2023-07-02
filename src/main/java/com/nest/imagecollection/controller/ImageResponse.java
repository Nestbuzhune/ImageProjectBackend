package com.nest.imagecollection.controller;

public class ImageResponse {
    private String imageUrl;

    public ImageResponse(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

