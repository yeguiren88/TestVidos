package video.com.myvideo.bean;

/**
 * Created by win7 on 2018/5/4.
 */

public class DianZanBean  {
    public String name;
    public String Id;

    public DianZanBean(String name, String id) {
        this.name = name;
        Id = id;
    }
    public DianZanBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
