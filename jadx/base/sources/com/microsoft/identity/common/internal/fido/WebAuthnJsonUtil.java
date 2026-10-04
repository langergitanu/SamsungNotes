package com.microsoft.identity.common.internal.fido;

import android.util.Base64;
import com.microsoft.identity.common.internal.util.CommonMoshiJsonAdapter;
import com.microsoft.identity.common.java.constants.FidoConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/WebAuthnJsonUtil;", "", "()V", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class WebAuthnJsonUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\n\u0010\f\u001a\u00020\u0004*\u00020\u0004¨\u0006\r"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/WebAuthnJsonUtil$Companion;", "", "()V", "createJsonAuthRequest", "", "challenge", "relyingPartyIdentifier", "allowedCredentials", "", "userVerificationPolicy", "extractAuthenticatorAssertionResponseJson", "fullResponseJson", "base64UrlEncoded", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String base64UrlEncoded(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String strEncodeToString = Base64.encodeToString(bytes, 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(data, (Ba…AP or Base64.NO_PADDING))");
            return strEncodeToString;
        }

        @NotNull
        public final String createJsonAuthRequest(@NotNull String challenge, @NotNull String relyingPartyIdentifier, @Nullable List<String> allowedCredentials, @NotNull String userVerificationPolicy) {
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            Intrinsics.checkNotNullParameter(relyingPartyIdentifier, "relyingPartyIdentifier");
            Intrinsics.checkNotNullParameter(userVerificationPolicy, "userVerificationPolicy");
            ArrayList arrayList = new ArrayList();
            if (allowedCredentials != null) {
                Iterator<String> it = allowedCredentials.iterator();
                while (it.hasNext()) {
                    arrayList.add(new PublicKeyCredentialDescriptor("public-key", it.next()));
                }
            }
            String json = new CommonMoshiJsonAdapter().toJson(new PublicKeyCredentialRequestOptions(base64UrlEncoded(challenge), relyingPartyIdentifier, arrayList, userVerificationPolicy));
            Intrinsics.checkNotNullExpressionValue(json, "CommonMoshiJsonAdapter().toJson(options)");
            return json;
        }

        @NotNull
        public final String extractAuthenticatorAssertionResponseJson(@NotNull String fullResponseJson) throws JSONException {
            Intrinsics.checkNotNullParameter(fullResponseJson, "fullResponseJson");
            JSONObject jSONObject = new JSONObject(fullResponseJson);
            JSONObject jSONObject2 = jSONObject.getJSONObject("response");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", jSONObject.get("id"));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY));
            String string = jSONObject3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "assertionResult.toString()");
            return string;
        }

        private Companion() {
        }
    }
}
