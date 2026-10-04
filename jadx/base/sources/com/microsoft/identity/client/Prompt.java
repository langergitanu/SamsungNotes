package com.microsoft.identity.client;

import com.microsoft.identity.common.java.providers.oauth2.OpenIdConnectPromptParameter;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum Prompt {
    SELECT_ACCOUNT,
    LOGIN,
    CONSENT,
    CREATE,
    WHEN_REQUIRED;

    /* JADX INFO: renamed from: com.microsoft.identity.client.Prompt$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C61941 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$client$Prompt;

        static {
            int[] iArr = new int[Prompt.values().length];
            $SwitchMap$com$microsoft$identity$client$Prompt = iArr;
            try {
                iArr[Prompt.SELECT_ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.CONSENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.WHEN_REQUIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.CREATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public OpenIdConnectPromptParameter toOpenIdConnectPromptParameter() {
        int i = C61941.$SwitchMap$com$microsoft$identity$client$Prompt[ordinal()];
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? OpenIdConnectPromptParameter.SELECT_ACCOUNT : OpenIdConnectPromptParameter.CREATE : OpenIdConnectPromptParameter.UNSET : OpenIdConnectPromptParameter.CONSENT : OpenIdConnectPromptParameter.LOGIN;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = C61941.$SwitchMap$com$microsoft$identity$client$Prompt[ordinal()];
        if (i == 1) {
            return SELECT_ACCOUNT.name().toLowerCase(Locale.ROOT);
        }
        if (i == 2) {
            return LOGIN.name().toLowerCase(Locale.ROOT);
        }
        if (i == 3) {
            return CONSENT.name().toLowerCase(Locale.ROOT);
        }
        if (i == 4) {
            return WHEN_REQUIRED.name().toLowerCase(Locale.ROOT);
        }
        if (i == 5) {
            return CREATE.name().toLowerCase(Locale.ROOT);
        }
        throw new IllegalArgumentException();
    }
}
