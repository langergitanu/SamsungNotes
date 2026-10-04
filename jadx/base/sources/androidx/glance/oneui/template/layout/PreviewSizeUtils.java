package androidx.glance.oneui.template.layout;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetManagerKt;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/PreviewSizeUtils;", "", "()V", "getAppWidgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "defaultPreviewSize", "getAppWidgetSize-aWA3r6Q", "(Landroid/content/Context;II)I", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PreviewSizeUtils {
    public static final int $stable = 0;

    @NotNull
    public static final PreviewSizeUtils INSTANCE = new PreviewSizeUtils();

    private PreviewSizeUtils() {
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "androidx.glance.oneui.common.AppWidgetManager.getBindAppWidgetSize(appWidgetId, defaultPreviewSize)", imports = {}))
    /* JADX INFO: renamed from: getAppWidgetSize-aWA3r6Q, reason: not valid java name */
    public final int m21786getAppWidgetSizeaWA3r6Q(@NotNull Context context, int appWidgetId, int defaultPreviewSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
        return AppWidgetManagerKt.m21539getBindAppWidgetSizenwmoUQ(appWidgetManager, appWidgetId, defaultPreviewSize);
    }
}
