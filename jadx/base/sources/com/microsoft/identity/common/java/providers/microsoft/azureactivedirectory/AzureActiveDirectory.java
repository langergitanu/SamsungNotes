package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.authorities.Environment;
import com.microsoft.identity.common.java.cache.HttpCache;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectory extends IdentityProvider<AzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryOAuth2Configuration> {
    private static final String AAD_INSTANCE_DISCOVERY_ENDPOINT = "/common/discovery/instance";
    private static final String API_VERSION = "api-version";
    private static final String API_VERSION_VALUE = "1.1";
    private static final String AUTHORIZATION_ENDPOINT = "authorization_endpoint";
    private static final String AUTHORIZATION_ENDPOINT_VALUE = "https://login.microsoftonline.com/common/oauth2/v2.0/authorize";
    private static final String METADATA = "metadata";
    private static final String TAG = "AzureActiveDirectory";
    private static final String TENANT_DISCOVERY_ENDPOINT = "tenant_discovery_endpoint";
    private static ConcurrentMap<String, AzureActiveDirectoryCloud> sAadClouds = new ConcurrentHashMap();
    private static boolean sIsInitialized = false;
    private static Environment sEnvironment = Environment.Production;
    private static final HttpClient httpClient = UrlConnectionHttpClient.getDefaultInstance();

    private static List<AzureActiveDirectoryCloud> deserializeClouds(String str) {
        return (List) new Gson().fromJson(str, TypeToken.getParameterized(List.class, AzureActiveDirectoryCloud.class).getType());
    }

    public static synchronized AzureActiveDirectoryCloud getAzureActiveDirectoryCloud(@NonNull URL url) {
        if (url == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        return sAadClouds.get(url.getHost().toLowerCase(Locale.US));
    }

    public static synchronized AzureActiveDirectoryCloud getAzureActiveDirectoryCloudFromHostName(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("preferredCacheHostName is marked non-null but is null");
        }
        return sAadClouds.get(str.toLowerCase(Locale.US));
    }

    public static synchronized List<AzureActiveDirectoryCloud> getClouds() {
        if (sAadClouds != null) {
            return new ArrayList(sAadClouds.values());
        }
        return new ArrayList();
    }

    public static synchronized String getDefaultCloudUrl() {
        return sEnvironment == Environment.PreProduction ? AzureActiveDirectoryEnvironment.PREPRODUCTION_CLOUD_URL : AzureActiveDirectoryEnvironment.PRODUCTION_CLOUD_URL;
    }

    public static synchronized Environment getEnvironment() {
        return sEnvironment;
    }

    public static synchronized Set<String> getHosts() {
        ConcurrentMap<String, AzureActiveDirectoryCloud> concurrentMap = sAadClouds;
        if (concurrentMap == null) {
            return null;
        }
        return concurrentMap.keySet();
    }

    public static synchronized boolean hasCloudHost(@NonNull URL url) {
        if (url == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        return sAadClouds.containsKey(url.getHost().toLowerCase(Locale.US));
    }

    public static synchronized void initializeCloudMetadata(@NonNull String str, @NonNull Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("authorityHost is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("discoveryResponse is marked non-null but is null");
        }
        boolean zContainsKey = map.containsKey(TENANT_DISCOVERY_ENDPOINT);
        String str2 = map.get("metadata");
        if (!zContainsKey) {
            sAadClouds.put(str, new AzureActiveDirectoryCloud(false));
            return;
        }
        if (StringUtil.isNullOrEmpty(str2)) {
            sAadClouds.put(str, new AzureActiveDirectoryCloud(str, str));
            return;
        }
        for (AzureActiveDirectoryCloud azureActiveDirectoryCloud : deserializeClouds(str2)) {
            azureActiveDirectoryCloud.setIsValidated(true);
            Iterator<String> it = azureActiveDirectoryCloud.getHostAliases().iterator();
            while (it.hasNext()) {
                sAadClouds.put(it.next().toLowerCase(Locale.US), azureActiveDirectoryCloud);
            }
        }
        sIsInitialized = true;
    }

    public static synchronized boolean isInitialized() {
        return sIsInitialized;
    }

    public static synchronized boolean isValidCloudHost(@NonNull URL url) {
        if (url == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        return hasCloudHost(url) && getAzureActiveDirectoryCloud(url).isValidated();
    }

    public static synchronized void performCloudDiscovery() {
        try {
            HttpResponse httpResponse = httpClient.get(new URL(new CommonURIBuilder(getDefaultCloudUrl() + AAD_INSTANCE_DISCOVERY_ENDPOINT).setParameter(API_VERSION, API_VERSION_VALUE).setParameter("authorization_endpoint", AUTHORIZATION_ENDPOINT_VALUE).build().toString()), new HashMap());
            if (httpResponse.getStatusCode() >= 400) {
                Logger.warn(TAG + ":performCloudDiscovery", "Error getting cloud information");
            } else {
                HttpCache.flush();
                StringBuilder sb = new StringBuilder();
                String str = TAG;
                sb.append(str);
                sb.append(":performCloudDiscovery");
                Logger.info(sb.toString(), "Parsing response.");
                AzureActiveDirectoryInstanceResponse azureActiveDirectoryInstanceResponse = (AzureActiveDirectoryInstanceResponse) ObjectMapper.deserializeJsonStringToObject(httpResponse.getBody(), AzureActiveDirectoryInstanceResponse.class);
                Logger.info(str + ":performCloudDiscovery", "Discovered [" + azureActiveDirectoryInstanceResponse.getClouds().size() + "] clouds.");
                for (AzureActiveDirectoryCloud azureActiveDirectoryCloud : azureActiveDirectoryInstanceResponse.getClouds()) {
                    azureActiveDirectoryCloud.setIsValidated(true);
                    Iterator<String> it = azureActiveDirectoryCloud.getHostAliases().iterator();
                    while (it.hasNext()) {
                        sAadClouds.put(it.next().toLowerCase(Locale.US), azureActiveDirectoryCloud);
                    }
                }
                sIsInitialized = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void putCloud(@NonNull String str, AzureActiveDirectoryCloud azureActiveDirectoryCloud) {
        if (str == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        sAadClouds.put(str.toLowerCase(Locale.US), azureActiveDirectoryCloud);
    }

    public static synchronized void setEnvironment(@NonNull Environment environment) {
        if (environment == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        if (environment != sEnvironment) {
            sIsInitialized = false;
            sEnvironment = environment;
        }
    }

    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public AzureActiveDirectoryOAuth2Strategy createOAuth2Strategy(@NonNull AzureActiveDirectoryOAuth2Configuration azureActiveDirectoryOAuth2Configuration, @NonNull IPlatformComponents iPlatformComponents) {
        if (azureActiveDirectoryOAuth2Configuration == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        if (iPlatformComponents != null) {
            return new AzureActiveDirectoryOAuth2Strategy(azureActiveDirectoryOAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
        }
        throw new NullPointerException("commonComponents is marked non-null but is null");
    }
}
