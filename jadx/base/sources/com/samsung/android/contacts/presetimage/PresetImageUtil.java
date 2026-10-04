package com.samsung.android.contacts.presetimage;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PresetImageUtil {
    static int[] CONTACT_LIST_PRESET_BACKGROUND = {C7111R.drawable.contact_list_preset_01, C7111R.drawable.contact_list_preset_02, C7111R.drawable.contact_list_preset_03, C7111R.drawable.contact_list_preset_04, C7111R.drawable.contact_list_preset_05, C7111R.drawable.contact_list_preset_06, C7111R.drawable.contact_list_preset_07, C7111R.drawable.contact_list_preset_08, C7111R.drawable.contact_list_preset_09, C7111R.drawable.contact_list_preset_10, C7111R.drawable.contact_list_preset_11, C7111R.drawable.contact_list_preset_12, C7111R.drawable.contact_list_preset_13, C7111R.drawable.contact_list_preset_14, C7111R.drawable.contact_list_preset_15, C7111R.drawable.contact_list_preset_16, C7111R.drawable.contact_list_preset_17, C7111R.drawable.contact_list_preset_18, C7111R.drawable.contact_list_preset_19, C7111R.drawable.contact_list_preset_20, C7111R.drawable.contact_list_preset_21, C7111R.drawable.contact_list_preset_22, C7111R.drawable.contact_list_preset_23, C7111R.drawable.contact_list_preset_24, C7111R.drawable.contact_list_preset_25, C7111R.drawable.contact_list_preset_26, C7111R.drawable.contact_list_preset_27, C7111R.drawable.contact_list_preset_28, C7111R.drawable.contact_list_preset_29, C7111R.drawable.contact_list_preset_30, C7111R.drawable.contact_list_preset_31, C7111R.drawable.contact_list_preset_32, C7111R.drawable.contact_list_preset_33, C7111R.drawable.contact_list_preset_34, C7111R.drawable.contact_list_preset_35};
    static int[] CONTACT_LIST_PRESET_CIRCLE_BACKGROUND = {C7111R.drawable.contact_list_preset_crop_01, C7111R.drawable.contact_list_preset_crop_02, C7111R.drawable.contact_list_preset_crop_03, C7111R.drawable.contact_list_preset_crop_04, C7111R.drawable.contact_list_preset_crop_05, C7111R.drawable.contact_list_preset_crop_06, C7111R.drawable.contact_list_preset_crop_07, C7111R.drawable.contact_list_preset_crop_08, C7111R.drawable.contact_list_preset_crop_09, C7111R.drawable.contact_list_preset_crop_10, C7111R.drawable.contact_list_preset_crop_11, C7111R.drawable.contact_list_preset_crop_12, C7111R.drawable.contact_list_preset_crop_13, C7111R.drawable.contact_list_preset_crop_14, C7111R.drawable.contact_list_preset_crop_15, C7111R.drawable.contact_list_preset_crop_16, C7111R.drawable.contact_list_preset_crop_17, C7111R.drawable.contact_list_preset_crop_18, C7111R.drawable.contact_list_preset_crop_19, C7111R.drawable.contact_list_preset_crop_20, C7111R.drawable.contact_list_preset_crop_21, C7111R.drawable.contact_list_preset_crop_22, C7111R.drawable.contact_list_preset_crop_23, C7111R.drawable.contact_list_preset_crop_24, C7111R.drawable.contact_list_preset_crop_25, C7111R.drawable.contact_list_preset_crop_26, C7111R.drawable.contact_list_preset_crop_27, C7111R.drawable.contact_list_preset_crop_28, C7111R.drawable.contact_list_preset_crop_29, C7111R.drawable.contact_list_preset_crop_30, C7111R.drawable.contact_list_preset_crop_31, C7111R.drawable.contact_list_preset_crop_32, C7111R.drawable.contact_list_preset_crop_33, C7111R.drawable.contact_list_preset_crop_34, C7111R.drawable.contact_list_preset_crop_35};

    public static int getCirclePresetImage(String str) {
        return CONTACT_LIST_PRESET_CIRCLE_BACKGROUND[getPresetImageIndex(str)];
    }

    public static int getPresetImage(String str) {
        return CONTACT_LIST_PRESET_BACKGROUND[getPresetImageIndex(str)];
    }

    private static int getPresetImageIndex(long j) {
        if (j < 0) {
            return 0;
        }
        return (int) (j % ((long) CONTACT_LIST_PRESET_BACKGROUND.length));
    }

    private static int getPresetImageIndex(String str) {
        int iAbs;
        if (str != null && (iAbs = Math.abs(str.hashCode())) >= 0) {
            return iAbs % CONTACT_LIST_PRESET_BACKGROUND.length;
        }
        return 0;
    }

    public static int getCirclePresetImage(long j) {
        return CONTACT_LIST_PRESET_CIRCLE_BACKGROUND[getPresetImageIndex(j)];
    }

    public static int getPresetImage(long j) {
        return CONTACT_LIST_PRESET_BACKGROUND[getPresetImageIndex(j)];
    }

    public static int getCirclePresetImage(long j, String str) {
        if (j > 0) {
            return getCirclePresetImage(j);
        }
        return getCirclePresetImage(str);
    }

    public static int getPresetImage(long j, String str) {
        if (j > 0) {
            return getPresetImage(j);
        }
        return getPresetImage(str);
    }
}
