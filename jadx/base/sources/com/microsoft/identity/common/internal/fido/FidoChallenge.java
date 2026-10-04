package com.microsoft.identity.common.internal.fido;

import com.microsoft.identity.common.internal.fido.FidoChallengeField;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0085\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003\u0012\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003¢\u0006\u0002\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003HÆ\u0003J\u0099\u0001\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006'"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/FidoChallenge;", "", "challenge", "Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;", "", "relyingPartyIdentifier", "userVerificationPolicy", "version", "submitUrl", "context", "keyTypes", "", "allowedCredentials", "(Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;)V", "getAllowedCredentials", "()Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;", "getChallenge", "getContext", "getKeyTypes", "getRelyingPartyIdentifier", "getSubmitUrl", "getUserVerificationPolicy", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final /* data */ class FidoChallenge {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DEFAULT_USER_VERIFICATION_POLICY = "required";

    @NotNull
    public static final String DELIMITER = ",";

    @NotNull
    private final FidoChallengeField<List<String>> allowedCredentials;

    @NotNull
    private final FidoChallengeField<String> challenge;

    @NotNull
    private final FidoChallengeField<String> context;

    @NotNull
    private final FidoChallengeField<List<String>> keyTypes;

    @NotNull
    private final FidoChallengeField<String> relyingPartyIdentifier;

    @NotNull
    private final FidoChallengeField<String> submitUrl;

    @NotNull
    private final FidoChallengeField<String> userVerificationPolicy;

    @NotNull
    private final FidoChallengeField<String> version;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/FidoChallenge$Companion;", "", "()V", "DEFAULT_USER_VERIFICATION_POLICY", "", "DELIMITER", "createFromRedirectUri", "Lcom/microsoft/identity/common/internal/fido/FidoChallenge;", "redirectUri", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final FidoChallenge createFromRedirectUri(@NotNull String redirectUri) throws ClientException {
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Map<String, String> parameters = UrlUtil.getParameters(redirectUri);
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(redirectUri)");
            FidoRequestField fidoRequestField = FidoRequestField.CHALLENGE;
            String str = parameters.get(fidoRequestField.getFieldName());
            FidoChallengeField.Companion companion = FidoChallengeField.INSTANCE;
            FidoChallengeField fidoChallengeField = new FidoChallengeField(fidoRequestField, str, new FidoChallenge$Companion$createFromRedirectUri$1(companion));
            FidoRequestField fidoRequestField2 = FidoRequestField.RELYING_PARTY_IDENTIFIER;
            FidoChallengeField fidoChallengeField2 = new FidoChallengeField(fidoRequestField2, parameters.get(fidoRequestField2.getFieldName()), new FidoChallenge$Companion$createFromRedirectUri$2(companion));
            FidoRequestField fidoRequestField3 = FidoRequestField.USER_VERIFICATION_POLICY;
            String str2 = parameters.get(fidoRequestField3.getFieldName());
            if (str2 == null) {
                str2 = FidoChallenge.DEFAULT_USER_VERIFICATION_POLICY;
            }
            FidoChallengeField fidoChallengeField3 = new FidoChallengeField(fidoRequestField3, str2, new FidoChallenge$Companion$createFromRedirectUri$3(companion));
            FidoRequestField fidoRequestField4 = FidoRequestField.VERSION;
            FidoChallengeField fidoChallengeField4 = new FidoChallengeField(fidoRequestField4, parameters.get(fidoRequestField4.getFieldName()), new FidoChallenge$Companion$createFromRedirectUri$4(companion));
            FidoRequestField fidoRequestField5 = FidoRequestField.SUBMIT_URL;
            FidoChallengeField fidoChallengeField5 = new FidoChallengeField(fidoRequestField5, parameters.get(fidoRequestField5.getFieldName()), new FidoChallenge$Companion$createFromRedirectUri$5(companion));
            FidoRequestField fidoRequestField6 = FidoRequestField.CONTEXT;
            FidoChallengeField fidoChallengeField6 = new FidoChallengeField(fidoRequestField6, parameters.get(fidoRequestField6.getFieldName()), new FidoChallenge$Companion$createFromRedirectUri$6(companion));
            FidoRequestField fidoRequestField7 = FidoRequestField.KEY_TYPES;
            String str3 = parameters.get(fidoRequestField7.getFieldName());
            FidoChallengeField fidoChallengeField7 = new FidoChallengeField(fidoRequestField7, str3 != null ? StringsKt__StringsKt.split$default(str3, new String[]{","}, false, 0, 6, (Object) null) : null, new FidoChallenge$Companion$createFromRedirectUri$7(companion));
            FidoRequestField fidoRequestField8 = FidoRequestField.ALLOWED_CREDENTIALS;
            String str4 = parameters.get(fidoRequestField8.getFieldName());
            return new FidoChallenge(fidoChallengeField, fidoChallengeField2, fidoChallengeField3, fidoChallengeField4, fidoChallengeField5, fidoChallengeField6, fidoChallengeField7, new FidoChallengeField(fidoRequestField8, str4 != null ? StringsKt__StringsKt.split$default(str4, new String[]{","}, false, 0, 6, (Object) null) : null, new FidoChallenge$Companion$createFromRedirectUri$8(companion)));
        }

        private Companion() {
        }
    }

    public FidoChallenge(@NotNull FidoChallengeField<String> challenge, @NotNull FidoChallengeField<String> relyingPartyIdentifier, @NotNull FidoChallengeField<String> userVerificationPolicy, @NotNull FidoChallengeField<String> version, @NotNull FidoChallengeField<String> submitUrl, @NotNull FidoChallengeField<String> context, @NotNull FidoChallengeField<List<String>> keyTypes, @NotNull FidoChallengeField<List<String>> allowedCredentials) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(relyingPartyIdentifier, "relyingPartyIdentifier");
        Intrinsics.checkNotNullParameter(userVerificationPolicy, "userVerificationPolicy");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(submitUrl, "submitUrl");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyTypes, "keyTypes");
        Intrinsics.checkNotNullParameter(allowedCredentials, "allowedCredentials");
        this.challenge = challenge;
        this.relyingPartyIdentifier = relyingPartyIdentifier;
        this.userVerificationPolicy = userVerificationPolicy;
        this.version = version;
        this.submitUrl = submitUrl;
        this.context = context;
        this.keyTypes = keyTypes;
        this.allowedCredentials = allowedCredentials;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FidoChallenge copy$default(FidoChallenge fidoChallenge, FidoChallengeField fidoChallengeField, FidoChallengeField fidoChallengeField2, FidoChallengeField fidoChallengeField3, FidoChallengeField fidoChallengeField4, FidoChallengeField fidoChallengeField5, FidoChallengeField fidoChallengeField6, FidoChallengeField fidoChallengeField7, FidoChallengeField fidoChallengeField8, int i, Object obj) {
        if ((i & 1) != 0) {
            fidoChallengeField = fidoChallenge.challenge;
        }
        if ((i & 2) != 0) {
            fidoChallengeField2 = fidoChallenge.relyingPartyIdentifier;
        }
        if ((i & 4) != 0) {
            fidoChallengeField3 = fidoChallenge.userVerificationPolicy;
        }
        if ((i & 8) != 0) {
            fidoChallengeField4 = fidoChallenge.version;
        }
        if ((i & 16) != 0) {
            fidoChallengeField5 = fidoChallenge.submitUrl;
        }
        if ((i & 32) != 0) {
            fidoChallengeField6 = fidoChallenge.context;
        }
        if ((i & 64) != 0) {
            fidoChallengeField7 = fidoChallenge.keyTypes;
        }
        if ((i & 128) != 0) {
            fidoChallengeField8 = fidoChallenge.allowedCredentials;
        }
        FidoChallengeField fidoChallengeField9 = fidoChallengeField7;
        FidoChallengeField fidoChallengeField10 = fidoChallengeField8;
        FidoChallengeField fidoChallengeField11 = fidoChallengeField5;
        FidoChallengeField fidoChallengeField12 = fidoChallengeField6;
        return fidoChallenge.copy(fidoChallengeField, fidoChallengeField2, fidoChallengeField3, fidoChallengeField4, fidoChallengeField11, fidoChallengeField12, fidoChallengeField9, fidoChallengeField10);
    }

    @JvmStatic
    @NotNull
    public static final FidoChallenge createFromRedirectUri(@NotNull String str) {
        return INSTANCE.createFromRedirectUri(str);
    }

    @NotNull
    public final FidoChallengeField<String> component1() {
        return this.challenge;
    }

    @NotNull
    public final FidoChallengeField<String> component2() {
        return this.relyingPartyIdentifier;
    }

    @NotNull
    public final FidoChallengeField<String> component3() {
        return this.userVerificationPolicy;
    }

    @NotNull
    public final FidoChallengeField<String> component4() {
        return this.version;
    }

    @NotNull
    public final FidoChallengeField<String> component5() {
        return this.submitUrl;
    }

    @NotNull
    public final FidoChallengeField<String> component6() {
        return this.context;
    }

    @NotNull
    public final FidoChallengeField<List<String>> component7() {
        return this.keyTypes;
    }

    @NotNull
    public final FidoChallengeField<List<String>> component8() {
        return this.allowedCredentials;
    }

    @NotNull
    public final FidoChallenge copy(@NotNull FidoChallengeField<String> challenge, @NotNull FidoChallengeField<String> relyingPartyIdentifier, @NotNull FidoChallengeField<String> userVerificationPolicy, @NotNull FidoChallengeField<String> version, @NotNull FidoChallengeField<String> submitUrl, @NotNull FidoChallengeField<String> context, @NotNull FidoChallengeField<List<String>> keyTypes, @NotNull FidoChallengeField<List<String>> allowedCredentials) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(relyingPartyIdentifier, "relyingPartyIdentifier");
        Intrinsics.checkNotNullParameter(userVerificationPolicy, "userVerificationPolicy");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(submitUrl, "submitUrl");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyTypes, "keyTypes");
        Intrinsics.checkNotNullParameter(allowedCredentials, "allowedCredentials");
        return new FidoChallenge(challenge, relyingPartyIdentifier, userVerificationPolicy, version, submitUrl, context, keyTypes, allowedCredentials);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FidoChallenge)) {
            return false;
        }
        FidoChallenge fidoChallenge = (FidoChallenge) other;
        return Intrinsics.areEqual(this.challenge, fidoChallenge.challenge) && Intrinsics.areEqual(this.relyingPartyIdentifier, fidoChallenge.relyingPartyIdentifier) && Intrinsics.areEqual(this.userVerificationPolicy, fidoChallenge.userVerificationPolicy) && Intrinsics.areEqual(this.version, fidoChallenge.version) && Intrinsics.areEqual(this.submitUrl, fidoChallenge.submitUrl) && Intrinsics.areEqual(this.context, fidoChallenge.context) && Intrinsics.areEqual(this.keyTypes, fidoChallenge.keyTypes) && Intrinsics.areEqual(this.allowedCredentials, fidoChallenge.allowedCredentials);
    }

    @NotNull
    public final FidoChallengeField<List<String>> getAllowedCredentials() {
        return this.allowedCredentials;
    }

    @NotNull
    public final FidoChallengeField<String> getChallenge() {
        return this.challenge;
    }

    @NotNull
    public final FidoChallengeField<String> getContext() {
        return this.context;
    }

    @NotNull
    public final FidoChallengeField<List<String>> getKeyTypes() {
        return this.keyTypes;
    }

    @NotNull
    public final FidoChallengeField<String> getRelyingPartyIdentifier() {
        return this.relyingPartyIdentifier;
    }

    @NotNull
    public final FidoChallengeField<String> getSubmitUrl() {
        return this.submitUrl;
    }

    @NotNull
    public final FidoChallengeField<String> getUserVerificationPolicy() {
        return this.userVerificationPolicy;
    }

    @NotNull
    public final FidoChallengeField<String> getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.allowedCredentials.hashCode() + ((this.keyTypes.hashCode() + ((this.context.hashCode() + ((this.submitUrl.hashCode() + ((this.version.hashCode() + ((this.userVerificationPolicy.hashCode() + ((this.relyingPartyIdentifier.hashCode() + (this.challenge.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "FidoChallenge(challenge=" + this.challenge + ", relyingPartyIdentifier=" + this.relyingPartyIdentifier + ", userVerificationPolicy=" + this.userVerificationPolicy + ", version=" + this.version + ", submitUrl=" + this.submitUrl + ", context=" + this.context + ", keyTypes=" + this.keyTypes + ", allowedCredentials=" + this.allowedCredentials + PropertyUtils.MAPPED_DELIM2;
    }
}
