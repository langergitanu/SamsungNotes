package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import androidx.credentials.webauthn.WebAuthnUtils;
import com.microsoft.identity.common.java.constants.FidoConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0017H\u0016R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Landroidx/credentials/webauthn/AuthenticatorAssertionResponse;", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "requestOptions", "Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", "credentialId", "", "origin", "", "up", "", "uv", "be", "bs", FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, "packageName", "clientDataHash", "(Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;[BLjava/lang/String;ZZZZ[BLjava/lang/String;[B)V", FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, "getAuthenticatorData", "()[B", "setAuthenticatorData", "([B)V", "clientJson", "Lorg/json/JSONObject;", "getClientJson", "()Lorg/json/JSONObject;", "setClientJson", "(Lorg/json/JSONObject;)V", FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, "getSignature", "setSignature", "dataToSign", "defaultAuthenticatorData", "json", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AuthenticatorAssertionResponse implements AuthenticatorResponse {

    @NotNull
    private byte[] authenticatorData;
    private final boolean be;
    private final boolean bs;

    @Nullable
    private final byte[] clientDataHash;

    @NotNull
    private JSONObject clientJson;

    @NotNull
    private final byte[] credentialId;

    @NotNull
    private final String origin;

    @Nullable
    private final String packageName;

    @NotNull
    private final PublicKeyCredentialRequestOptions requestOptions;

    @NotNull
    private byte[] signature;
    private final boolean up;

    @NotNull
    private byte[] userHandle;
    private final boolean uv;

    public AuthenticatorAssertionResponse(@NotNull PublicKeyCredentialRequestOptions requestOptions, @NotNull byte[] credentialId, @NotNull String origin, boolean z, boolean z2, boolean z3, boolean z4, @NotNull byte[] userHandle, @Nullable String str, @Nullable byte[] bArr) throws JSONException {
        Intrinsics.checkNotNullParameter(requestOptions, "requestOptions");
        Intrinsics.checkNotNullParameter(credentialId, "credentialId");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(userHandle, "userHandle");
        this.requestOptions = requestOptions;
        this.credentialId = credentialId;
        this.origin = origin;
        this.up = z;
        this.uv = z2;
        this.be = z3;
        this.bs = z4;
        this.userHandle = userHandle;
        this.packageName = str;
        this.clientDataHash = bArr;
        this.clientJson = new JSONObject();
        this.signature = new byte[0];
        getClientJson().put("type", "webauthn.get");
        getClientJson().put("challenge", WebAuthnUtils.INSTANCE.b64Encode(requestOptions.getChallenge()));
        getClientJson().put("origin", origin);
        if (str != null) {
            getClientJson().put("androidPackageName", str);
        }
        this.authenticatorData = defaultAuthenticatorData();
    }

    @NotNull
    public final byte[] dataToSign() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bArrDigest = this.clientDataHash;
        if (bArrDigest == null) {
            String string = getClientJson().toString();
            Intrinsics.checkNotNullExpressionValue(string, "clientJson.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArrDigest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "md.digest(clientJson.toString().toByteArray())");
        }
        return ArraysKt.plus(this.authenticatorData, bArrDigest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @NotNull
    public final byte[] defaultAuthenticatorData() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.requestOptions.getRpId().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] rpHash = messageDigest.digest(bytes);
        boolean z = this.up;
        ?? r12 = z;
        if (this.uv) {
            r12 = (z ? 1 : 0) | 4;
        }
        ?? r13 = r12;
        if (this.be) {
            r13 = (r12 == true ? 1 : 0) | 8;
        }
        int i = r13;
        if (this.bs) {
            i = (r13 == true ? 1 : 0) | 16;
        }
        Intrinsics.checkNotNullExpressionValue(rpHash, "rpHash");
        return ArraysKt.plus(ArraysKt.plus(rpHash, new byte[]{(byte) i}), new byte[]{0, 0, 0, 0});
    }

    @NotNull
    public final byte[] getAuthenticatorData() {
        return this.authenticatorData;
    }

    @Override // androidx.credentials.webauthn.AuthenticatorResponse
    @NotNull
    public JSONObject getClientJson() {
        return this.clientJson;
    }

    @NotNull
    public final byte[] getSignature() {
        return this.signature;
    }

    @Override // androidx.credentials.webauthn.AuthenticatorResponse
    @NotNull
    public JSONObject json() throws JSONException {
        String string = getClientJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "clientJson.toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        JSONObject jSONObject = new JSONObject();
        if (this.clientDataHash == null) {
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, WebAuthnUtils.INSTANCE.b64Encode(bytes));
        }
        WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
        jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, companion.b64Encode(this.authenticatorData));
        jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, companion.b64Encode(this.signature));
        jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, companion.b64Encode(this.userHandle));
        return jSONObject;
    }

    public final void setAuthenticatorData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.authenticatorData = bArr;
    }

    @Override // androidx.credentials.webauthn.AuthenticatorResponse
    public void setClientJson(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.clientJson = jSONObject;
    }

    public final void setSignature(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.signature = bArr;
    }

    public /* synthetic */ AuthenticatorAssertionResponse(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, byte[] bArr, String str, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr2, String str2, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(publicKeyCredentialRequestOptions, bArr, str, z, z2, z3, z4, bArr2, (i & 256) != 0 ? null : str2, (i & 512) != 0 ? null : bArr3);
    }
}
