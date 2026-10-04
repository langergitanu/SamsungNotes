package androidx.glance.appwidget.action;

import android.content.BroadcastReceiver;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/glance/appwidget/action/SendBroadcastClassAction;", "Landroidx/glance/appwidget/action/SendBroadcastAction;", "receiverClass", "Ljava/lang/Class;", "Landroid/content/BroadcastReceiver;", "(Ljava/lang/Class;)V", "getReceiverClass", "()Ljava/lang/Class;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SendBroadcastClassAction implements SendBroadcastAction {
    public static final int $stable = 8;

    @NotNull
    private final Class<? extends BroadcastReceiver> receiverClass;

    public SendBroadcastClassAction(@NotNull Class<? extends BroadcastReceiver> receiverClass) {
        Intrinsics.checkNotNullParameter(receiverClass, "receiverClass");
        this.receiverClass = receiverClass;
    }

    @NotNull
    public final Class<? extends BroadcastReceiver> getReceiverClass() {
        return this.receiverClass;
    }
}
