package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.recyclerview.widget.CustomGridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class PageListLayoutManager {
    Activity mActivity;
    GridLayoutManager mGridLayoutManager;
    protected final boolean mIsLandscapePage;
    Configuration mLastConfig;
    RecyclerView mRecyclerView;

    public PageListLayoutManager(Activity activity, RecyclerView recyclerView, boolean z) {
        this.mActivity = activity;
        this.mRecyclerView = recyclerView;
        this.mIsLandscapePage = z;
        this.mLastConfig = new Configuration(activity.getResources().getConfiguration());
        CustomGridLayoutManager customGridLayoutManager = new CustomGridLayoutManager(activity, getSpanCount());
        this.mGridLayoutManager = customGridLayoutManager;
        this.mRecyclerView.setLayoutManager(customGridLayoutManager);
    }

    public GridLayoutManager getGridLayoutManager() {
        return this.mGridLayoutManager;
    }

    public int getOrientation() {
        return this.mLastConfig.orientation;
    }

    public int getSpanCount() {
        return getSpanCount(this.mLastConfig.orientation);
    }

    public abstract int getSpanCount(int i);

    public abstract int getWidth();

    public boolean isVisibleItemPosition(int i) {
        return this.mGridLayoutManager.findLastCompletelyVisibleItemPosition() >= i && this.mGridLayoutManager.findFirstCompletelyVisibleItemPosition() <= i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mLastConfig = new Configuration(configuration);
    }

    public void setSpanCount(int i) {
        if (i > 0) {
            this.mGridLayoutManager.setSpanCount(i);
        }
        if (this.mRecyclerView.getAdapter() != null) {
            this.mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void updateMode(int i) {
    }
}
