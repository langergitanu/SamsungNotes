package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DateLinkifyHelper {
    public static void pruneOverlaps(ArrayList<DateLinkSpec> arrayList) {
        int i;
        Collections.sort(arrayList, new Comparator<DateLinkSpec>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.link.DateLinkifyHelper.1
            @Override // java.util.Comparator
            public final int compare(DateLinkSpec dateLinkSpec, DateLinkSpec dateLinkSpec2) {
                int i2;
                int i4;
                int i5 = dateLinkSpec.start;
                int i6 = dateLinkSpec2.start;
                if (i5 < i6) {
                    return -1;
                }
                if (i5 <= i6 && (i2 = dateLinkSpec.end) >= (i4 = dateLinkSpec2.end)) {
                    return i2 > i4 ? -1 : 0;
                }
                return 1;
            }
        });
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size - 1) {
            DateLinkSpec dateLinkSpec = arrayList.get(i2);
            int i4 = i2 + 1;
            DateLinkSpec dateLinkSpec2 = arrayList.get(i4);
            int i5 = dateLinkSpec.start;
            int i6 = dateLinkSpec2.start;
            if (i5 <= i6 && (i = dateLinkSpec.end) > i6) {
                int i7 = dateLinkSpec2.end;
                int i8 = (i7 > i && i - i5 <= i7 - i6) ? i - i5 < i7 - i6 ? i2 : -1 : i4;
                if (i8 != -1) {
                    arrayList.remove(i8);
                    size--;
                }
            }
            i2 = i4;
        }
    }
}
