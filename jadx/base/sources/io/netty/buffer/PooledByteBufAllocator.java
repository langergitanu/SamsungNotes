package io.netty.buffer;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import io.netty.buffer.PoolArena;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_NOT_USED = 0;
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PooledByteBufAllocator.class);
    private final int chunkSize;
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final Runnable trimTask;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        public PoolThreadLocalCache(boolean z) {
            this.useCacheForAllThreads = z;
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr == null || poolArenaArr.length == 0) {
                return null;
            }
            PoolArena<T> poolArena = poolArenaArr[0];
            if (poolArena.numThreadCaches.get() == 0) {
                return poolArena;
            }
            for (int i = 1; i < poolArenaArr.length; i++) {
                PoolArena<T> poolArena2 = poolArenaArr[i];
                if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                    poolArena = poolArena2;
                }
            }
            return poolArena;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            PoolArena poolArenaLeastUsedArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena poolArenaLeastUsedArena2 = leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread threadCurrentThread = Thread.currentThread();
            EventExecutor eventExecutorCurrentExecutor = ThreadExecutorMap.currentExecutor();
            if (!this.useCacheForAllThreads && !(threadCurrentThread instanceof FastThreadLocalThread) && eventExecutorCurrentExecutor == null) {
                return new PoolThreadCache(poolArenaLeastUsedArena, poolArenaLeastUsedArena2, 0, 0, 0, 0);
            }
            PoolThreadCache poolThreadCache = new PoolThreadCache(poolArenaLeastUsedArena, poolArenaLeastUsedArena2, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
            if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0 && eventExecutorCurrentExecutor != null) {
                eventExecutorCurrentExecutor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
            }
            return poolThreadCache;
        }

        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free(false);
        }
    }

    static {
        Object obj;
        int i;
        int i2 = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int i4 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i4, i2);
            i = i4;
            obj = null;
        } catch (Throwable th) {
            obj = th;
            i2 = 0;
            i = 8192;
        }
        DEFAULT_PAGE_SIZE = i;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = i2;
        int i5 = 9;
        int i6 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 9);
        try {
            validateAndCalculateChunkSize(i, i6);
            i5 = i6;
        } catch (Throwable th2) {
            obj2 = th2;
        }
        DEFAULT_MAX_ORDER = i5;
        Runtime runtime = Runtime.getRuntime();
        int iAvailableProcessors = NettyRuntime.availableProcessors() * 2;
        int i7 = DEFAULT_PAGE_SIZE;
        long j = iAvailableProcessors;
        long j2 = i7 << i5;
        int iMax = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(j, ((runtime.maxMemory() / j2) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = iMax;
        int iMax2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(j, ((PlatformDependent.maxDirectMemory() / j2) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = iMax2;
        int i8 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_SMALL_CACHE_SIZE = i8;
        int i9 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i9;
        int i10 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i10;
        int i11 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_CACHE_TRIM_INTERVAL = i11;
        if (SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            if (SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis")) {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
            } else {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0L);
            }
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
        }
        boolean z = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", false);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = z;
        int i12 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = i12;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(iMax));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(iMax2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i7));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i7), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i5));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i5), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(i7 << i5));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i8));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(i9));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(i10));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(i11));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", Long.valueOf(DEFAULT_CACHE_TRIM_INTERVAL_MILLIS));
            internalLogger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(z));
            internalLogger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", Integer.valueOf(i12));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    @Deprecated
    public static int defaultTinyCacheSize() {
        return 0;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    private static <T> PoolArena<T>[] newArenaArray(int i) {
        return new PoolArena[i];
    }

    private static long pinnedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long jNumPinnedBytes = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            jNumPinnedBytes += poolArena.numPinnedBytes();
            if (jNumPinnedBytes < 0) {
                return Long.MAX_VALUE;
            }
        }
        return jNumPinnedBytes;
    }

    private static long usedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long jNumActiveBytes = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            jNumActiveBytes += poolArena.numActiveBytes();
            if (jNumActiveBytes < 0) {
                return Long.MAX_VALUE;
            }
        }
        return jNumActiveBytes;
    }

    private static int validateAndCalculateChunkSize(int i, int i2) {
        if (i2 > 14) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "maxOrder: ", " (expected: 0-14)"));
        }
        int i4 = i;
        for (int i5 = i2; i5 > 0; i5--) {
            if (i4 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i), Integer.valueOf(i2), 1073741824));
            }
            i4 <<= 1;
        }
        return i4;
    }

    private static int validateAndCalculatePageShifts(int i, int i2) {
        if (i < 4096) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "pageSize: ", " (expected: 4096)"));
        }
        if (((i - 1) & i) != 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "pageSize: ", " (expected: power of 2)"));
        }
        if (i >= i2) {
            return 31 - Integer.numberOfLeadingZeros(i);
        }
        throw new IllegalArgumentException(AbstractC0622a.m1168n("Alignment cannot be greater than page size. Alignment: ", i2, ", page size: ", i, '.'));
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        PoolArena<byte[]>[] poolArenaArr = this.heapArenas;
        int length = poolArenaArr == null ? 0 : poolArenaArr.length;
        StringBuilder sb = new StringBuilder(512);
        sb.append(length);
        sb.append(" heap arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length > 0) {
            for (PoolArena<byte[]> poolArena : this.heapArenas) {
                sb.append(poolArena);
            }
        }
        PoolArena<ByteBuffer>[] poolArenaArr2 = this.directArenas;
        int length2 = poolArenaArr2 == null ? 0 : poolArenaArr2.length;
        sb.append(length2);
        sb.append(" direct arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length2 > 0) {
            for (PoolArena<ByteBuffer> poolArena2 : this.directArenas) {
                sb.append(poolArena2);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() throws Throwable {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newDirectBuffer(int i, int i2) {
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        return AbstractByteBufAllocator.toLeakAwareBuffer(poolArena != null ? poolArena.allocate(poolThreadCache, i, i2) : PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i, i2) : new UnpooledDirectByteBuf(this, i, i2));
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newHeapBuffer(int i, int i2) {
        ByteBuf unpooledUnsafeHeapByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            unpooledUnsafeHeapByteBuf = poolArena.allocate(poolThreadCache, i, i2);
        } else {
            unpooledUnsafeHeapByteBuf = PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i, i2) : new UnpooledHeapByteBuf(this, i, i2);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledUnsafeHeapByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i += poolArena.numThreadCaches.get();
        }
        return i;
    }

    public final long pinnedDirectMemory() {
        return pinnedMemory(this.directArenas);
    }

    public final long pinnedHeapMemory() {
        return pinnedMemory(this.heapArenas);
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    public final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() {
        return 0;
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache ifExists = this.threadCache.getIfExists();
        if (ifExists == null) {
            return false;
        }
        ifExists.trim();
        return true;
    }

    public final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    public final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    public PooledByteBufAllocator(boolean z) {
        this(z, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetricProvider
    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    public PooledByteBufAllocator(int i, int i2, int i4, int i5) {
        this(false, i, i2, i4, i5);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i4, int i5) {
        this(z, i, i2, i4, i5, 0, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        this(z, i, i2, i4, i5, i7, i8, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        this(z, i, i2, i4, i5, i7, i8, z2);
    }

    public PooledByteBufAllocator(boolean z, int i, int i2, int i4, int i5, int i6, int i7, boolean z2) {
        this(z, i, i2, i4, i5, i6, i7, z2, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9) {
        this(z, i, i2, i4, i5, i7, i8, z2, i9);
    }

    public PooledByteBufAllocator(boolean z, int i, int i2, int i4, int i5, int i6, int i7, boolean z2, int i8) {
        PooledByteBufAllocator pooledByteBufAllocator;
        super(z);
        this.trimTask = new Runnable() { // from class: io.netty.buffer.PooledByteBufAllocator.1
            @Override // java.lang.Runnable
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(z2);
        this.smallCacheSize = i6;
        this.normalCacheSize = i7;
        if (i8 != 0) {
            if (PlatformDependent.hasAlignDirectByteBuffer()) {
                i4 = (int) PlatformDependent.align(i4, i8);
            } else {
                throw new UnsupportedOperationException("Buffer alignment is not supported. Either Unsafe or ByteBuffer.alignSlice() must be available.");
            }
        }
        this.chunkSize = validateAndCalculateChunkSize(i4, i5);
        ObjectUtil.checkPositiveOrZero(i, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(i2, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(i8, "directMemoryCacheAlignment");
        if (i8 > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if (((-i8) & i8) == i8) {
            int iValidateAndCalculatePageShifts = validateAndCalculatePageShifts(i4, i8);
            if (i > 0) {
                PoolArena<byte[]>[] poolArenaArrNewArenaArray = newArenaArray(i);
                this.heapArenas = poolArenaArrNewArenaArray;
                ArrayList arrayList = new ArrayList(poolArenaArrNewArenaArray.length);
                for (int i9 = 0; i9 < this.heapArenas.length; i9++) {
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i4, iValidateAndCalculatePageShifts, this.chunkSize);
                    this.heapArenas[i9] = heapArena;
                    arrayList.add(heapArena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.EMPTY_LIST;
            }
            if (i2 > 0) {
                PoolArena<ByteBuffer>[] poolArenaArrNewArenaArray2 = newArenaArray(i2);
                this.directArenas = poolArenaArrNewArenaArray2;
                ArrayList arrayList2 = new ArrayList(poolArenaArrNewArenaArray2.length);
                int i10 = 0;
                while (i10 < this.directArenas.length) {
                    int i11 = i4;
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i11, iValidateAndCalculatePageShifts, this.chunkSize, i8);
                    this.directArenas[i10] = directArena;
                    arrayList2.add(directArena);
                    i10++;
                    i4 = i11;
                }
                pooledByteBufAllocator = this;
                pooledByteBufAllocator.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            } else {
                pooledByteBufAllocator = this;
                pooledByteBufAllocator.directArenas = null;
                pooledByteBufAllocator.directArenaMetrics = Collections.EMPTY_LIST;
            }
            pooledByteBufAllocator.metric = new PooledByteBufAllocatorMetric(this);
            return;
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i8, "directMemoryCacheAlignment: ", " (expected: power of two)"));
    }
}
