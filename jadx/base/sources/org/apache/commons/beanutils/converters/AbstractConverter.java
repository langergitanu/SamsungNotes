package org.apache.commons.beanutils.converters;

import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.XMPConst;
import java.lang.reflect.Array;
import java.util.Collection;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractConverter implements Converter {
    private static final String DEFAULT_CONFIG_MSG = "(Converters can be configured to use default values to avoid throwing exceptions)";
    private static final String PACKAGE = "org.apache.commons.beanutils.converters.";
    private Object defaultValue;
    private transient Log log;
    private boolean useDefault;

    public AbstractConverter() {
    }

    private <T> T convertToDefaultType(Class<T> cls, Object obj) {
        return (T) convert(getDefaultType(), obj);
    }

    public ConversionException conversionException(Class<?> cls, Object obj) {
        return new ConversionException("Can't convert value '" + obj + "' to type " + cls);
    }

    @Override // org.apache.commons.beanutils.Converter
    public <T> T convert(Class<T> cls, Object obj) {
        String str;
        if (cls == null) {
            return (T) convertToDefaultType(cls, obj);
        }
        Class<?> cls2 = obj == null ? null : obj.getClass();
        Class<T> clsPrimitiveToWrapper = ConvertUtils.primitiveToWrapper(cls);
        if (log().isDebugEnabled()) {
            Log log = log();
            StringBuilder sb = new StringBuilder("Converting");
            if (obj == null) {
                str = "";
            } else {
                str = " '" + toString(cls2) + "'";
            }
            sb.append(str);
            sb.append(" value '");
            sb.append(obj);
            sb.append("' to type '");
            sb.append(toString(clsPrimitiveToWrapper));
            sb.append("'");
            log.debug(sb.toString());
        }
        Object objConvertArray = convertArray(obj);
        if (objConvertArray == null) {
            return (T) handleMissing(clsPrimitiveToWrapper);
        }
        Class<?> cls3 = objConvertArray.getClass();
        try {
            if (clsPrimitiveToWrapper.equals(String.class)) {
                return clsPrimitiveToWrapper.cast(convertToString(objConvertArray));
            }
            if (clsPrimitiveToWrapper.equals(cls3)) {
                if (log().isDebugEnabled()) {
                    log().debug("    No conversion required, value is already a " + toString(clsPrimitiveToWrapper));
                }
                return clsPrimitiveToWrapper.cast(objConvertArray);
            }
            Object objConvertToType = convertToType(clsPrimitiveToWrapper, objConvertArray);
            if (log().isDebugEnabled()) {
                log().debug("    Converted to " + toString(clsPrimitiveToWrapper) + " value '" + objConvertToType + "'");
            }
            return clsPrimitiveToWrapper.cast(objConvertToType);
        } catch (Throwable th) {
            return (T) handleError(clsPrimitiveToWrapper, objConvertArray, th);
        }
    }

    public Object convertArray(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) > 0) {
                return Array.get(obj, 0);
            }
            return null;
        }
        if (!(obj instanceof Collection)) {
            return obj;
        }
        Collection collection = (Collection) obj;
        if (collection.size() > 0) {
            return collection.iterator().next();
        }
        return null;
    }

    public String convertToString(Object obj) {
        return obj.toString();
    }

    public abstract <T> T convertToType(Class<T> cls, Object obj);

    public Object getDefault(Class<?> cls) {
        if (cls.equals(String.class)) {
            return null;
        }
        return this.defaultValue;
    }

    public abstract Class<?> getDefaultType();

    public <T> T handleError(Class<T> cls, Object obj, Throwable th) {
        if (log().isDebugEnabled()) {
            if (th instanceof ConversionException) {
                log().debug("    Conversion threw ConversionException: " + th.getMessage());
            } else {
                log().debug("    Conversion threw " + th);
            }
        }
        if (this.useDefault) {
            return (T) handleMissing(cls);
        }
        if (th instanceof ConversionException) {
            ConversionException conversionException = (ConversionException) th;
            if (!log().isDebugEnabled()) {
                throw conversionException;
            }
            log().debug("    Re-throwing ConversionException: " + conversionException.getMessage());
            log().debug("    (Converters can be configured to use default values to avoid throwing exceptions)");
            throw conversionException;
        }
        String str = "Error converting from '" + toString(obj.getClass()) + "' to '" + toString(cls) + "' " + th.getMessage();
        ConversionException conversionException2 = new ConversionException(str, th);
        if (log().isDebugEnabled()) {
            log().debug("    Throwing ConversionException: " + str);
            log().debug("    (Converters can be configured to use default values to avoid throwing exceptions)");
        }
        throw conversionException2;
    }

    public <T> T handleMissing(Class<T> cls) {
        String str;
        if (!this.useDefault && !cls.equals(String.class)) {
            ConversionException conversionException = new ConversionException("No value specified for '" + toString(cls) + "'");
            if (!log().isDebugEnabled()) {
                throw conversionException;
            }
            log().debug("    Throwing ConversionException: " + conversionException.getMessage());
            log().debug("    (Converters can be configured to use default values to avoid throwing exceptions)");
            throw conversionException;
        }
        Object objConvertToType = getDefault(cls);
        if (this.useDefault && objConvertToType != null && !cls.equals(objConvertToType.getClass())) {
            try {
                objConvertToType = convertToType(cls, this.defaultValue);
            } catch (Throwable th) {
                throw new ConversionException("Default conversion to " + toString(cls) + " failed.", th);
            }
        }
        if (log().isDebugEnabled()) {
            Log log = log();
            StringBuilder sb = new StringBuilder("    Using default ");
            if (objConvertToType == null) {
                str = "";
            } else {
                str = toString(objConvertToType.getClass()) + " ";
            }
            sb.append(str);
            sb.append("value '");
            sb.append(this.defaultValue);
            sb.append("'");
            log.debug(sb.toString());
        }
        return cls.cast(objConvertToType);
    }

    public boolean isUseDefault() {
        return this.useDefault;
    }

    public Log log() {
        if (this.log == null) {
            this.log = LogFactory.getLog(getClass());
        }
        return this.log;
    }

    public void setDefaultValue(Object obj) {
        this.useDefault = false;
        if (log().isDebugEnabled()) {
            log().debug("Setting default value: " + obj);
        }
        if (obj == null) {
            this.defaultValue = null;
        } else {
            this.defaultValue = convert(getDefaultType(), obj);
        }
        this.useDefault = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(getClass()));
        sb.append("[UseDefault=");
        return AbstractC0000a.m14k(sb, this.useDefault, "]");
    }

    public AbstractConverter(Object obj) {
        setDefaultValue(obj);
    }

    public String toString(Class<?> cls) {
        String name;
        if (cls == null) {
            name = "null";
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            int i = 1;
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
                i++;
            }
            name = componentType.getName();
            for (int i2 = 0; i2 < i; i2++) {
                name = AbstractC0541b.m756B(name, XMPConst.ARRAY_ITEM_NAME);
            }
        } else {
            name = cls.getName();
        }
        if (name.startsWith("java.lang.") || name.startsWith("java.util.") || name.startsWith("java.math.")) {
            return name.substring(10);
        }
        return name.startsWith(PACKAGE) ? name.substring(40) : name;
    }
}
