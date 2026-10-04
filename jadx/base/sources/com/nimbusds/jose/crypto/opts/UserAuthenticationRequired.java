package com.nimbusds.jose.crypto.opts;

import com.nimbusds.jose.JWSSignerOption;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class UserAuthenticationRequired implements JWSSignerOption {
    private static final UserAuthenticationRequired SINGLETON = new UserAuthenticationRequired();

    private UserAuthenticationRequired() {
    }

    public static UserAuthenticationRequired getInstance() {
        return SINGLETON;
    }

    public String toString() {
        return "UserAuthenticationRequired";
    }
}
