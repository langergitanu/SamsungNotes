package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(28)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, m13886d2 = {"Landroidx/glance/appwidget/RemoteViewsTranslatorApi28Impl;", "", "()V", "copyRemoteViews", "Landroid/widget/RemoteViews;", "rv", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class RemoteViewsTranslatorApi28Impl {

    @NotNull
    public static final RemoteViewsTranslatorApi28Impl INSTANCE = new RemoteViewsTranslatorApi28Impl();

    private RemoteViewsTranslatorApi28Impl() {
    }

    @DoNotInline
    @NotNull
    public final RemoteViews copyRemoteViews(@NotNull RemoteViews rv) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        return new RemoteViews(rv);
    }
}
