package p074R1;

import com.samsung.android.app.sdk.deepsky.classifier.TextClassifierExtraUtils;
import com.vladsch.flexmark.formatter.FormatterUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import opennlp.tools.formats.leipzig.LeipzigLanguageSampleStream;

/* JADX INFO: renamed from: R1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0232d implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f679a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f680b;

    public /* synthetic */ C0232d(int i, int i2) {
        this.f679a = i2;
        this.f680b = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f679a) {
            case 0:
                return TextClassifierExtraUtils.lambda$getEntityIndex$5(this.f680b, (int[]) obj);
            case 1:
                return TextClassifierExtraUtils.lambda$getEntityExtras$8(this.f680b, (ArrayList) obj);
            case 2:
                return FormatterUtils.lambda$renderList$1(this.f680b, (CharSequence) obj);
            case 3:
                return FormatterUtils.lambda$renderList$2(this.f680b, (CharSequence) obj);
            default:
                return LeipzigLanguageSampleStream.lambda$new$3(this.f680b, (Map.Entry) obj);
        }
    }
}
