package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FuzzyMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FuzzyComparison implements Comparable<FuzzyComparison> {
        final Integer distance;
        final Field field;
        final String header;
        final Class<?> type;

        public FuzzyComparison(Integer num, String str, Class<?> cls, Field field) {
            this.distance = num;
            this.header = str;
            this.type = cls;
            this.field = field;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FuzzyComparison) {
                return Objects.equals(this.distance, ((FuzzyComparison) obj).distance);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.distance);
        }

        @Override // java.lang.Comparable
        public int compareTo(FuzzyComparison fuzzyComparison) {
            return Integer.compare(this.distance.intValue(), fuzzyComparison.distance.intValue());
        }
    }

    public FuzzyMappingStrategy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$captureHeader$0(String str) {
        return this.fieldMap.get(str.toUpperCase()) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$captureHeader$2(ListValuedMap listValuedMap, List list, LevenshteinDistance levenshteinDistance, String str) {
        listValuedMap.entries().forEach(new C6631n(list, 0, levenshteinDistance, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$captureHeader$3(FuzzyComparison fuzzyComparison, FuzzyComparison fuzzyComparison2) {
        return StringUtils.equals(fuzzyComparison2.header, fuzzyComparison.header) || Objects.equals(fuzzyComparison2.field, fuzzyComparison.field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$1(List list, LevenshteinDistance levenshteinDistance, String str, Map.Entry entry) {
        list.add(new FuzzyComparison(levenshteinDistance.apply((CharSequence) str.toUpperCase(), (CharSequence) ((Field) entry.getValue()).getName().toUpperCase()), str, (Class) entry.getKey(), (Field) entry.getValue()));
    }

    @Override // com.opencsv.bean.HeaderNameBaseMappingStrategy, com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws CsvRequiredFieldEmptyException {
        super.captureHeader(cSVReader);
        Set set = (Set) Stream.of((Object[]) this.headerIndex.getHeaderIndex()).filter(new C6621d(3)).filter(new C6632o(this, 5)).collect(Collectors.toSet());
        ListValuedMap<Class<?>, Field> listValuedMap = partitionFields().get(Boolean.FALSE);
        LevenshteinDistance defaultInstance = LevenshteinDistance.getDefaultInstance();
        LinkedList linkedList = new LinkedList();
        set.forEach(new C6631n(listValuedMap, linkedList, defaultInstance, 1));
        linkedList.sort(null);
        while (!linkedList.isEmpty()) {
            FuzzyComparison fuzzyComparison = (FuzzyComparison) linkedList.get(0);
            Field field = fuzzyComparison.field;
            this.fieldMap.put(fuzzyComparison.header.toUpperCase(), new BeanFieldSingleValue(fuzzyComparison.type, fuzzyComparison.field, false, this.errorLocale, determineConverter(field, field.getType(), null, null, null), null, null));
            linkedList.removeIf(new C6632o(fuzzyComparison, 0));
        }
    }

    public FuzzyMappingStrategy(boolean z) {
        super(z);
    }

    @Override // com.opencsv.bean.HeaderNameBaseMappingStrategy, com.opencsv.bean.AbstractMappingStrategy
    public void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
    }
}
