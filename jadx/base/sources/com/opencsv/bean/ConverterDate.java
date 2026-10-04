package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.chrono.HijrahEra;
import java.time.chrono.IsoEra;
import java.time.chrono.JapaneseEra;
import java.time.chrono.MinguoEra;
import java.time.chrono.ThaiBuddhistEra;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiFunction;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConverterDate extends AbstractCsvConverter {
    private static final String CSVDATE_NOT_DATE = "csvdate.not.date";
    private final DateTimeFormatter readDtf;
    private final SimpleDateFormat readSdf;
    private final BiFunction<DateTimeFormatter, String, TemporalAccessor> readTemporalConversionFunction;
    private final DateTimeFormatter writeDtf;
    private final SimpleDateFormat writeSdf;
    private final BiFunction<DateTimeFormatter, TemporalAccessor, String> writeTemporalConversionFunction;

    public ConverterDate(Class<?> cls, String str, String str2, Locale locale, String str3, String str4, String str5, String str6) {
        super(cls, str, str2, locale);
        Chronology chronology = getChronology(str5, this.locale);
        Chronology chronology2 = getChronology(str6, this.writeLocale);
        try {
            if (TemporalAccessor.class.isAssignableFrom(cls)) {
                this.readSdf = null;
                this.readDtf = setDateTimeFormatter(str3, this.locale).withChronology(chronology);
                this.readTemporalConversionFunction = determineReadTemporalConversionFunction(cls);
            } else {
                this.readDtf = null;
                this.readTemporalConversionFunction = null;
                this.readSdf = setDateFormat(str3, this.locale);
            }
            try {
                if (TemporalAccessor.class.isAssignableFrom(cls)) {
                    this.writeSdf = null;
                    this.writeDtf = setDateTimeFormatter(str4, this.writeLocale).withChronology(chronology2);
                    this.writeTemporalConversionFunction = determineWriteTemporalConversionFunction(cls);
                } else {
                    this.writeDtf = null;
                    this.writeTemporalConversionFunction = null;
                    this.writeSdf = setDateFormat(str4, this.writeLocale);
                }
            } catch (IllegalArgumentException e) {
                CsvBadConverterException csvBadConverterException = new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.date.format.string"), str4));
                csvBadConverterException.initCause(e);
                throw csvBadConverterException;
            }
        } catch (IllegalArgumentException e2) {
            CsvBadConverterException csvBadConverterException2 = new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.date.format.string"), str3));
            csvBadConverterException2.initCause(e2);
            throw csvBadConverterException2;
        }
    }

    private BiFunction<DateTimeFormatter, String, TemporalAccessor> determineReadTemporalConversionFunction(Class<?> cls) {
        if (TemporalAccessor.class.equals(cls)) {
            return new C6624g(2);
        }
        if (ChronoLocalDateTime.class.equals(cls) || LocalDateTime.class.equals(cls)) {
            return new C6624g(13);
        }
        if (ChronoZonedDateTime.class.equals(cls) || ZonedDateTime.class.equals(cls)) {
            return new C6624g(14);
        }
        if (Temporal.class.equals(cls)) {
            return new C6624g(15);
        }
        if (Era.class.equals(cls) || IsoEra.class.equals(cls)) {
            return new C6624g(16);
        }
        if (DayOfWeek.class.equals(cls)) {
            return new C6624g(17);
        }
        if (HijrahEra.class.equals(cls)) {
            return new C6624g(18);
        }
        if (Instant.class.equals(cls)) {
            return new C6624g(19);
        }
        if (ChronoLocalDate.class.isAssignableFrom(cls)) {
            return new C6624g(20);
        }
        if (JapaneseEra.class.equals(cls)) {
            return new C6624g(21);
        }
        if (LocalTime.class.equals(cls)) {
            return new C6624g(3);
        }
        if (MinguoEra.class.equals(cls)) {
            return new C6624g(4);
        }
        if (Month.class.equals(cls)) {
            return new C6624g(5);
        }
        if (MonthDay.class.equals(cls)) {
            return new C6624g(6);
        }
        if (OffsetDateTime.class.equals(cls)) {
            return new C6624g(7);
        }
        if (OffsetTime.class.equals(cls)) {
            return new C6624g(8);
        }
        if (ThaiBuddhistEra.class.equals(cls)) {
            return new C6624g(9);
        }
        if (Year.class.equals(cls)) {
            return new C6624g(10);
        }
        if (YearMonth.class.equals(cls)) {
            return new C6624g(11);
        }
        if (ZoneOffset.class.equals(cls)) {
            return new C6624g(12);
        }
        throw new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString(CSVDATE_NOT_DATE), cls));
    }

    private BiFunction<DateTimeFormatter, TemporalAccessor, String> determineWriteTemporalConversionFunction(Class<?> cls) {
        return Instant.class.equals(cls) ? new C6624g(0) : new C6624g(1);
    }

    private Chronology getChronology(String str, Locale locale) {
        try {
            return StringUtils.isNotBlank(str) ? Chronology.of(str) : Chronology.ofLocale(locale);
        } catch (DateTimeException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(getClass(), String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("chronology.not.found"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$10(DateTimeFormatter dateTimeFormatter, String str) {
        return JapaneseEra.of(dateTimeFormatter.parse(str).get(ChronoField.ERA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$11(DateTimeFormatter dateTimeFormatter, String str) {
        return (LocalTime) dateTimeFormatter.parse(str, new C6623f(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$12(DateTimeFormatter dateTimeFormatter, String str) {
        return MinguoEra.of(dateTimeFormatter.parse(str).get(ChronoField.ERA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$13(DateTimeFormatter dateTimeFormatter, String str) {
        return (Month) dateTimeFormatter.parse(str, new C6623f(7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$14(DateTimeFormatter dateTimeFormatter, String str) {
        return (MonthDay) dateTimeFormatter.parse(str, new C6623f(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$15(DateTimeFormatter dateTimeFormatter, String str) {
        return (OffsetDateTime) dateTimeFormatter.parse(str, new C6623f(12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$16(DateTimeFormatter dateTimeFormatter, String str) {
        return (OffsetTime) dateTimeFormatter.parse(str, new C6623f(8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$17(DateTimeFormatter dateTimeFormatter, String str) {
        return ThaiBuddhistEra.of(dateTimeFormatter.parse(str).get(ChronoField.ERA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$18(DateTimeFormatter dateTimeFormatter, String str) {
        return (Year) dateTimeFormatter.parse(str, new C6623f(9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$19(DateTimeFormatter dateTimeFormatter, String str) {
        return (YearMonth) dateTimeFormatter.parse(str, new C6623f(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$2(DateTimeFormatter dateTimeFormatter, String str) {
        return (LocalDateTime) dateTimeFormatter.parse(str, new C6623f(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$20(DateTimeFormatter dateTimeFormatter, String str) {
        return (ZoneOffset) dateTimeFormatter.parse(str, new C6623f(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$3(DateTimeFormatter dateTimeFormatter, String str) {
        return (ZonedDateTime) dateTimeFormatter.parse(str, new C6623f(11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$4(DateTimeFormatter dateTimeFormatter, String str) {
        return dateTimeFormatter.parseBest(str, new C6623f(11), new C6623f(12), new C6623f(13), new C6623f(5), new C6623f(1), new C6623f(8), new C6623f(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$5(DateTimeFormatter dateTimeFormatter, String str) {
        return IsoEra.of(dateTimeFormatter.parse(str).get(ChronoField.ERA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$6(DateTimeFormatter dateTimeFormatter, String str) {
        return (DayOfWeek) dateTimeFormatter.parse(str, new C6623f(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$7(DateTimeFormatter dateTimeFormatter, String str) {
        return HijrahEra.of(dateTimeFormatter.parse(str).get(ChronoField.ERA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$8(DateTimeFormatter dateTimeFormatter, String str) {
        return (Instant) dateTimeFormatter.parse(str, new C6623f(13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemporalAccessor lambda$determineReadTemporalConversionFunction$9(DateTimeFormatter dateTimeFormatter, String str) {
        return (ChronoLocalDate) dateTimeFormatter.parse(str, new C6623f(10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$determineWriteTemporalConversionFunction$0(DateTimeFormatter dateTimeFormatter, TemporalAccessor temporalAccessor) {
        return dateTimeFormatter.format(LocalDateTime.ofInstant((Instant) temporalAccessor, ZoneId.of("UTC")));
    }

    private SimpleDateFormat setDateFormat(String str, Locale locale) {
        return locale != null ? new SimpleDateFormat(str, locale) : new SimpleDateFormat(str);
    }

    private DateTimeFormatter setDateTimeFormatter(String str, Locale locale) {
        return this.writeLocale != null ? DateTimeFormatter.ofPattern(str, locale) : DateTimeFormatter.ofPattern(str);
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        Date date;
        Date date2;
        if (!StringUtils.isNotBlank(str)) {
            return null;
        }
        if (Date.class.isAssignableFrom(this.type)) {
            try {
                synchronized (this.readSdf) {
                    date = this.readSdf.parse(str);
                }
                return this.type.getConstructor(Long.TYPE).newInstance(Long.valueOf(date.getTime()));
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | ParseException e) {
                CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type);
                csvDataTypeMismatchException.initCause(e);
                throw csvDataTypeMismatchException;
            }
        }
        if (TemporalAccessor.class.isAssignableFrom(this.type)) {
            try {
                return this.type.cast(this.readTemporalConversionFunction.apply(this.readDtf, str));
            } catch (ArithmeticException | DateTimeException e2) {
                CsvDataTypeMismatchException csvDataTypeMismatchException2 = new CsvDataTypeMismatchException(str, this.type);
                csvDataTypeMismatchException2.initCause(e2);
                throw csvDataTypeMismatchException2;
            }
        }
        if (!Calendar.class.isAssignableFrom(this.type) && !XMLGregorianCalendar.class.isAssignableFrom(this.type)) {
            throw new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString(CSVDATE_NOT_DATE), this.type));
        }
        try {
            synchronized (this.readSdf) {
                date2 = this.readSdf.parse(str);
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date2);
            Class<?> cls = this.type;
            if (cls != XMLGregorianCalendar.class) {
                return cls.cast(gregorianCalendar);
            }
            try {
                return cls.cast(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
            } catch (DatatypeConfigurationException e3) {
                CsvDataTypeMismatchException csvDataTypeMismatchException3 = new CsvDataTypeMismatchException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("xmlgregoriancalendar.impossible"));
                csvDataTypeMismatchException3.initCause(e3);
                throw csvDataTypeMismatchException3;
            }
        } catch (ParseException e5) {
            CsvDataTypeMismatchException csvDataTypeMismatchException4 = new CsvDataTypeMismatchException(str, this.type);
            csvDataTypeMismatchException4.initCause(e5);
            throw csvDataTypeMismatchException4;
        }
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        String str;
        String str2;
        if (obj == null) {
            return null;
        }
        if (Date.class.isAssignableFrom(this.type)) {
            synchronized (this.writeSdf) {
                str2 = this.writeSdf.format((Date) obj);
            }
            return str2;
        }
        if (TemporalAccessor.class.isAssignableFrom(this.type)) {
            try {
                return this.writeTemporalConversionFunction.apply(this.writeDtf, (TemporalAccessor) obj);
            } catch (ArithmeticException | DateTimeException e) {
                CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(obj, this.type);
                csvDataTypeMismatchException.initCause(e);
                throw csvDataTypeMismatchException;
            }
        }
        if (!Calendar.class.isAssignableFrom(this.type) && !XMLGregorianCalendar.class.isAssignableFrom(this.type)) {
            throw new CsvDataTypeMismatchException(obj, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString(CSVDATE_NOT_DATE), this.type));
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        synchronized (this.writeSdf) {
            str = this.writeSdf.format(gregorianCalendar.getTime());
        }
        return str;
    }
}
