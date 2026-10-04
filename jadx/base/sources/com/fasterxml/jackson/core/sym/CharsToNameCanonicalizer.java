package com.fasterxml.jackson.core.sym;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.fasterxml.jackson.core.util.InternCache;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class CharsToNameCanonicalizer {
    protected static final int DEFAULT_TABLE_SIZE = 64;
    public static final int HASH_MULT = 33;
    static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
    static final int MAX_COLL_CHAIN_LENGTH = 255;
    static final int MAX_ENTRIES_FOR_REUSE = 12000;
    protected static final int MAX_TABLE_SIZE = 65536;
    static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
    protected Bucket[] _buckets;
    protected final boolean _canonicalize;
    protected boolean _dirty;
    private final int _hashSeed;
    protected int _indexMask;
    protected final boolean _intern;
    protected int _longestCollisionList;
    protected CharsToNameCanonicalizer _parent;
    protected int _size;
    protected int _sizeThreshold;
    protected String[] _symbols;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Bucket {
        private final int _length;
        private final Bucket _next;
        private final String _symbol;

        public Bucket(String str, Bucket bucket) {
            this._symbol = str;
            this._next = bucket;
            this._length = bucket != null ? 1 + bucket._length : 1;
        }

        public String find(char[] cArr, int i, int i2) {
            String symbol = this._symbol;
            Bucket next = this._next;
            while (true) {
                if (symbol.length() == i2) {
                    int i4 = 0;
                    while (symbol.charAt(i4) == cArr[i + i4] && (i4 = i4 + 1) < i2) {
                    }
                    if (i4 == i2) {
                        return symbol;
                    }
                }
                if (next == null) {
                    return null;
                }
                symbol = next.getSymbol();
                next = next.getNext();
            }
        }

        public Bucket getNext() {
            return this._next;
        }

        public String getSymbol() {
            return this._symbol;
        }

        public int length() {
            return this._length;
        }
    }

    private CharsToNameCanonicalizer() {
        this._canonicalize = true;
        this._intern = true;
        this._dirty = true;
        this._hashSeed = 0;
        this._longestCollisionList = 0;
        initTables(64);
    }

    private static int _thresholdSize(int i) {
        return i - (i >> 2);
    }

    private void copyArrays() {
        String[] strArr = this._symbols;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        this._symbols = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, length);
        Bucket[] bucketArr = this._buckets;
        int length2 = bucketArr.length;
        Bucket[] bucketArr2 = new Bucket[length2];
        this._buckets = bucketArr2;
        System.arraycopy(bucketArr, 0, bucketArr2, 0, length2);
    }

    public static CharsToNameCanonicalizer createRoot() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return createRoot((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }

    private void initTables(int i) {
        this._symbols = new String[i];
        this._buckets = new Bucket[i >> 1];
        this._indexMask = i - 1;
        this._size = 0;
        this._longestCollisionList = 0;
        this._sizeThreshold = _thresholdSize(i);
    }

    private CharsToNameCanonicalizer makeOrphan(int i) {
        return new CharsToNameCanonicalizer(null, true, true, this._symbols, this._buckets, this._size, i, this._longestCollisionList);
    }

    private void mergeChild(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.size() > MAX_ENTRIES_FOR_REUSE || charsToNameCanonicalizer._longestCollisionList > 63) {
            synchronized (this) {
                initTables(64);
                this._dirty = false;
            }
        } else {
            if (charsToNameCanonicalizer.size() <= size()) {
                return;
            }
            synchronized (this) {
                this._symbols = charsToNameCanonicalizer._symbols;
                this._buckets = charsToNameCanonicalizer._buckets;
                this._size = charsToNameCanonicalizer._size;
                this._sizeThreshold = charsToNameCanonicalizer._sizeThreshold;
                this._indexMask = charsToNameCanonicalizer._indexMask;
                this._longestCollisionList = charsToNameCanonicalizer._longestCollisionList;
                this._dirty = false;
            }
        }
    }

    private void rehash() {
        String[] strArr = this._symbols;
        int length = strArr.length;
        int i = length + length;
        if (i > 65536) {
            this._size = 0;
            Arrays.fill(strArr, (Object) null);
            Arrays.fill(this._buckets, (Object) null);
            this._dirty = true;
            return;
        }
        Bucket[] bucketArr = this._buckets;
        this._symbols = new String[i];
        this._buckets = new Bucket[i >> 1];
        this._indexMask = i - 1;
        this._sizeThreshold = _thresholdSize(i);
        int i2 = 0;
        int iMax = 0;
        for (String str : strArr) {
            if (str != null) {
                i2++;
                int i_hashToIndex = _hashToIndex(calcHash(str));
                String[] strArr2 = this._symbols;
                if (strArr2[i_hashToIndex] == null) {
                    strArr2[i_hashToIndex] = str;
                } else {
                    int i4 = i_hashToIndex >> 1;
                    Bucket bucket = new Bucket(str, this._buckets[i4]);
                    this._buckets[i4] = bucket;
                    iMax = Math.max(iMax, bucket.length());
                }
            }
        }
        int i5 = length >> 1;
        for (int i6 = 0; i6 < i5; i6++) {
            for (Bucket next = bucketArr[i6]; next != null; next = next.getNext()) {
                i2++;
                String symbol = next.getSymbol();
                int i_hashToIndex2 = _hashToIndex(calcHash(symbol));
                String[] strArr3 = this._symbols;
                if (strArr3[i_hashToIndex2] == null) {
                    strArr3[i_hashToIndex2] = symbol;
                } else {
                    int i7 = i_hashToIndex2 >> 1;
                    Bucket bucket2 = new Bucket(symbol, this._buckets[i7]);
                    this._buckets[i7] = bucket2;
                    iMax = Math.max(iMax, bucket2.length());
                }
            }
        }
        this._longestCollisionList = iMax;
        if (i2 != this._size) {
            throw new Error(AbstractC2322a.m1625o(new StringBuilder("Internal error on SymbolTable.rehash(): had "), this._size, i2, " entries; now have ", Extension.DOT));
        }
    }

    public int _hashToIndex(int i) {
        return (i + (i >>> 15)) & this._indexMask;
    }

    public int bucketCount() {
        return this._symbols.length;
    }

    public int calcHash(char[] cArr, int i, int i2) {
        int i4 = this._hashSeed;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 33) + cArr[i5];
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public int collisionCount() {
        int length = 0;
        for (Bucket bucket : this._buckets) {
            if (bucket != null) {
                length += bucket.length();
            }
        }
        return length;
    }

    public String findSymbol(char[] cArr, int i, int i2, int i4) {
        String strFind;
        if (i2 < 1) {
            return "";
        }
        if (!this._canonicalize) {
            return new String(cArr, i, i2);
        }
        int i_hashToIndex = _hashToIndex(i4);
        String str = this._symbols[i_hashToIndex];
        if (str != null) {
            if (str.length() == i2) {
                int i5 = 0;
                while (str.charAt(i5) == cArr[i + i5] && (i5 = i5 + 1) < i2) {
                }
                if (i5 == i2) {
                    return str;
                }
            }
            Bucket bucket = this._buckets[i_hashToIndex >> 1];
            if (bucket != null && (strFind = bucket.find(cArr, i, i2)) != null) {
                return strFind;
            }
        }
        if (!this._dirty) {
            copyArrays();
            this._dirty = true;
        } else if (this._size >= this._sizeThreshold) {
            rehash();
            i_hashToIndex = _hashToIndex(calcHash(cArr, i, i2));
        }
        String str2 = new String(cArr, i, i2);
        if (this._intern) {
            str2 = InternCache.instance.intern(str2);
        }
        this._size++;
        String[] strArr = this._symbols;
        if (strArr[i_hashToIndex] == null) {
            strArr[i_hashToIndex] = str2;
            return str2;
        }
        int i6 = i_hashToIndex >> 1;
        Bucket bucket2 = new Bucket(str2, this._buckets[i6]);
        this._buckets[i6] = bucket2;
        int iMax = Math.max(bucket2.length(), this._longestCollisionList);
        this._longestCollisionList = iMax;
        if (iMax > 255) {
            reportTooManyCollisions(255);
        }
        return str2;
    }

    public int hashSeed() {
        return this._hashSeed;
    }

    public CharsToNameCanonicalizer makeChild(boolean z, boolean z2) throws Throwable {
        String[] strArr;
        Bucket[] bucketArr;
        int i;
        int i2;
        int i4;
        synchronized (this) {
            try {
                strArr = this._symbols;
                bucketArr = this._buckets;
                i = this._size;
                i2 = this._hashSeed;
                i4 = this._longestCollisionList;
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        return new CharsToNameCanonicalizer(this, z, z2, strArr, bucketArr, i, i2, i4);
    }

    public int maxCollisionLength() {
        return this._longestCollisionList;
    }

    public boolean maybeDirty() {
        return this._dirty;
    }

    public void release() {
        CharsToNameCanonicalizer charsToNameCanonicalizer;
        if (maybeDirty() && (charsToNameCanonicalizer = this._parent) != null) {
            charsToNameCanonicalizer.mergeChild(this);
            this._dirty = false;
        }
    }

    public void reportTooManyCollisions(int i) {
        throw new IllegalStateException(AbstractC2322a.m1625o(new StringBuilder("Longest collision chain in symbol table (of size "), this._size, i, ") now exceeds maximum, ", " -- suspect a DoS attack based on hash collisions"));
    }

    public int size() {
        return this._size;
    }

    public static CharsToNameCanonicalizer createRoot(int i) {
        return sBootstrapSymbolTable.makeOrphan(i);
    }

    public int calcHash(String str) {
        int length = str.length();
        int iCharAt = this._hashSeed;
        for (int i = 0; i < length; i++) {
            iCharAt = (iCharAt * 33) + str.charAt(i);
        }
        if (iCharAt == 0) {
            return 1;
        }
        return iCharAt;
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2, String[] strArr, Bucket[] bucketArr, int i, int i2, int i4) {
        this._parent = charsToNameCanonicalizer;
        this._canonicalize = z;
        this._intern = z2;
        this._symbols = strArr;
        this._buckets = bucketArr;
        this._size = i;
        this._hashSeed = i2;
        int length = strArr.length;
        this._sizeThreshold = _thresholdSize(length);
        this._indexMask = length - 1;
        this._longestCollisionList = i4;
        this._dirty = false;
    }
}
