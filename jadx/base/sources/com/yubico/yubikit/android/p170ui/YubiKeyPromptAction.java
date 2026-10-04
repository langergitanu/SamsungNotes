package com.yubico.yubikit.android.p170ui;

import android.content.Intent;
import android.os.Bundle;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Pair;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class YubiKeyPromptAction {
    public static final Pair<Integer, Intent> CONTINUE = new Pair<>(101, new Intent());
    public static final int RESULT_CONTINUE = 101;

    public abstract void onYubiKey(YubiKeyDevice yubiKeyDevice, Bundle bundle, CommandState commandState, Callback<Pair<Integer, Intent>> callback);
}
