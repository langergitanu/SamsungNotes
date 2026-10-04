package com.samsung.android.support.senl.p148nt.model.restore.search;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.executor.ModelThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/restore/search/RestoreTextService;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startId", "onDestroy", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class RestoreTextService extends Service {

    @NotNull
    private static final String TAG;

    static {
        String strCreateTag = ModelLogger.createTag("RestoreTextService");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartCommand$lambda$0(RestoreTextService restoreTextService) {
        Context applicationContext = restoreTextService.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        new RestoreBodyTextManager(applicationContext).execute();
        restoreTextService.stopSelf();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DataLogger.m12307i(TAG, "onCreate");
        ServiceManager companion = ServiceManager.INSTANCE.getInstance();
        String string = getString(C11397R.string.composer_text_recognition_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.registerService(this, NotificationConstants.RESTORE_TEXT_NOTIFICATION_CHANNEL_ID, string, ServiceType.BACKGROUND);
    }

    @Override // android.app.Service
    public void onDestroy() {
        DataLogger.m12307i(TAG, "onDestroy");
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@NotNull Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        DataLogger.m12302d(TAG, "onStartCommand");
        ModelThreadPoolExecutor.getSingleThreadExecutor().execute(new RunnableC12034a(this, 1));
        return 2;
    }
}
