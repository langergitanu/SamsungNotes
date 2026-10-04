package com.samsung.android.support.senl.p148nt.base.composer.text.span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CellSpanStates {
    private boolean boldEnabled = true;
    private boolean boldValue = false;
    private boolean italicEnabled = true;
    private boolean italicValue = false;
    private boolean strikethroughEnabled = true;
    private boolean strikethroughValue = false;
    private boolean underlineEnabled = true;
    private boolean underlineValue = false;
    private boolean foregroundColorEnabled = true;
    private int foregroundColorValue = -16777216;
    private boolean fontSizeEnabled = true;
    private int fontSizeValue = 16;
    private boolean cellBGColorEnabled = true;
    private int cellBGColorValue = 0;
    private boolean alignEnabled = true;
    private int align = Alignment.getDefaultAlign();

    public int getAlignValue() {
        return this.align;
    }

    public int getCellBGColorValue() {
        return this.cellBGColorValue;
    }

    public int getFontSizeValue() {
        return this.fontSizeValue;
    }

    public int getForegroundColorValue() {
        return this.foregroundColorValue;
    }

    public boolean isAlignEnabled() {
        return this.alignEnabled;
    }

    public boolean isAllDisabled() {
        return (this.boldEnabled || this.italicEnabled || this.strikethroughEnabled || this.underlineEnabled || this.foregroundColorEnabled || this.fontSizeEnabled || this.cellBGColorEnabled || this.alignEnabled) ? false : true;
    }

    public boolean isBoldEnabled() {
        return this.boldEnabled;
    }

    public boolean isBoldValue() {
        return this.boldValue;
    }

    public boolean isCellBGColorEnabled() {
        return this.cellBGColorEnabled;
    }

    public boolean isFontSizeEnabled() {
        return this.fontSizeEnabled;
    }

    public boolean isForegroundColorEnabled() {
        return this.foregroundColorEnabled;
    }

    public boolean isItalicEnabled() {
        return this.italicEnabled;
    }

    public boolean isItalicValue() {
        return this.italicValue;
    }

    public boolean isStrikethroughEnabled() {
        return this.strikethroughEnabled;
    }

    public boolean isStrikethroughValue() {
        return this.strikethroughValue;
    }

    public boolean isUnderlineEnabled() {
        return this.underlineEnabled;
    }

    public boolean isUnderlineValue() {
        return this.underlineValue;
    }

    public void setAlignEnabled(boolean z) {
        this.alignEnabled = z;
    }

    public void setAlignValue(int i) {
        this.align = i;
    }

    public void setBoldEnabled(boolean z) {
        this.boldEnabled = z;
    }

    public void setBoldValue(boolean z) {
        this.boldValue = z;
    }

    public void setCellBGColorEnabled(boolean z) {
        this.cellBGColorEnabled = z;
    }

    public void setCellBGColorValue(int i) {
        this.cellBGColorValue = i;
    }

    public void setFontSizeEnabled(boolean z) {
        this.fontSizeEnabled = z;
    }

    public void setFontSizeValue(int i) {
        this.fontSizeValue = i;
    }

    public void setForegroundColorEnabled(boolean z) {
        this.foregroundColorEnabled = z;
    }

    public void setForegroundColorValue(int i) {
        this.foregroundColorValue = i;
    }

    public void setItalicEnabled(boolean z) {
        this.italicEnabled = z;
    }

    public void setItalicValue(boolean z) {
        this.italicValue = z;
    }

    public void setStrikethroughEnabled(boolean z) {
        this.strikethroughEnabled = z;
    }

    public void setStrikethroughValue(boolean z) {
        this.strikethroughValue = z;
    }

    public void setUnderlineEnabled(boolean z) {
        this.underlineEnabled = z;
    }

    public void setUnderlineValue(boolean z) {
        this.underlineValue = z;
    }
}
