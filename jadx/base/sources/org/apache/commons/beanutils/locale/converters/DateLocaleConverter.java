package org.apache.commons.beanutils.locale.converters;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DateLocaleConverter extends BaseLocaleConverter {
    private static final String DEFAULT_PATTERN_CHARS = initDefaultChars();
    boolean isLenient;
    private final Log log;

    public DateLocaleConverter() {
        this(false);
    }

    private String convertLocalizedPattern(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        String localPatternChars = new DateFormatSymbols(locale).getLocalPatternChars();
        String str2 = DEFAULT_PATTERN_CHARS;
        if (str2.equals(localPatternChars)) {
            return str;
        }
        try {
            return convertPattern(str, localPatternChars, str2);
        } catch (Exception e) {
            this.log.debug("Converting pattern '" + str + "' for " + locale, e);
            return null;
        }
    }

    private String convertPattern(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z) {
                if (cCharAt == '\'') {
                    z = false;
                }
            } else if (cCharAt == '\'') {
                z = true;
            } else if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                int iIndexOf = str2.indexOf(cCharAt);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Illegal pattern character '" + cCharAt + "'");
                }
                cCharAt = str3.charAt(iIndexOf);
            }
            sb.append(cCharAt);
        }
        if (z) {
            throw new IllegalArgumentException("Unfinished quote in pattern");
        }
        return sb.toString();
    }

    private static String initDefaultChars() {
        return new DateFormatSymbols(Locale.US).getLocalPatternChars();
    }

    public boolean isLenient() {
        return this.isLenient;
    }

    @Override // org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (this.locPattern) {
            str = convertLocalizedPattern(str, this.locale);
        }
        DateFormat dateInstance = str == null ? DateFormat.getDateInstance(3, this.locale) : new SimpleDateFormat(str, this.locale);
        dateInstance.setLenient(this.isLenient);
        ParsePosition parsePosition = new ParsePosition(0);
        String string = obj.toString();
        Object object = dateInstance.parseObject(string, parsePosition);
        if (parsePosition.getErrorIndex() > -1) {
            throw new ConversionException("Error parsing date '" + obj + "' at position=" + parsePosition.getErrorIndex());
        }
        if (parsePosition.getIndex() >= string.length()) {
            return object;
        }
        throw new ConversionException("Date '" + obj + "' contains unparsed characters from position=" + parsePosition.getIndex());
    }

    public void setLenient(boolean z) {
        this.isLenient = z;
    }

    public DateLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public DateLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DateLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public DateLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DateLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
        this.log = LogFactory.getLog((Class<?>) DateLocaleConverter.class);
    }

    public DateLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DateLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public DateLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DateLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public DateLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DateLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
        this.log = LogFactory.getLog((Class<?>) DateLocaleConverter.class);
    }
}
