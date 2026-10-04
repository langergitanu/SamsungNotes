package org.apache.commons.beanutils.locale;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.MappedPropertyDescriptor;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LocaleBeanUtilsBean extends BeanUtilsBean {
    private static final ContextClassLoaderLocal<LocaleBeanUtilsBean> LOCALE_BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<LocaleBeanUtilsBean>() { // from class: org.apache.commons.beanutils.locale.LocaleBeanUtilsBean.1
        @Override // org.apache.commons.beanutils.ContextClassLoaderLocal
        public LocaleBeanUtilsBean initialValue() {
            return new LocaleBeanUtilsBean();
        }
    };
    private final LocaleConvertUtilsBean localeConvertUtils;
    private final Log log;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public class Descriptor {
        private int index = -1;
        private String key;
        private String name;
        private String propName;
        private Object target;

        public Descriptor(Object obj, String str, String str2, String str3, int i) {
            setTarget(obj);
            setName(str);
            setPropName(str2);
            setKey(str3);
            setIndex(i);
        }

        public int getIndex() {
            return this.index;
        }

        public String getKey() {
            return this.key;
        }

        public String getName() {
            return this.name;
        }

        public String getPropName() {
            return this.propName;
        }

        public Object getTarget() {
            return this.target;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPropName(String str) {
            this.propName = str;
        }

        public void setTarget(Object obj) {
            this.target = obj;
        }
    }

    public LocaleBeanUtilsBean() {
        this.log = LogFactory.getLog((Class<?>) LocaleBeanUtilsBean.class);
        this.localeConvertUtils = new LocaleConvertUtilsBean();
    }

    public static LocaleBeanUtilsBean getLocaleBeanUtilsInstance() {
        return LOCALE_BEANS_BY_CLASSLOADER.get();
    }

    public static void setInstance(LocaleBeanUtilsBean localeBeanUtilsBean) {
        LOCALE_BEANS_BY_CLASSLOADER.set(localeBeanUtilsBean);
    }

    @Deprecated
    public Descriptor calculate(Object obj, String str) {
        Resolver resolver = getPropertyUtils().getResolver();
        Object property = obj;
        String strRemove = str;
        while (resolver.hasNested(strRemove)) {
            try {
                property = getPropertyUtils().getProperty(property, resolver.next(strRemove));
                strRemove = resolver.remove(strRemove);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + property);
            this.log.trace("    Target name = " + strRemove);
        }
        return new Descriptor(property, strRemove, resolver.getProperty(strRemove), resolver.getKey(strRemove), resolver.getIndex(strRemove));
    }

    public Object convert(Class<?> cls, int i, Object obj) {
        if (!cls.isArray() || i >= 0) {
            if (cls.isArray()) {
                if (obj instanceof String) {
                    return ConvertUtils.convert((String) obj, cls.getComponentType());
                }
                if (obj instanceof String[]) {
                    return ConvertUtils.convert(((String[]) obj)[0], cls.getComponentType());
                }
            } else {
                if (obj instanceof String) {
                    return ConvertUtils.convert((String) obj, cls);
                }
                if (obj instanceof String[]) {
                    return ConvertUtils.convert(((String[]) obj)[0], cls);
                }
            }
        } else {
            if (obj instanceof String) {
                return ConvertUtils.convert(new String[]{(String) obj}, cls);
            }
            if (obj instanceof String[]) {
                return ConvertUtils.convert((String[]) obj, cls);
            }
        }
        return obj;
    }

    public Class<?> definePropertyType(Object obj, String str, String str2) {
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(str2);
            if (dynaProperty == null) {
                return null;
            }
            return dynaProperty.getType();
        }
        try {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor instanceof MappedPropertyDescriptor ? ((MappedPropertyDescriptor) propertyDescriptor).getMappedPropertyType() : propertyDescriptor instanceof IndexedPropertyDescriptor ? propertyDescriptor.getIndexedPropertyType() : propertyDescriptor.getPropertyType();
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public boolean getApplyLocalized() {
        return getLocaleConvertUtils().getApplyLocalized();
    }

    public Locale getDefaultLocale() {
        return getLocaleConvertUtils().getDefaultLocale();
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getIndexedProperty(Object obj, String str) {
        return getIndexedProperty(obj, str, (String) null);
    }

    public LocaleConvertUtilsBean getLocaleConvertUtils() {
        return this.localeConvertUtils;
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getMappedProperty(Object obj, String str) {
        return getMappedPropertyLocale(obj, str, null);
    }

    public String getMappedPropertyLocale(Object obj, String str, String str2) {
        return getLocaleConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str), str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getNestedProperty(Object obj, String str) {
        return getNestedProperty(obj, str, null);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getProperty(Object obj, String str) {
        return getNestedProperty(obj, str);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getSimpleProperty(Object obj, String str) {
        return getSimpleProperty(obj, str, null);
    }

    public void invokeSetter(Object obj, String str, String str2, int i, Object obj2) throws InvocationTargetException {
        try {
            if (i >= 0) {
                getPropertyUtils().setIndexedProperty(obj, str, i, obj2);
            } else if (str2 != null) {
                getPropertyUtils().setMappedProperty(obj, str, str2, obj2);
            } else {
                getPropertyUtils().setProperty(obj, str, obj2);
            }
        } catch (NoSuchMethodException e) {
            throw new InvocationTargetException(e, AbstractC0541b.m772n("Cannot set ", str));
        }
    }

    public void setApplyLocalized(boolean z) {
        getLocaleConvertUtils().setApplyLocalized(z);
    }

    public void setDefaultLocale(Locale locale) {
        getLocaleConvertUtils().setDefaultLocale(locale);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public void setProperty(Object obj, String str, Object obj2) throws InvocationTargetException {
        setProperty(obj, str, obj2, null);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getIndexedProperty(Object obj, String str, int i) {
        return getIndexedProperty(obj, str, i, null);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getMappedProperty(Object obj, String str, String str2) {
        return getMappedProperty(obj, str, str2, null);
    }

    public String getNestedProperty(Object obj, String str, String str2) {
        return getLocaleConvertUtils().convert(getPropertyUtils().getNestedProperty(obj, str), str2);
    }

    public String getProperty(Object obj, String str, String str2) {
        return getNestedProperty(obj, str, str2);
    }

    public String getSimpleProperty(Object obj, String str, String str2) throws NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getSimpleProperty(obj, str), str2);
    }

    public void setProperty(Object obj, String str, Object obj2, String str2) throws InvocationTargetException {
        if (this.log.isTraceEnabled()) {
            StringBuilder sb = new StringBuilder("  setProperty(");
            sb.append(obj);
            sb.append(SQLKeyword.COMMA);
            sb.append(str);
            sb.append(SQLKeyword.COMMA);
            if (obj2 == null) {
                sb.append("<NULL>");
            } else if (obj2 instanceof String) {
                sb.append((String) obj2);
            } else if (obj2 instanceof String[]) {
                String[] strArr = (String[]) obj2;
                sb.append(PropertyUtils.INDEXED_DELIM);
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        sb.append(',');
                    }
                    sb.append(strArr[i]);
                }
                sb.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                sb.append(obj2.toString());
            }
            sb.append(PropertyUtils.MAPPED_DELIM2);
            this.log.trace(sb.toString());
        }
        Resolver resolver = getPropertyUtils().getResolver();
        Object property = obj;
        while (resolver.hasNested(str)) {
            try {
                property = getPropertyUtils().getProperty(property, resolver.next(str));
                str = resolver.remove(str);
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + property);
            this.log.trace("    Target name = " + str);
        }
        String property2 = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        Class<?> clsDefinePropertyType = definePropertyType(property, str, property2);
        if (clsDefinePropertyType != null) {
            invokeSetter(property, property2, key, index, convert(clsDefinePropertyType, index, obj2, str2));
        }
    }

    public String getIndexedProperty(Object obj, String str, int i, String str2) throws NoSuchMethodException, InvocationTargetException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str, i), str2);
    }

    public String getMappedProperty(Object obj, String str, String str2, String str3) throws NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str, str2), str3);
    }

    public LocaleBeanUtilsBean(LocaleConvertUtilsBean localeConvertUtilsBean) {
        this.log = LogFactory.getLog((Class<?>) LocaleBeanUtilsBean.class);
        this.localeConvertUtils = localeConvertUtilsBean;
    }

    public String getIndexedProperty(Object obj, String str, String str2) {
        return getLocaleConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str), str2);
    }

    public LocaleBeanUtilsBean(LocaleConvertUtilsBean localeConvertUtilsBean, ConvertUtilsBean convertUtilsBean, PropertyUtilsBean propertyUtilsBean) {
        super(convertUtilsBean, propertyUtilsBean);
        this.log = LogFactory.getLog((Class<?>) LocaleBeanUtilsBean.class);
        this.localeConvertUtils = localeConvertUtilsBean;
    }

    public Object convert(Class<?> cls, int i, Object obj, String str) {
        if (this.log.isTraceEnabled()) {
            this.log.trace("Converting value '" + obj + "' to type:" + cls);
        }
        if (cls.isArray() && i < 0) {
            if (obj instanceof String) {
                return getLocaleConvertUtils().convert(new String[]{(String) obj}, cls, str);
            }
            if (obj instanceof String[]) {
                return getLocaleConvertUtils().convert((String[]) obj, cls, str);
            }
        } else if (cls.isArray()) {
            if (obj instanceof String) {
                return getLocaleConvertUtils().convert((String) obj, cls.getComponentType(), str);
            }
            if (obj instanceof String[]) {
                return getLocaleConvertUtils().convert(((String[]) obj)[0], cls.getComponentType(), str);
            }
        } else {
            if (obj instanceof String) {
                return getLocaleConvertUtils().convert((String) obj, cls, str);
            }
            if (obj instanceof String[]) {
                return getLocaleConvertUtils().convert(((String[]) obj)[0], cls, str);
            }
        }
        return obj;
    }
}
