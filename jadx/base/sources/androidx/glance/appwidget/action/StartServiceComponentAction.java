package androidx.glance.appwidget.action;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/action/StartServiceComponentAction;", "Landroidx/glance/appwidget/action/StartServiceAction;", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "isForegroundService", "", "(Landroid/content/ComponentName;Z)V", "getComponentName", "()Landroid/content/ComponentName;", "()Z", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StartServiceComponentAction implements StartServiceAction {
    public static final int $stable = 8;

    @NotNull
    private final ComponentName componentName;
    private final boolean isForegroundService;

    public StartServiceComponentAction(@NotNull ComponentName componentName, boolean z) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        this.componentName = componentName;
        this.isForegroundService = z;
    }

    @NotNull
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Override // androidx.glance.appwidget.action.StartServiceAction
    /* JADX INFO: renamed from: isForegroundService, reason: from getter */
    public boolean getIsForegroundService() {
        return this.isForegroundService;
    }
}
