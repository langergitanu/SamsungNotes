package io.netty.buffer;

import androidx.collection.AbstractC0622a;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    static final int CALCULATE_THRESHOLD = 4194304;
    static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    /* JADX INFO: renamed from: io.netty.buffer.AbstractByteBufAllocator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C123281 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] iArr = new int[ResourceLeakDetector.Level.values().length];
            $SwitchMap$io$netty$util$ResourceLeakDetector$Level = iArr;
            try {
                iArr[ResourceLeakDetector.Level.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.PARANOID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    public AbstractByteBufAllocator() {
        this(false);
    }

    public static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack;
        int i = C123281.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i == 1) {
            ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack2 = AbstractByteBuf.leakDetector.track(byteBuf);
            if (resourceLeakTrackerTrack2 != null) {
                return new SimpleLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack2);
            }
        } else if ((i == 2 || i == 3) && (resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(byteBuf)) != null) {
            return new AdvancedLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack);
        }
        return byteBuf;
    }

    private static void validate(int i, int i2) {
        ObjectUtil.checkPositiveOrZero(i, "initialCapacity");
        if (i > i2) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.directByDefault ? directBuffer() : heapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i, int i2) {
        ObjectUtil.checkPositiveOrZero(i, "minNewCapacity");
        if (i > i2) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i == 4194304) {
            return 4194304;
        }
        if (i <= 4194304) {
            return Math.min(MathUtil.findNextPositivePowerOfTwo(Math.max(i, 64)), i2);
        }
        int i4 = (i / 4194304) * 4194304;
        return i4 > i2 - 4194304 ? i2 : i4 + 4194304;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.directByDefault ? compositeDirectBuffer() : compositeHeapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return compositeDirectBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return compositeHeapBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return directBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) ? directBuffer(256) : heapBuffer(256);
    }

    public abstract ByteBuf newDirectBuffer(int i, int i2);

    public abstract ByteBuf newHeapBuffer(int i, int i2);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(directByDefault: ");
        return AbstractC0622a.m1172r(sb, this.directByDefault, PropertyUtils.MAPPED_DELIM2);
    }

    public AbstractByteBufAllocator(boolean z) {
        this.directByDefault = z && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i) {
        return directBuffer(i, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i) {
        return heapBuffer(i, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.emptyBuf;
        }
        validate(i, i2);
        return newDirectBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.emptyBuf;
        }
        validate(i, i2);
        return newHeapBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i) {
        if (this.directByDefault) {
            return directBuffer(i);
        }
        return heapBuffer(i);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i);
        }
        return compositeHeapBuffer(i);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i);
        }
        return directBuffer(i);
    }

    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack;
        int i = C123281.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i == 1) {
            ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack2 = AbstractByteBuf.leakDetector.track(compositeByteBuf);
            if (resourceLeakTrackerTrack2 != null) {
                return new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, resourceLeakTrackerTrack2);
            }
        } else if ((i == 2 || i == 3) && (resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(compositeByteBuf)) != null) {
            return new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, resourceLeakTrackerTrack);
        }
        return compositeByteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i, int i2) {
        if (this.directByDefault) {
            return directBuffer(i, i2);
        }
        return heapBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i, int i2) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i, i2);
        }
        return directBuffer(i, i2);
    }
}
