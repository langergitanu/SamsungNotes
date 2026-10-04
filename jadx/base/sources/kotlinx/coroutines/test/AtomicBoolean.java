package kotlinx.coroutines.test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R$\u0010\b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005¨\u0006\f"}, m13886d2 = {"Lkotlinx/coroutines/test/AtomicBoolean;", "", "initial", "", "<init>", "(Z)V", "container", "Lkotlinx/atomicfu/AtomicBoolean;", "value", "getValue", "()Z", "setValue", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
final class AtomicBoolean {
    private static final /* synthetic */ AtomicIntegerFieldUpdater container$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(AtomicBoolean.class, "container$volatile");
    private volatile /* synthetic */ int container$volatile;

    public AtomicBoolean(boolean z) {
        this.container$volatile = z ? 1 : 0;
    }

    private final /* synthetic */ int getContainer$volatile() {
        return this.container$volatile;
    }

    private final /* synthetic */ void setContainer$volatile(int i) {
        this.container$volatile = i;
    }

    public final boolean getValue() {
        return container$volatile$FU.get(this) != 0;
    }

    public final void setValue(boolean z) {
        container$volatile$FU.set(this, z ? 1 : 0);
    }
}
