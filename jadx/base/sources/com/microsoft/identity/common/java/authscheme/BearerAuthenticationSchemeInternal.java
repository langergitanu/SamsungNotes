package com.microsoft.identity.common.java.authscheme;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BearerAuthenticationSchemeInternal extends TokenAuthenticationScheme implements ITokenAuthenticationSchemeInternal {
    public static final String SCHEME_BEARER = "Bearer";
    private static final long serialVersionUID = 823164758655077118L;

    public BearerAuthenticationSchemeInternal() {
        super("Bearer");
    }

    @Override // com.microsoft.identity.common.java.authscheme.ITokenAuthenticationSchemeInternal
    public String getAccessTokenForScheme(@NonNull String str) {
        if (str != null) {
            return str;
        }
        throw new NullPointerException("accessToken is marked non-null but is null");
    }
}
