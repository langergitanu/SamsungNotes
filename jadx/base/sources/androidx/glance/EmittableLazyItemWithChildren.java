package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.layout.Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Landroidx/glance/EmittableLazyItemWithChildren;", "Landroidx/glance/EmittableWithChildren;", "()V", "alignment", "Landroidx/glance/layout/Alignment;", "getAlignment", "()Landroidx/glance/layout/Alignment;", "setAlignment", "(Landroidx/glance/layout/Alignment;)V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class EmittableLazyItemWithChildren extends EmittableWithChildren {
    public static final int $stable = 8;

    @NotNull
    private Alignment alignment;

    public EmittableLazyItemWithChildren() {
        super(0, false, 3, null);
        this.alignment = Alignment.INSTANCE.getCenterStart();
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }
}
