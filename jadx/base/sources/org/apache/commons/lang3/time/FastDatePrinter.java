package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final long serialVersionUID = 1;
    private final Locale locale;
    private transient int maxLengthEstimate;
    private final String pattern;
    private transient Rule[] rules;
    private final TimeZone timeZone;
    private static final Rule[] EMPTY_RULE_ARRAY = new Rule[0];
    private static final ConcurrentMap<TimeZoneDisplayKey, String> timeZoneDisplayCache = new ConcurrentHashMap(7);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharacterLiteral implements Rule {
        private final char value;

        public CharacterLiteral(char c) {
            this.value = c;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.value);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Iso8601_Rule implements Rule {
        private final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        public Iso8601_Rule(int i) {
            this.length = i;
        }

        public static Iso8601_Rule getRule(int i) {
            if (i == 1) {
                return ISO8601_HOURS;
            }
            if (i == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(16) + calendar.get(15);
            if (i == 0) {
                appendable.append("Z");
                return;
            }
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            int i4 = this.length;
            if (i4 < 5) {
                return;
            }
            if (i4 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PaddedNumberField implements NumberRule {
        private final int field;
        private final int size;

        public PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.field = i;
            this.size = i2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.field));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.size;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i, this.size);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar);

        int estimateLength();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringLiteral implements Rule {
        private final String value;

        public StringLiteral(String str) {
            this.value = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.value);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.value.length();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TextField implements Rule {
        private final int field;
        private final String[] values;

        public TextField(int i, String[] strArr) {
            this.field = i;
            this.values = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.values[calendar.get(this.field)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.values.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.values[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TimeZoneDisplayKey {
        private final Locale locale;
        private final int style;
        private final TimeZone timeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.timeZone = timeZone;
            if (z) {
                this.style = Integer.MIN_VALUE | i;
            } else {
                this.style = i;
            }
            this.locale = LocaleUtils.toLocale(locale);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TimeZoneDisplayKey) {
                TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
                if (this.timeZone.equals(timeZoneDisplayKey.timeZone) && this.style == timeZoneDisplayKey.style && this.locale.equals(timeZoneDisplayKey.locale)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.timeZone.hashCode() + ((this.locale.hashCode() + (this.style * 31)) * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TimeZoneNameRule implements Rule {
        private final String daylight;
        private final Locale locale;
        private final String standard;
        private final int style;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i) {
            this.locale = LocaleUtils.toLocale(locale);
            this.style = i;
            this.standard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.daylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(FastDatePrinter.getTimeZoneDisplay(calendar.getTimeZone(), calendar.get(16) != 0, this.style, this.locale));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.standard.length(), this.daylight.length());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        private final boolean colon;

        public TimeZoneNumberRule(boolean z) {
            this.colon = z;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(16) + calendar.get(15);
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / 3600000;
            FastDatePrinter.appendDigits(appendable, i2);
            if (this.colon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TwoDigitNumberField implements NumberRule {
        private final int field;

        public TwoDigitNumberField(int i) {
            this.field = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.field));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i % 100);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, i);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UnpaddedNumberField implements NumberRule {
        private final int field;

        public UnpaddedNumberField(int i) {
            this.field = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.field));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WeekYear implements NumberRule {
        private final NumberRule rule;

        public WeekYear(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.rule.appendTo(appendable, calendar.getWeekYear());
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = LocaleUtils.toLocale(locale);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i) throws IOException {
        appendable.append((char) ((i / 10) + 48));
        appendable.append((char) ((i % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i, int i2) throws IOException {
        if (i < 10000) {
            int i4 = i < 1000 ? i < 100 ? i < 10 ? 1 : 2 : 3 : 4;
            for (int i5 = i2 - i4; i5 > 0; i5--) {
                appendable.append('0');
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        appendable.append((char) ((i / 1000) + 48));
                        i %= 1000;
                    }
                    if (i >= 100) {
                        appendable.append((char) ((i / 100) + 48));
                        i %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i >= 10) {
                    appendable.append((char) ((i / 10) + 48));
                    i %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i + 48));
            return;
        }
        char[] cArr = new char[10];
        int i6 = 0;
        while (i != 0) {
            cArr[i6] = (char) ((i % 10) + 48);
            i /= 10;
            i6++;
        }
        while (i6 < i2) {
            appendable.append('0');
            i2--;
        }
        while (true) {
            i6--;
            if (i6 < 0) {
                return;
            } else {
                appendable.append(cArr[i6]);
            }
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            for (Rule rule : this.rules) {
                rule.appendTo(b, calendar);
            }
            return b;
        } catch (IOException e) {
            ExceptionUtils.asRuntimeException(e);
            return b;
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, new StringBuilder(this.maxLengthEstimate))).toString();
    }

    public static void clear() {
        timeZoneDisplayCache.clear();
    }

    public static String getTimeZoneDisplay(final TimeZone timeZone, final boolean z, final int i, final Locale locale) {
        return timeZoneDisplayCache.computeIfAbsent(new TimeZoneDisplayKey(timeZone, z, i, locale), new Function() { // from class: org.apache.commons.lang3.time.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FastDatePrinter.lambda$getTimeZoneDisplay$0(timeZone, z, i, locale, (FastDatePrinter.TimeZoneDisplayKey) obj);
            }
        });
    }

    private void init() {
        Rule[] ruleArr = (Rule[]) parsePattern().toArray(EMPTY_RULE_ARRAY);
        this.rules = ruleArr;
        int length = ruleArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.maxLengthEstimate = iEstimateLength;
                return;
            }
            iEstimateLength += this.rules[length].estimateLength();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getTimeZoneDisplay$0(TimeZone timeZone, boolean z, int i, Locale locale, TimeZoneDisplayKey timeZoneDisplayKey) {
        return timeZone.getDisplayName(z, i, locale);
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.timeZone, this.locale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.pattern.equals(fastDatePrinter.pattern) && this.timeZone.equals(fastDatePrinter.timeZone) && this.locale.equals(fastDatePrinter.locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, new StringBuilder(this.maxLengthEstimate))).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    public int getMaxLengthEstimate() {
        return this.maxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return (((this.locale.hashCode() * 13) + this.timeZone.hashCode()) * 13) + this.pattern.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Rule> parsePattern() {
        int i;
        Object stringLiteral;
        Object textField;
        Object weekYear;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.pattern.length();
        int i2 = 0;
        int i4 = 0;
        while (i4 < length) {
            int[] iArr = {i4};
            String token = parseToken(this.pattern, iArr);
            int i5 = iArr[i2];
            int length2 = token.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = token.charAt(i2);
            if (cCharAt != '\'') {
                if (cCharAt == 'S') {
                    textField = selectNumberRule(14, length2);
                } else if (cCharAt == 'a') {
                    textField = new TextField(9, amPmStrings);
                } else if (cCharAt == 'd') {
                    textField = selectNumberRule(5, length2);
                } else if (cCharAt == 'h') {
                    textField = new TwelveHourField(selectNumberRule(10, length2));
                } else if (cCharAt == 'k') {
                    textField = new TwentyFourHourField(selectNumberRule(11, length2));
                } else if (cCharAt == 'm') {
                    textField = selectNumberRule(12, length2);
                } else if (cCharAt == 's') {
                    textField = selectNumberRule(13, length2);
                } else if (cCharAt == 'u') {
                    textField = new DayInWeekField(selectNumberRule(7, length2));
                } else if (cCharAt == 'w') {
                    textField = selectNumberRule(3, length2);
                } else if (cCharAt == 'y') {
                    NumberRule numberRuleSelectNumberRule = length2 == 2 ? TwoDigitYearField.INSTANCE : selectNumberRule(1, Math.max(length2, 4));
                    textField = numberRuleSelectNumberRule;
                    if (cCharAt == 'Y') {
                        weekYear = new WeekYear(numberRuleSelectNumberRule);
                        textField = weekYear;
                    }
                } else if (cCharAt != 'z') {
                    switch (cCharAt) {
                        case 'D':
                            textField = selectNumberRule(6, length2);
                            break;
                        case 'E':
                            textField = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                            break;
                        case 'F':
                            textField = selectNumberRule(8, length2);
                            break;
                        case 'G':
                            textField = new TextField(0, eras);
                            i = 0;
                            break;
                        case 'H':
                            textField = selectNumberRule(11, length2);
                            break;
                        default:
                            switch (cCharAt) {
                                case 'K':
                                    textField = selectNumberRule(10, length2);
                                    break;
                                case 'L':
                                    if (length2 >= 4) {
                                        weekYear = new TextField(2, CalendarUtils.getInstance(this.locale).getStandaloneLongMonthNames());
                                    } else if (length2 != 3) {
                                        textField = length2 != 2 ? UnpaddedMonthField.INSTANCE : TwoDigitMonthField.INSTANCE;
                                    } else {
                                        weekYear = new TextField(2, CalendarUtils.getInstance(this.locale).getStandaloneShortMonthNames());
                                    }
                                    textField = weekYear;
                                    break;
                                case 'M':
                                    if (length2 >= 4) {
                                        weekYear = new TextField(2, months);
                                    } else if (length2 != 3) {
                                        textField = length2 != 2 ? UnpaddedMonthField.INSTANCE : TwoDigitMonthField.INSTANCE;
                                    } else {
                                        weekYear = new TextField(2, shortMonths);
                                    }
                                    textField = weekYear;
                                    break;
                                default:
                                    switch (cCharAt) {
                                        case 'W':
                                            textField = selectNumberRule(4, length2);
                                            break;
                                        case 'X':
                                            textField = Iso8601_Rule.getRule(length2);
                                            break;
                                        case 'Y':
                                            break;
                                        case 'Z':
                                            textField = length2 != 1 ? length2 != 2 ? TimeZoneNumberRule.INSTANCE_COLON : Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES : TimeZoneNumberRule.INSTANCE_NO_COLON;
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Illegal pattern component: ".concat(token));
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    textField = new TimeZoneNameRule(this.timeZone, this.locale, length2 >= 4 ? 1 : 0);
                }
                i = 0;
            } else {
                String strSubstring = token.substring(1);
                if (strSubstring.length() == 1) {
                    i = 0;
                    stringLiteral = new CharacterLiteral(strSubstring.charAt(0));
                } else {
                    i = 0;
                    stringLiteral = new StringLiteral(strSubstring);
                }
                textField = stringLiteral;
            }
            arrayList.add(textField);
            i4 = i5 + 1;
            i2 = i;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i);
        if (CharUtils.isAsciiAlpha(cCharAt)) {
            sb.append(cCharAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 != '\'') {
                    if (!z && CharUtils.isAsciiAlpha(cCharAt2)) {
                        i--;
                        break;
                    }
                    sb.append(cCharAt2);
                } else {
                    int i4 = i + 1;
                    if (i4 >= length || str.charAt(i4) != '\'') {
                        z = !z;
                    } else {
                        sb.append(cCharAt2);
                        i = i4;
                    }
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    public NumberRule selectNumberRule(int i, int i2) {
        return i2 != 1 ? i2 != 2 ? new PaddedNumberField(i, i2) : new TwoDigitNumberField(i) : new UnpaddedNumberField(i);
    }

    public String toString() {
        return "FastDatePrinter[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DayInWeekField implements NumberRule {
        private final NumberRule rule;

        public DayInWeekField(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            int i = calendar.get(7);
            this.rule.appendTo(appendable, i != 1 ? i - 1 : 7);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b) {
        if (!calendar.getTimeZone().equals(this.timeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.timeZone);
        }
        return (B) applyRules(calendar, b);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TwelveHourField implements NumberRule {
        private final NumberRule rule;

        public TwelveHourField(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.rule.appendTo(appendable, leastMaximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TwentyFourHourField implements NumberRule {
        private final NumberRule rule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.rule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.rule.appendTo(appendable, maximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.rule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) {
            this.rule.appendTo(appendable, i);
        }
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return applyRulesToString(calendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return (B) applyRules(calendarNewCalendar, b);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return (StringBuffer) applyRules(calendarNewCalendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j);
        return applyRulesToString(calendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j, B b) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j);
        return (B) applyRules(calendarNewCalendar, b);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(calendarNewCalendar, stringBuffer);
    }

    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        throw new IllegalArgumentException("Unknown class: " + ClassUtils.getName(obj, "<null>"));
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        throw new IllegalArgumentException("Unknown class: " + ClassUtils.getName(obj, "<null>"));
    }
}
