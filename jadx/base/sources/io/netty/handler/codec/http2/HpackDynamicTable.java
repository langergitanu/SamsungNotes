package io.netty.handler.codec.http2;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class HpackDynamicTable {
    private long capacity = -1;
    int head;
    HpackHeaderField[] hpackHeaderFields;
    private long size;
    int tail;

    public HpackDynamicTable(long j) {
        setCapacity(j);
    }

    public void add(HpackHeaderField hpackHeaderField) {
        long j;
        long size = hpackHeaderField.size();
        if (size > this.capacity) {
            clear();
            return;
        }
        while (true) {
            long j2 = this.capacity;
            j = this.size;
            if (j2 - j >= size) {
                break;
            } else {
                remove();
            }
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i = this.head;
        int i2 = i + 1;
        this.head = i2;
        hpackHeaderFieldArr[i] = hpackHeaderField;
        this.size = j + size;
        if (i2 == hpackHeaderFieldArr.length) {
            this.head = 0;
        }
    }

    public long capacity() {
        return this.capacity;
    }

    public void clear() {
        while (true) {
            int i = this.tail;
            if (i == this.head) {
                this.head = 0;
                this.tail = 0;
                this.size = 0L;
                return;
            } else {
                HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
                int i2 = i + 1;
                this.tail = i2;
                hpackHeaderFieldArr[i] = null;
                if (i2 == hpackHeaderFieldArr.length) {
                    this.tail = 0;
                }
            }
        }
    }

    public HpackHeaderField getEntry(int i) {
        if (i <= 0 || i > length()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index ", " out of bounds for length ");
            sbM778t.append(length());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        int i2 = this.head - i;
        if (i2 >= 0) {
            return this.hpackHeaderFields[i2];
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        return hpackHeaderFieldArr[i2 + hpackHeaderFieldArr.length];
    }

    public int length() {
        int i = this.head;
        int i2 = this.tail;
        return i < i2 ? (this.hpackHeaderFields.length - i2) + i : i - i2;
    }

    public HpackHeaderField remove() {
        HpackHeaderField hpackHeaderField = this.hpackHeaderFields[this.tail];
        if (hpackHeaderField == null) {
            return null;
        }
        this.size -= (long) hpackHeaderField.size();
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i = this.tail;
        int i2 = i + 1;
        this.tail = i2;
        hpackHeaderFieldArr[i] = null;
        if (i2 == hpackHeaderFieldArr.length) {
            this.tail = 0;
        }
        return hpackHeaderField;
    }

    public void setCapacity(long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException(AbstractC0622a.m1169o("capacity is invalid: ", j));
        }
        if (this.capacity == j) {
            return;
        }
        this.capacity = j;
        if (j == 0) {
            clear();
        } else {
            while (this.size > j) {
                remove();
            }
        }
        int i = (int) (j / 32);
        if (j % 32 != 0) {
            i++;
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        if (hpackHeaderFieldArr == null || hpackHeaderFieldArr.length != i) {
            HpackHeaderField[] hpackHeaderFieldArr2 = new HpackHeaderField[i];
            int length = length();
            if (this.hpackHeaderFields != null) {
                int i2 = this.tail;
                for (int i4 = 0; i4 < length; i4++) {
                    HpackHeaderField[] hpackHeaderFieldArr3 = this.hpackHeaderFields;
                    int i5 = i2 + 1;
                    hpackHeaderFieldArr2[i4] = hpackHeaderFieldArr3[i2];
                    i2 = i5 == hpackHeaderFieldArr3.length ? 0 : i5;
                }
            }
            this.tail = 0;
            this.head = length;
            this.hpackHeaderFields = hpackHeaderFieldArr2;
        }
    }

    public long size() {
        return this.size;
    }
}
