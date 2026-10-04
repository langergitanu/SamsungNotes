package com.samsung.android.sdk.composer;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.view.accessibility.AccessibilityDelegateImpl;
import com.samsung.android.sdk.composer.view.contextmenu.SpenComposerContextMenu;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture;
import com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffectManager;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsManager;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 ¤\u00012\u00020\u0001:\u0004£\u0001¤\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0010\u0010b\u001a\u00020c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\"\u0010d\u001a\u00020c2\u0006\u0010e\u001a\u00020]2\u0006\u0010f\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010hH\u0014J\u0010\u0010i\u001a\u00020]2\u0006\u0010j\u001a\u00020kH\u0014J\u0010\u0010l\u001a\u00020]2\u0006\u0010j\u001a\u00020mH\u0016J\n\u0010n\u001a\u0004\u0018\u00010oH\u0016J\b\u0010p\u001a\u00020cH\u0016J\u0012\u0010q\u001a\u00020c2\b\u0010r\u001a\u0004\u0018\u00010%H\u0004J\u0010\u0010s\u001a\u00020c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010t\u001a\u00020c2\u0006\u0010u\u001a\u00020\u0007H\u0014J\u0010\u0010v\u001a\u00020c2\u0006\u0010w\u001a\u00020\u0007H\u0016J\u0010\u0010x\u001a\u00020]2\u0006\u0010j\u001a\u00020kH\u0016J\b\u0010y\u001a\u00020cH\u0014J\b\u0010z\u001a\u00020cH\u0014J\u0012\u0010{\u001a\u00020c2\b\u0010|\u001a\u0004\u0018\u00010}H\u0014J4\u0010~\u001a\u00020c2\u0006\u0010\u007f\u001a\u00020]2\u0007\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u0007H\u0014J\u0012\u0010\u0084\u0001\u001a\u00020c2\u0007\u0010\u0085\u0001\u001a\u00020]H\u0016J\u0013\u0010\u0086\u0001\u001a\u00020c2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0014J\u0011\u0010\u0089\u0001\u001a\u00020]2\u0006\u0010j\u001a\u00020kH\u0016J\u0011\u0010\u008a\u0001\u001a\u00020]2\u0006\u0010j\u001a\u00020kH\u0016J\u0015\u0010\u008b\u0001\u001a\u00020c2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0014J\u0007\u0010\u008e\u0001\u001a\u00020cJ\u0007\u0010\u008f\u0001\u001a\u00020cJ\t\u0010\u0090\u0001\u001a\u00020]H&J\n\u0010\u0091\u0001\u001a\u00030\u0092\u0001H&J\t\u0010\u0093\u0001\u001a\u00020cH&J\t\u0010\u0094\u0001\u001a\u00020cH&J\t\u0010\u0095\u0001\u001a\u00020cH&J\u0012\u0010\u0096\u0001\u001a\u00020c2\u0007\u0010j\u001a\u00030\u0097\u0001H&J\u0011\u0010\u0098\u0001\u001a\u00020]2\u0006\u0010j\u001a\u00020kH&J5\u0010\u0099\u0001\u001a\u00020c2\u0006\u0010\u007f\u001a\u00020]2\u0007\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u0007H&J\u0011\u0010\u009a\u0001\u001a\u00020]2\u0006\u0010j\u001a\u00020kH&J\u001b\u0010\u009b\u0001\u001a\u00020c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u009c\u0001\u001a\u00030\u0092\u0001H\u0004J\u0013\u0010\u009d\u0001\u001a\u00020c2\b\u0010\u009c\u0001\u001a\u00030\u0092\u0001H\u0004J\u0013\u0010\u009e\u0001\u001a\u00020c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0004J\u0012\u0010\u009f\u0001\u001a\u00020c2\u0007\u0010 \u0001\u001a\u00020]H\u0004J\u0012\u0010¡\u0001\u001a\u00020c2\u0007\u0010¢\u0001\u001a\u00020\u0007H\u0002R\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00060+R\u00020\u0000X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u001a\u0010\\\u001a\u00020]X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006¥\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenZoomScrollView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mSpenDrawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "getMSpenDrawLoop", "()Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "setMSpenDrawLoop", "(Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;)V", "mTextureView", "Landroid/view/TextureView;", "getMTextureView", "()Landroid/view/TextureView;", "setMTextureView", "(Landroid/view/TextureView;)V", "mHoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "getMHoverPointerIcon", "()Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "setMHoverPointerIcon", "(Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;)V", "mEdgeEffectManager", "Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffectManager;", "getMEdgeEffectManager", "()Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffectManager;", "setMEdgeEffectManager", "(Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffectManager;)V", "mActivity", "Landroid/app/Activity;", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "mLifecycleCallback", "Lcom/samsung/android/sdk/composer/SpenZoomScrollView$LifecycleCallback;", "getMLifecycleCallback", "()Lcom/samsung/android/sdk/composer/SpenZoomScrollView$LifecycleCallback;", "setMLifecycleCallback", "(Lcom/samsung/android/sdk/composer/SpenZoomScrollView$LifecycleCallback;)V", "mSpenDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "getMSpenDisplay", "()Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "setMSpenDisplay", "(Lcom/samsung/android/sdk/pen/view/SpenDisplay;)V", "mSpenConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "getMSpenConfiguration", "()Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "setMSpenConfiguration", "(Lcom/samsung/android/sdk/pen/view/SpenConfiguration;)V", "mOrientationListener", "Landroid/view/OrientationEventListener;", "getMOrientationListener", "()Landroid/view/OrientationEventListener;", "setMOrientationListener", "(Landroid/view/OrientationEventListener;)V", "mDvfsManager", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsManager;", "getMDvfsManager", "()Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsManager;", "setMDvfsManager", "(Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsManager;)V", "mAccDelegateImpl", "Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;", "getMAccDelegateImpl", "()Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;", "setMAccDelegateImpl", "(Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;)V", "mContextMenu", "Lcom/samsung/android/sdk/composer/view/contextmenu/SpenComposerContextMenu;", "getMContextMenu", "()Lcom/samsung/android/sdk/composer/view/contextmenu/SpenComposerContextMenu;", "setMContextMenu", "(Lcom/samsung/android/sdk/composer/view/contextmenu/SpenComposerContextMenu;)V", "mScreenWidth", "getMScreenWidth", "()I", "setMScreenWidth", "(I)V", "mScreenHeight", "getMScreenHeight", "setMScreenHeight", "mIsTouchDown", "", "getMIsTouchDown", "()Z", "setMIsTouchDown", "(Z)V", "init", "", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "getAccessibilityClassName", "", "close", "initActivity", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "updateScreenOrientation", "onWindowVisibilityChanged", "visibility", "onScreenStateChanged", "screenState", "onGenericMotionEvent", "onAttachedToWindow", "onDetachedFromWindow", "onCreateContextMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/ContextMenu;", "onLayout", "changed", "left", "top", "right", "bottom", "onWindowFocusChanged", "hasWindowFocus", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "onHoverEvent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "startActionMode", "stopActionMode", "isNativeHandleValid", "getView", "Landroid/view/ViewGroup;", "handleResume", "handlePause", "handleTrimMemory", "handleHover", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "handleMouseWheel", "handleLayout", "handleTouch", "initTextureView", "parent", "releaseTextureView", "initHoverIcon", "onFling", "isStarted", "onSetHoverIcon", "type", "LifecycleCallback", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenZoomScrollView extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenZoomScrollView";

    @Nullable
    private AccessibilityDelegateImpl mAccDelegateImpl;

    @Nullable
    private Activity mActivity;

    @Nullable
    private SpenComposerContextMenu mContextMenu;
    protected SpenDvfsManager mDvfsManager;
    protected SpenEdgeEffectManager mEdgeEffectManager;
    protected SpenHoverPointerIcon mHoverPointerIcon;
    private boolean mIsTouchDown;

    @NotNull
    private LifecycleCallback mLifecycleCallback;
    protected OrientationEventListener mOrientationListener;
    private int mScreenHeight;
    private int mScreenWidth;
    protected SpenConfiguration mSpenConfiguration;
    protected SpenDisplay mSpenDisplay;
    protected SpenDrawLoopInterface mSpenDrawLoop;
    protected TextureView mTextureView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenZoomScrollView$LifecycleCallback;", "Landroid/content/ComponentCallbacks2;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenZoomScrollView;)V", "onActivityCreated", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "onTrimMemory", "level", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class LifecycleCallback implements ComponentCallbacks2, Application.ActivityLifecycleCallbacks {
        public LifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenZoomScrollView.this.getMActivity()) {
                Log.i(SpenZoomScrollView.TAG, "onActivityPaused");
                SpenZoomScrollView.this.handlePause();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenZoomScrollView.this.getMActivity()) {
                Log.i(SpenZoomScrollView.TAG, "onActivityResumed");
                if (SpenZoomScrollView.this.isNativeHandleValid()) {
                    Log.i(SpenZoomScrollView.TAG, "onResume. Restore GL resources");
                    SpenZoomScrollView.this.getMSpenDisplay().updateDebugLevel();
                    SpenZoomScrollView.this.getMSpenDrawLoop().onResume();
                    SpenZoomScrollView.this.handleResume();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            if (SpenZoomScrollView.this.isNativeHandleValid() && level >= 20) {
                AbstractC2322a.m1631u(level, "SpenEditText.onTrimMemory level:", SpenZoomScrollView.TAG);
                SpenResources.INSTANCE.forceClearResources();
                SpenZoomScrollView.this.handleTrimMemory();
                SpenZoomScrollView.this.getMSpenDrawLoop().onPause();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenZoomScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
    }

    private final void onSetHoverIcon(int type) {
        getMHoverPointerIcon().setHoveringSpenIcon(type);
    }

    public void close() {
        releaseTextureView(getView());
        getMEdgeEffectManager().close();
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.close();
        }
        this.mContextMenu = null;
        getMHoverPointerIcon().close();
        getMSpenDrawLoop().close();
        getMSpenConfiguration().close();
        getMSpenDisplay().close();
        SpenResources.INSTANCE.unregisterResourceView(getView());
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.unregisterComponentCallbacks(this.mLifecycleCallback);
            activity.getApplication().unregisterActivityLifecycleCallbacks(this.mLifecycleCallback);
        }
        this.mActivity = null;
        getMOrientationListener().disable();
        getMDvfsManager().close();
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        if (accessibilityDelegateImpl != null) {
            accessibilityDelegateImpl.close();
        }
        this.mAccDelegateImpl = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        return (accessibilityDelegateImpl != null && accessibilityDelegateImpl.dispatchHoverEvent(event)) || super.dispatchHoverEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        return (accessibilityDelegateImpl != null && accessibilityDelegateImpl.dispatchKeyEvent(event)) || super.dispatchKeyEvent(event);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @Nullable
    public CharSequence getAccessibilityClassName() {
        CharSequence accessibilityClassName;
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        return (accessibilityDelegateImpl == null || (accessibilityClassName = accessibilityDelegateImpl.getAccessibilityClassName()) == null) ? super.getAccessibilityClassName() : accessibilityClassName;
    }

    @Nullable
    public final AccessibilityDelegateImpl getMAccDelegateImpl() {
        return this.mAccDelegateImpl;
    }

    @Nullable
    public final Activity getMActivity() {
        return this.mActivity;
    }

    @Nullable
    public final SpenComposerContextMenu getMContextMenu() {
        return this.mContextMenu;
    }

    @NotNull
    public final SpenDvfsManager getMDvfsManager() {
        SpenDvfsManager spenDvfsManager = this.mDvfsManager;
        if (spenDvfsManager != null) {
            return spenDvfsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDvfsManager");
        return null;
    }

    @NotNull
    public final SpenEdgeEffectManager getMEdgeEffectManager() {
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            return spenEdgeEffectManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEdgeEffectManager");
        return null;
    }

    @NotNull
    public final SpenHoverPointerIcon getMHoverPointerIcon() {
        SpenHoverPointerIcon spenHoverPointerIcon = this.mHoverPointerIcon;
        if (spenHoverPointerIcon != null) {
            return spenHoverPointerIcon;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHoverPointerIcon");
        return null;
    }

    public final boolean getMIsTouchDown() {
        return this.mIsTouchDown;
    }

    @NotNull
    public final LifecycleCallback getMLifecycleCallback() {
        return this.mLifecycleCallback;
    }

    @NotNull
    public final OrientationEventListener getMOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            return orientationEventListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOrientationListener");
        return null;
    }

    public final int getMScreenHeight() {
        return this.mScreenHeight;
    }

    public final int getMScreenWidth() {
        return this.mScreenWidth;
    }

    @NotNull
    public final SpenConfiguration getMSpenConfiguration() {
        SpenConfiguration spenConfiguration = this.mSpenConfiguration;
        if (spenConfiguration != null) {
            return spenConfiguration;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSpenConfiguration");
        return null;
    }

    @NotNull
    public final SpenDisplay getMSpenDisplay() {
        SpenDisplay spenDisplay = this.mSpenDisplay;
        if (spenDisplay != null) {
            return spenDisplay;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSpenDisplay");
        return null;
    }

    @NotNull
    public final SpenDrawLoopInterface getMSpenDrawLoop() {
        SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
        if (spenDrawLoopInterface != null) {
            return spenDrawLoopInterface;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSpenDrawLoop");
        return null;
    }

    @NotNull
    public final TextureView getMTextureView() {
        TextureView textureView = this.mTextureView;
        if (textureView != null) {
            return textureView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTextureView");
        return null;
    }

    @NotNull
    public abstract ViewGroup getView();

    public abstract void handleHover(@NotNull SpenMotionEvent event);

    public abstract void handleLayout(boolean changed, int left, int top, int right, int bottom);

    public abstract boolean handleMouseWheel(@NotNull MotionEvent event);

    public abstract void handlePause();

    public abstract void handleResume();

    public abstract boolean handleTouch(@NotNull MotionEvent event);

    public abstract void handleTrimMemory();

    public void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenResources.Companion companion = SpenResources.INSTANCE;
        companion.setResources(getView().getResources());
        companion.registerResourceView(getView());
        setMSpenDisplay(new SpenDisplay(context));
        setMSpenConfiguration(new SpenConfiguration(context));
        setMDvfsManager(new SpenDvfsManager(context));
        initTextureView(context, getView());
        initHoverIcon(context);
        setMOrientationListener(new OrientationEventListener(context, this) { // from class: com.samsung.android.sdk.composer.SpenZoomScrollView.init.1
            final /* synthetic */ Context $context;
            final /* synthetic */ SpenZoomScrollView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.$context = context;
                this.this$0 = this;
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                SpenZoomScrollView spenZoomScrollView = this.this$0;
                Context context2 = this.$context;
                synchronized (this) {
                    spenZoomScrollView.updateScreenOrientation(context2);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
        setMEdgeEffectManager(new SpenEdgeEffectManager(context, getView()));
    }

    public final void initActivity(@Nullable Activity activity) {
        this.mActivity = activity;
        if (activity != null) {
            activity.registerComponentCallbacks(this.mLifecycleCallback);
            activity.getApplication().registerActivityLifecycleCallbacks(this.mLifecycleCallback);
        }
    }

    public final void initHoverIcon(@Nullable Context context) {
        setMHoverPointerIcon(new SpenHoverPointerIcon(context, this));
        getMHoverPointerIcon().setPenIconStyle(SpenHoverPointerIcon.HOVER_POINTER_PEN_ICON_STYLE_CURVER);
    }

    public final void initTextureView(@NotNull Context context, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        setMSpenDrawLoop(new SpenDrawLoopTexture(true));
        parent.setLayerType(2, null);
        setMTextureView(new TextureView(context));
        parent.addView(getMTextureView());
        getMTextureView().setOpaque(false);
        getMTextureView().setSurfaceTextureListener((SpenDrawLoopTexture) getMSpenDrawLoop());
        if (getMTextureView().isAvailable()) {
            SpenDrawLoopInterface mSpenDrawLoop = getMSpenDrawLoop();
            SpenDrawLoopTexture spenDrawLoopTexture = mSpenDrawLoop instanceof SpenDrawLoopTexture ? (SpenDrawLoopTexture) mSpenDrawLoop : null;
            if (spenDrawLoopTexture != null) {
                SurfaceTexture surfaceTexture = getMTextureView().getSurfaceTexture();
                Intrinsics.checkNotNull(surfaceTexture);
                spenDrawLoopTexture.onSurfaceTextureAvailable(surfaceTexture, parent.getWidth(), parent.getHeight());
            }
        }
    }

    public abstract boolean isNativeHandleValid();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isNativeHandleValid()) {
            getMEdgeEffectManager().attachToParentView(getView().getParent());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getMSpenDisplay().copy(new SpenDisplay(getContext().getApplicationContext()));
        SpenResources.INSTANCE.setResources(getView().getResources());
    }

    @Override // android.view.View
    public void onCreateContextMenu(@Nullable ContextMenu menu) {
        super.onCreateContextMenu(menu);
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.onCreateContextMenu(menu);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isNativeHandleValid()) {
            return;
        }
        getMSpenDrawLoop().onViewDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (isNativeHandleValid()) {
            getMSpenDrawLoop().onDraw(canvas);
            getMEdgeEffectManager().draw(canvas);
            super.onDraw(canvas);
        }
    }

    public final void onFling(boolean isStarted) {
        AbstractC4539a.m3208r("onFlingGesture isStarted=", TAG, isStarted);
        if (isStarted) {
            getMDvfsManager().acquire();
            getView().requestDisallowInterceptTouchEvent(true);
        } else {
            getMDvfsManager().release();
            getView().requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        if (accessibilityDelegateImpl != null) {
            accessibilityDelegateImpl.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 8) {
            return super.onGenericMotionEvent(event);
        }
        Log.i(TAG, "[JavaGesture] onGenericMotionEvent event=" + event.getAction());
        return handleMouseWheel(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isNativeHandleValid()) {
            return false;
        }
        if (event.getToolType(0) == 2 || event.getToolType(0) == 3) {
            handleHover(new SpenMotionEvent(event));
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (isNativeHandleValid()) {
            int i = right - left;
            int i2 = bottom - top;
            if (i <= 0 || i2 <= 0) {
                return;
            }
            super.onLayout(changed, left, top, right, bottom);
            Log.i(TAG, "onLayout begin");
            if (this.mScreenWidth == i && this.mScreenHeight == i2) {
                Log.i(TAG, "onLayout end - same width, height");
                return;
            }
            this.mScreenWidth = i;
            this.mScreenHeight = i2;
            getMSpenDrawLoop().setScreenSize(i, i2);
            getMEdgeEffectManager().setScreenInfo(i, i2, 0, 0);
            handleLayout(changed, left, top, right, bottom);
            getMSpenDrawLoop().onLayout(changed);
            Log.i(TAG, "onLayout end");
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        if (getView().getWindowVisibility() == 0) {
            if (screenState == 0) {
                getMOrientationListener().disable();
            } else {
                getMOrientationListener().enable();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isNativeHandleValid()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.mIsTouchDown = true;
        }
        if (actionMasked == 3 && !this.mIsTouchDown) {
            Log.i(TAG, "[JavaGesture] Note ignore touch cancel because we didn't receive touch down first.");
            return false;
        }
        getMEdgeEffectManager().onTouch(event);
        boolean zOnTouchEvent = super.onTouchEvent(event) | handleTouch(event);
        if (actionMasked != 1 && actionMasked != 3) {
            return zOnTouchEvent;
        }
        this.mIsTouchDown = false;
        return zOnTouchEvent;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            getMSpenDrawLoop().onResume();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            getMOrientationListener().enable();
        } else {
            getMOrientationListener().disable();
        }
    }

    public final void releaseTextureView(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeView(getMTextureView());
        getMTextureView().setSurfaceTextureListener(null);
    }

    public final void setMAccDelegateImpl(@Nullable AccessibilityDelegateImpl accessibilityDelegateImpl) {
        this.mAccDelegateImpl = accessibilityDelegateImpl;
    }

    public final void setMActivity(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    public final void setMContextMenu(@Nullable SpenComposerContextMenu spenComposerContextMenu) {
        this.mContextMenu = spenComposerContextMenu;
    }

    public final void setMDvfsManager(@NotNull SpenDvfsManager spenDvfsManager) {
        Intrinsics.checkNotNullParameter(spenDvfsManager, "<set-?>");
        this.mDvfsManager = spenDvfsManager;
    }

    public final void setMEdgeEffectManager(@NotNull SpenEdgeEffectManager spenEdgeEffectManager) {
        Intrinsics.checkNotNullParameter(spenEdgeEffectManager, "<set-?>");
        this.mEdgeEffectManager = spenEdgeEffectManager;
    }

    public final void setMHoverPointerIcon(@NotNull SpenHoverPointerIcon spenHoverPointerIcon) {
        Intrinsics.checkNotNullParameter(spenHoverPointerIcon, "<set-?>");
        this.mHoverPointerIcon = spenHoverPointerIcon;
    }

    public final void setMIsTouchDown(boolean z) {
        this.mIsTouchDown = z;
    }

    public final void setMLifecycleCallback(@NotNull LifecycleCallback lifecycleCallback) {
        Intrinsics.checkNotNullParameter(lifecycleCallback, "<set-?>");
        this.mLifecycleCallback = lifecycleCallback;
    }

    public final void setMOrientationListener(@NotNull OrientationEventListener orientationEventListener) {
        Intrinsics.checkNotNullParameter(orientationEventListener, "<set-?>");
        this.mOrientationListener = orientationEventListener;
    }

    public final void setMScreenHeight(int i) {
        this.mScreenHeight = i;
    }

    public final void setMScreenWidth(int i) {
        this.mScreenWidth = i;
    }

    public final void setMSpenConfiguration(@NotNull SpenConfiguration spenConfiguration) {
        Intrinsics.checkNotNullParameter(spenConfiguration, "<set-?>");
        this.mSpenConfiguration = spenConfiguration;
    }

    public final void setMSpenDisplay(@NotNull SpenDisplay spenDisplay) {
        Intrinsics.checkNotNullParameter(spenDisplay, "<set-?>");
        this.mSpenDisplay = spenDisplay;
    }

    public final void setMSpenDrawLoop(@NotNull SpenDrawLoopInterface spenDrawLoopInterface) {
        Intrinsics.checkNotNullParameter(spenDrawLoopInterface, "<set-?>");
        this.mSpenDrawLoop = spenDrawLoopInterface;
    }

    public final void setMTextureView(@NotNull TextureView textureView) {
        Intrinsics.checkNotNullParameter(textureView, "<set-?>");
        this.mTextureView = textureView;
    }

    public final void startActionMode() {
        Log.i(TAG, "startActionMode");
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.startActionMode();
        }
    }

    public final void stopActionMode() {
        Log.i(TAG, "stopActionMode");
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.hideContextMenu();
        }
    }

    public final void updateScreenOrientation(@Nullable Context context) {
        getMSpenDisplay().updateScreenOrientation(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenZoomScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenZoomScrollView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
    }
}
