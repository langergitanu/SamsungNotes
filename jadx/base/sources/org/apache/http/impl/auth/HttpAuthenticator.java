package org.apache.http.impl.auth;

import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Asserts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HttpAuthenticator {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState = null;
    private static final String TAG = "HttpClient";

    public static /* synthetic */ int[] $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState() {
        int[] iArr = $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AuthProtocolState.valuesCustom().length];
        try {
            iArr2[AuthProtocolState.CHALLENGED.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AuthProtocolState.FAILURE.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AuthProtocolState.HANDSHAKE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AuthProtocolState.SUCCESS.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AuthProtocolState.UNCHALLENGED.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState = iArr2;
        return iArr2;
    }

    private Header doAuth(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) {
        return authScheme instanceof ContextAwareAuthScheme ? ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext) : authScheme.authenticate(credentials, httpRequest);
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    public void generateAuthResponse(HttpRequest httpRequest, AuthStateHC4 authStateHC4, HttpContext httpContext) {
        AuthScheme authScheme = authStateHC4.getAuthScheme();
        Credentials credentials = authStateHC4.getCredentials();
        int i = $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState()[authStateHC4.getState().ordinal()];
        if (i == 2) {
            Queue<AuthOption> authOptions = authStateHC4.getAuthOptions();
            if (authOptions != null) {
                while (!authOptions.isEmpty()) {
                    AuthOption authOptionRemove = authOptions.remove();
                    AuthScheme authScheme2 = authOptionRemove.getAuthScheme();
                    Credentials credentials2 = authOptionRemove.getCredentials();
                    authStateHC4.update(authScheme2, credentials2);
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Generating response to an authentication challenge using " + authScheme2.getSchemeName() + " scheme");
                    }
                    try {
                        httpRequest.addHeader(doAuth(authScheme2, credentials2, httpRequest, httpContext));
                        return;
                    } catch (AuthenticationException e) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, authScheme2 + " authentication error: " + e.getMessage());
                        }
                    }
                }
                return;
            }
            ensureAuthScheme(authScheme);
        } else {
            if (i == 4) {
                return;
            }
            if (i == 5) {
                ensureAuthScheme(authScheme);
                if (authScheme.isConnectionBased()) {
                    return;
                }
            }
        }
        if (authScheme != null) {
            try {
                httpRequest.addHeader(doAuth(authScheme, credentials, httpRequest, httpContext));
            } catch (AuthenticationException e2) {
                if (Log.isLoggable(TAG, 6)) {
                    Log.e(TAG, authScheme + " authentication error: " + e2.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0077 A[Catch: MalformedChallengeException -> 0x001d, TryCatch #0 {MalformedChallengeException -> 0x001d, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0020, B:10:0x002a, B:12:0x0030, B:14:0x0036, B:47:0x00c1, B:49:0x00c7, B:51:0x00cd, B:53:0x00d3, B:54:0x00e4, B:23:0x0056, B:26:0x005d, B:28:0x0063, B:29:0x0068, B:32:0x0077, B:34:0x0089, B:36:0x008f, B:37:0x0094, B:39:0x009d, B:41:0x00a3, B:42:0x00a8, B:44:0x00b8, B:46:0x00be), top: B:62:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleAuthChallenge(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthStateHC4 authStateHC4, HttpContext httpContext) {
        try {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, String.valueOf(httpHost.toHostString()).concat(" requested authentication"));
            }
            Map<String, Header> challenges = authenticationStrategy.getChallenges(httpHost, httpResponse, httpContext);
            if (challenges.isEmpty()) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Response contains no authentication challenges");
                }
                return false;
            }
            AuthScheme authScheme = authStateHC4.getAuthScheme();
            int i = $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState()[authStateHC4.getState().ordinal()];
            if (i == 1) {
                if (authScheme != null) {
                    Header header = challenges.get(authScheme.getSchemeName().toLowerCase(Locale.ENGLISH));
                    if (header != null) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Authorization challenge processed");
                        }
                        authScheme.processChallenge(header);
                        if (!authScheme.isComplete()) {
                            authStateHC4.setState(AuthProtocolState.HANDSHAKE);
                            return true;
                        }
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Authentication failed");
                        }
                        authenticationStrategy.authFailed(httpHost, authStateHC4.getAuthScheme(), httpContext);
                        authStateHC4.reset();
                        authStateHC4.setState(AuthProtocolState.FAILURE);
                        return false;
                    }
                    authStateHC4.reset();
                }
            } else if (i == 2 || i == 3) {
                if (authScheme == null) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Auth scheme is null");
                    }
                    authenticationStrategy.authFailed(httpHost, null, httpContext);
                    authStateHC4.reset();
                    authStateHC4.setState(AuthProtocolState.FAILURE);
                    return false;
                }
                if (authScheme != null) {
                }
            } else {
                if (i == 4) {
                    return false;
                }
                if (i == 5) {
                    authStateHC4.reset();
                }
            }
            Queue<AuthOption> queueSelect = authenticationStrategy.select(challenges, httpHost, httpResponse, httpContext);
            if (queueSelect == null || queueSelect.isEmpty()) {
                return false;
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Selected authentication options: " + queueSelect);
            }
            authStateHC4.setState(AuthProtocolState.CHALLENGED);
            authStateHC4.update(queueSelect);
            return true;
        } catch (MalformedChallengeException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Malformed challenge: " + e.getMessage());
            }
            authStateHC4.reset();
            return false;
        }
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthStateHC4 authStateHC4, HttpContext httpContext) {
        if (authenticationStrategy.isAuthenticationRequested(httpHost, httpResponse, httpContext)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Authentication required");
            }
            if (authStateHC4.getState() != AuthProtocolState.SUCCESS) {
                return true;
            }
            authenticationStrategy.authFailed(httpHost, authStateHC4.getAuthScheme(), httpContext);
            return true;
        }
        int i = $SWITCH_TABLE$org$apache$http$auth$AuthProtocolState()[authStateHC4.getState().ordinal()];
        if (i != 2 && i != 3) {
            if (i == 5) {
                return false;
            }
            authStateHC4.setState(AuthProtocolState.UNCHALLENGED);
            return false;
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Authentication succeeded");
        }
        authStateHC4.setState(AuthProtocolState.SUCCESS);
        authenticationStrategy.authSucceeded(httpHost, authStateHC4.getAuthScheme(), httpContext);
        return false;
    }
}
