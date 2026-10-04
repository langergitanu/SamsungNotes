package com.samsung.android.mcf.continuity.interfaces;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.mcf.continuity.common.Utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityCallback {
    public static final int CALLBACK_DISCOVERY_DISCOVERED = 4002;
    public static final int CALLBACK_END = 4005;
    public static final int CALLBACK_MESSAGE_RECEIVED = 4000;
    public static final int CALLBACK_MESSAGE_SENT = 4001;
    public static final int CALLBACK_SESSION_PEER_CONNECTION_REQUESTED = 4005;
    public static final int CALLBACK_SESSION_PEER_STATUS_CHANGED = 4004;
    public static final int CALLBACK_SESSION_STATUS_CHANGED = 4003;
    public static final int CALLBACK_START = 4000;

    @VisibleForTesting
    public static final String KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE = "KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE";

    @VisibleForTesting
    public static final String KEY_EVENT = "KEY_EVENT";

    @VisibleForTesting
    public static final String KEY_PEER_STATUS = "KEY_PEER_STATUS";

    @VisibleForTesting
    public static final String KEY_SESSION_STATUS = "KEY_SESSION_STATUS";

    @VisibleForTesting
    public static final String KEY_STATUS = "KEY_STATUS";

    @NonNull
    public static Message createDiscoveryDiscoveredCallbackMessage(int i, @NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper) {
        Message messageCreateMessage = createMessage(CALLBACK_DISCOVERY_DISCOVERED);
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putInt(KEY_EVENT, i);
        bundleCreateBundle.putParcelable(KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE, ContinuityBundleFactory.continuityNearbyMyDeviceWrapperToBundle(continuityNearbyMyDeviceWrapper));
        messageCreateMessage.obj = bundleCreateBundle;
        return messageCreateMessage;
    }

    @NonNull
    private static Message createMessage(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        return messageObtain;
    }

    @NonNull
    public static Message createMessageReceivedCallbackMessage(@NonNull String str, @NonNull byte[] bArr, byte b) {
        Message messageCreateMessage = createMessage(4000);
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateMessage.obj = bundleCreateBundle;
        ContinuityCommand.setBtMac(bundleCreateBundle, str);
        ContinuityCommand.setMessageData(bundleCreateBundle, bArr);
        ContinuityCommand.setMessageId(bundleCreateBundle, b);
        return messageCreateMessage;
    }

    @NonNull
    public static Message createMessageSentCallbackMessage(@NonNull String str, byte b, int i) {
        Message messageCreateMessage = createMessage(CALLBACK_MESSAGE_SENT);
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateMessage.obj = bundleCreateBundle;
        ContinuityCommand.setBtMac(bundleCreateBundle, str);
        ContinuityCommand.setMessageId(bundleCreateBundle, b);
        bundleCreateBundle.putInt(KEY_STATUS, i);
        return messageCreateMessage;
    }

    @NonNull
    public static Message createSessionPeerConnectionRequestedCallbackMessage(@NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        Message messageCreateMessage = createMessage(4005);
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putParcelable(KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE, ContinuityBundleFactory.continuityNearbyMyDeviceWrapperToBundle(continuityNearbyMyDeviceWrapper));
        ContinuityCommand.setContinuityNetworkPolicyWrapper(bundleCreateBundle, continuityNetworkPolicyWrapper);
        messageCreateMessage.obj = bundleCreateBundle;
        return messageCreateMessage;
    }

    @NonNull
    public static Message createSessionPeerStatusChangedCallbackMessage(int i, @NonNull ContinuityNearbyMyDeviceWrapper continuityNearbyMyDeviceWrapper) {
        Message messageCreateMessage = createMessage(CALLBACK_SESSION_PEER_STATUS_CHANGED);
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putInt(KEY_PEER_STATUS, i);
        bundleCreateBundle.putParcelable(KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE, ContinuityBundleFactory.continuityNearbyMyDeviceWrapperToBundle(continuityNearbyMyDeviceWrapper));
        messageCreateMessage.obj = bundleCreateBundle;
        return messageCreateMessage;
    }

    @NonNull
    public static Message createSessionStatusChangedCallbackMessage(int i) {
        Message messageCreateMessage = createMessage(CALLBACK_SESSION_STATUS_CHANGED);
        Bundle bundleCreateBundle = Utils.createBundle();
        bundleCreateBundle.putInt(KEY_SESSION_STATUS, i);
        messageCreateMessage.obj = bundleCreateBundle;
        return messageCreateMessage;
    }

    @Nullable
    public static String getBtMac(@NonNull Message message) {
        return ContinuityCommand.getBtMac(message);
    }

    public static int getCallbackId(@NonNull Message message) {
        return message.what;
    }

    @Nullable
    public static ContinuityNearbyMyDeviceWrapper getContinuityNearbyMyDeviceWrapper(@NonNull Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            return null;
        }
        Parcelable parcelable = ((Bundle) obj).getParcelable(KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE);
        if (parcelable instanceof Bundle) {
            return ContinuityBundleFactory.continuityNearbyMyDeviceWrapperFromBundle((Bundle) parcelable);
        }
        return null;
    }

    @Nullable
    public static ContinuityNetworkPolicyWrapper getContinuityNetworkPolicyWrapper(@NonNull Message message) {
        return ContinuityCommand.getContinuityNetworkPolicyWrapper(message);
    }

    public static int getEvent(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getInt(KEY_EVENT, 102);
        }
        return 102;
    }

    @Nullable
    public static byte[] getMessageData(@NonNull Message message) {
        return ContinuityCommand.getMessageData(message);
    }

    public static byte getMessageId(@NonNull Message message) {
        return ContinuityCommand.getMessageId(message);
    }

    public static int getPeerStatus(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getInt(KEY_PEER_STATUS, 21);
        }
        return 21;
    }

    public static int getSessionStatus(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getInt(KEY_SESSION_STATUS, 11);
        }
        return 11;
    }

    public static int getStatus(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getInt(KEY_STATUS, -1);
        }
        return -1;
    }
}
