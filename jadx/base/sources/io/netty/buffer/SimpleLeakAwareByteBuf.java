package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class SimpleLeakAwareByteBuf extends WrappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final ResourceLeakTracker<ByteBuf> leak;
    private final ByteBuf trackedByteBuf;

    public SimpleLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(byteBuf);
        this.trackedByteBuf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf2, "trackedByteBuf");
        this.leak = (ResourceLeakTracker) ObjectUtil.checkNotNull(resourceLeakTracker, "leak");
    }

    private void closeLeak() {
        this.leak.close(this.trackedByteBuf);
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return newLeakAwareByteBuf(byteBuf, byteBuf, resourceLeakTracker);
    }

    private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf byteBuf) {
        return newLeakAwareByteBuf(byteBuf, this.trackedByteBuf, this.leak);
    }

    private static ByteBuf unwrapSwapped(ByteBuf byteBuf) {
        if (byteBuf instanceof SwappedByteBuf) {
            do {
                byteBuf = byteBuf.unwrap();
            } while (byteBuf instanceof SwappedByteBuf);
        }
        return byteBuf;
    }

    private ByteBuf unwrappedDerived(ByteBuf byteBuf) {
        ByteBuf byteBufUnwrapSwapped = unwrapSwapped(byteBuf);
        if (!(byteBufUnwrapSwapped instanceof AbstractPooledDerivedByteBuf)) {
            return newSharedLeakAwareByteBuf(byteBuf);
        }
        ((AbstractPooledDerivedByteBuf) byteBufUnwrapSwapped).parent(this);
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(byteBuf);
        return resourceLeakTrackerTrack == null ? byteBuf : newLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return newSharedLeakAwareByteBuf(super.asReadOnly());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return newSharedLeakAwareByteBuf(super.duplicate());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        return order() == byteOrder ? this : newSharedLeakAwareByteBuf(super.order(byteOrder));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i) {
        return unwrappedDerived(super.readRetainedSlice(i));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i) {
        return newSharedLeakAwareByteBuf(super.readSlice(i));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        if (!super.release()) {
            return false;
        }
        closeLeak();
        return true;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return unwrappedDerived(super.retainedDuplicate());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return unwrappedDerived(super.retainedSlice());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return newSharedLeakAwareByteBuf(super.slice());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i, int i2) {
        return unwrappedDerived(super.retainedSlice(i, i2));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i, int i2) {
        return newSharedLeakAwareByteBuf(super.slice(i, i2));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i) {
        if (!super.release(i)) {
            return false;
        }
        closeLeak();
        return true;
    }

    public SimpleLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        this(byteBuf, byteBuf, resourceLeakTracker);
    }
}
