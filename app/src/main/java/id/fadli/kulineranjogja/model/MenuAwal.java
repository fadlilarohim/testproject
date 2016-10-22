package id.fadli.kulineranjogja.model;

/**
 * Created by fadli on 14/9/2016.
 */
public class MenuAwal {

    private String name;
    private int thumbnail;

    public MenuAwal(){
    }

    public MenuAwal(String name, int thumbnail){
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
