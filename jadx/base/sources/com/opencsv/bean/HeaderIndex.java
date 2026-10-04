package com.opencsv.bean;

import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderIndex {
    private String[] positionToHeader = ArrayUtils.EMPTY_STRING_ARRAY;
    private MultiValuedMap<String, Integer> headerToPosition = new ArrayListValuedHashMap();

    public void clear() {
        this.positionToHeader = ArrayUtils.EMPTY_STRING_ARRAY;
        this.headerToPosition.clear();
    }

    public int findMaxIndex() {
        return this.positionToHeader.length - 1;
    }

    public int[] getByName(String str) {
        Collection<Integer> collection = this.headerToPosition.get(str);
        return collection != null ? ArrayUtils.toPrimitive((Integer[]) collection.toArray(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY)) : ArrayUtils.EMPTY_INT_ARRAY;
    }

    public String getByPosition(int i) {
        String[] strArr = this.positionToHeader;
        if (i < strArr.length) {
            return strArr[i];
        }
        return null;
    }

    public String[] getHeaderIndex() {
        return (String[]) ArrayUtils.clone(this.positionToHeader);
    }

    public int getHeaderIndexLength() {
        return this.positionToHeader.length;
    }

    public void initializeHeaderIndex(String[] strArr) {
        this.positionToHeader = strArr != null ? (String[]) ArrayUtils.clone(strArr) : ArrayUtils.EMPTY_STRING_ARRAY;
        this.headerToPosition.clear();
        for (int i = 0; i < this.positionToHeader.length; i++) {
            this.headerToPosition.put(strArr[i], Integer.valueOf(i));
        }
    }

    public boolean isEmpty() {
        return this.positionToHeader.length == 0;
    }

    public void put(int i, String str) {
        String[] strArr = this.positionToHeader;
        if (i >= strArr.length) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, i + 1);
            this.positionToHeader = strArr2;
            strArr2[i] = str;
        }
        this.headerToPosition.put(str, Integer.valueOf(i));
    }
}
