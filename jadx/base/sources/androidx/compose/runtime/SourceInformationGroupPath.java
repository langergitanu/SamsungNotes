package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/runtime/SourceInformationGroupPath;", "", "()V", "getIdentity", "table", "Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/AnchoredGroupPath;", "Landroidx/compose/runtime/RelativeGroupPath;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
abstract class SourceInformationGroupPath {
    public /* synthetic */ SourceInformationGroupPath(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract Object getIdentity(@NotNull SlotTable table);

    private SourceInformationGroupPath() {
    }
}
