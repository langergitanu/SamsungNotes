package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13448c implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9428a;

    public /* synthetic */ C13448c(int i) {
        this.f9428a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9428a) {
            case 0:
                return FlowKt__DistinctKt.defaultKeySelector$lambda$0$FlowKt__DistinctKt(obj);
            default:
                return Boolean.valueOf(FlowKt__MigrationKt.onErrorReturn$lambda$0$FlowKt__MigrationKt((Throwable) obj));
        }
    }
}
