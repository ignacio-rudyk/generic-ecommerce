package com.ignacio.rudyk.generic.ecommerce.repository.entity;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base64")
    private Blob base64;

    @Column(name = "url_file")
    private String urlFile;

    public File(Blob base64, String urlFile) {
        this.base64 = base64;
        this.urlFile = urlFile;
    }

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getBase64() {
        return base64;
    }

    public void setBase64(Blob base64) {
        this.base64 = base64;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

}