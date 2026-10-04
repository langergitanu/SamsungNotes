package androidx.compose.p109ui.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.LinkAnnotation;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 :2\u00020\u0001:\u00039:;B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\u0002\u0010\nBY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0096\u0002J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\"\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J*\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J$\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0007J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000J\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\u001e\u0010.\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\b\u0010/\u001a\u00020\u0013H\u0016J\u0011\u00100\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002J\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0018\u00101\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020\u0003H\u0016R$\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\"\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\"\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, m13886d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "text", "", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "spanStylesOrNull", "paragraphStylesOrNull", "annotations", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotations$ui_text_release", "()Ljava/util/List;", "length", "", "getLength", "()I", "getParagraphStyles", "getParagraphStylesOrNull$ui_text_release", "getSpanStyles", "getSpanStylesOrNull$ui_text_release", "getText", "()Ljava/lang/String;", "equals", "", "other", "get", "", "index", "getLinkAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "start", "end", "getStringAnnotations", "tag", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "hasEqualAnnotations", "hasLinkAnnotations", "hasStringAnnotations", "hashCode", "plus", "subSequence", Bixby2Constants.BIXBY_PARAM_RANGE, "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "toString", "Builder", "Companion", "Range", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnnotatedString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedString\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1271:1\n1045#2:1272\n33#3,6:1273\n235#3,3:1280\n33#3,4:1283\n238#3,2:1287\n38#3:1289\n240#3:1290\n101#3,2:1291\n33#3,6:1293\n103#3:1299\n235#3,3:1300\n33#3,4:1303\n238#3,2:1307\n38#3:1309\n240#3:1310\n235#3,3:1311\n33#3,4:1314\n238#3,2:1318\n38#3:1320\n240#3:1321\n235#3,3:1322\n33#3,4:1325\n238#3,2:1329\n38#3:1331\n240#3:1332\n235#3,3:1333\n33#3,4:1336\n238#3,2:1340\n38#3:1342\n240#3:1343\n101#3,2:1344\n33#3,6:1346\n103#3:1352\n1#4:1279\n*S KotlinDebug\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedString\n*L\n88#1:1272\n88#1:1273,6\n161#1:1280,3\n161#1:1283,4\n161#1:1287,2\n161#1:1289\n161#1:1290\n169#1:1291,2\n169#1:1293,6\n169#1:1299\n184#1:1300,3\n184#1:1303,4\n184#1:1307,2\n184#1:1309\n184#1:1310\n199#1:1311,3\n199#1:1314,4\n199#1:1318,2\n199#1:1320\n199#1:1321\n216#1:1322,3\n216#1:1325,4\n216#1:1329,2\n216#1:1331\n216#1:1332\n231#1:1333,3\n231#1:1336,4\n231#1:1340,2\n231#1:1342\n231#1:1343\n239#1:1344,2\n239#1:1346,6\n239#1:1352\n*E\n"})
public final class AnnotatedString implements CharSequence {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Saver<AnnotatedString, ?> Saver = SaversKt.getAnnotatedStringSaver();

    @Nullable
    private final List<Range<? extends Object>> annotations;

    @Nullable
    private final List<Range<ParagraphStyle>> paragraphStylesOrNull;

    @Nullable
    private final List<Range<SpanStyle>> spanStylesOrNull;

