package com.samsung.android.support.senl.p148nt.base.common.inapp;

import android.content.Context;
import android.content.IntentFilter;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevices;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevicesModel;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tJ\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0007J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\rH\u0002J\u0012\u0010)\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070$8F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServerManager;", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager;", "<init>", "()V", "mComposerList", "", "", "", "mContinuityMenu", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevices$ContinuityMenuContract;", "mContinuityReceiver", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityReceiver;", "getTag", "", "connect", "context", "Landroid/content/Context;", "startDiscovery", "", "continuityMenu", "stopDiscovery", "startInAppCollaboration", "btMacToConnect", "correctConnectingDevice", "foundDeviceBtMac", "addTargetComposer", "hashCode", "removeTargetComposer", "setTargetComposer", "initTargetComposer", "isTargetComposer", "hasTargetComposer", "targetComposerSize", "getTargetComposerSize", "()I", "composerList", "", "getComposerList", "()Ljava/util/Map;", "loggingFragment", "tag", "release", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContinuityServerManager extends ContinuityServiceManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ContinuityServerManager";

    @Nullable
    private static ContinuityServerManager sInstance;

    @NotNull
    private final Map<Integer, Boolean> mComposerList = new HashMap();

    @Nullable
    private NearbyMyDevices.ContinuityMenuContract mContinuityMenu;

    @Nullable
    private ContinuityReceiver mContinuityReceiver;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServerManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServerManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServerManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized ContinuityServerManager getInstance() {
            ContinuityServerManager continuityServerManager;
            try {
                if (ContinuityServerManager.sInstance == null) {
                    ContinuityServerManager.sInstance = new ContinuityServerManager();
                }
                continuityServerManager = ContinuityServerManager.sInstance;
                Intrinsics.checkNotNull(continuityServerManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServerManager");
            } catch (Throwable th) {
                throw th;
            }
            return continuityServerManager;
        }

        private Companion() {
        }
    }

    @NotNull
    public static final synchronized ContinuityServerManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void loggingFragment(String tag) {
    }

    public final void addTargetComposer(int hashCode) {
        this.mComposerList.put(Integer.valueOf(hashCode), Boolean.FALSE);
        loggingFragment("addTargetComposer");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public boolean connect(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zConnect = super.connect(context);
        if (this.mContinuityReceiver != null) {
            return zConnect;
        }
        InAppLogger.m8595d(TAG, "connect# registerReceiver");
        ContinuityReceiver continuityReceiver = new ContinuityReceiver() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServerManager.connect.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityReceiver
            public void onContinuityServiceReconnected(Context context2) {
                InAppLogger.m8595d(ContinuityServerManager.this.getTag(), "onContinuityServiceReconnected# ContinuityState : " + ContinuityServerManager.this.getContinuityState());
                if (ContinuityServerManager.this.getContinuityState() == ContinuityState.DISCONNECTED) {
                    ContinuityServerManager continuityServerManager = ContinuityServerManager.this;
                    Intrinsics.checkNotNull(context2);
                    continuityServerManager.connect(context2);
                }
            }
        };
        this.mContinuityReceiver = continuityReceiver;
        BroadcastCompat.INSTANCE.registerReceiver(context, continuityReceiver, new IntentFilter(ContinuityReceiver.ACTION_MCF_SERVICE_STARTED), ContinuityReceiver.PERMISSION_MCF_SERVICE, null, 2);
        return zConnect;
    }

    public final boolean correctConnectingDevice(@Nullable String foundDeviceBtMac) {
        if (getMConnectedDeviceBtMac() != null && foundDeviceBtMac != null) {
            boolean zAreEqual = Intrinsics.areEqual(foundDeviceBtMac, getMConnectedDeviceBtMac());
            ContinuityState continuityState = getContinuityState();
            InAppLogger.m8595d(TAG, "correctConnectingDevice# ContinuityState : " + continuityState + ", isCorrectDevice : " + zAreEqual);
            if (continuityState == ContinuityState.PEER_CONNECTED && zAreEqual) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Map<Integer, Boolean> getComposerList() {
        loggingFragment("getComposerList");
        return this.mComposerList;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    @NotNull
    public String getTag() {
        return TAG;
    }

    public final int getTargetComposerSize() {
        loggingFragment("getTargetComposerSize");
        return this.mComposerList.size();
    }

    public final boolean hasTargetComposer() {
        Iterator<Map.Entry<Integer, Boolean>> it = this.mComposerList.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                loggingFragment("hasTargetComposer");
                return true;
            }
        }
        loggingFragment("hasTargetComposer");
        return false;
    }

    public final void initTargetComposer() {
        Iterator<Integer> it = this.mComposerList.keySet().iterator();
        while (it.hasNext()) {
            this.mComposerList.put(Integer.valueOf(it.next().intValue()), Boolean.FALSE);
        }
        loggingFragment("initTargetComposer");
    }

    public final boolean isTargetComposer(int hashCode) {
        loggingFragment("isTargetComposer");
        Boolean bool = this.mComposerList.get(Integer.valueOf(hashCode));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public void release(@Nullable Context context) {
        super.release(context);
        this.mComposerList.clear();
        this.mContinuityMenu = null;
        if (this.mContinuityReceiver != null) {
            InAppLogger.m8595d(TAG, "release# unregisterReceiver");
            if (context != null) {
                context.unregisterReceiver(this.mContinuityReceiver);
            }
            this.mContinuityReceiver = null;
        }
    }

    public final void removeTargetComposer(int hashCode) {
        this.mComposerList.remove(Integer.valueOf(hashCode));
        loggingFragment("removeTargetComposer");
    }

    public final void setTargetComposer(int hashCode) {
        this.mComposerList.put(Integer.valueOf(hashCode), Boolean.TRUE);
        loggingFragment("setTargetComposer");
    }

    public final void startDiscovery(@NotNull NearbyMyDevices.ContinuityMenuContract continuityMenu) {
        Intrinsics.checkNotNullParameter(continuityMenu, "continuityMenu");
        ContinuityAdapter mContinuityAdapter = getMContinuityAdapter();
        setMDiscoveryManager(mContinuityAdapter != null ? mContinuityAdapter.getContinuityDiscoveryManager() : null);
        if (getMDiscoveryManager() == null) {
            InAppLogger.m8596e(TAG, "startDiscovery# fail - Discovery Manager is null");
            return;
        }
        NearbyMyDevicesModel mNearbyMyDevicesModel = getMNearbyMyDevicesModel();
        if (mNearbyMyDevicesModel != null) {
            mNearbyMyDevicesModel.clear();
        }
        this.mContinuityMenu = continuityMenu;
        ContinuityDiscoveryManager mDiscoveryManager = getMDiscoveryManager();
        if (mDiscoveryManager != null) {
            mDiscoveryManager.startDiscovery(new ContinuityDiscoveryManager.DiscoveryListener() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServerManager.startDiscovery.1
                @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager.DiscoveryListener
                public void onDiscovered(int event, ContinuityNearbyMyDevice continuityNearbyMyDevice) {
                    NearbyMyDevices.ContinuityMenuContract continuityMenuContract;
                    Intrinsics.checkNotNullParameter(continuityNearbyMyDevice, "continuityNearbyMyDevice");
                    int screenState = continuityNearbyMyDevice.getScreenState();
                    String str = ContinuityServerManager.TAG;
                    String displayName = continuityNearbyMyDevice.getDisplayName();
                    int deviceType = continuityNearbyMyDevice.getDeviceType();
                    String modelName = continuityNearbyMyDevice.getModelName();
                    int btState = continuityNearbyMyDevice.getBtState();
                    StringBuilder sbM1629s = AbstractC2322a.m1629s("onDiscovered# event : ", event, ", displayName : ", displayName, ", deviceType : ");
                    AbstractC1974b.m1331x(sbM1629s, deviceType, ", modelName : ", modelName, ", screenState : ");
                    sbM1629s.append(screenState);
                    sbM1629s.append(", btState ");
                    sbM1629s.append(btState);
                    InAppLogger.m8595d(str, sbM1629s.toString());
                    switch (event) {
                        case 100:
                            NearbyMyDevicesModel mNearbyMyDevicesModel2 = ContinuityServerManager.this.getMNearbyMyDevicesModel();
                            if (mNearbyMyDevicesModel2 != null) {
                                mNearbyMyDevicesModel2.deviceFound(ContinuityServerManager.this.mContinuityMenu, continuityNearbyMyDevice);
                            }
                            if (ContinuityServerManager.this.correctConnectingDevice(continuityNearbyMyDevice.getBtMac()) && (continuityMenuContract = ContinuityServerManager.this.mContinuityMenu) != null) {
                                continuityMenuContract.onReleaseDim();
                            }
                            break;
                        case 101:
                            if (screenState == 400) {
                                ContinuityServerManager.this.closeInAppCollaboration();
                            }
                            break;
                        case 102:
                            NearbyMyDevicesModel mNearbyMyDevicesModel3 = ContinuityServerManager.this.getMNearbyMyDevicesModel();
                            if (mNearbyMyDevicesModel3 != null) {
                                mNearbyMyDevicesModel3.deviceLost(ContinuityServerManager.this.mContinuityMenu, continuityNearbyMyDevice);
                            }
                            break;
                    }
                    NearbyMyDevices.ContinuityMenuContract continuityMenuContract2 = ContinuityServerManager.this.mContinuityMenu;
                    if (continuityMenuContract2 != null) {
                        continuityMenuContract2.onUpdateDeviceListDialog();
                    }
                }
            });
        }
    }

    public final boolean startInAppCollaboration(@NotNull String btMacToConnect) {
        Intrinsics.checkNotNullParameter(btMacToConnect, "btMacToConnect");
        if (!openSession()) {
            return false;
        }
        ContinuityNetworkPolicy continuityNetworkPolicyBuild = new ContinuityNetworkPolicy.Builder().setTopology(21).setType(11).build();
        Intrinsics.checkNotNullExpressionValue(continuityNetworkPolicyBuild, "build(...)");
        InAppLogger.m8595d(TAG, "startInAppCollaboration# requestConnect");
        ContinuitySessionManager mSessionManager = getMSessionManager();
        if (mSessionManager == null) {
            return true;
        }
        mSessionManager.requestConnect(btMacToConnect, continuityNetworkPolicyBuild, getMPeerStatusListener());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager
    public void stopDiscovery() {
        NearbyMyDevicesModel mNearbyMyDevicesModel;
        if (getMDiscoveryManager() != null) {
            InAppLogger.m8595d(TAG, "stopDiscovery#");
            ContinuityDiscoveryManager mDiscoveryManager = getMDiscoveryManager();
            if (mDiscoveryManager != null) {
                mDiscoveryManager.stopDiscovery();
            }
            setMDiscoveryManager(null);
        }
        NearbyMyDevices.ContinuityMenuContract continuityMenuContract = this.mContinuityMenu;
        if (continuityMenuContract != null && continuityMenuContract != null) {
            continuityMenuContract.onUpdateMenuVisibility();
        }
        if (getMNearbyMyDevicesModel() == null || (mNearbyMyDevicesModel = getMNearbyMyDevicesModel()) == null) {
            return;
        }
        mNearbyMyDevicesModel.clear();
    }
}
