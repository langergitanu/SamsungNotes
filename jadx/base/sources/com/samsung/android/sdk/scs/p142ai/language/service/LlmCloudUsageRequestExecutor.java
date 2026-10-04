package com.samsung.android.sdk.scs.p142ai.language.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IUsageService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/service/LlmCloudUsageRequestExecutor;", "Lcom/samsung/android/sdk/scs/base/connection/ServiceExecutor;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "service", "Lcom/samsung/android/sivs/ai/sdkcommon/language/IUsageService;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "onConnected", "", "name", "Landroid/content/ComponentName;", "Landroid/os/IBinder;", "onDisconnected", "getServiceIntent", "Landroid/content/Intent;", "getService", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LlmCloudUsageRequestExecutor extends ServiceExecutor {

    @NotNull
    public static final String TAG = "UsageExecutor";

    @NotNull
    private Context context;

    @NotNull
    private final IBinder.DeathRecipient deathRecipient;

    @Nullable
    private IUsageService service;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LlmCloudUsageRequestExecutor(@NotNull Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.context = context.getApplicationContext();
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.language.service.LlmCloudUsageRequestExecutor$deathRecipient$1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                IUsageService iUsageService = this.this$0.service;
                Intrinsics.checkNotNull(iUsageService);
                iUsageService.asBinder().unlinkToDeath(this, 0);
            }
        };
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final IUsageService getService() {
        return this.service;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    @NotNull
    public Intent getServiceIntent() {
        return AbstractC2821a.m2214e("android.intellivoiceservice.UsageService", BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(@Nullable ComponentName name, @Nullable IBinder service) {
        IUsageService iUsageServiceAsInterface = IUsageService.Stub.asInterface(service);
        this.service = iUsageServiceAsInterface;
        try {
            Intrinsics.checkNotNull(iUsageServiceAsInterface);
            iUsageServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(@Nullable ComponentName name) {
        this.service = null;
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }
}
