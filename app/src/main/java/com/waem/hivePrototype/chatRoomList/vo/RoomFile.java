package com.waem.hivePrototype.chatRoomList.vo;

import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;

public class RoomFile {
    private String id;
    private String filePath;
    private FileType fileType;
    private boolean division = true;

    public RoomFile() {
    }

    public RoomFile(String id, String filePath, FileType fileType, boolean division) {
        this.id = id;
        this.filePath = filePath;
        this.fileType = fileType;
        this.division = division;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public boolean isDivision() {
        return division;
    }

    public void setDivision(boolean division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "RoomFile{" +
                "id='" + id + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType=" + fileType +
                ", division=" + division +
                '}';
    }
}
