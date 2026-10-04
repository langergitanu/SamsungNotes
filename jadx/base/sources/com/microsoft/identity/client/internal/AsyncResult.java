package com.microsoft.identity.client.internal;

import androidx.annotation.Nullable;
import com.microsoft.identity.client.exception.MsalException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AsyncResult<T> {
    private MsalException mMsalException;
    private T mResult;

    public AsyncResult(@Nullable T t, @Nullable MsalException msalException) {
        this.mResult = t;
        this.mMsalException = msalException;
    }

    public MsalException getException() {
        return this.mMsalException;
    }

    public T getResult() {
        return this.mResult;
    }

    public boolean getSuccess() {
        return this.mMsalException == null;
    }
}
