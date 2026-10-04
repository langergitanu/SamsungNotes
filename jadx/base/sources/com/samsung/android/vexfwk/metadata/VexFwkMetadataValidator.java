package com.samsung.android.vexfwk.metadata;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt__GroupingJVMKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006H\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataValidator;", "", "()V", SearchConstants.TargetContents.TAG, "", "getDuplicates", "", "T", XmlErrorCodes.LIST, "validate", "", "validateKeyMatching", "validateKeyUniqueness", "validateTagMatched", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkMetadataValidator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkMetadataValidator.kt\ncom/samsung/android/vexfwk/metadata/VexFwkMetadataValidator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1536#2:60\n1549#2:68\n1620#2,3:69\n2634#2:72\n1549#2:74\n1620#2,3:75\n2634#2:78\n2624#2,3:80\n526#3:61\n511#3,6:62\n1#4:73\n1#4:79\n*S KotlinDebug\n*F\n+ 1 VexFwkMetadataValidator.kt\ncom/samsung/android/vexfwk/metadata/VexFwkMetadataValidator\n*L\n34#1:60\n37#1:68\n37#1:69,3\n38#1:72\n41#1:74\n41#1:75,3\n42#1:78\n49#1:80,3\n34#1:61\n34#1:62,6\n38#1:73\n42#1:79\n*E\n"})
public final class VexFwkMetadataValidator {

    @NotNull
    public static final VexFwkMetadataValidator INSTANCE = new VexFwkMetadataValidator();

    @NotNull
    private static final String TAG = "VexFwkMetadataValidator";

    private VexFwkMetadataValidator() {
    }

    private final <T> List<T> getDuplicates(List<? extends T> list) {
        final List<? extends T> list2 = list;
        Map mapEachCount = GroupingKt__GroupingJVMKt.eachCount(new Grouping<T, T>() { // from class: com.samsung.android.vexfwk.metadata.VexFwkMetadataValidator$getDuplicates$$inlined$groupingBy$1
            @Override // kotlin.collections.Grouping
            public T keyOf(T element) {
                return element;
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<T> sourceIterator() {
                return list2.iterator();
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapEachCount.entrySet()) {
            if (((Number) entry.getValue()).intValue() > 1) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return CollectionsKt.toList(linkedHashMap.keySet());
    }

    private final boolean validateKeyUniqueness() {
        VexFwkMetadataKey.Companion companion = VexFwkMetadataKey.INSTANCE;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(companion));
        Iterator<VexFwkMetadataKey<?>> it = companion.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        List duplicates = getDuplicates(arrayList);
        Iterator it2 = duplicates.iterator();
        while (it2.hasNext()) {
            AbstractC2322a.m1636z("Duplicate name found: ", (String) it2.next(), TAG);
        }
        boolean zIsEmpty = duplicates.isEmpty();
        VexFwkMetadataKey.Companion companion2 = VexFwkMetadataKey.INSTANCE;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(companion2));
        Iterator<VexFwkMetadataKey<?>> it3 = companion2.iterator();
        while (it3.hasNext()) {
            arrayList2.add(Integer.valueOf(it3.next().getTag()));
        }
        List duplicates2 = getDuplicates(arrayList2);
        Iterator it4 = duplicates2.iterator();
        while (it4.hasNext()) {
            AbstractC0541b.m758D(((Number) it4.next()).intValue(), "Duplicate name found: ", TAG);
        }
        return zIsEmpty && duplicates2.isEmpty();
    }

    private final boolean validateTagMatched() {
        Iterable<VexFwkMetadataKey> iterable = VexFwkMetadataKey.INSTANCE;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (VexFwkMetadataKey vexFwkMetadataKey : iterable) {
            int tag = VexFwkMetadataNative.INSTANCE.getTag(vexFwkMetadataKey.getName());
            boolean z = tag != vexFwkMetadataKey.getTag();
            if (z) {
                String name = vexFwkMetadataKey.getName();
                int tag2 = vexFwkMetadataKey.getTag();
                StringBuilder sbM780v = AbstractC0541b.m780v("Mismatched tag found: ", tag, name, " (expected: ", ", actual: ");
                sbM780v.append(tag2);
                sbM780v.append(")");
                Log.e(TAG, sbM780v.toString());
            }
            if (z) {
                return false;
            }
        }
        return true;
    }

    public final boolean validate() {
        return validate(false);
    }

    public final boolean validate(boolean validateKeyMatching) {
        Log.d(TAG, "Validating VexFwkMetadataKey...");
        boolean zValidateKeyUniqueness = validateKeyUniqueness();
        if (!zValidateKeyUniqueness) {
            Log.e(TAG, "VexFwkMetadataKey has duplicate keys.");
        }
        boolean zValidateTagMatched = validateKeyMatching ? validateTagMatched() : true;
        if (!zValidateTagMatched) {
            Log.e(TAG, "VexFwkMetadataKey has mismatched tags.");
        }
        return zValidateTagMatched & zValidateKeyUniqueness;
    }
}
