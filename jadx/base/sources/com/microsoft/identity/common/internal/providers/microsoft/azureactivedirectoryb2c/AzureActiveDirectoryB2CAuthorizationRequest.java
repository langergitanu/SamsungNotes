package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryB2CAuthorizationRequest extends MicrosoftAuthorizationRequest<AzureActiveDirectoryB2CAuthorizationRequest> {
    private static final long serialVersionUID = -3380061616328869269L;
    private String mPrompt;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends MicrosoftAuthorizationRequest.Builder<Builder> {
        private String mPrompt;

        @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest.Builder, com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public Builder self() {
            return this;
        }

        @SuppressFBWarnings({"URF_UNREAD_FIELD"})
        public Builder setPrompt(String str) {
            this.mPrompt = str;
            return this;
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public AzureActiveDirectoryB2CAuthorizationRequest build() {
            return new AzureActiveDirectoryB2CAuthorizationRequest(this);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public String getAuthorizationEndpoint() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    private AzureActiveDirectoryB2CAuthorizationRequest(Builder builder) {
        super(builder);
        this.mPrompt = builder.mPrompt;
    }
}
