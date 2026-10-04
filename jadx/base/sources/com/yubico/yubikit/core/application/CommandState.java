package com.yubico.yubikit.core.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CommandState {
    public static final byte STATUS_PROCESSING = 1;
    public static final byte STATUS_UPNEEDED = 2;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CommandState.class);
    private boolean cancelled = false;

    public final synchronized void cancel() {
        this.cancelled = true;
    }

    public void onKeepAliveStatus(byte b) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "received keepalive status: {}", Byte.valueOf(b));
    }

    public final synchronized boolean waitForCancel(long j) {
        if (this.cancelled || j <= 0) {
        } else {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                com.yubico.yubikit.core.internal.Logger.debug(logger, "Thread interrupted, cancelling command");
                this.cancelled = true;
                Thread.currentThread().interrupt();
            }
        }
        return this.cancelled;
    }
}
