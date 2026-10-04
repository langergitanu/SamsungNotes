package com.samsung.android.sdk.mobileservice;

import android.content.Context;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SeMobileServiceWatchSessionImpl extends SeMobileServiceSessionImpl {
    public SeMobileServiceWatchSessionImpl(Context context, HashSet<String> hashSet, String str, SeMobileServiceSession.ConnectionResultCallback connectionResultCallback) {
        super(context, hashSet, str, connectionResultCallback);
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSessionImpl
    public int getAuthorized() {
        return 3;
    }
}
