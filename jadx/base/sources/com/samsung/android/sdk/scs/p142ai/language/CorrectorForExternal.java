package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.p142ai.language.service.CorrectionServiceExecutorForExternal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CorrectorForExternal extends Corrector {
    public CorrectorForExternal(@NonNull Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.language.Corrector
    public void createExecutor(Context context) {
        this.mServiceExecutor = new CorrectionServiceExecutorForExternal(context);
        this.featureName = "FEATURE_AI_GEN_CORRECTION_FOR_EXTERNAL";
    }
}
