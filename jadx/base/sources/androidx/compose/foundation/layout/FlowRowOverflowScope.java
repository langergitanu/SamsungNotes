package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@LayoutScopeMarker
@ExperimentalLayoutApi
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflowScope;", "Landroidx/compose/foundation/layout/FlowRowScope;", "shownItemCount", "", "getShownItemCount$annotations", "()V", "getShownItemCount", "()I", "totalItemCount", "getTotalItemCount$annotations", "getTotalItemCount", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
public interface FlowRowOverflowScope extends FlowRowScope {
    int getShownItemCount();

    int getTotalItemCount();

    @ExperimentalLayoutApi
    static /* synthetic */ void getShownItemCount$annotations() {
    }

    @ExperimentalLayoutApi
    static /* synthetic */ void getTotalItemCount$annotations() {
    }
}
