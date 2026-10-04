package com.samsung.android.sdk.pen.painting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingFillColorInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.document.SpenHistoryUpdateInfo;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenEraserChangeListener;
import com.samsung.android.sdk.pen.engine.SpenPenChangeListener;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopSurface;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 º\u00012\u00020\u0001:\u0002º\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020OH\u0017J\u0010\u0010P\u001a\u00020.2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010Q\u001a\u00020.2\u0006\u0010N\u001a\u00020OH\u0016J0\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\nH\u0014J(\u0010Y\u001a\u00020S2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\nH\u0014J\u0010\u0010^\u001a\u00020S2\u0006\u0010_\u001a\u00020\nH\u0014J\u0010\u0010`\u001a\u00020S2\u0006\u0010a\u001a\u00020.H\u0016J\u0010\u0010b\u001a\u00020S2\u0006\u0010c\u001a\u00020\nH\u0016J\b\u0010d\u001a\u00020SH\u0014J\b\u0010e\u001a\u00020SH\u0016J\u0010\u0010f\u001a\u00020S2\b\u0010g\u001a\u0004\u0018\u00010hJ\u0010\u0010i\u001a\u00020S2\b\u0010g\u001a\u0004\u0018\u00010jJ\u0016\u0010k\u001a\u00020S2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nJ\u000e\u0010n\u001a\u00020\n2\u0006\u0010l\u001a\u00020\nJ\u001a\u0010o\u001a\u00020.2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020.H\u0016J\u001e\u0010s\u001a\u00020S2\u0006\u0010t\u001a\u0002042\u0006\u0010u\u001a\u0002042\u0006\u0010v\u001a\u000204J\u000e\u0010w\u001a\u00020.2\u0006\u0010t\u001a\u000204J\u000e\u0010x\u001a\u00020.2\u0006\u0010t\u001a\u000204J&\u0010y\u001a\u00020S2\u0006\u0010U\u001a\u0002042\u0006\u0010V\u001a\u0002042\u0006\u0010W\u001a\u0002042\u0006\u0010X\u001a\u000204J\u0016\u0010z\u001a\u00020S2\u0006\u0010{\u001a\u0002042\u0006\u0010|\u001a\u000204J\b\u0010}\u001a\u00020SH\u0007J\b\u0010~\u001a\u00020SH\u0007J\u0006\u0010\u007f\u001a\u00020SJ\"\u0010\u0080\u0001\u001a\u00020S2\u0013\u0010\u0081\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u0001\u0018\u00010\u0082\u0001¢\u0006\u0003\u0010\u0084\u0001J\"\u0010\u0085\u0001\u001a\u00020S2\u0013\u0010\u0081\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u0001\u0018\u00010\u0082\u0001¢\u0006\u0003\u0010\u0084\u0001J\u0012\u0010\u0086\u0001\u001a\u00020S2\t\u0010g\u001a\u0005\u0018\u00010\u0087\u0001J\u0012\u0010\u0088\u0001\u001a\u00020S2\t\u0010g\u001a\u0005\u0018\u00010\u0087\u0001J\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u0002042\u0007\u0010\u008c\u0001\u001a\u00020\nJ\u0013\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u008e\u0001\u001a\u00020.J\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u0002042\u0007\u0010\u0090\u0001\u001a\u00020\nJ\u0016\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008a\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J-\u0010\u0094\u0001\u001a\u00020S2\u0007\u0010\u0095\u0001\u001a\u00020\n2\u0007\u0010\u0096\u0001\u001a\u00020\n2\u0007\u0010\u0097\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0099\u0001\u001a\u00020S2\t\u0010g\u001a\u0005\u0018\u00010\u009a\u0001J!\u0010\u009b\u0001\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0007\u0010\u009c\u0001\u001a\u00020\n2\u0007\u0010\u009d\u0001\u001a\u00020\nJ\u0012\u0010\u009e\u0001\u001a\u00020S2\t\u0010g\u001a\u0005\u0018\u00010\u009f\u0001J\u0010\u0010 \u0001\u001a\u00020S2\u0007\u0010¡\u0001\u001a\u00020.J.\u0010¢\u0001\u001a\u0005\u0018\u00010\u0093\u00012\u0007\u0010£\u0001\u001a\u00020\n2\u0007\u0010¤\u0001\u001a\u00020\n2\u0007\u0010¥\u0001\u001a\u00020\n2\u0007\u0010¦\u0001\u001a\u00020\nJ%\u0010§\u0001\u001a\u00020.2\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010©\u0001\u001a\u00020\n2\u0007\u0010ª\u0001\u001a\u00020\nJ\u000f\u0010«\u0001\u001a\u00020S2\u0006\u0010-\u001a\u00020.J:\u0010¬\u0001\u001a\u00020.2\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u008a\u00012\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u0093\u00012\u0007\u0010®\u0001\u001a\u00020\n2\u0007\u0010¯\u0001\u001a\u00020\n2\u0007\u0010°\u0001\u001a\u00020.J%\u0010¬\u0001\u001a\u00020.2\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010±\u0001\u001a\u00020\n2\u0007\u0010°\u0001\u001a\u00020.J\u0010\u0010²\u0001\u001a\u00020.2\u0007\u0010³\u0001\u001a\u00020.J\u0010\u0010´\u0001\u001a\u00020S2\u0007\u0010³\u0001\u001a\u00020.J\u0007\u0010µ\u0001\u001a\u00020SJ\u0007\u0010¶\u0001\u001a\u00020SJ\u0012\u0010·\u0001\u001a\u00020S2\t\u0010g\u001a\u0005\u0018\u00010¸\u0001J\u0011\u0010¹\u0001\u001a\u00020S2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b,\u0010*R$\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b8\u00106R\u0011\u00109\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b:\u00106R(\u0010=\u001a\u0004\u0018\u00010<2\b\u0010;\u001a\u0004\u0018\u00010<8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bC\u0010?R$\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010*\"\u0004\bG\u0010HR$\u0010I\u001a\u00020.2\u0006\u0010-\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R$\u0010K\u001a\u00020.2\u0006\u0010-\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u00100\"\u0004\bL\u00102¨\u0006»\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewImpl", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewImpl;", "mHolderCallback", "Landroid/view/SurfaceHolder$Callback;", "mOrientationListener", "Landroid/view/OrientationEventListener;", "mSPenDrawLoopSurface", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopSurface;", "info", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "penSettingInfo", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "eraserSettingInfo", "getEraserSettingInfo", "setEraserSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;", "fillColorInfo", "getFillColorInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;", "setFillColorInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;)V", "gestureController", "Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController;", "getGestureController", "()Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController;", "canvasWidth", "getCanvasWidth", "()I", "canvasHeight", "getCanvasHeight", "enable", "", "isZoomable", "()Z", "setZoomable", "(Z)V", "zoomScale", "", "getZoomScale", "()F", "maxZoomScale", "getMaxZoomScale", "minZoomScale", "getMinZoomScale", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", "color", "blankColor", "getBlankColor", "setBlankColor", "(I)V", "isToolTipEnabled", "setToolTipEnabled", "isPaperEnabled", "setPaperEnabled", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onGenericMotionEvent", "onHoverEvent", "onLayout", "", "changed", "left", "top", "right", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onWindowVisibilityChanged", "visibility", "onWindowFocusChanged", "hasWindowFocus", "onScreenStateChanged", "screenState", "onAttachedToWindow", "close", "setPenChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenPenChangeListener;", "setEraserChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenEraserChangeListener;", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setPaintingDoc", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "isUpdate", "setZoomScale", WiggleAnimationConfig.KEY_SCALE, "centerX", "centerY", "setMaxZoomScale", "setMinZoomScale", "setMargin", "setDelta", "deltaX", "deltaY", "commitStroke", "cancelStroke", Constants.ARG_UPDATE, "updateUndo", "userDataList", "", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "([Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;)V", "updateRedo", "setPreTouchListener", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "setTouchListener", "capturePage", "Landroid/graphics/Bitmap;", "ratio", "option", "captureCurrentView", "includeBlank", "captureLayer", "layer_id", "captureRect", "rect", "Landroid/graphics/RectF;", "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "setForceStretchView", "width", "height", "setColorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "setMouseWheelZoomEnabled", "wheelZoomEnabled", "getValidRect", "lMargin", "tMargin", "rMargin", "bMargin", "setSketchImage", "bitmap", "stretchMode", "opacity", "setColoringForegroundEnabled", "setLayerBitmap", "dstRect", "fullBitmapWidth", "fullBitmapHeight", "isClearCurrentLayer", "wrappingmode", "setFrontBufferRenderingEnabled", "enabled", "setPredictionEnabled", "startActionMode", "stopActionMode", "setContextMenuListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "construct", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPaintingSurfaceView extends SurfaceView {
    public static final int BACKGROUND_IMAGE_MODE_CENTER = 0;
    public static final int BACKGROUND_IMAGE_MODE_FIT = 2;
    public static final int BACKGROUND_IMAGE_MODE_STRETCH = 1;
    public static final int BACKGROUND_IMAGE_MODE_TILE = 3;
    public static final int CAPTURE_ALL = 286261521;
    public static final int CAPTURE_BACKGROUND_COLOR = 268435456;
    public static final int CAPTURE_BACKGROUND_IMAGE = 16777216;
    public static final int CAPTURE_FOREGROUND_ALL = 273;
    private static final int CAPTURE_IMAGE = 256;
    public static final int CAPTURE_PAPER = 1048576;
    private static final int CAPTURE_STROKE = 1;
    private static final int CAPTURE_TEXTBOX = 16;

    @NotNull
    private static final String TAG = "SpenPaintingView";

    @Nullable
    private SurfaceHolder.Callback mHolderCallback;

    @Nullable
    private OrientationEventListener mOrientationListener;

    @Nullable
    private SpenDrawLoopSurface mSPenDrawLoopSurface;

    @Nullable
    private SpenPaintingViewImpl mViewImpl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPaintingSurfaceView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        Log.d(TAG, "construct");
        SPenRecognitionWorker.initializeSelf(context);
        this.mSPenDrawLoopSurface = new SpenDrawLoopSurface();
        SpenDrawLoopSurface spenDrawLoopSurface = this.mSPenDrawLoopSurface;
        Intrinsics.checkNotNull(spenDrawLoopSurface);
        this.mViewImpl = new SpenPaintingViewImpl(context, this, spenDrawLoopSurface);
        SurfaceHolder holder = getHolder();
        SpenDrawLoopSurface spenDrawLoopSurface2 = this.mSPenDrawLoopSurface;
        this.mHolderCallback = spenDrawLoopSurface2;
        holder.addCallback(spenDrawLoopSurface2);
        holder.setFormat(1);
        this.mOrientationListener = new OrientationEventListener(context, this) { // from class: com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView.construct.1
            final /* synthetic */ Context $context;
            final /* synthetic */ SpenPaintingSurfaceView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.$context = context;
                this.this$0 = this;
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                SpenPaintingSurfaceView spenPaintingSurfaceView = this.this$0;
                Context context2 = this.$context;
                synchronized (this) {
                    SpenPaintingViewImpl spenPaintingViewImpl = spenPaintingSurfaceView.mViewImpl;
                    if (spenPaintingViewImpl != null) {
                        Log.i(SpenPaintingSurfaceView.TAG, "onOrientationChanged, orientation = " + orientation);
                        Object systemService = context2.getSystemService("window");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        spenPaintingViewImpl.setScreenOrientation(((WindowManager) systemService).getDefaultDisplay().getRotation());
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        };
        SpenResources.Companion companion = SpenResources.INSTANCE;
        companion.setResources(getResources());
        companion.registerResourceView(this);
    }

    @Deprecated(message = "")
    public final void cancelStroke() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.cancelStroke();
        }
    }

    @Nullable
    public final Bitmap captureCurrentView(boolean includeBlank) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.captureCurrentView(includeBlank);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureLayer(float ratio, int layer_id) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.captureLayer(ratio, layer_id);
        }
        return null;
    }

    @Nullable
    public final Bitmap capturePage(float ratio, int option) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.capturePage(ratio, option);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureRect(@Nullable RectF rect) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.captureRect(rect);
        }
        return null;
    }

    public void close() {
        SpenResources.INSTANCE.unregisterResourceView(this);
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl == null) {
            return;
        }
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.close();
        }
        this.mViewImpl = null;
        getHolder().removeCallback(this.mHolderCallback);
        this.mHolderCallback = null;
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.mOrientationListener = null;
        SpenDrawLoopSurface spenDrawLoopSurface = this.mSPenDrawLoopSurface;
        if (spenDrawLoopSurface != null) {
            spenDrawLoopSurface.close();
        }
    }

    @Deprecated(message = "")
    public final void commitStroke() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.commitStroke();
        }
    }

    public final int getBlankColor() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getBlankColor();
        }
        return 0;
    }

    public final int getCanvasHeight() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getCanvasHeight();
        }
        return 0;
    }

    public final int getCanvasWidth() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getCanvasWidth();
        }
        return 0;
    }

    @NotNull
    public final PointF getDelta() {
        PointF delta;
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        return (spenPaintingViewImpl == null || (delta = spenPaintingViewImpl.getDelta()) == null) ? new PointF(0.0f, 0.0f) : delta;
    }

    @Nullable
    public final SpenSettingPenInfo getEraserSettingInfo() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getMCurEraserInfo();
        }
        return null;
    }

    @Nullable
    public final SpenSettingFillColorInfo getFillColorInfo() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getMCurFillColorInfo();
        }
        return null;
    }

    @Nullable
    public final SpenIPaintingGestureController getGestureController() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getGestureController();
        }
        return null;
    }

    public final float getMaxZoomScale() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getMaxZoomScale();
        }
        return 0.0f;
    }

    public final float getMinZoomScale() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getMinZoomScale();
        }
        return 0.0f;
    }

    @Nullable
    public final PointF getPan() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getPan();
        }
        return null;
    }

    @Nullable
    public final SpenSettingPenInfo getPenSettingInfo() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getMCurPenInfo();
        }
        return null;
    }

    public final int getToolTypeAction(int toolType) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getToolTypeAction(toolType);
        }
        return 0;
    }

    @Nullable
    public final RectF getValidRect(int lMargin, int tMargin, int rMargin, int bMargin) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getValidRect(lMargin, tMargin, rMargin, bMargin);
        }
        return null;
    }

    public final float getZoomScale() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getZoomScale();
        }
        return 0.0f;
    }

    public final boolean isPaperEnabled() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.getIsPaperEnabled();
        }
        return false;
    }

    public final boolean isToolTipEnabled() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.isToolTipEnabled();
        }
        return false;
    }

    public final boolean isZoomable() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.isZoomable();
        }
        return false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.onGenericMotionEvent(event);
        }
        return super.onGenericMotionEvent(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.onHoverEvent(event);
        }
        return false;
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.onLayout(changed, left, top, right, bottom);
        }
        SpenDrawLoopSurface spenDrawLoopSurface = this.mSPenDrawLoopSurface;
        if (spenDrawLoopSurface != null) {
            spenDrawLoopSurface.setScreenSize(right - left, bottom - top);
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        OrientationEventListener orientationEventListener;
        super.onScreenStateChanged(screenState);
        if (getWindowVisibility() == 0 && (orientationEventListener = this.mOrientationListener) != null) {
            if (screenState == 0) {
                Intrinsics.checkNotNull(orientationEventListener);
                orientationEventListener.disable();
            } else {
                Intrinsics.checkNotNull(orientationEventListener);
                orientationEventListener.enable();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.onTouchEvent(event);
        }
        return false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.onWindowFocusChanged(hasWindowFocus);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            OrientationEventListener orientationEventListener = this.mOrientationListener;
            if (orientationEventListener != null) {
                orientationEventListener.enable();
                return;
            }
            return;
        }
        OrientationEventListener orientationEventListener2 = this.mOrientationListener;
        if (orientationEventListener2 != null) {
            orientationEventListener2.disable();
        }
    }

    public final void setBlankColor(int i) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setBlankColor(i);
        }
    }

    public final void setColorPickerListener(@Nullable SpenColorPickerListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setColorPickerListener(listener);
        }
    }

    public final void setColoringForegroundEnabled(boolean enable) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setColoringForegroundEnabled(enable);
        }
    }

    public final void setContextMenuListener(@Nullable SpenContextMenuListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setContextMenuListener(listener);
        }
    }

    public final void setDelta(float deltaX, float deltaY) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setDelta(deltaX, deltaY);
        }
    }

    public final void setEraserChangeListener(@Nullable SpenEraserChangeListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setEraserChangeListener(listener);
        }
    }

    public final void setEraserSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setEraserSettingInfo(spenSettingPenInfo);
        }
    }

    public final void setFillColorInfo(@Nullable SpenSettingFillColorInfo spenSettingFillColorInfo) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setFillColorInfo(spenSettingFillColorInfo);
        }
    }

    public final boolean setForceStretchView(boolean enable, int width, int height) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setForceStretchView(enable, width, height);
        }
        return false;
    }

    public final boolean setFrontBufferRenderingEnabled(boolean enabled) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setFrontBufferRenderingEnabled(enabled);
        }
        return false;
    }

    public final boolean setLayerBitmap(@Nullable Bitmap bitmap, @Nullable RectF dstRect, int fullBitmapWidth, int fullBitmapHeight, boolean isClearCurrentLayer) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setLayerBitmap(bitmap, dstRect, fullBitmapWidth, fullBitmapHeight, isClearCurrentLayer);
        }
        return false;
    }

    public final void setMargin(float left, float top, float right, float bottom) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setMargin(left, top, right, bottom);
        }
    }

    public final boolean setMaxZoomScale(float scale) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setMaxZoomScale(scale);
        }
        return false;
    }

    public final boolean setMinZoomScale(float scale) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setMinZoomScale(scale);
        }
        return false;
    }

    public final void setMouseWheelZoomEnabled(boolean wheelZoomEnabled) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setMouseWheelZoomEnabled(wheelZoomEnabled);
        }
    }

    public synchronized boolean setPaintingDoc(@Nullable SpenPaintingDoc paintingDoc, boolean isUpdate) {
        SpenPaintingViewImpl spenPaintingViewImpl;
        spenPaintingViewImpl = this.mViewImpl;
        return spenPaintingViewImpl != null ? spenPaintingViewImpl.setPaintingDoc(paintingDoc, isUpdate) : false;
    }

    public final void setPan(@Nullable PointF pointF) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setPan(pointF);
        }
    }

    public final void setPaperEnabled(boolean z) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setPaperEnabled(z);
        }
    }

    public final void setPenChangeListener(@Nullable SpenPenChangeListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setPenChangeListener(listener);
        }
    }

    public final void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setPenSettingInfo(spenSettingPenInfo);
        }
    }

    public final void setPreTouchListener(@Nullable SpenTouchListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setPreTouchListener(listener);
        }
    }

    public final void setPredictionEnabled(boolean enabled) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setPredictionEnabled(enabled);
        }
    }

    public final boolean setSketchImage(@Nullable Bitmap bitmap, int stretchMode, int opacity) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setSketchImage(bitmap, stretchMode, opacity);
        }
        return false;
    }

    public final void setToolTipEnabled(boolean z) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setToolTipEnabled(z);
        }
    }

    public final void setToolTypeAction(int toolType, int action) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setToolTypeAction(toolType, action);
        }
    }

    public final void setTouchListener(@Nullable SpenTouchListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setTouchListener(listener);
        }
    }

    public void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setTouchMargin(marginLeft, marginTop, marginRight, marginBottom);
        }
    }

    public final void setZoomListener(@Nullable SpenZoomListener listener) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setZoomListener(listener);
        }
    }

    public final void setZoomScale(float scale, float centerX, float centerY) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setZoomScale(scale, centerX, centerY);
        }
    }

    public final void setZoomable(boolean z) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.setZoomable(z);
        }
    }

    public final void startActionMode() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.startActionMode();
        }
    }

    public final void stopActionMode() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.stopActionMode();
        }
    }

    public final void update() {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.update();
        }
    }

    public final void updateRedo(@Nullable SpenHistoryUpdateInfo[] userDataList) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.updateRedo(userDataList);
        }
    }

    public final void updateUndo(@Nullable SpenHistoryUpdateInfo[] userDataList) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            spenPaintingViewImpl.updateUndo(userDataList);
        }
    }

    public final boolean setLayerBitmap(@Nullable Bitmap bitmap, int wrappingmode, boolean isClearCurrentLayer) {
        SpenPaintingViewImpl spenPaintingViewImpl = this.mViewImpl;
        if (spenPaintingViewImpl != null) {
            return spenPaintingViewImpl.setLayerBitmap(bitmap, wrappingmode, isClearCurrentLayer);
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPaintingSurfaceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPaintingSurfaceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }
}
