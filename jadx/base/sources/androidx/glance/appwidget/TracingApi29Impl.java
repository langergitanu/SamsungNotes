package androidx.glance.appwidget;

import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/TracingApi29Impl;", "", "()V", "beginAsyncSection", "", "methodName", "", "cookie", "", "endAsyncSection", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TracingApi29Impl {
    public static final int $stable = 0;

    @NotNull
    public static final TracingApi29Impl INSTANCE = new TracingApi29Impl();

    private TracingApi29Impl() {
    }

    @DoNotInline
    public final void beginAsyncSection(@NotNull String methodName, int cookie) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Trace.beginAsyncSection(methodName, cookie);
    }

    @DoNotInline
    public final void endAsyncSection(@NotNull String methodName, int cookie) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Trace.endAsyncSection(methodName, cookie);
    }
}
