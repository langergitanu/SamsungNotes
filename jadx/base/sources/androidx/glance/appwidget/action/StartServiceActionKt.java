package androidx.glance.appwidget.action;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import androidx.glance.action.Action;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a(\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b¨\u0006\f"}, m13886d2 = {"actionStartService", "Landroidx/glance/action/Action;", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "isForegroundService", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "T", "Landroid/app/Service;", "service", "Ljava/lang/Class;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class StartServiceActionKt {
    @NotNull
    public static final Action actionStartService(@NotNull Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return new StartServiceIntentAction(intent, z);
    }

    public static /* synthetic */ Action actionStartService$default(Intent intent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return actionStartService(intent, z);
    }

    @NotNull
    public static final Action actionStartService(@NotNull ComponentName componentName, boolean z) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        return new StartServiceComponentAction(componentName, z);
    }

    public static /* synthetic */ Action actionStartService$default(ComponentName componentName, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return actionStartService(componentName, z);
    }

    @NotNull
    public static final <T extends Service> Action actionStartService(@NotNull Class<T> service, boolean z) {
        Intrinsics.checkNotNullParameter(service, "service");
        return new StartServiceClassAction(service, z);
    }

    public static /* synthetic */ Action actionStartService$default(Class cls, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return actionStartService(cls, z);
    }

    public static final /* synthetic */ <T extends Service> Action actionStartService(boolean z) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionStartService(Service.class, z);
    }

    public static /* synthetic */ Action actionStartService$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return actionStartService(Service.class, z);
    }
}
