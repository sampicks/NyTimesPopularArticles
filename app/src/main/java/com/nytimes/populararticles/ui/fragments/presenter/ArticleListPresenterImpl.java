package com.nytimes.populararticles.ui.fragments.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.fragments.mvp.FragmentViewPresenter;
import com.nytimes.populararticles.retrofit.NYTimesApiService;
import com.nytimes.populararticles.retrofit.RetrofitClient;
import com.nytimes.populararticles.retrofit.responsemodel.ArticleListResponse;
import com.nytimes.populararticles.utils.NetworkUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author peeyooshkhare
 * A simple implementation class of {@link FragmentViewPresenter.Presenter} for {@link ArticleListResponse}
 * @version 1.0
 */
public class ArticleListPresenterImpl implements FragmentViewPresenter.Presenter {
    private static final String TAG = "ArticleListPresenterImp";

    private FragmentViewPresenter.View<ArticleListResponse> mView;
    private Context context;
    private ProgressDialog mProgressDialog;
    private DisposableObserver<ArticleListResponse> mResponseDisposableObserver;

    /**
     * constructor of the class
     *
     * @param ctx  a reference of type {@link Context}
     * @param view a reference of type {@link FragmentViewPresenter.View}
     */
    public ArticleListPresenterImpl(@NonNull Context ctx, FragmentViewPresenter.View<ArticleListResponse> view) {
        this.mView = view;
        this.context = ctx;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ctx.getString(R.string.loading));
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    /**
     * An interface method implementation
     */
    @Override
    public void fetchData() {

        if (NetworkUtils.isInternetAvailable(context))
            mResponseDisposableObserver = getObservable().subscribeWith(getObserver());
        else mView.displayError(context.getString(R.string.internet_not_available));
    }

    private Observable<ArticleListResponse> getObservable() {
        return RetrofitClient.getRetrofitClient().create(NYTimesApiService.class)
                .getArticles(context.getString(R.string.api_key))
                .subscribeOn(Schedulers.io())// perform network operation on separate thread
                .observeOn(AndroidSchedulers.mainThread());// perform ui operation on main thread
    }

    private DisposableObserver<ArticleListResponse> getObserver() {
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
                Log.e(TAG, e.getMessage());
                mView.displayError(context.getString(R.string.error_fetch_articles));
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");

            }
        };
    }

    /**
     * method to dispose observer
     */
    public void disposeReferences() {
        if(mResponseDisposableObserver!=null && !mResponseDisposableObserver.isDisposed())
        mResponseDisposableObserver.dispose();
        Log.d(TAG, "disposeReferences");
    }
}
