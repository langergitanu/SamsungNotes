package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FieldMapByName<T> extends AbstractFieldMap<String, String, RegexToBeanField<T>, T> {
    private Comparator<String> writeOrder;

    public FieldMapByName(Locale locale) {
        super(locale);
        this.writeOrder = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$determineMissingRequiredHeaders$0(Map.Entry entry) {
        return ((BeanField) entry.getValue()).isRequired();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$determineMissingRequiredHeaders$1(RegexToBeanField regexToBeanField) {
        return regexToBeanField.getBeanField().isRequired();
    }

    public List<FieldMapByNameEntry<T>> determineMissingRequiredHeaders(String[] strArr) {
        List<String> list = (List) this.simpleMap.entrySet().stream().filter(new C6621d(1)).map(new C6617b(7)).collect(Collectors.toCollection(new C6628k()));
        List<ComplexFieldMapEntry> list2 = (List) this.complexMapList.stream().filter(new C6621d(2)).collect(Collectors.toList());
        for (String str : strArr) {
            if (!list.remove(str.toUpperCase().trim())) {
                ListIterator listIterator = list2.listIterator();
                boolean z = false;
                while (!z && listIterator.hasNext()) {
                    if (((ComplexFieldMapEntry) listIterator.next()).contains(str)) {
                        listIterator.remove();
                        z = true;
                    }
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            linkedList.add(new FieldMapByNameEntry(str2, (BeanField) this.simpleMap.get(str2), false));
        }
        for (ComplexFieldMapEntry complexFieldMapEntry : list2) {
            linkedList.add(new FieldMapByNameEntry((String) complexFieldMapEntry.getInitializer(), complexFieldMapEntry.getBeanField(), true));
        }
        return linkedList;
    }

    @Override // com.opencsv.bean.FieldMap
    public String[] generateHeader(T t) throws CsvRequiredFieldEmptyException {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList(this.simpleMap.keySet());
        for (C c : this.complexMapList) {
            MultiValuedMap multiValuedMap = (MultiValuedMap) c.getBeanField().getFieldValue(t);
            if (multiValuedMap != null && !multiValuedMap.isEmpty()) {
                arrayList.addAll((Collection) multiValuedMap.entries().stream().map(new C6617b(7)).filter(new C6632o(c, 4)).collect(Collectors.toList()));
            } else if (c.getBeanField().isRequired()) {
                linkedList.add(c.getBeanField().getField());
            }
        }
        if (linkedList.isEmpty()) {
            arrayList.sort(this.writeOrder);
            return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        throw new CsvRequiredFieldEmptyException(t.getClass(), linkedList, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.required.field.absent"), linkedList.stream().map(new C6617b(8)).collect(Collectors.joining(" ")), String.join(" ", arrayList)));
    }

    public void setColumnOrderOnWrite(Comparator<String> comparator) {
        this.writeOrder = comparator;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.opencsv.bean.FieldMap
    public void putComplex(String str, BeanField<T, String> beanField) {
        this.complexMapList.add(new RegexToBeanField(str, beanField, this.errorLocale));
    }
}
