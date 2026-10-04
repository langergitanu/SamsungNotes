package androidx.glance.oneui.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Point;
import android.util.Size;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.RestrictTo;
import androidx.glance.oneui.common.devicefeature.DeviceFeature;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\bH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0011"}, m13886d2 = {"DISPLAY_DEVICE_TYPE_MAIN", "", "DISPLAY_DEVICE_TYPE_SUB", "DISPLAY_DEVICE_TYPE_UNDEFINED", SearchConstants.TargetContents.TAG, "", "isOverSW360Dp", "", "Landroid/content/Context;", "(Landroid/content/Context;)Z", "isPortrait", "Landroid/content/res/Configuration;", "(Landroid/content/res/Configuration;)Z", "getDisplayDeviceType", "Landroidx/glance/oneui/common/DeviceType;", "getScreenSize", "Landroid/util/Size;", "glance-oneui-common_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class DeviceConfigUtilsKt {
    private static final int DISPLAY_DEVICE_TYPE_MAIN = 0;
    private static final int DISPLAY_DEVICE_TYPE_SUB = 5;
    private static final int DISPLAY_DEVICE_TYPE_UNDEFINED = -1;

    @NotNull
    private static final String TAG = "GWT:GlanceDeviceConfigUtils";

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceType getDisplayDeviceType(Context context) {
        DeviceFeature deviceFeature = DeviceFeature.INSTANCE;
        if (deviceFeature.isFlipModel()) {
            return DeviceType.Flip;
        }
        if (!deviceFeature.isFoldModel()) {
            return deviceFeature.isTabletModel() ? DeviceType.Tablet : DeviceType.Phone;
        }
        if (deviceFeature.isMultiFoldModel()) {
            int i = context.getResources().getConfiguration().semDisplayDeviceType;
            return i != 0 ? i != 5 ? DeviceType.MultiFoldMain : DeviceType.MultiFoldSub : DeviceType.MultiFoldMain;
        }
        int i2 = context.getResources().getConfiguration().semDisplayDeviceType;
        return i2 != 0 ? i2 != 5 ? DeviceType.FoldMain : DeviceType.FoldSub : DeviceType.FoldMain;
    }

    @SuppressLint({WarningType.NewApi})
    @NotNull
    public static final Size getScreenSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
        Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        point.x -= insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
        point.y -= insetsIgnoringVisibility.bottom + insetsIgnoringVisibility.top;
        float density = currentWindowMetrics.getDensity();
        return new Size(Math.round(point.x / density), Math.round(point.y / density));
    }

    public static final boolean isOverSW360Dp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getBoolean(C3081R.bool.is_sw_over_360_dp);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isPortrait(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        return configuration.orientation == 1;
    }
}
