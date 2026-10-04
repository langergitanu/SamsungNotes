package com.samsung.android.support.senl.p148nt.model.base.document;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DocumentPageRatio {
    public static final PageRatioType PAGE_RATIO = PageRatioType.A4_PORTRAIT;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PageRatioType {
        A4_PORTRAIT(1.4142857f),
        A4_LANDSCAPE(0.7070707f),
        LONG(2.0f);

        private final float mPageRatio;

        PageRatioType(float f) {
            this.mPageRatio = f;
        }

        public boolean equal(float f) {
            return equalFloatValues(f, this.mPageRatio, 0.1f);
        }

        public boolean equalFloatValues(float f, float f4, float f5) {
            return Math.abs(f - f4) < f5;
        }

        public int getHeight(int i) {
            return (int) (i * this.mPageRatio);
        }

        public float getPageRatio() {
            return this.mPageRatio;
        }
    }

    public static PageRatioType convertFromSettings(int i) {
        return i != 1 ? i != 2 ? PageRatioType.A4_PORTRAIT : PageRatioType.A4_LANDSCAPE : PageRatioType.LONG;
    }

    public static boolean equalPageRatio(int i, int i2, int i4, int i5) {
        PageRatioType pageRatioType = PageRatioType.A4_PORTRAIT;
        return getPageRatio(i, i2, pageRatioType.getPageRatio()) == getPageRatio(i4, i5, pageRatioType.getPageRatio());
    }

    public static float getPageRatio(int i, int i2, float f) {
        if (i == 0) {
            int i4 = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
            if (i4 == 1) {
                return PageRatioType.LONG.getPageRatio();
            }
            if (i4 == 2) {
                return PageRatioType.A4_LANDSCAPE.getPageRatio();
            }
            PageRatioType.A4_PORTRAIT.getPageRatio();
        }
        float f4 = i2 / i;
        PageRatioType pageRatioType = PageRatioType.LONG;
        if (pageRatioType.equal(f4)) {
            return pageRatioType.getPageRatio();
        }
        PageRatioType pageRatioType2 = PageRatioType.A4_PORTRAIT;
        if (pageRatioType2.equal(f4)) {
            return pageRatioType2.getPageRatio();
        }
        PageRatioType pageRatioType3 = PageRatioType.A4_LANDSCAPE;
        return pageRatioType3.equal(f4) ? pageRatioType3.getPageRatio() : f;
    }

    public static PageRatioType getPageRatioTypeFromPageSizeType(int i) {
        return convertFromSettings(i);
    }

    public static PageRatioType getPageRatioTypeFromRatio(float f) {
        PageRatioType pageRatioType = PageRatioType.LONG;
        if (pageRatioType.getPageRatio() == f) {
            return pageRatioType;
        }
        PageRatioType pageRatioType2 = PageRatioType.A4_PORTRAIT;
        if (pageRatioType2.getPageRatio() != f) {
            PageRatioType pageRatioType3 = PageRatioType.A4_LANDSCAPE;
            if (pageRatioType3.getPageRatio() == f) {
                return pageRatioType3;
            }
        }
        return pageRatioType2;
    }

    public static PageRatioType getPageRatioTypeFromSettings() {
        return getPageRatioTypeFromPageSizeType(getPageSizeType());
    }

    public static int getPageSizeType() {
        if (SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1) == 0) {
            return 0;
        }
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
    }
}
