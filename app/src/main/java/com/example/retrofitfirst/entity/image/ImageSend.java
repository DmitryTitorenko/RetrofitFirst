package com.example.retrofitfirst.entity.image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 * <p>
 * This POJO use for correct send Image dino in JSON to server:
 * {
 * "filename": "[NAME]",
 * "target_uri": "pictures/[ADDR]",
 * "filemime": "image/[FORMAT]",
 * "file": "[BASE64]",
 * "filesize": "[SIZE]"
 * }
 * <p>
 * Comment:
 * [FID] - File ID
 * [NAME] - Full file name (dino.jpg)
 * [ADDR] - File address (dino.jpg)
 * [FORMAT] - File format (jpeg/png)
 * [BASE64] - base64 encoded file code
 * [SIZE] - Size (bites)
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public void setFileMime(String fileMime) {
        this.fileMime = fileMime;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
