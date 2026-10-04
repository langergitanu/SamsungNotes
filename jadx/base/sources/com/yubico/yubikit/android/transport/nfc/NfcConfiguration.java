package com.yubico.yubikit.android.transport.nfc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NfcConfiguration {
    private boolean disableNfcDiscoverySound = false;
    private boolean skipNdefCheck = false;
    private boolean handleUnavailableNfc = false;
    private int timeout = 1000;

    public NfcConfiguration disableNfcDiscoverySound(boolean z) {
        this.disableNfcDiscoverySound = z;
        return this;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public NfcConfiguration handleUnavailableNfc(boolean z) {
        this.handleUnavailableNfc = z;
        return this;
    }

    public boolean isDisableNfcDiscoverySound() {
        return this.disableNfcDiscoverySound;
    }

    public boolean isHandleUnavailableNfc() {
        return this.handleUnavailableNfc;
    }

    public boolean isSkipNdefCheck() {
        return this.skipNdefCheck;
    }

    public NfcConfiguration skipNdefCheck(boolean z) {
        this.skipNdefCheck = z;
        return this;
    }

    public NfcConfiguration timeout(int i) {
        this.timeout = i;
        return this;
    }
}
