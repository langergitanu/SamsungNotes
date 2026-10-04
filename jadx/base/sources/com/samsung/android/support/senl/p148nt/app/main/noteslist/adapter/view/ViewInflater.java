package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.ThumbnailBitmapUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ImageScaleView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ThumbnailType;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ViewInflater {
    private FrameLayout mBlurView;
    private View mCoverContainerView;
    private View mCoverView;
    private ImageView mFullScreenContents;
    private final View mItemView;
    private LockView mLockView;
    private ConstraintLayout mThumbnailContainer;
    private ViewContainer mViewContainer;
    private final int mViewMode;
    private int mType = -1;
    private int mCoverType = -1;
    private int mPrevCoverType = -1;

    public ViewInflater(View view, int i) {
        this.mItemView = view;
        this.mViewMode = i;
    }

    private FrameLayout findBlurView() {
        if (this.mBlurView == null) {
            this.mBlurView = (FrameLayout) this.mItemView.findViewById(C8003R.id.blur_view);
        }
        return this.mBlurView;
    }

    private ImageView findFullScreenContents() {
        if (this.mFullScreenContents == null) {
            this.mFullScreenContents = (ImageView) this.mItemView.findViewById(C8003R.id.full_screen_contents);
        }
        return this.mFullScreenContents;
    }

    private ConstraintLayout findThumbnailContainer() {
        if (this.mThumbnailContainer == null) {
            this.mThumbnailContainer = (ConstraintLayout) this.mItemView.findViewById(C8003R.id.thumbnail_container);
        }
        return this.mThumbnailContainer;
    }

    private void hideBlurView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return;
        }
        viewContainer.hideBlurView();
    }

    private void setListConstraintLayout(ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(C8003R.id.notes_list_item_content, 7, C8003R.id.inflate_contents, 6);
        constraintSet.applyTo(constraintLayout);
    }

    private void setNormalListConstraintLayout(ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(C8003R.id.notes_list_item_content, 7, C8003R.id.thumbnail_container, 7);
        constraintSet.applyTo(constraintLayout);
    }

    public View getBlurView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return null;
        }
        return viewContainer.getBlurView();
    }

    public int getCoverType() {
        return this.mCoverType;
    }

    public View getCoverView() {
        return this.mCoverView;
    }

    public ImageView getImageContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return null;
        }
        return viewContainer.getImageContentView();
    }

    public ImageView getLockImageContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return null;
        }
        return viewContainer.getLockImageContentView();
    }

    public FrameLayout getLockImageContentViewContainer() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return null;
        }
        return viewContainer.getLockImageContentViewContainer();
    }

    public LockView getLockThumbnail() {
        return this.mLockView;
    }

    public HoverPopupTextView getTextContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return null;
        }
        return viewContainer.getTextContentView();
    }

    public View getThumbnailContainer() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return null;
        }
        return viewContainer.getThumbnailContainer();
    }

    public int getType() {
        return this.mType;
    }

    public int getViewMode() {
        return this.mViewMode;
    }

    public boolean hasCoverView() {
        return this.mCoverView != null;
    }

    public boolean hasImageContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return false;
        }
        return viewContainer.hasImageContentView();
    }

    public Boolean hasLockImageContentViewContainer() {
        ViewContainer viewContainer = this.mViewContainer;
        return viewContainer == null ? Boolean.FALSE : Boolean.valueOf(viewContainer.hasLockImageContentViewContainer());
    }

    public boolean hasLockThumbnail() {
        return this.mLockView != null;
    }

    public boolean hasTextContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return false;
        }
        return viewContainer.hasTextContentView();
    }

    public void hideAllView() {
        hideImageView();
        hideTextContentView();
        hideBlurView();
    }

    public void hideCoverView() {
        View view = this.mCoverContainerView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mCoverView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void hideImageView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return;
        }
        viewContainer.hideImageView();
    }

    public void hideLockThumbnail() {
        LockView lockView = this.mLockView;
        if (lockView != null) {
            lockView.setVisibility(8);
        }
        if (hasLockImageContentViewContainer().booleanValue()) {
            getLockImageContentViewContainer().setVisibility(8);
        }
    }

    public void hideTextContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return;
        }
        viewContainer.hideTextContentView();
    }

    public void inflateCoverView() {
        int i = this.mCoverType;
        if (i == 19) {
            this.mCoverContainerView = ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.cover_container, C8003R.id.inflate_notes_list_cover_container);
            this.mCoverView = this.mItemView.findViewById(C8003R.id.cover);
        } else if (i == 8) {
            this.mCoverView = ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.cover_thumbnail, C8003R.id.inflate_cover_container);
        } else {
            this.mCoverView = ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.simple_view_cover, C8003R.id.inflate_simple_view_cover_thumbnail);
        }
    }

    public void inflateLockThumbnail(boolean z) {
        if (this.mLockView == null) {
            this.mLockView = new LockView(this.mItemView, this.mViewMode);
        }
        this.mLockView.inflateLockView(z);
    }

    public void inflateSimpleLockThumbnail() {
        FrameLayout lockImageContentViewContainer = getLockImageContentViewContainer();
        if (lockImageContentViewContainer != null) {
            lockImageContentViewContainer.setVisibility(0);
        }
        ImageView lockImageContentView = getLockImageContentView();
        if (lockImageContentView != null) {
            lockImageContentView.setVisibility(0);
            lockImageContentView.setPadding(0, 0, 0, 0);
            lockImageContentView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
    }

    public void inflateTextContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return;
        }
        viewContainer.inflateTextContentView();
    }

    public void inflateThumbnail() {
        if (this.mViewContainer == null) {
            int i = this.mType;
            switch (i) {
                case 1:
                    this.mViewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.text_only_thumbnail, C8003R.id.inflate_text_only_thumbnail_layout));
                    break;
                case 2:
                    this.mViewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.text_image_thumbnail_old, C8003R.id.inflate_text_image_thumbnail_layout_old));
                    break;
                case 3:
                    ViewContainer viewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.text_image_thumbnail, C8003R.id.inflate_text_image_thumbnail_layout));
                    this.mViewContainer = viewContainer;
                    viewContainer.setBlurView(findBlurView());
                    break;
                case 4:
                case 6:
                case 12:
                case 14:
                    this.mViewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.image_only_thumbnail, C8003R.id.inflate_image_only_thumbnail_layout));
                    break;
                case 5:
                case 13:
                    this.mViewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.image_only_thumbnail_landscape, C8003R.id.inflate_image_only_thumbnail_landscape_layout));
                    break;
                case 7:
                case 8:
                default:
                    if (i == -1 && !ContentUtils.isSimpleViewMode(this.mViewMode)) {
                        View view = this.mItemView;
                        this.mViewContainer = new ViewContainer(view, (ImageScaleView) ViewModeUtils.getInflatedView(view, C8003R.id.full_screen_contents, C8003R.id.inflate_notes_list_item_full_screen_contents));
                    } else {
                        this.mViewContainer = new ViewContainer(this.mItemView, findFullScreenContents());
                    }
                    break;
                case 9:
                    this.mViewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.text_only_small_thumbnail, C8003R.id.inflate_text_only_thumbnail_layout));
                    break;
                case 10:
                    this.mViewContainer = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.text_image_small_thumbnail_old, C8003R.id.inflate_text_image_small_thumbnail_layout_old));
                    break;
                case 11:
                    ViewContainer viewContainer2 = new ViewContainer(ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.text_image_small_thumbnail, C8003R.id.inflate_text_image_small_thumbnail_layout));
                    this.mViewContainer = viewContainer2;
                    viewContainer2.setBlurView(findBlurView());
                    break;
                case 15:
                case 16:
                    View view2 = this.mItemView;
                    this.mViewContainer = new ViewContainer(view2, (ImageScaleView) ViewModeUtils.getInflatedView(view2, C8003R.id.full_screen_contents, C8003R.id.inflate_notes_list_item_full_screen_contents));
                    setNormalListConstraintLayout(findThumbnailContainer());
                    break;
                case 17:
                    ImageScaleView imageScaleView = (ImageScaleView) ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.contents_container, C8003R.id.inflate_contents);
                    setListConstraintLayout(findThumbnailContainer());
                    this.mViewContainer = new ViewContainer(this.mItemView, imageScaleView);
                    break;
            }
        }
        this.mViewContainer.setVisibility(0);
    }

    public boolean isVisibleImageContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return false;
        }
        return viewContainer.isVisibleImageContentView();
    }

    public boolean isVisibleTextContentView() {
        ViewContainer viewContainer = this.mViewContainer;
        if (viewContainer == null) {
            return false;
        }
        return viewContainer.isVisibleTextContentView();
    }

    public void setCoverType(int i) {
        this.mPrevCoverType = this.mCoverType;
        if (ThumbnailType.isLock(i)) {
            this.mCoverType = i;
        } else if (ThumbnailType.isCover(i)) {
            this.mCoverType = i;
        } else {
            this.mCoverType = -1;
        }
    }

    public void setType(int i) {
        if (this.mType == i) {
            return;
        }
        if (ContentUtils.isGridViewMode(this.mViewMode)) {
            ViewContainer viewContainer = this.mViewContainer;
            if (viewContainer != null) {
                viewContainer.setVisibility(8);
                this.mViewContainer = null;
            }
        } else {
            if (this.mPrevCoverType != 18) {
                hideAllView();
            }
            this.mViewContainer = null;
        }
        this.mType = i;
    }

    public void showCoverView() {
        View view = this.mCoverContainerView;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mCoverView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ViewContainer {
        private FrameLayout mBlurView;
        private final ImageView mImageContentView;
        private ImageView mLockImageContentView;
        private FrameLayout mLockImageContentViewContainer;
        private HoverPopupTextView mTextContentView;
        private final View mThumbnailContainer;

        public ViewContainer(View view) {
            this.mTextContentView = null;
            this.mThumbnailContainer = view;
            view.setVisibility(0);
            HoverPopupTextView hoverPopupTextView = (HoverPopupTextView) view.findViewById(C8003R.id.text_content);
            this.mTextContentView = hoverPopupTextView;
            if (hoverPopupTextView != null) {
                hoverPopupTextView.setVisibility(0);
                HoverPopupTextView hoverPopupTextView2 = this.mTextContentView;
            }
            ImageView imageView = (ImageView) view.findViewById(C8003R.id.full_screen_contents);
            this.mImageContentView = imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }

        public FrameLayout getBlurView() {
            return this.mBlurView;
        }

        public ImageView getImageContentView() {
            return this.mImageContentView;
        }

        public ImageView getLockImageContentView() {
            if (this.mLockImageContentViewContainer == null) {
                this.mLockImageContentViewContainer = (FrameLayout) ViewModeUtils.getInflatedView(this.mThumbnailContainer, C8003R.id.simple_view_lock_thumbnail, C8003R.id.inflate_simple_view_lock_thumbnail);
            }
            if (this.mLockImageContentView == null) {
                this.mLockImageContentView = (ImageView) this.mLockImageContentViewContainer.findViewById(C8003R.id.lock_icon);
            }
            return this.mLockImageContentView;
        }

        public FrameLayout getLockImageContentViewContainer() {
            if (this.mLockImageContentViewContainer == null) {
                this.mLockImageContentViewContainer = (FrameLayout) ViewModeUtils.getInflatedView(this.mThumbnailContainer, C8003R.id.simple_view_lock_thumbnail, C8003R.id.inflate_simple_view_lock_thumbnail);
            }
            return this.mLockImageContentViewContainer;
        }

        public HoverPopupTextView getTextContentView() {
            return this.mTextContentView;
        }

        public View getThumbnailContainer() {
            return this.mThumbnailContainer;
        }

        public boolean hasImageContentView() {
            return this.mImageContentView != null;
        }

        public boolean hasLockImageContentViewContainer() {
            return this.mLockImageContentViewContainer != null;
        }

        public boolean hasTextContentView() {
            return this.mTextContentView != null;
        }

        public void hideBlurView() {
            FrameLayout frameLayout = this.mBlurView;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }

        public void hideImageView() {
            ImageView imageView = this.mImageContentView;
            if (imageView != null) {
                imageView.setOnHoverListener(null);
                ThumbnailBitmapUtil.recycleBitmap(this.mImageContentView);
                this.mImageContentView.setImageBitmap(null);
                this.mImageContentView.setVisibility(8);
                if (ViewInflater.this.mType == 20) {
                    ((ImageScaleView) this.mImageContentView).initGravity();
                }
            }
        }

        public void hideTextContentView() {
            HoverPopupTextView hoverPopupTextView = this.mTextContentView;
            if (hoverPopupTextView == null) {
                return;
            }
            hoverPopupTextView.setVisibility(8);
            this.mTextContentView.setOriginalText(null);
            if (ThumbnailType.isGridTextImageOnly(ViewInflater.this.mType) || ThumbnailType.isGridTextOnly(ViewInflater.this.mType)) {
                this.mTextContentView.setMaxLines(this.mThumbnailContainer.getResources().getInteger(C8003R.integer.noteslist_grid_text_max_lines));
                this.mTextContentView.setEllipsize(null);
            }
        }

        public void inflateTextContentView() {
            if (this.mTextContentView == null) {
                this.mTextContentView = (HoverPopupTextView) ViewModeUtils.getInflatedView(this.mThumbnailContainer, C8003R.id.text_content, C8003R.id.inflate_text_content);
            }
            HoverPopupTextView hoverPopupTextView = this.mTextContentView;
            if (hoverPopupTextView != null) {
                hoverPopupTextView.setVisibility(0);
                this.mTextContentView.setScaleY(1.0f);
                this.mTextContentView.setScaleX(1.0f);
            }
        }

        public boolean isVisibleImageContentView() {
            ImageView imageView = this.mImageContentView;
            return imageView != null && imageView.getVisibility() == 0;
        }

        public boolean isVisibleTextContentView() {
            HoverPopupTextView hoverPopupTextView = this.mTextContentView;
            return hoverPopupTextView != null && hoverPopupTextView.getVisibility() == 0;
        }

        public void setBlurView(FrameLayout frameLayout) {
            this.mBlurView = frameLayout;
            frameLayout.setVisibility(8);
        }

        public void setVisibility(int i) {
            this.mThumbnailContainer.setVisibility(i);
        }

        public ViewContainer(View view, ImageView imageView) {
            this.mTextContentView = null;
            this.mThumbnailContainer = view;
            if (view != null) {
                view.setVisibility(0);
            }
            this.mImageContentView = imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
    }
}
