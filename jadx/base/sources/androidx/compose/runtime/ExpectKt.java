package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, m13886d2 = {"ThreadLocal", "Landroidx/compose/runtime/ThreadLocal;", "T", "postIncrement", "", "Landroidx/compose/runtime/AtomicInt;", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ExpectKt {
    @NotNull
    public static final <T> ThreadLocal<T> ThreadLocal() {
        return new ThreadLocal<>(new Function0<T>() { // from class: androidx.compose.runtime.ExpectKt.ThreadLocal.1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final T invoke() {
                return null;
            }
        });
    }

    public static final int postIncrement(@NotNull AtomicInt atomicInt) {
        return atomicInt.add(1) - 1;
    }
}
