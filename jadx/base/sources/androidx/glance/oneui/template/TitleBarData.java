package androidx.glance.oneui.template;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/oneui/template/TitleBarData;", "", "title", "Landroidx/glance/oneui/template/TextData;", "subtitle", "actionButton1", "Landroidx/glance/oneui/template/ActionButtonData;", "actionButton2", "isOverlayWithContent", "", "(Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/ActionButtonData;Landroidx/glance/oneui/template/ActionButtonData;Z)V", "getActionButton1", "()Landroidx/glance/oneui/template/ActionButtonData;", "getActionButton2", "()Z", "showTitleBar", "getShowTitleBar", "(Landroidx/compose/runtime/Composer;I)Z", "getSubtitle", "()Landroidx/glance/oneui/template/TextData;", DynamicActionBarProvider.METHOD_GET_DATA, "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceTemplate.kt\nandroidx/glance/oneui/template/TitleBarData\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,673:1\n74#2:674\n*S KotlinDebug\n*F\n+ 1 GlanceTemplate.kt\nandroidx/glance/oneui/template/TitleBarData\n*L\n619#1:674\n*E\n"})
public final class TitleBarData {
    public static final int $stable = 8;

    @Nullable
    private final ActionButtonData actionButton1;

    @Nullable
    private final ActionButtonData actionButton2;
    private final boolean isOverlayWithContent;

    @Nullable
    private final TextData subtitle;

    @NotNull
    private final TextData title;

    public TitleBarData(@NotNull TextData title, @Nullable TextData textData, @Nullable ActionButtonData actionButtonData, @Nullable ActionButtonData actionButtonData2, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.subtitle = textData;
        this.actionButton1 = actionButtonData;
        this.actionButton2 = actionButtonData2;
        this.isOverlayWithContent = z;
    }

    @Nullable
    public final ActionButtonData getActionButton1() {
        return this.actionButton1;
    }

    @Nullable
    public final ActionButtonData getActionButton2() {
        return this.actionButton2;
    }

    @Composable
    @JvmName(name = "getShowTitleBar")
    public final boolean getShowTitleBar(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1042985241);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1042985241, i, -1, "androidx.glance.oneui.template.TitleBarData.<get-showTitleBar> (GlanceTemplate.kt:618)");
        }
        boolean z = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4()) >= 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }

    @Nullable
    public final TextData getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final TextData getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isOverlayWithContent, reason: from getter */
    public final boolean getIsOverlayWithContent() {
        return this.isOverlayWithContent;
    }

    public /* synthetic */ TitleBarData(TextData textData, TextData textData2, ActionButtonData actionButtonData, ActionButtonData actionButtonData2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textData, (i & 2) != 0 ? null : textData2, (i & 4) != 0 ? null : actionButtonData, (i & 8) != 0 ? null : actionButtonData2, (i & 16) != 0 ? false : z);
    }
}
