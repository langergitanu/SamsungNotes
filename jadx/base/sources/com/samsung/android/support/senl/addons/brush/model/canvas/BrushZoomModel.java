package com.samsung.android.support.senl.addons.brush.model.canvas;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0010\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\fJ0\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0002J.\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tJ \u0010\u0019\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\fJ\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushZoomModel;", "", "<init>", "()V", "mMinZoomRatio", "", "mFitZoomRatio", "mPrevFitZoomRatio", "mPageDocWidth", "", "mPageDocHeight", "setDocSize", "", "pageDocWidth", "pageDocHeight", "initialize", "updateMinZoomRatio", "fitScaleX", "fitScaleY", "widthExceptEdge", "heightExceptEdge", "orientation", "setZoomRatios", "viewWidth", "viewHeight", "updateFitZoomRatio", "isNeedSetFitZoom", "", "zoomRatio", "setFitZoomUpdated", "getFitZoomRatio", "getMinZoomRatio", "isInitZoomRatios", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushZoomModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushZoomModel");
    private static final float ZOOM_VALUE_NOT_INITIALIZED = -1.0f;
    private int mPageDocHeight;
    private int mPageDocWidth;
    private float mMinZoomRatio = -1.0f;
    private float mFitZoomRatio = -1.0f;
    private float mPrevFitZoomRatio = -1.0f;

    private final void updateFitZoomRatio(float fitScaleX, float fitScaleY, int orientation) {
        if (orientation != 1 ? fitScaleX <= fitScaleY : fitScaleX > fitScaleY && Math.abs(fitScaleX - 1.0f) > Math.abs(fitScaleY - 1.0f)) {
            fitScaleX = fitScaleY;
        }
        if (Math.abs(fitScaleX - this.mFitZoomRatio) > 0.001f) {
            float f = this.mFitZoomRatio;
            this.mPrevFitZoomRatio = f;
            this.mFitZoomRatio = fitScaleX;
            Logger.m7100d(TAG, "update fit zoom ratio : set " + fitScaleX + " from " + f);
        }
    }

    private final void updateMinZoomRatio(float fitScaleX, float fitScaleY, float widthExceptEdge, float heightExceptEdge, int orientation) {
        if (orientation == 1) {
            float fFloor = ((float) Math.floor((widthExceptEdge / this.mPageDocWidth) * 1000.0f)) / 1000.0f;
            float fFloor2 = ((float) Math.floor((heightExceptEdge / this.mPageDocHeight) * 1000.0f)) / 1000.0f;
            if (fFloor > fFloor2) {
                fFloor = fFloor2;
            }
            if (fitScaleX >= fFloor) {
                fitScaleX = fFloor;
            }
            if (fitScaleX < fitScaleY) {
                fitScaleY = fitScaleX;
            }
            this.mMinZoomRatio = fitScaleY;
        } else {
            float fFloor3 = ((float) Math.floor((widthExceptEdge / this.mPageDocHeight) * 1000.0f)) / 1000.0f;
            float fFloor4 = ((float) Math.floor((heightExceptEdge / this.mPageDocWidth) * 1000.0f)) / 1000.0f;
            if (fFloor3 > fFloor4) {
                fFloor3 = fFloor4;
            }
            if (fitScaleY >= fFloor3) {
                fitScaleY = fFloor3;
            }
            if (fitScaleX >= fitScaleY) {
                fitScaleX = fitScaleY;
            }
            this.mMinZoomRatio = fitScaleX;
        }
        float f = this.mMinZoomRatio;
        float f4 = this.mFitZoomRatio;
        if (f >= f4 * 0.9f) {
            this.mMinZoomRatio = f4 * 0.9f;
        }
        Logger.m7100d(TAG, "update min zoom ratio : set " + this.mMinZoomRatio);
    }

    /* JADX INFO: renamed from: getFitZoomRatio, reason: from getter */
    public float getMFitZoomRatio() {
        return this.mFitZoomRatio;
    }

    /* JADX INFO: renamed from: getMinZoomRatio, reason: from getter */
    public float getMMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    public final void initialize() {
        this.mMinZoomRatio = -1.0f;
        this.mFitZoomRatio = -1.0f;
        this.mPrevFitZoomRatio = -1.0f;
    }

    public boolean isInitZoomRatios() {
        return this.mMinZoomRatio > 0.0f && this.mFitZoomRatio > 0.0f;
    }

    public boolean isNeedSetFitZoom(float zoomRatio) {
        boolean z = Math.abs(zoomRatio - this.mPrevFitZoomRatio) < 0.001f;
        boolean z2 = this.mPrevFitZoomRatio > 0.0f;
        Logger.m7100d(TAG, "isNeedSetFitZoom : " + z + SQLKeyword.COMMA + z2);
        return !z2 || z;
    }

    public final void setDocSize(int pageDocWidth, int pageDocHeight) {
        this.mPageDocWidth = pageDocWidth;
        this.mPageDocHeight = pageDocHeight;
    }

    public final void setFitZoomUpdated() {
        this.mPrevFitZoomRatio = this.mFitZoomRatio;
    }

    public final void setZoomRatios(int viewWidth, int viewHeight, float widthExceptEdge, float heightExceptEdge, int orientation) {
        float fFloor = ((float) Math.floor((viewWidth / this.mPageDocWidth) * 1000.0f)) / 1000.0f;
        float fFloor2 = ((float) Math.floor((viewHeight / this.mPageDocHeight) * 1000.0f)) / 1000.0f;
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("update zoom ratios : ", fFloor, " x ", fFloor2, SQLKeyword.COMMA);
        sbM1176v.append(orientation);
        Logger.m7100d(str, sbM1176v.toString());
        if (fFloor <= 0.0f || fFloor2 <= 0.0f) {
            return;
        }
        updateFitZoomRatio(fFloor, fFloor2, orientation);
        updateMinZoomRatio(fFloor, fFloor2, widthExceptEdge, heightExceptEdge, orientation);
    }
}
