package com.google.api.client.googleapis.auth.oauth2;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlException;
import java.util.Locale;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
class DefaultCredentialProvider extends SystemEnvironmentProvider {
    static final String APP_ENGINE_CREDENTIAL_CLASS = "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper";
    static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";
    static final String CLOUD_SHELL_ENV_VAR = "DEVSHELL_CLIENT_PORT";
    static final String CREDENTIAL_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS";
    static final String HELP_PERMALINK = "https://developers.google.com/accounts/docs/application-default-credentials";
    static final String WELL_KNOWN_CREDENTIALS_FILE = "application_default_credentials.json";
    private GoogleCredential cachedCredential = null;
    private Environment detectedEnvironment = null;

    /* JADX INFO: renamed from: com.google.api.client.googleapis.auth.oauth2.DefaultCredentialProvider$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C53531 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment */
        static final /* synthetic */ int[] f3246x52b60e20;

        static {
            int[] iArr = new int[Environment.values().length];
            f3246x52b60e20 = iArr;
            try {
                iArr[Environment.ENVIRONMENT_VARIABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3246x52b60e20[Environment.WELL_KNOWN_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3246x52b60e20[Environment.APP_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3246x52b60e20[Environment.CLOUD_SHELL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3246x52b60e20[Environment.COMPUTE_ENGINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ComputeGoogleCredential extends GoogleCredential {
        private static final String TOKEN_SERVER_ENCODED_URL = OAuth2Utils.getMetadataServerUrl() + "/computeMetadata/v1/instance/service-accounts/default/token";

        public ComputeGoogleCredential(HttpTransport httpTransport, JsonFactory jsonFactory) {
            super(new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory).setTokenServerEncodedUrl(TOKEN_SERVER_ENCODED_URL));
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
        public TokenResponse executeRefreshToken() throws IOException {
            HttpRequest httpRequestBuildGetRequest = getTransport().createRequestFactory().buildGetRequest(new GenericUrl(getTokenServerEncodedUrl()));
            JsonObjectParser jsonObjectParser = new JsonObjectParser(getJsonFactory());
            httpRequestBuildGetRequest.setParser(jsonObjectParser);
            httpRequestBuildGetRequest.getHeaders().set("Metadata-Flavor", "Google");
            httpRequestBuildGetRequest.setThrowExceptionOnExecuteError(false);
            HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
            int statusCode = httpResponseExecute.getStatusCode();
            if (statusCode != 200) {
                if (statusCode == 404) {
                    throw new IOException(AbstractC0541b.m767i(statusCode, "Error code ", " trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified."));
                }
                throw new IOException(AbstractC2322a.m1616f(statusCode, "Unexpected Error code ", " trying to get security access token from Compute Engine metadata for the default service account: ", httpResponseExecute.parseAsString()));
            }
            InputStream content = httpResponseExecute.getContent();
            if (content != null) {
                return (TokenResponse) jsonObjectParser.parseAndClose(content, httpResponseExecute.getContentCharset(), TokenResponse.class);
            }
            throw new IOException("Empty content from metadata token server request.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Environment {
        UNKNOWN,
        ENVIRONMENT_VARIABLE,
        WELL_KNOWN_FILE,
        CLOUD_SHELL,
        APP_ENGINE,
        COMPUTE_ENGINE
    }

    private final Environment detectEnvironment(HttpTransport httpTransport) {
        return runningUsingEnvironmentVariable() ? Environment.ENVIRONMENT_VARIABLE : runningUsingWellKnownFile() ? Environment.WELL_KNOWN_FILE : runningOnAppEngine() ? Environment.APP_ENGINE : runningOnCloudShell() ? Environment.CLOUD_SHELL : OAuth2Utils.runningOnComputeEngine(httpTransport, this) ? Environment.COMPUTE_ENGINE : Environment.UNKNOWN;
    }

    private final GoogleCredential getAppEngineCredential(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        try {
            return (GoogleCredential) forName(APP_ENGINE_CREDENTIAL_CLASS).getConstructor(HttpTransport.class, JsonFactory.class).newInstance(httpTransport, jsonFactory);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw ((IOException) OAuth2Utils.exceptionWithCause(new IOException("Application Default Credentials failed to create the Google App Engine service account credentials class com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper. Check that the component 'google-api-client-appengine' is deployed."), e));
        }
    }

    private GoogleCredential getCloudShellCredential(JsonFactory jsonFactory) {
        return new CloudShellCredential(Integer.parseInt(getEnv(CLOUD_SHELL_ENV_VAR)), jsonFactory);
    }

    private final GoogleCredential getComputeCredential(HttpTransport httpTransport, JsonFactory jsonFactory) {
        return new ComputeGoogleCredential(httpTransport, jsonFactory);
    }

    private GoogleCredential getCredentialUsingEnvironmentVariable(HttpTransport httpTransport, JsonFactory jsonFactory) throws Throwable {
        FileInputStream fileInputStream;
        String env = getEnv(CREDENTIAL_ENV_VAR);
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(env);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            GoogleCredential googleCredentialFromStream = GoogleCredential.fromStream(fileInputStream, httpTransport, jsonFactory);
            fileInputStream.close();
            return googleCredentialFromStream;
        } catch (IOException e2) {
            e = e2;
            throw ((IOException) OAuth2Utils.exceptionWithCause(new IOException("Error reading credential file from environment variable GOOGLE_APPLICATION_CREDENTIALS, value '" + env + "': " + e.getMessage()), e));
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private GoogleCredential getCredentialUsingWellKnownFile(HttpTransport httpTransport, JsonFactory jsonFactory) throws Throwable {
        FileInputStream fileInputStream;
        File wellKnownCredentialsFile = getWellKnownCredentialsFile();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(wellKnownCredentialsFile);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            GoogleCredential googleCredentialFromStream = GoogleCredential.fromStream(fileInputStream, httpTransport, jsonFactory);
            fileInputStream.close();
            return googleCredentialFromStream;
        } catch (IOException e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            throw new IOException(String.format("Error reading credential file from location %s: %s", wellKnownCredentialsFile, e.getMessage()));
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private final GoogleCredential getDefaultCredentialUnsynchronized(HttpTransport httpTransport, JsonFactory jsonFactory) {
        if (this.detectedEnvironment == null) {
            this.detectedEnvironment = detectEnvironment(httpTransport);
        }
        int i = C53531.f3246x52b60e20[this.detectedEnvironment.ordinal()];
        if (i == 1) {
            return getCredentialUsingEnvironmentVariable(httpTransport, jsonFactory);
        }
        if (i == 2) {
            return getCredentialUsingWellKnownFile(httpTransport, jsonFactory);
        }
        if (i == 3) {
            return getAppEngineCredential(httpTransport, jsonFactory);
        }
        if (i == 4) {
            return getCloudShellCredential(jsonFactory);
        }
        if (i != 5) {
            return null;
        }
        return getComputeCredential(httpTransport, jsonFactory);
    }

    private final File getWellKnownCredentialsFile() {
        return new File(getProperty(SystemProperties.OS_NAME, "").toLowerCase(Locale.US).indexOf("windows") >= 0 ? new File(new File(getEnv("APPDATA")), CLOUDSDK_CONFIG_DIRECTORY) : new File(new File(getProperty("user.home", ""), ".config"), CLOUDSDK_CONFIG_DIRECTORY), WELL_KNOWN_CREDENTIALS_FILE);
    }

    private boolean runningOnAppEngine() {
        try {
            try {
                Field field = forName("com.google.appengine.api.utils.SystemProperty").getField("environment");
                return field.getType().getMethod("value", null).invoke(field.get(null), null) != null;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw ((RuntimeException) OAuth2Utils.exceptionWithCause(new RuntimeException(AbstractC0541b.m772n("Unexpcted error trying to determine if runnning on Google App Engine: ", e.getMessage())), e));
            }
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean runningOnCloudShell() {
        return getEnv(CLOUD_SHELL_ENV_VAR) != null;
    }

    private boolean runningUsingEnvironmentVariable() throws IOException {
        String env = getEnv(CREDENTIAL_ENV_VAR);
        if (env != null && env.length() != 0) {
            try {
                File file = new File(env);
                if (file.exists() && !file.isDirectory()) {
                    return true;
                }
                throw new IOException("Error reading credential file from environment variable GOOGLE_APPLICATION_CREDENTIALS, value '" + env + "': File does not exist.");
            } catch (AccessControlException unused) {
            }
        }
        return false;
    }

    private boolean runningUsingWellKnownFile() {
        try {
            return fileExists(getWellKnownCredentialsFile());
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public boolean fileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public Class<?> forName(String str) {
        return Class.forName(str);
    }

    public final GoogleCredential getDefaultCredential(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        synchronized (this) {
            try {
                if (this.cachedCredential == null) {
                    this.cachedCredential = getDefaultCredentialUnsynchronized(httpTransport, jsonFactory);
                }
                GoogleCredential googleCredential = this.cachedCredential;
                if (googleCredential != null) {
                    return googleCredential;
                }
                throw new IOException("The Application Default Credentials are not available. They are available if running on Google App Engine, Google Compute Engine, or Google Cloud Shell. Otherwise, the environment variable GOOGLE_APPLICATION_CREDENTIALS must be defined pointing to a file defining the credentials. See https://developers.google.com/accounts/docs/application-default-credentials for more information.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getProperty(String str, String str2) {
        return System.getProperty(str, str2);
    }
}
