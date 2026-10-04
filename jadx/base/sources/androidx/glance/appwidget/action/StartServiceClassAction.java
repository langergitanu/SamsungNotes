package androidx.glance.appwidget.action;

import android.app.Service;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/appwidget/action/StartServiceClassAction;", "Landroidx/glance/appwidget/action/StartServiceAction;", "serviceClass", "Ljava/lang/Class;", "Landroid/app/Service;", "isForegroundService", "", "(Ljava/lang/Class;Z)V", "()Z", "getServiceClass", "()Ljava/lang/Class;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StartServiceClassAction implements StartServiceAction {
    public static final int $stable = 8;
    private final boolean isForegroundService;

    @NotNull
    private final Class<? extends Service> serviceClass;

    public StartServiceClassAction(@NotNull Class<? extends Service> serviceClass, boolean z) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        this.serviceClass = serviceClass;
        this.isForegroundService = z;
    }

    @NotNull
    public final Class<? extends Service> getServiceClass() {
        return this.serviceClass;
    }

    @Override // androidx.glance.appwidget.action.StartServiceAction
    /* JADX INFO: renamed from: isForegroundService, reason: from getter */
    public boolean getIsForegroundService() {
        return this.isForegroundService;
    }
}
