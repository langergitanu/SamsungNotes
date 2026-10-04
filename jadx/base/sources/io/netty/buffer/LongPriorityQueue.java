package io.netty.buffer;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class LongPriorityQueue {
    public static final int NO_VALUE = -1;
    private long[] array = new long[9];
    private int size;

    private void lift(int i) {
        while (i > 1) {
            int i2 = i >> 1;
            if (!subord(i2, i)) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private void sink(int i) {
        while (true) {
            int i2 = i << 1;
            int i4 = this.size;
            if (i2 > i4) {
                return;
            }
            if (i2 < i4) {
                int i5 = i2 + 1;
                if (subord(i2, i5)) {
                    i2 = i5;
                }
            }
            if (!subord(i, i2)) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private boolean subord(int i, int i2) {
        long[] jArr = this.array;
        return jArr[i] > jArr[i2];
    }

    private void swap(int i, int i2) {
        long[] jArr = this.array;
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void offer(long j) {
        if (j == -1) {
            throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
        }
        int i = this.size + 1;
        this.size = i;
        long[] jArr = this.array;
        if (i == jArr.length) {
            this.array = Arrays.copyOf(jArr, ((jArr.length - 1) * 2) + 1);
        }
        long[] jArr2 = this.array;
        int i2 = this.size;
        jArr2[i2] = j;
        lift(i2);
    }

    public long peek() {
        if (this.size == 0) {
            return -1L;
        }
        return this.array[1];
    }

    public long poll() {
        int i = this.size;
        if (i == 0) {
            return -1L;
        }
        long[] jArr = this.array;
        long j = jArr[1];
        jArr[1] = jArr[i];
        jArr[i] = 0;
        this.size = i - 1;
        sink(1);
        return j;
    }

    public void remove(long j) {
        int i = 1;
        while (true) {
            int i2 = this.size;
            if (i > i2) {
                return;
            }
            long[] jArr = this.array;
            if (jArr[i] == j) {
                this.size = i2 - 1;
                jArr[i] = jArr[i2];
                lift(i);
                sink(i);
                return;
            }
            i++;
        }
    }
}
