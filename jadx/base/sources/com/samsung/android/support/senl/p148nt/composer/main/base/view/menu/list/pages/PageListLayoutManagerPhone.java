package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListLayoutManagerPhone extends PageListLayoutManager {
    private static final String TAG = Logger.createTag("PageListLayoutManagerPhone");
    private int mMode;

    public PageListLayoutManagerPhone(Activity activity, RecyclerView recyclerView, boolean z) {
        super(activity, recyclerView, z);
        this.mMode = 0;
    }

    private int getAdjustSpanCountWithMinGap(int i, int i2, int i4, int i5) {
        return i - (((i4 - 1) * i5) + (i2 * i4)) > 0 ? 0 : 1;
    }

    private int getSpanCountInSearchMode(int i) {
        Point point = new Point();
        this.mActivity.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        Resources resources = this.mActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_search_item_width);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C9086R.dimen.comp_page_list_side_padding);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(C9086R.dimen.comp_page_list_item_min_gap_margin);
        int i2 = point.x - (dimensionPixelOffset * 2);
        int i4 = i2 / dimensionPixelSize;
        int adjustSpanCountWithMinGap = i4 - getAdjustSpanCountWithMinGap(i2, dimensionPixelSize, i4, dimensionPixelOffset2);
        return i == 1 ? Math.min(adjustSpanCountWithMinGap, 2) : Math.min(adjustSpanCountWithMinGap, 4);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public /* bridge */ /* synthetic */ GridLayoutManager getGridLayoutManager() {
        return super.getGridLayoutManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public int getSpanCount(int i) {
        int i2;
        int i4;
        if (this.mMode == 2) {
            return getSpanCountInSearchMode(i);
        }
        Resources resources = this.mActivity.getResources();
        if (this.mIsLandscapePage) {
            i2 = C9086R.dimen.comp_page_list_item_width_land;
            i4 = i == 1 ? 2 : 4;
        } else {
            i2 = C9086R.dimen.comp_page_list_item_width;
            i4 = i == 1 ? 3 : 6;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i2);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C9086R.dimen.comp_page_list_side_padding);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(C9086R.dimen.comp_page_list_item_min_gap_margin);
        Point point = new Point();
        this.mActivity.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        int i5 = point.x - (dimensionPixelOffset * 2);
        int i6 = i5 / dimensionPixelSize;
        int iMin = Math.min(Math.max(i6 - getAdjustSpanCountWithMinGap(i5, dimensionPixelSize, i6, dimensionPixelOffset2), 1), i4);
        AbstractC0000a.m3D(iMin, "getSpanCountOnPhone# ", TAG);
        return iMin;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public int getWidth() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = this.mLastConfig;
        if (configuration2 == null) {
            return;
        }
        int iDiff = configuration2.diff(configuration);
        if ((iDiff & 128) != 0 || (iDiff & 1024) != 0) {
            setSpanCount(this.mMode == 2 ? getSpanCountInSearchMode(configuration.orientation) : getSpanCount(configuration.orientation));
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public void updateMode(int i) {
        this.mMode = i;
        setSpanCount(getSpanCount(this.mLastConfig.orientation));
    }
}
