package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.AcquireTokenParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class IntuneAcquireTokenParameters extends AcquireTokenParameters {
    private boolean mBrokerBrowserSupportEnabled;

    public boolean isBrokerBrowserSupportEnabled() {
        return this.mBrokerBrowserSupportEnabled;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends AcquireTokenParameters.Builder {
        private boolean mBrokerBrowserSupportEnabled;

        public Builder brokerBrowserSupportEnabled(boolean z) {
            this.mBrokerBrowserSupportEnabled = z;
            return this;
        }

        @Override // com.microsoft.identity.client.AcquireTokenParameters.Builder, com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        @Override // com.microsoft.identity.client.AcquireTokenParameters.Builder, com.microsoft.identity.client.TokenParameters.Builder
        public IntuneAcquireTokenParameters build() {
            return new IntuneAcquireTokenParameters(this);
        }
    }

    private IntuneAcquireTokenParameters(Builder builder) {
        super(builder);
        this.mBrokerBrowserSupportEnabled = builder.mBrokerBrowserSupportEnabled;
    }
}
