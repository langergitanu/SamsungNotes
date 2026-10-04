package com.vladsch.flexmark.util.sequence.mappers;

import com.vladsch.flexmark.util.misc.CharPredicate;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SpaceMapper {
    public static final CharMapper toNonBreakSpace = new ToNonBreakSpace();
    public static final CharMapper fromNonBreakSpace = new FromNonBreakSpace();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FromNonBreakSpace implements CharMapper {
        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            if (c == 160) {
                return ' ';
            }
            return c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FromPredicate implements CharMapper {

        @NotNull
        final CharPredicate myPredicate;

        public FromPredicate(@NotNull CharPredicate charPredicate) {
            this.myPredicate = charPredicate;
        }

        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            if (this.myPredicate.test(c)) {
                return ' ';
            }
            return c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ToNonBreakSpace implements CharMapper {
        @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
        public char map(char c) {
            if (c == ' ') {
                return (char) 160;
            }
            return c;
        }
    }

    public static boolean areEquivalent(char c, char c2) {
        if (c == c2) {
            return true;
        }
        if (c == ' ' && c2 == 160) {
            return true;
        }
        return c2 == ' ' && c == 160;
    }

    @NotNull
    public static CharMapper toSpaces(@NotNull CharPredicate charPredicate) {
        return new FromPredicate(charPredicate);
    }
}
