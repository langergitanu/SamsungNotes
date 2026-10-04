package io.netty.buffer;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class PoolSubpage<T> implements PoolSubpageMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    final int elemSize;
    private final ReentrantLock lock;
    private int maxNumElems;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageShifts;
    PoolSubpage<T> prev;
    private final int runOffset;
    private final int runSize;

    public PoolSubpage() {
        this.lock = new ReentrantLock();
        this.chunk = null;
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i = this.bitmapLength;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if ((~j) != 0) {
                return findNextAvail0(i2, j);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i, long j) {
        int i2 = this.maxNumElems;
        int i4 = i << 6;
        for (int i5 = 0; i5 < 64; i5++) {
            if ((1 & j) == 0) {
                int i6 = i4 | i5;
                if (i6 < i2) {
                    return i6;
                }
                return -1;
            }
            j >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i = this.nextAvail;
        if (i < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return i;
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i) {
        this.nextAvail = i;
    }

    private long toHandle(int i) {
        return (((long) this.runOffset) << 49) | (((long) (this.runSize >> this.pageShifts)) << 34) | 12884901888L | ((long) i);
    }

    public long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int nextAvail = getNextAvail();
        if (nextAvail < 0) {
            removeFromPool();
            StringBuilder sbM778t = AbstractC0541b.m778t(nextAvail, "No next available bitmap index found (bitmapIdx = ", "), even though there are supposed to be (numAvail = ");
            sbM778t.append(this.numAvail);
            sbM778t.append(") out of (maxNumElems = ");
            throw new AssertionError(AbstractC2821a.m2223n(sbM778t, ") available indexes.", this.maxNumElems));
        }
        int i = nextAvail >>> 6;
        long[] jArr = this.bitmap;
        jArr[i] = jArr[i] | (1 << (nextAvail & 63));
        int i2 = this.numAvail - 1;
        this.numAvail = i2;
        if (i2 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail);
    }

    public void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return -1;
        }
        poolChunk.arena.lock();
        try {
            return this.elemSize;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    public boolean free(PoolSubpage<T> poolSubpage, int i) {
        if (this.elemSize == 0) {
            return true;
        }
        int i2 = i >>> 6;
        long[] jArr = this.bitmap;
        jArr[i2] = jArr[i2] ^ (1 << (i & 63));
        setNextAvail(i);
        int i4 = this.numAvail;
        this.numAvail = i4 + 1;
        if (i4 == 0) {
            addToPool(poolSubpage);
            if (this.maxNumElems > 1) {
                return true;
            }
        }
        if (this.numAvail != this.maxNumElems || this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        removeFromPool();
        return false;
    }

    public void lock() {
        this.lock.lock();
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        poolChunk.arena.lock();
        try {
            return this.maxNumElems;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        poolChunk.arena.lock();
        try {
            return this.numAvail;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return 1 << this.pageShifts;
    }

    public String toString() {
        int i;
        int i2;
        PoolChunk<T> poolChunk = this.chunk;
        int i4 = -1;
        boolean z = true;
        int i5 = 0;
        if (poolChunk == null) {
            i = 0;
        } else {
            poolChunk.arena.lock();
            try {
                if (this.doNotDestroy) {
                    i4 = this.maxNumElems;
                    i = this.numAvail;
                    i2 = this.elemSize;
                } else {
                    i = -1;
                    z = false;
                    i2 = -1;
                }
                this.chunk.arena.unlock();
                int i6 = i2;
                i5 = i4;
                i4 = i6;
            } catch (Throwable th) {
                this.chunk.arena.unlock();
                throw th;
            }
        }
        if (!z) {
            return AbstractC2821a.m2223n(new StringBuilder("("), ": not in use)", this.runOffset);
        }
        return "(" + this.runOffset + ": " + (i5 - i) + '/' + i5 + ", offset: " + this.runOffset + ", length: " + this.runSize + ", elemSize: " + i4 + PropertyUtils.MAPPED_DELIM2;
    }

    public void unlock() {
        this.lock.unlock();
    }

    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i, int i2, int i4, int i5) {
        this.lock = new ReentrantLock();
        this.chunk = poolChunk;
        this.pageShifts = i;
        this.runOffset = i2;
        this.runSize = i4;
        this.elemSize = i5;
        this.bitmap = new long[i4 >>> 10];
        this.doNotDestroy = true;
        if (i5 != 0) {
            int i6 = i4 / i5;
            this.numAvail = i6;
            this.maxNumElems = i6;
            this.nextAvail = 0;
            int i7 = i6 >>> 6;
            this.bitmapLength = i7;
            if ((i6 & 63) != 0) {
                this.bitmapLength = i7 + 1;
            }
        }
        addToPool(poolSubpage);
    }
}
