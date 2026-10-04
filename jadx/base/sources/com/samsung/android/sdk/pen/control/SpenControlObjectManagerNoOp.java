package com.samsung.android.sdk.pen.control;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0010H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0010H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0010H\u0016J\u0010\u00107\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0010H\u0016J@\u0010:\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010;j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`<2\u001e\u0010=\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010;j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`<H\u0016JN\u0010B\u001a\u0004\u0018\u00010\u001b2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010D\u001a\u0004\u0018\u00010?2\u001e\u0010=\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010;j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`<2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rH\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\u0010H\u0016J \u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\r2\u0006\u0010H\u001a\u00020\u0010H\u0016J\b\u0010L\u001a\u00020\u0010H\u0016J\b\u0010M\u001a\u00020\tH\u0016J\u0012\u0010N\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010>\u001a\u0004\u0018\u00010?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/SpenControlObjectManagerNoOp;", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "<init>", "()V", "nativeHandle", "", "getNativeHandle", "()J", "close", "", "closeControl", "setScreenSize", "width", "", "height", "onTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "updateObjectRuntimePos", "isObjectRuntimePlaying", "()Z", "playVideo", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "stopPlayingVideo", "selectedData", "Landroid/graphics/Bitmap;", "getSelectedData", "()Landroid/graphics/Bitmap;", "scaleX", "", "scaleY", "_position", "Landroid/graphics/PointF;", "pastePosition", "getPastePosition", "()Landroid/graphics/PointF;", "setPastePosition", "(Landroid/graphics/PointF;)V", "setObjectListener", "l", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "setControlActionListener", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$ControlActionListener;", "setImageEditable", "editable", "setControlBitmap", "enable", "setFitWidth", "isFitWidth", "setLasso", "isLasso", "setLassoCrop", "isCrop", "setRectangleCrop", "setShapeSegment", "isShapeSegment", "getCombinedObjectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "objectList", "selectedRect", "Landroid/graphics/RectF;", "getSelectedRect", "()Landroid/graphics/RectF;", "getMaskedBitmap", "srcBitmap", "rect", "internalMaskColor", "externalMaskColor", "setFocus", "focus", "setFocusCell", "row", "column", "hasFocus", "setControlStyleInfoAsDefault", "setControlStyleInfo", "info", "Lcom/samsung/android/sdk/pen/control/SpenControlStyleInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenControlObjectManagerNoOp implements ISpenControlObjectManager {
    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void closeControl() {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public ArrayList<SpenObjectBase> getCombinedObjectList(@Nullable ArrayList<SpenObjectBase> objectList) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public Bitmap getMaskedBitmap(@Nullable Bitmap srcBitmap, @Nullable RectF rect, @Nullable ArrayList<SpenObjectBase> objectList, int internalMaskColor, int externalMaskColor) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public long getNativeHandle() {
        return 0L;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public PointF getPastePosition() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public Bitmap getSelectedData() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public RectF getSelectedRect() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean hasFocus() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean isObjectRuntimePlaying() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean onTouch(@Nullable MotionEvent motionEvent) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean playVideo(@Nullable SpenObjectBase objectBase) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlActionListener(@Nullable ISpenControlObjectManager.ControlActionListener l) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlBitmap(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlStyleInfo(@Nullable SpenControlStyleInfo info) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlStyleInfoAsDefault() {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setFitWidth(boolean isFitWidth) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setFocus(boolean focus) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setFocusCell(int row, int column, boolean focus) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setImageEditable(boolean editable) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setLasso(boolean isLasso) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setLassoCrop(boolean isCrop) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setObjectListener(@Nullable SpenControlObjectListener l) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setPastePosition(@Nullable PointF pointF) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setRectangleCrop(boolean isCrop) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setScreenSize(int width, int height) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setShapeSegment(boolean isShapeSegment) {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void stopPlayingVideo() {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void updateObjectRuntimePos() {
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public Bitmap getSelectedData(float scaleX, float scaleY) {
        return null;
    }
}
