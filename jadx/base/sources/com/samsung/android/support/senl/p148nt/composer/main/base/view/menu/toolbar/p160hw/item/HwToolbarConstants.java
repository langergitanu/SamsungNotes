package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarConstants {
    public static final int AI_ASSIST = 1048576;
    public static final int ALIGNMENTCOGNITION = 128;
    public static final int ASSISTANCE = 131072;
    public static final int CLEAN_UP_AND_CONVERT_TEXT = 524288;
    public static final int CUSTOM_TOOLBAR_SETTING = 8388608;
    public static final int DIRECT_WRITE = 8192;
    public static final int EASY_WRITING_PAD = 1024;
    public static final int ERASER = 4;
    public static final int FAVORITE_PEN = 1;
    public static final int HIGHLIGHTER = 2048;
    public static final int LASER_PEN = 262144;
    public static final int LOCK_CANVAS = 4096;
    public static final int MOVE_ONLY_MODE = 2097152;
    public static final int NONE = 0;
    public static final int PEN = 2;
    public static final int QUICK_COLOR_1 = 16385;
    public static final int QUICK_COLOR_2 = 16387;
    public static final int QUICK_COLOR_3 = 16389;
    public static final int QUICK_COLOR_4 = 16393;
    public static final int QUICK_COLOR_5 = 16407;
    public static final int QUICK_SIZE_1 = 32769;
    public static final int QUICK_SIZE_2 = 32771;
    public static final int QUICK_SIZE_3 = 32773;
    public static final int REDO = 512;
    public static final int SELECTION = 8;
    public static final int SHAPERECOGNITION = 64;
    public static final int SMART_PEN = 4194304;
    public static final int[] SMART_PEN_ITEMS = {524288, 131072, 8192};
    public static final int STYLE = 16;
    public static final int TEXTRECOGNITION = 32;
    public static final int TEXT_MODE = 65536;
    public static final int UNDO = 256;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum QUICK_COLOR {
        first(16385),
        second(16387),
        third(16389),
        fourth(16393),
        fifth(16407);

        public int constant;

        QUICK_COLOR(int i) {
            this.constant = i;
        }

        public static int getOrdinal(int i) {
            for (QUICK_COLOR quick_color : values()) {
                if (quick_color.constant == i) {
                    return quick_color.ordinal();
                }
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum QUICK_SIZE {
        first(32769),
        second(32771),
        third(32773);

        public int constant;

        QUICK_SIZE(int i) {
            this.constant = i;
        }

        public static int getOrdinal(int i) {
            for (QUICK_SIZE quick_size : values()) {
                if (quick_size.constant == i) {
                    return quick_size.ordinal();
                }
            }
            return -1;
        }
    }

    public static boolean isSmartPenItems(int i) {
        for (int i2 : SMART_PEN_ITEMS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
