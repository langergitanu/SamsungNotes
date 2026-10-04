package androidx.compose.p109ui.platform;

import androidx.collection.IntObjectMap;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.compose.p109ui.semantics.SemanticsConfiguration;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/ui/platform/SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/collection/IntObjectMap;)V", "children", "Landroidx/collection/MutableIntSet;", "getChildren", "()Landroidx/collection/MutableIntSet;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSemanticsUtils.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticsUtils.android.kt\nandroidx/compose/ui/platform/SemanticsNodeCopy\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,233:1\n33#2,6:234\n*S KotlinDebug\n*F\n+ 1 SemanticsUtils.android.kt\nandroidx/compose/ui/platform/SemanticsNodeCopy\n*L\n53#1:234,6\n*E\n"})
public final class SemanticsNodeCopy {
    public static final int $stable = 8;

    @NotNull
    private final MutableIntSet children = IntSetKt.mutableIntSetOf();

    @NotNull
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNodeCopy(@NotNull SemanticsNode semanticsNode, @NotNull IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        this.unmergedConfig = semanticsNode.getUnmergedConfig();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (intObjectMap.contains(semanticsNode2.getId())) {
                this.children.add(semanticsNode2.getId());
            }
        }
    }

    @NotNull
    public final MutableIntSet getChildren() {
        return this.children;
    }

    @NotNull
    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }
}
