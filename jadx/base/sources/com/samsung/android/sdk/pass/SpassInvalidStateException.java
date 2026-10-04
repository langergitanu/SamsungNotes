package com.samsung.android.sdk.pass;

/* JADX INFO: loaded from: classes7.dex */
public class SpassInvalidStateException extends IllegalStateException {
    public static final int STATUS_OPERATION_DENIED = 1;

    /* JADX INFO: renamed from: a */
    private int f4922a;

    public SpassInvalidStateException(String str, int i) {
        super(str);
        this.f4922a = i;
    }

    public int getType() {
        return this.f4922a;
    }
}
