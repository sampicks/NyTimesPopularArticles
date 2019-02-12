package com.nytimes.populararticles.retrofit;

import com.nytimes.populararticles.retrofit.responseModel.ArticleListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NYTimesApiService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json")
    Observable<ArticleListResponse> getArticles(@Query("api-key") String api_key);
}
