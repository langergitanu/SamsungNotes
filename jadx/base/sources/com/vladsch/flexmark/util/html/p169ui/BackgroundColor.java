package com.vladsch.flexmark.util.html.p169ui;

import java.awt.Color;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BackgroundColor extends Color {
    public static final BackgroundColor NULL = new BackgroundColor(new Color(0, true));
    public static final BackgroundColor WHITE = new BackgroundColor(Color.WHITE);
    public static final BackgroundColor LIGHT_GRAY = new BackgroundColor(Color.LIGHT_GRAY);
    public static final BackgroundColor GRAY = new BackgroundColor(Color.GRAY);
    public static final BackgroundColor DARK_GRAY = new BackgroundColor(Color.DARK_GRAY);
    public static final BackgroundColor BLACK = new BackgroundColor(Color.BLACK);
    public static final BackgroundColor RED = new BackgroundColor(Color.RED);
    public static final BackgroundColor PINK = new BackgroundColor(Color.PINK);
    public static final BackgroundColor ORANGE = new BackgroundColor(Color.ORANGE);
    public static final BackgroundColor YELLOW = new BackgroundColor(Color.YELLOW);
    public static final BackgroundColor GREEN = new BackgroundColor(Color.GREEN);
    public static final BackgroundColor MAGENTA = new BackgroundColor(Color.MAGENTA);
    public static final BackgroundColor CYAN = new BackgroundColor(Color.CYAN);
    public static final BackgroundColor BLUE = new BackgroundColor(Color.BLUE);

    public BackgroundColor(Color color) {
        super(color.getRGB());
    }

    /* JADX INFO: renamed from: of */
    public static BackgroundColor m13375of(Color color) {
        return new BackgroundColor(color);
    }

    public BackgroundColor(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: of */
    public static BackgroundColor m13374of(int i) {
        return new BackgroundColor(i);
    }

    /* JADX INFO: renamed from: of */
    public static BackgroundColor m13376of(String str) {
        Color namedColor = ColorStyler.getNamedColor(str);
        return namedColor == null ? NULL : new BackgroundColor(namedColor);
    }
}
