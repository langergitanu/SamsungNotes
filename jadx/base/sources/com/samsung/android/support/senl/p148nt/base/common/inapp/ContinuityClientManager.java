package com.samsung.android.support.senl.p148nt.base.common.inapp;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.mcf.continuity.ContinuityManager;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityIntentHelper;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityClientManager;", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager;", "<init>", "()V", "mIntent", "Landroid/content/Intent;", "getTag", "", "onServiceConnected", "", "startDiscovery", "stopDiscovery", "setContinuityIntent", MarketingConstants.LINK_TYPE_INTENT, "onSessionStatusChanged", "sessionStatus", "", "release", "context", "Landroid/content/Context;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContinuityClientManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuityClientManager.kt\ncom/samsung/android/support/senl/nt/base/common/inapp/ContinuityClientManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
public final class ContinuityClientManager extends ContinuityServiceManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ContinuityClientManager";

    @Nullable
    private static ContinuityClientManager sInstance;

    @Nullable
    private Intent mIntent;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityClientManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityClientManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityClientManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized ContinuityClientManager getInstance() {
            ContinuityClientManager continuityClientManager;
            try {
                if (ContinuityClientManager.sInstance == null) {
                    ContinuityClientManager.sInstance = new ContinuityClientManager();
                }
                continuityClientManager = ContinuityClientManager.sInstance;
                Intrinsics.checkNotNull(continuityClientManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.inapp.ContinuityClientManager");
            } catch (Throwable th) {
                throw th;
            }
            return continuityClientManager;
        }

        private Companion() {
        }
    }

    @NotNull
    public static final synchronized ContinuityClientManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void startDiscovery() {
        ContinuityAdapter mContinuityAdapter = getMContinuityAdapter();
        setMDiscoveryManager(mContinuityAdapter != null ? mContinuityAdapter.getContinuityDiscoveryManager() : null);
        if (getMDiscoveryManager() == null) {
            InAppLogger.m8596e(TAG, "startDiscoveryForClient# fail - Discovery Manager is null");
            return;
        }
        ContinuityDiscoveryManager mDiscoveryManager = getMDiscoveryManager();
        if (mDiscoveryManager != null) {
            mDiscoveryManager.startAdvertisement();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public void onServiceConnected() {
        startDiscovery();
        openSession();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public void onSessionStatusChanged(int sessionStatus) {
        ContinuityNearbyMyDevice continuityNearbyMyDevice;
        ContinuityNetworkPolicy continuityNetworkPolicy;
        if (this.mIntent == null) {
            return;
        }
        if (sessionStatus != 11) {
            onServiceDisconnected(BaseUtils.getApplicationContext());
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        ContinuityIntentHelper continuityIntentHelper = applicationContext != null ? ContinuityManager.getContinuityIntentHelper(applicationContext) : null;
        if (continuityIntentHelper != null) {
            Intent intent = this.mIntent;
            Intrinsics.checkNotNull(intent);
            continuityNearbyMyDevice = continuityIntentHelper.getContinuityNearbyMyDevice(intent);
        } else {
            continuityNearbyMyDevice = null;
        }
        if (continuityIntentHelper != null) {
            Intent intent2 = this.mIntent;
            Intrinsics.checkNotNull(intent2);
            continuityNetworkPolicy = continuityIntentHelper.getContinuityNetworkPolicy(intent2);
        } else {
            continuityNetworkPolicy = null;
        }
        InAppLogger.m8595d(TAG, "onSessionStatusChanged# continuityNearbyMyDevice : " + (continuityNearbyMyDevice == null ? "null" : continuityNearbyMyDevice) + ", continuityNetworkPolicy : " + (continuityNetworkPolicy != null ? continuityNetworkPolicy : "null"));
        this.mIntent = null;
        if (continuityNearbyMyDevice == null || continuityNetworkPolicy == null) {
            return;
        }
        String btMac = continuityNearbyMyDevice.getBtMac();
        if (btMac == null) {
            InAppLogger.m8596e(TAG, "onSessionStatusChanged# btMac is null");
            return;
        }
        ContinuitySessionManager mSessionManager = getMSessionManager();
        if (mSessionManager != null) {
            mSessionManager.responseConnect(0, btMac, continuityNetworkPolicy, getMPeerStatusListener());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public void release(@Nullable Context context) {
        super.release(context);
        this.mIntent = null;
    }

    public final void setContinuityIntent(@Nullable Intent intent) {
        this.mIntent = intent;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public void stopDiscovery() {
        if (getMDiscoveryManager() != null) {
            InAppLogger.m8595d(TAG, "stopDiscovery#");
            ContinuityDiscoveryManager mDiscoveryManager = getMDiscoveryManager();
            if (mDiscoveryManager != null) {
                mDiscoveryManager.stopAdvertisement();
            }
            setMDiscoveryManager(null);
        }
    }
}
