package androidx.compose.runtime.snapshots;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.Immutable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J:\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002'\u0010\u0011\u001a#\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0012H\u0086\bJ\u001d\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "toString", "", "Companion", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@SourceDebugExtension({"SMAP\nSnapshotIdSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotIdSet.kt\nandroidx/compose/runtime/snapshots/SnapshotIdSet\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,382:1\n317#1,28:385\n317#1,28:413\n317#1,28:441\n317#1,28:469\n317#1,28:497\n325#1,20:525\n13600#2,2:383\n1549#3:545\n1620#3,3:546\n*S KotlinDebug\n*F\n+ 1 SnapshotIdSet.kt\nandroidx/compose/runtime/snapshots/SnapshotIdSet\n*L\n236#1:385,28\n257#1:413,28\n261#1:441,28\n283#1:469,28\n286#1:497,28\n318#1:525,20\n107#1:383,2\n354#1:545\n354#1:546,3\n*E\n"})
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);

    @Nullable
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", m14021f = "SnapshotIdSet.kt", m14022i = {0, 0, 1, 1, 2, 2}, m14023l = {295, 300, 307}, m14024m = "invokeSuspend", m14025n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, m14026s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
    public static final class C20131 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C20131(Continuation<? super C20131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C20131 c20131 = SnapshotIdSet.this.new C20131(continuation);
            c20131.L$0 = obj;
            return c20131;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        
            if (r15.yield(r4, r19) == r1) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
        
            if (r13.yield(r4, r19) == r1) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:19:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009b -> B:30:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b4 -> B:30:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d2 -> B:43:0x00f2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f0 -> B:42:0x00f1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            SequenceScope sequenceScope;
            SequenceScope sequenceScope2;
            int length;
            int[] iArr;
            int i;
            long j;
            SequenceScope sequenceScope3;
            int i2;
            SequenceScope sequenceScope4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            int i5 = 0;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                sequenceScope = (SequenceScope) this.L$0;
                int[] iArr2 = SnapshotIdSet.this.belowBound;
                if (iArr2 != null) {
                    sequenceScope2 = sequenceScope;
                    length = iArr2.length;
                    iArr = iArr2;
                    i = 0;
                    if (i < length) {
                    }
                }
                j = 1;
                if (SnapshotIdSet.this.lowerSet != 0) {
                }
                if (SnapshotIdSet.this.upperSet != 0) {
                }
                return Unit.INSTANCE;
            }
            if (i4 == 1) {
                length = this.I$1;
                i = this.I$0;
                iArr = (int[]) this.L$1;
                sequenceScope2 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i < length) {
                    sequenceScope = sequenceScope2;
                    j = 1;
                    if (SnapshotIdSet.this.lowerSet != 0) {
                        sequenceScope3 = sequenceScope;
                        i2 = 0;
                        if (i2 >= 64) {
                        }
                    }
                    if (SnapshotIdSet.this.upperSet != 0) {
                    }
                    return Unit.INSTANCE;
                }
                Integer numBoxInt = Boxing.boxInt(iArr[i]);
                this.L$0 = sequenceScope2;
                this.L$1 = iArr;
                this.I$0 = i;
                this.I$1 = length;
                this.label = 1;
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i6 = this.I$0;
                    sequenceScope4 = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j = 1;
                    i5 = i6;
                    i5++;
                    if (i5 < 64) {
                        if ((SnapshotIdSet.this.upperSet & (j << i5)) != 0) {
                            Integer numBoxInt2 = Boxing.boxInt(SnapshotIdSet.this.lowerBound + i5 + 64);
                            this.L$0 = sequenceScope4;
                            this.L$1 = null;
                            this.I$0 = i5;
                            this.label = 3;
                            if (sequenceScope4.yield(numBoxInt2, this) != coroutine_suspended) {
                                i6 = i5;
                                i5 = i6;
                            }
                            return coroutine_suspended;
                        }
                        i5++;
                        if (i5 < 64) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                i2 = this.I$0;
                sequenceScope3 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                j = 1;
                i2++;
                if (i2 >= 64) {
                    sequenceScope = sequenceScope3;
                    if (SnapshotIdSet.this.upperSet != 0) {
                        sequenceScope4 = sequenceScope;
                        if (i5 < 64) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                if ((SnapshotIdSet.this.lowerSet & (j << i2)) != 0) {
                    Integer numBoxInt3 = Boxing.boxInt(SnapshotIdSet.this.lowerBound + i2);
                    this.L$0 = sequenceScope3;
                    this.L$1 = null;
                    this.I$0 = i2;
                    this.label = 2;
                }
                i2++;
                if (i2 >= 64) {
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SequenceScope<? super Integer> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C20131) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private SnapshotIdSet(long j, long j2, int i, int[] iArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = i;
        this.belowBound = iArr;
    }

    @NotNull
    public final SnapshotIdSet and(@NotNull SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (Intrinsics.areEqual(bits, snapshotIdSet) || Intrinsics.areEqual(this, snapshotIdSet)) {
            return snapshotIdSet;
        }
        int i = bits.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                long j = this.upperSet;
                long j2 = bits.upperSet;
                long j3 = j & j2;
                long j5 = this.lowerSet;
                long j6 = bits.lowerSet;
                return (j3 == 0 && (j5 & j6) == 0 && iArr2 == null) ? snapshotIdSet : new SnapshotIdSet(j & j2, j5 & j6, i2, iArr2);
            }
        }
        SnapshotIdSet snapshotIdSet2 = snapshotIdSet;
        int i4 = 0;
        if (this.belowBound == null) {
            int[] iArr3 = this.belowBound;
            if (iArr3 != null) {
                for (int i5 : iArr3) {
                    if (bits.get(i5)) {
                        snapshotIdSet2 = snapshotIdSet2.set(i5);
                    }
                }
            }
            SnapshotIdSet snapshotIdSet3 = snapshotIdSet2;
            if (this.lowerSet != 0) {
                for (int i6 = 0; i6 < 64; i6++) {
                    if ((this.lowerSet & (1 << i6)) != 0) {
                        int i7 = this.lowerBound + i6;
                        if (bits.get(i7)) {
                            snapshotIdSet3 = snapshotIdSet3.set(i7);
                        }
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i4 < 64) {
                    if ((this.upperSet & (1 << i4)) != 0) {
                        int i8 = this.lowerBound + i4 + 64;
                        if (bits.get(i8)) {
                            snapshotIdSet3 = snapshotIdSet3.set(i8);
                        }
                    }
                    i4++;
                }
            }
            return snapshotIdSet3;
        }
        int[] iArr4 = bits.belowBound;
        if (iArr4 != null) {
            for (int i9 : iArr4) {
                if (get(i9)) {
                    snapshotIdSet2 = snapshotIdSet2.set(i9);
                }
            }
        }
        SnapshotIdSet snapshotIdSet4 = snapshotIdSet2;
        if (bits.lowerSet != 0) {
            for (int i10 = 0; i10 < 64; i10++) {
                if ((bits.lowerSet & (1 << i10)) != 0) {
                    int i11 = bits.lowerBound + i10;
                    if (get(i11)) {
                        snapshotIdSet4 = snapshotIdSet4.set(i11);
                    }
                }
            }
        }
        if (bits.upperSet != 0) {
            while (i4 < 64) {
                if ((bits.upperSet & (1 << i4)) != 0) {
                    int i12 = bits.lowerBound + i4 + 64;
                    if (get(i12)) {
                        snapshotIdSet4 = snapshotIdSet4.set(i12);
                    }
                }
                i4++;
            }
        }
        return snapshotIdSet4;
    }

    @NotNull
    public final SnapshotIdSet andNot(@NotNull SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSetClear;
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        int i = bits.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet & (~bits.upperSet), this.lowerSet & (~bits.lowerSet), i2, iArr2);
            }
        }
        int[] iArr3 = bits.belowBound;
        if (iArr3 != null) {
            snapshotIdSetClear = this;
            for (int i4 : iArr3) {
                snapshotIdSetClear = snapshotIdSetClear.clear(i4);
            }
        } else {
            snapshotIdSetClear = this;
        }
        if (bits.lowerSet != 0) {
            for (int i5 = 0; i5 < 64; i5++) {
                if ((bits.lowerSet & (1 << i5)) != 0) {
                    snapshotIdSetClear = snapshotIdSetClear.clear(bits.lowerBound + i5);
                }
            }
        }
        if (bits.upperSet != 0) {
            for (int i6 = 0; i6 < 64; i6++) {
                if ((bits.upperSet & (1 << i6)) != 0) {
                    snapshotIdSetClear = snapshotIdSetClear.clear(bits.lowerBound + i6 + 64);
                }
            }
        }
        return snapshotIdSetClear;
    }

    @NotNull
    public final SnapshotIdSet clear(int bit) {
        int[] iArr;
        int iBinarySearch;
        int i = this.lowerBound;
        int i2 = bit - i;
        if (i2 >= 0 && i2 < 64) {
            long j = 1 << i2;
            long j2 = this.lowerSet;
            if ((j2 & j) != 0) {
                return new SnapshotIdSet(this.upperSet, (~j) & j2, i, this.belowBound);
            }
        } else if (i2 >= 64 && i2 < 128) {
            long j3 = 1 << (i2 - 64);
            long j5 = this.upperSet;
            if ((j5 & j3) != 0) {
                return new SnapshotIdSet((~j3) & j5, this.lowerSet, i, this.belowBound);
            }
        } else if (i2 < 0 && (iArr = this.belowBound) != null && (iBinarySearch = SnapshotIdSetKt.binarySearch(iArr, bit)) >= 0) {
            int length = iArr.length;
            int i4 = length - 1;
            if (i4 == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] iArr2 = new int[i4];
            if (iBinarySearch > 0) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, iBinarySearch);
            }
            if (iBinarySearch < i4) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, iBinarySearch, iBinarySearch + 1, length);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    @NotNull
    public final SnapshotIdSet fastFold(@NotNull SnapshotIdSet initial, @NotNull Function2<? super SnapshotIdSet, ? super Integer, SnapshotIdSet> operation) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            for (int i : iArr) {
                initial = operation.invoke(initial, Integer.valueOf(i));
            }
        }
        if (this.lowerSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.lowerSet & (1 << i2)) != 0) {
                    initial = operation.invoke(initial, Integer.valueOf(this.lowerBound + i2));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((this.upperSet & (1 << i4)) != 0) {
                    initial = operation.invoke(initial, Integer.valueOf(this.lowerBound + i4 + 64));
                }
            }
        }
        return initial;
    }

    public final void fastForEach(@NotNull Function1<? super Integer, Unit> block) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            for (int i : iArr) {
                block.invoke(Integer.valueOf(i));
            }
        }
        if (this.lowerSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.lowerSet & (1 << i2)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + i2));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((this.upperSet & (1 << i4)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + i4 + 64));
                }
            }
        }
    }

    public final boolean get(int bit) {
        int[] iArr;
        int i = bit - this.lowerBound;
        return (i < 0 || i >= 64) ? (i < 64 || i >= 128) ? i <= 0 && (iArr = this.belowBound) != null && SnapshotIdSetKt.binarySearch(iArr, bit) >= 0 : ((1 << (i - 64)) & this.upperSet) != 0 : ((1 << i) & this.lowerSet) != 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new C20131(null)).iterator();
    }

    public final int lowest(int i) {
        int i2;
        int iNumberOfTrailingZeros;
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j = this.lowerSet;
        if (j != 0) {
            i2 = this.lowerBound;
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        } else {
            long j2 = this.upperSet;
            if (j2 == 0) {
                return i;
            }
            i2 = this.lowerBound + 64;
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j2);
        }
        return iNumberOfTrailingZeros + i2;
    }

    @NotNull
    /* JADX INFO: renamed from: or */
    public final SnapshotIdSet m1337or(@NotNull SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (bits == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return bits;
        }
        int i = bits.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet | bits.upperSet, this.lowerSet | bits.lowerSet, i2, iArr2);
            }
        }
        int i4 = 0;
        if (this.belowBound == null) {
            int[] iArr3 = this.belowBound;
            if (iArr3 != null) {
                for (int i5 : iArr3) {
                    bits = bits.set(i5);
                }
            }
            if (this.lowerSet != 0) {
                for (int i6 = 0; i6 < 64; i6++) {
                    if ((this.lowerSet & (1 << i6)) != 0) {
                        bits = bits.set(this.lowerBound + i6);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i4 < 64) {
                    if ((this.upperSet & (1 << i4)) != 0) {
                        bits = bits.set(this.lowerBound + i4 + 64);
                    }
                    i4++;
                }
            }
            return bits;
        }
        int[] iArr4 = bits.belowBound;
        if (iArr4 != null) {
            snapshotIdSet = this;
            for (int i7 : iArr4) {
                snapshotIdSet = snapshotIdSet.set(i7);
            }
        } else {
            snapshotIdSet = this;
        }
        if (bits.lowerSet != 0) {
            for (int i8 = 0; i8 < 64; i8++) {
                if ((bits.lowerSet & (1 << i8)) != 0) {
                    snapshotIdSet = snapshotIdSet.set(bits.lowerBound + i8);
                }
            }
        }
        if (bits.upperSet != 0) {
            while (i4 < 64) {
                if ((bits.upperSet & (1 << i4)) != 0) {
                    snapshotIdSet = snapshotIdSet.set(bits.lowerBound + i4 + 64);
                }
                i4++;
            }
        }
        return snapshotIdSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0080 A[PHI: r9
      0x0080: PHI (r9v5 java.util.ArrayList) = (r9v2 java.util.ArrayList), (r9v7 java.util.ArrayList) binds: [B:24:0x0064, B:26:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SnapshotIdSet set(int bit) {
        int i;
        int[] intArray;
        long j;
        long j2;
        int i2 = this.lowerBound;
        int i4 = bit - i2;
        long j3 = 1;
        long j5 = 0;
        if (i4 >= 0 && i4 < 64) {
            long j6 = 1 << i4;
            long j7 = this.lowerSet;
            if ((j7 & j6) == 0) {
                return new SnapshotIdSet(this.upperSet, j7 | j6, i2, this.belowBound);
            }
        } else if (i4 >= 64 && i4 < 128) {
            long j8 = 1 << (i4 - 64);
            long j9 = this.upperSet;
            if ((j9 & j8) == 0) {
                return new SnapshotIdSet(j9 | j8, this.lowerSet, i2, this.belowBound);
            }
        } else if (i4 < 128) {
            int[] iArr = this.belowBound;
            if (iArr == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i2, new int[]{bit});
            }
            int iBinarySearch = SnapshotIdSetKt.binarySearch(iArr, bit);
            if (iBinarySearch < 0) {
                int i5 = -(iBinarySearch + 1);
                int length = iArr.length;
                int[] iArr2 = new int[length + 1];
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, i5);
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, i5 + 1, i5, length);
                iArr2[i5] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
            }
        } else if (!get(bit)) {
            long j10 = this.upperSet;
            long j11 = this.lowerSet;
            int i6 = this.lowerBound;
            int i7 = ((bit + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j12 = j11;
            long j13 = j10;
            while (true) {
                if (i6 >= i7) {
                    i = i6;
                    break;
                }
                if (j12 == j5) {
                    j = j3;
                    j2 = j5;
                } else if (arrayList == null) {
                    arrayList = new ArrayList();
                    int[] iArr3 = this.belowBound;
                    if (iArr3 != null) {
                        j = j3;
                        int length2 = iArr3.length;
                        int iM1200a = 0;
                        while (iM1200a < length2) {
                            iM1200a = AbstractC1038a.m1200a(iArr3[iM1200a], iM1200a, 1, arrayList);
                            j5 = j5;
                        }
                    } else {
                        j = j3;
                    }
                    j2 = j5;
                    for (int i8 = 0; i8 < 64; i8++) {
                        if (((j << i8) & j12) != j2) {
                            arrayList.add(Integer.valueOf(i8 + i6));
                        }
                    }
                }
                if (j13 == j2) {
                    i = i7;
                    j12 = j2;
                    break;
                }
                i6 += 64;
                j12 = j13;
                j3 = j;
                j5 = j2;
                j13 = j5;
            }
            if (arrayList == null || (intArray = CollectionsKt.toIntArray(arrayList)) == null) {
                intArray = this.belowBound;
            }
            return new SnapshotIdSet(j13, j12, i, intArray).set(bit);
        }
        return this;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(this));
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null), sb);
    }
}
