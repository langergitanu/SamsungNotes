package p193j4;

import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.DocumentStickyRepository;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextDataTask;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: j4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C12937a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9141a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f9142b;

    public /* synthetic */ C12937a(String str, int i) {
        this.f9141a = i;
        this.f9142b = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zDeleteByPageId$lambda$1;
        switch (this.f9141a) {
            case 0:
                zDeleteByPageId$lambda$1 = DocumentStickyRepository.deleteByPageId$lambda$1(this.f9142b, (Map.Entry) obj);
                break;
            default:
                zDeleteByPageId$lambda$1 = AiTextDataTask.start$lambda$3$lambda$1(this.f9142b, (String) obj);
                break;
        }
        return Boolean.valueOf(zDeleteByPageId$lambda$1);
    }
}
