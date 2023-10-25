package com.example.th5;

public enum Thumbnail {

    Thumbnail1("Thumbnail 1", R.drawable.thumbnail1),
    Thumbnail2("Thumbnail 2", R.drawable.thumbnail2),
    Thumbnail3("Thumbnail 3", R.drawable.thumbnail3),
    Thumbnail4("Thumbnail 4", R.drawable.thumbnail4);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}