package androidx.window.embedding;

import android.util.Pair;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.lang3.reflect.MethodUtils;

/* JADX INFO: renamed from: androidx.window.embedding.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C4015c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1714a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1715b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1716c;

    public /* synthetic */ C4015c(Object obj, Object obj2, int i) {
        this.f1714a = i;
        this.f1715b = obj;
        this.f1716c = obj2;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1714a) {
            case 0:
                return EmbeddingAdapter.m22067translateActivityPairPredicates$lambda1((EmbeddingAdapter) this.f1715b, (Set) this.f1716c, (Pair) obj);
            case 1:
                return EmbeddingAdapter.m22066translateActivityIntentPredicates$lambda3((EmbeddingAdapter) this.f1715b, (Set) this.f1716c, (Pair) obj);
            default:
                return MethodUtils.lambda$getMatchingAccessibleMethod$0((String) this.f1715b, (Class[]) this.f1716c, (Method) obj);
        }
    }
}
