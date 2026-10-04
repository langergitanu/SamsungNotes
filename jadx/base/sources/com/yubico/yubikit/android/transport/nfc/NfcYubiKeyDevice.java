package com.yubico.yubikit.android.transport.nfc;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.Ndef;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.YubiKeyConnection;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.ApplicationNotAvailableException;
import com.yubico.yubikit.core.smartcard.AppId;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.smartcard.SmartCardProtocol;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NfcYubiKeyDevice implements YubiKeyDevice {
    private final ExecutorService executorService;
    private final AtomicBoolean removed = new AtomicBoolean();
    private final Tag tag;
    private final int timeout;

    public NfcYubiKeyDevice(Tag tag, int i, ExecutorService executorService) {
        this.executorService = executorService;
        this.tag = tag;
        this.timeout = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$remove$0(Runnable runnable) {
        try {
            IsoDep isoDep = IsoDep.get(this.tag);
            isoDep.connect();
            while (isoDep.isConnected()) {
                Thread.sleep(250L);
            }
        } catch (IOException | InterruptedException | SecurityException unused) {
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnection$1(Class cls, Callback callback) {
        try {
            YubiKeyConnection yubiKeyConnectionOpenConnection = openConnection(cls);
            try {
                callback.invoke(Result.success(yubiKeyConnectionOpenConnection));
                if (yubiKeyConnectionOpenConnection != null) {
                    yubiKeyConnectionOpenConnection.close();
                }
            } catch (Throwable th) {
                if (yubiKeyConnectionOpenConnection != null) {
                    try {
                        yubiKeyConnectionOpenConnection.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            callback.invoke(Result.failure(e));
        } catch (Exception e2) {
            callback.invoke(Result.failure(new IOException("openConnection(" + cls.getSimpleName() + ") exception: " + e2.getMessage())));
        }
    }

    private NfcSmartCardConnection openIso7816Connection() throws IOException {
        IsoDep isoDep = IsoDep.get(this.tag);
        if (isoDep == null) {
            throw new IOException("the tag does not support ISO-DEP");
        }
        isoDep.setTimeout(this.timeout);
        isoDep.connect();
        return new NfcSmartCardConnection(isoDep);
    }

    public Tag getTag() {
        return this.tag;
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public Transport getTransport() {
        return Transport.NFC;
    }

    public boolean isYubiKey() {
        try {
            SmartCardConnection smartCardConnection = (SmartCardConnection) openConnection(SmartCardConnection.class);
            try {
                SmartCardProtocol smartCardProtocol = new SmartCardProtocol(smartCardConnection);
                try {
                    try {
                        smartCardProtocol.select(AppId.MANAGEMENT);
                        if (smartCardConnection != null) {
                            smartCardConnection.close();
                        }
                        return true;
                    } catch (ApplicationNotAvailableException unused) {
                        smartCardProtocol.select(AppId.OTP);
                        if (smartCardConnection != null) {
                            smartCardConnection.close();
                        }
                        return true;
                    }
                } catch (ApplicationNotAvailableException unused2) {
                    if (smartCardConnection == null) {
                        return false;
                    }
                    smartCardConnection.close();
                    return false;
                }
            } finally {
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> T openConnection(Class<T> cls) {
        if (!cls.isAssignableFrom(NfcSmartCardConnection.class)) {
            throw new IllegalStateException("The connection type is not supported by this session");
        }
        T tCast = cls.cast(openIso7816Connection());
        Objects.requireNonNull(tCast);
        return tCast;
    }

    @SuppressFBWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE"})
    public byte[] readNdef() throws IOException {
        try {
            Ndef ndef = Ndef.get(this.tag);
            if (ndef != null) {
                try {
                    ndef.connect();
                    NdefMessage ndefMessage = ndef.getNdefMessage();
                    if (ndefMessage != null) {
                        byte[] byteArray = ndefMessage.toByteArray();
                        ndef.close();
                        return byteArray;
                    }
                } finally {
                }
            }
            if (ndef != null) {
                ndef.close();
            }
            throw new IOException("NDEF data missing or invalid");
        } catch (FormatException e) {
            throw new IOException(e);
        }
    }

    public void remove(Runnable runnable) {
        this.removed.set(true);
        this.executorService.submit(new RunnableC10960a(this, runnable, 20));
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> void requestConnection(Class<T> cls, Callback<Result<T, IOException>> callback) {
        if (this.removed.get()) {
            callback.invoke(Result.failure(new IOException("Can't requestConnection after calling remove()")));
        } else {
            this.executorService.submit(new RunnableC8928b(this, 25, cls, callback));
        }
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public boolean supportsConnection(Class<? extends YubiKeyConnection> cls) {
        return cls.isAssignableFrom(NfcSmartCardConnection.class);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NfcYubiKeyDevice{tag=");
        sb.append(this.tag);
        sb.append(", timeout=");
        return AbstractC0000a.m13j(sb, this.timeout, '}');
    }
}
