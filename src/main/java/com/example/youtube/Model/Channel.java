package com.example.youtube.Model;

public class Channel {
    private String id;
    private String name;
    private String description;
    private Byte image;  //?????
    public Channel(String id,String name,String description){
        this.id=id;
        this.description=description;
        this.name=name;
        // image ?????
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = description;
        //add database method
    }

    public void changeName(String name) {
        this.name = name;
        // you should know this is unique
        //add database method
    }
}
