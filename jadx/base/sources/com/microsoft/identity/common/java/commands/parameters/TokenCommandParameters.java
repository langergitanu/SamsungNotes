package com.microsoft.identity.common.java.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenCommandParameters extends CommandParameters {
    private static final String TAG = "TokenCommandParameters";
    private final IAccountRecord account;

    @Expose
    private final AbstractAuthenticationScheme authenticationScheme;

    @Expose
    private final Authority authority;

    @Expose
    private final String claimsRequestJson;
    private final List<Map.Entry<String, String>> extraOptions;

    @Expose
    private final boolean forceRefresh;
    private final String loginHint;

    @Expose
    private final String mamEnrollmentId;

    @Expose
    private final Set<String> scopes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TokenCommandParametersBuilder<C extends TokenCommandParameters, B extends TokenCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private IAccountRecord account;
        private AbstractAuthenticationScheme authenticationScheme;
        private Authority authority;
        private String claimsRequestJson;
        private List<Map.Entry<String, String>> extraOptions;
        private boolean forceRefresh;
        private String loginHint;
        private String mamEnrollmentId;
        private Set<String> scopes;

        private static void $fillValuesFromInstanceIntoBuilder(TokenCommandParameters tokenCommandParameters, TokenCommandParametersBuilder<?, ?> tokenCommandParametersBuilder) {
            tokenCommandParametersBuilder.account(tokenCommandParameters.account);
            tokenCommandParametersBuilder.scopes(tokenCommandParameters.scopes);
            tokenCommandParametersBuilder.authority(tokenCommandParameters.authority);
            tokenCommandParametersBuilder.claimsRequestJson(tokenCommandParameters.claimsRequestJson);
            tokenCommandParametersBuilder.authenticationScheme(tokenCommandParameters.authenticationScheme);
            tokenCommandParametersBuilder.mamEnrollmentId(tokenCommandParameters.mamEnrollmentId);
            tokenCommandParametersBuilder.forceRefresh(tokenCommandParameters.forceRefresh);
            tokenCommandParametersBuilder.loginHint(tokenCommandParameters.loginHint);
            tokenCommandParametersBuilder.extraOptions(tokenCommandParameters.extraOptions);
        }

        public B account(IAccountRecord iAccountRecord) {
            this.account = iAccountRecord;
            return (B) self();
        }

        public B authenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return (B) self();
        }

        public B authority(Authority authority) {
            this.authority = authority;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B claimsRequestJson(String str) {
            this.claimsRequestJson = str;
            return (B) self();
        }

        public B extraOptions(List<Map.Entry<String, String>> list) {
            this.extraOptions = list;
            return (B) self();
        }

        public B forceRefresh(boolean z) {
            this.forceRefresh = z;
            return (B) self();
        }

        public B loginHint(String str) {
            this.loginHint = str;
            return (B) self();
        }

        public B mamEnrollmentId(String str) {
            this.mamEnrollmentId = str;
            return (B) self();
        }

        public B scopes(Set<String> set) {
            this.scopes = set;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("TokenCommandParameters.TokenCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", account=");
            sb.append(this.account);
            sb.append(", scopes=");
            sb.append(this.scopes);
            sb.append(", authority=");
            sb.append(this.authority);
            sb.append(", claimsRequestJson=");
            sb.append(this.claimsRequestJson);
            sb.append(", authenticationScheme=");
            sb.append(this.authenticationScheme);
            sb.append(", mamEnrollmentId=");
            sb.append(this.mamEnrollmentId);
            sb.append(", forceRefresh=");
            sb.append(this.forceRefresh);
            sb.append(", loginHint=");
            sb.append(this.loginHint);
            sb.append(", extraOptions=");
            return AbstractC0541b.m777s(sb, this.extraOptions, ")");
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((TokenCommandParameters) c, (TokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TokenCommandParametersBuilderImpl extends TokenCommandParametersBuilder<TokenCommandParameters, TokenCommandParametersBuilderImpl> {
        private TokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public TokenCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public TokenCommandParameters build() {
            return new TokenCommandParameters(this);
        }
    }

    public TokenCommandParameters(TokenCommandParametersBuilder<?, ?> tokenCommandParametersBuilder) {
        super(tokenCommandParametersBuilder);
        this.account = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).account;
        this.scopes = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).scopes;
        this.authority = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).authority;
        this.claimsRequestJson = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).claimsRequestJson;
        this.authenticationScheme = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).authenticationScheme;
        this.mamEnrollmentId = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).mamEnrollmentId;
        this.forceRefresh = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).forceRefresh;
        this.loginHint = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).loginHint;
        this.extraOptions = ((TokenCommandParametersBuilder) tokenCommandParametersBuilder).extraOptions;
    }

    public static TokenCommandParametersBuilder<?, ?> builder() {
        return new TokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof TokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenCommandParameters)) {
            return false;
        }
        TokenCommandParameters tokenCommandParameters = (TokenCommandParameters) obj;
        if (!tokenCommandParameters.canEqual(this) || !super.equals(obj) || isForceRefresh() != tokenCommandParameters.isForceRefresh()) {
            return false;
        }
        IAccountRecord account = getAccount();
        IAccountRecord account2 = tokenCommandParameters.getAccount();
        if (account != null ? !account.equals(account2) : account2 != null) {
            return false;
        }
        Set<String> scopes = getScopes();
        Set<String> scopes2 = tokenCommandParameters.getScopes();
        if (scopes != null ? !scopes.equals(scopes2) : scopes2 != null) {
            return false;
        }
        Authority authority = getAuthority();
        Authority authority2 = tokenCommandParameters.getAuthority();
        if (authority != null ? !authority.equals(authority2) : authority2 != null) {
            return false;
        }
        String claimsRequestJson = getClaimsRequestJson();
        String claimsRequestJson2 = tokenCommandParameters.getClaimsRequestJson();
        if (claimsRequestJson != null ? !claimsRequestJson.equals(claimsRequestJson2) : claimsRequestJson2 != null) {
            return false;
        }
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        AbstractAuthenticationScheme authenticationScheme2 = tokenCommandParameters.getAuthenticationScheme();
        if (authenticationScheme != null ? !authenticationScheme.equals(authenticationScheme2) : authenticationScheme2 != null) {
            return false;
        }
        String mamEnrollmentId = getMamEnrollmentId();
        String mamEnrollmentId2 = tokenCommandParameters.getMamEnrollmentId();
        if (mamEnrollmentId != null ? !mamEnrollmentId.equals(mamEnrollmentId2) : mamEnrollmentId2 != null) {
            return false;
        }
        String loginHint = getLoginHint();
        String loginHint2 = tokenCommandParameters.getLoginHint();
        if (loginHint != null ? !loginHint.equals(loginHint2) : loginHint2 != null) {
            return false;
        }
        List<Map.Entry<String, String>> extraOptions = getExtraOptions();
        List<Map.Entry<String, String>> extraOptions2 = tokenCommandParameters.getExtraOptions();
        return extraOptions != null ? extraOptions.equals(extraOptions2) : extraOptions2 == null;
    }

    public IAccountRecord getAccount() {
        return this.account;
    }

    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.authenticationScheme;
    }

    public Authority getAuthority() {
        return this.authority;
    }

    public String getClaimsRequestJson() {
        return this.claimsRequestJson;
    }

    public List<Map.Entry<String, String>> getExtraOptions() {
        return this.extraOptions;
    }

    public String getLoginHint() {
        return this.loginHint;
    }

    public String getMamEnrollmentId() {
        return this.mamEnrollmentId;
    }

    public Set<String> getScopes() {
        if (this.scopes == null) {
            return null;
        }
        return new HashSet(this.scopes);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + (isForceRefresh() ? 79 : 97);
        IAccountRecord account = getAccount();
        int iHashCode2 = (iHashCode * 59) + (account == null ? 43 : account.hashCode());
        Set<String> scopes = getScopes();
        int iHashCode3 = (iHashCode2 * 59) + (scopes == null ? 43 : scopes.hashCode());
        Authority authority = getAuthority();
        int iHashCode4 = (iHashCode3 * 59) + (authority == null ? 43 : authority.hashCode());
        String claimsRequestJson = getClaimsRequestJson();
        int iHashCode5 = (iHashCode4 * 59) + (claimsRequestJson == null ? 43 : claimsRequestJson.hashCode());
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        int iHashCode6 = (iHashCode5 * 59) + (authenticationScheme == null ? 43 : authenticationScheme.hashCode());
        String mamEnrollmentId = getMamEnrollmentId();
        int iHashCode7 = (iHashCode6 * 59) + (mamEnrollmentId == null ? 43 : mamEnrollmentId.hashCode());
        String loginHint = getLoginHint();
        int iHashCode8 = (iHashCode7 * 59) + (loginHint == null ? 43 : loginHint.hashCode());
        List<Map.Entry<String, String>> extraOptions = getExtraOptions();
        return (iHashCode8 * 59) + (extraOptions != null ? extraOptions.hashCode() : 43);
    }

    public boolean isForceRefresh() {
        return this.forceRefresh;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void validate() throws ArgumentException {
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":validate", "Validating operation params...");
        Set<String> set = this.scopes;
        if (set != null) {
            set.removeAll(Arrays.asList("", null));
            if (this.scopes.size() <= 0) {
                if (this instanceof SilentTokenCommandParameters) {
                    throw new ArgumentException("acquireTokenSilent", "scopes", "scope is empty or null");
                }
                if (this instanceof InteractiveTokenCommandParameters) {
                    throw new ArgumentException("acquireToken", "scopes", "scope is empty or null");
                }
                if (this instanceof DeviceCodeFlowCommandParameters) {
                    throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME, "scopes", "scope is empty or null");
                }
            }
        }
        if (this.authenticationScheme == null) {
            if (this instanceof SilentTokenCommandParameters) {
                throw new ArgumentException("acquireTokenSilent", ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME, "authentication scheme is undefined");
            }
            if (this instanceof InteractiveTokenCommandParameters) {
                throw new ArgumentException("acquireToken", ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME, "authentication scheme is undefined");
            }
            if (this instanceof DeviceCodeFlowCommandParameters) {
                throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME, ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME, "authentication scheme is undefined");
            }
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public TokenCommandParametersBuilder<?, ?> toBuilder() {
        return new TokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
