package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: renamed from: androidx.window.embedding.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C4013a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1711a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Set f1712b;

    public /* synthetic */ C4013a(Set set, int i) {
        this.f1711a = i;
        this.f1712b = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1711a) {
            case 0:
                return EmbeddingAdapter.m22069translateIntentPredicates$lambda8(this.f1712b, (Intent) obj);
            case 1:
                return EmbeddingAdapter.m22068translateActivityPredicates$lambda6(this.f1712b, (Activity) obj);
            default:
                return this.f1712b.contains((String) obj);
        }
    }
}
