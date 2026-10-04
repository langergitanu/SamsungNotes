package kotlin.collections;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: kotlin.collections.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C12989a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9312a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ KMappedMarker f9313b;

    public /* synthetic */ C12989a(KMappedMarker kMappedMarker, int i) {
        this.f9312a = i;
        this.f9313b = kMappedMarker;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9312a) {
            case 0:
                return AbstractCollection.toString$lambda$2((AbstractCollection) this.f9313b, obj);
            default:
                return AbstractMap.toString$lambda$2((AbstractMap) this.f9313b, (Map.Entry) obj);
        }
    }
}
