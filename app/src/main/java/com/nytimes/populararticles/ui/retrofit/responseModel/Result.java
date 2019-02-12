package com.nytimes.populararticles.ui.retrofit.responseModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("column")
    @Expose
    private Object column;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("asset_id")
    @Expose
    private long assetId;
    @SerializedName("views")
    @Expose
    private int views;
//    @SerializedName("des_facet")
//    @Expose
//    private List<String> desFacet = null;
//    @SerializedName("org_facet")
//    @Expose
//    private List<String> orgFacet;
//    @SerializedName("per_facet")
//    @Expose
//    private List<String> perFacet = null;
//    @SerializedName("geo_facet")
//    @Expose
//    private String geoFacet;
    @SerializedName("media")
    @Expose
    private List<Medium> media = null;

    protected Result(Parcel in) {
        url = in.readString();
        adxKeywords = in.readString();
        section = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        _abstract = in.readString();
        publishedDate = in.readString();
        source = in.readString();
        id = in.readLong();
        assetId = in.readLong();
        views = in.readInt();
        media = in.createTypedArrayList(Medium.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(adxKeywords);
        dest.writeString(section);
        dest.writeString(byline);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(_abstract);
        dest.writeString(publishedDate);
        dest.writeString(source);
        dest.writeLong(id);
        dest.writeLong(assetId);
        dest.writeInt(views);
        dest.writeTypedList(media);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

//    public List<String> getDesFacet() {
//        return desFacet;
//    }
//
//    public void setDesFacet(List<String> desFacet) {
//        this.desFacet = desFacet;
//    }

//    public List<String> getOrgFacet() {
//        return orgFacet;
//    }
//
//    public void setOrgFacet(List<String> orgFacet) {
//        this.orgFacet = orgFacet;
//    }

//    public List<String> getPerFacet() {
//        return perFacet;
//    }
//
//    public void setPerFacet(List<String> perFacet) {
//        this.perFacet = perFacet;
//    }
//
//    public String getGeoFacet() {
//        return geoFacet;
//    }
//
//    public void setGeoFacet(String geoFacet) {
//        this.geoFacet = geoFacet;
//    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

}