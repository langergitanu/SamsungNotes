package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.graphics.PointF;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageReorderController {
    private static final String TAG = Logger.createTag("PageReorderController");
    private PageReorderAnimator mAnimator;
    private PageDragListenerImpl mPageDragListener;

    private void updateViewAlpha(PageHolder pageHolder, float f) {
        pageHolder.mThumbnailContainer.setAlpha(f);
        pageHolder.mPageIndexView.setAlpha(f);
        pageHolder.mBookmarkBtnImage.setAlpha(f);
        pageHolder.mMoreBtn.setAlpha(f);
    }

    private void updateViewTranslation(PageHolder pageHolder, PageDragListenerImpl.AnimationItemInfo[] animationItemInfoArr, int i) {
        if (animationItemInfoArr != null) {
            PageDragListenerImpl.AnimationItemInfo animationItemInfo = animationItemInfoArr[i];
            Logger.m10999d(TAG, "updateViewTranslation# " + animationItemInfo);
            if (animationItemInfo == null || !animationItemInfo.isMoved()) {
                pageHolder.itemView.setTranslationY(0.0f);
                pageHolder.itemView.setTranslationX(0.0f);
                pageHolder.mPageIndexView.setText(LocaleUtils.convertToArabicNumber(pageHolder.mPageIndex + 1));
            } else {
                pageHolder.itemView.setTranslationY(animationItemInfo.getDistY());
                pageHolder.itemView.setTranslationX(animationItemInfo.getDistX());
                pageHolder.mPageIndexView.setText(LocaleUtils.convertToArabicNumber(animationItemInfo.getMovedIndex()));
            }
        }
    }

    public void setDragLayout(PageHolder pageHolder, int i) {
        if (pageHolder.getType() == 1) {
            return;
        }
        int dragIndex = this.mPageDragListener.getDragIndex();
        PageDragListenerImpl.AnimationItemInfo[] animationInfo = this.mPageDragListener.getAnimationInfo();
        if (dragIndex >= 0) {
            if (dragIndex == i) {
                updateViewAlpha(pageHolder, 0.0f);
            } else {
                updateViewAlpha(pageHolder, 1.0f);
            }
            updateViewTranslation(pageHolder, animationInfo, i);
            return;
        }
        pageHolder.itemView.setTranslationY(0.0f);
        pageHolder.itemView.setTranslationX(0.0f);
        updateViewAlpha(pageHolder, 1.0f);
        pageHolder.setPageIndexText(pageHolder.mPageIndex + 1);
    }

    public void setPageDragListener(PageDragListenerImpl pageDragListenerImpl) {
        this.mPageDragListener = pageDragListenerImpl;
    }

    public void startDrag(final PageHolder pageHolder, final int i) {
        PageReorderAnimator pageReorderAnimator = new PageReorderAnimator(pageHolder, pageHolder.mPageHolderVariable.getTopContainer());
        this.mAnimator = pageReorderAnimator;
        pageReorderAnimator.startDragInAnimation(pageHolder.mThumbnailView, pageHolder.mInputEventChecker.getPosition(), new PageReorderAnimator.IListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderController.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator.IListener
            public void onAnimationEnd() {
                pageHolder.mThumbnailContainer.setAlpha(0.0f);
                PageReorderController.this.mAnimator.startDrag(pageHolder.itemView, new PointF(pageHolder.mInputEventChecker.getPosition().x / pageHolder.mThumbnailContainer.getWidth(), pageHolder.mInputEventChecker.getPosition().y / pageHolder.mThumbnailContainer.getHeight()), i);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator.IListener
            public void onAnimationStart() {
                PageReorderController.this.mPageDragListener.setDragInfo(pageHolder.mPageId, i, PageReorderController.this.mAnimator);
                pageHolder.mBookmarkBtnImage.setAlpha(0.0f);
                pageHolder.mMoreBtn.setAlpha(0.0f);
                pageHolder.mPageIndexView.setAlpha(0.0f);
            }
        });
    }

    public void startDragByMouse(PageHolder pageHolder, int i) {
        PageReorderAnimator pageReorderAnimator = new PageReorderAnimator(pageHolder, pageHolder.mPageHolderVariable.getTopContainer());
        this.mAnimator = pageReorderAnimator;
        pageReorderAnimator.startDragInNoAnimation(pageHolder.mThumbnailView, pageHolder.mInputEventChecker.getPosition());
        this.mPageDragListener.setDragInfo(pageHolder.mPageId, i, this.mAnimator);
        pageHolder.mBookmarkBtnImage.setAlpha(0.0f);
        pageHolder.mMoreBtn.setAlpha(0.0f);
        pageHolder.mPageIndexView.setAlpha(0.0f);
        pageHolder.mThumbnailContainer.setAlpha(0.0f);
        this.mAnimator.startDrag(pageHolder.itemView, new PointF(0.5f, 0.5f), i);
    }
}
