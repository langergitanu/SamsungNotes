package com.samsung.android.app.sdk.deepsky.widgetrotation;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller;
import com.samsung.android.app.sdk.deepsky.common.SystemDataSource;
import com.samsung.android.app.sdk.deepsky.contract.widget.WidgetContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/widgetrotation/WidgetRotationImpl;", "Lcom/samsung/android/app/sdk/deepsky/widgetrotation/WidgetRotation;", "contentProviderCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "systemDataSource", "Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "(Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;)V", WidgetContract.DISABLE_WIDGET_FOCUS, "", "stackId", "", WidgetContract.ENABLE_WIDGET_FOCUS, "widgetComponentNameList", "Ljava/util/ArrayList;", "Landroid/content/ComponentName;", "Lkotlin/collections/ArrayList;", "getEnabledIdList", "", "isEnabled", "isSubscribed", WidgetContract.SUBSCRIBE_WIDGET_FOCUS, BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", WidgetContract.UNSUBSCRIBE_WIDGET_FOCUS, "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class WidgetRotationImpl implements WidgetRotation {

    @NotNull
    private static final String TAG = "WidgetRotationImpl";

    @NotNull
    private final ContentProviderCaller contentProviderCaller;

    @NotNull
    private final SystemDataSource systemDataSource;

    public WidgetRotationImpl(@NotNull ContentProviderCaller contentProviderCaller, @NotNull SystemDataSource systemDataSource) {
        Intrinsics.checkNotNullParameter(contentProviderCaller, "contentProviderCaller");
        Intrinsics.checkNotNullParameter(systemDataSource, "systemDataSource");
        this.contentProviderCaller = contentProviderCaller;
        this.systemDataSource = systemDataSource;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    public boolean disableWidgetFocus(int stackId) {
        AbstractC2322a.m1631u(stackId, "disableWidgetFocus ", TAG);
        Bundle bundleNewBundle = this.systemDataSource.newBundle();
        bundleNewBundle.putInt(WidgetContract.KEY_STACK_ID, stackId);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(WidgetContract.DISABLE_WIDGET_FOCUS, bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(WidgetContract.RESULT_WIDGET_FOCUS);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    public boolean enableWidgetFocus(int stackId, @NotNull ArrayList<ComponentName> widgetComponentNameList) {
        Intrinsics.checkNotNullParameter(widgetComponentNameList, "widgetComponentNameList");
        Log.i(TAG, "enableWidgetFocus " + stackId);
        Bundle bundleNewBundle = this.systemDataSource.newBundle();
        bundleNewBundle.putInt(WidgetContract.KEY_STACK_ID, stackId);
        bundleNewBundle.putParcelableArrayList(WidgetContract.KEY_WIDGET_COMPONENT_NAME_LIST, widgetComponentNameList);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(WidgetContract.ENABLE_WIDGET_FOCUS, bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(WidgetContract.RESULT_WIDGET_FOCUS);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    @NotNull
    public List<Integer> getEnabledIdList() {
        Log.i(TAG, "getEnabledIdList");
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(WidgetContract.GET_ENABLED_WIDGET_FOCUS_ID_LIST, this.systemDataSource.newBundle());
        ArrayList<Integer> integerArrayList = bundleSendCommand != null ? bundleSendCommand.getIntegerArrayList(WidgetContract.RESULT_WIDGET_FOCUS) : null;
        return integerArrayList == null ? CollectionsKt.emptyList() : integerArrayList;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    public boolean isEnabled(int stackId) {
        AbstractC2322a.m1631u(stackId, "isEnabled ", TAG);
        Bundle bundleNewBundle = this.systemDataSource.newBundle();
        bundleNewBundle.putInt(WidgetContract.KEY_STACK_ID, stackId);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("isEnabled", bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(WidgetContract.RESULT_WIDGET_FOCUS);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    public boolean isSubscribed(int stackId) {
        AbstractC2322a.m1631u(stackId, "isSubscribed ", TAG);
        Bundle bundleNewBundle = this.systemDataSource.newBundle();
        bundleNewBundle.putInt(WidgetContract.KEY_STACK_ID, stackId);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(WidgetContract.IS_SUBSCRIBED_WIDGET_FOCUS, bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(WidgetContract.RESULT_WIDGET_FOCUS);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    public boolean subscribeWidgetFocus(int stackId, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Log.i(TAG, "subscribeWidgetFocus " + stackId);
        Bundle bundleNewBundle = this.systemDataSource.newBundle();
        bundleNewBundle.putInt(WidgetContract.KEY_STACK_ID, stackId);
        bundleNewBundle.putParcelable(WidgetContract.KEY_PENDING_INTENT, pendingIntent);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(WidgetContract.SUBSCRIBE_WIDGET_FOCUS, bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(WidgetContract.RESULT_WIDGET_FOCUS);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation
    public boolean unsubscribeWidgetFocus(int stackId) {
        AbstractC2322a.m1631u(stackId, "unsubscribeWidgetFocus ", TAG);
        Bundle bundleNewBundle = this.systemDataSource.newBundle();
        bundleNewBundle.putInt(WidgetContract.KEY_STACK_ID, stackId);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(WidgetContract.UNSUBSCRIBE_WIDGET_FOCUS, bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(WidgetContract.RESULT_WIDGET_FOCUS);
        }
        return false;
    }
}
