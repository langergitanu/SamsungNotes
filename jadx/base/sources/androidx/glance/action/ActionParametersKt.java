package androidx.glance.action;

import androidx.datastore.preferences.core.Preferences;
import androidx.glance.action.ActionParameters;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\b2\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\t\u001a\n\u0010\n\u001a\u00020\b*\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u000e0\u000f¨\u0006\u0010"}, m13886d2 = {"actionParametersOf", "Landroidx/glance/action/ActionParameters;", "pairs", "", "Landroidx/glance/action/ActionParameters$Pair;", "", "([Landroidx/glance/action/ActionParameters$Pair;)Landroidx/glance/action/ActionParameters;", "mutableActionParametersOf", "Landroidx/glance/action/MutableActionParameters;", "([Landroidx/glance/action/ActionParameters$Pair;)Landroidx/glance/action/MutableActionParameters;", "toMutableParameters", "toParameters", "toParametersKey", "Landroidx/glance/action/ActionParameters$Key;", "T", "Landroidx/datastore/preferences/core/Preferences$Key;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nActionParameters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionParameters.kt\nandroidx/glance/action/ActionParametersKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,212:1\n11065#2:213\n11400#2,3:214\n37#3,2:217\n*S KotlinDebug\n*F\n+ 1 ActionParameters.kt\nandroidx/glance/action/ActionParametersKt\n*L\n186#1:213\n186#1:214,3\n186#1:217,2\n*E\n"})
public final class ActionParametersKt {
    @NotNull
    public static final ActionParameters actionParametersOf(@NotNull ActionParameters.Pair<? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return mutableActionParametersOf((ActionParameters.Pair[]) Arrays.copyOf(pairs, pairs.length));
    }

    @NotNull
    public static final MutableActionParameters mutableActionParametersOf(@NotNull ActionParameters.Pair<? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        ArrayList arrayList = new ArrayList(pairs.length);
        for (ActionParameters.Pair<? extends Object> pair : pairs) {
            arrayList.add(TuplesKt.m13893to(pair.getKey$glance_release(), pair.getValue$glance_release()));
        }
        Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        return new MutableActionParameters(MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
    }

    @NotNull
    public static final MutableActionParameters toMutableParameters(@NotNull ActionParameters actionParameters) {
        Intrinsics.checkNotNullParameter(actionParameters, "<this>");
        return new MutableActionParameters(MapsKt.toMutableMap(actionParameters.asMap()));
    }

    @NotNull
    public static final ActionParameters toParameters(@NotNull ActionParameters actionParameters) {
        Intrinsics.checkNotNullParameter(actionParameters, "<this>");
        return toMutableParameters(actionParameters);
    }

    @NotNull
    public static final <T> ActionParameters.Key<T> toParametersKey(@NotNull Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "<this>");
        return new ActionParameters.Key<>(key.getName());
    }
}
