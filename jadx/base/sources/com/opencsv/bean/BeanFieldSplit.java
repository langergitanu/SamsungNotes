package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BeanFieldSplit<T, I> extends AbstractBeanField<T, I> {
    private final Pattern capture;
    private final Class<? extends Collection> collectionType;
    private final Class<?> elementType;
    private final Pattern splitOn;
    private final String writeDelimiter;
    private final String writeFormat;

    public BeanFieldSplit(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter, String str, String str2, Class<? extends Collection> cls2, Class<?> cls3, String str3, String str4) {
        super(cls, field, z, locale, csvConverter);
        this.writeDelimiter = str2;
        this.writeFormat = str4;
        this.elementType = cls3;
        if (!Collection.class.isAssignableFrom(field.getType())) {
            throw new CsvBadConverterException(BeanFieldSplit.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.collection.type"), field.getType().toString()));
        }
        this.splitOn = OpencsvUtils.compilePattern(str, 0, BeanFieldSplit.class, this.errorLocale);
        this.capture = OpencsvUtils.compilePatternAtLeastOneGroup(str3, 0, BeanFieldSplit.class, this.errorLocale);
        OpencsvUtils.verifyFormatString(str4, BeanFieldSplit.class, this.errorLocale);
        Class<?> type = field.getType();
        if (!type.isInterface()) {
            this.collectionType = field.getType();
        } else if (!cls2.isInterface()) {
            this.collectionType = cls2;
        } else if (Collection.class.equals(type) || List.class.equals(type)) {
            this.collectionType = ArrayList.class;
        } else if (Set.class.equals(type)) {
            if (type.isEnum()) {
                this.collectionType = EnumSet.class;
            } else {
                this.collectionType = HashSet.class;
            }
        } else if (SortedSet.class.equals(type) || NavigableSet.class.equals(type)) {
            this.collectionType = TreeSet.class;
        } else if (Queue.class.equals(type) || Deque.class.equals(type)) {
            this.collectionType = ArrayDeque.class;
        } else if (Bag.class.equals(type)) {
            this.collectionType = HashBag.class;
        } else {
            if (!SortedBag.class.equals(type)) {
                this.collectionType = null;
                throw new CsvBadConverterException(BeanFieldSplit.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.collection.type"), cls2.toString()));
            }
            this.collectionType = TreeBag.class;
        }
        if (!field.getType().isAssignableFrom(this.collectionType)) {
            throw new CsvBadConverterException(BeanFieldSplit.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("unassignable.collection.type"), cls2.getName(), field.getType().getName()));
        }
    }

    @Override // com.opencsv.bean.AbstractBeanField
    public Object convert(String str) {
        try {
            Collection collectionNoneOf = this.collectionType.equals(EnumSet.class) ? EnumSet.noneOf(this.elementType) : this.collectionType.getDeclaredConstructor(null).newInstance(null);
            for (String strGroup : str == null ? ArrayUtils.EMPTY_STRING_ARRAY : this.splitOn.split(str)) {
                Pattern pattern = this.capture;
                if (pattern != null) {
                    Matcher matcher = pattern.matcher(strGroup);
                    if (matcher.matches()) {
                        strGroup = matcher.group(1);
                    }
                }
                collectionNoneOf.add(this.converter.convertToRead(strGroup));
            }
            return collectionNoneOf;
        } catch (IllegalAccessException e) {
            e = e;
            CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("collection.cannot.be.instantiated"), this.collectionType.getCanonicalName()));
            csvBeanIntrospectionException.initCause(e);
            throw csvBeanIntrospectionException;
        } catch (IllegalArgumentException e2) {
            e = e2;
            CsvBeanIntrospectionException csvBeanIntrospectionException2 = new CsvBeanIntrospectionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("collection.cannot.be.instantiated"), this.collectionType.getCanonicalName()));
            csvBeanIntrospectionException2.initCause(e);
            throw csvBeanIntrospectionException2;
        } catch (InstantiationException e3) {
            e = e3;
            CsvBeanIntrospectionException csvBeanIntrospectionException22 = new CsvBeanIntrospectionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("collection.cannot.be.instantiated"), this.collectionType.getCanonicalName()));
            csvBeanIntrospectionException22.initCause(e);
            throw csvBeanIntrospectionException22;
        } catch (NoSuchMethodException e5) {
            e = e5;
            CsvBeanIntrospectionException csvBeanIntrospectionException222 = new CsvBeanIntrospectionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("collection.cannot.be.instantiated"), this.collectionType.getCanonicalName()));
            csvBeanIntrospectionException222.initCause(e);
            throw csvBeanIntrospectionException222;
        } catch (SecurityException e6) {
            e = e6;
            CsvBeanIntrospectionException csvBeanIntrospectionException2222 = new CsvBeanIntrospectionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("collection.cannot.be.instantiated"), this.collectionType.getCanonicalName()));
            csvBeanIntrospectionException2222.initCause(e);
            throw csvBeanIntrospectionException2222;
        } catch (InvocationTargetException e7) {
            e = e7;
            CsvBeanIntrospectionException csvBeanIntrospectionException22222 = new CsvBeanIntrospectionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("collection.cannot.be.instantiated"), this.collectionType.getCanonicalName()));
            csvBeanIntrospectionException22222.initCause(e);
            throw csvBeanIntrospectionException22222;
        }
    }

    @Override // com.opencsv.bean.AbstractBeanField
    public String convertToWrite(Object obj) {
        if (obj == null) {
            return "";
        }
        Collection collection = (Collection) obj;
        String[] strArr = new String[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = this.converter.convertToWrite(it.next());
            if (StringUtils.isNotEmpty(this.writeFormat) && StringUtils.isNotEmpty(strArr[i])) {
                strArr[i] = String.format(this.writeFormat, strArr[i]);
            }
            i++;
        }
        return StringUtils.join(strArr, this.writeDelimiter);
    }

    @Override // com.opencsv.bean.AbstractBeanField
    public boolean isFieldEmptyForWrite(Object obj) {
        return super.isFieldEmptyForWrite(obj) || ((Collection) obj).isEmpty();
    }
}
