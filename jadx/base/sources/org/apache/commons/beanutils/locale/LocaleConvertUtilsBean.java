package org.apache.commons.beanutils.locale;

import com.samsung.android.app.sdk.deepsky.donation.schema.DonationContract;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.locale.converters.BigDecimalLocaleConverter;
import org.apache.commons.beanutils.locale.converters.BigIntegerLocaleConverter;
import org.apache.commons.beanutils.locale.converters.ByteLocaleConverter;
import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;
import org.apache.commons.beanutils.locale.converters.FloatLocaleConverter;
import org.apache.commons.beanutils.locale.converters.IntegerLocaleConverter;
import org.apache.commons.beanutils.locale.converters.LongLocaleConverter;
import org.apache.commons.beanutils.locale.converters.ShortLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlDateLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlTimeLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlTimestampLocaleConverter;
import org.apache.commons.beanutils.locale.converters.StringLocaleConverter;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LocaleConvertUtilsBean {
    private boolean applyLocalized;
    private Locale defaultLocale = Locale.getDefault();
    private final Log log = LogFactory.getLog((Class<?>) LocaleConvertUtils.class);
    private final FastHashMap mapConverters;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DelegateFastHashMap extends FastHashMap {
        private static final long serialVersionUID = 1;
        private final Map<Object, Object> map;

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.map.clear();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Object, Object>> entrySet() {
            return this.map.entrySet();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this.map.equals(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return this.map.get(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap
        public boolean getFast() {
            return BeanUtils.getCacheFast(this.map);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Object> keySet() {
            return this.map.keySet();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return this.map.put(obj, obj2);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            this.map.putAll(map);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return this.map.remove(obj);
        }

        @Override // org.apache.commons.collections.FastHashMap
        public void setFast(boolean z) {
            BeanUtils.setCacheFast(this.map, z);
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // org.apache.commons.collections.FastHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection<Object> values() {
            return this.map.values();
        }

        private DelegateFastHashMap(Map<Object, Object> map) {
            this.map = map;
        }
    }

    public LocaleConvertUtilsBean() {
        DelegateFastHashMap delegateFastHashMap = new DelegateFastHashMap(BeanUtils.createCache());
        this.mapConverters = delegateFastHashMap;
        delegateFastHashMap.setFast(false);
        deregister();
        delegateFastHashMap.setFast(true);
    }

    public static LocaleConvertUtilsBean getInstance() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getLocaleConvertUtils();
    }

    public String convert(Object obj) {
        return convert(obj, this.defaultLocale, (String) null);
    }

    @Deprecated
    public FastHashMap create(Locale locale) {
        DelegateFastHashMap delegateFastHashMap = new DelegateFastHashMap(BeanUtils.createCache());
        delegateFastHashMap.setFast(false);
        delegateFastHashMap.put(BigDecimal.class, new BigDecimalLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(BigInteger.class, new BigIntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Byte.class, new ByteLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Byte.TYPE, new ByteLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Double.class, new DoubleLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Double.TYPE, new DoubleLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Float.class, new FloatLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Float.TYPE, new FloatLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Integer.class, new IntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Integer.TYPE, new IntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Long.class, new LongLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Long.TYPE, new LongLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Short.class, new ShortLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Short.TYPE, new ShortLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(String.class, new StringLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Date.class, new SqlDateLocaleConverter(locale, DonationContract.DONATION_DATE_FORMAT));
        delegateFastHashMap.put(Time.class, new SqlTimeLocaleConverter(locale, "HH:mm:ss"));
        delegateFastHashMap.put(Timestamp.class, new SqlTimestampLocaleConverter(locale, "yyyy-MM-dd HH:mm:ss.S"));
        delegateFastHashMap.setFast(true);
        return delegateFastHashMap;
    }

    public void deregister() {
        FastHashMap fastHashMapLookup = lookup(this.defaultLocale);
        this.mapConverters.setFast(false);
        this.mapConverters.clear();
        this.mapConverters.put(this.defaultLocale, fastHashMapLookup);
        this.mapConverters.setFast(true);
    }

    public boolean getApplyLocalized() {
        return this.applyLocalized;
    }

    public Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    public LocaleConverter lookup(Class<?> cls, Locale locale) {
        LocaleConverter localeConverter = (LocaleConverter) lookup(locale).get(cls);
        if (this.log.isTraceEnabled()) {
            this.log.trace("LocaleConverter:" + localeConverter);
        }
        return localeConverter;
    }

    public void register(LocaleConverter localeConverter, Class<?> cls, Locale locale) {
        lookup(locale).put(cls, localeConverter);
    }

    public void setApplyLocalized(boolean z) {
        this.applyLocalized = z;
    }

    public void setDefaultLocale(Locale locale) {
        if (locale == null) {
            this.defaultLocale = Locale.getDefault();
        } else {
            this.defaultLocale = locale;
        }
    }

    public String convert(Object obj, Locale locale, String str) {
        return (String) lookup(String.class, locale).convert(String.class, obj, str);
    }

    public String convert(Object obj, String str) {
        return convert(obj, this.defaultLocale, str);
    }

    @Deprecated
    public FastHashMap lookup(Locale locale) {
        if (locale == null) {
            return (FastHashMap) this.mapConverters.get(this.defaultLocale);
        }
        FastHashMap fastHashMap = (FastHashMap) this.mapConverters.get(locale);
        if (fastHashMap != null) {
            return fastHashMap;
        }
        FastHashMap fastHashMapCreate = create(locale);
        this.mapConverters.put(locale, fastHashMapCreate);
        return fastHashMapCreate;
    }

    public Object convert(String str, Class<?> cls) {
        return convert(str, cls, this.defaultLocale, (String) null);
    }

    public Object convert(String str, Class<?> cls, Locale locale, String str2) {
        if (this.log.isDebugEnabled()) {
            Log log = this.log;
            StringBuilder sbM15l = AbstractC0000a.m15l("Convert string ", str, " to class ");
            sbM15l.append(cls.getName());
            sbM15l.append(" using ");
            sbM15l.append(locale);
            sbM15l.append(" locale and ");
            sbM15l.append(str2);
            sbM15l.append(" pattern");
            log.debug(sbM15l.toString());
        }
        LocaleConverter localeConverterLookup = lookup(cls, locale);
        if (localeConverterLookup == null) {
            cls = String.class;
            localeConverterLookup = lookup(cls, locale);
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("  Using converter " + localeConverterLookup);
        }
        return localeConverterLookup.convert(cls, str, str2);
    }

    public void deregister(Class<?> cls, Locale locale) {
        lookup(locale).remove(cls);
    }

    public void deregister(Locale locale) {
        this.mapConverters.remove(locale);
    }

    public Object convert(String str, Class<?> cls, String str2) {
        return convert(str, cls, this.defaultLocale, str2);
    }

    public Object convert(String[] strArr, Class<?> cls) {
        return convert(strArr, cls, getDefaultLocale(), (String) null);
    }

    public Object convert(String[] strArr, Class<?> cls, Locale locale, String str) {
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Convert String[" + strArr.length + "] to class " + cls.getName() + "[] using " + locale + " locale and " + str + " pattern");
        }
        Object objNewInstance = Array.newInstance(cls, strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            Array.set(objNewInstance, i, convert(strArr[i], cls, locale, str));
        }
        return objNewInstance;
    }

    public Object convert(String[] strArr, Class<?> cls, String str) {
        return convert(strArr, cls, getDefaultLocale(), str);
    }
}
