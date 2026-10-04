package androidx.glance.action;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/action/StartActivityClassAction;", "Landroidx/glance/action/StartActivityAction;", "activityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "parameters", "Landroidx/glance/action/ActionParameters;", "activityOptions", "Landroid/os/Bundle;", "(Ljava/lang/Class;Landroidx/glance/action/ActionParameters;Landroid/os/Bundle;)V", "getActivityClass", "()Ljava/lang/Class;", "getActivityOptions", "()Landroid/os/Bundle;", "getParameters", "()Landroidx/glance/action/ActionParameters;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StartActivityClassAction implements StartActivityAction {
    public static final int $stable = 8;

    @NotNull
    private final Class<? extends Activity> activityClass;

    @Nullable
    private final Bundle activityOptions;

    @NotNull
    private final ActionParameters parameters;

    public StartActivityClassAction(@NotNull Class<? extends Activity> activityClass, @NotNull ActionParameters parameters, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activityClass, "activityClass");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.activityClass = activityClass;
        this.parameters = parameters;
        this.activityOptions = bundle;
    }

    @NotNull
    public final Class<? extends Activity> getActivityClass() {
        return this.activityClass;
    }

    @Override // androidx.glance.action.StartActivityAction
    @Nullable
    public Bundle getActivityOptions() {
        return this.activityOptions;
    }

    @Override // androidx.glance.action.StartActivityAction
    @NotNull
    public ActionParameters getParameters() {
        return this.parameters;
    }
}
