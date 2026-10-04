package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b'\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0004R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/EmittableWithChildren;", "Landroidx/glance/Emittable;", "maxDepth", "", "resetsDepthForChildren", "", "(IZ)V", "children", "", "getChildren", "()Ljava/util/List;", "getMaxDepth$glance_release", "()I", "setMaxDepth$glance_release", "(I)V", "getResetsDepthForChildren$glance_release", "()Z", "childrenToString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class EmittableWithChildren implements Emittable {
    public static final int $stable = 8;

    @NotNull
    private final List<Emittable> children;
    private int maxDepth;
    private final boolean resetsDepthForChildren;

    /* JADX WARN: Multi-variable type inference failed */
    public EmittableWithChildren() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    @NotNull
    public final String childrenToString() {
        return StringsKt__IndentKt.prependIndent(CollectionsKt.m13955n(this.children, ",\n", null, null, null, 62), Constant.WHITE_SPACE_FOR_LINK_ICON);
    }

    @NotNull
    public final List<Emittable> getChildren() {
        return this.children;
    }

    /* JADX INFO: renamed from: getMaxDepth$glance_release, reason: from getter */
    public final int getMaxDepth() {
        return this.maxDepth;
    }

    /* JADX INFO: renamed from: getResetsDepthForChildren$glance_release, reason: from getter */
    public final boolean getResetsDepthForChildren() {
        return this.resetsDepthForChildren;
    }

    public final void setMaxDepth$glance_release(int i) {
        this.maxDepth = i;
    }

    public EmittableWithChildren(int i, boolean z) {
        this.maxDepth = i;
        this.resetsDepthForChildren = z;
        this.children = new ArrayList();
    }

    public /* synthetic */ EmittableWithChildren(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? false : z);
    }
}
