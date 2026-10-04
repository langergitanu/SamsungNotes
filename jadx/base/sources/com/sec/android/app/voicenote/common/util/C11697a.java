package com.sec.android.app.voicenote.common.util;

import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import io.opentelemetry.api.trace.propagation.internal.W3CTraceContextEncoding;
import java.util.function.BiConsumer;
import org.apache.commons.text.AlphabetConverter;

/* JADX INFO: renamed from: com.sec.android.app.voicenote.common.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11697a implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8261a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StringBuilder f8262b;

    public /* synthetic */ C11697a(int i, StringBuilder sb) {
        this.f8261a = i;
        this.f8262b = sb;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f8261a) {
            case 0:
                AiSpeakerData.lambda$toString$0(this.f8262b, (Integer) obj, (String) obj2);
                break;
            case 1:
                W3CBaggagePropagator.lambda$baggageToString$0(this.f8262b, (String) obj, (BaggageEntry) obj2);
                break;
            case 2:
                W3CTraceContextEncoding.lambda$encodeTraceState$0(this.f8262b, (String) obj, (String) obj2);
                break;
            default:
                AlphabetConverter.lambda$toString$1(this.f8262b, (Integer) obj, (String) obj2);
                break;
        }
    }
}
