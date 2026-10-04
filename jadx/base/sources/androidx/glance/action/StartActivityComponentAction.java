package androidx.glance.action;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/action/StartActivityComponentAction;", "Landroidx/glance/action/StartActivityAction;", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "parameters", "Landroidx/glance/action/ActionParameters;", "activityOptions", "Landroid/os/Bundle;", "(Landroid/content/ComponentName;Landroidx/glance/action/ActionParameters;Landroid/os/Bundle;)V", "getActivityOptions", "()Landroid/os/Bundle;", "getComponentName", "()Landroid/content/ComponentName;", "getParameters", "()Landroidx/glance/action/ActionParameters;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StartActivityComponentAction implements StartActivityAction {
    public static final int $stable = 8;

    @Nullable
    private final Bundle activityOptions;

    @NotNull
    private final ComponentName componentName;

    @NotNull
    private final ActionParameters parameters;

    public StartActivityComponentAction(@NotNull ComponentName componentName, @NotNull ActionParameters parameters, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.componentName = componentName;
        this.parameters = parameters;
        this.activityOptions = bundle;
    }

    @Override // androidx.glance.action.StartActivityAction
    @Nullable
    public Bundle getActivityOptions() {
        return this.activityOptions;
    }

    @NotNull
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Override // androidx.glance.action.StartActivityAction
    @NotNull
    public ActionParameters getParameters() {
        return this.parameters;
    }
}
