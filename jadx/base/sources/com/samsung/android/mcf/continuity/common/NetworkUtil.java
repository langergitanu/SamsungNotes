package com.samsung.android.mcf.continuity.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NetworkUtil {
    private static final int SOCKET_TIMEOUT = 5000;
    private static final String TAG = "NetworkUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SocketCallback {
        void onDisconnected();

        void onPacketReceived(@NonNull ProtoContinuityPacket.ContinuityPacket continuityPacket);
    }

    public static void closeSocket(@Nullable Socket socket) {
        ExecutorUtil.executeOnIO(new RunnableC0015b(socket, 17));
    }

    @WorkerThread
    public static boolean connectSocket(@NonNull Socket socket, @NonNull SocketAddress socketAddress) {
        try {
            socket.connect(socketAddress, 5000);
            return true;
        } catch (IOException e) {
            DLog.m5611w(TAG, "connectSocket", "fail to connect : " + e.getMessage());
            return false;
        }
    }

    @NonNull
    public static ServerSocket createServerSocket() {
        return new ServerSocket(0, 5);
    }

    @NonNull
    public static Socket createSocket() {
        return new Socket();
    }

    @NonNull
    public static SocketAddress createSocketAddress(@NonNull String str, int i) {
        return new InetSocketAddress(str, i);
    }

    @Nullable
    private static InputStream getInputStream(@NonNull Socket socket) {
        try {
            return socket.getInputStream();
        } catch (IOException e) {
            DLog.m5611w(TAG, "getInputStream", "getInputStream IOException : " + e.getMessage());
            return null;
        }
    }

    @Nullable
    public static OutputStream getOutputStream(@NonNull Socket socket) {
        try {
            return socket.getOutputStream();
        } catch (IOException e) {
            DLog.m5611w(TAG, "getOutputStream", "getOutputStream IOException : " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeSocket$0(Socket socket) {
        if (socket == null) {
            return;
        }
        DLog.m5607d(TAG, "closeSocket", "hashCode = " + socket.hashCode());
        try {
            socket.close();
        } catch (IOException e) {
            DLog.m5611w(TAG, "closeSocket", e.getMessage());
        }
    }

    @WorkerThread
    public static void readSocket(@NonNull Socket socket, @NonNull SocketCallback socketCallback) {
        InputStream inputStream = getInputStream(socket);
        if (inputStream == null) {
            DLog.m5611w(TAG, "readSocket", "null inputStream");
            socketCallback.onDisconnected();
            return;
        }
        while (true) {
            try {
                ProtoContinuityPacket.ContinuityPacket delimitedFrom = ProtoContinuityPacket.ContinuityPacket.parseDelimitedFrom(inputStream);
                if (delimitedFrom == null) {
                    break;
                } else {
                    socketCallback.onPacketReceived(delimitedFrom);
                }
            } catch (IOException e) {
                DLog.m5611w(TAG, "readSocket", "read IOException : " + e.getMessage());
            }
        }
        DLog.m5611w(TAG, "readSocket", "null continuityPacket");
        socketCallback.onDisconnected();
    }
}
