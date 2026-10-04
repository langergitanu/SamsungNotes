package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ServerResultParser {
    public static final String DETAILS = "details";
    private static final String PATTERN_TASK_STYLE = "^-|^\\d+\\)|^\\*|^@|^❖|^•";
    private static final String QUOTES = "\"";
    public static final String SUBHEADING = "subheading";
    public static final String TITLE = "title";
    FormatStructure mFormatStructure;
    private boolean mIsSingleLineCase;
    private final boolean mIsStreamingMode;
    String mSrc;
    private static final String TAG = Logger.createTag("ServerResultParser", AiConstants.PREFIX_TAG);
    public static final int MAIN_DEF_FONT_COLOR = Color.parseColor("#252528");
    public static final int MAIN_SECOND_DEF_FONT_COLOR = Color.parseColor("#47474A");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbsFormat {
        String mText;

        public AbsFormat(String str) {
            this.mText = str;
        }

        public void applyStyle(FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mText);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DetailFormat extends AbsFormat {
        List<SentenceFormat> mSentenceList;

        public DetailFormat(String str) {
            super(str);
            this.mSentenceList = new ArrayList();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            Iterator<SentenceFormat> it = this.mSentenceList.iterator();
            while (it.hasNext()) {
                it.next().applyStyle(formatStyle, i, textStyleHelper);
            }
            formatStyle.applyDetail(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public boolean isEmpty() {
            return this.mSentenceList.isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FormatStructure {
        List<AbsFormat> mFormatList = new ArrayList();

        public void addFormat(AbsFormat absFormat) {
            this.mFormatList.add(absFormat);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class FormatStyle {
        int mMaxFontSize = 24;
        int mMinFontSize;

        public FormatStyle(int i) {
            this.mMinFontSize = i;
        }

        public abstract void applyDetail(int i, TextStyleHelper textStyleHelper);

        public abstract void applySentence(String str, int i, TextStyleHelper textStyleHelper);

        public abstract void applySubHeading(String str, int i, TextStyleHelper textStyleHelper);

        public abstract void applyTitle(String str, int i, TextStyleHelper textStyleHelper);

        public int getBodyFontSize(int i) {
            int i2 = this.mMinFontSize;
            if (i < i2) {
                return i2;
            }
            int i4 = this.mMaxFontSize;
            return i > i4 ? i4 : i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderBulletStyleFive extends HeaderBulletStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");

        public HeaderBulletStyleFive(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < 12 ? 17 : i > this.mMaxFontSize ? 36 : 28;
            int length = objectTextBox.getText().length();
            textStyleHelper.setFontSize(i2, new int[]{length - 1, length});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            if (str.isEmpty()) {
                return;
            }
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
            int bodyFontSize = getBodyFontSize(i);
            int i2 = i < 12 ? 6 : i > this.mMaxFontSize ? 13 : 8;
            textStyleHelper.setFontSize(bodyFontSize, iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            int i4 = iArr[1];
            textStyleHelper.setFontSize(i2, new int[]{i4 + 1, i4 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            String strM756B = AbstractC0541b.m756B(str, "\n___________________");
            int length = objectTextBox.getText().length();
            if (length == 0) {
                textStyleHelper.setAlign(2, new int[]{0, 1});
            }
            int[] iArr2 = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr2);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i < 12 ? 8 : i > this.mMaxFontSize ? 16 : 15;
            if (str.contains("\n")) {
                int i5 = iArr2[1];
                iArr = new int[]{i5, i5 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i6 = iArr2[1];
                iArr = new int[]{i6 + 1, i6 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i4, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr2 = {0, str.length()};
            int bodyFontSize = getBodyFontSize(i) + 9;
            int i2 = 32;
            if (i <= 12) {
                bodyFontSize = 20;
            } else if (i >= this.mMaxFontSize) {
                bodyFontSize = 32;
            }
            textStyleHelper.setFontSize(bodyFontSize, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i4 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i4, i4});
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setAlign(2, iArr2);
            if (i < 12) {
                i2 = 20;
            } else if (i <= this.mMaxFontSize) {
                i2 = 28;
            }
            if (str.contains("\n")) {
                int i5 = iArr2[1];
                iArr = new int[]{i5, i5 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i6 = iArr2[1];
                iArr = new int[]{i6 + 1, i6 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderBulletStyleFour extends HeaderBulletStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");
        static final int TITLE_FONT_COLOR = Color.parseColor("#FAFAFF");
        static final int SUB_TITLE_FONT_COLOR = Color.parseColor("#215ACB");

        public HeaderBulletStyleFour(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < 12 ? 17 : i > this.mMaxFontSize ? 28 : 22;
            int length = objectTextBox.getText().length();
            textStyleHelper.setFontSize(i2, new int[]{length - 1, length});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
            int bodyFontSize = getBodyFontSize(i);
            int i2 = i < 12 ? 5 : i > this.mMaxFontSize ? 13 : 10;
            textStyleHelper.setFontSize(bodyFontSize, iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i4 = iArr[1];
            textStyleHelper.removeTask(new int[]{i4 + 1, i4 + 2});
            int i5 = iArr[1];
            textStyleHelper.setFontSize(i2, new int[]{i5 + 1, i5 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            if (str.isEmpty()) {
                return;
            }
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr2 = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i) + 2, iArr2);
            textStyleHelper.setTextColor(SUB_TITLE_FONT_COLOR, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            textStyleHelper.setItalic(true, iArr2);
            int i4 = iArr2[1];
            textStyleHelper.setItalic(false, new int[]{i4, i4});
            int i5 = i < 12 ? 4 : 6;
            if (str.contains("\n")) {
                int i6 = iArr2[1];
                iArr = new int[]{i6, i6 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i7 = iArr2[1];
                iArr = new int[]{i7 + 1, i7 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i5, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            String strReplace = str.contains("\n") ? str.replace("\n", SequenceUtils.SPACE_EOL) : str.concat(" ");
            objectTextBox.setText(strReplace);
            int[] iArr2 = {0, strReplace.length()};
            int bodyFontSize = getBodyFontSize(i) + 9;
            int i2 = 22;
            if (i >= this.mMaxFontSize) {
                bodyFontSize = 32;
            } else if (i <= 12) {
                bodyFontSize = 22;
            }
            textStyleHelper.setFontSize(bodyFontSize, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i4 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i4, i4});
            textStyleHelper.setItalic(true, iArr2);
            int i5 = iArr2[1];
            textStyleHelper.setItalic(false, new int[]{i5, i5});
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr2);
            int i6 = DEF_FONT_COLOR;
            int i7 = iArr2[1];
            textStyleHelper.setTextColor(i6, new int[]{i7, i7});
            textStyleHelper.setTextBgColor(Color.parseColor("#316EEF"), iArr2);
            int i8 = iArr2[1];
            textStyleHelper.setTextBgColor(0, new int[]{i8, i8});
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr2);
            if (i < 12) {
                i2 = 18;
            } else if (i > this.mMaxFontSize) {
                i2 = 32;
            }
            if (strReplace.contains("\n")) {
                int i9 = iArr2[1];
                iArr = new int[]{i9, i9 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i10 = iArr2[1];
                iArr = new int[]{i10 + 1, i10 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderBulletStyleOne extends FormatStyle {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");

        public HeaderBulletStyleOne(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int bodyFontSize = getBodyFontSize(i);
            int length = objectTextBox.getText().length();
            textStyleHelper.setFontSize(bodyFontSize, new int[]{length - 1, length});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = i < 12 ? 4 : i > this.mMaxFontSize ? 13 : 10;
            int i5 = iArr[1];
            textStyleHelper.setFontSize(i4, new int[]{i5 + 1, i5 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr2 = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(Math.max(1, getBodyFontSize(i) - (i >= this.mMaxFontSize ? 4 : 3)), iArr2);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i >= 12 ? 6 : 3;
            if (str.contains("\n")) {
                int i5 = iArr2[1];
                iArr = new int[]{i5, i5 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i6 = iArr2[1];
                iArr = new int[]{i6 + 1, i6 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i4, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr2 = {0, str.length()};
            int bodyFontSize = getBodyFontSize(i);
            textStyleHelper.setFontSize(bodyFontSize + (bodyFontSize >= this.mMaxFontSize ? 4 : 3), iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            textStyleHelper.setUnderline(true, iArr2);
            int i4 = iArr2[1];
            textStyleHelper.setUnderline(false, new int[]{i4, i4});
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr2);
            int i5 = this.mMaxFontSize;
            if (i < 12) {
                i5 = 18;
            } else if (i > i5) {
                i5 = 28;
            }
            if (str.contains("\n")) {
                int i6 = iArr2[1];
                iArr = new int[]{i6, i6 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i7 = iArr2[1];
                iArr = new int[]{i7 + 1, i7 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i5, iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderBulletStyleStreaming extends HeaderBulletStyleOne {
        public HeaderBulletStyleStreaming(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int bodyFontSize = getBodyFontSize(i);
            int length = objectTextBox.getText().length();
            textStyleHelper.setFontSize(bodyFontSize, new int[]{length - 1, length});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            if (str.isEmpty()) {
                return;
            }
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = iArr[1];
            textStyleHelper.setFontSize(10, new int[]{i4 + 1, i4 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            if (str.isEmpty()) {
                return;
            }
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(Math.max(1, getBodyFontSize(i) - 3), iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i >= 12 ? 6 : 3;
            objectTextBox.insertText("\n", iArr[1]);
            int i5 = iArr[1];
            int[] iArr2 = {i5 + 1, i5 + 2};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr = {0, str.length()};
            textStyleHelper.setFontSize(getBodyFontSize(i) + 3, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText("\n", iArr[1]);
            int i4 = iArr[1];
            objectTextBox.insertText("\n", new int[]{i4 + 1, i4 + 2}[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderBulletStyleThree extends HeaderBulletStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");

        public HeaderBulletStyleThree(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
            super.applyDetail(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
            int bodyFontSize = getBodyFontSize(i);
            int i2 = i < 12 ? 6 : i > this.mMaxFontSize ? 10 : 8;
            textStyleHelper.setFontSize(bodyFontSize, iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            int i4 = iArr[1];
            textStyleHelper.setFontSize(i2, new int[]{i4 + 1, i4 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            String strM772n = AbstractC0541b.m772n("___\n", str);
            int length = objectTextBox.getText().length();
            int[] iArr2 = {length, strM772n.length() + length};
            objectTextBox.insertText(strM772n, length);
            textStyleHelper.setFontSize(getBodyFontSize(i) + 2, iArr2);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i < 12 ? 4 : 6;
            if (str.contains("\n")) {
                int i5 = iArr2[1];
                iArr = new int[]{i5, i5 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i6 = iArr2[1];
                iArr = new int[]{i6 + 1, i6 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i4, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), new int[]{0, 0});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderBulletStyleTwo extends HeaderBulletStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#47474A");
        static final int TITLE_FONT_COLOR = Color.parseColor("#615EC6");

        public HeaderBulletStyleTwo(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
            super.applyDetail(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            int bodyFontSize = getBodyFontSize(i);
            objectTextBox.insertText(str.concat(MarkdownDocument.NEW_LINE), length);
            textStyleHelper.setFontSize(bodyFontSize, iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setIndent(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeIndent(new int[]{i2 + 1, i2 + 2});
            int i4 = i < 12 ? 4 : i > this.mMaxFontSize ? 13 : 10;
            int i5 = iArr[1];
            textStyleHelper.setFontSize(i4, new int[]{i5 + 1, i5 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr2 = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(Math.max(1, getBodyFontSize(i)), iArr2);
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i < 12 ? 3 : 6;
            if (str.contains("\n")) {
                int i5 = iArr2[1];
                iArr = new int[]{i5, i5 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i6 = iArr2[1];
                iArr = new int[]{i6 + 1, i6 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i4, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.HeaderBulletStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr2 = {0, str.length()};
            textStyleHelper.setFontSize(getBodyFontSize(i) + 7, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr2);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr2);
            int i4 = i < 12 ? 18 : i > this.mMaxFontSize ? 28 : 24;
            if (str.contains("\n")) {
                int i5 = iArr2[1];
                iArr = new int[]{i5, i5 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i6 = iArr2[1];
                iArr = new int[]{i6 + 1, i6 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i4, iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SentenceFormat extends AbsFormat {
        public SentenceFormat(String str) {
            super(str);
            this.mText = removeTextDuplicatedTask(str);
        }

        public static String removeTextDuplicatedTask(String str) {
            String strTrim = str.trim();
            int iMin = Math.min(5, strTrim.length());
            int iCharCount = 0;
            String strSubstring = strTrim.substring(0, iMin);
            String strSubstring2 = strSubstring.matches("^\\d+[.|-]\\D.*") ? strSubstring.substring(Math.max(strSubstring.indexOf(Extension.DOT), strSubstring.indexOf(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) + 1) : strSubstring.replaceFirst(ServerResultParser.PATTERN_TASK_STYLE, "");
            if (strSubstring.equals(strSubstring2)) {
                return strTrim;
            }
            int length = strSubstring2.length();
            while (iCharCount < length) {
                int iCodePointAt = strSubstring2.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            return AbstractC4539a.m3198h(AbstractC1974b.m1324q(strSubstring2.substring(iCharCount, length)), strTrim, iMin);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            formatStyle.applySentence(this.mText, i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SubHeadingFormat extends AbsFormat {
        public SubHeadingFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            formatStyle.applySubHeading(this.mText, i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TitleFormat extends AbsFormat {
        public TitleFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            formatStyle.applyTitle(this.mText, i, textStyleHelper);
        }
    }

    public ServerResultParser(String str) {
        this(str, false);
    }

    private boolean compareOrder(Integer num, Integer num2) {
        return (num == null || num2 == null || num.intValue() <= num2.intValue()) ? false : true;
    }

    @NonNull
    private SentenceFormat getSentenceFormat(String str) {
        return new SentenceFormat(parseValue(str));
    }

    private void invertAfterParsing() {
        FormatStructure formatStructure = new FormatStructure();
        Iterator<AbsFormat> it = this.mFormatStructure.mFormatList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbsFormat next = it.next();
            if (next instanceof TitleFormat) {
                formatStructure.addFormat(next);
                break;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (AbsFormat absFormat : this.mFormatStructure.mFormatList) {
            if (absFormat instanceof SubHeadingFormat) {
                formatStructure.addFormat(absFormat);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    formatStructure.addFormat((AbsFormat) it2.next());
                }
                arrayList.clear();
            } else if (absFormat instanceof DetailFormat) {
                arrayList.add(absFormat);
            }
        }
        this.mFormatStructure = formatStructure;
    }

    private void preProcess() {
        StringBuilder sb = new StringBuilder(this.mSrc.length());
        int i = 0;
        Integer numValueOf = null;
        for (int i2 = 1; i2 < this.mSrc.length(); i2++) {
            char cCharAt = this.mSrc.charAt(i2 - 1);
            if (this.mSrc.charAt(i2) == '\"') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i2);
                    sb.append(this.mSrc.substring(i, i2));
                } else if (cCharAt != '\\') {
                    sb.append(StringUtils.convertUnexpectedChars(this.mSrc.substring(numValueOf.intValue(), i2)).replace("\\'", "'").replace("\\\"", QUOTES).replaceAll("\\\\", ""));
                    numValueOf = null;
                }
                i = i2;
            }
        }
        if (i != this.mSrc.length() - 1) {
            sb.append(StringUtils.convertUnexpectedChars(this.mSrc.substring(i)));
        }
        this.mSrc = sb.toString();
    }

    public void applyFormat(int i, SpenObjectTextBox spenObjectTextBox, int i2) {
        TextStyleHelper textStyleHelper = new TextStyleHelper(spenObjectTextBox);
        FormatStyle formatStyleMakeStyle = makeStyle(i, Math.min(12, i2));
        Iterator<AbsFormat> it = this.mFormatStructure.mFormatList.iterator();
        while (it.hasNext()) {
            it.next().applyStyle(formatStyleMakeStyle, i2, textStyleHelper);
        }
        removeOverLinefeed(spenObjectTextBox, textStyleHelper, i2);
    }

    public boolean checkParseResult() {
        FormatStructure formatStructure = this.mFormatStructure;
        if (formatStructure != null && !formatStructure.mFormatList.isEmpty()) {
            Iterator<AbsFormat> it = this.mFormatStructure.mFormatList.iterator();
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(it.next().mText)) {
                    return true;
                }
            }
        }
        return false;
    }

    public FormatStyle makeStyle(int i, int i2) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 999 ? new HeaderBulletStyleOne(i2) : new HeaderBulletStyleStreaming(i2) : new HeaderBulletStyleFive(i2) : new HeaderBulletStyleFour(i2) : new HeaderBulletStyleThree(i2) : new HeaderBulletStyleTwo(i2);
    }

    public void parse() {
        String[] strArrSplitLine = splitLine();
        boolean z = strArrSplitLine.length == 1;
        this.mIsSingleLineCase = z;
        if (z) {
            Logger.m10999d(TAG, "parse# single line case");
        }
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        int sentence = 0;
        Integer numValueOf3 = null;
        while (sentence < strArrSplitLine.length) {
            String str = strArrSplitLine[sentence];
            if (str.contains("\"title\"")) {
                numValueOf = Integer.valueOf(sentence);
                this.mFormatStructure.addFormat(new TitleFormat(parseValueFromKeyValue(str)));
            } else if (str.contains("\"subheading\"")) {
                if (numValueOf3 == null) {
                    numValueOf3 = Integer.valueOf(sentence);
                }
                this.mFormatStructure.addFormat(new SubHeadingFormat(parseValueFromKeyValue(str)));
            } else if (str.contains("\"details\"")) {
                if (numValueOf2 == null) {
                    numValueOf2 = Integer.valueOf(sentence);
                }
                DetailFormat detailFormat = new DetailFormat("");
                if (str.contains("[")) {
                    this.mFormatStructure.addFormat(detailFormat);
                    sentence = parseSentence(detailFormat, strArrSplitLine, sentence);
                } else if (str.contains(":")) {
                    detailFormat.mSentenceList.add(getSentenceFormat(str));
                    this.mFormatStructure.addFormat(detailFormat);
                }
            }
            sentence++;
        }
        if (compareOrder(numValueOf, numValueOf3) || compareOrder(numValueOf, numValueOf2) || compareOrder(numValueOf3, numValueOf2)) {
            invertAfterParsing();
        }
    }

    public void parseInlineArray(String str, int i, Integer num, DetailFormat detailFormat) {
        Integer numValueOf = null;
        while (i < num.intValue()) {
            if (str.charAt(i) == '\"') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i);
                } else if (str.charAt(i - 1) != '\\') {
                    detailFormat.mSentenceList.add(new SentenceFormat(str.substring(numValueOf.intValue() + 1, i)));
                    numValueOf = null;
                }
            }
            i++;
        }
    }

    public int parseSentence(DetailFormat detailFormat, String[] strArr, int i) {
        String str;
        int iIndexOf;
        if (strArr[i].contains(" null,")) {
            Logger.m10999d(TAG, "parseArrayItems# empty");
            return i;
        }
        String str2 = strArr[i];
        int iIndexOf2 = str2.indexOf(91);
        int iLastIndexOf = str2.lastIndexOf(93);
        if (iIndexOf2 != -1 && iLastIndexOf != -1) {
            parseInlineArray(str2, iIndexOf2, Integer.valueOf(iLastIndexOf), detailFormat);
            return i;
        }
        while (true) {
            i++;
            if (i >= strArr.length || ((iIndexOf = (str = strArr[i]).indexOf(93)) > -1 && str.indexOf(34, iIndexOf) == -1)) {
                break;
            }
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                int iIndexOf3 = strTrim.indexOf(QUOTES) + 1;
                int iLastIndexOf2 = strTrim.lastIndexOf(QUOTES);
                if (iIndexOf3 > iLastIndexOf2) {
                    iLastIndexOf2 = strTrim.length();
                }
                detailFormat.mSentenceList.add(new SentenceFormat(strTrim.substring(iIndexOf3, iLastIndexOf2)));
            }
        }
        return i;
    }

    public String parseValue(String str) {
        int iIndexOf = str.indexOf(QUOTES, str.indexOf(58));
        if (iIndexOf < 0) {
            Logger.m10999d(TAG, "parseValue# not found quotes in value");
            return "";
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(QUOTES, i);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        return str.substring(i, iIndexOf2);
    }

    public String parseValueFromKeyValue(String str) {
        return parseValueFromValue(str, str.indexOf(58));
    }

    public String parseValueFromValue(String str, int i) {
        int iIndexOf = str.indexOf(QUOTES, i) + 1;
        int iIndexOf2 = this.mIsSingleLineCase ? str.indexOf(QUOTES, iIndexOf) : str.lastIndexOf(QUOTES);
        if (this.mIsStreamingMode) {
            iIndexOf2 = str.indexOf(QUOTES, iIndexOf);
        }
        if (iIndexOf > iIndexOf2) {
            iIndexOf2 = str.length();
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    public void removeOverLinefeed(SpenObjectTextBox spenObjectTextBox, TextStyleHelper textStyleHelper, int i) {
        String text = spenObjectTextBox.getText();
        int i2 = 0;
        for (int length = text.length() - 1; length >= 0 && text.charAt(length) == '\n'; length--) {
            i2++;
        }
        if (i2 > 2) {
            int i4 = i2 - 2;
            spenObjectTextBox.removeText(text.length() - i4, i4);
            i2 = 2;
        }
        if (i2 > 0) {
            int length2 = spenObjectTextBox.getText().length();
            textStyleHelper.setFontSize(i, new int[]{length2 - i2, length2});
        }
    }

    public String[] splitLine() {
        preProcess();
        return this.mSrc.replace("\\n", "\n").split("\n");
    }

    public ServerResultParser(String str, boolean z) {
        this.mSrc = str;
        this.mIsStreamingMode = z;
        this.mFormatStructure = new FormatStructure();
    }
}
