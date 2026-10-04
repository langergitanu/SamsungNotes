package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0007\u001d\u001e\u001f !\"#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat;", "", "<init>", "()V", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$WindowDisplayCutoutDelegateImpl;", "mListeners", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutRectsListener;", "setDisplayCutoutMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "type", "", "Landroid/view/WindowManager$LayoutParams;", "windowAttribute", "setDisplayCutoutBGColor", "color", "registerBoundingRectsListener", "view", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterBoundingRectsListener", "getBoundingRects", "", "Landroid/graphics/Rect;", "windowInsets", "Landroid/view/WindowInsets;", "DisplayCutoutRectsListener", "OnApplyWindowInsetsListener", "WindowDisplayCutoutDelegateImpl", "DisplayCutoutDelegateSem", "DisplayCutoutDelegatePure", "DisplayCutoutDelegateNotSupported", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayCutoutCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "DisplayCutoutCompat";

    @Nullable
    private static DisplayCutoutCompat mInstance;

    @Nullable
    private WindowDisplayCutoutDelegateImpl mImpl;

    @NotNull
    private final SparseArray<DisplayCutoutRectsListener> mListeners;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "instance", "Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat;", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat;", "mInstance", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized DisplayCutoutCompat getInstance() {
            DisplayCutoutCompat displayCutoutCompat;
            try {
                if (DisplayCutoutCompat.mInstance == null) {
                    DisplayCutoutCompat.mInstance = new DisplayCutoutCompat(null);
                }
                displayCutoutCompat = DisplayCutoutCompat.mInstance;
                Intrinsics.checkNotNull(displayCutoutCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat");
            } catch (Throwable th) {
                throw th;
            }
            return displayCutoutCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutDelegateNotSupported;", "Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$WindowDisplayCutoutDelegateImpl;", "<init>", "()V", "setDisplayCutoutMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "type", "", "Landroid/view/WindowManager$LayoutParams;", "windowAttribute", "setDisplayCutoutBGColor", "color", "getBoundingRects", "", "Landroid/graphics/Rect;", "windowInsets", "Landroid/view/WindowInsets;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DisplayCutoutDelegateNotSupported implements WindowDisplayCutoutDelegateImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        @NotNull
        public List<Rect> getBoundingRects(@Nullable WindowInsets windowInsets) {
            return new ArrayList();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        public void setDisplayCutoutBGColor(@NotNull Activity activity, int color) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        @Nullable
        public WindowManager.LayoutParams setDisplayCutoutMode(@NotNull WindowManager.LayoutParams windowAttribute, int type) {
            Intrinsics.checkNotNullParameter(windowAttribute, "windowAttribute");
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        public void setDisplayCutoutMode(@NotNull Activity activity, int type) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutDelegateSem;", "Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutDelegatePure;", "<init>", "()V", "setDisplayCutoutBGColor", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "color", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DisplayCutoutDelegateSem extends DisplayCutoutDelegatePure {
        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.DisplayCutoutDelegateNotSupported, com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        public void setDisplayCutoutBGColor(@NotNull Activity activity, int color) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            try {
                Class.forName(View.class.getName()).getMethod("semSetDisplayCutoutBackgroundColor", Integer.TYPE).invoke(decorView, Integer.valueOf(color));
            } catch (Exception e) {
                AbstractC0000a.m23t("setDisplayCutoutBGColor: ", e.getMessage(), LoggerBase.INSTANCE, DisplayCutoutCompat.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutRectsListener;", "", "onChangeBoundingRects", "", "rects", "", "Landroid/graphics/Rect;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DisplayCutoutRectsListener {
        void onChangeBoundingRects(@Nullable List<Rect> rects);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$OnApplyWindowInsetsListener;", "Landroid/view/View$OnApplyWindowInsetsListener;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat;)V", "onApplyWindowInsets", "Landroid/view/WindowInsets;", VPathDataCmd.RCurveTo, "Landroid/view/View;", "insets", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
        public OnApplyWindowInsetsListener() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        @NotNull
        public WindowInsets onApplyWindowInsets(@NotNull View v, @NotNull WindowInsets insets) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(insets, "insets");
            WindowInsets windowInsetsConsumeStableInsets = insets.consumeStableInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsetsConsumeStableInsets, "consumeStableInsets(...)");
            DisplayCutoutRectsListener displayCutoutRectsListener = (DisplayCutoutRectsListener) DisplayCutoutCompat.this.mListeners.get(v.hashCode());
            if (displayCutoutRectsListener != null) {
                int[] iArr = new int[2];
                v.getLocationInWindow(iArr);
                Rect rect = new Rect();
                v.getLocalVisibleRect(rect);
                rect.offset(iArr[0], iArr[1]);
                List<Rect> boundingRects = DisplayCutoutCompat.INSTANCE.getInstance().getBoundingRects(windowInsetsConsumeStableInsets);
                Integer numValueOf = boundingRects != null ? Integer.valueOf(boundingRects.size()) : null;
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    for (int i = 0; i < iIntValue; i++) {
                        if (rect.intersect(boundingRects.get(i))) {
                            displayCutoutRectsListener.onChangeBoundingRects(boundingRects);
                            return insets;
                        }
                    }
                }
            }
            return insets;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$WindowDisplayCutoutDelegateImpl;", "", "setDisplayCutoutMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "type", "", "Landroid/view/WindowManager$LayoutParams;", "windowAttribute", "setDisplayCutoutBGColor", "color", "getBoundingRects", "", "Landroid/graphics/Rect;", "windowInsets", "Landroid/view/WindowInsets;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface WindowDisplayCutoutDelegateImpl {
        @NotNull
        List<Rect> getBoundingRects(@Nullable WindowInsets windowInsets);

        void setDisplayCutoutBGColor(@NotNull Activity activity, int color);

        @Nullable
        WindowManager.LayoutParams setDisplayCutoutMode(@NotNull WindowManager.LayoutParams windowAttribute, int type);

        void setDisplayCutoutMode(@NotNull Activity activity, int type);
    }

    public /* synthetic */ DisplayCutoutCompat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Rect> getBoundingRects(WindowInsets windowInsets) {
        WindowDisplayCutoutDelegateImpl windowDisplayCutoutDelegateImpl = this.mImpl;
        if (windowDisplayCutoutDelegateImpl != null) {
            return windowDisplayCutoutDelegateImpl.getBoundingRects(windowInsets);
        }
        return null;
    }

    @NotNull
    public static final synchronized DisplayCutoutCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final void registerBoundingRectsListener(@Nullable View view, @NotNull DisplayCutoutRectsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (view == null) {
            return;
        }
        OnApplyWindowInsetsListener onApplyWindowInsetsListener = new OnApplyWindowInsetsListener();
        this.mListeners.put(view.hashCode(), listener);
        view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
    }

    public final void setDisplayCutoutBGColor(@Nullable Activity activity, int color) {
        WindowDisplayCutoutDelegateImpl windowDisplayCutoutDelegateImpl;
        if (activity == null || (windowDisplayCutoutDelegateImpl = this.mImpl) == null) {
            return;
        }
        windowDisplayCutoutDelegateImpl.setDisplayCutoutBGColor(activity, color);
    }

    public final void setDisplayCutoutMode(@Nullable Activity activity, int type) {
        WindowDisplayCutoutDelegateImpl windowDisplayCutoutDelegateImpl;
        if (activity == null || (windowDisplayCutoutDelegateImpl = this.mImpl) == null) {
            return;
        }
        windowDisplayCutoutDelegateImpl.setDisplayCutoutMode(activity, type);
    }

    public final void unregisterBoundingRectsListener(@Nullable View view) {
        if (view == null) {
            return;
        }
        this.mListeners.remove(view.hashCode());
        view.setOnApplyWindowInsetsListener(null);
    }

    private DisplayCutoutCompat() {
        this.mListeners = new SparseArray<>();
        this.mImpl = Build.VERSION.SDK_INT > 27 ? DeviceInfo.isSemDevice() ? new DisplayCutoutDelegateSem() : new DisplayCutoutDelegatePure() : new DisplayCutoutDelegateNotSupported();
    }

    @Nullable
    public final WindowManager.LayoutParams setDisplayCutoutMode(@Nullable WindowManager.LayoutParams windowAttribute, int type) {
        WindowDisplayCutoutDelegateImpl windowDisplayCutoutDelegateImpl;
        if (windowAttribute == null || (windowDisplayCutoutDelegateImpl = this.mImpl) == null) {
            return null;
        }
        return windowDisplayCutoutDelegateImpl.setDisplayCutoutMode(windowAttribute, type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutDelegatePure;", "Lcom/samsung/android/support/senl/cm/base/framework/view/DisplayCutoutCompat$DisplayCutoutDelegateNotSupported;", "<init>", "()V", "setDisplayCutoutMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "type", "", "Landroid/view/WindowManager$LayoutParams;", "windowAttribute", "getBoundingRects", "", "Landroid/graphics/Rect;", "windowInsets", "Landroid/view/WindowInsets;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DisplayCutoutDelegatePure extends DisplayCutoutDelegateNotSupported {
        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.DisplayCutoutDelegateNotSupported, com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        @NotNull
        public List<Rect> getBoundingRects(@Nullable WindowInsets windowInsets) {
            ArrayList arrayList = new ArrayList();
            try {
                Object objInvoke = WindowInsets.class.getDeclaredMethod("getDisplayCutout", null).invoke(windowInsets, null);
                Rect rect = new Rect();
                if (objInvoke != null) {
                    Class<?> cls = objInvoke.getClass();
                    Object objInvoke2 = cls.getDeclaredMethod("getSafeInsetTop", null).invoke(objInvoke, null);
                    Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) objInvoke2).intValue();
                    Object objInvoke3 = cls.getDeclaredMethod("getSafeInsetBottom", null).invoke(objInvoke, null);
                    Intrinsics.checkNotNull(objInvoke3, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue2 = ((Integer) objInvoke3).intValue();
                    Object objInvoke4 = cls.getDeclaredMethod("getSafeInsetLeft", null).invoke(objInvoke, null);
                    Intrinsics.checkNotNull(objInvoke4, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue3 = ((Integer) objInvoke4).intValue();
                    Object objInvoke5 = cls.getDeclaredMethod("getSafeInsetRight", null).invoke(objInvoke, null);
                    Intrinsics.checkNotNull(objInvoke5, "null cannot be cast to non-null type kotlin.Int");
                    rect.set(iIntValue3, iIntValue, ((Integer) objInvoke5).intValue(), iIntValue2);
                    Object objInvoke6 = cls.getDeclaredMethod("getBoundingRects", null).invoke(objInvoke, null);
                    Intrinsics.checkNotNull(objInvoke6, "null cannot be cast to non-null type kotlin.collections.List<android.graphics.Rect>");
                    arrayList.addAll((List) objInvoke6);
                    return arrayList;
                }
            } catch (IllegalAccessException e) {
                AbstractC0000a.m23t("failed to get list of bounding rect : ", e.getMessage(), LoggerBase.INSTANCE, DisplayCutoutCompat.TAG);
            } catch (NoSuchMethodException e2) {
                AbstractC0000a.m23t("failed to get list of bounding rect : ", e2.getMessage(), LoggerBase.INSTANCE, DisplayCutoutCompat.TAG);
            } catch (InvocationTargetException e3) {
                AbstractC0000a.m23t("failed to get list of bounding rect : ", e3.getMessage(), LoggerBase.INSTANCE, DisplayCutoutCompat.TAG);
            }
            return arrayList;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.DisplayCutoutDelegateNotSupported, com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        public void setDisplayCutoutMode(@NotNull Activity activity, int type) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(attributes, type);
                window.setAttributes(attributes);
                LoggerBase.INSTANCE.m7132d(DisplayCutoutCompat.TAG, "layoutInDisplayCutoutMode. " + type);
            } catch (Exception e) {
                AbstractC0000a.m23t("setDisplayCutoutMode: ", e.getMessage(), LoggerBase.INSTANCE, DisplayCutoutCompat.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.DisplayCutoutDelegateNotSupported, com.samsung.android.support.senl.cm.base.framework.view.DisplayCutoutCompat.WindowDisplayCutoutDelegateImpl
        @Nullable
        public WindowManager.LayoutParams setDisplayCutoutMode(@NotNull WindowManager.LayoutParams windowAttribute, int type) {
            Intrinsics.checkNotNullParameter(windowAttribute, "windowAttribute");
            try {
                Field field = windowAttribute.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(windowAttribute, type);
                LoggerBase.INSTANCE.m7132d(DisplayCutoutCompat.TAG, "layoutInDisplayCutoutMode. " + type);
                return windowAttribute;
            } catch (Exception e) {
                AbstractC0000a.m23t("setDisplayCutoutMode: ", e.getMessage(), LoggerBase.INSTANCE, DisplayCutoutCompat.TAG);
                return windowAttribute;
            }
        }
    }
}
