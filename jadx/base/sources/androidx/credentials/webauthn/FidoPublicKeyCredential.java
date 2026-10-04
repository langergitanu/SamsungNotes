package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0007R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m13886d2 = {"Landroidx/credentials/webauthn/FidoPublicKeyCredential;", "", "rawId", "", "response", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "authenticatorAttachment", "", "([BLandroidx/credentials/webauthn/AuthenticatorResponse;Ljava/lang/String;)V", "getAuthenticatorAttachment", "()Ljava/lang/String;", "getRawId", "()[B", "getResponse", "()Landroidx/credentials/webauthn/AuthenticatorResponse;", "json", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class FidoPublicKeyCredential {

    @NotNull
    private final String authenticatorAttachment;

    @NotNull
    private final byte[] rawId;

    @NotNull
    private final AuthenticatorResponse response;

    public FidoPublicKeyCredential(@NotNull byte[] rawId, @NotNull AuthenticatorResponse response, @NotNull String authenticatorAttachment) {
        Intrinsics.checkNotNullParameter(rawId, "rawId");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(authenticatorAttachment, "authenticatorAttachment");
        this.rawId = rawId;
        this.response = response;
        this.authenticatorAttachment = authenticatorAttachment;
    }

    @NotNull
    public final String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    @NotNull
    public final byte[] getRawId() {
        return this.rawId;
    }

    @NotNull
    public final AuthenticatorResponse getResponse() {
        return this.response;
    }

    @NotNull
    public final String json() throws JSONException {
        String strB64Encode = WebAuthnUtils.INSTANCE.b64Encode(this.rawId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", strB64Encode);
        jSONObject.put("rawId", strB64Encode);
        jSONObject.put("type", "public-key");
        jSONObject.put("authenticatorAttachment", this.authenticatorAttachment);
        jSONObject.put("response", this.response.json());
        jSONObject.put("clientExtensionResults", new JSONObject());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "ret.toString()");
        return string;
    }
}
