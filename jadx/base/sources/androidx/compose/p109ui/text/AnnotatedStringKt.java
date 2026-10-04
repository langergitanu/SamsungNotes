package androidx.compose.p109ui.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\"\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0086\b\u001a(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0000\u001aD\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u0019\u0018\u00010\u0018\"\u0004\b\u0000\u0010\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u001a0\u0019\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0000\u001a\u0014\u0010#\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a\u0014\u0010&\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a,\u0010'\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020(0\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a*\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a*\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0019\u0018\u00010\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001aa\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0018\"\u0004\b\u0000\u0010\u001a*\u00020\u00012\u0006\u0010,\u001a\u00020\u00062>\b\u0004\u0010-\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u001a0.H\u0080\b\u001a \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00190\u0018*\u00020\u00012\u0006\u0010,\u001a\u00020\u0006H\u0000\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a\u0014\u00104\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a\u0014\u00105\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a?\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u00108\u001a\u0002092\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\u0087\b¢\u0006\u0002\u0010:\u001a?\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010;\u001a\u00020<2\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\u0087\b¢\u0006\u0002\u0010=\u001aG\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\u0087\b¢\u0006\u0002\u0010@\u001a=\u0010A\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010B\u001a\u00020C2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010D\u001a?\u0010E\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010F\u001a\u00020\u00062\u0019\b\u0004\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010G\u001a=\u0010E\u001a\u0002H7\"\b\b\u0000\u00107*\u00020(*\u00020\f2\u0006\u0010F\u001a\u00020\b2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H70\u000b¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0002\u0010H\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m13886d2 = {"EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedString", "text", "", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "buildAnnotatedString", "builder", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "contains", "", "baseStart", "", "baseEnd", "targetStart", "targetEnd", "emptyAnnotatedString", "filterRanges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "ranges", "start", "end", "intersect", "lStart", "lEnd", "rStart", "rEnd", "capitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "getLocalAnnotations", "", "getLocalParagraphStyles", "getLocalSpanStyles", "mapEachParagraphStyle", "defaultParagraphStyle", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "normalizedParagraphStyles", "substringWithoutParagraphStyles", "toLowerCase", "toUpperCase", "withAnnotation", "R", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tag", MathMLUtilities.ANNOTATION_LOCAL_NAME, "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/LinkAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStyle", "style", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnnotatedString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedStringKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1271:1\n33#2,6:1272\n235#2,3:1278\n33#2,4:1281\n238#2,2:1285\n38#2:1287\n240#2:1288\n151#2,3:1289\n33#2,4:1292\n154#2,2:1296\n38#2:1298\n156#2:1299\n235#2,3:1300\n33#2,4:1303\n238#2,2:1307\n38#2:1309\n240#2:1310\n151#2,3:1311\n33#2,4:1314\n154#2,2:1318\n38#2:1320\n156#2:1321\n235#2,3:1322\n33#2,4:1325\n238#2,2:1329\n38#2:1331\n240#2:1332\n151#2,3:1333\n33#2,4:1336\n154#2,2:1340\n38#2:1342\n156#2:1343\n151#2,3:1344\n33#2,4:1347\n154#2,2:1351\n38#2:1353\n156#2:1354\n235#2,3:1356\n33#2,4:1359\n238#2,2:1363\n38#2:1365\n240#2:1366\n151#2,3:1367\n33#2,4:1370\n154#2,2:1374\n38#2:1376\n156#2:1377\n1#3:1355\n*S KotlinDebug\n*F\n+ 1 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedStringKt\n*L\n790#1:1272,6\n826#1:1278,3\n826#1:1281,4\n826#1:1285,2\n826#1:1287\n826#1:1288\n827#1:1289,3\n827#1:1292,4\n827#1:1296,2\n827#1:1298\n827#1:1299\n853#1:1300,3\n853#1:1303,4\n853#1:1307,2\n853#1:1309\n853#1:1310\n854#1:1311,3\n854#1:1314,4\n854#1:1318,2\n854#1:1320\n854#1:1321\n880#1:1322,3\n880#1:1325,4\n880#1:1329,2\n880#1:1331\n880#1:1332\n881#1:1333,3\n881#1:1336,4\n881#1:1340,2\n881#1:1342\n881#1:1343\n917#1:1344,3\n917#1:1347,4\n917#1:1351,2\n917#1:1353\n917#1:1354\n1193#1:1356,3\n1193#1:1359,4\n1193#1:1363,2\n1193#1:1365\n1193#1:1366\n1193#1:1367,3\n1193#1:1370,4\n1193#1:1374,2\n1193#1:1376\n1193#1:1377\n*E\n"})
public final class AnnotatedStringKt {

