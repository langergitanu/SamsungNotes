package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants;

import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultHighlighters;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultPens;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Default {
    public static final boolean ASSISTANCE_ALIGN_LETTERS = true;
    public static final boolean ASSISTANCE_FIX_SHAPE_LETTERS = true;
    public static final boolean ASSISTANCE_GUIDELINE = true;
    public static final int CHANGE_STYLE_COLOR = -13396225;
    public static final boolean CHANGE_STYLE_IS_BLANK_SHAPE = true;
    public static final int CHANGE_STYLE_SELECTION_TYPE = 0;
    public static final int CHANGE_STYLE_SIZE_LEVEL = 30;
    public static final int COLOR_PICKER_VIEW_MODE = 2;
    public static final int LASER_PEN_COLOR = -51658;
    public static final int LASER_PEN_COLOR_UI_INFO = 2097408;
    public static final boolean LASER_PEN_FILLINSIDE = true;
    public static final int LASER_PEN_RAINBOW_TYPE = 1;
    public static final int LASER_PEN_TYPE = 1;
    public static final int QUICK_COLOR_USE_COUNT = 3;
    public static final int QUICK_SIZE_USE_COUNT = 1;
    public static final float REMOVER_SIZE = 1.0f;
    public static final int REMOVER_TARGET = 0;
    public static final int REMOVER_TYPE = 1;
    public static final int SELECTION_CHANGE_STYLE_COLOR = -14342875;
    public static final boolean SELECTION_INCLUDE_PARTIALLY_SELECTED = true;
    public static final int SELECTION_TYPE = 0;
    public static final boolean STRAIGHTEN_ALIGN_LETTERS = true;
    public static final boolean STRAIGHTEN_EVENLY_SPACE_WORDS = true;
    public static final boolean STRAIGHTEN_FIX_SHAPE_LETTERS = true;
    public static final boolean STRAIGHTEN_OPTION = true;
    public static final Pen DEFAULT_PEN = Pen.FountainPen;
    public static final Highlighter DEFAULT_HIGHLIGHTER = Highlighter.Marker4;
    public static final int[] QUICK_COLOR = {15695980, 10146505, 1193540, 10797311, 10973917};
    public static final int[] QUICK_SIZE = {30, 50, 70};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Highlighter implements IDefault<AbsSPenExtraInfo> {
        Marker4(new DefaultHighlighters.Marker4()),
        StraightHighlighter(new DefaultHighlighters.StraightHighlighter()),
        Marker3(new DefaultHighlighters.Marker3()),
        StraightMarker(new DefaultHighlighters.StraightMarker());

        private final AbsSPenExtraInfo defaultInfo;

        Highlighter(AbsSPenExtraInfo absSPenExtraInfo) {
            this.defaultInfo = absSPenExtraInfo;
        }

        public static Highlighter find(String str) {
            for (Highlighter highlighter : values()) {
                if (highlighter.getDefault().anyMatch(str)) {
                    return highlighter;
                }
            }
            return null;
        }

        public static String[] getNames() {
            String[] strArr = new String[values().length];
            for (Highlighter highlighter : values()) {
                strArr[highlighter.ordinal()] = highlighter.getDefault().name;
            }
            return strArr;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.constants.Default.IDefault
        public AbsSPenExtraInfo getDefault() {
            return this.defaultInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDefault<T> {
        T getDefault();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Pen implements IDefault<AbsSPenExtraInfo> {
        FountainPen(new DefaultPens.FountainPen()),
        ObliquePen(new DefaultPens.ObliquePen()),
        InkPen2(new DefaultPens.InkPen2()),
        Pencil2(new DefaultPens.Pencil2()),
        BrushPen(new DefaultPens.BrushPen());

        private final AbsSPenExtraInfo defaultInfo;

        Pen(AbsSPenExtraInfo absSPenExtraInfo) {
            this.defaultInfo = absSPenExtraInfo;
        }

        public static Pen find(String str) {
            for (Pen pen : values()) {
                if (pen.getDefault().anyMatch(str)) {
                    return pen;
                }
            }
            return null;
        }

        public static String[] getNames() {
            String[] strArr = new String[values().length];
            for (Pen pen : values()) {
                strArr[pen.ordinal()] = pen.getDefault().name;
            }
            return strArr;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.constants.Default.IDefault
        public AbsSPenExtraInfo getDefault() {
            if (DeviceUtils.isTabletModel()) {
                this.defaultInfo.useSizeLevelTablet();
            }
            return this.defaultInfo;
        }
    }

    public static AbsSPenExtraInfo findSPenInfo(String str) {
        Pen penFind = Pen.find(str);
        if (penFind != null) {
            return penFind.getDefault();
        }
        Highlighter highlighterFind = Highlighter.find(str);
        if (highlighterFind != null) {
            return highlighterFind.getDefault();
        }
        return null;
    }

    public static boolean isStraightType(String str) {
        Highlighter highlighterFind = Highlighter.find(str);
        if (highlighterFind != null) {
            return highlighterFind.getDefault().isStraightType;
        }
        return false;
    }
}
