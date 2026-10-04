package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.authscheme.INameable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AuthenticationScheme implements INameable {
    private final String mSchemeName;

    public AuthenticationScheme(@NonNull String str) {
        this.mSchemeName = str;
    }

    @Override // com.microsoft.identity.common.java.authscheme.INameable
    public final String getName() {
        return this.mSchemeName;
    }
}
