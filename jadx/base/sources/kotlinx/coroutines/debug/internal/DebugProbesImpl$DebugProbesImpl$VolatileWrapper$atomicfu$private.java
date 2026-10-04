package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
public /* synthetic */ class DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private {
    private static final /* synthetic */ AtomicIntegerFieldUpdater installations$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.class, "installations$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater sequenceNumber$volatile$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.class, "sequenceNumber$volatile");
    private volatile /* synthetic */ int installations$volatile;
    private volatile /* synthetic */ long sequenceNumber$volatile;

    private DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private() {
    }

    private final /* synthetic */ int getInstallations$volatile() {
        return this.installations$volatile;
    }

    private final /* synthetic */ long getSequenceNumber$volatile() {
        return this.sequenceNumber$volatile;
    }

    private final /* synthetic */ void setInstallations$volatile(int i) {
        this.installations$volatile = i;
    }

    private final /* synthetic */ void setSequenceNumber$volatile(long j) {
        this.sequenceNumber$volatile = j;
    }

    public /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
