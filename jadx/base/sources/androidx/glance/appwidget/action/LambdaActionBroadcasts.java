package androidx.glance.appwidget.action;

import android.content.ComponentName;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/appwidget/action/LambdaActionBroadcasts;", "", "()V", "ActionTriggerLambda", "", "ExtraActionKey", "ExtraAppWidgetId", "createIntent", "Landroid/content/Intent;", "receiver", "Landroid/content/ComponentName;", "actionKey", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "createIntent$glance_appwidget_release", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LambdaActionBroadcasts {
    public static final int $stable = 0;

    @NotNull
    public static final String ActionTriggerLambda = "ACTION_TRIGGER_LAMBDA";

    @NotNull
    public static final String ExtraActionKey = "EXTRA_ACTION_KEY";

    @NotNull
    public static final String ExtraAppWidgetId = "EXTRA_APPWIDGET_ID";

    @NotNull
    public static final LambdaActionBroadcasts INSTANCE = new LambdaActionBroadcasts();

    private LambdaActionBroadcasts() {
    }

    @NotNull
    public final Intent createIntent$glance_appwidget_release(@NotNull ComponentName receiver, @NotNull String actionKey, int appWidgetId) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(actionKey, "actionKey");
        Intent intentPutExtra = new Intent().setComponent(receiver).setAction(ActionTriggerLambda).putExtra(ExtraActionKey, actionKey).putExtra(ExtraAppWidgetId, appWidgetId);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }
}
