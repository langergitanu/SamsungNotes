package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import com.samsung.android.scs.p140ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.RecognitionConfig;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr_6_0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7718f implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5172a;

    public /* synthetic */ C7718f(int i) {
        this.f5172a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5172a) {
            case 0:
                return SpeechRecognitionConst.SERVICE_SYSTEM_BIND_ACTION;
            case 1:
                return SpeechRecognitionConst.SERVICE_BIND_ACTION;
            case 2:
                return SpeechRecognizerControl.lambda$static$0();
            default:
                return RecognitionConfig.Builder.lambda$build$2();
        }
    }
}
