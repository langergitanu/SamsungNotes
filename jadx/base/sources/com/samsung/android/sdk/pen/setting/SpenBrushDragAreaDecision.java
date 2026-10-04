package com.samsung.android.sdk.pen.setting;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u001b\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushDragAreaDecision;", "", "<init>", "()V", "mTop", "", "Landroid/graphics/Point;", "[Landroid/graphics/Point;", "mStart", "mEnd", "mIsRTL", "", "mParent", "Landroid/view/View;", "close", "", "setParent", "parent", "makeDecision", "getArea", "align", "", "(I)[Landroid/graphics/Point;", "getParentRect", "Landroid/graphics/Rect;", "view", "makePortraitArea", "parentRect", "makeLandscapeArea", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushDragAreaDecision {
    private static final int AREA_POINT_SIZE = 4;

    @NotNull
    private Point[] mEnd;
    private boolean mIsRTL;

    @Nullable
    private View mParent;

    @NotNull
    private Point[] mStart;

    @NotNull
    private Point[] mTop;

    public SpenBrushDragAreaDecision() {
        Point[] pointArr = new Point[4];
        for (int i = 0; i < 4; i++) {
            pointArr[i] = new Point();
        }
        this.mTop = pointArr;
        Point[] pointArr2 = new Point[4];
        for (int i2 = 0; i2 < 4; i2++) {
            pointArr2[i2] = new Point();
        }
        this.mStart = pointArr2;
        Point[] pointArr3 = new Point[4];
        for (int i4 = 0; i4 < 4; i4++) {
            pointArr3[i4] = new Point();
        }
        this.mEnd = pointArr3;
    }

    private final Rect getParentRect(View view) {
        return new Rect((int) view.getX(), (int) view.getY(), view.getWidth() + ((int) view.getX()), view.getHeight() + ((int) view.getY()));
    }

    private final void makeLandscapeArea(Rect parentRect) {
        int iWidth = (int) (parentRect.width() * 0.2f);
        int iWidth2 = (int) (parentRect.width() * 0.4f);
        this.mTop[0].set(parentRect.left + iWidth, parentRect.top);
        this.mTop[1].set((parentRect.width() + parentRect.left) - iWidth, parentRect.top);
        this.mTop[2].set(parentRect.left + iWidth2, parentRect.height() + parentRect.top);
        this.mTop[3].set((parentRect.width() + parentRect.left) - iWidth2, this.mTop[2].y);
        this.mStart[0].set(parentRect.left, parentRect.top);
        this.mStart[1].set(parentRect.left + iWidth, parentRect.top);
        Point[] pointArr = this.mStart;
        pointArr[2].set(pointArr[0].x, parentRect.height() + parentRect.top);
        Point[] pointArr2 = this.mStart;
        pointArr2[3].set(parentRect.left + iWidth2, pointArr2[2].y);
        this.mEnd[0].set((parentRect.width() + parentRect.left) - iWidth, parentRect.top);
        this.mEnd[1].set(parentRect.width() + parentRect.left, parentRect.top);
        this.mEnd[2].set((parentRect.width() + parentRect.left) - iWidth2, parentRect.height() + parentRect.top);
        Point[] pointArr3 = this.mEnd;
        pointArr3[3].set(pointArr3[1].x, pointArr3[2].y);
    }

    private final void makePortraitArea(Rect parentRect) {
        int iHeight = (int) (parentRect.height() * 0.22f);
        this.mTop[0].set(parentRect.left, parentRect.top);
        this.mTop[1].set(parentRect.width() + parentRect.left, parentRect.top);
        this.mTop[2].set(parentRect.left, parentRect.top + iHeight);
        Point[] pointArr = this.mTop;
        pointArr[3].set(pointArr[1].x, pointArr[2].y);
        this.mStart[0].set(parentRect.left, parentRect.top + iHeight);
        this.mStart[1].set((parentRect.width() / 2) + parentRect.left, this.mStart[0].y);
        Point[] pointArr2 = this.mStart;
        pointArr2[2].set(pointArr2[0].x, parentRect.height() + parentRect.top);
        Point[] pointArr3 = this.mStart;
        pointArr3[3].set(pointArr3[1].x, pointArr3[2].y);
        this.mEnd[0].set((parentRect.width() / 2) + parentRect.left, parentRect.top + iHeight);
        this.mEnd[1].set(parentRect.width() + parentRect.left, this.mEnd[0].y);
        Point[] pointArr4 = this.mEnd;
        pointArr4[2].set(pointArr4[0].x, parentRect.height() + parentRect.top);
        Point[] pointArr5 = this.mEnd;
        pointArr5[3].set(pointArr5[1].x, pointArr5[2].y);
    }

    public final void close() {
        this.mParent = null;
    }

    @Nullable
    public final Point[] getArea(int align) {
        if (align == 1) {
            return this.mIsRTL ? this.mStart : this.mEnd;
        }
        if (align == 2) {
            return this.mIsRTL ? this.mEnd : this.mStart;
        }
        if (align != 3) {
            return null;
        }
        return this.mTop;
    }

    public final boolean makeDecision() {
        View view = this.mParent;
        if (view == null) {
            return false;
        }
        this.mIsRTL = view.getLayoutDirection() == 1;
        Rect parentRect = getParentRect(view);
        if (parentRect.width() < parentRect.height()) {
            makePortraitArea(parentRect);
        } else {
            makeLandscapeArea(parentRect);
        }
        return true;
    }

    public final void setParent(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.mParent = parent;
    }
}
