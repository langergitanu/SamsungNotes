package androidx.credentials.webauthn;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.credentials.webauthn.WebAuthnUtils;
import com.microsoft.identity.common.internal.fido.FidoChallenge;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006/"}, m13886d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialCreationOptions;", "", "requestJson", "", "(Ljava/lang/String;)V", "attestation", "getAttestation", "()Ljava/lang/String;", "setAttestation", "authenticatorSelection", "Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "getAuthenticatorSelection", "()Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "setAuthenticatorSelection", "(Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;)V", "challenge", "", "getChallenge", "()[B", "excludeCredentials", "", "Landroidx/credentials/webauthn/PublicKeyCredentialDescriptor;", "getExcludeCredentials", "()Ljava/util/List;", "setExcludeCredentials", "(Ljava/util/List;)V", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "pubKeyCredParams", "Landroidx/credentials/webauthn/PublicKeyCredentialParameters;", "getPubKeyCredParams", "rp", "Landroidx/credentials/webauthn/PublicKeyCredentialRpEntity;", "getRp", "()Landroidx/credentials/webauthn/PublicKeyCredentialRpEntity;", "timeout", "", "getTimeout", "()J", "setTimeout", "(J)V", IdentityApiContract.Token.USER, "Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "getUser", "()Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialCreationOptions {

    @NotNull
    private String attestation;

    @NotNull
    private AuthenticatorSelectionCriteria authenticatorSelection;

    @NotNull
    private final byte[] challenge;

    @NotNull
    private List<PublicKeyCredentialDescriptor> excludeCredentials;

    @NotNull
    private final JSONObject json;

    @NotNull
    private final List<PublicKeyCredentialParameters> pubKeyCredParams;

    @NotNull
    private final PublicKeyCredentialRpEntity rp;
    private long timeout;

    @NotNull
    private final PublicKeyCredentialUserEntity user;

    public PublicKeyCredentialCreationOptions(@NotNull String requestJson) throws JSONException {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        JSONObject jSONObject = new JSONObject(requestJson);
        this.json = jSONObject;
        String challengeString = jSONObject.getString("challenge");
        WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(challengeString, "challengeString");
        this.challenge = companion.b64Decode(challengeString);
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        String string = jSONObject2.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "rpJson.getString(\"name\")");
        String string2 = jSONObject2.getString("id");
        Intrinsics.checkNotNullExpressionValue(string2, "rpJson.getString(\"id\")");
        this.rp = new PublicKeyCredentialRpEntity(string, string2);
        JSONObject jSONObject3 = jSONObject.getJSONObject(IdentityApiContract.Token.USER);
        String string3 = jSONObject3.getString("id");
        Intrinsics.checkNotNullExpressionValue(string3, "rpUser.getString(\"id\")");
        byte[] bArrB64Decode = companion.b64Decode(string3);
        String string4 = jSONObject3.getString("name");
        Intrinsics.checkNotNullExpressionValue(string4, "rpUser.getString(\"name\")");
        String string5 = jSONObject3.getString("displayName");
        Intrinsics.checkNotNullExpressionValue(string5, "rpUser.getString(\"displayName\")");
        this.user = new PublicKeyCredentialUserEntity(string4, bArrB64Decode, string5);
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i);
            String string6 = jSONObject4.getString("type");
            Intrinsics.checkNotNullExpressionValue(string6, "e.getString(\"type\")");
            arrayList.add(new PublicKeyCredentialParameters(string6, jSONObject4.getLong("alg")));
        }
        List<PublicKeyCredentialParameters> list = CollectionsKt.toList(arrayList);
        this.pubKeyCredParams = list;
        this.timeout = this.json.optLong("timeout", 0L);
        this.excludeCredentials = CollectionsKt.emptyList();
        this.authenticatorSelection = new AuthenticatorSelectionCriteria("platform", FidoChallenge.DEFAULT_USER_VERIFICATION_POLICY, false, null, 12, null);
        String strOptString = this.json.optString("attestation", "none");
        Intrinsics.checkNotNullExpressionValue(strOptString, "json.optString(\"attestation\", \"none\")");
        this.attestation = strOptString;
        Log.i("WebAuthn", "Challenge " + this.challenge + "()");
        StringBuilder sb = new StringBuilder("rp ");
        sb.append(this.rp);
        Log.i("WebAuthn", sb.toString());
        Log.i("WebAuthn", "user " + this.user);
        Log.i("WebAuthn", "pubKeyCredParams " + list);
        Log.i("WebAuthn", "timeout " + this.timeout);
        Log.i("WebAuthn", "excludeCredentials " + this.excludeCredentials);
        Log.i("WebAuthn", "authenticatorSelection " + this.authenticatorSelection);
        AbstractC11014a.m12338w(new StringBuilder("attestation "), this.attestation, "WebAuthn");
    }

    @NotNull
    public final String getAttestation() {
        return this.attestation;
    }

    @NotNull
    public final AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.authenticatorSelection;
    }

    @NotNull
    public final byte[] getChallenge() {
        return this.challenge;
    }

    @NotNull
    public final List<PublicKeyCredentialDescriptor> getExcludeCredentials() {
        return this.excludeCredentials;
    }

    @NotNull
    public final JSONObject getJson() {
        return this.json;
    }

    @NotNull
    public final List<PublicKeyCredentialParameters> getPubKeyCredParams() {
        return this.pubKeyCredParams;
    }

    @NotNull
    public final PublicKeyCredentialRpEntity getRp() {
        return this.rp;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    @NotNull
    public final PublicKeyCredentialUserEntity getUser() {
        return this.user;
    }

    public final void setAttestation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attestation = str;
    }

    public final void setAuthenticatorSelection(@NotNull AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
        Intrinsics.checkNotNullParameter(authenticatorSelectionCriteria, "<set-?>");
        this.authenticatorSelection = authenticatorSelectionCriteria;
    }

    public final void setExcludeCredentials(@NotNull List<PublicKeyCredentialDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.excludeCredentials = list;
    }

    public final void setTimeout(long j) {
        this.timeout = j;
    }
}
