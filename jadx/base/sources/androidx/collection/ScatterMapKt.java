package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import io.netty.handler.ssl.ApplicationProtocolNames;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a\u001e\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d\u001a \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0000\u001a\u001d\u0010!\u001a\u00060\u0001j\u0002`\"2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\bH\u0080\b\u001a\u0011\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0080\b\u001a\u0011\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0080\b\u001a\u0013\u0010%\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0080\b\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010*\u001a\u00020\bH\u0080\b\u001a\u0019\u0010+\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010*\u001a\u00020\bH\u0080\b\u001a\u0011\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0001H\u0081\b\u001a\u0019\u0010,\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010*\u001a\u00020\bH\u0080\b\u001a\u0010\u0010.\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u000f\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d\u001aO\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u000f\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d2*\u00100\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0201\"\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d02¢\u0006\u0002\u00103\u001a\u0010\u00104\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a\u0010\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0000\u001a\u0019\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\r2\u0006\u0010#\u001a\u00020\bH\u0081\b\u001a\u0010\u00109\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a)\u0010:\u001a\u00020\u00172\u0006\u00108\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0001H\u0080\b\u001a!\u0010;\u001a\u00020\u00172\u0006\u00108\u001a\u00020\r2\u0006\u0010#\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010<\u001a\u00020\b*\u00060\u0001j\u0002`=H\u0080\b\u001a\u0011\u0010>\u001a\u00020)*\u00060\u0001j\u0002`=H\u0080\b\u001a\u0011\u0010?\u001a\u00020\b*\u00060\u0001j\u0002`@H\u0081\b\u001a\u0015\u0010A\u001a\u00060\u0001j\u0002`=*\u00060\u0001j\u0002`\"H\u0080\b\u001a\u0015\u0010B\u001a\u00060\u0001j\u0002`=*\u00060\u0001j\u0002`\"H\u0081\b\u001a\u001d\u0010C\u001a\u00060\u0001j\u0002`=*\u00060\u0001j\u0002`\"2\u0006\u0010D\u001a\u00020\bH\u0081\b\u001a\u0011\u0010E\u001a\u00020\u0001*\u00060\u0001j\u0002`=H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0004*\f\b\u0000\u0010F\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010G\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010H\"\u00020\u00012\u00020\u0001¨\u0006I"}, m13886d2 = {"AllEmpty", "", "BitmaskLsb", "getBitmaskLsb$annotations", "()V", "BitmaskMsb", "getBitmaskMsb$annotations", "ClonedMetadataCount", "", "DefaultScatterCapacity", "Deleted", "Empty", "EmptyGroup", "", "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", "", "", "GroupWidth", "MurmurHashC1", "Sentinel", "getSentinel$annotations", "convertMetadataForCleanup", "", GroupContract.Group.META_DATA, ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "emptyScatterMap", "Landroidx/collection/ScatterMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "findEmptySlot", "start", "end", "group", "Landroidx/collection/Group;", TypedValues.Cycle.S_WAVE_OFFSET, "h1", "hash", ApplicationProtocolNames.HTTP_2, "k", "isDeleted", "", "index", "isEmpty", "isFull", "value", "loadedCapacity", "mutableScatterMapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/collection/MutableScatterMap;", "nextCapacity", "normalizeCapacity", "n", "readRawMetadata", "data", "unloadedCapacity", "writeMetadata", "writeRawMetadata", "get", "Landroidx/collection/Bitmask;", "hasNext", "lowestBitSet", "Landroidx/collection/StaticBitmask;", "maskEmpty", "maskEmptyOrDeleted", "match", "m", "next", "Bitmask", "Group", "StaticBitmask", "collection"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1980:1\n1770#1:1981\n1804#1,6:1982\n1770#1:1988\n1770#1:1989\n1770#1:1990\n1847#1:1991\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1701#1:1981\n1780#1:1982,6\n1812#1:1988\n1814#1:1989\n1817#1:1990\n1853#1:1991\n*E\n"})
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;

    @JvmField
    @NotNull
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};

    @NotNull
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final void convertMetadataForCleanup(@NotNull long[] metadata, int i) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i2 = (i + 7) >> 3;
        for (int i4 = 0; i4 < i2; i4++) {
            long j = metadata[i4] & (-9187201950435737472L);
            metadata[i4] = (-72340172838076674L) & ((~j) + (j >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(metadata);
        int i5 = lastIndex - 1;
        metadata[i5] = (metadata[i5] & 72057594037927935L) | (-72057594037927936L);
        metadata[lastIndex] = metadata[0];
    }

    @NotNull
    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        Intrinsics.checkNotNull(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int findEmptySlot(@NotNull long[] metadata, int i, int i2) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        while (i < i2) {
            if (((metadata[i >> 3] >> ((i & 7) << 3)) & 255) == 128) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final int get(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long group(@NotNull long[] metadata, int i) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i2 = i >> 3;
        int i4 = (i & 7) << 3;
        return (((-i4) >> 63) & (metadata[i2 + 1] << (64 - i4))) | (metadata[i2] >>> i4);
    }

    /* JADX INFO: renamed from: h1 */
    public static final int m1148h1(int i) {
        return i >>> 7;
    }

    /* JADX INFO: renamed from: h2 */
    public static final int m1149h2(int i) {
        return i & 127;
    }

    public static final boolean hasNext(long j) {
        return j != 0;
    }

    public static final int hash(@Nullable Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final boolean isDeleted(@NotNull long[] metadata, int i) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return ((metadata[i >> 3] >> ((i & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(@NotNull long[] metadata, int i) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return ((metadata[i >> 3] >> ((i & 7) << 3)) & 255) == 128;
    }

    @PublishedApi
    public static final boolean isFull(long j) {
        return j < 128;
    }

    public static final int loadedCapacity(int i) {
        if (i == 7) {
            return 6;
        }
        return i - (i / 8);
    }

    @PublishedApi
    public static final int lowestBitSet(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long maskEmpty(long j) {
        return j & ((~j) << 6) & (-9187201950435737472L);
    }

    @PublishedApi
    public static final long maskEmptyOrDeleted(long j) {
        return j & ((~j) << 7) & (-9187201950435737472L);
    }

    @PublishedApi
    public static final long match(long j, int i) {
        long j2 = j ^ (((long) i) * BitmaskLsb);
        return (~j2) & (j2 - BitmaskLsb) & (-9187201950435737472L);
    }

    @NotNull
    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final long next(long j) {
        return j & (j - 1);
    }

    public static final int nextCapacity(int i) {
        if (i == 0) {
            return 6;
        }
        return (i * 2) + 1;
    }

    public static final int normalizeCapacity(int i) {
        if (i > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    @PublishedApi
    public static final long readRawMetadata(@NotNull long[] data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        return (data[i >> 3] >> ((i & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i) {
        if (i == 7) {
            return 8;
        }
        return AbstractC0000a.m7d(i, 1, 7, i);
    }

    public static final void writeMetadata(@NotNull long[] data, int i, int i2, long j) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i4 = i2 >> 3;
        int i5 = (i2 & 7) << 3;
        long j2 = (j << i5) | (data[i4] & (~(255 << i5)));
        data[i4] = j2;
        data[(((i2 - 7) & i) + (i & 7)) >> 3] = j2;
    }

    public static final void writeRawMetadata(@NotNull long[] data, int i, long j) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i2 = i >> 3;
        int i4 = (i & 7) << 3;
        data[i2] = (j << i4) | (data[i2] & (~(255 << i4)));
    }

    public static final boolean isFull(@NotNull long[] metadata, int i) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return ((metadata[i >> 3] >> ((i & 7) << 3)) & 255) < 128;
    }

    @NotNull
    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(@NotNull Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairs.length);
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }

    @PublishedApi
    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSentinel$annotations() {
    }
}
