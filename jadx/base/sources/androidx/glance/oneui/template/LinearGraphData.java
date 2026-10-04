package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/oneui/template/LinearGraphData;", "", "linearGraph", "Landroidx/glance/oneui/template/LinearGraph;", "text", "Landroidx/glance/oneui/template/TypedTextData;", "(Landroidx/glance/oneui/template/LinearGraph;Landroidx/glance/oneui/template/TypedTextData;)V", "textList", "Landroidx/glance/oneui/template/TypedTextListData;", "(Landroidx/glance/oneui/template/LinearGraph;Landroidx/glance/oneui/template/TypedTextListData;)V", "getLinearGraph$glance_oneui_template_release", "()Landroidx/glance/oneui/template/LinearGraph;", "getTextList$glance_oneui_template_release", "()Landroidx/glance/oneui/template/TypedTextListData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LinearGraphData {
    public static final int $stable = 8;

    @NotNull
    private final LinearGraph linearGraph;

    @NotNull
    private final TypedTextListData textList;

    public LinearGraphData(@NotNull LinearGraph linearGraph, @NotNull TypedTextListData textList) {
        Intrinsics.checkNotNullParameter(linearGraph, "linearGraph");
        Intrinsics.checkNotNullParameter(textList, "textList");
        this.linearGraph = linearGraph;
        this.textList = textList;
    }

    @NotNull
    /* JADX INFO: renamed from: getLinearGraph$glance_oneui_template_release, reason: from getter */
    public final LinearGraph getLinearGraph() {
        return this.linearGraph;
    }

    @NotNull
    /* JADX INFO: renamed from: getTextList$glance_oneui_template_release, reason: from getter */
    public final TypedTextListData getTextList() {
        return this.textList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearGraphData(@NotNull LinearGraph linearGraph, @NotNull TypedTextData text) {
        this(linearGraph, new TypedTextListData(CollectionsKt.listOf(text), null, 0, 6, null));
        Intrinsics.checkNotNullParameter(linearGraph, "linearGraph");
        Intrinsics.checkNotNullParameter(text, "text");
    }
}
