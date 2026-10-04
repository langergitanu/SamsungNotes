package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.google.firebase.messaging.Constants;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u0019\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\nJ\u001e\u0010\u0019\u001a\u00020\b2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001dH\u0086\n¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u0019\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0086\nJ\u0017\u0010\u0019\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0086\nJ\u0017\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001b\u0010#\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0002\u0010%J#\u0010#\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0013\u0010)\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u001b\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0002\u0010+J&\u0010,\u001a\u00020\b2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0.H\u0086\bø\u0001\u0000J\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0004H\u0001J\u0010\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0002\u0010%J\u0006\u00104\u001a\u00020\u0004J\u0019\u00105\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00042\u0006\u0010$\u001a\u000206H\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, m13886d2 = {"Landroidx/collection/MutableObjectFloatMap;", "K", "Landroidx/collection/ObjectFloatMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "dropDeletes", "findFirstAvailableSlot", "hash1", "findIndex", "key", "(Ljava/lang/Object;)I", "getOrPut", "", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)F", "initializeGrowth", "initializeMetadata", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", Constants.MessagePayloadKeys.FROM, "put", "value", "(Ljava/lang/Object;F)V", "default", "(Ljava/lang/Object;FF)F", "putAll", "remove", "", "(Ljava/lang/Object;F)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "resizeStorage", "newCapacity", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "trim", "writeMetadata", "", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nObjectFloatMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectFloatMap.kt\nandroidx/collection/MutableObjectFloatMap\n+ 2 RuntimeHelpers.kt\nandroidx/collection/internal/RuntimeHelpersKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 ObjectFloatMap.kt\nandroidx/collection/ObjectFloatMap\n+ 5 ScatterSet.kt\nandroidx/collection/ScatterSet\n*L\n1#1,1158:1\n46#2,5:1159\n1804#3,6:1164\n1956#3:1180\n1820#3:1184\n1956#3:1202\n1820#3:1206\n1956#3:1227\n1820#3:1231\n1780#3:1242\n1804#3,6:1243\n1792#3:1249\n1791#3,4:1250\n1804#3,6:1254\n1714#3,3:1260\n1724#3:1263\n1728#3:1264\n1925#3,3:1265\n1939#3,3:1268\n1865#3:1271\n1853#3:1272\n1847#3:1273\n1860#3:1274\n1948#3:1275\n1814#3:1276\n1770#3:1277\n1812#3:1278\n1770#3:1279\n1780#3:1280\n1804#3,6:1281\n1792#3:1287\n1791#3,4:1288\n1925#3,3:1292\n1956#3:1295\n1847#3:1296\n1770#3:1297\n1714#3,3:1298\n1724#3:1301\n1728#3:1302\n1804#3,6:1303\n1770#3:1309\n1728#3:1310\n1804#3,6:1311\n1804#3,6:1317\n1728#3:1323\n1804#3,6:1324\n1817#3:1330\n1770#3:1331\n1714#3,3:1332\n1724#3:1335\n1728#3:1336\n1780#3:1337\n1804#3,6:1338\n1792#3:1344\n1791#3,4:1345\n1804#3,6:1349\n1804#3,6:1355\n402#4,4:1170\n374#4,6:1174\n384#4,3:1181\n387#4,2:1185\n407#4,2:1187\n390#4,6:1189\n409#4:1195\n374#4,6:1196\n384#4,3:1203\n387#4,9:1207\n228#5,4:1216\n198#5,7:1220\n209#5,3:1228\n212#5,9:1232\n232#5:1241\n*S KotlinDebug\n*F\n+ 1 ObjectFloatMap.kt\nandroidx/collection/MutableObjectFloatMap\n*L\n701#1:1159,5\n729#1:1164,6\n805#1:1180\n805#1:1184\n844#1:1202\n844#1:1206\n890#1:1227\n890#1:1231\n901#1:1242\n901#1:1243,6\n901#1:1249\n901#1:1250,4\n912#1:1254,6\n926#1:1260,3\n927#1:1263\n928#1:1264\n935#1:1265,3\n936#1:1268,3\n937#1:1271\n938#1:1272\n938#1:1273\n942#1:1274\n945#1:1275\n954#1:1276\n954#1:1277\n960#1:1278\n960#1:1279\n961#1:1280\n961#1:1281,6\n961#1:1287\n961#1:1288,4\n976#1:1292,3\n977#1:1295\n979#1:1296\n1032#1:1297\n1047#1:1298,3\n1048#1:1301\n1059#1:1302\n1060#1:1303,6\n1070#1:1309\n1073#1:1310\n1074#1:1311,6\n1075#1:1317,6\n1087#1:1323\n1088#1:1324,6\n1130#1:1330\n1130#1:1331\n1132#1:1332,3\n1133#1:1335\n1135#1:1336\n1135#1:1337\n1135#1:1338,6\n1135#1:1344\n1135#1:1345,4\n1149#1:1349,6\n1155#1:1355,6\n805#1:1170,4\n805#1:1174,6\n805#1:1181,3\n805#1:1185,2\n805#1:1187,2\n805#1:1189,6\n805#1:1195\n844#1:1196,6\n844#1:1203,3\n844#1:1207,9\n890#1:1216,4\n890#1:1220,7\n890#1:1228,3\n890#1:1232,9\n890#1:1241\n*E\n"})
public final class MutableObjectFloatMap<K> extends ObjectFloatMap<K> {
    private int growthLimit;

