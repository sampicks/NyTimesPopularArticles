package com.nytimes.populararticles.retrofit.responseModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Media meta data.
 */
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

    /**
     * Instantiates a new Media meta data.
     *
     * @param in the in
     */
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

    /**
     * The constant CREATOR.
     */
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

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets format.
     *
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets format.
     *
     * @param format the format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

}
