package com.microsoft.identity.common.java.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/common/java/constants/FidoConstants;", "", "()V", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FidoConstants {

    @NotNull
    public static final String PASSKEY_CONTEXT_DELIMITER = " ";

    @NotNull
    public static final String PASSKEY_PROTOCOL_ERROR_PREFIX_STRING = "ERROR: ";

    @NotNull
    public static final String PASSKEY_PROTOCOL_HEADER_NAME = "x-ms-PassKeyAuth";

    @NotNull
    public static final String PASSKEY_PROTOCOL_HEADER_VALUE = "1.0/passkey";

    @NotNull
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_DELIMITER = ",";

    @NotNull
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_NGC_OPTION = "ngc";

    @NotNull
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_PASSKEY_OPTION = "passkey";

    @NotNull
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_SECURITYKEY_OPTION = "securitykey";

    @NotNull
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_SUPPORTED = "passkey";

    @NotNull
    public static final String PASSKEY_PROTOCOL_REDIRECT = "urn:http-auth:PassKey";

    @NotNull
    public static final String PASSKEY_PROTOCOL_VERSION = "1.0";

    @NotNull
    public static final String PASSKEY_RESPONSE_ASSERTION_HEADER = "Assertion";

    @NotNull
    public static final String PASSKEY_RESPONSE_CONTEXT_HEADER = "x-ms-ctx";

    @NotNull
    public static final String PASSKEY_RESPONSE_FLOWTOKEN_HEADER = "x-ms-flowToken";

    @NotNull
    public static final String WEBAUTHN_AUTHENTICATION_ASSERTION_RESPONSE_JSON_KEY = "response";

    @NotNull
    public static final String WEBAUTHN_QUERY_PARAMETER_FIELD = "webauthn";

    @NotNull
    public static final String WEBAUTHN_QUERY_PARAMETER_VALUE = "1";

    @NotNull
    public static final String WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY = "authenticatorData";

    @NotNull
    public static final String WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY = "clientDataJSON";

    @NotNull
    public static final String WEBAUTHN_RESPONSE_ID_JSON_KEY = "id";

    @NotNull
    public static final String WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY = "signature";

    @NotNull
    public static final String WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY = "userHandle";
}
