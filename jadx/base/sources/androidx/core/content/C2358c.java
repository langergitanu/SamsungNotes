package androidx.core.content;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: renamed from: androidx.core.content.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2358c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1268a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1269b;

    public /* synthetic */ C2358c(Object obj, int i) {
        this.f1268a = i;
        this.f1269b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1268a) {
            case 0:
                return ((ComponentName) this.f1269b).equals((ComponentName) obj);
            default:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) this.f1269b, (Uri) obj);
        }
    }
}
