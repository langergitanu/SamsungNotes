package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/LayoutSelectionApi31Impl;", "", "()V", "remoteViews", "Landroid/widget/RemoteViews;", "packageName", "", "layoutId", "", "viewId", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class LayoutSelectionApi31Impl {

    @NotNull
    public static final LayoutSelectionApi31Impl INSTANCE = new LayoutSelectionApi31Impl();

    private LayoutSelectionApi31Impl() {
    }

    @DoNotInline
    @NotNull
    public final RemoteViews remoteViews(@NotNull String packageName, @LayoutRes int layoutId, int viewId) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new RemoteViews(packageName, layoutId, viewId);
    }
}
