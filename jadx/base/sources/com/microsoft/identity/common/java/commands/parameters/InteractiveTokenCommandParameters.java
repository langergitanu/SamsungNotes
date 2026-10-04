package com.microsoft.identity.common.java.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.p132ui.AuthorizationAgent;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdConnectPromptParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class InteractiveTokenCommandParameters extends TokenCommandParameters {

    @Expose
    private final AuthorizationAgent authorizationAgent;
    private final boolean brokerBrowserSupportEnabled;
    private final transient List<BrowserDescriptor> browserSafeList;
    private final List<Map.Entry<String, String>> extraQueryStringParameters;

    @Expose
    private final List<String> extraScopesToConsent;

    @Expose
    private final boolean handleNullTaskAffinity;

    @Expose
    private final boolean isWebViewZoomControlsEnabled;

    @Expose
    private final boolean isWebViewZoomEnabled;
    private final PreferredAuthMethod preferredAuthMethod;
    private final transient BrowserDescriptor preferredBrowser;

    @Expose
    private final OpenIdConnectPromptParameter prompt;
    private final transient HashMap<String, String> requestHeaders;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class InteractiveTokenCommandParametersBuilder<C extends InteractiveTokenCommandParameters, B extends InteractiveTokenCommandParametersBuilder<C, B>> extends TokenCommandParameters.TokenCommandParametersBuilder<C, B> {
        private AuthorizationAgent authorizationAgent;
        private boolean brokerBrowserSupportEnabled;
        private List<BrowserDescriptor> browserSafeList;
        private List<Map.Entry<String, String>> extraQueryStringParameters;
        private List<String> extraScopesToConsent;
        private boolean handleNullTaskAffinity;
        private boolean isWebViewZoomControlsEnabled;
        private boolean isWebViewZoomEnabled;
        private PreferredAuthMethod preferredAuthMethod;
        private BrowserDescriptor preferredBrowser;
        private OpenIdConnectPromptParameter prompt;
        private HashMap<String, String> requestHeaders;

        private static void $fillValuesFromInstanceIntoBuilder(InteractiveTokenCommandParameters interactiveTokenCommandParameters, InteractiveTokenCommandParametersBuilder<?, ?> interactiveTokenCommandParametersBuilder) {
            interactiveTokenCommandParametersBuilder.browserSafeList(interactiveTokenCommandParameters.browserSafeList);
            interactiveTokenCommandParametersBuilder.preferredBrowser(interactiveTokenCommandParameters.preferredBrowser);
            interactiveTokenCommandParametersBuilder.preferredAuthMethod(interactiveTokenCommandParameters.preferredAuthMethod);
            interactiveTokenCommandParametersBuilder.requestHeaders(interactiveTokenCommandParameters.requestHeaders);
            interactiveTokenCommandParametersBuilder.brokerBrowserSupportEnabled(interactiveTokenCommandParameters.brokerBrowserSupportEnabled);
            interactiveTokenCommandParametersBuilder.prompt(interactiveTokenCommandParameters.prompt);
            interactiveTokenCommandParametersBuilder.authorizationAgent(interactiveTokenCommandParameters.authorizationAgent);
            interactiveTokenCommandParametersBuilder.isWebViewZoomEnabled(interactiveTokenCommandParameters.isWebViewZoomEnabled);
            interactiveTokenCommandParametersBuilder.isWebViewZoomControlsEnabled(interactiveTokenCommandParameters.isWebViewZoomControlsEnabled);
            interactiveTokenCommandParametersBuilder.handleNullTaskAffinity(interactiveTokenCommandParameters.handleNullTaskAffinity);
            interactiveTokenCommandParametersBuilder.extraQueryStringParameters(interactiveTokenCommandParameters.extraQueryStringParameters);
            interactiveTokenCommandParametersBuilder.extraScopesToConsent(interactiveTokenCommandParameters.extraScopesToConsent);
        }

        public B authorizationAgent(AuthorizationAgent authorizationAgent) {
            this.authorizationAgent = authorizationAgent;
            return (B) self();
        }

        public B brokerBrowserSupportEnabled(boolean z) {
            this.brokerBrowserSupportEnabled = z;
            return (B) self();
        }

        public B browserSafeList(List<BrowserDescriptor> list) {
            this.browserSafeList = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B extraQueryStringParameters(List<Map.Entry<String, String>> list) {
            this.extraQueryStringParameters = list;
            return (B) self();
        }

        public B extraScopesToConsent(List<String> list) {
            this.extraScopesToConsent = list;
            return (B) self();
        }

        public B handleNullTaskAffinity(boolean z) {
            this.handleNullTaskAffinity = z;
            return (B) self();
        }

        public B isWebViewZoomControlsEnabled(boolean z) {
            this.isWebViewZoomControlsEnabled = z;
            return (B) self();
        }

        public B isWebViewZoomEnabled(boolean z) {
            this.isWebViewZoomEnabled = z;
            return (B) self();
        }

        public B preferredAuthMethod(PreferredAuthMethod preferredAuthMethod) {
            this.preferredAuthMethod = preferredAuthMethod;
            return (B) self();
        }

        public B preferredBrowser(BrowserDescriptor browserDescriptor) {
            this.preferredBrowser = browserDescriptor;
            return (B) self();
        }

        public B prompt(OpenIdConnectPromptParameter openIdConnectPromptParameter) {
            this.prompt = openIdConnectPromptParameter;
            return (B) self();
        }

        public B requestHeaders(HashMap<String, String> map) {
            this.requestHeaders = map;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", browserSafeList=");
            sb.append(this.browserSafeList);
            sb.append(", preferredBrowser=");
            sb.append(this.preferredBrowser);
            sb.append(", preferredAuthMethod=");
            sb.append(this.preferredAuthMethod);
            sb.append(", requestHeaders=");
            sb.append(this.requestHeaders);
            sb.append(", brokerBrowserSupportEnabled=");
            sb.append(this.brokerBrowserSupportEnabled);
            sb.append(", prompt=");
            sb.append(this.prompt);
            sb.append(", authorizationAgent=");
            sb.append(this.authorizationAgent);
            sb.append(", isWebViewZoomEnabled=");
            sb.append(this.isWebViewZoomEnabled);
            sb.append(", isWebViewZoomControlsEnabled=");
            sb.append(this.isWebViewZoomControlsEnabled);
            sb.append(", handleNullTaskAffinity=");
            sb.append(this.handleNullTaskAffinity);
            sb.append(", extraQueryStringParameters=");
            sb.append(this.extraQueryStringParameters);
            sb.append(", extraScopesToConsent=");
            return AbstractC0541b.m777s(sb, this.extraScopesToConsent, ")");
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((InteractiveTokenCommandParameters) c, (InteractiveTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InteractiveTokenCommandParametersBuilderImpl extends InteractiveTokenCommandParametersBuilder<InteractiveTokenCommandParameters, InteractiveTokenCommandParametersBuilderImpl> {
        private InteractiveTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public InteractiveTokenCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public InteractiveTokenCommandParameters build() {
            return new InteractiveTokenCommandParameters(this);
        }
    }

    public InteractiveTokenCommandParameters(InteractiveTokenCommandParametersBuilder<?, ?> interactiveTokenCommandParametersBuilder) {
        super(interactiveTokenCommandParametersBuilder);
        this.browserSafeList = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).browserSafeList;
        this.preferredBrowser = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).preferredBrowser;
        this.preferredAuthMethod = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).preferredAuthMethod;
        this.requestHeaders = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).requestHeaders;
        this.brokerBrowserSupportEnabled = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).brokerBrowserSupportEnabled;
        this.prompt = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).prompt;
        this.authorizationAgent = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).authorizationAgent;
        this.isWebViewZoomEnabled = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).isWebViewZoomEnabled;
        this.isWebViewZoomControlsEnabled = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).isWebViewZoomControlsEnabled;
        this.handleNullTaskAffinity = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).handleNullTaskAffinity;
        this.extraQueryStringParameters = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).extraQueryStringParameters;
        this.extraScopesToConsent = ((InteractiveTokenCommandParametersBuilder) interactiveTokenCommandParametersBuilder).extraScopesToConsent;
    }

    public static InteractiveTokenCommandParametersBuilder<?, ?> builder() {
        return new InteractiveTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof InteractiveTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InteractiveTokenCommandParameters)) {
            return false;
        }
        InteractiveTokenCommandParameters interactiveTokenCommandParameters = (InteractiveTokenCommandParameters) obj;
        if (!interactiveTokenCommandParameters.canEqual(this) || !super.equals(obj) || isBrokerBrowserSupportEnabled() != interactiveTokenCommandParameters.isBrokerBrowserSupportEnabled() || isWebViewZoomEnabled() != interactiveTokenCommandParameters.isWebViewZoomEnabled() || isWebViewZoomControlsEnabled() != interactiveTokenCommandParameters.isWebViewZoomControlsEnabled() || getHandleNullTaskAffinity() != interactiveTokenCommandParameters.getHandleNullTaskAffinity()) {
            return false;
        }
        PreferredAuthMethod preferredAuthMethod = getPreferredAuthMethod();
        PreferredAuthMethod preferredAuthMethod2 = interactiveTokenCommandParameters.getPreferredAuthMethod();
        if (preferredAuthMethod != null ? !preferredAuthMethod.equals(preferredAuthMethod2) : preferredAuthMethod2 != null) {
            return false;
        }
        OpenIdConnectPromptParameter prompt = getPrompt();
        OpenIdConnectPromptParameter prompt2 = interactiveTokenCommandParameters.getPrompt();
        if (prompt != null ? !prompt.equals(prompt2) : prompt2 != null) {
            return false;
        }
        AuthorizationAgent authorizationAgent = getAuthorizationAgent();
        AuthorizationAgent authorizationAgent2 = interactiveTokenCommandParameters.getAuthorizationAgent();
        if (authorizationAgent != null ? !authorizationAgent.equals(authorizationAgent2) : authorizationAgent2 != null) {
            return false;
        }
        List<Map.Entry<String, String>> extraQueryStringParameters = getExtraQueryStringParameters();
        List<Map.Entry<String, String>> extraQueryStringParameters2 = interactiveTokenCommandParameters.getExtraQueryStringParameters();
        if (extraQueryStringParameters != null ? !extraQueryStringParameters.equals(extraQueryStringParameters2) : extraQueryStringParameters2 != null) {
            return false;
        }
        List<String> extraScopesToConsent = getExtraScopesToConsent();
        List<String> extraScopesToConsent2 = interactiveTokenCommandParameters.getExtraScopesToConsent();
        return extraScopesToConsent != null ? extraScopesToConsent.equals(extraScopesToConsent2) : extraScopesToConsent2 == null;
    }

    public AuthorizationAgent getAuthorizationAgent() {
        return this.authorizationAgent;
    }

    public List<BrowserDescriptor> getBrowserSafeList() {
        if (this.browserSafeList == null) {
            return null;
        }
        return new ArrayList(this.browserSafeList);
    }

    public List<Map.Entry<String, String>> getExtraQueryStringParameters() {
        if (this.extraQueryStringParameters == null) {
            return null;
        }
        return new ArrayList(this.extraQueryStringParameters);
    }

    public List<String> getExtraScopesToConsent() {
        if (this.extraScopesToConsent == null) {
            return null;
        }
        return new ArrayList(this.extraScopesToConsent);
    }

    public boolean getHandleNullTaskAffinity() {
        return this.handleNullTaskAffinity;
    }

    public PreferredAuthMethod getPreferredAuthMethod() {
        return this.preferredAuthMethod;
    }

    public BrowserDescriptor getPreferredBrowser() {
        return this.preferredBrowser;
    }

    public OpenIdConnectPromptParameter getPrompt() {
        return this.prompt;
    }

    public HashMap<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = ((((((super.hashCode() * 59) + (isBrokerBrowserSupportEnabled() ? 79 : 97)) * 59) + (isWebViewZoomEnabled() ? 79 : 97)) * 59) + (isWebViewZoomControlsEnabled() ? 79 : 97)) * 59;
        int i = getHandleNullTaskAffinity() ? 79 : 97;
        PreferredAuthMethod preferredAuthMethod = getPreferredAuthMethod();
        int iHashCode2 = ((iHashCode + i) * 59) + (preferredAuthMethod == null ? 43 : preferredAuthMethod.hashCode());
        OpenIdConnectPromptParameter prompt = getPrompt();
        int iHashCode3 = (iHashCode2 * 59) + (prompt == null ? 43 : prompt.hashCode());
        AuthorizationAgent authorizationAgent = getAuthorizationAgent();
        int iHashCode4 = (iHashCode3 * 59) + (authorizationAgent == null ? 43 : authorizationAgent.hashCode());
        List<Map.Entry<String, String>> extraQueryStringParameters = getExtraQueryStringParameters();
        int iHashCode5 = (iHashCode4 * 59) + (extraQueryStringParameters == null ? 43 : extraQueryStringParameters.hashCode());
        List<String> extraScopesToConsent = getExtraScopesToConsent();
        return (iHashCode5 * 59) + (extraScopesToConsent != null ? extraScopesToConsent.hashCode() : 43);
    }

    public boolean isBrokerBrowserSupportEnabled() {
        return this.brokerBrowserSupportEnabled;
    }

    public boolean isWebViewZoomControlsEnabled() {
        return this.isWebViewZoomControlsEnabled;
    }

    public boolean isWebViewZoomEnabled() {
        return this.isWebViewZoomEnabled;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public InteractiveTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new InteractiveTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
