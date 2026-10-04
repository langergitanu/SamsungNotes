package kotlinx.coroutines.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0006\u0010\u0015\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineExceptionHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "_exceptions", "", "", "_lock", "", "_coroutinesCleanedUp", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "uncaughtExceptions", "", "getUncaughtExceptions", "()Ljava/util/List;", "cleanupTestCoroutines", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestCoroutineExceptionHandler.kt\nkotlinx/coroutines/test/TestCoroutineExceptionHandler\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n27#2:37\n27#2:39\n27#2:41\n16#3:38\n16#3:40\n16#3:42\n1863#4,2:43\n*S KotlinDebug\n*F\n+ 1 TestCoroutineExceptionHandler.kt\nkotlinx/coroutines/test/TestCoroutineExceptionHandler\n*L\n15#1:37\n24#1:39\n27#1:41\n15#1:38\n24#1:40\n27#1:42\n31#1:43,2\n*E\n"})
public final class TestCoroutineExceptionHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private boolean _coroutinesCleanedUp;

    @NotNull
    private final List<Throwable> _exceptions;

    @NotNull
    private final Object _lock;

    public TestCoroutineExceptionHandler() {
        super(CoroutineExceptionHandler.INSTANCE);
        this._exceptions = new ArrayList();
        this._lock = new Object();
    }

    public final void cleanupTestCoroutines() {
        synchronized (this._lock) {
            try {
                this._coroutinesCleanedUp = true;
                Throwable th = (Throwable) CollectionsKt.firstOrNull((List) this._exceptions);
                if (th != null) {
                    Iterator it = CollectionsKt.drop(this._exceptions, 1).iterator();
                    while (it.hasNext()) {
                        ((Throwable) it.next()).printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NotNull
    public final List<Throwable> getUncaughtExceptions() {
        List<Throwable> list;
        synchronized (this._lock) {
            list = CollectionsKt.toList(this._exceptions);
        }
        return list;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        synchronized (this._lock) {
            try {
                if (this._coroutinesCleanedUp) {
                    CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(context, exception);
                }
                this._exceptions.add(exception);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
