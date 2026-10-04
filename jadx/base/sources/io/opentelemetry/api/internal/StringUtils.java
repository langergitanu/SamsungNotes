package io.opentelemetry.api.internal;

import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public final class StringUtils {
    private StringUtils() {
    }

    @Contract("null -> true")
    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isPrintableChar(char c) {
        return c >= ' ' && c <= '~';
    }

    public static boolean isPrintableString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isPrintableChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String padLeft(String str, int i) {
        return padStart(str, i, '0');
    }

    private static String padStart(String str, int i, char c) {
        Objects.requireNonNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }
}
