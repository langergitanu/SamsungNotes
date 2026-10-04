package com.yubico.yubikit.android.p170ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.yubico.yubikit.core.YubiKeyConnection;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Pair;
import com.yubico.yubikit.core.util.Result;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class YubiKeyPromptConnectionAction<T extends YubiKeyConnection> extends YubiKeyPromptAction {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) YubiKeyPromptConnectionAction.class);
    final Class<T> connectionType;

    public YubiKeyPromptConnectionAction(Class<T> cls) {
        this.connectionType = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onYubiKey$0(Callback callback, Bundle bundle, CommandState commandState, Result result) {
        try {
            callback.invoke(onYubiKeyConnection((YubiKeyConnection) result.getValue(), bundle, commandState));
        } catch (IOException e) {
            onError(e);
        }
    }

    @WorkerThread
    public void onError(Exception exc) {
        com.yubico.yubikit.core.internal.Logger.error(logger, "Error connecting to YubiKey", exc);
    }

    @Override // com.yubico.yubikit.android.p170ui.YubiKeyPromptAction
    public final void onYubiKey(YubiKeyDevice yubiKeyDevice, final Bundle bundle, final CommandState commandState, final Callback<Pair<Integer, Intent>> callback) {
        if (yubiKeyDevice.supportsConnection(this.connectionType)) {
            yubiKeyDevice.requestConnection(this.connectionType, new Callback() { // from class: com.yubico.yubikit.android.ui.f
                @Override // com.yubico.yubikit.core.util.Callback
                public final void invoke(Object obj) {
                    this.f8441a.lambda$onYubiKey$0(callback, bundle, commandState, (Result) obj);
                }
            });
        } else {
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Connected YubiKey does not support desired connection type");
            callback.invoke(YubiKeyPromptAction.CONTINUE);
        }
    }

    @WorkerThread
    public abstract Pair<Integer, Intent> onYubiKeyConnection(T t, Bundle bundle, CommandState commandState);
}
