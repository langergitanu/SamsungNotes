package androidx.glance.appwidget.action;

import androidx.glance.action.ActionParameters;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"ToggleableStateKey", "Landroidx/glance/action/ActionParameters$Key;", "", "getToggleableStateKey", "()Landroidx/glance/action/ActionParameters$Key;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ToggleableKt {

    @NotNull
    private static final ActionParameters.Key<Boolean> ToggleableStateKey = new ActionParameters.Key<>("android.widget.extra.CHECKED");

    @NotNull
    public static final ActionParameters.Key<Boolean> getToggleableStateKey() {
        return ToggleableStateKey;
    }
}
