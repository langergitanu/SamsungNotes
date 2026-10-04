package com.samsung.android.sdk.scs.p142ai.asr;

import com.samsung.android.sdk.scs.p142ai.asr.RecognitionConfig;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import java.util.Collections;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7692h implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5140a;

    public /* synthetic */ C7692h(int i) {
        this.f5140a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5140a) {
            case 0:
                return SpeechRecognitionConst.SERVICE_SYSTEM_BIND_ACTION;
            case 1:
                return SpeechRecognitionConst.SERVICE_BIND_ACTION;
            case 2:
                return SpeechRecognizerControl.lambda$static$0();
            case 3:
                return new String();
            case 4:
                return Collections.EMPTY_SET;
            default:
                return RecognitionConfig.Builder.lambda$build$2();
        }
    }
}
