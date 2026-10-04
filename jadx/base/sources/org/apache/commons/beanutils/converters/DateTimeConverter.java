package org.apache.commons.beanutils.converters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class DateTimeConverter extends AbstractConverter {
    private String displayPatterns;
    private Locale locale;
    private String[] patterns;
    private TimeZone timeZone;
    private boolean useLocaleFormat;

    public DateTimeConverter() {
    }

    private void logFormat(String str, DateFormat dateFormat) {
        if (log().isDebugEnabled()) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("    ");
            sb.append(str);
            sb.append(" with Format");
            if (dateFormat instanceof SimpleDateFormat) {
                sb.append("[");
                sb.append(((SimpleDateFormat) dateFormat).toPattern());
                sb.append("]");
            }
            sb.append(" for ");
            if (this.locale == null) {
                sb.append("default locale");
            } else {
                sb.append("locale[");
                sb.append(this.locale);
                sb.append("]");
            }
            if (this.timeZone != null) {
                sb.append(", TimeZone[");
                sb.append(this.timeZone);
                sb.append("]");
            }
            log().debug(sb.toString());
        }
    }

    private Calendar parse(Class<?> cls, Class<?> cls2, String str) throws Exception {
        Exception exc = null;
        for (String str2 : this.patterns) {
            try {
                return parse(cls, cls2, str, getFormat(str2));
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.patterns.length <= 1) {
            throw exc;
        }
        StringBuilder sb = new StringBuilder("Error converting '");
        sb.append(toString(cls));
        sb.append("' to '");
        sb.append(toString(cls2));
        sb.append("' using  patterns '");
        throw new ConversionException(AbstractC0622a.m1170p(this.displayPatterns, "'", sb));
    }

    private <T> T toDate(Class<T> cls, long j) {
        Calendar calendar;
        if (cls.equals(Date.class)) {
            return cls.cast(new Date(j));
        }
        if (cls.equals(java.sql.Date.class)) {
            return cls.cast(new java.sql.Date(j));
        }
        if (cls.equals(Time.class)) {
            return cls.cast(new Time(j));
        }
        if (cls.equals(Timestamp.class)) {
            return cls.cast(new Timestamp(j));
        }
        if (cls.equals(Calendar.class)) {
            Locale locale = this.locale;
            if (locale == null && this.timeZone == null) {
                calendar = Calendar.getInstance();
            } else if (locale == null) {
                calendar = Calendar.getInstance(this.timeZone);
            } else {
                TimeZone timeZone = this.timeZone;
                calendar = timeZone == null ? Calendar.getInstance(locale) : Calendar.getInstance(timeZone, locale);
            }
            calendar.setTime(new Date(j));
            calendar.setLenient(false);
            return cls.cast(calendar);
        }
        String str = toString(getClass()) + " cannot handle conversion to '" + toString(cls) + "'";
        if (log().isWarnEnabled()) {
            log().warn("    " + str);
        }
        throw new ConversionException(str);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String convertToString(Object obj) {
        Date time = obj instanceof Date ? (Date) obj : obj instanceof Calendar ? ((Calendar) obj).getTime() : obj instanceof Long ? new Date(((Long) obj).longValue()) : null;
        if (!this.useLocaleFormat || time == null) {
            String string = obj.toString();
            if (log().isDebugEnabled()) {
                log().debug("    Converted  to String using toString() '" + string + "'");
            }
            return string;
        }
        String[] strArr = this.patterns;
        DateFormat format = (strArr == null || strArr.length <= 0) ? getFormat(this.locale, this.timeZone) : getFormat(strArr[0]);
        logFormat("Formatting", format);
        String str = format.format(time);
        if (log().isDebugEnabled()) {
            log().debug("    Converted  to String using format '" + str + "'");
        }
        return str;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        Class<?> cls2 = obj.getClass();
        if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            return (T) toDate(cls, ((timestamp.getTime() / 1000) * 1000) + ((long) (timestamp.getNanos() / 1000000)));
        }
        if (obj instanceof Date) {
            return (T) toDate(cls, ((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return (T) toDate(cls, ((Calendar) obj).getTime().getTime());
        }
        if (obj instanceof Long) {
            return (T) toDate(cls, ((Long) obj).longValue());
        }
        String strTrim = obj.toString().trim();
        if (strTrim.length() == 0) {
            return (T) handleMissing(cls);
        }
        if (!this.useLocaleFormat) {
            return (T) toDate(cls, strTrim);
        }
        String[] strArr = this.patterns;
        Calendar calendar = (strArr == null || strArr.length <= 0) ? parse(cls2, cls, strTrim, getFormat(this.locale, this.timeZone)) : parse(cls2, cls, strTrim);
        return Calendar.class.isAssignableFrom(cls) ? cls.cast(calendar) : (T) toDate(cls, calendar.getTime().getTime());
    }

    public DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat dateInstance = locale == null ? DateFormat.getDateInstance(3) : DateFormat.getDateInstance(3, locale);
        if (timeZone != null) {
            dateInstance.setTimeZone(timeZone);
        }
        return dateInstance;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String[] getPatterns() {
        return this.patterns;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        setUseLocaleFormat(true);
    }

    public void setPattern(String str) {
        setPatterns(new String[]{str});
    }

    public void setPatterns(String[] strArr) {
        this.patterns = strArr;
        if (strArr != null && strArr.length > 1) {
            this.displayPatterns = String.join(SQLKeyword.COMMA, strArr);
        }
        setUseLocaleFormat(true);
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setUseLocaleFormat(boolean z) {
        this.useLocaleFormat = z;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(getClass()));
        sb.append("[UseDefault=");
        sb.append(isUseDefault());
        sb.append(", UseLocaleFormat=");
        sb.append(this.useLocaleFormat);
        if (this.displayPatterns != null) {
            sb.append(", Patterns={");
            sb.append(this.displayPatterns);
            sb.append('}');
        }
        if (this.locale != null) {
            sb.append(", Locale=");
            sb.append(this.locale);
        }
        if (this.timeZone != null) {
            sb.append(", TimeZone=");
            sb.append(this.timeZone);
        }
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public DateTimeConverter(Object obj) {
        super(obj);
    }

    private DateFormat getFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat;
    }

    private Calendar parse(Class<?> cls, Class<?> cls2, String str, DateFormat dateFormat) {
        logFormat("Parsing", dateFormat);
        dateFormat.setLenient(false);
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = dateFormat.parse(str, parsePosition);
        if (parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() == str.length() && date != null) {
            return dateFormat.getCalendar();
        }
        String string = "Error converting '" + toString(cls) + "' to '" + toString(cls2) + "'";
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder sbM781w = AbstractC0541b.m781w(string, " using pattern '");
            sbM781w.append(((SimpleDateFormat) dateFormat).toPattern());
            sbM781w.append("'");
            string = sbM781w.toString();
        }
        if (log().isDebugEnabled()) {
            log().debug("    " + string);
        }
        throw new ConversionException(string);
    }

    private <T> T toDate(Class<T> cls, String str) {
        if (cls.equals(java.sql.Date.class)) {
            try {
                return cls.cast(java.sql.Date.valueOf(str));
            } catch (IllegalArgumentException unused) {
                throw new ConversionException("String must be in JDBC format [yyyy-MM-dd] to create a java.sql.Date");
            }
        }
        if (cls.equals(Time.class)) {
            try {
                return cls.cast(Time.valueOf(str));
            } catch (IllegalArgumentException unused2) {
                throw new ConversionException("String must be in JDBC format [HH:mm:ss] to create a java.sql.Time");
            }
        }
        if (cls.equals(Timestamp.class)) {
            try {
                return cls.cast(Timestamp.valueOf(str));
            } catch (IllegalArgumentException unused3) {
                throw new ConversionException("String must be in JDBC format [yyyy-MM-dd HH:mm:ss.fffffffff] to create a java.sql.Timestamp");
            }
        }
        String str2 = toString(getClass()) + " does not support default String to '" + toString(cls) + "' conversion.";
        if (log().isWarnEnabled()) {
            log().warn("    " + str2);
            log().warn("    (Re-configure Converter or use alternative implementation)");
        }
        throw new ConversionException(str2);
    }
}
