package org.apache.commons.lang3.time;

import java.util.function.Consumer;
import org.apache.commons.lang3.time.FastDateParser;

/* JADX INFO: renamed from: org.apache.commons.lang3.time.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13924g implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9960a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StringBuilder f9961b;

    public /* synthetic */ C13924g(int i, StringBuilder sb) {
        this.f9960a = i;
        this.f9961b = sb;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f9960a) {
            case 0:
                FastDateParser.TimeZoneStrategy.lambda$new$0(this.f9961b, (String) obj);
                break;
            default:
                FastDateParser.lambda$appendDisplayNames$1(this.f9961b, (String) obj);
                break;
        }
    }
}
