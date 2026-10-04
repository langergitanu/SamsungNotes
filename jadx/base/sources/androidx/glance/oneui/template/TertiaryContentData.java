package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.layout.Alignment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nB%\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014BK\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u0006X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, m13886d2 = {"Landroidx/glance/oneui/template/TertiaryContentData;", "", "firstText", "Landroidx/glance/oneui/template/TypedTextData;", "secondText", "alignWithSecondaryContent", "Landroidx/glance/layout/Alignment$Horizontal;", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/TypedTextData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "textList", "Landroidx/glance/oneui/template/TypedTextListData;", "(Landroidx/glance/oneui/template/TypedTextListData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "firstProgressBar", "Landroidx/glance/oneui/template/LinearProgressData;", "secondProgressBar", "(Landroidx/glance/oneui/template/LinearProgressData;Landroidx/glance/oneui/template/LinearProgressData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "stackedGraph", "Landroidx/glance/oneui/template/StackedGraphData;", "(Landroidx/glance/oneui/template/StackedGraphData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", XmlErrorCodes.LIST, "Landroidx/glance/oneui/template/ListData;", "(Landroidx/glance/oneui/template/ListData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/glance/oneui/template/TypedTextListData;Landroidx/glance/oneui/template/LinearProgressData;Landroidx/glance/oneui/template/LinearProgressData;Landroidx/glance/oneui/template/StackedGraphData;Landroidx/glance/oneui/template/ListData;)V", "getAlignWithSecondaryContent-PGIyAqw$glance_oneui_template_release", "()I", "I", "getFirstProgressBar$glance_oneui_template_release", "()Landroidx/glance/oneui/template/LinearProgressData;", "getList$glance_oneui_template_release", "()Landroidx/glance/oneui/template/ListData;", "getSecondProgressBar$glance_oneui_template_release", "getStackedGraph$glance_oneui_template_release", "()Landroidx/glance/oneui/template/StackedGraphData;", "getTextList$glance_oneui_template_release", "()Landroidx/glance/oneui/template/TypedTextListData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TertiaryContentData {
    public static final int $stable = 8;
    private final int alignWithSecondaryContent;

    @Nullable
    private final LinearProgressData firstProgressBar;

    @Nullable
    private final ListData list;

    @Nullable
    private final LinearProgressData secondProgressBar;

    @Nullable
    private final StackedGraphData stackedGraph;

    @Nullable
    private final TypedTextListData textList;

    public /* synthetic */ TertiaryContentData(LinearProgressData linearProgressData, LinearProgressData linearProgressData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(linearProgressData, linearProgressData2, i);
    }

    /* JADX INFO: renamed from: getAlignWithSecondaryContent-PGIyAqw$glance_oneui_template_release, reason: from getter */
    public final int getAlignWithSecondaryContent() {
        return this.alignWithSecondaryContent;
    }

    @Nullable
    /* JADX INFO: renamed from: getFirstProgressBar$glance_oneui_template_release, reason: from getter */
    public final LinearProgressData getFirstProgressBar() {
        return this.firstProgressBar;
    }

    @Nullable
    /* JADX INFO: renamed from: getList$glance_oneui_template_release, reason: from getter */
    public final ListData getList() {
        return this.list;
    }

    @Nullable
    /* JADX INFO: renamed from: getSecondProgressBar$glance_oneui_template_release, reason: from getter */
    public final LinearProgressData getSecondProgressBar() {
        return this.secondProgressBar;
    }

    @Nullable
    /* JADX INFO: renamed from: getStackedGraph$glance_oneui_template_release, reason: from getter */
    public final StackedGraphData getStackedGraph() {
        return this.stackedGraph;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextList$glance_oneui_template_release, reason: from getter */
    public final TypedTextListData getTextList() {
        return this.textList;
    }

    public /* synthetic */ TertiaryContentData(ListData listData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(listData, i);
    }

    public /* synthetic */ TertiaryContentData(StackedGraphData stackedGraphData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackedGraphData, i);
    }

    public /* synthetic */ TertiaryContentData(TypedTextData typedTextData, TypedTextData typedTextData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextData, typedTextData2, i);
    }

    public /* synthetic */ TertiaryContentData(TypedTextListData typedTextListData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextListData, i);
    }

    private TertiaryContentData(int i, TypedTextListData typedTextListData, LinearProgressData linearProgressData, LinearProgressData linearProgressData2, StackedGraphData stackedGraphData, ListData listData) {
        this.alignWithSecondaryContent = i;
        this.textList = typedTextListData;
        this.firstProgressBar = linearProgressData;
        this.secondProgressBar = linearProgressData2;
        this.stackedGraph = stackedGraphData;
        this.list = listData;
    }

    public /* synthetic */ TertiaryContentData(int i, TypedTextListData typedTextListData, LinearProgressData linearProgressData, LinearProgressData linearProgressData2, StackedGraphData stackedGraphData, ListData listData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : typedTextListData, (i2 & 4) != 0 ? null : linearProgressData, (i2 & 8) != 0 ? null : linearProgressData2, (i2 & 16) != 0 ? null : stackedGraphData, (i2 & 32) != 0 ? null : listData);
    }

    public /* synthetic */ TertiaryContentData(TypedTextData typedTextData, TypedTextData typedTextData2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextData, (i2 & 2) != 0 ? null : typedTextData2, (i2 & 4) != 0 ? Alignment.INSTANCE.m21432getEndPGIyAqw() : i, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    private TertiaryContentData(TypedTextData firstText, TypedTextData typedTextData, int i) {
        Intrinsics.checkNotNullParameter(firstText, "firstText");
        List listListOf = typedTextData != null ? CollectionsKt.listOf((Object[]) new TypedTextData[]{firstText, typedTextData}) : CollectionsKt.listOf(firstText);
        Object[] objArr = 0 == true ? 1 : 0;
        this(i, new TypedTextListData(listListOf, null, 0, 6, null), null, null, objArr, null, 60, null);
    }

    public /* synthetic */ TertiaryContentData(TypedTextListData typedTextListData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextListData, (i2 & 2) != 0 ? Alignment.INSTANCE.m21432getEndPGIyAqw() : i, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TertiaryContentData(TypedTextListData textList, int i) {
        this(i, textList, null, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(textList, "textList");
    }

    public /* synthetic */ TertiaryContentData(LinearProgressData linearProgressData, LinearProgressData linearProgressData2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(linearProgressData, (i2 & 2) != 0 ? null : linearProgressData2, (i2 & 4) != 0 ? Alignment.INSTANCE.m21432getEndPGIyAqw() : i, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TertiaryContentData(LinearProgressData firstProgressBar, LinearProgressData linearProgressData, int i) {
        this(i, null, firstProgressBar, linearProgressData, null, null, 50, null);
        Intrinsics.checkNotNullParameter(firstProgressBar, "firstProgressBar");
    }

    public /* synthetic */ TertiaryContentData(StackedGraphData stackedGraphData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackedGraphData, (i2 & 2) != 0 ? Alignment.INSTANCE.m21432getEndPGIyAqw() : i, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TertiaryContentData(StackedGraphData stackedGraph, int i) {
        this(i, null, null, null, stackedGraph, null, 46, null);
        Intrinsics.checkNotNullParameter(stackedGraph, "stackedGraph");
    }

    public /* synthetic */ TertiaryContentData(ListData listData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(listData, (i2 & 2) != 0 ? Alignment.INSTANCE.m21432getEndPGIyAqw() : i, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TertiaryContentData(ListData list, int i) {
        this(i, null, null, null, null, list, 30, null);
        Intrinsics.checkNotNullParameter(list, "list");
    }
}
