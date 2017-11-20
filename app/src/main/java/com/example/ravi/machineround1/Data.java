package com.example.ravi.machineround1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ravi on 17/11/17.
 */

public class Data implements Serializable {

    String GroupImg,Groupname,ChatImg,MemeberName,Chattext;

    ArrayList<Chat> chatArrayList;

    public Data() {

        chatArrayList = new ArrayList<>();
    }

    public ArrayList<Chat> getChatArrayList() {
        return chatArrayList;
    }

    public void setChatArrayList(ArrayList<Chat> chatArrayList) {
        this.chatArrayList = chatArrayList;
    }

    public String getGroupImg() {
        return GroupImg;
    }

    public void setGroupImg(String groupImg) {
        GroupImg = groupImg;
    }

    public String getGroupname() {
        return Groupname;
    }

    public void setGroupname(String groupname) {
        Groupname = groupname;
    }

    public String getChatImg() {
        return ChatImg;
    }

    public void setChatImg(String chatImg) {
        ChatImg = chatImg;
    }

    public String getMemeberName() {
        return MemeberName;
    }

    public void setMemeberName(String memeberName) {
        MemeberName = memeberName;
    }

    public String getChattext() {
        return Chattext;
    }

    public void setChattext(String chattext) {
        Chattext = chattext;
    }
}