    @NotNull
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, null, 6, null);

    @NotNull
    public static final AnnotatedString AnnotatedString(@NotNull String str, @NotNull SpanStyle spanStyle, @Nullable ParagraphStyle paragraphStyle) {
        return new AnnotatedString(str, CollectionsKt.listOf(new AnnotatedString.Range(spanStyle, 0, str.length())), paragraphStyle == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    @NotNull
    public static final AnnotatedString buildAnnotatedString(@NotNull Function1<? super AnnotatedString.Builder, Unit> function1) {
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        function1.invoke(builder);
        return builder.toAnnotatedString();
    }

    @NotNull
    public static final AnnotatedString capitalize(@NotNull AnnotatedString annotatedString, @NotNull final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt.capitalize.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            @NotNull
            public final String invoke(@NotNull String str, int i, int i2) {
                if (i == 0) {
                    String strSubstring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return StringKt.capitalize(strSubstring, localeList);
                }
                String strSubstring2 = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            }
        });
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final boolean contains(int i, int i2, int i4, int i5) {
        if (i <= i4 && i5 <= i2) {
            if (i2 == i5) {
                if ((i4 == i5) == (i == i2)) {
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public static final AnnotatedString decapitalize(@NotNull AnnotatedString annotatedString, @NotNull final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt.decapitalize.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            @NotNull
            public final String invoke(@NotNull String str, int i, int i2) {
                if (i == 0) {
                    String strSubstring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return StringKt.decapitalize(strSubstring, localeList);
                }
                String strSubstring2 = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            }
        });
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    @NotNull
    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException(AbstractC0622a.m1168n("start (", i, ") should be less than or equal to end (", i2, PropertyUtils.MAPPED_DELIM2).toString());
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            AnnotatedString.Range<? extends T> range = list.get(i4);
            AnnotatedString.Range<? extends T> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i5 = 0; i5 < size2; i5++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i5);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), Math.max(i, range3.getStart()) - i, Math.min(i2, range3.getEnd()) - i, range3.getTag()));
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<? extends Object>> getLocalAnnotations(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release;
        if (i == i2 || (annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotations$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(annotations$ui_text_release.size());
        int size = annotations$ui_text_release.size();
        for (int i4 = 0; i4 < size; i4++) {
            AnnotatedString.Range<? extends Object> range = annotations$ui_text_release.get(i4);
            AnnotatedString.Range<? extends Object> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i5 = 0; i5 < size2; i5++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i5);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i, range3.getTag()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release;
        if (i == i2 || (paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return paragraphStylesOrNull$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
        int size = paragraphStylesOrNull$ui_text_release.size();
        for (int i4 = 0; i4 < size; i4++) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i4);
            AnnotatedString.Range<ParagraphStyle> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i5 = 0; i5 < size2; i5++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i5);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<SpanStyle>> getLocalSpanStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release;
        if (i == i2 || (spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return spanStylesOrNull$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
        int size = spanStylesOrNull$ui_text_release.size();
        for (int i4 = 0; i4 < size; i4++) {
            AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i4);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i5 = 0; i5 < size2; i5++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i5);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    public static final boolean intersect(int i, int i2, int i4, int i5) {
        return Math.max(i, i4) < Math.min(i2, i5) || contains(i, i2, i4, i5) || contains(i4, i5, i, i2);
    }

    @NotNull
    public static final <T> List<T> mapEachParagraphStyle(@NotNull AnnotatedString annotatedString, @NotNull ParagraphStyle paragraphStyle, @NotNull Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> function2) {
        List<AnnotatedString.Range<ParagraphStyle>> listNormalizedParagraphStyles = normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(listNormalizedParagraphStyles.size());
        int size = listNormalizedParagraphStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<ParagraphStyle> range = listNormalizedParagraphStyles.get(i);
            arrayList.add(function2.invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
        }
        return arrayList;
    }

    @NotNull
    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(@NotNull AnnotatedString annotatedString, @NotNull ParagraphStyle paragraphStyle) {
        int length = annotatedString.getText().length();
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release == null) {
            paragraphStylesOrNull$ui_text_release = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = paragraphStylesOrNull$ui_text_release.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i);
            ParagraphStyle paragraphStyleComponent1 = range.component1();
            int start = range.getStart();
            int end = range.getEnd();
            if (start != i2) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, start));
            }
            arrayList.add(new AnnotatedString.Range(paragraphStyle.merge(paragraphStyleComponent1), start, end));
            i++;
            i2 = end;
        }
        if (i2 != length) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String strSubstring;
        if (i != i2) {
            strSubstring = annotatedString.getText().substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = "";
        }
        return new AnnotatedString(strSubstring, getLocalSpanStyles(annotatedString, i, i2), null, null, 12, null);
    }

    @NotNull
    public static final AnnotatedString toLowerCase(@NotNull AnnotatedString annotatedString, @NotNull final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt.toLowerCase.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            @NotNull
            public final String invoke(@NotNull String str, int i, int i2) {
                String strSubstring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.toLowerCase(strSubstring, localeList);
            }
        });
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    @NotNull
    public static final AnnotatedString toUpperCase(@NotNull AnnotatedString annotatedString, @NotNull final LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new Function3<String, Integer, Integer, String>() { // from class: androidx.compose.ui.text.AnnotatedStringKt.toUpperCase.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            @NotNull
            public final String invoke(@NotNull String str, int i, int i2) {
                String strSubstring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.toUpperCase(strSubstring, localeList);
            }
        });
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull String str, @NotNull String str2, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int iPushStringAnnotation = builder.pushStringAnnotation(str, str2);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(iPushStringAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final <R> R withLink(@NotNull AnnotatedString.Builder builder, @NotNull LinkAnnotation linkAnnotation, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int iPushLink = builder.pushLink(linkAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(iPushLink);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final <R> R withStyle(@NotNull AnnotatedString.Builder builder, @NotNull SpanStyle spanStyle, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int iPushStyle = builder.pushStyle(spanStyle);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(iPushStyle);
            InlineMarker.finallyEnd(1);
        }
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull TtsAnnotation ttsAnnotation, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int iPushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(iPushTtsAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final <R> R withStyle(@NotNull AnnotatedString.Builder builder, @NotNull ParagraphStyle paragraphStyle, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int iPushStyle = builder.pushStyle(paragraphStyle);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(iPushStyle);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final AnnotatedString AnnotatedString(@NotNull String str, @NotNull ParagraphStyle paragraphStyle) {
        return new AnnotatedString(str, CollectionsKt.emptyList(), CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "withLink(, block)", imports = {}))
    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull UrlAnnotation urlAnnotation, @NotNull Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        int iPushUrlAnnotation = builder.pushUrlAnnotation(urlAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(iPushUrlAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }
}
