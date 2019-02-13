package com.nytimes.populararticles.retrofit.responsemodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Medium.
 */
public class Medium implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private int approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    private List<MediaMetaData> mediaMetadata = null;

    /**
     * Instantiates a new Medium.
     *
     * @param in the in
     */
    protected Medium(Parcel in) {
        type = in.readString();
        subtype = in.readString();
        caption = in.readString();
        copyright = in.readString();
        approvedForSyndication = in.readInt();
        mediaMetadata = in.createTypedArrayList(MediaMetaData.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(subtype);
        dest.writeString(caption);
        dest.writeString(copyright);
        dest.writeInt(approvedForSyndication);
        dest.writeTypedList(mediaMetadata);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * The constant CREATOR.
     */
    public static final Creator<Medium> CREATOR = new Creator<Medium>() {
        @Override
        public Medium createFromParcel(Parcel in) {
            return new Medium(in);
        }

        @Override
        public Medium[] newArray(int size) {
            return new Medium[size];
        }
    };

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets subtype.
     *
     * @return the subtype
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * Sets subtype.
     *
     * @param subtype the subtype
     */
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    /**
     * Gets caption.
     *
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets caption.
     *
     * @param caption the caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Gets copyright.
     *
     * @return the copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets copyright.
     *
     * @param copyright the copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * Gets approved for syndication.
     *
     * @return the approved for syndication
     */
    public int getApprovedForSyndication() {
        return approvedForSyndication;
    }

    /**
     * Sets approved for syndication.
     *
     * @param approvedForSyndication the approved for syndication
     */
    public void setApprovedForSyndication(int approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    /**
     * Gets media metadata.
     *
     * @return the media metadata
     */
    public List<MediaMetaData> getMediaMetadata() {
        return mediaMetadata;
    }

    /**
     * Sets media metadata.
     *
     * @param mediaMetadata the media metadata
     */
    public void setMediaMetadata(List<MediaMetaData> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

}