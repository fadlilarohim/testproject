package id.fadli.kulineranjogja.model;

/**
 * Created by fadli on 23/10/2016.
 */

public class MenuKategori {

    private String name, deskripsi;
    private int thumbnail;

    public MenuKategori(){

    }

    public MenuKategori(String name, String deskripsi, int thumbnail ){
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
