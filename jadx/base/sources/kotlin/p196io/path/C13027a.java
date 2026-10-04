package kotlin.p196io.path;

import java.nio.file.Path;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: kotlin.io.path.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13027a implements Function3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9331a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f9332b;

    public /* synthetic */ C13027a(boolean z, int i) {
        this.f9331a = i;
        this.f9332b = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        CopyActionContext copyActionContext = (CopyActionContext) obj;
        Path path = (Path) obj2;
        Path path2 = (Path) obj3;
        switch (this.f9331a) {
            case 0:
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(this.f9332b, copyActionContext, path, path2);
            default:
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(this.f9332b, copyActionContext, path, path2);
        }
    }
}
