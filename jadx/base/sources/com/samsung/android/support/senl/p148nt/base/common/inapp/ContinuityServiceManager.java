package com.samsung.android.support.senl.p148nt.base.common.inapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.glance.AbstractC2821a;
import com.samsung.android.mcf.continuity.ContinuityManager;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager;
import com.samsung.android.mcf.continuity.common.FeatureUtil;
import com.samsung.android.mcf.continuity.common.SettingUtil;
import com.samsung.android.mcf.continuity.common.VersionUtil;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.ContinuityConstant;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevicesModel;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 _2\u00020\u0001:\u0003]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010+J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:J\b\u0010<\u001a\u000205H\u0016J\u0006\u0010=\u001a\u000208J\u0006\u0010>\u001a\u000205J\b\u0010?\u001a\u000208H\u0016J\u0010\u0010@\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010%J\u0010\u0010B\u001a\u0002052\u0006\u0010C\u001a\u00020DH\u0016J\r\u0010J\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010KJ\u0010\u0010S\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:J\u0006\u0010T\u001a\u000205J\u0006\u0010U\u001a\u000205J\b\u0010V\u001a\u000205H\u0016J\u0010\u0010W\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u00020ZH\u0016J\n\u0010[\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010\\\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010E\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020G\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\bH\u0010IR$\u0010L\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010Q\u001a\u0002088F¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006`"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager;", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityService;", "<init>", "()V", "mContinuityAdapter", "Lcom/samsung/android/mcf/continuity/api/ContinuityAdapter;", "getMContinuityAdapter", "()Lcom/samsung/android/mcf/continuity/api/ContinuityAdapter;", "setMContinuityAdapter", "(Lcom/samsung/android/mcf/continuity/api/ContinuityAdapter;)V", "mDiscoveryManager", "Lcom/samsung/android/mcf/continuity/api/ContinuityDiscoveryManager;", "getMDiscoveryManager", "()Lcom/samsung/android/mcf/continuity/api/ContinuityDiscoveryManager;", "setMDiscoveryManager", "(Lcom/samsung/android/mcf/continuity/api/ContinuityDiscoveryManager;)V", "mSessionManager", "Lcom/samsung/android/mcf/continuity/api/ContinuitySessionManager;", "getMSessionManager", "()Lcom/samsung/android/mcf/continuity/api/ContinuitySessionManager;", "setMSessionManager", "(Lcom/samsung/android/mcf/continuity/api/ContinuitySessionManager;)V", "mMessageManager", "Lcom/samsung/android/mcf/continuity/api/ContinuitySessionMessageManager;", "getMMessageManager", "()Lcom/samsung/android/mcf/continuity/api/ContinuitySessionMessageManager;", "setMMessageManager", "(Lcom/samsung/android/mcf/continuity/api/ContinuitySessionMessageManager;)V", "mContinuityState", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityState;", "mNearbyMyDevicesModel", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel;", "getMNearbyMyDevicesModel", "()Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel;", "setMNearbyMyDevicesModel", "(Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel;)V", "mConnectedDeviceBtMac", "", "getMConnectedDeviceBtMac", "()Ljava/lang/String;", "setMConnectedDeviceBtMac", "(Ljava/lang/String;)V", "mActionContract", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$ContinuityActionContract;", "mPeerStatusListener", "Lcom/samsung/android/mcf/continuity/api/ContinuitySessionManager$PeerStatusListener;", "getMPeerStatusListener", "()Lcom/samsung/android/mcf/continuity/api/ContinuitySessionManager$PeerStatusListener;", "mSessionStatusListener", "Lcom/samsung/android/mcf/continuity/api/ContinuitySessionManager$SessionStatusListener;", "mSendMessageCallback", "Lcom/samsung/android/mcf/continuity/api/ContinuitySessionMessageManager$SendMessageCallback;", "setActionContract", "", "actionContract", "connect", "", "context", "Landroid/content/Context;", "disconnect", "stopDiscovery", "openSession", "closeSession", "closeInAppCollaboration", "readyToInAppCollaboration", "connectedDeviceBtMac", "sendMessage", "message", "", "nearbyMyDevices", "", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel$NearbyDevice;", "getNearbyMyDevices", "()Ljava/util/Map;", "hasNearbyMyDevices", "()Ljava/lang/Boolean;", "continuityState", "getContinuityState", "()Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityState;", "setContinuityState", "(Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityState;)V", "isPeerConnected", "()Z", "initContinuityService", "registerMessageIntentListener", "unregisterMessageIntentListener", "onServiceConnected", "onServiceDisconnected", "onSessionStatusChanged", "sessionStatus", "", "getTag", "release", "ContinuityServiceContract", "ContinuityActionContract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContinuityServiceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuityServiceManager.kt\ncom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,486:1\n1#2:487\n*E\n"})
public class ContinuityServiceManager implements ContinuityService {

    @Nullable
    private ContinuityActionContract mActionContract;

    @Nullable
    private String mConnectedDeviceBtMac;

    @Nullable
    private ContinuityAdapter mContinuityAdapter;

    @Nullable
    private ContinuityDiscoveryManager mDiscoveryManager;

    @Nullable
    private ContinuitySessionMessageManager mMessageManager;

    @Nullable
    private NearbyMyDevicesModel mNearbyMyDevicesModel;

    @Nullable
    private ContinuitySessionManager mSessionManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ContinuityServiceManager";
    private static final int APP_ID = 2;
    private static final long MIN_SUPPORT_SERVICE_VERSION = 110000013;

    @NotNull
    private ContinuityState mContinuityState = ContinuityState.INIT;

    @NotNull
    private final ContinuitySessionManager.PeerStatusListener mPeerStatusListener = new ContinuitySessionManager.PeerStatusListener() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager$mPeerStatusListener$1
        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.PeerStatusListener
        public void onPeerStatusChanged(int peerStatus, ContinuityNearbyMyDevice continuityNearbyMyDevice) {
            Intrinsics.checkNotNullParameter(continuityNearbyMyDevice, "continuityNearbyMyDevice");
            InAppLogger.m8595d(this.this$0.getTag(), "onPeerStatusChanged# peerStatus " + peerStatus);
            if (peerStatus == 20) {
                InAppLogger.m8595d(this.this$0.getTag(), "onPeerStatusChanged# STATUS_PEER_CONNECTED");
                this.this$0.setContinuityState(ContinuityState.PEER_CONNECTED);
                this.this$0.readyToInAppCollaboration(continuityNearbyMyDevice.getBtMac());
            } else {
                if (peerStatus != 21) {
                    return;
                }
                InAppLogger.m8596e(this.this$0.getTag(), "onPeerStatusChanged# STATUS_PEER_DISCONNECTED");
                this.this$0.setContinuityState(ContinuityState.PEER_DISCONNECTED);
                if (this.this$0.getMConnectedDeviceBtMac() != null && !Intrinsics.areEqual(this.this$0.getMConnectedDeviceBtMac(), continuityNearbyMyDevice.getBtMac())) {
                    InAppLogger.m8596e(this.this$0.getTag(), "onPeerStatusChanged# ConnectedDeviceBtMac is not same");
                }
                this.this$0.setMConnectedDeviceBtMac(null);
                this.this$0.closeSession();
                ContinuityServiceManager.ContinuityActionContract continuityActionContract = this.this$0.mActionContract;
                if (continuityActionContract != null) {
                    continuityActionContract.closedInAppCollaboration();
                }
            }
        }
    };

    @NotNull
    private final ContinuitySessionManager.SessionStatusListener mSessionStatusListener = new ContinuitySessionManager.SessionStatusListener() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager$mSessionStatusListener$1
        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.SessionStatusListener
        public void onSessionStatusChanged(int sessionStatus) {
            InAppLogger.m8595d(this.this$0.getTag(), "onSessionStatusChanged# sessionStatus : " + sessionStatus);
            this.this$0.onSessionStatusChanged(sessionStatus);
        }
    };

    @NotNull
    private final ContinuitySessionMessageManager.SendMessageCallback mSendMessageCallback = new ContinuitySessionMessageManager.SendMessageCallback() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager$mSendMessageCallback$1
        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager.SendMessageCallback
        public void onResult(int status) {
            InAppLogger.m8595d(this.this$0.getTag(), "MessageManager# onResult, status : " + status);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\t2\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\n\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\r¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "APP_ID", "", "MIN_SUPPORT_SERVICE_VERSION", "", "isSupportedInAppCollaborationAsServer", "", "isSupportedInAppCollaborationAsServer$annotations", "()Z", "isSupportedInAppCollaborationAsClient", "isSupportedInAppCollaborationAsClient$annotations", "isSupportedInAppCollaboration", "isContinuityFeatureEnabled", "isContinuityFeatureEnabled$annotations", "isContinuitySettingEnabled", "isContinuityServiceVersionSupported", "isContinuityServiceVersionSupported$annotations", "getServiceVersionCode", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nContinuityServiceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuityServiceManager.kt\ncom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,486:1\n1#2:487\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isContinuityFeatureEnabled$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isContinuityServiceVersionSupported$annotations() {
        }

        private final boolean isContinuitySettingEnabled() {
            Context applicationContext = BaseUtils.getApplicationContext();
            Boolean boolValueOf = applicationContext != null ? Boolean.valueOf(SettingUtil.isContinuitySettingEnabled(applicationContext)) : null;
            InAppLogger.m8595d(ContinuityServiceManager.TAG, "isContinuitySettingEnabled : " + boolValueOf);
            return Intrinsics.areEqual(boolValueOf, Boolean.TRUE);
        }

        private final boolean isSupportedInAppCollaboration() {
            boolean z = false;
            if (Build.VERSION.SDK_INT <= 30) {
                InAppLogger.m8595d(ContinuityServiceManager.TAG, "isSupportedInAppCollaboration# OS condition : false");
                return false;
            }
            if (isContinuityFeatureEnabled() && isContinuitySettingEnabled()) {
                z = true;
            }
            InAppLogger.m8595d(ContinuityServiceManager.TAG, "isSupportedInAppCollaboration# ContinuityManager isSupported : " + z);
            return z;
        }

        @JvmStatic
        public static /* synthetic */ void isSupportedInAppCollaborationAsClient$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isSupportedInAppCollaborationAsServer$annotations() {
        }

        @RequiresApi(28)
        public final long getServiceVersionCode(@NonNull @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(VersionUtil.PACKAGE_NAME_MCF_CONTINUITY, 128);
                if (packageInfo == null) {
                    return -1L;
                }
                return packageInfo.getLongVersionCode();
            } catch (PackageManager.NameNotFoundException unused) {
                return -1L;
            }
        }

        public final boolean isContinuityFeatureEnabled() {
            boolean zIsContinuityFeatureEnabled;
            try {
                zIsContinuityFeatureEnabled = FeatureUtil.isContinuityFeatureEnabled();
            } catch (NoClassDefFoundError e) {
                InAppLogger.m8596e(ContinuityServiceManager.TAG, "NoClassDefFoundError : " + e.getMessage());
                zIsContinuityFeatureEnabled = false;
            } catch (NoSuchMethodError e2) {
                InAppLogger.m8596e(ContinuityServiceManager.TAG, "NoSuchMethodError : " + e2.getMessage());
                zIsContinuityFeatureEnabled = false;
            }
            InAppLogger.m8595d(ContinuityServiceManager.TAG, "isContinuityFeatureEnabled : " + zIsContinuityFeatureEnabled);
            return zIsContinuityFeatureEnabled;
        }

        public final boolean isContinuityServiceVersionSupported() {
            if (Build.VERSION.SDK_INT < 28) {
                InAppLogger.m8595d(ContinuityServiceManager.TAG, "isContinuityServiceVersionSupported: false by not supported os");
                return false;
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            Boolean boolValueOf = null;
            Long lValueOf = applicationContext != null ? Long.valueOf(ContinuityServiceManager.INSTANCE.getServiceVersionCode(applicationContext)) : null;
            if (lValueOf != null) {
                boolValueOf = Boolean.valueOf(lValueOf.longValue() >= ContinuityServiceManager.MIN_SUPPORT_SERVICE_VERSION);
            }
            String str = ContinuityServiceManager.TAG;
            Object obj = lValueOf;
            if (lValueOf == null) {
                obj = "null";
            }
            InAppLogger.m8595d(str, "isContinuityServiceVersionSupported: version: " + obj + ", supported: " + (boolValueOf != null ? boolValueOf : "null"));
            return Intrinsics.areEqual(boolValueOf, Boolean.TRUE);
        }

        public final boolean isSupportedInAppCollaborationAsClient() {
            boolean zIsSupportedInAppCollaboration = isSupportedInAppCollaboration();
            boolean zIsPhoneModel = DeviceUtils.isPhoneModel();
            boolean isSupportInAppClient = ModelFeature.getFeature().getIsSupportInAppClient();
            boolean z = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 40100;
            String str = ContinuityServiceManager.TAG;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("isSupportedInAppCollaborationAsClient# supportedInApp : ", ", phone : ", ", supportedDevice : ", zIsSupportedInAppCollaboration, zIsPhoneModel);
            sbM2230u.append(isSupportInAppClient);
            sbM2230u.append(", supportedOneUIVersion : ");
            sbM2230u.append(z);
            InAppLogger.m8595d(str, sbM2230u.toString());
            return zIsPhoneModel && zIsSupportedInAppCollaboration && (isSupportInAppClient || z);
        }

        public final boolean isSupportedInAppCollaborationAsServer() {
            boolean zIsSupportedInAppCollaboration = isSupportedInAppCollaboration();
            boolean zIsTabletModel = DeviceUtils.isTabletModel();
            boolean zIsDexMode = DesktopModeCompat.INSTANCE.getInstance().isDexMode(BaseUtils.getApplicationContext());
            boolean isSupportInAppServer = ModelFeature.getFeature().getIsSupportInAppServer();
            boolean z = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 40100;
            String str = ContinuityServiceManager.TAG;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("isSupportedInAppCollaborationAsServer# supportedInApp : ", ", tablet : ", ", dex : ", zIsSupportedInAppCollaboration, zIsTabletModel);
            AbstractC2821a.m2208C(sbM2230u, zIsDexMode, ", supportedDevice : ", isSupportInAppServer, ", supportedOneUIVersion : ");
            sbM2230u.append(z);
            InAppLogger.m8595d(str, sbM2230u.toString());
            return zIsTabletModel && !zIsDexMode && zIsSupportedInAppCollaboration && (isSupportInAppServer || z);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$ContinuityActionContract;", "Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$ContinuityServiceContract;", "readyToInAppCollaboration", "", "closedInAppCollaboration", "messageReceived", "message", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ContinuityActionContract extends ContinuityServiceContract {
        void closedInAppCollaboration();

        void messageReceived(@NotNull byte[] message);

        void readyToInAppCollaboration();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityServiceManager$ContinuityServiceContract;", "", "onServiceConnected", "", "onServiceDisconnected", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ContinuityServiceContract {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public ContinuityServiceManager() {
        if (this.mNearbyMyDevicesModel == null) {
            this.mNearbyMyDevicesModel = new NearbyMyDevicesModel();
        }
    }

    public static final boolean isContinuityFeatureEnabled() {
        return INSTANCE.isContinuityFeatureEnabled();
    }

    public static final boolean isContinuityServiceVersionSupported() {
        return INSTANCE.isContinuityServiceVersionSupported();
    }

    public static final boolean isSupportedInAppCollaborationAsClient() {
        return INSTANCE.isSupportedInAppCollaborationAsClient();
    }

    public static final boolean isSupportedInAppCollaborationAsServer() {
        return INSTANCE.isSupportedInAppCollaborationAsServer();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityService
    public boolean closeInAppCollaboration() {
        boolean z;
        if (this.mSessionManager == null || this.mConnectedDeviceBtMac == null) {
            z = false;
        } else {
            InAppLogger.m8595d(getTag(), "closeInAppCollaboration# Session disconnect");
            ContinuitySessionManager continuitySessionManager = this.mSessionManager;
            if (continuitySessionManager != null) {
                String str = this.mConnectedDeviceBtMac;
                Intrinsics.checkNotNull(str);
                continuitySessionManager.disconnect(str);
            }
            z = true;
        }
        InAppLogger.m8595d(getTag(), "closeInAppCollaboration# close : " + z);
        return z;
    }

    public final void closeSession() {
        if (this.mConnectedDeviceBtMac != null) {
            closeInAppCollaboration();
        }
        if (this.mSessionManager != null) {
            InAppLogger.m8595d(getTag(), "closeSession#");
            ContinuitySessionManager continuitySessionManager = this.mSessionManager;
            if (continuitySessionManager != null) {
                continuitySessionManager.closeSession();
            }
            this.mSessionManager = null;
        }
        if (this.mMessageManager != null) {
            InAppLogger.m8595d(getTag(), "closeSession# unregister message");
            ContinuitySessionMessageManager continuitySessionMessageManager = this.mMessageManager;
            if (continuitySessionMessageManager != null) {
                continuitySessionMessageManager.unregisterMessageListener();
            }
            this.mMessageManager = null;
        }
        this.mConnectedDeviceBtMac = null;
    }

    public boolean connect(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContinuityAdapter continuityAdapter = ContinuityManager.getContinuityAdapter(context);
        this.mContinuityAdapter = continuityAdapter;
        Integer numValueOf = continuityAdapter != null ? Integer.valueOf(continuityAdapter.initialize(context, APP_ID)) : null;
        if (numValueOf == null || numValueOf.intValue() != 900) {
            InAppLogger.m8596e(getTag(), "connect# fail - initialize result " + numValueOf);
            return false;
        }
        InAppLogger.m8595d(getTag(), "connect#");
        ContinuityAdapter continuityAdapter2 = this.mContinuityAdapter;
        if (continuityAdapter2 == null) {
            return true;
        }
        continuityAdapter2.bindService(context, new ContinuityAdapter.ServiceStateListener() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.connect.1
            @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter.ServiceStateListener
            public void onServiceConnected() {
                InAppLogger.m8595d(ContinuityServiceManager.this.getTag(), "onServiceConnected#");
                ContinuityServiceManager.this.setContinuityState(ContinuityState.CONNECTED);
                ContinuityServiceManager.this.onServiceConnected();
            }

            @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter.ServiceStateListener
            public void onServiceDisconnected() {
                InAppLogger.m8596e(ContinuityServiceManager.this.getTag(), "onServiceDisconnected#");
                ContinuityServiceManager.this.setContinuityState(ContinuityState.DISCONNECTED);
                ContinuityServiceManager.this.onServiceDisconnected(context);
            }
        });
        return true;
    }

    public final void disconnect(@Nullable Context context) {
        ContinuityAdapter continuityAdapter;
        ContinuityAdapter continuityAdapter2;
        stopDiscovery();
        closeSession();
        if (this.mContinuityAdapter != null) {
            InAppLogger.m8595d(getTag(), "disconnect#");
            if (context != null && (continuityAdapter2 = this.mContinuityAdapter) != null) {
                continuityAdapter2.unbindService(context);
            }
            if (context != null && (continuityAdapter = this.mContinuityAdapter) != null) {
                continuityAdapter.release(context);
            }
            this.mContinuityAdapter = null;
        }
        setContinuityState(ContinuityState.DISCONNECTED);
    }

    @NotNull
    public final ContinuityState getContinuityState() {
        InAppLogger.m8595d(TAG, "getContinuityState# state : " + this.mContinuityState.name());
        return this.mContinuityState;
    }

    @Nullable
    public final String getMConnectedDeviceBtMac() {
        return this.mConnectedDeviceBtMac;
    }

    @Nullable
    public final ContinuityAdapter getMContinuityAdapter() {
        return this.mContinuityAdapter;
    }

    @Nullable
    public final ContinuityDiscoveryManager getMDiscoveryManager() {
        return this.mDiscoveryManager;
    }

    @Nullable
    public final ContinuitySessionMessageManager getMMessageManager() {
        return this.mMessageManager;
    }

    @Nullable
    public final NearbyMyDevicesModel getMNearbyMyDevicesModel() {
        return this.mNearbyMyDevicesModel;
    }

    @NotNull
    public final ContinuitySessionManager.PeerStatusListener getMPeerStatusListener() {
        return this.mPeerStatusListener;
    }

    @Nullable
    public final ContinuitySessionManager getMSessionManager() {
        return this.mSessionManager;
    }

    @Nullable
    public final Map<String, NearbyMyDevicesModel.NearbyDevice> getNearbyMyDevices() {
        NearbyMyDevicesModel nearbyMyDevicesModel = this.mNearbyMyDevicesModel;
        if (nearbyMyDevicesModel == null) {
            return new HashMap();
        }
        if (nearbyMyDevicesModel != null) {
            return nearbyMyDevicesModel.getNearbyMyDevices();
        }
        return null;
    }

    @Nullable
    public String getTag() {
        return TAG;
    }

    @Nullable
    public final Boolean hasNearbyMyDevices() {
        NearbyMyDevicesModel nearbyMyDevicesModel = this.mNearbyMyDevicesModel;
        if (nearbyMyDevicesModel != null) {
            return Boolean.valueOf(nearbyMyDevicesModel.hasNearbyMyDevices());
        }
        return null;
    }

    public final void initContinuityService(@Nullable final Context context) {
        ContinuityState continuityState = getContinuityState();
        if (continuityState != ContinuityState.INIT) {
            InAppLogger.m8596e(getTag(), "initContinuityService# fail - current continuity state " + continuityState);
            return;
        }
        Integer numValueOf = null;
        numValueOf = null;
        ContinuityAdapter continuityAdapter = context != null ? ContinuityManager.getContinuityAdapter(context) : null;
        this.mContinuityAdapter = continuityAdapter;
        if (context != null && continuityAdapter != null) {
            numValueOf = Integer.valueOf(continuityAdapter.initialize(context, APP_ID));
        }
        if (numValueOf != null && numValueOf.intValue() == 900) {
            InAppLogger.m8595d(getTag(), "initContinuityService#");
            ContinuityAdapter continuityAdapter2 = this.mContinuityAdapter;
            if (continuityAdapter2 != null) {
                continuityAdapter2.bindService(context, new ContinuityAdapter.ServiceStateListener() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.initContinuityService.2
                    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter.ServiceStateListener
                    public void onServiceConnected() {
                        InAppLogger.m8595d(ContinuityServiceManager.this.getTag(), "initContinuityService - onServiceConnected#");
                        ContinuityServiceManager.this.setContinuityState(ContinuityState.CONNECTED);
                        ContinuityServiceManager.this.registerMessageIntentListener();
                        onServiceDisconnected();
                    }

                    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter.ServiceStateListener
                    public void onServiceDisconnected() {
                        InAppLogger.m8596e(ContinuityServiceManager.this.getTag(), "initContinuityService - onServiceDisconnected#");
                        ContinuityServiceManager.this.setContinuityState(ContinuityState.DISCONNECTED);
                        if (ContinuityServiceManager.this.getMContinuityAdapter() != null) {
                            ContinuityAdapter mContinuityAdapter = ContinuityServiceManager.this.getMContinuityAdapter();
                            if (mContinuityAdapter != null) {
                                mContinuityAdapter.unbindService(context);
                            }
                            ContinuityAdapter mContinuityAdapter2 = ContinuityServiceManager.this.getMContinuityAdapter();
                            if (mContinuityAdapter2 != null) {
                                mContinuityAdapter2.release(context);
                            }
                            ContinuityServiceManager.this.setMContinuityAdapter(null);
                        }
                    }
                });
                return;
            }
            return;
        }
        String tag = getTag();
        Object obj = numValueOf;
        if (numValueOf == null) {
            obj = "null";
        }
        InAppLogger.m8596e(tag, "initContinuityService# fail - initialize result " + obj);
    }

    public final boolean isPeerConnected() {
        boolean z = this.mContinuityState == ContinuityState.PEER_CONNECTED;
        InAppLogger.m8595d(TAG, "isConnected# " + z);
        return z;
    }

    public void onServiceConnected() {
        ContinuityActionContract continuityActionContract = this.mActionContract;
        if (continuityActionContract == null || continuityActionContract == null) {
            return;
        }
        continuityActionContract.onServiceConnected();
    }

    public final void onServiceDisconnected(@Nullable Context context) {
        ContinuityActionContract continuityActionContract = this.mActionContract;
        if (continuityActionContract != null && continuityActionContract != null) {
            continuityActionContract.onServiceDisconnected();
        }
        disconnect(context);
    }

    public void onSessionStatusChanged(int sessionStatus) {
    }

    public final boolean openSession() {
        ContinuityAdapter continuityAdapter = this.mContinuityAdapter;
        ContinuitySessionManager continuitySessionManager = continuityAdapter != null ? continuityAdapter.getContinuitySessionManager() : null;
        this.mSessionManager = continuitySessionManager;
        if (continuitySessionManager == null) {
            InAppLogger.m8596e(getTag(), "openSession# fail - Session Manager is null");
            return false;
        }
        InAppLogger.m8595d(getTag(), "openSession");
        ContinuitySessionManager continuitySessionManager2 = this.mSessionManager;
        if (continuitySessionManager2 == null) {
            return true;
        }
        continuitySessionManager2.openSession(this.mSessionStatusListener);
        return true;
    }

    public final void readyToInAppCollaboration(@Nullable String connectedDeviceBtMac) {
        this.mConnectedDeviceBtMac = connectedDeviceBtMac;
        ContinuitySessionManager continuitySessionManager = this.mSessionManager;
        ContinuitySessionMessageManager continuitySessionMessageManager = continuitySessionManager != null ? continuitySessionManager.getContinuitySessionMessageManager() : null;
        this.mMessageManager = continuitySessionMessageManager;
        if (continuitySessionMessageManager == null) {
            InAppLogger.m8596e(getTag(), "readyToInAppCollaboration# fail -  MessageManager is null");
            closeInAppCollaboration();
            return;
        }
        if (continuitySessionMessageManager != null) {
            continuitySessionMessageManager.registerMessageListener(new ContinuityMessageManager.MessageListener() { // from class: com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.readyToInAppCollaboration.1
                @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager.MessageListener
                public void onReceived(String btMac, byte[] message) {
                    Intrinsics.checkNotNullParameter(btMac, "btMac");
                    Intrinsics.checkNotNullParameter(message, "message");
                    InAppLogger.m8595d(ContinuityServiceManager.this.getTag(), "MessageManager# onReceived");
                    ContinuityActionContract continuityActionContract = ContinuityServiceManager.this.mActionContract;
                    if (continuityActionContract != null) {
                        continuityActionContract.messageReceived(message);
                    }
                }
            });
        }
        InAppLogger.m8595d(getTag(), "readyToInAppCollaboration#");
        ContinuityActionContract continuityActionContract = this.mActionContract;
        if (continuityActionContract != null) {
            continuityActionContract.readyToInAppCollaboration();
        }
    }

    public final void registerMessageIntentListener() {
        ContinuityAdapter continuityAdapter = this.mContinuityAdapter;
        if (continuityAdapter == null) {
            InAppLogger.m8596e(getTag(), "registerMessageIntentListener# fail - Continuity is not Supported");
            return;
        }
        ContinuityDiscoveryManager continuityDiscoveryManager = continuityAdapter != null ? continuityAdapter.getContinuityDiscoveryManager() : null;
        if (continuityDiscoveryManager == null) {
            InAppLogger.m8596e(getTag(), "registerMessageIntentListener# fail - DiscoveryManager is null");
            return;
        }
        ContinuitySimpleMessageManager continuitySimpleMessageManager = continuityDiscoveryManager.getContinuitySimpleMessageManager();
        Intrinsics.checkNotNullExpressionValue(continuitySimpleMessageManager, "getContinuitySimpleMessageManager(...)");
        continuitySimpleMessageManager.registerMessageIntentListener("com.samsung.android.app.notes", ContinuityConstant.INTENT_ACTION_NOTIFICATION);
    }

    public void release(@Nullable Context context) {
        this.mActionContract = null;
        NearbyMyDevicesModel nearbyMyDevicesModel = this.mNearbyMyDevicesModel;
        if (nearbyMyDevicesModel != null) {
            nearbyMyDevicesModel.clear();
        }
        setContinuityState(ContinuityState.INIT);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityService
    public void sendMessage(@NotNull byte[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.mMessageManager == null || this.mConnectedDeviceBtMac == null) {
            return;
        }
        InAppLogger.m8595d(getTag(), "sendMessage#");
        ContinuitySessionMessageManager continuitySessionMessageManager = this.mMessageManager;
        if (continuitySessionMessageManager != null) {
            String str = this.mConnectedDeviceBtMac;
            Intrinsics.checkNotNull(str);
            continuitySessionMessageManager.sendMessage(str, message, 0, this.mSendMessageCallback);
        }
    }

    public final void setActionContract(@Nullable ContinuityActionContract actionContract) {
        this.mActionContract = actionContract;
    }

    public final void setContinuityState(@NotNull ContinuityState continuityState) {
        Intrinsics.checkNotNullParameter(continuityState, "continuityState");
        InAppLogger.m8595d(TAG, "setContinuityState# " + continuityState);
        this.mContinuityState = continuityState;
    }

    public final void setMConnectedDeviceBtMac(@Nullable String str) {
        this.mConnectedDeviceBtMac = str;
    }

    public final void setMContinuityAdapter(@Nullable ContinuityAdapter continuityAdapter) {
        this.mContinuityAdapter = continuityAdapter;
    }

    public final void setMDiscoveryManager(@Nullable ContinuityDiscoveryManager continuityDiscoveryManager) {
        this.mDiscoveryManager = continuityDiscoveryManager;
    }

    public final void setMMessageManager(@Nullable ContinuitySessionMessageManager continuitySessionMessageManager) {
        this.mMessageManager = continuitySessionMessageManager;
    }

    public final void setMNearbyMyDevicesModel(@Nullable NearbyMyDevicesModel nearbyMyDevicesModel) {
        this.mNearbyMyDevicesModel = nearbyMyDevicesModel;
    }

    public final void setMSessionManager(@Nullable ContinuitySessionManager continuitySessionManager) {
        this.mSessionManager = continuitySessionManager;
    }

    public void stopDiscovery() {
    }

    public final void unregisterMessageIntentListener() {
        ContinuityAdapter continuityAdapter = this.mContinuityAdapter;
        if (continuityAdapter == null) {
            InAppLogger.m8596e(getTag(), "unregisterMessageIntentListener# fail - Continuity is not Supported");
            return;
        }
        ContinuityDiscoveryManager continuityDiscoveryManager = continuityAdapter != null ? continuityAdapter.getContinuityDiscoveryManager() : null;
        if (continuityDiscoveryManager == null) {
            InAppLogger.m8596e(getTag(), "unregisterMessageIntentListener# fail - DiscoveryManager is null");
            return;
        }
        ContinuitySimpleMessageManager continuitySimpleMessageManager = continuityDiscoveryManager.getContinuitySimpleMessageManager();
        Intrinsics.checkNotNullExpressionValue(continuitySimpleMessageManager, "getContinuitySimpleMessageManager(...)");
        continuitySimpleMessageManager.unregisterMessageIntentListener();
    }
}
