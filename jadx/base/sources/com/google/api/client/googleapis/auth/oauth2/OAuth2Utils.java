package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class OAuth2Utils {
    private static final int COMPUTE_PING_CONNECTION_TIMEOUT_MS = 500;
    private static final String DEFAULT_METADATA_SERVER_URL = "http://169.254.169.254";
    private static final int MAX_COMPUTE_PING_TRIES = 3;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Logger LOGGER = Logger.getLogger(OAuth2Utils.class.getName());

    public static <T extends Throwable> T exceptionWithCause(T t, Throwable th) {
        t.initCause(th);
        return t;
    }

    public static String getMetadataServerUrl() {
        return getMetadataServerUrl(SystemEnvironmentProvider.INSTANCE);
    }

    public static boolean headersContainValue(HttpHeaders httpHeaders, String str, String str2) {
        Object obj = httpHeaders.get(str);
        if (!(obj instanceof Collection)) {
            return false;
        }
        for (Object obj2 : (Collection) obj) {
            if ((obj2 instanceof String) && ((String) obj2).equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean runningOnComputeEngine(HttpTransport httpTransport, SystemEnvironmentProvider systemEnvironmentProvider) {
        if (Boolean.parseBoolean(systemEnvironmentProvider.getEnv("NO_GCE_CHECK"))) {
            return false;
        }
        GenericUrl genericUrl = new GenericUrl(getMetadataServerUrl(systemEnvironmentProvider));
        for (int i = 1; i <= 3; i++) {
            try {
                HttpRequest httpRequestBuildGetRequest = httpTransport.createRequestFactory().buildGetRequest(genericUrl);
                httpRequestBuildGetRequest.setConnectTimeout(500);
                HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
                try {
                    return headersContainValue(httpResponseExecute.getHeaders(), "Metadata-Flavor", "Google");
                } finally {
                    httpResponseExecute.disconnect();
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Failed to detect whether we are running on Google Compute Engine.", (Throwable) e);
            }
        }
        return false;
    }

    public static String getMetadataServerUrl(SystemEnvironmentProvider systemEnvironmentProvider) {
        String env = systemEnvironmentProvider.getEnv("GCE_METADATA_HOST");
        return env != null ? WebConstants.HTTP_PROTOCOL.concat(env) : DEFAULT_METADATA_SERVER_URL;
    }
}
