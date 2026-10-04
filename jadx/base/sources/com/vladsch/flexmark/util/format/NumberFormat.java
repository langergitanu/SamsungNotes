package com.vladsch.flexmark.util.format;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum NumberFormat {
    NONE,
    ARABIC,
    LETTERS,
    ROMAN,
    CUSTOM;

    /* JADX INFO: renamed from: com.vladsch.flexmark.util.format.NumberFormat$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118541 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$util$format$NumberFormat;

        static {
            int[] iArr = new int[NumberFormat.values().length];
            $SwitchMap$com$vladsch$flexmark$util$format$NumberFormat = iArr;
            try {
                iArr[NumberFormat.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$NumberFormat[NumberFormat.ARABIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$NumberFormat[NumberFormat.LETTERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$NumberFormat[NumberFormat.ROMAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$NumberFormat[NumberFormat.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String getFormat(NumberFormat numberFormat, int i) {
        int i2 = C118541.$SwitchMap$com$vladsch$flexmark$util$format$NumberFormat[numberFormat.ordinal()];
        if (i2 == 2) {
            return String.valueOf(i);
        }
        if (i2 == 3) {
            if (i >= 1) {
                return getFormat(i - 1, "abcdefghijklmnopqrstuvwxyz");
            }
            throw new NumberFormatException(AbstractC0000a.m11h(i, "Letter format count must be > 0, actual "));
        }
        if (i2 == 4) {
            return new RomanNumeral(i).toString();
        }
        if (i2 != 5) {
            return "";
        }
        throw new IllegalStateException("CounterFormat.CUSTOM has to use custom conversion, possibly by calling getFormat(int count, CharSequence digitSet)");
    }

    public static String getFormat(int i, CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(10);
        int length = charSequence.length();
        while (true) {
            int i2 = i / length;
            sb.append(charSequence.charAt(i - (i2 * length)));
            if (i2 <= 0) {
                break;
            }
            i = i2;
        }
        int length2 = sb.length();
        StringBuilder sb2 = new StringBuilder(length2);
        while (true) {
            int i4 = length2 - 1;
            if (length2 > 0) {
                sb2.append(sb.charAt(i4));
                length2 = i4;
            } else {
                return sb2.toString();
            }
        }
    }
}
