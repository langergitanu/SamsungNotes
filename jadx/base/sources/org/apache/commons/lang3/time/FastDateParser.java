package org.apache.commons.lang3.time;

import androidx.appcompat.animation.C0422b;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.imagetranslation.util.C7149r;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.LocaleUtils;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FastDateParser implements DateParser, Serializable {
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;
    static final Locale JAPANESE_IMPERIAL = new Locale(LangPackConfigConstants.LANGUAGE_CODE_JA, "JP", "JP");
    private static final Comparator<String> LONGER_FIRST_LOWERCASE = Comparator.reverseOrder();
    private static final ConcurrentMap<Locale, Strategy>[] CACHES = new ConcurrentMap[17];
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: org.apache.commons.lang3.time.FastDateParser.1
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            return i < 100 ? fastDateParser.adjustYear(i) : i;
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: org.apache.commons.lang3.time.FastDateParser.2
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            return i - 1;
        }
    };
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) { // from class: org.apache.commons.lang3.time.FastDateParser.3
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 7) {
                return 1;
            }
            return i + 1;
        }
    };
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: org.apache.commons.lang3.time.FastDateParser.4
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 24) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) { // from class: org.apache.commons.lang3.time.FastDateParser.5
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 12) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        private final Locale locale;

        public CaseInsensitiveTextStrategy(int i, Calendar calendar, Locale locale) {
            super();
            this.field = i;
            this.locale = LocaleUtils.toLocale(locale);
            StringBuilder sbM1324q = AbstractC1974b.m1324q("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale, i, sbM1324q);
            sbM1324q.setLength(sbM1324q.length() - 1);
            sbM1324q.append(")");
            createPattern(sbM1324q);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.locale);
            Integer num = this.lKeyValues.get(lowerCase);
            if (num == null) {
                num = this.lKeyValues.get(lowerCase + '.');
            }
            if (9 != this.field || num.intValue() <= 1) {
                calendar.set(this.field, num.intValue());
            }
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public String toString() {
            return "CaseInsensitiveTextStrategy [field=" + this.field + ", locale=" + this.locale + ", lKeyValues=" + this.lKeyValues + ", pattern=" + this.pattern + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        public CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            for (int i2 = 0; i2 < this.formatField.length(); i2++) {
                int index = parsePosition.getIndex() + i2;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                if (this.formatField.charAt(i2) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(parsePosition.getIndex() + this.formatField.length());
            return true;
        }

        public String toString() {
            return AbstractC0622a.m1170p(this.formatField, "]", new StringBuilder("CopyQuotedStrategy [formatField="));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        public ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        public static Strategy getStrategy(int i) {
            if (i == 1) {
                return ISO_8601_1_STRATEGY;
            }
            if (i == 2) {
                return ISO_8601_2_STRATEGY;
            }
            if (i == 3) {
                return ISO_8601_3_STRATEGY;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PatternStrategy extends Strategy {
        Pattern pattern;

        private PatternStrategy() {
            super();
        }

        public void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(matcher.end(1) + parsePosition.getIndex());
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        public abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        public String toString() {
            return getClass().getSimpleName() + " [pattern=" + this.pattern + "]";
        }

        public void createPattern(StringBuilder sb) {
            createPattern(sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Strategy {
        private Strategy() {
        }

        public boolean isNumber() {
            return false;
        }

        public abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        public StrategyAndWidth(Strategy strategy, int i) {
            Objects.requireNonNull(strategy, "strategy");
            this.strategy = strategy;
            this.width = i;
        }

        public int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (this.strategy.isNumber() && listIterator.hasNext()) {
                Strategy strategy = listIterator.next().strategy;
                listIterator.previous();
                if (strategy.isNumber()) {
                    return this.width;
                }
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("StrategyAndWidth [strategy=");
            sb.append(this.strategy);
            sb.append(", width=");
            return AbstractC2821a.m2223n(sb, "]", this.width);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;

        public StrategyParser(Calendar calendar) {
            Objects.requireNonNull(calendar, "definingCalendar");
            this.definingCalendar = calendar;
        }

        private StrategyAndWidth letterPattern(char c) {
            int i = this.currentIdx;
            do {
                int i2 = this.currentIdx + 1;
                this.currentIdx = i2;
                if (i2 >= FastDateParser.this.pattern.length()) {
                    break;
                }
            } while (FastDateParser.this.pattern.charAt(this.currentIdx) == c);
            int i4 = this.currentIdx - i;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c, i4, this.definingCalendar), i4);
        }

        private StrategyAndWidth literal() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char cCharAt = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!z && CharUtils.isAsciiAlpha(cCharAt)) {
                    break;
                }
                if (cCharAt == '\'') {
                    int i = this.currentIdx + 1;
                    this.currentIdx = i;
                    if (i == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'') {
                        z = !z;
                    }
                }
                this.currentIdx++;
                sb.append(cCharAt);
            }
            if (z) {
                throw new IllegalArgumentException("Unterminated quote");
            }
            String string = sb.toString();
            return new StrategyAndWidth(new CopyQuotedStrategy(string), string.length());
        }

        public StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char cCharAt = FastDateParser.this.pattern.charAt(this.currentIdx);
            return CharUtils.isAsciiAlpha(cCharAt) ? letterPattern(cCharAt) : literal();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeZoneStrategy extends PatternStrategy {
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";

        /* JADX INFO: renamed from: ID */
        private static final int f9945ID = 0;
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class TzInfo {
            final int dstOffset;
            final TimeZone zone;

            public TzInfo(TimeZone timeZone, boolean z) {
                this.zone = timeZone;
                this.dstOffset = z ? timeZone.getDSTSavings() : 0;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("TzInfo [zone=");
                sb.append(this.zone);
                sb.append(", dstOffset=");
                return AbstractC2821a.m2223n(sb, "]", this.dstOffset);
            }
        }

        public TimeZoneStrategy(Locale locale) {
            super();
            this.tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            this.locale = LocaleUtils.toLocale(locale);
            StringBuilder sbM1324q = AbstractC1974b.m1324q("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase(TimeZones.GMT_ID)) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i = 1; i < strArr.length; i++) {
                        if (i == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i == 5) {
                            tzInfo2 = tzInfo;
                        }
                        String str2 = strArr[i];
                        if (str2 != null && treeSet.add(str2)) {
                            this.tzNames.put(str2, tzInfo2);
                        }
                    }
                }
            }
            for (String str3 : (String[]) ArraySorter.sort(TimeZone.getAvailableIDs())) {
                if (!str3.equalsIgnoreCase(TimeZones.GMT_ID)) {
                    TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                    String displayName = timeZone2.getDisplayName(locale);
                    if (treeSet.add(displayName)) {
                        this.tzNames.put(displayName, new TzInfo(timeZone2, timeZone2.observesDaylightTime()));
                    }
                }
            }
            treeSet.forEach(new C13924g(0, sbM1324q));
            sbM1324q.append(")");
            createPattern(sbM1324q);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(StringBuilder sb, String str) {
            sb.append('|');
            FastDateParser.simpleQuote(sb, str);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone(str);
            if (gmtTimeZone != null) {
                calendar.setTimeZone(gmtTimeZone);
                return;
            }
            TzInfo tzInfo = this.tzNames.get(str);
            if (tzInfo == null) {
                tzInfo = this.tzNames.get(str + '.');
                if (tzInfo == null) {
                    char[] charArray = str.toCharArray();
                    throw new IllegalStateException(String.format("Can't find time zone '%s' (%d %s) in %s", str, Integer.valueOf(charArray.length), Arrays.toString(charArray), new TreeSet(this.tzNames.keySet())));
                }
            }
            calendar.set(16, tzInfo.dstOffset);
            calendar.set(15, tzInfo.zone.getRawOffset());
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public String toString() {
            return "TimeZoneStrategy [locale=" + this.locale + ", tzNames=" + this.tzNames + ", pattern=" + this.pattern + "]";
        }
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(int i) {
        int i2 = this.century + i;
        return i >= this.startYear ? i2 : i2 + 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int i, StringBuilder sb) {
        Objects.requireNonNull(calendar, "calendar");
        final HashMap map = new HashMap();
        final Locale locale2 = LocaleUtils.toLocale(locale);
        Map<String, Integer> displayNames = calendar.getDisplayNames(i, 0, locale2);
        final TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        displayNames.forEach(new BiConsumer() { // from class: org.apache.commons.lang3.time.f
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                FastDateParser.lambda$appendDisplayNames$0(locale2, treeSet, map, (String) obj, (Integer) obj2);
            }
        });
        treeSet.forEach(new C13924g(1, sb));
        return map;
    }

    public static void clear() {
        Stream.of((Object[]) CACHES).filter(new C0233e(21)).forEach(new C0422b(5));
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = CACHES;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i] == null) {
                    concurrentMapArr[i] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i];
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i, Calendar calendar) {
        return getCache(i).computeIfAbsent(this.locale, new C7149r(this, i, calendar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Strategy getStrategy(char c, int i, Calendar calendar) {
        if (c == 'S') {
            return MILLISECOND_STRATEGY;
        }
        if (c == 'a') {
            return getLocaleSpecificStrategy(9, calendar);
        }
        if (c == 'd') {
            return DAY_OF_MONTH_STRATEGY;
        }
        if (c == 'h') {
            return HOUR12_STRATEGY;
        }
        if (c == 'k') {
            return HOUR24_OF_DAY_STRATEGY;
        }
        if (c == 'm') {
            return MINUTE_STRATEGY;
        }
        if (c == 's') {
            return SECOND_STRATEGY;
        }
        if (c == 'u') {
            return DAY_OF_WEEK_STRATEGY;
        }
        if (c == 'w') {
            return WEEK_OF_YEAR_STRATEGY;
        }
        if (c != 'y') {
            if (c != 'z') {
                switch (c) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'L':
                            case 'M':
                                return i >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                            default:
                                switch (c) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return ISO8601TimeZoneStrategy.getStrategy(i);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i == 2) {
                                            return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c + "' not supported");
                                }
                                break;
                        }
                        break;
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        return i > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy == null) {
                return;
            } else {
                this.patterns.add(nextStrategy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$appendDisplayNames$0(Locale locale, TreeSet treeSet, Map map, String str, Integer num) {
        String lowerCase = str.toLowerCase(locale);
        if (treeSet.add(lowerCase)) {
            map.put(lowerCase, num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$appendDisplayNames$1(StringBuilder sb, String str) {
        simpleQuote(sb, str).append('|');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Strategy lambda$getLocaleSpecificStrategy$2(int i, Calendar calendar, Locale locale) {
        return i == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i, calendar, this.locale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '$' || cCharAt == '.' || cCharAt == '?' || cCharAt == '^' || cCharAt == '[' || cCharAt == '\\' || cCharAt == '{' || cCharAt == '|') {
                sb.append('\\');
            } else {
                switch (cCharAt) {
                }
            }
            sb.append(cCharAt);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('?');
        }
        return sb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return (((this.locale.hashCode() * 13) + this.timeZone.hashCode()) * 13) + this.pattern.hashCode();
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = parse(str, parsePosition);
        if (date != null) {
            return date;
        }
        if (!this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException(AbstractC0541b.m772n("Unparseable date: ", str), parsePosition.getErrorIndex());
        }
        throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + SQLKeyword.COMMA + this.locale + SQLKeyword.COMMA + this.timeZone.getID() + "]";
    }

    public String toStringAll() {
        StringBuilder sb = new StringBuilder("FastDateParser [pattern=");
        sb.append(this.pattern);
        sb.append(", timeZone=");
        sb.append(this.timeZone);
        sb.append(", locale=");
        sb.append(this.locale);
        sb.append(", century=");
        sb.append(this.century);
        sb.append(", startYear=");
        sb.append(this.startYear);
        sb.append(", patterns=");
        return AbstractC0541b.m777s(sb, this.patterns, "]");
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i;
        Objects.requireNonNull(str, "pattern");
        this.pattern = str;
        Objects.requireNonNull(timeZone, "timeZone");
        this.timeZone = timeZone;
        Locale locale2 = LocaleUtils.toLocale(locale);
        this.locale = locale2;
        Calendar calendar = Calendar.getInstance(timeZone, locale2);
        if (date != null) {
            calendar.setTime(date);
            i = calendar.get(1);
        } else if (locale2.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            calendar.setTime(new Date());
            i = calendar.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(calendar);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        if (parse(str, parsePosition, calendar)) {
            return calendar.getTime();
        }
        return null;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            String str2 = str;
            ParsePosition parsePosition2 = parsePosition;
            Calendar calendar2 = calendar;
            if (!next.strategy.parse(this, calendar2, str2, parsePosition2, next.getMaxWidth(listIterator))) {
                return false;
            }
            calendar = calendar2;
            str = str2;
            parsePosition = parsePosition2;
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NumberStrategy extends Strategy {
        private final int field;

        public NumberStrategy(int i) {
            super();
            this.field = i;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i2 = i + index;
                if (length > i2) {
                    length = i2;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int i4 = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, i4));
            return true;
        }

        public String toString() {
            return AbstractC2821a.m2223n(new StringBuilder("NumberStrategy [field="), "]", this.field);
        }

        public int modify(FastDateParser fastDateParser, int i) {
            return i;
        }
    }
}
