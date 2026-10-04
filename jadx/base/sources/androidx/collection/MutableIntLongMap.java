package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.google.firebase.messaging.Constants;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\bø\u0001\u0000J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0019H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0001H\u0086\nJ\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fJ\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fJ&\u0010#\u001a\u00020\u00072\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"0%H\u0086\bø\u0001\u0000J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0003H\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0086\u0002J\u0006\u0010+\u001a\u00020\u0003J\u0019\u0010,\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0082\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, m13886d2 = {"Landroidx/collection/MutableIntLongMap;", "Landroidx/collection/IntLongMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "dropDeletes", "findFirstAvailableSlot", "hash1", "findInsertIndex", "key", "getOrPut", "", "defaultValue", "Lkotlin/Function0;", "initializeGrowth", "initializeMetadata", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "initializeStorage", "minusAssign", "keys", "Landroidx/collection/IntList;", "Landroidx/collection/IntSet;", "", "plusAssign", Constants.MessagePayloadKeys.FROM, "put", "value", "default", "putAll", "remove", "", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "trim", "writeMetadata", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntLongMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntLongMap.kt\nandroidx/collection/MutableIntLongMap\n+ 2 RuntimeHelpers.kt\nandroidx/collection/internal/RuntimeHelpersKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 IntLongMap.kt\nandroidx/collection/IntLongMap\n+ 5 IntSet.kt\nandroidx/collection/IntSet\n+ 6 IntList.kt\nandroidx/collection/IntList\n+ 7 IntSet.kt\nandroidx/collection/IntSetKt\n*L\n1#1,1131:1\n46#2,5:1132\n1804#3,6:1137\n1956#3:1153\n1820#3:1157\n1956#3:1175\n1820#3:1179\n1956#3:1200\n1820#3:1204\n1780#3:1222\n1804#3,6:1223\n1792#3:1229\n1791#3,4:1230\n1804#3,6:1234\n1724#3:1243\n1728#3:1244\n1925#3,3:1245\n1939#3,3:1248\n1865#3:1251\n1853#3:1252\n1847#3:1253\n1860#3:1254\n1948#3:1255\n1814#3:1256\n1770#3:1257\n1812#3:1258\n1770#3:1259\n1780#3:1260\n1804#3,6:1261\n1792#3:1267\n1791#3,4:1268\n1925#3,3:1272\n1956#3:1275\n1847#3:1276\n1770#3:1277\n1724#3:1281\n1728#3:1282\n1804#3,6:1283\n1770#3:1289\n1728#3:1290\n1804#3,6:1291\n1804#3,6:1297\n1728#3:1303\n1804#3,6:1304\n1817#3:1310\n1770#3:1311\n1724#3:1315\n1728#3:1316\n1780#3:1317\n1804#3,6:1318\n1792#3:1324\n1791#3,4:1325\n1804#3,6:1329\n1804#3,6:1335\n386#4,4:1143\n358#4,6:1147\n368#4,3:1154\n371#4,2:1158\n390#4,2:1160\n374#4,6:1162\n392#4:1168\n358#4,6:1169\n368#4,3:1176\n371#4,9:1180\n262#5,4:1189\n232#5,7:1193\n243#5,3:1201\n246#5,2:1205\n266#5,2:1207\n249#5,6:1209\n268#5:1215\n250#6,6:1216\n921#7,3:1240\n921#7,3:1278\n921#7,3:1312\n*S KotlinDebug\n*F\n+ 1 IntLongMap.kt\nandroidx/collection/MutableIntLongMap\n*L\n684#1:1132,5\n712#1:1137,6\n790#1:1153\n790#1:1157\n829#1:1175\n829#1:1179\n856#1:1200\n856#1:1204\n876#1:1222\n876#1:1223,6\n876#1:1229\n876#1:1230,4\n886#1:1234,6\n900#1:1243\n901#1:1244\n908#1:1245,3\n909#1:1248,3\n910#1:1251\n911#1:1252\n911#1:1253\n915#1:1254\n918#1:1255\n927#1:1256\n927#1:1257\n933#1:1258\n933#1:1259\n934#1:1260\n934#1:1261,6\n934#1:1267\n934#1:1268,4\n949#1:1272,3\n950#1:1275\n952#1:1276\n1005#1:1277\n1021#1:1281\n1032#1:1282\n1033#1:1283,6\n1043#1:1289\n1046#1:1290\n1047#1:1291,6\n1048#1:1297,6\n1060#1:1303\n1061#1:1304,6\n1103#1:1310\n1103#1:1311\n1106#1:1315\n1108#1:1316\n1108#1:1317\n1108#1:1318,6\n1108#1:1324\n1108#1:1325,4\n1122#1:1329,6\n1128#1:1335,6\n790#1:1143,4\n790#1:1147,6\n790#1:1154,3\n790#1:1158,2\n790#1:1160,2\n790#1:1162,6\n790#1:1168\n829#1:1169,6\n829#1:1176,3\n829#1:1180,9\n856#1:1189,4\n856#1:1193,7\n856#1:1201,3\n856#1:1205,2\n856#1:1207,2\n856#1:1209,6\n856#1:1215\n865#1:1216,6\n899#1:1240,3\n1020#1:1278,3\n1105#1:1312,3\n*E\n"})
public final class MutableIntLongMap extends IntLongMap {
    private int growthLimit;

