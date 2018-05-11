package video.com.myvideo.bean;

/**
 * Created by win7 on 2018/4/24.
 */

public class MyThreeBeanInfo {
    public String url;
    public String titile;
    public String id;

    public MyThreeBeanInfo(String url, String titile, String id) {
        this.url = url;
        this.titile = titile;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
