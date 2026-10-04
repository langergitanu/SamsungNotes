package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OAuth2StrategyParameters {

    @Nullable
    private final transient AbstractAuthenticationScheme mAuthenticationScheme;

    @Nullable
    public final List<String> mChallengeTypes;

    @Nullable
    private final transient IPlatformComponents mPlatformComponents;
    private transient boolean mUsingOpenIdConfiguration;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OAuth2StrategyParametersBuilder {
        private AbstractAuthenticationScheme authenticationScheme;
        private List<String> challengeTypes;
        private IPlatformComponents platformComponents;
        private boolean usingOpenIdConfiguration;

        public OAuth2StrategyParametersBuilder authenticationScheme(@Nullable AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return this;
        }

        public OAuth2StrategyParameters build() {
            return new OAuth2StrategyParameters(this.platformComponents, this.authenticationScheme, this.challengeTypes, this.usingOpenIdConfiguration);
        }

        public OAuth2StrategyParametersBuilder challengeTypes(@Nullable List<String> list) {
            this.challengeTypes = list;
            return this;
        }

        public OAuth2StrategyParametersBuilder platformComponents(@Nullable IPlatformComponents iPlatformComponents) {
            this.platformComponents = iPlatformComponents;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("OAuth2StrategyParameters.OAuth2StrategyParametersBuilder(platformComponents=");
            sb.append(this.platformComponents);
            sb.append(", authenticationScheme=");
            sb.append(this.authenticationScheme);
            sb.append(", challengeTypes=");
            sb.append(this.challengeTypes);
            sb.append(", usingOpenIdConfiguration=");
            return AbstractC0000a.m14k(sb, this.usingOpenIdConfiguration, ")");
        }

        public OAuth2StrategyParametersBuilder usingOpenIdConfiguration(boolean z) {
            this.usingOpenIdConfiguration = z;
            return this;
        }
    }

    public OAuth2StrategyParameters(@Nullable IPlatformComponents iPlatformComponents, @Nullable AbstractAuthenticationScheme abstractAuthenticationScheme, @Nullable List<String> list, boolean z) {
        this.mPlatformComponents = iPlatformComponents;
        this.mAuthenticationScheme = abstractAuthenticationScheme;
        this.mChallengeTypes = list;
        this.mUsingOpenIdConfiguration = z;
    }

    public static OAuth2StrategyParametersBuilder builder() {
        return new OAuth2StrategyParametersBuilder();
    }

    @Nullable
    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.mAuthenticationScheme;
    }

    @Nullable
    public List<String> getChallengeTypes() {
        return this.mChallengeTypes;
    }

    @Nullable
    public IPlatformComponents getPlatformComponents() {
        return this.mPlatformComponents;
    }

    public boolean isUsingOpenIdConfiguration() {
        return this.mUsingOpenIdConfiguration;
    }

    public void setUsingOpenIdConfiguration(boolean z) {
        this.mUsingOpenIdConfiguration = z;
    }
}
