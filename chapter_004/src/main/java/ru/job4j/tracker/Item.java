package ru.job4j.tracker;


import java.util.List;
import java.util.Objects;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long create;
    private List<String> comment;

    public Item(String name, String desc, long create) {
        this.name = name;
        this.desc = desc;
        this.create = create;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.create = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreate() {
        return create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }


}
