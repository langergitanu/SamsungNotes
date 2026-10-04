package com.samsung.android.sdk.mobileservice.social.buddy;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.buddy.IBuddyInfoResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.IPublicBuddyInfoResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.ISyncResultCallback;
import com.samsung.android.sdk.mobileservice.social.buddy.PublicBuddyInfo;
import com.samsung.android.sdk.mobileservice.social.buddy.request.BuddyInfoRequest;
import com.samsung.android.sdk.mobileservice.social.buddy.request.TargetAppListRequest;
import com.samsung.android.sdk.mobileservice.social.buddy.result.Buddy;
import com.samsung.android.sdk.mobileservice.social.buddy.result.BuddyResult;
import com.samsung.android.sdk.mobileservice.social.buddy.result.Certificate;
import com.samsung.android.sdk.mobileservice.social.buddy.result.PublicBuddyInfoResult;
import com.samsung.android.sdk.mobileservice.social.buddy.result.SyncedContact;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BuddyApi extends SeMobileServiceApi {
    public static final String API_NAME = "BuddyApi";
    private static final String EXTRA_TIMESTAMP = "timestamp";
    private static final Long INVALID_TIMESTAMP = -1L;
    private static final String KEY_QUERY_RESULT = "QUERY_RESULT";
    private static final String KEY_QUERY_SELECTION = "QUERY_SELECTION";
    private static final int QUERY_TYPE_CERTIFICATE = 0;
    private static final int QUERY_TYPE_SYNCED_CONTACT_ID = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BuddyInfoCallback {
        void onResult(BuddyResult<Buddy> buddyResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BuddyResultCallback<T> {
        void onResult(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PublicBuddyInfoResultCallback {
        void onResult(PublicBuddyInfoResult publicBuddyInfoResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SyncResultCallback {
        void onResult(BooleanResult booleanResult);
    }

    public BuddyApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "BuddyApi");
        checkAuthorized(0, 2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkItem(int i, int i2) {
        return (i & i2) == i2;
    }

    public void getBuddyInfo(final BuddyInfoRequest buddyInfoRequest, final BuddyInfoCallback buddyInfoCallback) {
        try {
            debugLog("getBuddyInfo");
            getSocialService().getBuddyInfo(buddyInfoRequest.toBundle(), new IBuddyInfoResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.buddy.BuddyApi.3
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IBuddyInfoResultCallback
                public void onFailure(int i, String str) {
                    BuddyApi.this.debugLog(AbstractC11014a.m12321f("getBuddyInfo onFailure : code=[", i, "], message=[", str, "] "));
                    CommonResultStatus commonResultStatus = new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(i), str, String.valueOf(i));
                    BuddyInfoCallback buddyInfoCallback2 = buddyInfoCallback;
                    if (buddyInfoCallback2 != null) {
                        buddyInfoCallback2.onResult(new BuddyResult<>(commonResultStatus, null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IBuddyInfoResultCallback
                public void onSuccess(Bundle bundle) {
                    long j = bundle.getLong(BuddyApi.KEY_QUERY_RESULT, 1000L);
                    CommonResultStatus commonResultStatus = new CommonResultStatus(j == 0 ? 1 : ErrorCodeConvertor.convertErrorcode(j));
                    Buddy buddy = null;
                    if (commonResultStatus.getCode() == 1) {
                        buddy = new Buddy(bundle.getString("contact_id"), BuddyApi.this.checkItem(buddyInfoRequest.getItemFlags(), 1) ? new Certificate(bundle.getString("certificate")) : null, BuddyApi.this.checkItem(buddyInfoRequest.getItemFlags(), 2) ? new SyncedContact(bundle.getString("raw_contact_id")) : null);
                    }
                    buddyInfoCallback.onResult(new BuddyResult<>(commonResultStatus, buddy));
                }
            });
        } catch (RemoteException e) {
            secureLog(e);
            buddyInfoCallback.onResult(new BuddyResult<>(new CommonResultStatus(301), null));
        } catch (NotConnectedException e2) {
            secureLog(e2);
            buddyInfoCallback.onResult(new BuddyResult<>(new CommonResultStatus(-8), null));
        }
    }

    public CommonResult<Long> getBuddySyncTime() {
        debugLog("getBuddySyncTime ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_50)) {
            return new CommonResult<>(new CommonResultStatus(-7), INVALID_TIMESTAMP);
        }
        try {
            Bundle buddySyncTime = getSocialService().getBuddySyncTime();
            long jLongValue = INVALID_TIMESTAMP.longValue();
            if (buddySyncTime != null) {
                jLongValue = buddySyncTime.getLong("timestamp");
            }
            debugLog("getBuddySyncTime. result: " + jLongValue);
            return new CommonResult<>(new CommonResultStatus(1), Long.valueOf(jLongValue));
        } catch (Exception e) {
            secureLog(e);
            return new CommonResult<>(new CommonResultStatus(-1), INVALID_TIMESTAMP);
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"SocialService"};
    }

    public int requestAppUpdateAndLaunchForBuddy(TargetAppListRequest targetAppListRequest, final BuddyResultCallback<BooleanResult> buddyResultCallback) {
        debugLog("requestAppUpdateAndLaunchForBuddy ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_13_6_10)) {
            return -7;
        }
        try {
            getSocialService().requestAppUpdateAndLaunchForBuddy(targetAppListRequest.toBundle(), new IBuddyInfoResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.buddy.BuddyApi.5
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IBuddyInfoResultCallback
                public void onFailure(int i, String str) {
                    BuddyApi.this.debugLog(AbstractC11014a.m12321f("requestAppUpdateAndLaunchForBuddy onFailure : code=[", i, "], message=[", str, "] "));
                    if (buddyResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(i);
                        BuddyApi buddyApi = BuddyApi.this;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertErrorcode, i, "requestAppUpdateAndLaunchForBuddy onFailure (", SQLKeyword.COMMA, SQLKeyword.COMMA);
                        sbM1173s.append(str);
                        sbM1173s.append(")");
                        buddyApi.debugLog(sbM1173s.toString());
                        buddyResultCallback.onResult(new BooleanResult(new CommonResultStatus(iConvertErrorcode, str, Long.toString(i)), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IBuddyInfoResultCallback
                public void onSuccess(Bundle bundle) {
                    BuddyApi.this.debugLog("requestAppUpdateAndLaunchForBuddy onSuccess ");
                    BuddyResultCallback buddyResultCallback2 = buddyResultCallback;
                    if (buddyResultCallback2 != null) {
                        buddyResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestPublicBuddyInfo(String str, final PublicBuddyInfoResultCallback publicBuddyInfoResultCallback) {
        debugLog("requestPublicBuddyInfo ");
        secureLog(" - phoneNumber = [%s]", str);
        try {
            getSocialService().requestPublicBuddyInfo(str, new IPublicBuddyInfoResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.buddy.BuddyApi.4
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IPublicBuddyInfoResultCallback
                public void onFailure(int i, String str2) {
                    BuddyApi.this.debugLog(AbstractC11014a.m12321f("requestPublicBuddyInfo onFailure : code=[", i, "], message=[", str2, "] "));
                    if (publicBuddyInfoResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(i);
                        BuddyApi buddyApi = BuddyApi.this;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertErrorcode, i, "requestPublicBuddyInfo onFailure (", SQLKeyword.COMMA, SQLKeyword.COMMA);
                        sbM1173s.append(str2);
                        sbM1173s.append(")");
                        buddyApi.debugLog(sbM1173s.toString());
                        publicBuddyInfoResultCallback.onResult(new PublicBuddyInfoResult(new CommonResultStatus(iConvertErrorcode, str2, Integer.toString(i)), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.IPublicBuddyInfoResultCallback
                public void onSuccess(Bundle bundle) {
                    BuddyApi.this.debugLog("requestPublicBuddyInfo onSuccess ");
                    if (publicBuddyInfoResultCallback != null) {
                        String string = bundle.getString("extra_phone_number", null);
                        String string2 = bundle.getString("extra_name", null);
                        String string3 = bundle.getString("extra_status_msg", null);
                        byte[] byteArray = bundle.getByteArray("extra_image");
                        String string4 = bundle.getString("extra_image_type");
                        ArrayList<String> stringArrayList = bundle.getStringArrayList("extra_app_list");
                        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("extra_svc_list");
                        BuddyApi.this.secureLog("requestPublicBuddyInfo extra_phone_number : [%s]", string);
                        BuddyApi.this.secureLog("requestPublicBuddyInfo extra_status_msg : [%s]", string3);
                        ArrayList arrayList = new ArrayList();
                        if (stringArrayList != null && stringArrayList2 != null) {
                            for (int i = 0; i < stringArrayList.size(); i++) {
                                arrayList.add(new PublicBuddyInfo.Capability(stringArrayList.get(i), stringArrayList2.get(i)));
                            }
                        }
                        publicBuddyInfoResultCallback.onResult(new PublicBuddyInfoResult(new CommonResultStatus(1), new PublicBuddyInfo(string, string2, string3, byteArray, string4, arrayList)));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    @Deprecated
    public int requestSync(final SyncResultCallback syncResultCallback) {
        debugLog("requestSync ");
        try {
            getSocialService().requestSync(new ISyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.buddy.BuddyApi.1
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.ISyncResultCallback
                public void onFailure(int i, String str) {
                    BuddyApi.this.debugLog(AbstractC11014a.m12321f("requestSync onFailure : code=[", i, "], message=[", str, "] "));
                    if (syncResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(i);
                        BuddyApi buddyApi = BuddyApi.this;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertErrorcode, i, "requestSync onFailure (", SQLKeyword.COMMA, SQLKeyword.COMMA);
                        sbM1173s.append(str);
                        sbM1173s.append(")");
                        buddyApi.debugLog(sbM1173s.toString());
                        syncResultCallback.onResult(new BooleanResult(new CommonResultStatus(iConvertErrorcode, str, Integer.toString(i)), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.ISyncResultCallback
                public void onSuccess() {
                    BuddyApi.this.debugLog("requestSync onSuccess ");
                    SyncResultCallback syncResultCallback2 = syncResultCallback;
                    if (syncResultCallback2 != null) {
                        syncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }

    public int requestSync(int i, final SyncResultCallback syncResultCallback) {
        debugLog("requestSync ");
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_11_1)) {
            return -7;
        }
        try {
            getSocialService().requestBuddySync(i, new ISyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.buddy.BuddyApi.2
                @Override // com.samsung.android.sdk.mobileservice.social.buddy.ISyncResultCallback
                public void onFailure(int i2, String str) {
                    BuddyApi.this.debugLog(AbstractC11014a.m12321f("requestSync onFailure : code=[", i2, "], message=[", str, "] "));
                    if (syncResultCallback != null) {
                        int iConvertErrorcode = ErrorCodeConvertor.convertErrorcode(i2);
                        BuddyApi buddyApi = BuddyApi.this;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertErrorcode, i2, "requestSync onFailure (", SQLKeyword.COMMA, SQLKeyword.COMMA);
                        sbM1173s.append(str);
                        sbM1173s.append(")");
                        buddyApi.debugLog(sbM1173s.toString());
                        syncResultCallback.onResult(new BooleanResult(new CommonResultStatus(iConvertErrorcode, str, Integer.toString(i2)), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.social.buddy.ISyncResultCallback
                public void onSuccess() {
                    BuddyApi.this.debugLog("requestSync onSuccess ");
                    SyncResultCallback syncResultCallback2 = syncResultCallback;
                    if (syncResultCallback2 != null) {
                        syncResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            secureLog(e2);
            return -8;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        }
    }
}
