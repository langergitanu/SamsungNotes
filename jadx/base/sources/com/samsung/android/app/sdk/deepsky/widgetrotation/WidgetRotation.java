package com.samsung.android.app.sdk.deepsky.widgetrotation;

import android.app.PendingIntent;
import android.content.ComponentName;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.samsung.android.app.sdk.deepsky.contract.widget.WidgetContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/widgetrotation/WidgetRotation;", "", WidgetContract.DISABLE_WIDGET_FOCUS, "", "stackId", "", WidgetContract.ENABLE_WIDGET_FOCUS, "widgetComponentNameList", "Ljava/util/ArrayList;", "Landroid/content/ComponentName;", "Lkotlin/collections/ArrayList;", "getEnabledIdList", "", "isEnabled", "isSubscribed", WidgetContract.SUBSCRIBE_WIDGET_FOCUS, BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", WidgetContract.UNSUBSCRIBE_WIDGET_FOCUS, "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface WidgetRotation {
    boolean disableWidgetFocus(int stackId);

    boolean enableWidgetFocus(int stackId, @NotNull ArrayList<ComponentName> widgetComponentNameList);

    @NotNull
    List<Integer> getEnabledIdList();

    boolean isEnabled(int stackId);

    boolean isSubscribed(int stackId);

    boolean subscribeWidgetFocus(int stackId, @NotNull PendingIntent pendingIntent);

    boolean unsubscribeWidgetFocus(int stackId);
}
