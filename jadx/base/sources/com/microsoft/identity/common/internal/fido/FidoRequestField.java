package com.microsoft.identity.common.internal.fido;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/FidoRequestField;", "", "fieldName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFieldName", "()Ljava/lang/String;", "CHALLENGE", "RELYING_PARTY_IDENTIFIER", "USER_VERIFICATION_POLICY", "VERSION", "SUBMIT_URL", "CONTEXT", "ALLOWED_CREDENTIALS", "KEY_TYPES", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public enum FidoRequestField {
    CHALLENGE("challenge"),
    RELYING_PARTY_IDENTIFIER("relyingPartyIdentifier"),
    USER_VERIFICATION_POLICY("userVerificationPolicy"),
    VERSION("version"),
    SUBMIT_URL("submitUrl"),
    CONTEXT("context"),
    ALLOWED_CREDENTIALS("allowedCredentials"),
    KEY_TYPES("keyTypes");


    @NotNull
    private final String fieldName;

    FidoRequestField(String str) {
        this.fieldName = str;
    }

    @NotNull
    public final String getFieldName() {
        return this.fieldName;
    }
}
