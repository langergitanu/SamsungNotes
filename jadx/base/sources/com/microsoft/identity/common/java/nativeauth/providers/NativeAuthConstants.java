package com.microsoft.identity.common.java.nativeauth.providers;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants;", "", "()V", "ChallengeType", "GrantType", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthConstants {

    @NotNull
    public static final NativeAuthConstants INSTANCE = new NativeAuthConstants();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants$ChallengeType;", "", "()V", "OOB", "", "PASSWORD", "REDIRECT", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class ChallengeType {

        @NotNull
        public static final ChallengeType INSTANCE = new ChallengeType();

        @NotNull
        public static final String OOB = "oob";

        @NotNull
        public static final String PASSWORD = "password";

        @NotNull
        public static final String REDIRECT = "redirect";

        private ChallengeType() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants$GrantType;", "", "()V", "ATTRIBUTES", "", "CONTINUATION_TOKEN", "OOB", "PASSWORD", "REDIRECT", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class GrantType {

        @NotNull
        public static final String ATTRIBUTES = "attributes";

        @NotNull
        public static final String CONTINUATION_TOKEN = "continuation_token";

        @NotNull
        public static final GrantType INSTANCE = new GrantType();

        @NotNull
        public static final String OOB = "oob";

        @NotNull
        public static final String PASSWORD = "password";

        @NotNull
        public static final String REDIRECT = "redirect";

        private GrantType() {
        }
    }

    private NativeAuthConstants() {
    }
}
