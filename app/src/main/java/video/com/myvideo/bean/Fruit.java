package video.com.myvideo.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by win7 on 2018/4/23.
 */

public class Fruit  implements Parcelable{
    public  String url;
    public  String imageId;
    public  String imageTitile;

    public Fruit(String url, String imageId, String imageTitile) {
        this.url = url;
        this.imageId = imageId;
        this.imageTitile = imageTitile;
    }

    protected Fruit(Parcel in) {
        url = in.readString();
        imageId = in.readString();
        imageTitile = in.readString();
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageTitile() {
        return imageTitile;
    }

    public void setImageTitile(String imageTitile) {
        this.imageTitile = imageTitile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(imageId);
        dest.writeString(imageTitile);
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

}
