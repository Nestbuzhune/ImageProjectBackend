package com.nest.imagecollection.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nest.imagecollection.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
