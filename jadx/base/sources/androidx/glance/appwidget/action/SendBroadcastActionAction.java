package androidx.glance.appwidget.action;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/appwidget/action/SendBroadcastActionAction;", "Landroidx/glance/appwidget/action/SendBroadcastAction;", "action", "", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "(Ljava/lang/String;Landroid/content/ComponentName;)V", "getAction", "()Ljava/lang/String;", "getComponentName", "()Landroid/content/ComponentName;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SendBroadcastActionAction implements SendBroadcastAction {
    public static final int $stable = 8;

    @NotNull
    private final String action;

    @Nullable
    private final ComponentName componentName;

    public SendBroadcastActionAction(@NotNull String action, @Nullable ComponentName componentName) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.componentName = componentName;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public /* synthetic */ SendBroadcastActionAction(String str, ComponentName componentName, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : componentName);
    }
}
