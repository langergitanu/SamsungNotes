package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.Gson;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OpenIdProviderConfigurationClient {
    private static final String HTTPS_SCHEME = "https";
    private static final String TAG = "OpenIdProviderConfigurationClient";
    private static final String WELL_KNOWN_CONFIG_HOST = "login.microsoftonline.com";
    private static final String WELL_KNOWN_CONFIG_PATH = "/v2.0/.well-known/openid-configuration";
    private static final ExecutorService sBackgroundExecutor = Executors.newCachedThreadPool();
    private static final Map<URI, OpenIdProviderConfiguration> sConfigCache = new HashMap();
    private static final HttpClient httpClient = UrlConnectionHttpClient.getDefaultInstance();
    private static final Gson GSON = new Gson();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OpenIdProviderConfigurationCallback extends TaskCompletedCallbackWithError<OpenIdProviderConfiguration, Exception> {
    }

    private void cacheConfiguration(@NonNull URI uri, @NonNull OpenIdProviderConfiguration openIdProviderConfiguration) {
        if (uri == null) {
            throw new NullPointerException("configUrl is marked non-null but is null");
        }
        if (openIdProviderConfiguration == null) {
            throw new NullPointerException("parsedConfig is marked non-null but is null");
        }
        sConfigCache.put(uri, openIdProviderConfiguration);
    }

    private synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationInternal(@NonNull String str, String str2) {
        String str3;
        try {
            if (str == null) {
                throw new NullPointerException("tenantedAuthorityString is marked non-null but is null");
            }
            try {
                if (str2 != null) {
                    str3 = sanitize(str) + WELL_KNOWN_CONFIG_PATH + str2;
                } else {
                    str3 = sanitize(str) + WELL_KNOWN_CONFIG_PATH;
                }
                URI uri = new URI(str3);
                OpenIdProviderConfiguration openIdProviderConfiguration = sConfigCache.get(uri);
                if (openIdProviderConfiguration != null) {
                    Logger.info(TAG + ":loadOpenIdProviderConfiguration", "Using cached metadata result.");
                    return openIdProviderConfiguration;
                }
                StringBuilder sb = new StringBuilder();
                String str4 = TAG;
                sb.append(str4);
                sb.append(":loadOpenIdProviderConfiguration");
                Logger.verbose(sb.toString(), "Config URL is valid.");
                Logger.verbosePII(str4 + ":loadOpenIdProviderConfiguration", "Using request URL: " + uri);
                HttpResponse httpResponse = httpClient.get(uri.toURL(), new HashMap());
                int statusCode = httpResponse.getStatusCode();
                if (200 != statusCode || StringUtil.isNullOrEmpty(httpResponse.getBody())) {
                    throw new ServiceException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "OpenId Provider Configuration metadata failed to load with status: " + statusCode, null);
                }
                OpenIdProviderConfiguration metadata = parseMetadata(httpResponse.getBody());
                cacheConfiguration(uri, metadata);
                return metadata;
            } catch (IOException e) {
                e = e;
                throw new ServiceException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "IOException while requesting metadata", e);
            } catch (URISyntaxException e2) {
                e = e2;
                throw new ServiceException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "IOException while requesting metadata", e);
            }
        } finally {
        }
    }

    private OpenIdProviderConfiguration parseMetadata(@NonNull String str) {
        if (str != null) {
            return (OpenIdProviderConfiguration) GSON.fromJson(str, OpenIdProviderConfiguration.class);
        }
        throw new NullPointerException("body is marked non-null but is null");
    }

    private String sanitize(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("issuer is marked non-null but is null");
        }
        return str.endsWith("/") ? str.substring(0, r0.length() - 1) : str.trim();
    }

    public void loadOpenIdProviderConfiguration(@NonNull final OpenIdProviderConfigurationCallback openIdProviderConfigurationCallback, @NonNull final String str) {
        if (openIdProviderConfigurationCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("authority is marked non-null but is null");
        }
        sBackgroundExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfigurationClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    openIdProviderConfigurationCallback.onTaskCompleted(OpenIdProviderConfigurationClient.this.loadOpenIdProviderConfigurationFromAuthority(str));
                } catch (ServiceException e) {
                    openIdProviderConfigurationCallback.onError(e);
                }
            }
        });
    }

    public synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationFromAuthority(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        return loadOpenIdProviderConfigurationInternal(str, null);
    }

    public synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationFromAuthorityWithExtraParams(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("extraParams is marked non-null but is null");
        }
        return loadOpenIdProviderConfigurationInternal(str, str2);
    }

    public synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationFromTenant(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tenantIdentifier is marked non-null but is null");
        }
        try {
        } catch (URISyntaxException e) {
            throw new ServiceException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "IOException while requesting metadata", e);
        }
        return loadOpenIdProviderConfigurationInternal(new CommonURIBuilder().setScheme("https").setHost(WELL_KNOWN_CONFIG_HOST).setPathSegments(str).build().toString(), null);
    }
}
