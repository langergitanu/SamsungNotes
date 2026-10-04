package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/TextBlockData;", "", "mainTextBlock", "Landroidx/glance/oneui/template/TextBlockItem;", "subTextBlock", "dividerColor", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/oneui/template/TextBlockItem;Landroidx/glance/oneui/template/TextBlockItem;Landroidx/glance/unit/ColorProvider;)V", "getDividerColor", "()Landroidx/glance/unit/ColorProvider;", "getMainTextBlock", "()Landroidx/glance/oneui/template/TextBlockItem;", "getSubTextBlock", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextBlockData {
    public static final int $stable = 8;

    @Nullable
    private final ColorProvider dividerColor;

    @NotNull
    private final TextBlockItem mainTextBlock;

    @Nullable
    private final TextBlockItem subTextBlock;

    public TextBlockData(@NotNull TextBlockItem mainTextBlock, @Nullable TextBlockItem textBlockItem, @Nullable ColorProvider colorProvider) {
        Intrinsics.checkNotNullParameter(mainTextBlock, "mainTextBlock");
        this.mainTextBlock = mainTextBlock;
        this.subTextBlock = textBlockItem;
        this.dividerColor = colorProvider;
        if (textBlockItem == null) {
            mainTextBlock.setMode$glance_oneui_template_release(0);
        } else {
            mainTextBlock.setMode$glance_oneui_template_release(1);
            textBlockItem.setMode$glance_oneui_template_release(2);
        }
    }

    @Nullable
    public final ColorProvider getDividerColor() {
        return this.dividerColor;
    }

    @NotNull
    public final TextBlockItem getMainTextBlock() {
        return this.mainTextBlock;
    }

    @Nullable
    public final TextBlockItem getSubTextBlock() {
        return this.subTextBlock;
    }

    public /* synthetic */ TextBlockData(TextBlockItem textBlockItem, TextBlockItem textBlockItem2, ColorProvider colorProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textBlockItem, (i & 2) != 0 ? null : textBlockItem2, (i & 4) != 0 ? null : colorProvider);
    }
}
