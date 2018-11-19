package com.example.retrofitfirst.entity.image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class ImageSend {

    @SerializedName("filename")
    @Expose
    private String fileName;
    @SerializedName("target_uri")
    @Expose
    private String targetUri;
    @SerializedName("filemime")
    @Expose
    private String fileMime;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("filesize")
    @Expose
    private String fileSize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public String getFileMime() {
        return fileMime;
    }

    public void setFileMime(String fileMime) {
        this.fileMime = fileMime;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
