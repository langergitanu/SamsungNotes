package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat combineLocales(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        while (i < localeListCompat2.size() + localeListCompat.size()) {
            Locale locale = i < localeListCompat.size() ? localeListCompat.get(i) : localeListCompat2.get(i - localeListCompat.size());
            if (locale != null) {
                linkedHashSet.add(locale);
            }
            i++;
        }
        return LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        return (localeListCompat == null || localeListCompat.isEmpty()) ? LocaleListCompat.getEmptyLocaleList() : combineLocales(localeListCompat, localeListCompat2);
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleList localeList, LocaleList localeList2) {
        if (localeList != null && !localeList.isEmpty()) {
            return combineLocales(LocaleListCompat.wrap(localeList), LocaleListCompat.wrap(localeList2));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }
}
