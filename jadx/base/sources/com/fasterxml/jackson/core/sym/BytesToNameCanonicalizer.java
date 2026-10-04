package com.fasterxml.jackson.core.sym;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class BytesToNameCanonicalizer {
    protected static final int DEFAULT_TABLE_SIZE = 64;
    static final int INITIAL_COLLISION_LEN = 32;
    static final int LAST_VALID_BUCKET = 254;
    static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
    static final int MAX_COLL_CHAIN_LENGTH = 255;
    static final int MAX_ENTRIES_FOR_REUSE = 6000;
    protected static final int MAX_TABLE_SIZE = 65536;
    static final int MIN_HASH_SIZE = 16;
    private static final int MULT = 33;
    private static final int MULT2 = 65599;
    private static final int MULT3 = 31;
    protected int _collCount;
    protected int _collEnd;
    protected Bucket[] _collList;
    private boolean _collListShared;
    protected int _count;
    private final int _hashSeed;
    protected final boolean _intern;
    protected int _longestCollisionList;
    protected int[] _mainHash;
    protected int _mainHashMask;
    private boolean _mainHashShared;
    protected Name[] _mainNames;
    private boolean _mainNamesShared;
    private transient boolean _needRehash;
    protected final BytesToNameCanonicalizer _parent;
    protected final AtomicReference<TableInfo> _tableInfo;

    private BytesToNameCanonicalizer(int i, boolean z, int i2) {
        this._parent = null;
        this._hashSeed = i2;
        this._intern = z;
        int i4 = 16;
        if (i < 16) {
            i = i4;
        } else if (((i - 1) & i) != 0) {
            while (i4 < i) {
                i4 += i4;
            }
            i = i4;
        }
        this._tableInfo = new AtomicReference<>(initTableInfo(i));
    }

    private void _addSymbol(int i, Name name) {
        int iFindBestBucket;
        if (this._mainHashShared) {
            unshareMain();
        }
        if (this._needRehash) {
            rehash();
        }
        this._count++;
        int i2 = this._mainHashMask & i;
        if (this._mainNames[i2] == null) {
            this._mainHash[i2] = i << 8;
            if (this._mainNamesShared) {
                unshareNames();
            }
            this._mainNames[i2] = name;
        } else {
            if (this._collListShared) {
                unshareCollision();
            }
            this._collCount++;
            int i4 = this._mainHash[i2];
            int i5 = i4 & 255;
            if (i5 == 0) {
                iFindBestBucket = this._collEnd;
                if (iFindBestBucket <= 254) {
                    this._collEnd = iFindBestBucket + 1;
                    if (iFindBestBucket >= this._collList.length) {
                        expandCollision();
                    }
                } else {
                    iFindBestBucket = findBestBucket();
                }
                this._mainHash[i2] = (i4 & (-256)) | (iFindBestBucket + 1);
            } else {
                iFindBestBucket = i5 - 1;
            }
            Bucket bucket = new Bucket(name, this._collList[iFindBestBucket]);
            this._collList[iFindBestBucket] = bucket;
            int iMax = Math.max(bucket.length(), this._longestCollisionList);
            this._longestCollisionList = iMax;
            if (iMax > 255) {
                reportTooManyCollisions(255);
            }
        }
        int length = this._mainHash.length;
        int i6 = this._count;
        if (i6 > (length >> 1)) {
            int i7 = length >> 2;
            if (i6 > length - i7) {
                this._needRehash = true;
            } else if (this._collCount >= i7) {
                this._needRehash = true;
            }
        }
    }

    public static int[] calcQuads(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[(length + 3) / 4];
        int i = 0;
        while (i < length) {
            int i2 = bArr[i] & 255;
            int i4 = i + 1;
            if (i4 < length) {
                i2 = (i2 << 8) | (bArr[i4] & 255);
                i4 = i + 2;
                if (i4 < length) {
                    i2 = (i2 << 8) | (bArr[i4] & 255);
                    i4 = i + 3;
                    if (i4 < length) {
                        i2 = (bArr[i4] & 255) | (i2 << 8);
                    }
                }
            }
            iArr[i4 >> 2] = i2;
            i = i4 + 1;
        }
        return iArr;
    }

    private static Name constructName(int i, String str, int i2, int i4) {
        return i4 == 0 ? new Name1(str, i, i2) : new Name2(str, i, i2, i4);
    }

    public static BytesToNameCanonicalizer createRoot() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return createRoot((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }

    private void expandCollision() {
        Bucket[] bucketArr = this._collList;
        int length = bucketArr.length;
        Bucket[] bucketArr2 = new Bucket[length + length];
        this._collList = bucketArr2;
        System.arraycopy(bucketArr, 0, bucketArr2, 0, length);
    }

    private int findBestBucket() {
        Bucket[] bucketArr = this._collList;
        int i = this._collEnd;
        int i2 = Integer.MAX_VALUE;
        int i4 = -1;
        for (int i5 = 0; i5 < i; i5++) {
            int length = bucketArr[i5].length();
            if (length < i2) {
                if (length == 1) {
                    return i5;
                }
                i4 = i5;
                i2 = length;
            }
        }
        return i4;
    }

    public static Name getEmptyName() {
        return Name1.getEmptyName();
    }

    private TableInfo initTableInfo(int i) {
        return new TableInfo(0, i - 1, new int[i], new Name[i], null, 0, 0, 0);
    }

    private void mergeChild(TableInfo tableInfo) {
        int i = tableInfo.count;
        TableInfo tableInfo2 = this._tableInfo.get();
        if (i <= tableInfo2.count) {
            return;
        }
        if (i > 6000 || tableInfo.longestCollisionList > 63) {
            tableInfo = initTableInfo(64);
        }
        AtomicReference<TableInfo> atomicReference = this._tableInfo;
        while (!atomicReference.compareAndSet(tableInfo2, tableInfo) && atomicReference.get() == tableInfo2) {
        }
    }

    private void nukeSymbols() {
        this._count = 0;
        this._longestCollisionList = 0;
        Arrays.fill(this._mainHash, 0);
        Arrays.fill(this._mainNames, (Object) null);
        Arrays.fill(this._collList, (Object) null);
        this._collCount = 0;
        this._collEnd = 0;
    }

    private void rehash() {
        int iFindBestBucket;
        this._needRehash = false;
        this._mainNamesShared = false;
        int length = this._mainHash.length;
        int i = length + length;
        if (i > 65536) {
            nukeSymbols();
            return;
        }
        this._mainHash = new int[i];
        this._mainHashMask = i - 1;
        Name[] nameArr = this._mainNames;
        this._mainNames = new Name[i];
        int i2 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            Name name = nameArr[i4];
            if (name != null) {
                i2++;
                int iHashCode = name.hashCode();
                int i5 = this._mainHashMask & iHashCode;
                this._mainNames[i5] = name;
                this._mainHash[i5] = iHashCode << 8;
            }
        }
        int i6 = this._collEnd;
        if (i6 == 0) {
            this._longestCollisionList = 0;
            return;
        }
        this._collCount = 0;
        this._collEnd = 0;
        this._collListShared = false;
        Bucket[] bucketArr = this._collList;
        this._collList = new Bucket[bucketArr.length];
        int iMax = 0;
        for (int i7 = 0; i7 < i6; i7++) {
            for (Bucket bucket = bucketArr[i7]; bucket != null; bucket = bucket._next) {
                i2++;
                Name name2 = bucket._name;
                int iHashCode2 = name2.hashCode();
                int i8 = this._mainHashMask & iHashCode2;
                int[] iArr = this._mainHash;
                int i9 = iArr[i8];
                Name[] nameArr2 = this._mainNames;
                if (nameArr2[i8] == null) {
                    iArr[i8] = iHashCode2 << 8;
                    nameArr2[i8] = name2;
                } else {
                    this._collCount++;
                    int i10 = i9 & 255;
                    if (i10 == 0) {
                        iFindBestBucket = this._collEnd;
                        if (iFindBestBucket <= 254) {
                            this._collEnd = iFindBestBucket + 1;
                            if (iFindBestBucket >= this._collList.length) {
                                expandCollision();
                            }
                        } else {
                            iFindBestBucket = findBestBucket();
                        }
                        this._mainHash[i8] = (i9 & (-256)) | (iFindBestBucket + 1);
                    } else {
                        iFindBestBucket = i10 - 1;
                    }
                    Bucket bucket2 = new Bucket(name2, this._collList[iFindBestBucket]);
                    this._collList[iFindBestBucket] = bucket2;
                    iMax = Math.max(iMax, bucket2.length());
                }
            }
        }
        this._longestCollisionList = iMax;
        if (i2 == this._count) {
            return;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i2, "Internal error: count after rehash ", "; should be ");
        sbM778t.append(this._count);
        throw new RuntimeException(sbM778t.toString());
    }

    private void unshareCollision() {
        Bucket[] bucketArr = this._collList;
        if (bucketArr == null) {
            this._collList = new Bucket[32];
        } else {
            int length = bucketArr.length;
            Bucket[] bucketArr2 = new Bucket[length];
            this._collList = bucketArr2;
            System.arraycopy(bucketArr, 0, bucketArr2, 0, length);
        }
        this._collListShared = false;
    }

    private void unshareMain() {
        int[] iArr = this._mainHash;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this._mainHash = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this._mainHashShared = false;
    }

    private void unshareNames() {
        Name[] nameArr = this._mainNames;
        int length = nameArr.length;
        Name[] nameArr2 = new Name[length];
        this._mainNames = nameArr2;
        System.arraycopy(nameArr, 0, nameArr2, 0, length);
        this._mainNamesShared = false;
    }

    public Name addName(String str, int i, int i2) {
        if (this._intern) {
            str = InternCache.instance.intern(str);
        }
        int iCalcHash = i2 == 0 ? calcHash(i) : calcHash(i, i2);
        Name nameConstructName = constructName(iCalcHash, str, i, i2);
        _addSymbol(iCalcHash, nameConstructName);
        return nameConstructName;
    }

    public int bucketCount() {
        return this._mainHash.length;
    }

    public int calcHash(int i) {
        int i2 = i ^ this._hashSeed;
        int i4 = i2 + (i2 >>> 15);
        return i4 ^ (i4 >>> 9);
    }

    public int collisionCount() {
        return this._collCount;
    }

    public Name findName(int i) {
        int iCalcHash = calcHash(i);
        int i2 = this._mainHashMask & iCalcHash;
        int i4 = this._mainHash[i2];
        if ((((i4 >> 8) ^ iCalcHash) << 8) == 0) {
            Name name = this._mainNames[i2];
            if (name == null) {
                return null;
            }
            if (name.equals(i)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & 255;
        if (i5 > 0) {
            Bucket bucket = this._collList[i5 - 1];
            if (bucket != null) {
                return bucket.find(iCalcHash, i, 0);
            }
        }
        return null;
    }

    public int hashSeed() {
        return this._hashSeed;
    }

    public BytesToNameCanonicalizer makeChild(boolean z, boolean z2) {
        return new BytesToNameCanonicalizer(this, z2, this._hashSeed, this._tableInfo.get());
    }

    public int maxCollisionLength() {
        return this._longestCollisionList;
    }

    public boolean maybeDirty() {
        return !this._mainHashShared;
    }

    public void release() {
        if (this._parent == null || !maybeDirty()) {
            return;
        }
        this._parent.mergeChild(new TableInfo(this));
        this._mainHashShared = true;
        this._mainNamesShared = true;
        this._collListShared = true;
    }

    public void reportTooManyCollisions(int i) {
        throw new IllegalStateException(AbstractC2322a.m1625o(new StringBuilder("Longest collision chain in symbol table (of size "), this._count, i, ") now exceeds maximum, ", " -- suspect a DoS attack based on hash collisions"));
    }

    public int size() {
        AtomicReference<TableInfo> atomicReference = this._tableInfo;
        return atomicReference != null ? atomicReference.get().count : this._count;
    }

    public int calcHash(int i, int i2) {
        int i4 = this._hashSeed ^ ((i2 * 33) + (i ^ (i >>> 15)));
        return i4 + (i4 >>> 7);
    }

    private static Name constructName(int i, String str, int[] iArr, int i2) {
        if (i2 < 4) {
            if (i2 == 1) {
                return new Name1(str, i, iArr[0]);
            }
            if (i2 == 2) {
                return new Name2(str, i, iArr[0], iArr[1]);
            }
            if (i2 == 3) {
                return new Name3(str, i, iArr[0], iArr[1], iArr[2]);
            }
        }
        int[] iArr2 = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            iArr2[i4] = iArr[i4];
        }
        return new NameN(str, i, iArr2, i2);
    }

    public static BytesToNameCanonicalizer createRoot(int i) {
        return new BytesToNameCanonicalizer(64, true, i);
    }

    public int calcHash(int[] iArr, int i) {
        if (i >= 3) {
            int i2 = iArr[0] ^ this._hashSeed;
            int i4 = (((i2 + (i2 >>> 9)) * 33) + iArr[1]) * MULT2;
            int i5 = (i4 + (i4 >>> 15)) ^ iArr[2];
            int i6 = i5 + (i5 >>> 17);
            for (int i7 = 3; i7 < i; i7++) {
                int i8 = (i6 * 31) ^ iArr[i7];
                int i9 = i8 + (i8 >>> 3);
                i6 = i9 ^ (i9 << 7);
            }
            int i10 = i6 + (i6 >>> 15);
            return (i10 << 9) ^ i10;
        }
        throw new IllegalArgumentException();
    }

    private BytesToNameCanonicalizer(BytesToNameCanonicalizer bytesToNameCanonicalizer, boolean z, int i, TableInfo tableInfo) {
        this._parent = bytesToNameCanonicalizer;
        this._hashSeed = i;
        this._intern = z;
        this._tableInfo = null;
        this._count = tableInfo.count;
        this._mainHashMask = tableInfo.mainHashMask;
        this._mainHash = tableInfo.mainHash;
        this._mainNames = tableInfo.mainNames;
        this._collList = tableInfo.collList;
        this._collCount = tableInfo.collCount;
        this._collEnd = tableInfo.collEnd;
        this._longestCollisionList = tableInfo.longestCollisionList;
        this._needRehash = false;
        this._mainHashShared = true;
        this._mainNamesShared = true;
        this._collListShared = true;
    }

    public Name addName(String str, int[] iArr, int i) {
        int iCalcHash;
        if (this._intern) {
            str = InternCache.instance.intern(str);
        }
        if (i < 3) {
            iCalcHash = i == 1 ? calcHash(iArr[0]) : calcHash(iArr[0], iArr[1]);
        } else {
            iCalcHash = calcHash(iArr, i);
        }
        Name nameConstructName = constructName(iCalcHash, str, iArr, i);
        _addSymbol(iCalcHash, nameConstructName);
        return nameConstructName;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Bucket {
        private final int _length;
        protected final Name _name;
        protected final Bucket _next;

        public Bucket(Name name, Bucket bucket) {
            this._name = name;
            this._next = bucket;
            this._length = bucket != null ? 1 + bucket._length : 1;
        }

        public Name find(int i, int i2, int i4) {
            if (this._name.hashCode() == i && this._name.equals(i2, i4)) {
                return this._name;
            }
            for (Bucket bucket = this._next; bucket != null; bucket = bucket._next) {
                Name name = bucket._name;
                if (name.hashCode() == i && name.equals(i2, i4)) {
                    return name;
                }
            }
            return null;
        }

        public int length() {
            return this._length;
        }

        public Name find(int i, int[] iArr, int i2) {
            if (this._name.hashCode() == i && this._name.equals(iArr, i2)) {
                return this._name;
            }
            for (Bucket bucket = this._next; bucket != null; bucket = bucket._next) {
                Name name = bucket._name;
                if (name.hashCode() == i && name.equals(iArr, i2)) {
                    return name;
                }
            }
            return null;
        }
    }

    public Name findName(int i, int i2) {
        int iCalcHash = i2 == 0 ? calcHash(i) : calcHash(i, i2);
        int i4 = this._mainHashMask & iCalcHash;
        int i5 = this._mainHash[i4];
        if ((((i5 >> 8) ^ iCalcHash) << 8) == 0) {
            Name name = this._mainNames[i4];
            if (name == null) {
                return null;
            }
            if (name.equals(i, i2)) {
                return name;
            }
        } else if (i5 == 0) {
            return null;
        }
        int i6 = i5 & 255;
        if (i6 > 0) {
            Bucket bucket = this._collList[i6 - 1];
            if (bucket != null) {
                return bucket.find(iCalcHash, i, i2);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TableInfo {
        public final int collCount;
        public final int collEnd;
        public final Bucket[] collList;
        public final int count;
        public final int longestCollisionList;
        public final int[] mainHash;
        public final int mainHashMask;
        public final Name[] mainNames;

        public TableInfo(int i, int i2, int[] iArr, Name[] nameArr, Bucket[] bucketArr, int i4, int i5, int i6) {
            this.count = i;
            this.mainHashMask = i2;
            this.mainHash = iArr;
            this.mainNames = nameArr;
            this.collList = bucketArr;
            this.collCount = i4;
            this.collEnd = i5;
            this.longestCollisionList = i6;
        }

        public TableInfo(BytesToNameCanonicalizer bytesToNameCanonicalizer) {
            this.count = bytesToNameCanonicalizer._count;
            this.mainHashMask = bytesToNameCanonicalizer._mainHashMask;
            this.mainHash = bytesToNameCanonicalizer._mainHash;
            this.mainNames = bytesToNameCanonicalizer._mainNames;
            this.collList = bytesToNameCanonicalizer._collList;
            this.collCount = bytesToNameCanonicalizer._collCount;
            this.collEnd = bytesToNameCanonicalizer._collEnd;
            this.longestCollisionList = bytesToNameCanonicalizer._longestCollisionList;
        }
    }

    public Name findName(int[] iArr, int i) {
        if (i < 3) {
            return findName(iArr[0], i >= 2 ? iArr[1] : 0);
        }
        int iCalcHash = calcHash(iArr, i);
        int i2 = this._mainHashMask & iCalcHash;
        int i4 = this._mainHash[i2];
        if ((((i4 >> 8) ^ iCalcHash) << 8) == 0) {
            Name name = this._mainNames[i2];
            if (name == null || name.equals(iArr, i)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & 255;
        if (i5 > 0) {
            Bucket bucket = this._collList[i5 - 1];
            if (bucket != null) {
                return bucket.find(iCalcHash, iArr, i);
            }
        }
        return null;
    }
}
