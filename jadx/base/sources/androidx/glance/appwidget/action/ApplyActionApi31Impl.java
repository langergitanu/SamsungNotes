package androidx.glance.appwidget.action;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/action/ApplyActionApi31Impl;", "", "()V", "setOnCheckedChangeResponse", "", "rv", "Landroid/widget/RemoteViews;", "viewId", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/app/PendingIntent;", "Landroid/content/Intent;", "unsetOnCheckedChangeResponse", "unsetOnClickResponse", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class ApplyActionApi31Impl {

    @NotNull
    public static final ApplyActionApi31Impl INSTANCE = new ApplyActionApi31Impl();

    private ApplyActionApi31Impl() {
    }

    @DoNotInline
    public final void setOnCheckedChangeResponse(@NotNull RemoteViews rv, int viewId, @NotNull PendingIntent intent) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(intent, "intent");
        rv.setOnCheckedChangeResponse(viewId, RemoteViews.RemoteResponse.fromPendingIntent(intent));
    }

    @DoNotInline
    public final void unsetOnCheckedChangeResponse(@NotNull RemoteViews rv, int viewId) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        rv.setOnCheckedChangeResponse(viewId, new RemoteViews.RemoteResponse());
    }

    @DoNotInline
    public final void unsetOnClickResponse(@NotNull RemoteViews rv, int viewId) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        rv.setOnClickResponse(viewId, new RemoteViews.RemoteResponse());
    }

    @DoNotInline
    public final void setOnCheckedChangeResponse(@NotNull RemoteViews rv, int viewId, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(intent, "intent");
        rv.setOnCheckedChangeResponse(viewId, RemoteViews.RemoteResponse.fromFillInIntent(intent));
    }
}
