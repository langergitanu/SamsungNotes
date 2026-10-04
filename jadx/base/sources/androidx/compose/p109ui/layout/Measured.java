package androidx.compose.p109ui.layout;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH¦\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/layout/Measured;", "", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredWidth", "getMeasuredWidth", "parentData", "getParentData", "()Ljava/lang/Object;", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface Measured {
    int get(@NotNull AlignmentLine alignmentLine);

    int getMeasuredHeight();

    int getMeasuredWidth();

    @Nullable
    default Object getParentData() {
        return null;
    }
}
