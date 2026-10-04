package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PageHolderLayout {
    private static final String TAG = Logger.createTag("PageHolder");
    View mBookmarkBtnImage;
    View mItemView;
    private final PageHolderVariable mPageHolderVariable;
    CheckableRelativeLayout mThumbnailContainer;
    View mThumbnailContainerCover;
    ImageView mThumbnailView;
    private boolean mIsFittingOnlyWidth = false;
    private boolean mIsFittingOnlyHeight = false;

    public PageHolderLayout(View view, ImageView imageView, CheckableRelativeLayout checkableRelativeLayout, View view2, PageHolderVariable pageHolderVariable) {
        this.mItemView = view;
        this.mThumbnailView = imageView;
        this.mThumbnailContainer = checkableRelativeLayout;
        this.mThumbnailContainerCover = (View) checkableRelativeLayout.getParent();
        this.mBookmarkBtnImage = view2;
        this.mPageHolderVariable = pageHolderVariable;
    }

    private int getLongPortraitPageWidth(int i, int i2) {
        float f = i2;
        if (f < i * 1.5f) {
            return i;
        }
        this.mIsFittingOnlyHeight = true;
        PageHolderVariable pageHolderVariable = this.mPageHolderVariable;
        float f4 = pageHolderVariable.mDefaultThumbnailHeight / f;
        int i4 = pageHolderVariable.mDefaultThumbnailWidth;
        int i5 = (int) (i4 * f4);
        int i6 = pageHolderVariable.mThumbnailWidth;
        if (i6 < i4) {
            i5 = (int) (i5 * (i6 / i4));
        }
        return i6 > i5 ? Math.max(i5, this.mThumbnailView.getResources().getDimensionPixelSize(C9086R.dimen.comp_page_list_item_thumbnail_container_min_width)) : i;
    }

    private void setWidthHeightLayoutParams(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i != 0) {
            layoutParams.width = i;
        }
        if (i2 != 0) {
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }

    private void updateLongPortraitPage(Bitmap bitmap, ViewGroup.LayoutParams layoutParams) {
        int longPortraitPageWidth = getLongPortraitPageWidth(bitmap.getWidth(), bitmap.getHeight());
        if (longPortraitPageWidth == bitmap.getWidth()) {
            return;
        }
        layoutParams.width = longPortraitPageWidth;
        this.mThumbnailContainer.getLayoutParams().width = layoutParams.width;
    }

    public boolean isFittingOnlyHeight() {
        return this.mIsFittingOnlyHeight;
    }

    public boolean isFittingOnlyWidth() {
        return this.mIsFittingOnlyWidth;
    }

    public void resize(float f) {
        this.mIsFittingOnlyHeight = false;
        this.mIsFittingOnlyWidth = f < 1.4142857f;
        ImageView imageView = this.mThumbnailView;
        PageHolderVariable pageHolderVariable = this.mPageHolderVariable;
        setWidthHeightLayoutParams(imageView, pageHolderVariable.mThumbnailWidth, pageHolderVariable.mThumbnailHeight);
        View view = this.mBookmarkBtnImage;
        PageHolderVariable pageHolderVariable2 = this.mPageHolderVariable;
        setWidthHeightLayoutParams(view, pageHolderVariable2.mBookmarkWidth, pageHolderVariable2.mBookmarkHeight);
        if (this.mIsFittingOnlyWidth) {
            setWidthHeightLayoutParams(this.mItemView, 0, -2);
            setWidthHeightLayoutParams(this.mThumbnailContainer, this.mPageHolderVariable.mThumbnailWidth, -2);
        } else {
            setWidthHeightLayoutParams(this.mItemView, 0, this.mPageHolderVariable.mContainerHeight);
            CheckableRelativeLayout checkableRelativeLayout = this.mThumbnailContainer;
            PageHolderVariable pageHolderVariable3 = this.mPageHolderVariable;
            setWidthHeightLayoutParams(checkableRelativeLayout, pageHolderVariable3.mThumbnailWidth, pageHolderVariable3.mThumbnailHeight);
        }
        setWidthHeightLayoutParams(this.mThumbnailContainerCover, this.mPageHolderVariable.mThumbnailWidth, -2);
    }

    public void setThumbnailLayout(Bitmap bitmap, int i, int i2, float f) {
        ViewGroup.LayoutParams layoutParams = this.mThumbnailView.getLayoutParams();
        if (bitmap == null) {
            layoutParams.width = this.mPageHolderVariable.mThumbnailWidth;
            if (this.mIsFittingOnlyWidth) {
                Logger.m10999d(TAG, "setThumbnailLayout# ratio " + f);
                layoutParams.height = (int) (((float) this.mPageHolderVariable.mThumbnailWidth) * f);
            } else {
                int longPortraitPageWidth = getLongPortraitPageWidth(i, i2);
                if (this.mIsFittingOnlyHeight) {
                    layoutParams.width = longPortraitPageWidth;
                    this.mThumbnailContainer.getLayoutParams().width = layoutParams.width;
                }
                layoutParams.height = this.mPageHolderVariable.mThumbnailHeight;
            }
            this.mThumbnailView.setImageDrawable(new ColorDrawable(this.mPageHolderVariable.mBackgroundColor));
        } else {
            if (this.mIsFittingOnlyWidth) {
                this.mThumbnailView.setAdjustViewBounds(true);
                layoutParams.height = -2;
            } else {
                updateLongPortraitPage(bitmap, layoutParams);
                this.mThumbnailView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            this.mThumbnailView.setImageBitmap(bitmap);
        }
        this.mThumbnailView.setLayoutParams(layoutParams);
    }
}
