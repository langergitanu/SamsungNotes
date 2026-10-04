package com.samsung.android.support.senl.p148nt.base.common.inapp.model;

import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevices;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel;", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevices;", "<init>", "()V", "mNearbyMyDevices", "", "", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel$NearbyDevice;", "deviceFound", "", "continuityMenu", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevices$ContinuityMenuContract;", "nearbyMyDevice", "Lcom/samsung/android/mcf/continuity/api/ContinuityNearbyMyDevice;", "deviceLost", "checkNeedToUpdateMenu", "isEmpty", "", "clear", "hasNearbyMyDevices", "nearbyMyDevices", "", "getNearbyMyDevices", "()Ljava/util/Map;", "NearbyDevice", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NearbyMyDevicesModel implements NearbyMyDevices {

    @NotNull
    private static final String TAG = "NearbyMyDevicesModel";

    @NotNull
    private final Map<String, NearbyDevice> mNearbyMyDevices = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevicesModel$NearbyDevice;", "", "btMac", "", "displayName", IdentityApiContract.Parameter.MODEL_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtMac", "()Ljava/lang/String;", "setBtMac", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getModelName", "setModelName", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class NearbyDevice {

        @NotNull
        private String btMac;

        @Nullable
        private String displayName;

        @Nullable
        private String modelName;

        public NearbyDevice(@NotNull String btMac, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(btMac, "btMac");
            this.btMac = btMac;
            this.displayName = str;
            this.modelName = str2;
        }

        @NotNull
        public final String getBtMac() {
            return this.btMac;
        }

        @Nullable
        public final String getDisplayName() {
            return this.displayName;
        }

        @Nullable
        public final String getModelName() {
            return this.modelName;
        }

        public final void setBtMac(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.btMac = str;
        }

        public final void setDisplayName(@Nullable String str) {
            this.displayName = str;
        }

        public final void setModelName(@Nullable String str) {
            this.modelName = str;
        }
    }

    private final void checkNeedToUpdateMenu(NearbyMyDevices.ContinuityMenuContract continuityMenu, boolean isEmpty) {
        if (isEmpty == this.mNearbyMyDevices.isEmpty() || continuityMenu == null) {
            return;
        }
        continuityMenu.onUpdateMenuVisibility();
    }

    public final void clear() {
        this.mNearbyMyDevices.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevices
    public void deviceFound(@Nullable NearbyMyDevices.ContinuityMenuContract continuityMenu, @Nullable ContinuityNearbyMyDevice nearbyMyDevice) {
        boolean zIsEmpty = this.mNearbyMyDevices.isEmpty();
        String btMac = nearbyMyDevice != null ? nearbyMyDevice.getBtMac() : null;
        if (btMac != null && nearbyMyDevice.getDeviceType() == 1) {
            this.mNearbyMyDevices.put(btMac, new NearbyDevice(btMac, nearbyMyDevice.getDisplayName(), nearbyMyDevice.getModelName()));
            if (continuityMenu != null) {
                continuityMenu.onUpdateDeviceListDialog();
            }
        }
        InAppLogger.m8595d(TAG, "deviceFound# size : " + this.mNearbyMyDevices.size());
        checkNeedToUpdateMenu(continuityMenu, zIsEmpty);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevices
    public void deviceLost(@Nullable NearbyMyDevices.ContinuityMenuContract continuityMenu, @Nullable ContinuityNearbyMyDevice nearbyMyDevice) {
        boolean zIsEmpty = this.mNearbyMyDevices.isEmpty();
        String btMac = nearbyMyDevice != null ? nearbyMyDevice.getBtMac() : null;
        if (btMac != null) {
            this.mNearbyMyDevices.remove(btMac);
            if (continuityMenu != null) {
                continuityMenu.onUpdateDeviceListDialog();
            }
        }
        InAppLogger.m8595d(TAG, "deviceLost# size : " + this.mNearbyMyDevices.size());
        checkNeedToUpdateMenu(continuityMenu, zIsEmpty);
    }

    @NotNull
    public final Map<String, NearbyDevice> getNearbyMyDevices() {
        return this.mNearbyMyDevices;
    }

    public final boolean hasNearbyMyDevices() {
        InAppLogger.m8595d(TAG, "hasNearbyMyDevices# NearbyMyDevices size : " + this.mNearbyMyDevices.size());
        return !this.mNearbyMyDevices.isEmpty();
    }
}
