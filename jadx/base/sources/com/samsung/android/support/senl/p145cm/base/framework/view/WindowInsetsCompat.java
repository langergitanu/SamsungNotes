package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.graphics.Insets;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsets;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ \u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat;", "", "<init>", "()V", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$WindowInsetsDelegateImpl;", "isFullScreenWindow", "", "insets", "Landroid/view/WindowInsets;", "findRotationByWindowInsets", "", "hasGestureNavigation", "undefinedValue", "setFitInsetsTypesNavigationBar", "", "window", "Landroid/view/Window;", "WindowInsetsImpl", "WindowInsetsDelegateImpl", "WindowInsetsDelegateBelowRImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WindowInsetsCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "WindowInsetCompat";

    @Nullable
    private static WindowInsetsCompat mInstance;

    @NotNull
    private WindowInsetsDelegateImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat;", "findRotationByWindowInsetsInner", "", "left", "top", "right", "bottom", "hasGestureNavigation", "", "undefinedValue", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int findRotationByWindowInsetsInner(int left, int top, int right, int bottom, boolean hasGestureNavigation, int undefinedValue) {
            if (top != 0 || bottom != 0 || left != 0 || right != 0) {
                if (bottom > 0) {
                    undefinedValue = 0;
                } else {
                    undefinedValue = 1;
                    if (right > left) {
                        if (hasGestureNavigation) {
                            undefinedValue = 3;
                        }
                    } else if (right >= left) {
                        undefinedValue = 2;
                    } else if (!hasGestureNavigation) {
                    }
                }
            }
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(top, bottom, "findRotationByWindowInsetsInner# top/bottom/left/right/rotation ", "/", "/");
            AbstractC2821a.m2235z(sbM1173s, left, right, "/", "/");
            sbM1173s.append(undefinedValue);
            companion.m7132d(WindowInsetsCompat.TAG, sbM1173s.toString());
            return undefinedValue;
        }

        @NotNull
        public final synchronized WindowInsetsCompat getInstance() {
            WindowInsetsCompat windowInsetsCompat;
            try {
                if (WindowInsetsCompat.mInstance == null) {
                    WindowInsetsCompat.mInstance = new WindowInsetsCompat(null);
                }
                windowInsetsCompat = WindowInsetsCompat.mInstance;
                Intrinsics.checkNotNull(windowInsetsCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat");
            } catch (Throwable th) {
                throw th;
            }
            return windowInsetsCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$WindowInsetsDelegateBelowRImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$WindowInsetsDelegateImpl;", "<init>", "()V", "isFullScreenWindow", "", "insets", "Landroid/view/WindowInsets;", "findRotationByWindowInsets", "", "hasGestureNavigation", "undefinedValue", "setFitInsetsTypesNavigationBar", "", "window", "Landroid/view/Window;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class WindowInsetsDelegateBelowRImpl extends WindowInsetsDelegateImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsDelegateImpl, com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsImpl
        public int findRotationByWindowInsets(@NotNull WindowInsets insets, boolean hasGestureNavigation, int undefinedValue) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            return WindowInsetsCompat.INSTANCE.findRotationByWindowInsetsInner(insets.getStableInsetLeft(), insets.getStableInsetTop(), insets.getStableInsetRight(), insets.getStableInsetBottom(), hasGestureNavigation, undefinedValue);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsDelegateImpl, com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsImpl
        public boolean isFullScreenWindow(@NotNull WindowInsets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            LoggerBase.INSTANCE.m7132d(WindowInsetsCompat.TAG, "isFullScreenWindow# insets " + insets);
            return insets.getStableInsetBottom() + (insets.getStableInsetRight() + (insets.getStableInsetTop() + insets.getStableInsetLeft())) == 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsDelegateImpl, com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsImpl
        public void setFitInsetsTypesNavigationBar(@NotNull Window window) {
            Intrinsics.checkNotNullParameter(window, "window");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$WindowInsetsDelegateImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$WindowInsetsImpl;", "<init>", "()V", "isFullScreenWindow", "", "insets", "Landroid/view/WindowInsets;", "findRotationByWindowInsets", "", "hasGestureNavigation", "undefinedValue", "setFitInsetsTypesNavigationBar", "", "window", "Landroid/view/Window;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class WindowInsetsDelegateImpl implements WindowInsetsImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsImpl
        public int findRotationByWindowInsets(@NotNull WindowInsets insets, boolean hasGestureNavigation, int undefinedValue) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Insets insets2 = insets.getInsets(WindowInsets.Type.statusBars());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            Insets insets3 = insets.getInsets(WindowInsets.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
            return WindowInsetsCompat.INSTANCE.findRotationByWindowInsetsInner(insets3.left, insets2.top, insets3.right, insets3.bottom, hasGestureNavigation, undefinedValue);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsImpl
        public boolean isFullScreenWindow(@NotNull WindowInsets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Insets insets2 = insets.getInsets(WindowInsets.Type.statusBars());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            Insets insets3 = insets.getInsets(WindowInsets.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
            LoggerBase.INSTANCE.m7132d(WindowInsetsCompat.TAG, "isFullScreenWindow# statusBar/navigationBar insets " + insets2 + "/" + insets3);
            return (insets3.bottom + (insets3.right + (insets3.top + insets3.left))) + (insets2.bottom + (insets2.right + (insets2.top + insets2.left))) == 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.WindowInsetsCompat.WindowInsetsImpl
        public void setFitInsetsTypesNavigationBar(@NotNull Window window) {
            Intrinsics.checkNotNullParameter(window, "window");
            LoggerBase.INSTANCE.m7132d(WindowInsetsCompat.TAG, "setFitInsetsTypesNavigationBar#");
            window.getAttributes().setFitInsetsTypes(WindowInsets.Type.navigationBars());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowInsetsCompat$WindowInsetsImpl;", "", "isFullScreenWindow", "", "insets", "Landroid/view/WindowInsets;", "findRotationByWindowInsets", "", "hasGestureNavigation", "undefinedValue", "setFitInsetsTypesNavigationBar", "", "window", "Landroid/view/Window;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface WindowInsetsImpl {
        int findRotationByWindowInsets(@NotNull WindowInsets insets, boolean hasGestureNavigation, int undefinedValue);

        boolean isFullScreenWindow(@NotNull WindowInsets insets);

        void setFitInsetsTypesNavigationBar(@NotNull Window window);
    }

    public /* synthetic */ WindowInsetsCompat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public static final synchronized WindowInsetsCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final int findRotationByWindowInsets(@Nullable WindowInsets insets, boolean hasGestureNavigation, int undefinedValue) {
        return insets == null ? undefinedValue : this.mImpl.findRotationByWindowInsets(insets, hasGestureNavigation, undefinedValue);
    }

    public final boolean isFullScreenWindow(@Nullable WindowInsets insets) {
        if (insets == null) {
            return false;
        }
        return this.mImpl.isFullScreenWindow(insets);
    }

    public final void setFitInsetsTypesNavigationBar(@Nullable Window window) {
        if (window == null) {
            return;
        }
        this.mImpl.setFitInsetsTypesNavigationBar(window);
    }

    private WindowInsetsCompat() {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new WindowInsetsDelegateImpl() : new WindowInsetsDelegateBelowRImpl();
    }
}
