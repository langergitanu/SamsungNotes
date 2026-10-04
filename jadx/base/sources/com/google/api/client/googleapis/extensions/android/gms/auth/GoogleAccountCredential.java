package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class GoogleAccountCredential implements HttpRequestInitializer {
    private final GoogleAccountManager accountManager;
    private String accountName;
    private BackOff backOff;
    final Context context;
    final String scope;
    private Account selectedAccount;
    private Sleeper sleeper = Sleeper.DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Beta
    public class RequestHandler implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {
        boolean received401;
        String token;

        public RequestHandler() {
        }

        @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
        public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
            if (httpResponse.getStatusCode() != 401 || this.received401) {
                return false;
            }
            this.received401 = true;
            GoogleAuthUtil.invalidateToken(GoogleAccountCredential.this.context, this.token);
            return true;
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void intercept(HttpRequest httpRequest) throws GoogleAuthIOException {
            try {
                this.token = GoogleAccountCredential.this.getToken();
                httpRequest.getHeaders().setAuthorization(IdentityApiContract.Token.BEARER_ + this.token);
            } catch (GooglePlayServicesAvailabilityException e) {
                throw new GooglePlayServicesAvailabilityIOException(e);
            } catch (UserRecoverableAuthException e2) {
                throw new UserRecoverableAuthIOException(e2);
            } catch (GoogleAuthException e3) {
                throw new GoogleAuthIOException(e3);
            }
        }
    }

    public GoogleAccountCredential(Context context, String str) {
        this.accountManager = new GoogleAccountManager(context);
        this.context = context;
        this.scope = str;
    }

    public static GoogleAccountCredential usingAudience(Context context, String str) {
        Preconditions.checkArgument(str.length() != 0);
        return new GoogleAccountCredential(context, "audience:".concat(str));
    }

    public static GoogleAccountCredential usingOAuth2(Context context, Collection<String> collection) {
        Preconditions.checkArgument(collection != null && collection.iterator().hasNext());
        return new GoogleAccountCredential(context, "oauth2: " + Joiner.m4228on(' ').join(collection));
    }

    public final Account[] getAllAccounts() {
        return this.accountManager.getAccounts();
    }

    public BackOff getBackOff() {
        return this.backOff;
    }

    public final Context getContext() {
        return this.context;
    }

    public final GoogleAccountManager getGoogleAccountManager() {
        return this.accountManager;
    }

    public final String getScope() {
        return this.scope;
    }

    public final Account getSelectedAccount() {
        return this.selectedAccount;
    }

    public final String getSelectedAccountName() {
        return this.accountName;
    }

    public final Sleeper getSleeper() {
        return this.sleeper;
    }

    public String getToken() throws IOException {
        BackOff backOff;
        BackOff backOff2 = this.backOff;
        if (backOff2 != null) {
            backOff2.reset();
        }
        while (true) {
            try {
                return GoogleAuthUtil.getToken(this.context, this.accountName, this.scope);
            } catch (IOException e) {
                try {
                    backOff = this.backOff;
                } catch (InterruptedException unused) {
                }
                if (backOff == null || !BackOffUtils.next(this.sleeper, backOff)) {
                    throw e;
                }
            }
        }
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) {
        RequestHandler requestHandler = new RequestHandler();
        httpRequest.setInterceptor(requestHandler);
        httpRequest.setUnsuccessfulResponseHandler(requestHandler);
    }

    public final Intent newChooseAccountIntent() {
        return AccountPicker.newChooseAccountIntent(this.selectedAccount, null, new String[]{"com.google"}, true, null, null, null, null);
    }

    public GoogleAccountCredential setBackOff(BackOff backOff) {
        this.backOff = backOff;
        return this;
    }

    public final GoogleAccountCredential setSelectedAccountName(String str) {
        Account accountByName = this.accountManager.getAccountByName(str);
        this.selectedAccount = accountByName;
        if (accountByName == null) {
            str = null;
        }
        this.accountName = str;
        return this;
    }

    public final GoogleAccountCredential setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }
}
