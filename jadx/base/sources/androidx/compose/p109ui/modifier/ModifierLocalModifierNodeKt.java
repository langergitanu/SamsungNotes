package androidx.compose.p109ui.modifier;

import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a?\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006\"\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006\"\u0006\u0012\u0002\b\u00030\u0003H\u0007¢\u0006\u0002\u0010\n\u001aA\u0010\u0000\u001a\u00020\u000122\u0010\u000b\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\f0\u0006\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\u0010\u000e\u001ao\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\f2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\f22\u0010\u000b\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\f0\u0006\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0004\u0012\u0002H\b0\f¨\u0006\u0013"}, m13886d2 = {"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "key1", "Landroidx/compose/ui/modifier/ModifierLocal;", "key2", "keys", "", "(Landroidx/compose/ui/modifier/ModifierLocal;Landroidx/compose/ui/modifier/ModifierLocal;[Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "T", "key", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", SearchIndexablesContract.RawData.COLUMN_ENTRIES, "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "entry2", "(Lkotlin/Pair;Lkotlin/Pair;[Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nModifierLocalModifierNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModifierLocalModifierNode.kt\nandroidx/compose/ui/modifier/ModifierLocalModifierNodeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,253:1\n1#2:254\n11335#3:255\n11670#3,3:256\n37#4,2:259\n37#4,2:272\n37#4,2:274\n151#5,3:261\n33#5,4:264\n154#5,2:268\n38#5:270\n156#5:271\n*S KotlinDebug\n*F\n+ 1 ModifierLocalModifierNode.kt\nandroidx/compose/ui/modifier/ModifierLocalModifierNodeKt\n*L\n211#1:255\n211#1:256,3\n211#1:259,2\n237#1:272,2\n251#1:274,2\n237#1:261,3\n237#1:264,4\n237#1:268,2\n237#1:270\n237#1:271\n*E\n"})
public final class ModifierLocalModifierNodeKt {
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    @NotNull
    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<T> modifierLocal) {
        return new SingleLocalMap(modifierLocal);
    }

    @NotNull
    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<T>, ? extends T> pair) {
        SingleLocalMap singleLocalMap = new SingleLocalMap(pair.getFirst());
        singleLocalMap.mo19961set$ui_release(pair.getFirst(), pair.getSecond());
        return singleLocalMap;
    }

    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<?> modifierLocal, @NotNull ModifierLocal<?> modifierLocal2, @NotNull ModifierLocal<?>... modifierLocalArr) {
        Pair pairM13893to = TuplesKt.m13893to(modifierLocal, null);
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.m13893to(modifierLocal2, null));
        ArrayList arrayList = new ArrayList(modifierLocalArr.length);
        for (ModifierLocal<?> modifierLocal3 : modifierLocalArr) {
            arrayList.add(TuplesKt.m13893to(modifierLocal3, null));
        }
        spreadBuilder.addSpread(arrayList.toArray(new Pair[0]));
        return new MultiLocalMap(pairM13893to, (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<?>, ? extends Object> pair, @NotNull Pair<? extends ModifierLocal<?>, ? extends Object> pair2, @NotNull Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(pair2);
        spreadBuilder.addSpread(pairArr);
        return new MultiLocalMap(pair, (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(ModifierLocal... modifierLocalArr) {
        int length = modifierLocalArr.length;
        if (length == 0) {
            return EmptyMap.INSTANCE;
        }
        if (length != 1) {
            Pair pairM13893to = TuplesKt.m13893to(ArraysKt.first(modifierLocalArr), null);
            List listDrop = ArraysKt.drop(modifierLocalArr, 1);
            ArrayList arrayList = new ArrayList(listDrop.size());
            int size = listDrop.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(TuplesKt.m13893to((ModifierLocal) listDrop.get(i), null));
            }
            Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            return new MultiLocalMap(pairM13893to, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
        return new SingleLocalMap((ModifierLocal) ArraysKt.first(modifierLocalArr));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(Pair... pairArr) {
        int length = pairArr.length;
        if (length == 0) {
            return EmptyMap.INSTANCE;
        }
        if (length != 1) {
            Pair pair = (Pair) ArraysKt.first(pairArr);
            Pair[] pairArr2 = (Pair[]) ArraysKt.drop(pairArr, 1).toArray(new Pair[0]);
            return new MultiLocalMap(pair, (Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
        }
        return new MultiLocalMap((Pair) ArraysKt.first(pairArr), new Pair[0]);
    }
}
