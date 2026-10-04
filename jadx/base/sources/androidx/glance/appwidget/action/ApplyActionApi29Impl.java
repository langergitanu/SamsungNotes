package androidx.glance.appwidget.action;

import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/glance/appwidget/action/ApplyActionApi29Impl;", "", "()V", "setIntentIdentifier", "Landroid/content/Intent;", MarketingConstants.LINK_TYPE_INTENT, "viewId", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class ApplyActionApi29Impl {

    @NotNull
    public static final ApplyActionApi29Impl INSTANCE = new ApplyActionApi29Impl();

    private ApplyActionApi29Impl() {
    }

    @DoNotInline
    @NotNull
    public final Intent setIntentIdentifier(@NotNull Intent intent, int viewId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.setIdentifier(String.valueOf(viewId));
        return intent;
    }
}
