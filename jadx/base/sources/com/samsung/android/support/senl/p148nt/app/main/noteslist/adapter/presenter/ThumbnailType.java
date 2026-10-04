package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ThumbnailType {
    public static final int GRID_COVER = 8;
    public static final int GRID_LOCK = 7;
    public static final int GRID_NORMAL = 4;
    public static final int GRID_TEMPLATE_LANDSCAPE = 5;
    public static final int GRID_TEMPLATE_PORTRAIT = 6;
    public static final int GRID_TEXT_IMAGE_ONLY = 3;
    public static final int GRID_TEXT_IMAGE_ONLY_OLD = 2;
    public static final int GRID_TEXT_ONLY = 1;
    public static final int LIST_COVER = 19;
    public static final int LIST_LOCK = 18;
    public static final int LIST_NORMAL = 15;
    public static final int LIST_TEXT_IMAGE_ONLY = 17;
    public static final int LIST_TEXT_ONLY = 16;
    public static final int NOT_DEFINED = -1;
    public static final int SIMPLE_COVER = 22;
    public static final int SIMPLE_LOCK = 21;
    public static final int SIMPLE_NORMAL = 20;
    public static final int SMALL_GRID_NORMAL = 12;
    public static final int SMALL_GRID_TEMPLATE_LANDSCAPE = 13;
    public static final int SMALL_GRID_TEMPLATE_PORTRAIT = 14;
    public static final int SMALL_GRID_TEXT_IMAGE_ONLY = 11;
    public static final int SMALL_GRID_TEXT_IMAGE_ONLY_OLD = 10;
    public static final int SMALL_GRID_TEXT_ONLY = 9;

    static boolean isCover(int i) {
        return i == 8 || i == 22 || i == 19;
    }

    static boolean isGridTextImageOnly(int i) {
        return i == 3 || i == 11;
    }

    static boolean isGridTextOnly(int i) {
        return i == 1 || i == 9;
    }

    static boolean isImageRatioUsedMode(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 14 || i == 15 || i == 16 || i == 18 || i == 19;
    }

    static boolean isLayoutMode(int i) {
        return i == 5 || i == 6 || i == 13 || i == 14;
    }

    static boolean isLayoutModeLandScape(int i) {
        return i == 5 || i == 13;
    }

    static boolean isLayoutModePortrait(int i) {
        return i == 6 || i == 14;
    }

    static boolean isListTextOnly(int i) {
        return i == 16;
    }

    static boolean isLock(int i) {
        return i == 7 || i == 21 || i == 18;
    }
}
