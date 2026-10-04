package kotlin.p196io;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlin.io.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13021a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9328a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayList f9329b;

    public /* synthetic */ C13021a(ArrayList arrayList, int i) {
        this.f9328a = i;
        this.f9329b = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9328a) {
            case 0:
                return FilesKt__FileReadWriteKt.readLines$lambda$9$FilesKt__FileReadWriteKt(this.f9329b, (String) obj);
            default:
                return TextStreamsKt.readLines$lambda$1(this.f9329b, (String) obj);
        }
    }
}
