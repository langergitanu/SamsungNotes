package p092W3;

import android.graphics.Point;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.TemperatureCache;
import com.google.android.material.color.utilities.TonalPalette;
import com.samsung.android.sdk.pen.ocr.SpenOcrPageData;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paManifestList;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C7791a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.external.ExternalDataQuery;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer;
import com.vladsch.flexmark.formatter.NodeRepositoryFormatter;
import com.vladsch.flexmark.formatter.internal.CoreNodeFormatter;
import com.vladsch.flexmark.util.misc.Utils;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiFunction;
import java.util.function.Function;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.postag.POSTagFormatMapper;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.apache.commons.collections4.properties.SortedProperties;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.concurrent.Computable;
import org.apache.commons.lang3.concurrent.Memoizer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.stream.Streams;
import org.apache.commons.logging.impl.LogFactoryImpl;
import p100Y3.C0348a;

/* JADX INFO: renamed from: W3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0332a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f853a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f854b;

    public /* synthetic */ C0332a(Object obj, int i) {
        this.f853a = i;
        this.f854b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f853a) {
            case 0:
                return ((ExternalDataQuery) this.f854b).getMatchedStatementByColumn((String) obj);
            case 1:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) this.f854b, (DynamicScheme) obj);
            case 2:
                return DynamicColor.lambda$fromArgb$1((Hct) this.f854b, (DynamicScheme) obj);
            case 3:
                return ((TemperatureCache) this.f854b).lambda$getHctsByTemp$0((Hct) obj);
            case 4:
                return SpenOcrPageData.lambda$findNearestTextBlock$1((Point) this.f854b, (Point) obj);
            case 5:
                return (IInterface) ((AiServiceExecutorFactory.ServiceStubFactory) this.f854b).createStub((IBinder) obj);
            case 6:
                return C2paManifestList.checkInvalid$lambda$21((C7791a) this.f854b, obj);
            case 7:
                return ScsRecognizer.startRecognizer$lambda$2((C0348a) this.f854b, obj);
            case 8:
                return ((NodeRepositoryFormatter) this.f854b).lambda$renderReferenceBlockUnique$0((String) obj);
            case 9:
                return ((CoreNodeFormatter) this.f854b).lambda$renderAutoLink$4((String) obj);
            case 10:
                return Utils.lambda$removeIf$0((BiFunction) this.f854b, (Map.Entry) obj);
            case 11:
                return ((BeamSearch) this.f854b).lambda$bestSequences$0((String[]) obj);
            case 12:
                return (Integer) ((Map) this.f854b).get((String) obj);
            case 13:
                return ((POSTagFormatMapper) this.f854b).convertTag((String) obj);
            case 14:
                return ((OrderedProperties) this.f854b).lambda$entrySet$0(obj);
            case 15:
                return ((SortedProperties) this.f854b).lambda$entrySet$0((String) obj);
            case 16:
                return Functions.apply((Functions.FailableFunction) this.f854b, obj);
            case 17:
                return ((Streams.ArrayCollector) this.f854b).lambda$finisher$1((List) obj);
            case 18:
                return Memoizer.lambda$new$1((Computable) this.f854b, obj);
            case 19:
                return ExceptionUtils.getCauseUsingMethodName((Throwable) this.f854b, (String) obj);
            case 20:
                return Failable.apply((FailableFunction) this.f854b, obj);
            case 21:
                return ((Streams.ArrayCollector) this.f854b).lambda$finisher$1((List) obj);
            case 22:
                return ((LogFactoryImpl) this.f854b).newInstance((String) obj);
            default:
                return ((Properties) this.f854b).getProperty((String) obj);
        }
    }
}
