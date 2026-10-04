package com.samsung.android.sdk.mobileservice.social.datasync;

import android.os.Bundle;
import android.os.RemoteException;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback;
import com.samsung.android.sdk.mobileservice.social.datasync.result.DataSyncResult;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DataSyncApi extends SeMobileServiceApi {
    public static final String API_NAME = "DataSyncApi";
    private static final String BUNDLE_KEY_DATA_LIST = "data_list";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DataSyncResultCallback {
        void onResult(DataSyncResult dataSyncResult);
    }

    public DataSyncApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "DataSyncApi");
        checkAuthorized(0, 2);
    }

    public int delete(DataSyncRequest dataSyncRequest, final DataSyncResultCallback dataSyncResultCallback) {
        debugLog(OpenSessionApi.ITEM_LIMIT_DELETE);
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return -7;
        }
        String serviceName = dataSyncRequest.getServiceName();
        if (serviceName == null || serviceName.isEmpty()) {
            infoLog("serviceName is invalid");
            return -1;
        }
        try {
            getSocialService().dataSyncDelete(serviceName, dataSyncRequest.toBundle(), new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.datasync.DataSyncApi.2
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onFailure(long j, String str) {
                    DataSyncApi.this.debugLog("delete. onFailure : code=" + j + ", message=" + str);
                    DataSyncResultCallback dataSyncResultCallback2 = dataSyncResultCallback;
                    if (dataSyncResultCallback2 != null) {
                        dataSyncResultCallback2.onResult(new DataSyncResult(new CommonResultStatus(-1, str, Long.toString(j))));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onSuccess(Bundle bundle) {
                    DataSyncApi.this.debugLog("delete. onSuccess");
                    DataSyncResultCallback dataSyncResultCallback2 = dataSyncResultCallback;
                    if (dataSyncResultCallback2 != null) {
                        dataSyncResultCallback2.onResult(new DataSyncResult(new CommonResultStatus(1)));
                    }
                }
            });
            return 1;
        } catch (RemoteException | NotConnectedException e) {
            secureLog(e);
            return -1;
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    public int getSyncedData(DataSyncRequest dataSyncRequest, final DataSyncResultCallback dataSyncResultCallback) {
        debugLog("getSyncedData");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return -7;
        }
        final String serviceName = dataSyncRequest.getServiceName();
        if (serviceName == null || serviceName.isEmpty()) {
            infoLog("serviceName is invalid");
            return -1;
        }
        try {
            getSocialService().dataSyncGetSyncedData(serviceName, dataSyncRequest.toBundle(), new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.datasync.DataSyncApi.3
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onFailure(long j, String str) {
                    DataSyncApi.this.debugLog("getSyncedData. onFailure : code=" + j + ", message=" + str);
                    DataSyncResultCallback dataSyncResultCallback2 = dataSyncResultCallback;
                    if (dataSyncResultCallback2 != null) {
                        dataSyncResultCallback2.onResult(new DataSyncResult(new CommonResultStatus(-1, str, Long.toString(j))));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onSuccess(Bundle bundle) {
                    DataSyncApi.this.debugLog("getSyncedData. onSuccess");
                    if (dataSyncResultCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(DataSyncApi.BUNDLE_KEY_DATA_LIST);
                        if (parcelableArrayList != null) {
                            Iterator it = parcelableArrayList.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new SyncedData(serviceName, (Bundle) it.next()));
                            }
                        }
                        dataSyncResultCallback.onResult(new DataSyncResult(new CommonResultStatus(1), arrayList));
                    }
                }
            });
            return 1;
        } catch (RemoteException | NotConnectedException e) {
            secureLog(e);
            return -1;
        }
    }

    public int upsert(DataSyncRequest dataSyncRequest, final DataSyncResultCallback dataSyncResultCallback) {
        debugLog("upsert");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return -7;
        }
        if (dataSyncRequest.isInvalid().booleanValue()) {
            infoLog("request data is invalid");
            return -1;
        }
        try {
            final String serviceName = dataSyncRequest.getServiceName();
            getSocialService().dataSyncUpsert(serviceName, dataSyncRequest.toBundle(), new IBundleResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.datasync.DataSyncApi.1
                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onFailure(long j, String str) {
                    DataSyncApi.this.debugLog("upsert. onFailure : code=" + j + ", message=" + str);
                    DataSyncResultCallback dataSyncResultCallback2 = dataSyncResultCallback;
                    if (dataSyncResultCallback2 != null) {
                        dataSyncResultCallback2.onResult(new DataSyncResult(new CommonResultStatus(-1, str, Long.toString(j))));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.common.IBundleResultCallback
                public void onSuccess(Bundle bundle) {
                    DataSyncApi.this.debugLog("upsert. onSuccess");
                    if (dataSyncResultCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(DataSyncApi.BUNDLE_KEY_DATA_LIST);
                        if (parcelableArrayList != null) {
                            Iterator it = parcelableArrayList.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new SyncedData(serviceName, (Bundle) it.next()));
                            }
                        }
                        DataSyncApi.this.debugLog("upsert. onSuccess : syncedDataList.size=" + arrayList.size());
                        dataSyncResultCallback.onResult(new DataSyncResult(new CommonResultStatus(1), arrayList));
                    }
                }
            });
            return 1;
        } catch (RemoteException | NotConnectedException e) {
            secureLog(e);
            return -1;
        }
    }
}
