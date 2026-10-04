package com.samsung.android.sdk.mobileservice.place;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PlaceApi extends SeMobileServiceApi {
    public static final String API_NAME = "PlaceApi";
    public static final String SERVICE_NAME = "PlaceService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PlaceRequest {
        private String mAddress;
        private String mBluetoothMacAddress;
        private String mBluetoothName;
        private double mLatitude;
        private double mLongitude;
        private String mName;
        private int mPlaceType;
        private String mWifiBssId;
        private String mWifiName;

        public PlaceRequest(String str, String str2, double d, double d2, String str3, String str4) {
            this(str, 4, str2, d, d2, str3, str4, null, null);
        }

        public String getAddress() {
            return this.mAddress;
        }

        public String getBluetoothMacAddress() {
            return this.mBluetoothMacAddress;
        }

        public String getBluetoothName() {
            return this.mBluetoothName;
        }

        public double getLatitude() {
            return this.mLatitude;
        }

        public double getLongitude() {
            return this.mLongitude;
        }

        public String getName() {
            return this.mName;
        }

        public int getPlaceType() {
            return this.mPlaceType;
        }

        public String getWifiBssId() {
            return this.mWifiBssId;
        }

        public String getWifiName() {
            return this.mWifiName;
        }

        public void setAddress(String str) {
            this.mAddress = str;
        }

        public void setBluetoothMacAddress(String str) {
            this.mBluetoothMacAddress = str;
        }

        public void setBluetoothName(String str) {
            this.mBluetoothName = str;
        }

        public void setLatitude(double d) {
            this.mLatitude = d;
        }

        public void setLongitude(double d) {
            this.mLongitude = d;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public void setPlaceType(int i) {
            this.mPlaceType = i;
        }

        public void setWifiBssId(String str) {
            this.mWifiBssId = str;
        }

        public void setWifiName(String str) {
            this.mWifiName = str;
        }

        public Bundle writeToBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("name", this.mName);
            bundle.putInt("category", this.mPlaceType);
            bundle.putString("address", this.mAddress);
            bundle.putDouble("latitude", this.mLatitude);
            bundle.putDouble("longitude", this.mLongitude);
            bundle.putString("wifi_name", this.mWifiName);
            bundle.putString("wifi_bss_id", this.mWifiBssId);
            bundle.putString("bluetooth_name", this.mBluetoothName);
            bundle.putString("bluetooth_mac_address", this.mBluetoothMacAddress);
            return bundle;
        }

        public PlaceRequest(int i, String str, double d, double d2, String str2, String str3) {
            this(null, i, str, d, d2, str2, str3, null, null);
        }

        public PlaceRequest(String str, String str2) {
            this(null, 3, null, -1.0d, -1.0d, null, null, str, str2);
        }

        private PlaceRequest(String str, int i, String str2, double d, double d2, String str3, String str4, String str5, String str6) {
            this.mName = str;
            this.mPlaceType = i;
            this.mAddress = str2;
            this.mLatitude = d;
            this.mLongitude = d2;
            this.mWifiName = str3;
            this.mWifiBssId = str4;
            this.mBluetoothName = str5;
            this.mBluetoothMacAddress = str6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PlaceResultCallback<T> {
        void onResult(PlaceResult<T> placeResult);
    }

    public PlaceApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "PlaceApi");
        checkAuthorized(0);
    }

    private boolean isAppIdNullOrEmpty() {
        if (!TextUtils.isEmpty(getAppId())) {
            return false;
        }
        debugLog("appId is null or empty");
        return true;
    }

    public int getCurrentCount() {
        debugLog("getCurrentCount ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            int currentCount = getPlaceService().getCurrentCount();
            debugLog("getCurrentCount : count=[" + currentCount + "] ");
            return currentCount;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"PlaceService"};
    }

    public int getMaxCount() {
        debugLog("getMaxCount ");
        if (isAppIdNullOrEmpty()) {
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return -7;
        }
        try {
            int maxCount = getPlaceService().getMaxCount();
            debugLog("getMaxCount : count=[" + maxCount + "] ");
            return maxCount;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public List<Place> getPlaceList() {
        debugLog("getPlaces ");
        if (isAppIdNullOrEmpty()) {
            return new ArrayList();
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            List<Bundle> placeList = getPlaceService().getPlaceList();
            debugLog("getPlaceList : list size=[" + placeList.size() + "] ");
            Iterator<Bundle> it = placeList.iterator();
            while (it.hasNext()) {
                arrayList.add(new Place(it.next()));
            }
            return arrayList;
        } catch (Exception e) {
            secureLog(e);
            return new ArrayList();
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new ArrayList();
        }
    }

    public int requestPlaceCreation(PlaceRequest placeRequest, final PlaceResultCallback<Place> placeResultCallback) {
        debugLog("requestPlaceCreation ");
        if (isAppIdNullOrEmpty()) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(-1, "appId is null or empty", ""), null));
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(200), null));
            return -7;
        }
        try {
            getPlaceService().requestPlaceCreate(placeRequest.writeToBundle(), new IPlaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.place.PlaceApi.2
                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onFailure(String str, String str2) {
                    PlaceApi.this.debugLog(AbstractC0541b.m775q("requestPlaceCreation onFailure : code=[", str, "], message=[", str2, "] "));
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(-1, str2, str), null));
                }

                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onSuccess(Bundle bundle) {
                    Place place = new Place(bundle);
                    PlaceApi.this.debugLog("requestPlaceCreation onSuccess : name=[" + place.getName() + "], createTime=[" + place.getUpdatedTime() + "]");
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(1), place));
                }
            });
            return 1;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestPlaceDeletion(String str, final PlaceResultCallback<Boolean> placeResultCallback) {
        debugLog("requestPlaceDeletion ");
        if (isAppIdNullOrEmpty()) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(-1, "appId is null or empty", ""), Boolean.FALSE));
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(200), Boolean.FALSE));
            return -7;
        }
        try {
            getPlaceService().requestPlaceDelete(str, new IPlaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.place.PlaceApi.3
                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onFailure(String str2, String str3) {
                    PlaceApi.this.debugLog(AbstractC0541b.m775q("requestPlaceDeletion onFailure : code=[", str2, "], message=[", str3, "] "));
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(-1, str3, str2), Boolean.FALSE));
                }

                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onSuccess(Bundle bundle) {
                    PlaceApi.this.debugLog("requestPlaceDeletion onSuccess ");
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(1), Boolean.TRUE));
                }
            });
            return 1;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestPlaceUpdate(Place place, final PlaceResultCallback<Place> placeResultCallback) {
        debugLog("requestPlaceUpdate ");
        if (isAppIdNullOrEmpty()) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(-1, "appId is null or empty", ""), null));
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(200), null));
            return -7;
        }
        try {
            getPlaceService().requestPlaceUpdate(place.writeToBundle(), new IPlaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.place.PlaceApi.4
                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onFailure(String str, String str2) {
                    PlaceApi.this.debugLog(AbstractC0541b.m775q("requestPlaceUpdate onFailure : code=[", str, "], message=[", str2, "] "));
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(-1, str2, str), null));
                }

                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onSuccess(Bundle bundle) {
                    Place place2 = new Place(bundle);
                    PlaceApi.this.debugLog("requestPlaceUpdate onSuccess : name=[" + place2.getName() + "], updateTime=[" + place2.getUpdatedTime() + "]");
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(1), place2));
                }
            });
            return 1;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public int requestSync(final PlaceResultCallback<Boolean> placeResultCallback) {
        debugLog("requestSync ");
        if (isAppIdNullOrEmpty()) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(-1, "appId is null or empty", ""), Boolean.FALSE));
            return -1;
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            placeResultCallback.onResult(new PlaceResult<>(new CommonResultStatus(200), Boolean.FALSE));
            return -7;
        }
        try {
            getPlaceService().requestSync(new IPlaceResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.place.PlaceApi.1
                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onFailure(String str, String str2) {
                    PlaceApi.this.debugLog(AbstractC0541b.m775q("requestSync onFailure : code=[", str, "], message=[", str2, "] "));
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(-1, str2, str), Boolean.FALSE));
                }

                @Override // com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback
                public void onSuccess(Bundle bundle) {
                    PlaceApi.this.debugLog("requestSync onSuccess ");
                    placeResultCallback.onResult(new PlaceResult(new CommonResultStatus(1), Boolean.TRUE));
                }
            });
            return 1;
        } catch (Exception e) {
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public List<Place> getPlaceList(int i) {
        debugLog("getPlaces ");
        if (isAppIdNullOrEmpty()) {
            return new ArrayList();
        }
        if (!isSupportedSemsAgentVersionMoreThan(1000000000)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            List<Bundle> listSearchPlaces = getPlaceService().searchPlaces(i);
            debugLog("getPlaceList(" + i + ") : list size=[" + listSearchPlaces.size() + "] ");
            Iterator<Bundle> it = listSearchPlaces.iterator();
            while (it.hasNext()) {
                arrayList.add(new Place(it.next()));
            }
            return arrayList;
        } catch (Exception e) {
            secureLog(e);
            return new ArrayList();
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new ArrayList();
        }
    }
}
