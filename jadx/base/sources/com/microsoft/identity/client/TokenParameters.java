package com.microsoft.identity.client;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.dto.AccountRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TokenParameters {
    private IAccount mAccount;
    private AccountRecord mAccountRecord;
    private AuthenticationScheme mAuthenticationScheme;
    private String mAuthority;
    private ClaimsRequest mClaimsRequest;
    private String mCorrelationId;
    private List<String> mScopes;

    public TokenParameters(@NonNull Builder builder) {
        this.mAccount = builder.mAccount;
        this.mAuthority = builder.mAuthority;
        this.mClaimsRequest = builder.mClaimsRequest;
        this.mScopes = builder.mScopes;
        this.mAuthenticationScheme = builder.mAuthenticationScheme;
        this.mCorrelationId = builder.mCorrelationId;
    }

    public IAccount getAccount() {
        return this.mAccount;
    }

    public AccountRecord getAccountRecord() {
        return this.mAccountRecord;
    }

    @NonNull
    public AuthenticationScheme getAuthenticationScheme() {
        return this.mAuthenticationScheme;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public ClaimsRequest getClaimsRequest() {
        return this.mClaimsRequest;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public List<String> getScopes() {
        return this.mScopes;
    }

    public void setAccount(IAccount iAccount) {
        this.mAccount = iAccount;
    }

    public void setAccountRecord(AccountRecord accountRecord) {
        this.mAccountRecord = accountRecord;
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public void setScopes(List<String> list) {
        this.mScopes = list;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Builder<B extends Builder<B>> {
        private IAccount mAccount;
        private AuthenticationScheme mAuthenticationScheme;
        private String mAuthority;
        private ClaimsRequest mClaimsRequest;
        private String mCorrelationId;
        private List<String> mScopes;

        public abstract TokenParameters build();

        public B forAccount(IAccount iAccount) {
            this.mAccount = iAccount;
            return (B) self();
        }

        public B fromAuthority(String str) {
            this.mAuthority = str;
            return (B) self();
        }

        public abstract B self();

        public B withAuthenticationScheme(@NonNull AuthenticationScheme authenticationScheme) {
            this.mAuthenticationScheme = authenticationScheme;
            return (B) self();
        }

        public B withClaims(ClaimsRequest claimsRequest) {
            this.mClaimsRequest = claimsRequest;
            return (B) self();
        }

        public B withCorrelationId(@NonNull UUID uuid) {
            this.mCorrelationId = uuid.toString();
            return (B) self();
        }

        public B withResource(String str) {
            if (this.mScopes != null) {
                throw new IllegalArgumentException("Scopes is already set. Scopes and resources cannot be combined in a single request.");
            }
            if (StringUtil.isEmpty(str)) {
                throw new IllegalArgumentException("Empty resource string.");
            }
            this.mScopes = new ArrayList<String>(str) { // from class: com.microsoft.identity.client.TokenParameters.Builder.1
                final /* synthetic */ String val$resource;

                {
                    this.val$resource = str;
                    add(str.trim() + "/.default");
                }
            };
            return (B) self();
        }

        public B withScopes(List<String> list) {
            if (this.mScopes != null) {
                throw new IllegalArgumentException("Scopes is already set.");
            }
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Empty scopes list.");
            }
            this.mScopes = list;
            return (B) self();
        }

        public B fromAuthority(@NonNull AzureCloudInstance azureCloudInstance, @NonNull AadAuthorityAudience aadAuthorityAudience, @Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                AadAuthorityAudience aadAuthorityAudience2 = AadAuthorityAudience.AzureAdMyOrg;
                if (aadAuthorityAudience == aadAuthorityAudience2) {
                    return (B) fromAuthority(azureCloudInstance, str);
                }
                throw new IllegalArgumentException("Audience must be " + aadAuthorityAudience2 + " when tenant is specified");
            }
            if (aadAuthorityAudience == AadAuthorityAudience.AzureAdMyOrg) {
                if (!TextUtils.isEmpty(str)) {
                    this.mAuthority = azureCloudInstance.getCloudInstanceUri() + "/" + str;
                    return (B) self();
                }
                throw new IllegalArgumentException("Tenant must be specified when the audience is " + aadAuthorityAudience);
            }
            this.mAuthority = azureCloudInstance.getCloudInstanceUri() + "/" + aadAuthorityAudience.getAudienceValue();
            return (B) self();
        }

        public B fromAuthority(@NonNull AzureCloudInstance azureCloudInstance, @NonNull AadAuthorityAudience aadAuthorityAudience) {
            return (B) fromAuthority(azureCloudInstance, aadAuthorityAudience, null);
        }

        public B fromAuthority(@NonNull AzureCloudInstance azureCloudInstance, @NonNull String str) {
            this.mAuthority = azureCloudInstance.getCloudInstanceUri() + "/" + str;
            return (B) self();
        }
    }
}
