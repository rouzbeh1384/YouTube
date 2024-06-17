package com.example.youtube.Model;

public class PlayList {
    private String description;
    private String name;
    private String ID;
    private String channelID;
    //videos???
    private PlayList(String name,String ID,String channelID,String description){
        this.description=description;
        this.ID=ID;
        this.name=name;
        this.channelID=channelID;
    }

    public String getDescription() {
        return description;
    }

    public String getChannelID() {
        return channelID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public void editDescription(String description) {
        this.description = description;
    }
    public void changeName(String name){
        this.name=name;
    }
}
