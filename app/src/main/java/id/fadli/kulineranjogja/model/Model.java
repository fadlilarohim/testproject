package id.fadli.kulineranjogja.model;

import java.io.Serializable;

/**
 * Created by fadli on 28/10/2016.
 */

public class Model {

    private String name, deskripsi;
    private int thumbnail;

    public Model() {

    }

    public Model(String name, String deskripsi, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.deskripsi = deskripsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
