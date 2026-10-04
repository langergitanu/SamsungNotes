package com.samsung.android.app.sdk.deepsky.smartwidget;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.app.sdk.deepsky.common.AccessControl;
import com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller;
import com.samsung.android.app.sdk.deepsky.common.SystemDataSource;
import com.samsung.android.app.sdk.deepsky.contract.smartwidget.SmartWidgetContract;
import com.samsung.android.app.sdk.deepsky.donation.WidgetContribution;
import com.samsung.android.app.sdk.deepsky.donation.schema.DonationContract;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p014C3.RunnableC0054a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/smartwidget/SmartWidgetImpl;", "Lcom/samsung/android/app/sdk/deepsky/smartwidget/SmartWidget;", "Lcom/samsung/android/app/sdk/deepsky/common/AccessControl;", "contentProviderCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "systemDataSource", "Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "(Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;)V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "checkIfAccessAllowed", "", "contribute", "", "widgetContribution", "Lcom/samsung/android/app/sdk/deepsky/donation/WidgetContribution;", "isActive", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SmartWidgetImpl implements SmartWidget, AccessControl {

    @NotNull
    private static final String TAG = "SmartWidgetImpl";

    @NotNull
    private final ContentProviderCaller contentProviderCaller;

    @NotNull
    private final ExecutorService mExecutorService;

    @NotNull
    private final SystemDataSource systemDataSource;

    public SmartWidgetImpl(@NotNull ContentProviderCaller contentProviderCaller, @NotNull SystemDataSource systemDataSource) {
        Intrinsics.checkNotNullParameter(contentProviderCaller, "contentProviderCaller");
        Intrinsics.checkNotNullParameter(systemDataSource, "systemDataSource");
        this.contentProviderCaller = contentProviderCaller;
        this.systemDataSource = systemDataSource;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contribute$lambda$1(SmartWidgetImpl this$0, WidgetContribution widgetContribution) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(widgetContribution, "$widgetContribution");
        Bundle bundle = new Bundle();
        bundle.putParcelable(DonationContract.KEY_COMPONENT_NAME, widgetContribution.getComponentName());
        bundle.putInt(DonationContract.KEY_SCORE, widgetContribution.getScore());
        bundle.putLong(DonationContract.KEY_DURATION, widgetContribution.getDuration());
        bundle.putLong(DonationContract.KEY_START_TIME, widgetContribution.getStartTime());
        bundle.putBoolean(DonationContract.KEY_WILL_PROVIDE_REASON, widgetContribution.getWillProvideReason());
        ContentProviderCaller contentProviderCaller = this$0.contentProviderCaller;
        Uri content_uri = DonationContract.INSTANCE.getCONTENT_URI();
        Intrinsics.checkNotNullExpressionValue(content_uri, "DonationContract.CONTENT_URI");
        contentProviderCaller.sendCommand(content_uri, DonationContract.DONATION_WIDGET_METHOD_CALL, bundle);
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.AccessControl
    public boolean checkIfAccessAllowed() {
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.smartwidget.SmartWidget
    public void contribute(@NotNull WidgetContribution widgetContribution) {
        Intrinsics.checkNotNullParameter(widgetContribution, "widgetContribution");
        Log.i(TAG, "contribute");
        this.mExecutorService.execute(new RunnableC0054a(this, widgetContribution, 7));
    }

    @Override // com.samsung.android.app.sdk.deepsky.smartwidget.SmartWidget
    public boolean isActive() {
        Log.i(TAG, "isActive");
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand(SmartWidgetContract.IS_ACTIVE, this.systemDataSource.newBundle());
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(SmartWidgetContract.RESULT_SMART_WIDGET);
        }
        return false;
    }
}
