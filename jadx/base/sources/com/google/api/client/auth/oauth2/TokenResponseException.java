package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class TokenResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4020689092957439244L;
    private final transient TokenErrorResponse details;

    public TokenResponseException(HttpResponseException.Builder builder, TokenErrorResponse tokenErrorResponse) {
        super(builder);
        this.details = tokenErrorResponse;
    }

    public static TokenResponseException from(JsonFactory jsonFactory, HttpResponse httpResponse) {
        TokenErrorResponse tokenErrorResponse;
        String asString;
        HttpResponseException.Builder builder = new HttpResponseException.Builder(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
        Preconditions.checkNotNull(jsonFactory);
        String contentType = httpResponse.getContentType();
        String str = null;
        TokenErrorResponse tokenErrorResponse2 = null;
        try {
            if (httpResponse.isSuccessStatusCode() || contentType == null || httpResponse.getContent() == null || !HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, contentType)) {
                asString = httpResponse.parseAsString();
            } else {
                tokenErrorResponse = (TokenErrorResponse) new JsonObjectParser(jsonFactory).parseAndClose(httpResponse.getContent(), httpResponse.getContentCharset(), TokenErrorResponse.class);
                try {
                    tokenErrorResponse2 = tokenErrorResponse;
                    asString = tokenErrorResponse.toPrettyString();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                }
            }
            TokenErrorResponse tokenErrorResponse3 = tokenErrorResponse2;
            str = asString;
            tokenErrorResponse = tokenErrorResponse3;
        } catch (IOException e2) {
            e = e2;
            tokenErrorResponse = null;
        }
        StringBuilder sbComputeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
        if (!Strings.isNullOrEmpty(str)) {
            sbComputeMessageBuffer.append(StringUtils.LINE_SEPARATOR);
            sbComputeMessageBuffer.append(str);
            builder.setContent(str);
        }
        builder.setMessage(sbComputeMessageBuffer.toString());
        return new TokenResponseException(builder, tokenErrorResponse);
    }

    public final TokenErrorResponse getDetails() {
        return this.details;
    }
}
