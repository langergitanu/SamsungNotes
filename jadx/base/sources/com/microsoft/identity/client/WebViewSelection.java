package com.microsoft.identity.client;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum WebViewSelection {
    EMBEDDED_WEBVIEW(1),
    SYSTEM_BROWSER(2);

    private int mId;

    WebViewSelection(int i) {
        this.mId = i;
    }

    public int getId() {
        return this.mId;
    }
}
