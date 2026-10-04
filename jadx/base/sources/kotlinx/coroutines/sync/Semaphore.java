package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, m13886d2 = {"Lkotlinx/coroutines/sync/Semaphore;", "", "availablePermits", "", "getAvailablePermits", "()I", "acquire", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAcquire", "", "release", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface Semaphore {
    @Nullable
    Object acquire(@NotNull Continuation<? super Unit> continuation);

    int getAvailablePermits();

    void release();

    boolean tryAcquire();
}
