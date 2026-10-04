package com.samsung.android.sdk.mobileservice.profile.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.profile.ProfileApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ProfileBirthdayTypeResult implements Result {
    private ProfileApi.ProfileBirthdayType mProfileBirthdayType;
    private CommonResultStatus mStatus;

    public ProfileBirthdayTypeResult(CommonResultStatus commonResultStatus, String str) {
        this.mStatus = commonResultStatus;
        this.mProfileBirthdayType = convertStringToProfileBirthdayType(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ProfileApi.ProfileBirthdayType convertStringToProfileBirthdayType(String str) {
        byte b;
        switch (str.hashCode()) {
            case 48:
                b = !str.equals("0") ? (byte) -1 : (byte) 0;
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                    break;
                }
                break;
        }
        return b != 0 ? b != 1 ? b != 2 ? ProfileApi.ProfileBirthdayType.INVALID : ProfileApi.ProfileBirthdayType.LEAP_BIRTHDAY : ProfileApi.ProfileBirthdayType.LUNAR_BIRTHDAY : ProfileApi.ProfileBirthdayType.SOLAR_BIRTHDAY;
    }

    public ProfileApi.ProfileBirthdayType getResult() {
        return this.mProfileBirthdayType;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
