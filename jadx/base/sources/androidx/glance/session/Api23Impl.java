package androidx.glance.session;

import android.os.PowerManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/session/Api23Impl;", "", "()V", "isIdle", "", "pm", "Landroid/os/PowerManager;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class Api23Impl {

    @NotNull
    public static final Api23Impl INSTANCE = new Api23Impl();

    private Api23Impl() {
    }

    @DoNotInline
    public final boolean isIdle(@NotNull PowerManager pm) {
        Intrinsics.checkNotNullParameter(pm, "pm");
        return pm.isDeviceIdleMode();
    }
}
