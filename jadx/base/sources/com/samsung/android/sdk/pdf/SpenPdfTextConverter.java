package com.samsung.android.sdk.pdf;

import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J-\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0007¢\u0006\u0002\u0010 J1\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001bH\u0007¢\u0006\u0002\u0010#J\u0014\u0010!\u001a\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0002J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010,\u001a\u00020-2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u000200H\u0002J\u001c\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfTextConverter;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ANNOTATION_START_OPEN", "ANNOTATION_START_CLOSE", "ANNOTATION_END_OPEN", "ANNOTATION_END_CLOSE", "LESS_THAN", "GREATER_THAN", "FONT_SIZE", "FONT_COLOR", "BOLD", "ITALIC", "SEPARATOR", "SUB_SUPER_SCRIPT_LENGTH", "", "LF", "", "CR", "getScale", "", ExternalDataConstants.Column.PDF_TEXT, "Lcom/samsung/android/sdk/pdf/SpenPdfText;", "compose", "", "listParagraph", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)[Ljava/lang/String;", "parse", "input", "([Ljava/lang/String;)Ljava/util/ArrayList;", "getValidTag", Constants.MessagePayloadKeys.FROM, "to", "getTextStyleFromTag", "Lcom/samsung/android/sdk/pdf/SpenPdfTextStyle;", "taggedStr", "removeExcessTag", "text", "getTagInfo", "Lcom/samsung/android/sdk/pdf/SpenPdfTextConverter$TagInfo;", "startPos", "isOpenTag", "", "mergeToPreviousPdfText", "paragraph", "TagInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPdfTextConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPdfTextConverter.kt\ncom/samsung/android/sdk/pdf/SpenPdfTextConverter\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,298:1\n107#2:299\n79#2,22:300\n*S KotlinDebug\n*F\n+ 1 SpenPdfTextConverter.kt\ncom/samsung/android/sdk/pdf/SpenPdfTextConverter\n*L\n58#1:299\n58#1:300,22\n*E\n"})
public final class SpenPdfTextConverter {

    @NotNull
    private static final String ANNOTATION_END_CLOSE = ">";

    @NotNull
    private static final String ANNOTATION_END_OPEN = "</";

    @NotNull
    private static final String ANNOTATION_START_CLOSE = ">";

    @NotNull
    private static final String ANNOTATION_START_OPEN = "<";

    @NotNull
    private static final String BOLD = "bold";
    private static final char CR = '\r';

    @NotNull
    private static final String FONT_COLOR = "color:";

    @NotNull
    private static final String FONT_SIZE = "size:";

    @NotNull
    private static final String GREATER_THAN = "&gt;";

    @NotNull
    public static final SpenPdfTextConverter INSTANCE = new SpenPdfTextConverter();

    @NotNull
    private static final String ITALIC = "italic";

    @NotNull
    private static final String LESS_THAN = "&lt;";
    private static final char LF = '\n';

    @NotNull
    private static final String SEPARATOR = ",";
    private static final int SUB_SUPER_SCRIPT_LENGTH = 3;

    @NotNull
    private static final String TAG = "PdfTextConverter";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfTextConverter$TagInfo;", "", "startIdx", "", "endIdx", "tag", "", "<init>", "(IILjava/lang/String;)V", "getStartIdx", "()I", "setStartIdx", "(I)V", "getEndIdx", "setEndIdx", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TagInfo {
        private int endIdx;
        private int startIdx;

        @Nullable
        private String tag;

        public TagInfo(int i, int i2, @Nullable String str) {
            this.startIdx = i;
            this.endIdx = i2;
            this.tag = str;
        }

        public final int getEndIdx() {
            return this.endIdx;
        }

        public final int getStartIdx() {
            return this.startIdx;
        }

        @Nullable
        public final String getTag() {
            return this.tag;
        }

        public final void setEndIdx(int i) {
            this.endIdx = i;
        }

        public final void setStartIdx(int i) {
            this.startIdx = i;
        }

