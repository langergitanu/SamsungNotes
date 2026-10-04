package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.protobuf.ByteString;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import com.samsung.android.mcf.continuity.common.VersionUtil;
import com.samsung.android.mcf.continuity.impl.ContinuityCallbackManager;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNearbyMyDeviceWrapper;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNetworkPolicyWrapper;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import p012C1.RunnableC0050f;
import p014C3.RunnableC0054a;
import p027F3.RunnableC0101a;
import p066P2.RunnableC0201c;
import p122b2.C4183f;
import p122b2.C4188k;
import p122b2.C4190m;
import p122b2.C4191n;
import p122b2.C4192o;
import p122b2.C4194q;
import p122b2.RunnableC4195r;
import p122b2.RunnableC4198u;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuitySession {
    private static final String TAG = "ContinuitySession";

    @NonNull
    private final ContinuityCallbackManager mContinuityCallbackManager;

    @NonNull
    private final ContinuityCommandManager mContinuityCommandManager;

    @Nullable
    private volatile ContinuityNetworkPolicyWrapper mContinuityNetworkPolicyWrapper;

    @Nullable
    private ContinuityServerSocket mContinuityServerSocket;

    @Nullable
    private volatile ContinuitySessionFileManager.FileInfoListener mFileInfoListener;
    private boolean mIsOpened;

    @Nullable
    private ContinuityMessageManager.MessageListener mMessageListener;

    @Nullable
    private ContinuitySessionManager.PeerConnectionRequestListener mPeerConnectionRequestListener;

    @Nullable
    private ContinuitySessionManager.SessionStatusListener mSessionStatusListener;

    @NonNull
    private final Object mContinuityConnectionMapLock = new Object();

    @NonNull
    private final ProtoContinuityPacket.ContinuityPacket.Builder mContinuityPacketBuilder = ProtoContinuityPacket.ContinuityPacket.newBuilder();

    @NonNull
    private final ConcurrentHashMap<String, ContinuitySessionManager.PeerStatusListener> mPeerStatusListenerMap = new ConcurrentHashMap<>(1);

    @NonNull
    private final CopyOnWriteArraySet<String> mConnectionRequestedSet = new CopyOnWriteArraySet<>();

    @NonNull
    private final ArrayMap<String, ContinuityConnection> mContinuityConnectionMap = new ArrayMap<>();

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySession$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71941 extends ContinuitySessionManager.SessionStatusListener {
        public C71941() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSessionStatusChanged$0(int i) {
            ContinuitySession.this.handleSessionStatusChanged(i);
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.SessionStatusListener
        public void onSessionStatusChanged(int i) {
            ExecutorUtil.executeOnMain(new RunnableC0050f(this, i, 6));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySession$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71952 extends ContinuitySessionManager.PeerStatusListener {
        public C71952() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPeerStatusChanged$0(int i, ContinuityNearbyMyDevice continuityNearbyMyDevice) {
            ContinuitySession.this.handlePeerStatusChanged(i, (ContinuityNearbyMyDeviceWrapper) continuityNearbyMyDevice);
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.PeerStatusListener
        public void onPeerStatusChanged(int i, @NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice) {
            if (continuityNearbyMyDevice instanceof ContinuityNearbyMyDeviceWrapper) {
                ExecutorUtil.executeOnMain(new RunnableC0101a(this, i, (ContinuityNearbyMyDeviceWrapper) continuityNearbyMyDevice, 5));
            } else {
                DLog.m5611w(ContinuitySession.TAG, "onPeerStatusChanged", "fail to cast ContinuityNearbyMyDeviceWrapper");
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySession$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71963 extends ContinuitySessionManager.PeerConnectionRequestListener {
        public C71963() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPeerConnectionRequested$0(ContinuityNearbyMyDevice continuityNearbyMyDevice, ContinuityNetworkPolicy continuityNetworkPolicy) {
            ContinuitySession.this.handlePeerConnectionRequested((ContinuityNearbyMyDeviceWrapper) continuityNearbyMyDevice, (ContinuityNetworkPolicyWrapper) continuityNetworkPolicy);
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.PeerConnectionRequestListener
        public void onPeerConnectionRequested(@NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy) {
            if (!(continuityNearbyMyDevice instanceof ContinuityNearbyMyDeviceWrapper) || !(continuityNetworkPolicy instanceof ContinuityNetworkPolicyWrapper)) {
                DLog.m5611w(ContinuitySession.TAG, "onPeerConnectionRequested", "fail to cast ContinuityNearbyMyDeviceWrapper or ContinuityNetworkPolicyWrapper");
            } else {
                ExecutorUtil.executeOnMain(new RunnableC0201c(this, 14, (ContinuityNearbyMyDeviceWrapper) continuityNearbyMyDevice, (ContinuityNetworkPolicyWrapper) continuityNetworkPolicy));
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySession$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71974 implements ContinuityCallbackManager.SendMessageCallbackWrapper {
        public C71974() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onMessageSent$0(String str, byte b, int i) {
            return "btMac = " + DLog.secureMac(str) + ", messageId = " + ((int) b) + ", status = " + i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ContinuityConnection lambda$onMessageSent$1(byte b, int i, String str, ContinuityConnection continuityConnection) {
            ContinuitySessionMessageManager.SendMessageCallback sendMessageCallbackRemoveSendMessageCallback = continuityConnection.removeSendMessageCallback(b);
            if (sendMessageCallbackRemoveSendMessageCallback != null) {
                sendMessageCallbackRemoveSendMessageCallback.onResult(i);
            }
            return continuityConnection;
        }

        @Override // com.samsung.android.mcf.continuity.impl.ContinuityCallbackManager.SendMessageCallbackWrapper
        public void onMessageSent(@NonNull final String str, final byte b, final int i) {
            DLog.m5608d(ContinuitySession.TAG, "onMessageSent", (Supplier<String>) new Supplier() { // from class: b2.s
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ContinuitySession.C71974.lambda$onMessageSent$0(str, b, i);
                }
            });
            synchronized (ContinuitySession.this.mContinuityConnectionMapLock) {
                ContinuitySession.this.mContinuityConnectionMap.computeIfPresent(str, new BiFunction() { // from class: b2.t
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return ContinuitySession.C71974.lambda$onMessageSent$1(b, i, (String) obj, (ContinuityConnection) obj2);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySession$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71985 implements NetworkUtil.SocketCallback {
        public final /* synthetic */ String val$btMac;

        public C71985(String str) {
            this.val$btMac = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDisconnected$0(String str) {
            ContinuitySession.this.forceDisconnect(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onPacketReceived$1(String str, byte[] bArr) {
            return "btMac = " + DLog.secureMac(str) + ", message.length = " + bArr.length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPacketReceived$2(ProtoContinuityPacket.ContinuityPacket continuityPacket, String str) {
            int type = continuityPacket.getType();
            if (type != 11) {
                DLog.m5611w(ContinuitySession.TAG, "onMessageReceived", "wrong packetType = " + type);
            } else {
                byte[] byteArray = continuityPacket.getPayload().toByteArray();
                DLog.m5608d(ContinuitySession.TAG, "onMessageReceived", new C4183f(str, byteArray, 2));
                if (ContinuitySession.this.mMessageListener == null) {
                    DLog.m5611w(ContinuitySession.TAG, "onMessageReceived", "null mMessageListener");
                } else {
                    ContinuitySession.this.mMessageListener.onReceived(str, byteArray);
                }
            }
        }

        @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
        public void onDisconnected() {
            ExecutorUtil.executeOnMain(new RunnableC0054a(this, this.val$btMac, 26));
        }

        @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
        public void onPacketReceived(@NonNull ProtoContinuityPacket.ContinuityPacket continuityPacket) {
            ExecutorUtil.executeOnMain(new RunnableC0201c(this, 15, continuityPacket, this.val$btMac));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySession$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71996 extends ContinuityMessageManager.MessageListener {
        public final /* synthetic */ ContinuityMessageManager.MessageListener val$messageListener;

        public C71996(ContinuityMessageManager.MessageListener messageListener) {
            this.val$messageListener = messageListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager.MessageListener
        public void onReceived(@NonNull String str, @NonNull byte[] bArr) {
            ExecutorUtil.executeOnCallback(new RunnableC4198u(this.val$messageListener, str, bArr, 0));
        }
    }

    public ContinuitySession(@NonNull ContinuityCommandManager continuityCommandManager, @NonNull ContinuityCallbackManager continuityCallbackManager) {
        this.mContinuityCommandManager = continuityCommandManager;
        this.mContinuityCallbackManager = continuityCallbackManager;
    }

    @Nullable
    @MainThread
    private ContinuityNetworkPolicyWrapper checkNetworkPolicy(@NonNull ContinuityNetworkPolicy continuityNetworkPolicy) {
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapperCreateInstance = ContinuityNetworkPolicyWrapper.createInstance(continuityNetworkPolicy.getType(), continuityNetworkPolicy.getTopology(), 30);
        if (this.mContinuityNetworkPolicyWrapper == null || continuityNetworkPolicyWrapperCreateInstance.equals(this.mContinuityNetworkPolicyWrapper)) {
            return continuityNetworkPolicyWrapperCreateInstance;
        }
        return null;
    }

    @MainThread
    private void closeServer() {
        if (!VersionUtil.isNetworkTypeSupported(12)) {
            DLog.m5610i(TAG, "closeServer", "wifi ap is not supported");
            return;
        }
        DLog.m5607d(TAG, "closeServer", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        ContinuityServerSocket continuityServerSocket = this.mContinuityServerSocket;
        if (continuityServerSocket != null) {
            continuityServerSocket.close();
            this.mContinuityServerSocket = null;
        }
    }

    @NonNull
    private NetworkUtil.SocketCallback createControlSocketCallback(@NonNull String str) {
        return new C71985(str);
    }

    @NonNull
    private ContinuitySessionManager.PeerConnectionRequestListener createPeerConnectionRequestListenerWrapper() {
        return new C71963();
    }

    @NonNull
    private ContinuitySessionManager.PeerStatusListener createPeerStatusListenerWrapper() {
        return new C71952();
    }

    private ContinuityCallbackManager.SendMessageCallbackWrapper createSendMessageCallbackWrapper() {
        return new C71974();
    }

    @NonNull
    private ContinuitySessionManager.SessionStatusListener createSessionStatusListenerWrapper() {
        return new C71941();
    }

    @MainThread
    private void disconnect(@NonNull String str) {
        ContinuityConnection continuityConnectionRemove;
        boolean zIsEmpty;
        synchronized (this.mContinuityConnectionMapLock) {
            continuityConnectionRemove = this.mContinuityConnectionMap.remove(str);
        }
        if (continuityConnectionRemove == null) {
            DLog.m5611w(TAG, "disconnect", "already disconnected, btMac = " + DLog.secureMac(str));
            return;
        }
        continuityConnectionRemove.destroy();
        synchronized (this.mContinuityConnectionMapLock) {
            zIsEmpty = this.mContinuityConnectionMap.isEmpty();
        }
        if (zIsEmpty) {
            this.mContinuityNetworkPolicyWrapper = null;
        }
        notifyPeerDisconnected(str);
    }

    @MainThread
    private int getLocalPort() {
        ContinuityServerSocket continuityServerSocket;
        if (this.mIsOpened && VersionUtil.isNetworkTypeSupported(12) && (continuityServerSocket = this.mContinuityServerSocket) != null) {
            return continuityServerSocket.getLocalPort();
        }
        return -1;
    }

    @MainThread
    private void handlePeerConnected(@NonNull final String str, @Nullable String str2, int i) {
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper = this.mContinuityNetworkPolicyWrapper;
        if (continuityNetworkPolicyWrapper == null) {
            DLog.m5611w(TAG, "handlePeerConnected", "null mContinuityNetworkPolicyWrapper");
            return;
        }
        ContinuityConnection continuityConnectionCreateInstance = ContinuityConnection.createInstance(str, str2, i, createControlSocketCallback(str));
        synchronized (this.mContinuityConnectionMapLock) {
            this.mContinuityConnectionMap.put(str, continuityConnectionCreateInstance);
        }
        int type = continuityNetworkPolicyWrapper.getType();
        switch (type) {
            case 11:
                this.mConnectionRequestedSet.clear();
                notifyPeerConnected(str);
                return;
            case 12:
                final boolean zContains = this.mConnectionRequestedSet.contains(str);
                DLog.m5608d(TAG, "handlePeerConnected", (Supplier<String>) new Supplier() { // from class: b2.p
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return ContinuitySession.lambda$handlePeerConnected$5(zContains, str);
                    }
                });
                if (zContains) {
                    return;
                }
                continuityConnectionCreateInstance.connectAndSetControlSocket(NetworkUtil.createSocket(), new C4190m(this, str, 1));
                return;
            case 13:
                return;
            default:
                DLog.m5611w(TAG, "handlePeerConnected", "invalid networkType : " + type);
                return;
        }
    }

    @MainThread
    private void handlePeerConnecting(@NonNull String str) {
        DLog.m5607d(TAG, "handlePeerConnecting", "btMac = " + DLog.secureMac(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void handlePeerConnectionRequested(@NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener = this.mPeerConnectionRequestListener;
        if (peerConnectionRequestListener != null) {
            peerConnectionRequestListener.onPeerConnectionRequested(continuityNearbyMyDeviceWrapper, continuityNetworkPolicyWrapper);
        }
    }

    @MainThread
    private void handlePeerDisconnected(@NonNull String str) {
        DLog.m5608d(TAG, "handlePeerDisconnected", new C4194q(str, 0));
        disconnect(str);
        notifyPeerDisconnected(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void handlePeerStatusChanged(final int i, @NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper) {
        final String btMac = continuityNearbyMyDeviceWrapper.getBtMac();
        final String ip = continuityNearbyMyDeviceWrapper.getIp();
        final int port = continuityNearbyMyDeviceWrapper.getPort();
        DLog.m5608d(TAG, "handlePeerStatusChanged", (Supplier<String>) new Supplier() { // from class: b2.l
            @Override // java.util.function.Supplier
            public final Object get() {
                return ContinuitySession.lambda$handlePeerStatusChanged$4(i, btMac, ip, port);
            }
        });
        if (btMac == null) {
            DLog.m5611w(TAG, "handlePeerStatusChanged", "null btMac");
        }
        if (!this.mPeerStatusListenerMap.containsKey(btMac)) {
            DLog.m5611w(TAG, "handlePeerStatusChanged", "not contain peerStatusListener");
            return;
        }
        switch (i) {
            case 20:
                handlePeerConnected(btMac, ip, port);
                break;
            case 21:
                handlePeerDisconnected(btMac);
                break;
            case 22:
                handlePeerConnecting(btMac);
                break;
            default:
                DLog.m5611w(TAG, "handlePeerStatusChanged", "invalid status : " + i);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void handleSessionStatusChanged(int i) {
        if (this.mSessionStatusListener != null) {
            ExecutorUtil.executeOnCallback(new RunnableC0050f(this, i, 5));
        }
    }

    @Nullable
    @WorkerThread
    private String ipToBtMac(@NonNull String str) {
        synchronized (this.mContinuityConnectionMapLock) {
            try {
                for (Map.Entry<String, ContinuityConnection> entry : this.mContinuityConnectionMap.entrySet()) {
                    String key = entry.getKey();
                    if (str.equals(entry.getValue().getIp())) {
                        return key;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    private boolean isServerOpened() {
        return this.mContinuityServerSocket != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$forceDisconnect$9(String str) {
        return "btMac = " + DLog.secureMac(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$handlePeerConnected$5(boolean z, String str) {
        StringBuilder sbM3200j = AbstractC4539a.m3200j("isRequested = ", ", btMac = ", z);
        sbM3200j.append(DLog.secureMac(str));
        return sbM3200j.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePeerConnected$6(String str, Boolean bool) {
        onControlSocketConnectResult(bool.booleanValue(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$handlePeerDisconnected$7(String str) {
        return "btMac = " + DLog.secureMac(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$handlePeerStatusChanged$4(int i, String str, String str2, int i2) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "peerStatus = ", ", btMac = ");
        sbM778t.append(DLog.secureMac(str));
        sbM778t.append(", ip = ");
        sbM778t.append(DLog.secureIp(str2));
        sbM778t.append(", port = ");
        sbM778t.append(i2);
        return sbM778t.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSessionStatusChanged$8(int i) {
        this.mSessionStatusListener.onSessionStatusChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ContinuitySessionManager.PeerStatusListener lambda$notifyPeerConnected$3(String str, String str2, ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        notifyPeerStatusChanged(str, 20, peerStatusListener);
        return peerStatusListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAccepted$0(String str, Boolean bool) {
        onControlSocketConnectResult(bool.booleanValue(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ContinuityConnection lambda$onAccepted$1(Socket socket, String str, String str2, ContinuityConnection continuityConnection) {
        continuityConnection.setControlSocket(socket, new C4190m(this, str, 0));
        return continuityConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ContinuityConnection lambda$onAccepted$2(String str, Socket socket, ContinuitySessionFileManager.FileInfoListener fileInfoListener, String str2, ContinuityConnection continuityConnection) {
        continuityConnection.addFileSocket(str, socket, fileInfoListener);
        return continuityConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerMessageListener$10(ContinuityMessageManager.MessageListener messageListener) {
        C71996 c71996 = new C71996(messageListener);
        this.mMessageListener = c71996;
        this.mContinuityCallbackManager.setSessionMessageListener(c71996);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unregisterMessageListener$11() {
        this.mContinuityCallbackManager.setSessionMessageListener(null);
        this.mMessageListener = null;
    }

    @AnyThread
    private void notifyPeerConnected(@NonNull String str) {
        this.mPeerStatusListenerMap.computeIfPresent(str, new C4192o(str, 0));
    }

    @AnyThread
    private void notifyPeerDisconnected(@NonNull String str) {
        synchronized (this.mContinuityConnectionMapLock) {
            this.mContinuityConnectionMap.remove(str);
        }
        notifyPeerStatusChanged(str, 21, this.mPeerStatusListenerMap.remove(str));
    }

    @AnyThread
    private static void notifyPeerStatusChanged(@NonNull String str, int i, @Nullable ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        if (peerStatusListener != null) {
            peerStatusListener.onPeerStatusChanged(i, new ContinuityNearbyMyDeviceWrapper.Builder().setBtMac(str).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void onAccepted(@NonNull Socket socket) {
        ContinuityConnection continuityConnectionComputeIfPresent;
        ContinuityConnection continuityConnectionComputeIfPresent2;
        InetAddress inetAddress = socket.getInetAddress();
        if (inetAddress == null) {
            DLog.m5611w(TAG, "accept", "null inetAddress");
            NetworkUtil.closeSocket(socket);
            return;
        }
        String hostAddress = inetAddress.getHostAddress();
        if (hostAddress == null) {
            DLog.m5611w(TAG, "accept", "null ip");
            NetworkUtil.closeSocket(socket);
            return;
        }
        String strIpToBtMac = ipToBtMac(hostAddress);
        if (strIpToBtMac == null) {
            DLog.m5611w(TAG, "accept", "unknown ip : " + DLog.secureIp(hostAddress));
            NetworkUtil.closeSocket(socket);
            return;
        }
        DLog.m5610i(TAG, "accept", "socket ip = " + DLog.secureIp(hostAddress) + ", btMac = " + DLog.secureMac(strIpToBtMac));
        if (this.mConnectionRequestedSet.remove(strIpToBtMac)) {
            synchronized (this.mContinuityConnectionMapLock) {
                continuityConnectionComputeIfPresent2 = this.mContinuityConnectionMap.computeIfPresent(strIpToBtMac, new C4188k(this, socket, strIpToBtMac));
            }
        } else {
            ContinuitySessionFileManager.FileInfoListener fileInfoListener = this.mFileInfoListener;
            if (fileInfoListener == null) {
                DLog.m5611w(TAG, "accept", "null fileInfoListener");
                NetworkUtil.closeSocket(socket);
                return;
            } else {
                synchronized (this.mContinuityConnectionMapLock) {
                    continuityConnectionComputeIfPresent = this.mContinuityConnectionMap.computeIfPresent(strIpToBtMac, new C4188k(strIpToBtMac, socket, fileInfoListener));
                }
                continuityConnectionComputeIfPresent2 = continuityConnectionComputeIfPresent;
            }
        }
        if (continuityConnectionComputeIfPresent2 == null) {
            DLog.m5611w(TAG, "accept", "not connected btMac : " + DLog.secureMac(strIpToBtMac));
            NetworkUtil.closeSocket(socket);
        }
    }

    @AnyThread
    private void onControlSocketConnectResult(boolean z, @NonNull String str) {
        if (z) {
            notifyPeerConnected(str);
        } else {
            notifyPeerDisconnected(str);
        }
    }

    @MainThread
    private boolean openServer() {
        if (!VersionUtil.isNetworkTypeSupported(12)) {
            DLog.m5610i(TAG, "openServer", "wifi ap is not supported");
            return true;
        }
        try {
            ContinuityServerSocket continuityServerSocketCreateInstance = ContinuityServerSocket.createInstance();
            this.mContinuityServerSocket = continuityServerSocketCreateInstance;
            try {
                continuityServerSocketCreateInstance.enableReuseAddress();
                return this.mContinuityServerSocket.accept(new C4191n(this, 0));
            } catch (SocketException e) {
                DLog.m5611w(TAG, "openServer", "enableReuseAddress SocketException : " + e.getMessage());
                closeServer();
                return false;
            }
        } catch (IOException e2) {
            DLog.m5611w(TAG, "openServer", "createInstance IOException : " + e2.getMessage());
            return false;
        }
    }

    @MainThread
    private void registerCallbackWrappers() {
        this.mContinuityCallbackManager.setSendMessageCallbackWrapper(createSendMessageCallbackWrapper());
        this.mContinuityCallbackManager.setSessionStatusListenerWrapper(createSessionStatusListenerWrapper());
        this.mContinuityCallbackManager.setPeerConnectionRequestListenerWrapper(createPeerConnectionRequestListenerWrapper());
        this.mContinuityCallbackManager.setPeerStatusListenerWrapper(createPeerStatusListenerWrapper());
    }

    private boolean setPeerStatusListener(@NonNull String str, @Nullable ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        return (peerStatusListener != null ? this.mPeerStatusListenerMap.putIfAbsent(str, peerStatusListener) : this.mPeerStatusListenerMap.remove(str)) != null;
    }

    @MainThread
    private void unregisterCallbackWrappers() {
        this.mContinuityCallbackManager.setSendMessageCallbackWrapper(null);
        this.mContinuityCallbackManager.setSessionStatusListenerWrapper(null);
        this.mContinuityCallbackManager.setPeerConnectionRequestListenerWrapper(null);
        this.mContinuityCallbackManager.setPeerStatusListenerWrapper(null);
    }

    @MainThread
    public void close() {
        if (this.mIsOpened) {
            destroy();
            this.mContinuityCommandManager.sendCloseSessionCommand();
        }
    }

    @MainThread
    public void destroy() {
        this.mConnectionRequestedSet.clear();
        synchronized (this.mContinuityConnectionMapLock) {
            try {
                Iterator<Map.Entry<String, ContinuityConnection>> it = this.mContinuityConnectionMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().destroy();
                }
                this.mContinuityConnectionMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mPeerStatusListenerMap.clear();
        this.mContinuityNetworkPolicyWrapper = null;
        this.mSessionStatusListener = null;
        this.mPeerConnectionRequestListener = null;
        this.mMessageListener = null;
        unregisterCallbackWrappers();
        closeServer();
        this.mIsOpened = false;
    }

    @MainThread
    public void forceDisconnect(@NonNull String str) {
        DLog.m5608d(TAG, "forceDisconnect", new C4194q(str, 1));
        disconnect(str);
        this.mContinuityCommandManager.sendDisconnectCommand(str);
    }

    @Nullable
    @VisibleForTesting(otherwise = 5)
    public ContinuitySessionManager.PeerConnectionRequestListener getPeerConnectionRequestListener() {
        return this.mPeerConnectionRequestListener;
    }

    @VisibleForTesting(otherwise = 5)
    public boolean hasPeerStatusListener(@NonNull String str) {
        return this.mPeerStatusListenerMap.containsKey(str);
    }

    @MainThread
    public void open(@NonNull ContinuitySessionManager.SessionStatusListener sessionStatusListener) {
        if (this.mIsOpened) {
            DLog.m5611w(TAG, AbstractCircuitBreaker.PROPERTY_NAME, "already opened");
            return;
        }
        if (!openServer()) {
            DLog.m5611w(TAG, AbstractCircuitBreaker.PROPERTY_NAME, "fail openServer");
            return;
        }
        registerCallbackWrappers();
        this.mSessionStatusListener = sessionStatusListener;
        this.mIsOpened = true;
        if (this.mContinuityCommandManager.sendOpenSessionCommand()) {
            return;
        }
        DLog.m5611w(TAG, AbstractCircuitBreaker.PROPERTY_NAME, "fail sendOpenSessionCommand");
        unregisterCallbackWrappers();
        this.mSessionStatusListener = null;
        this.mIsOpened = false;
        closeServer();
    }

    @MainThread
    public void registerFileInfoListener(@NonNull ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        this.mFileInfoListener = fileInfoListener;
    }

    public boolean registerMessageListener(@NonNull ContinuityMessageManager.MessageListener messageListener) {
        return ExecutorUtil.executeOnMain(new RunnableC0054a(this, messageListener, 25));
    }

    @MainThread
    public void registerPeerConnectionRequestListener(@NonNull ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener) {
        if (!this.mIsOpened) {
            DLog.m5611w(TAG, "registerPeerConnectionRequestListener", "not opened session");
            return;
        }
        this.mPeerConnectionRequestListener = peerConnectionRequestListener;
        if (this.mContinuityCommandManager.sendRegisterSessionListenerCommand()) {
            return;
        }
        DLog.m5611w(TAG, "registerSessionListener", "fail sendRegisterSessionListenerCommand");
        this.mPeerConnectionRequestListener = null;
    }

    @MainThread
    public void requestConnect(@NonNull String str, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy, @NonNull ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        if (!this.mIsOpened) {
            DLog.m5611w(TAG, "requestConnect", "session is not opened");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        int type = continuityNetworkPolicy.getType();
        if (!VersionUtil.isNetworkTypeSupported(type)) {
            DLog.m5611w(TAG, "requestConnect", "not supported networkType : " + type);
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        if (type != 11 && !isServerOpened()) {
            DLog.m5611w(TAG, "requestConnect", "server socket is not opened");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        int localPort = getLocalPort();
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapperCheckNetworkPolicy = checkNetworkPolicy(continuityNetworkPolicy);
        if (continuityNetworkPolicyWrapperCheckNetworkPolicy == null) {
            DLog.m5611w(TAG, "requestConnect", "different network policy");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        if (setPeerStatusListener(str, peerStatusListener)) {
            DLog.m5611w(TAG, "requestConnect", "duplicated connect");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        this.mContinuityNetworkPolicyWrapper = continuityNetworkPolicyWrapperCheckNetworkPolicy;
        if (this.mContinuityCommandManager.sendRequestConnectCommand(str, localPort, continuityNetworkPolicyWrapperCheckNetworkPolicy)) {
            return;
        }
        DLog.m5611w(TAG, "requestConnect", "fail sendRequestConnectCommand");
        setPeerStatusListener(str, null);
        this.mContinuityNetworkPolicyWrapper = null;
        notifyPeerStatusChanged(str, 21, peerStatusListener);
    }

    @MainThread
    public void responseConnect(int i, @NonNull String str, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy, @Nullable ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        if (!this.mIsOpened) {
            DLog.m5611w(TAG, "responseConnect", "session is not opened");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        int type = continuityNetworkPolicy.getType();
        if (!VersionUtil.isNetworkTypeSupported(type)) {
            DLog.m5611w(TAG, "responseConnect", "not supported networkType : " + type);
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        if (type != 11 && !isServerOpened()) {
            DLog.m5611w(TAG, "responseConnect", "server socket is not opened");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        int localPort = getLocalPort();
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapperCheckNetworkPolicy = checkNetworkPolicy(continuityNetworkPolicy);
        if (continuityNetworkPolicyWrapperCheckNetworkPolicy == null) {
            DLog.m5611w(TAG, "responseConnect", "different network policy");
            notifyPeerStatusChanged(str, 21, peerStatusListener);
            return;
        }
        if (i == 0) {
            if (setPeerStatusListener(str, peerStatusListener)) {
                DLog.m5611w(TAG, "responseConnect", "duplicated connect");
                notifyPeerStatusChanged(str, 21, peerStatusListener);
                return;
            } else {
                this.mContinuityNetworkPolicyWrapper = continuityNetworkPolicyWrapperCheckNetworkPolicy;
                this.mConnectionRequestedSet.add(str);
            }
        }
        if (this.mContinuityCommandManager.sendResponseConnectCommand(i, str, localPort, continuityNetworkPolicyWrapperCheckNetworkPolicy)) {
            return;
        }
        DLog.m5611w(TAG, "responseConnect", "fail sendRequestConnectCommand");
        if (i == 0) {
            setPeerStatusListener(str, null);
            this.mContinuityNetworkPolicyWrapper = null;
            this.mConnectionRequestedSet.remove(str);
        }
        notifyPeerStatusChanged(str, 21, peerStatusListener);
    }

    @AnyThread
    public boolean responseReceiveFile(int i, @NonNull ContinuityFileId continuityFileId, @Nullable File file, @Nullable ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper = this.mContinuityNetworkPolicyWrapper;
        if (continuityNetworkPolicyWrapper == null) {
            DLog.m5611w(TAG, "responseReceiveFile", "null continuityNetworkPolicyWrapper");
            return false;
        }
        if (continuityNetworkPolicyWrapper.getType() == 11) {
            DLog.m5611w(TAG, "responseReceiveFile", "BT session does not support File");
            return false;
        }
        String srcBtMac = continuityFileId.getSrcBtMac();
        int fileSequence = continuityFileId.getFileSequence();
        synchronized (this.mContinuityConnectionMapLock) {
            try {
                ContinuityConnection continuityConnection = this.mContinuityConnectionMap.get(srcBtMac);
                if (continuityConnection != null) {
                    return continuityConnection.responseReceiveFile(i, fileSequence, file, fileStatusListener);
                }
                DLog.m5611w(TAG, "responseReceiveFile", "not connected " + DLog.secureMac(srcBtMac));
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    @AnyThread
    public ContinuityFileId sendFile(@NonNull String str, @NonNull byte[] bArr, @NonNull File file, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper = this.mContinuityNetworkPolicyWrapper;
        if (continuityNetworkPolicyWrapper == null) {
            DLog.m5611w(TAG, "sendFile", "null continuityNetworkPolicyWrapper");
            return null;
        }
        if (continuityNetworkPolicyWrapper.getType() == 11) {
            DLog.m5611w(TAG, "sendFile", "BT session does not support File");
            return null;
        }
        synchronized (this.mContinuityConnectionMapLock) {
            try {
                ContinuityConnection continuityConnection = this.mContinuityConnectionMap.get(str);
                if (continuityConnection != null) {
                    return continuityConnection.sendFile(bArr, file, fileStatusListener);
                }
                DLog.m5611w(TAG, "sendFile", "not connected " + DLog.secureMac(str));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean sendMessage(@NonNull String str, @NonNull byte[] bArr, int i, @NonNull ContinuitySessionMessageManager.SendMessageCallback sendMessageCallback) {
        DLog.m5607d(TAG, "sendMessage", "btMac = " + DLog.secureMac(str) + ", message.length = " + bArr.length);
        ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper = this.mContinuityNetworkPolicyWrapper;
        if (continuityNetworkPolicyWrapper == null) {
            DLog.m5611w(TAG, "sendMessage", "null continuityNetworkPolicyWrapper");
            return false;
        }
        int type = continuityNetworkPolicyWrapper.getType();
        synchronized (this.mContinuityConnectionMapLock) {
            try {
                ContinuityConnection continuityConnection = this.mContinuityConnectionMap.get(str);
                if (continuityConnection == null) {
                    DLog.m5611w(TAG, "sendMessage", "not connected btMac : " + DLog.secureMac(str));
                    return false;
                }
                byte messageId = continuityConnection.getMessageId();
                if (type == 11) {
                    continuityConnection.putSendMessageCallback(messageId, sendMessageCallback);
                    if (!this.mContinuityCommandManager.sendSessionMessageCommand(str, bArr, messageId)) {
                        DLog.m5611w(TAG, "sendMessage", "fail sendSessionMessageCommand : " + DLog.secureMac(str));
                        continuityConnection.removeSendMessageCallback(messageId);
                        return false;
                    }
                } else {
                    continuityConnection.sendMessage(this.mContinuityPacketBuilder.setType(11).setId(messageId).setPayload(ByteString.copyFrom(bArr)).build(), sendMessageCallback);
                }
                continuityConnection.incrementMessageId();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    public void unregisterFileInfoListener() {
        this.mFileInfoListener = null;
    }

    public void unregisterMessageListener() {
        ExecutorUtil.executeOnMain(new RunnableC4195r(this, 0));
    }

    @MainThread
    public void unregisterPeerConnectionRequestListener() {
        this.mPeerConnectionRequestListener = null;
    }
}
