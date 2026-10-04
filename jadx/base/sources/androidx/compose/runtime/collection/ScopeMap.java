package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001aJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\b¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020\u000e2#\b\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\bJ\u001b\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, m13886d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "clear", "contains", "element", "(Ljava/lang/Object;)Z", "forEachScopeOf", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "value", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScopeMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScopeMap.kt\nandroidx/compose/runtime/collection/ScopeMap\n+ 2 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n+ 3 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 6 ScatterSet.kt\nandroidx/collection/MutableScatterSet\n*L\n1#1,194:1\n77#1,5:239\n85#1,4:270\n876#2,18:195\n1049#2:274\n1051#2:288\n1052#2,3:316\n1055#2:325\n1049#2:326\n1051#2,4:340\n1055#2:350\n228#3,4:213\n198#3,7:217\n209#3,3:225\n212#3,9:229\n232#3:238\n228#3,4:244\n198#3,7:248\n209#3,3:256\n212#3,9:260\n232#3:269\n198#3,7:291\n209#3,3:299\n212#3,2:303\n215#3,6:309\n1956#4:224\n1820#4:228\n1956#4:255\n1820#4:259\n1956#4:281\n1820#4:285\n1956#4:298\n1820#4:302\n1956#4:333\n1820#4:337\n1956#4:361\n1820#4:365\n365#5,6:275\n375#5,3:282\n378#5,2:286\n381#5,6:319\n365#5,6:327\n375#5,3:334\n378#5,2:338\n381#5,6:344\n393#5,4:351\n365#5,6:355\n375#5,3:362\n378#5,2:366\n398#5,2:368\n381#5,6:370\n400#5:376\n784#6,2:289\n787#6,4:305\n791#6:315\n*S KotlinDebug\n*F\n+ 1 ScopeMap.kt\nandroidx/compose/runtime/collection/ScopeMap\n*L\n91#1:239,5\n91#1:270,4\n37#1:195,18\n138#1:274\n138#1:288\n138#1:316,3\n138#1:325\n159#1:326\n159#1:340,4\n159#1:350\n81#1:213,4\n81#1:217,7\n81#1:225,3\n81#1:229,9\n81#1:238\n91#1:244,4\n91#1:248,7\n91#1:256,3\n91#1:260,9\n91#1:269\n143#1:291,7\n143#1:299,3\n143#1:303,2\n143#1:309,6\n81#1:224\n81#1:228\n91#1:255\n91#1:259\n138#1:281\n138#1:285\n143#1:298\n143#1:302\n159#1:333\n159#1:337\n180#1:361\n180#1:365\n138#1:275,6\n138#1:282,3\n138#1:286,2\n138#1:319,6\n159#1:327,6\n159#1:334,3\n159#1:338,2\n159#1:344,6\n180#1:351,4\n180#1:355,6\n180#1:362,3\n180#1:366,2\n180#1:368,2\n180#1:370,6\n180#1:376\n143#1:289,2\n143#1:305,4\n143#1:315\n*E\n"})
public final class ScopeMap<Key, Scope> {
    public static final int $stable = 8;

