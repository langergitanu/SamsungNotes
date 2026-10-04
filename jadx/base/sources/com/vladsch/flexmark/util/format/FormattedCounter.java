package com.vladsch.flexmark.util.format;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.util.misc.Utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FormattedCounter {
    private int count;
    private final String delimiter;
    private final Boolean isLowercase;
    private final NumberFormat numberFormat;

    public FormattedCounter(NumberFormat numberFormat, Boolean bool, String str) {
        this.numberFormat = numberFormat;
        this.isLowercase = bool;
        this.delimiter = str;
        reset();
    }

    public int getCount() {
        return this.count;
    }

    public String getFormatted(boolean z) {
        String str;
        String format = NumberFormat.getFormat(this.numberFormat, Utils.minLimit(this.count, 1));
        Boolean bool = this.isLowercase;
        if (bool != null) {
            format = bool.booleanValue() ? format.toLowerCase() : format.toUpperCase();
        }
        return (!z || (str = this.delimiter) == null || str.isEmpty()) ? format : AbstractC0541b.m756B(format, this.delimiter);
    }

    public int nextCount() {
        int i = this.count + 1;
        this.count = i;
        return i;
    }

    public void reset() {
        this.count = 0;
    }
}
