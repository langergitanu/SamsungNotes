package androidx.credentials.provider;

import androidx.credentials.provider.PendingIntentHandler;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.credentials.provider.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2558c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1436a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function1 f1437b;

    public /* synthetic */ C2558c(Function1 function1, int i) {
        this.f1436a = i;
        this.f1437b = function1;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f1436a) {
            case 0:
                return PendingIntentHandler.Companion.retrieveProviderGetCredentialRequest$lambda$1(this.f1437b, obj);
            case 1:
                return BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$5(this.f1437b, obj);
            case 2:
                return BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$7(this.f1437b, obj);
            case 3:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$14(this.f1437b, obj);
            case 4:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$6(this.f1437b, obj);
            case 5:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$8(this.f1437b, obj);
            case 6:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$9(this.f1437b, obj);
            case 7:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$11(this.f1437b, obj);
            case 8:
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$12(this.f1437b, obj);
            case 9:
                return BeginGetCredentialUtil.Companion.convertToFrameworkRequest$lambda$5(this.f1437b, obj);
            case 10:
                return GraphqlQueryExecutorImpl.future$lambda$5(this.f1437b, obj);
            case 11:
                return GraphqlQueryExecutorImpl.resolve$lambda$7(this.f1437b, obj);
            default:
                return DrawUtil.fixDimensions$lambda$0(this.f1437b, obj);
        }
    }
}
