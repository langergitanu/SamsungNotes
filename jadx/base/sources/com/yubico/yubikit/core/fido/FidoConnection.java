package com.yubico.yubikit.core.fido;

import com.yubico.yubikit.core.YubiKeyConnection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface FidoConnection extends YubiKeyConnection {
    public static final int PACKET_SIZE = 64;

    void receive(byte[] bArr);

    void send(byte[] bArr);
}
