package org.apache.poi.java.awt;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public final class SystemColor extends Color implements Serializable {
    public static final int ACTIVE_CAPTION = 1;
    public static final int ACTIVE_CAPTION_BORDER = 3;
    public static final int ACTIVE_CAPTION_TEXT = 2;
    public static final int CONTROL = 17;
    public static final int CONTROL_DK_SHADOW = 22;
    public static final int CONTROL_HIGHLIGHT = 19;
    public static final int CONTROL_LT_HIGHLIGHT = 20;
    public static final int CONTROL_SHADOW = 21;
    public static final int CONTROL_TEXT = 18;
    public static final int DESKTOP = 0;
    public static final int INACTIVE_CAPTION = 4;
    public static final int INACTIVE_CAPTION_BORDER = 6;
    public static final int INACTIVE_CAPTION_TEXT = 5;
    public static final int INFO = 24;
    public static final int INFO_TEXT = 25;
    public static final int MENU = 10;
    public static final int MENU_TEXT = 11;
    public static final int NUM_COLORS = 26;
    public static final int SCROLLBAR = 23;
    public static final int TEXT = 12;
    public static final int TEXT_HIGHLIGHT = 14;
    public static final int TEXT_HIGHLIGHT_TEXT = 15;
    public static final int TEXT_INACTIVE_TEXT = 16;
    public static final int TEXT_TEXT = 13;
    public static final int WINDOW = 7;
    public static final int WINDOW_BORDER = 8;
    public static final int WINDOW_TEXT = 9;
    public static final SystemColor activeCaption;
    public static final SystemColor activeCaptionBorder;
    public static final SystemColor activeCaptionText;
    public static final SystemColor control;
    public static final SystemColor controlDkShadow;
    public static final SystemColor controlHighlight;
    public static final SystemColor controlLtHighlight;
    public static final SystemColor controlShadow;
    public static final SystemColor controlText;
    public static final SystemColor desktop;
    public static final SystemColor inactiveCaption;
    public static final SystemColor inactiveCaptionBorder;
    public static final SystemColor inactiveCaptionText;
    public static final SystemColor info;
    public static final SystemColor infoText;
    public static final SystemColor menu;
    public static final SystemColor menuText;
    public static final SystemColor scrollbar;
    private static final long serialVersionUID = 4503142729533789064L;
    private static SystemColor[] systemColorObjects;
    private static int[] systemColors = {-16753572, -16777088, -1, -4144960, -8355712, -4144960, -4144960, -1, -16777216, -16777216, -4144960, -16777216, -4144960, -16777216, -16777088, -1, -8355712, -4144960, -16777216, -1, -2039584, -8355712, -16777216, -2039584, -2039808, -16777216};
    public static final SystemColor text;
    public static final SystemColor textHighlight;
    public static final SystemColor textHighlightText;
    public static final SystemColor textInactiveText;
    public static final SystemColor textText;
    public static final SystemColor window;
    public static final SystemColor windowBorder;
    public static final SystemColor windowText;
    private transient int index;

    static {
        SystemColor systemColor = new SystemColor((byte) 0);
        desktop = systemColor;
        SystemColor systemColor2 = new SystemColor((byte) 1);
        activeCaption = systemColor2;
        SystemColor systemColor3 = new SystemColor((byte) 2);
        activeCaptionText = systemColor3;
        SystemColor systemColor4 = new SystemColor((byte) 3);
        activeCaptionBorder = systemColor4;
        SystemColor systemColor5 = new SystemColor((byte) 4);
        inactiveCaption = systemColor5;
        SystemColor systemColor6 = new SystemColor((byte) 5);
        inactiveCaptionText = systemColor6;
        SystemColor systemColor7 = new SystemColor((byte) 6);
        inactiveCaptionBorder = systemColor7;
        SystemColor systemColor8 = new SystemColor((byte) 7);
        window = systemColor8;
        SystemColor systemColor9 = new SystemColor((byte) 8);
        windowBorder = systemColor9;
        SystemColor systemColor10 = new SystemColor((byte) 9);
        windowText = systemColor10;
        SystemColor systemColor11 = new SystemColor((byte) 10);
        menu = systemColor11;
        SystemColor systemColor12 = new SystemColor((byte) 11);
        menuText = systemColor12;
        SystemColor systemColor13 = new SystemColor((byte) 12);
        text = systemColor13;
        SystemColor systemColor14 = new SystemColor((byte) 13);
        textText = systemColor14;
        SystemColor systemColor15 = new SystemColor((byte) 14);
        textHighlight = systemColor15;
        SystemColor systemColor16 = new SystemColor((byte) 15);
        textHighlightText = systemColor16;
        SystemColor systemColor17 = new SystemColor((byte) 16);
        textInactiveText = systemColor17;
        SystemColor systemColor18 = new SystemColor((byte) 17);
        control = systemColor18;
        SystemColor systemColor19 = new SystemColor((byte) 18);
        controlText = systemColor19;
        SystemColor systemColor20 = new SystemColor((byte) 19);
        controlHighlight = systemColor20;
        SystemColor systemColor21 = new SystemColor((byte) 20);
        controlLtHighlight = systemColor21;
        SystemColor systemColor22 = new SystemColor((byte) 21);
        controlShadow = systemColor22;
        SystemColor systemColor23 = new SystemColor((byte) 22);
        controlDkShadow = systemColor23;
        SystemColor systemColor24 = new SystemColor((byte) 23);
        scrollbar = systemColor24;
        SystemColor systemColor25 = new SystemColor((byte) 24);
        info = systemColor25;
        SystemColor systemColor26 = new SystemColor((byte) 25);
        infoText = systemColor26;
        systemColorObjects = new SystemColor[]{systemColor, systemColor2, systemColor3, systemColor4, systemColor5, systemColor6, systemColor7, systemColor8, systemColor9, systemColor10, systemColor11, systemColor12, systemColor13, systemColor14, systemColor15, systemColor16, systemColor17, systemColor18, systemColor19, systemColor20, systemColor21, systemColor22, systemColor23, systemColor24, systemColor25, systemColor26};
        updateSystemColors();
    }

    private SystemColor(byte b) {
        super(systemColors[b]);
        this.index = b;
    }

    private Object readResolve() {
        return systemColorObjects[this.value];
    }

    private static void updateSystemColors() {
        if (!GraphicsEnvironment.isHeadless()) {
            Toolkit.getDefaultToolkit().loadSystemColors(systemColors);
        }
        int i = 0;
        while (true) {
            int[] iArr = systemColors;
            if (i >= iArr.length) {
                return;
            }
            systemColorObjects[i].value = iArr[i];
            i++;
        }
    }

    private Object writeReplace() {
        SystemColor systemColor = new SystemColor((byte) this.index);
        systemColor.value = this.index;
        return systemColor;
    }

    @Override // org.apache.poi.java.awt.Color
    public String toString() {
        StringBuilder sb = new StringBuilder();
        AbstractC2322a.m1635y(SystemColor.class, sb, "[i=");
        return AbstractC2821a.m2223n(sb, "]", this.index);
    }
}
