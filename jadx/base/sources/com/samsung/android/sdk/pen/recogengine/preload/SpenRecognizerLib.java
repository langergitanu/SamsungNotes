package com.samsung.android.sdk.pen.recogengine.preload;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\bB\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0087 J-\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0087 JE\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0087 J7\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0087 J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0087 Jc\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001e\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0018j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u00192\u001e\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0018j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0087 J\u0011\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0011\u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0019\u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001cH\u0087 J!\u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0087 J\u0019\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0087 J+\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0087 J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0011\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u001b\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0087 J\u0013\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u001b\u0010*\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010(H\u0087 J\u0013\u0010,\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0019\u0010-\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010.\u001a\u00020&H\u0087 J\u0019\u0010/\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010.\u001a\u00020&H\u0087 J\u0013\u00100\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0013\u00101\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0019\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u001cH\u0087 J\u0011\u00104\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J/\u00105\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010(2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u000108H\u0087 J\u0013\u0010:\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u001b\u0010;\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u000108H\u0087 J\u001b\u0010=\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u000108H\u0087 J\u001b\u0010?\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u000108H\u0087 J!\u0010A\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\rH\u0087 J\u0013\u0010D\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0005H\u0087 J\u0019\u0010E\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u001cH\u0087 J#\u0010G\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010(2\u0006\u0010I\u001a\u00020\rH\u0087 J\u0011\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u0005H\u0087 J\u0019\u0010L\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J\u0011\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u0005H\u0087 J\u0011\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0005H\u0087 J\u0013\u0010R\u001a\u0004\u0018\u00010(2\u0006\u0010Q\u001a\u00020\u0005H\u0087 J\u0011\u0010S\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0005H\u0087 J\u0011\u0010T\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0005H\u0087 J\u0013\u0010U\u001a\u0004\u0018\u00010\u00162\u0006\u0010Q\u001a\u00020\u0005H\u0087 J\u0011\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u0005H\u0087 J\u0019\u0010X\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001cH\u0087 J\u0019\u0010Z\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001cH\u0087 J\u001b\u0010[\u001a\u0004\u0018\u00010\u00162\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001cH\u0087 J\u0019\u0010\\\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001cH\u0087 J!\u0010]\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001cH\u0087 J#\u0010_\u001a\u0004\u0018\u00010\u00162\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001cH\u0087 J!\u0010`\u001a\u00020&2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001cH\u0087 J\u001b\u0010a\u001a\u0004\u0018\u00010(2\u0006\u0010b\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J\u0011\u0010c\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020\u0005H\u0087 J\u0019\u0010d\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u001cH\u0087 J\u001b\u0010f\u001a\u0004\u0018\u00010\u00162\u0006\u0010b\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u001cH\u0087 J\u0011\u0010g\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020\u0005H\u0087 J\u001b\u0010i\u001a\u0004\u0018\u00010(2\u0006\u0010h\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J\u0019\u0010j\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J5\u0010k\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00192\u0006\u0010h\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u001cH\u0087 J\u0019\u0010m\u001a\u00020\r2\u0006\u0010h\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J\u0013\u0010n\u001a\u0004\u0018\u00010\u00162\u0006\u0010h\u001a\u00020\u0005H\u0087 J\u0019\u0010o\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J-\u0010p\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00192\u0006\u0010h\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J\u0011\u0010q\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u0005H\u0087 J\u0019\u0010s\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u001cH\u0087 J9\u0010u\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0018j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u00192\u0006\u0010r\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u001cH\u0087 J\u001b\u0010v\u001a\u0004\u0018\u00010(2\u0006\u0010r\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u001cH\u0087 J\u001b\u0010w\u001a\u0004\u0018\u00010(2\u0006\u0010x\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001cH\u0087 J\u0011\u0010y\u001a\u00020\u001c2\u0006\u0010x\u001a\u00020\u0005H\u0087 ¨\u0006z"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerLib;", "", "<init>", "()V", "SPenRecognizer_Construct", "", "SPenRecognizer_AddStroke", "", "engine", "pArrX", "", "pArrY", "width", "", "pivotX", "pivotY", "degree", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerPlugin$SpenRecognizerListener;", "SPenRecognizer_ClearStrokes", "SPenRecognizer_AddHwrDataWithStrokes", "objectIDs", "", "xStrokeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "yStrokeList", "strokeCount", "", "SPenRecognizer_ClearHwrDataList", "SPenRecognizer_Recognize", "sleepTime", "refX", "refY", "SPenRecognizer_Request", "SPenRecognizer_Cancel", "SPenRecognizer_Destroy", "SPenRecognizer_SetTextRecognitionType", "", "trType", "", "SPenRecognizer_GetTextRecognitionType", "SPenRecognizer_SetTextRecognitionMode", "mode", "SPenRecognizer_GetTextRecognitionMode", "SPenRecognizer_SetTextRecognitionStrokeMode", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "SPenRecognizer_SetRefineHyperLinkMode", "SPenRecognizer_GetTextEngineVersion", "SPenRecognizer_GetRecognizerDBVersion", "SPenRecognizer_SetRecognizerType", "type", "SPenRecognizer_GetRecognizerType", "SPenRecognizer_SetLanguageData", "language", "mainData", "", "subData", "SPenRecognizer_GetLanguage", "SPenRecognizer_SetDocumentAnalyzerData", "docdb", "SPenRecognizer_SetDocumentLineSplitterData", "lsdb", "SPenRecognizer_SetMathExpressionData", "mathdb", "SPenRecognizer_SetDisplayMetrics", "xdpi", "ydpi", "SPenRecognizer_GetDisplayMetrics", "SPenRecognizer_SetOneUIVersion", "version", "SPenRecognizer_SetConfigurationItem", "configName", "configValue", "SPenRecognizerResultContainer_GetResultCount", "container", "SPenRecognizerResultContainer_GetResult", "index", "SPenRecognizerResultInterface_GetResultType", "resultInterface", "SPenRecognizerResultContextInterface_GetEntityStringLength", "context", "SPenRecognizerResultContextInterface_GetEntityString", "SPenRecognizerResultContextInterface_GetEntityType", "SPenRecognizerResultContextInterface_GetEntityStrokeListCount", "SPenRecognizerResultContextInterface_GetEntityStrokeList", "SPenRecognizerResultDocumentInterface_GetGroupCount", ExternalDataConstants.DOCUMENT_TABLE_NAME, "SPenRecognizerResultDocumentInterface_GetGroupType", "groupID", "SPenRecognizerResultDocumentInterface_GetGroupStrokeCount", "SPenRecognizerResultDocumentInterface_GetGroupStroke", "SPenRecognizerResultDocumentInterface_GetSubGroupCount", "SPenRecognizerResultDocumentInterface_GetSubGroupStrokeCount", "subGroupID", "SPenRecognizerResultDocumentInterface_GetSubGroupStroke", "SPenRecognizerResultDocumentInterface_IsSubGroupSkewed", "SPenRecognizerResultTextInterface_GetResultString", "text", "SPenRecognizerResultTextInterface_GetResultCount", "SPenRecognizerResultTextInterface_GetStrokeIndexCount", "characterIndex", "SPenRecognizerResultTextInterface_GetStrokeIndex", "SPenRecognizerResultShapeInterface_GetCandidateShapeCount", VMetaDataKey.META_KEY_SHAPE, "SPenRecognizerResultShapeInterface_GetCandidateShapeName", "SPenRecognizerResultShapeInterface_GetCandidateShape_GetStrokeSize", "SPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints", "strokeIndex", "SPenRecognizerResultShapeInterface_GetCandidateRelevance", "SPenRecognizerResultShapeInterface_GetStrokeIndex", "SPenRecognizerResultShapeInterface_GetRecognizedPointCount", "SPenRecognizerResultShapeInterface_GetRecognizedPoints", "SPenRecognizerResultBeautifierInterface_GetHwrDataSize", "beautifier", "SPenRecognizerResultBeautifierInterface_GetHwrData_StrokeSize", "hwrDataIndex", "SPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints", "SPenRecognizerResultBeautifierInterface_GetHwrData_LineText", "SPenRecognizerResultMathExpressionInterface_GetResultString", "math", "SPenRecognizerResultMathExpressionInterface_GetResultCount", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecognizerLib {

    @NotNull
    public static final SpenRecognizerLib INSTANCE = new SpenRecognizerLib();

    private SpenRecognizerLib() {
    }

    @JvmStatic
    public static final native int SPenRecognizerResultBeautifierInterface_GetHwrDataSize(long beautifier);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizerResultBeautifierInterface_GetHwrData_LineText(long beautifier, int hwrDataIndex);

    @JvmStatic
    @Nullable
    public static final native ArrayList<float[]> SPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints(long beautifier, int hwrDataIndex, int strokeIndex);

    @JvmStatic
    public static final native int SPenRecognizerResultBeautifierInterface_GetHwrData_StrokeSize(long beautifier, int hwrDataIndex);

    @JvmStatic
    public static final native long SPenRecognizerResultContainer_GetResult(long container, int index);

    @JvmStatic
    public static final native int SPenRecognizerResultContainer_GetResultCount(long container);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizerResultContextInterface_GetEntityString(long context);

    @JvmStatic
    public static final native int SPenRecognizerResultContextInterface_GetEntityStringLength(long context);

    @JvmStatic
    @Nullable
    public static final native int[] SPenRecognizerResultContextInterface_GetEntityStrokeList(long context);

    @JvmStatic
    public static final native int SPenRecognizerResultContextInterface_GetEntityStrokeListCount(long context);

    @JvmStatic
    public static final native int SPenRecognizerResultContextInterface_GetEntityType(long context);

    @JvmStatic
    public static final native int SPenRecognizerResultDocumentInterface_GetGroupCount(long document);

    @JvmStatic
    @Nullable
    public static final native int[] SPenRecognizerResultDocumentInterface_GetGroupStroke(long document, int groupID);

    @JvmStatic
    public static final native int SPenRecognizerResultDocumentInterface_GetGroupStrokeCount(long document, int groupID);

    @JvmStatic
    public static final native int SPenRecognizerResultDocumentInterface_GetGroupType(long document, int groupID);

    @JvmStatic
    public static final native int SPenRecognizerResultDocumentInterface_GetSubGroupCount(long document, int groupID);

    @JvmStatic
    @Nullable
    public static final native int[] SPenRecognizerResultDocumentInterface_GetSubGroupStroke(long document, int groupID, int subGroupID);

    @JvmStatic
    public static final native int SPenRecognizerResultDocumentInterface_GetSubGroupStrokeCount(long document, int groupID, int subGroupID);

    @JvmStatic
    public static final native boolean SPenRecognizerResultDocumentInterface_IsSubGroupSkewed(long document, int groupID, int subGroupID);

    @JvmStatic
    public static final native int SPenRecognizerResultInterface_GetResultType(long resultInterface);

    @JvmStatic
    public static final native int SPenRecognizerResultMathExpressionInterface_GetResultCount(long math);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizerResultMathExpressionInterface_GetResultString(long math, int index);

    @JvmStatic
    public static final native float SPenRecognizerResultShapeInterface_GetCandidateRelevance(long shape, int index);

    @JvmStatic
    public static final native int SPenRecognizerResultShapeInterface_GetCandidateShapeCount(long shape);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizerResultShapeInterface_GetCandidateShapeName(long shape, int index);

    @JvmStatic
    @Nullable
    public static final native ArrayList<float[]> SPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints(long shape, int index, int strokeIndex);

    @JvmStatic
    /* JADX INFO: renamed from: SPenRecognizerResultShapeInterface_GetCandidateShape_GetStrokeSize */
    public static final native int m5898xade82ae4(long shape, int index);

    @JvmStatic
    public static final native int SPenRecognizerResultShapeInterface_GetRecognizedPointCount(long shape, int index);

    @JvmStatic
    @Nullable
    public static final native ArrayList<float[]> SPenRecognizerResultShapeInterface_GetRecognizedPoints(long shape, int index);

    @JvmStatic
    @Nullable
    public static final native int[] SPenRecognizerResultShapeInterface_GetStrokeIndex(long shape);

    @JvmStatic
    public static final native int SPenRecognizerResultTextInterface_GetResultCount(long text);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizerResultTextInterface_GetResultString(long text, int index);

    @JvmStatic
    @Nullable
    public static final native int[] SPenRecognizerResultTextInterface_GetStrokeIndex(long text, int characterIndex);

    @JvmStatic
    public static final native int SPenRecognizerResultTextInterface_GetStrokeIndexCount(long text, int characterIndex);

    @JvmStatic
    public static final native void SPenRecognizer_AddHwrDataWithStrokes(long engine, @Nullable int[] objectIDs, @Nullable ArrayList<float[]> xStrokeList, @Nullable ArrayList<float[]> yStrokeList, int strokeCount);

    @JvmStatic
    public static final native void SPenRecognizer_AddStroke(long engine, @Nullable float[] pArrX, @Nullable float[] pArrY, float width);

    @JvmStatic
    public static final native void SPenRecognizer_AddStroke(long engine, @Nullable float[] pArrX, @Nullable float[] pArrY, float width, float pivotX, float pivotY, float degree);

    @JvmStatic
    public static final native void SPenRecognizer_AddStroke(long engine, @Nullable float[] pArrX, @Nullable float[] pArrY, float width, @Nullable SpenRecognizerPlugin.SpenRecognizerListener listener);

    @JvmStatic
    public static final native void SPenRecognizer_Cancel(long engine);

    @JvmStatic
    public static final native void SPenRecognizer_ClearHwrDataList(long engine);

    @JvmStatic
    public static final native void SPenRecognizer_ClearStrokes(long engine);

    @JvmStatic
    public static final native long SPenRecognizer_Construct();

    @JvmStatic
    public static final native void SPenRecognizer_Destroy(long engine);

    @JvmStatic
    @Nullable
    public static final native float[] SPenRecognizer_GetDisplayMetrics(long engine);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizer_GetLanguage(long engine);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizer_GetRecognizerDBVersion(long engine);

    @JvmStatic
    public static final native int SPenRecognizer_GetRecognizerType(long engine);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizer_GetTextEngineVersion(long engine);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizer_GetTextRecognitionMode(long engine);

    @JvmStatic
    @Nullable
    public static final native String SPenRecognizer_GetTextRecognitionType(long engine);

    @JvmStatic
    public static final native long SPenRecognizer_Recognize(long engine);

    @JvmStatic
    public static final native long SPenRecognizer_Recognize(long engine, float refX, float refY);

    @JvmStatic
    public static final native long SPenRecognizer_Recognize(long engine, int sleepTime);

    @JvmStatic
    public static final native void SPenRecognizer_Request(long engine, @NotNull SpenRecognizerPlugin.SpenRecognizerListener listener);

    @JvmStatic
    public static final native void SPenRecognizer_Request(long engine, @Nullable SpenRecognizerPlugin.SpenRecognizerListener listener, float refX, float refY);

    @JvmStatic
    public static final native void SPenRecognizer_SetConfigurationItem(long engine, @Nullable String configName, float configValue);

    @JvmStatic
    public static final native void SPenRecognizer_SetDisplayMetrics(long engine, float xdpi, float ydpi);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetDocumentAnalyzerData(long engine, @Nullable byte[] docdb);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetDocumentLineSplitterData(long engine, @Nullable byte[] lsdb);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetLanguageData(long engine, @Nullable String language, @Nullable byte[] mainData, @Nullable byte[] subData);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetMathExpressionData(long engine, @Nullable byte[] mathdb);

    @JvmStatic
    public static final native void SPenRecognizer_SetOneUIVersion(long engine, int version);

    @JvmStatic
    public static final native void SPenRecognizer_SetRecognizerType(long engine, int type);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetRefineHyperLinkMode(long engine, boolean set);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetTextRecognitionMode(long engine, @Nullable String mode);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetTextRecognitionStrokeMode(long engine, boolean set);

    @JvmStatic
    public static final native boolean SPenRecognizer_SetTextRecognitionType(long engine, @Nullable String trType);
}
