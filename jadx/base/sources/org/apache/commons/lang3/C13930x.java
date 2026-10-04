package org.apache.commons.lang3;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.lang3.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13930x implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9972a;

    public /* synthetic */ C13930x(int i) {
        this.f9972a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9972a) {
            case 0:
                return RandomUtils.secure();
            case 1:
                return RandomUtils.insecure();
            case 2:
                return RandomUtils.secureStrong();
            case 3:
                return ThreadLocalRandom.current();
            case 4:
                return new SecureRandom();
            case 5:
                return RandomUtils.lambda$static$0();
            case 6:
                return RandomUtils.lambda$static$1();
            default:
                return SystemUtils.lambda$static$0();
        }
    }
}