    public MutableIntLongMap() {
        this(0, 1, null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compareUnsigned(AbstractC0622a.m1161g(this._size, 32L), AbstractC0622a.m1161g(this._capacity, 25L)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes();
        }
    }

    private final void dropDeletes() {
        long[] jArr = this.metadata;
        int i = this._capacity;
        int[] iArr = this.keys;
        long[] jArr2 = this.values;
        ScatterMapKt.convertMetadataForCleanup(jArr, i);
        int i2 = 0;
        int iFindEmptySlot = -1;
        while (i2 != i) {
            int i4 = i2 >> 3;
            int i5 = (i2 & 7) << 3;
            long j = (jArr[i4] >> i5) & 255;
            if (j == 128) {
                iFindEmptySlot = i2;
                i2++;
            } else {
                if (j == 254) {
                    int iHashCode = Integer.hashCode(iArr[i2]) * ScatterMapKt.MurmurHashC1;
                    int i6 = iHashCode ^ (iHashCode << 16);
                    int i7 = i6 >>> 7;
                    int iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                    int i8 = i7 & i;
                    if (((iFindFirstAvailableSlot - i8) & i) / 8 == ((i2 - i8) & i) / 8) {
                        jArr[i4] = (((long) (i6 & 127)) << i5) | ((~(255 << i5)) & jArr[i4]);
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i9 = iFindFirstAvailableSlot >> 3;
                        long j2 = jArr[i9];
                        int i10 = (iFindFirstAvailableSlot & 7) << 3;
                        if (((j2 >> i10) & 255) == 128) {
                            jArr[i9] = (j2 & (~(255 << i10))) | (((long) (i6 & 127)) << i10);
                            jArr[i4] = (jArr[i4] & (~(255 << i5))) | (128 << i5);
                            iArr[iFindFirstAvailableSlot] = iArr[i2];
                            iArr[i2] = 0;
                            jArr2[iFindFirstAvailableSlot] = jArr2[i2];
                            jArr2[i2] = 0;
                            iFindEmptySlot = i2;
                        } else {
                            jArr[i9] = (((long) (i6 & 127)) << i10) | (j2 & (~(255 << i10)));
                            if (iFindEmptySlot == -1) {
                                iFindEmptySlot = ScatterMapKt.findEmptySlot(jArr, i2 + 1, i);
                            }
                            iArr[iFindEmptySlot] = iArr[iFindFirstAvailableSlot];
                            iArr[iFindFirstAvailableSlot] = iArr[i2];
                            iArr[i2] = iArr[iFindEmptySlot];
                            jArr2[iFindEmptySlot] = jArr2[iFindFirstAvailableSlot];
                            jArr2[iFindFirstAvailableSlot] = jArr2[i2];
                            jArr2[i2] = jArr2[iFindEmptySlot];
                            i2--;
                        }
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    }
                }
                i2++;
            }
        }
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i2 = hash1 & i;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i2 >> 3;
            int i6 = (i2 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i2 + (Long.numberOfTrailingZeros(j2) >> 3)) & i;
            }
            i4 += 8;
            i2 = (i2 + i4) & i;
        }
    }

    private final int findInsertIndex(int key) {
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i4 = i & 127;
        int i5 = this._capacity;
        int i6 = i2 & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            int i10 = 1;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = i4;
            int i11 = i7;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            long j5 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (j5 != 0) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i6) & i5;
                int i12 = i10;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
                j5 &= j5 - 1;
                i10 = i12;
            }
            int i13 = i10;
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i14 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i15 = iFindFirstAvailableSlot >> 3;
                long j6 = jArr2[i15];
                int i16 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i14 - (((j6 >> i16) & 255) == 128 ? i13 : 0);
                int i17 = this._capacity;
                long j7 = ((~(255 << i16)) & j6) | (j2 << i16);
                jArr2[i15] = j7;
                jArr2[(((iFindFirstAvailableSlot - 7) & i17) + (i17 & 7)) >> 3] = j7;
                return ~iFindFirstAvailableSlot;
            }
            i7 = i11 + 8;
            i6 = (i6 + i7) & i5;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        int i = capacity >> 3;
        long j = 255 << ((capacity & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = new int[iMax];
        this.values = new long[iMax];
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr;
        MutableIntLongMap mutableIntLongMap = this;
        long[] jArr2 = mutableIntLongMap.metadata;
        int[] iArr = mutableIntLongMap.keys;
        long[] jArr3 = mutableIntLongMap.values;
        int i = mutableIntLongMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr4 = mutableIntLongMap.metadata;
        int[] iArr2 = mutableIntLongMap.keys;
        long[] jArr5 = mutableIntLongMap.values;
        int i2 = mutableIntLongMap._capacity;
        int i4 = 0;
        while (i4 < i) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                int i5 = iArr[i4];
                int iHashCode = Integer.hashCode(i5) * ScatterMapKt.MurmurHashC1;
                int i6 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = mutableIntLongMap.findFirstAvailableSlot(i6 >>> 7);
                long j = i6 & 127;
                int i7 = iFindFirstAvailableSlot >> 3;
                int i8 = (iFindFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                long j2 = (jArr4[i7] & (~(255 << i8))) | (j << i8);
                jArr4[i7] = j2;
                jArr4[(((iFindFirstAvailableSlot - 7) & i2) + (i2 & 7)) >> 3] = j2;
                iArr2[iFindFirstAvailableSlot] = i5;
                jArr5[iFindFirstAvailableSlot] = jArr3[i4];
            } else {
                jArr = jArr2;
            }
            i4++;
            mutableIntLongMap = this;
            jArr2 = jArr;
        }
    }

    private final void writeMetadata(int index, long value) {
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (value << i2);
        int i4 = this._capacity;
        int i5 = ((index - 7) & i4) + (i4 & 7);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (value << i7) | (jArr[i6] & (~(255 << i7)));
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            ArraysKt___ArraysJvmKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        initializeGrowth();
    }

    public final long getOrPut(int key, @NotNull Function0<Long> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        long jLongValue = defaultValue.invoke().longValue();
        put(key, jLongValue);
        return jLongValue;
    }

    public final void minusAssign(int key) {
        remove(key);
    }

    public final void plusAssign(@NotNull IntLongMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void put(int key, long value) {
        set(key, value);
    }

    public final void putAll(@NotNull IntLongMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int[] iArr = from.keys;
        long[] jArr = from.values;
        long[] jArr2 = from.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        set(iArr[i5], jArr[i5]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void remove(int key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            removeValueAt(iFindKeyIndex);
        }
    }

    public final void removeIf(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        if (predicate.invoke(Integer.valueOf(this.keys[i5]), Long.valueOf(this.values[i5])).booleanValue()) {
                            removeValueAt(i5);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @PublishedApi
    public final void removeValueAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i2 = index >> 3;
        int i4 = (index & 7) << 3;
        long j = (jArr[i2] & (~(255 << i4))) | (254 << i4);
        jArr[i2] = j;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j;
    }

    public final void set(int key, long value) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        this.keys[iFindInsertIndex] = key;
        this.values[iFindInsertIndex] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i - this._capacity;
    }

    public /* synthetic */ MutableIntLongMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull int[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (int i : keys) {
            remove(i);
        }
    }

    public final long put(int key, long value, long j) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        } else {
            j = this.values[iFindInsertIndex];
        }
        this.keys[iFindInsertIndex] = key;
        this.values[iFindInsertIndex] = value;
        return j;
    }

    public MutableIntLongMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final boolean remove(int key, long value) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != value) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(@NotNull IntSet keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        int[] iArr = keys.elements;
        long[] jArr = keys.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        remove(iArr[(i << 3) + i4]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void minusAssign(@NotNull IntList keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        int[] iArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(iArr[i2]);
        }
    }
}