        public final void setTag(@Nullable String str) {
            this.tag = str;
        }
    }

    private SpenPdfTextConverter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0160  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String[] compose(@NotNull ArrayList<SpenPdfParagraph> listParagraph) {
        String[] strArr;
        int i;
        float f;
        String strJoin;
        int i2;
        float f4;
        ArrayList<SpenPdfParagraph> listParagraph2 = listParagraph;
        Intrinsics.checkNotNullParameter(listParagraph2, "listParagraph");
        String[] strArr2 = new String[listParagraph2.size()];
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int size = listParagraph2.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size) {
            SpenPdfParagraph spenPdfParagraph = listParagraph2.get(i5);
            Intrinsics.checkNotNullExpressionValue(spenPdfParagraph, "get(...)");
            SpenPdfParagraph spenPdfParagraph2 = spenPdfParagraph;
            sb.setLength(i4);
            ArrayList<SpenPdfText> listPdfText = spenPdfParagraph2.getListPdfText();
            Intrinsics.checkNotNull(listPdfText);
            int size2 = listPdfText.size();
            String str = null;
            float f5 = -1.0f;
            int i6 = i4;
            float f6 = Float.MIN_VALUE;
            while (i6 < size2) {
                ArrayList<SpenPdfText> listPdfText2 = spenPdfParagraph2.getListPdfText();
                Intrinsics.checkNotNull(listPdfText2);
                SpenPdfText spenPdfText = listPdfText2.get(i6);
                Intrinsics.checkNotNullExpressionValue(spenPdfText, "get(...)");
                SpenPdfText spenPdfText2 = spenPdfText;
                if (spenPdfText2.getVisibility()) {
                    SpenPdfTextStyle style = spenPdfText2.getStyle();
                    SpenPdfTextConverter spenPdfTextConverter = INSTANCE;
                    float scale = spenPdfTextConverter.getScale(spenPdfText2);
                    if (f6 == Float.MIN_VALUE) {
                        f6 = scale;
                    }
                    arrayList.clear();
                    Intrinsics.checkNotNull(style);
                    i = size;
                    float fontSize = (((float) style.getFontSize()) * scale) / f6;
                    Intrinsics.checkNotNull(spenPdfParagraph2.getListPdfText());
                    if (i6 < r5.size() - 1) {
                        ArrayList<SpenPdfText> listPdfText3 = spenPdfParagraph2.getListPdfText();
                        Intrinsics.checkNotNull(listPdfText3);
                        strArr = strArr2;
                        SpenPdfText spenPdfText3 = listPdfText3.get(i6 + 1);
                        Intrinsics.checkNotNullExpressionValue(spenPdfText3, "get(...)");
                        SpenPdfText spenPdfText4 = spenPdfText3;
                        SpenPdfTextStyle style2 = spenPdfText4.getStyle();
                        Intrinsics.checkNotNull(style2);
                        f = fontSize;
                        float fontSize2 = (((float) style2.getFontSize()) * spenPdfTextConverter.getScale(spenPdfText4)) / f6;
                        String text = spenPdfText2.getText();
                        Intrinsics.checkNotNull(text);
                        int length = text.length() - 1;
                        int i7 = 0;
                        boolean z = false;
                        while (true) {
                            i2 = length;
                            if (i7 > length) {
                                f4 = fontSize2;
                                break;
                            }
                            if (!z) {
                                length = i7;
                            }
                            f4 = fontSize2;
                            boolean z2 = Intrinsics.compare((int) text.charAt(length), 32) <= 0;
                            if (!z) {
                                if (z2) {
                                    i7++;
                                } else {
                                    z = true;
                                }
                                length = i2;
                            } else {
                                if (!z2) {
                                    break;
                                }
                                length = i2 - 1;
                            }
                            fontSize2 = f4;
                        }
                        if (text.subSequence(i7, i2 + 1).toString().length() >= 3 || f >= f5 || f5 != f4) {
                        }
                        arrayList.add(FONT_SIZE + f5);
                        arrayList.add(FONT_COLOR + style.getColor());
                        if (style.getIsBold()) {
                            arrayList.add(BOLD);
                        }
                        if (style.getIsItalic()) {
                            arrayList.add(ITALIC);
                        }
                        strJoin = TextUtils.join(",", arrayList);
                        if (!Intrinsics.areEqual(strJoin, str)) {
                            if (str != null) {
                                AbstractC1974b.m1332y(sb, ANNOTATION_END_OPEN, str, ">");
                            }
                            AbstractC1974b.m1332y(sb, ANNOTATION_START_OPEN, strJoin, ">");
                        }
                        String text2 = spenPdfText2.getText();
                        Intrinsics.checkNotNull(text2);
                        sb.append(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(text2, "\r\n", ""), "\n", ""), StringUtils.f9761CR, ""), ANNOTATION_START_OPEN, LESS_THAN), ">", GREATER_THAN));
                        str = strJoin;
                    } else {
                        strArr = strArr2;
                        f = fontSize;
                    }
                    f5 = f;
                    arrayList.add(FONT_SIZE + f5);
                    arrayList.add(FONT_COLOR + style.getColor());
                    if (style.getIsBold()) {
                    }
                    if (style.getIsItalic()) {
                    }
                    strJoin = TextUtils.join(",", arrayList);
                    if (!Intrinsics.areEqual(strJoin, str)) {
                    }
                    String text22 = spenPdfText2.getText();
                    Intrinsics.checkNotNull(text22);
                    sb.append(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(text22, "\r\n", ""), "\n", ""), StringUtils.f9761CR, ""), ANNOTATION_START_OPEN, LESS_THAN), ">", GREATER_THAN));
                    str = strJoin;
                } else {
                    strArr = strArr2;
                    i = size;
                }
                i6++;
                size = i;
                strArr2 = strArr;
            }
            String[] strArr3 = strArr2;
            int i8 = size;
            if (str != null) {
                AbstractC1974b.m1332y(sb, ANNOTATION_END_OPEN, str, ">");
            }
            strArr3[i5] = sb.toString();
            i5++;
            listParagraph2 = listParagraph;
            size = i8;
            strArr2 = strArr3;
            i4 = 0;
        }
        String[] strArr4 = strArr2;
        arrayList.clear();
        sb.setLength(0);
        return strArr4;
    }

    private final float getScale(SpenPdfText pdfText) {
        Intrinsics.checkNotNull(pdfText.getMatrix());
        float fPow = (float) Math.pow(r0[0], 2.0f);
        Intrinsics.checkNotNull(pdfText.getMatrix());
        return (float) Math.sqrt(fPow + ((float) Math.pow(r7[1], r2)));
    }

    private final TagInfo getTagInfo(String input, int startPos, boolean isOpenTag) {
        int iM14129C;
        if (input == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        TagInfo tagInfo = new TagInfo(-1, -1, null);
        while (startPos < input.length()) {
            int iM14129C2 = StringsKt.m14129C(isOpenTag ? ANNOTATION_START_OPEN : ANNOTATION_END_OPEN, startPos, 4, input);
            if (iM14129C2 == -1 || (iM14129C = StringsKt.m14129C(">", iM14129C2, 4, input)) == -1) {
                break;
            }
            String validTag = getValidTag(input, iM14129C2 + 1, iM14129C);
            if (validTag != null) {
                return new TagInfo(iM14129C2, iM14129C, validTag);
            }
            startPos = iM14129C;
        }
        return tagInfo;
    }

    private final SpenPdfTextStyle getTextStyleFromTag(String taggedStr) {
        SpenPdfTextStyle spenPdfTextStyle = new SpenPdfTextStyle();
        Intrinsics.checkNotNull(taggedStr);
        int iM14129C = StringsKt.m14129C(FONT_SIZE, 0, 6, taggedStr) + 5;
        String strSubstring = taggedStr.substring(iM14129C, StringsKt.m14129C(",", iM14129C, 4, taggedStr));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        spenPdfTextStyle.setFontSize(Double.parseDouble(strSubstring));
        int iM14129C2 = StringsKt.m14129C(FONT_COLOR, 0, 6, taggedStr) + 6;
        int iM14129C3 = StringsKt.m14129C(",", iM14129C2, 4, taggedStr);
        if (iM14129C3 == -1) {
            iM14129C3 = taggedStr.length();
        }
        String strSubstring2 = taggedStr.substring(iM14129C2, iM14129C3);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        spenPdfTextStyle.setColor(Integer.parseInt(strSubstring2));
        if (StringsKt.m14129C(BOLD, iM14129C3, 4, taggedStr) != -1) {
            spenPdfTextStyle.setBold(true);
        }
        if (StringsKt.m14129C(ITALIC, iM14129C3, 4, taggedStr) != -1) {
            spenPdfTextStyle.setItalic(true);
        }
        return spenPdfTextStyle;
    }

    private final String getValidTag(String input, int from, int to) {
        if (input == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        String strSubstring = input.substring(from, to);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (StringsKt.m14129C(FONT_SIZE, 0, 6, strSubstring) == -1) {
            return null;
        }
        return strSubstring;
    }

    private final boolean mergeToPreviousPdfText(SpenPdfParagraph paragraph, String text) {
        if (paragraph == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (text == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ArrayList<SpenPdfText> listPdfText = paragraph.getListPdfText();
        Intrinsics.checkNotNull(listPdfText);
        if (listPdfText.size() <= 0) {
            return false;
        }
        String strRemoveExcessTag = removeExcessTag(text);
        ArrayList<SpenPdfText> listPdfText2 = paragraph.getListPdfText();
        Intrinsics.checkNotNull(listPdfText2);
        SpenPdfText spenPdfText = listPdfText2.get(listPdfText2.size() - 1);
        Intrinsics.checkNotNullExpressionValue(spenPdfText, "get(...)");
        SpenPdfText spenPdfText2 = spenPdfText;
        spenPdfText2.setText(spenPdfText2.getText() + strRemoveExcessTag);
        return true;
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<SpenPdfParagraph> parse(@NotNull String[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ArrayList<SpenPdfParagraph> arrayList = new ArrayList<>();
        for (String str : input) {
            if (str == null) {
                return null;
            }
            SpenPdfParagraph spenPdfParagraph = INSTANCE.parse(str);
            if (spenPdfParagraph == null) {
                Log.i(TAG, AbstractC11014a.m12321f("Parse() - Fail to parse pdfParagraph [", arrayList.size(), "] - [", str, "]"));
                return null;
            }
            arrayList.add(spenPdfParagraph);
        }
        return arrayList;
    }

    private final String removeExcessTag(String text) {
        int iM14129C;
        if (text == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        StringBuilder sb = new StringBuilder(text);
        int iM14129C2 = 0;
        while (iM14129C2 < sb.length() && (iM14129C2 = StringsKt.m14129C(ANNOTATION_START_OPEN, iM14129C2, 4, text)) != -1 && (iM14129C = StringsKt.m14129C(">", iM14129C2, 4, text)) != -1) {
            sb.delete(iM14129C2, iM14129C);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final SpenPdfParagraph parse(String input) {
        int startIdx;
        String strSubstring;
        if (input != null) {
            SpenPdfParagraph spenPdfParagraph = new SpenPdfParagraph();
            int endIdx = 0;
            while (true) {
                if (endIdx >= input.length()) {
                    break;
                }
                TagInfo tagInfo = getTagInfo(input, endIdx, true);
                TagInfo tagInfo2 = getTagInfo(input, endIdx, false);
                if (tagInfo.getStartIdx() == -1) {
                    String strSubstring2 = input.substring(endIdx);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    if (!mergeToPreviousPdfText(spenPdfParagraph, strSubstring2)) {
                        ArrayList<SpenPdfText> listPdfText = spenPdfParagraph.getListPdfText();
                        Intrinsics.checkNotNull(listPdfText);
                        AbstractC11014a.m12328m(listPdfText.size(), "Parse pdfText[", "] - Fail to find any tag", TAG);
                        return null;
                    }
                } else {
                    if (tagInfo2.getTag() == null) {
                        tagInfo2.setStartIdx(input.length());
                        tagInfo2.setEndIdx(input.length());
                    }
                    if (tagInfo.getStartIdx() == endIdx) {
                        endIdx = tagInfo.getEndIdx() + 1;
                        if (tagInfo2.getStartIdx() == tagInfo.getStartIdx()) {
                            endIdx = tagInfo2.getEndIdx();
                        } else {
                            startIdx = tagInfo2.getStartIdx();
                        }
                    } else {
                        startIdx = tagInfo2.getStartIdx();
                    }
                    SpenPdfTextStyle textStyleFromTag = getTextStyleFromTag(tagInfo.getTag() != null ? tagInfo.getTag() : tagInfo2.getTag());
                    SpenPdfText spenPdfText = new SpenPdfText();
                    if (endIdx < tagInfo.getStartIdx()) {
                        strSubstring = input.substring(endIdx, tagInfo.getStartIdx());
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        if (startIdx > tagInfo.getEndIdx() + 1) {
                            String strSubstring3 = input.substring(tagInfo.getEndIdx() + 1, startIdx);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            strSubstring = AbstractC0541b.m756B(strSubstring, strSubstring3);
                        }
                    } else {
                        strSubstring = input.substring(endIdx, startIdx);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    spenPdfText.setText(StringsKt.m14139M(StringsKt.m14139M(removeExcessTag(strSubstring), LESS_THAN, ANNOTATION_START_OPEN), GREATER_THAN, ">"));
                    spenPdfText.setStyle(textStyleFromTag);
                    spenPdfParagraph.add(spenPdfText);
                    endIdx = tagInfo2.getEndIdx() + 1;
                }
            }
            return spenPdfParagraph;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
