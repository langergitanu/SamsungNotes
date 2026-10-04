package com.samsung.android.mcf.continuity.interfaces;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.common.Utils;
import com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityCommand {
    public static final int CMD_ASYNC_CLOSE_SESSION = 2017;
    public static final int CMD_ASYNC_DISCONNECT = 2016;
    public static final int CMD_ASYNC_END = 2017;
    public static final int CMD_ASYNC_OPEN_SESSION = 2012;
    public static final int CMD_ASYNC_REGISTER_CALLBACK = 2000;
    public static final int CMD_ASYNC_REGISTER_MESSAGE_INTENT_LISTENER = 2010;
    public static final int CMD_ASYNC_REGISTER_SESSION_LISTENER = 2014;
    public static final int CMD_ASYNC_REGISTER_SIMPLE_MESSAGE_LISTENER = 2008;
    public static final int CMD_ASYNC_REQUEST_CONNECT = 2013;
    public static final int CMD_ASYNC_RESPONSE_CONNECT = 2015;
    public static final int CMD_ASYNC_SEND_MESSAGE = 2007;
    public static final int CMD_ASYNC_START = 2000;
    public static final int CMD_ASYNC_START_ADVERTISEMENT = 2004;
    public static final int CMD_ASYNC_START_DISCOVERY = 2002;
    public static final int CMD_ASYNC_STOP_ADVERTISEMENT = 2006;
    public static final int CMD_ASYNC_STOP_DISCOVERY = 2003;
    public static final int CMD_ASYNC_UNREGISTER_CALLBACK = 2001;
    public static final int CMD_ASYNC_UNREGISTER_MESSAGE_INTENT_LISTENER = 2011;
    public static final int CMD_ASYNC_UNREGISTER_SIMPLE_MESSAGE_LISTENER = 2009;
    public static final int CMD_ASYNC_UPDATE_ADVERTISEMENT = 2005;
    public static final int CMD_SYNC_END = 3002;
    public static final int CMD_SYNC_GET_CONTINUITY_NEARBY_DEVICE = 3000;
    public static final int CMD_SYNC_GET_MESSAGE_INTENT_ACTION = 3001;
    public static final int CMD_SYNC_IS_MAIN_CONTROLLER_STARTED = 3002;
    public static final int CMD_SYNC_START = 3000;

    @VisibleForTesting
    public static final String KEY_ADVERTISEMENT_DATA = "KEY_ADVERTISEMENT_DATA";

    @VisibleForTesting
    public static final String KEY_BT_MAC = "KEY_BT_MAC";

    @VisibleForTesting
    public static final String KEY_CALLBACK = "KEY_CALLBACK";

    @VisibleForTesting
    public static final String KEY_CONFIRM = "KEY_CONFIRM";

    @VisibleForTesting
    public static final String KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE_ARRAY_LIST = "KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE_ARRAY_LIST";

    @VisibleForTesting
    public static final String KEY_MESSAGE_DATA = "KEY_MESSAGE_DATA";

    @VisibleForTesting
    public static final String KEY_MESSAGE_ID = "KEY_MESSAGE_ID";

    @VisibleForTesting
    public static final String KEY_MESSAGE_INTENT_ACTION_NAME = "KEY_MESSAGE_INTENT_ACTION_NAME";

    @VisibleForTesting
    public static final String KEY_MESSAGE_INTENT_PACKAGE_NAME = "KEY_MESSAGE_INTENT_PACKAGE_NAME";

    @VisibleForTesting
    public static final String KEY_NETWORK_POLICY_BUNDLE = "KEY_NETWORK_POLICY_BUNDLE";

    @VisibleForTesting
    public static final String KEY_PORT = "KEY_PORT";
    public static final int RETURN_FAILED = -1;
    public static final int RETURN_SUCCESS = 0;

    @NonNull
    public static Message createCloseSessionCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 2017;
        return messageCreateCommand;
    }

    @NonNull
    private static Message createCommand(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i;
        return messageObtain;
    }

    @NonNull
    public static Message createDisconnectCommand(int i, @NonNull String str) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_DISCONNECT;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putString("KEY_BT_MAC", str);
        return messageCreateCommand;
    }

    @NonNull
    public static Message createGetContinuityNearbyDeviceCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 3000;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createGetMessageIntentActionCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 3001;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createIsMainControllerStartedCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 3002;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createOpenSessionCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_OPEN_SESSION;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createRegisterCallbackCommand(int i, @NonNull IContinuitySdkCallback iContinuitySdkCallback) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 2000;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putBinder(KEY_CALLBACK, iContinuitySdkCallback.asBinder());
        return messageCreateCommand;
    }

    @NonNull
    public static Message createRegisterMessageIntentListenerCommand(int i, @NonNull String str, @NonNull String str2) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_REGISTER_MESSAGE_INTENT_LISTENER;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putString(KEY_MESSAGE_INTENT_PACKAGE_NAME, str);
        bundleCreateBundle.putString(KEY_MESSAGE_INTENT_ACTION_NAME, str2);
        return messageCreateCommand;
    }

    @NonNull
    public static Message createRegisterSessionListenerCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_REGISTER_SESSION_LISTENER;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createRegisterSimpleMessageListenerCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_REGISTER_SIMPLE_MESSAGE_LISTENER;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createRequestConnectCommand(int i, @NonNull String str, int i2, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_REQUEST_CONNECT;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putString("KEY_BT_MAC", str);
        bundleCreateBundle.putInt("KEY_PORT", i2);
        setContinuityNetworkPolicyWrapper(bundleCreateBundle, continuityNetworkPolicyWrapper);
        return messageCreateCommand;
    }

    @NonNull
    public static Message createResponseConnectCommand(int i, int i2, @NonNull String str, int i4, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_RESPONSE_CONNECT;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putInt(KEY_CONFIRM, i2);
        bundleCreateBundle.putString("KEY_BT_MAC", str);
        bundleCreateBundle.putInt("KEY_PORT", i4);
        setContinuityNetworkPolicyWrapper(bundleCreateBundle, continuityNetworkPolicyWrapper);
        return messageCreateCommand;
    }

    @NonNull
    public static Message createSendMessageCommand(int i, @NonNull String str, @NonNull byte[] bArr) {
        return createSendMessageCommand(i, str, bArr, (byte) 0);
    }

    @NonNull
    public static Message createStartAdvertisementCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 2004;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createStartDiscoveryCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 2002;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createStopAdvertisementCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_STOP_ADVERTISEMENT;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createStopDiscoveryCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 2003;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createUnregisterCallbackCommand(int i, @NonNull IContinuitySdkCallback iContinuitySdkCallback) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = 2001;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putBinder(KEY_CALLBACK, iContinuitySdkCallback.asBinder());
        return messageCreateCommand;
    }

    @NonNull
    public static Message createUnregisterMessageIntentListenerCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_UNREGISTER_MESSAGE_INTENT_LISTENER;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createUnregisterSimpleMessageListenerCommand(int i) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_UNREGISTER_SIMPLE_MESSAGE_LISTENER;
        return messageCreateCommand;
    }

    @NonNull
    public static Message createUpdateAdvertisementCommand(int i, @Nullable byte[] bArr) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_UPDATE_ADVERTISEMENT;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        bundleCreateBundle.putByteArray(KEY_ADVERTISEMENT_DATA, bArr);
        return messageCreateCommand;
    }

    @Nullable
    public static String getActionName(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getString(KEY_MESSAGE_INTENT_ACTION_NAME);
        }
        return null;
    }

    @Nullable
    public static byte[] getAdvertisementData(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getByteArray(KEY_ADVERTISEMENT_DATA);
        }
        return null;
    }

    public static int getAppId(@NonNull Message message) {
        return message.arg1;
    }

    @Nullable
    public static String getBtMac(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getString("KEY_BT_MAC");
        }
        return null;
    }

    @Nullable
    public static IContinuitySdkCallback getCallback(@NonNull Message message) {
        IBinder binder;
        int i = message.what;
        if (i != 2000 && i != 2001) {
            return null;
        }
        Object obj = message.obj;
        if ((obj instanceof Bundle) && (binder = ((Bundle) obj).getBinder(KEY_CALLBACK)) != null) {
            return IContinuitySdkCallback.Stub.asInterface(binder);
        }
        return null;
    }

    public static int getCommand(@NonNull Message message) {
        return message.what;
    }

    public static int getConfirm(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getInt(KEY_CONFIRM, -1);
        }
        return -1;
    }

    @NonNull
    public static List<ContinuityNearbyMyDevice> getContinuityNearbyDevice(@Nullable Bundle bundle) {
        ArrayList<Parcelable> parcelableArrayList = bundle != null ? bundle.getParcelableArrayList(KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE_ARRAY_LIST) : null;
        if (parcelableArrayList == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(parcelableArrayList.size());
        for (Parcelable parcelable : parcelableArrayList) {
            if (parcelable instanceof Bundle) {
                arrayList.add(ContinuityBundleFactory.continuityNearbyMyDeviceWrapperFromBundle((Bundle) parcelable));
            }
        }
        return arrayList;
    }

    @Nullable
    public static ContinuityNetworkPolicyWrapper getContinuityNetworkPolicyWrapper(@NonNull Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            return null;
        }
        Parcelable parcelable = ((Bundle) obj).getParcelable("KEY_NETWORK_POLICY_BUNDLE");
        if (parcelable instanceof Bundle) {
            return ContinuityBundleFactory.continuityNetworkPolicyWrapperFromBundle((Bundle) parcelable);
        }
        return null;
    }

    @Nullable
    public static byte[] getMessageData(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getByteArray(KEY_MESSAGE_DATA);
        }
        return null;
    }

    public static byte getMessageId(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getByte(KEY_MESSAGE_ID, (byte) 0).byteValue();
        }
        return (byte) 0;
    }

    @Nullable
    public static String getMessageIntentAction(@Nullable Bundle bundle) {
        if (bundle != null) {
            return bundle.getString(KEY_MESSAGE_INTENT_ACTION_NAME);
        }
        return null;
    }

    @Nullable
    public static String getPackageName(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getString(KEY_MESSAGE_INTENT_PACKAGE_NAME);
        }
        return null;
    }

    public static int getPort(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getInt("KEY_PORT", -1);
        }
        return -1;
    }

    public static void setBtMac(@NonNull Bundle bundle, @NonNull String str) {
        bundle.putString("KEY_BT_MAC", str);
    }

    public static void setContinuityNearbyDevice(@NonNull Bundle bundle, @NonNull ArrayList<ContinuityNearbyMyDeviceWrapper> arrayList) {
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<ContinuityNearbyMyDeviceWrapper> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ContinuityBundleFactory.continuityNearbyMyDeviceWrapperToBundle(it.next()));
        }
        bundle.putParcelableArrayList(KEY_CONTINUITY_NEARBY_DEVICE_BUNDLE_ARRAY_LIST, arrayList2);
    }

    public static void setContinuityNetworkPolicyWrapper(@NonNull Bundle bundle, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        bundle.putParcelable("KEY_NETWORK_POLICY_BUNDLE", ContinuityBundleFactory.continuityNetworkPolicyWrapperToBundle(continuityNetworkPolicyWrapper));
    }

    public static void setMessageData(@NonNull Bundle bundle, @NonNull byte[] bArr) {
        bundle.putByteArray(KEY_MESSAGE_DATA, bArr);
    }

    public static void setMessageId(@NonNull Bundle bundle, byte b) {
        bundle.putByte(KEY_MESSAGE_ID, b);
    }

    public static void setMessageIntentAction(@NonNull Bundle bundle, @Nullable String str) {
        bundle.putString(KEY_MESSAGE_INTENT_ACTION_NAME, str);
    }

    @NonNull
    public static Message createSendMessageCommand(int i, @NonNull String str, @NonNull byte[] bArr, byte b) {
        Message messageCreateCommand = createCommand(i);
        messageCreateCommand.what = CMD_ASYNC_SEND_MESSAGE;
        Bundle bundleCreateBundle = Utils.createBundle();
        messageCreateCommand.obj = bundleCreateBundle;
        setBtMac(bundleCreateBundle, str);
        setMessageData(bundleCreateBundle, bArr);
        setMessageId(bundleCreateBundle, b);
        return messageCreateCommand;
    }
}
