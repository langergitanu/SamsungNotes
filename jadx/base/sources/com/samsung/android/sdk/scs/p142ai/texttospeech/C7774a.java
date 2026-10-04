package com.samsung.android.sdk.scs.p142ai.texttospeech;

import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.texttospeech.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7774a implements OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5224a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TextToSpeech.OnConntectListener f5225b;

    public /* synthetic */ C7774a(TextToSpeech.OnConntectListener onConntectListener, int i) {
        this.f5224a = i;
        this.f5225b = onConntectListener;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f5224a) {
            case 0:
                CustomTextToSpeech.lambda$bindSynthesizer$0(this.f5225b, task);
                break;
            default:
                TextToSpeech.lambda$bindSynthesizer$0(this.f5225b, task);
                break;
        }
    }
}
