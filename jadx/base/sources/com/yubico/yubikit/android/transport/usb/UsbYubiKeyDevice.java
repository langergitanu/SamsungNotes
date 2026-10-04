package com.yubico.yubikit.android.transport.usb;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.yubico.yubikit.android.transport.usb.connection.ConnectionManager;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.UsbPid;
import com.yubico.yubikit.core.YubiKeyConnection;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.otp.OtpConnection;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UsbYubiKeyDevice implements YubiKeyDevice, Closeable {
    private final ConnectionManager connectionManager;
    private final UsbDevice usbDevice;
    private final UsbManager usbManager;
    private final UsbPid usbPid;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbYubiKeyDevice.class);
    private static final Callback<Result<OtpConnection, IOException>> CLOSE_OTP = new C11893a();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Nullable
    private CachedOtpConnection otpConnection = null;

    @Nullable
    private Runnable onClosed = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CachedOtpConnection implements Closeable {
        private final LinkedBlockingQueue<Callback<Result<OtpConnection, IOException>>> queue;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(Callback callback) {
            try {
                OtpConnection otpConnection = (OtpConnection) UsbYubiKeyDevice.this.connectionManager.openConnection(OtpConnection.class);
                while (true) {
                    try {
                        try {
                            Callback<Result<OtpConnection, IOException>> callbackTake = this.queue.take();
                            if (callbackTake == UsbYubiKeyDevice.CLOSE_OTP) {
                                com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyDevice.logger, "Closing CachedOtpConnection");
                                break;
                            } else {
                                try {
                                    callbackTake.invoke(Result.success(otpConnection));
                                } catch (Exception e) {
                                    com.yubico.yubikit.core.internal.Logger.error(UsbYubiKeyDevice.logger, "OtpConnection callback threw an exception", e);
                                }
                            }
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } finally {
                    }
                }
                if (otpConnection != null) {
                    otpConnection.close();
                }
            } catch (IOException e3) {
                callback.invoke(Result.failure(e3));
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.queue.offer(UsbYubiKeyDevice.CLOSE_OTP);
        }

        private CachedOtpConnection(final Callback<Result<OtpConnection, IOException>> callback) {
            LinkedBlockingQueue<Callback<Result<OtpConnection, IOException>>> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.queue = linkedBlockingQueue;
            com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyDevice.logger, "Creating new CachedOtpConnection");
            linkedBlockingQueue.offer(callback);
            UsbYubiKeyDevice.this.executorService.submit(new Runnable() { // from class: com.yubico.yubikit.android.transport.usb.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8427a.lambda$new$0(callback);
                }
            });
        }
    }

    public UsbYubiKeyDevice(UsbManager usbManager, UsbDevice usbDevice) {
        if (usbDevice.getVendorId() != 4176) {
            throw new IllegalArgumentException("Invalid vendor id");
        }
        this.usbPid = UsbPid.fromValue(usbDevice.getProductId());
        this.connectionManager = new ConnectionManager(usbManager, usbDevice);
        this.usbDevice = usbDevice;
        this.usbManager = usbManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnection$1(Class cls, Callback callback) {
        try {
            YubiKeyConnection yubiKeyConnectionOpenConnection = this.connectionManager.openConnection(cls);
            try {
                callback.invoke(Result.success(yubiKeyConnectionOpenConnection));
                if (yubiKeyConnectionOpenConnection != null) {
                    yubiKeyConnectionOpenConnection.close();
                }
            } finally {
            }
        } catch (IOException e) {
            callback.invoke(Result.failure(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$2(Result result) {
    }

    private <T extends YubiKeyConnection> void verifyAccess(Class<T> cls) {
        if (!hasPermission()) {
            throw new IllegalStateException("Device access not permitted");
        }
        if (!supportsConnection(cls)) {
            throw new IllegalStateException("Unsupported connection type");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Closing YubiKey device");
        CachedOtpConnection cachedOtpConnection = this.otpConnection;
        if (cachedOtpConnection != null) {
            cachedOtpConnection.close();
            this.otpConnection = null;
        }
        Runnable runnable = this.onClosed;
        if (runnable != null) {
            this.executorService.submit(runnable);
        }
        this.executorService.shutdown();
    }

    public UsbPid getPid() {
        return this.usbPid;
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public Transport getTransport() {
        return Transport.USB;
    }

    public UsbDevice getUsbDevice() {
        return this.usbDevice;
    }

    public boolean hasPermission() {
        return this.usbManager.hasPermission(this.usbDevice);
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> T openConnection(Class<T> cls) {
        verifyAccess(cls);
        return (T) this.connectionManager.openConnection(cls);
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> void requestConnection(Class<T> cls, Callback<Result<T, IOException>> callback) {
        verifyAccess(cls);
        if (!OtpConnection.class.isAssignableFrom(cls)) {
            CachedOtpConnection cachedOtpConnection = this.otpConnection;
            if (cachedOtpConnection != null) {
                cachedOtpConnection.close();
                this.otpConnection = null;
            }
            this.executorService.submit(new RunnableC8928b(this, 26, cls, callback));
            return;
        }
        C11894b c11894b = new C11894b(callback, 0);
        CachedOtpConnection cachedOtpConnection2 = this.otpConnection;
        if (cachedOtpConnection2 == null) {
            this.otpConnection = new CachedOtpConnection(c11894b);
        } else {
            cachedOtpConnection2.queue.offer(c11894b);
        }
    }

    public void setOnClosed(Runnable runnable) {
        if (this.executorService.isTerminated()) {
            runnable.run();
        } else {
            this.onClosed = runnable;
        }
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public boolean supportsConnection(Class<? extends YubiKeyConnection> cls) {
        return this.connectionManager.supportsConnection(cls);
    }

    @Nonnull
    public String toString() {
        return "UsbYubiKeyDevice{usbDevice=" + this.usbDevice + ", usbPid=" + this.usbPid + '}';
    }
}
