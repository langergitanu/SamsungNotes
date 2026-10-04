package com.samsung.android.support.senl.p148nt.word.common;

import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J-\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u001eH$J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J%\u0010+\u001a\u00028\u00012\u0006\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H$¢\u0006\u0002\u0010/J%\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00122\u0006\u0010,\u001a\u00028\u00002\u0006\u00102\u001a\u00020)H&¢\u0006\u0002\u00103J\u001d\u00104\u001a\u00020 2\u0006\u0010,\u001a\u00028\u00002\u0006\u00105\u001a\u00020\u0012H$¢\u0006\u0002\u00106J#\u00107\u001a\u00020 2\u0006\u0010,\u001a\u00028\u00002\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u001f\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00028\u00012\b\u0010B\u001a\u0004\u0018\u00010\u001cH$¢\u0006\u0002\u0010CJ\u001d\u0010D\u001a\u00020 2\u0006\u0010,\u001a\u00028\u00002\u0006\u0010>\u001a\u00020?H$¢\u0006\u0002\u0010ER\u001a\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c`\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttrToOfficeHelper;", "OfficeParagraph", "OfficeRun", "", "officeParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "mView", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "<init>", "(Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;Lcom/samsung/android/sdk/pen/document/SpenObjectShape;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;)V", "textParagraphs", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "Lkotlin/collections/ArrayList;", "paragraphs", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttributes;", "Lkotlin/collections/HashMap;", "getParagraphs", "()Ljava/util/HashMap;", "setParagraphs", "(Ljava/util/HashMap;)V", "textSpanBases", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "spans", "Lcom/samsung/android/support/senl/nt/word/common/SpanAttributes;", "mContent", "", "setSpanForTextParagraph", "", NativeAuthConstants.GrantType.ATTRIBUTES, "paragraphIndex", "", "", "index", "(Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttributes;[[II)V", "getTag", "haveSpenTextParagraph", "", "haveSpan", "createRun", "paragraph", "start", "end", "(Ljava/lang/Object;II)Ljava/lang/Object;", "addSpenTextParagraph", "line", "isNewLine", "(ILjava/lang/Object;Z)V", "addAlignment", "align", "(Ljava/lang/Object;I)V", "addRunToParagraph", "startParagraph", "endParagraph", "(Ljava/lang/Object;II)V", "setFontSize", "xwpfRun", "Lorg/apache/poi/xwpf/usermodel/XWPFRun;", "size", "", "addProperty", "run", "attr", "(Ljava/lang/Object;Lcom/samsung/android/support/senl/nt/word/common/SpanAttributes;)V", "setStyle", "(Ljava/lang/Object;D)V", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nParagraphAttrToOfficeHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParagraphAttrToOfficeHelper.kt\ncom/samsung/android/support/senl/nt/word/common/ParagraphAttrToOfficeHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,267:1\n739#2,9:268\n739#2,9:281\n37#3:277\n36#3,3:278\n37#3:290\n36#3,3:291\n*S KotlinDebug\n*F\n+ 1 ParagraphAttrToOfficeHelper.kt\ncom/samsung/android/support/senl/nt/word/common/ParagraphAttrToOfficeHelper\n*L\n142#1:268,9\n211#1:281,9\n142#1:277\n142#1:278,3\n211#1:290\n211#1:291,3\n*E\n"})
public abstract class ParagraphAttrToOfficeHelper<OfficeParagraph, OfficeRun> {

    @JvmField
    @Nullable
    protected String mContent;

    @JvmField
    @NotNull
    protected OfficeView<?, ?> mView;
    protected HashMap<Integer, ParagraphAttributes> paragraphs;
    private HashMap<Integer, SpanAttributes> spans;

    @Nullable
    private ArrayList<SpenTextParagraphBase> textParagraphs;

    @Nullable
    private ArrayList<SpenTextSpanBase> textSpanBases;

