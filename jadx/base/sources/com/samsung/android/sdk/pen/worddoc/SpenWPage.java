package com.samsung.android.sdk.pen.worddoc;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectFactory;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.smartswitchfileshare.Constants;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ¤\u00012\u00020\u0001:\n \u0001¡\u0001¢\u0001£\u0001¤\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00106\u001a\u00020\u001cJ\u001a\u0010L\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020I\u0018\u0001`\u0012J\"\u0010M\u001a\u00020N2\u001a\u0010O\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020I\u0018\u0001`\u0012J\u0013\u0010V\u001a\u00020\u001c2\b\u0010W\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010X\u001a\u00020\u0005H\u0016J\u0010\u0010Y\u001a\u00020N2\b\u0010Z\u001a\u0004\u0018\u00010\u0011J\"\u0010[\u001a\u00020N2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012J\u0018\u0010\\\u001a\u00020N2\b\u0010Z\u001a\u0004\u0018\u00010\u00112\u0006\u0010]\u001a\u00020\u0005J*\u0010^\u001a\u00020N2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00122\u0006\u0010]\u001a\u00020\u0005J\u0010\u0010_\u001a\u00020N2\b\u0010Z\u001a\u0004\u0018\u00010\u0011J\"\u0010`\u001a\u00020N2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012J\u0006\u0010a\u001a\u00020NJ\u0006\u0010b\u001a\u00020NJ\u000e\u0010c\u001a\u00020N2\u0006\u0010d\u001a\u00020\u0005J\u0010\u0010e\u001a\u0004\u0018\u00010\u00112\u0006\u0010]\u001a\u00020\u0005J\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u001cJ\u0016\u0010f\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u001cJ\u000e\u0010h\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005J\u0010\u0010i\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0011J\u0010\u0010j\u001a\u00020\u001c2\b\u0010Z\u001a\u0004\u0018\u00010\u0011J\u001e\u0010k\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u00052\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020mJ&\u0010k\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u00052\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020mJ.\u0010p\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010d\u001a\u00020\u00052\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020mJ6\u0010p\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010d\u001a\u00020\u00052\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020mJ1\u0010q\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010d\u001a\u00020\u00052\f\u0010r\u001a\b\u0012\u0004\u0012\u00020t0s¢\u0006\u0002\u0010uJ.\u0010v\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010d\u001a\u00020\u00052\u0006\u0010w\u001a\u00020-2\u0006\u0010x\u001a\u00020\u001cJ(\u0010y\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010d\u001a\u00020\u00052\b\u0010w\u001a\u0004\u0018\u00010-J \u0010z\u001a\u00020N2\b\u0010Z\u001a\u0004\u0018\u00010\u00112\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u001cJ\u0016\u0010}\u001a\u00020N2\u0006\u0010~\u001a\u00020m2\u0006\u0010\u007f\u001a\u00020mJ.\u0010\u0080\u0001\u001a\u00020N2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00122\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0000J/\u0010\u0080\u0001\u001a\u00020N2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00122\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\u0007\u0010\u0084\u0001\u001a\u00020NJ\u0012\u0010\u0085\u0001\u001a\u00020N2\u0007\u0010\u0086\u0001\u001a\u00020\u0000H\u0007J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u00020\u0005J\u0017\u0010\"\u001a\u00020N2\u0006\u0010\u001f\u001a\u00020\u00052\u0007\u0010\u0088\u0001\u001a\u00020\u001cJ\u0012\u0010\u0089\u0001\u001a\u00020N2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0016J\u001b\u0010\u0089\u0001\u001a\u00020N2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010\u0088\u0001\u001a\u00020\u001cJ\u0019\u0010\u0089\u0001\u001a\u00020N2\u0007\u0010\u008b\u0001\u001a\u00020\u00052\u0007\u0010\u0088\u0001\u001a\u00020\u001cJ\u0007\u0010\u008c\u0001\u001a\u00020\u001cJ\u0017\u0010\u008d\u0001\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J$\u0010\u008e\u0001\u001a\u00020N2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020m2\u0006\u0010\u000b\u001a\u00020tJ\u0007\u0010\u0092\u0001\u001a\u00020NJ\u0010\u0010\u0093\u0001\u001a\u00020\u001c2\u0007\u0010\u0094\u0001\u001a\u00020-J\u0010\u0010\u0095\u0001\u001a\u00020N2\u0007\u0010Z\u001a\u00030\u0096\u0001J\u0018\u0010\u0097\u0001\u001a\u00020N2\u0007\u0010Z\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020\u0005J\u000f\u0010\u0098\u0001\u001a\u00020N2\u0006\u0010]\u001a\u00020\u0005J\u0007\u0010\u0099\u0001\u001a\u00020NJ\u0012\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0006\u0010]\u001a\u00020\u0005J\u0007\u0010\u009b\u0001\u001a\u00020\u0005J\u0011\u0010\u0098\u0001\u001a\u00020N2\b\u0010\u009c\u0001\u001a\u00030\u0096\u0001J\t\u0010\u009d\u0001\u001a\u00020NH\u0004J\u0012\u0010\u009e\u0001\u001a\u00020N2\u0007\u0010\u009f\u0001\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR$\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\bR\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b+\u0010\u0018R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b.\u0010/RL\u00102\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010\u0010j\n\u0012\u0004\u0012\u000201\u0018\u0001`\u00122\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010\u0010j\n\u0012\u0004\u0012\u000201\u0018\u0001`\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u00105R$\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010#R(\u0010<\u001a\u0004\u0018\u00010\u00162\b\u0010;\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0018\"\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bB\u0010CR$\u0010E\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010\b\"\u0004\bG\u0010#RL\u0010H\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020I\u0018\u0001`\u00122\u001a\u0010H\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020I\u0018\u0001`\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0014\"\u0004\bK\u00105R$\u0010Q\u001a\u00020A2\u0006\u0010P\u001a\u00020A8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010C\"\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bU\u0010\u001d¨\u0006¥\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "", "<init>", "()V", "mHandle", "", "width", "getWidth", "()I", "height", "getHeight", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/graphics/Point;", "getOffset", "()Landroid/graphics/Point;", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "getObjectList", "()Ljava/util/ArrayList;", "id", "", "getId", "()Ljava/lang/String;", "runtimeHandle", "getRuntimeHandle", "isChanged", "", "()Z", "isValid", "color", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "(I)V", "backgroundImageId", "getBackgroundImageId", "backgroundImage", "Landroid/graphics/Bitmap;", "getBackgroundImage", "()Landroid/graphics/Bitmap;", "backgroundImagePath", "getBackgroundImagePath", "drawnRectOfAllObject", "Landroid/graphics/RectF;", "getDrawnRectOfAllObject", "()Landroid/graphics/RectF;", Constants.JTAG_DATA_LIST, "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$StrokeRecognitionData;", "strokeRecognitionData", "getStrokeRecognitionData", "setStrokeRecognitionData", "(Ljava/util/ArrayList;)V", "hasPDF", "type", "templateType", "getTemplateType", "setTemplateType", "uri", "templateURI", "getTemplateURI", "setTemplateURI", "(Ljava/lang/String;)V", "modifiedTime", "", "getModifiedTime", "()J", "mode", "backgroundImageMode", "getBackgroundImageMode", "setBackgroundImageMode", "pdfData", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$PDFData;", "getPdfData", "setPdfData", "getPDFData", "setPDFData", "", "pdfDataList", "time", "recognizedDataModifiedTime", "getRecognizedDataModifiedTime", "setRecognizedDataModifiedTime", "(J)V", "isEditingByCoedit", "equals", "o", "hashCode", "appendObject", "obj", "appendObjectList", "insertObject", "index", "insertObjectList", "removeObject", "removeObjectList", "removeAllObject", "removeSelectedObject", "removeObjects", "typeFilter", "getObject", "getObjectCount", "includeInvisible", "getObjectByRuntimeHandle", "getObjectIndex", "isObjectContained", "findTopObjectAtPosition", "x", "", "y", "threshold", "findObjectAtPosition", "findObjectInClosedCurve", "points", "", "Landroid/graphics/PointF;", "(I[Landroid/graphics/PointF;)Ljava/util/ArrayList;", "findObjectInRect", "rectf", "allAreas", "findObjectInRectIntersect", "moveObjectIndex", "step", "ignoreInvisible", "moveAllObject", "horizontalDelta", "verticalDelta", "moveObject", "targetPage", "targetContainer", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "clearChangedFlag", "copy", "sourcePage", "createObject", "skipHistory", "setBackgroundImage", "filePath", "fileId", "hasBackgroundImage", "setSize", "transferObjects", "page", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "magnification", "clearCanvasCacheData", "isObjectInRect", "rectF", "appendCustomObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "insertCustomObject", "removeCustomObject", "removeAllCustomObject", "getCustomObject", "getCustomObjectCount", "customObject", "finalize", "throwUncheckedException", "errno", "SearchData", "ActionLinkData", "StrokeRecognitionData", "PDFData", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWPage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWPage.kt\ncom/samsung/android/sdk/pen/worddoc/SpenWPage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1639:1\n1#2:1640\n*E\n"})
public final class SpenWPage {
    public static final int BACKGROUND_IMAGE_MODE_CENTER = 0;
    public static final int BACKGROUND_IMAGE_MODE_FIT = 2;
    public static final int BACKGROUND_IMAGE_MODE_STRETCH = 1;
    public static final int BACKGROUND_IMAGE_MODE_TILE = 3;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_CUSTOM = 12;
    public static final int TYPE_DYNAMIC = 17;
    public static final int TYPE_MANUSCRIPT = 15;
    public static final int TYPE_MAX = 18;
    public static final int TYPE_MEDIUM_DOT = 8;
    public static final int TYPE_MEDIUM_GRID = 5;
    public static final int TYPE_MEDIUM_LINE = 2;
    public static final int TYPE_MONTHLY = 14;
    public static final int TYPE_NARROW_DOT = 7;
    public static final int TYPE_NARROW_GRID = 4;
    public static final int TYPE_NARROW_LINE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OXFORD_PAPER = 11;
    public static final int TYPE_PDF = 16;
    public static final int TYPE_TODO = 10;
    public static final int TYPE_WEEKLY = 13;
    public static final int TYPE_WIDE_DOT = 9;
    public static final int TYPE_WIDE_GRID = 6;
    public static final int TYPE_WIDE_LINE = 3;
    private int mHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$ActionLinkData;", "", "<init>", "()V", "linkType", "", "pageWidth", "linkStr", "", "strokeRect", "Landroid/graphics/Rect;", "firstCharRect", "lastCharRect", "handleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "repObjectUuid", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ActionLinkData {
        public static final int ACTIONLINK_TYPE_EMAIL = 2;
        public static final int ACTIONLINK_TYPE_FORMULA = 3;
        public static final int ACTIONLINK_TYPE_PHONE = 0;
        public static final int ACTIONLINK_TYPE_URL = 1;

        @JvmField
        @Nullable
        public Rect firstCharRect;

        @JvmField
        @Nullable
        public ArrayList<Integer> handleList;

        @JvmField
        @Nullable
        public Rect lastCharRect;

        @JvmField
        @Nullable
        public String linkStr;

        @JvmField
        public int linkType;

        @JvmField
        public int pageWidth;

        @JvmField
        @Nullable
        public String repObjectUuid;

        @JvmField
        @Nullable
        public Rect strokeRect;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001b\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0083 J-\u0010'\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*H\u0083 J#\u0010+\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010,\u001a\u00020\u0005H\u0083 J5\u0010-\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010,\u001a\u00020\u0005H\u0083 J\u001b\u0010.\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0083 J-\u0010/\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*H\u0083 J\u0011\u00100\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0019\u00102\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0083 J\u001b\u00104\u001a\u0004\u0018\u00010&2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0083 J%\u00105\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J-\u00106\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0083 J\u0019\u00107\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00108\u001a\u00020$H\u0083 J!\u00109\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00108\u001a\u00020$2\u0006\u00103\u001a\u00020\u0005H\u0083 J\u001b\u0010:\u001a\u0004\u0018\u00010&2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0083 J\u001b\u0010<\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0083 J)\u0010=\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0083 J1\u0010B\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020@H\u0083 J=\u0010D\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0083 JE\u0010E\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020@H\u0083 JC\u0010F\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\u0006\u0010J\u001a\u00020\u0005H\u0083 J=\u0010K\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020$H\u0083 J3\u0010O\u001a\u0012\u0012\u0004\u0012\u00020&0)j\b\u0012\u0004\u0012\u00020&`*2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010MH\u0083 J+\u0010P\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020$H\u0083 J!\u0010S\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010T\u001a\u00020@2\u0006\u0010U\u001a\u00020@H\u0083 J=\u0010V\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\u0006\u0010W\u001a\u00020@2\u0006\u0010X\u001a\u00020@H\u0083 J?\u0010Y\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u0005H\u0083 J7\u0010]\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010)j\n\u0012\u0004\u0012\u00020&\u0018\u0001`*2\b\u0010^\u001a\u0004\u0018\u00010_H\u0083 J\u001b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0083 J!\u0010b\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020$H\u0083 J\u0011\u0010e\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J#\u0010f\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010g\u001a\u0004\u0018\u00010a2\u0006\u0010d\u001a\u00020$H\u0083 J!\u0010h\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010d\u001a\u00020$H\u0083 J\u0011\u0010j\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010k\u001a\u00020l2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010m\u001a\u00020a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010n\u001a\u00020a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010o\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010p\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J!\u0010q\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010r\u001a\u00020[2\u0006\u0010s\u001a\u00020\u0005H\u0083 J\u0011\u0010t\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010u\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010v\u001a\u00020M2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0011\u0010w\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J!\u0010x\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u0005H\u0083 J\u0011\u0010{\u001a\u00020$2\u0006\u0010|\u001a\u00020\u0005H\u0083 J)\u0010}\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0016\u0010~\u001a\u0012\u0012\u0004\u0012\u00020\u007f0)j\b\u0012\u0004\u0012\u00020\u007f`*H\u0083 J&\u0010\u0080\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u007f\u0018\u00010)j\n\u0012\u0004\u0012\u00020\u007f\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001a\u0010\u0081\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0083 J\u0012\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001d\u0010\u0083\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010aH\u0083 J\u0012\u0010\u0085\u0001\u001a\u00020a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J0\u0010\u0086\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020@2\u0007\u0010\u008a\u0001\u001a\u00020IH\u0083 J\u0013\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001b\u0010\u008d\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u0005H\u0083 J\u0012\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J-\u0010\u0090\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0019\u0010\u0091\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0092\u00010)j\t\u0012\u0005\u0012\u00030\u0092\u0001`*H\u0083 J(\u0010\u0093\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010)j\u000b\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u0001`*2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0012\u0010\u0094\u0001\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001c\u0010\u0095\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u0096\u0001\u001a\u00030\u008c\u0001H\u0083 J\u0013\u0010\u0097\u0001\u001a\u00030\u008c\u00012\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0012\u0010\u0098\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001b\u0010\u0099\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020MH\u0083 J\u001b\u0010\u009b\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0007\u0010%\u001a\u00030\u009c\u0001H\u0083 J#\u0010\u009d\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0007\u0010%\u001a\u00030\u009c\u00012\u0006\u0010,\u001a\u00020\u0005H\u0083 J\u001a\u0010\u009e\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0083 J\u0012\u0010\u009f\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u0012\u0010 \u0001\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J\u001d\u0010¡\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0083 J\u001c\u0010¢\u0001\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010£\u0001\u001a\u00030\u009c\u0001H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$Companion;", "", "<init>", "()V", "TYPE_NONE", "", "TYPE_NARROW_LINE", "TYPE_MEDIUM_LINE", "TYPE_WIDE_LINE", "TYPE_NARROW_GRID", "TYPE_MEDIUM_GRID", "TYPE_WIDE_GRID", "TYPE_NARROW_DOT", "TYPE_MEDIUM_DOT", "TYPE_WIDE_DOT", "TYPE_TODO", "TYPE_OXFORD_PAPER", "TYPE_CUSTOM", "TYPE_WEEKLY", "TYPE_MONTHLY", "TYPE_MANUSCRIPT", "TYPE_PDF", "TYPE_DYNAMIC", "TYPE_MAX", "BACKGROUND_IMAGE_MODE_CENTER", "BACKGROUND_IMAGE_MODE_STRETCH", "BACKGROUND_IMAGE_MODE_FIT", "BACKGROUND_IMAGE_MODE_TILE", "WPage_finalize", "", "nativeHandle", "WPage_GetWidth", "WPage_GetHeight", "WPage_GetOffset", "Landroid/graphics/Point;", "WPage_AppendObject", "", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "WPage_AppendObjectList", "objectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "WPage_InsertObject", "index", "WPage_InsertObjectList", "WPage_RemoveObject", "WPage_RemoveObjectList", "WPage_RemoveAllObject", "WPage_RemoveSelectedObject", "WPage_RemoveObjects", "typeFilter", "WPage_GetObject", "WPage_GetObjectList", "WPage_GetObjectList2", "WPage_GetObjectCount", "includeInvisible", "WPage_GetObjectCount2", "WPage_GetObjectByRuntimeHandle", "runtimeHandle", "WPage_GetObjectIndex", "WPage_FindTopObjectAtPosition", "type", "x", "", "y", "WPage_FindTopObjectAtPositionWithThreshold", "threshold", "WPage_FindObjectAtPosition", "WPage_FindObjectAtPositionWithThreshold", "WPage_FindObjectInClosedCurve", "points", "", "Landroid/graphics/PointF;", "length", "WPage_FindObjectInRect", "rectf", "Landroid/graphics/RectF;", "allAreas", "WPage_FindObjectInRectIntersect", "WPage_MoveObjectIndex", "step", "ignoreInvisible", "WPage_MoveAllObject", "horizontalDelta", "verticalDelta", "WPage_MoveObject", "deltaX", "deltaY", "WPage_MoveObject1", "targetPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "targetPageHandle", "WPage_MoveObject2", "targetContainer", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "WPage_GetCanvasCachePath", "", "WPage_SetBackgroundColor", "color", "skipHistory", "WPage_GetBackgroundColor", "WPage_SetBackgroundImage", "sourceUri", "WPage_SetBackgroundImageById", "fileId", "WPage_GetBackgroundImageId", "WPage_GetBackgroundImage", "Landroid/graphics/Bitmap;", "WPage_GetBackgroundImagePath", "WPage_GetId", "WPage_GetRuntimeHandle", "WPage_IsChanged", "WPage_Copy", ShareApi.ORIGINAL_SIZE_IMAGE, "originalHandle", "WPage_IsValid", "WPage_ClearChangedFlag", "WPage_GetDrawnRectOfAllObject", "WPage_HasBackgroundImage", "WPage_SetSize", "width", "height", "WPage_HasPDF", "handle", "WPage_SetStrokeRecognitionData", Constants.JTAG_DATA_LIST, "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$StrokeRecognitionData;", "WPage_GetStrokeRecognitionData", "WPage_SetTemplateType", "WPage_GetTemplateType", "WPage_SetTemplateURI", "uri", "WPage_GetTemplateURI", "WPage_TransferObjects", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "magnification", TypedValues.Cycle.S_WAVE_OFFSET, "WPage_GetModifiedTime", "", "WPage_SetBackgroundImageMode", "mode", "WPage_GetBackgroundImageMode", "WPage_SetPDFData", "pdfData", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$PDFData;", "WPage_GetPDFData", "WPage_ClearCanvasCacheData", "WPage_SetRecognizedDataModifiedTime", "modifiedTime", "WPage_GetRecognizedDataModifiedTime", "WPage_IsEditingByCoedit", "WPage_IsObjectInRect", "rectF", "WPage_AppendCustomObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "WPage_InsertCustomObject", "WPage_RemoveCustomObject", "WPage_RemoveAllCustomObject", "WPage_GetCustomObjectCount", "WPage_GetCustomObject", "WPage_RemoveCustomObject1", "customObject", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_AppendCustomObject(int nativeHandle, SpenCustomObject obj) {
            return SpenWPage.WPage_AppendCustomObject(nativeHandle, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_AppendObject(int nativeHandle, SpenObjectBase obj) {
            return SpenWPage.WPage_AppendObject(nativeHandle, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_AppendObjectList(int nativeHandle, ArrayList<SpenObjectBase> objectList) {
            return SpenWPage.WPage_AppendObjectList(nativeHandle, objectList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void WPage_ClearCanvasCacheData(int nativeHandle) {
            SpenWPage.WPage_ClearCanvasCacheData(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void WPage_ClearChangedFlag(int nativeHandle) {
            SpenWPage.WPage_ClearChangedFlag(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_Copy(int nativeHandle, SpenWPage original, int originalHandle) {
            return SpenWPage.WPage_Copy(nativeHandle, original, originalHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_FindObjectAtPosition(int nativeHandle, int type, float x, float y2) {
            return SpenWPage.WPage_FindObjectAtPosition(nativeHandle, type, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_FindObjectAtPositionWithThreshold(int nativeHandle, int type, float x, float y2, float threshold) {
            return SpenWPage.WPage_FindObjectAtPositionWithThreshold(nativeHandle, type, x, y2, threshold);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_FindObjectInClosedCurve(int i, int i2, PointF[] pointFArr, int i4) {
            return SpenWPage.WPage_FindObjectInClosedCurve(i, i2, pointFArr, i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_FindObjectInRect(int nativeHandle, int type, RectF rectf, boolean allAreas) {
            return SpenWPage.WPage_FindObjectInRect(nativeHandle, type, rectf, allAreas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_FindObjectInRectIntersect(int nativeHandle, int type, RectF rectf) {
            return SpenWPage.WPage_FindObjectInRectIntersect(nativeHandle, type, rectf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectBase WPage_FindTopObjectAtPosition(int nativeHandle, int type, float x, float y2) {
            return SpenWPage.WPage_FindTopObjectAtPosition(nativeHandle, type, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectBase WPage_FindTopObjectAtPositionWithThreshold(int nativeHandle, int type, float x, float y2, float threshold) {
            return SpenWPage.WPage_FindTopObjectAtPositionWithThreshold(nativeHandle, type, x, y2, threshold);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetBackgroundColor(int nativeHandle) {
            return SpenWPage.WPage_GetBackgroundColor(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap WPage_GetBackgroundImage(int nativeHandle) {
            return SpenWPage.WPage_GetBackgroundImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetBackgroundImageId(int nativeHandle) {
            return SpenWPage.WPage_GetBackgroundImageId(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetBackgroundImageMode(int nativeHandle) {
            return SpenWPage.WPage_GetBackgroundImageMode(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WPage_GetBackgroundImagePath(int nativeHandle) {
            return SpenWPage.WPage_GetBackgroundImagePath(nativeHandle);
        }

        @JvmStatic
        private final String WPage_GetCanvasCachePath(int nativeHandle, int index) {
            return SpenWPage.WPage_GetCanvasCachePath(nativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenCustomObject WPage_GetCustomObject(int nativeHandle, int index) {
            return SpenWPage.WPage_GetCustomObject(nativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetCustomObjectCount(int nativeHandle) {
            return SpenWPage.WPage_GetCustomObjectCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF WPage_GetDrawnRectOfAllObject(int nativeHandle) {
            return SpenWPage.WPage_GetDrawnRectOfAllObject(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetHeight(int nativeHandle) {
            return SpenWPage.WPage_GetHeight(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WPage_GetId(int nativeHandle) {
            return SpenWPage.WPage_GetId(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WPage_GetModifiedTime(int nativeHandle) {
            return SpenWPage.WPage_GetModifiedTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectBase WPage_GetObject(int nativeHandle, int index) {
            return SpenWPage.WPage_GetObject(nativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectBase WPage_GetObjectByRuntimeHandle(int nativeHandle, int runtimeHandle) {
            return SpenWPage.WPage_GetObjectByRuntimeHandle(nativeHandle, runtimeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetObjectCount(int nativeHandle, boolean includeInvisible) {
            return SpenWPage.WPage_GetObjectCount(nativeHandle, includeInvisible);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetObjectCount2(int nativeHandle, boolean includeInvisible, int typeFilter) {
            return SpenWPage.WPage_GetObjectCount2(nativeHandle, includeInvisible, typeFilter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetObjectIndex(int nativeHandle, SpenObjectBase obj) {
            return SpenWPage.WPage_GetObjectIndex(nativeHandle, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_GetObjectList(int nativeHandle) {
            return SpenWPage.WPage_GetObjectList(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenObjectBase> WPage_GetObjectList2(int nativeHandle, int typeFilter) {
            return SpenWPage.WPage_GetObjectList2(nativeHandle, typeFilter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Point WPage_GetOffset(int nativeHandle) {
            return SpenWPage.WPage_GetOffset(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<PDFData> WPage_GetPDFData(int nativeHandle) {
            return SpenWPage.WPage_GetPDFData(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WPage_GetRecognizedDataModifiedTime(int nativeHandle) {
            return SpenWPage.WPage_GetRecognizedDataModifiedTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetRuntimeHandle(int nativeHandle) {
            return SpenWPage.WPage_GetRuntimeHandle(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<StrokeRecognitionData> WPage_GetStrokeRecognitionData(int nativeHandle) {
            return SpenWPage.WPage_GetStrokeRecognitionData(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetTemplateType(int nativeHandle) {
            return SpenWPage.WPage_GetTemplateType(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WPage_GetTemplateURI(int nativeHandle) {
            return SpenWPage.WPage_GetTemplateURI(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WPage_GetWidth(int nativeHandle) {
            return SpenWPage.WPage_GetWidth(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_HasBackgroundImage(int nativeHandle) {
            return SpenWPage.WPage_HasBackgroundImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_HasPDF(int handle) {
            return SpenWPage.WPage_HasPDF(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_InsertCustomObject(int nativeHandle, SpenCustomObject obj, int index) {
            return SpenWPage.WPage_InsertCustomObject(nativeHandle, obj, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_InsertObject(int nativeHandle, SpenObjectBase obj, int index) {
            return SpenWPage.WPage_InsertObject(nativeHandle, obj, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_InsertObjectList(int nativeHandle, ArrayList<SpenObjectBase> objectList, int index) {
            return SpenWPage.WPage_InsertObjectList(nativeHandle, objectList, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_IsChanged(int nativeHandle) {
            return SpenWPage.WPage_IsChanged(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_IsEditingByCoedit(int nativeHandle) {
            return SpenWPage.WPage_IsEditingByCoedit(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_IsObjectInRect(int nativeHandle, RectF rectF) {
            return SpenWPage.WPage_IsObjectInRect(nativeHandle, rectF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_IsValid(int nativeHandle) {
            return SpenWPage.WPage_IsValid(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_MoveAllObject(int nativeHandle, float horizontalDelta, float verticalDelta) {
            return SpenWPage.WPage_MoveAllObject(nativeHandle, horizontalDelta, verticalDelta);
        }

        @JvmStatic
        private final boolean WPage_MoveObject(int nativeHandle, ArrayList<SpenObjectBase> objectList, float deltaX, float deltaY) {
            return SpenWPage.WPage_MoveObject(nativeHandle, objectList, deltaX, deltaY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_MoveObject1(int nativeHandle, ArrayList<SpenObjectBase> objectList, SpenWPage targetPage, int targetPageHandle) {
            return SpenWPage.WPage_MoveObject1(nativeHandle, objectList, targetPage, targetPageHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_MoveObject2(int nativeHandle, ArrayList<SpenObjectBase> objectList, SpenObjectContainer targetContainer) {
            return SpenWPage.WPage_MoveObject2(nativeHandle, objectList, targetContainer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_MoveObjectIndex(int nativeHandle, SpenObjectBase obj, int step, boolean ignoreInvisible) {
            return SpenWPage.WPage_MoveObjectIndex(nativeHandle, obj, step, ignoreInvisible);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveAllCustomObject(int nativeHandle) {
            return SpenWPage.WPage_RemoveAllCustomObject(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveAllObject(int nativeHandle) {
            return SpenWPage.WPage_RemoveAllObject(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveCustomObject(int nativeHandle, int index) {
            return SpenWPage.WPage_RemoveCustomObject(nativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveCustomObject1(int nativeHandle, SpenCustomObject customObject) {
            return SpenWPage.WPage_RemoveCustomObject1(nativeHandle, customObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveObject(int nativeHandle, SpenObjectBase obj) {
            return SpenWPage.WPage_RemoveObject(nativeHandle, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveObjectList(int nativeHandle, ArrayList<SpenObjectBase> objectList) {
            return SpenWPage.WPage_RemoveObjectList(nativeHandle, objectList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveObjects(int nativeHandle, int typeFilter) {
            return SpenWPage.WPage_RemoveObjects(nativeHandle, typeFilter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_RemoveSelectedObject(int nativeHandle) {
            return SpenWPage.WPage_RemoveSelectedObject(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetBackgroundColor(int nativeHandle, int color, boolean skipHistory) {
            return SpenWPage.WPage_SetBackgroundColor(nativeHandle, color, skipHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetBackgroundImage(int nativeHandle, String sourceUri, boolean skipHistory) {
            return SpenWPage.WPage_SetBackgroundImage(nativeHandle, sourceUri, skipHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetBackgroundImageById(int nativeHandle, int fileId, boolean skipHistory) {
            return SpenWPage.WPage_SetBackgroundImageById(nativeHandle, fileId, skipHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetBackgroundImageMode(int nativeHandle, int mode) {
            return SpenWPage.WPage_SetBackgroundImageMode(nativeHandle, mode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetPDFData(int nativeHandle, ArrayList<PDFData> pdfData) {
            return SpenWPage.WPage_SetPDFData(nativeHandle, pdfData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetRecognizedDataModifiedTime(int nativeHandle, long modifiedTime) {
            return SpenWPage.WPage_SetRecognizedDataModifiedTime(nativeHandle, modifiedTime);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetSize(int nativeHandle, int width, int height) {
            return SpenWPage.WPage_SetSize(nativeHandle, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetStrokeRecognitionData(int nativeHandle, ArrayList<StrokeRecognitionData> dataList) {
            return SpenWPage.WPage_SetStrokeRecognitionData(nativeHandle, dataList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetTemplateType(int nativeHandle, int type) {
            return SpenWPage.WPage_SetTemplateType(nativeHandle, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_SetTemplateURI(int nativeHandle, String uri) {
            return SpenWPage.WPage_SetTemplateURI(nativeHandle, uri);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WPage_TransferObjects(int nativeHandle, SpenPageDoc pageDoc, float magnification, PointF offset) {
            return SpenWPage.WPage_TransferObjects(nativeHandle, pageDoc, magnification, offset);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void WPage_finalize(int nativeHandle) {
            SpenWPage.WPage_finalize(nativeHandle);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$PDFData;", "", "<init>", "()V", "index", "", "rect", "Landroid/graphics/RectF;", "password", "", "filePath", "getFilePath", "()Ljava/lang/String;", "boundFileId", "getBoundFileId", "()I", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class PDFData {
        private final int boundFileId;

        @Nullable
        private final String filePath;

        @JvmField
        public int index;

        @JvmField
        @Nullable
        public String password;

        @JvmField
        @NotNull
        public RectF rect = new RectF();

        public final int getBoundFileId() {
            return this.boundFileId;
        }

        @Nullable
        public final String getFilePath() {
            return this.filePath;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$SearchData;", "", "<init>", "()V", "type", "", "rect", "Landroid/graphics/Rect;", "text", "", "pageWidth", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SearchData {
        public static final int SEARCHDATA_TYPE_STROKE = 1;
        public static final int SEARCHDATA_TYPE_TEXTBOX = 0;

        @JvmField
        public int pageWidth;

        @JvmField
        @Nullable
        public Rect rect;

        @JvmField
        @Nullable
        public String text;

        @JvmField
        public int type;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$StrokeRecognitionData;", "", "<init>", "()V", "text", "", "rect", "Landroid/graphics/Rect;", "pageWidth", "", "actionLinkData", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$StrokeRecognitionData$LinkData;", "LinkData", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class StrokeRecognitionData {

        @JvmField
        @Nullable
        public LinkData actionLinkData;

        @JvmField
        public int pageWidth = -1;

        @JvmField
        @Nullable
        public Rect rect;

        @JvmField
        @Nullable
        public String text;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$StrokeRecognitionData$LinkData;", "", "<init>", "()V", "type", "", "firstCharRect", "Landroid/graphics/Rect;", "lastCharRect", "indexList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "repObjectUuid", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class LinkData {
            public static final int LINK_TYPE_EMAIL = 2;
            public static final int LINK_TYPE_FORMULA = 3;
            public static final int LINK_TYPE_PHONE = 0;
            public static final int LINK_TYPE_URL = 1;

            @JvmField
            @Nullable
            public Rect firstCharRect;

            @JvmField
            @Nullable
            public ArrayList<Integer> indexList;

            @JvmField
            @Nullable
            public Rect lastCharRect;

            @JvmField
            @Nullable
            public String repObjectUuid;

            @JvmField
            public int type = -1;
        }
    }

    private SpenWPage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_AppendCustomObject(int i, SpenCustomObject spenCustomObject);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_AppendObject(int i, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_AppendObjectList(int i, ArrayList<SpenObjectBase> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void WPage_ClearCanvasCacheData(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void WPage_ClearChangedFlag(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_Copy(int i, SpenWPage spenWPage, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_FindObjectAtPosition(int i, int i2, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_FindObjectAtPositionWithThreshold(int i, int i2, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_FindObjectInClosedCurve(int i, int i2, PointF[] pointFArr, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_FindObjectInRect(int i, int i2, RectF rectF, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_FindObjectInRectIntersect(int i, int i2, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectBase WPage_FindTopObjectAtPosition(int i, int i2, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectBase WPage_FindTopObjectAtPositionWithThreshold(int i, int i2, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetBackgroundColor(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Bitmap WPage_GetBackgroundImage(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetBackgroundImageId(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetBackgroundImageMode(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WPage_GetBackgroundImagePath(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WPage_GetCanvasCachePath(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenCustomObject WPage_GetCustomObject(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetCustomObjectCount(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF WPage_GetDrawnRectOfAllObject(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetHeight(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WPage_GetId(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WPage_GetModifiedTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectBase WPage_GetObject(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectBase WPage_GetObjectByRuntimeHandle(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetObjectCount(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetObjectCount2(int i, boolean z, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetObjectIndex(int i, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_GetObjectList(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenObjectBase> WPage_GetObjectList2(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Point WPage_GetOffset(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<PDFData> WPage_GetPDFData(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WPage_GetRecognizedDataModifiedTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetRuntimeHandle(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<StrokeRecognitionData> WPage_GetStrokeRecognitionData(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetTemplateType(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WPage_GetTemplateURI(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WPage_GetWidth(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_HasBackgroundImage(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_HasPDF(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_InsertCustomObject(int i, SpenCustomObject spenCustomObject, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_InsertObject(int i, SpenObjectBase spenObjectBase, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_InsertObjectList(int i, ArrayList<SpenObjectBase> arrayList, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_IsChanged(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_IsEditingByCoedit(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_IsObjectInRect(int i, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_IsValid(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_MoveAllObject(int i, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_MoveObject(int i, ArrayList<SpenObjectBase> arrayList, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_MoveObject1(int i, ArrayList<SpenObjectBase> arrayList, SpenWPage spenWPage, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_MoveObject2(int i, ArrayList<SpenObjectBase> arrayList, SpenObjectContainer spenObjectContainer);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_MoveObjectIndex(int i, SpenObjectBase spenObjectBase, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveAllCustomObject(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveAllObject(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveCustomObject(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveCustomObject1(int i, SpenCustomObject spenCustomObject);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveObject(int i, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveObjectList(int i, ArrayList<SpenObjectBase> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveObjects(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_RemoveSelectedObject(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetBackgroundColor(int i, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetBackgroundImage(int i, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetBackgroundImageById(int i, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetBackgroundImageMode(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetPDFData(int i, ArrayList<PDFData> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetRecognizedDataModifiedTime(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetSize(int i, int i2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetStrokeRecognitionData(int i, ArrayList<StrokeRecognitionData> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetTemplateType(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_SetTemplateURI(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WPage_TransferObjects(int i, SpenPageDoc spenPageDoc, float f, PointF pointF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void WPage_finalize(int i);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenWPage(" + this + ") is already closed");
    }

    public final void appendCustomObject(@NotNull SpenCustomObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (INSTANCE.WPage_AppendCustomObject(this.mHandle, obj)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendObject(@Nullable SpenObjectBase obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.WPage_AppendObject(this.mHandle, obj)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendObjectList(@Nullable ArrayList<SpenObjectBase> objectList) {
        if (objectList == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.WPage_AppendObjectList(this.mHandle, objectList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void clearCanvasCacheData() {
        INSTANCE.WPage_ClearCanvasCacheData(this.mHandle);
    }

    public final void clearChangedFlag() {
        INSTANCE.WPage_ClearChangedFlag(this.mHandle);
    }

    @Deprecated(message = "")
    public final void copy(@NotNull SpenWPage sourcePage) {
        Intrinsics.checkNotNullParameter(sourcePage, "sourcePage");
        if (INSTANCE.WPage_Copy(this.mHandle, sourcePage, sourcePage.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final SpenObjectBase createObject(int type) {
        return SpenObjectFactory.createObject(type);
    }

    public boolean equals(@Nullable Object o) {
        return (o instanceof SpenWPage) && this.mHandle == ((SpenWPage) o).mHandle;
    }

    public final void finalize() {
        INSTANCE.WPage_finalize(this.mHandle);
        this.mHandle = -1;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectAtPosition(int typeFilter, float x, float y2) {
        ArrayList<SpenObjectBase> arrayListWPage_FindObjectAtPosition = INSTANCE.WPage_FindObjectAtPosition(this.mHandle, typeFilter, x, y2);
        if (arrayListWPage_FindObjectAtPosition == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_FindObjectAtPosition);
        return arrayListWPage_FindObjectAtPosition;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectInClosedCurve(int typeFilter, @NotNull PointF[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        ArrayList<SpenObjectBase> arrayListWPage_FindObjectInClosedCurve = INSTANCE.WPage_FindObjectInClosedCurve(this.mHandle, typeFilter, points, points.length);
        if (arrayListWPage_FindObjectInClosedCurve == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_FindObjectInClosedCurve);
        return arrayListWPage_FindObjectInClosedCurve;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectInRect(int typeFilter, @NotNull RectF rectf, boolean allAreas) {
        Intrinsics.checkNotNullParameter(rectf, "rectf");
        ArrayList<SpenObjectBase> arrayListWPage_FindObjectInRect = INSTANCE.WPage_FindObjectInRect(this.mHandle, typeFilter, rectf, allAreas);
        if (arrayListWPage_FindObjectInRect == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_FindObjectInRect);
        return arrayListWPage_FindObjectInRect;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectInRectIntersect(int typeFilter, @Nullable RectF rectf) {
        ArrayList<SpenObjectBase> arrayListWPage_FindObjectInRectIntersect = INSTANCE.WPage_FindObjectInRectIntersect(this.mHandle, typeFilter, rectf);
        if (arrayListWPage_FindObjectInRectIntersect == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_FindObjectInRectIntersect);
        return arrayListWPage_FindObjectInRectIntersect;
    }

    @NotNull
    public final SpenObjectBase findTopObjectAtPosition(int typeFilter, float x, float y2) {
        return INSTANCE.WPage_FindTopObjectAtPosition(this.mHandle, typeFilter, x, y2);
    }

    public final int getBackgroundColor() {
        return INSTANCE.WPage_GetBackgroundColor(this.mHandle);
    }

    @NotNull
    public final Bitmap getBackgroundImage() {
        return INSTANCE.WPage_GetBackgroundImage(this.mHandle);
    }

    public final int getBackgroundImageId() {
        return INSTANCE.WPage_GetBackgroundImageId(this.mHandle);
    }

    public final int getBackgroundImageMode() {
        return INSTANCE.WPage_GetBackgroundImageMode(this.mHandle);
    }

    @NotNull
    public final String getBackgroundImagePath() {
        return INSTANCE.WPage_GetBackgroundImagePath(this.mHandle);
    }

    @Nullable
    public final SpenCustomObject getCustomObject(int index) {
        SpenCustomObject spenCustomObjectWPage_GetCustomObject = INSTANCE.WPage_GetCustomObject(this.mHandle, index);
        if (spenCustomObjectWPage_GetCustomObject == null) {
            throwUncheckedException(SpenError.getError());
        }
        return spenCustomObjectWPage_GetCustomObject;
    }

    public final int getCustomObjectCount() {
        return INSTANCE.WPage_GetCustomObjectCount(this.mHandle);
    }

    @NotNull
    public final RectF getDrawnRectOfAllObject() {
        return INSTANCE.WPage_GetDrawnRectOfAllObject(this.mHandle);
    }

    public final int getHeight() {
        return INSTANCE.WPage_GetHeight(this.mHandle);
    }

    @NotNull
    public final String getId() {
        return INSTANCE.WPage_GetId(this.mHandle);
    }

    public final long getModifiedTime() {
        return INSTANCE.WPage_GetModifiedTime(this.mHandle);
    }

    @Nullable
    public final SpenObjectBase getObject(int index) {
        SpenObjectBase spenObjectBaseWPage_GetObject = INSTANCE.WPage_GetObject(this.mHandle, index);
        if (spenObjectBaseWPage_GetObject == null) {
            throwUncheckedException(SpenError.getError());
        }
        return spenObjectBaseWPage_GetObject;
    }

    @NotNull
    public final SpenObjectBase getObjectByRuntimeHandle(int runtimeHandle) {
        SpenObjectBase spenObjectBaseWPage_GetObjectByRuntimeHandle = INSTANCE.WPage_GetObjectByRuntimeHandle(this.mHandle, runtimeHandle);
        if (spenObjectBaseWPage_GetObjectByRuntimeHandle == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenObjectBaseWPage_GetObjectByRuntimeHandle);
        return spenObjectBaseWPage_GetObjectByRuntimeHandle;
    }

    public final int getObjectCount(boolean includeInvisible) {
        return INSTANCE.WPage_GetObjectCount(this.mHandle, includeInvisible);
    }

    public final int getObjectIndex(@Nullable SpenObjectBase obj) {
        int iWPage_GetObjectIndex = INSTANCE.WPage_GetObjectIndex(this.mHandle, obj);
        if (iWPage_GetObjectIndex == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return iWPage_GetObjectIndex;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> getObjectList() {
        ArrayList<SpenObjectBase> arrayListWPage_GetObjectList = INSTANCE.WPage_GetObjectList(this.mHandle);
        if (arrayListWPage_GetObjectList == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_GetObjectList);
        return arrayListWPage_GetObjectList;
    }

    @NotNull
    public final Point getOffset() {
        return INSTANCE.WPage_GetOffset(this.mHandle);
    }

    @Nullable
    public final ArrayList<PDFData> getPDFData() {
        return getPdfData();
    }

    @Nullable
    public final ArrayList<PDFData> getPdfData() {
        return INSTANCE.WPage_GetPDFData(this.mHandle);
    }

    public final long getRecognizedDataModifiedTime() {
        return INSTANCE.WPage_GetRecognizedDataModifiedTime(this.mHandle);
    }

    public final int getRuntimeHandle() {
        return INSTANCE.WPage_GetRuntimeHandle(this.mHandle);
    }

    @Nullable
    public final ArrayList<StrokeRecognitionData> getStrokeRecognitionData() {
        ArrayList<StrokeRecognitionData> arrayListWPage_GetStrokeRecognitionData = INSTANCE.WPage_GetStrokeRecognitionData(this.mHandle);
        if (arrayListWPage_GetStrokeRecognitionData == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListWPage_GetStrokeRecognitionData;
    }

    public final int getTemplateType() {
        return INSTANCE.WPage_GetTemplateType(this.mHandle);
    }

    @Nullable
    public final String getTemplateURI() {
        return INSTANCE.WPage_GetTemplateURI(this.mHandle);
    }

    public final int getWidth() {
        return INSTANCE.WPage_GetWidth(this.mHandle);
    }

    public final boolean hasBackgroundImage() {
        return INSTANCE.WPage_HasBackgroundImage(this.mHandle);
    }

    public final boolean hasPDF() {
        return INSTANCE.WPage_HasPDF(this.mHandle);
    }

    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getMHandle() {
        return this.mHandle;
    }

    public final void insertCustomObject(@NotNull SpenCustomObject obj, int index) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (INSTANCE.WPage_InsertCustomObject(this.mHandle, obj, index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertObject(@Nullable SpenObjectBase obj, int index) {
        if (INSTANCE.WPage_InsertObject(this.mHandle, obj, index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertObjectList(@Nullable ArrayList<SpenObjectBase> objectList, int index) {
        if (INSTANCE.WPage_InsertObjectList(this.mHandle, objectList, index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean isChanged() {
        return INSTANCE.WPage_IsChanged(this.mHandle);
    }

    public final boolean isEditingByCoedit() {
        return INSTANCE.WPage_IsEditingByCoedit(this.mHandle);
    }

    public final boolean isObjectContained(@Nullable SpenObjectBase obj) {
        if (obj != null) {
            return INSTANCE.WPage_GetObjectIndex(this.mHandle, obj) != -1;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final boolean isObjectInRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        return INSTANCE.WPage_IsObjectInRect(this.mHandle, rectF);
    }

    public final boolean isValid() {
        return INSTANCE.WPage_IsValid(this.mHandle);
    }

    public final void moveAllObject(float horizontalDelta, float verticalDelta) {
        if (INSTANCE.WPage_MoveAllObject(this.mHandle, horizontalDelta, verticalDelta)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void moveObject(@Nullable ArrayList<SpenObjectBase> objectList, @Nullable SpenWPage targetPage) {
        if (targetPage == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.WPage_MoveObject1(this.mHandle, objectList, targetPage, targetPage.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void moveObjectIndex(@Nullable SpenObjectBase obj, int step, boolean ignoreInvisible) {
        if (INSTANCE.WPage_MoveObjectIndex(this.mHandle, obj, step, ignoreInvisible)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeAllCustomObject() {
        if (INSTANCE.WPage_RemoveAllCustomObject(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeAllObject() {
        if (INSTANCE.WPage_RemoveAllObject(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeCustomObject(int index) {
        if (INSTANCE.WPage_RemoveCustomObject(this.mHandle, index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeObject(@Nullable SpenObjectBase obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.WPage_RemoveObject(this.mHandle, obj)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeObjectList(@Nullable ArrayList<SpenObjectBase> objectList) {
        if (INSTANCE.WPage_RemoveObjectList(this.mHandle, objectList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeObjects(int typeFilter) {
        if (typeFilter < 0 || typeFilter > 8388607) {
            throw new IllegalArgumentException("typeFileter is invalid");
        }
        if (INSTANCE.WPage_RemoveObjects(this.mHandle, typeFilter)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeSelectedObject() {
        if (INSTANCE.WPage_RemoveSelectedObject(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundColor(int i) {
        if (INSTANCE.WPage_SetBackgroundColor(this.mHandle, i, false)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundImage(@Nullable String filePath) {
        if (INSTANCE.WPage_SetBackgroundImage(this.mHandle, filePath, false)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundImageMode(int i) {
        if (INSTANCE.WPage_SetBackgroundImageMode(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPDFData(@Nullable ArrayList<PDFData> pdfDataList) {
        setPdfData(pdfDataList);
    }

    public final void setPdfData(@Nullable ArrayList<PDFData> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.WPage_SetPDFData(this.mHandle, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRecognizedDataModifiedTime(long j) {
        if (INSTANCE.WPage_SetRecognizedDataModifiedTime(this.mHandle, j)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean setSize(int width, int height) {
        if (INSTANCE.WPage_SetSize(this.mHandle, width, height)) {
            return true;
        }
        throwUncheckedException(SpenError.getError());
        return true;
    }

    public final void setStrokeRecognitionData(@Nullable ArrayList<StrokeRecognitionData> arrayList) {
        Companion companion = INSTANCE;
        int i = this.mHandle;
        Intrinsics.checkNotNull(arrayList);
        if (companion.WPage_SetStrokeRecognitionData(i, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTemplateType(int i) {
        if (INSTANCE.WPage_SetTemplateType(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTemplateURI(@Nullable String str) {
        if (INSTANCE.WPage_SetTemplateURI(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void transferObjects(@Nullable SpenPageDoc page, float magnification, @NotNull PointF offset) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        if (page == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (INSTANCE.WPage_TransferObjects(this.mHandle, page, magnification, offset)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final SpenObjectBase findTopObjectAtPosition(int typeFilter, float x, float y2, float threshold) {
        return INSTANCE.WPage_FindTopObjectAtPositionWithThreshold(this.mHandle, typeFilter, x, y2, threshold);
    }

    public final int getObjectCount(int typeFilter, boolean includeInvisible) {
        return INSTANCE.WPage_GetObjectCount2(this.mHandle, includeInvisible, typeFilter);
    }

    public final void removeCustomObject(@NotNull SpenCustomObject customObject) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
        if (INSTANCE.WPage_RemoveCustomObject1(this.mHandle, customObject)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundColor(int color, boolean skipHistory) {
        if (INSTANCE.WPage_SetBackgroundColor(this.mHandle, color, skipHistory)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundImage(@Nullable String filePath, boolean skipHistory) {
        if (INSTANCE.WPage_SetBackgroundImage(this.mHandle, filePath, skipHistory)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectAtPosition(int typeFilter, float x, float y2, float threshold) {
        ArrayList<SpenObjectBase> arrayListWPage_FindObjectAtPositionWithThreshold = INSTANCE.WPage_FindObjectAtPositionWithThreshold(this.mHandle, typeFilter, x, y2, threshold);
        if (arrayListWPage_FindObjectAtPositionWithThreshold == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_FindObjectAtPositionWithThreshold);
        return arrayListWPage_FindObjectAtPositionWithThreshold;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> getObjectList(int typeFilter) {
        ArrayList<SpenObjectBase> arrayListWPage_GetObjectList2 = INSTANCE.WPage_GetObjectList2(this.mHandle, typeFilter);
        if (arrayListWPage_GetObjectList2 == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListWPage_GetObjectList2);
        return arrayListWPage_GetObjectList2;
    }

    public final void moveObject(@Nullable ArrayList<SpenObjectBase> objectList, @Nullable SpenObjectContainer targetContainer) {
        if (INSTANCE.WPage_MoveObject2(this.mHandle, objectList, targetContainer)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundImage(int fileId, boolean skipHistory) {
        if (INSTANCE.WPage_SetBackgroundImageById(this.mHandle, fileId, skipHistory)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
