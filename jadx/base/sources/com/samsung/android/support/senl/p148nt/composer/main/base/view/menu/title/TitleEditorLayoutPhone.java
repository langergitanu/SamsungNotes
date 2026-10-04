package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class TitleEditorLayoutPhone implements ITitleEditorLayout {
    private static final String TAG = Logger.createTag("TitleEditorLayoutPhone");
    private final TitleEditorShowHideAnimator mShowHideAnimator;
    private final TitleEditorViewSet mViewSet;

    public TitleEditorLayoutPhone(TitleEditorViewSet titleEditorViewSet, TitleEditorShowHideAnimator.Contract contract) {
        this.mShowHideAnimator = new TitleEditorShowHideAnimator(titleEditorViewSet, contract);
        this.mViewSet = titleEditorViewSet;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean hide(boolean z) {
        if (!isShowing()) {
            return false;
        }
        this.mViewSet.getTitleView().getView().setEnabled(false);
        if (!z) {
            this.mShowHideAnimator.cancel();
            this.mShowHideAnimator.initHideState();
            this.mShowHideAnimator.animate(1.0f, false);
            this.mShowHideAnimator.updateHideState();
        } else {
            if (this.mShowHideAnimator.isHiding()) {
                return true;
            }
            hideAfterToolbarSetTitle();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void hideAfterToolbarSetTitle() {
        this.mViewSet.getToolbar().setTitle(this.mViewSet.getTitleView().getTitleText(), new ICustomToolbar.TitleCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorLayoutPhone.1
            @Override // com.samsung.android.support.senl.nt.base.winset.view.toolbar.ICustomToolbar.TitleCallback
            public void updateDone() {
                Logger.m10999d(TitleEditorLayoutPhone.TAG, "updateDone#");
                TitleEditorLayoutPhone.this.mShowHideAnimator.initHideState();
                TitleEditorLayoutPhone.this.mShowHideAnimator.animate(0.0f, false);
            }
        });
    }

    public void hideNoteCover() {
        Logger.m10999d(TAG, "hideNoteCover#");
        if (isShowing()) {
            this.mShowHideAnimator.hideNoteCover();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean isAnimating() {
        return this.mShowHideAnimator.isAnimating();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean isShowing() {
        return this.mViewSet.getParentLockView().getVisibility() == 0;
    }

    public void onCompleteCover() {
        Logger.m10999d(TAG, "onCompleteCover#");
        this.mShowHideAnimator.updateNoteCover();
        this.mViewSet.getAiNoteCoverView().completeView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void release() {
        this.mShowHideAnimator.release();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void show() {
        if (isShowing() || this.mShowHideAnimator.isAnimating()) {
            return;
        }
        this.mViewSet.getTitleView().getView().setEnabled(true);
        this.mShowHideAnimator.initShowState();
        this.mShowHideAnimator.animate(0.0f, true);
    }

    public void showCancelCover(boolean z) {
        this.mViewSet.getAiNoteCoverView().initCancelView();
        this.mViewSet.getAiNoteCoverView().setVisibleCancelView(z ? 0 : 8);
    }

    public void showCreatingCover() {
        Logger.m10999d(TAG, "showCreatingCover#");
        this.mViewSet.getAiNoteCoverView().setLoadingView(0);
        if (isShowing()) {
            this.mShowHideAnimator.updateNoteCover();
        } else {
            show();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean updateFavorite(boolean z) {
        if (this.mViewSet.getFavorite() == null) {
            return false;
        }
        this.mViewSet.getFavorite().updateState(z, false);
        return true;
    }

    public void updateNoteCover() {
        Logger.m10999d(TAG, "updateNoteCover#");
        this.mShowHideAnimator.updateNoteCover();
        this.mViewSet.getAiNoteCoverView().updateView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void updateTitleAndFolderWidth() {
        if (!isShowing() || this.mShowHideAnimator.isAnimating()) {
            return;
        }
        this.mShowHideAnimator.updateTitleWidth();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void updateTitleWidth(int i) {
        if (!isShowing() || this.mShowHideAnimator.isAnimating()) {
            return;
        }
        this.mShowHideAnimator.updateTitleWidth(i);
    }
}
