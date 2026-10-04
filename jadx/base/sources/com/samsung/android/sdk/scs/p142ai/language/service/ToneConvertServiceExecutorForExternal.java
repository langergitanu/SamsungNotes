package com.samsung.android.sdk.scs.p142ai.language.service;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ToneConvertServiceExecutorForExternal extends ToneConvertServiceExecutor {
    public ToneConvertServiceExecutorForExternal(Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.language.service.ToneConvertServiceExecutor, com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_TONE_CONVERT_SERVICE_FOR_EXTERNAL, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }
}
