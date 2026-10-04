package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.listener.CoverHoverListener;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ThumbnailType;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ComposedView {
    private final ExtraView mExtraView;
    private final View mRoundedView;
    private Runnable mTextContentMaxLineRunnable;
    private Runnable mTitlePaddingRunnable;
    private final TitleView mTitleView;
    private final ViewInflater mViewInflater;

    public ComposedView(View view, int i, ThumbnailContract thumbnailContract) {
        if (2 == i || 1 == i) {
            this.mRoundedView = view.findViewById(C8003R.id.thumbnail_container);
            this.mExtraView = new ExtraView(view, view.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_item_favorite_icon_size_large));
        } else if (4 == i) {
            this.mRoundedView = view.findViewById(C8003R.id.thumbnail_container);
            this.mExtraView = new ExtraView(view, view.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_item_favorite_icon_size_small));
        } else {
            this.mRoundedView = null;
            this.mExtraView = new ExtraView(view.findViewById(C8003R.id.extra));
        }
        this.mViewInflater = new ViewInflater(view, i);
        TitleView titleView = (TitleView) view.findViewById(C8003R.id.title);
        this.mTitleView = titleView;
        titleView.setNoteTitleContract(thumbnailContract);
    }

    private void hideExtraView() {
        ExtraView extraView = this.mExtraView;
        if (extraView != null) {
            extraView.init();
        }
    }

    private void hideTitleView() {
        TitleView titleView = this.mTitleView;
        if (titleView != null) {
            titleView.init();
        }
    }

    private void initRoundedView() {
        View view = this.mRoundedView;
        if (view != null) {
            view.setClipToOutline(true);
            this.mRoundedView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showContentsWithUnlockAnimation() {
        HolderAnimation.beginDelayedTransition((ViewGroup) this.mRoundedView.getParent());
        if (this.mViewInflater.isVisibleImageContentView()) {
            ImageView imageContentView = this.mViewInflater.getImageContentView();
            imageContentView.setAlpha(1.0f);
            imageContentView.setScaleX(1.0f);
            imageContentView.setScaleY(1.0f);
            imageContentView.invalidate();
        }
        if (this.mViewInflater.hasTextContentView()) {
            HoverPopupTextView textContentView = this.mViewInflater.getTextContentView();
            textContentView.setAlpha(1.0f);
            textContentView.setScaleX(1.0f);
            textContentView.setScaleY(1.0f);
            textContentView.invalidate();
        }
    }

    public void decorateCoverEnabled(String str, CoverThumbnailCreator.ThumbnailType thumbnailType) {
        if (!hasCoverView()) {
            inflateCoverView();
        }
        View coverView = getCoverView();
        coverView.setOnHoverListener(new CoverHoverListener(CoverThumbnailCreator.getCoverPath(coverView.getContext(), str, CoverThumbnailCreator.ThumbnailType.RECT)));
        coverView.setBackground(CoverThumbnailCreator.getCoverThumbnail(coverView.getContext(), str, thumbnailType));
        this.mViewInflater.showCoverView();
    }

    public void decorateCoverEnabledSimple(String str, CoverThumbnailCreator.ThumbnailType thumbnailType) {
        if (!hasCoverView()) {
            inflateCoverView();
        }
        View coverView = getCoverView();
        coverView.setOnHoverListener(new CoverHoverListener(CoverThumbnailCreator.getCoverPath(coverView.getContext(), str, CoverThumbnailCreator.ThumbnailType.RECT)));
        coverView.setBackground(new LayerDrawable(new Drawable[]{ResourcesCompat.getDrawable(coverView.getResources(), C8003R.drawable.notes_simple_item_content_bg_shape, null), CoverThumbnailCreator.getCoverThumbnail(coverView.getContext(), str, thumbnailType)}));
        coverView.setForeground(ResourcesCompat.getDrawable(coverView.getResources(), C8003R.drawable.notes_simple_item_content_fg, null));
        this.mViewInflater.showCoverView();
    }

    public void decorateExtra(MainListDocumentData mainListDocumentData, String str) {
        this.mExtraView.setExtraData(mainListDocumentData, str);
    }

    public void decorateExtraBackground(boolean z, boolean z2, @ColorInt int i, @ColorInt int i2) {
        if (isRoundedViewUsed()) {
            this.mExtraView.decorateExtraBackground(z, z2, i, i2);
        }
    }

    public void decorateFavoriteAnimation(boolean z, boolean z2) {
        HolderAnimation.decorateFavoriteAnimation(this.mExtraView.getFavoriteView(), z, z2);
    }

    public void decorateLockAnimation(boolean z, boolean z2, boolean z3) {
        if (this.mRoundedView != null) {
            if (z2 && !z) {
                this.mViewInflater.inflateLockThumbnail(false);
            }
            View view = this.mRoundedView;
            int viewMode = this.mViewInflater.getViewMode();
            LockView lockThumbnail = this.mViewInflater.getLockThumbnail();
            HoverPopupTextView textContentView = null;
            ImageView imageContentView = (this.mViewInflater.getViewMode() == 1 && this.mViewInflater.isVisibleImageContentView()) ? this.mViewInflater.getImageContentView() : null;
            if (this.mViewInflater.getViewMode() == 1 && this.mViewInflater.isVisibleTextContentView()) {
                textContentView = this.mViewInflater.getTextContentView();
            }
            HolderAnimation.decorateLockAnimation(view, viewMode, lockThumbnail, imageContentView, textContentView, z, z2, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.view.ComposedView.1
                @Override // java.lang.Runnable
                public void run() {
                    ComposedView.this.mViewInflater.hideLockThumbnail();
                    ComposedView.this.showContentsWithUnlockAnimation();
                }
            }, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.view.ComposedView.2
                @Override // java.lang.Runnable
                public void run() {
                    ComposedView.this.mViewInflater.inflateLockThumbnail(false);
                }
            }, z3, this.mViewInflater.getViewMode() == 1);
        }
    }

    public void decorateLockThumbnailAnimation(boolean z, boolean z2) {
        if (this.mViewInflater.hasLockImageContentViewContainer().booleanValue()) {
            HolderAnimation.decorateLockThumbnailAnimation(this.mViewInflater.getLockImageContentViewContainer(), this.mViewInflater.getLockImageContentView(), z, z2);
        }
    }

    @SuppressLint({"Recycle"})
    public void decorateRoundFavoriteShape(boolean z, boolean z2) {
        HolderAnimation.decorateRoundFavoriteShape(this.mRoundedView, this.mExtraView.getFavoriteView(), z, z2, this.mViewInflater.getViewMode());
    }

    public View decorateSearchExtra(String str, String str2, int i) {
        return this.mExtraView.decorateSearchExtra(str, str2, i);
    }

    public void decorateVoiceAnimation(boolean z, boolean z2, boolean z3) {
        View view = this.mRoundedView;
        if (view != null) {
            HolderAnimation.decorateVoiceAnimation(view, this.mViewInflater.getViewMode(), this.mExtraView.getVoiceView(), this.mExtraView.getVoiceIconView(), this.mExtraView.getVoiceText(), z, z2, z3, this.mViewInflater.getViewMode() == 1);
        }
    }

    public View getBlurView() {
        return this.mViewInflater.getBlurView();
    }

    public int getCoverType() {
        return this.mViewInflater.getCoverType();
    }

    public View getCoverView() {
        return this.mViewInflater.getCoverView();
    }

    public ImageView getImageContentView() {
        return this.mViewInflater.getImageContentView();
    }

    public View getLockBackground() {
        if (this.mViewInflater.getLockThumbnail() == null) {
            return null;
        }
        return this.mViewInflater.getLockThumbnail().getLockBackground();
    }

    public View getLockIcon() {
        return this.mViewInflater.getLockThumbnail().getLockIcon();
    }

    public HoverPopupTextView getTextContentView() {
        return this.mViewInflater.getTextContentView();
    }

    public String getTitle() {
        return this.mTitleView.getText().toString();
    }

    public int getType() {
        return this.mViewInflater.getType();
    }

    public boolean hasCoverView() {
        return this.mViewInflater.hasCoverView();
    }

    public boolean hasImageContentView() {
        return this.mViewInflater.hasImageContentView();
    }

    public boolean hasNotTextContentView() {
        return !this.mViewInflater.hasTextContentView();
    }

    public void hideAllView() {
        this.mViewInflater.hideAllView();
    }

    public void hideContentsWithUnlockAnimation() {
        HolderAnimation.beginDelayedTransition((ViewGroup) this.mRoundedView.getParent());
        if (this.mViewInflater.isVisibleImageContentView()) {
            ImageView imageContentView = this.mViewInflater.getImageContentView();
            imageContentView.setAlpha(0.0f);
            imageContentView.setScaleX(1.0f);
            imageContentView.setScaleY(1.0f);
            imageContentView.invalidate();
        }
        if (this.mViewInflater.hasTextContentView()) {
            HoverPopupTextView textContentView = this.mViewInflater.getTextContentView();
            textContentView.setAlpha(0.0f);
            textContentView.setScaleX(1.0f);
            textContentView.setScaleY(1.0f);
            textContentView.invalidate();
        }
    }

    public void hideCoverView() {
        if (hasCoverView()) {
            this.mViewInflater.hideCoverView();
        }
    }

    public void hideImageView() {
        this.mViewInflater.hideImageView();
    }

    public void inflateCoverView() {
        this.mViewInflater.inflateCoverView();
    }

    public void inflateTextContentView() {
        this.mViewInflater.inflateTextContentView();
    }

    public void inflateThumbnail(String str, boolean z, CoverThumbnailCreator.ThumbnailType thumbnailType) {
        if (!ThumbnailType.isCover(this.mViewInflater.getCoverType())) {
            this.mViewInflater.hideCoverView();
        }
        if (!ThumbnailType.isLock(this.mViewInflater.getCoverType())) {
            this.mViewInflater.hideLockThumbnail();
        }
        this.mViewInflater.inflateThumbnail();
        int coverType = this.mViewInflater.getCoverType();
        if (coverType != 7) {
            if (coverType != 8) {
                if (coverType != 18) {
                    if (coverType != 19) {
                        if (coverType != 21) {
                            if (coverType != 22) {
                                return;
                            }
                            decorateCoverEnabledSimple(str, thumbnailType);
                            return;
                        } else if (this.mViewInflater.getViewMode() == 6) {
                            this.mViewInflater.inflateLockThumbnail(z);
                            return;
                        } else {
                            this.mViewInflater.inflateSimpleLockThumbnail();
                            return;
                        }
                    }
                }
            }
            decorateCoverEnabled(str, thumbnailType);
            return;
        }
        this.mViewInflater.inflateLockThumbnail(z);
    }

    public void init() {
        hideTitleView();
        hideExtraView();
        hideCoverView();
        this.mViewInflater.hideLockThumbnail();
        this.mViewInflater.hideTextContentView();
        initRoundedView();
    }

    public boolean isRoundedViewUsed() {
        return this.mRoundedView != null;
    }

    public void postUpdateListViewLayout() {
        View thumbnailContainer;
        FrameLayout.LayoutParams layoutParams;
        if (this.mViewInflater.getViewMode() == 1 && (thumbnailContainer = this.mViewInflater.getThumbnailContainer()) != null) {
            if (getType() == 15 || getType() == 16) {
                HoverPopupTextView textContentView = this.mViewInflater.getTextContentView();
                if (textContentView != null) {
                    textContentView.setMaxLines(textContentView.getResources().getInteger(C8003R.integer.noteslist_list_text_max_lines));
                }
                if (this.mExtraView.getVoiceText() == null || this.mExtraView.getVoiceText().getVisibility() != 0) {
                    TitleView titleView = this.mTitleView;
                    titleView.setPadding(titleView.getPaddingLeft(), this.mTitleView.getPaddingTop(), 0, this.mTitleView.getPaddingBottom());
                } else {
                    Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.view.ComposedView.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ComposedView.this.mExtraView.getVoiceText() == null || ComposedView.this.mExtraView.getVoiceText().getVisibility() != 0) {
                                return;
                            }
                            ComposedView.this.mTitleView.setPadding(ComposedView.this.mTitleView.getPaddingLeft(), ComposedView.this.mTitleView.getPaddingTop(), ComposedView.this.mExtraView.getVoiceView().getWidth(), ComposedView.this.mTitleView.getPaddingBottom());
                            ComposedView.this.mTitleView.invalidate();
                            ComposedView.this.mTitlePaddingRunnable = null;
                        }
                    };
                    this.mTitlePaddingRunnable = runnable;
                    this.mTitleView.post(runnable);
                }
                layoutParams = new FrameLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (this.mExtraView.getResources().getDimensionPixelSize(C8003R.dimen.notes_list_item_card_view_margin_top) * 2) + this.mExtraView.getResources().getDimensionPixelSize(C8003R.dimen.notes_list_item_contents_size));
                final HoverPopupTextView textContentView2 = this.mViewInflater.getTextContentView();
                if (textContentView2 != null) {
                    Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.view.ComposedView.4
                        @Override // java.lang.Runnable
                        public void run() {
                            int measuredHeight = textContentView2.getMeasuredHeight() / textContentView2.getLineHeight();
                            if (measuredHeight != textContentView2.getMaxLines()) {
                                textContentView2.setMaxLines(measuredHeight);
                                textContentView2.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            ComposedView.this.mTextContentMaxLineRunnable = null;
                        }
                    };
                    this.mTextContentMaxLineRunnable = runnable2;
                    textContentView2.post(runnable2);
                }
            }
            thumbnailContainer.setLayoutParams(layoutParams);
            thumbnailContainer.requestLayout();
        }
    }

    public void removeListViewAllCallbacks() {
        HoverPopupTextView textContentView;
        if (this.mViewInflater.getViewMode() != 1) {
            return;
        }
        if ((this.mTitlePaddingRunnable != null && getType() == 15) || getType() == 16) {
            this.mTitleView.removeCallbacks(this.mTitlePaddingRunnable);
        } else {
            if (this.mTextContentMaxLineRunnable == null || (textContentView = this.mViewInflater.getTextContentView()) == null) {
                return;
            }
            textContentView.removeCallbacks(this.mTextContentMaxLineRunnable);
        }
    }

    public void setAutoTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText, int i) {
        this.mTitleView.setAutoTitle(mainListDocumentData, highlightText, i);
    }

    public void setClipToOutline() {
        if (hasCoverView()) {
            getCoverView().setClipToOutline(true);
        }
        if (hasImageContentView()) {
            getImageContentView().setClipToOutline(true);
        }
    }

    public void setCoeditAutoTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText, int i) {
        this.mTitleView.setCoeditAutoTitle(mainListDocumentData, highlightText, i);
    }

    public void setCoverType(int i) {
        this.mViewInflater.setCoverType(i);
    }

    public void setLockState(boolean z) {
        if (this.mViewInflater.hasLockThumbnail()) {
            this.mViewInflater.getLockThumbnail().setLockState(z);
        }
    }

    public void setTitle(CharSequence charSequence, HighlightText highlightText, int i) {
        this.mTitleView.setTitle(charSequence, highlightText, i);
    }

    public void setType(int i) {
        this.mViewInflater.setType(i);
    }

    public void decorateExtraBackground(boolean z, boolean z2, @ColorInt int i) {
        if (isRoundedViewUsed()) {
            this.mExtraView.decorateExtraBackground(z, z2, i);
        }
    }
}
