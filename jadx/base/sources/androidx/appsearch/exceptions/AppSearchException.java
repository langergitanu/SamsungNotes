package androidx.appsearch.exceptions;

import androidx.appsearch.app.AppSearchResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class AppSearchException extends Exception {
    private final int mResultCode;

    public AppSearchException(int i) {
        this(i, null);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public <T> AppSearchResult<T> toAppSearchResult() {
        return AppSearchResult.newFailedResult(this.mResultCode, getMessage());
    }

    public AppSearchException(int i, String str) {
        this(i, str, null);
    }

    public AppSearchException(int i, String str, Throwable th) {
        super(str, th);
        this.mResultCode = i;
    }
}
