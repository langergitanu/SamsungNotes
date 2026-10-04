package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import androidx.credentials.webauthn.WebAuthnUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, m13886d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", "", "requestJson", "", "(Ljava/lang/String;)V", "challenge", "", "getChallenge", "()[B", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "rpId", "getRpId", "()Ljava/lang/String;", "timeout", "", "getTimeout", "()J", "userVerification", "getUserVerification", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialRequestOptions {

    @NotNull
    private final byte[] challenge;

    @NotNull
    private final JSONObject json;

    @NotNull
    private final String rpId;
    private final long timeout;

    @NotNull
    private final String userVerification;

    public PublicKeyCredentialRequestOptions(@NotNull String requestJson) throws JSONException {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        JSONObject jSONObject = new JSONObject(requestJson);
        this.json = jSONObject;
        String challengeString = jSONObject.getString("challenge");
        WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(challengeString, "challengeString");
        this.challenge = companion.b64Decode(challengeString);
        this.timeout = jSONObject.optLong("timeout", 0L);
        String strOptString = jSONObject.optString("rpId", "");
        Intrinsics.checkNotNullExpressionValue(strOptString, "json.optString(\"rpId\", \"\")");
        this.rpId = strOptString;
        String strOptString2 = jSONObject.optString("userVerification", "preferred");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "json.optString(\"userVerification\", \"preferred\")");
        this.userVerification = strOptString2;
    }

    @NotNull
    public final byte[] getChallenge() {
        return this.challenge;
    }

    @NotNull
    public final JSONObject getJson() {
        return this.json;
    }

    @NotNull
    public final String getRpId() {
        return this.rpId;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    @NotNull
    public final String getUserVerification() {
        return this.userVerification;
    }
}
