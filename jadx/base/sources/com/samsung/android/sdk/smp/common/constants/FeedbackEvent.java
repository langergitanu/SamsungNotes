package com.samsung.android.sdk.smp.common.constants;

import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum FeedbackEvent {
    DELIVER(20),
    DOWNLOADED(40),
    CONSUMED(60),
    CLICKED(80),
    CLICKED_BUTTON_1(81),
    CLICKED_BUTTON_2(82),
    CLICKED_BUTTON_3(83),
    WRONG_META_DATA(-24),
    PUSH_CHANNEL_NOT_CREATED(-26),
    CUSTOM_CONTENT_REQUEST_FAILED(-28),
    DISAGREE(-32),
    UNSUPPORTED_TYPE(-36),
    USER_CHANGE_DATE_AND_TIME_ERROR(-38),
    GET_MARKETING_STATUS_FAIL(-39),
    DOWNLOAD_FAIL(-40),
    POWER_SAVING_MODE(-41),
    CONTENTS_FILE_ERROR(-42),
    LOCALE_NOT_MATCHED(-43),
    DATA_SAVER_MODE(-44),
    REFERRER_VALIDATION_FAIL(-45),
    MARKETING_CANCELED(-55),
    USER_INFO_CHANGED(-56),
    CONSUME_FAIL(-60),
    BUSY(-61),
    DISABLE_NOTI_OPTION(-65),
    DISABLE_POPUP_OPTION(-66),
    INSTALL_CHECK_FAIL(-67),
    NOT_INSTALL_CHECK_FAIL(-68),
    NONE_REACTION(-70),
    SYSTEM_EVENT_RECEIVED(-75),
    IGNORED(-80),
    FC_LIMIT_OVER(LttEngineErrors.ERROR_INPAINTING_RESOLUTION_NOT_SUPPORTED),
    CLIENT_INTERNAL_ERROR(-120),
    CLIENT_DEBUG(998),
    CUSTOM_FEEDBACK(999);

    private final int value;

    FeedbackEvent(int i) {
        this.value = i;
    }

    public static FeedbackEvent fromInt(int i) {
        for (FeedbackEvent feedbackEvent : EnumSet.allOf(FeedbackEvent.class)) {
            if (feedbackEvent.value() == i) {
                return feedbackEvent;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
