package androidx.credentials.provider.utils;

import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.credentials.provider.utils.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2559a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1438a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function1 f1439b;

    public /* synthetic */ C2559a(Function1 function1, int i) {
        this.f1438a = i;
        this.f1439b = function1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1438a) {
            case 0:
                return BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$6(this.f1439b, obj);
            case 1:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$13(this.f1439b, obj);
            case 2:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$7(this.f1439b, obj);
            default:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$10(this.f1439b, obj);
        }
    }
}
