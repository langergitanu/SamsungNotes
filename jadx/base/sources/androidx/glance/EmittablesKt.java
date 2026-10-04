package androidx.glance;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0006"}, m13886d2 = {"addChild", "", "Landroidx/glance/EmittableWithChildren;", "e", "Landroidx/glance/Emittable;", "addChildIfNotNull", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class EmittablesKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void addChild(@NotNull EmittableWithChildren emittableWithChildren, @NotNull Emittable e) {
        Intrinsics.checkNotNullParameter(emittableWithChildren, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        emittableWithChildren.getChildren().add(e);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void addChildIfNotNull(@NotNull EmittableWithChildren emittableWithChildren, @Nullable Emittable emittable) {
        Intrinsics.checkNotNullParameter(emittableWithChildren, "<this>");
        if (emittable != null) {
            emittableWithChildren.getChildren().add(emittable);
        }
    }
}
