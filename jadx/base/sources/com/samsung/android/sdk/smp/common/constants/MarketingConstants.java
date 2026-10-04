package com.samsung.android.sdk.smp.common.constants;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MarketingConstants {
    public static final String BUTTON = "button";
    public static final String BUTTON_TITLE = "title";
    public static final String CCTIME = "cctime";
    public static final String CHANNEL = "chan";
    public static final long CHECK_NOTIFICATION_CLEARED_DELAY_MILLIS;
    public static final String CLEAR_TIME = "clearTime";
    public static final int CLICK_EVENT_FOR_S_OS_VERSION = 31;
    public static final int COMPONENT_ACTIVITY = 1;
    public static final String CONTENTS = "contents";
    public static final String CONTENTS_BASE_URL = "bURL";
    public static final String CONTENTS_FILENAME = "fname";
    public static final String CONTENTS_TYPE_1 = "type1";
    public static final String CONTENTS_TYPE_2 = "type2";
    public static final String CONTENTS_TYPE_3 = "type3";
    public static final String CUSTOM_CONTENT = "customContent";
    public static final int CUSTOM_CONTENT_MAX_LENGTH = 100;
    public static final int DATA_TYPE_BOOLEAN = 1;
    public static final int DATA_TYPE_DOUBLE = 9;
    public static final int DATA_TYPE_FLOAT = 10;
    public static final int DATA_TYPE_INT = 2;
    public static final int DATA_TYPE_INT_ARRAY = 3;
    public static final int DATA_TYPE_INT_ARRAYLIST = 4;
    public static final int DATA_TYPE_LONG = 5;
    public static final int DATA_TYPE_SHORT = 11;
    public static final int DATA_TYPE_STRING = 6;
    public static final int DATA_TYPE_STRING_ARRAY = 7;
    public static final int DATA_TYPE_STRING_ARRAYLIST = 8;
    public static final int DEFAULT_CCTIME = 0;
    public static final int DEFAULT_CLEAR_TIME = 0;
    public static final int DEFAULT_FEEDBACK_DISPERSION_MAX = 10;
    public static final int DEFAULT_FEEDBACK_DISPERSION_MIN = 1;
    public static final int DEFAULT_OFF = -1;
    public static final int DEFAULT_RANDOM_DISPLAY_RANGE = 60;
    public static final int DEFAULT_SCREEN_ON_TIME = 0;
    public static final int DISPLAY_MAX_RETRY = 5;
    public static final long DISPLAY_RETRY_DELAY_MILLIS;
    public static final String DISPLAY_TIME = "cardDisplayTime";
    public static final String DISPLAY_TIME_MIN = "cardDisplayTimeMin";
    public static final String DO_NOT_DISTURB_TIME = "doNotDisturbTime";
    public static final String DO_NOT_DISTURB_TIME_MIN = "doNotDisturbTimeMin";
    public static final String FEEDBACK_DISPERSION = "feedbackDispersion";
    public static final String FILTER = "filter";
    public static final String FILTER_COUNT = "count";
    public static final String FILTER_INSTALL = "install";
    public static final String FILTER_NOT_INSTALL = "notInstall";
    public static final String FILTER_PKG = "pkg";
    public static final String FREQUENCY_CAPPING = "freq";
    public static final int GET_MARKETING_STATUS_MAX_RETRY = 3;
    public static final String[] IMAGE_FILE_EXTENSIONS;
    public static final long INITIAL_CHECK_NOTIFICATION_CLEARED_DELAY_MILLIS;
    public static final String INTENT_ACTION = "action";
    public static final String INTENT_CLASS = "cls";
    public static final String INTENT_COMPONENT = "comp";
    public static final String INTENT_DATA = "data";
    public static final String INTENT_EXTRA = "extra";
    public static final String LINK_ACTION = "action";
    public static final String LINK_PKG = "pkg";
    public static final String LINK_REDIRECTION_URL = "redirectionUrl";
    public static final String LINK_REFERRER = "referrer";
    public static final String LINK_REFERRER_DATA = "data";
    public static final String LINK_REFERRER_KEY = "key";
    public static final String LINK_REFERRER_REQUIRE_VALIDATION = "requireValidation";
    public static final String LINK_REFERRER_TYPE = "type";
    public static final String LINK_TYPE = "type";
    public static final String LINK_TYPE_APP = "app";
    public static final String LINK_TYPE_IGNORE = "ignore";
    public static final String LINK_TYPE_INTENT = "intent";
    public static final String LINK_TYPE_URL = "url";
    public static final String LINK_URL = "url";
    public static final String MARKETING_EXTRA = "extra";
    public static final String MARKETING_MSG = "marketing";
    public static final long MARKETING_SAVE_TIME_MILLIS;
    public static final String MARKETING_TYPE = "marketingType";
    public static final String MARKETING_TYPE_NOTI = "1";
    public static final String MARKETING_TYPE_POPUP = "2";
    public static final int MAX_BUTTON_COUNT = 3;
    public static final int MAX_LINK_COUNT = 5;
    public static final String MID = "mid";
    public static final int MID_MAX_LENGTH = 32;
    public static final int MSGTYPE_MAX_LENGTH = 20;
    public static final String PASSIVE_MSG = "passive";
    public static final String P_LINK = "pLink";
    public static final String RANDOM_RANGE = "random";
    public static final String REFERRER_DELIMITER_U003D = "=";
    public static final String REFERRER_DELIMITER_U007C = "|";
    public static final String REFERRER_KEY_APP_VERSION = "appVersion";
    public static final String REFERRER_KEY_MID = "mid";
    public static final String REFERRER_STR = "referrerStr";
    public static final String REFERRER_TYPE_APP = "appReferrer";
    public static final String REFERRER_TYPE_APP_FILTER = "appFilter";
    public static final String REFERRER_TYPE_BASIC = "basicReferrer";
    public static final long REQUEST_RESOURCE_DELAY_MILLIS;
    public static final int REQUEST_RESOURCE_MAX_RETRY = 5;
    public static final int RESPONSE_CANCEL_STATUS_CODE = 400;
    public static final int RESPONSE_DISAGREEMENT_STATUS_CODE = 301;
    public static final int RESPONSE_DISPLAY_STATUS_CODE = 200;
    public static final String RESPONSE_KEY_SERVER_TIMESTAMP = "sts";
    public static final String RESPONSE_KEY_STATUS = "status";
    public static final String RESPONSE_KEY_TIP = "tip";
    public static final int RESPONSE_NO_MATCH_UID_STATUS_CODE = 300;
    public static final String SCREEN_ON_TIME = "screenOnTime";
    public static final String STYLE = "st";
    public static final String TEST_MSG = "test";
    public static final String TIME_BASE = "timeBase";
    public static final String TIME_BASE_LOCAL = "local";
    public static final String TIME_BASE_UTC0 = "utc0";
    public static final String TTL = "ttl";
    public static final String TYPE = "type";
    public static final String TYPE_1_LOCALE = "lang1";
    public static final String TYPE_2_LOCALE = "lang2";
    public static final String TYPE_3_LOCALE = "lang3";
    public static final String UNDELETABLE = "undeletable";
    public static final long UPLOAD_EXTERNAL_FEEDBACK_FIRST_DELAY_MILLIS;
    public static final long UPLOAD_EXTERNAL_FEEDBACK_SECOND_DELAY_MILLIS;
    public static final String USERDATA = "userdata";
    public static final int USERDATA_MAX_LENGTH = 10240;
    public static final int WINDOW_OVERLAY_OS_VERSION = 29;
    public static final List<Integer> DEFAULT_TIME_MIN = Arrays.asList(0, 0);
    public static final List<Integer> DEFAULT_DO_NOT_DISTURB_TIME = Arrays.asList(21, 8);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomContentConst {
        public static final String NUDGE = "/nudge";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DisplayConst {
        public static final String CHANNEL_TYPE = "channel_type";
        public static final String CLICK_LINK_URIS = "link_uris";
        public static final String DISPLAYID = "displayid";
        public static final String KEY_EXTRA_CHANNEL_ID = "extra_channel_id";
        public static final String KEY_EXTRA_CLEAR = "extra_clear";
        public static final String KEY_EXTRA_CLEAR_TIME = "extra_clear_time";
        public static final String KEY_EXTRA_IS_FIRST_DISPLAY = "extra_is_first_display";
        public static final String KEY_EXTRA_POPUP_DATA = "extra_popup";
        public static final String MID = "mid";
        public static final String NOTIF_BANNER_PATH = "banner";
        public static final String NOTIF_BIG_PICTURE_PATH = "big_picture";
        public static final String NOTIF_BUTTON = "noti_button";
        public static final String NOTIF_CLICK_LINK = "click_link";
        public static final String NOTIF_CONTENT_TEXT = "content_text";
        public static final String NOTIF_CONTENT_TITLE = "content_title";
        public static final String NOTIF_E_FLIPPER_ANIMATION = "e_flip_anim";
        public static final String NOTIF_E_FLIPPER_PATH = "e_flip_path";
        public static final String NOTIF_E_FLIPPER_PERIOD = "e_flip_period";
        public static final String NOTIF_E_TYPE = "e_type";
        public static final String NOTIF_F_FLIPPER_ANIMATION = "f_flip_anim";
        public static final String NOTIF_F_FLIPPER_PATH = "f_flip_path";
        public static final String NOTIF_F_FLIPPER_PERIOD = "f_flip_period";
        public static final String NOTIF_F_TYPE = "f_type";
        public static final String NOTIF_ICON = "noti_big_icon";
        public static final String NOTIF_LARGE_ICON_PATH = "large_icon";
        public static final String NOTIF_SMALL_ICON_PATH = "small_icon";
        public static final String NOTIF_SUB_CONTENT_TEXT = "sub_content_text";
        public static final String NOTIF_TICKER = "ticker";
        public static final String POP_BODY_TEXT = "body_text";
        public static final String POP_BOTTOM_VISIBLE = "bottom_visible";
        public static final String POP_BUTTON1_LINK = "btn1_link";
        public static final String POP_BUTTON1_TEXT = "btn1_text";
        public static final String POP_BUTTON2_LINK = "btn2_link";
        public static final String POP_BUTTON2_TEXT = "btn2_text";
        public static final String POP_BUTTON_ALIGN = "btn_align";
        public static final String POP_CLOSE_BUTTON_VISIBLE = "close_visible";
        public static final String POP_COLOR_BG = "color_bg";
        public static final String POP_COLOR_BODY_TEXT = "color_body";
        public static final String POP_COLOR_BOTTOM = "color_bottom";
        public static final String POP_COLOR_BUTTON_TEXT = "color_btn_text";
        public static final String POP_COLOR_LINE = "color_line";
        public static final String POP_IS_DISTURB_ON = "disturb";
        public static final String POP_MAIN_IMAGE = "img_main";
        public static final String POP_TEMPLATE_TYPE = "template_type";
        public static final String POP_WEB_URL = "web";
        public static final String P_LINK = "p_link";
        public static final String UNDELETABLE = "undeletable";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NotificationConst {
        public static final String BANNER = "banner";
        public static final int E_TYPE_BIGIMAGE = 2;
        public static final int E_TYPE_BIGTEXT = 4;
        public static final int E_TYPE_NONE = 1;
        public static final int E_TYPE_VIEWFLIPPER = 5;
        public static final String FLIPPING_ANIMATION = "fa";
        public static final String FLIPPING_PERIOD = "fp";
        public static final int F_TYPE_BANNER = 2;
        public static final int F_TYPE_BASIC = 1;
        public static final int F_TYPE_VIEWFLIPPER = 3;
        public static final String ICON = "icon";
        public static final int MAX_FLIP_COUNT = 10;
        public static final String STYLE_EXPANDED = "e";
        public static final String STYLE_FOLDED = "f";
        public static final String TICKER = "ticker";
        public static final String CONTENT_TITLE = "contentTitle";
        public static final String CONTENT_TEXT = "contentText";
        public static final String SUB_CONTENT_TEXT = "subContentText";
        public static final String[][] FOLDED_TXT_RES = {new String[]{CONTENT_TITLE, CONTENT_TEXT, SUB_CONTENT_TEXT}, new String[0], new String[0]};
        public static final String[][] EXPANDED_TXT_RES = {new String[0], new String[]{CONTENT_TITLE, CONTENT_TEXT}, new String[]{CONTENT_TITLE, CONTENT_TEXT}, new String[]{CONTENT_TITLE, CONTENT_TEXT}, new String[0]};
        public static final String SMALLICON = "smallIcon";
        public static final String LARGEICON = "largeIcon";
        public static final String FLIPPER_FOLDED = "flip_f";
        public static final String[][] FOLDED_IMG_RES = {new String[]{SMALLICON, LARGEICON}, new String[]{"banner"}, new String[]{FLIPPER_FOLDED}};
        public static final String BIGPICTURE = "bigPicture";
        public static final String FLIPPER_EXPANDED = "flip_e";
        public static final String[][] EXPANDED_IMG_RES = {new String[0], new String[]{SMALLICON, LARGEICON, BIGPICTURE}, new String[]{SMALLICON, LARGEICON, BIGPICTURE}, new String[]{SMALLICON, LARGEICON}, new String[]{FLIPPER_EXPANDED}};

        public static boolean isSupportType(int i, int i2) {
            if (i < 1 || i > 3) {
                return false;
            }
            return i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PopupConst {
        public static final String BODY_TEXT = "body";
        public static final String BUTTON1 = "btn1";
        public static final String BUTTON2 = "btn2";
        public static final String BUTTON_TEXT = "text";
        public static final String COLOR_BACKGROUND = "bg";
        public static final String COLOR_BODY_TEXT = "text";
        public static final String COLOR_BOTTOM = "bottom";
        public static final String COLOR_BUTTON_TEXT = "btntext";
        public static final String COLOR_LINE = "line";
        public static final int DEFAULT_COLOR_BACKGROUND = -328966;
        public static final int DEFAULT_COLOR_BOTTOM = -657931;
        public static final int DEFAULT_COLOR_BUTTON_TEXT = -570425344;
        public static final int DEFAULT_COLOR_LINE = -1644826;
        public static final int DEFAULT_COLOR_TEXT = -570425344;
        public static final String DISTURB = "disturb";
        public static final int MAX_BUTTON_TEXT_LENGTH = 10;
        public static final String POPUP_CONTENTS = "pop";
        public static final String STYLE_BOTTOM_VISIBLE = "bottom";
        public static final String STYLE_BUTTON_ALIGN = "btnalign";
        public static final String STYLE_CLOSE_BUTTON_VISIBLE = "close";
        public static final String STYLE_COLOR = "color";
        public static final String STYLE_TYPE = "pop";
        public static final int TYPE_IMAGE_ONLY = 2;
        public static final int TYPE_IMAGE_TEXT = 3;
        public static final int TYPE_TEXT_ONLY = 1;
        public static final int TYPE_WEB_VIEW = 4;
        public static final String WEB = "web";
        public static final String[][] TXT_RES = {new String[]{"body"}, new String[0], new String[]{"body"}, new String[]{"web"}};
        public static final String MAIN_IMG = "popupmain";
        public static final String[][] IMG_RES = {new String[0], new String[]{MAIN_IMG}, new String[]{MAIN_IMG}, new String[0]};

        public static boolean isSupportType(int i) {
            return i >= 1 && i <= 4;
        }
    }

    static {
        long j = Constants.DAYMILLIS;
        MARKETING_SAVE_TIME_MILLIS = 7 * j;
        long j2 = Constants.MINMILLIS;
        REQUEST_RESOURCE_DELAY_MILLIS = j2 * 30;
        DISPLAY_RETRY_DELAY_MILLIS = j2 * 30;
        long j3 = Constants.HOURMILLIS;
        UPLOAD_EXTERNAL_FEEDBACK_FIRST_DELAY_MILLIS = j3;
        UPLOAD_EXTERNAL_FEEDBACK_SECOND_DELAY_MILLIS = j;
        INITIAL_CHECK_NOTIFICATION_CLEARED_DELAY_MILLIS = j3 * 6;
        CHECK_NOTIFICATION_CLEARED_DELAY_MILLIS = j;
        IMAGE_FILE_EXTENSIONS = new String[]{"jpg", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.THUMBNAIL_PNG_EXTENSION, "bmp", "JPG", "PNG", "BMP"};
    }
}
