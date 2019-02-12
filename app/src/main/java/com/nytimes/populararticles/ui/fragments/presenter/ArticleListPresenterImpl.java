package com.nytimes.populararticles.ui.fragments.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.fragments.mvp.FragmentViewPresenter;
import com.nytimes.populararticles.ui.retrofit.NYTimesApiService;
import com.nytimes.populararticles.ui.retrofit.RetrofitClient;
import com.nytimes.populararticles.ui.retrofit.responseModel.ArticleListResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ArticleListPresenterImpl implements FragmentViewPresenter.Presenter {
    private static final String TAG = "ArticleListPresenterImp";

    private FragmentViewPresenter.View<ArticleListResponse> mView;
    private Context context;
    private ProgressDialog mProgressDialog;

    /**
     * constructor of the class
     *
     * @param ctx  a reference of type {@link Context}
     * @param view a reference of type {@link FragmentViewPresenter.View}
     */
    public ArticleListPresenterImpl(Context ctx, FragmentViewPresenter.View<ArticleListResponse> view) {
        this.mView = view;
        this.context = ctx;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ctx.getString(R.string.loading));
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void fetchData() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<ArticleListResponse> getObservable() {
        return RetrofitClient.getRetrofit().create(NYTimesApiService.class)
                .getArticles(context.getString(R.string.api_key))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ArticleListResponse> getObserver() {
        mProgressDialog.show();
        return new DisposableObserver<ArticleListResponse>() {

            @Override
            public void onNext(@NonNull ArticleListResponse listResponse) {
                mProgressDialog.dismiss();
                Log.d(TAG, "OnNext : " + listResponse.getNumResults());
                mView.setData(listResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mProgressDialog.dismiss();
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
                mView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
