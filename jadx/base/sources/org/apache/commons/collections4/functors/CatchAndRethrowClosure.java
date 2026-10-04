package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class CatchAndRethrowClosure<T> implements Closure<T> {
    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        try {
            executeAndThrow(t);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }

    public abstract void executeAndThrow(T t);
}
