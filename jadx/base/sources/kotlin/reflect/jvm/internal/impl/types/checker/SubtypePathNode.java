package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class SubtypePathNode {

    @Nullable
    private final SubtypePathNode previous;

    @NotNull
    private final KotlinType type;

    public SubtypePathNode(@NotNull KotlinType type, @Nullable SubtypePathNode subtypePathNode) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.previous = subtypePathNode;
    }

    @Nullable
    public final SubtypePathNode getPrevious() {
        return this.previous;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }
}
