package com.samsung.android.mcf.continuity.impl;

import android.util.ArrayMap;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import p012C1.RunnableC0050f;
import p014C3.RunnableC0054a;
import p066P2.RunnableC0201c;
import p070Q1.RunnableC0218a;
import p074R1.C0230b;
import p122b2.C4183f;
import p122b2.RunnableC4180c;
import p122b2.RunnableC4181d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityConnection {
    private static final String TAG = "ContinuityConnection";

    @NonNull
    private final String mBtMac;

    @Nullable
    private volatile Socket mControlSocket;

    @Nullable
    private NetworkUtil.SocketCallback mControlSocketCallback;

    @Nullable
    private final String mIp;
    private final int mPort;

    @NonNull
    private final Object mConnectionCallbackLock = new Object();

    @NonNull
    private final Object mMessageIdLock = new Object();
    private byte mMessageId = 1;

    @NonNull
    private final Object mSendFileSequenceLock = new Object();
    private int mSendFileSequence = 1;

    @NonNull
    private final ArrayMap<Byte, ContinuitySessionMessageManager.SendMessageCallback> mSendMessageCallbackMap = new ArrayMap<>();

    @NonNull
    private final ConcurrentHashMap<Integer, ContinuitySendFile> mContinuitySendFileMap = new ConcurrentHashMap<>(1);

    @NonNull
    private final CopyOnWriteArrayList<ContinuityReceiveFile> mContinuityReceiveFileList = new CopyOnWriteArrayList<>();

    private ContinuityConnection(@NonNull String str, @Nullable String str2, int i, @NonNull NetworkUtil.SocketCallback socketCallback) {
        this.mBtMac = str;
        this.mIp = str2;
        this.mPort = i;
        this.mControlSocketCallback = socketCallback;
    }

    @MainThread
    private void closeReceiveFile(int i, int i2, double d, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        DLog.m5607d(TAG, "closeReceiveFile", i + SQLKeyword.COMMA + i2 + SQLKeyword.COMMA + DLog.secureMac(this.mBtMac));
        ContinuityReceiveFile continuityReceiveFileRemove = this.mContinuityReceiveFileList.remove(i);
        if (continuityReceiveFileRemove != null) {
            continuityReceiveFileRemove.close();
        }
        fileStatusListener.onFileStatusUpdated(i2, d);
    }

    @MainThread
    private void closeSendFile(int i, int i2, double d, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        DLog.m5607d(TAG, "closeSendFile", i + SQLKeyword.COMMA + i2 + SQLKeyword.COMMA + DLog.secureMac(this.mBtMac));
        ContinuitySendFile continuitySendFileRemove = this.mContinuitySendFileMap.remove(Integer.valueOf(i));
        if (continuitySendFileRemove != null) {
            continuitySendFileRemove.close();
        }
        fileStatusListener.onFileStatusUpdated(i2, d);
    }

    @NonNull
    private NetworkUtil.SocketCallback createControlSocketCallback() {
        return new NetworkUtil.SocketCallback() { // from class: com.samsung.android.mcf.continuity.impl.ContinuityConnection.1
            @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
            public void onDisconnected() {
                ContinuityConnection.this.onControlSocketDisconnected();
            }

            @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
            public void onPacketReceived(@NonNull ProtoContinuityPacket.ContinuityPacket continuityPacket) {
                synchronized (ContinuityConnection.this.mConnectionCallbackLock) {
                    try {
                        if (ContinuityConnection.this.mControlSocketCallback != null) {
                            ContinuityConnection.this.mControlSocketCallback.onPacketReceived(continuityPacket);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }

    @NonNull
    private ContinuitySessionFileManager.FileInfoListener createFileInfoListenerWrapper(@NonNull final ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        return new ContinuitySessionFileManager.FileInfoListener() { // from class: com.samsung.android.mcf.continuity.impl.ContinuityConnection.4
            @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager.FileInfoListener
            public void onFileInfoReceived(@NonNull ContinuityFileId continuityFileId, @NonNull byte[] bArr) {
                ContinuityConnection.this.handleFileInfoReceived(continuityFileId, bArr, fileInfoListener);
            }
        };
    }

    @NonNull
    public static ContinuityConnection createInstance(@NonNull String str, @Nullable String str2, int i, @NonNull NetworkUtil.SocketCallback socketCallback) {
        return new ContinuityConnection(str, str2, i, socketCallback);
    }

    @NonNull
    private ContinuitySessionFileManager.FileStatusListener createReceiveFileStatusListenerWrapper(final int i, @NonNull final ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        return new ContinuitySessionFileManager.FileStatusListener() { // from class: com.samsung.android.mcf.continuity.impl.ContinuityConnection.3
            @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager.FileStatusListener
            public void onFileStatusUpdated(int i2, double d) {
                ContinuityConnection.this.handleReceiveFileStatusUpdated(i, i2, d, fileStatusListener);
            }
        };
    }

    @NonNull
    private ContinuitySessionFileManager.FileStatusListener createSendFileStatusListenerWrapper(final int i, @NonNull final ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        return new ContinuitySessionFileManager.FileStatusListener() { // from class: com.samsung.android.mcf.continuity.impl.ContinuityConnection.2
            @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager.FileStatusListener
            public void onFileStatusUpdated(int i2, double d) {
                ContinuityConnection.this.handleSendFileStatusUpdated(i, i2, d, fileStatusListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFileInfoReceived(@NonNull ContinuityFileId continuityFileId, @NonNull byte[] bArr, @NonNull ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        DLog.m5608d(TAG, "handleFileInfoReceived", new C4183f(this, continuityFileId, 0));
        fileInfoListener.onFileInfoReceived(continuityFileId, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void handleReceiveFileStatusUpdated(final int i, final int i2, final double d, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        DLog.m5608d(TAG, "handleReceiveFileStatusUpdated", (Supplier<String>) new Supplier() { // from class: b2.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f1777a.lambda$handleReceiveFileStatusUpdated$9(i, i2, d);
            }
        });
        if (i2 == 51) {
            fileStatusListener.onFileStatusUpdated(i2, d);
            return;
        }
        switch (i2) {
            case 60:
            case 61:
            case 62:
                closeReceiveFile(i, i2, d, fileStatusListener);
                break;
            default:
                DLog.m5611w(TAG, "handleReceiveFileStatusUpdated", "invalid status : " + i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void handleSendFileStatusUpdated(final int i, final int i2, final double d, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        DLog.m5608d(TAG, "handleSendFileStatusUpdated", (Supplier<String>) new Supplier() { // from class: b2.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return ContinuityConnection.lambda$handleSendFileStatusUpdated$7(i, i2, d);
            }
        });
        switch (i2) {
            case 40:
            case 43:
                fileStatusListener.onFileStatusUpdated(i2, d);
                return;
            case 41:
                sendFileData(i, fileStatusListener);
                return;
            case 42:
                break;
            default:
                switch (i2) {
                    case 60:
                    case 61:
                    case 62:
                        break;
                    default:
                        DLog.m5611w(TAG, "handleSendFileStatusUpdated", "invalid status : " + i2);
                        break;
                }
                return;
        }
        closeSendFile(i, i2, d, fileStatusListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFileSocket$11(Socket socket, String str, ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        ContinuityReceiveFile continuityReceiveFile = new ContinuityReceiveFile(socket, str, createFileInfoListenerWrapper(fileInfoListener));
        this.mContinuityReceiveFileList.add(continuityReceiveFile);
        continuityReceiveFile.read();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectAndSetControlSocket$0(Consumer consumer, Socket socket) {
        String str = this.mIp;
        if (str == null) {
            DLog.m5611w(TAG, "connectAndSetControlSocket", "null Ip");
            consumer.accept(Boolean.FALSE);
        } else if (NetworkUtil.connectSocket(socket, NetworkUtil.createSocketAddress(str, this.mPort))) {
            setControlSocket(socket, consumer);
        } else {
            DLog.m5611w(TAG, "connectAndSetControlSocket", "connect fail");
            consumer.accept(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$handleFileInfoReceived$10(ContinuityFileId continuityFileId) {
        return continuityFileId.getFileSequence() + SQLKeyword.COMMA + DLog.secureMac(this.mBtMac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$handleReceiveFileStatusUpdated$9(int i, int i2, double d) {
        return i + SQLKeyword.COMMA + i2 + SQLKeyword.COMMA + d + SQLKeyword.COMMA + DLog.secureMac(this.mBtMac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$handleSendFileStatusUpdated$7(int i, int i2, double d) {
        return i + SQLKeyword.COMMA + i2 + SQLKeyword.COMMA + d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendFile$8(int i, ContinuitySessionFileManager.FileStatusListener fileStatusListener, byte[] bArr, File file) {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, SQLKeyword.COMMA);
        sbM1322o.append(DLog.secureMac(this.mBtMac));
        DLog.m5607d(TAG, "sendFile", sbM1322o.toString());
        Socket socketCreateSocket = NetworkUtil.createSocket();
        if (!NetworkUtil.connectSocket(socketCreateSocket, NetworkUtil.createSocketAddress(this.mIp, this.mPort))) {
            DLog.m5611w(TAG, "sendFile", "connect fail");
            fileStatusListener.onFileStatusUpdated(62, 0.0d);
            return;
        }
        ContinuitySendFile continuitySendFile = new ContinuitySendFile(socketCreateSocket, this.mBtMac, i, bArr, file, createSendFileStatusListenerWrapper(i, fileStatusListener));
        ContinuitySendFile continuitySendFilePut = this.mContinuitySendFileMap.put(Integer.valueOf(i), continuitySendFile);
        if (continuitySendFilePut != null) {
            DLog.m5611w(TAG, "sendFile", "close prevContinuityFileSocket");
            continuitySendFilePut.close();
        }
        continuitySendFile.read();
        continuitySendFile.sendFileInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$sendMessage$4(ProtoContinuityPacket.ContinuityPacket continuityPacket) {
        return "packetId = " + continuityPacket.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$6(ProtoContinuityPacket.ContinuityPacket continuityPacket, ContinuitySessionMessageManager.SendMessageCallback sendMessageCallback) {
        int i;
        DLog.m5608d(TAG, "sendMessage", new C0230b(continuityPacket, 1));
        Socket socket = this.mControlSocket;
        if (socket != null) {
            try {
                continuityPacket.writeDelimitedTo(socket.getOutputStream());
                i = 0;
            } catch (IOException e) {
                DLog.m5611w(TAG, "sendMessage", "IOException : " + e.getMessage());
                onControlSocketDisconnected();
                i = -1;
            }
        } else {
            i = -1;
        }
        ExecutorUtil.executeOnCallback(new RunnableC0050f(sendMessageCallback, i, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$setControlSocket$1(Socket socket) {
        return "btMac = " + DLog.secureMac(this.mBtMac) + ", socket = " + socket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setControlSocket$2(Socket socket) {
        NetworkUtil.readSocket(socket, createControlSocketCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setControlSocket$3(Socket socket, Consumer consumer) {
        this.mControlSocket = socket;
        consumer.accept(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void onControlSocketDisconnected() {
        synchronized (this.mConnectionCallbackLock) {
            try {
                NetworkUtil.SocketCallback socketCallback = this.mControlSocketCallback;
                if (socketCallback != null) {
                    socketCallback.onDisconnected();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    private void sendFileData(int i, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, SQLKeyword.COMMA);
        sbM1322o.append(DLog.secureMac(this.mBtMac));
        DLog.m5607d(TAG, "sendFileData", sbM1322o.toString());
        ContinuitySendFile continuitySendFile = this.mContinuitySendFileMap.get(Integer.valueOf(i));
        if (continuitySendFile == null) {
            fileStatusListener.onFileStatusUpdated(62, 0.0d);
        } else {
            continuitySendFile.sendFileData();
            fileStatusListener.onFileStatusUpdated(41, 0.0d);
        }
    }

    public void addFileSocket(@NonNull String str, @NonNull Socket socket, @NonNull ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        DLog.m5607d(TAG, "addFileSocket", "btMac : " + DLog.secureMac(str));
        ExecutorUtil.executeOnIO(new RunnableC0218a(this, socket, str, fileInfoListener, 3));
    }

    public void connectAndSetControlSocket(@NonNull Socket socket, @NonNull Consumer<Boolean> consumer) {
        DLog.m5607d(TAG, "connectAndSetControlSocket", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        ExecutorUtil.executeOnIO(new RunnableC4181d(this, consumer, socket));
    }

    @MainThread
    public void destroy() {
        DLog.m5607d(TAG, "destroy", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        synchronized (this.mConnectionCallbackLock) {
            this.mControlSocketCallback = null;
        }
        NetworkUtil.closeSocket(this.mControlSocket);
        Iterator<Map.Entry<Integer, ContinuitySendFile>> it = this.mContinuitySendFileMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().close();
        }
        this.mContinuitySendFileMap.clear();
        Iterator<ContinuityReceiveFile> it2 = this.mContinuityReceiveFileList.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
        this.mContinuityReceiveFileList.clear();
        this.mSendMessageCallbackMap.clear();
    }

    @Nullable
    public String getIp() {
        return this.mIp;
    }

    public byte getMessageId() {
        byte b;
        synchronized (this.mMessageIdLock) {
            b = this.mMessageId;
        }
        return b;
    }

    public void incrementMessageId() {
        synchronized (this.mMessageIdLock) {
            try {
                byte b = (byte) (this.mMessageId + 1);
                this.mMessageId = b;
                if (b == 0) {
                    this.mMessageId = (byte) (b + 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void putSendMessageCallback(byte b, @NonNull ContinuitySessionMessageManager.SendMessageCallback sendMessageCallback) {
        ContinuitySessionMessageManager.SendMessageCallback sendMessageCallbackPut = this.mSendMessageCallbackMap.put(Byte.valueOf(b), sendMessageCallback);
        if (sendMessageCallbackPut != null) {
            sendMessageCallbackPut.onResult(-1);
        }
    }

    @Nullable
    public ContinuitySessionMessageManager.SendMessageCallback removeSendMessageCallback(byte b) {
        return this.mSendMessageCallbackMap.remove(Byte.valueOf(b));
    }

    @AnyThread
    public boolean responseReceiveFile(int i, int i2, @Nullable File file, @Nullable ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        for (ContinuityReceiveFile continuityReceiveFile : this.mContinuityReceiveFileList) {
            if (continuityReceiveFile.getSequence() == i2) {
                return continuityReceiveFile.responseReceiveFile(i, file, fileStatusListener != null ? createReceiveFileStatusListenerWrapper(i2, fileStatusListener) : null);
            }
        }
        return false;
    }

    @Nullable
    @AnyThread
    public ContinuityFileId sendFile(@NonNull byte[] bArr, @NonNull File file, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) throws Throwable {
        int i;
        if (this.mIp == null) {
            DLog.m5611w(TAG, "sendFile", "null IP");
            return null;
        }
        synchronized (this.mSendFileSequenceLock) {
            try {
                i = this.mSendFileSequence;
                this.mSendFileSequence = i + 1;
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        ExecutorUtil.executeOnIO(new RunnableC4180c(this, i, fileStatusListener, bArr, file, 0));
        return new ContinuityFileIdImpl(ContinuityFileId.THIS_DEVICE, this.mBtMac, i);
    }

    public void sendMessage(@NonNull ProtoContinuityPacket.ContinuityPacket continuityPacket, @NonNull ContinuitySessionMessageManager.SendMessageCallback sendMessageCallback) {
        ExecutorUtil.executeOnIO(new RunnableC0201c(this, 13, continuityPacket, sendMessageCallback));
    }

    @AnyThread
    public void setControlSocket(@NonNull Socket socket, @NonNull Consumer<Boolean> consumer) {
        DLog.m5608d(TAG, "setControlSocket", new C4183f(this, socket, 1));
        ExecutorUtil.executeOnIO(new RunnableC0054a(this, socket, 22));
        Socket socket2 = this.mControlSocket;
        if (socket2 != null) {
            DLog.m5611w(TAG, "setControlSocket", "close prevControlSocket");
            NetworkUtil.closeSocket(socket2);
        }
        ExecutorUtil.executeOnMain(new RunnableC4181d(this, socket, consumer));
    }
}
