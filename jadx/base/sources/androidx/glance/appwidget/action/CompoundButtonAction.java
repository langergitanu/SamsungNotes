package androidx.glance.appwidget.action;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.action.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/action/CompoundButtonAction;", "Landroidx/glance/action/Action;", "innerAction", "checked", "", "(Landroidx/glance/action/Action;Z)V", "getChecked", "()Z", "getInnerAction", "()Landroidx/glance/action/Action;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CompoundButtonAction implements Action {
    public static final int $stable = 8;
    private final boolean checked;

    @NotNull
    private final Action innerAction;

    public CompoundButtonAction(@NotNull Action innerAction, boolean z) {
        Intrinsics.checkNotNullParameter(innerAction, "innerAction");
        this.innerAction = innerAction;
        this.checked = z;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @NotNull
    public final Action getInnerAction() {
        return this.innerAction;
    }
}
