package p184g4;

import com.samsung.android.sdk.scs.base.feature.FeatureStatusCache;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import java.util.Map;
import java.util.function.BiFunction;
import opennlp.tools.p217ml.model.AbstractDataIndexer;
import org.apache.commons.collections4.MapUtils;

/* JADX INFO: renamed from: g4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C12014a implements BiFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8767a;

    public /* synthetic */ C12014a(int i) {
        this.f8767a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f8767a) {
            case 0:
                return SearchNoteUseCase.lambda$createSortFunction$1((MainListDocumentData) obj, (MainListDocumentData) obj2);
            case 1:
                return SearchNoteUseCase.lambda$createSortFunction$2((MainListDocumentData) obj, (MainListDocumentData) obj2);
            case 2:
                return SearchNoteUseCase.lambda$createSortFunction$3((MainListDocumentData) obj, (MainListDocumentData) obj2);
            case 3:
                return SearchNoteUseCase.lambda$createSortFunction$4((MainListDocumentData) obj, (MainListDocumentData) obj2);
            case 4:
                return SearchNoteUseCase.lambda$createSortFunction$5((MainListDocumentData) obj, (MainListDocumentData) obj2);
            case 5:
                return SearchNoteUseCase.lambda$createSortFunction$6((MainListDocumentData) obj, (MainListDocumentData) obj2);
            case 6:
                return AbstractDataIndexer.lambda$update$1((Integer) obj, (Integer) obj2);
            case 7:
                return MapUtils.getBoolean((Map) obj, obj2);
            case 8:
                return MapUtils.getNumber((Map) obj, obj2);
            case 9:
                return MapUtils.getFloat((Map) obj, obj2);
            case 10:
                return MapUtils.getLong((Map) obj, obj2);
            case 11:
                return MapUtils.getMap((Map) obj, obj2);
            case 12:
                return MapUtils.getString((Map) obj, obj2);
            case 13:
                return MapUtils.getDouble((Map) obj, obj2);
            case 14:
                return MapUtils.getInteger((Map) obj, obj2);
            case 15:
                return MapUtils.getByte((Map) obj, obj2);
            case 16:
                return MapUtils.getShort((Map) obj, obj2);
            default:
                return FeatureStatusCache.lambda$clear$0((String) obj, (Integer) obj2);
        }
    }
}
