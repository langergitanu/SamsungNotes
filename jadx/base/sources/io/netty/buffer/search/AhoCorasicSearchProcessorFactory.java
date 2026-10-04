package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class AhoCorasicSearchProcessorFactory extends AbstractMultiSearchProcessorFactory {
    static final int ALPHABET_SIZE = 256;
    static final int BITS_PER_SYMBOL = 8;
    private final int[] jumpTable;
    private final int[] matchForNeedleId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Context {
        int[] jumpTable;
        int[] matchForNeedleId;

        private Context() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Processor implements MultiSearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final int[] matchForNeedleId;

        public Processor(int[] iArr, int[] iArr2) {
            this.jumpTable = iArr;
            this.matchForNeedleId = iArr2;
        }

        @Override // io.netty.buffer.search.MultiSearchProcessor
        public int getFoundNeedleId() {
            return this.matchForNeedleId[((int) this.currentPosition) >> 8];
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            long j = PlatformDependent.getInt(this.jumpTable, this.currentPosition | (((long) b) & 255));
            this.currentPosition = j;
            if (j >= 0) {
                return true;
            }
            this.currentPosition = -j;
            return false;
        }

        @Override // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0L;
        }
    }

    public AhoCorasicSearchProcessorFactory(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2.length == 0) {
                throw new IllegalArgumentException("Needle must be non empty");
            }
        }
        Context contextBuildTrie = buildTrie(bArr);
        this.jumpTable = contextBuildTrie.jumpTable;
        this.matchForNeedleId = contextBuildTrie.matchForNeedleId;
        linkSuffixes();
        while (true) {
            int[] iArr = this.jumpTable;
            if (i >= iArr.length) {
                return;
            }
            int[] iArr2 = this.matchForNeedleId;
            int i2 = iArr[i];
            if (iArr2[i2 >> 8] >= 0) {
                iArr[i] = -i2;
            }
            i++;
        }
    }

    private static Context buildTrie(byte[][] bArr) {
        ArrayList arrayList = new ArrayList(256);
        for (int i = 0; i < 256; i++) {
            arrayList.add(-1);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(-1);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int iIntValue = 0;
            for (byte b : bArr[i2]) {
                int i4 = iIntValue + (b & 255);
                if (((Integer) arrayList.get(i4)).intValue() == -1) {
                    arrayList.set(i4, Integer.valueOf(arrayList.size()));
                    for (int i5 = 0; i5 < 256; i5++) {
                        arrayList.add(-1);
                    }
                    arrayList2.add(-1);
                }
                iIntValue = ((Integer) arrayList.get(i4)).intValue();
            }
            arrayList2.set(iIntValue >> 8, Integer.valueOf(i2));
        }
        Context context = new Context();
        context.jumpTable = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            context.jumpTable[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        context.matchForNeedleId = new int[arrayList2.size()];
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            context.matchForNeedleId[i7] = ((Integer) arrayList2.get(i7)).intValue();
        }
        return context;
    }

    private void linkSuffixes() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(0);
        int[] iArr = new int[this.matchForNeedleId.length];
        Arrays.fill(iArr, -1);
        while (!arrayDeque.isEmpty()) {
            int iIntValue = ((Integer) arrayDeque.remove()).intValue();
            int i = iIntValue >> 8;
            int i2 = iArr[i];
            if (i2 == -1) {
                i2 = 0;
            }
            int[] iArr2 = this.matchForNeedleId;
            if (iArr2[i] == -1) {
                iArr2[i] = iArr2[i2 >> 8];
            }
            for (int i4 = 0; i4 < 256; i4++) {
                int i5 = iIntValue | i4;
                int[] iArr3 = this.jumpTable;
                int i6 = iArr3[i5];
                int i7 = iArr3[i2 | i4];
                if (i6 != -1) {
                    int i8 = i6 >> 8;
                    if (iIntValue <= 0 || i7 == -1) {
                        i7 = 0;
                    }
                    iArr[i8] = i7;
                    arrayDeque.add(Integer.valueOf(i6));
                } else {
                    if (i7 == -1) {
                        i7 = 0;
                    }
                    iArr3[i5] = i7;
                }
            }
        }
    }

    @Override // io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.jumpTable, this.matchForNeedleId);
    }
}
