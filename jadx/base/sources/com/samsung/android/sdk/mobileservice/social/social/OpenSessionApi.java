package com.samsung.android.sdk.mobileservice.social.social;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.social.social.result.OpenSessionResult;
import com.samsung.android.sdk.mobileservice.social.social.result.PhoneNumberInfo;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OpenSessionApi {
    private static final int ACTION_VALUE = 0;
    private static final int DEFAULT_ITEM_LIMIT_DELETE_FROM_TRASH_BIN_MAX = 500;
    private static final int DEFAULT_ITEM_LIMIT_DELETE_MAX = 100;
    private static final int DEFAULT_ITEM_LIMIT_DOWNLOAD_MAX = 500;
    private static final int DEFAULT_ITEM_LIMIT_MOVE_TO_TRASH_BIN_MAX = 500;
    private static final int DEFAULT_ITEM_LIMIT_RESTORE_FROM_TRASH_BIN_MAX = 500;
    private static final int DEFAULT_ITEM_LIMIT_UPLOAD_MAX = 500;
    private static final int DEFAULT_ITEM_LIMIT_UPLOAD_MAX_UNDER_13 = 100;
    public static final int DENIED_CONTACT_READ_PERMISSION = 2;
    public static final String EDIT_AUTHORITY_READ_ONLY = "R/O";
    public static final String EDIT_AUTHORITY_WRITABLE = "R/W";
    public static final String EXTRA_FEATURE_ID = "featureId";
    private static final int EXTRA_KEY = 1;
    public static final String EXTRA_KEY_EDIT_AUTHORITY = "editAuthority";
    public static final String EXTRA_KEY_JSON_RESULT = "jsonResult";
    public static final String EXTRA_LINK_URL = "linkUrl";
    public static final String EXTRA_TITLE = "title";
    private static final int EXTRA_VALUE = 2;
    public static final int FOUND_NUMBER = 1;
    public static final int INVALID_PARAMETER = 4;
    private static final String INVITATION_LINK_URL_KEY = "invitation_link_url";
    public static final String ITEM_LIMIT_DELETE = "delete";
    private static final int ITEM_LIMIT_DELETE_FROM_TRASH_BIN_INDEX = 5;
    private static final int ITEM_LIMIT_DELETE_INDEX = 2;
    public static final String ITEM_LIMIT_DOWNLOAD = "download";
    private static final int ITEM_LIMIT_DOWNLOAD_INDEX = 1;
    private static final int ITEM_LIMIT_MOVE_TO_TRASH_BIN_INDEX = 3;
    private static final int ITEM_LIMIT_RESTORE_FROM_TRASH_BIN_INDEX = 4;
    public static final String ITEM_LIMIT_UPLOAD = "upload";
    private static final int ITEM_LIMIT_UPLOAD_INDEX = 0;
    private static final String METHOD_GET_CONTACT_INFO = "getContactInfo";
    private static final String METHOD_GET_MY_PHONE_NUMBER_INFO = "getMyPhoneNumberInfo";
    private static final String METHOD_GET_SHARE_VIA_INVITATION_LINK_INTENT = "getShareViaInvitationLinkIntent";
    private static final String MOBILE_SERVICE_PROVIDER_URI = "com.samsung.android.mobileservice.social.common.provider.OpenSessionProvider";
    public static final int NOT_FOUND_NUMBER = 0;
    public static final int NOT_SUPPORTED_API = 3;
    private static final String PATH_ACCOUNT_BASED_CONTACT_POLICY = "accountBasedContactPolicy";
    private static final String PATH_GDPR = "gdpr";
    private static final String PATH_GROUP_INVITATION_LINK = "groupInvitationLink";
    private static final String PATH_HAS_NUMBER_IN_CONTACT = "hasNumberInContact";
    private static final String PATH_INTRODUCTION = "introduction";
    private static final String PATH_PERSONAL_INFORMATION_COLLECTION_AGREEMENT = "personalInformationCollectionAgreement";
    private static final String PATH_SERVICE_NUMBER_REGISTRATION = "serviceNumberRegistration";
    private static final String PATH_SHARE_ITEM_LIMIT = "shareItemLimit";
    private static final String PATH_TERMS_AND_CONDITION = "termsAndCondition";
    public static final int RESULT_CODE_INVITE_FROM_SHARE_LINK = 55;

    /* JADX INFO: renamed from: com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C74091 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$mobileservice$social$social$OpenSessionApi$LegalNoticeIntentType */
        static final /* synthetic */ int[] f4881xbab7ce8e;

        static {
            int[] iArr = new int[LegalNoticeIntentType.values().length];
            f4881xbab7ce8e = iArr;
            try {
                iArr[LegalNoticeIntentType.ACCOUNT_BASED_CONTACT_POLICY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4881xbab7ce8e[LegalNoticeIntentType.GDPR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4881xbab7ce8e[LegalNoticeIntentType.INTRODUCTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4881xbab7ce8e[LegalNoticeIntentType.PERSONAL_INFORMATION_COLLECTION_AGREEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4881xbab7ce8e[LegalNoticeIntentType.TERMS_AND_CONDITION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LegalNoticeIntentType {
        ACCOUNT_BASED_CONTACT_POLICY,
        GDPR,
        INTRODUCTION,
        PERSONAL_INFORMATION_COLLECTION_AGREEMENT,
        TERMS_AND_CONDITION
    }

    private Bundle callGetContactInfo(Context context, String str) {
        try {
            return context.getContentResolver().call(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).build(), METHOD_GET_CONTACT_INFO, str, (Bundle) null);
        } catch (Exception e) {
            secureLog(e);
            return null;
        }
    }

    private void debugLog(String str) {
        SdkLog.m5782d("OpenSessionApi", str);
    }

    private Bundle getGroupDetailDataFromAgent(Context context, GroupDetailRequest groupDetailRequest) {
        return context.getContentResolver().call(new Uri.Builder().encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).build(), "getGroupDetailIntent", (String) null, groupDetailRequest.toBundle());
    }

    private Intent getIntent(Context context, String str, String... strArr) {
        Intent intent;
        Exception exc;
        Throwable th;
        ContentResolver contentResolver = context.getContentResolver();
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendPath(str);
        for (String str2 : strArr) {
            builderAppendPath.appendPath(str2);
        }
        Uri uriBuild = builderAppendPath.build();
        Intent intent2 = null;
        try {
            Cursor cursorQuery = contentResolver.query(uriBuild, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        intent = new Intent(cursorQuery.getString(0));
                        while (cursorQuery.moveToNext()) {
                            try {
                                String string = cursorQuery.getString(1);
                                String string2 = cursorQuery.getString(2);
                                debugLog("intent key: " + string + ", value: " + string2);
                                intent.putExtra(string, string2);
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    try {
                                        try {
                                            cursorQuery.close();
                                            throw th3;
                                        } catch (Throwable th4) {
                                            th.addSuppressed(th4);
                                            throw th3;
                                        }
                                    } catch (Exception e) {
                                        exc = e;
                                        secureLog(exc);
                                        return intent;
                                    }
                                }
                            }
                        }
                        intent2 = intent;
                    }
                } catch (Throwable th5) {
                    intent = null;
                    th = th5;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return intent2;
        } catch (Exception e2) {
            intent = intent2;
            exc = e2;
        }
    }

    private Bundle getResult(Context context, Uri uri, String str, String str2, Bundle bundle) {
        try {
            return context.getContentResolver().call(uri, str, str2, bundle);
        } catch (Exception e) {
            secureLog(e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ShareLimit getShareLimitFromAgent(Context context) {
        OpenSessionApi openSessionApi;
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Throwable th;
        int i11;
        int i12;
        int i13;
        int i14;
        try {
            Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath(PATH_SHARE_ITEM_LIMIT).build(), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        int i15 = !cursorQuery.isNull(0) ? cursorQuery.getInt(0) : 500;
                        try {
                            i12 = !cursorQuery.isNull(1) ? cursorQuery.getInt(1) : 500;
                            try {
                                i = cursorQuery.isNull(2) ? 100 : cursorQuery.getInt(2);
                                i13 = !cursorQuery.isNull(3) ? cursorQuery.getInt(3) : 500;
                                try {
                                    i14 = !cursorQuery.isNull(4) ? cursorQuery.getInt(4) : 500;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i4 = i13;
                                    i5 = i;
                                    i2 = i12;
                                    i6 = 500;
                                }
                                try {
                                    i = i15;
                                    i = cursorQuery.isNull(5) ? 500 : cursorQuery.getInt(5);
                                } catch (Throwable th3) {
                                    th = th3;
                                    i5 = i;
                                    i6 = i14;
                                    i4 = i13;
                                    i2 = i12;
                                    i11 = i15;
                                    th = th;
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        try {
                                            try {
                                                cursorQuery.close();
                                                throw th4;
                                            } catch (Exception e) {
                                                e = e;
                                                openSessionApi = this;
                                                i = 500;
                                                i = i11;
                                                openSessionApi.secureLog(e);
                                                i7 = i2;
                                                i8 = i4;
                                                i9 = i6;
                                                i10 = i5;
                                                return new ShareLimit(i, i7, i10, i8, i9, i);
                                            }
                                        } catch (Throwable th5) {
                                            th.addSuppressed(th5);
                                            throw th4;
                                        }
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i2 = i12;
                                i4 = 500;
                                i5 = i;
                                i11 = i15;
                                i6 = 500;
                            }
                        } catch (Throwable th7) {
                            i11 = i15;
                            i2 = 500;
                            i4 = 500;
                            i5 = 100;
                            th = th7;
                            i6 = i4;
                            throw th;
                        }
                    } else {
                        i = 500;
                        i12 = 500;
                        i13 = 500;
                        i14 = 500;
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e2) {
                            e = e2;
                            openSessionApi = this;
                            i5 = i;
                            i6 = i14;
                            i4 = i13;
                            i2 = i12;
                            openSessionApi.secureLog(e);
                            i7 = i2;
                            i8 = i4;
                            i9 = i6;
                            i10 = i5;
                        }
                    }
                    i7 = i12;
                    i8 = i13;
                    i9 = i14;
                    i10 = i;
                } catch (Throwable th8) {
                    th = th8;
                    i11 = 500;
                    i2 = 500;
                    i4 = 500;
                    i5 = 100;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openSessionApi = this;
            i = 500;
            i2 = 500;
            i4 = 500;
            i5 = 100;
            i6 = 500;
        }
        return new ShareLimit(i, i7, i10, i8, i9, i);
    }

    private Bundle getSocialPickerDataFromAgent(Context context, SocialPickerRequest socialPickerRequest) {
        return context.getContentResolver().call(new Uri.Builder().encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).build(), "getSocialPickerIntent", (String) null, socialPickerRequest.toBundle());
    }

    private boolean isSupportedSemsAgentVersion(Context context, int i) {
        return SeMobileService.getAgentVersion(context) >= i;
    }

    private boolean isSupportedSemsAgentVersionBetween(Context context, int i, int i2) {
        int agentVersion = SeMobileService.getAgentVersion(context);
        return agentVersion >= i && agentVersion < i2;
    }

    private ShareLimit makeDefaultItemLimit() {
        return new ShareLimit(100, 500, 100, 500, 500, 500);
    }

    private void secureLog(Exception exc) {
        SdkLog.m5785s(exc);
    }

    public ContactInfo getContactInfo(Context context, String str) {
        int iHasNumberInContact;
        debugLog(METHOD_GET_CONTACT_INFO);
        long j = -1;
        String string = "";
        if (TextUtils.isEmpty(str)) {
            secureLog(new Exception(AbstractC0541b.m772n("Not supported getContactInfo api : ", str)));
            iHasNumberInContact = 4;
        } else {
            if (isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
                Bundle bundleCallGetContactInfo = callGetContactInfo(context, str);
                if (bundleCallGetContactInfo != null) {
                    int i = (bundleCallGetContactInfo.getInt("value", 0) == 1 || Integer.parseInt(bundleCallGetContactInfo.getString("value", "0")) == 1) ? 1 : 0;
                    j = bundleCallGetContactInfo.getLong("contact_id", -1L);
                    string = bundleCallGetContactInfo.getString(IDToken.PHONE_NUMBER, "");
                    iHasNumberInContact = i;
                }
            } else {
                secureLog(new Exception("Not supported version"));
            }
            iHasNumberInContact = 3;
        }
        String str2 = string;
        long j2 = j;
        if (iHasNumberInContact == 3) {
            debugLog("getContactInfo. not supported version. use hasNumberInContact instead");
            iHasNumberInContact = hasNumberInContact(context, str);
        }
        int i2 = iHasNumberInContact;
        debugLog(AbstractC0000a.m11h(i2, "result : "));
        return new ContactInfo(i2, j2, str2, str);
    }

    public Intent getIntentForGroupDetail(Context context, GroupDetailRequest groupDetailRequest) {
        debugLog("getIntentForGroupDetail");
        Intent intent = new Intent("com.samsung.android.mobileservice.action.ACTION_EXTERNAL_GROUP_DETAIL");
        if (!isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_0_5_5)) {
            intent.putExtras(groupDetailRequest.toBundle());
            return intent;
        }
        Bundle groupDetailDataFromAgent = getGroupDetailDataFromAgent(context, groupDetailRequest);
        if (groupDetailDataFromAgent != null) {
            intent.putExtras(groupDetailDataFromAgent);
            return intent;
        }
        debugLog("com.samsung.android.mobileservice.social.common.provider.OpenSessionProvider getGroupDetailIntent method call is null");
        intent.putExtras(groupDetailRequest.toBundle());
        return intent;
    }

    public Intent getIntentForGroupInvitationLink(Context context, String str, boolean z) {
        debugLog(AbstractC0541b.m772n("getIntentForGroupInvitationLink:", str));
        if (!isSupportedSemsAgentVersionBetween(context, CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            secureLog(new Exception("Not supported version"));
            return null;
        }
        Intent intent = getIntent(context, PATH_GROUP_INVITATION_LINK, str, z ? "1" : "0");
        intent.putExtra("invitation_link_url", str);
        return intent;
    }

    public Intent getIntentForLegalNotice(Context context, LegalNoticeIntentType legalNoticeIntentType) {
        debugLog("getIntentForLegalNotice type = " + legalNoticeIntentType);
        String str = null;
        if (!isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_12_1)) {
            secureLog(new Exception("Not supported version"));
            return null;
        }
        int i = C74091.f4881xbab7ce8e[legalNoticeIntentType.ordinal()];
        if (i == 1) {
            str = PATH_ACCOUNT_BASED_CONTACT_POLICY;
        } else if (i == 2) {
            str = PATH_GDPR;
        } else if (i == 3) {
            str = PATH_INTRODUCTION;
        } else if (i == 4) {
            str = PATH_PERSONAL_INFORMATION_COLLECTION_AGREEMENT;
        } else if (i == 5) {
            str = PATH_TERMS_AND_CONDITION;
        }
        return getIntent(context, str, new String[0]);
    }

    public Intent getIntentForServiceNumberRegistration(Context context) {
        debugLog("getIntentForServiceNumberRegistration ");
        if (isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_12_1)) {
            return getIntent(context, "serviceNumberRegistration", new String[0]);
        }
        secureLog(new Exception("Not supported version"));
        return null;
    }

    public Intent getIntentForShareViaInvitationLink(Context context, int i, String str, String str2) {
        debugLog(AbstractC0541b.m772n("getIntentForShareViaInvitationLink:", str2));
        if (!isSupportedSemsAgentVersionBetween(context, CommonConstants.SupportedApiMinVersion.VERSION_10_8_9, CommonConstants.SupportedApiMinVersion.VERSION_11_0) && !isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_1_10)) {
            secureLog(new Exception("Not supported version"));
            return null;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            secureLog(new Exception("groupName and linkUrl should be not empty"));
            return null;
        }
        Uri uriBuild = new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).build();
        Bundle bundle = new Bundle();
        bundle.putInt("featureId", i);
        bundle.putString("title", str);
        bundle.putString(EXTRA_LINK_URL, str2);
        Intent intent = getIntent(context, uriBuild, METHOD_GET_SHARE_VIA_INVITATION_LINK_INTENT, null, bundle);
        if (intent == null) {
            secureLog(new Exception("getIntentForShareViaInvitationLink result is null"));
        }
        return intent;
    }

    public Intent getIntentForSocialPicker(Context context, SocialPickerRequest socialPickerRequest) {
        debugLog("getIntentForSocialPicker");
        Intent intent = new Intent("com.samsung.android.mobileservice.social.intent.action.SOCIAL_CONTACT_PICKER");
        if (!isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_0_5_5)) {
            intent.putExtras(socialPickerRequest.toBundle());
            return intent;
        }
        Bundle socialPickerDataFromAgent = getSocialPickerDataFromAgent(context, socialPickerRequest);
        if (socialPickerDataFromAgent != null) {
            intent.putExtras(socialPickerDataFromAgent);
            return intent;
        }
        debugLog("com.samsung.android.mobileservice.social.common.provider.OpenSessionProvider getSocialPickerIntent method call is null");
        intent.putExtras(socialPickerRequest.toBundle());
        return intent;
    }

    public OpenSessionResult<PhoneNumberInfo> getMyPhoneNumberInfo(Context context) {
        int i;
        debugLog(METHOD_GET_MY_PHONE_NUMBER_INFO);
        PhoneNumberInfo phoneNumberInfo = null;
        if (isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_5_40)) {
            Bundle result = getResult(context, new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).build(), METHOD_GET_MY_PHONE_NUMBER_INFO, null, null);
            if (result != null) {
                i = 0;
                if (result.getInt("value", 0) != 1 && Integer.parseInt(result.getString("value", "0")) != 1) {
                    i = 101;
                }
                if (i == 0) {
                    phoneNumberInfo = new PhoneNumberInfo(result.getString("hash"), result.getString(IDToken.PHONE_NUMBER), PhoneNumberInfo.mapToType(result.getString("type")));
                    debugLog("hash: " + phoneNumberInfo.getHash() + ", type: " + phoneNumberInfo.getType());
                }
            } else {
                i = 105;
            }
        } else {
            i = 103;
        }
        debugLog(AbstractC0000a.m11h(i, "result : "));
        return new OpenSessionResult<>(i, phoneNumberInfo);
    }

    public ShareLimit getShareLimit(Context context) {
        if (isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_0_0_15)) {
            return getShareLimitFromAgent(context);
        }
        secureLog(new Exception("Not supported version"));
        return makeDefaultItemLimit();
    }

    @Deprecated
    public int hasNumberInContact(Context context, String str) {
        debugLog(PATH_HAS_NUMBER_IN_CONTACT);
        if (TextUtils.isEmpty(str)) {
            secureLog(new Exception(AbstractC0541b.m772n("Not supported hasNumberInContact api : ", str)));
            return 3;
        }
        if (!isSupportedSemsAgentVersion(context, CommonConstants.SupportedApiMinVersion.VERSION_13_0_4)) {
            secureLog(new Exception("Not supported version"));
            return 3;
        }
        int iHasNumberInContact = hasNumberInContact(context, new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath(PATH_HAS_NUMBER_IN_CONTACT).appendEncodedPath(str).build());
        debugLog(AbstractC0000a.m11h(iHasNumberInContact, "result : "));
        return iHasNumberInContact;
    }

    private Intent getIntent(Context context, Uri uri, String str, String str2, Bundle bundle) {
        Bundle result = getResult(context, uri, str, str2, bundle);
        if (result != null) {
            return (Intent) result.getParcelable("value");
        }
        return null;
    }

    private int hasNumberInContact(Context context, Uri uri) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        int i = cursorQuery.getInt(0);
                        cursorQuery.close();
                        return i;
                    }
                } finally {
                }
            }
            if (cursorQuery == null) {
                return 3;
            }
            cursorQuery.close();
            return 3;
        } catch (Exception e) {
            secureLog(e);
            return 3;
        }
    }
}