    @NotNull
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final void add(@NotNull Key key, @NotNull Scope scope) {
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = iFindInsertIndex < 0;
        Object obj = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) obj).add(scope);
            } else if (obj != scope) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.add(obj);
                mutableScatterSet.add(scope);
                scope = (Scope) mutableScatterSet;
            }
            scope = (Scope) obj;
        }
        if (!z) {
            mutableScatterMap.values[iFindInsertIndex] = scope;
            return;
        }
        int i = ~iFindInsertIndex;
        mutableScatterMap.keys[i] = key;
        mutableScatterMap.values[i] = scope;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean anyScopeOf(@NotNull Key key, @NotNull Function1<? super Scope, Boolean> block) {
        Object obj = getMap().get(key);
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i4 = 0; i4 < i2; i4++) {
                                if ((255 & j) < 128 && block.invoke(objArr[(i << 3) + i4]).booleanValue()) {
                                    return true;
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                            if (i == length) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else if (block.invoke(obj).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Key, Set<Scope>> asMap() {
        Set setMutableSetOf;
        HashMap map = new HashMap();
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            Object obj2 = objArr2[i5];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4>");
                                setMutableSetOf = ((MutableScatterSet) obj2).asSet();
                            } else {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                                setMutableSetOf = SetsKt.mutableSetOf(obj2);
                            }
                            map.put(obj, setMutableSetOf);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return map;
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean contains(@NotNull Key element) {
        return this.map.containsKey(element);
    }

    public final void forEachScopeOf(@NotNull Key key, @NotNull Function1<? super Scope, Unit> block) {
        Object obj = getMap().get(key);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            block.invoke(obj);
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
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
                        block.invoke(objArr[(i << 3) + i4]);
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

    @NotNull
    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.get_size();
    }

    public final boolean remove(@NotNull Key key, @NotNull Scope scope) {
        Object obj = this.map.get(key);
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MutableScatterSet)) {
            if (!Intrinsics.areEqual(obj, scope)) {
                return false;
            }
            this.map.remove(key);
            return true;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        boolean zRemove = mutableScatterSet.remove(scope);
        if (zRemove && mutableScatterSet.isEmpty()) {
            this.map.remove(key);
        }
        return zRemove;
    }

    public final void removeScope(@NotNull Scope scope) {
        boolean zIsEmpty;
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        long[] jArr = mutableScatterMap.metadata;
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
                        Object obj = mutableScatterMap.keys[i5];
                        Object obj2 = mutableScatterMap.values[i5];
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            mutableScatterSet.remove(scope);
                            zIsEmpty = mutableScatterSet.isEmpty();
                        } else {
                            zIsEmpty = obj2 == scope;
                        }
                        if (zIsEmpty) {
                            mutableScatterMap.removeValueAt(i5);
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

    public final void removeScopeIf(@NotNull Function1<? super Scope, Boolean> predicate) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean zBooleanValue;
        MutableScatterSet mutableScatterSet;
        long[] jArr3;
        int i2;
        MutableScatterSet mutableScatterSet2;
        MutableScatterMap<Object, Object> map = getMap();
        long[] jArr4 = map.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i4 = 0;
        while (true) {
            long j3 = jArr4[i4];
            char c2 = 7;
            long j5 = -9187201950435737472L;
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i5 = 8;
                int i6 = 8 - ((~(i4 - length)) >>> 31);
                int i7 = 0;
                while (i7 < i6) {
                    if ((j3 & 255) < 128) {
                        int i8 = (i4 << 3) + i7;
                        c = c2;
                        Object obj = map.keys[i8];
                        Object obj2 = map.values[i8];
                        j2 = j5;
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet3.elements;
                            long[] jArr5 = mutableScatterSet3.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i9 = i5;
                                MutableScatterSet mutableScatterSet4 = mutableScatterSet3;
                                int i10 = 0;
                                while (true) {
                                    long j6 = jArr5[i10];
                                    j = j3;
                                    if ((((~j6) << c) & j6 & j2) != j2) {
                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                        int i12 = 0;
                                        while (i12 < i11) {
                                            if ((j6 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i13 = (i10 << 3) + i12;
                                                i2 = i12;
                                                if (predicate.invoke(objArr[i13]).booleanValue()) {
                                                    mutableScatterSet2 = mutableScatterSet4;
                                                    mutableScatterSet2.removeElementAt(i13);
                                                }
                                                j6 >>= i9;
                                                mutableScatterSet4 = mutableScatterSet2;
                                                i12 = i2 + 1;
                                                jArr4 = jArr3;
                                            } else {
                                                jArr3 = jArr4;
                                                i2 = i12;
                                            }
                                            mutableScatterSet2 = mutableScatterSet4;
                                            j6 >>= i9;
                                            mutableScatterSet4 = mutableScatterSet2;
                                            i12 = i2 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                        if (i11 != i9) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                    }
                                    if (i10 == length2) {
                                        break;
                                    }
                                    i10++;
                                    mutableScatterSet4 = mutableScatterSet;
                                    j3 = j;
                                    jArr4 = jArr2;
                                    i9 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j = j3;
                                mutableScatterSet = mutableScatterSet3;
                            }
                            zBooleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j = j3;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                            zBooleanValue = predicate.invoke(obj2).booleanValue();
                        }
                        if (zBooleanValue) {
                            map.removeValueAt(i8);
                        }
                        i = 8;
                    } else {
                        jArr2 = jArr4;
                        j = j3;
                        c = c2;
                        j2 = j5;
                        i = i5;
                    }
                    j3 = j >> i;
                    i7++;
                    i5 = i;
                    c2 = c;
                    j5 = j2;
                    jArr4 = jArr2;
                }
                jArr = jArr4;
                if (i6 != i5) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i4 == length) {
                return;
            }
            i4++;
            jArr4 = jArr;
        }
    }

    public final void set(@NotNull Key key, @NotNull Scope value) {
        this.map.set(key, value);
    }
}
