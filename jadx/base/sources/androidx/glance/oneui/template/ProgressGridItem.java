package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.action.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/ProgressGridItem;", "Landroidx/glance/oneui/template/GridItem;", "progress", "Landroidx/glance/oneui/template/CircularProgressData;", "text", "Landroidx/glance/oneui/template/TextData;", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "(Landroidx/glance/oneui/template/CircularProgressData;Landroidx/glance/oneui/template/TextData;Ljava/lang/String;Landroidx/glance/action/Action;)V", "getProgress", "()Landroidx/glance/oneui/template/CircularProgressData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ProgressGridItem extends GridItem {
    public static final int $stable = 8;

    @NotNull
    private final CircularProgressData progress;

    public /* synthetic */ ProgressGridItem(CircularProgressData circularProgressData, TextData textData, String str, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(circularProgressData, (i & 2) != 0 ? null : textData, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : action);
    }

    @NotNull
    public final CircularProgressData getProgress() {
        return this.progress;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressGridItem(@NotNull CircularProgressData progress, @Nullable TextData textData, @Nullable String str, @Nullable Action action) {
        super(GlanceTemplateKt.getImageWithBackgroundDataNotDefined(), textData, null, str, action, null, false, 96, null);
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.progress = progress;
    }
}
