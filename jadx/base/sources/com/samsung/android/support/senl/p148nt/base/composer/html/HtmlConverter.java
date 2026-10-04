package com.samsung.android.support.senl.p148nt.base.composer.html;

import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenSpacingAfterParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenSpacingBeforeParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlHelper;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.HtmlParser;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.MarkdownElementUtil;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenImageObjectTemp;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenMathObjectTemp;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.misc.Extension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u00012\u0006\u0010\u0014\u001a\u00020\u0010H\u0082\b¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\fJ\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J$\u0010 \u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\fH\u0002J(\u0010\"\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J$\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180)H\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0002¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/HtmlConverter;", "", "<init>", "()V", "makeSObjectListFromHtml", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "input", "", "fixSpacingParagraph", "", "objectList", "", "isSameFontSize", "", "prev", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "cur", "findParagraph", "T", ExternalDataConstants.Column.TEXT_BOX, "(Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;)Ljava/lang/Object;", "makeSObjectListFromText", "unsupportedList", "", "convertMarkdownToHtml", "preprocess", "markdown", "preprocessMathSyntax", "preprocessTable", "isTableLine", "line", "replaceUnsupportedObjToText", "objList", "replaceToText", "index", "text", "preprocessEmphasis", "replaceEmphasis", "processed", "pos", "Lkotlin/Pair;", "isEmphasisBrokenChar", "c", "", "println", "str", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHtmlConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HtmlConverter.kt\ncom/samsung/android/support/senl/nt/base/composer/html/HtmlConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,276:1\n89#1,8:277\n89#1,8:285\n89#1,8:293\n89#1,8:301\n1869#2,2:309\n*S KotlinDebug\n*F\n+ 1 HtmlConverter.kt\ncom/samsung/android/support/senl/nt/base/composer/html/HtmlConverter\n*L\n47#1:277,8\n49#1:285,8\n52#1:293,8\n53#1:301,8\n240#1:309,2\n*E\n"})
public final class HtmlConverter {

    @NotNull
    public static final String TAG = "HtmlConverter";

    private final /* synthetic */ <T> T findParagraph(SpenObjectTextBox textBox) {
        int size;
        ArrayList<SpenTextParagraphBase> textParagraph = textBox.getTextParagraph();
        if (textParagraph != null && textParagraph.size() - 1 >= 0) {
            while (true) {
                int i = size - 1;
                Object obj = textParagraph.get(size);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                T t = (T) ((SpenTextParagraphBase) obj);
                Intrinsics.reifiedOperationMarker(3, "T");
                if (t != null) {
                    return t;
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095 A[EDGE_INSN: B:89:0x0095->B:40:0x0095 BREAK  A[LOOP:2: B:43:0x009f->B:48:0x00b2]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00b4 A[EDGE_INSN: B:88:0x00b4->B:49:0x00b4 BREAK  A[LOOP:2: B:43:0x009f->B:48:0x00b2], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fixSpacingParagraph(List<? extends SpenObjectBase> objectList) {
        int size;
        SpenTextParagraphBase spenTextParagraphBase;
        SpenSpacingAfterParagraph spenSpacingAfterParagraph;
        int size2;
        SpenTextParagraphBase spenTextParagraphBase2;
        SpenSpacingBeforeParagraph spenSpacingBeforeParagraph;
        ArrayList<SpenTextParagraphBase> textParagraph;
        int size3;
        int i;
        SpenTextParagraphBase spenTextParagraphBase3;
        SpenIndentLevelParagraph spenIndentLevelParagraph;
        int size4;
        SpenTextParagraphBase spenTextParagraphBase4;
        SpenIndentLevelParagraph spenIndentLevelParagraph2;
        HashMap map = new HashMap();
        int size5 = objectList.size();
        for (int i2 = 1; i2 < size5; i2++) {
            SpenObjectBase spenObjectBase = objectList.get(i2 - 1);
            SpenObjectBase spenObjectBase2 = objectList.get(i2);
            if ((spenObjectBase instanceof SpenObjectTextBox) && (spenObjectBase2 instanceof SpenObjectTextBox)) {
                SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBase;
                ArrayList<SpenTextParagraphBase> textParagraph2 = spenObjectTextBox.getTextParagraph();
                if (textParagraph2 != null && textParagraph2.size() - 1 >= 0) {
                    while (true) {
                        int i4 = size - 1;
                        SpenTextParagraphBase spenTextParagraphBase5 = textParagraph2.get(size);
                        Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase5, "get(...)");
                        spenTextParagraphBase = spenTextParagraphBase5;
                        if (spenTextParagraphBase instanceof SpenSpacingAfterParagraph) {
                            break;
                        } else if (i4 < 0) {
                            break;
                        } else {
                            size = i4;
                        }
                    }
                    spenSpacingAfterParagraph = (SpenSpacingAfterParagraph) spenTextParagraphBase;
                    if (spenSpacingAfterParagraph != null) {
                        SpenObjectTextBox spenObjectTextBox2 = (SpenObjectTextBox) spenObjectBase2;
                        ArrayList<SpenTextParagraphBase> textParagraph3 = spenObjectTextBox2.getTextParagraph();
                        if (textParagraph3 != null && textParagraph3.size() - 1 >= 0) {
                            while (true) {
                                int i5 = size2 - 1;
                                SpenTextParagraphBase spenTextParagraphBase6 = textParagraph3.get(size2);
                                Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase6, "get(...)");
                                spenTextParagraphBase2 = spenTextParagraphBase6;
                                if (spenTextParagraphBase2 instanceof SpenSpacingBeforeParagraph) {
                                    break;
                                } else if (i5 < 0) {
                                    break;
                                } else {
                                    size2 = i5;
                                }
                            }
                            spenTextParagraphBase2 = null;
                            spenSpacingBeforeParagraph = (SpenSpacingBeforeParagraph) spenTextParagraphBase2;
                            if (spenSpacingBeforeParagraph != null && spenSpacingAfterParagraph.getSpacing() == spenSpacingBeforeParagraph.getSpacing()) {
                                textParagraph = spenObjectTextBox.getTextParagraph();
                                if (textParagraph != null && textParagraph.size() - 1 >= 0) {
                                    while (true) {
                                        i = size3 - 1;
                                        SpenTextParagraphBase spenTextParagraphBase7 = textParagraph.get(size3);
                                        Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase7, "get(...)");
                                        spenTextParagraphBase3 = spenTextParagraphBase7;
                                        if (spenTextParagraphBase3 instanceof SpenIndentLevelParagraph) {
                                            break;
                                        } else if (i < 0) {
                                            break;
                                        } else {
                                            size3 = i;
                                        }
                                    }
                                    spenTextParagraphBase3 = null;
                                    spenIndentLevelParagraph = (SpenIndentLevelParagraph) spenTextParagraphBase3;
                                    if (spenIndentLevelParagraph != null) {
                                        ArrayList<SpenTextParagraphBase> textParagraph4 = spenObjectTextBox2.getTextParagraph();
                                        if (textParagraph4 != null && textParagraph4.size() - 1 >= 0) {
                                            while (true) {
                                                int i6 = size4 - 1;
                                                SpenTextParagraphBase spenTextParagraphBase8 = textParagraph4.get(size4);
                                                Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase8, "get(...)");
                                                SpenTextParagraphBase spenTextParagraphBase9 = spenTextParagraphBase8;
                                                if (spenTextParagraphBase9 instanceof SpenIndentLevelParagraph) {
                                                    spenTextParagraphBase4 = spenTextParagraphBase9;
                                                    break;
                                                } else if (i6 < 0) {
                                                    break;
                                                } else {
                                                    size4 = i6;
                                                }
                                            }
                                            spenTextParagraphBase4 = null;
                                            spenIndentLevelParagraph2 = (SpenIndentLevelParagraph) spenTextParagraphBase4;
                                            if (spenIndentLevelParagraph2 == null) {
                                                if (spenIndentLevelParagraph.getIndentLevel() == spenIndentLevelParagraph2.getIndentLevel()) {
                                                    if (isSameFontSize(spenObjectTextBox, spenObjectTextBox2)) {
                                                        map.put(spenSpacingAfterParagraph, spenObjectBase);
                                                        map.put(spenSpacingBeforeParagraph, spenObjectBase2);
                                                    }
                                                } else if (spenIndentLevelParagraph.getIndentLevel() < spenIndentLevelParagraph2.getIndentLevel()) {
                                                    map.put(spenSpacingAfterParagraph, spenObjectBase);
                                                    map.put(spenSpacingBeforeParagraph, spenObjectBase2);
                                                }
                                            }
                                        } else {
                                            spenTextParagraphBase4 = null;
                                            spenIndentLevelParagraph2 = (SpenIndentLevelParagraph) spenTextParagraphBase4;
                                            if (spenIndentLevelParagraph2 == null) {
                                            }
                                        }
                                    }
                                } else {
                                    spenTextParagraphBase3 = null;
                                    spenIndentLevelParagraph = (SpenIndentLevelParagraph) spenTextParagraphBase3;
                                    if (spenIndentLevelParagraph != null) {
                                    }
                                }
                            }
                        } else {
                            spenTextParagraphBase2 = null;
                            spenSpacingBeforeParagraph = (SpenSpacingBeforeParagraph) spenTextParagraphBase2;
                            if (spenSpacingBeforeParagraph != null) {
                                textParagraph = spenObjectTextBox.getTextParagraph();
                                if (textParagraph != null) {
                                    while (true) {
                                        i = size3 - 1;
                                        SpenTextParagraphBase spenTextParagraphBase72 = textParagraph.get(size3);
                                        Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase72, "get(...)");
                                        spenTextParagraphBase3 = spenTextParagraphBase72;
                                        if (spenTextParagraphBase3 instanceof SpenIndentLevelParagraph) {
                                        }
                                        size3 = i;
                                    }
                                    spenTextParagraphBase3 = null;
                                    spenIndentLevelParagraph = (SpenIndentLevelParagraph) spenTextParagraphBase3;
                                    if (spenIndentLevelParagraph != null) {
                                    }
                                }
                            }
                        }
                    }
                } else {
                    spenTextParagraphBase = null;
                    spenSpacingAfterParagraph = (SpenSpacingAfterParagraph) spenTextParagraphBase;
                    if (spenSpacingAfterParagraph != null) {
                    }
                }
            }
        }
        for (Object obj : map.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            Map.Entry entry = (Map.Entry) obj;
            ((SpenObjectTextBox) entry.getValue()).removeTextParagraph((SpenTextParagraphBase) entry.getKey());
        }
    }

    private final boolean isEmphasisBrokenChar(char c) {
        return c == ')' || c == '\"' || c == '$';
    }

    private final boolean isSameFontSize(SpenObjectTextBox prev, SpenObjectTextBox cur) {
        float size;
        if (prev.getText() != null && cur.getText() != null) {
            String text = prev.getText();
            Intrinsics.checkNotNull(text);
            ArrayList<SpenTextSpanBase> arrayListFindTextSpan = prev.findTextSpan(0, text.length(), 8);
            float size2 = 15.0f;
            if (arrayListFindTextSpan != null) {
                SpenTextSpanBase spenTextSpanBase = arrayListFindTextSpan.get(arrayListFindTextSpan.size() - 1);
                Intrinsics.checkNotNull(spenTextSpanBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan");
                size = ((SpenFontSizeSpan) spenTextSpanBase).getSize();
            } else {
                size = 15.0f;
            }
            String text2 = cur.getText();
            Intrinsics.checkNotNull(text2);
            ArrayList<SpenTextSpanBase> arrayListFindTextSpan2 = cur.findTextSpan(0, text2.length(), 8);
            if (arrayListFindTextSpan2 != null) {
                SpenTextSpanBase spenTextSpanBase2 = arrayListFindTextSpan2.get(arrayListFindTextSpan2.size() - 1);
                Intrinsics.checkNotNull(spenTextSpanBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan");
                size2 = ((SpenFontSizeSpan) spenTextSpanBase2).getSize();
            }
            if (size == size2) {
                return true;
            }
        }
        return false;
    }

    private final boolean isTableLine(String line) {
        return StringsKt.m14145S(line, "|") && StringsKt.m14167w(line, "|");
    }

    private final String preprocess(String markdown) {
        return preprocessTable(preprocessMathSyntax(preprocessEmphasis(markdown)));
    }

    private final String preprocessEmphasis(String markdown) {
        Matcher matcher = Pattern.compile("\\*\\*(.*?)\\*\\*").matcher(markdown);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(new Pair(Integer.valueOf(matcher.start()), Integer.valueOf(matcher.end())));
        }
        for (Pair<Integer, Integer> pair : CollectionsKt.reversed(arrayList)) {
            if (pair.getSecond().intValue() < markdown.length()) {
                markdown = replaceEmphasis(markdown, pair);
            }
        }
        return markdown;
    }

    private final String preprocessMathSyntax(String markdown) {
        Ref.IntRef intRef = new Ref.IntRef();
        String strReplace = new Regex("\\${1,2}(.+?)\\${1,2}", RegexOption.DOT_MATCHES_ALL).replace(markdown, new C4202b(intRef, 9));
        if (HtmlHelper.INSTANCE.getENABLED_LOG() && intRef.element > 0) {
            println(strReplace);
        }
        return strReplace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence preprocessMathSyntax$lambda$3(Ref.IntRef intRef, String str, MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        intRef.element++;
        String str2 = matchResult.getGroupValues().get(1);
        return StringsKt.m14145S(str2, "\n") ? AbstractC0541b.m773o("\n```math\n", StringsKt.trim((CharSequence) str2).toString(), "\n```") : AbstractC2322a.m1622l(str, "`", str2, "`", str);
    }

    private final String preprocessTable(String markdown) {
        List listSplit$default = StringsKt__StringsKt.split$default(markdown, new String[]{"\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(listSplit$default.size());
        int size = listSplit$default.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                String string = StringsKt.trim((CharSequence) listSplit$default.get(i)).toString();
                String string2 = StringsKt.trim((CharSequence) listSplit$default.get(i - 1)).toString();
                if (isTableLine(string) && !isTableLine(string2)) {
                    arrayList.add("");
                }
            }
            arrayList.add(listSplit$default.get(i));
        }
        return arrayList.size() == listSplit$default.size() ? markdown : CollectionsKt.m13955n(arrayList, "\n", null, null, null, 62);
    }

    private final void println(String str) {
        Logger.m8697d(TAG, str);
    }

    private final String replaceEmphasis(String processed, Pair<Integer, Integer> pos) {
        char cCharAt = processed.charAt(pos.getSecond().intValue());
        char cCharAt2 = processed.charAt(pos.getSecond().intValue() - 3);
        if (Character.isWhitespace(cCharAt) || !isEmphasisBrokenChar(cCharAt2)) {
            return processed;
        }
        if (cCharAt2 == '$' && (cCharAt == ',' || cCharAt == '\'' || cCharAt == '\"')) {
            return processed;
        }
        int iIntValue = pos.getFirst().intValue();
        int iIntValue2 = pos.getSecond().intValue();
        String strSubstring = processed.substring(pos.getFirst().intValue(), pos.getSecond().intValue());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt__StringsKt.replaceRange((CharSequence) processed, iIntValue, iIntValue2, strSubstring + " ").toString();
    }

    private final void replaceToText(List<SpenObjectBase> objList, int index, String text) {
        objList.remove(index);
        if (TextUtils.isEmpty(text)) {
            return;
        }
        MarkdownElementUtil markdownElementUtil = MarkdownElementUtil.INSTANCE;
        Intrinsics.checkNotNull(text);
        SpenObjectTextBox spenObjectTextBoxCreateTextBox = markdownElementUtil.createTextBox(text);
        if (spenObjectTextBoxCreateTextBox != null) {
            objList.add(spenObjectTextBoxCreateTextBox);
        }
    }

    private final void replaceUnsupportedObjToText(List<SpenObjectBase> objList, List<Integer> unsupportedList) {
        boolean zContains = unsupportedList.contains(3);
        boolean zContains2 = unsupportedList.contains(21);
        int size = objList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            SpenObjectBase spenObjectBase = objList.get(size);
            if (zContains && (spenObjectBase instanceof SpenImageObjectTemp)) {
                replaceToText(objList, size, ((SpenImageObjectTemp) spenObjectBase).getSrc());
            } else if (zContains2 && (spenObjectBase instanceof SpenMathObjectTemp)) {
                replaceToText(objList, size, ((SpenMathObjectTemp) spenObjectBase).getLatex());
            }
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    @NotNull
    public final String convertMarkdownToHtml(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (HtmlHelper.INSTANCE.getENABLED_LOG()) {
            println(input);
        }
        String strM756B = AbstractC0541b.m756B(preprocess(input), "\n");
        MutableDataSet mutableDataSet = new MutableDataSet();
        mutableDataSet.set((DataKey<List>) Parser.EXTENSIONS, CollectionsKt.listOf((Object[]) new Extension[]{TablesExtension.create(), GitLabExtension.create(), StrikethroughExtension.create(), TaskListExtension.create()}));
        mutableDataSet.set(HtmlRenderer.SOFT_BREAK, "<br>");
        mutableDataSet.set(Parser.INDENTED_CODE_BLOCK_PARSER, Boolean.FALSE);
        Parser parserBuild = Parser.builder(mutableDataSet).build();
        Intrinsics.checkNotNullExpressionValue(parserBuild, "build(...)");
        HtmlRenderer htmlRendererBuild = HtmlRenderer.builder(mutableDataSet).build();
        Intrinsics.checkNotNullExpressionValue(htmlRendererBuild, "build(...)");
        Document document = parserBuild.parse(strM756B);
        Intrinsics.checkNotNullExpressionValue(document, "parse(...)");
        String strRender = htmlRendererBuild.render(document);
        Intrinsics.checkNotNullExpressionValue(strRender, "render(...)");
        return strRender;
    }

    @NotNull
    public final List<SpenObjectBase> makeSObjectListFromHtml(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        long jCurrentTimeMillis = System.currentTimeMillis();
        println("makeSObjectListFromHtml# begin");
        List<SpenObjectBase> listConvertToObject = new HtmlParser().convertToObject(input);
        fixSpacingParagraph(listConvertToObject);
        println(AbstractC0622a.m1169o("makeSObjectListFromHtml# end ", System.currentTimeMillis() - jCurrentTimeMillis));
        return listConvertToObject;
    }

    @NotNull
    public final List<SpenObjectBase> makeSObjectListFromText(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return makeSObjectListFromText(input, null);
    }

    @NotNull
    public final List<SpenObjectBase> makeSObjectListFromText(@NotNull String input, @Nullable List<Integer> unsupportedList) {
        Intrinsics.checkNotNullParameter(input, "input");
        long jCurrentTimeMillis = System.currentTimeMillis();
        println("makeSObjectListFromText# begin");
        List<SpenObjectBase> listMakeSObjectListFromHtml = makeSObjectListFromHtml(convertMarkdownToHtml(input));
        if (unsupportedList != null && !unsupportedList.isEmpty()) {
            replaceUnsupportedObjToText(listMakeSObjectListFromHtml, unsupportedList);
        }
        println(AbstractC0622a.m1169o("makeSObjectListFromText# end ", System.currentTimeMillis() - jCurrentTimeMillis));
        return listMakeSObjectListFromHtml;
    }
}
