package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"trace", "T", "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TraceKt {
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        Trace trace = Trace.INSTANCE;
        Object objBeginSection = trace.beginSection(str);
        try {
            T tInvoke = function0.invoke();
            InlineMarker.finallyStart(1);
            trace.endSection(objBeginSection);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            Trace.INSTANCE.endSection(objBeginSection);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
