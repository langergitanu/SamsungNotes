package androidx.glance.action;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.action.ActionParameters;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a+\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0087\b\u001a(\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a6\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\f"}, m13886d2 = {"actionStartActivity", "Landroidx/glance/action/Action;", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "parameters", "Landroidx/glance/action/ActionParameters;", "activityOptions", "Landroid/os/Bundle;", "T", "Landroid/app/Activity;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Ljava/lang/Class;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class StartActivityActionKt {
    @NotNull
    public static final Action actionStartActivity(@NotNull ComponentName componentName, @NotNull ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new StartActivityComponentAction(componentName, parameters, null);
    }

    public static /* synthetic */ Action actionStartActivity$default(ComponentName componentName, ActionParameters actionParameters, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        return actionStartActivity(componentName, actionParameters);
    }

    @ExperimentalGlanceApi
    @NotNull
    public static final Action actionStartActivity(@NotNull ComponentName componentName, @NotNull ActionParameters parameters, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new StartActivityComponentAction(componentName, parameters, bundle);
    }

    @NotNull
    public static final <T extends Activity> Action actionStartActivity(@NotNull Class<T> activity, @NotNull ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new StartActivityClassAction(activity, parameters, null);
    }

    public static /* synthetic */ Action actionStartActivity$default(ComponentName componentName, ActionParameters actionParameters, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        return actionStartActivity(componentName, actionParameters, bundle);
    }

    @ExperimentalGlanceApi
    @NotNull
    public static final <T extends Activity> Action actionStartActivity(@NotNull Class<T> activity, @NotNull ActionParameters parameters, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new StartActivityClassAction(activity, parameters, bundle);
    }

    public static final /* synthetic */ <T extends Activity> Action actionStartActivity(ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionStartActivity(Activity.class, parameters);
    }

    public static /* synthetic */ Action actionStartActivity$default(Class cls, ActionParameters actionParameters, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        return actionStartActivity(cls, actionParameters);
    }

    @ExperimentalGlanceApi
    public static final /* synthetic */ <T extends Activity> Action actionStartActivity(ActionParameters parameters, Bundle bundle) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionStartActivity(Activity.class, parameters, bundle);
    }

    public static /* synthetic */ Action actionStartActivity$default(Class cls, ActionParameters actionParameters, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        return actionStartActivity(cls, actionParameters, bundle);
    }

    public static /* synthetic */ Action actionStartActivity$default(ActionParameters parameters, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionStartActivity(Activity.class, parameters);
    }

    public static /* synthetic */ Action actionStartActivity$default(ActionParameters parameters, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        if ((i & 2) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionStartActivity(Activity.class, parameters, bundle);
    }
}
