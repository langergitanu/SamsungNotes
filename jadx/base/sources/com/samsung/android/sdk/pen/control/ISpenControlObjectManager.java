package com.samsung.android.sdk.pen.control;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003NOPJ\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0007H&J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0007H&J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0012\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H&J\u0012\u0010(\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010)H&J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u000eH&J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u000eH&J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u000eH&J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u000eH&J\u0010\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u000eH&J\u0010\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u000eH&J\u0010\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000eH&J@\u00107\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u000108j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`92\u001e\u0010:\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u000108j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`9H&JN\u0010?\u001a\u0004\u0018\u00010\u00192\b\u0010@\u001a\u0004\u0018\u00010\u00192\b\u0010A\u001a\u0004\u0018\u00010<2\u001e\u0010:\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u000108j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`92\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000bH&J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u000eH&J \u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000eH&J\b\u0010I\u001a\u00020\u000eH&J\b\u0010J\u001a\u00020\u0007H&J\u0012\u0010K\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010MH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u0004\u0018\u00010 X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010;\u001a\u0004\u0018\u00010<X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "", "nativeHandle", "", "getNativeHandle", "()J", "close", "", "closeControl", "setScreenSize", "width", "", "height", "onTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "updateObjectRuntimePos", "isObjectRuntimePlaying", "()Z", "playVideo", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "stopPlayingVideo", "selectedData", "Landroid/graphics/Bitmap;", "getSelectedData", "()Landroid/graphics/Bitmap;", "scaleX", "", "scaleY", "pastePosition", "Landroid/graphics/PointF;", "getPastePosition", "()Landroid/graphics/PointF;", "setPastePosition", "(Landroid/graphics/PointF;)V", "setObjectListener", "l", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "setControlActionListener", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$ControlActionListener;", "setImageEditable", "editable", "setControlBitmap", "enable", "setFitWidth", "isFitWidth", "setLasso", "isLasso", "setLassoCrop", "isCrop", "setRectangleCrop", "setShapeSegment", "isShapeSegment", "getCombinedObjectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "objectList", "selectedRect", "Landroid/graphics/RectF;", "getSelectedRect", "()Landroid/graphics/RectF;", "getMaskedBitmap", "srcBitmap", "rect", "internalMaskColor", "externalMaskColor", "setFocus", "focus", "setFocusCell", "row", "column", "hasFocus", "setControlStyleInfoAsDefault", "setControlStyleInfo", "info", "Lcom/samsung/android/sdk/pen/control/SpenControlStyleInfo;", "ControlActionListener", "CoordinateInfo", "RotateChangedInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenControlObjectManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$ControlActionListener;", "", "onRequestCoordinateInfo", "", "coordinateInfo", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$CoordinateInfo;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "onRequestMoveIntoScreen", "onRequestSelectObject", "isFloatingViewShown", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ControlActionListener {
        boolean isFloatingViewShown();

        void onRequestCoordinateInfo(@Nullable CoordinateInfo coordinateInfo, @Nullable SpenObjectBase objectBase);

        void onRequestMoveIntoScreen(@Nullable SpenObjectBase objectBase);

        void onRequestSelectObject(@Nullable SpenObjectBase objectBase);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$CoordinateInfo;", "", "<init>", "()V", "pan", "Landroid/graphics/PointF;", "zoomRatio", "", "startPos", "reset", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class CoordinateInfo {

        @JvmField
        @NotNull
        public PointF pan = new PointF();

        @JvmField
        @NotNull
        public PointF startPos = new PointF();

        @JvmField
        public float zoomRatio;

        public CoordinateInfo() {
            reset();
        }

        public final void reset() {
            this.pan.set(0.0f, 0.0f);
            this.zoomRatio = 1.0f;
            this.startPos.set(0.0f, 0.0f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$RotateChangedInfo;", "", "<init>", "()V", "angle", "", "getAngle", "()F", "setAngle", "(F)V", "controlRect", "Landroid/graphics/RectF;", "getControlRect", "()Landroid/graphics/RectF;", "setControlRect", "(Landroid/graphics/RectF;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RotateChangedInfo {
        private float angle;

        @Nullable
        private RectF controlRect;

        public final float getAngle() {
            return this.angle;
        }

        @Nullable
        public final RectF getControlRect() {
            return this.controlRect;
        }

        public final void setAngle(float f) {
            this.angle = f;
        }

        public final void setControlRect(@Nullable RectF rectF) {
            this.controlRect = rectF;
        }
    }

    void close();

    void closeControl();

    @Nullable
    ArrayList<SpenObjectBase> getCombinedObjectList(@Nullable ArrayList<SpenObjectBase> objectList);

    @Nullable
    Bitmap getMaskedBitmap(@Nullable Bitmap srcBitmap, @Nullable RectF rect, @Nullable ArrayList<SpenObjectBase> objectList, int internalMaskColor, int externalMaskColor);

    long getNativeHandle();

    @Nullable
    PointF getPastePosition();

    @Nullable
    Bitmap getSelectedData();

    @Nullable
    Bitmap getSelectedData(float scaleX, float scaleY);

    @Nullable
    RectF getSelectedRect();

    boolean hasFocus();

    boolean isObjectRuntimePlaying();

    boolean onTouch(@Nullable MotionEvent motionEvent);

    boolean playVideo(@Nullable SpenObjectBase objectBase);

    void setControlActionListener(@Nullable ControlActionListener l);

    void setControlBitmap(boolean enable);

    void setControlStyleInfo(@Nullable SpenControlStyleInfo info);

    void setControlStyleInfoAsDefault();

    void setFitWidth(boolean isFitWidth);

    void setFocus(boolean focus);

    void setFocusCell(int row, int column, boolean focus);

    void setImageEditable(boolean editable);

    void setLasso(boolean isLasso);

    void setLassoCrop(boolean isCrop);

    void setObjectListener(@Nullable SpenControlObjectListener l);

    void setPastePosition(@Nullable PointF pointF);

    void setRectangleCrop(boolean isCrop);

    void setScreenSize(int width, int height);

    void setShapeSegment(boolean isShapeSegment);

    void stopPlayingVideo();

    void updateObjectRuntimePos();
}
