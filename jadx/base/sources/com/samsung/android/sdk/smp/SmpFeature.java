package com.samsung.android.sdk.smp;

import android.content.Context;
import androidx.core.util.Pair;
import com.google.android.gms.tasks.Task;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.ApiValidationCheckUtil;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;
import com.samsung.android.sdk.smp.push.FcmInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpFeature {
    public static void init(Context context, String str, SmpConstants.PushModeForHkAndMo pushModeForHkAndMo) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("appId", str), new Pair("pushMode", pushModeForHkAndMo));
            SmpInterfaceImpl.init(context.getApplicationContext(), str, pushModeForHkAndMo, new SmpInitOptions());
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static Task<Void> subscribeToFcmTopic(String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("topic", str));
            return FcmInterface.subscribeToFcmTopic(str);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static Task<Void> unsubscribeToFcmTopic(String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("topic", str));
            return FcmInterface.unsubscribeToFcmTopic(str);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }

    public static void init(Context context, String str, SmpConstants.PushModeForHkAndMo pushModeForHkAndMo, SmpInitOptions smpInitOptions) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        try {
            ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("appId", str), new Pair("pushMode", pushModeForHkAndMo), new Pair("smpInitOptions", smpInitOptions));
            SmpInterfaceImpl.init(context.getApplicationContext(), str, pushModeForHkAndMo, smpInitOptions);
        } catch (InternalException.ProviderErrorException e) {
            throw new SmpException.IllegalStateException(e.getErrorMessage());
        }
    }
}
