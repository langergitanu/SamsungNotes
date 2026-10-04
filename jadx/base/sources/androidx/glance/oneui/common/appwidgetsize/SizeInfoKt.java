package androidx.glance.oneui.common.appwidgetsize;

import android.os.Bundle;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import androidx.glance.oneui.common.AppWidgetConstants;
import androidx.glance.oneui.common.AppWidgetSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0007\u001a\u001c\u0010\u0007\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0007¨\u0006\n"}, m13886d2 = {"getDensity", "", "Landroid/os/Bundle;", "getHostKey", "", "toAppWidgetSizeInfo", "Landroidx/glance/oneui/common/appwidgetsize/AppWidgetSizeInfo;", "toBundle", "hostKey", "density", "glance-oneui-common_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SizeInfoKt {
    @RequiresApi(36)
    public static final float getDensity(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return bundle.getFloat(AppWidgetConstants.OPTION_APPWIDGET_DISPLAY_DENSITY, 0.0f);
    }

    @RequiresApi(36)
    public static final int getHostKey(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return bundle.getInt("hostKey", 0);
    }

    @RequiresApi(36)
    @Nullable
    public static final AppWidgetSizeInfo toAppWidgetSizeInfo(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        SizeF sizeF = (SizeF) bundle.getParcelable("appWidgetSizes", SizeF.class);
        int i = bundle.getInt("semAppWidgetRowSpan", 0);
        int i2 = bundle.getInt("semAppWidgetColumnSpan", 0);
        int i4 = bundle.getInt(AppWidgetConstants.OPTION_APPWIDGET_SIZE, 0);
        if (sizeF == null) {
            return null;
        }
        return new AppWidgetSizeInfo(sizeF, new SpanSize(i2, i), AppWidgetSize.m21547constructorimpl(i4), null);
    }

    @RequiresApi(36)
    @NotNull
    public static final Bundle toBundle(@NotNull AppWidgetSizeInfo appWidgetSizeInfo, int i, float f) {
        Intrinsics.checkNotNullParameter(appWidgetSizeInfo, "<this>");
        Bundle bundle = new Bundle();
        bundle.putInt("hostKey", i);
        bundle.putFloat(AppWidgetConstants.OPTION_APPWIDGET_DISPLAY_DENSITY, f);
        bundle.putParcelable("appWidgetSizes", new SizeF(appWidgetSizeInfo.getDpSize().getWidth(), appWidgetSizeInfo.getDpSize().getHeight()));
        bundle.putInt("semAppWidgetRowSpan", appWidgetSizeInfo.getSpanSize().getRow());
        bundle.putInt("semAppWidgetColumnSpan", appWidgetSizeInfo.getSpanSize().getCol());
        bundle.putInt(AppWidgetConstants.OPTION_APPWIDGET_SIZE, AppWidgetSize.m21557toIntimpl(appWidgetSizeInfo.m21618getAppWidgetSizerx25Pp4()));
        return bundle;
    }
}
