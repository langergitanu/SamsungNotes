package androidx.core.content;

import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* JADX INFO: renamed from: androidx.core.content.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2357b implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1266a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1267b;

    public /* synthetic */ C2357b(String str, int i) {
        this.f1266a = i;
        this.f1267b = str;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1266a) {
            case 0:
                return IntentSanitizer.Builder.lambda$allowExtraOutput$16(this.f1267b, (Uri) obj);
            case 1:
                return this.f1267b.equals((String) obj);
            case 2:
                return IntentSanitizer.Builder.lambda$allowComponentWithPackage$9(this.f1267b, (ComponentName) obj);
            case 3:
                return IntentSanitizer.Builder.lambda$allowDataWithAuthority$8(this.f1267b, (Uri) obj);
            case 4:
                return IntentSanitizer.Builder.lambda$allowClipDataUriWithAuthority$11(this.f1267b, (Uri) obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtraStreamUriWithAuthority$15(this.f1267b, (Uri) obj);
        }
    }
}