    public ParagraphAttrToOfficeHelper(@NotNull OfficeParams officeParams, @NotNull SpenObjectShape objectShape, @NotNull OfficeView<?, ?> mView) {
        Intrinsics.checkNotNullParameter(officeParams, "officeParams");
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.textParagraphs = objectShape.getTextParagraph();
        if (haveSpenTextParagraph()) {
            setParagraphs(new HashMap<>());
            ArrayList<SpenTextParagraphBase> arrayList = this.textParagraphs;
            Intrinsics.checkNotNull(arrayList);
            Iterator<SpenTextParagraphBase> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextParagraphBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextParagraphBase spenTextParagraphBase = next;
                int type = spenTextParagraphBase.getType();
                if (type == 2) {
                    for (int start = spenTextParagraphBase.getStart(); start < spenTextParagraphBase.getEnd(); start++) {
                        if (!getParagraphs().containsKey(Integer.valueOf(start))) {
                            getParagraphs().put(Integer.valueOf(start), new ParagraphAttributes());
                        }
                        ParagraphAttributes paragraphAttributes = getParagraphs().get(Integer.valueOf(start));
                        Intrinsics.checkNotNull(paragraphAttributes);
                        paragraphAttributes.setIndentLevel(((SpenIndentLevelParagraph) spenTextParagraphBase).getIndentLevel());
                    }
                } else if (type == 3) {
                    for (int start2 = spenTextParagraphBase.getStart(); start2 < spenTextParagraphBase.getEnd(); start2++) {
                        if (!getParagraphs().containsKey(Integer.valueOf(start2))) {
                            getParagraphs().put(Integer.valueOf(start2), new ParagraphAttributes());
                        }
                        ParagraphAttributes paragraphAttributes2 = getParagraphs().get(Integer.valueOf(start2));
                        Intrinsics.checkNotNull(paragraphAttributes2);
                        paragraphAttributes2.setAlign(((SpenAlignmentParagraph) spenTextParagraphBase).getAlignment());
                    }
                } else if (type == 5) {
                    for (int start3 = spenTextParagraphBase.getStart(); start3 < spenTextParagraphBase.getEnd(); start3++) {
                        if (!getParagraphs().containsKey(Integer.valueOf(start3))) {
                            getParagraphs().put(Integer.valueOf(start3), new ParagraphAttributes());
                        }
                        ParagraphAttributes paragraphAttributes3 = getParagraphs().get(Integer.valueOf(start3));
                        Intrinsics.checkNotNull(paragraphAttributes3);
                        SpenBulletParagraph spenBulletParagraph = (SpenBulletParagraph) spenTextParagraphBase;
                        paragraphAttributes3.setBulletType(spenBulletParagraph.getBulletType());
                        ParagraphAttributes paragraphAttributes4 = getParagraphs().get(Integer.valueOf(start3));
                        if (paragraphAttributes4 != null) {
                            paragraphAttributes4.setChecked(spenBulletParagraph.getIsChecked());
                        }
                    }
                }
            }
            this.textSpanBases = objectShape.getTextSpan();
            this.mContent = objectShape.getText();
            if (haveSpan()) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList<SpenTextSpanBase> arrayList3 = this.textSpanBases;
                Intrinsics.checkNotNull(arrayList3);
                Iterator<SpenTextSpanBase> it2 = arrayList3.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    SpenTextSpanBase next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    SpenTextSpanBase spenTextSpanBase = next2;
                    arrayList2.add(Integer.valueOf(spenTextSpanBase.getStart()));
                    arrayList2.add(Integer.valueOf(spenTextSpanBase.getEnd()));
                }
                int i = 0;
                arrayList2.add(0);
                String str = this.mContent;
                Intrinsics.checkNotNull(str);
                arrayList2.add(Integer.valueOf(str.length()));
                int iM14128B = 0;
                while (iM14128B != -1) {
                    int i2 = iM14128B + 1;
                    arrayList2.add(Integer.valueOf(i2));
                    String str2 = this.mContent;
                    Intrinsics.checkNotNull(str2);
                    iM14128B = StringsKt.m14128B(str2, '\n', i2, 4);
                }
                CollectionsKt.sort(arrayList2);
                this.spans = new HashMap<>();
                int size = arrayList2.size() - 1;
                while (true) {
                    HashMap<Integer, SpanAttributes> map = null;
                    if (i >= size) {
                        break;
                    }
                    int i4 = i + 1;
                    if (((Number) arrayList2.get(i)).intValue() != ((Number) arrayList2.get(i4)).intValue()) {
                        int iIntValue = ((Number) arrayList2.get(i)).intValue();
                        SpanAttributes spanAttributes = new SpanAttributes(iIntValue, ((Number) arrayList2.get(i4)).intValue());
                        HashMap<Integer, SpanAttributes> map2 = this.spans;
                        if (map2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("spans");
                        } else {
                            map = map2;
                        }
                        map.put(Integer.valueOf(iIntValue), spanAttributes);
                    }
                    i = i4;
                }
                ArrayList<SpenTextSpanBase> arrayList4 = this.textSpanBases;
                Intrinsics.checkNotNull(arrayList4);
                Iterator<SpenTextSpanBase> it3 = arrayList4.iterator();
                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                while (it3.hasNext()) {
                    SpenTextSpanBase next3 = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                    SpenTextSpanBase spenTextSpanBase2 = next3;
                    HashMap<Integer, SpanAttributes> map3 = this.spans;
                    if (map3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("spans");
                        map3 = null;
                    }
                    SpanAttributes spanAttributes2 = map3.get(Integer.valueOf(spenTextSpanBase2.getStart()));
                    while (spanAttributes2 != null && spanAttributes2.getEnd() <= spenTextSpanBase2.getEnd()) {
                        int type2 = spenTextSpanBase2.getType();
                        if (type2 == 1) {
                            spanAttributes2.setForegroundColor(officeParams.toHexaStringColor(((SpenForegroundColorSpan) spenTextSpanBase2).getColor()));
                        } else if (type2 == 3) {
                            spanAttributes2.setFontSize(officeParams.getFontSize((int) ((SpenFontSizeSpan) spenTextSpanBase2).getSize()));
                        } else if (type2 == 17) {
                            int color = ((SpenBackgroundColorSpan) spenTextSpanBase2).getColor();
                            if (color != 0) {
                                spanAttributes2.setBackgroundColor(officeParams.toHexaStringColor(color));
                            }
                        } else if (type2 == 20) {
                            spanAttributes2.setStrikethrough(((SpenStrikethroughSpan) spenTextSpanBase2).getIsStrikethroughStyleEnabled());
                        } else if (type2 == 5) {
                            spanAttributes2.setBold(((SpenBoldSpan) spenTextSpanBase2).getIsBoldStyleEnabled());
                        } else if (type2 == 6) {
                            spanAttributes2.setItalic(((SpenItalicSpan) spenTextSpanBase2).getIsItalicStyleEnabled());
                        } else if (type2 == 7) {
                            spanAttributes2.setUnderline(((SpenUnderlineSpan) spenTextSpanBase2).getIsUnderlineStyleEnabled());
                        }
                        HashMap<Integer, SpanAttributes> map4 = this.spans;
                        if (map4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("spans");
                            map4 = null;
                        }
                        spanAttributes2 = map4.get(Integer.valueOf(spanAttributes2.getEnd()));
                    }
                }
                setSpanForTextParagraph(objectShape);
            }
        }
    }

    private final void setSpanForTextParagraph(SpenObjectShape objectShape) {
        List listEmptyList;
        if (TextUtils.isEmpty(objectShape.getText())) {
            return;
        }
        String text = objectShape.getText();
        Intrinsics.checkNotNull(text);
        List<String> listSplit = new Regex(CharUtils.SDOCX_CRLF_REGEX).split(text, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        int length = strArr.length;
        int[][] iArr = new int[length][];
        for (int i = 0; i < length; i++) {
            iArr[i] = new int[2];
        }
        if (!(strArr.length == 0)) {
            int length2 = strArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (i2 == 0) {
                    int[] iArr2 = iArr[i2];
                    iArr2[0] = 0;
                    iArr2[1] = strArr[i2].length();
                } else {
                    int[] iArr3 = iArr[i2];
                    int i4 = iArr[i2 - 1][1] + 1;
                    iArr3[0] = i4;
                    iArr3[1] = strArr[i2].length() + i4;
                }
            }
        }
        ArrayList<SpenTextParagraphBase> arrayList = this.textParagraphs;
        Intrinsics.checkNotNull(arrayList);
        Iterator<SpenTextParagraphBase> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenTextParagraphBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextParagraphBase spenTextParagraphBase = next;
            if (spenTextParagraphBase.getType() == 5) {
                int end = spenTextParagraphBase.getEnd();
                for (int start = spenTextParagraphBase.getStart(); start < end; start++) {
                    if (!getParagraphs().containsKey(Integer.valueOf(start))) {
                        getParagraphs().put(Integer.valueOf(start), new ParagraphAttributes());
                    }
                    ParagraphAttributes paragraphAttributes = getParagraphs().get(Integer.valueOf(start));
                    Intrinsics.checkNotNull(paragraphAttributes);
                    paragraphAttributes.setBulletNumber(((SpenBulletParagraph) spenTextParagraphBase).getBulletNumber());
                    setSpanForTextParagraph(getParagraphs().get(Integer.valueOf(start)), iArr, start);
                }
            }
        }
    }

    public abstract void addAlignment(OfficeParagraph paragraph, int align);

    public abstract void addProperty(OfficeRun run, @Nullable SpanAttributes attr);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addRunToParagraph(OfficeParagraph paragraph, int startParagraph, int endParagraph) {
        String strSubstring;
        List listEmptyList;
        int length;
        int i;
        int length2;
        int length3;
        AbstractC8014b.m7216r(startParagraph, endParagraph, "addRunToParagraph, startParagraph: ", ", endParagraph: ", getTag());
        HashMap<Integer, SpanAttributes> map = this.spans;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spans");
            map = null;
        }
        SpanAttributes spanAttributes = map.get(Integer.valueOf(startParagraph));
        if (spanAttributes == null) {
            return;
        }
        int i2 = 0;
        Object objCreateParagraph = paragraph;
        boolean z = false;
        boolean z2 = true;
        while (true) {
            Intrinsics.checkNotNull(spanAttributes);
            if (spanAttributes.getStart() >= endParagraph) {
                if (spanAttributes.getStart() < endParagraph || z) {
                    return;
                }
                setStyle(paragraph, spanAttributes.getFontSize());
                return;
            }
            int start = spanAttributes.getStart();
            int end = spanAttributes.getEnd();
            if (end > endParagraph) {
                HashMap<Integer, SpanAttributes> map2 = this.spans;
                if (map2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spans");
                    map2 = null;
                }
                map2.put(Integer.valueOf(endParagraph), new SpanAttributes(endParagraph, end, spanAttributes));
                spanAttributes.setEnd(endParagraph);
                end = endParagraph;
            }
            String str = this.mContent;
            if (str != null) {
                strSubstring = str.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            } else {
                strSubstring = null;
            }
            if (strSubstring == null || !StringsKt.m14162r(strSubstring, UnicodeUtils.OBJECT_REPLACEMENT)) {
                if (!z2) {
                    OfficeView<?, ?> officeView = this.mView;
                    Intrinsics.checkNotNull(officeView, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.WordView");
                    objCreateParagraph = ((WordView) officeView).createParagraph();
                }
                addProperty(createRun(objCreateParagraph, start, end), spanAttributes);
                z2 = true;
            } else {
                List listM13999t = AbstractC12991c.m13999t(i2, UnicodeUtils.OBJECT_REPLACEMENT, UnicodeUtils.replaceUnicode(strSubstring, UnicodeUtils.OBJECT_REPLACEMENT, "￼�"));
                if (listM13999t.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                    String[] strArr = (String[]) listEmptyList.toArray(new String[i2]);
                    length = strArr.length;
                    i = i2;
                    int i4 = i;
                    while (i < length) {
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
                    String[] strArr2 = (String[]) listEmptyList.toArray(new String[i2]);
                    length = strArr2.length;
                    i = i2;
                    int i42 = i;
                    while (i < length) {
                        String str2 = strArr2[i];
                        if (!StringsKt.m14162r(str2, UnicodeUtils.REPLACEMENT)) {
                            length2 = str2.length() + start;
                            length3 = AbstractC2821a.m2212c(1, start, str2);
                        } else if (Intrinsics.areEqual(UnicodeUtils.REPLACEMENT, str2)) {
                            length3 = start + 1;
                            length2 = -1;
                        } else {
                            length2 = (str2.length() + start) - 1;
                            length3 = str2.length() + start;
                        }
                        if (length2 >= 0) {
                            if (!z2) {
                                OfficeView<?, ?> officeView2 = this.mView;
                                Intrinsics.checkNotNull(officeView2, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.WordView");
                                objCreateParagraph = ((WordView) officeView2).createParagraph();
                            }
                            addProperty(createRun(objCreateParagraph, start, length2), spanAttributes);
                            z2 = true;
                        }
                        if ((this.mView instanceof WordView) && (i42 < strArr2.length - 1 || strArr2.length == 1)) {
                            if (!z2 || str2.length() != 0) {
                                OfficeView<?, ?> officeView3 = this.mView;
                                Intrinsics.checkNotNull(officeView3, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.WordView");
                                objCreateParagraph = ((WordView) officeView3).createParagraph();
                            }
                            addProperty(createRun(objCreateParagraph, start, start), spanAttributes);
                            WordView.Companion companion = WordView.INSTANCE;
                            Intrinsics.checkNotNull(objCreateParagraph, "null cannot be cast to non-null type org.apache.poi.xwpf.usermodel.XWPFParagraph");
                            XWPFRun xWPFRunCreateRun = ((XWPFParagraph) objCreateParagraph).createRun();
                            Intrinsics.checkNotNullExpressionValue(xWPFRunCreateRun, "createRun(...)");
                            companion.addInlineImage(xWPFRunCreateRun);
                            i42++;
                            z2 = false;
                        }
                        i++;
                        start = length3;
                    }
                }
            }
            HashMap<Integer, SpanAttributes> map3 = this.spans;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spans");
                map3 = null;
            }
            spanAttributes = map3.get(Integer.valueOf(end));
            String str3 = this.mContent;
            if (str3 != null && end == str3.length()) {
                return;
            }
            z = true;
            i2 = 0;
        }
    }

    public abstract void addSpenTextParagraph(int line, OfficeParagraph paragraph, boolean isNewLine);

    public abstract OfficeRun createRun(OfficeParagraph paragraph, int start, int end);

    @NotNull
    public final HashMap<Integer, ParagraphAttributes> getParagraphs() {
        HashMap<Integer, ParagraphAttributes> map = this.paragraphs;
        if (map != null) {
            return map;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paragraphs");
        return null;
    }

    @NotNull
    public abstract String getTag();

    public final boolean haveSpan() {
        ArrayList<SpenTextSpanBase> arrayList = this.textSpanBases;
        if (arrayList == null) {
            return false;
        }
        Intrinsics.checkNotNull(arrayList);
        return (arrayList.isEmpty() || TextUtils.isEmpty(this.mContent)) ? false : true;
    }

    public final boolean haveSpenTextParagraph() {
        ArrayList<SpenTextParagraphBase> arrayList = this.textParagraphs;
        if (arrayList == null) {
            return false;
        }
        Intrinsics.checkNotNull(arrayList);
        return !arrayList.isEmpty();
    }

    public final void setFontSize(@NotNull XWPFRun xwpfRun, double size) {
        Intrinsics.checkNotNullParameter(xwpfRun, "xwpfRun");
        StringBuilder sb = new StringBuilder();
        sb.append(size);
        BigDecimal bigDecimal = new BigDecimal(sb.toString());
        CTR ctr = xwpfRun.getCTR();
        CTRPr rPr = ctr.isSetRPr() ? ctr.getRPr() : ctr.addNewRPr();
        (rPr.isSetSz() ? rPr.getSz() : rPr.addNewSz()).setVal(bigDecimal.multiply(new BigDecimal("2")).toBigIntegerExact());
    }

    public final void setParagraphs(@NotNull HashMap<Integer, ParagraphAttributes> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.paragraphs = map;
    }

    public abstract void setStyle(OfficeParagraph paragraph, double size);

    private final void setSpanForTextParagraph(ParagraphAttributes attributes, int[][] paragraphIndex, int index) {
        HashMap<Integer, SpanAttributes> map = this.spans;
        if (map == null || index >= paragraphIndex.length) {
            return;
        }
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spans");
            map = null;
        }
        SpanAttributes spanAttributes = map.get(Integer.valueOf(paragraphIndex[index][0]));
        if (spanAttributes == null || attributes == null) {
            return;
        }
        attributes.setForegroundColor(spanAttributes.getForegroundColor());
        attributes.setFontSize((int) spanAttributes.getFontSize());
    }
}
