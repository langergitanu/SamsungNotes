package org.apache.commons.lang3.concurrent;

import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import org.apache.commons.lang3.C13890o;
import org.apache.commons.lang3.exception.ExceptionUtils;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Memoizer<I, O> implements Computable<I, O> {
    private final ConcurrentMap<I, Future<O>> cache;
    private final Function<? super I, ? extends Future<O>> mappingFunction;
    private final boolean recalculate;

    public Memoizer(Computable<I, O> computable) {
        this((Computable) computable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Future lambda$new$1(Computable computable, Object obj) {
        return FutureTasks.run(new CallableC7766b(computable, obj, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Future lambda$new$3(Function function, Object obj) {
        return FutureTasks.run(new CallableC7766b(function, obj, 11));
    }

    private RuntimeException launderException(Throwable th) {
        throw new IllegalStateException("Unchecked exception", ExceptionUtils.throwUnchecked(th));
    }

    @Override // org.apache.commons.lang3.concurrent.Computable
    public O compute(I i) {
        while (true) {
            Future<O> futureComputeIfAbsent = this.cache.computeIfAbsent(i, this.mappingFunction);
            try {
                return futureComputeIfAbsent.get();
            } catch (CancellationException unused) {
                this.cache.remove(i, futureComputeIfAbsent);
            } catch (ExecutionException e) {
                if (this.recalculate) {
                    this.cache.remove(i, futureComputeIfAbsent);
                }
                throw launderException(e.getCause());
            }
        }
    }

    public Memoizer(Computable<I, O> computable, boolean z) {
        this.cache = new ConcurrentHashMap();
        this.recalculate = z;
        this.mappingFunction = new C0332a(computable, 18);
    }

    public Memoizer(Function<I, O> function) {
        this((Function) function, false);
    }

    public Memoizer(Function<I, O> function, boolean z) {
        this.cache = new ConcurrentHashMap();
        this.recalculate = z;
        this.mappingFunction = new C13890o(function, 1);
    }
}
