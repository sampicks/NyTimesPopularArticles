package com.nytimes.populararticles.retrofit.responseModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Result.
 */
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

    /**
     * Instantiates a new Result.
     *
     * @param in the in
     */
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

    /**
     * The constant CREATOR.
     */
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
     * Gets adx keywords.
     *
     * @return the adx keywords
     */
    public String getAdxKeywords() {
        return adxKeywords;
    }

    /**
     * Sets adx keywords.
     *
     * @param adxKeywords the adx keywords
     */
    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    /**
     * Gets column.
     *
     * @return the column
     */
    public Object getColumn() {
        return column;
    }

    /**
     * Sets column.
     *
     * @param column the column
     */
    public void setColumn(Object column) {
        this.column = column;
    }

    /**
     * Gets section.
     *
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets section.
     *
     * @param section the section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets byline.
     *
     * @return the byline
     */
    public String getByline() {
        return byline;
    }

    /**
     * Sets byline.
     *
     * @param byline the byline
     */
    public void setByline(String byline) {
        this.byline = byline;
    }

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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets abstract.
     *
     * @return the abstract
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * Sets abstract.
     *
     * @param _abstract the abstract
     */
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    /**
     * Gets published date.
     *
     * @return the published date
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets published date.
     *
     * @param publishedDate the published date
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * Gets source.
     *
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets source.
     *
     * @param source the source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets asset id.
     *
     * @return the asset id
     */
    public long getAssetId() {
        return assetId;
    }

    /**
     * Sets asset id.
     *
     * @param assetId the asset id
     */
    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    /**
     * Gets views.
     *
     * @return the views
     */
    public int getViews() {
        return views;
    }

    /**
     * Sets views.
     *
     * @param views the views
     */
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

    /**
     * Gets media.
     *
     * @return the media
     */
    public List<Medium> getMedia() {
        return media;
    }

    /**
     * Sets media.
     *
     * @param media the media
     */
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

}