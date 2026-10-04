package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftAuthClient extends BoundServiceClient<IMicrosoftAuthService> {
    private static final String MICROSOFT_AUTH_SERVICE_CLASS_NAME = "com.microsoft.identity.client.MicrosoftAuthService";
    private static final String MICROSOFT_AUTH_SERVICE_INTENT_FILTER = "com.microsoft.identity.client.MicrosoftAuth";

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.broker.MicrosoftAuthClient$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C62441 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation */
        static final /* synthetic */ int[] f3581xecc0b39b;

        static {
            int[] iArr = new int[BrokerOperationBundle.Operation.values().length];
            f3581xecc0b39b = iArr;
            try {
                iArr[BrokerOperationBundle.Operation.MSAL_HELLO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_GET_INTENT_FOR_INTERACTIVE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_ACQUIRE_TOKEN_SILENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_GET_ACCOUNTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_REMOVE_ACCOUNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_GET_DEVICE_MODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_GET_CURRENT_ACCOUNT_IN_SHARED_DEVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_SIGN_OUT_FROM_SHARED_DEVICE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3581xecc0b39b[BrokerOperationBundle.Operation.MSAL_GENERATE_SHR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public MicrosoftAuthClient(@NonNull Context context) {
        super(context, MICROSOFT_AUTH_SERVICE_CLASS_NAME, MICROSOFT_AUTH_SERVICE_INTENT_FILTER);
    }

    public MicrosoftAuthClient(@NonNull Context context, int i) {
        super(context, MICROSOFT_AUTH_SERVICE_INTENT_FILTER, MICROSOFT_AUTH_SERVICE_CLASS_NAME, i);
    }

    @Override // com.microsoft.identity.common.internal.broker.BoundServiceClient
    @NonNull
    public IMicrosoftAuthService getInterfaceFromIBinder(@NonNull IBinder iBinder) {
        IMicrosoftAuthService iMicrosoftAuthServiceAsInterface = IMicrosoftAuthService.Stub.asInterface(iBinder);
        if (iMicrosoftAuthServiceAsInterface != null) {
            return iMicrosoftAuthServiceAsInterface;
        }
        throw new IllegalStateException("Failed to extract IMicrosoftAuthService from IBinder.", null);
    }

    @Override // com.microsoft.identity.common.internal.broker.BoundServiceClient
    @Nullable
    public Bundle performOperationInternal(@NonNull BrokerOperationBundle brokerOperationBundle, @NonNull IMicrosoftAuthService iMicrosoftAuthService) throws BrokerCommunicationException {
        Bundle bundle = brokerOperationBundle.getBundle();
        switch (C62441.f3581xecc0b39b[brokerOperationBundle.getOperation().ordinal()]) {
            case 1:
                return iMicrosoftAuthService.hello(bundle);
            case 2:
                Intent intentForInteractiveRequest = iMicrosoftAuthService.getIntentForInteractiveRequest();
                Bundle extras = intentForInteractiveRequest.getExtras();
                if (intentForInteractiveRequest.getComponent() != null && !TextUtils.isEmpty(intentForInteractiveRequest.getPackage()) && !TextUtils.isEmpty(intentForInteractiveRequest.getComponent().getClassName())) {
                    extras.putString(AuthenticationConstants.Broker.BROKER_PACKAGE_NAME, intentForInteractiveRequest.getPackage());
                    extras.putString(AuthenticationConstants.Broker.BROKER_ACTIVITY_NAME, intentForInteractiveRequest.getComponent().getClassName());
                }
                return extras;
            case 3:
                return iMicrosoftAuthService.acquireTokenSilently(bundle);
            case 4:
                return iMicrosoftAuthService.getAccounts(bundle);
            case 5:
                return iMicrosoftAuthService.removeAccount(bundle);
            case 6:
                return iMicrosoftAuthService.getDeviceMode();
            case 7:
                return iMicrosoftAuthService.getCurrentAccount(bundle);
            case 8:
                return iMicrosoftAuthService.removeAccountFromSharedDevice(bundle);
            case 9:
                return iMicrosoftAuthService.generateSignedHttpRequest(bundle);
            default:
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, IIpcStrategy.Type.BOUND_SERVICE, "Operation " + brokerOperationBundle.getOperation().name() + " is not supported by MicrosoftAuthClient.", null);
        }
    }
}
