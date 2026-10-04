package com.samsung.android.support.senl.p148nt.composer.main.base.page;

import android.graphics.PointF;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.Serializable;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocPageInfo implements Serializable {
    private static final long BASE_CLEAR_LAST_POSITION = 2592000000L;
    private static final transient String TAG = Logger.createTag("DocPageInfo");
    private static final long serialVersionUID = 1;
    private boolean mBlockToSetCurrentPage;
    private final long mBodyTextModifiedTime;
    private int mCurrentPageIndex;
    private boolean mEnabledDarkTheme;
    private boolean mIsZoomLocked;
    private long mLastAiRequestTime;
    private long mLastOpenedTime;
    private float mLeft;
    private transient LinkedList<PageIndexObserver> mPageIndexObserverList;
    private int mPageLayoutColumn;
    private boolean mPageLayoutFitToScreen;
    private int mPageLayoutRow;
    private PagePanInfo mPagePan;
    private transient PositionObserver mPositionObserver;
    private boolean mRestore;
    private boolean mScrollVertical;
    private final long mServerTimeStamp;
    private float mTop;
    private int mTotalPageCount;
    private transient IViewUpdater mViewUpdater;
    private float mZoomRatio;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IViewUpdater {
        void goToPage(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PageIndexObserver {
        void onPageIndexChanged(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PositionObserver {
        void onPositionChanged(float f, float f4, float f5);
    }

    public DocPageInfo(int i) {
        this.mPageLayoutColumn = 1;
        this.mPageLayoutRow = 1;
        this.mPageLayoutFitToScreen = false;
        this.mScrollVertical = true;
        this.mTotalPageCount = i;
        this.mCurrentPageIndex = 0;
        this.mBodyTextModifiedTime = 0L;
        this.mServerTimeStamp = 0L;
        this.mPagePan = new PagePanInfo(new PointF(0.0f, 0.0f), 0, new PointF(0.0f, 0.0f));
        this.mLastOpenedTime = System.currentTimeMillis();
        this.mIsZoomLocked = false;
        loadPageLayoutSetting();
        this.mLastAiRequestTime = 0L;
    }

    private void notifyDataChanged() {
        LinkedList<PageIndexObserver> linkedList = this.mPageIndexObserverList;
        if (linkedList == null) {
            return;
        }
        for (PageIndexObserver pageIndexObserver : linkedList) {
            if (pageIndexObserver != null) {
                pageIndexObserver.onPageIndexChanged(this.mCurrentPageIndex);
            }
        }
    }

    public void addPageIndexObserver(PageIndexObserver pageIndexObserver) {
        if (this.mPageIndexObserverList == null) {
            this.mPageIndexObserverList = new LinkedList<>();
        }
        this.mPageIndexObserverList.add(pageIndexObserver);
    }

    public void clearPositionAfterDays() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(jCurrentTimeMillis, "clearPositionAfterDays# cur: ", " lot: ");
        sbM1323p.append(this.mLastOpenedTime);
        Logger.m11003i(str, sbM1323p.toString());
        if (jCurrentTimeMillis - this.mLastOpenedTime > BASE_CLEAR_LAST_POSITION) {
            setPosition(new PagePanInfo(), 0.0f);
        }
        this.mLastOpenedTime = jCurrentTimeMillis;
    }

    public DocPageInfo copy() {
        return new DocPageInfo(this.mTotalPageCount, this.mCurrentPageIndex, this.mEnabledDarkTheme, this.mPagePan, this.mZoomRatio, this.mLastOpenedTime, this.mPageLayoutColumn, this.mPageLayoutRow, this.mPageLayoutFitToScreen, this.mScrollVertical, this.mIsZoomLocked, this.mLastAiRequestTime);
    }

    public void fixInvalidInfo(SpenWNote spenWNote) {
        int pageCount = spenWNote.getPageCount();
        if (this.mCurrentPageIndex >= pageCount) {
            Logger.m11003i(TAG, "fixInvalidInfo#");
            this.mCurrentPageIndex = pageCount - 2;
            this.mTotalPageCount = pageCount;
        }
    }

    public void forceSetCurrentPageIndex(int i) {
        if (this.mCurrentPageIndex == i) {
            return;
        }
        Logger.m11003i(TAG, "forceSetCurrentPageIndex : " + this.mCurrentPageIndex + " to " + i);
        this.mCurrentPageIndex = i;
    }

    public int getCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    public long getLastAiRequestTime() {
        return this.mLastAiRequestTime;
    }

    public PointF getLeftTop() {
        return new PointF(this.mLeft, this.mTop);
    }

    public LinkedList<PageIndexObserver> getPageIndexObserverList() {
        return this.mPageIndexObserverList;
    }

    public int getPageLayoutColumn() {
        return this.mPageLayoutColumn;
    }

    public int getPageLayoutRow() {
        return this.mPageLayoutRow;
    }

    public PagePanInfo getPagePan() {
        return this.mPagePan;
    }

    public PositionObserver getPositionObserver() {
        return this.mPositionObserver;
    }

    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public void init() {
        if (this.mPageLayoutColumn == 0) {
            loadPageLayoutSetting();
        }
    }

    public boolean isEnabledDarkTheme() {
        return this.mEnabledDarkTheme;
    }

    public boolean isPageLayoutFitToScreen() {
        return this.mPageLayoutFitToScreen;
    }

    public boolean isReadyToRestore() {
        return this.mRestore;
    }

    public boolean isScrollVertical() {
        return this.mScrollVertical;
    }

    public boolean isZoomLocked() {
        return this.mIsZoomLocked;
    }

    public void loadPageLayoutDefaultForSingle() {
        this.mPageLayoutColumn = 1;
        this.mPageLayoutRow = 1;
        this.mScrollVertical = true;
        this.mPageLayoutFitToScreen = !true;
    }

    public void loadPageLayoutSetting() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Settings");
        this.mPageLayoutColumn = sharedPreferencesCompat.getInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 1);
        this.mPageLayoutRow = 1;
        boolean z = sharedPreferencesCompat.getBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, true);
        this.mScrollVertical = z;
        this.mPageLayoutFitToScreen = !z;
    }

    public void removePageIndexObserver(PageIndexObserver pageIndexObserver) {
        LinkedList<PageIndexObserver> linkedList = this.mPageIndexObserverList;
        if (linkedList == null) {
            return;
        }
        linkedList.remove(pageIndexObserver);
    }

    public void setBlockToSetCurrentPage(boolean z) {
        this.mBlockToSetCurrentPage = z;
    }

    public void setCurrentPageIndex(int i) {
        setCurrentPageIndex(i, false);
    }

    public void setDarkTheme(boolean z) {
        this.mEnabledDarkTheme = z;
    }

    public void setLastAiRequestTime(long j) {
        this.mLastAiRequestTime = j;
    }

    public void setPageLayout(int i, int i2, boolean z, boolean z2) {
        this.mPageLayoutColumn = i;
        this.mPageLayoutRow = i2;
        this.mPageLayoutFitToScreen = z;
        this.mScrollVertical = z2;
    }

    public void setPageLayoutColumn(int i) {
        this.mPageLayoutColumn = i;
    }

    public void setPageLayoutFitToScreen(boolean z) {
        this.mPageLayoutFitToScreen = z;
    }

    public void setPageLayoutRow(int i) {
        this.mPageLayoutRow = i;
    }

    public void setPosition(PagePanInfo pagePanInfo, float f) {
        PagePanInfo pagePanInfo2;
        if (this.mPositionObserver != null && (pagePanInfo2 = this.mPagePan) != null && (pagePanInfo2.getContentPanX() != pagePanInfo.getContentPanX() || this.mPagePan.getContentPanY() != pagePanInfo.getContentPanY() || this.mZoomRatio != f)) {
            this.mPositionObserver.onPositionChanged(pagePanInfo.getContentPanX(), pagePanInfo.getContentPanY(), f);
        }
        this.mPagePan = pagePanInfo;
        this.mZoomRatio = f;
    }

    public void setPositionObserver(PositionObserver positionObserver) {
        this.mPositionObserver = positionObserver;
    }

    public void setRestoreFlag(boolean z) {
        this.mRestore = z;
    }

    public void setScrollVertical(boolean z) {
        this.mScrollVertical = z;
    }

    public void setTotalPageCount(int i) {
        this.mTotalPageCount = i;
    }

    public void setViewUpdater(IViewUpdater iViewUpdater) {
        this.mViewUpdater = iViewUpdater;
    }

    public void setZoomLocked(boolean z) {
        this.mIsZoomLocked = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DocPageInfo{mTotalPageCount=");
        sb.append(this.mTotalPageCount);
        sb.append(", mCurrentPageIndex=");
        sb.append(this.mCurrentPageIndex);
        sb.append(", mEnabledDarkTheme=");
        sb.append(this.mEnabledDarkTheme);
        sb.append(", mLeft=");
        sb.append(this.mLeft);
        sb.append(", mTop=");
        sb.append(this.mTop);
        sb.append(", mPagePan=");
        PagePanInfo pagePanInfo = this.mPagePan;
        PagePanInfo string = pagePanInfo;
        if (pagePanInfo != null) {
            string = pagePanInfo.toString();
        }
        sb.append(string);
        sb.append(", mZoomRatio=");
        sb.append(this.mZoomRatio);
        sb.append(", mRestore=");
        sb.append(this.mRestore);
        sb.append(", mBlockToSetCurrentPage=");
        sb.append(this.mBlockToSetCurrentPage);
        sb.append(", mLastOpenedTime=");
        sb.append(this.mLastOpenedTime);
        sb.append(", mPageLayoutColumn=");
        sb.append(this.mPageLayoutColumn);
        sb.append(", mPageLayoutRow=");
        sb.append(this.mPageLayoutRow);
        sb.append(", mPageLayoutFitToScreen=");
        sb.append(this.mPageLayoutFitToScreen);
        sb.append(", mScrollVertical=");
        sb.append(this.mScrollVertical);
        sb.append(", mIsZoomLocked=");
        return AbstractC0622a.m1172r(sb, this.mIsZoomLocked, '}');
    }

    public void setCurrentPageIndex(int i, boolean z) {
        IViewUpdater iViewUpdater;
        if ((this.mCurrentPageIndex != i || z) && !this.mBlockToSetCurrentPage) {
            Logger.m11003i(TAG, "setCurrentPageIndex : " + this.mCurrentPageIndex + " to " + i);
            this.mCurrentPageIndex = i;
            if (i < 0) {
                this.mCurrentPageIndex = 0;
            }
            if (z && (iViewUpdater = this.mViewUpdater) != null) {
                iViewUpdater.goToPage(this.mCurrentPageIndex);
            }
            notifyDataChanged();
        }
    }

    public DocPageInfo(int i, int i2, boolean z, PagePanInfo pagePanInfo, float f, long j, int i4, int i5, boolean z2, boolean z3, boolean z4, long j2) {
        this.mTotalPageCount = i;
        this.mCurrentPageIndex = i2;
        this.mBodyTextModifiedTime = 0L;
        this.mServerTimeStamp = 0L;
        this.mEnabledDarkTheme = z;
        this.mPagePan = pagePanInfo;
        this.mZoomRatio = f;
        this.mLastOpenedTime = j;
        this.mPageLayoutColumn = i4;
        this.mPageLayoutRow = i5;
        this.mPageLayoutFitToScreen = z2;
        this.mScrollVertical = z3;
        this.mIsZoomLocked = z4;
        this.mLastAiRequestTime = j2;
    }

    public DocPageInfo(int i, DocPageInfo docPageInfo) {
        this(i);
        if (docPageInfo != null) {
            this.mPageIndexObserverList = docPageInfo.getPageIndexObserverList();
            this.mPositionObserver = docPageInfo.getPositionObserver();
        }
    }
}
