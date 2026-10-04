package com.samsung.android.sdk.smp;

import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpConstants {
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String EVENT = "event";
    public static final String INITIAL_DISPLAY = "initial_display";
    public static final String IS_SUCCESS = "is_success";
    public static final String MARKETING_CONTENTS = "contents";
    public static final String MARKETING_DISPLAY = "display";
    public static final String MARKETING_ID = "mid";
    public static final String MARKETING_LINK = "link";
    public static final String MARKETING_TYPE = "type";
    public static final String MARKETING_TYPE_NOTI = "noti";
    public static final String MARKETING_TYPE_POPUP = "popup";
    public static final String NOTIFICATION_TITLE = "noti_title";
    public static final String OPTIN = "optin";
    public static final String OPTIN_TIME = "optin_time";
    public static final String PUSH_REGISTRATION_RESULT_ACTION = "com.samsung.android.sdk.smp.pushRegistrationResult";
    public static final String PUSH_TOKEN = "push_token";
    public static final String PUSH_TOKEN_CHANGED_ACTION = "com.samsung.android.sdk.smp.pushTokenChanged";
    public static final String PUSH_TYPE = "push_type";
    public static final String PUSH_TYPE_FCM = "fcm";
    public static final String PUSH_TYPE_SPP = "spp";
    public static final String REFERRER_KEY = "smpReferrer";
    public static final String SMP_INITIALIZE_RESULT_ACTION = "com.samsung.android.sdk.smp.smpInitializeResult";
    public static final String SMP_INIT_RESULT_ACTION = "com.samsung.android.sdk.smp.smpInitResult";
    public static final String SMP_MARKETING_EVENT_ACTION = "com.samsung.android.sdk.smp.smpEvent";
    public static final String SMP_PK = "smpPK";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum OptInPolicy {
        INTEGRATED_BASED,
        DEVICE_BASED;

        public static OptInPolicy fromString(String str) {
            for (OptInPolicy optInPolicy : EnumSet.allOf(OptInPolicy.class)) {
                if (optInPolicy.name().equals(str)) {
                    return optInPolicy;
                }
            }
            return null;
        }

        public static String getName(OptInPolicy optInPolicy) {
            return optInPolicy == null ? "" : optInPolicy.name();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PushModeForHkAndMo {
        FCM_ONLY_MODE,
        SPP_ONLY_MODE,
        FCM_PRIMARY_MODE;

        public static PushModeForHkAndMo fromString(String str) {
            for (PushModeForHkAndMo pushModeForHkAndMo : EnumSet.allOf(PushModeForHkAndMo.class)) {
                if (pushModeForHkAndMo.name().equals(str)) {
                    return pushModeForHkAndMo;
                }
            }
            return null;
        }

        public static String getName(PushModeForHkAndMo pushModeForHkAndMo) {
            return pushModeForHkAndMo == null ? "" : pushModeForHkAndMo.name();
        }
    }
}
