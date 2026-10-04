package com.samsung.android.mcf.continuity.impl;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.Utils;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCommand;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNetworkPolicyWrapper;
import com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCallback;
import com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityCommandManager {
    private static final String TAG = "ContinuityCommandManager";
    private volatile int mAppId;

    @NonNull
    private final IContinuitySdkCallback mIContinuitySdkCallback;

    @Nullable
    private volatile IContinuitySdkCommand mIContinuitySdkCommand;

    public ContinuityCommandManager(@NonNull IContinuitySdkCallback iContinuitySdkCallback) {
        this.mIContinuitySdkCallback = iContinuitySdkCallback;
    }

    @Nullable
    @AnyThread
    private Bundle getInternalBundle(@NonNull Message message) {
        IContinuitySdkCommand iContinuitySdkCommand = this.mIContinuitySdkCommand;
        if (iContinuitySdkCommand == null) {
            DLog.m5611w(TAG, "getInternalBundle", "null iContinuitySdkCommand");
            return null;
        }
        Bundle bundleCreateBundle = Utils.createBundle();
        try {
            iContinuitySdkCommand.internalCommandWithReturnValue(message, bundleCreateBundle);
            return bundleCreateBundle;
        } catch (RemoteException e) {
            DLog.m5611w(TAG, "getInternalBundle", "RemoteException : " + e.getMessage());
            return null;
        }
    }

    @AnyThread
    private boolean internalCommand(@NonNull Message message) {
        IContinuitySdkCommand iContinuitySdkCommand = this.mIContinuitySdkCommand;
        if (iContinuitySdkCommand == null) {
            DLog.m5611w(TAG, "internalCommand", "null iContinuitySdkCommand");
            return false;
        }
        try {
            return iContinuitySdkCommand.internalCommand(message) == 0;
        } catch (RemoteException e) {
            DLog.m5611w(TAG, "internalCommand", "RemoteException : " + e.getMessage());
            return false;
        }
    }

    @MainThread
    public void destroy() {
        this.mIContinuitySdkCommand = null;
        this.mAppId = 0;
    }

    @Nullable
    public String getMessageIntentAction() {
        return ContinuityCommand.getMessageIntentAction(getInternalBundle(ContinuityCommand.createGetMessageIntentActionCommand(this.mAppId)));
    }

    @NonNull
    public List<ContinuityNearbyMyDevice> getNearbyMyDevices() {
        return ContinuityCommand.getContinuityNearbyDevice(getInternalBundle(ContinuityCommand.createGetContinuityNearbyDeviceCommand(this.mAppId)));
    }

    @MainThread
    public boolean initialize(int i, @Nullable IContinuitySdkCommand iContinuitySdkCommand) {
        if (iContinuitySdkCommand == null) {
            DLog.m5611w(TAG, "initialize", "null iContinuitySdkCommand");
            return false;
        }
        try {
            if (iContinuitySdkCommand.internalCommandWithReturnValue(ContinuityCommand.createIsMainControllerStartedCommand(i), Utils.createBundle()) != 0) {
                DLog.m5611w(TAG, "initialize", "main controller is not started");
                return false;
            }
            try {
                int iInternalCommand = iContinuitySdkCommand.internalCommand(ContinuityCommand.createRegisterCallbackCommand(i, this.mIContinuitySdkCallback));
                this.mIContinuitySdkCommand = iContinuitySdkCommand;
                this.mAppId = i;
                return iInternalCommand == 0;
            } catch (RemoteException e) {
                DLog.m5611w(TAG, "initialize", "fail to registerCallback " + e.getMessage());
                return false;
            }
        } catch (RemoteException e2) {
            DLog.m5611w(TAG, "initialize", "fail to check started " + e2.getMessage());
            return false;
        } catch (SecurityException e3) {
            DLog.m5611w(TAG, "initialize", "SecurityException " + e3.getMessage());
            return false;
        }
    }

    public boolean sendCloseSessionCommand() {
        return internalCommand(ContinuityCommand.createCloseSessionCommand(this.mAppId));
    }

    public boolean sendDisconnectCommand(@NonNull String str) {
        return internalCommand(ContinuityCommand.createDisconnectCommand(this.mAppId, str));
    }

    public boolean sendOpenSessionCommand() {
        return internalCommand(ContinuityCommand.createOpenSessionCommand(this.mAppId));
    }

    public boolean sendRegisterMessageIntentListenerCommand(@NonNull String str, @NonNull String str2) {
        return internalCommand(ContinuityCommand.createRegisterMessageIntentListenerCommand(this.mAppId, str, str2));
    }

    public boolean sendRegisterSessionListenerCommand() {
        return internalCommand(ContinuityCommand.createRegisterSessionListenerCommand(this.mAppId));
    }

    public boolean sendRegisterSimpleMessageListenerCommand() {
        return internalCommand(ContinuityCommand.createRegisterSimpleMessageListenerCommand(this.mAppId));
    }

    public boolean sendRequestConnectCommand(@NonNull String str, int i, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        return internalCommand(ContinuityCommand.createRequestConnectCommand(this.mAppId, str, i, continuityNetworkPolicyWrapper));
    }

    public boolean sendResponseConnectCommand(int i, @NonNull String str, int i2, @NonNull ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper) {
        return internalCommand(ContinuityCommand.createResponseConnectCommand(this.mAppId, i, str, i2, continuityNetworkPolicyWrapper));
    }

    public boolean sendSessionMessageCommand(@NonNull String str, @NonNull byte[] bArr, byte b) {
        return internalCommand(ContinuityCommand.createSendMessageCommand(this.mAppId, str, bArr, b));
    }

    public boolean sendSimpleMessageCommand(@NonNull String str, @NonNull byte[] bArr) {
        return internalCommand(ContinuityCommand.createSendMessageCommand(this.mAppId, str, bArr));
    }

    public boolean sendStartAdvertisementCommand() {
        return internalCommand(ContinuityCommand.createStartAdvertisementCommand(this.mAppId));
    }

    public boolean sendStartDiscoveryCommand() {
        return internalCommand(ContinuityCommand.createStartDiscoveryCommand(this.mAppId));
    }

    public boolean sendStopAdvertisementCommand() {
        return internalCommand(ContinuityCommand.createStopAdvertisementCommand(this.mAppId));
    }

    public boolean sendStopDiscoveryCommand() {
        return internalCommand(ContinuityCommand.createStopDiscoveryCommand(this.mAppId));
    }

    public boolean sendUnregisterCallbackCommand() {
        return internalCommand(ContinuityCommand.createUnregisterCallbackCommand(this.mAppId, this.mIContinuitySdkCallback));
    }

    public boolean sendUnregisterMessageIntentListenerCommand() {
        return internalCommand(ContinuityCommand.createUnregisterMessageIntentListenerCommand(this.mAppId));
    }

    public boolean sendUnregisterSimpleMessageListenerCommand() {
        return internalCommand(ContinuityCommand.createUnregisterSimpleMessageListenerCommand(this.mAppId));
    }

    public boolean sendUpdateAdvertisementCommand(@Nullable byte[] bArr) {
        return internalCommand(ContinuityCommand.createUpdateAdvertisementCommand(this.mAppId, bArr));
    }
}
