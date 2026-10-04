package com.opencsv.bean;

import com.opencsv.bean.FuzzyMappingStrategy;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.lang3.Range;

/* JADX INFO: renamed from: com.opencsv.bean.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6632o implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3694a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3695b;

    public /* synthetic */ C6632o(Object obj, int i) {
        this.f3694a = i;
        this.f3695b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f3694a) {
            case 0:
                return FuzzyMappingStrategy.lambda$captureHeader$3((FuzzyMappingStrategy.FuzzyComparison) this.f3695b, (FuzzyMappingStrategy.FuzzyComparison) obj);
            case 1:
                return AbstractFieldMap.lambda$get$0((Comparable) this.f3695b, (ComplexFieldMapEntry) obj);
            case 2:
                return ((Field) this.f3695b).isAnnotationPresent((Class) obj);
            case 3:
                return AbstractMappingStrategy.lambda$null$3((Map.Entry) this.f3695b, (Class) obj);
            case 4:
                return ((ComplexFieldMapEntry) this.f3695b).contains((String) obj);
            case 5:
                return ((FuzzyMappingStrategy) this.f3695b).lambda$captureHeader$0((String) obj);
            default:
                return PositionToBeanField.lambda$contains$0((Integer) this.f3695b, (Range) obj);
        }
    }
}
