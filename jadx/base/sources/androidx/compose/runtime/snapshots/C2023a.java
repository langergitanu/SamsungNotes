package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: androidx.compose.runtime.snapshots.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C2023a implements ObserverHandle {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1065a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function f1066b;

    public /* synthetic */ C2023a(Function function, int i) {
        this.f1065a = i;
        this.f1066b = function;
    }

    @Override // androidx.compose.runtime.snapshots.ObserverHandle
    public final void dispose() {
        switch (this.f1065a) {
            case 0:
                Snapshot.Companion.registerApplyObserver$lambda$6((Function2) this.f1066b);
                break;
            default:
                Snapshot.Companion.registerGlobalWriteObserver$lambda$9((Function1) this.f1066b);
                break;
        }
    }
}
