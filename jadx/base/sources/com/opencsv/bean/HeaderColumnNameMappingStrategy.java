package com.opencsv.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderColumnNameMappingStrategy<T> extends HeaderNameBaseMappingStrategy<T> {
    public HeaderColumnNameMappingStrategy() {
    }

    private void registerBinding(CsvBindByName csvBindByName, Class<?> cls, Field field) {
        String strTrim = csvBindByName.column().toUpperCase().trim();
        String strLocale = csvBindByName.locale();
        CsvConverter csvConverterDetermineConverter = determineConverter(field, field.getType(), strLocale, csvBindByName.writeLocaleEqualsReadLocale() ? strLocale : csvBindByName.writeLocale(), null);
        if (StringUtils.isEmpty(strTrim)) {
            this.fieldMap.put(field.getName().toUpperCase(), new BeanFieldSingleValue(cls, field, csvBindByName.required(), this.errorLocale, csvConverterDetermineConverter, csvBindByName.capture(), csvBindByName.format()));
        } else {
            this.fieldMap.put(strTrim, new BeanFieldSingleValue(cls, field, csvBindByName.required(), this.errorLocale, csvConverterDetermineConverter, csvBindByName.capture(), csvBindByName.format()));
        }
    }

    private void registerCustomBinding(CsvCustomBindByName csvCustomBindByName, Class<?> cls, Field field) {
        String strTrim = csvCustomBindByName.column().toUpperCase().trim();
        if (StringUtils.isEmpty(strTrim)) {
            strTrim = field.getName().toUpperCase();
        }
        BeanField<T, String> beanFieldInstantiateCustomConverter = instantiateCustomConverter(csvCustomBindByName.converter());
        beanFieldInstantiateCustomConverter.setType(cls);
        beanFieldInstantiateCustomConverter.setField(field);
        beanFieldInstantiateCustomConverter.setRequired(csvCustomBindByName.required());
        this.fieldMap.put(strTrim, beanFieldInstantiateCustomConverter);
    }

    private void registerJoinBinding(CsvBindAndJoinByName csvBindAndJoinByName, Class<?> cls, Field field) {
        String strColumn = csvBindAndJoinByName.column();
        String strLocale = csvBindAndJoinByName.locale();
        CsvConverter csvConverterDetermineConverter = determineConverter(field, csvBindAndJoinByName.elementType(), strLocale, csvBindAndJoinByName.writeLocaleEqualsReadLocale() ? strLocale : csvBindAndJoinByName.writeLocale(), csvBindAndJoinByName.converter());
        if (StringUtils.isEmpty(strColumn)) {
            this.fieldMap.putComplex(field.getName(), (BeanField) new BeanFieldJoinStringIndex(cls, field, csvBindAndJoinByName.required(), this.errorLocale, csvConverterDetermineConverter, csvBindAndJoinByName.mapType(), csvBindAndJoinByName.capture(), csvBindAndJoinByName.format()));
        } else {
            this.fieldMap.putComplex(strColumn, (BeanField) new BeanFieldJoinStringIndex(cls, field, csvBindAndJoinByName.required(), this.errorLocale, csvConverterDetermineConverter, csvBindAndJoinByName.mapType(), csvBindAndJoinByName.capture(), csvBindAndJoinByName.format()));
        }
    }

    private void registerSplitBinding(CsvBindAndSplitByName csvBindAndSplitByName, Class<?> cls, Field field) {
        String strTrim = csvBindAndSplitByName.column().toUpperCase().trim();
        String strLocale = csvBindAndSplitByName.locale();
        String strWriteLocale = csvBindAndSplitByName.writeLocaleEqualsReadLocale() ? strLocale : csvBindAndSplitByName.writeLocale();
        Class<?> clsElementType = csvBindAndSplitByName.elementType();
        CsvConverter csvConverterDetermineConverter = determineConverter(field, clsElementType, strLocale, strWriteLocale, csvBindAndSplitByName.converter());
        if (StringUtils.isEmpty(strTrim)) {
            this.fieldMap.put(field.getName().toUpperCase(), new BeanFieldSplit(cls, field, csvBindAndSplitByName.required(), this.errorLocale, csvConverterDetermineConverter, csvBindAndSplitByName.splitOn(), csvBindAndSplitByName.writeDelimiter(), csvBindAndSplitByName.collectionType(), clsElementType, csvBindAndSplitByName.capture(), csvBindAndSplitByName.format()));
        } else {
            this.fieldMap.put(strTrim, new BeanFieldSplit(cls, field, csvBindAndSplitByName.required(), this.errorLocale, csvConverterDetermineConverter, csvBindAndSplitByName.splitOn(), csvBindAndSplitByName.writeDelimiter(), csvBindAndSplitByName.collectionType(), clsElementType, csvBindAndSplitByName.capture(), csvBindAndSplitByName.format()));
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public Set<Class<? extends Annotation>> getBindingAnnotations() {
        return new HashSet(Arrays.asList(CsvBindByNames.class, CsvCustomBindByNames.class, CsvBindAndSplitByNames.class, CsvBindAndJoinByNames.class, CsvBindByName.class, CsvCustomBindByName.class, CsvBindAndSplitByName.class, CsvBindAndJoinByName.class));
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void loadAnnotatedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        for (Map.Entry<Class<?>, Field> entry : listValuedMap.entries()) {
            Class<?> key = entry.getKey();
            Field value = entry.getValue();
            if (value.isAnnotationPresent(CsvCustomBindByName.class) || value.isAnnotationPresent(CsvCustomBindByNames.class)) {
                CsvCustomBindByName csvCustomBindByName = (CsvCustomBindByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvCustomBindByName.class), new C6617b(9));
                if (csvCustomBindByName != null) {
                    registerCustomBinding(csvCustomBindByName, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndSplitByName.class) || value.isAnnotationPresent(CsvBindAndSplitByNames.class)) {
                CsvBindAndSplitByName csvBindAndSplitByName = (CsvBindAndSplitByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndSplitByName.class), new C6617b(10));
                if (csvBindAndSplitByName != null) {
                    registerSplitBinding(csvBindAndSplitByName, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndJoinByName.class) || value.isAnnotationPresent(CsvBindAndJoinByNames.class)) {
                CsvBindAndJoinByName csvBindAndJoinByName = (CsvBindAndJoinByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndJoinByName.class), new C6617b(11));
                if (csvBindAndJoinByName != null) {
                    registerJoinBinding(csvBindAndJoinByName, key, value);
                }
            } else {
                CsvBindByName csvBindByName = (CsvBindByName) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindByName.class), new C6617b(12));
                if (csvBindByName != null) {
                    registerBinding(csvBindByName, key, value);
                }
            }
        }
    }

    public HeaderColumnNameMappingStrategy(boolean z) {
        super(z);
    }
}
