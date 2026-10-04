package com.samsung.android.mcf.continuity.impl;

import android.os.Message;
import androidx.annotation.BinderThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCallback;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNearbyMyDeviceWrapper;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNetworkPolicyWrapper;
import com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityCallbackManager {
    private static final String TAG = "ContinuityCallbackManager";

    @Nullable
    private volatile ContinuityDiscoveryManager.DiscoveryListener mDiscoveryListener;

    @Nullable
    private volatile ContinuitySessionManager.PeerConnectionRequestListener mPeerConnectionRequestListenerWrapper;

    @Nullable
    private volatile ContinuitySessionManager.PeerStatusListener mPeerStatusListenerWrapper;

    @Nullable
    private volatile SendMessageCallbackWrapper mSendMessageCallbackWrapper;

    @Nullable
    private volatile ContinuityMessageManager.MessageListener mSessionMessageListener;

    @Nullable
    private volatile ContinuitySessionManager.SessionStatusListener mSessionStatusListenerWrapper;

    @Nullable
    private volatile ContinuityMessageManager.MessageListener mSimpleMessageListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SendMessageCallbackWrapper {
        void onMessageSent(@NonNull String str, byte b, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @BinderThread
    public void handleDiscoveryDiscovered(int i, @Nullable ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper) {
        if (continuityNearbyMyDeviceWrapper == null) {
            DLog.m5611w(TAG, "handleDiscoveryDiscovered", "null parameters");
            return;
        }
        ContinuityDiscoveryManager.DiscoveryListener discoveryListener = this.mDiscoveryListener;
        if (discoveryListener == null) {
            DLog.m5611w(TAG, "handleDiscoveryDiscovered", "null discoveryListener");
        } else {
            discoveryListener.onDiscovered(i, continuityNearbyMyDeviceWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @BinderThread
    public void handleMessageReceived(@Nullable String str, @Nullable byte[] bArr, byte b) {
        if (str == null || bArr == null) {
            DLog.m5611w(TAG, "handleMessageReceived", "null parameters");
            return;
        }
        if (b == 0) {
            ContinuityMessageManager.MessageListener messageListener = this.mSimpleMessageListener;
            if (messageListener == null) {
                DLog.m5611w(TAG, "handleMessageReceived", "null simpleMessageListener");
                return;
            } else {
                messageListener.onReceived(str, bArr);
                return;
            }
        }
        ContinuityMessageManager.MessageListener messageListener2 = this.mSessionMessageListener;
        if (messageListener2 == null) {
            DLog.m5611w(TAG, "handleMessageReceived", "null sessionMessageListener");
        } else {
            messageListener2.onReceived(str, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @BinderThread
    public void handleMessageSent(@Nullable String str, byte b, int i) {
        if (str == null) {
            DLog.m5611w(TAG, "handleMessageSent", "null parameters");
            return;
        }
        if (b == 0) {
            DLog.m5611w(TAG, "handleMessageSent", "SendMessageCallback for simple message is not supported");
            return;
        }
        SendMessageCallbackWrapper sendMessageCallbackWrapper = this.mSendMessageCallbackWrapper;
        if (sendMessageCallbackWrapper == null) {
            DLog.m5611w(TAG, "handleMessageSent", "null sendMessageCallbackWrapper");
        } else {
            sendMessageCallbackWrapper.onMessageSent(str, b, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @BinderThread
    public void handleSessionPeerConnectionRequested(@Nullable ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper, @Nullable ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        if (continuityNearbyMyDeviceWrapper == null || continuityNetworkPolicyWrapper == null) {
            DLog.m5611w(TAG, "handleSessionPeerConnectionRequested", "null parameters");
            return;
        }
        ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener = this.mPeerConnectionRequestListenerWrapper;
        if (peerConnectionRequestListener == null) {
            DLog.m5611w(TAG, "handleSessionPeerConnectionRequested", "null peerConnectionRequestListenerWrapper");
        } else {
            peerConnectionRequestListener.onPeerConnectionRequested(continuityNearbyMyDeviceWrapper, continuityNetworkPolicyWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @BinderThread
    public void handleSessionPeerStatusChanged(int i, @Nullable ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper) {
        if (continuityNearbyMyDeviceWrapper == null) {
            DLog.m5611w(TAG, "handleSessionPeerStatusChanged", "null parameters");
            return;
        }
        ContinuitySessionManager.PeerStatusListener peerStatusListener = this.mPeerStatusListenerWrapper;
        if (peerStatusListener == null) {
            DLog.m5611w(TAG, "handleSessionPeerStatusChanged", "null peerStatusListenerWrapper");
        } else {
            peerStatusListener.onPeerStatusChanged(i, continuityNearbyMyDeviceWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @BinderThread
    public void handleSessionStatusChanged(int i) {
        ContinuitySessionManager.SessionStatusListener sessionStatusListener = this.mSessionStatusListenerWrapper;
        if (sessionStatusListener == null) {
            DLog.m5611w(TAG, "handleSessionStatusChanged", "null sessionStatusListenerWrapper");
        } else {
            sessionStatusListener.onSessionStatusChanged(i);
        }
    }

    @NonNull
    public IContinuitySdkCallback createIContinuitySdkCallback() {
        return new IContinuitySdkCallback.Stub() { // from class: com.samsung.android.mcf.continuity.impl.ContinuityCallbackManager.1
            @Override // com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCallback
            public void onCallback(Message message) {
                if (message == null) {
                    DLog.m5611w(ContinuityCallbackManager.TAG, "onCallback", "null message");
                }
                int callbackId = ContinuityCallback.getCallbackId(message);
                switch (callbackId) {
                    case 4000:
                        ContinuityCallbackManager.this.handleMessageReceived(ContinuityCallback.getBtMac(message), ContinuityCallback.getMessageData(message), ContinuityCallback.getMessageId(message));
                        break;
                    case ContinuityCallback.CALLBACK_MESSAGE_SENT /* 4001 */:
                        ContinuityCallbackManager.this.handleMessageSent(ContinuityCallback.getBtMac(message), ContinuityCallback.getMessageId(message), ContinuityCallback.getStatus(message));
                        break;
                    case ContinuityCallback.CALLBACK_DISCOVERY_DISCOVERED /* 4002 */:
                        ContinuityCallbackManager.this.handleDiscoveryDiscovered(ContinuityCallback.getEvent(message), ContinuityCallback.getContinuityNearbyMyDeviceWrapper(message));
                        break;
                    case ContinuityCallback.CALLBACK_SESSION_STATUS_CHANGED /* 4003 */:
                        ContinuityCallbackManager.this.handleSessionStatusChanged(ContinuityCallback.getSessionStatus(message));
                        break;
                    case ContinuityCallback.CALLBACK_SESSION_PEER_STATUS_CHANGED /* 4004 */:
                        ContinuityCallbackManager.this.handleSessionPeerStatusChanged(ContinuityCallback.getPeerStatus(message), ContinuityCallback.getContinuityNearbyMyDeviceWrapper(message));
                        break;
                    case 4005:
                        ContinuityCallbackManager.this.handleSessionPeerConnectionRequested(ContinuityCallback.getContinuityNearbyMyDeviceWrapper(message), ContinuityCallback.getContinuityNetworkPolicyWrapper(message));
                        break;
                    default:
                        DLog.m5611w(ContinuityCallbackManager.TAG, "onCallback", "invalid callbackId = " + callbackId);
                        break;
                }
            }
        };
    }

    @MainThread
    public void destroy() {
        setDiscoveryListener(null);
        setSimpleMessageListener(null);
        setSessionMessageListener(null);
        setSendMessageCallbackWrapper(null);
        setSessionStatusListenerWrapper(null);
        setPeerStatusListenerWrapper(null);
        setPeerConnectionRequestListenerWrapper(null);
    }

    @MainThread
    public void setDiscoveryListener(@Nullable ContinuityDiscoveryManager.DiscoveryListener discoveryListener) {
        this.mDiscoveryListener = discoveryListener;
    }

    @MainThread
    public void setPeerConnectionRequestListenerWrapper(@Nullable ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener) {
        this.mPeerConnectionRequestListenerWrapper = peerConnectionRequestListener;
    }

    @MainThread
    public void setPeerStatusListenerWrapper(@Nullable ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        this.mPeerStatusListenerWrapper = peerStatusListener;
    }

    @MainThread
    public void setSendMessageCallbackWrapper(@Nullable SendMessageCallbackWrapper sendMessageCallbackWrapper) {
        this.mSendMessageCallbackWrapper = sendMessageCallbackWrapper;
    }

    @MainThread
    public void setSessionMessageListener(@Nullable ContinuityMessageManager.MessageListener messageListener) {
        this.mSessionMessageListener = messageListener;
    }

    @MainThread
    public void setSessionStatusListenerWrapper(@Nullable ContinuitySessionManager.SessionStatusListener sessionStatusListener) {
        this.mSessionStatusListenerWrapper = sessionStatusListener;
    }

    @MainThread
    public void setSimpleMessageListener(@Nullable ContinuityMessageManager.MessageListener messageListener) {
        this.mSimpleMessageListener = messageListener;
    }
}
