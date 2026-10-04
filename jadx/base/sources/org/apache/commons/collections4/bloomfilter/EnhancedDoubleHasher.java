package org.apache.commons.collections4.bloomfilter;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.Objects;
import java.util.function.IntPredicate;
import org.apache.commons.collections4.bloomfilter.EnhancedDoubleHasher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EnhancedDoubleHasher implements Hasher {
    private final long increment;
    private final long initial;

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.EnhancedDoubleHasher$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C137361 implements IndexExtractor {
        final /* synthetic */ EnhancedDoubleHasher this$0;
        final /* synthetic */ Shape val$shape;

        public C137361(EnhancedDoubleHasher enhancedDoubleHasher, Shape shape) {
            this.val$shape = shape;
            this.this$0 = enhancedDoubleHasher;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$asIndexArray$0(int[] iArr, int[] iArr2, int i) {
            int i2 = iArr2[0];
            iArr2[0] = i2 + 1;
            iArr[i2] = i;
            return true;
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
        public int[] asIndexArray() {
            final int[] iArr = new int[this.val$shape.getNumberOfHashFunctions()];
            final int[] iArr2 = new int[1];
            processIndices(new IntPredicate() { // from class: org.apache.commons.collections4.bloomfilter.k
                @Override // java.util.function.IntPredicate
                public final boolean test(int i) {
                    return EnhancedDoubleHasher.C137361.lambda$asIndexArray$0(iArr, iArr2, i);
                }
            });
            return iArr;
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
        public boolean processIndices(IntPredicate intPredicate) {
            Objects.requireNonNull(intPredicate, "consumer");
            int numberOfBits = this.val$shape.getNumberOfBits();
            int iMod = BitMaps.mod(this.this$0.initial, numberOfBits);
            if (!intPredicate.test(iMod)) {
                return false;
            }
            int iMod2 = BitMaps.mod(this.this$0.increment, numberOfBits);
            int numberOfHashFunctions = this.val$shape.getNumberOfHashFunctions();
            if (numberOfHashFunctions >= numberOfBits) {
                int i = 1;
                for (int i2 = 1; i2 < numberOfHashFunctions; i2++) {
                    iMod -= iMod2;
                    if (iMod < 0) {
                        iMod += numberOfBits;
                    }
                    if (!intPredicate.test(iMod)) {
                        return false;
                    }
                    iMod2 -= i;
                    if (iMod2 < 0) {
                        iMod2 += numberOfBits;
                    }
                    i++;
                    if (i == numberOfBits) {
                        i = 0;
                    }
                }
            } else {
                for (int i4 = 1; i4 < numberOfHashFunctions; i4++) {
                    iMod -= iMod2;
                    if (iMod < 0) {
                        iMod += numberOfBits;
                    }
                    if (!intPredicate.test(iMod)) {
                        return false;
                    }
                    iMod2 -= i4;
                    if (iMod2 < 0) {
                        iMod2 += numberOfBits;
                    }
                }
            }
            return true;
        }
    }

    public EnhancedDoubleHasher(byte[] bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("buffer length must be greater than 0");
        }
        int length = bArr.length / 2;
        this.initial = toLong(bArr, 0, length);
        this.increment = toLong(bArr, length, bArr.length - length);
    }

    private static long toLong(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, 8) + i;
        long j = 0;
        int i4 = 64;
        while (i < iMin) {
            i4 -= 8;
            j |= ((long) (bArr[i] & 255)) << i4;
            i++;
        }
        return j;
    }

    public long getIncrement() {
        return this.increment;
    }

    public long getInitial() {
        return this.initial;
    }

    @Override // org.apache.commons.collections4.bloomfilter.Hasher
    public IndexExtractor indices(Shape shape) {
        Objects.requireNonNull(shape, VMetaDataKey.META_KEY_SHAPE);
        return new C137361(this, shape);
    }

    public EnhancedDoubleHasher(long j, long j2) {
        this.initial = j;
        this.increment = j2;
    }
}
