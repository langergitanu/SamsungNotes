package p074R1;

import com.samsung.android.app.sdk.deepsky.classifier.TextClassifierExtraUtils;
import com.samsung.android.scs.p140ai.sdkcommon.asr.DialogInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.sdk.scs.p142ai.visual.VisualErrorCode;
import com.samsung.scsp.framework.core.network.base.NetworkImpl;
import com.vladsch.flexmark.util.format.MarkdownTable;
import com.vladsch.flexmark.util.format.TrackedOffset;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Predicate;
import opennlp.tools.p217ml.model.OnePassDataIndexer;
import opennlp.tools.p217ml.model.TwoPassDataIndexer;

/* JADX INFO: renamed from: R1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0231c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f677a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f678b;

    public /* synthetic */ C0231c(int i, int i2) {
        this.f677a = i2;
        this.f678b = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f677a) {
            case 0:
                return TextClassifierExtraUtils.lambda$getEntityIndex$4(this.f678b, (int[]) obj);
            case 1:
                return TextClassifierExtraUtils.lambda$getEntityExtras$7(this.f678b, (ArrayList) obj);
            case 2:
                return DialogInfo.lambda$getSpeechInfosById$0(this.f678b, (SpeechInfo) obj);
            case 3:
                return VisualErrorCode.lambda$toCoreErrorCode$0(this.f678b, (VisualErrorCode) obj);
            case 4:
                return com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.lambda$toCoreErrorCode$0(this.f678b, (com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode) obj);
            case 5:
                return NetworkImpl.lambda$close$5(this.f678b, (HttpURLConnection) obj);
            case 6:
                return MarkdownTable.lambda$addTrackedOffset$2(this.f678b, (TrackedOffset) obj);
            case 7:
                return OnePassDataIndexer.lambda$computeEventCounts$0(this.f678b, (Map.Entry) obj);
            default:
                return TwoPassDataIndexer.lambda$computeEventCounts$0(this.f678b, (Map.Entry) obj);
        }
    }
}
