package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¨\u0006\u0007"}, m13886d2 = {"withNullability", "Lkotlin/reflect/KType;", "nullable", "", "isSubtypeOf", "other", "isSupertypeOf", "kotlin-reflection"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@JvmName(name = "KTypes")
public final class KTypes {
    @SinceKotlin(version = "1.1")
    public static final boolean isSubtypeOf(@NotNull KType kType, @NotNull KType other) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return TypeUtilsKt.isSubtypeOf(((KTypeImpl) kType).getType(), ((KTypeImpl) other).getType());
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSupertypeOf(@NotNull KType kType, @NotNull KType other) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return isSubtypeOf(other, kType);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final KType withNullability(@NotNull KType kType, boolean z) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        return ((KTypeImpl) kType).makeNullableAsSpecified$kotlin_reflection(z);
    }
}
