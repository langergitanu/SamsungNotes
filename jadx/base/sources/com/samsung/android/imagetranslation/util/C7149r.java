package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.function.Function;
import org.apache.commons.lang3.time.FastDateParser;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7149r implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4806a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4807b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4808c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4809d;

    public /* synthetic */ C7149r(Object obj, ArrayList arrayList, int i, int i2) {
        this.f4806a = i2;
        this.f4809d = obj;
        this.f4807b = arrayList;
        this.f4808c = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4806a) {
            case 0:
                return ((OcrDataToSceneTextConverter) this.f4809d).lambda$convertStLines$3((ArrayList) this.f4807b, this.f4808c, (LttOcrResult.LineInfo) obj);
            case 1:
                return ((com.samsung.android.livetranslation.util.OcrDataToSceneTextConverter) this.f4809d).lambda$convertStLines$3((ArrayList) this.f4807b, this.f4808c, (LttOcrResult.LineInfo) obj);
            default:
                return ((FastDateParser) this.f4809d).lambda$getLocaleSpecificStrategy$2(this.f4808c, (Calendar) this.f4807b, (Locale) obj);
        }
    }

    public /* synthetic */ C7149r(FastDateParser fastDateParser, int i, Calendar calendar) {
        this.f4806a = 2;
        this.f4809d = fastDateParser;
        this.f4808c = i;
        this.f4807b = calendar;
    }
}
