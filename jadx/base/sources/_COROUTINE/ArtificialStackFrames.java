package _COROUTINE;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, m13886d2 = {"L_COROUTINE/ArtificialStackFrames;", "", "<init>", "()V", "coroutineCreation", "Ljava/lang/StackTraceElement;", "coroutineBoundary", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ArtificialStackFrames {
    @NotNull
    public final StackTraceElement coroutineBoundary() {
        return CoroutineDebuggingKt.artificialFrame(new Exception(), "_BOUNDARY");
    }

    @NotNull
    public final StackTraceElement coroutineCreation() {
        return CoroutineDebuggingKt.artificialFrame(new Exception(), "_CREATION");
    }
}