    public MutableObjectFloatMap() {
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
        Object[] objArr = this.keys;
        float[] fArr = this.values;
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
                    Object obj = objArr[i2];
                    int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
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
                            objArr[iFindFirstAvailableSlot] = objArr[i2];
                            objArr[i2] = null;
                            fArr[iFindFirstAvailableSlot] = fArr[i2];
                            fArr[i2] = 0.0f;
                            iFindEmptySlot = i2;
                        } else {
                            jArr[i9] = (((long) (i6 & 127)) << i10) | (j2 & (~(255 << i10)));
                            if (iFindEmptySlot == -1) {
                                iFindEmptySlot = ScatterMapKt.findEmptySlot(jArr, i2 + 1, i);
                            }
                            objArr[iFindEmptySlot] = objArr[iFindFirstAvailableSlot];
                            objArr[iFindFirstAvailableSlot] = objArr[i2];
                            objArr[i2] = objArr[iFindEmptySlot];
                            fArr[iFindEmptySlot] = fArr[iFindFirstAvailableSlot];
                            fArr[iFindFirstAvailableSlot] = fArr[i2];
                            fArr[i2] = fArr[iFindEmptySlot];
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

    private final int findIndex(K key) {
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
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
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = i4;
            int i10 = i4;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j5 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = (i6 + (Long.numberOfTrailingZeros(j5) >> 3)) & i5;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], key)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i11 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i12 = iFindFirstAvailableSlot >> 3;
                long j6 = jArr2[i12];
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i11 - (((j6 >> i13) & 255) == 128 ? 1 : 0);
                int i14 = this._capacity;
                long j7 = ((~(255 << i13)) & j6) | (j2 << i13);
                jArr2[i12] = j7;
                jArr2[(((iFindFirstAvailableSlot - 7) & i14) + (i14 & 7)) >> 3] = j7;
                return ~iFindFirstAvailableSlot;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
            i4 = i10;
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
        this.keys = new Object[iMax];
        this.values = new float[iMax];
    }

    private final void resizeStorage(int newCapacity) {
        int i;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        int i2 = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.keys;
        float[] fArr2 = this.values;
        int i4 = this._capacity;
        int i5 = 0;
        while (i5 < i2) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i6 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i6 >>> 7);
                i = i5;
                long j = i6 & 127;
                int i7 = iFindFirstAvailableSlot >> 3;
                int i8 = (iFindFirstAvailableSlot & 7) << 3;
                long j2 = (j << i8) | (jArr2[i7] & (~(255 << i8)));
                jArr2[i7] = j2;
                jArr2[(((iFindFirstAvailableSlot - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr2[iFindFirstAvailableSlot] = obj;
                fArr2[iFindFirstAvailableSlot] = fArr[i];
            } else {
                i = i5;
            }
            i5 = i + 1;
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
        ArraysKt___ArraysJvmKt.fill(this.keys, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final float getOrPut(K key, @NotNull Function0<Float> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        float fFloatValue = defaultValue.invoke().floatValue();
        set(key, fFloatValue);
        return fFloatValue;
    }

    public final void minusAssign(K key) {
        remove(key);
    }

    public final void plusAssign(@NotNull ObjectFloatMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void put(K key, float value) {
        set(key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(@NotNull ObjectFloatMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Object[] objArr = from.keys;
        float[] fArr = from.values;
        long[] jArr = from.metadata;
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
                        set(objArr[i5], fArr[i5]);
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

    public final void remove(K key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            removeValueAt(iFindKeyIndex);
        }
    }

    public final void removeIf(@NotNull Function2<? super K, ? super Float, Boolean> predicate) {
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
                        if (predicate.invoke(this.keys[i5], Float.valueOf(this.values[i5])).booleanValue()) {
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
        this.keys[index] = null;
    }

    public final void set(K key, float value) {
        int iFindIndex = findIndex(key);
        if (iFindIndex < 0) {
            iFindIndex = ~iFindIndex;
        }
        this.keys[iFindIndex] = key;
        this.values[iFindIndex] = value;
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

    public /* synthetic */ MutableObjectFloatMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull K[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final float put(K key, float value, float f) {
        int iFindIndex = findIndex(key);
        if (iFindIndex < 0) {
            iFindIndex = ~iFindIndex;
        } else {
            f = this.values[iFindIndex];
        }
        this.keys[iFindIndex] = key;
        this.values[iFindIndex] = value;
        return f;
    }

    public MutableObjectFloatMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final boolean remove(K key, float value) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != value) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(@NotNull Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void minusAssign(@NotNull Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Object[] objArr = keys.elements;
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
                        remove(objArr[(i << 3) + i4]);
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
}
