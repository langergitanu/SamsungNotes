package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import java.util.Objects;

/* JADX INFO: renamed from: androidx.core.content.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2359d implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1270a;

    public /* synthetic */ C2359d(int i) {
        this.f1270a = i;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1270a) {
            case 0:
                return IntentSanitizer.Builder.lambda$allowAnyComponent$10((ComponentName) obj);
            case 1:
                return IntentSanitizer.Builder.lambda$allowExtra$14(obj);
            case 2:
                return IntentSanitizer.Builder.lambda$new$0((String) obj);
            case 3:
                return IntentSanitizer.Builder.lambda$new$1((Uri) obj);
            case 4:
                return IntentSanitizer.Builder.lambda$new$2((String) obj);
            case 5:
                return IntentSanitizer.Builder.lambda$new$3((String) obj);
            case 6:
                return IntentSanitizer.Builder.lambda$new$4((String) obj);
            case 7:
                return IntentSanitizer.Builder.lambda$new$5((ComponentName) obj);
            case 8:
                return IntentSanitizer.Builder.lambda$new$6((Uri) obj);
            case 9:
                return IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
            case 10:
                return IntentSanitizer.Builder.lambda$allowExtra$12(obj);
            default:
                return Objects.isNull(obj);
        }
    }
}
