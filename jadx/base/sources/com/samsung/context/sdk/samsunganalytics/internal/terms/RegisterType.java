package com.samsung.context.sdk.samsunganalytics.internal.terms;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum RegisterType {
    DELETE_APP_DATA("com.sec.android.diagmonagent.sa.terms.DELETE_APP_DATA"),
    DELETE_SENSITIVE_APP_DATA("com.sec.android.diagmonagent.sa.terms.DELETE_SENSITIVE_APP_DATA"),
    SEND_PREVIOUS_REGISTRATION_INFO("None");

    private final String action;

    RegisterType(String str) {
        this.action = str;
    }

    public String getAction() {
        return this.action;
    }
}
