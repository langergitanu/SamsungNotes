package com.samsung.android.sdk.smp;

import android.content.Context;
import androidx.core.util.Pair;
import com.samsung.android.sdk.smp.SmpCallback;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.SmpListeners;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.ApiValidationCheckUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Smp extends SmpFeature {
    public static void appUpdated(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            SmpInterfaceImpl.appUpdated(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void bootCompleted(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            SmpInterfaceImpl.bootCompleted(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static SmpResult clearData(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.clearData(context.getApplicationContext(), 60);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void feedback(Context context, String str, String str2) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("mid", str), new Pair("event", str2));
            SmpInterfaceImpl.feedback(context.getApplicationContext(), str, str2);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static String getGuid(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getGuid(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static SmpResult getOptIn(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getOptIn(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static String getPushToken(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getPushToken(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static String getPushType(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getPushType(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static String getSDKVersionName(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return DeviceInfoUtil.getSmpSdkVersion(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static String getSmpId(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.getSmpID(context.getApplicationContext());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void removeSmpInitResultListener() throws SmpException.IllegalStateException {
        ApiValidationCheckUtil.checkSmpApiValidity();
        SmpInterfaceImpl.removeSmpInitResultListener();
    }

    public static void removeSmpPushResultListener() throws SmpException.IllegalStateException {
        ApiValidationCheckUtil.checkSmpApiValidity();
        SmpInterfaceImpl.removeSmpPushResultListener();
    }

    public static void setGuid(Context context, String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            SmpInterfaceImpl.setGuid(context.getApplicationContext(), str);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static SmpResult setOptIn(Context context, boolean z, long j) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.setOptIn(context.getApplicationContext(), z, j);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void setSmpInitResultListener(SmpListeners.SmpInitResultListener smpInitResultListener) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("SmpInitResultListener", smpInitResultListener));
        SmpInterfaceImpl.setSmpInitResultListener(smpInitResultListener);
    }

    public static void setSmpPushResultListener(SmpListeners.SmpPushResultListener smpPushResultListener) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("SmpPushResultListener", smpPushResultListener));
        SmpInterfaceImpl.setSmpPushResultListener(smpPushResultListener);
    }

    public static SmpResult clearData(Context context, int i) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
            return SmpInterfaceImpl.clearData(context.getApplicationContext(), i);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void getGuid(Context context, SmpCallback.Success<String> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getGuid(context.getApplicationContext(), success, error);
    }

    public static void getPushToken(Context context, SmpCallback.Success<String> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getPushToken(context.getApplicationContext(), success, error);
    }

    public static void getPushType(Context context, SmpCallback.Success<String> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getPushType(context.getApplicationContext(), success, error);
    }

    public static void getSmpId(Context context, SmpCallback.Success<String> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.getSmpId(context.getApplicationContext(), success, error);
    }

    public static void setGuid(Context context, String str, SmpCallback.Success<Void> success, SmpCallback.Error error) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.setGuid(context.getApplicationContext(), str, success, error);
    }
}
