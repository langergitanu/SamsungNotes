package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageHolderVariable {
    int mBackgroundColor;
    int mBookmarkHeight;
    int mBookmarkWidth;
    int mContainerHeight;
    int mDefaultThumbnailHeight;
    int mDefaultThumbnailWidth;
    boolean mIsDisabledAddPage;
    boolean mIsEditable;
    boolean mIsEnabledBookmark;
    boolean mIsLandscapePage;
    boolean mIsMoreEnable;
    boolean mIsVoiceAssistantEnabled;
    int mThumbnailHeight;
    int mThumbnailWidth;
    private final ViewGroup mTopContainer;
    int mCurrentPageIndex = 0;
    int mMode = -1;
    boolean mIsRTL = LocaleUtils.isRTLMode();
    PageReorderController mPageReorderController = new PageReorderController();

    public PageHolderVariable(boolean z, boolean z2, boolean z3, boolean z4, ViewGroup viewGroup) {
        this.mIsEditable = z;
        this.mIsMoreEnable = z3;
        this.mIsEnabledBookmark = z2;
        this.mIsLandscapePage = z4;
        this.mTopContainer = viewGroup;
        this.mIsVoiceAssistantEnabled = VoiceAssistantTTS.isVoiceAssistantEnabled(viewGroup.getContext());
    }

    private void initHolderItemViewSize(Resources resources) {
        if (this.mMode == 2) {
            if (this.mIsLandscapePage) {
                this.mThumbnailWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_width_land);
                this.mThumbnailHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_height_land);
            } else {
                this.mThumbnailWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_search_item_width);
                this.mThumbnailHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_search_item_height);
            }
            this.mContainerHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_search_item_container_height);
            this.mBookmarkWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_bookmark_width);
            this.mBookmarkHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_bookmark_height);
            this.mDefaultThumbnailWidth = this.mThumbnailWidth;
            this.mDefaultThumbnailHeight = this.mThumbnailHeight;
            return;
        }
        if (this.mIsLandscapePage) {
            this.mThumbnailWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_width_land);
            this.mThumbnailHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_height_land);
        } else {
            this.mThumbnailWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_width);
            this.mThumbnailHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_height);
        }
        this.mContainerHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_container_height);
        this.mBookmarkWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_bookmark_width);
        this.mBookmarkHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_item_bookmark_height);
        this.mDefaultThumbnailWidth = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_search_item_width);
        this.mDefaultThumbnailHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_page_list_search_item_height);
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    public int getMode() {
        return this.mMode;
    }

    public PageReorderController getPageReorderController() {
        return this.mPageReorderController;
    }

    public ViewGroup getTopContainer() {
        return this.mTopContainer;
    }

    public boolean isRTL() {
        return this.mIsRTL;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setCurrentPageIndex(int i) {
        this.mCurrentPageIndex = i;
    }

    public void setDisableAddPage(boolean z) {
        this.mIsDisabledAddPage = z;
    }

    public void setMode(int i, Resources resources) {
        if (this.mMode != i) {
            this.mMode = i;
            initHolderItemViewSize(resources);
        }
    }
}
