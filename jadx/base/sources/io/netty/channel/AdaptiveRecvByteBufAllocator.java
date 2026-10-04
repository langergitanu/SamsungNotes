package io.netty.channel;

import androidx.compose.foundation.layout.AbstractC1038a;
import io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {

    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    static final int DEFAULT_INITIAL = 2048;
    static final int DEFAULT_MAXIMUM = 65536;
    static final int DEFAULT_MINIMUM = 64;
    private static final int INDEX_DECREMENT = 1;
    private static final int INDEX_INCREMENT = 4;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        public HandleImpl(int i, int i2, int i4) {
            super();
            this.minIndex = i;
            this.maxIndex = i2;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(i4);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        private void record(int i) {
            if (i > AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)]) {
                if (i >= this.nextReceiveBufferSize) {
                    this.index = Math.min(this.index + 4, this.maxIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                return;
            }
            if (!this.decreaseNow) {
                this.decreaseNow = true;
                return;
            }
            this.index = Math.max(this.index - 1, this.minIndex);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
            this.decreaseNow = false;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i) {
            if (i == attemptedBytesRead()) {
                record(i);
            }
            super.lastBytesRead(i);
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    static {
        int i;
        ArrayList arrayList = new ArrayList();
        int iM1200a = 16;
        while (true) {
            if (iM1200a >= 512) {
                break;
            } else {
                iM1200a = AbstractC1038a.m1200a(iM1200a, iM1200a, 16, arrayList);
            }
        }
        for (i = 512; i > 0; i <<= 1) {
            arrayList.add(Integer.valueOf(i));
        }
        SIZE_TABLE = new int[arrayList.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i2 >= iArr.length) {
                DEFAULT = new AdaptiveRecvByteBufAllocator();
                return;
            } else {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i2++;
            }
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, 2048, 65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSizeTableIndex(int i) {
        int length = SIZE_TABLE.length - 1;
        int i2 = 0;
        while (length >= i2) {
            if (length == i2) {
                return length;
            }
            int i4 = (i2 + length) >>> 1;
            int[] iArr = SIZE_TABLE;
            int i5 = iArr[i4];
            int i6 = i4 + 1;
            if (i > iArr[i6]) {
                i2 = i6;
            } else {
                if (i >= i5) {
                    return i == i5 ? i4 : i6;
                }
                length = i4 - 1;
            }
        }
        return i2;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }

    public AdaptiveRecvByteBufAllocator(int i, int i2, int i4) {
        ObjectUtil.checkPositive(i, "minimum");
        if (i2 < i) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "initial: "));
        }
        if (i4 < i2) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i4, "maximum: "));
        }
        int sizeTableIndex = getSizeTableIndex(i);
        int[] iArr = SIZE_TABLE;
        if (iArr[sizeTableIndex] < i) {
            this.minIndex = sizeTableIndex + 1;
        } else {
            this.minIndex = sizeTableIndex;
        }
        int sizeTableIndex2 = getSizeTableIndex(i4);
        if (iArr[sizeTableIndex2] > i4) {
            this.maxIndex = sizeTableIndex2 - 1;
        } else {
            this.maxIndex = sizeTableIndex2;
        }
        this.initial = i2;
    }

    @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public AdaptiveRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        super.respectMaybeMoreData(z);
        return this;
    }
}
