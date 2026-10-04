package com.samsung.android.sdk.pen.recoguifeature.math;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.layer.C2061c;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScroller;
import com.samsung.android.sdk.pen.document.SpenObjectMath;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 [2\u00020\u0001:\u0001[B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020 J\u0010\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0016J\u0012\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010+\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010,\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016J(\u00100\u001a\u00020 2\u001e\u00101\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u000102j\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u0001`4H\u0016J\u0012\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\b\u0010@\u001a\u00020 H\u0002J\b\u0010A\u001a\u00020 H\u0002J\"\u0010B\u001a\u00020 2\u001a\u0010C\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010D02j\n\u0012\u0006\u0012\u0004\u0018\u00010D`4J\u001e\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020'J\u001e\u0010I\u001a\u00020 2\u0006\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020/J\u0010\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020'H\u0002J\b\u0010M\u001a\u00020 H\u0002J\u0010\u0010N\u001a\u00020 2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020/H\u0002J\u0010\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020DH\u0002J\u0018\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020'2\u0006\u0010R\u001a\u00020DH\u0002J(\u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020'H\u0002J\u0010\u0010Y\u001a\u00020 2\u0006\u0010L\u001a\u00020'H\u0002J\b\u0010Z\u001a\u00020 H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b>\u0010?¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathManager;", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "mCanvas", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "mNativeMathManager", "", "mContext", "Landroid/content/Context;", "docModelPath", "", "docLsModelPath", "modelPath", "getModelPath", "()Ljava/lang/String;", "setModelPath", "(Ljava/lang/String;)V", "fontPath", "getFontPath", "setFontPath", "mSpenHwrMathListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenHwrMathListener;", "mSpenMathHelperListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathHelperListener;", "mSpenMathPlotListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathPlotListener;", "mSpenDialer", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerLayout;", "mZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "setNativeHandle", "", "context", "handle", "close", "setNoteZoomScroller", "noteZoomScroller", "setHwrMathEnabled", "", "enabled", "setHwrMathListener", "l", "setMathHelperListener", "setMathPlotListener", "setAnswerColor", "color", "", "releaseMathObjectList", "objectMathList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectMath;", "Lkotlin/collections/ArrayList;", "setLocale", "locale", "onTouch", "motionEvent", "Landroid/view/MotionEvent;", "dismissDialer", "initDialer", "mMathDialerHandler", "Landroid/os/Handler;", "getMMathDialerHandler$annotations", "()V", "onProgressStart", "onProgressStop", "onMathResultAppended", "resultRectList", "Landroid/graphics/RectF;", "onMathExpressionUpdated", "resultRect", "latexResult", "isPlottable", "onMathExpressionFailed", "failNum", "onControlVisibleChanged", "isVisible", "onClosed", "onMathHelperUpdated", "onMathHelperFailed", "failCode", "onMathDialerRequested", "rect", "onGraphSelected", "graphID", "x", "", "y", "selected", "onPlotControlVisibleChanged", "onPlotClosed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenMathManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenMathManager.kt\ncom/samsung/android/sdk/pen/recoguifeature/math/SpenMathManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,292:1\n1#2:293\n*E\n"})
public final class SpenMathManager implements SpenIMathManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MATH_DIALER_DISMISS_DELAY = 2000;

    @NotNull
    private static final String TAG = "SpenMathManager";

    @Nullable
    private String docLsModelPath;

    @Nullable
    private String docModelPath;

    @Nullable
    private String fontPath;

    @Nullable
    private ViewGroup mCanvas;

    @Nullable
    private Context mContext;

    @NotNull
    private final Handler mMathDialerHandler = new Handler(new C2061c(this, 2));
    private long mNativeMathManager;

    @Nullable
    private SpenMathDialerLayout mSpenDialer;

    @Nullable
    private SpenHwrMathListener mSpenHwrMathListener;

    @Nullable
    private SpenMathHelperListener mSpenMathHelperListener;

    @Nullable
    private SpenMathPlotListener mSpenMathPlotListener;

    @Nullable
    private SpenNoteZoomScroller mZoomScroller;

    @Nullable
    private String modelPath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J1\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001e\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u0001`\u001aH\u0083 J\u0019\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0083 J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0083 J\u0019\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MATH_DIALER_DISMISS_DELAY", "", "Native_init", "", "nativeMathManager", "", "mathManager", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathManager;", "modelPath", "fontPath", "docModelPath", "docLsModelPath", "Native_finalize", "Native_onDialerChanged", "stepCount", "Native_onDialerHide", "Native_releaseMathObjectList", "objectMathList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectMath;", "Lkotlin/collections/ArrayList;", "Native_setAnswerColor", "Native_setHwrMathEnabled", "", "enabled", "Native_setLocale", "locale", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeMathManager) {
            SpenMathManager.Native_finalize(nativeMathManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeMathManager, SpenMathManager mathManager, String modelPath, String fontPath, String docModelPath, String docLsModelPath) {
            SpenMathManager.Native_init(nativeMathManager, mathManager, modelPath, fontPath, docModelPath, docLsModelPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDialerChanged(long nativeMathManager, int stepCount) {
            SpenMathManager.Native_onDialerChanged(nativeMathManager, stepCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDialerHide(long nativeMathManager) {
            SpenMathManager.Native_onDialerHide(nativeMathManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_releaseMathObjectList(long nativeMathManager, ArrayList<SpenObjectMath> objectMathList) {
            SpenMathManager.Native_releaseMathObjectList(nativeMathManager, objectMathList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAnswerColor(long nativeMathManager, int stepCount) {
            SpenMathManager.Native_setAnswerColor(nativeMathManager, stepCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setHwrMathEnabled(long nativeMathManager, boolean enabled) {
            return SpenMathManager.Native_setHwrMathEnabled(nativeMathManager, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLocale(long nativeMathManager, String locale) {
            SpenMathManager.Native_setLocale(nativeMathManager, locale);
        }

        private Companion() {
        }
    }

    public SpenMathManager(@Nullable ViewGroup viewGroup) {
        this.mCanvas = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenMathManager spenMathManager, String str, String str2, String str3, String str4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDialerChanged(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDialerHide(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_releaseMathObjectList(long j, ArrayList<SpenObjectMath> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAnswerColor(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setHwrMathEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLocale(long j, String str);

    private final void dismissDialer() {
        SpenMathDialerLayout spenMathDialerLayout = this.mSpenDialer;
        if (spenMathDialerLayout != null) {
            spenMathDialerLayout.requestHide(true);
            spenMathDialerLayout.resetValue();
        }
    }

    private static /* synthetic */ void getMMathDialerHandler$annotations() {
    }

    private final void initDialer() {
        if (this.mCanvas == null) {
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            SpenMathDialerLayout spenMathDialerLayout = new SpenMathDialerLayout(context);
            this.mSpenDialer = spenMathDialerLayout;
            spenMathDialerLayout.setOnValueChangedListener(new SpenMathDialerLayout.OnDialerChangedListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.SpenMathManager$initDialer$1$1
                @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout.OnDialerChangedListener
                public void onHide() {
                    SpenMathManager.INSTANCE.Native_onDialerHide(this.this$0.mNativeMathManager);
                    SpenMathHelperListener spenMathHelperListener = this.this$0.mSpenMathHelperListener;
                    if (spenMathHelperListener != null) {
                        spenMathHelperListener.onDialerVisibleChanged(false);
                    }
                }

                @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout.OnDialerChangedListener
                public void onValueChanged(int stepCount) {
                    SpenMathManager.INSTANCE.Native_onDialerChanged(this.this$0.mNativeMathManager, stepCount);
                    this.this$0.mMathDialerHandler.removeCallbacksAndMessages(null);
                    this.this$0.mMathDialerHandler.sendEmptyMessageDelayed(0, 2000L);
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        ViewGroup viewGroup = this.mCanvas;
        if (viewGroup != null) {
            viewGroup.addView(this.mSpenDialer, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mMathDialerHandler$lambda$8(SpenMathManager spenMathManager, Message it) {
        Intrinsics.checkNotNullParameter(it, "it");
        spenMathManager.dismissDialer();
        return false;
    }

    private final void onClosed() {
        Log.d(TAG, "SpenMathManager::onClosed");
        dismissDialer();
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onClosed();
        }
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onClosed();
        }
    }

    private final void onControlVisibleChanged(boolean isVisible) {
        AbstractC6670b.m4759t("SpenMathManager::onControlVisibleChanged isVisible : ", TAG, isVisible);
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onControlVisibleChanged(isVisible);
        }
    }

    private final void onGraphSelected(int graphID, float x, float y2, boolean selected) {
        AbstractC2322a.m1631u(graphID, "SpenMathManager::onMathGraphSelected graphID#", TAG);
        SpenMathPlotListener spenMathPlotListener = this.mSpenMathPlotListener;
        if (spenMathPlotListener != null) {
            spenMathPlotListener.onGraphSelected(graphID, x, y2, selected);
        }
    }

    private final void onMathDialerRequested(RectF rect) {
        SpenNoteZoomScroller spenNoteZoomScroller;
        RectF rectFConvertContentRectIntoViewRect;
        SpenMathDialerLayout spenMathDialerLayout;
        Log.i(TAG, "SpenMathManager::onMathDialerRequested: rect " + rect);
        if (this.mSpenDialer == null || (spenNoteZoomScroller = this.mZoomScroller) == null) {
            return;
        }
        RectF rectFConvertContentRectIntoViewRect2 = spenNoteZoomScroller != null ? spenNoteZoomScroller.convertContentRectIntoViewRect(rect) : null;
        SpenNoteZoomScroller spenNoteZoomScroller2 = this.mZoomScroller;
        if (spenNoteZoomScroller2 != null) {
            rectFConvertContentRectIntoViewRect = spenNoteZoomScroller2.convertContentRectIntoViewRect(spenNoteZoomScroller2 != null ? spenNoteZoomScroller2.getContentRectInView() : null);
        } else {
            rectFConvertContentRectIntoViewRect = null;
        }
        SpenMathDialerLayout spenMathDialerLayout2 = this.mSpenDialer;
        if (spenMathDialerLayout2 != null) {
            spenMathDialerLayout2.resetValue();
        }
        if (rectFConvertContentRectIntoViewRect2 != null && rectFConvertContentRectIntoViewRect != null && (spenMathDialerLayout = this.mSpenDialer) != null) {
            spenMathDialerLayout.requestShow(rectFConvertContentRectIntoViewRect2, rectFConvertContentRectIntoViewRect);
        }
        this.mMathDialerHandler.removeCallbacksAndMessages(null);
        this.mMathDialerHandler.sendEmptyMessageDelayed(0, 2000L);
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onDialerVisibleChanged(true);
        }
    }

    private final void onMathHelperFailed(int failCode) {
        Log.d(TAG, "SpenMathManager::onMathHelperFailed failCode : " + failCode);
        Log.d(TAG, "SpenMathManager::onMathHelperFailed failCode : " + SpenMathFailCode.values()[failCode]);
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onMathHelperFailed(failCode);
        }
    }

    private final void onMathHelperUpdated(boolean isPlottable) {
        AbstractC6670b.m4759t("SpenMathManager::onMathHelperUpdated isPlottable : ", TAG, isPlottable);
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onMathHelperUpdated(isPlottable);
        }
    }

    private final void onPlotClosed() {
        Log.d(TAG, "SpenMathManager::onPlotClosed");
        SpenMathPlotListener spenMathPlotListener = this.mSpenMathPlotListener;
        if (spenMathPlotListener != null) {
            spenMathPlotListener.onClosed();
        }
    }

    private final void onPlotControlVisibleChanged(boolean isVisible) {
        AbstractC6670b.m4759t("SpenMathManager::onPlotControlVisibleChanged isVisible : ", TAG, isVisible);
        SpenMathPlotListener spenMathPlotListener = this.mSpenMathPlotListener;
        if (spenMathPlotListener != null) {
            spenMathPlotListener.onControlVisibleChanged(isVisible);
        }
    }

    private final void onProgressStart() {
        Log.i(TAG, "SpenMathManager::onProgressStart");
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onProgressStart();
        }
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onProgressStart();
        }
    }

    private final void onProgressStop() {
        Log.i(TAG, "SpenMathManager::onProgressStop");
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onProgressStop();
        }
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onProgressStop();
        }
    }

    public final void close() {
        this.mContext = null;
        long j = this.mNativeMathManager;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.mNativeMathManager = 0L;
        }
        this.mMathDialerHandler.removeCallbacksAndMessages(null);
        SpenMathDialerLayout spenMathDialerLayout = this.mSpenDialer;
        if (spenMathDialerLayout != null) {
            spenMathDialerLayout.close();
            this.mSpenDialer = null;
        }
        setModelPath(null);
        this.docModelPath = null;
        this.docLsModelPath = null;
        setFontPath(null);
        this.mSpenHwrMathListener = null;
        this.mSpenMathHelperListener = null;
        this.mSpenMathPlotListener = null;
        this.mCanvas = null;
        this.mZoomScroller = null;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    @Nullable
    public String getFontPath() {
        return this.fontPath;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    @Nullable
    public String getModelPath() {
        return this.modelPath;
    }

    public final void onMathExpressionFailed(@NotNull RectF resultRect, @NotNull String latexResult, int failNum) {
        Intrinsics.checkNotNullParameter(resultRect, "resultRect");
        Intrinsics.checkNotNullParameter(latexResult, "latexResult");
        SpenMathFailCode spenMathFailCode = SpenMathFailCode.values()[failNum];
        float f = resultRect.left;
        float f4 = resultRect.top;
        float f5 = resultRect.right;
        float f6 = resultRect.bottom;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("SpenMathManager::onMathExpressionFailed mathExpression (l:", f, ", t:", f4, ", r:");
        AbstractC11014a.m12337v(sbM1176v, f5, ", b:", f6, "), latex:");
        sbM1176v.append(latexResult);
        sbM1176v.append(", failCode:");
        sbM1176v.append(spenMathFailCode);
        Log.d(TAG, sbM1176v.toString());
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onMathExpressionFailed(resultRect, latexResult, spenMathFailCode);
        }
    }

    public final void onMathExpressionUpdated(@NotNull RectF resultRect, @NotNull String latexResult, boolean isPlottable) {
        Intrinsics.checkNotNullParameter(resultRect, "resultRect");
        Intrinsics.checkNotNullParameter(latexResult, "latexResult");
        float f = resultRect.left;
        float f4 = resultRect.top;
        float f5 = resultRect.right;
        float f6 = resultRect.bottom;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("SpenMathManager::onMathExpressionUpdated mathExpression (l:", f, ", t:", f4, ", r:");
        AbstractC11014a.m12337v(sbM1176v, f5, ", b:", f6, "), latex:");
        sbM1176v.append(latexResult);
        sbM1176v.append(", ploattable:");
        sbM1176v.append(isPlottable);
        Log.d(TAG, sbM1176v.toString());
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onMathExpressionUpdated(resultRect, latexResult, isPlottable);
        }
    }

    public final void onMathResultAppended(@NotNull ArrayList<RectF> resultRectList) {
        Intrinsics.checkNotNullParameter(resultRectList, "resultRectList");
        Log.i(TAG, "SpenMathManager::onMathResultAppended");
        SpenHwrMathListener spenHwrMathListener = this.mSpenHwrMathListener;
        if (spenHwrMathListener != null) {
            spenHwrMathListener.onMathResultAppended(resultRectList);
        }
    }

    public final boolean onTouch(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        dismissDialer();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void releaseMathObjectList(@Nullable ArrayList<SpenObjectMath> objectMathList) {
        long j = this.mNativeMathManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_releaseMathObjectList(j, objectMathList);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setAnswerColor(int color) {
        long j = this.mNativeMathManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setAnswerColor(j, color);
    }

    public void setFontPath(@Nullable String str) {
        this.fontPath = str;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public boolean setHwrMathEnabled(boolean enabled) {
        SpenMathManager spenMathManager;
        long j = this.mNativeMathManager;
        if (j == 0) {
            return false;
        }
        if (enabled) {
            spenMathManager = this;
            INSTANCE.Native_init(j, spenMathManager, getModelPath(), getFontPath(), this.docModelPath, this.docLsModelPath);
        } else {
            spenMathManager = this;
        }
        return INSTANCE.Native_setHwrMathEnabled(spenMathManager.mNativeMathManager, enabled);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setHwrMathListener(@Nullable SpenHwrMathListener l) {
        this.mSpenHwrMathListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setLocale(@Nullable String locale) {
        long j = this.mNativeMathManager;
        if (j == 0 || locale == null) {
            return;
        }
        INSTANCE.Native_setLocale(j, locale);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setMathHelperListener(@Nullable SpenMathHelperListener l) {
        this.mSpenMathHelperListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager
    public void setMathPlotListener(@Nullable SpenMathPlotListener l) {
        this.mSpenMathPlotListener = l;
    }

    public void setModelPath(@Nullable String str) {
        this.modelPath = str;
    }

    public final void setNativeHandle(@Nullable Context context, long handle) {
        this.mNativeMathManager = handle;
        this.mContext = context;
        Log.i(TAG, "SpenMathManager::setNativeHandle()");
        if (this.mNativeMathManager != 0) {
            String fontPath = null;
            setModelPath(getModelPath() == null ? context != null ? SpenMathResourceExtractor.INSTANCE.copyModelFilesFromAssets(context) : null : getModelPath());
            String strCopyDocModelFilesFromAssets = this.docModelPath;
            if (strCopyDocModelFilesFromAssets == null) {
                strCopyDocModelFilesFromAssets = context != null ? SpenMathResourceExtractor.INSTANCE.copyDocModelFilesFromAssets(context) : null;
            }
            this.docModelPath = strCopyDocModelFilesFromAssets;
            String strCopyDocLsModelFilesFromAssets = this.docLsModelPath;
            if (strCopyDocLsModelFilesFromAssets == null) {
                strCopyDocLsModelFilesFromAssets = context != null ? SpenMathResourceExtractor.INSTANCE.copyDocLsModelFilesFromAssets(context) : null;
            }
            this.docLsModelPath = strCopyDocLsModelFilesFromAssets;
            if (getFontPath() != null) {
                fontPath = getFontPath();
            } else if (context != null) {
                fontPath = SpenMathResourceExtractor.copyOtfFontsFromAssets(context);
            }
            setFontPath(fontPath);
            Log.i(TAG, "SpenMathManager::setNativeHandle() modelPath : " + getModelPath() + ", fontPath : " + getFontPath());
            String str = this.docModelPath;
            String strValueOf = str != null ? String.valueOf(str) : "null";
            String str2 = this.docLsModelPath;
            Log.i(TAG, "SpenMathManager::setNativeHandle() document_modelPath : " + strValueOf + ", ls_modelPath : " + (str2 != null ? String.valueOf(str2) : "null"));
        }
    }

    public final void setNoteZoomScroller(@Nullable SpenNoteZoomScroller noteZoomScroller) {
        this.mZoomScroller = noteZoomScroller;
    }

    private final void onControlVisibleChanged(boolean isVisible, RectF rect) {
        AbstractC6670b.m4759t("SpenMathManager::onControlVisibleChanged isVisible : ", TAG, isVisible);
        SpenMathHelperListener spenMathHelperListener = this.mSpenMathHelperListener;
        if (spenMathHelperListener != null) {
            spenMathHelperListener.onControlVisibleChanged(isVisible, rect);
        }
    }
}
