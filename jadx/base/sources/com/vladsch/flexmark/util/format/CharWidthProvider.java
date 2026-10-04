package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.misc.CharPredicate;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface CharWidthProvider {
    public static final CharWidthProvider NULL = new CharWidthProvider() { // from class: com.vladsch.flexmark.util.format.CharWidthProvider.1
        @Override // com.vladsch.flexmark.util.format.CharWidthProvider
        public int getCharWidth(char c) {
            return 1;
        }

        @Override // com.vladsch.flexmark.util.format.CharWidthProvider
        public int getSpaceWidth() {
            return 1;
        }
    };

    int getCharWidth(char c);

    int getSpaceWidth();

    default int getStringWidth(@NotNull CharSequence charSequence) {
        return getStringWidth(charSequence, CharPredicate.NONE);
    }

    default int getStringWidth(@NotNull CharSequence charSequence, @NotNull CharPredicate charPredicate) {
        int length = charSequence.length();
        int charWidth = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (!charPredicate.test(cCharAt)) {
                charWidth = getCharWidth(cCharAt) + charWidth;
            }
        }
        return charWidth;
    }
}
