package com.samsung.android.support.senl.addons.base.model.canvas.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PointF;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 R*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001RJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020!H&J \u0010*\u001a\u00020\u00102\u0006\u0010%\u001a\u00020!2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020!H&J\b\u0010-\u001a\u00020\u0010H&J\b\u0010.\u001a\u00020\u0010H&J\u0012\u0010/\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u000100H&J\u0012\u00101\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u000102H&J\b\u00103\u001a\u00020\u0010H&J\u0014\u00104\u001a\u00020\u00102\n\b\u0001\u00105\u001a\u0004\u0018\u000106H&J\b\u00107\u001a\u00020\u0010H&J\b\u00108\u001a\u00020\u0010H&J\b\u00109\u001a\u00020\u0010H&J\b\u0010:\u001a\u00020\u0010H&J\u0012\u0010>\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010@H&J\u001a\u0010A\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010@2\u0006\u0010C\u001a\u00020DH&J\u0010\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\fH&J\n\u0010J\u001a\u0004\u0018\u00010KH&J\u0010\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u001bH&J\b\u0010N\u001a\u00020\u0010H&J\u0018\u0010O\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u001bH&J\u0010\u0010Q\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u001bH&R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010&\u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0012\u0010(\u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010#R\u0012\u0010;\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010<R\u001a\u0010G\u001a\u0004\u0018\u00010\u0006X¦\u000e¢\u0006\f\u001a\u0004\bH\u0010\b\"\u0004\bI\u0010\n¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "T", "", "getContext", "Landroid/content/Context;", "penSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "initializeDocModel", "", "docModel", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "setPreTouchListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "setTouchListener", "pan", "Landroid/graphics/PointF;", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "canvasWidth", "", "getCanvasWidth", "()I", "canvasHeight", "getCanvasHeight", "minZoomScale", "", "getMinZoomScale", "()F", "setMinZoomScale", WiggleAnimationConfig.KEY_SCALE, "maxZoomScale", "getMaxZoomScale", "zoomScale", "getZoomScale", "setZoomScale", "centerX", "centerY", Constants.ARG_UPDATE, "clearAll", "setZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "setColorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "commitStroke", "getLocationInWindow", "outLocation", "", "close", "lockForSave", "unlockForSave", "requestReadyForSave", "isHScrollable", "()Z", "isVScrollable", "post", "run", "Ljava/lang/Runnable;", "postDelayed", "runnable", "delayMs", "", "setFrontBufferRenderingEnabled", "enable", "eraserSettingInfo", "getEraserSettingInfo", "setEraserSettingInfo", "getConfiguration", "Landroid/content/res/Configuration;", "setActionType", "var1", "closeControl", "setToolTypeAction", "var2", "getToolTypeAction", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IView<T> {
    public static final int ACTION_CHANGESTYLE = 13;
    public static final int ACTION_COLOR_PICKER = 9;
    public static final int ACTION_ERASER = 7;
    public static final int ACTION_GESTURE = 1;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_RECOGNITION = 12;
    public static final int ACTION_RECOGNITION_PREVIEW = 14;
    public static final int ACTION_SELECTION = 10;
    public static final int ACTION_STROKE = 2;
    public static final int ACTION_STROKE_REMOVER = 8;
    public static final int ACTION_TEXT = 11;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TOOL_ERASER = 4;
    public static final int TOOL_FINGER = 1;
    public static final int TOOL_MOUSE = 3;
    public static final int TOOL_MULTI_TOUCH = 5;
    public static final int TOOL_PEN_BUTTON = 6;
    public static final int TOOL_SPEN = 2;
    public static final int TOOL_UNKNOWN = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView$Companion;", "", "<init>", "()V", "TOOL_UNKNOWN", "", "TOOL_FINGER", "TOOL_SPEN", "TOOL_MOUSE", "TOOL_ERASER", "TOOL_MULTI_TOUCH", "TOOL_PEN_BUTTON", "ACTION_NONE", "ACTION_GESTURE", "ACTION_STROKE", "ACTION_ERASER", "ACTION_STROKE_REMOVER", "ACTION_COLOR_PICKER", "ACTION_SELECTION", "ACTION_TEXT", "ACTION_RECOGNITION", "ACTION_CHANGESTYLE", "ACTION_RECOGNITION_PREVIEW", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ACTION_CHANGESTYLE = 13;
        public static final int ACTION_COLOR_PICKER = 9;
        public static final int ACTION_ERASER = 7;
        public static final int ACTION_GESTURE = 1;
        public static final int ACTION_NONE = 0;
        public static final int ACTION_RECOGNITION = 12;
        public static final int ACTION_RECOGNITION_PREVIEW = 14;
        public static final int ACTION_SELECTION = 10;
        public static final int ACTION_STROKE = 2;
        public static final int ACTION_STROKE_REMOVER = 8;
        public static final int ACTION_TEXT = 11;
        public static final int TOOL_ERASER = 4;
        public static final int TOOL_FINGER = 1;
        public static final int TOOL_MOUSE = 3;
        public static final int TOOL_MULTI_TOUCH = 5;
        public static final int TOOL_PEN_BUTTON = 6;
        public static final int TOOL_SPEN = 2;
        public static final int TOOL_UNKNOWN = 0;

        private Companion() {
        }
    }

    void clearAll();

    void close();

    void closeControl();

    void commitStroke();

    int getCanvasHeight();

    int getCanvasWidth();

    @Nullable
    Configuration getConfiguration();

    @Nullable
    Context getContext();

    @Nullable
    SpenSettingPenInfo getEraserSettingInfo();

    void getLocationInWindow(@Size(2) @Nullable int[] outLocation);

    float getMaxZoomScale();

    float getMinZoomScale();

    @Nullable
    PointF getPan();

    @Nullable
    SpenSettingPenInfo getPenSettingInfo();

    int getToolTypeAction(int var1);

    float getZoomScale();

    boolean initializeDocModel(@NotNull IDocModel<?> docModel);

    boolean isHScrollable();

    boolean isVScrollable();

    void lockForSave();

    boolean post(@Nullable Runnable run);

    boolean postDelayed(@Nullable Runnable runnable, long delayMs);

    void requestReadyForSave();

    void setActionType(int var1);

    void setColorPickerListener(@Nullable SpenColorPickerListener listener);

    void setEraserSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo);

    boolean setFrontBufferRenderingEnabled(boolean enable);

    boolean setMinZoomScale(float scale);

    void setPan(@Nullable PointF pointF);

    void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo);

    void setPreTouchListener(@Nullable SpenTouchListener listener);

    void setToolTypeAction(int var1, int var2);

    void setTouchListener(@Nullable SpenTouchListener listener);

    void setZoomListener(@Nullable SpenZoomListener listener);

    void setZoomScale(float scale, float centerX, float centerY);

    void unlockForSave();

    void update();
}
