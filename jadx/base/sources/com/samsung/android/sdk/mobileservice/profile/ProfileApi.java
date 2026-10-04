package com.samsung.android.sdk.mobileservice.profile;

import android.net.Uri;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.profile.IPrivacyUpdateResultCallback;
import com.samsung.android.sdk.mobileservice.profile.IProfileUpdateResultCallback;
import com.samsung.android.sdk.mobileservice.profile.ISyncResultCallback;
import com.samsung.android.sdk.mobileservice.profile.result.PrivacyResult;
import com.samsung.android.sdk.mobileservice.profile.result.ProfileBirthdayTypeResult;
import com.samsung.android.sdk.mobileservice.profile.result.ProfileImageUrlResult;
import com.samsung.android.sdk.mobileservice.profile.result.ProfileResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ProfileApi extends SeMobileServiceApi {
    public static final String API_NAME = "ProfileApi";
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    public static final int PRIVACY_TYPE_CONTACTS = 2;
    public static final int PRIVACY_TYPE_EVERYONE = 0;
    public static final String SERVICE_NAME = "ProfileService";
    private int mConnectedProfileVersion;
    private int mPrivacyType;

    /* JADX INFO: renamed from: com.samsung.android.sdk.mobileservice.profile.ProfileApi$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C73075 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$mobileservice$profile$ProfileApi$ProfileBirthdayType */
        static final /* synthetic */ int[] f4876x84b8df45;

        static {
            int[] iArr = new int[ProfileBirthdayType.values().length];
            f4876x84b8df45 = iArr;
            try {
                iArr[ProfileBirthdayType.SOLAR_BIRTHDAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4876x84b8df45[ProfileBirthdayType.LUNAR_BIRTHDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4876x84b8df45[ProfileBirthdayType.LEAP_BIRTHDAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PrivacyUpdateResultCallback {
        void onResult(BooleanResult booleanResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ProfileBirthdayType {
        SOLAR_BIRTHDAY,
        LUNAR_BIRTHDAY,
        LEAP_BIRTHDAY,
        INVALID
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProfileUpdateResultCallback {
        void onResult(BooleanResult booleanResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SyncResultCallback {
        void onResult(ProfileResult profileResult);
    }

    public ProfileApi(SeMobileServiceSession seMobileServiceSession) throws NotAuthorizedException {
        super(seMobileServiceSession, "ProfileApi");
        this.mConnectedProfileVersion = 6;
        this.mPrivacyType = 0;
        checkAuthorized(0);
        try {
            this.mConnectedProfileVersion = getProfileService().exchangeProfileVersion(6);
        } catch (RemoteException e) {
            secureLog(e);
        }
    }

    private String convertProfileBirthdayTypeToString(ProfileBirthdayType profileBirthdayType) {
        int i = C73075.f4876x84b8df45[profileBirthdayType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : "2" : "1" : "0";
    }

    private byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    private boolean isAppIdNullOrEmpty() {
        if (!TextUtils.isEmpty(getAppId())) {
            return false;
        }
        debugLog("appId is null or empty");
        return true;
    }

    private void setPhotoBlobFromUriIfNeeded(Profile profile) throws IOException {
        if (TextUtils.isEmpty(profile.getPhotoInstance().getPhotoFileUri())) {
            debugLog("uriString for photo is null or empty.");
            return;
        }
        Uri uri = Uri.parse(profile.getPhotoInstance().getPhotoFileUri());
        if (uri != null) {
            InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    profile.getPhotoInstance().setPhoto(getBytes(inputStreamOpenInputStream));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
        }
    }

    @Override // com.samsung.android.sdk.mobileservice.common.api.SeMobileServiceApi
    public String[] getEssentialServiceNames() {
        return new String[]{"ProfileService"};
    }

    public PrivacyResult getPrivacy() {
        debugLog("getPrivacy ");
        if (isAppIdNullOrEmpty()) {
            return new PrivacyResult(new CommonResultStatus(-1, "appId id null or empty", ""), null);
        }
        try {
            if (getProfileService() == null) {
                debugLog("profile service is null ");
                return new PrivacyResult(new CommonResultStatus(5), null);
            }
            return new PrivacyResult(new CommonResultStatus(1), new Privacy(getProfileService().getPrivacy()));
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new PrivacyResult(new CommonResultStatus(-1), null);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new PrivacyResult(new CommonResultStatus(-1), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new PrivacyResult(new CommonResultStatus(-1), null);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new PrivacyResult(new CommonResultStatus(-1), null);
        }
    }

    public ProfileResult getProfile() {
        debugLog("getProfile ");
        if (isAppIdNullOrEmpty()) {
            return new ProfileResult(new CommonResultStatus(-1, "appId id null or empty", ""), null);
        }
        try {
            Profile profile = getProfileService().getProfile();
            try {
                setPhotoBlobFromUriIfNeeded(profile);
                return new ProfileResult(new CommonResultStatus(1), profile);
            } catch (IOException unused) {
                verboseLog("IOException");
                return new ProfileResult(new CommonResultStatus(-1, "IOException", "IOException"), null);
            }
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new ProfileResult(new CommonResultStatus(-1, "RemoteException", "RemoteException"), null);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new ProfileResult(new CommonResultStatus(-1, "RemoteException", "RemoteException"), null);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new ProfileResult(new CommonResultStatus(-1, "RemoteException", "RemoteException"), null);
        } catch (OutOfMemoryError unused2) {
            verboseLog("OutOfMemoryError");
            return new ProfileResult(new CommonResultStatus(-1, "OutOfMemoryError", "OutOfMemoryError"), null);
        }
    }

    public ProfileBirthdayTypeResult getProfileBirthdayType() {
        debugLog("getProfileBirthdayType ");
        if (isAppIdNullOrEmpty()) {
            return new ProfileBirthdayTypeResult(new CommonResultStatus(-1, "appId id null or empty", ""), "");
        }
        if (!isSupportedSaAgentVersion(CommonConstants.SupportedApiMinVersion.VERSION_11_0)) {
            return new ProfileBirthdayTypeResult(new CommonResultStatus(200), "");
        }
        try {
            return new ProfileBirthdayTypeResult(new CommonResultStatus(1), getProfileService().getProfileBirthdayType());
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new ProfileBirthdayTypeResult(new CommonResultStatus(-1, e.getMessage(), e.getClass().getSimpleName()), "");
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new ProfileBirthdayTypeResult(new CommonResultStatus(-1, e.getMessage(), e.getClass().getSimpleName()), "");
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new ProfileBirthdayTypeResult(new CommonResultStatus(-1, e.getMessage(), e.getClass().getSimpleName()), "");
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new ProfileBirthdayTypeResult(new CommonResultStatus(-1, "OutOfMemoryError", "OutOfMemoryError"), "");
        }
    }

    public ProfileImageUrlResult getProfileImageUrl() {
        debugLog("getProfileImageUrl");
        if (isAppIdNullOrEmpty()) {
            return new ProfileImageUrlResult(new CommonResultStatus(-1, "appId id null or empty", ""), "");
        }
        if (!isSupportedSemsAgentVersionMoreThan(CommonConstants.SupportedApiMinVersion.VERSION_10_6)) {
            return new ProfileImageUrlResult(new CommonResultStatus(200), "");
        }
        try {
            return new ProfileImageUrlResult(new CommonResultStatus(1), getProfileService().getProfileImageUrl());
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return new ProfileImageUrlResult(new CommonResultStatus(-1, "RemoteException", "RemoteException"), "");
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return new ProfileImageUrlResult(new CommonResultStatus(-1, "RemoteException", "RemoteException"), "");
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return new ProfileImageUrlResult(new CommonResultStatus(-1, "RemoteException", "RemoteException"), "");
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return new ProfileImageUrlResult(new CommonResultStatus(-1, "OutOfMemoryError", "OutOfMemoryError"), "");
        }
    }

    public int requestPrivacyUpdate(Privacy privacy, final PrivacyUpdateResultCallback privacyUpdateResultCallback) {
        debugLog("requestPrivacyUpdate ");
        if (isAppIdNullOrEmpty()) {
            privacyUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(-1, "appId id null or empty", ""), false));
            return -1;
        }
        try {
            getProfileService().requestPrivacyUpdate(privacy.read(), new IPrivacyUpdateResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.profile.ProfileApi.3
                @Override // com.samsung.android.sdk.mobileservice.profile.IPrivacyUpdateResultCallback
                public void onFailure(String str, String str2) {
                    ProfileApi.this.debugLog(AbstractC0541b.m775q("requestPrivacyUpdate onFailure : code=[", str, "], message=[", str2, "] "));
                    if (privacyUpdateResultCallback != null) {
                        privacyUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(str), str2, str), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.profile.IPrivacyUpdateResultCallback
                public void onResult() {
                    ProfileApi.this.debugLog("requestPrivacyUpdate onResult ");
                    PrivacyUpdateResultCallback privacyUpdateResultCallback2 = privacyUpdateResultCallback;
                    if (privacyUpdateResultCallback2 != null) {
                        privacyUpdateResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    public void requestProfileBirthdayTypeUpdate(ProfileBirthdayType profileBirthdayType, final ProfileUpdateResultCallback profileUpdateResultCallback) {
        debugLog("requestProfileBirthdayTypeUpdate");
        if (isAppIdNullOrEmpty()) {
            profileUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(-1, "appId id null or empty", ""), false));
        }
        if (!isSupportedSaAgentVersion(CommonConstants.SupportedApiMinVersion.VERSION_11_0)) {
            profileUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(200), false));
        }
        try {
            getProfileService().requestProfileBirthdayTypeUpdate(convertProfileBirthdayTypeToString(profileBirthdayType), new IProfileUpdateResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.profile.ProfileApi.4
                @Override // com.samsung.android.sdk.mobileservice.profile.IProfileUpdateResultCallback
                public void onFailure(String str, String str2) {
                    ProfileApi.this.debugLog(AbstractC0541b.m775q("requestProfileBirthdayTypeUpdate onFailure : code=[", str, "], message=[", str2, "] "));
                    if (profileUpdateResultCallback != null) {
                        profileUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(str), str2, str), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.profile.IProfileUpdateResultCallback
                public void onResult() {
                    ProfileApi.this.debugLog("requestProfileBirthdayTypeUpdate onResult ");
                    ProfileUpdateResultCallback profileUpdateResultCallback2 = profileUpdateResultCallback;
                    if (profileUpdateResultCallback2 != null) {
                        profileUpdateResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                    }
                }
            });
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
        }
    }

    public int requestProfileUpdate(Profile profile, final ProfileUpdateResultCallback profileUpdateResultCallback) {
        debugLog("requestProfileUpdate ");
        if (isAppIdNullOrEmpty()) {
            profileUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(-1, "appId id null or empty", ""), false));
            return -1;
        }
        try {
            profile.setConnectedProfileVersion(this.mConnectedProfileVersion);
            getProfileService().requestProfileUpdate(profile, new IProfileUpdateResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.profile.ProfileApi.2
                @Override // com.samsung.android.sdk.mobileservice.profile.IProfileUpdateResultCallback
                public void onFailure(String str, String str2) {
                    ProfileApi.this.debugLog(AbstractC0541b.m775q("requestProfileUpdate onFailure : code=[", str, "], message=[", str2, "] "));
                    if (profileUpdateResultCallback != null) {
                        profileUpdateResultCallback.onResult(new BooleanResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(str), str2, str), false));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.profile.IProfileUpdateResultCallback
                public void onResult() {
                    ProfileApi.this.debugLog("requestProfileUpdate onResult ");
                    ProfileUpdateResultCallback profileUpdateResultCallback2 = profileUpdateResultCallback;
                    if (profileUpdateResultCallback2 != null) {
                        profileUpdateResultCallback2.onResult(new BooleanResult(new CommonResultStatus(1), true));
                    }
                }
            });
            return 1;
        } catch (TransactionTooLargeException e) {
            verboseLog("TransactionTooLargeException occurred");
            secureLog(e);
            return -1;
        } catch (RemoteException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (NullPointerException e5) {
            e = e5;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }

    @Deprecated
    public int requestSync(final SyncResultCallback syncResultCallback) {
        debugLog("requestSync ");
        if (isAppIdNullOrEmpty()) {
            syncResultCallback.onResult(new ProfileResult(new CommonResultStatus(-1, "appId is null or empty", ""), null));
            return -1;
        }
        try {
            getProfileService().requestSync(new ISyncResultCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.profile.ProfileApi.1
                @Override // com.samsung.android.sdk.mobileservice.profile.ISyncResultCallback
                public void onFailure(String str, String str2) {
                    ProfileApi.this.debugLog(AbstractC0541b.m775q("requestSync onFailure : code=[", str, "], message=[", str2, "] "));
                    if (syncResultCallback != null) {
                        syncResultCallback.onResult(new ProfileResult(new CommonResultStatus(ErrorCodeConvertor.convertErrorcode(str), str2, str), null));
                    }
                }

                @Override // com.samsung.android.sdk.mobileservice.profile.ISyncResultCallback
                public void onSuccess(Profile profile) {
                    ProfileApi.this.debugLog("requestSync onSuccess ");
                    SyncResultCallback syncResultCallback2 = syncResultCallback;
                    if (syncResultCallback2 != null) {
                        syncResultCallback2.onResult(new ProfileResult(new CommonResultStatus(1), profile));
                    }
                }
            });
            return 1;
        } catch (RemoteException e) {
            e = e;
            secureLog(e);
            return -1;
        } catch (NotConnectedException e2) {
            e = e2;
            secureLog(e);
            return -1;
        } catch (NullPointerException e3) {
            e = e3;
            secureLog(e);
            return -1;
        } catch (OutOfMemoryError unused) {
            verboseLog("OutOfMemoryError occurred");
            return -1;
        }
    }
}
