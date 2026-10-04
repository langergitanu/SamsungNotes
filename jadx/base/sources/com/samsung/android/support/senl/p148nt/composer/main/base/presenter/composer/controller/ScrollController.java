package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.util.SpenPagePan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ScrollController implements DocPageInfo.IViewUpdater {
    private static final String TAG = Logger.createTag("CpV$ScrollController");
    private ControllerManager mControllerManager;
    private OnScrollListener mOnScrollListener;
    private PageManager mPageManager;
    private ComposerControllerContract mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnScrollListener {
        void onScroll();
    }

    public void alignmentContent(int i) {
        this.mView.alignmentContent(i);
    }

    public void checkIsNaNAndChange(PointF pointF) {
        if (Float.isNaN(pointF.x)) {
            pointF.x = 0.0f;
        }
        if (Float.isNaN(pointF.y)) {
            pointF.y = 0.0f;
        }
    }

    public void fitPageWidth() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.requestResetZoomScaleToDefault();
        }
    }

    @NonNull
    public PointF getDelta() {
        ComposerControllerContract composerControllerContract = this.mView;
        return composerControllerContract == null ? new PointF() : composerControllerContract.getDelta();
    }

    public int getPageIndex(RectF rectF) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            return composerControllerContract.getPageIndex(rectF);
        }
        return -1;
    }

    public PointF getPan() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract == null) {
            return null;
        }
        return composerControllerContract.getPan();
    }

    public float getScale() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract == null) {
            return 1.0f;
        }
        return composerControllerContract.getScale();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.DocPageInfo.IViewUpdater
    public void goToPage(int i) {
        AbstractC0000a.m3D(i, "goToPage# ", TAG);
        this.mView.goToPage(i);
        this.mPageManager.getDocPageInfo().setCurrentPageIndex(i);
    }

    public void init(ControllerManager controllerManager, PageManager pageManager) {
        this.mControllerManager = controllerManager;
        this.mPageManager = pageManager;
    }

    public void moveScroll(boolean z, boolean z2) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.moveScroll(z, z2);
        }
    }

    public void onScroll(PagePanInfo pagePanInfo, float f, int i) {
        List<PageInfo> pageList = this.mPageManager.getPageList();
        if (pageList == null || pageList.isEmpty() || this.mPageManager.getDocPageInfo().isReadyToRestore()) {
            return;
        }
        if (this.mControllerManager.getQuickSaveTimer() != null) {
            this.mControllerManager.getQuickSaveTimer().reset("onScroll");
        }
        this.mPageManager.getDocPageInfo().setPosition(pagePanInfo, f);
        this.mPageManager.getDocPageInfo().setCurrentPageIndex(i);
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll();
        }
    }

    public void pageScroll(boolean z) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.pageScroll(z);
        }
    }

    public void pageZoom(boolean z) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.pageZoom(z);
        }
    }

    public void restoreLastPosition(SpenWNote spenWNote) {
        PointF leftTop;
        DocPageInfo docPageInfo = this.mPageManager.getDocPageInfo();
        if (docPageInfo.isReadyToRestore()) {
            docPageInfo.setRestoreFlag(false);
            try {
                int currentPageIndex = docPageInfo.getCurrentPageIndex();
                if (docPageInfo.getPagePan() != null) {
                    SpenPagePan spenPagePanConvertToSpenPagePan = PagePanInfo.convertToSpenPagePan(docPageInfo.getPagePan());
                    int pageCount = spenWNote.getPageCount();
                    int i = spenPagePanConvertToSpenPagePan.pageIndex;
                    if (pageCount <= i) {
                        Logger.m11000e(TAG, "restoreLastPosition IndexOutOfBoundsException : " + spenWNote.getPageCount() + "<=" + spenPagePanConvertToSpenPagePan.pageIndex + "/ currIdx=" + currentPageIndex);
                        docPageInfo.setCurrentPageIndex(0);
                        return;
                    }
                    leftTop = SpenPagePan.convertPagePanToContentPan(spenWNote, spenPagePanConvertToSpenPagePan);
                    if (leftTop == null) {
                        Logger.m11000e(TAG, "restoreLastPosition# contentPan is null");
                        return;
                    }
                    currentPageIndex = i;
                } else {
                    if (this.mView.getScrollingDirection() != 0) {
                        goToPage(currentPageIndex);
                        Logger.m11003i(TAG, "restoreLastPosition first goToPage : " + currentPageIndex);
                        return;
                    }
                    leftTop = docPageInfo.getLeftTop();
                }
                checkIsNaNAndChange(leftTop);
                float zoomRatio = docPageInfo.getZoomRatio();
                setContentPan(zoomRatio, leftTop.x, leftTop.y, currentPageIndex);
                Logger.m11003i(TAG, "restoreLastPosition first setContentPan : " + zoomRatio + "/" + leftTop.x + "/" + leftTop.y + "/" + currentPageIndex);
            } catch (Exception e) {
                AbstractC8014b.m7207i("restoreLastPosition ", e, TAG);
            }
        }
    }

    public void setContentPan(float f, float f4, float f5, int i) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            try {
                composerControllerContract.setContentPan(f, f4, f5, i);
            } catch (Exception e) {
                AbstractC8014b.m7207i("setContentPan# ", e, TAG);
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setPan(PointF pointF) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract == null || pointF == null) {
            return;
        }
        composerControllerContract.setPan(pointF);
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        this.mView = composerControllerContract;
    }

    public void smoothScrollToFitPage() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.smoothScrollToFitPage();
        }
    }

    public void stopGestureAnimation() {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.stopGestureAnimation();
        }
    }
}
