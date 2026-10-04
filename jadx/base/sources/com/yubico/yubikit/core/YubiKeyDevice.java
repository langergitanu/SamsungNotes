package com.yubico.yubikit.core;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface YubiKeyDevice {
    Transport getTransport();

    <T extends YubiKeyConnection> T openConnection(Class<T> cls);

    <T extends YubiKeyConnection> void requestConnection(Class<T> cls, Callback<Result<T, IOException>> callback);

    boolean supportsConnection(Class<? extends YubiKeyConnection> cls);
}
