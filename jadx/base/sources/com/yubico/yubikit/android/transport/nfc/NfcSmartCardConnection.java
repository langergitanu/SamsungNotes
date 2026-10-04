package com.yubico.yubikit.android.transport.nfc;

import android.nfc.tech.IsoDep;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.StringUtils;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NfcSmartCardConnection implements SmartCardConnection {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NfcSmartCardConnection.class);
    private final IsoDep card;

    public NfcSmartCardConnection(IsoDep isoDep) {
        this.card = isoDep;
        com.yubico.yubikit.core.internal.Logger.debug(logger, "nfc connection opened");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.card.close();
        com.yubico.yubikit.core.internal.Logger.debug(logger, "nfc connection closed");
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] getAtr() {
        byte[] historicalBytes = this.card.getHistoricalBytes();
        return historicalBytes != null ? (byte[]) historicalBytes.clone() : new byte[0];
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public Transport getTransport() {
        return Transport.NFC;
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public boolean isExtendedLengthApduSupported() {
        return this.card.isExtendedLengthApduSupported();
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] sendAndReceive(byte[] bArr) throws IOException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.trace(logger2, "sent: {}", StringUtils.bytesToHex(bArr));
        byte[] bArrTransceive = this.card.transceive(bArr);
        com.yubico.yubikit.core.internal.Logger.trace(logger2, "received: {}", StringUtils.bytesToHex(bArrTransceive));
        return bArrTransceive;
    }
}
