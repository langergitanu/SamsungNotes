package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftIdToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryIdToken extends MicrosoftIdToken {
    public static final String IDENTITY_PROVIDER = "idp";
    public static final String PASSWORD_CHANGE_URL = "pwd_url";
    public static final String PASSWORD_EXPIRATION = "pwd_exp";
    public static final String UNIQUE_NAME = "unique_name";
    public static final String UPN = "upn";

    public AzureActiveDirectoryIdToken(String str) {
        super(str);
    }
}
