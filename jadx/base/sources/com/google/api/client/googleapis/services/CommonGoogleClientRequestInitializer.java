package com.google.api.client.googleapis.services;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CommonGoogleClientRequestInitializer implements GoogleClientRequestInitializer {
    private final String key;
    private final String userIp;

    public CommonGoogleClientRequestInitializer() {
        this(null);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUserIp() {
        return this.userIp;
    }

    @Override // com.google.api.client.googleapis.services.GoogleClientRequestInitializer
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        String str = this.key;
        if (str != null) {
            abstractGoogleClientRequest.put("key", (Object) str);
        }
        String str2 = this.userIp;
        if (str2 != null) {
            abstractGoogleClientRequest.put("userIp", (Object) str2);
        }
    }

    public CommonGoogleClientRequestInitializer(String str) {
        this(str, null);
    }

    public CommonGoogleClientRequestInitializer(String str, String str2) {
        this.key = str;
        this.userIp = str2;
    }
}
