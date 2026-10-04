package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants;

import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultPens {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BrushPen extends AbsSPenExtraInfo {
        public BrushPen() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_calligraphy_brush;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_calligraphy_brush_color;
            this.sizeLevelTablet = 15;
            this.sizeLevel = 30;
            this.name = SpenPenManager.SPEN_BRUSH_PEN;
            this.size = 20.0f;
            this.color = -9642609;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class FountainPen extends AbsSPenExtraInfo {
        public FountainPen() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_fountain_pen;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_fountain_pen_color;
            this.sizeLevelTablet = 15;
            this.sizeLevel = 30;
            this.name = SpenPenManager.SPEN_FOUNTAIN_PEN;
            this.size = 40.0f;
            this.color = -15448065;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InkPen2 extends AbsSPenExtraInfo {
        public InkPen2() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_pen;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_pen_color;
            ArrayList<String> arrayList = new ArrayList<>();
            this.legacyNames = arrayList;
            arrayList.add(SpenPenManager.SPEN_INK_PEN);
            this.sizeLevelTablet = 15;
            this.sizeLevel = 30;
            this.name = SpenPenManager.SPEN_INK_PEN2;
            this.size = 10.0f;
            this.color = -13520;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ObliquePen extends AbsSPenExtraInfo {
        public ObliquePen() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_calligraphy_pen;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_calligraphy_pen_color;
            this.sizeLevelTablet = 15;
            this.sizeLevel = 30;
            this.name = SpenPenManager.SPEN_OBLIQUE_PEN;
            this.size = 16.0f;
            this.color = -14342875;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Pencil2 extends AbsSPenExtraInfo {
        public Pencil2() {
            this.penDrawableId = C9086R.drawable.comp_hw_toolbar_ic_pencil;
            this.penDrawableColorId = C9086R.drawable.comp_hw_toolbar_ic_pencil_color;
            this.sizeLevelTablet = 30;
            this.sizeLevel = 50;
            this.name = SpenPenManager.SPEN_PENCIL2;
            this.size = 10.0f;
            this.color = -1510001098;
        }
    }
}
