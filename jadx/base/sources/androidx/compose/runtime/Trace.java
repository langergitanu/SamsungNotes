package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001¨\u0006\t"}, m13886d2 = {"Landroidx/compose/runtime/Trace;", "", "()V", "beginSection", "name", "", "endSection", "", ResponseType.TOKEN, "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Trace {
    public static final int $stable = 0;

    @NotNull
    public static final Trace INSTANCE = new Trace();

    private Trace() {
    }

    @Nullable
    public final Object beginSection(@NotNull String name) {
        android.os.Trace.beginSection(name);
        return null;
    }

    public final void endSection(@Nullable Object token) {
        android.os.Trace.endSection();
    }
}
