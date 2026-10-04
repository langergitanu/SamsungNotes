package com.samsung.android.sdk.pen.text.inputmethod;

import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputEmojiUtil;", "", "<init>", "()V", "EMOJI_PATTERN", "Ljava/util/regex/Pattern;", "emojiStartCodePoint", "", "emojiEndCodePoint", "alphanumSupStartCodePoint", "alphanumSupEndCodePoint", "hasEmojiString", "", "chars", "", "startEmojiString", "start", "endEmojiString", "end", "getPattern", "unicodeToUTF16", "", "unicode", "removeBrokenEmojiChar", "string", "isEnclosedAlphanumSuppplement", "code", "isEmoji", "isHighSurrogate", "c", "isLowSurrogate", "getUnicode", "charcode", "charcode2", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenInputEmojiUtil {

    @Nullable
    private static Pattern EMOJI_PATTERN = null;

    @NotNull
    public static final SpenInputEmojiUtil INSTANCE = new SpenInputEmojiUtil();
    private static final int alphanumSupEndCodePoint = 127487;
    private static final int alphanumSupStartCodePoint = 127232;
    private static final int emojiEndCodePoint = 128767;
    private static final int emojiStartCodePoint = 127744;

    private SpenInputEmojiUtil() {
    }

    @JvmStatic
    @Nullable
    public static final Pattern getPattern() {
        StringBuilder sb = new StringBuilder(SpenInputEmojiList.getEmoticonMap().length * 2);
        sb.append(PropertyUtils.MAPPED_DELIM);
        for (SpenInputEmojiInfo spenInputEmojiInfo : SpenInputEmojiList.getEmoticonMap()) {
            sb.append(Pattern.quote(INSTANCE.unicodeToUTF16(spenInputEmojiInfo.getEmoticonCode())));
            sb.append('|');
        }
        sb.replace(sb.length() - 1, sb.length(), ")");
        return Pattern.compile(sb.toString());
    }

    private final int getUnicode(int charcode, int charcode2) {
        return (isHighSurrogate((char) charcode) && isLowSurrogate((char) charcode2)) ? (char) (((charcode << 10) + charcode2) - 56613888) : charcode;
    }

    @JvmStatic
    public static final boolean hasEmojiString(@Nullable CharSequence chars) {
        try {
            if (EMOJI_PATTERN == null) {
                EMOJI_PATTERN = getPattern();
            }
            Pattern pattern = EMOJI_PATTERN;
            if (pattern != null) {
                Intrinsics.checkNotNull(pattern);
                return pattern.matcher(chars).find();
            }
        } catch (IllegalStateException unused) {
        }
        return false;
    }

    @JvmStatic
    public static final boolean isHighSurrogate(int c) {
        return (c & 64512) == 55296;
    }

    private final boolean isLowSurrogate(int c) {
        return (c & 64512) == 56320;
    }

    public final int endEmojiString(@Nullable CharSequence chars, int end) {
        try {
            if (EMOJI_PATTERN == null) {
                EMOJI_PATTERN = getPattern();
            }
            Pattern pattern = EMOJI_PATTERN;
            if (pattern != null) {
                Intrinsics.checkNotNull(pattern);
                Matcher matcher = pattern.matcher(chars);
                if (matcher.find(end)) {
                    return matcher.end();
                }
            }
        } catch (IllegalStateException unused) {
        }
        return -1;
    }

    public final boolean isEmoji(int code) {
        return emojiStartCodePoint <= code && code < 128768;
    }

    public final boolean isEnclosedAlphanumSuppplement(int code) {
        return alphanumSupStartCodePoint <= code && code < 127488;
    }

    @NotNull
    public final String removeBrokenEmojiChar(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        int length = string.length() - 1;
        if (Character.isHighSurrogate(string.charAt(length))) {
            string = string.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (!Character.isLowSurrogate(string.charAt(0))) {
            return string;
        }
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final int startEmojiString(@Nullable CharSequence chars, int start) {
        try {
            if (EMOJI_PATTERN == null) {
                EMOJI_PATTERN = getPattern();
            }
            Pattern pattern = EMOJI_PATTERN;
            if (pattern != null) {
                Intrinsics.checkNotNull(pattern);
                Matcher matcher = pattern.matcher(chars);
                if (matcher.find(start)) {
                    return matcher.start();
                }
            }
        } catch (IllegalStateException unused) {
        }
        return -1;
    }

    @NotNull
    public final String unicodeToUTF16(@NotNull String unicode) {
        Intrinsics.checkNotNullParameter(unicode, "unicode");
        Integer numDecode = Integer.decode(unicode);
        if (unicode.length() - 2 <= 4) {
            char cIntValue = (char) numDecode.intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(cIntValue);
            return sb.toString();
        }
        Intrinsics.checkNotNull(numDecode);
        int iIntValue = ((numDecode.intValue() & 2031616) >> 16) - 1;
        String strM772n = AbstractC0541b.m772n("0x", Integer.toHexString((numDecode.intValue() & 1023) | Utf8.LOG_SURROGATE_HEADER));
        String strM772n2 = AbstractC0541b.m772n("0x", Integer.toHexString((iIntValue << 6) | ((numDecode.intValue() & 64512) >> 10) | 55296));
        Integer numDecode2 = Integer.decode(strM772n);
        char cIntValue2 = (char) Integer.decode(strM772n2).intValue();
        char cIntValue3 = (char) numDecode2.intValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cIntValue2);
        sb2.append(cIntValue3);
        return sb2.toString();
    }

    public final int endEmojiString(@Nullable CharSequence chars) {
        try {
            if (EMOJI_PATTERN == null) {
                EMOJI_PATTERN = getPattern();
            }
            Pattern pattern = EMOJI_PATTERN;
            if (pattern != null) {
                Intrinsics.checkNotNull(pattern);
                Matcher matcher = pattern.matcher(chars);
                if (matcher.find()) {
                    return matcher.end();
                }
            }
        } catch (IllegalStateException unused) {
        }
        return -1;
    }

    public final int startEmojiString(@Nullable CharSequence chars) {
        try {
            if (EMOJI_PATTERN == null) {
                EMOJI_PATTERN = getPattern();
            }
            Pattern pattern = EMOJI_PATTERN;
            if (pattern != null) {
                Intrinsics.checkNotNull(pattern);
                Matcher matcher = pattern.matcher(chars);
                if (matcher.find()) {
                    return matcher.start();
                }
            }
        } catch (IllegalStateException unused) {
        }
        return -1;
    }
}
