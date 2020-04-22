package com.waem.hivePrototype.chatRoomList.vo;

import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class RoomFile extends RealmObject  {
    private String id;
    private String filePath;
    private String fileType;
    private boolean division = true;

    public RoomFile() {
    }

    public RoomFile(String id, String filePath, FileType fileType, boolean division) {
        this.id = id;
        this.filePath = filePath;
        this.fileType = fileType.toString();
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
        return FileType.valueOf(fileType);
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType.toString();
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
