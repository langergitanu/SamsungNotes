package p074R1;

import android.os.Parcelable;
import android.text.TextUtils;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.bean.util.OrderedObject;
import com.samsung.android.app.sdk.deepsky.classifier.TextClassifierExtraUtils;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.external.ExternalDataQuery;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailDataCreator;
import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import opennlp.tools.formats.conllu.ConlluStream;
import opennlp.tools.formats.conllu.ConlluWordLine;
import org.apache.commons.collections4.list.CursorableLinkedList;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.apache.commons.lang3.function.Predicates;
import org.apache.commons.text.WordUtils;
import org.apache.commons.text.translate.CharSequenceTranslator;
import p002A0.C0009i;

/* JADX INFO: renamed from: R1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0233e implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f681a;

    public /* synthetic */ C0233e(int i) {
        this.f681a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f681a) {
            case 0:
                return TextClassifierExtraUtils.lambda$getEntityExtras$9((Parcelable) obj);
            case 1:
                return QueryUtils.isAllowedStatement((String) obj);
            case 2:
                return ExternalDataQuery.lambda$getInnerSelectClause$0((String) obj);
            case 3:
                return StringUtils.isBlank((String) obj);
            case 4:
                return Objects.nonNull((OrderedObject) obj);
            case 5:
                return OpencsvUtils.lambda$determineMappingStrategy$0((Field) obj);
            case 6:
                return NeuralTranslator.lambda$getSourceLanguageList$6((Map.Entry) obj);
            case 7:
                return NeuralTranslator.lambda$getTargetLanguageList$7((Map.Entry) obj);
            case 8:
                return ThumbnailDataCreator.lambda$checkBodyImageObject$0((SpenObjectSpan) obj);
            case 9:
                return Objects.isNull((SegmentedSequenceStats.StatsEntry) obj);
            case 10:
                return ConlluStream.lambda$mergeAnnotation$0((ConlluWordLine) obj);
            case 11:
                return ConlluStream.lambda$mergeAnnotation$1((ConlluWordLine) obj);
            case 12:
                return ConlluStream.lambda$mergeAnnotation$3((ConlluWordLine) obj);
            case 13:
                return ConlluStream.lambda$mergeAnnotation$5((ConlluWordLine) obj);
            case 14:
                return Objects.nonNull((Integer) obj);
            case 15:
                return ((Iterator) obj).hasNext();
            case 16:
                return CursorableLinkedList.lambda$registerCursor$0((WeakReference) obj);
            case 17:
                return ((BackgroundInitializer) obj).isInitialized();
            case 18:
                return Objects.nonNull((Throwable) obj);
            case 19:
                return Predicates.lambda$static$0(obj);
            case 20:
                return Predicates.lambda$static$1(obj);
            case 21:
                return Objects.nonNull((ConcurrentMap) obj);
            case 22:
                return Character.isWhitespace(((Integer) obj).intValue());
            case 23:
                return WordUtils.lambda$generateIsDelimiterFunction$0((Integer) obj);
            case 24:
                return Objects.nonNull((CharSequenceTranslator) obj);
            default:
                return !(TextUtils.isEmpty(((C0009i) obj).f39b) ? false : r2.startsWith("UNPACK_"));
        }
    }
}
