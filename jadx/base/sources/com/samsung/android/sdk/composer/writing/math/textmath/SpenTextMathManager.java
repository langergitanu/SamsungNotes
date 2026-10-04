package com.samsung.android.sdk.composer.writing.math.textmath;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.graphics.layer.C2061c;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScroller;
import com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathPlotListener;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0019\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u0013J\u0010\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002J \u0010-\u001a\u00020\u00152\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u0002000/j\b\u0012\u0004\u0012\u000200`1H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J(\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u0003¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathManager;", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenITextMathManager;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mNativeHandler", "", "mTextMathListener", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathListener;", "mMathPlotListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathPlotListener;", "mPlotManager", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotManager;", "mDialerLayout", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerLayout;", "mCanvas", "Landroid/view/ViewGroup;", "mZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "setNativeHandle", "", "context", "handle", "canvas", "close", "setTextMathListener", "l", "setMathPlotListener", "onTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "setNoteZoomScroller", "noteZoomScroller", "requestShowDialer", "rect", "Landroid/graphics/RectF;", "requestHideDialer", "initDialer", "mDialerHandler", "Landroid/os/Handler;", "getMDialerHandler$annotations", "initPlotManager", "onDialerRequested", "onPlotListUpdated", "plotList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/writing/math/textmath/PlotInfo;", "Lkotlin/collections/ArrayList;", "onFocusChanged", "onGraphSelected", "graphID", "", "x", "", "y", "selected", "onPlotControlVisibleChanged", "isVisible", "onPlotClosed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextMathManager implements SpenITextMathManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MATH_DIALER_DISMISS_DELAY = 2000;

    @NotNull
    private static final String TAG = "SpenTextMathManager";

    @Nullable
    private ViewGroup mCanvas;

    @Nullable
    private Context mContext;

    @NotNull
    private final Handler mDialerHandler = new Handler(new C2061c(this, 1));

    @Nullable
    private SpenMathDialerLayout mDialerLayout;

    @Nullable
    private SpenMathPlotListener mMathPlotListener;
    private long mNativeHandler;

    @Nullable
    private SpenTextMathPlotManager mPlotManager;

    @Nullable
    private SpenTextMathListener mTextMathListener;

    @Nullable
    private SpenNoteZoomScroller mZoomScroller;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MATH_DIALER_DISMISS_DELAY", "", "Native_init", "", "nativeTextMathManager", "", "textMathManager", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathManager;", "Native_finalize", "Native_onDialerChanged", "stepCount", "Native_onDialerHide", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeTextMathManager) {
            SpenTextMathManager.Native_finalize(nativeTextMathManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeTextMathManager, SpenTextMathManager textMathManager) {
            SpenTextMathManager.Native_init(nativeTextMathManager, textMathManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDialerChanged(long nativeTextMathManager, int stepCount) {
            SpenTextMathManager.Native_onDialerChanged(nativeTextMathManager, stepCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDialerHide(long nativeTextMathManager) {
            SpenTextMathManager.Native_onDialerHide(nativeTextMathManager);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenTextMathManager spenTextMathManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDialerChanged(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDialerHide(long j);

    private static /* synthetic */ void getMDialerHandler$annotations() {
    }

    private final void initDialer() {
        if (this.mCanvas == null) {
            return;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        SpenMathDialerLayout spenMathDialerLayout = new SpenMathDialerLayout(context);
        this.mDialerLayout = spenMathDialerLayout;
        spenMathDialerLayout.setOnValueChangedListener(new SpenMathDialerLayout.OnDialerChangedListener() { // from class: com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathManager.initDialer.1
            @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout.OnDialerChangedListener
            public void onHide() {
                SpenTextMathManager.INSTANCE.Native_onDialerHide(SpenTextMathManager.this.mNativeHandler);
                SpenTextMathListener spenTextMathListener = SpenTextMathManager.this.mTextMathListener;
                if (spenTextMathListener != null) {
                    spenTextMathListener.onDialerVisibleChanged(false);
                }
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout.OnDialerChangedListener
            public void onValueChanged(int stepCount) {
                SpenTextMathManager.INSTANCE.Native_onDialerChanged(SpenTextMathManager.this.mNativeHandler, stepCount);
                SpenTextMathManager.this.mDialerHandler.removeCallbacksAndMessages(null);
                SpenTextMathManager.this.mDialerHandler.sendEmptyMessageDelayed(0, 2000L);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        ViewGroup viewGroup = this.mCanvas;
        if (viewGroup != null) {
            viewGroup.addView(this.mDialerLayout, layoutParams);
        }
    }

    private final void initPlotManager() {
        SpenTextMathPlotManager spenTextMathPlotManager = new SpenTextMathPlotManager(this.mContext, this.mCanvas);
        this.mPlotManager = spenTextMathPlotManager;
        spenTextMathPlotManager.setPlotManagerListener(new SpenTextMathPlotManager.SpenPlotManagerListener() { // from class: com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathManager.initPlotManager.1
            @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotManager.SpenPlotManagerListener
            public RectF convertContentRectIntoViewRect(RectF rect) {
                RectF rectFConvertContentRectIntoViewRect;
                SpenNoteZoomScroller spenNoteZoomScroller = SpenTextMathManager.this.mZoomScroller;
                return (spenNoteZoomScroller == null || (rectFConvertContentRectIntoViewRect = spenNoteZoomScroller.convertContentRectIntoViewRect(rect)) == null) ? new RectF() : rectFConvertContentRectIntoViewRect;
            }

            @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotManager.SpenPlotManagerListener
            public void requestInsertPlot(SpenObjectBase objectBase) {
                SpenTextMathListener spenTextMathListener = SpenTextMathManager.this.mTextMathListener;
                if (spenTextMathListener != null) {
                    spenTextMathListener.requestInsertPlot(objectBase);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mDialerHandler$lambda$0(SpenTextMathManager spenTextMathManager, Message it) {
        Intrinsics.checkNotNullParameter(it, "it");
        spenTextMathManager.requestHideDialer();
        return false;
    }

    private final void onDialerRequested(RectF rect) {
        Log.i(TAG, "onDialerRequested: rect= " + rect);
        requestShowDialer(rect);
    }

    private final void onFocusChanged() {
        Log.i(TAG, "onFocusChanged");
        SpenTextMathPlotManager spenTextMathPlotManager = this.mPlotManager;
        if (spenTextMathPlotManager != null) {
            spenTextMathPlotManager.hideGraphButton();
        }
    }

    private final void onGraphSelected(int graphID, float x, float y2, boolean selected) {
        AbstractC2322a.m1631u(graphID, "onMathGraphSelected graphID#", TAG);
        SpenMathPlotListener spenMathPlotListener = this.mMathPlotListener;
        if (spenMathPlotListener != null) {
            spenMathPlotListener.onGraphSelected(graphID, x, y2, selected);
        }
    }

    private final void onPlotClosed() {
        Log.d(TAG, "onPlotClosed");
        SpenMathPlotListener spenMathPlotListener = this.mMathPlotListener;
        if (spenMathPlotListener != null) {
            spenMathPlotListener.onClosed();
        }
    }

    private final void onPlotControlVisibleChanged(boolean isVisible) {
        AbstractC6670b.m4759t("onPlotControlVisibleChanged isVisible : ", TAG, isVisible);
        SpenMathPlotListener spenMathPlotListener = this.mMathPlotListener;
        if (spenMathPlotListener != null) {
            spenMathPlotListener.onControlVisibleChanged(isVisible);
        }
    }

    private final void onPlotListUpdated(ArrayList<PlotInfo> plotList) {
        AbstractC0541b.m755A(plotList.size(), "onPlotListUpdated size : ", TAG);
        SpenTextMathPlotManager spenTextMathPlotManager = this.mPlotManager;
        if (spenTextMathPlotManager != null) {
            spenTextMathPlotManager.updateGraphData(plotList);
        }
    }

    private final boolean requestHideDialer() {
        SpenMathDialerLayout spenMathDialerLayout = this.mDialerLayout;
        boolean zRequestHide = spenMathDialerLayout != null ? spenMathDialerLayout.requestHide(true) : false;
        SpenMathDialerLayout spenMathDialerLayout2 = this.mDialerLayout;
        if (spenMathDialerLayout2 != null) {
            spenMathDialerLayout2.resetValue();
        }
        return zRequestHide;
    }

    public final void close() {
        this.mContext = null;
        long j = this.mNativeHandler;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.mNativeHandler = 0L;
        }
        this.mTextMathListener = null;
        this.mMathPlotListener = null;
        SpenTextMathPlotManager spenTextMathPlotManager = this.mPlotManager;
        if (spenTextMathPlotManager != null) {
            spenTextMathPlotManager.close();
        }
        this.mPlotManager = null;
        this.mCanvas = null;
        this.mZoomScroller = null;
        SpenMathDialerLayout spenMathDialerLayout = this.mDialerLayout;
        if (spenMathDialerLayout != null) {
            spenMathDialerLayout.close();
        }
        this.mDialerLayout = null;
    }

    public final boolean onTouch(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (motionEvent.getActionMasked() == 0) {
            return requestHideDialer();
        }
        return false;
    }

    public final void requestShowDialer(@Nullable RectF rect) {
        SpenNoteZoomScroller spenNoteZoomScroller;
        RectF rectFConvertContentRectIntoViewRect;
        if (this.mDialerLayout == null || (spenNoteZoomScroller = this.mZoomScroller) == null) {
            return;
        }
        RectF rectFConvertContentRectIntoViewRect2 = spenNoteZoomScroller != null ? spenNoteZoomScroller.convertContentRectIntoViewRect(rect) : null;
        Intrinsics.checkNotNull(rectFConvertContentRectIntoViewRect2);
        SpenNoteZoomScroller spenNoteZoomScroller2 = this.mZoomScroller;
        if (spenNoteZoomScroller2 != null) {
            rectFConvertContentRectIntoViewRect = spenNoteZoomScroller2.convertContentRectIntoViewRect(spenNoteZoomScroller2 != null ? spenNoteZoomScroller2.getContentRectInView() : null);
        } else {
            rectFConvertContentRectIntoViewRect = null;
        }
        Intrinsics.checkNotNull(rectFConvertContentRectIntoViewRect);
        SpenMathDialerLayout spenMathDialerLayout = this.mDialerLayout;
        if (spenMathDialerLayout != null) {
            spenMathDialerLayout.resetValue();
        }
        SpenMathDialerLayout spenMathDialerLayout2 = this.mDialerLayout;
        if (spenMathDialerLayout2 != null) {
            spenMathDialerLayout2.requestShow(rectFConvertContentRectIntoViewRect2, rectFConvertContentRectIntoViewRect);
        }
        this.mDialerHandler.removeCallbacksAndMessages(null);
        this.mDialerHandler.sendEmptyMessageDelayed(0, 2000L);
        SpenTextMathListener spenTextMathListener = this.mTextMathListener;
        if (spenTextMathListener != null) {
            spenTextMathListener.onDialerVisibleChanged(true);
        }
    }

    @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenITextMathManager
    public void setMathPlotListener(@Nullable SpenMathPlotListener l) {
        this.mMathPlotListener = l;
    }

    public final void setNativeHandle(@Nullable Context context, long handle, @Nullable ViewGroup canvas) {
        Log.i(TAG, "setNativeHandle()");
        this.mNativeHandler = handle;
        this.mContext = context;
        this.mCanvas = canvas;
        if (handle != 0) {
            INSTANCE.Native_init(handle, this);
        }
    }

    public final void setNoteZoomScroller(@Nullable SpenNoteZoomScroller noteZoomScroller) {
        this.mZoomScroller = noteZoomScroller;
    }

    @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenITextMathManager
    public void setTextMathListener(@Nullable SpenTextMathListener l) {
        this.mTextMathListener = l;
    }
}
