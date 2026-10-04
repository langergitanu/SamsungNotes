package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.graphics.Rect;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AnchorInfo {
    private static final int DEFAULT_ANCHOR_MARGIN = 10;
    protected static String TAG = Logger.createTag("AnchorInfo");
    public View mAnchorBorderView;
    public int mAnchorMargin;
    public Rect mAnchorRect;
    public Rect mBorderRect;
    public ViewAnchorUtil.Area mPriorityArea;

    public AnchorInfo(AnchorInfo anchorInfo) {
        this.mAnchorMargin = 10;
        this.mPriorityArea = null;
        this.mAnchorRect = new Rect(anchorInfo.mAnchorRect);
        this.mAnchorBorderView = anchorInfo.mAnchorBorderView;
        this.mAnchorMargin = anchorInfo.mAnchorMargin;
        this.mPriorityArea = anchorInfo.mPriorityArea;
        this.mBorderRect = anchorInfo.mBorderRect;
    }

    public View getAnchorBorderView() {
        return this.mAnchorBorderView;
    }

    public void setPriorityArea(ViewAnchorUtil.Area area) {
        this.mPriorityArea = area;
    }

    public AnchorInfo(Rect rect, View view) {
        this(rect, view, 10);
    }

    public AnchorInfo(Rect rect, View view, int i) {
        this.mAnchorMargin = 10;
        this.mPriorityArea = null;
        this.mAnchorRect = rect;
        this.mAnchorBorderView = view;
        this.mBorderRect = new Rect((int) this.mAnchorBorderView.getX(), (int) this.mAnchorBorderView.getY(), this.mAnchorBorderView.getWidth(), this.mAnchorBorderView.getHeight());
        this.mAnchorMargin = i;
    }

    public AnchorInfo(Rect rect, View view, Rect rect2, int i) {
        this.mPriorityArea = null;
        this.mAnchorRect = rect;
        this.mAnchorBorderView = view;
        this.mBorderRect = rect2;
        this.mAnchorMargin = i;
    }

    public AnchorInfo(View view, View view2) {
        this.mAnchorMargin = 10;
        this.mPriorityArea = null;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        this.mAnchorRect = new Rect(iArr[0], iArr[1], view.getMeasuredWidth(), view.getMeasuredHeight());
        this.mAnchorBorderView = view2;
        this.mBorderRect = new Rect((int) this.mAnchorBorderView.getX(), (int) this.mAnchorBorderView.getY(), this.mAnchorBorderView.getWidth(), this.mAnchorBorderView.getHeight());
    }
}
