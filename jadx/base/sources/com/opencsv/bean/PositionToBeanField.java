package com.opencsv.bean;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PositionToBeanField<T> extends AbstractFieldMapEntry<String, Integer, T> implements Iterable<FieldMapByPositionEntry<T>> {
    private final String initializer;
    private final List<Range<Integer>> ranges;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PositionIterator implements Iterator<FieldMapByPositionEntry<T>> {
        private Range<Integer> currentRange;
        private int position;
        private ListIterator<Range<Integer>> rangeIterator;

        public PositionIterator() {
            if (PositionToBeanField.this.ranges.isEmpty()) {
                this.position = -1;
                return;
            }
            ListIterator<Range<Integer>> listIterator = PositionToBeanField.this.ranges.listIterator();
            this.rangeIterator = listIterator;
            Range<Integer> next = listIterator.next();
            this.currentRange = next;
            this.position = next.getMinimum().intValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position != -1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public FieldMapByPositionEntry<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            FieldMapByPositionEntry<T> fieldMapByPositionEntry = new FieldMapByPositionEntry<>(this.position, PositionToBeanField.this.field);
            if (this.position != this.currentRange.getMaximum().intValue() && Integer.MAX_VALUE != this.currentRange.getMaximum().intValue()) {
                this.position++;
                return fieldMapByPositionEntry;
            }
            if (!this.rangeIterator.hasNext()) {
                this.position = -1;
                return fieldMapByPositionEntry;
            }
            Range<Integer> next = this.rangeIterator.next();
            this.currentRange = next;
            this.position = next.getMinimum().intValue();
            return fieldMapByPositionEntry;
        }
    }

    public PositionToBeanField(String str, int i, BeanField<T, Integer> beanField, Locale locale) {
        Range<Integer> rangeM14659is;
        boolean z;
        super(beanField, locale);
        this.initializer = str;
        this.ranges = new LinkedList();
        if (StringUtils.isBlank(str)) {
            throw new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.range.definition"), str));
        }
        String[] strArrSplit = str.split(",");
        try {
            int length = strArrSplit.length;
            int i2 = 0;
            int i4 = 0;
            while (i4 < length) {
                String str2 = strArrSplit[i4];
                if (StringUtils.isNotEmpty(str2)) {
                    boolean z2 = true;
                    if (str2.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                        String[] strArrSplit2 = str2.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, 2);
                        Integer numValueOf = StringUtils.isEmpty(strArrSplit2[i2]) ? Integer.valueOf(i2) : Integer.valueOf(strArrSplit2[i2].trim());
                        Integer numValueOf2 = Integer.valueOf(i);
                        if (strArrSplit2.length == 2 && StringUtils.isNotEmpty(strArrSplit2[1])) {
                            numValueOf2 = Integer.valueOf(strArrSplit2[1].trim());
                        }
                        rangeM14659is = Range.m14661of(numValueOf, numValueOf2.intValue() >= i ? numValueOf.intValue() >= i ? numValueOf : Integer.valueOf(i) : numValueOf2);
                    } else {
                        rangeM14659is = Range.m14659is(Integer.valueOf(str2));
                    }
                    ListIterator<Range<Integer>> listIterator = this.ranges.listIterator();
                    boolean z3 = false;
                    while (listIterator.hasNext() && !z3) {
                        Range<Integer> next = listIterator.next();
                        if (next.containsRange(rangeM14659is)) {
                            z = z2;
                            z3 = z;
                        } else if (next.isOverlappedBy(rangeM14659is)) {
                            z = z2;
                            rangeM14659is = Range.m14661of(Integer.valueOf(Math.min(next.getMinimum().intValue(), rangeM14659is.getMinimum().intValue())), Integer.valueOf(Math.max(next.getMaximum().intValue(), rangeM14659is.getMaximum().intValue())));
                            listIterator.remove();
                        } else {
                            z = z2;
                            if (next.getMaximum().intValue() + 1 == rangeM14659is.getMinimum().intValue()) {
                                rangeM14659is = Range.m14661of(next.getMinimum(), rangeM14659is.getMaximum());
                            } else if (rangeM14659is.getMaximum().intValue() + 1 == next.getMinimum().intValue()) {
                                rangeM14659is = Range.m14661of(rangeM14659is.getMinimum(), next.getMaximum());
                            }
                        }
                        z2 = z;
                    }
                    if (!z3) {
                        this.ranges.add(rangeM14659is);
                    }
                }
                i4++;
                i2 = 0;
            }
        } catch (NumberFormatException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.range.definition"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$contains$0(Integer num, Range range) {
        return range.contains(num);
    }

    public void attenuateRanges(int i) {
        ListIterator<Range<Integer>> listIterator = this.ranges.listIterator();
        while (listIterator.hasNext()) {
            Range<Integer> next = listIterator.next();
            if (next.getMaximum().intValue() > i) {
                if (next.getMinimum().intValue() > i) {
                    listIterator.set(Range.m14659is(next.getMinimum()));
                } else {
                    listIterator.set(Range.m14661of(next.getMinimum(), Integer.valueOf(i)));
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<FieldMapByPositionEntry<T>> iterator() {
        return new PositionIterator();
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public boolean contains(Integer num) {
        return this.ranges.stream().anyMatch(new C6632o(num, 6));
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public String getInitializer() {
        return this.initializer;
    }
}
