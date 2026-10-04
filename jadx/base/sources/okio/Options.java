package okio;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m13886d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, m13887k = 1, m13888mv = {1, 4, 1})
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final ByteString[] byteStrings;

    @NotNull
    private final int[] trie;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m13886d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, m13887k = 1, m13888mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i;
            int i2;
            long j;
            int i4 = byteStringOffset;
            int i5 = fromIndex;
            if (!(i5 < toIndex)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i6 = i5; i6 < toIndex; i6++) {
                if (!(byteStrings.get(i6).size() >= i4)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = byteStrings.get(fromIndex);
            ByteString byteString2 = byteStrings.get(toIndex - 1);
            if (i4 == byteString.size()) {
                int iIntValue = indexes.get(i5).intValue();
                i5++;
                i = iIntValue;
                byteString = byteStrings.get(i5);
            } else {
                i = -1;
            }
            if (byteString.getByte(i4) == byteString2.getByte(i4)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i7 = 0;
                for (int i8 = i4; i8 < iMin && byteString.getByte(i8) == byteString2.getByte(i8); i8++) {
                    i7++;
                }
                long intCount = nodeOffset + getIntCount(node) + ((long) 2) + ((long) i7) + 1;
                node.writeInt(-i7);
                node.writeInt(i);
                int i9 = i4 + i7;
                while (i4 < i9) {
                    node.writeInt(byteString.getByte(i4) & 255);
                    i4++;
                }
                if (i5 + 1 == toIndex) {
                    if (!(i9 == byteStrings.get(i5).size())) {
                        throw new IllegalStateException("Check failed.");
                    }
                    node.writeInt(indexes.get(i5).intValue());
                    return;
                } else {
                    Buffer buffer = new Buffer();
                    node.writeInt(((int) (getIntCount(buffer) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer, i9, byteStrings, i5, toIndex, indexes);
                    node.writeAll(buffer);
                    return;
                }
            }
            int i10 = 1;
            for (int i11 = i5 + 1; i11 < toIndex; i11++) {
                if (byteStrings.get(i11 - 1).getByte(i4) != byteStrings.get(i11).getByte(i4)) {
                    i10++;
                }
            }
            long intCount2 = nodeOffset + getIntCount(node) + ((long) 2) + ((long) (i10 * 2));
            node.writeInt(i10);
            node.writeInt(i);
            for (int i12 = i5; i12 < toIndex; i12++) {
                byte b = byteStrings.get(i12).getByte(i4);
                if (i12 == i5 || b != byteStrings.get(i12 - 1).getByte(i4)) {
                    node.writeInt(b & 255);
                }
            }
            Buffer buffer2 = new Buffer();
            int i13 = i5;
            while (i13 < toIndex) {
                byte b5 = byteStrings.get(i13).getByte(i4);
                int i14 = i13 + 1;
                int i15 = i14;
                while (true) {
                    if (i15 >= toIndex) {
                        i2 = toIndex;
                        break;
                    } else {
                        if (b5 != byteStrings.get(i15).getByte(i4)) {
                            i2 = i15;
                            break;
                        }
                        i15++;
                    }
                }
                if (i14 == i2 && i4 + 1 == byteStrings.get(i13).size()) {
                    node.writeInt(indexes.get(i13).intValue());
                    j = intCount2;
                } else {
                    node.writeInt(((int) (getIntCount(buffer2) + intCount2)) * (-1));
                    j = intCount2;
                    buildTrieRecursive(j, buffer2, i4 + 1, byteStrings, i13, i2, indexes);
                }
                intCount2 = j;
                i13 = i2;
            }
            node.writeAll(buffer2);
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i4, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j = 0;
            }
            companion.buildTrieRecursive(j, buffer, (i5 & 4) != 0 ? 0 : i, list, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00d0, code lost:
        
            continue;
         */
        @JvmStatic
        @NotNull
        /* JADX INFO: renamed from: of */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options m14405of(@NotNull ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 0;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List mutableList = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            int length = byteStrings.length;
            for (int iM1200a = 0; iM1200a < length; iM1200a = AbstractC1038a.m1200a(-1, iM1200a, 1, arrayList)) {
                ByteString byteString = byteStrings[iM1200a];
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List listMutableListOf = CollectionsKt.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length2 = byteStrings.length;
            int i2 = 0;
            int i4 = 0;
            while (i2 < length2) {
                listMutableListOf.set(CollectionsKt__CollectionsKt.binarySearch$default(mutableList, byteStrings[i2], 0, 0, 6, (Object) null), Integer.valueOf(i4));
                i2++;
                i4++;
            }
            if (((ByteString) mutableList.get(0)).size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i5 = 0;
            while (i5 < mutableList.size()) {
                ByteString byteString2 = (ByteString) mutableList.get(i5);
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < mutableList.size()) {
                    ByteString byteString3 = (ByteString) mutableList.get(i7);
                    if (!byteString3.startsWith(byteString2)) {
                        break;
                    }
                    if (byteString3.size() == byteString2.size()) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                    }
                    if (((Number) listMutableListOf.get(i7)).intValue() > ((Number) listMutableListOf.get(i5)).intValue()) {
                        mutableList.remove(i7);
                        listMutableListOf.remove(i7);
                    } else {
                        i7++;
                    }
                }
                i5 = i6;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive$default(this, 0L, buffer, 0, mutableList, 0, 0, listMutableListOf, 53, null);
            int[] iArr = new int[(int) getIntCount(buffer)];
            while (!buffer.exhausted()) {
                iArr[i] = buffer.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new Options((ByteString[]) objArrCopyOf, iArr, defaultConstructorMarker);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    @NotNull
    /* JADX INFO: renamed from: of */
    public static final Options m14404of(@NotNull ByteString... byteStringArr) {
        return INSTANCE.m14405of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    /* JADX INFO: renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
