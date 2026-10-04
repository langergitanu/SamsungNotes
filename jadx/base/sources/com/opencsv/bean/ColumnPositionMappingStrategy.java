package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ColumnPositionMappingStrategy<T> extends AbstractMappingStrategy<String, Integer, ComplexFieldMapEntry<String, Integer, T>, T> {
    private FieldMapByPosition<T> fieldMap;
    private Comparator<Integer> writeOrder;
    private boolean columnsExplicitlySet = false;
    private Integer[] columnIndexForWriting = null;

    private void registerBinding(CsvBindByPosition csvBindByPosition, Class<?> cls, Field field) {
        String strLocale = csvBindByPosition.locale();
        this.fieldMap.put(Integer.valueOf(csvBindByPosition.position()), new BeanFieldSingleValue(cls, field, csvBindByPosition.required(), this.errorLocale, determineConverter(field, field.getType(), strLocale, csvBindByPosition.writeLocaleEqualsReadLocale() ? strLocale : csvBindByPosition.writeLocale(), null), csvBindByPosition.capture(), csvBindByPosition.format()));
    }

    private void registerCustomBinding(CsvCustomBindByPosition csvCustomBindByPosition, Class<?> cls, Field field) {
        BeanField<T, Integer> beanFieldInstantiateCustomConverter = instantiateCustomConverter(csvCustomBindByPosition.converter());
        beanFieldInstantiateCustomConverter.setType(cls);
        beanFieldInstantiateCustomConverter.setField(field);
        beanFieldInstantiateCustomConverter.setRequired(csvCustomBindByPosition.required());
        this.fieldMap.put(Integer.valueOf(csvCustomBindByPosition.position()), beanFieldInstantiateCustomConverter);
    }

    private void registerJoinBinding(CsvBindAndJoinByPosition csvBindAndJoinByPosition, Class<?> cls, Field field) {
        String strLocale = csvBindAndJoinByPosition.locale();
        this.fieldMap.putComplex(csvBindAndJoinByPosition.position(), (BeanField) new BeanFieldJoinIntegerIndex(cls, field, csvBindAndJoinByPosition.required(), this.errorLocale, determineConverter(field, csvBindAndJoinByPosition.elementType(), strLocale, csvBindAndJoinByPosition.writeLocaleEqualsReadLocale() ? strLocale : csvBindAndJoinByPosition.writeLocale(), csvBindAndJoinByPosition.converter()), csvBindAndJoinByPosition.mapType(), csvBindAndJoinByPosition.capture(), csvBindAndJoinByPosition.format()));
    }

    private void registerSplitBinding(CsvBindAndSplitByPosition csvBindAndSplitByPosition, Class<?> cls, Field field) {
        String strLocale = csvBindAndSplitByPosition.locale();
        String strWriteLocale = csvBindAndSplitByPosition.writeLocaleEqualsReadLocale() ? strLocale : csvBindAndSplitByPosition.writeLocale();
        Class<?> clsElementType = csvBindAndSplitByPosition.elementType();
        this.fieldMap.put(Integer.valueOf(csvBindAndSplitByPosition.position()), new BeanFieldSplit(cls, field, csvBindAndSplitByPosition.required(), this.errorLocale, determineConverter(field, clsElementType, strLocale, strWriteLocale, csvBindAndSplitByPosition.converter()), csvBindAndSplitByPosition.splitOn(), csvBindAndSplitByPosition.writeDelimiter(), csvBindAndSplitByPosition.collectionType(), clsElementType, csvBindAndSplitByPosition.capture(), csvBindAndSplitByPosition.format()));
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.unset"));
        }
        this.fieldMap.setMaxIndex(ArrayUtils.nullToEmpty(cSVReader.peek()).length - 1);
        if (this.columnsExplicitlySet) {
            return;
        }
        this.headerIndex.clear();
        for (FieldMapByPositionEntry<T> fieldMapByPositionEntry : this.fieldMap) {
            Field field = fieldMapByPositionEntry.getField().getField();
            if (field.getAnnotation(CsvCustomBindByPosition.class) != null || field.getAnnotation(CsvBindAndSplitByPosition.class) != null || field.getAnnotation(CsvBindAndJoinByPosition.class) != null || field.getAnnotation(CsvBindByPosition.class) != null) {
                this.headerIndex.put(fieldMapByPositionEntry.getPosition(), field.getName().toUpperCase().trim());
            }
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public BeanField<T, Integer> findField(int i) {
        Integer[] numArr = this.columnIndexForWriting;
        if (numArr == null) {
            return this.fieldMap.get(Integer.valueOf(i));
        }
        if (i < numArr.length) {
            return this.fieldMap.get(numArr[i]);
        }
        return null;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String findHeader(int i) {
        return Integer.toString(i);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy, com.opencsv.bean.MappingStrategy
    public String[] generateHeader(T t) {
        Integer[] numArr = new Integer[super.generateHeader(t).length];
        this.columnIndexForWriting = numArr;
        Arrays.setAll(numArr, new C6622e());
        Arrays.sort(this.columnIndexForWriting, this.writeOrder);
        return ArrayUtils.EMPTY_STRING_ARRAY;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public Set<Class<? extends Annotation>> getBindingAnnotations() {
        return new HashSet(Arrays.asList(CsvBindByPositions.class, CsvCustomBindByPositions.class, CsvBindAndJoinByPositions.class, CsvBindAndSplitByPositions.class, CsvBindByPosition.class, CsvCustomBindByPosition.class, CsvBindAndJoinByPosition.class, CsvBindAndSplitByPosition.class));
    }

    public String[] getColumnMapping() {
        return this.headerIndex.getHeaderIndex();
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String getColumnName(int i) {
        return this.headerIndex.getByPosition(i);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public FieldMap<String, Integer, ? extends ComplexFieldMapEntry<String, Integer, T>, T> getFieldMap() {
        return this.fieldMap;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void initializeFieldMap() {
        FieldMapByPosition<T> fieldMapByPosition = new FieldMapByPosition<>(this.errorLocale);
        this.fieldMap = fieldMapByPosition;
        fieldMapByPosition.setColumnOrderOnWrite(this.writeOrder);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void loadAnnotatedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        for (Map.Entry<Class<?>, Field> entry : listValuedMap.entries()) {
            Class<?> key = entry.getKey();
            Field value = entry.getValue();
            if (value.isAnnotationPresent(CsvCustomBindByPosition.class) || value.isAnnotationPresent(CsvCustomBindByPositions.class)) {
                CsvCustomBindByPosition csvCustomBindByPosition = (CsvCustomBindByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvCustomBindByPosition.class), new C6617b(3));
                if (csvCustomBindByPosition != null) {
                    registerCustomBinding(csvCustomBindByPosition, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndSplitByPosition.class) || value.isAnnotationPresent(CsvBindAndSplitByPositions.class)) {
                CsvBindAndSplitByPosition csvBindAndSplitByPosition = (CsvBindAndSplitByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndSplitByPosition.class), new C6617b(4));
                if (csvBindAndSplitByPosition != null) {
                    registerSplitBinding(csvBindAndSplitByPosition, key, value);
                }
            } else if (value.isAnnotationPresent(CsvBindAndJoinByPosition.class) || value.isAnnotationPresent(CsvBindAndJoinByPositions.class)) {
                CsvBindAndJoinByPosition csvBindAndJoinByPosition = (CsvBindAndJoinByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindAndJoinByPosition.class), new C6617b(5));
                if (csvBindAndJoinByPosition != null) {
                    registerJoinBinding(csvBindAndJoinByPosition, key, value);
                }
            } else {
                CsvBindByPosition csvBindByPosition = (CsvBindByPosition) selectAnnotationForProfile(value.getAnnotationsByType(CsvBindByPosition.class), new C6617b(6));
                if (csvBindByPosition != null) {
                    registerBinding(csvBindByPosition, key, value);
                }
            }
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        for (Map.Entry<Class<?>, Field> entry : listValuedMap.entries()) {
            Class<?> key = entry.getKey();
            Field value = entry.getValue();
            CsvConverter csvConverterDetermineConverter = determineConverter(value, value.getType(), null, null, null);
            int[] byName = this.headerIndex.getByName(value.getName());
            if (byName.length != 0) {
                this.fieldMap.put(Integer.valueOf(byName[0]), new BeanFieldSingleValue(key, value, false, this.errorLocale, csvConverterDetermineConverter, null, null));
            }
        }
    }

    public void setColumnMapping(String... strArr) {
        if (strArr != null) {
            this.headerIndex.initializeHeaderIndex(strArr);
        } else {
            this.headerIndex.clear();
        }
        this.columnsExplicitlySet = true;
        if (getType() != null) {
            loadFieldMap();
        }
    }

    public void setColumnOrderOnWrite(Comparator<Integer> comparator) {
        this.writeOrder = comparator;
        FieldMapByPosition<T> fieldMapByPosition = this.fieldMap;
        if (fieldMapByPosition != null) {
            fieldMapByPosition.setColumnOrderOnWrite(comparator);
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void verifyLineLength(int i) throws CsvRequiredFieldEmptyException {
        if (this.headerIndex.isEmpty()) {
            return;
        }
        StringBuilder sb = null;
        while (i <= this.headerIndex.findMaxIndex()) {
            BeanField<T, Integer> beanFieldFindField = findField(i);
            if (beanFieldFindField != null && beanFieldFindField.isRequired()) {
                if (sb == null) {
                    sb = new StringBuilder(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("multiple.required.field.empty"));
                }
                sb.append(' ');
                sb.append(beanFieldFindField.getField().getName());
            }
            i++;
        }
        if (sb != null) {
            throw new CsvRequiredFieldEmptyException(this.type, sb.toString());
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public Integer chooseMultivaluedFieldIndexFromHeaderIndex(int i) {
        return Integer.valueOf(i);
    }
}
