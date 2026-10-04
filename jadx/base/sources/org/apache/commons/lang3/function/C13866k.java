package org.apache.commons.lang3.function;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.apache.commons.lang3.reflect.TypeUtils;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13866k implements FailableBiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9876a;

    public /* synthetic */ C13866k(int i) {
        this.f9876a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableBiConsumer
    public final void accept(Object obj, Object obj2) throws IOException {
        switch (this.f9876a) {
            case 0:
                FailableBiConsumer.lambda$static$0(obj, obj2);
                break;
            case 1:
                TypeUtils.lambda$static$0((Appendable) obj, (Type) obj2);
                break;
            case 2:
                TypeUtils.lambda$static$1((Appendable) obj, (TypeVariable) obj2);
                break;
            default:
                TypeUtils.lambda$static$2((Appendable) obj, obj2);
                break;
        }
    }
}
