package com.samsung.android.support.senl.p148nt.base.common.startmanager;

import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/CoeditStartManager;", "", "<init>", "()V", "stopCoeditDownload", "", "syncProgressListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/SyncProgressListener;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoeditStartManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "CoeditStartManager";
    private static long sFinalBlockTime;

    @Nullable
    private static CoeditStartManager sInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/CoeditStartManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/startmanager/CoeditStartManager;", "sFinalBlockTime", "", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/startmanager/CoeditStartManager;", "setFinalBlockTimeToStartSync", "", "finalBlockTime", "canStartCoedit", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean canStartCoedit() {
            if (System.currentTimeMillis() >= CoeditStartManager.sFinalBlockTime) {
                return true;
            }
            Logger.m8703w(CoeditStartManager.TAG, "canStartSync() : false, blockTime = " + CoeditStartManager.sFinalBlockTime);
            return false;
        }

        @NotNull
        public final synchronized CoeditStartManager getInstance() {
            CoeditStartManager coeditStartManager;
            try {
                if (CoeditStartManager.sInstance == null) {
                    CoeditStartManager.sInstance = new CoeditStartManager(null);
                }
                coeditStartManager = CoeditStartManager.sInstance;
                Intrinsics.checkNotNull(coeditStartManager);
            } catch (Throwable th) {
                throw th;
            }
            return coeditStartManager;
        }

        public final void setFinalBlockTimeToStartSync(long finalBlockTime) {
            CoeditStartManager.sFinalBlockTime = finalBlockTime;
            Logger.m8702i(CoeditStartManager.TAG, "setFinalBlockTimeToStartSync() : blockTime = " + finalBlockTime);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CoeditStartManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void stopCoeditDownload(@Nullable SyncProgressListener syncProgressListener) {
        Logger.m8702i(TAG, "stopSync()");
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(301);
        RequestSyncContract requestSyncContract = RequestToSyncManager.INSTANCE.getInstance().getRequestSyncContract();
        if (requestSyncContract != null) {
            requestSyncContract.stopCoeditDownloadBySmartSwitch(syncProgressListener);
        }
    }

    private CoeditStartManager() {
    }
}
