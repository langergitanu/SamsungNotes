package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants;

import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultHighlighters {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Marker3 extends AbsSPenExtraInfo {
        public Marker3() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_marker_round;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_marker_round_color;
            this.name = SpenPenManager.SPEN_MARKER3;
            this.size = 40.0f;
            this.sizeLevel = 50;
            this.color = 1933038438;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Marker4 extends AbsSPenExtraInfo {
        public Marker4() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_marker_pen;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_marker_pen_color;
            ArrayList<String> arrayList = new ArrayList<>();
            this.legacyNames = arrayList;
            arrayList.add(SpenPenManager.SPEN_MARKER);
            this.name = SpenPenManager.SPEN_MARKER4;
            this.size = 40.0f;
            this.sizeLevel = 50;
            this.color = 1946143536;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StraightHighlighter extends AbsSPenExtraInfo {
        public StraightHighlighter() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_marker_pen;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_marker_pen_color;
            this.isStraightType = true;
            this.name = SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER;
            this.size = 40.0f;
            this.sizeLevel = 50;
            this.color = 1945129576;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StraightMarker extends AbsSPenExtraInfo {
        public StraightMarker() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_marker_round;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_marker_round_color;
            this.isStraightType = true;
            this.name = SpenPenManager.SPEN_STRAIGHT_MARKER;
            this.size = 40.0f;
            this.sizeLevel = 50;
            this.color = 1936886271;
        }
    }
}
