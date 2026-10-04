package kotlin.text;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.apache.xmlbeans.XmlOptions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\r\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0002\u001a\r\u0010\u000f\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\u001a\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u001c\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\"\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010#\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020%H\u0000\u001a\u0010\u0010(\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u001f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, m13886d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "isDefined", "", "isLetter", "isLetterOrDigit", "isDigit", "isIdentifierIgnorable", "isISOControl", "isJavaIdentifierPart", "isJavaIdentifierStart", "isWhitespace", "isUpperCase", "isLowerCase", "toUpperCase", "uppercaseChar", "uppercase", "", "locale", "Ljava/util/Locale;", "toLowerCase", "lowercaseChar", "lowercase", "isTitleCase", "toTitleCase", "titlecaseChar", "titlecase", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "isHighSurrogate", "isLowSurrogate", "digitOf", "", "char", "radix", "checkRadix", "kotlin-stdlib"}, m13887k = 5, m13888mv = {2, 1, 0}, m13890xi = 49, m13891xs = "kotlin/text/CharsKt")
public class CharsKt__CharJVMKt {
    @PublishedApi
    public static int checkRadix(int i) {
        if (2 <= i && i < 37) {
            return i;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "radix ", " was not in valid range ");
        sbM778t.append(new IntRange(2, 36));
        throw new IllegalArgumentException(sbM778t.toString());
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    @NotNull
    public static final CharCategory getCategory(char c) {
        return CharCategory.INSTANCE.valueOf(Character.getType(c));
    }

    @NotNull
    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.INSTANCE.valueOf(Character.getDirectionality(c));
    }

    @InlineOnly
    private static final boolean isDefined(char c) {
        return Character.isDefined(c);
    }

    @InlineOnly
    private static final boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    @InlineOnly
    private static final boolean isHighSurrogate(char c) {
        return Character.isHighSurrogate(c);
    }

    @InlineOnly
    private static final boolean isISOControl(char c) {
        return Character.isISOControl(c);
    }

    @InlineOnly
    private static final boolean isIdentifierIgnorable(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierPart(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierStart(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    @InlineOnly
    private static final boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    @InlineOnly
    private static final boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    @InlineOnly
    private static final boolean isLowSurrogate(char c) {
        return Character.isLowSurrogate(c);
    }

    @InlineOnly
    private static final boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    @InlineOnly
    private static final boolean isTitleCase(char c) {
        return Character.isTitleCase(c);
    }

    @InlineOnly
    private static final boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(char c) {
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char lowercaseChar(char c) {
        return Character.toLowerCase(c);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static String titlecase(char c, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strUppercase = uppercase(c, locale);
        if (strUppercase.length() <= 1) {
            String strValueOf = String.valueOf(c);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(strUppercase, upperCase)) {
                return String.valueOf(Character.toTitleCase(c));
            }
        } else if (c != 329) {
            char cCharAt = strUppercase.charAt(0);
            Intrinsics.checkNotNull(strUppercase, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strUppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return cCharAt + lowerCase;
        }
        return strUppercase;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char titlecaseChar(char c) {
        return Character.toTitleCase(c);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = XmlOptions.GENERATE_JAVA_15)
    @InlineOnly
    private static final char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = XmlOptions.GENERATE_JAVA_15)
    @InlineOnly
    private static final char toTitleCase(char c) {
        return Character.toTitleCase(c);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = XmlOptions.GENERATE_JAVA_15)
    @InlineOnly
    private static final char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(char c) {
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char uppercaseChar(char c) {
        return Character.toUpperCase(c);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static String lowercase(char c, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String uppercase(char c, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
