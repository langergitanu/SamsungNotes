package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.time.AbstractFormatCache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractFormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<ArrayKey, String> dateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<ArrayKey, F> instanceCache = new ConcurrentHashMap(7);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ArrayKey {
        private final int hashCode;
        private final Object[] keys;

        public ArrayKey(Object... objArr) {
            this.keys = objArr;
            this.hashCode = Objects.hash(objArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ArrayKey.class == obj.getClass()) {
                return Arrays.deepEquals(this.keys, ((ArrayKey) obj).keys);
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static void clear() {
        dateTimeInstanceCache.clear();
    }

    public static String getPatternForStyle(final Integer num, final Integer num2, Locale locale) {
        final Locale locale2 = LocaleUtils.toLocale(locale);
        return dateTimeInstanceCache.computeIfAbsent(new ArrayKey(num, num2, locale2), new Function() { // from class: org.apache.commons.lang3.time.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AbstractFormatCache.lambda$getPatternForStyle$0(num, num2, locale2, (AbstractFormatCache.ArrayKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Format lambda$getInstance$1(String str, TimeZone timeZone, Locale locale, ArrayKey arrayKey) {
        return createInstance(str, timeZone, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getPatternForStyle$0(Integer num, Integer num2, Locale locale, ArrayKey arrayKey) {
        try {
            return ((SimpleDateFormat) (num == null ? DateFormat.getTimeInstance(num2.intValue(), locale) : num2 == null ? DateFormat.getDateInstance(num.intValue(), locale) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale))).toPattern();
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("No date time pattern for locale: " + locale);
        }
    }

    public void clearInstance() {
        this.instanceCache.clear();
    }

    public abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    public F getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    public F getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    public F getInstance() {
        return (F) getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        Locale locale2 = LocaleUtils.toLocale(locale);
        return (F) getInstance(getPatternForStyle(num, num2, locale2), timeZone, locale2);
    }

    public F getInstance(final String str, TimeZone timeZone, Locale locale) {
        Objects.requireNonNull(str, "pattern");
        final TimeZone timeZone2 = TimeZones.toTimeZone(timeZone);
        final Locale locale2 = LocaleUtils.toLocale(locale);
        return this.instanceCache.computeIfAbsent(new ArrayKey(str, timeZone2, locale2), new Function() { // from class: org.apache.commons.lang3.time.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f9949a.lambda$getInstance$1(str, timeZone2, locale2, (AbstractFormatCache.ArrayKey) obj);
            }
        });
    }
}