    @NotNull
    private final String text;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ&\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ \u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0007J \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0007J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0006J\u001e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u0010\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010,\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010/H\u0016J\"\u0010,\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010/2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004J\u0015\u00100\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\b,J\u0006\u00101\u001a\u00020\u001aJ\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\t2\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0013J\u000e\u00107\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0015J\u000e\u00108\u001a\u00020\t2\u0006\u0010'\u001a\u00020(J\u0010\u00109\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H\u0007J\u0006\u0010:\u001a\u00020\u0006R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00060\u0017j\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, m13886d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "text", "", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "", "(I)V", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "", "length", "getLength", "()I", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "styleStack", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addLink", "", "clickable", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "start", "end", "url", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "addStringAnnotation", "tag", MathMLUtilities.ANNOTATION_LOCAL_NAME, "addStyle", "style", "addTtsAnnotation", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "addUrlAnnotation", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", RtspHeaders.Values.APPEND, "char", "", "", "deprecated_append_returning_void", "pop", "index", "pushLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "pushStringAnnotation", "pushStyle", "pushTtsAnnotation", "pushUrlAnnotation", "toAnnotatedString", "MutableRange", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAnnotatedString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedString$Builder\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1271:1\n33#2,6:1272\n33#2,6:1278\n33#2,6:1284\n33#2,6:1290\n33#2,6:1296\n33#2,6:1302\n151#2,3:1309\n33#2,4:1312\n154#2,2:1316\n38#2:1318\n156#2:1319\n151#2,3:1320\n33#2,4:1323\n154#2,2:1327\n38#2:1329\n156#2:1330\n151#2,3:1331\n33#2,4:1334\n154#2,2:1338\n38#2:1340\n156#2:1341\n1#3:1308\n*S KotlinDebug\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedString$Builder\n*L\n437#1:1272,6\n440#1:1278,6\n444#1:1284,6\n464#1:1290,6\n467#1:1296,6\n471#1:1302,6\n743#1:1309,3\n743#1:1312,4\n743#1:1316,2\n743#1:1318\n743#1:1319\n746#1:1320,3\n746#1:1323,4\n746#1:1327,2\n746#1:1329\n746#1:1330\n749#1:1331,3\n749#1:1334,4\n749#1:1338,2\n749#1:1340\n749#1:1341\n*E\n"})
    public static final class Builder implements Appendable {
        public static final int $stable = 8;

        @NotNull
        private final List<MutableRange<? extends Object>> annotations;

        @NotNull
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;

        @NotNull
        private final List<MutableRange<SpanStyle>> spanStyles;

        @NotNull
        private final List<MutableRange<? extends Object>> styleStack;

        @NotNull
        private final StringBuilder text;

        public Builder() {
            this(0, 1, null);
        }

        public final void addLink(@NotNull LinkAnnotation.Url url, int start, int end) {
            this.annotations.add(new MutableRange<>(url, start, end, null, 8, null));
        }

        public final void addStringAnnotation(@NotNull String tag, @NotNull String annotation, int start, int end) {
            this.annotations.add(new MutableRange<>(annotation, start, end, tag));
        }

        public final void addStyle(@NotNull SpanStyle style, int start, int end) {
            this.spanStyles.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        @ExperimentalTextApi
        public final void addTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation, int start, int end) {
            this.annotations.add(new MutableRange<>(ttsAnnotation, start, end, null, 8, null));
        }

