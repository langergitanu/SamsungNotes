package com.microsoft.identity.common.java.authscheme;

import androidx.collection.AbstractC0622a;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme;
import com.nimbusds.jose.util.Base64URL;
import java.net.URL;
import lombok.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PopAuthenticationSchemeWithClientKeyInternal extends TokenAuthenticationScheme implements IPoPAuthenticationSchemeParams {
    public static final String SCHEME_POP_WITH_CLIENT_KEY = "PoP_With_Client_Key";
    private static final long serialVersionUID = 788393037295696359L;

    @SerializedName("kid")
    private String mKid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PopAuthenticationSchemeWithClientKeyInternalBuilder<C extends PopAuthenticationSchemeWithClientKeyInternal, B extends PopAuthenticationSchemeWithClientKeyInternalBuilder<C, B>> extends TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder<C, B> {
        private String kid;

        private static void $fillValuesFromInstanceIntoBuilder(PopAuthenticationSchemeWithClientKeyInternal popAuthenticationSchemeWithClientKeyInternal, PopAuthenticationSchemeWithClientKeyInternalBuilder<?, ?> popAuthenticationSchemeWithClientKeyInternalBuilder) {
            popAuthenticationSchemeWithClientKeyInternalBuilder.kid(popAuthenticationSchemeWithClientKeyInternal.mKid);
        }

        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract C build();

        public B kid(String str) {
            this.kid = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("PopAuthenticationSchemeWithClientKeyInternal.PopAuthenticationSchemeWithClientKeyInternalBuilder(super=");
            sb.append(super.toString());
            sb.append(", kid=");
            return AbstractC0622a.m1170p(this.kid, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((PopAuthenticationSchemeWithClientKeyInternal) c, (PopAuthenticationSchemeWithClientKeyInternalBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PopAuthenticationSchemeWithClientKeyInternalBuilderImpl extends PopAuthenticationSchemeWithClientKeyInternalBuilder<PopAuthenticationSchemeWithClientKeyInternal, PopAuthenticationSchemeWithClientKeyInternalBuilderImpl> {
        private PopAuthenticationSchemeWithClientKeyInternalBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal.PopAuthenticationSchemeWithClientKeyInternalBuilder, com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public PopAuthenticationSchemeWithClientKeyInternalBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal.PopAuthenticationSchemeWithClientKeyInternalBuilder, com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public PopAuthenticationSchemeWithClientKeyInternal build() {
            return new PopAuthenticationSchemeWithClientKeyInternal(this);
        }
    }

    public PopAuthenticationSchemeWithClientKeyInternal(PopAuthenticationSchemeWithClientKeyInternalBuilder<?, ?> popAuthenticationSchemeWithClientKeyInternalBuilder) {
        super(popAuthenticationSchemeWithClientKeyInternalBuilder);
        this.mKid = ((PopAuthenticationSchemeWithClientKeyInternalBuilder) popAuthenticationSchemeWithClientKeyInternalBuilder).kid;
    }

    public static PopAuthenticationSchemeWithClientKeyInternalBuilder<?, ?> builder() {
        return new PopAuthenticationSchemeWithClientKeyInternalBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public boolean canEqual(Object obj) {
        return obj instanceof PopAuthenticationSchemeWithClientKeyInternal;
    }

    @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PopAuthenticationSchemeWithClientKeyInternal)) {
            return false;
        }
        PopAuthenticationSchemeWithClientKeyInternal popAuthenticationSchemeWithClientKeyInternal = (PopAuthenticationSchemeWithClientKeyInternal) obj;
        if (!popAuthenticationSchemeWithClientKeyInternal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String kid = getKid();
        String kid2 = popAuthenticationSchemeWithClientKeyInternal.getKid();
        return kid != null ? kid.equals(kid2) : kid2 == null;
    }

    @Override // com.microsoft.identity.common.java.authscheme.ITokenAuthenticationSchemeInternal
    public String getAccessTokenForScheme(@NonNull String str) {
        if (str != null) {
            return str;
        }
        throw new NullPointerException("accessToken is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public String getClientClaims() {
        return null;
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public String getHttpMethod() {
        return null;
    }

    public String getKid() {
        return this.mKid;
    }

    @Override // com.microsoft.identity.common.java.authscheme.INonced
    public String getNonce() {
        return null;
    }

    public String getRequestConfirmation() {
        return Base64URL.encode(new JSONObject().put("kid", this.mKid).toString()).toString();
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public URL getUrl() {
        return null;
    }

    @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public int hashCode() {
        int iHashCode = super.hashCode();
        String kid = getKid();
        return (iHashCode * 59) + (kid == null ? 43 : kid.hashCode());
    }

    public PopAuthenticationSchemeWithClientKeyInternalBuilder<?, ?> toBuilder() {
        return new PopAuthenticationSchemeWithClientKeyInternalBuilderImpl().$fillValuesFrom(this);
    }

    public PopAuthenticationSchemeWithClientKeyInternal() {
        super(SCHEME_POP_WITH_CLIENT_KEY);
    }

    public PopAuthenticationSchemeWithClientKeyInternal(@NonNull String str) {
        super(SCHEME_POP_WITH_CLIENT_KEY);
        if (str != null) {
            this.mKid = str;
            return;
        }
        throw new NullPointerException("kid is marked non-null but is null");
    }
}
