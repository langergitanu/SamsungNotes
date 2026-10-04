package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface TypeProjection extends TypeArgumentMarker {
    @NotNull
    Variance getProjectionKind();

    @NotNull
    KotlinType getType();

    boolean isStarProjection();

    @NotNull
    TypeProjection refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner);
}
