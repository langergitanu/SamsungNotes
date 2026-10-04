package com.samsung.android.support.senl.docscan.common.util;

import android.app.Activity;
import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/common/util/CommonUtils;", "", "<init>", "()V", "runOnUiThread", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "action", "Ljava/lang/Runnable;", "isNotAvailableActivity", "", "isStandardViewOfFoldDevice", "context", "Landroid/content/Context;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CommonUtils {

    @NotNull
    public static final CommonUtils INSTANCE = new CommonUtils();

    private CommonUtils() {
    }

    @JvmStatic
    public static final boolean isNotAvailableActivity(@Nullable Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    @JvmStatic
    public static final boolean isStandardViewOfFoldDevice(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() && !ResourceUtils.isTabletLayout(context) && DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(context.getResources().getConfiguration());
    }

    @JvmStatic
    public static final void runOnUiThread(@NotNull Activity activity, @Nullable Runnable action) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (action == null || isNotAvailableActivity(activity)) {
            return;
        }
        activity.runOnUiThread(action);
    }
}
