package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.action.Action;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/oneui/template/ActionButtonData;", "Landroidx/glance/oneui/template/ImageButtonData;", "actionIcon", "Landroidx/glance/oneui/template/ActionIcon;", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "iconTintColor", "Landroidx/glance/unit/ColorProvider;", "enabled", "", "keepColor", "(Landroidx/glance/oneui/template/ActionIcon;Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/unit/ColorProvider;ZZ)V", "getActionIcon", "()Landroidx/glance/oneui/template/ActionIcon;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ActionButtonData extends ImageButtonData {
    public static final int $stable = 0;

    @NotNull
    private final ActionIcon actionIcon;

    public /* synthetic */ ActionButtonData(ActionIcon actionIcon, String str, Action action, ColorProvider colorProvider, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(actionIcon, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : action, (i & 8) != 0 ? null : colorProvider, (i & 16) != 0 ? true : z, (i & 32) != 0 ? false : z2);
    }

    @NotNull
    public final ActionIcon getActionIcon() {
        return this.actionIcon;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionButtonData(@NotNull ActionIcon actionIcon, @Nullable String str, @Nullable Action action, @Nullable ColorProvider colorProvider, boolean z, boolean z2) {
        super(actionIcon.getImageProvider(), str, ImageType.Icon, null, 0, colorProvider, null, action, z, z2, 88, null);
        Intrinsics.checkNotNullParameter(actionIcon, "actionIcon");
        this.actionIcon = actionIcon;
    }
}
