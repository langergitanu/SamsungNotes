package com.samsung.android.sdk.pen.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.AbstractC0622a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.control.runtimeObject.WritingObjectRuntimeVideo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 s2\u00020\u0001:\u0001sB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020$H\u0016J\u0012\u00101\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u00103\u001a\u00020$H\u0016J\u001a\u00106\u001a\u0004\u0018\u0001052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0016J\u0012\u0010A\u001a\u00020$2\b\u0010B\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010C\u001a\u00020$2\b\u0010B\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020+H\u0016J\u0010\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020+H\u0016J\u0010\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020+H\u0016J\u0010\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020+H\u0016J\u0010\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020+H\u0016J\u0010\u0010N\u001a\u00020$2\u0006\u0010M\u001a\u00020+H\u0016J\u0010\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020+H\u0016J@\u0010Q\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010Rj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`S2\u001e\u0010T\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010Rj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`SH\u0016JN\u0010Y\u001a\u0004\u0018\u0001052\b\u0010Z\u001a\u0004\u0018\u0001052\b\u0010[\u001a\u0004\u0018\u00010V2\u001e\u0010T\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010Rj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u0001`S2\u0006\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u00020(H\u0016J\u0010\u0010^\u001a\u00020$2\u0006\u0010_\u001a\u00020+H\u0016J \u0010`\u001a\u00020$2\u0006\u0010a\u001a\u00020(2\u0006\u0010b\u001a\u00020(2\u0006\u0010_\u001a\u00020+H\u0016J\b\u0010c\u001a\u00020+H\u0016J\b\u0010d\u001a\u00020$H\u0016J\u0012\u0010e\u001a\u00020$2\b\u0010f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010g\u001a\u00020+2\u0006\u0010h\u001a\u00020(2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0018\u0010i\u001a\u00020+2\u0006\u0010h\u001a\u00020(2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0010\u0010j\u001a\u00020+2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0010\u0010k\u001a\u00020+2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0010\u0010l\u001a\u00020+2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0018\u0010m\u001a\u00020+2\u0006\u00102\u001a\u00020\u001a2\u0006\u0010[\u001a\u00020VH\u0002J\u0018\u0010n\u001a\u00020+2\u0006\u00102\u001a\u00020\u001a2\u0006\u0010[\u001a\u00020VH\u0002J\u0018\u0010o\u001a\u00020+2\u0006\u00102\u001a\u00020\u001a2\u0006\u0010[\u001a\u00020VH\u0002J\u0010\u0010q\u001a\u00020$2\u0006\u0010r\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R(\u0010<\u001a\u0004\u0018\u00010\u00122\b\u0010;\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010U\u001a\u0004\u0018\u00010V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010p\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u00100¨\u0006t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "<init>", "()V", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", SearchConstants.TargetContents.TAG, "", "TIME_DELAY_UPDATE", "", "value", "nativeHandle", "getNativeHandle", "()J", "mPastePosition", "Landroid/graphics/PointF;", "mControlObjectListener", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "mContext", "mView", "mObjectRuntimeVideo", "Lcom/samsung/android/sdk/pen/control/runtimeObject/WritingObjectRuntimeVideo;", "mPlayingObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "mControlActionListener", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager$ControlActionListener;", "mHandler", "Landroid/os/Handler;", "mControlStyleInfo", "Lcom/samsung/android/sdk/pen/control/SpenControlStyleInfo;", "mUpdateRunnable", "Ljava/lang/Runnable;", "close", "", "closeControl", "setScreenSize", "width", "", "height", "onTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "updateObjectRuntimePos", "isObjectRuntimePlaying", "()Z", "playVideo", "objectBase", "stopPlayingVideo", "selectedData", "Landroid/graphics/Bitmap;", "getSelectedData", "()Landroid/graphics/Bitmap;", "scaleX", "", "scaleY", "position", "pastePosition", "getPastePosition", "()Landroid/graphics/PointF;", "setPastePosition", "(Landroid/graphics/PointF;)V", "setObjectListener", "l", "setControlActionListener", "setImageEditable", "editable", "setControlBitmap", "enable", "setFitWidth", "isFitWidth", "setLasso", "isLasso", "setLassoCrop", "isCrop", "setRectangleCrop", "setShapeSegment", "isShapeSegment", "getCombinedObjectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "objectList", "selectedRect", "Landroid/graphics/RectF;", "getSelectedRect", "()Landroid/graphics/RectF;", "getMaskedBitmap", "srcBitmap", "rect", "internalMaskColor", "externalMaskColor", "setFocus", "focus", "setFocusCell", "row", "column", "hasFocus", "setControlStyleInfoAsDefault", "setControlStyleInfo", "info", "onItemClicked", "toolType", "onItemLongClicked", "onItemClickedOfSelected", "onItemLongClickedOfSelected", "onItemButtonClicked", "onItemShowContextAllCellsMenu", "onItemShowContextRowMenu", "onItemShowContextColumnMenu", "isFloatingViewShown", "announceForAccessibility", "message", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenControlObjectManager implements ISpenControlObjectManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String TAG;
    private final long TIME_DELAY_UPDATE;

    @Nullable
    private Context mContext;

    @Nullable
    private ISpenControlObjectManager.ControlActionListener mControlActionListener;

    @Nullable
    private SpenControlObjectListener mControlObjectListener;

    @NotNull
    private SpenControlStyleInfo mControlStyleInfo;

    @Nullable
    private Handler mHandler;

    @Nullable
    private WritingObjectRuntimeVideo mObjectRuntimeVideo;

    @NotNull
    private final PointF mPastePosition;

    @Nullable
    private SpenObjectBase mPlayingObject;

    @NotNull
    private final Runnable mUpdateRunnable;

    @Nullable
    private View mView;
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0019\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fH\u0083 J\u0019\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000fH\u0083 J\u0019\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000fH\u0083 J\u0019\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000fH\u0083 J\u0019\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000fH\u0083 J\u0019\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000fH\u0083 JI\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 2\u0006\u0010\n\u001a\u00020\u00052\u001e\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` H\u0083 J]\u0010\"\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\r2\u001e\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0083 J\u0019\u0010)\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000fH\u0083 J)\u0010+\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020'2\u0006\u0010*\u001a\u00020\u000fH\u0083 J\u0011\u0010.\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0013\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0011\u00101\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0019\u00102\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u00103\u001a\u000204H\u0083 ¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager$Companion;", "", "<init>", "()V", "Native_init", "", "manager", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "Native_finalize", "", "nativePtr", "Native_closeControl", "Native_getSelectedRect", "Landroid/graphics/RectF;", "Native_getSelectedData", "", "bitmap", "Landroid/graphics/Bitmap;", "Native_setControlBitmap", "enable", "Native_setFitWidth", "isFitWidth", "Native_setLasso", "isLasso", "Native_setLassoCrop", "isCrop", "Native_setRectangleCrop", "Native_setShapeSegment", "isShapeSegment", "Native_getCombinedObjectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "objectList", "Native_getMaskedBitmapByObjectList", "srcBitmap", "dstBitmap", "rect", "internalMaskColor", "", "externalMaskColor", "Native_setFocus", "focus", "Native_setFocusCell", "row", "column", "Native_hasFocus", "Native_getPastePosition", "Landroid/graphics/PointF;", "Native_setControlStyleInfoAsDefault", "Native_setControStyleInfo", "info", "Lcom/samsung/android/sdk/pen/control/SpenControlStyleInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_closeControl(long nativePtr) {
            SpenControlObjectManager.Native_closeControl(nativePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativePtr) {
            SpenControlObjectManager.Native_finalize(nativePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> Native_getCombinedObjectList(long nativePtr, ArrayList<SpenObjectBase> objectList) {
            return SpenControlObjectManager.Native_getCombinedObjectList(nativePtr, objectList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_getMaskedBitmapByObjectList(long nativePtr, Bitmap srcBitmap, Bitmap dstBitmap, RectF rect, ArrayList<SpenObjectBase> objectList, int internalMaskColor, int externalMaskColor) {
            return SpenControlObjectManager.Native_getMaskedBitmapByObjectList(nativePtr, srcBitmap, dstBitmap, rect, objectList, internalMaskColor, externalMaskColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_getPastePosition(long nativePtr) {
            return SpenControlObjectManager.Native_getPastePosition(nativePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_getSelectedData(long nativePtr, Bitmap bitmap) {
            return SpenControlObjectManager.Native_getSelectedData(nativePtr, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getSelectedRect(long nativePtr) {
            return SpenControlObjectManager.Native_getSelectedRect(nativePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasFocus(long nativePtr) {
            return SpenControlObjectManager.Native_hasFocus(nativePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenControlObjectManager manager) {
            return SpenControlObjectManager.Native_init(manager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setControStyleInfo(long nativePtr, SpenControlStyleInfo info) {
            SpenControlObjectManager.Native_setControStyleInfo(nativePtr, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setControlBitmap(long nativePtr, boolean enable) {
            SpenControlObjectManager.Native_setControlBitmap(nativePtr, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setControlStyleInfoAsDefault(long nativePtr) {
            SpenControlObjectManager.Native_setControlStyleInfoAsDefault(nativePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFitWidth(long nativePtr, boolean isFitWidth) {
            SpenControlObjectManager.Native_setFitWidth(nativePtr, isFitWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFocus(long nativePtr, boolean focus) {
            SpenControlObjectManager.Native_setFocus(nativePtr, focus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFocusCell(long nativePtr, int row, int column, boolean focus) {
            SpenControlObjectManager.Native_setFocusCell(nativePtr, row, column, focus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLasso(long nativePtr, boolean isLasso) {
            SpenControlObjectManager.Native_setLasso(nativePtr, isLasso);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLassoCrop(long nativePtr, boolean isCrop) {
            SpenControlObjectManager.Native_setLassoCrop(nativePtr, isCrop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setRectangleCrop(long nativePtr, boolean isCrop) {
            SpenControlObjectManager.Native_setRectangleCrop(nativePtr, isCrop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setShapeSegment(long nativePtr, boolean isShapeSegment) {
            SpenControlObjectManager.Native_setShapeSegment(nativePtr, isShapeSegment);
        }

        private Companion() {
        }
    }

    public SpenControlObjectManager() {
        this.TAG = "SpenControlObjectManager";
        this.TIME_DELAY_UPDATE = 100L;
        this.mPastePosition = new PointF();
        this.mControlStyleInfo = new SpenControlStyleInfo();
        this.mUpdateRunnable = new RunnableC4617a(this, 12);
        this.nativeHandle = INSTANCE.Native_init(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_closeControl(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> Native_getCombinedObjectList(long j, ArrayList<SpenObjectBase> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_getMaskedBitmapByObjectList(long j, Bitmap bitmap, Bitmap bitmap2, RectF rectF, ArrayList<SpenObjectBase> arrayList, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native PointF Native_getPastePosition(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_getSelectedData(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getSelectedRect(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasFocus(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenControlObjectManager spenControlObjectManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setControStyleInfo(long j, SpenControlStyleInfo spenControlStyleInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setControlBitmap(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setControlStyleInfoAsDefault(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFitWidth(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFocus(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFocusCell(long j, int i, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLasso(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLassoCrop(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRectangleCrop(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setShapeSegment(long j, boolean z);

    private final void announceForAccessibility(String message) {
        View view = this.mView;
        if (view != null) {
            view.announceForAccessibility(message);
        }
    }

    private final boolean isFloatingViewShown() {
        ISpenControlObjectManager.ControlActionListener controlActionListener = this.mControlActionListener;
        if (controlActionListener != null) {
            return controlActionListener.isFloatingViewShown();
        }
        return false;
    }

    private final boolean onItemButtonClicked(SpenObjectBase objectBase) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemButtonClicked(objectBase);
        }
        return false;
    }

    private final boolean onItemClicked(int toolType, SpenObjectBase objectBase) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemClicked(toolType, objectBase);
        }
        return false;
    }

    private final boolean onItemClickedOfSelected(SpenObjectBase objectBase) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onSelectedItemClicked(objectBase);
        }
        return false;
    }

    private final boolean onItemLongClicked(int toolType, SpenObjectBase objectBase) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemLongClicked(toolType, objectBase);
        }
        return false;
    }

    private final boolean onItemLongClickedOfSelected(SpenObjectBase objectBase) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onSelectedItemLongClicked(objectBase);
        }
        return false;
    }

    private final boolean onItemShowContextAllCellsMenu(SpenObjectBase objectBase, RectF rect) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemShowContextAllCellsMenu(objectBase, rect);
        }
        return false;
    }

    private final boolean onItemShowContextColumnMenu(SpenObjectBase objectBase, RectF rect) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemShowContextColumnMenu(objectBase, rect);
        }
        return false;
    }

    private final boolean onItemShowContextRowMenu(SpenObjectBase objectBase, RectF rect) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemShowContextRowMenu(objectBase, rect);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void close() {
        Log.d(this.TAG, "SpenControlObjectManager close");
        WritingObjectRuntimeVideo writingObjectRuntimeVideo = this.mObjectRuntimeVideo;
        if (writingObjectRuntimeVideo != null) {
            Intrinsics.checkNotNull(writingObjectRuntimeVideo);
            writingObjectRuntimeVideo.close();
            this.mObjectRuntimeVideo = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
        INSTANCE.Native_finalize(getNativeHandle());
        this.nativeHandle = 0L;
        this.mContext = null;
        this.mView = null;
        this.mPlayingObject = null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void closeControl() {
        if (getNativeHandle() == 0) {
            return;
        }
        Log.d(this.TAG, "SpenControlObjectManager closeControl");
        INSTANCE.Native_closeControl(getNativeHandle());
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public ArrayList<SpenObjectBase> getCombinedObjectList(@Nullable ArrayList<SpenObjectBase> objectList) {
        if (getNativeHandle() != 0) {
            return INSTANCE.Native_getCombinedObjectList(getNativeHandle(), objectList);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public Bitmap getMaskedBitmap(@Nullable Bitmap srcBitmap, @Nullable RectF rect, @Nullable ArrayList<SpenObjectBase> objectList, int internalMaskColor, int externalMaskColor) {
        if (getNativeHandle() == 0) {
            return null;
        }
        Integer numValueOf = rect != null ? Integer.valueOf((int) rect.width()) : null;
        Intrinsics.checkNotNull(numValueOf);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(numValueOf.intValue(), (int) rect.height(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (INSTANCE.Native_getMaskedBitmapByObjectList(getNativeHandle(), srcBitmap, bitmapCreateBitmap, rect, objectList, internalMaskColor, externalMaskColor)) {
            return bitmapCreateBitmap;
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public PointF getPastePosition() {
        if (getNativeHandle() == 0) {
            return null;
        }
        PointF pointF = this.mPastePosition;
        if (pointF.x == 0.0f && pointF.y == 0.0f) {
            return INSTANCE.Native_getPastePosition(getNativeHandle());
        }
        PointF pointF2 = this.mPastePosition;
        return new PointF(pointF2.x, pointF2.y);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public Bitmap getSelectedData() {
        return getSelectedData(1.0f, 1.0f);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public RectF getSelectedRect() {
        if (getNativeHandle() == 0) {
            return null;
        }
        return INSTANCE.Native_getSelectedRect(getNativeHandle());
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean hasFocus() {
        return getNativeHandle() != 0 && INSTANCE.Native_hasFocus(getNativeHandle());
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean isObjectRuntimePlaying() {
        WritingObjectRuntimeVideo writingObjectRuntimeVideo = this.mObjectRuntimeVideo;
        if (writingObjectRuntimeVideo != null) {
            return writingObjectRuntimeVideo.isPlay();
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean onTouch(@Nullable MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        stopPlayingVideo();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public boolean playVideo(@Nullable final SpenObjectBase objectBase) {
        if (getNativeHandle() == 0) {
            return false;
        }
        String extraDataString = objectBase != null ? objectBase.getExtraDataString("VideoPath") : null;
        if (extraDataString == null || extraDataString.length() == 0) {
            Log.d(this.TAG, "playVideo : Invalid file path");
            return false;
        }
        File file = new File(extraDataString);
        Log.d(this.TAG, "playVideo : Video path = " + extraDataString);
        if (!file.exists()) {
            Log.d(this.TAG, "playVideo : File does not exist");
            return false;
        }
        if (this.mContext == null || this.mView == null) {
            Log.d(this.TAG, "playVideo : Context or View is null");
            return false;
        }
        this.mPlayingObject = objectBase;
        if (this.mObjectRuntimeVideo == null) {
            Context context = this.mContext;
            View view = this.mView;
            ViewParent parent = view != null ? view.getParent() : null;
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            this.mObjectRuntimeVideo = new WritingObjectRuntimeVideo(context, (ViewGroup) parent);
        }
        ISpenControlObjectManager.CoordinateInfo coordinateInfo = new ISpenControlObjectManager.CoordinateInfo();
        ISpenControlObjectManager.ControlActionListener controlActionListener = this.mControlActionListener;
        if (controlActionListener != null) {
            controlActionListener.onRequestMoveIntoScreen(objectBase);
            controlActionListener.onRequestCoordinateInfo(coordinateInfo, objectBase);
        }
        WritingObjectRuntimeVideo writingObjectRuntimeVideo = this.mObjectRuntimeVideo;
        if (writingObjectRuntimeVideo == null) {
            return true;
        }
        writingObjectRuntimeVideo.setPosition(coordinateInfo.pan, coordinateInfo.zoomRatio, coordinateInfo.startPos);
        writingObjectRuntimeVideo.setActionListener(new WritingObjectRuntimeVideo.ActionListener() { // from class: com.samsung.android.sdk.pen.control.SpenControlObjectManager$playVideo$2$1
            @Override // com.samsung.android.sdk.pen.control.runtimeObject.WritingObjectRuntimeVideo.ActionListener
            public void onCloseControl() {
                this.this$0.closeControl();
            }

            @Override // com.samsung.android.sdk.pen.control.runtimeObject.WritingObjectRuntimeVideo.ActionListener
            public void onCompleted() {
                ISpenControlObjectManager.ControlActionListener controlActionListener2 = this.this$0.mControlActionListener;
                if (controlActionListener2 != null) {
                    controlActionListener2.onRequestSelectObject(objectBase);
                }
            }

            @Override // com.samsung.android.sdk.pen.control.runtimeObject.WritingObjectRuntimeVideo.ActionListener
            public void onUpdate() {
            }
        });
        if (writingObjectRuntimeVideo.start(objectBase)) {
            return true;
        }
        Log.d(this.TAG, "playVideo : Failed to start the video");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlActionListener(@Nullable ISpenControlObjectManager.ControlActionListener l) {
        this.mControlActionListener = l;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlBitmap(boolean enable) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setControlBitmap(getNativeHandle(), enable);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlStyleInfo(@Nullable SpenControlStyleInfo info) {
        if (getNativeHandle() == 0 || info == null) {
            return;
        }
        this.mControlStyleInfo = new SpenControlStyleInfo(info);
        INSTANCE.Native_setControStyleInfo(getNativeHandle(), this.mControlStyleInfo);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setControlStyleInfoAsDefault() {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setControlStyleInfoAsDefault(getNativeHandle());
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setFitWidth(boolean isFitWidth) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setFitWidth(getNativeHandle(), isFitWidth);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setFocus(boolean focus) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setFocus(getNativeHandle(), focus);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setFocusCell(int row, int column, boolean focus) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setFocusCell(getNativeHandle(), row, column, focus);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setImageEditable(boolean editable) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setRectangleCrop(getNativeHandle(), editable);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setLasso(boolean isLasso) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setLasso(getNativeHandle(), isLasso);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setLassoCrop(boolean isCrop) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setLassoCrop(getNativeHandle(), isCrop);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setObjectListener(@Nullable SpenControlObjectListener l) {
        this.mControlObjectListener = l;
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setPastePosition(@Nullable PointF pointF) {
        if (getNativeHandle() == 0) {
            return;
        }
        Log.d(this.TAG, "SpenControlObjectManager setPastePosition : " + pointF);
        PointF pointF2 = this.mPastePosition;
        Intrinsics.checkNotNull(pointF);
        pointF2.set(pointF);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setRectangleCrop(boolean isCrop) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setRectangleCrop(getNativeHandle(), isCrop);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setScreenSize(int width, int height) {
        Handler handler;
        if (!isObjectRuntimePlaying() || (handler = this.mHandler) == null) {
            return;
        }
        handler.removeCallbacks(this.mUpdateRunnable);
        handler.postDelayed(this.mUpdateRunnable, this.TIME_DELAY_UPDATE);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void setShapeSegment(boolean isShapeSegment) {
        if (getNativeHandle() == 0) {
            return;
        }
        INSTANCE.Native_setShapeSegment(getNativeHandle(), isShapeSegment);
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void stopPlayingVideo() {
        WritingObjectRuntimeVideo writingObjectRuntimeVideo;
        Log.d(this.TAG, "playVideo : Stop playing video!");
        WritingObjectRuntimeVideo writingObjectRuntimeVideo2 = this.mObjectRuntimeVideo;
        if (writingObjectRuntimeVideo2 == null || !writingObjectRuntimeVideo2.isPlay() || (writingObjectRuntimeVideo = this.mObjectRuntimeVideo) == null) {
            return;
        }
        writingObjectRuntimeVideo.stop();
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    public void updateObjectRuntimePos() {
        WritingObjectRuntimeVideo writingObjectRuntimeVideo = this.mObjectRuntimeVideo;
        if (writingObjectRuntimeVideo != null) {
            Log.d(this.TAG, "SpenControlObjectManager updateObjectRuntimePos");
            ISpenControlObjectManager.CoordinateInfo coordinateInfo = new ISpenControlObjectManager.CoordinateInfo();
            ISpenControlObjectManager.ControlActionListener controlActionListener = this.mControlActionListener;
            if (controlActionListener != null) {
                controlActionListener.onRequestCoordinateInfo(coordinateInfo, this.mPlayingObject);
            }
            writingObjectRuntimeVideo.setPosition(coordinateInfo.pan, coordinateInfo.zoomRatio, coordinateInfo.startPos);
            writingObjectRuntimeVideo.updateRect();
        }
    }

    @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager
    @Nullable
    public Bitmap getSelectedData(float scaleX, float scaleY) {
        if (getNativeHandle() == 0) {
            return null;
        }
        Companion companion = INSTANCE;
        RectF rectFNative_getSelectedRect = companion.Native_getSelectedRect(getNativeHandle());
        if (rectFNative_getSelectedRect.isEmpty()) {
            return null;
        }
        int iWidth = (int) (rectFNative_getSelectedRect.width() * scaleX);
        int iHeight = (int) (rectFNative_getSelectedRect.height() * scaleY);
        Log.d(this.TAG, AbstractC0622a.m1164j(iWidth, (int) (rectFNative_getSelectedRect.height() * scaleY), "SpenControlObjectManager getSelectedData [", " ", "]"));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (companion.Native_getSelectedData(getNativeHandle(), bitmapCreateBitmap)) {
            return bitmapCreateBitmap;
        }
        return null;
    }

    public SpenControlObjectManager(@Nullable Context context, @Nullable View view) {
        this.TAG = "SpenControlObjectManager";
        this.TIME_DELAY_UPDATE = 100L;
        this.mPastePosition = new PointF();
        this.mControlStyleInfo = new SpenControlStyleInfo();
        this.mUpdateRunnable = new RunnableC4617a(this, 12);
        this.nativeHandle = INSTANCE.Native_init(this);
        this.mContext = context;
        this.mView = view;
        this.mHandler = new Handler();
    }
}
