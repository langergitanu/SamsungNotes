package org.apache.commons.text.lookup;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: renamed from: org.apache.commons.text.lookup.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13960e implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9998a;

    public /* synthetic */ C13960e(int i) {
        this.f9998a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f9998a) {
            case 0:
                return InterpolatorStringLookup.lambda$new$0((Map.Entry) obj);
            case 1:
                return ((Path) obj).toAbsolutePath();
            case 2:
                return (StringLookup) ((Map.Entry) obj).getValue();
            case 3:
                return StringLookupFactory.lambda$static$0((String) obj);
            case 4:
                return StringLookupFactory.lambda$static$1((String) obj);
            case 5:
                return System.getenv((String) obj);
            case 6:
                return StringLookupFactory.lambda$static$2((String) obj);
            default:
                return System.getProperty((String) obj);
        }
    }
}
