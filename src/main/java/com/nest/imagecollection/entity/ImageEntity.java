package com.nest.imagecollection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public void setFileName(String fileName) {
    }

    public void setData(byte[] bytes) {
    }

    public int getId() {
        return 0;
    }

    // Getters and setters

    // ...

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return byte[] return the data
     */
    public byte[] getData() {
        return data;
    }

}
