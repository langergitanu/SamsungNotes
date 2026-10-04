package com.samsung.android.sdk.pen.recoguifeature.converttotext;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult;
import com.samsung.android.sdk.pen.util.SpenAnalyticsUtil;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 f2\u00020\u0001:\u0001fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010$\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0018\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J0\u0010/\u001a\u00020\u00132\u001e\u00100\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101j\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u0001`32\u0006\u00104\u001a\u00020\u0013H\u0016J\b\u00105\u001a\u00020\u0013H\u0016J\b\u00106\u001a\u00020\u0013H\u0016J(\u00107\u001a\u00020\u00132\u001e\u00100\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101j\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u0001`3H\u0016J\b\u00108\u001a\u00020\u0013H\u0016J0\u00107\u001a\u00020\u00132\u001e\u00100\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101j\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u0001`32\u0006\u00104\u001a\u00020\u0013H\u0016J\u0012\u00109\u001a\u00020\u00132\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u0013H\u0016J(\u0010=\u001a\u00020\u00192\u001e\u0010>\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u000101j\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u0001`3H\u0016J\u0012\u0010@\u001a\u00020\u00192\b\u0010A\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010B\u001a\u00020\u0019H\u0016J\u0012\u0010C\u001a\u00020\u00192\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u0013H\u0002J\u0082\u0001\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u00132\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\u0016\u0010O\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\b\u0010D\u001a\u0004\u0018\u00010?2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020Q01j\b\u0012\u0004\u0012\u00020Q`3H\u0002J\b\u0010R\u001a\u00020\u0019H\u0002J<\u0010S\u001a\u00020\u00132\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\u001a\u0010U\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u000101j\n\u0012\u0004\u0012\u000202\u0018\u0001`3H\u0002J\u0010\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u0013H\u0002J\u0010\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u0013H\u0002J\u0018\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u0013H\u0002JP\u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u00020\u00132\u001a\u00100\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010201j\n\u0012\u0006\u0012\u0004\u0018\u000102`32\u001a\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010201j\n\u0012\u0006\u0012\u0004\u0018\u000102`32\u0006\u0010_\u001a\u00020\u0013H\u0002Jt\u0010`\u001a\u00020\u00192\u0006\u0010^\u001a\u00020\u00132\u001a\u00100\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010201j\n\u0012\u0006\u0012\u0004\u0018\u000102`32\u001a\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010201j\n\u0012\u0006\u0012\u0004\u0018\u000102`32\u0006\u0010D\u001a\u00020?2\u001a\u0010P\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010Q01j\n\u0012\u0006\u0012\u0004\u0018\u00010Q`32\u0006\u0010a\u001a\u00020?H\u0002J0\u0010b\u001a\u00020\u00192\u0006\u0010c\u001a\u00020?2\u001e\u0010d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101j\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u0001`3H\u0002J\b\u0010e\u001a\u00020\u0019H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010G¨\u0006g"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManager;", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeConvertToTextView", "", "mDocument", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mSpenConvertToTextListener", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextListener;", "mSpenAutoFormatListener", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenAutoFormatListener;", "mFloatingTextResult", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/FloatingTextResult;", "mCanvasLayout", "Landroid/view/ViewGroup;", "mIsDarkModeGUI", "", "mIsDarkTransparentBackground", "mIsDarkBackground", "mMode", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextMode;", "createFloatingTextResult", "", "visibility", "", "setDocument", "doc", "setNativeHandle", "handle", "close", "closeAutoFormat", "setRecognitionListener", "l", "setAutoFormatListener", "setTextTransformEnabled", "enable", "setConvertToTextEnabled", "enabled", "setDarkModeEnabled", "isDarkModeGUI", "isDarkMode", "executeConvertToText", "executeExtractText", "executeAutoFormat", "executeAutoFormatAnalyze", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "isFullyContainedOnly", "nextAutoFormatAnalyze", "maxAutoFormatAnalyze", "executeAutoFormatRecognize", "executeAutoFormatExtractText", "executeConvertToTextFromPoint", "position", "Landroid/graphics/PointF;", "cancelConvertToText", "setRecognitionLanguageList", XmlErrorCodes.LIST, "", "setCanvasLayout", DBSchema.DocumentThumbnail.LAYOUT, "closeControl", "updateLanguage", "text", "", "isEditing", "()Z", "isFloatingViewShown", "onProgressStartEnd", "start", "onShowFloatingTextResult", "focus", "isCenterAlign", "resultViewRectList", "maxViewRectList", "originalSpanList", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "updateLayoutDirection", "isSameRectList", "rectSrc", "rectDst", "onConvertToTextFailed", "isNoHandwriting", "onConvertToTextRunning", "isRunning", "onUpdated", "isMaxLine", "isControlMoved", "OnAutoFormatAnalyzeResult", "showContext", "isTextIncluded", "OnAutoFormatRecognizeResult", "language", "printRectList", "prefix", "rectList", "OnControlClosed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenConvertToTextManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenConvertToTextManager.kt\ncom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,599:1\n1#2:600\n731#3,9:601\n37#4,2:610\n*S KotlinDebug\n*F\n+ 1 SpenConvertToTextManager.kt\ncom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManager\n*L\n461#1:601,9\n461#1:610,2\n*E\n"})
public final class SpenConvertToTextManager implements ISpenConvertToTextManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DARK_COLOR = 65793;

    @NotNull
    private static final String TAG = "ConvertToTextManager";

    @Nullable
    private ViewGroup mCanvasLayout;

    @Nullable
    private Context mContext;

    @Nullable
    private SpenWNote mDocument;

    @Nullable
    private FloatingTextResult mFloatingTextResult;
    private boolean mIsDarkBackground;
    private boolean mIsDarkModeGUI;
    private boolean mIsDarkTransparentBackground;

    @NotNull
    private SpenConvertToTextMode mMode = SpenConvertToTextMode.MODE_DEFAULT;
    private long mNativeConvertToTextView;

    @Nullable
    private SpenAutoFormatListener mSpenAutoFormatListener;

    @Nullable
    private SpenConvertToTextListener mSpenConvertToTextListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0083 J\u0011\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\u0018\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J9\u0010\u0019\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u001e\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u0001`\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0083 J\u0011\u0010\u001f\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010 \u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J9\u0010!\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u001e\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u0001`\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0083 J\u0011\u0010\"\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J!\u0010#\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0083 J\u0011\u0010'\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010(\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DARK_COLOR", "", "Native_init", "", "nativeConvertToText", "", "convertToTextManager", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManager;", "Native_finalize", "Native_onClickTextResult", "Native_closeControl", "Native_refreshTextResult", "", "Native_setTextTransformEnabled", "enable", "Native_setConvertToTextEnabled", "enabled", "Native_executeConvertToText", "Native_executeExtractText", "Native_executeAutoFormatAnalyze", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "isFullyContainedOnly", "Native_nextAutoFormatAnalyze", "Native_maxAutoFormatAnalyze", "Native_executeAutoFormatRecognize", "Native_executeAutoFormatExtractText", "Native_executeConvertToTextFromPoint", "x", "", "y", "Native_cancelConvertToText", "Native_closeAutoFormat", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_cancelConvertToText(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_cancelConvertToText(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_closeAutoFormat(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_closeAutoFormat(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_closeControl(long nativeConvertToText) {
            SpenConvertToTextManager.Native_closeControl(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_executeAutoFormatAnalyze(long nativeConvertToText, ArrayList<RectF> resultRectList, boolean isFullyContainedOnly) {
            return SpenConvertToTextManager.Native_executeAutoFormatAnalyze(nativeConvertToText, resultRectList, isFullyContainedOnly);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_executeAutoFormatExtractText(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_executeAutoFormatExtractText(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_executeAutoFormatRecognize(long nativeConvertToText, ArrayList<RectF> resultRectList, boolean isFullyContainedOnly) {
            return SpenConvertToTextManager.Native_executeAutoFormatRecognize(nativeConvertToText, resultRectList, isFullyContainedOnly);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_executeConvertToText(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_executeConvertToText(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_executeConvertToTextFromPoint(long nativeConvertToText, float x, float y2) {
            return SpenConvertToTextManager.Native_executeConvertToTextFromPoint(nativeConvertToText, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_executeExtractText(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_executeExtractText(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeConvertToText) {
            SpenConvertToTextManager.Native_finalize(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeConvertToText, SpenConvertToTextManager convertToTextManager) {
            SpenConvertToTextManager.Native_init(nativeConvertToText, convertToTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_maxAutoFormatAnalyze(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_maxAutoFormatAnalyze(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_nextAutoFormatAnalyze(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_nextAutoFormatAnalyze(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onClickTextResult(long nativeConvertToText) {
            SpenConvertToTextManager.Native_onClickTextResult(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_refreshTextResult(long nativeConvertToText) {
            return SpenConvertToTextManager.Native_refreshTextResult(nativeConvertToText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setConvertToTextEnabled(long nativeConvertToText, boolean enabled) {
            SpenConvertToTextManager.Native_setConvertToTextEnabled(nativeConvertToText, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTextTransformEnabled(long nativeConvertToText, boolean enable) {
            SpenConvertToTextManager.Native_setTextTransformEnabled(nativeConvertToText, enable);
        }

        private Companion() {
        }
    }

    public SpenConvertToTextManager(@Nullable Context context) {
        this.mContext = context;
        createFloatingTextResult(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_cancelConvertToText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_closeAutoFormat(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_closeControl(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_executeAutoFormatAnalyze(long j, ArrayList<RectF> arrayList, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_executeAutoFormatExtractText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_executeAutoFormatRecognize(long j, ArrayList<RectF> arrayList, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_executeConvertToText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_executeConvertToTextFromPoint(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_executeExtractText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenConvertToTextManager spenConvertToTextManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_maxAutoFormatAnalyze(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_nextAutoFormatAnalyze(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onClickTextResult(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_refreshTextResult(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setConvertToTextEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTextTransformEnabled(long j, boolean z);

    private final void OnAutoFormatAnalyzeResult(boolean showContext, ArrayList<RectF> resultRectList, ArrayList<RectF> resultViewRectList, boolean isTextIncluded) {
        Log.d(TAG, "[AutoFormat] OnAutoFormatAnalyzeResult showContext : " + showContext + ", isTextIncluded : " + isTextIncluded);
        SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
        if (spenAutoFormatListener != null) {
            if (showContext && resultRectList.isEmpty()) {
                Log.d(TAG, "[AutoFormat] OnAutoFormatAnalyzeResult onFailed!!");
                spenAutoFormatListener.onFailed();
            } else {
                printRectList("ConvertToTextManager::OnAutoFormatAnalyzeResult resultRectList", resultRectList);
                printRectList("ConvertToTextManager::OnAutoFormatAnalyzeResult resultViewRectList", resultViewRectList);
                spenAutoFormatListener.onResultAnalyze(showContext, resultRectList, resultViewRectList, isTextIncluded);
            }
        }
    }

    private final void OnAutoFormatRecognizeResult(boolean showContext, ArrayList<RectF> resultRectList, ArrayList<RectF> resultViewRectList, String text, ArrayList<SpenTextSpanBase> originalSpanList, String language) {
        Log.d(TAG, "[AutoFormat] OnAutoFormatRecognizeResult showContext : " + showContext + ", text.length : " + text.length() + ", language : " + language);
        SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
        if (spenAutoFormatListener != null) {
            if (showContext && (resultRectList.isEmpty() || text.length() == 0)) {
                Log.d(TAG, "[AutoFormat] OnAutoFormatRecognizeResult onFailed!!");
                spenAutoFormatListener.onFailed();
            } else {
                printRectList("ConvertToTextManager::OnAutoFormatRecognizeResult resultRectList", resultRectList);
                printRectList("ConvertToTextManager::OnAutoFormatRecognizeResult resultViewRectList", resultViewRectList);
                spenAutoFormatListener.onResultRecognize(showContext, resultRectList, resultViewRectList, text, originalSpanList, language);
            }
        }
    }

    private final void OnControlClosed() {
        SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
        if (spenAutoFormatListener != null) {
            Log.i(TAG, "[AutoFormat] OnControlClosed");
            spenAutoFormatListener.onControlClosed();
        }
    }

    private final void createFloatingTextResult(int visibility) {
        FloatingTextResult floatingTextResult = new FloatingTextResult(this.mContext);
        this.mFloatingTextResult = floatingTextResult;
        floatingTextResult.construct(this.mIsDarkModeGUI, this.mIsDarkTransparentBackground, this.mIsDarkBackground);
        FloatingTextResult floatingTextResult2 = this.mFloatingTextResult;
        if (floatingTextResult2 != null) {
            floatingTextResult2.setListener(new FloatingTextResult.ActionListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextManager.createFloatingTextResult.1
                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult.ActionListener
                public void onClose() {
                    if (SpenConvertToTextManager.this.mNativeConvertToTextView != 0) {
                        SpenConvertToTextManager.INSTANCE.Native_cancelConvertToText(SpenConvertToTextManager.this.mNativeConvertToTextView);
                    }
                    SpenConvertToTextListener spenConvertToTextListener = SpenConvertToTextManager.this.mSpenConvertToTextListener;
                    if (spenConvertToTextListener != null) {
                        SpenConvertToTextManager spenConvertToTextManager = SpenConvertToTextManager.this;
                        FloatingTextResult floatingTextResult3 = spenConvertToTextManager.mFloatingTextResult;
                        if (floatingTextResult3 != null) {
                            floatingTextResult3.requestTextFocus(false);
                        }
                        FloatingTextResult floatingTextResult4 = spenConvertToTextManager.mFloatingTextResult;
                        if (floatingTextResult4 != null) {
                            floatingTextResult4.clearSpan();
                        }
                        spenConvertToTextListener.onClose();
                    }
                    if ((SpenConvertToTextManager.this.mMode.getValue() & SpenConvertToTextMode.MODE_EXTRACT_TEXT.getValue()) != 0) {
                        SpenAnalyticsUtil.INSTANCE.getInstance().insertLog(411, SpenAnalyticsUtil.EVENT_WRITING_EXTRACT_TEXT_RESULT_CLOSE);
                    }
                }

                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult.ActionListener
                public void onConvert(SpannableStringBuilder spannableStringBuilder, RectF rect) {
                    boolean z;
                    SpenWNote spenWNote;
                    SpenWNote spenWNote2 = SpenConvertToTextManager.this.mDocument;
                    if (spenWNote2 == null || spenWNote2.isGroupingHistory()) {
                        z = false;
                    } else {
                        SpenWNote spenWNote3 = SpenConvertToTextManager.this.mDocument;
                        if (spenWNote3 != null) {
                            spenWNote3.beginHistoryGroup();
                        }
                        z = true;
                    }
                    if (SpenConvertToTextManager.this.mNativeConvertToTextView != 0) {
                        SpenConvertToTextManager.INSTANCE.Native_onClickTextResult(SpenConvertToTextManager.this.mNativeConvertToTextView);
                    }
                    SpenConvertToTextListener spenConvertToTextListener = SpenConvertToTextManager.this.mSpenConvertToTextListener;
                    if (spenConvertToTextListener != null) {
                        spenConvertToTextListener.onConvertToText(spannableStringBuilder, rect);
                    }
                    if (z && (spenWNote = SpenConvertToTextManager.this.mDocument) != null) {
                        spenWNote.endHistoryGroup();
                    }
                    if ((SpenConvertToTextManager.this.mMode.getValue() & SpenConvertToTextMode.MODE_EXTRACT_TEXT.getValue()) != 0) {
                        SpenAnalyticsUtil.INSTANCE.getInstance().insertLog(411, SpenAnalyticsUtil.EVENT_WRITING_EXTRACT_TEXT_RESULT_CONVERT);
                    } else {
                        SpenAnalyticsUtil.INSTANCE.getInstance().insertLog(412, SpenAnalyticsUtil.EVENT_CTT_RESULT_CONVERT);
                    }
                }

                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult.ActionListener
                public void onCopy(CharSequence text) {
                    SpenConvertToTextListener spenConvertToTextListener = SpenConvertToTextManager.this.mSpenConvertToTextListener;
                    if (spenConvertToTextListener != null && String.valueOf(text).length() != 0) {
                        spenConvertToTextListener.onCopySelected(text);
                    }
                    if ((SpenConvertToTextManager.this.mMode.getValue() & SpenConvertToTextMode.MODE_EXTRACT_TEXT.getValue()) != 0) {
                        SpenAnalyticsUtil.INSTANCE.getInstance().insertLog(411, SpenAnalyticsUtil.EVENT_WRITING_EXTRACT_TEXT_RESULT_COPY);
                    } else {
                        SpenAnalyticsUtil.INSTANCE.getInstance().insertLog(412, SpenAnalyticsUtil.EVENT_CTT_RESULT_COPY);
                    }
                }

                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult.ActionListener
                public void onEditTextOverflow(boolean isLine) {
                    SpenConvertToTextListener spenConvertToTextListener = SpenConvertToTextManager.this.mSpenConvertToTextListener;
                    if (spenConvertToTextListener != null) {
                        if (isLine) {
                            spenConvertToTextListener.onEditLineOverflow(50);
                        } else {
                            spenConvertToTextListener.onEditTextOverflow(3000);
                        }
                    }
                }

                @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult.ActionListener
                public void onSetting() {
                    SpenConvertToTextListener spenConvertToTextListener = SpenConvertToTextManager.this.mSpenConvertToTextListener;
                    if (spenConvertToTextListener != null) {
                        spenConvertToTextListener.onSetting();
                    }
                    if ((SpenConvertToTextManager.this.mMode.getValue() & SpenConvertToTextMode.MODE_EXTRACT_TEXT.getValue()) != 0) {
                        SpenAnalyticsUtil.INSTANCE.getInstance().insertLog(411, SpenAnalyticsUtil.EVENT_WRITING_EXTRACT_TEXT_RESULT_SETTINGS);
                    }
                }
            });
        }
        FloatingTextResult floatingTextResult3 = this.mFloatingTextResult;
        if (floatingTextResult3 != null) {
            floatingTextResult3.setVisibility(visibility);
        }
    }

    private final boolean isSameRectList(ArrayList<RectF> rectSrc, ArrayList<RectF> rectDst) {
        if (rectDst == null || rectDst.size() != rectSrc.size()) {
            return false;
        }
        int size = rectDst.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual(rectDst.get(i), rectSrc.get(i))) {
                return false;
            }
        }
        return true;
    }

    private final void onConvertToTextFailed(boolean isNoHandwriting) {
        if ((this.mMode.getValue() & SpenConvertToTextMode.MODE_AUTO_FORMAT.getValue()) != 0 && this.mSpenAutoFormatListener != null) {
            AbstractC6670b.m4759t("[AutoFormat] onConvertToTextFailed isNoHandwriting :", TAG, isNoHandwriting);
            SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
            if (spenAutoFormatListener != null) {
                spenAutoFormatListener.onRecognitionFailed(isNoHandwriting);
                return;
            }
            return;
        }
        if (this.mSpenConvertToTextListener != null) {
            AbstractC6670b.m4759t("onConvertToTextFailed isNoHandwriting :", TAG, isNoHandwriting);
            SpenConvertToTextListener spenConvertToTextListener = this.mSpenConvertToTextListener;
            if (spenConvertToTextListener != null) {
                spenConvertToTextListener.onConvertToTextFailed(isNoHandwriting);
            }
        }
    }

    private final void onConvertToTextRunning(boolean isRunning) {
        if ((this.mMode.getValue() & SpenConvertToTextMode.MODE_AUTO_FORMAT.getValue()) == 0 || this.mSpenAutoFormatListener == null) {
            AbstractC6670b.m4759t("onConvertToTextRunning isRunning :", TAG, isRunning);
            SpenConvertToTextListener spenConvertToTextListener = this.mSpenConvertToTextListener;
            if (spenConvertToTextListener != null) {
                spenConvertToTextListener.onConvertToTextRunning(isRunning);
                return;
            }
            return;
        }
        AbstractC6670b.m4759t("[AutoFormat] onConvertToTextRunning isRunning :", TAG, isRunning);
        SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
        if (spenAutoFormatListener != null) {
            spenAutoFormatListener.onRecognitionRunning(isRunning);
        }
    }

    private final void onProgressStartEnd(boolean start) {
        if ((this.mMode.getValue() & SpenConvertToTextMode.MODE_AUTO_FORMAT.getValue()) == 0 || this.mSpenAutoFormatListener == null) {
            SpenConvertToTextListener spenConvertToTextListener = this.mSpenConvertToTextListener;
            if (spenConvertToTextListener != null) {
                AbstractC6670b.m4759t("onProgressStartEnd : ", TAG, start);
                if (start) {
                    spenConvertToTextListener.onProgressStart();
                    return;
                } else {
                    spenConvertToTextListener.onProgressStop();
                    return;
                }
            }
            return;
        }
        AbstractC6670b.m4759t("[AutoFormat] onProgressStartEnd : ", TAG, start);
        if (start) {
            SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
            if (spenAutoFormatListener != null) {
                spenAutoFormatListener.onProgressStart();
                return;
            }
            return;
        }
        SpenAutoFormatListener spenAutoFormatListener2 = this.mSpenAutoFormatListener;
        if (spenAutoFormatListener2 != null) {
            spenAutoFormatListener2.onProgressStop();
        }
    }

    private final void onShowFloatingTextResult(boolean focus, boolean isCenterAlign, ArrayList<RectF> resultRectList, ArrayList<RectF> resultViewRectList, ArrayList<RectF> maxViewRectList, String text, ArrayList<SpenTextSpanBase> originalSpanList) {
        FloatingTextResult floatingTextResult;
        FloatingTextResult floatingTextResult2;
        SpenWPage page;
        if ((this.mMode.getValue() & SpenConvertToTextMode.MODE_AUTO_FORMAT.getValue()) != 0) {
            Log.e(TAG, "[AutoFormat] onShowFloatingTextResult");
            return;
        }
        if (this.mFloatingTextResult == null) {
            createFloatingTextResult(0);
            ViewGroup viewGroup = this.mCanvasLayout;
            if (viewGroup != null) {
                viewGroup.addView(this.mFloatingTextResult);
            }
        }
        if (text != null && text.length() != 0) {
            SpenConvertToTextListener spenConvertToTextListener = this.mSpenConvertToTextListener;
            if (spenConvertToTextListener != null && focus) {
                spenConvertToTextListener.onUpdateRecognitionLanguage();
            }
            updateLayoutDirection();
            FloatingTextResult floatingTextResult3 = this.mFloatingTextResult;
            if (floatingTextResult3 != null) {
                floatingTextResult3.showPreview(isCenterAlign, text, originalSpanList, resultRectList, resultViewRectList, maxViewRectList);
            }
        }
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null && this.mIsDarkModeGUI && !this.mIsDarkTransparentBackground) {
            int backgroundColor = (spenWNote == null || (page = spenWNote.getPage(0)) == null) ? 0 : page.getBackgroundColor();
            FloatingTextResult floatingTextResult4 = this.mFloatingTextResult;
            if (floatingTextResult4 != null) {
                floatingTextResult4.setBgColorDarkMode(backgroundColor);
            }
        }
        if (focus) {
            FloatingTextResult floatingTextResult5 = this.mFloatingTextResult;
            if (floatingTextResult5 != null) {
                floatingTextResult5.setVisibility(0);
            }
            FloatingTextResult floatingTextResult6 = this.mFloatingTextResult;
            if (floatingTextResult6 != null && floatingTextResult6.hasFocus() && (floatingTextResult2 = this.mFloatingTextResult) != null) {
                floatingTextResult2.requestTextFocus(true);
            }
        } else {
            FloatingTextResult floatingTextResult7 = this.mFloatingTextResult;
            if (floatingTextResult7 != null && floatingTextResult7.isTextFocused() && (floatingTextResult = this.mFloatingTextResult) != null) {
                floatingTextResult.requestTextFocus(false);
            }
            FloatingTextResult floatingTextResult8 = this.mFloatingTextResult;
            if (floatingTextResult8 != null) {
                floatingTextResult8.clearSpan();
            }
            FloatingTextResult floatingTextResult9 = this.mFloatingTextResult;
            if (floatingTextResult9 != null) {
                floatingTextResult9.setVisibility(8);
            }
            SpenConvertToTextListener spenConvertToTextListener2 = this.mSpenConvertToTextListener;
            if (spenConvertToTextListener2 != null) {
                spenConvertToTextListener2.onFinished();
            }
        }
        AbstractC4539a.m3208r("SpenConvertToTextManager::onFloatingTextResult focus:", TAG, focus);
    }

    private final void onUpdated(boolean isMaxLine, boolean isControlMoved) {
        if ((this.mMode.getValue() & SpenConvertToTextMode.MODE_AUTO_FORMAT.getValue()) == 0 || this.mSpenAutoFormatListener == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{String.valueOf(isMaxLine), String.valueOf(isControlMoved)}, 2, "[AutoFormat] onUpdated isMaxLine[%s], isControlMoved[%s]", "format(format, *args)", TAG);
        SpenAutoFormatListener spenAutoFormatListener = this.mSpenAutoFormatListener;
        if (spenAutoFormatListener != null) {
            spenAutoFormatListener.onUpdated(isMaxLine, isControlMoved);
        }
    }

    private final void printRectList(String prefix, ArrayList<RectF> rectList) {
        if (rectList == null) {
            return;
        }
        int size = rectList.size();
        for (int i = 0; i < size; i++) {
            RectF rectF = rectList.get(i);
            Float fValueOf = null;
            Float fValueOf2 = rectF != null ? Float.valueOf(rectF.left) : null;
            RectF rectF2 = rectList.get(i);
            Float fValueOf3 = rectF2 != null ? Float.valueOf(rectF2.top) : null;
            RectF rectF3 = rectList.get(i);
            Float fValueOf4 = rectF3 != null ? Float.valueOf(rectF3.right) : null;
            RectF rectF4 = rectList.get(i);
            if (rectF4 != null) {
                fValueOf = Float.valueOf(rectF4.bottom);
            }
            Log.d(TAG, prefix + "[" + i + "] (l:" + fValueOf2 + ", t:" + fValueOf3 + ", r:" + fValueOf4 + ", b:" + fValueOf + ")");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateLayoutDirection() {
        String[] strArr;
        String str;
        List listM13999t;
        List listEmptyList;
        String language = SPenRecognitionWorker.INSTANCE.getLanguage(this.mContext);
        if (language == null || (listM13999t = AbstractC12991c.m13999t(0, "_", language)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                strArr = (String[]) listEmptyList.toArray(new String[0]);
            }
        }
        Locale locale = (strArr == null || (str = strArr[0]) == null) ? Locale.getDefault() : new Locale(str);
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null) {
            floatingTextResult.setLayoutDirection(TextUtils.getLayoutDirectionFromLocale(locale));
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean cancelConvertToText() {
        Log.i(TAG, "SpenConvertToTextManager::cancelConvertToText");
        long j = this.mNativeConvertToTextView;
        if (j == 0 || !INSTANCE.Native_cancelConvertToText(j)) {
            return false;
        }
        SpenConvertToTextListener spenConvertToTextListener = this.mSpenConvertToTextListener;
        if (spenConvertToTextListener == null) {
            return true;
        }
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null) {
            floatingTextResult.requestTextFocus(false);
        }
        FloatingTextResult floatingTextResult2 = this.mFloatingTextResult;
        if (floatingTextResult2 != null) {
            floatingTextResult2.clearSpan();
        }
        spenConvertToTextListener.onClose();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void close() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null) {
            floatingTextResult.close();
        }
        this.mFloatingTextResult = null;
        this.mContext = null;
        this.mCanvasLayout = null;
        long j = this.mNativeConvertToTextView;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mNativeConvertToTextView = 0L;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean closeAutoFormat() {
        long j = this.mNativeConvertToTextView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_closeAutoFormat(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void closeControl() {
        Log.i(TAG, "SpenConvertToTextManager::closeControl");
        long j = this.mNativeConvertToTextView;
        if (j != 0) {
            INSTANCE.Native_closeControl(j);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormat() {
        Log.i(TAG, "[AutoFormat Legacy API] executeAutoFormat");
        return executeAutoFormatRecognize(null);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatAnalyze() {
        return executeAutoFormatAnalyze(null, false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatExtractText() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "SpenConvertToTextManager::executeAutoFormatExtractText FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "SpenConvertToTextManager::executeAutoFormatExtractText");
        this.mMode = SpenConvertToTextMode.MODE_AUTO_FORMAT_EXTRACT_TEXT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_executeAutoFormatExtractText(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatRecognize(@Nullable ArrayList<RectF> resultRectList) {
        return executeAutoFormatRecognize(resultRectList, false);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeConvertToText() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "SpenConvertToTextManager::executeConvertToText FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "SpenConvertToTextManager::executeConvertToText");
        this.mMode = SpenConvertToTextMode.MODE_DEFAULT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_executeConvertToText(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeConvertToTextFromPoint(@Nullable PointF position) {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "SpenConvertToTextManager::executeConvertToTextFromPoint FloatingTextResult is already running.");
            return true;
        }
        if (position != null) {
            Log.i(TAG, "SpenConvertToTextManager:: executeConvertToText x:" + position.x + ", y:" + position.y);
            this.mMode = SpenConvertToTextMode.MODE_DEFAULT;
            long j = this.mNativeConvertToTextView;
            if (j != 0 && INSTANCE.Native_executeConvertToTextFromPoint(j, position.x, position.y)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeExtractText() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "SpenConvertToTextManager::executeExtractText FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "SpenConvertToTextManager::executeExtractText");
        this.mMode = SpenConvertToTextMode.MODE_EXTRACT_TEXT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_executeExtractText(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean isEditing() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        boolean z = false;
        if (floatingTextResult != null && floatingTextResult.isTextFocused()) {
            z = true;
        }
        FloatingTextResult floatingTextResult2 = this.mFloatingTextResult;
        Log.i(TAG, "SpenConvertToTextManager::isEditing - mFloatingTextResult.isTextFocused() = " + (floatingTextResult2 != null ? Boolean.valueOf(floatingTextResult2.isTextFocused()) : "null") + ", return " + z);
        return z;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean isFloatingViewShown() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        return floatingTextResult != null && floatingTextResult.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean maxAutoFormatAnalyze() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "[AutoFormat] maxAutoFormatAnalyze FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "[AutoFormat] maxAutoFormatAnalyze");
        this.mMode = SpenConvertToTextMode.MODE_AUTO_FORMAT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_maxAutoFormatAnalyze(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean nextAutoFormatAnalyze() {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "[AutoFormat] nextAutoFormatAnalyze FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "[AutoFormat] nextAutoFormatAnalyze");
        this.mMode = SpenConvertToTextMode.MODE_AUTO_FORMAT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_nextAutoFormatAnalyze(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setAutoFormatListener(@Nullable SpenAutoFormatListener l) {
        this.mSpenAutoFormatListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setCanvasLayout(@Nullable ViewGroup layout) {
        Log.i(TAG, "SpenConvertToTextManager::setCanvasLayout");
        this.mCanvasLayout = layout;
        if (layout != null) {
            FloatingTextResult floatingTextResult = this.mFloatingTextResult;
            if (floatingTextResult != null) {
                floatingTextResult.removeParentView();
            }
            layout.addView(this.mFloatingTextResult);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setConvertToTextEnabled(boolean enabled) {
        long j = this.mNativeConvertToTextView;
        if (j != 0) {
            INSTANCE.Native_setConvertToTextEnabled(j, enabled);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setDarkModeEnabled(boolean isDarkModeGUI, boolean isDarkMode) {
        AbstractC6670b.m4758s("SpenConvertToTextManager::setDarkModeEnabled isDarkModeGUI : ", ", isDarkMode : ", TAG, isDarkModeGUI, isDarkMode);
        SpenWNote spenWNote = this.mDocument;
        boolean z = false;
        if (spenWNote != null && (spenWNote.getPage(0).getBackgroundColor() & 16777215) == DARK_COLOR) {
            z = true;
        }
        if (this.mIsDarkModeGUI == isDarkModeGUI && this.mIsDarkTransparentBackground == isDarkMode && this.mIsDarkBackground == z) {
            return;
        }
        this.mIsDarkModeGUI = isDarkModeGUI;
        this.mIsDarkTransparentBackground = isDarkMode;
        this.mIsDarkBackground = z;
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        Integer numValueOf = floatingTextResult != null ? Integer.valueOf(floatingTextResult.getVisibility()) : null;
        this.mFloatingTextResult = null;
        if (numValueOf != null) {
            createFloatingTextResult(numValueOf.intValue());
        }
        ViewGroup viewGroup = this.mCanvasLayout;
        if (viewGroup != null) {
            viewGroup.addView(this.mFloatingTextResult);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setDocument(@Nullable SpenWNote doc) {
        this.mDocument = doc;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setNativeHandle(long handle) {
        this.mNativeConvertToTextView = handle;
        if (handle != 0) {
            INSTANCE.Native_init(handle, this);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setRecognitionLanguageList(@Nullable ArrayList<String> list) {
        Log.i(TAG, "SpenConvertToTextManager::setRecognitionLanguageList");
        if (list == null || list.size() == 0) {
            return;
        }
        SPenRecognitionWorker.setLanguage(list.get(0));
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setRecognitionListener(@Nullable SpenConvertToTextListener l) {
        this.mSpenConvertToTextListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void setTextTransformEnabled(boolean enable) {
        long j = this.mNativeConvertToTextView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setTextTransformEnabled(j, enable);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public void updateLanguage(@Nullable CharSequence text) {
        if (text == null || text.length() <= 0) {
            Log.e(TAG, "SpenConvertToTextManager::updateLanguage text == null || text.length() <= 0");
            return;
        }
        Log.i(TAG, "SpenConvertToTextManager::updateLanguage - " + ((Object) text));
        if (SPenRecognitionWorker.setLanguage(text.toString())) {
            FloatingTextResult floatingTextResult = this.mFloatingTextResult;
            if (floatingTextResult != null) {
                floatingTextResult.clearSpan();
            }
            SPenRecognitionWorker.initializeSelf(this.mContext);
            long j = this.mNativeConvertToTextView;
            if (j != 0) {
                INSTANCE.Native_refreshTextResult(j);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatAnalyze(@Nullable ArrayList<RectF> resultRectList, boolean isFullyContainedOnly) {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "[AutoFormat] executeAutoFormatAnalyze FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "[AutoFormat] executeAutoFormatAnalyze");
        printRectList("executeAutoFormatAnalyze", resultRectList);
        this.mMode = SpenConvertToTextMode.MODE_AUTO_FORMAT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_executeAutoFormatAnalyze(j, resultRectList, isFullyContainedOnly);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager
    public boolean executeAutoFormatRecognize(@Nullable ArrayList<RectF> resultRectList, boolean isFullyContainedOnly) {
        FloatingTextResult floatingTextResult = this.mFloatingTextResult;
        if (floatingTextResult != null && floatingTextResult.getVisibility() == 0) {
            Log.w(TAG, "[AutoFormat] executeAutoFormatRecognize FloatingTextResult is already running.");
            return true;
        }
        Log.i(TAG, "[AutoFormat] executeAutoFormatRecognize");
        this.mMode = SpenConvertToTextMode.MODE_AUTO_FORMAT;
        long j = this.mNativeConvertToTextView;
        return j != 0 && INSTANCE.Native_executeAutoFormatRecognize(j, resultRectList, isFullyContainedOnly);
    }
}
