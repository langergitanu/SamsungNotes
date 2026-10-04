package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerViewState {
    private boolean mIsOnTextOnlyMode;
    private float mPanX;
    private float mPanY;
    private ViewPositionAndZoom mSmoothScrollToLast;
    private int mSpenComposerType;
    private float mZoomRatio;
    private int mLastPageIndex = 0;
    private int mLastPageCount = 0;
    private boolean mIsVertical = true;
    private boolean mIsTwoPageView = false;
    private final List<StateChangeListener> mStateChangeListeners = new ArrayList(3);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StateChangeListener {
        void onComposerModeChanged(int i, int i2);

        void onPageCountChanged(int i);

        void onPageIndexChanged(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewPositionAndZoom {
        private final int mPageIndex;
        private final float mPanX;
        private final float mPanY;
        private final float mZoomRatio;

        public ViewPositionAndZoom(float f, float f4, float f5, int i) {
            this.mPanX = f;
            this.mPanY = f4;
            this.mZoomRatio = f5;
            this.mPageIndex = i;
        }

        public int getPageIndex() {
            return this.mPageIndex;
        }

        public float getPanX() {
            return this.mPanX;
        }

        public float getPanY() {
            return this.mPanY;
        }

        public float getZoomRatio() {
            return this.mZoomRatio;
        }
    }

    public void addStateChangeListener(StateChangeListener stateChangeListener) {
        if (this.mStateChangeListeners.contains(stateChangeListener)) {
            return;
        }
        this.mStateChangeListeners.add(stateChangeListener);
    }

    public void clearSnapShotSmoothScrollData() {
        this.mSmoothScrollToLast = new ViewPositionAndZoom(0.0f, 0.0f, 0.0f, 0);
    }

    public int getComposerMode() {
        return this.mSpenComposerType;
    }

    public int getLastPageCount() {
        return this.mLastPageCount;
    }

    public int getLastPageIndex() {
        return this.mLastPageIndex;
    }

    public float getPanX() {
        return this.mPanX;
    }

    public float getPanY() {
        return this.mPanY;
    }

    public ViewPositionAndZoom getSmoothScrollToLast() {
        if (this.mSmoothScrollToLast == null) {
            clearSnapShotSmoothScrollData();
        }
        return this.mSmoothScrollToLast;
    }

    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public boolean isOnTextOnlyMode() {
        return this.mIsOnTextOnlyMode;
    }

    public boolean isTwoPageView() {
        return this.mIsTwoPageView;
    }

    public boolean isVertical() {
        return this.mIsVertical;
    }

    public void release() {
        this.mStateChangeListeners.clear();
    }

    public void setComposerMode(int i) {
        int i2 = this.mSpenComposerType;
        if (i2 == i) {
            return;
        }
        this.mSpenComposerType = i;
        Iterator<StateChangeListener> it = this.mStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onComposerModeChanged(i2, i);
        }
    }

    public void setIsOnTextOnlyMode(boolean z) {
        this.mIsOnTextOnlyMode = z;
    }

    public void setLastPageIndex(int i) {
        int i2 = this.mLastPageIndex;
        if (i2 == i) {
            return;
        }
        this.mLastPageIndex = i;
        Iterator<StateChangeListener> it = this.mStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageIndexChanged(i2, i);
        }
    }

    public void setPanXY(float f, float f4) {
        this.mPanX = f;
        this.mPanY = f4;
    }

    public void setTwoPageView(boolean z) {
        this.mIsTwoPageView = z;
    }

    public void setVertical(boolean z) {
        this.mIsVertical = z;
    }

    public void setZoomRatio(float f) {
        this.mZoomRatio = f;
    }

    public void snapShotSmoothScrollData(int i) {
        this.mSmoothScrollToLast = new ViewPositionAndZoom(this.mPanX, this.mPanY, this.mZoomRatio, i);
    }

    public void updatePageCount(int i) {
        this.mLastPageCount = i;
        Iterator<StateChangeListener> it = this.mStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageCountChanged(i);
        }
    }
}
