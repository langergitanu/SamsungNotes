package com.samsung.android.ocr;

import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import java.util.Map;
import java.util.function.ToIntFunction;
import opennlp.tools.formats.leipzig.LeipzigLanguageSampleStream;
import opennlp.tools.util.Span;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;

/* JADX INFO: renamed from: com.samsung.android.ocr.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7212a implements ToIntFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4845a;

    public /* synthetic */ C7212a(int i) {
        this.f4845a = i;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.f4845a) {
            case 0:
                return Integer.parseInt((String) obj);
            case 1:
                return ((SpenObjectSpan) obj).getTextIndex();
            case 2:
                return LeipzigLanguageSampleStream.lambda$new$2((String) obj);
            case 3:
                return ((Span) obj).getStart();
            case 4:
                return ((Integer) ((Map.Entry) obj).getValue()).intValue();
            case 5:
                return ((Integer) obj).intValue();
            default:
                return ((BackgroundInitializer) obj).getTaskCount();
        }
    }
}
