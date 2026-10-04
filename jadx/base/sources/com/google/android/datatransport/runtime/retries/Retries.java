package com.google.android.datatransport.runtime.retries;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Retries {
    private Retries() {
    }

    public static <TInput, TResult, TException extends Throwable> TResult retry(int i, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) {
        TResult tresultApply;
        if (i < 1) {
            return function.apply(tinput);
        }
        do {
            tresultApply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, tresultApply);
            if (tinput == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return tresultApply;
    }
}
