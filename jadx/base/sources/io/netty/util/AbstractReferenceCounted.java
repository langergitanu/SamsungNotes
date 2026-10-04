package io.netty.util;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractReferenceCounted implements ReferenceCounted {
    private volatile int refCnt = updater.initialValue();
    private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCounted.class, "refCnt");
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCounted> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCounted.class, "refCnt");
    private static final ReferenceCountUpdater<AbstractReferenceCounted> updater = new ReferenceCountUpdater<AbstractReferenceCounted>() { // from class: io.netty.util.AbstractReferenceCounted.1
        @Override // io.netty.util.internal.ReferenceCountUpdater
        public long unsafeOffset() {
            return AbstractReferenceCounted.REFCNT_FIELD_OFFSET;
        }

        @Override // io.netty.util.internal.ReferenceCountUpdater
        public AtomicIntegerFieldUpdater<AbstractReferenceCounted> updater() {
            return AbstractReferenceCounted.AIF_UPDATER;
        }
    };

    private boolean handleRelease(boolean z) {
        if (z) {
            deallocate();
        }
        return z;
    }

    public abstract void deallocate();

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return updater.refCnt(this);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return handleRelease(updater.release(this));
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return updater.retain(this);
    }

    public final void setRefCnt(int i) {
        updater.setRefCnt(this, i);
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return touch(null);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return handleRelease(updater.release(this, i));
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int i) {
        return updater.retain(this, i);
    }
}
