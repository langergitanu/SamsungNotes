package com.samsung.android.support.senl.p148nt.base.common;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0003()*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ$\u0010\u001c\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010#¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager;", "", "<init>", "()V", "mWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "mSystemBarsInsets", "Landroidx/core/graphics/Insets;", "mCaptionBarInsets", "mDisplayCutoutInsets", "registerAnimationCallback", "", "container", "Landroid/view/View;", "animationCallback", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$AnimationCallback;", "unregisterAnimationCallback", "registerApplyListener", "applyListener", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$ApplyInsetListener;", "unregisterApplyListener", "applyAllInsets", "", "windowInsets", "hasInvalidWindowInset", "requestApplyInsets", "window", "Landroid/view/Window;", "requestAndGetInsets", "onReady", "Lkotlin/Function1;", "getWindowInsets", "()Landroidx/core/view/WindowInsetsCompat;", "systemBarInsets", "getSystemBarInsets", "()Landroidx/core/graphics/Insets;", "captionBarInsets", "getCaptionBarInsets", "displayCutoutInsets", "getDisplayCutoutInsets", "ApplyInsetListener", "AnimationCallback", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWindowInsetsManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowInsetsManager.kt\ncom/samsung/android/support/senl/nt/base/common/WindowInsetsManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1#2:174\n*E\n"})
public final class WindowInsetsManager {

    @NotNull
    private static final String TAG = "WindowInsetsManager";

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static WindowInsetsManager sWindowInsetsManager;

    @Nullable
    private Insets mCaptionBarInsets;

    @Nullable
    private Insets mDisplayCutoutInsets;

    @Nullable
    private Insets mSystemBarsInsets;

    @Nullable
    private WindowInsetsCompat mWindowInsets;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<Integer, AnimationCallback> mAnimationCallbacks = new LinkedHashMap();

