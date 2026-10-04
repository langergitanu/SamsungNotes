package com.microsoft.identity.common.java.providers.oauth2;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum OpenIdConnectPromptParameter {
    UNSET,
    NONE,
    SELECT_ACCOUNT,
    LOGIN,
    CONSENT,
    CREATE;

    public static OpenIdConnectPromptParameter _fromPromptBehavior(@Nullable String str) {
        return (str == null || !str.equals("FORCE_PROMPT")) ? UNSET : LOGIN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == UNSET ? "" : name().toLowerCase(Locale.ROOT);
    }
}
