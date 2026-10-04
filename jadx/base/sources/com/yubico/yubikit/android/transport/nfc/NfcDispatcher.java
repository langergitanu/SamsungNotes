package com.yubico.yubikit.android.transport.nfc;

import android.app.Activity;
import android.nfc.Tag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NfcDispatcher {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTagHandler {
        void onTag(Tag tag);
    }

    void disable(Activity activity);

    void enable(Activity activity, NfcConfiguration nfcConfiguration, OnTagHandler onTagHandler);
}
