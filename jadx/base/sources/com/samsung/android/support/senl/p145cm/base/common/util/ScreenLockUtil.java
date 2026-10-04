package com.samsung.android.support.senl.p145cm.base.common.util;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/ScreenLockUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "coverWindow", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uncoverWindow", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenLockUtil {

    @NotNull
    public static final ScreenLockUtil INSTANCE = new ScreenLockUtil();

    @NotNull
    private static final String TAG = "ScreenLockUtil";

    private ScreenLockUtil() {
    }

    @JvmStatic
    public static final void coverWindow(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(window.getStatusBarColor());
        decorView.setForeground(colorDrawable);
        LoggerBase.INSTANCE.m7137i(TAG, "coverWindow setForeground ");
    }

    @JvmStatic
    public static final void uncoverWindow(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        if (window == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "uncoverWindow window is null");
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (decorView.getForeground() != null) {
            decorView.setForeground(null);
            LoggerBase.INSTANCE.m7137i(TAG, "uncoverWindow setForeground ");
        }
    }
}
