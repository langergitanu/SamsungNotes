package com.samsung.android.support.senl.document;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocCipher {
    static final int CIPHER_BUF_SIZE = 4096;
    static final int CIPHER_INTERATION_COUNT = 4000;
    static final int CIPHER_KEY_BIT_LENGTH = 256;
    String mPassword;

    public SDocCipher(Context context) {
        this.mPassword = null;
        if (context == null) {
            throw new IllegalStateException("SDocCipher() - context can not be null.");
        }
        this.mPassword = new SDocLocker(context).getUserCode()[0];
    }
}
