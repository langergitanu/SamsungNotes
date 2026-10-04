package org.apache.commons.beanutils.locale;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseLocaleConverter implements LocaleConverter {
    private Object defaultValue;
    protected boolean locPattern;
    protected Locale locale;
    private final Log log;
    protected String pattern;
    protected boolean useDefault;

    public BaseLocaleConverter(Locale locale, String str) {
        this(null, locale, str, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T checkConversionResult(Class<T> cls, Object obj) {
        if (cls == null) {
            return obj;
        }
        if (obj == 0) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new ConversionException(AbstractC2322a.m1621k("Unsupported target type: ", cls));
    }

    private <T> T getDefaultAs(Class<T> cls) {
        return (T) checkConversionResult(cls, this.defaultValue);
    }

    @Override // org.apache.commons.beanutils.Converter
    public <T> T convert(Class<T> cls, Object obj) {
        return (T) convert(cls, obj, null);
    }

    public abstract Object parse(Object obj, String str);

    public BaseLocaleConverter(Locale locale, String str, boolean z) {
        this(null, locale, str, false, z);
    }

    @Override // org.apache.commons.beanutils.locale.LocaleConverter
    public <T> T convert(Class<T> cls, Object obj, String str) {
        Class<T> clsPrimitiveToWrapper = ConvertUtils.primitiveToWrapper(cls);
        if (obj == null) {
            if (this.useDefault) {
                return (T) getDefaultAs(clsPrimitiveToWrapper);
            }
            this.log.debug("Null value specified for conversion, returing null");
            return null;
        }
        try {
            return str != null ? (T) checkConversionResult(clsPrimitiveToWrapper, parse(obj, str)) : (T) checkConversionResult(clsPrimitiveToWrapper, parse(obj, this.pattern));
        } catch (Exception e) {
            if (this.useDefault) {
                return (T) getDefaultAs(clsPrimitiveToWrapper);
            }
            if (e instanceof ConversionException) {
                throw ((ConversionException) e);
            }
            throw new ConversionException(e);
        }
    }

    public BaseLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public BaseLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        this(obj, locale, str, true, z);
    }

    private BaseLocaleConverter(Object obj, Locale locale, String str, boolean z, boolean z2) {
        this.log = LogFactory.getLog((Class<?>) BaseLocaleConverter.class);
        this.locale = Locale.getDefault();
        if (z) {
            this.defaultValue = obj;
            this.useDefault = true;
        }
        if (locale != null) {
            this.locale = locale;
        }
        this.pattern = str;
        this.locPattern = z2;
    }

    public Object convert(Object obj) {
        return convert(obj, (String) null);
    }

    public Object convert(Object obj, String str) {
        return convert(null, obj, str);
    }
}
