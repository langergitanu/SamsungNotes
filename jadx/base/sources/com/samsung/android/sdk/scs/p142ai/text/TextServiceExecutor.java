package com.samsung.android.sdk.scs.p142ai.text;

import android.content.ContentResolver;
import android.content.Context;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.connection.ProviderExecutor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TextServiceExecutor extends ProviderExecutor {
    private static final String TAG = "ScsApi@TextServiceExecutor";
    private ContentResolver mTextContentResolver;

    public TextServiceExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.mTextContentResolver = context.getContentResolver();
    }

    public ContentResolver getTextContentResolver() {
        return this.mTextContentResolver;
    }
}
