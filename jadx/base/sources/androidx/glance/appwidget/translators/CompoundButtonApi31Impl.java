package androidx.glance.appwidget.translators;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/appwidget/translators/CompoundButtonApi31Impl;", "", "()V", "setCompoundButtonChecked", "", "rv", "Landroid/widget/RemoteViews;", "viewId", "", "checked", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CompoundButtonApi31Impl {
    public static final int $stable = 0;

    @NotNull
    public static final CompoundButtonApi31Impl INSTANCE = new CompoundButtonApi31Impl();

    private CompoundButtonApi31Impl() {
    }

    @DoNotInline
    public final void setCompoundButtonChecked(@NotNull RemoteViews rv, int viewId, boolean checked) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        rv.setCompoundButtonChecked(viewId, checked);
    }
}
