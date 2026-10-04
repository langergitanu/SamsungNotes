package com.samsung.android.sdk.scs.p142ai.visual;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WallpaperResult {
    Bundle retBundle;
    int status;
    Uri uri;

    public Bundle getBundle() {
        return this.retBundle;
    }

    public int getResult() {
        return this.status;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setBundle(Bundle bundle) {
        this.retBundle = bundle;
    }

    public void setResult(int i) {
        this.status = i;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
