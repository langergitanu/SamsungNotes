package com.microsoft.identity.common.java.authscheme;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings(justification = "Lombok inserts redundant null checks into the code", value = {SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
public abstract class TokenAuthenticationScheme extends AbstractAuthenticationScheme implements ITokenAuthenticationSchemeInternal {
    public static final String SCHEME_DELIMITER = " ";
    private static final long serialVersionUID = 8007073391895830795L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TokenAuthenticationSchemeBuilder<C extends TokenAuthenticationScheme, B extends TokenAuthenticationSchemeBuilder<C, B>> extends AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder<C, B> {
        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public String toString() {
            return AbstractC0622a.m1170p(super.toString(), ")", new StringBuilder("TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder(super="));
        }

        @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((TokenAuthenticationScheme) c, (TokenAuthenticationSchemeBuilder<?, ?>) this);
            return (B) self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(TokenAuthenticationScheme tokenAuthenticationScheme, TokenAuthenticationSchemeBuilder<?, ?> tokenAuthenticationSchemeBuilder) {
        }
    }

    public TokenAuthenticationScheme(TokenAuthenticationSchemeBuilder<?, ?> tokenAuthenticationSchemeBuilder) {
        super(tokenAuthenticationSchemeBuilder);
    }

    @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public boolean canEqual(Object obj) {
        return obj instanceof TokenAuthenticationScheme;
    }

    @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof TokenAuthenticationScheme) && ((TokenAuthenticationScheme) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public int hashCode() {
        return super.hashCode();
    }

    public TokenAuthenticationScheme(@NonNull String str) {
        super(str);
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
    }
}
