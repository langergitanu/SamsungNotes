package com.samsung.android.support.senl.p148nt.base.common.inapp.model;

import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevices;", "", "deviceFound", "", "continuityMenu", "Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevices$ContinuityMenuContract;", "nearbyMyDevice", "Lcom/samsung/android/mcf/continuity/api/ContinuityNearbyMyDevice;", "deviceLost", "ContinuityMenuContract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface NearbyMyDevices {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/model/NearbyMyDevices$ContinuityMenuContract;", "", "onUpdateMenuVisibility", "", "onUpdateDeviceListDialog", "onReleaseDim", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ContinuityMenuContract {
        void onReleaseDim();

        void onUpdateDeviceListDialog();

        void onUpdateMenuVisibility();
    }

    void deviceFound(@Nullable ContinuityMenuContract continuityMenu, @Nullable ContinuityNearbyMyDevice nearbyMyDevice);

    void deviceLost(@Nullable ContinuityMenuContract continuityMenu, @Nullable ContinuityNearbyMyDevice nearbyMyDevice);
}
