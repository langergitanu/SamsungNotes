package com.vladsch.flexmark.util.html.p169ui;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Color extends java.awt.Color {
    public static final Color NULL = new Color(new java.awt.Color(0, true));
    public static final Color WHITE = new Color(java.awt.Color.WHITE);
    public static final Color LIGHT_GRAY = new Color(java.awt.Color.LIGHT_GRAY);
    public static final Color GRAY = new Color(java.awt.Color.GRAY);
    public static final Color DARK_GRAY = new Color(java.awt.Color.DARK_GRAY);
    public static final Color BLACK = new Color(java.awt.Color.BLACK);
    public static final Color RED = new Color(java.awt.Color.RED);
    public static final Color PINK = new Color(java.awt.Color.PINK);
    public static final Color ORANGE = new Color(java.awt.Color.ORANGE);
    public static final Color YELLOW = new Color(java.awt.Color.YELLOW);
    public static final Color GREEN = new Color(java.awt.Color.GREEN);
    public static final Color MAGENTA = new Color(java.awt.Color.MAGENTA);
    public static final Color CYAN = new Color(java.awt.Color.CYAN);
    public static final Color BLUE = new Color(java.awt.Color.BLUE);

    public Color(java.awt.Color color) {
        super(color.getRGB());
    }

    /* JADX INFO: renamed from: of */
    public static Color m13378of(java.awt.Color color) {
        return new Color(color);
    }

    public String toString() {
        return AbstractC0541b.m775q("Color { ", HtmlHelpers.toHtmlString(this), " ", HtmlHelpers.toRgbString(this), "}");
    }

    public Color(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: of */
    public static Color m13377of(int i) {
        return new Color(i);
    }

    /* JADX INFO: renamed from: of */
    public static Color m13379of(String str) {
        java.awt.Color namedColor = ColorStyler.getNamedColor(str);
        return namedColor == null ? NULL : new Color(namedColor);
    }
}
