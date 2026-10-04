package androidx.glance.appwidget.action;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import androidx.glance.action.Action;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\f"}, m13886d2 = {"actionSendBroadcast", "Landroidx/glance/action/Action;", "T", "Landroid/content/BroadcastReceiver;", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "receiver", "Ljava/lang/Class;", "action", "", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SendBroadcastActionKt {
    @NotNull
    public static final Action actionSendBroadcast(@NotNull String action, @Nullable ComponentName componentName) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new SendBroadcastActionAction(action, componentName);
    }

    public static /* synthetic */ Action actionSendBroadcast$default(String str, ComponentName componentName, int i, Object obj) {
        if ((i & 2) != 0) {
            componentName = null;
        }
        return actionSendBroadcast(str, componentName);
    }

    @NotNull
    public static final Action actionSendBroadcast(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return new SendBroadcastIntentAction(intent);
    }

    @NotNull
    public static final Action actionSendBroadcast(@NotNull ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        return new SendBroadcastComponentAction(componentName);
    }

    @NotNull
    public static final <T extends BroadcastReceiver> Action actionSendBroadcast(@NotNull Class<T> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        return new SendBroadcastClassAction(receiver);
    }

    public static final /* synthetic */ <T extends BroadcastReceiver> Action actionSendBroadcast() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionSendBroadcast(BroadcastReceiver.class);
    }
}
