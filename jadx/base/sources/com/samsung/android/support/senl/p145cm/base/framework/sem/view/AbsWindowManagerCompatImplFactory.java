package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IWindowManagerCompatImpl", "WindowManagerCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsWindowManagerCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0003H&J\"\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H&¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", "", "isMultiWindowMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getMultiWindowMode", "", "configuration", "Landroid/content/res/Configuration;", "exitMultiWindow", "isFreeFormWindow", "semIsPopOver", "setExtensionFlagDozeMode", "", "lp", "Landroid/view/WindowManager$LayoutParams;", "setExtensionFlagMultiWindowHandlerHidden", "setResizeFullscreenWindowOnSoftInput", "setForceHideFloatingMultiWindow", "setSensitivePalmRecognitionEnabled", "requestSystemKeyEvent", "keyCode", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "request", "canAllowByRegion", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "", "x", "y", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IWindowManagerCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int MULTIWINDOW_MODE_FREEFORM = 1;
        public static final int MULTIWINDOW_MODE_NONE = 0;
        public static final int MULTIWINDOW_MODE_SPLIT_SCREEN = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl$Companion;", "", "<init>", "()V", "MULTIWINDOW_MODE_NONE", "", "MULTIWINDOW_MODE_FREEFORM", "MULTIWINDOW_MODE_SPLIT_SCREEN", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int MULTIWINDOW_MODE_FREEFORM = 1;
            public static final int MULTIWINDOW_MODE_NONE = 0;
            public static final int MULTIWINDOW_MODE_SPLIT_SCREEN = 2;

            private Companion() {
            }
        }

        boolean canAllowByRegion(@Nullable String activityName, int x, int y2);

        boolean exitMultiWindow(@Nullable Activity activity);

        int getMultiWindowMode(@Nullable Activity activity);

        int getMultiWindowMode(@Nullable Configuration configuration);

        boolean isFreeFormWindow(@Nullable Activity activity);

        boolean isMultiWindowMode(@NotNull Activity activity);

        boolean requestSystemKeyEvent(int keyCode, @Nullable ComponentName componentName, boolean request);

        boolean semIsPopOver(@Nullable Activity activity);

        void setExtensionFlagDozeMode(@Nullable WindowManager.LayoutParams lp);

        void setExtensionFlagMultiWindowHandlerHidden(@Nullable WindowManager.LayoutParams lp);

        boolean setForceHideFloatingMultiWindow(@Nullable WindowManager.LayoutParams lp);

        boolean setResizeFullscreenWindowOnSoftInput(@Nullable WindowManager.LayoutParams lp);

        void setSensitivePalmRecognitionEnabled(@Nullable Activity activity);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\"\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$WindowManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", "<init>", "()V", "isMultiWindowMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getMultiWindowMode", "", "configuration", "Landroid/content/res/Configuration;", "isFreeFormWindow", "semIsPopOver", "exitMultiWindow", "setExtensionFlagDozeMode", "", "lp", "Landroid/view/WindowManager$LayoutParams;", "setExtensionFlagMultiWindowHandlerHidden", "setResizeFullscreenWindowOnSoftInput", "setForceHideFloatingMultiWindow", "setSensitivePalmRecognitionEnabled", "requestSystemKeyEvent", "keyCode", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "request", "canAllowByRegion", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "", "x", "y", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class WindowManagerCompatPureImpl implements IWindowManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean canAllowByRegion(@Nullable String activityName, int x, int y2) {
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean exitMultiWindow(@Nullable Activity activity) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public int getMultiWindowMode(@Nullable Activity activity) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isFreeFormWindow(@Nullable Activity activity) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isMultiWindowMode(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return activity.isInMultiWindowMode();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean requestSystemKeyEvent(int keyCode, @Nullable ComponentName componentName, boolean request) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean semIsPopOver(@Nullable Activity activity) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean setForceHideFloatingMultiWindow(@Nullable WindowManager.LayoutParams lp) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean setResizeFullscreenWindowOnSoftInput(@Nullable WindowManager.LayoutParams lp) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public int getMultiWindowMode(@Nullable Configuration configuration) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setExtensionFlagDozeMode(@Nullable WindowManager.LayoutParams lp) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setExtensionFlagMultiWindowHandlerHidden(@Nullable WindowManager.LayoutParams lp) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setSensitivePalmRecognitionEnabled(@Nullable Activity activity) {
        }
    }

    @NotNull
    public IWindowManagerCompatImpl create(int deviceType) {
        return new WindowManagerCompatPureImpl();
    }
}
