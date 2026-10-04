package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.ComplexFieldMapEntry;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import com.opencsv.exceptions.CsvRecursionException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.lang.Comparable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMappingStrategy<I, K extends Comparable<K>, C extends ComplexFieldMapEntry<I, K, T>, T> implements MappingStrategy<T> {
    private static final Set<Class<?>> FORBIDDEN_CLASSES_FOR_RECURSION = new HashSet(Arrays.asList(Byte.TYPE, Short.TYPE, Integer.TYPE, Float.TYPE, Double.TYPE, Boolean.TYPE, Long.TYPE, Character.TYPE));
    protected RecursiveType recursiveTypeTree;
    protected Class<? extends T> type;
    protected final HeaderIndex headerIndex = new HeaderIndex();
    private MultiValuedMap<Class<?>, Field> ignoredFields = new ArrayListValuedHashMap();
    protected Locale errorLocale = Locale.getDefault();
    protected String profile = "";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RecursiveType {
        private final Map<FieldAccess<Object>, RecursiveType> recursiveMembers = new HashMap();
        private final Class<?> type;

        public RecursiveType(Class<?> cls) {
            this.type = cls;
        }

        public void addRecursiveMember(FieldAccess<Object> fieldAccess, RecursiveType recursiveType) {
            this.recursiveMembers.put(fieldAccess, recursiveType);
        }

        public Map<FieldAccess<Object>, RecursiveType> getRecursiveMembers() {
            return this.recursiveMembers;
        }

        public Class<?> getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: assembleCompleteFieldList, reason: merged with bridge method [inline-methods] */
    public void lambda$assembleCompleteFieldList$1(RecursiveType recursiveType, ListValuedMap<Class<?>, Field> listValuedMap) {
        listValuedMap.putAll(recursiveType.type, filterIgnoredFields(recursiveType.type, FieldUtils.getAllFields(recursiveType.type)));
        recursiveType.getRecursiveMembers().values().forEach(new C6618c(this, listValuedMap, 1));
    }

    private static void createSubordinateBeans(RecursiveType recursiveType, Map<Class<?>, Object> map, Object obj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Map.Entry<FieldAccess<Object>, RecursiveType> entry : recursiveType.getRecursiveMembers().entrySet()) {
            Object field = entry.getKey().getField(obj);
            if (field == null) {
                field = entry.getValue().type.getDeclaredConstructor(null).newInstance(null);
                entry.getKey().setField(obj, field);
            }
            map.put(entry.getValue().getType(), field);
            createSubordinateBeans(entry.getValue(), map, field);
        }
    }

    private static void indexSubordinateBeans(RecursiveType recursiveType, Map<Class<?>, Object> map, Object obj) {
        for (Map.Entry<FieldAccess<Object>, RecursiveType> entry : recursiveType.getRecursiveMembers().entrySet()) {
            Object field = obj == null ? null : entry.getKey().getField(obj);
            map.put(entry.getValue().getType(), field);
            indexSubordinateBeans(entry.getValue(), map, field);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ignoreFields$0(MapIterator mapIterator, Class cls) {
        Field field = (Field) mapIterator.getValue();
        if (cls == null || field == null || !field.getDeclaringClass().isAssignableFrom(cls)) {
            throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("ignore.field.inconsistent"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$null$3(Map.Entry entry, Class cls) {
        return ((Field) entry.getValue()).isAnnotationPresent(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$partitionFields$2(Map.Entry entry) {
        return !((Field) entry.getValue()).isSynthetic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$partitionFields$4(Set set, Map map, Map.Entry entry) {
        if (set.stream().anyMatch(new C6632o(entry, 3))) {
            ((ListValuedMap) map.get(Boolean.TRUE)).put(entry.getKey(), entry.getValue());
        } else {
            ((ListValuedMap) map.get(Boolean.FALSE)).put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setErrorLocale$5(BeanField beanField) {
        beanField.setErrorLocale(this.errorLocale);
    }

    public abstract K chooseMultivaluedFieldIndexFromHeaderIndex(int i);

    public Map<Class<?>, Object> createBean() {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.unset"));
        }
        HashMap map = new HashMap();
        try {
            T tNewInstance = this.type.getDeclaredConstructor(null).newInstance(null);
            map.put(this.type, tNewInstance);
            createSubordinateBeans(this.recursiveTypeTree, map, tNewInstance);
            return map;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("bean.instantiation.impossible"));
            csvBeanIntrospectionException.initCause(e);
            throw csvBeanIntrospectionException;
        }
    }

    public CsvConverter determineConverter(Field field, Class<?> cls, String str, String str2, Class<? extends AbstractCsvConverter> cls2) {
        if (cls2 != null && !cls2.equals(AbstractCsvConverter.class)) {
            try {
                AbstractCsvConverter abstractCsvConverterNewInstance = cls2.getDeclaredConstructor(null).newInstance(null);
                abstractCsvConverterNewInstance.setType(cls);
                abstractCsvConverterNewInstance.setLocale(str);
                abstractCsvConverterNewInstance.setWriteLocale(str2);
                abstractCsvConverterNewInstance.setErrorLocale(this.errorLocale);
                return abstractCsvConverterNewInstance;
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                CsvBadConverterException csvBadConverterException = new CsvBadConverterException(cls2, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("custom.converter.invalid"), cls2.getCanonicalName()));
                csvBadConverterException.initCause(e);
                throw csvBadConverterException;
            }
        }
        if (field.isAnnotationPresent(CsvDate.class) || field.isAnnotationPresent(CsvDates.class)) {
            CsvDate csvDate = (CsvDate) selectAnnotationForProfile(field.getAnnotationsByType(CsvDate.class), new C6617b(1));
            if (csvDate == null) {
                throw new CsvBadConverterException(CsvDate.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("profile.not.found.date"), this.profile));
            }
            String strValue = csvDate.value();
            String strWriteFormat = csvDate.writeFormatEqualsReadFormat() ? strValue : csvDate.writeFormat();
            String strChronology = csvDate.chronology();
            return new ConverterDate(cls, str, str2, this.errorLocale, strValue, strWriteFormat, strChronology, csvDate.writeChronologyEqualsReadChronology() ? strChronology : csvDate.writeChronology());
        }
        if (!field.isAnnotationPresent(CsvNumber.class) && !field.isAnnotationPresent(CsvNumbers.class)) {
            return cls.equals(Currency.class) ? new ConverterCurrency(this.errorLocale) : cls.isEnum() ? new ConverterEnum(cls, str, str2, this.errorLocale) : cls.equals(UUID.class) ? new ConverterUUID(this.errorLocale) : new ConverterPrimitiveTypes(cls, str, str2, this.errorLocale);
        }
        CsvNumber csvNumber = (CsvNumber) selectAnnotationForProfile(field.getAnnotationsByType(CsvNumber.class), new C6617b(2));
        if (csvNumber == null) {
            throw new CsvBadConverterException(CsvNumber.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("profile.not.found.number"), this.profile));
        }
        String strValue2 = csvNumber.value();
        return new ConverterNumber(cls, str, str2, this.errorLocale, strValue2, csvNumber.writeFormatEqualsReadFormat() ? strValue2 : csvNumber.writeFormat(), csvNumber.roundingMode());
    }

    public List<Field> filterIgnoredFields(Class<?> cls, Field[] fieldArr) {
        LinkedList linkedList = new LinkedList();
        for (Field field : fieldArr) {
            CsvIgnore csvIgnore = (CsvIgnore) field.getAnnotation(CsvIgnore.class);
            Set setEmptySet = csvIgnore == null ? SetUtils.emptySet() : new HashSet(Arrays.asList(csvIgnore.profiles()));
            if (!this.ignoredFields.containsMapping(cls, field) && !setEmptySet.contains(this.profile) && !setEmptySet.contains("")) {
                linkedList.add(field);
            }
        }
        return linkedList;
    }

    public abstract BeanField<T, K> findField(int i);

    public abstract String findHeader(int i);

    @Override // com.opencsv.bean.MappingStrategy
    public String[] generateHeader(T t) {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.before.header"));
        }
        if (!this.headerIndex.isEmpty()) {
            return this.headerIndex.getHeaderIndex();
        }
        String[] strArrGenerateHeader = getFieldMap().generateHeader(t);
        this.headerIndex.initializeHeaderIndex(strArrGenerateHeader);
        return strArrGenerateHeader;
    }

    public Set<Class<? extends Annotation>> getBindingAnnotations() {
        return Collections.EMPTY_SET;
    }

    public String getColumnName(int i) {
        return this.headerIndex.getByPosition(i);
    }

    public abstract FieldMap<I, K, ? extends C, T> getFieldMap();

    public Class<? extends T> getType() {
        return this.type;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void ignoreFields(MultiValuedMap<Class<?>, Field> multiValuedMap) {
        if (multiValuedMap == null) {
            this.ignoredFields = new ArrayListValuedHashMap();
        } else {
            this.ignoredFields = multiValuedMap;
            MapIterator<Class<?>, Field> mapIterator = multiValuedMap.mapIterator();
            mapIterator.forEachRemaining(new C6618c(this, mapIterator, 0));
        }
        if (this.type != null) {
            loadFieldMap();
        }
    }

    public Map<Class<?>, Object> indexBean(T t) {
        HashMap map = new HashMap();
        map.put(this.type, t);
        indexSubordinateBeans(this.recursiveTypeTree, map, t);
        return map;
    }

    public abstract void initializeFieldMap();

    public BeanField<T, K> instantiateCustomConverter(Class<? extends AbstractBeanField<T, K>> cls) {
        try {
            AbstractBeanField<T, K> abstractBeanFieldNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            abstractBeanFieldNewInstance.setErrorLocale(this.errorLocale);
            return abstractBeanFieldNewInstance;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(cls, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("custom.converter.invalid"), cls.getCanonicalName()));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    public boolean isForbiddenClassForRecursion(Class<?> cls) {
        return FORBIDDEN_CLASSES_FOR_RECURSION.contains(cls);
    }

    public void loadFieldMap() {
        initializeFieldMap();
        this.recursiveTypeTree = loadRecursiveClasses(this.type, new HashSet());
        Map<Boolean, ListValuedMap<Class<?>, Field>> mapPartitionFields = partitionFields();
        Boolean bool = Boolean.TRUE;
        if (mapPartitionFields.get(bool).isEmpty()) {
            loadUnadornedFieldMap(mapPartitionFields.get(Boolean.FALSE));
        } else {
            loadAnnotatedFieldMap(mapPartitionFields.get(bool));
        }
    }

    public RecursiveType loadRecursiveClasses(Class<?> cls, Set<Class<?>> set) {
        if (isForbiddenClassForRecursion(cls)) {
            throw new CsvRecursionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("recursion.on.primitive"), cls);
        }
        if (set.contains(cls)) {
            throw new CsvRecursionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("recursive.type.encountered.twice"), cls.toString()), cls);
        }
        set.add(cls);
        RecursiveType recursiveType = new RecursiveType(cls);
        for (Field field : filterIgnoredFields(cls, FieldUtils.getFieldsWithAnnotation(cls, CsvRecurse.class))) {
            Stream<Class<? extends Annotation>> stream = getBindingAnnotations().stream();
            field.getClass();
            if (stream.anyMatch(new C6632o(field, 2))) {
                throw new CsvRecursionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("recursion.binding.mutually.exclusive"), field.getType());
            }
            recursiveType.addRecursiveMember(new FieldAccess<>(field), loadRecursiveClasses(field.getType(), set));
        }
        return recursiveType;
    }

    public abstract void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap);

    public Map<Boolean, ListValuedMap<Class<?>, Field>> partitionFields() {
        ArrayListValuedHashMap arrayListValuedHashMap = new ArrayListValuedHashMap();
        lambda$assembleCompleteFieldList$1(this.recursiveTypeTree, arrayListValuedHashMap);
        Set<Class<? extends Annotation>> bindingAnnotations = getBindingAnnotations();
        TreeMap treeMap = new TreeMap();
        treeMap.put(Boolean.TRUE, new ArrayListValuedHashMap());
        treeMap.put(Boolean.FALSE, new ArrayListValuedHashMap());
        arrayListValuedHashMap.entries().stream().filter(new C6621d(0)).forEach(new C6618c(bindingAnnotations, treeMap, 2));
        return treeMap;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public T populateNewBean(String[] strArr) throws CsvChainedException, CsvFieldAssignmentException {
        verifyLineLength(strArr.length);
        Map<Class<?>, Object> mapCreateBean = createBean();
        CsvChainedException csvChainedException = null;
        for (int i = 0; i < strArr.length; i++) {
            try {
                setFieldValue(mapCreateBean, strArr[i], i);
            } catch (CsvFieldAssignmentException e) {
                if (csvChainedException != null) {
                    csvChainedException.add(e);
                } else {
                    csvChainedException = new CsvChainedException(e);
                }
            }
        }
        if (csvChainedException == null) {
            return (T) mapCreateBean.get(this.type);
        }
        if (csvChainedException.hasOnlyOneException()) {
            throw csvChainedException.getFirstException();
        }
        throw csvChainedException;
    }

    public <A extends Annotation> A selectAnnotationForProfile(A[] aArr, Function<A, String[]> function) {
        A a = null;
        for (A a3 : aArr) {
            for (String str : function.apply(a3)) {
                if (this.profile.equals(str)) {
                    return a3;
                }
                if ("".equals(str)) {
                    a = a3;
                }
            }
        }
        return a;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        if (getFieldMap() != null) {
            getFieldMap().setErrorLocale(this.errorLocale);
            getFieldMap().values().forEach(new C6616a(this, 2));
        }
    }

    public void setFieldValue(Map<Class<?>, Object> map, String str, int i) {
        BeanField<T, K> beanFieldFindField = findField(i);
        if (beanFieldFindField != null) {
            beanFieldFindField.setFieldValue(map.get(beanFieldFindField.getType()), str, findHeader(i));
        }
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void setProfile(String str) {
        this.profile = StringUtils.defaultString(str);
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void setType(Class<? extends T> cls) {
        this.type = cls;
        loadFieldMap();
    }

    @Override // com.opencsv.bean.MappingStrategy
    public String[] transmuteBean(T t) throws CsvChainedException, CsvFieldAssignmentException {
        int i = 1;
        int iFindMaxIndex = this.headerIndex.findMaxIndex() + 1;
        ArrayList arrayList = new ArrayList(Math.max(iFindMaxIndex, 0));
        try {
            Map<Class<?>, Object> mapIndexBean = indexBean(t);
            CsvChainedException csvChainedException = null;
            int i2 = 0;
            while (i2 < iFindMaxIndex) {
                BeanField<T, K> beanFieldFindField = findField(i2);
                Comparable comparableChooseMultivaluedFieldIndexFromHeaderIndex = chooseMultivaluedFieldIndexFromHeaderIndex(i2);
                String[] strArrWrite = ArrayUtils.EMPTY_STRING_ARRAY;
                if (beanFieldFindField != null) {
                    try {
                        strArrWrite = beanFieldFindField.write(mapIndexBean.get(beanFieldFindField.getType()), comparableChooseMultivaluedFieldIndexFromHeaderIndex);
                    } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
                        if (csvChainedException != null) {
                            csvChainedException.add(e);
                        } else {
                            csvChainedException = new CsvChainedException(e);
                        }
                    }
                }
                if (strArrWrite.length == 0) {
                    arrayList.add("");
                    i2++;
                } else {
                    arrayList.add(StringUtils.defaultString(strArrWrite[0]));
                    int i4 = i2 + 1;
                    BeanField<T, K> beanFieldFindField2 = findField(i4);
                    Comparable comparableChooseMultivaluedFieldIndexFromHeaderIndex2 = chooseMultivaluedFieldIndexFromHeaderIndex(i4);
                    int i5 = i;
                    while (i5 < strArrWrite.length && i4 < iFindMaxIndex && Objects.equals(beanFieldFindField, beanFieldFindField2) && Objects.equals(comparableChooseMultivaluedFieldIndexFromHeaderIndex, comparableChooseMultivaluedFieldIndexFromHeaderIndex2)) {
                        arrayList.add(StringUtils.defaultString(strArrWrite[i5]));
                        i5++;
                        i4 = i2 + i5;
                        beanFieldFindField2 = findField(i4);
                        comparableChooseMultivaluedFieldIndexFromHeaderIndex2 = chooseMultivaluedFieldIndexFromHeaderIndex(i4);
                    }
                    if (i4 < iFindMaxIndex) {
                        BeanField<T, K> beanFieldFindField3 = findField(i4);
                        Comparable comparableChooseMultivaluedFieldIndexFromHeaderIndex3 = chooseMultivaluedFieldIndexFromHeaderIndex(i4);
                        while (Objects.equals(beanFieldFindField, beanFieldFindField3) && Objects.equals(comparableChooseMultivaluedFieldIndexFromHeaderIndex, comparableChooseMultivaluedFieldIndexFromHeaderIndex3) && i4 < iFindMaxIndex) {
                            arrayList.add("");
                            i4++;
                            beanFieldFindField3 = findField(i4);
                            comparableChooseMultivaluedFieldIndexFromHeaderIndex3 = chooseMultivaluedFieldIndexFromHeaderIndex(i4);
                        }
                    }
                    i2 = i4;
                }
                i = 1;
            }
            if (csvChainedException == null) {
                return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
            }
            if (csvChainedException.hasOnlyOneException()) {
                throw csvChainedException.getFirstException();
            }
            throw csvChainedException;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("error.introspecting.beans"));
            csvBeanIntrospectionException.initCause(e2);
            throw csvBeanIntrospectionException;
        }
    }

    public abstract void verifyLineLength(int i);

    public void loadAnnotatedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
    }
}
