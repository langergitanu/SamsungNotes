package androidx.glance.appwidget.action;

import androidx.glance.action.Action;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.ActionParametersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a(\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\b"}, m13886d2 = {"actionRunCallback", "Landroidx/glance/action/Action;", "T", "Landroidx/glance/appwidget/action/ActionCallback;", "parameters", "Landroidx/glance/action/ActionParameters;", "callbackClass", "Ljava/lang/Class;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class RunCallbackActionKt {
    @NotNull
    public static final <T extends ActionCallback> Action actionRunCallback(@NotNull Class<T> callbackClass, @NotNull ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(callbackClass, "callbackClass");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new RunCallbackAction(callbackClass, parameters);
    }

    public static /* synthetic */ Action actionRunCallback$default(Class cls, ActionParameters actionParameters, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        return actionRunCallback(cls, actionParameters);
    }

    public static final /* synthetic */ <T extends ActionCallback> Action actionRunCallback(ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionRunCallback(ActionCallback.class, parameters);
    }

    public static /* synthetic */ Action actionRunCallback$default(ActionParameters parameters, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionRunCallback(ActionCallback.class, parameters);
    }
}
