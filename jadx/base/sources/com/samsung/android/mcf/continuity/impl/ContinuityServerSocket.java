package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import p014C3.RunnableC0054a;
import p074R1.C0230b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityServerSocket {
    private static final String TAG = "ContinuityServerSocket";

    @NonNull
    private final ServerSocket mServerSocket = NetworkUtil.createServerSocket();

    private ContinuityServerSocket() {
    }

    @NonNull
    public static ContinuityServerSocket createInstance() {
        return new ContinuityServerSocket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$accept$0(Socket socket) {
        return "client is connected, socket=" + socket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$accept$1(Consumer consumer) {
        while (true) {
            try {
                Socket socketAccept = this.mServerSocket.accept();
                DLog.m5608d(TAG, "runServer", new C0230b(socketAccept, 2));
                consumer.accept(socketAccept);
            } catch (IOException e) {
                DLog.m5611w(TAG, "runServer", "accept IOException : " + e.getMessage());
                return;
            }
        }
    }

    public boolean accept(@NonNull Consumer<Socket> consumer) {
        return ExecutorUtil.executeOnIO(new RunnableC0054a(this, consumer, 24));
    }

    public void close() {
        try {
            this.mServerSocket.close();
        } catch (IOException e) {
            DLog.m5611w(TAG, "closeServer", "IOException : " + e.getMessage());
        }
    }

    public void enableReuseAddress() {
        this.mServerSocket.setReuseAddress(true);
    }

    public int getLocalPort() {
        return this.mServerSocket.getLocalPort();
    }
}
