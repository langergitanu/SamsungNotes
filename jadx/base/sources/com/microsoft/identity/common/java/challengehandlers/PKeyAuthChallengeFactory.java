package com.microsoft.identity.common.java.challengehandlers;

import com.microsoft.identity.common.java.challengehandlers.PKeyAuthChallenge;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PKeyAuthChallengeFactory {
    private static final String CHALLENGE_REQUEST_CERT_AUTH_DELIMITER = ";";
    private static final String TAG = "PKeyAuthChallengeFactory";

    private Map<String, String> getPKeyAuthHeader(String str) throws ClientException {
        String strSubstring = str.substring(8);
        ArrayList<String> arrayListSplitWithQuotes = StringUtil.splitWithQuotes(strSubstring, ',');
        HashMap map = new HashMap();
        Iterator<String> it = arrayListSplitWithQuotes.iterator();
        while (it.hasNext()) {
            ArrayList<String> arrayListSplitWithQuotes2 = StringUtil.splitWithQuotes(it.next(), '=');
            if (arrayListSplitWithQuotes2.size() == 2 && !StringUtil.isNullOrEmpty(arrayListSplitWithQuotes2.get(0)) && !StringUtil.isNullOrEmpty(arrayListSplitWithQuotes2.get(1))) {
                String str2 = arrayListSplitWithQuotes2.get(0);
                String str3 = arrayListSplitWithQuotes2.get(1);
                map.put(StringUtil.urlFormDecode(str2).trim(), StringUtil.removeQuoteInHeaderValue(StringUtil.urlFormDecode(str3).trim()));
            } else {
                if (arrayListSplitWithQuotes2.size() != 1 || StringUtil.isNullOrEmpty(arrayListSplitWithQuotes2.get(0))) {
                    throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, strSubstring);
                }
                map.put(StringUtil.urlFormDecode(arrayListSplitWithQuotes2.get(0)).trim(), StringUtil.urlFormDecode(""));
            }
        }
        return map;
    }

    private void validateHeaderForPkeyAuthChallenge(@NonNull String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("header is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "header value is empty.");
        }
        if (!StringUtil.hasPrefixInHeader(str, "PKeyAuth")) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "challenge response type is wrong.");
        }
    }

    private void validatePKeyAuthChallengeFromTokenEndpointResponse(Map<String, String> map) throws ClientException {
        PKeyAuthChallenge.RequestField requestField = PKeyAuthChallenge.RequestField.Nonce;
        if (!map.containsKey(requestField.name()) && !map.containsKey(requestField.name().toLowerCase(Locale.US))) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Nonce is empty.");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Context.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Context is empty");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Version.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Version name is empty");
        }
    }

    private void validatePKeyAuthChallengeFromWebViewRedirect(Map<String, String> map) throws ClientException {
        PKeyAuthChallenge.RequestField requestField = PKeyAuthChallenge.RequestField.Nonce;
        if (!map.containsKey(requestField.name()) && !map.containsKey(requestField.name().toLowerCase(Locale.US))) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Nonce is empty.");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Context.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Context is empty");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Version.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Version name is empty");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.SubmitUrl.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "SubmitUrl is empty");
        }
    }

    public PKeyAuthChallenge getPKeyAuthChallengeFromTokenEndpointResponse(@NonNull String str, @NonNull String str2) throws ClientException {
        if (str == null) {
            throw new NullPointerException("header is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("authority is marked non-null but is null");
        }
        validateHeaderForPkeyAuthChallenge(str);
        Map<String, String> pKeyAuthHeader = getPKeyAuthHeader(str);
        validatePKeyAuthChallengeFromTokenEndpointResponse(pKeyAuthHeader);
        PKeyAuthChallenge.PKeyAuthChallengeBuilder pKeyAuthChallengeBuilder = new PKeyAuthChallenge.PKeyAuthChallengeBuilder();
        pKeyAuthChallengeBuilder.submitUrl(str2).nonce(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.Nonce.name().toLowerCase(Locale.US))).context(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.Context.name())).version(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.Version.name())).tenantId(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.TenantId.name()));
        PKeyAuthChallenge.RequestField requestField = PKeyAuthChallenge.RequestField.CertThumbprint;
        if (StringUtil.isNullOrEmpty(pKeyAuthHeader.get(requestField.name()))) {
            PKeyAuthChallenge.RequestField requestField2 = PKeyAuthChallenge.RequestField.CertAuthorities;
            if (pKeyAuthHeader.containsKey(requestField2.name())) {
                pKeyAuthChallengeBuilder.certAuthorities(StringUtil.getStringTokens(pKeyAuthHeader.get(requestField2.name()), ";"));
            }
        } else {
            pKeyAuthChallengeBuilder.thumbprint(pKeyAuthHeader.get(requestField.name()));
        }
        return pKeyAuthChallengeBuilder.build();
    }

    public PKeyAuthChallenge getPKeyAuthChallengeFromWebViewRedirect(@NonNull String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        Map<String, String> parameters = UrlUtil.getParameters(str);
        validatePKeyAuthChallengeFromWebViewRedirect(parameters);
        PKeyAuthChallenge.PKeyAuthChallengeBuilder pKeyAuthChallengeBuilder = new PKeyAuthChallenge.PKeyAuthChallengeBuilder();
        pKeyAuthChallengeBuilder.nonce(parameters.get(PKeyAuthChallenge.RequestField.Nonce.name().toLowerCase(Locale.US))).context(parameters.get(PKeyAuthChallenge.RequestField.Context.name())).version(parameters.get(PKeyAuthChallenge.RequestField.Version.name())).submitUrl(parameters.get(PKeyAuthChallenge.RequestField.SubmitUrl.name())).tenantId(parameters.get(PKeyAuthChallenge.RequestField.TenantId.name()));
        PKeyAuthChallenge.RequestField requestField = PKeyAuthChallenge.RequestField.CertAuthorities;
        if (parameters.containsKey(requestField.name())) {
            pKeyAuthChallengeBuilder.certAuthorities(StringUtil.getStringTokens(parameters.get(requestField.name()), ";"));
        }
        return pKeyAuthChallengeBuilder.build();
    }
}
