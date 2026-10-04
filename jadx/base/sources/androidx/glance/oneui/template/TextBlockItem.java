package androidx.glance.oneui.template;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceTheme;
import androidx.glance.action.Action;
import androidx.glance.layout.Alignment;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, m13886d2 = {"Landroidx/glance/oneui/template/TextBlockItem;", "", "textList", "Landroidx/glance/oneui/template/TypedTextListData;", "contentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "applyInverseColor", "", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "(Landroidx/glance/oneui/template/TypedTextListData;IZLjava/lang/String;Landroidx/glance/action/Action;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getApplyInverseColor", "()Z", "getContentAlign-mnfRV0w", "()I", "I", "getContentDescription", "()Ljava/lang/String;", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "getDefaultTextColor", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/unit/ColorProvider;", "fromSingleBlock", "getFromSingleBlock$glance_oneui_template_release", "mode", "", "getMode$glance_oneui_template_release", "setMode$glance_oneui_template_release", "(I)V", "getOnClick", "()Landroidx/glance/action/Action;", "getTextList", "()Landroidx/glance/oneui/template/TypedTextListData;", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextBlockItem {
    public static final int TEXT_BLOCK_MODE_DUAL_MAIN = 1;
    public static final int TEXT_BLOCK_MODE_DUAL_SUB = 2;
    public static final int TEXT_BLOCK_MODE_SINGLE_MAIN = 0;
    private final boolean applyInverseColor;
    private final int contentAlign;

    @Nullable
    private final String contentDescription;
    private int mode;

    @Nullable
    private final Action onClick;

    @NotNull
    private final TypedTextListData textList;
    public static final int $stable = 8;

    public /* synthetic */ TextBlockItem(TypedTextListData typedTextListData, int i, boolean z, String str, Action action, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextListData, i, z, str, action);
    }

    public final boolean getApplyInverseColor() {
        return this.applyInverseColor;
    }

    /* JADX INFO: renamed from: getContentAlign-mnfRV0w, reason: not valid java name and from getter */
    public final int getContentAlign() {
        return this.contentAlign;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @JvmName(name = "getDefaultTextColor")
    @NotNull
    @Composable
    public final ColorProvider getDefaultTextColor(@Nullable Composer composer, int i) {
        ColorProvider onBackground;
        composer.startReplaceableGroup(1261169547);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1261169547, i, -1, "androidx.glance.oneui.template.TextBlockItem.<get-defaultTextColor> (TextBlockTemplate.kt:115)");
        }
        if (this.applyInverseColor) {
            composer.startReplaceableGroup(-596729239);
            onBackground = GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getInverseOnSurface();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-596729166);
            onBackground = GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getOnBackground();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return onBackground;
    }

    public final boolean getFromSingleBlock$glance_oneui_template_release() {
        return this.mode == 0;
    }

    /* JADX INFO: renamed from: getMode$glance_oneui_template_release, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    @Nullable
    public final Action getOnClick() {
        return this.onClick;
    }

    @NotNull
    public final TypedTextListData getTextList() {
        return this.textList;
    }

    public final void setMode$glance_oneui_template_release(int i) {
        this.mode = i;
    }

    private TextBlockItem(TypedTextListData textList, int i, boolean z, String str, Action action) {
        Intrinsics.checkNotNullParameter(textList, "textList");
        this.textList = textList;
        this.contentAlign = i;
        this.applyInverseColor = z;
        this.contentDescription = str;
        this.onClick = action;
    }

    public /* synthetic */ TextBlockItem(TypedTextListData typedTextListData, int i, boolean z, String str, Action action, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextListData, (i2 & 2) != 0 ? Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w() : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : action, null);
    }
}
