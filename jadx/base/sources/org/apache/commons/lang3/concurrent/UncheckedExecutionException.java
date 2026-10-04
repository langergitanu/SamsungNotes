package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.exception.UncheckedException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class UncheckedExecutionException extends UncheckedException {
    private static final long serialVersionUID = 1;

    public UncheckedExecutionException(Throwable th) {
        super(th);
    }
}
