package org.apache.commons.lang3;

import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9478c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LocaleUtils {
    private static final char DASH = '-';
    private static final char UNDERSCORE = '_';
    private static final String UNDETERMINED = "und";
    private static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry = new ConcurrentHashMap();
    private static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SyncAvoid {
        private static final List<Locale> AVAILABLE_LOCALE_ULIST;
        private static final Set<Locale> AVAILABLE_LOCALE_USET;

        static {
            List<Locale> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList((Locale[]) ArraySorter.sort(Locale.getAvailableLocales(), Comparator.comparing(new C13791b(13)))));
            AVAILABLE_LOCALE_ULIST = listUnmodifiableList;
            AVAILABLE_LOCALE_USET = Collections.unmodifiableSet(new LinkedHashSet(listUnmodifiableList));
        }

        private SyncAvoid() {
        }
    }

    @Deprecated
    public LocaleUtils() {
    }

    public static List<Locale> availableLocaleList() {
        return SyncAvoid.AVAILABLE_LOCALE_ULIST;
    }

    public static Set<Locale> availableLocaleSet() {
        return SyncAvoid.AVAILABLE_LOCALE_USET;
    }

    public static List<Locale> countriesByLanguage(String str) {
        return str == null ? Collections.EMPTY_LIST : cCountriesByLanguage.computeIfAbsent(str, new C13928v(str, 0));
    }

    public static boolean isAvailableLocale(Locale locale) {
        return availableLocaleSet().contains(locale);
    }

    private static boolean isISO3166CountryCode(String str) {
        return StringUtils.isAllUpperCase(str) && str.length() == 2;
    }

    private static boolean isISO639LanguageCode(String str) {
        if (StringUtils.isAllLowerCase(str)) {
            return str.length() == 2 || str.length() == 3;
        }
        return false;
    }

    public static boolean isLanguageUndetermined(Locale locale) {
        return locale == null || UNDETERMINED.equals(locale.toLanguageTag());
    }

    private static boolean isNumericAreaCode(String str) {
        return StringUtils.isNumeric(str) && str.length() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$countriesByLanguage$0(String str, Locale locale) {
        return str.equals(locale.getLanguage()) && !locale.getCountry().isEmpty() && locale.getVariant().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$countriesByLanguage$1(String str, String str2) {
        return Collections.unmodifiableList(availableLocaleList(new C9478c(str, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$languagesByCountry$2(String str, Locale locale) {
        return str.equals(locale.getCountry()) && locale.getVariant().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$languagesByCountry$3(String str, String str2) {
        return Collections.unmodifiableList(availableLocaleList(new C9478c(str, 2)));
    }

    public static List<Locale> languagesByCountry(String str) {
        return str == null ? Collections.EMPTY_LIST : cLanguagesByCountry.computeIfAbsent(str, new C13928v(str, 1));
    }

    public static List<Locale> localeLookupList(Locale locale) {
        return localeLookupList(locale, locale);
    }

    private static Locale parseLocale(String str) {
        if (isISO639LanguageCode(str)) {
            return new Locale(str);
        }
        char c = UNDERSCORE;
        if (str.indexOf(95) == -1) {
            c = DASH;
        }
        String[] strArrSplit = str.split(String.valueOf(c), 3);
        String str2 = strArrSplit[0];
        if (strArrSplit.length == 2) {
            String str3 = strArrSplit[1];
            if ((isISO639LanguageCode(str2) && isISO3166CountryCode(str3)) || isNumericAreaCode(str3)) {
                return new Locale(str2, str3);
            }
        } else if (strArrSplit.length == 3) {
            String str4 = strArrSplit[1];
            String str5 = strArrSplit[2];
            if (isISO639LanguageCode(str2) && ((str4.isEmpty() || isISO3166CountryCode(str4) || isNumericAreaCode(str4)) && !str5.isEmpty())) {
                return new Locale(str2, str4, str5);
            }
        }
        throw new IllegalArgumentException("Invalid locale format: ".concat(str));
    }

    public static Locale toLocale(Locale locale) {
        return locale != null ? locale : Locale.getDefault();
    }

    private static List<Locale> availableLocaleList(Predicate<Locale> predicate) {
        return (List) availableLocaleList().stream().filter(predicate).collect(Collectors.toList());
    }

    public static List<Locale> localeLookupList(Locale locale, Locale locale2) {
        ArrayList arrayList = new ArrayList(4);
        if (locale != null) {
            arrayList.add(locale);
            if (!locale.getVariant().isEmpty()) {
                arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
            }
            if (!locale.getCountry().isEmpty()) {
                arrayList.add(new Locale(locale.getLanguage(), ""));
            }
            if (!arrayList.contains(locale2)) {
                arrayList.add(locale2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Locale toLocale(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new Locale("", "");
        }
        if (str.contains(ContentUtils.HASH_SYMBOL)) {
            throw new IllegalArgumentException("Invalid locale format: ".concat(str));
        }
        int length = str.length();
        if (length < 2) {
            throw new IllegalArgumentException("Invalid locale format: ".concat(str));
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '_' && cCharAt != '-') {
            return parseLocale(str);
        }
        if (length < 3) {
            throw new IllegalArgumentException("Invalid locale format: ".concat(str));
        }
        char cCharAt2 = str.charAt(1);
        char cCharAt3 = str.charAt(2);
        if (!Character.isUpperCase(cCharAt2) || !Character.isUpperCase(cCharAt3)) {
            throw new IllegalArgumentException("Invalid locale format: ".concat(str));
        }
        if (length == 3) {
            return new Locale("", str.substring(1, 3));
        }
        if (length < 5) {
            throw new IllegalArgumentException("Invalid locale format: ".concat(str));
        }
        if (str.charAt(3) == cCharAt) {
            return new Locale("", str.substring(1, 3), str.substring(4));
        }
        throw new IllegalArgumentException("Invalid locale format: ".concat(str));
    }
}
