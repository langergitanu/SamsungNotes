package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/oneui/template/ListData;", "", "items", "", "Landroidx/glance/oneui/template/ListItem;", "contentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "dividerColor", "Landroidx/glance/unit/ColorProvider;", "scrollToPosition", "", "(Ljava/util/List;ILandroidx/glance/unit/ColorProvider;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentAlign-mnfRV0w", "()I", "I", "getDividerColor", "()Landroidx/glance/unit/ColorProvider;", "isScrollable", "", "isScrollable$glance_oneui_template_release", "()Z", "getItems", "()Ljava/util/List;", "getScrollToPosition", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ListData {
    public static final int $stable = 8;
    private final int contentAlign;

    @Nullable
    private final ColorProvider dividerColor;

    @NotNull
    private final List<ListItem> items;
    private final int scrollToPosition;

    public /* synthetic */ ListData(List list, int i, ColorProvider colorProvider, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, colorProvider, i2);
    }

    /* JADX INFO: renamed from: getContentAlign-mnfRV0w, reason: not valid java name and from getter */
    public final int getContentAlign() {
        return this.contentAlign;
    }

    @Nullable
    public final ColorProvider getDividerColor() {
        return this.dividerColor;
    }

    @NotNull
    public final List<ListItem> getItems() {
        return this.items;
    }

    public final int getScrollToPosition() {
        return this.scrollToPosition;
    }

    public final boolean isScrollable$glance_oneui_template_release() {
        int i = this.scrollToPosition;
        return i < 0 || i >= this.items.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ListData(List<? extends ListItem> items, int i, ColorProvider colorProvider, int i2) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.contentAlign = i;
        this.dividerColor = colorProvider;
        this.scrollToPosition = i2;
    }

    public /* synthetic */ ListData(List list, int i, ColorProvider colorProvider, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, (i4 & 4) != 0 ? null : colorProvider, (i4 & 8) != 0 ? -1 : i2, null);
    }
}
