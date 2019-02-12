package com.nytimes.populararticles.ui.retrofit.responseModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaMetaData implements Parcelable {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("width")
    @Expose
    private int width;

    protected MediaMetaData(Parcel in) {
        url = in.readString();
        format = in.readString();
        height = in.readInt();
        width = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(format);
        dest.writeInt(height);
        dest.writeInt(width);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MediaMetaData> CREATOR = new Creator<MediaMetaData>() {
        @Override
        public MediaMetaData createFromParcel(Parcel in) {
            return new MediaMetaData(in);
        }

        @Override
        public MediaMetaData[] newArray(int size) {
            return new MediaMetaData[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
