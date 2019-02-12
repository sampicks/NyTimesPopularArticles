package com.nytimes.populararticles.ui.fragments.mvp;

/**
 * @author peeyooshkhare
 * An interface resposible for mvp architecture
 * @version 1.0
 */
public interface FragmentViewPresenter {
    /**
     * An inner interface resposible for views
     */
    interface View<T> {
        void setData(T t);

        void displayError(String error);
    }

    /**
     * An inner interface resposible for presenters
     */
    interface Presenter {
        void fetchData();

    }
}
