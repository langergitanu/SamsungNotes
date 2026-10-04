package androidx.glance.appwidget.action;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/glance/appwidget/action/ApplyActionApi26Impl;", "", "()V", "getForegroundServicePendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class ApplyActionApi26Impl {

    @NotNull
    public static final ApplyActionApi26Impl INSTANCE = new ApplyActionApi26Impl();

    private ApplyActionApi26Impl() {
    }

    @DoNotInline
    @NotNull
    public final PendingIntent getForegroundServicePendingIntent(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        PendingIntent foregroundService = PendingIntent.getForegroundService(context, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(foregroundService, "getForegroundService(...)");
        return foregroundService;
    }
}
