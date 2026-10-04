package androidx.glance.appwidget.action;

import android.content.Intent;
import android.os.Bundle;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.action.Action;
import androidx.glance.action.ActionParameters;
import androidx.glance.action.ActionParametersKt;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, m13886d2 = {"actionStartActivity", "Landroidx/glance/action/Action;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "parameters", "Landroidx/glance/action/ActionParameters;", "activityOptions", "Landroid/os/Bundle;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class StartActivityIntentActionKt {
    @NotNull
    public static final Action actionStartActivity(@NotNull Intent intent, @NotNull ActionParameters parameters) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new StartActivityIntentAction(intent, parameters, null);
    }

    public static /* synthetic */ Action actionStartActivity$default(Intent intent, ActionParameters actionParameters, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        return actionStartActivity(intent, actionParameters);
    }

    @ExperimentalGlanceApi
    @NotNull
    public static final Action actionStartActivity(@NotNull Intent intent, @NotNull ActionParameters parameters, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new StartActivityIntentAction(intent, parameters, bundle);
    }

    public static /* synthetic */ Action actionStartActivity$default(Intent intent, ActionParameters actionParameters, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            actionParameters = ActionParametersKt.actionParametersOf(new ActionParameters.Pair[0]);
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        return actionStartActivity(intent, actionParameters, bundle);
    }
}
