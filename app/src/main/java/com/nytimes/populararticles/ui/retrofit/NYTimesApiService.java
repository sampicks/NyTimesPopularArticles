package com.nytimes.populararticles.ui.retrofit;

import com.nytimes.populararticles.ui.retrofit.responseModel.ArticleListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NYTimesApiService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json")
    Observable<ArticleListResponse> getArticles(@Query("api-key") String api_key);
}
