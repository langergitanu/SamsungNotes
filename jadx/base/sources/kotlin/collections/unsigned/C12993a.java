package kotlin.collections.unsigned;

import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: kotlin.collections.unsigned.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C12993a implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9317a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9318b;

    public /* synthetic */ C12993a(Object obj, int i) {
        this.f9317a = i;
        this.f9318b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f9317a) {
            case 0:
                return UIntArray.m22374iteratorimpl((int[]) this.f9318b);
            case 1:
                return ULongArray.m22453iteratorimpl((long[]) this.f9318b);
            case 2:
                return UByteArray.m22295iteratorimpl((byte[]) this.f9318b);
            default:
                return UShortArray.m22558iteratorimpl((short[]) this.f9318b);
        }
    }
}
