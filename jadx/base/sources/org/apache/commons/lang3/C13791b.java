package org.apache.commons.lang3;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import org.apache.commons.lang3.AnnotationUtils;

/* JADX INFO: renamed from: org.apache.commons.lang3.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13791b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9766a;

    public /* synthetic */ C13791b(int i) {
        this.f9766a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f9766a) {
            case 0:
                return AnnotationUtils.C137821.lambda$getShortClassName$0((Class) obj);
            case 1:
                return ArrayUtils.lambda$subarray$12(((Integer) obj).intValue());
            case 2:
                return ArrayUtils.lambda$subarray$10(((Integer) obj).intValue());
            case 3:
                return ArrayUtils.lambda$increment$4(obj);
            case 4:
                return ArrayUtils.lambda$subarray$11(((Integer) obj).intValue());
            case 5:
                return ArrayUtils.lambda$subarray$9(((Integer) obj).intValue());
            case 6:
                return ArrayUtils.lambda$subarray$7(((Integer) obj).intValue());
            case 7:
                return ArrayUtils.lambda$subarray$13(((Integer) obj).intValue());
            case 8:
                return ArrayUtils.lambda$subarray$6(((Integer) obj).intValue());
            case 9:
                return ArrayUtils.lambda$subarray$8(((Integer) obj).intValue());
            case 10:
                return (String) ((Map.Entry) obj).getValue();
            case 11:
                return ClassUtils.lambda$convertClassesToClassNames$2((Class) obj);
            case 12:
                return ((Enum) obj).name();
            case 13:
                return ((Locale) obj).toString();
            case 14:
                return RuntimeEnvironment.lambda$readFile$1((String) obj);
            case 15:
                return RuntimeEnvironment.lambda$readFile$2((String[]) obj);
            case 16:
                return ObjectUtils.toString(obj);
            case 17:
                return ((ThreadGroup) obj).getName();
            default:
                return ((Thread) obj).getName();
        }
    }
}
