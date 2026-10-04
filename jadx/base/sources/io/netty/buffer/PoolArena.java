package io.netty.buffer;

import androidx.compose.runtime.AbstractC1974b;
import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class PoolArena<T> extends SizeClasses implements PoolArenaMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    private final LongCounter activeBytesHuge;
    private final LongCounter allocationsHuge;
    private long allocationsNormal;
    private final LongCounter allocationsSmall;
    private final List<PoolChunkListMetric> chunkListMetrics;
    private final LongCounter deallocationsHuge;
    private long deallocationsNormal;
    private long deallocationsSmall;
    final int directMemoryCacheAlignment;
    private final ReentrantLock lock;
    final int numSmallSubpagePools;
    final AtomicInteger numThreadCaches;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;

    /* JADX INFO: renamed from: io.netty.buffer.PoolArena$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C123461 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DirectArena extends PoolArena<ByteBuffer> {
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i4, int i5) {
            super(pooledByteBufAllocator, i, i2, i4, i5);
        }

        private static ByteBuffer allocateDirect(int i) {
            return PlatformDependent.useDirectBufferNoCleaner() ? PlatformDependent.allocateDirectNoCleaner(i) : ByteBuffer.allocateDirect(i);
        }

        @Override // io.netty.buffer.PoolArena
        public void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner((ByteBuffer) poolChunk.base);
            } else {
                PlatformDependent.freeDirectBuffer((ByteBuffer) poolChunk.base);
            }
        }

        @Override // io.netty.buffer.PoolArena
        public boolean isDirect() {
            return true;
        }

        @Override // io.netty.buffer.PoolArena
        public PooledByteBuf<ByteBuffer> newByteBuf(int i) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeDirectByteBuf.newInstance(i) : PooledDirectByteBuf.newInstance(i);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<ByteBuffer> newChunk(int i, int i2, int i4, int i5) {
            int i6 = ((PoolArena) this).directMemoryCacheAlignment;
            if (i6 == 0) {
                ByteBuffer byteBufferAllocateDirect = allocateDirect(i5);
                return new PoolChunk<>(this, byteBufferAllocateDirect, byteBufferAllocateDirect, i, i4, i5, i2);
            }
            ByteBuffer byteBufferAllocateDirect2 = allocateDirect(i6 + i5);
            return new PoolChunk<>(this, byteBufferAllocateDirect2, PlatformDependent.alignDirectBuffer(byteBufferAllocateDirect2, ((PoolArena) this).directMemoryCacheAlignment), i, i4, i5, i2);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<ByteBuffer> newUnpooledChunk(int i) {
            int i2 = ((PoolArena) this).directMemoryCacheAlignment;
            if (i2 == 0) {
                ByteBuffer byteBufferAllocateDirect = allocateDirect(i);
                return new PoolChunk<>(this, byteBufferAllocateDirect, byteBufferAllocateDirect, i);
            }
            ByteBuffer byteBufferAllocateDirect2 = allocateDirect(i2 + i);
            return new PoolChunk<>(this, byteBufferAllocateDirect2, PlatformDependent.alignDirectBuffer(byteBufferAllocateDirect2, ((PoolArena) this).directMemoryCacheAlignment), i);
        }

        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i, PooledByteBuf<ByteBuffer> pooledByteBuf, int i2) {
            if (i2 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + ((long) i), PlatformDependent.directBufferAddress(pooledByteBuf.memory) + ((long) pooledByteBuf.offset), i2);
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            ByteBuffer byteBufferInternalNioBuffer = pooledByteBuf.internalNioBuffer();
            byteBufferDuplicate.position(i).limit(i + i2);
            byteBufferInternalNioBuffer.position(pooledByteBuf.offset);
            byteBufferInternalNioBuffer.put(byteBufferDuplicate);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HeapArena extends PoolArena<byte[]> {
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i4) {
            super(pooledByteBufAllocator, i, i2, i4, 0);
        }

        private static byte[] newByteArray(int i) {
            return PlatformDependent.allocateUninitializedArray(i);
        }

        @Override // io.netty.buffer.PoolArena
        public boolean isDirect() {
            return false;
        }

        @Override // io.netty.buffer.PoolArena
        public PooledByteBuf<byte[]> newByteBuf(int i) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i) : PooledHeapByteBuf.newInstance(i);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<byte[]> newChunk(int i, int i2, int i4, int i5) {
            return new PoolChunk<>(this, null, newByteArray(i5), i, i4, i5, i2);
        }

        @Override // io.netty.buffer.PoolArena
        public PoolChunk<byte[]> newUnpooledChunk(int i) {
            return new PoolChunk<>(this, null, newByteArray(i), i);
        }

        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i, PooledByteBuf<byte[]> pooledByteBuf, int i2) {
            if (i2 == 0) {
                return;
            }
            System.arraycopy(bArr, i, pooledByteBuf.memory, pooledByteBuf.offset, i2);
        }

        @Override // io.netty.buffer.PoolArena
        public void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SizeClass {
        Small,
        Normal
    }

    public PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i4, int i5) {
        super(i, i2, i4, i5);
        this.allocationsSmall = PlatformDependent.newLongCounter();
        this.allocationsHuge = PlatformDependent.newLongCounter();
        this.activeBytesHuge = PlatformDependent.newLongCounter();
        this.deallocationsHuge = PlatformDependent.newLongCounter();
        this.numThreadCaches = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.parent = pooledByteBufAllocator;
        this.directMemoryCacheAlignment = i5;
        int i6 = this.nSubpages;
        this.numSmallSubpagePools = i6;
        this.smallSubpagePools = newSubpagePoolArray(i6);
        int i7 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.smallSubpagePools;
            if (i7 >= poolSubpageArr.length) {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(this, null, 100, Integer.MAX_VALUE, i4);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(this, poolChunkList, 75, 100, i4);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(this, poolChunkList2, 50, 100, i4);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(this, poolChunkList3, 25, 75, i4);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(this, poolChunkList4, 1, 50, i4);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(this, poolChunkList5, Integer.MIN_VALUE, 25, i4);
                this.qInit = poolChunkList6;
                poolChunkList.prevList(poolChunkList2);
                poolChunkList2.prevList(poolChunkList3);
                poolChunkList3.prevList(poolChunkList4);
                poolChunkList4.prevList(poolChunkList5);
                poolChunkList5.prevList(null);
                poolChunkList6.prevList(poolChunkList6);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(poolChunkList6);
                arrayList.add(poolChunkList5);
                arrayList.add(poolChunkList4);
                arrayList.add(poolChunkList3);
                arrayList.add(poolChunkList2);
                arrayList.add(poolChunkList);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
            poolSubpageArr[i7] = newSubpagePoolHead();
            i7++;
        }
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i) {
        PoolChunk<T> poolChunkNewUnpooledChunk = newUnpooledChunk(i);
        this.activeBytesHuge.add(poolChunkNewUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(poolChunkNewUnpooledChunk, i);
        this.allocationsHuge.increment();
    }

    private void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i, int i2, PoolThreadCache poolThreadCache) {
        if (this.q050.allocate(pooledByteBuf, i, i2, poolThreadCache) || this.q025.allocate(pooledByteBuf, i, i2, poolThreadCache) || this.q000.allocate(pooledByteBuf, i, i2, poolThreadCache) || this.qInit.allocate(pooledByteBuf, i, i2, poolThreadCache) || this.q075.allocate(pooledByteBuf, i, i2, poolThreadCache)) {
            return;
        }
        PoolChunk<T> poolChunkNewChunk = newChunk(this.pageSize, this.nPSizes, this.pageShifts, this.chunkSize);
        poolChunkNewChunk.allocate(pooledByteBuf, i, i2, poolThreadCache);
        this.qInit.add(poolChunkNewChunk);
    }

    private static void appendPoolSubPages(StringBuilder sb, PoolSubpage<?>[] poolSubpageArr) {
        for (int i = 0; i < poolSubpageArr.length; i++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i];
            PoolSubpage<?> poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage && poolSubpage2 != null) {
                AbstractC1974b.m1330w(i, StringUtil.NEWLINE, ": ", sb);
                PoolSubpage poolSubpage3 = poolSubpage.next;
                while (poolSubpage3 != null) {
                    sb.append(poolSubpage3);
                    poolSubpage3 = poolSubpage3.next;
                    if (poolSubpage3 == poolSubpage) {
                        break;
                    }
                }
            }
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... poolChunkListArr) {
        for (PoolChunkList<T> poolChunkList : poolChunkListArr) {
            poolChunkList.destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] poolSubpageArr) {
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            poolSubpage.destroy();
        }
    }

    private void incSmallAllocation() {
        this.allocationsSmall.increment();
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i) {
        return new PoolSubpage[i];
    }

    private PoolSubpage<T> newSubpagePoolHead() {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>();
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private static SizeClass sizeClass(long j) {
        return PoolChunk.isSubpage(j) ? SizeClass.Small : SizeClass.Normal;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] poolSubpageArr) {
        ArrayList arrayList = new ArrayList();
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            PoolSubpage poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage) {
                do {
                    arrayList.add(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        return arrayList;
    }

    private void tcacheAllocateNormal(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        if (poolThreadCache.allocateNormal(this, pooledByteBuf, i, i2)) {
            return;
        }
        lock();
        try {
            allocateNormal(pooledByteBuf, i, i2, poolThreadCache);
            this.allocationsNormal++;
        } finally {
            unlock();
        }
    }

    private void tcacheAllocateSmall(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        PoolThreadCache poolThreadCache2;
        PooledByteBuf<T> pooledByteBuf2;
        int i4;
        if (poolThreadCache.allocateSmall(this, pooledByteBuf, i, i2)) {
            return;
        }
        PoolSubpage<T> poolSubpageFindSubpagePoolHead = findSubpagePoolHead(i2);
        poolSubpageFindSubpagePoolHead.lock();
        try {
            PoolSubpage<T> poolSubpage = poolSubpageFindSubpagePoolHead.next;
            boolean z = poolSubpage == poolSubpageFindSubpagePoolHead;
            if (z) {
                poolThreadCache2 = poolThreadCache;
                pooledByteBuf2 = pooledByteBuf;
                i4 = i;
            } else {
                poolThreadCache2 = poolThreadCache;
                pooledByteBuf2 = pooledByteBuf;
                i4 = i;
                poolSubpage.chunk.initBufWithSubpage(pooledByteBuf2, null, poolSubpage.allocate(), i4, poolThreadCache2);
            }
            if (z) {
                lock();
                try {
                    allocateNormal(pooledByteBuf2, i4, i2, poolThreadCache2);
                } finally {
                    unlock();
                }
            }
            incSmallAllocation();
        } finally {
            poolSubpageFindSubpagePoolHead.unlock();
        }
    }

    public PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i, int i2) {
        PooledByteBuf<T> pooledByteBufNewByteBuf = newByteBuf(i2);
        allocate(poolThreadCache, pooledByteBufNewByteBuf, i);
        return pooledByteBufNewByteBuf;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    public abstract void destroyChunk(PoolChunk<T> poolChunk);

    public final void finalize() {
        try {
            super.finalize();
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        } catch (Throwable th) {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
            throw th;
        }
    }

    public PoolSubpage<T> findSubpagePoolHead(int i) {
        return this.smallSubpagePools[i];
    }

    public void free(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j, int i, PoolThreadCache poolThreadCache) {
        PoolChunk<T> poolChunk2;
        ByteBuffer byteBuffer2;
        long j2;
        int i2;
        if (poolChunk.unpooled) {
            int iChunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-iChunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(j);
        if (poolThreadCache != null) {
            poolChunk2 = poolChunk;
            if (poolThreadCache.add(this, poolChunk, byteBuffer, j, i, sizeClass)) {
                return;
            }
            byteBuffer2 = byteBuffer;
            j2 = j;
            i2 = i;
            sizeClass = sizeClass;
        } else {
            poolChunk2 = poolChunk;
            byteBuffer2 = byteBuffer;
            j2 = j;
            i2 = i;
        }
        freeChunk(poolChunk2, j2, i2, sizeClass, byteBuffer2, false);
    }

    public void freeChunk(PoolChunk<T> poolChunk, long j, int i, SizeClass sizeClass, ByteBuffer byteBuffer, boolean z) {
        lock();
        if (!z) {
            try {
                int i2 = C123461.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
                if (i2 == 1) {
                    this.deallocationsNormal++;
                } else {
                    if (i2 != 2) {
                        throw new Error();
                    }
                    this.deallocationsSmall++;
                }
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        boolean zFree = poolChunk.parent.free(poolChunk, j, i, byteBuffer);
        unlock();
        if (zFree) {
            return;
        }
        destroyChunk(poolChunk);
    }

    public abstract boolean isDirect();

    public void lock() {
        this.lock.lock();
    }

    public abstract void memoryCopy(T t, int i, PooledByteBuf<T> pooledByteBuf, int i2);

    public abstract PooledByteBuf<T> newByteBuf(int i);

    public abstract PoolChunk<T> newChunk(int i, int i2, int i4, int i5);

    public abstract PoolChunk<T> newUnpooledChunk(int i);

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long jValue = (this.allocationsHuge.value() + this.allocationsSmall.value()) - this.deallocationsHuge.value();
        lock();
        try {
            long j = (this.allocationsNormal - (this.deallocationsSmall + this.deallocationsNormal)) + jValue;
            unlock();
            return Math.max(j, 0L);
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveBytes() {
        long jValue = this.activeBytesHuge.value();
        lock();
        for (int i = 0; i < this.chunkListMetrics.size(); i++) {
            try {
                Iterator<PoolChunkMetric> it = this.chunkListMetrics.get(i).iterator();
                while (it.hasNext()) {
                    jValue += (long) it.next().chunkSize();
                }
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        unlock();
        return Math.max(0L, jValue);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        return Math.max(numHugeAllocations() - numHugeDeallocations(), 0L);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        lock();
        try {
            long j = this.allocationsNormal - this.deallocationsNormal;
            unlock();
            return Math.max(j, 0L);
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        return Math.max(numSmallAllocations() - numSmallDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        lock();
        try {
            long j = this.allocationsNormal;
            unlock();
            return this.allocationsHuge.value() + this.allocationsSmall.value() + j;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        lock();
        try {
            long j = this.deallocationsSmall + this.deallocationsNormal;
            unlock();
            return this.deallocationsHuge.value() + j;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numNormalAllocations() {
        lock();
        try {
            return this.allocationsNormal;
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numNormalDeallocations() {
        lock();
        try {
            return this.deallocationsNormal;
        } finally {
            unlock();
        }
    }

    public long numPinnedBytes() {
        long jValue = this.activeBytesHuge.value();
        lock();
        for (int i = 0; i < this.chunkListMetrics.size(); i++) {
            try {
                Iterator<PoolChunkMetric> it = this.chunkListMetrics.get(i).iterator();
                while (it.hasNext()) {
                    jValue += (long) ((PoolChunk) it.next()).pinnedBytes();
                }
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        unlock();
        return Math.max(0L, jValue);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallDeallocations() {
        lock();
        try {
            return this.deallocationsSmall;
        } finally {
            unlock();
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyDeallocations() {
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return 0;
    }

    public void reallocate(PooledByteBuf<T> pooledByteBuf, int i, boolean z) {
        int i2 = pooledByteBuf.length;
        if (i2 == i) {
            return;
        }
        PoolChunk<T> poolChunk = pooledByteBuf.chunk;
        ByteBuffer byteBuffer = pooledByteBuf.tmpNioBuf;
        long j = pooledByteBuf.handle;
        T t = pooledByteBuf.memory;
        int i4 = pooledByteBuf.offset;
        int i5 = pooledByteBuf.maxLength;
        allocate(this.parent.threadCache(), pooledByteBuf, i);
        if (i > i2) {
            i = i2;
        } else {
            pooledByteBuf.trimIndicesToCapacity(i);
        }
        memoryCopy(t, i4, pooledByteBuf, i);
        if (z) {
            free(poolChunk, byteBuffer, j, i5, pooledByteBuf.cache);
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> tinySubpages() {
        return Collections.EMPTY_LIST;
    }

    public String toString() {
        lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Chunk(s) at 0~25%:");
            String str = StringUtil.NEWLINE;
            sb.append(str);
            sb.append(this.qInit);
            sb.append(str);
            sb.append("Chunk(s) at 0~50%:");
            sb.append(str);
            sb.append(this.q000);
            sb.append(str);
            sb.append("Chunk(s) at 25~75%:");
            sb.append(str);
            sb.append(this.q025);
            sb.append(str);
            sb.append("Chunk(s) at 50~100%:");
            sb.append(str);
            sb.append(this.q050);
            sb.append(str);
            sb.append("Chunk(s) at 75~100%:");
            sb.append(str);
            sb.append(this.q075);
            sb.append(str);
            sb.append("Chunk(s) at 100%:");
            sb.append(str);
            sb.append(this.q100);
            sb.append(str);
            sb.append("small subpages:");
            appendPoolSubPages(sb, this.smallSubpagePools);
            sb.append(str);
            return sb.toString();
        } finally {
            unlock();
        }
    }

    public void unlock() {
        this.lock.unlock();
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i) {
        int iSize2SizeIdx = size2SizeIdx(i);
        if (iSize2SizeIdx <= this.smallMaxSizeIdx) {
            tcacheAllocateSmall(poolThreadCache, pooledByteBuf, i, iSize2SizeIdx);
        } else {
            if (iSize2SizeIdx < this.nSizes) {
                tcacheAllocateNormal(poolThreadCache, pooledByteBuf, i, iSize2SizeIdx);
                return;
            }
            if (this.directMemoryCacheAlignment > 0) {
                i = normalizeSize(i);
            }
            allocateHuge(pooledByteBuf, i);
        }
    }
}
