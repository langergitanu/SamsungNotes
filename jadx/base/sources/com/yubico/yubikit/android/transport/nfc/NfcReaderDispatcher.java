package com.yubico.yubikit.android.transport.nfc;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import com.yubico.yubikit.android.transport.nfc.NfcDispatcher;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NfcReaderDispatcher implements NfcDispatcher {
    private final NfcAdapter adapter;

    public NfcReaderDispatcher(NfcAdapter nfcAdapter) {
        this.adapter = nfcAdapter;
    }

    private void disableReaderMode(Activity activity) {
        this.adapter.disableReaderMode(activity);
    }

    private void enableReaderMode(Activity activity, NfcConfiguration nfcConfiguration, final NfcDispatcher.OnTagHandler onTagHandler) {
        Bundle bundle = new Bundle();
        bundle.putInt("presence", 50);
        int i = nfcConfiguration.isDisableNfcDiscoverySound() ? 259 : 3;
        if (nfcConfiguration.isSkipNdefCheck()) {
            i |= 128;
        }
        NfcAdapter nfcAdapter = this.adapter;
        Objects.requireNonNull(onTagHandler);
        nfcAdapter.enableReaderMode(activity, new NfcAdapter.ReaderCallback() { // from class: com.yubico.yubikit.android.transport.nfc.a
            @Override // android.nfc.NfcAdapter.ReaderCallback
            public final void onTagDiscovered(Tag tag) {
                onTagHandler.onTag(tag);
            }
        }, i, bundle);
    }

    @Override // com.yubico.yubikit.android.transport.nfc.NfcDispatcher
    public void disable(Activity activity) {
        disableReaderMode(activity);
    }

    @Override // com.yubico.yubikit.android.transport.nfc.NfcDispatcher
    public void enable(Activity activity, NfcConfiguration nfcConfiguration, NfcDispatcher.OnTagHandler onTagHandler) {
        disableReaderMode(activity);
        enableReaderMode(activity, nfcConfiguration, onTagHandler);
    }
}
