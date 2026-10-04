package com.microsoft.identity.client;

import com.microsoft.identity.client.TokenParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DeviceCodeFlowParameters extends TokenParameters {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends TokenParameters.Builder<Builder> {
        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public DeviceCodeFlowParameters build() {
            return new DeviceCodeFlowParameters(this);
        }
    }

    public DeviceCodeFlowParameters(Builder builder) {
        super(builder);
    }
}
