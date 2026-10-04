package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlinx.coroutines.channels.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13330c implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9421a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9422b;

    public /* synthetic */ C13330c(Object obj, int i) {
        this.f9421a = i;
        this.f9422b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9421a) {
            case 0:
                return ChannelsKt__DeprecatedKt.consumes$lambda$24$ChannelsKt__DeprecatedKt((ReceiveChannel) this.f9422b, (Throwable) obj);
            case 1:
                return BroadcastKt.broadcast$lambda$1((ReceiveChannel) this.f9422b, (Throwable) obj);
            default:
                return ChannelsKt__DeprecatedKt.consumesAll$lambda$2$ChannelsKt__DeprecatedKt((ReceiveChannel[]) this.f9422b, (Throwable) obj);
        }
    }
}
