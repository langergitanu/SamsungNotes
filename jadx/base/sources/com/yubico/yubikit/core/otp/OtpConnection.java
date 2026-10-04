package com.yubico.yubikit.core.otp;

import com.yubico.yubikit.core.YubiKeyConnection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface OtpConnection extends YubiKeyConnection {
    public static final int FEATURE_REPORT_SIZE = 8;

    void receive(byte[] bArr);

    void send(byte[] bArr);
}