        @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "addLink(, start, end)", imports = {}))
        @ExperimentalTextApi
        public final void addUrlAnnotation(@NotNull UrlAnnotation urlAnnotation, int start, int end) {
            this.annotations.add(new MutableRange<>(urlAnnotation, start, end, null, 8, null));
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void pop() {
            if (this.styleStack.isEmpty()) {
                throw new IllegalStateException("Nothing to pop.");
            }
            this.styleStack.remove(r0.size() - 1).setEnd(this.text.length());
        }

        public final int pushLink(@NotNull LinkAnnotation link) {
            MutableRange<? extends Object> mutableRange = new MutableRange<>(link, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStringAnnotation(@NotNull String tag, @NotNull String annotation) {
            MutableRange<? extends Object> mutableRange = new MutableRange<>(annotation, this.text.length(), 0, tag, 4, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(@NotNull SpanStyle style) {
            MutableRange<SpanStyle> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation) {
            MutableRange<? extends Object> mutableRange = new MutableRange<>(ttsAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "pushLink(, start, end)", imports = {}))
        @ExperimentalTextApi
        public final int pushUrlAnnotation(@NotNull UrlAnnotation urlAnnotation) {
            MutableRange<? extends Object> mutableRange = new MutableRange<>(urlAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @NotNull
        public final AnnotatedString toAnnotatedString() {
            String string = this.text.toString();
            List<MutableRange<SpanStyle>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(list.get(i).toRange(this.text.length()));
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            List<MutableRange<ParagraphStyle>> list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList2.add(list2.get(i2).toRange(this.text.length()));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            List<MutableRange<? extends Object>> list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                arrayList3.add(list3.get(i4).toRange(this.text.length()));
            }
            return new AnnotatedString(string, arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
        }

        public Builder(int i) {
            this.text = new StringBuilder(i);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void addLink(@NotNull LinkAnnotation.Clickable clickable, int start, int end) {
            this.annotations.add(new MutableRange<>(clickable, start, end, null, 8, null));
        }

        public final void addStyle(@NotNull ParagraphStyle style, int start, int end) {
            this.paragraphStyles.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final void append(@NotNull String text) {
            this.text.append(text);
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010 \u001a\u00020\u0005J\t\u0010!\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", "", "item", "start", "", "end", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "setEnd", "(I)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "equals", "", "other", "hashCode", "toRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "defaultEnd", "toString", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nAnnotatedString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedString$Builder$MutableRange\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1271:1\n1#2:1272\n*E\n"})
        public static final /* data */ class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;

            @NotNull
            private final String tag;

            public MutableRange(T t, int i, int i2, @NotNull String str) {
                this.item = t;
                this.start = i;
                this.end = i2;
                this.tag = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MutableRange copy$default(MutableRange mutableRange, Object obj, int i, int i2, String str, int i4, Object obj2) {
                if ((i4 & 1) != 0) {
                    obj = mutableRange.item;
                }
                if ((i4 & 2) != 0) {
                    i = mutableRange.start;
                }
                if ((i4 & 4) != 0) {
                    i2 = mutableRange.end;
                }
                if ((i4 & 8) != 0) {
                    str = mutableRange.tag;
                }
                return mutableRange.copy(obj, i, i2, str);
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(i);
            }

            public final T component1() {
                return this.item;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getStart() {
                return this.start;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getEnd() {
                return this.end;
            }

            @NotNull
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getTag() {
                return this.tag;
            }

            @NotNull
            public final MutableRange<T> copy(T item, int start, int end, @NotNull String tag) {
                return new MutableRange<>(item, start, end, tag);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) other;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public final int getEnd() {
                return this.end;
            }

            public final T getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            @NotNull
            public final String getTag() {
                return this.tag;
            }

            public int hashCode() {
                T t = this.item;
                return this.tag.hashCode() + AbstractC0622a.m1157c(this.end, AbstractC0622a.m1157c(this.start, (t == null ? 0 : t.hashCode()) * 31, 31), 31);
            }

            public final void setEnd(int i) {
                this.end = i;
            }

            @NotNull
            public final Range<T> toRange(int defaultEnd) {
                int i = this.end;
                if (i != Integer.MIN_VALUE) {
                    defaultEnd = i;
                }
                if (defaultEnd != Integer.MIN_VALUE) {
                    return new Range<>(this.item, this.start, defaultEnd, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first");
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder("MutableRange(item=");
                sb.append(this.item);
                sb.append(", start=");
                sb.append(this.start);
                sb.append(", end=");
                sb.append(this.end);
                sb.append(", tag=");
                return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.tag, sb);
            }

            public /* synthetic */ MutableRange(Object obj, int i, int i2, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i, (i4 & 4) != 0 ? Integer.MIN_VALUE : i2, (i4 & 8) != 0 ? "" : str);
            }
        }

        public final void pop(int index) {
            if (index < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= index) {
                    pop();
                }
            } else {
                StringBuilder sbM1322o = AbstractC1974b.m1322o(index, " should be less than ");
                sbM1322o.append(this.styleStack.size());
                throw new IllegalStateException(sbM1322o.toString().toString());
            }
        }

        public final int pushStyle(@NotNull ParagraphStyle style) {
            MutableRange<ParagraphStyle> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.paragraphStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @Override // java.lang.Appendable
        @NotNull
        public Builder append(@Nullable CharSequence text) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text);
                return this;
            }
            this.text.append(text);
            return this;
        }

        public /* synthetic */ Builder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 16 : i);
        }

        public Builder(@NotNull String str) {
            this(0, 1, null);
            append(str);
        }

        @Override // java.lang.Appendable
        @NotNull
        public Builder append(@Nullable CharSequence text, int start, int end) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text, start, end);
                return this;
            }
            this.text.append(text, start, end);
            return this;
        }

        public Builder(@NotNull AnnotatedString annotatedString) {
            this(0, 1, null);
            append(annotatedString);
        }

        @Override // java.lang.Appendable
        @NotNull
        public Builder append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(@NotNull AnnotatedString text) {
            int length = this.text.length();
            this.text.append(text.getText());
            List<Range<SpanStyle>> spanStylesOrNull$ui_text_release = text.getSpanStylesOrNull$ui_text_release();
            if (spanStylesOrNull$ui_text_release != null) {
                int size = spanStylesOrNull$ui_text_release.size();
                for (int i = 0; i < size; i++) {
                    Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i);
                    addStyle(range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List<Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = text.getParagraphStylesOrNull$ui_text_release();
            if (paragraphStylesOrNull$ui_text_release != null) {
                int size2 = paragraphStylesOrNull$ui_text_release.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Range<ParagraphStyle> range2 = paragraphStylesOrNull$ui_text_release.get(i2);
                    addStyle(range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List<Range<? extends Object>> annotations$ui_text_release = text.getAnnotations$ui_text_release();
            if (annotations$ui_text_release != null) {
                int size3 = annotations$ui_text_release.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    Range<? extends Object> range3 = annotations$ui_text_release.get(i4);
                    this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }

        public final void append(@NotNull AnnotatedString text, int start, int end) {
            int length = this.text.length();
            this.text.append((CharSequence) text.getText(), start, end);
            List localSpanStyles = AnnotatedStringKt.getLocalSpanStyles(text, start, end);
            if (localSpanStyles != null) {
                int size = localSpanStyles.size();
                for (int i = 0; i < size; i++) {
                    Range range = (Range) localSpanStyles.get(i);
                    addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List localParagraphStyles = AnnotatedStringKt.getLocalParagraphStyles(text, start, end);
            if (localParagraphStyles != null) {
                int size2 = localParagraphStyles.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Range range2 = (Range) localParagraphStyles.get(i2);
                    addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List localAnnotations = AnnotatedStringKt.getLocalAnnotations(text, start, end);
            if (localAnnotations != null) {
                int size3 = localAnnotations.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    Range range3 = (Range) localAnnotations.get(i4);
                    this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/text/AnnotatedString$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<AnnotatedString, ?> getSaver() {
            return AnnotatedString.Saver;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(@NotNull String str, @Nullable List<Range<SpanStyle>> list, @Nullable List<Range<ParagraphStyle>> list2, @Nullable List<? extends Range<? extends Object>> list3) {
        List listSortedWith;
        this.text = str;
        this.spanStylesOrNull = list;
        this.paragraphStylesOrNull = list2;
        this.annotations = list3;
        if (list2 == null || (listSortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((AnnotatedString.Range) t).getStart()), Integer.valueOf(((AnnotatedString.Range) t2).getStart()));
            }
        })) == null) {
            return;
        }
        int size = listSortedWith.size();
        int end = -1;
        for (int i = 0; i < size; i++) {
            Range range = (Range) listSortedWith.get(i);
            if (range.getStart() < end) {
                throw new IllegalArgumentException("ParagraphStyle should not overlap");
            }
            if (range.getEnd() > this.text.length()) {
                throw new IllegalArgumentException(("ParagraphStyle range [" + range.getStart() + SQLKeyword.COMMA + range.getEnd() + ") is out of boundary").toString());
            }
            end = range.getEnd();
        }
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) other;
        return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.spanStylesOrNull, annotatedString.spanStylesOrNull) && Intrinsics.areEqual(this.paragraphStylesOrNull, annotatedString.paragraphStylesOrNull) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    @Nullable
    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    @NotNull
    public final List<Range<LinkAnnotation>> getLinkAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return listEmptyList;
    }

    @NotNull
    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        List<Range<ParagraphStyle>> list = this.paragraphStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Nullable
    public final List<Range<ParagraphStyle>> getParagraphStylesOrNull$ui_text_release() {
        return this.paragraphStylesOrNull;
    }

    @NotNull
    public final List<Range<SpanStyle>> getSpanStyles() {
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Nullable
    public final List<Range<SpanStyle>> getSpanStylesOrNull$ui_text_release() {
        return this.spanStylesOrNull;
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(@NotNull String tag, int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof String) && Intrinsics.areEqual(tag, range2.getTag()) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return listEmptyList;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<Range<TtsAnnotation>> getTtsAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return listEmptyList;
    }

    @Deprecated(message = "Use LinkAnnotation API instead", replaceWith = @ReplaceWith(expression = "getLinkAnnotations(start, end)", imports = {}))
    @ExperimentalTextApi
    @NotNull
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof UrlAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return listEmptyList;
    }

    public final boolean hasEqualAnnotations(@NotNull AnnotatedString other) {
        return Intrinsics.areEqual(this.annotations, other.annotations);
    }

    public final boolean hasLinkAnnotations(int start, int end) {
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                if ((range.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean hasStringAnnotations(@NotNull String tag, int start, int end) {
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                if ((range.getItem() instanceof String) && Intrinsics.areEqual(tag, range.getTag()) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Range<ParagraphStyle>> list2 = this.paragraphStylesOrNull;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Range<? extends Object>> list3 = this.annotations;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    @Stable
    @NotNull
    public final AnnotatedString plus(@NotNull AnnotatedString other) {
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    @NotNull
    /* JADX INFO: renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m20307subSequence5zctL8(long range) {
        return subSequence(TextRange.m20454getMinimpl(range), TextRange.m20453getMaximpl(range));
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    @NotNull
    public AnnotatedString subSequence(int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException(AbstractC0622a.m1168n("start (", startIndex, ") should be less or equal to end (", endIndex, PropertyUtils.MAPPED_DELIM2).toString());
        }
        if (startIndex == 0 && endIndex == this.text.length()) {
            return this;
        }
        String strSubstring = this.text.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new AnnotatedString(strSubstring, AnnotatedStringKt.filterRanges(this.spanStylesOrNull, startIndex, endIndex), AnnotatedStringKt.filterRanges(this.paragraphStylesOrNull, startIndex, endIndex), AnnotatedStringKt.filterRanges(this.annotations, startIndex, endIndex));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B%\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "start", "", "end", "(Ljava/lang/Object;II)V", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Immutable
    @SourceDebugExtension({"SMAP\nAnnotatedString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedString$Range\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1271:1\n1#2:1272\n*E\n"})
    public static final /* data */ class Range<T> {
        public static final int $stable = 0;
        private final int end;
        private final T item;
        private final int start;

        @NotNull
        private final String tag;

        public Range(T t, int i, int i2, @NotNull String str) {
            this.item = t;
            this.start = i;
            this.end = i2;
            this.tag = str;
            if (i > i2) {
                throw new IllegalArgumentException("Reversed range is not supported");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range range, Object obj, int i, int i2, String str, int i4, Object obj2) {
            if ((i4 & 1) != 0) {
                obj = range.item;
            }
            if ((i4 & 2) != 0) {
                i = range.start;
            }
            if ((i4 & 4) != 0) {
                i2 = range.end;
            }
            if ((i4 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(obj, i, i2, str);
        }

        public final T component1() {
            return this.item;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @NotNull
        public final Range<T> copy(T item, int start, int end, @NotNull String tag) {
            return new Range<>(item, start, end, tag);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t = this.item;
            return this.tag.hashCode() + AbstractC0622a.m1157c(this.end, AbstractC0622a.m1157c(this.start, (t == null ? 0 : t.hashCode()) * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("Range(item=");
            sb.append(this.item);
            sb.append(", start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", tag=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.tag, sb);
        }

        public Range(T t, int i, int i2) {
            this(t, i, i2, "");
        }
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof String) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return listEmptyList;
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3);
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnnotatedString(@NotNull String str, @NotNull List<Range<SpanStyle>> list, @NotNull List<Range<ParagraphStyle>> list2) {
        List<Range<SpanStyle>> list3 = list;
        List<Range<ParagraphStyle>> list4 = list2;
        this(str, list3.isEmpty() ? null : list3, list4.isEmpty() ? null : list4, null);
    }
}
