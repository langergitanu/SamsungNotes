package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m13886d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1", "", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "setIterator", "(Ljava/util/Iterator;)V", "hasNext", "", "next", "remove", "", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class MutableScatterMap$MutableMapWrapper$entries$1$iterator$1<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
    private int current = -1;

    @NotNull
    private Iterator<? extends Map.Entry<K, V>> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    /* JADX INFO: renamed from: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/SequenceScope;", ""}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1", m14021f = "ScatterMap.kt", m14022i = {0, 0, 0, 0, 0, 0, 0}, m14023l = {1412}, m14024m = "invokeSuspend", m14025n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, m14026s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
    @SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1980:1\n365#2,6:1981\n375#2,3:1988\n378#2,9:1992\n1956#3:1987\n1820#3:1991\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1\n*L\n1410#1:1981,6\n1410#1:1988,3\n1410#1:1992,9\n1410#1:1987\n1410#1:1991\n*E\n"})
    public static final class C06161 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<K, V>>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutableScatterMap<K, V> this$0;
        final /* synthetic */ MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 this$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06161(MutableScatterMap mutableScatterMap, MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 mutableScatterMap$MutableMapWrapper$entries$1$iterator$1, Continuation continuation) {
            super(2, continuation);
            this.this$0 = mutableScatterMap;
            this.this$1 = mutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C06161 c06161 = new C06161(this.this$0, this.this$1, continuation);
            c06161.L$0 = obj;
            return c06161;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0059 -> B:14:0x006d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0076 -> B:20:0x00a9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a6 -> B:21:0x00ac). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00be -> B:26:0x00bf). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            SequenceScope sequenceScope;
            MutableScatterMap<K, V> mutableScatterMap;
            MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 mutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
            long[] jArr;
            int length;
            int i;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i4 = 8;
            int i5 = 1;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                sequenceScope = (SequenceScope) this.L$0;
                mutableScatterMap = this.this$0;
                mutableScatterMap$MutableMapWrapper$entries$1$iterator$1 = this.this$1;
                jArr = mutableScatterMap.metadata;
                length = jArr.length - 2;
                if (length >= 0) {
                    i = 0;
                    j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = this.I$3;
            int i7 = this.I$2;
            long j2 = this.J$0;
            int i8 = this.I$1;
            int i9 = this.I$0;
            long[] jArr2 = (long[]) this.L$3;
            MutableScatterMap<K, V> mutableScatterMap2 = (MutableScatterMap) this.L$2;
            MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 mutableScatterMap$MutableMapWrapper$entries$1$iterator$12 = (MutableScatterMap$MutableMapWrapper$entries$1$iterator$1) this.L$1;
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            int i10 = i4;
            int i11 = i5;
            j2 >>= i10;
            i6 += i11;
            i5 = i11;
            i4 = i10;
            if (i6 < i7) {
                int i12 = i5;
                if (i7 == i4) {
                    int i13 = i9;
                    i = i8;
                    length = i13;
                    jArr = jArr2;
                    mutableScatterMap = mutableScatterMap2;
                    mutableScatterMap$MutableMapWrapper$entries$1$iterator$1 = mutableScatterMap$MutableMapWrapper$entries$1$iterator$12;
                    sequenceScope = sequenceScope2;
                    if (i != length) {
                        i++;
                        i5 = i12;
                        j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            int i14 = 8 - ((~(i - length)) >>> 31);
                            int i15 = i;
                            i9 = length;
                            i8 = i15;
                            sequenceScope2 = sequenceScope;
                            i6 = 0;
                            mutableScatterMap2 = mutableScatterMap;
                            jArr2 = jArr;
                            i7 = i14;
                            mutableScatterMap$MutableMapWrapper$entries$1$iterator$12 = mutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
                            j2 = j;
                            if (i6 < i7) {
                                if ((255 & j2) < 128) {
                                    mutableScatterMap$MutableMapWrapper$entries$1$iterator$12.setCurrent((i8 << 3) + i6);
                                    i10 = i4;
                                    MutableMapEntry mutableMapEntry = new MutableMapEntry(mutableScatterMap2.keys, mutableScatterMap2.values, mutableScatterMap$MutableMapWrapper$entries$1$iterator$12.getCurrent());
                                    this.L$0 = sequenceScope2;
                                    this.L$1 = mutableScatterMap$MutableMapWrapper$entries$1$iterator$12;
                                    this.L$2 = mutableScatterMap2;
                                    this.L$3 = jArr2;
                                    this.I$0 = i9;
                                    this.I$1 = i8;
                                    this.J$0 = j2;
                                    this.I$2 = i7;
                                    this.I$3 = i6;
                                    i11 = 1;
                                    this.label = 1;
                                    if (sequenceScope2.yield(mutableMapEntry, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    int i102 = i4;
                                    int i112 = i5;
                                }
                                j2 >>= i102;
                                i6 += i112;
                                i5 = i112;
                                i4 = i102;
                                if (i6 < i7) {
                                }
                            }
                        } else {
                            i12 = i5;
                            if (i != length) {
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SequenceScope<? super Map.Entry<K, V>> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C06161) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = SequencesKt.iterator(new C06161(mutableScatterMap, this, null));
    }

    public final int getCurrent() {
        return this.current;
    }

    @NotNull
    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.current;
        if (i != -1) {
            this.this$0.removeValueAt(i);
            this.current = -1;
        }
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setIterator(@NotNull Iterator<? extends Map.Entry<K, V>> it) {
        Intrinsics.checkNotNullParameter(it, "<set-?>");
        this.iterator = it;
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<K, V> next() {
        return this.iterator.next();
    }
}