    @NotNull
    private static final Map<Integer, ApplyInsetListener> mApplyListeners = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$AnimationCallback;", "", "onProgress", "", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "runningAnimations", "", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onEnd", "animation", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AnimationCallback {
        void onEnd(@NotNull WindowInsetsAnimationCompat animation);

        void onProgress(@NotNull WindowInsetsCompat windowInsets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$ApplyInsetListener;", "", "onApplyInsets", "", "view", "Landroid/view/View;", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ApplyInsetListener {
        void onApplyInsets(@NotNull View view, @NotNull WindowInsetsCompat windowInsetsCompat);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sWindowInsetsManager", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager;", "mAnimationCallbacks", "", "", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$AnimationCallback;", "mApplyListeners", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$ApplyInsetListener;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized WindowInsetsManager getInstance() {
            WindowInsetsManager windowInsetsManager;
            try {
                if (WindowInsetsManager.sWindowInsetsManager == null) {
                    WindowInsetsManager.sWindowInsetsManager = new WindowInsetsManager(null);
                }
                windowInsetsManager = WindowInsetsManager.sWindowInsetsManager;
                Intrinsics.checkNotNull(windowInsetsManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.WindowInsetsManager");
            } catch (Throwable th) {
                throw th;
            }
            return windowInsetsManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WindowInsetsManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean applyAllInsets(WindowInsetsCompat windowInsets) {
        if (windowInsets == null) {
            return false;
        }
        this.mWindowInsets = windowInsets;
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        Insets insets2 = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        Insets insets3 = windowInsets.getInsets(WindowInsetsCompat.Type.captionBar());
        Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
        boolean z = (Intrinsics.areEqual(insets, this.mSystemBarsInsets) && Intrinsics.areEqual(insets2, this.mDisplayCutoutInsets) && Intrinsics.areEqual(this.mCaptionBarInsets, insets3)) ? false : true;
        if (z) {
            this.mSystemBarsInsets = insets;
            this.mDisplayCutoutInsets = insets2;
            this.mCaptionBarInsets = insets3;
            Logger.m8702i(TAG, "applyAllInsets\nsystemBarsInsets:" + insets + "\ndisplayCutoutInsets:" + insets2 + "\ncaptionBarInsets:" + insets3 + "\n");
        }
        return z;
    }

    @NotNull
    public static final synchronized WindowInsetsManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat registerApplyListener$lambda$4$lambda$3(WindowInsetsManager windowInsetsManager, View view, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        windowInsetsManager.applyAllInsets(insets);
        Map<Integer, ApplyInsetListener> map = mApplyListeners;
        synchronized (map) {
            ApplyInsetListener applyInsetListener = map.get(Integer.valueOf(view.hashCode()));
            if (applyInsetListener != null) {
                applyInsetListener.onApplyInsets(v, insets);
                Unit unit = Unit.INSTANCE;
            }
        }
        return insets;
    }

    @NotNull
    public final Insets getCaptionBarInsets() {
        Insets insets = this.mCaptionBarInsets;
        if (insets != null) {
            return insets;
        }
        Insets NONE = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    @NotNull
    public final Insets getDisplayCutoutInsets() {
        Insets insets = this.mDisplayCutoutInsets;
        if (insets != null) {
            return insets;
        }
        Insets NONE = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    @NotNull
    public final Insets getSystemBarInsets() {
        Insets insets = this.mSystemBarsInsets;
        if (insets != null) {
            return insets;
        }
        Insets NONE = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    @NotNull
    public final WindowInsetsCompat getWindowInsets() {
        WindowInsetsCompat windowInsetsCompat = this.mWindowInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat;
        }
        WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
        Intrinsics.checkNotNullExpressionValue(CONSUMED, "CONSUMED");
        return CONSUMED;
    }

    public final boolean hasInvalidWindowInset() {
        return this.mWindowInsets == null;
    }

    public final void registerAnimationCallback(@Nullable final View container, @NotNull AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "animationCallback");
        if (container == null) {
            return;
        }
        Map<Integer, AnimationCallback> map = mAnimationCallbacks;
        synchronized (map) {
            map.put(Integer.valueOf(container.hashCode()), animationCallback);
            ViewCompat.setWindowInsetsAnimationCallback(container, new WindowInsetsAnimationCompat.Callback() { // from class: com.samsung.android.support.senl.nt.base.common.WindowInsetsManager$registerAnimationCallback$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public void onEnd(WindowInsetsAnimationCompat animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onEnd(animation);
                    WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(container);
                    if (rootWindowInsets != null) {
                        this.this$0.applyAllInsets(rootWindowInsets);
                    }
                    Map map2 = WindowInsetsManager.mAnimationCallbacks;
                    View view = container;
                    synchronized (map2) {
                        WindowInsetsManager.AnimationCallback animationCallback2 = (WindowInsetsManager.AnimationCallback) WindowInsetsManager.mAnimationCallbacks.get(Integer.valueOf(view.hashCode()));
                        if (animationCallback2 != null) {
                            animationCallback2.onEnd(animation);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                    Intrinsics.checkNotNullParameter(insets, "insets");
                    Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                    this.this$0.applyAllInsets(insets);
                    Map map2 = WindowInsetsManager.mAnimationCallbacks;
                    View view = container;
                    synchronized (map2) {
                        WindowInsetsManager.AnimationCallback animationCallback2 = (WindowInsetsManager.AnimationCallback) WindowInsetsManager.mAnimationCallbacks.get(Integer.valueOf(view.hashCode()));
                        if (animationCallback2 != null) {
                            animationCallback2.onProgress(insets, runningAnimations);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    return insets;
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerApplyListener(@Nullable View container, @NotNull ApplyInsetListener applyListener) {
        Intrinsics.checkNotNullParameter(applyListener, "applyListener");
        if (container == null) {
            return;
        }
        Map<Integer, ApplyInsetListener> map = mApplyListeners;
        synchronized (map) {
            map.put(Integer.valueOf(container.hashCode()), applyListener);
            ViewCompat.setOnApplyWindowInsetsListener(container, new C0287e(this, container, 14));
            Unit unit = Unit.INSTANCE;
        }
        ViewCompat.requestApplyInsets(container);
    }

    public final void requestAndGetInsets(@Nullable final View container, @NotNull final Function1<? super WindowInsetsCompat, Unit> onReady) {
        Intrinsics.checkNotNullParameter(onReady, "onReady");
        if (container == null) {
            return;
        }
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(container);
        if (rootWindowInsets != null) {
            onReady.invoke(rootWindowInsets);
        } else {
            registerApplyListener(container, new ApplyInsetListener() { // from class: com.samsung.android.support.senl.nt.base.common.WindowInsetsManager$requestAndGetInsets$once$1
                @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.ApplyInsetListener
                public void onApplyInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
                    this.this$0.applyAllInsets(windowInsetsCompat);
                    onReady.invoke(windowInsetsCompat);
                    this.this$0.unregisterApplyListener(container);
                }
            });
        }
    }

    public final void requestApplyInsets(@Nullable Window window) {
        if (window == null) {
            return;
        }
        ViewCompat.requestApplyInsets(window.getDecorView());
    }

    public final void unregisterAnimationCallback(@Nullable View container) {
        if (container == null) {
            return;
        }
        Map<Integer, AnimationCallback> map = mAnimationCallbacks;
        synchronized (map) {
            map.remove(Integer.valueOf(container.hashCode()));
            ViewCompat.setWindowInsetsAnimationCallback(container, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void unregisterApplyListener(@Nullable View container) {
        if (container == null) {
            return;
        }
        Map<Integer, ApplyInsetListener> map = mApplyListeners;
        synchronized (map) {
            map.remove(Integer.valueOf(container.hashCode()));
            ViewCompat.setOnApplyWindowInsetsListener(container, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    private WindowInsetsManager() {
    }
}
