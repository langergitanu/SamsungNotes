package org.apache.commons.lang3;

import java.util.function.Function;
import org.apache.commons.logging.LogSource;

/* JADX INFO: renamed from: org.apache.commons.lang3.v */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13928v implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9968a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f9969b;

    public /* synthetic */ C13928v(String str, int i) {
        this.f9968a = i;
        this.f9969b = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f9968a) {
            case 0:
                return LocaleUtils.lambda$countriesByLanguage$1(this.f9969b, (String) obj);
            case 1:
                return LocaleUtils.lambda$languagesByCountry$3(this.f9969b, (String) obj);
            case 2:
                return ThreadUtils.lambda$findThreadsByName$1(this.f9969b, (ThreadGroup) obj);
            default:
                return LogSource.lambda$getInstance$0(this.f9969b, (String) obj);
        }
    }
}
