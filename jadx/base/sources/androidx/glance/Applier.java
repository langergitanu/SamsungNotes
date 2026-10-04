package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0014J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/Applier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/glance/Emittable;", "root", "Landroidx/glance/EmittableWithChildren;", "(Landroidx/glance/EmittableWithChildren;)V", "currentChildren", "", "getCurrentChildren", "()Ljava/util/List;", "newRootMaxDepth", "", "insertBottomUp", "", "index", "instance", "insertTopDown", SecureFolderConstants.TEMP_FOLDER_NAME, Constants.MessagePayloadKeys.FROM, "to", "count", "onClear", "remove", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Applier extends AbstractApplier<Emittable> {
    public static final int $stable = 0;
    private final int newRootMaxDepth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Applier(@NotNull EmittableWithChildren root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
        this.newRootMaxDepth = root.getMaxDepth();
    }

    private final List<Emittable> getCurrentChildren() {
        Emittable current = getCurrent();
        if (current instanceof EmittableWithChildren) {
            return ((EmittableWithChildren) current).getChildren();
        }
        throw new IllegalStateException("Current node cannot accept children");
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int index, @NotNull Emittable instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int from, int to, int count) {
        move(getCurrentChildren(), from, to, count);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void onClear() {
        Emittable root = getRoot();
        Intrinsics.checkNotNull(root, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
        ((EmittableWithChildren) root).getChildren().clear();
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int index, int count) {
        remove(getCurrentChildren(), index, count);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int index, @NotNull Emittable instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Emittable current = getCurrent();
        Intrinsics.checkNotNull(current, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
        if (((EmittableWithChildren) current).getMaxDepth() <= 0) {
            Emittable root = getRoot();
            Intrinsics.checkNotNull(root, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
            throw new IllegalArgumentException(AbstractC0000a.m11h(((EmittableWithChildren) root).getMaxDepth(), "Too many embedded views for the current surface. The maximum depth is: ").toString());
        }
        if (instance instanceof EmittableWithChildren) {
            EmittableWithChildren emittableWithChildren = (EmittableWithChildren) instance;
            emittableWithChildren.setMaxDepth$glance_release(emittableWithChildren.getResetsDepthForChildren() ? this.newRootMaxDepth : r0.getMaxDepth() - 1);
        }
        getCurrentChildren().add(index, instance);
    }
}
