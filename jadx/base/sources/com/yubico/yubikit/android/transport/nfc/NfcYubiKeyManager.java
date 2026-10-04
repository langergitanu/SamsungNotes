package com.yubico.yubikit.android.transport.nfc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import androidx.transition.C3970a;
import com.yubico.yubikit.core.util.Callback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NfcYubiKeyManager {
    public static final String NFC_SETTINGS_ACTION = "android.settings.NFC_SETTINGS";
    private final NfcAdapter adapter;
    private final Context context;
    private final NfcDispatcher dispatcher;

    @Nullable
    private ExecutorService executorService = null;

    public NfcYubiKeyManager(Context context, @Nullable NfcDispatcher nfcDispatcher) throws NfcNotAvailable {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        this.adapter = defaultAdapter;
        if (defaultAdapter == null) {
            throw new NfcNotAvailable("NFC unavailable on this device", false);
        }
        this.dispatcher = nfcDispatcher == null ? new NfcReaderDispatcher(defaultAdapter) : nfcDispatcher;
        this.context = context;
    }

    private boolean checkAvailability(boolean z) throws NfcNotAvailable {
        if (this.adapter.isEnabled()) {
            return true;
        }
        if (!z) {
            throw new NfcNotAvailable("Please activate NFC_TRANSPORT", true);
        }
        this.context.startActivity(new Intent(NFC_SETTINGS_ACTION));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enable$0(Callback callback, NfcConfiguration nfcConfiguration, ExecutorService executorService, Tag tag) {
        callback.invoke(new NfcYubiKeyDevice(tag, nfcConfiguration.getTimeout(), executorService));
    }

    public void disable(Activity activity) {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdown();
            this.executorService = null;
        }
        this.dispatcher.disable(activity);
    }

    public void enable(Activity activity, NfcConfiguration nfcConfiguration, Callback<? super NfcYubiKeyDevice> callback) {
        if (checkAvailability(nfcConfiguration.isHandleUnavailableNfc())) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            this.dispatcher.enable(activity, nfcConfiguration, new C3970a(callback, 7, nfcConfiguration, executorServiceNewSingleThreadExecutor));
            this.executorService = executorServiceNewSingleThreadExecutor;
        }
    }
}
