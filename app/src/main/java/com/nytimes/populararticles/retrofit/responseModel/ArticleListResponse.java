package com.nytimes.populararticles.retrofit.responseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The type Article list response.
 */
public class ArticleListResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private int numResults;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
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
     * Gets num results.
     *
     * @return the num results
     */
    public int getNumResults() {
        return numResults;
    }

    /**
     * Sets num results.
     *
     * @param numResults the num results
     */
    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }
}
