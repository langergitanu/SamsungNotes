package com.microsoft.identity.common.java.exception;

import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.util.HashMapExtensions;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ServiceException extends BaseException {
    public static final String ACCESS_DENIED = "access_denied";
    public static final int DEFAULT_STATUS_CODE = 0;
    public static final String INVALID_INSTANCE = "invalid_instance";
    public static final String INVALID_REQUEST = "invalid_request";
    public static final String INVALID_SCOPE = "invalid_scope";
    public static final String MsaGrantedRefreshTokenNotSupportedOnAadTenantErrorCode = "1000030";
    public static final String OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD = "failed_to_load_openid_configuration";
    public static final String REQUEST_THROTTLED_AT_ESTS_GATEWAY = "request_throttled_at_ESTS_gateway";
    public static final String REQUEST_TIMEOUT = "request_timeout";
    public static final String SERVICE_NOT_AVAILABLE = "service_not_available";
    public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
    public static final String UNKNOWN_ERROR = "unknown_error";
    public static final String sName = "com.microsoft.identity.common.exception.ServiceException";
    private static final long serialVersionUID = 5139563940871615046L;
    private HashMap<String, String> mHttpResponseBody;
    private HashMap<String, List<String>> mHttpResponseHeaders;
    private int mHttpStatusCode;
    private String mOauthSubErrorCode;

    public ServiceException(String str, String str2, Throwable th) {
        super(str, str2, th);
        this.mHttpResponseBody = null;
        this.mHttpResponseHeaders = null;
        this.mHttpStatusCode = 0;
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }

    public HashMap<String, String> getHttpResponseBody() {
        return this.mHttpResponseBody;
    }

    public HashMap<String, List<String>> getHttpResponseHeaders() {
        return this.mHttpResponseHeaders;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String getOAuthSubErrorCode() {
        return this.mOauthSubErrorCode;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        if (httpResponse != null) {
            this.mHttpStatusCode = httpResponse.getStatusCode();
            if (httpResponse.getHeaders() != null) {
                this.mHttpResponseHeaders = new HashMap<>(httpResponse.getHeaders());
            }
            if (httpResponse.getBody() != null) {
                this.mHttpResponseBody = HashMapExtensions.getJsonResponse(httpResponse);
            }
        }
    }

    public void setHttpResponseBody(HashMap<String, String> map) {
        this.mHttpResponseBody = map;
    }

    public void setHttpResponseHeaders(HashMap<String, List<String>> map) {
        this.mHttpResponseHeaders = map;
    }

    public void setOauthSubErrorCode(@Nullable String str) {
        this.mOauthSubErrorCode = str;
    }

    public ServiceException(String str, String str2, int i, Throwable th) {
        super(str, str2, th);
        this.mHttpResponseBody = null;
        this.mHttpResponseHeaders = null;
        this.mHttpStatusCode = i;
    }
}
