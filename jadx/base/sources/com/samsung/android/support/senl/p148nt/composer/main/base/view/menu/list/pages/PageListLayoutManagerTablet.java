package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListLayoutManagerTablet extends PageListLayoutManager {
    private final TextView mEditBtn;
    private Boolean mIsFold;
    private PageAdapter mPageAdapter;
    private final ViewGroup mViewContainer;

    public PageListLayoutManagerTablet(Activity activity, RecyclerView recyclerView, ViewGroup viewGroup, boolean z) {
        super(activity, recyclerView, z);
        this.mIsFold = null;
        this.mViewContainer = viewGroup;
        this.mEditBtn = (TextView) viewGroup.findViewById(C9086R.id.comp_page_list_edit_btn);
    }

    private Boolean isFold() {
        if (this.mIsFold == null) {
            this.mIsFold = Boolean.valueOf(DeviceUtils.isFoldableModel());
        }
        return this.mIsFold;
    }

    private boolean isForceOneSpan() {
        return this.mIsLandscapePage && isFold().booleanValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public /* bridge */ /* synthetic */ GridLayoutManager getGridLayoutManager() {
        return super.getGridLayoutManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public int getSpanCount(int i) {
        return (i == 1 || isForceOneSpan()) ? 1 : 2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public int getWidth() {
        return this.mViewContainer.getLayoutParams().width;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListLayoutManager
    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = this.mLastConfig;
        if (configuration2 == null) {
            return;
        }
        if ((configuration2.diff(configuration) & 128) != 0) {
            updateContainerWidth(configuration.orientation);
            PageAdapter pageAdapter = this.mPageAdapter;
            if (pageAdapter != null) {
                pageAdapter.onOrientationChanged();
            }
            setSpanCount(getSpanCount(configuration.orientation));
        }
        super.onConfigurationChanged(configuration);
    }

    public void setAdapter(PageAdapter pageAdapter) {
        this.mPageAdapter = pageAdapter;
    }

    public void updateContainerWidth() {
        updateContainerWidth(this.mLastConfig.orientation);
    }

    private void updateContainerWidth(int i) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Resources resources = this.mActivity.getResources();
        if (i == 1 || isForceOneSpan()) {
            dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_container_width);
            dimensionPixelSize2 = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_menu_edit_button_max_width);
        } else {
            dimensionPixelSize = this.mIsLandscapePage ? resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_container_width_page_land) : resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_container_width_land);
            dimensionPixelSize2 = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_menu_edit_button_max_width_land);
        }
        this.mEditBtn.setMaxWidth(dimensionPixelSize2);
        ViewGroup.LayoutParams layoutParams = this.mViewContainer.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        this.mViewContainer.setLayoutParams(layoutParams);
    }
}
