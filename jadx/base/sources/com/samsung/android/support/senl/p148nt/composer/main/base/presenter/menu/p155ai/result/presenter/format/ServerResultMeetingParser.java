package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ServerResultMeetingParser extends ServerResultParser {
    public static final String AGENDAS = "agendas";
    public static final String CONTENTS = "contents";
    public static final String DATE = "date";
    public static final String DETAILS = "details";
    public static final String PARTICIPANTS = "participants";
    public static final String PLACE = "place";
    private static final String QUOTES = "\"";
    public static final String SUBHEADING = "subheading";
    private static final String TAG = Logger.createTag("ServerResultMeetingParser", AiConstants.PREFIX_TAG);
    public static final String TIME = "time";
    public static final String TITLE = "title";
    private String mAgendas;
    private String mContents;
    private String mDateKey;
    private String mDetailsKey;
    private MeetingFormat mInfoEndFormat;
    private final List<Integer> mInfoEndIndexList;
    private String mParticipants;
    private String mPlaceKey;
    private Context mResultLocaleContext;
    private String mSubHeading;
    private String mTimeKey;
    private String mTitleKey;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AgendaFormat extends MeetingFormat {
        int mNumber;

        public AgendaFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            formatStyle.applySentence(this.mText, i, textStyleHelper);
        }

        public void setNumber(int i) {
            this.mNumber = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AgendasFormat extends ArrayFormat {
        String mInfoTitle;

        public AgendasFormat(String str, String str2) {
            super(str);
            this.mInfoTitle = str2;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            if (this.mItemList.isEmpty()) {
                return;
            }
            formatStyle.applySubHeading(this.mInfoTitle, i, textStyleHelper);
            for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
                ((AgendaFormat) this.mItemList.get(i2)).applyStyle(formatStyle, i, textStyleHelper);
            }
            textStyleHelper.getObjectTextBox().removeText(textStyleHelper.getObjectTextBox().getText().length(), 1);
            ((MeetingFormatStyle) formatStyle).applyBetweenArrayItemAndSubHeading(i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ArrayFormat extends MeetingFormat {
        List<MeetingFormat> mItemList;

        public ArrayFormat(String str) {
            super(str);
            this.mItemList = new ArrayList();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public boolean isEmpty() {
            return this.mItemList.isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContentFormat extends ArrayFormat {
        public ContentFormat(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DateFormat extends InformationFormat {
        public DateFormat(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DetailFormat extends ArrayFormat {
        public DetailFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            Iterator<MeetingFormat> it = this.mItemList.iterator();
            while (it.hasNext()) {
                it.next().applyStyle(formatStyle, i, textStyleHelper);
            }
            ((MeetingFormatStyle) formatStyle).applyBetweenArrayItemAndSubHeading(i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FormatStructure extends ServerResultParser.FormatStructure {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStructure
        public void addFormat(ServerResultParser.AbsFormat absFormat) {
            this.mFormatList.add(absFormat);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InformationFormat extends MeetingFormat {
        String mInfoTitle;

        public InformationFormat(String str, String str2) {
            super(str);
            this.mInfoTitle = str2;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            if (isEmpty()) {
                return;
            }
            ((MeetingFormatStyle) formatStyle).applyMeetingInfo(this.mInfoTitle, this.mText, i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class MeetingFormat extends ServerResultParser.AbsFormat {
        public MeetingFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public /* bridge */ /* synthetic */ void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            super.applyStyle(formatStyle, i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return super.isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class MeetingFormatStyle extends ServerResultParser.FormatStyle {
        public MeetingFormatStyle(int i) {
            super(i);
        }

        public abstract void applyBetweenArrayItemAndSubHeading(int i, TextStyleHelper textStyleHelper);

        public abstract void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper);

        public abstract void applyMeetingInfoEnd(int i, TextStyleHelper textStyleHelper, boolean z);

        public abstract void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper);

        public abstract void applyParticipantsNextLine(int i, int i2, TextStyleHelper textStyleHelper);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingInfoFormat extends ArrayFormat {
        public MeetingInfoFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            boolean zIsEmpty = true;
            for (MeetingFormat meetingFormat : this.mItemList) {
                meetingFormat.applyStyle(formatStyle, i, textStyleHelper);
                if (zIsEmpty) {
                    zIsEmpty = meetingFormat.isEmpty();
                }
            }
            ((MeetingFormatStyle) formatStyle).applyMeetingInfoEnd(i, textStyleHelper, zIsEmpty);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingStyleFive extends MeetingStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");
        static final int SUB_TITLE_BG_FONT_COLOR = Color.parseColor("#E9E9EC");

        public MeetingStyleFive(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyBetweenArrayItemAndSubHeading(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 15 : i > this.mMaxFontSize ? 32 : 24;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.insertText(AbstractC0541b.m756B(str2, "\n"), objectTextBox.getText().length());
            applyMeetingInfoNexLine(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne
        public void applyMeetingInfoNexLine(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 7 : 6;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTextBgColor(SUB_TITLE_BG_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText(Constant.WHITE_SPACE_FOR_LINK_ICON, iArr[1]);
            int i4 = iArr[1];
            textStyleHelper.setTextBgColor(0, new int[]{i4, i4 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 10 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTextBgColor(SUB_TITLE_BG_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText("\n", iArr[1]);
            int i4 = iArr[1];
            textStyleHelper.setTextBgColor(0, new int[]{i4 + 1, i4 + 1});
            int i5 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 7 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i5, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr = {0, str.length()};
            textStyleHelper.setFontSize(getBodyFontSize(i) + 6, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = DEF_FONT_COLOR;
            textStyleHelper.setTextColor(i4, iArr);
            textStyleHelper.setTextBgColor(Color.parseColor("#DEDEE3"), iArr);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr);
            objectTextBox.insertText(MarkdownDocument.NEW_LINE, iArr[1]);
            int i5 = iArr[1];
            int[] iArr2 = {i5 + 1, i5 + 2};
            textStyleHelper.setFontSize(i < this.mMinFontSize ? 18 : i > this.mMaxFontSize ? 32 : 24, iArr2);
            textStyleHelper.setTextColor(i4, iArr2);
            textStyleHelper.setTextBgColor(0, iArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingStyleFour extends MeetingStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");
        static final int TITLE_FONT_COLOR = Color.parseColor("#8C3F13");

        public MeetingStyleFour(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyBetweenArrayItemAndSubHeading(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 15 : i > this.mMaxFontSize ? 32 : 20;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.insertText(AbstractC0541b.m756B(str2, "\n"), objectTextBox.getText().length());
            applyMeetingInfoNexLine(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne
        public void applyMeetingInfoNexLine(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 3 : 6;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText(Constant.WHITE_SPACE_FOR_LINK_ICON, iArr[1]);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 10 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText("\n", iArr[1]);
            int i4 = DEF_FONT_COLOR;
            int i5 = iArr[1];
            textStyleHelper.setTextColor(i4, new int[]{i5 + 1, i5 + 1});
            int i6 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 7 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i6, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr = {0, str.length()};
            int i2 = 24;
            textStyleHelper.setFontSize(i <= this.mMinFontSize ? 24 : i >= this.mMaxFontSize ? 36 : i + 13, iArr);
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr);
            objectTextBox.insertText(MarkdownDocument.NEW_LINE, iArr[1]);
            int i4 = iArr[1];
            int[] iArr2 = {i4 + 1, i4 + 2};
            if (i < this.mMinFontSize) {
                i2 = 18;
            } else if (i > this.mMaxFontSize) {
                i2 = 26;
            }
            textStyleHelper.setFontSize(i2, iArr2);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingStyleOne extends MeetingFormatStyle {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");

        public MeetingStyleOne(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyBetweenArrayItemAndSubHeading(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 15 : i > this.mMaxFontSize ? 32 : 20;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyDetail(int i, TextStyleHelper textStyleHelper) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.insertText(AbstractC0541b.m756B(str2, "\n"), objectTextBox.getText().length());
            applyMeetingInfoNexLine(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoEnd(int i, TextStyleHelper textStyleHelper, boolean z) {
            if (z) {
                return;
            }
            textStyleHelper.getObjectTextBox().removeText(textStyleHelper.getObjectTextBox().getText().length(), 1);
            applyBetweenArrayItemAndSubHeading(i, textStyleHelper);
        }

        public void applyMeetingInfoNexLine(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 7 : 6;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, " |");
            int[] iArr = {length, strM756B.length() + length};
            int bodyFontSize = getBodyFontSize(i);
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(bodyFontSize, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText(Constant.WHITE_SPACE_FOR_LINK_ICON, iArr[1]);
            int i4 = DEF_FONT_COLOR;
            int i5 = iArr[1];
            textStyleHelper.setTextColor(i4, new int[]{i5, i5 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyParticipantsNextLine(int i, int i2, TextStyleHelper textStyleHelper) {
            applyMeetingInfoNexLine(i2, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 13 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 10 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr2 = {0, str.length()};
            int bodyFontSize = getBodyFontSize(i) + 7;
            if (i >= this.mMaxFontSize) {
                bodyFontSize = 32;
            }
            textStyleHelper.setFontSize(bodyFontSize, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr2);
            int i4 = i < this.mMinFontSize ? 18 : i > this.mMaxFontSize ? 40 : 26;
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
    public static class MeetingStyleStreaming extends MeetingStyleOne {
        public MeetingStyleStreaming(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyBetweenArrayItemAndSubHeading(int i, TextStyleHelper textStyleHelper) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.insertText(AbstractC0541b.m756B(str2, "\n"), objectTextBox.getText().length());
            applyMeetingInfoNexLine(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoEnd(int i, TextStyleHelper textStyleHelper, boolean z) {
            super.applyMeetingInfoEnd(i, textStyleHelper, false);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne
        public void applyMeetingInfoNexLine(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 7 : 6;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, " |");
            int[] iArr = {length, strM756B.length() + length};
            int bodyFontSize = getBodyFontSize(i);
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(bodyFontSize, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText(Constant.WHITE_SPACE_FOR_LINK_ICON, iArr[1]);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyParticipantsNextLine(int i, int i2, TextStyleHelper textStyleHelper) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int length2 = objectTextBox.getText().length();
            objectTextBox.insertText("\n", new int[]{length2, length2 + 1}[0]);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int length2 = objectTextBox.getText().length();
            objectTextBox.insertText("\n", new int[]{length2, length2 + 1}[0]);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            int[] iArr;
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr2 = {0, str.length()};
            int bodyFontSize = getBodyFontSize(i) + 7;
            if (i >= this.mMaxFontSize) {
                bodyFontSize = 32;
            }
            textStyleHelper.setFontSize(bodyFontSize, iArr2);
            textStyleHelper.setBold(true, iArr2);
            int i2 = iArr2[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            if (str.contains("\n")) {
                int i4 = iArr2[1];
                iArr = new int[]{i4, i4 + 1};
            } else {
                objectTextBox.insertText("\n", iArr2[1]);
                int i5 = iArr2[1];
                iArr = new int[]{i5 + 1, i5 + 2};
            }
            objectTextBox.insertText("\n", iArr[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingStyleThree extends MeetingStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");
        static final int TITLE_FONT_COLOR = Color.parseColor("#615EC6");

        public MeetingStyleThree(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyBetweenArrayItemAndSubHeading(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 18 : i > this.mMaxFontSize ? 32 : 24;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            String strM756B = AbstractC0541b.m756B(str2, "\n");
            int length = objectTextBox.getText().length();
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, iArr[0]);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            applyMeetingInfoNexLine(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne
        public void applyMeetingInfoNexLine(int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int i2 = i < this.mMinFontSize ? 10 : i > this.mMaxFontSize ? 13 : 12;
            int length = objectTextBox.getText().length();
            int[] iArr = {length, length + 1};
            objectTextBox.insertText("\n", iArr[0]);
            textStyleHelper.setFontSize(i2, iArr);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(i >= this.mMaxFontSize ? 26 : getBodyFontSize(i) + 3, iArr);
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            int i4 = i >= this.mMinFontSize ? 6 : 3;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyParticipantsNextLine(int i, int i2, TextStyleHelper textStyleHelper) {
            int[] iArr = {i, textStyleHelper.getObjectTextBox().getText().length()};
            textStyleHelper.setFontSize(getBodyFontSize(i2), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            applyMeetingInfoNexLine(i2, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 10 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingStyleTwo extends MeetingStyleOne {
        static final int DEF_FONT_COLOR = Color.parseColor("#252528");
        static final int TITLE_FONT_COLOR = Color.parseColor("#316EEF");

        public MeetingStyleTwo(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfo(String str, String str2, int i, TextStyleHelper textStyleHelper) {
            applyMeetingInfoTitle(str, i, textStyleHelper);
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.insertText(AbstractC0541b.m756B(str2, "\n"), objectTextBox.getText().length());
            applyMeetingInfoNexLine(i, textStyleHelper);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormatStyle
        public void applyMeetingInfoTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText(Constant.WHITE_SPACE_FOR_LINK_ICON, iArr[1]);
            int i4 = DEF_FONT_COLOR;
            int i5 = iArr[1];
            textStyleHelper.setTextColor(i4, new int[]{i5, i5 + 2});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySentence(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            String strM756B = AbstractC0541b.m756B(str, "\n");
            int[] iArr = {length, strM756B.length() + length};
            objectTextBox.insertText(strM756B, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr);
            textStyleHelper.setTask(iArr);
            int i2 = iArr[1];
            textStyleHelper.removeTask(new int[]{i2 + 1, i2 + 2});
            int i4 = i < this.mMinFontSize ? 3 : i > this.mMaxFontSize ? 10 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i4, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applySubHeading(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length();
            int[] iArr = {length, str.length() + length};
            objectTextBox.insertText(str, length);
            textStyleHelper.setFontSize(getBodyFontSize(i), iArr);
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr);
            textStyleHelper.setBold(true, iArr);
            int i2 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i2, i2});
            objectTextBox.insertText("\n", iArr[1]);
            int i4 = DEF_FONT_COLOR;
            int i5 = iArr[1];
            textStyleHelper.setTextColor(i4, new int[]{i5 + 1, i5 + 1});
            int i6 = i < this.mMinFontSize ? 3 : 6;
            int length2 = objectTextBox.getText().length();
            int[] iArr2 = {length2, length2 + 1};
            objectTextBox.insertText("\n", iArr2[0]);
            textStyleHelper.setFontSize(i6, iArr2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingStyleOne, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.FormatStyle
        public void applyTitle(String str, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.setText(str);
            int[] iArr = {0, str.length()};
            int i2 = 32;
            textStyleHelper.setFontSize(i <= this.mMinFontSize ? 24 : i >= this.mMaxFontSize ? 32 : i + 11, iArr);
            textStyleHelper.setBold(true, iArr);
            int i4 = iArr[1];
            textStyleHelper.setBold(false, new int[]{i4, i4});
            textStyleHelper.setUnderline(true, iArr);
            int i5 = iArr[1];
            textStyleHelper.setUnderline(false, new int[]{i5, i5});
            textStyleHelper.setTextColor(TITLE_FONT_COLOR, iArr);
            textStyleHelper.setAlign(2, iArr);
            objectTextBox.insertText(MarkdownDocument.NEW_LINE, iArr[1]);
            int i6 = iArr[1];
            int[] iArr2 = {i6 + 1, i6 + 2};
            if (i < this.mMinFontSize) {
                i2 = 20;
            } else if (i > this.mMaxFontSize) {
                i2 = 44;
            }
            textStyleHelper.setFontSize(i2, iArr2);
            textStyleHelper.setTextColor(DEF_FONT_COLOR, iArr2);
            textStyleHelper.setAlign(Alignment.getDefaultAlign(), iArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParticipantFormat extends ArrayFormat {
        public ParticipantFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            objectTextBox.insertText(AbstractC0622a.m1170p(this.mText, ",", new StringBuilder(" ")), objectTextBox.getText().length());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParticipantsFormat extends ArrayFormat {
        String mInfoTitle;

        public ParticipantsFormat(String str, String str2) {
            super(str);
            this.mInfoTitle = str2;
        }

        private void removeLastComma(TextStyleHelper textStyleHelper) {
            SpenObjectTextBox objectTextBox = textStyleHelper.getObjectTextBox();
            int length = objectTextBox.getText().length() - 1;
            if (objectTextBox.getText().charAt(length) == ',') {
                objectTextBox.removeText(length, 1);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            if (this.mItemList.isEmpty()) {
                return;
            }
            MeetingFormatStyle meetingFormatStyle = (MeetingFormatStyle) formatStyle;
            meetingFormatStyle.applyMeetingInfoTitle(this.mInfoTitle, i, textStyleHelper);
            int length = textStyleHelper.getObjectTextBox().getText().length();
            Iterator<MeetingFormat> it = this.mItemList.iterator();
            while (it.hasNext()) {
                it.next().applyStyle(formatStyle, i, textStyleHelper);
            }
            removeLastComma(textStyleHelper);
            meetingFormatStyle.applyParticipantsNextLine(length, i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PlaceFormat extends InformationFormat {
        public PlaceFormat(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SentenceFormat extends MeetingFormat {
        public SentenceFormat(String str) {
            super(str);
            this.mText = ServerResultParser.SentenceFormat.removeTextDuplicatedTask(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            formatStyle.applySentence(this.mText, i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SubHeadingFormat extends MeetingFormat {
        public SubHeadingFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            if (isEmpty()) {
                return;
            }
            formatStyle.applySubHeading(this.mText, i, textStyleHelper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeFormat extends InformationFormat {
        public TimeFormat(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TitleFormat extends MeetingFormat {
        public TitleFormat(String str) {
            super(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultMeetingParser.MeetingFormat, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.format.ServerResultParser.AbsFormat
        public void applyStyle(ServerResultParser.FormatStyle formatStyle, int i, TextStyleHelper textStyleHelper) {
            formatStyle.applyTitle(this.mText, i, textStyleHelper);
        }
    }

    public ServerResultMeetingParser(String str) {
        super(str);
        this.mResultLocaleContext = null;
        this.mInfoEndIndexList = new ArrayList();
        this.mFormatStructure = new FormatStructure();
    }

    @NonNull
    private SentenceFormat getSentenceFormat(String str) {
        return new SentenceFormat(parseValue(str));
    }

    private void initKey() {
        this.mTitleKey = "\"title\"";
        this.mDateKey = "\"date\"";
        this.mTimeKey = "\"time\"";
        this.mPlaceKey = "\"place\"";
        this.mParticipants = "\"participants\"";
        this.mAgendas = "\"agendas\"";
        this.mContents = "\"contents\"";
        this.mSubHeading = "\"subheading\"";
        this.mDetailsKey = "\"details\"";
    }

    private void parseInlineArray(String str, int i, Integer num, ArrayFormat arrayFormat, Constructor constructor) {
        Integer numValueOf = null;
        while (i < num.intValue()) {
            if (str.charAt(i) == '\"') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i);
                } else if (str.charAt(i - 1) != '\\') {
                    try {
                        arrayFormat.mItemList.add((MeetingFormat) constructor.newInstance(str.substring(numValueOf.intValue() + 1, i)));
                        numValueOf = null;
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        Logger.m11000e(TAG, "parseArrayItems# " + e.getMessage());
                        return;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
    }

    private int parseMeetingInformation(String[] strArr, int i) {
        MeetingFormat placeFormat;
        String str = strArr[i];
        MeetingInfoFormat meetingInfoFormat = null;
        if (str.contains(this.mDateKey)) {
            placeFormat = new DateFormat(parseValue(str), this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_date));
            AbstractC8014b.m7213o(new StringBuilder("parseDate# "), placeFormat.mText, TAG);
        } else if (str.contains(this.mTimeKey)) {
            placeFormat = new TimeFormat(parseValue(str), this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_time));
            AbstractC8014b.m7213o(new StringBuilder("parseTime# "), placeFormat.mText, TAG);
        } else if (str.contains(this.mPlaceKey)) {
            placeFormat = new PlaceFormat(parseValue(str), this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_place));
            AbstractC8014b.m7213o(new StringBuilder("parsePlace# "), placeFormat.mText, TAG);
        } else if (str.contains(this.mParticipants)) {
            ParticipantsFormat participantsFormat = new ParticipantsFormat("", this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_participants));
            AbstractC8014b.m7213o(new StringBuilder("parseParticipants# "), participantsFormat.mText, TAG);
            i = parseArrayItems(participantsFormat, strArr, i, ParticipantFormat.class);
            placeFormat = participantsFormat;
        } else {
            placeFormat = null;
        }
        if (placeFormat != null) {
            this.mInfoEndFormat = placeFormat;
            Iterator<ServerResultParser.AbsFormat> it = this.mFormatStructure.mFormatList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ServerResultParser.AbsFormat next = it.next();
                if (next instanceof MeetingInfoFormat) {
                    meetingInfoFormat = (MeetingInfoFormat) next;
                    break;
                }
            }
            if (meetingInfoFormat == null) {
                meetingInfoFormat = new MeetingInfoFormat("");
                this.mFormatStructure.addFormat(meetingInfoFormat);
            }
            meetingInfoFormat.mItemList.add(placeFormat);
        }
        return i;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser
    public void applyFormat(int i, SpenObjectTextBox spenObjectTextBox, int i2) {
        TextStyleHelper textStyleHelper = new TextStyleHelper(spenObjectTextBox);
        ServerResultParser.FormatStyle formatStyleMakeStyle = makeStyle(i, Math.min(12, i2));
        for (ServerResultParser.AbsFormat absFormat : this.mFormatStructure.mFormatList) {
            absFormat.applyStyle(formatStyleMakeStyle, i2, textStyleHelper);
            if (absFormat.equals(this.mInfoEndFormat)) {
                this.mInfoEndIndexList.add(Integer.valueOf(spenObjectTextBox.getText().length()));
            }
        }
        removeOverLinefeed(spenObjectTextBox, textStyleHelper, i2);
    }

    public void applyFormatReplaceInfoText(FormatStructure formatStructure, int i, SpenObjectTextBox spenObjectTextBox, int i2) {
        TextStyleHelper textStyleHelper = new TextStyleHelper(spenObjectTextBox);
        ServerResultParser.FormatStyle formatStyleMakeStyle = makeStyle(i, Math.min(12, i2));
        Iterator<ServerResultParser.AbsFormat> it = formatStructure.mFormatList.iterator();
        while (it.hasNext()) {
            it.next().applyStyle(formatStyleMakeStyle, i2, textStyleHelper);
        }
    }

    public List<Integer> getInfoEndIndexList() {
        return this.mInfoEndIndexList;
    }

    public Map<String, MeetingFormat> makeInfoFormatMap(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2) {
        HashMap map = new HashMap();
        TitleFormat titleFormat = new TitleFormat(str);
        DateFormat dateFormat = new DateFormat(str2, this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_date));
        TimeFormat timeFormat = new TimeFormat(str3, this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_time));
        PlaceFormat placeFormat = new PlaceFormat(str4, this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_place));
        ParticipantsFormat participantsFormat = new ParticipantsFormat("", this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_participants));
        for (String str5 : strArr) {
            participantsFormat.mItemList.add(new ParticipantFormat(str5));
        }
        AgendasFormat agendasFormat = new AgendasFormat("", this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_agenda));
        for (String str6 : strArr2) {
            agendasFormat.mItemList.add(new AgendaFormat(str6));
        }
        map.put("title", titleFormat);
        map.put("date", dateFormat);
        map.put("time", timeFormat);
        map.put(PLACE, placeFormat);
        map.put(PARTICIPANTS, participantsFormat);
        map.put(AGENDAS, agendasFormat);
        return map;
    }

    public FormatStructure makeInfoFormatStructure(Map<String, MeetingFormat> map) {
        FormatStructure formatStructure = new FormatStructure();
        formatStructure.addFormat(map.get("title"));
        MeetingInfoFormat meetingInfoFormat = new MeetingInfoFormat("");
        formatStructure.addFormat(meetingInfoFormat);
        meetingInfoFormat.mItemList.add(map.get("date"));
        meetingInfoFormat.mItemList.add(map.get("time"));
        meetingInfoFormat.mItemList.add(map.get(PLACE));
        meetingInfoFormat.mItemList.add(map.get(PARTICIPANTS));
        formatStructure.addFormat(map.get(AGENDAS));
        return formatStructure;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser
    public ServerResultParser.FormatStyle makeStyle(int i, int i2) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 999 ? new MeetingStyleOne(i2) : new MeetingStyleStreaming(i2) : new MeetingStyleFive(i2) : new MeetingStyleFour(i2) : new MeetingStyleThree(i2) : new MeetingStyleTwo(i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser
    public void parse() {
        String[] strArrSplitLine = splitLine();
        initKey();
        int meetingInformation = 0;
        while (meetingInformation < strArrSplitLine.length) {
            String str = strArrSplitLine[meetingInformation];
            if (str.contains(this.mTitleKey)) {
                TitleFormat titleFormat = new TitleFormat(parseValue(str));
                this.mFormatStructure.addFormat(titleFormat);
                this.mInfoEndFormat = titleFormat;
            } else if (str.contains(this.mAgendas)) {
                AgendasFormat agendasFormat = new AgendasFormat("", this.mResultLocaleContext.getString(C9086R.string.ai_auto_format_meeting_agenda));
                this.mFormatStructure.addFormat(agendasFormat);
                meetingInformation = parseArrayItems(agendasFormat, strArrSplitLine, meetingInformation, AgendaFormat.class);
                this.mInfoEndFormat = agendasFormat;
            } else if (str.contains(this.mContents)) {
                this.mFormatStructure.addFormat(new ContentFormat(""));
            } else if (str.contains(this.mSubHeading)) {
                this.mFormatStructure.addFormat(new SubHeadingFormat(parseValue(str)));
            } else if (str.contains(this.mDetailsKey)) {
                DetailFormat detailFormat = new DetailFormat("");
                if (str.contains("[")) {
                    this.mFormatStructure.addFormat(detailFormat);
                    meetingInformation = parseArrayItems(detailFormat, strArrSplitLine, meetingInformation, SentenceFormat.class);
                } else if (str.contains(":")) {
                    detailFormat.mItemList.add(getSentenceFormat(str));
                    this.mFormatStructure.addFormat(detailFormat);
                }
            } else {
                meetingInformation = parseMeetingInformation(strArrSplitLine, meetingInformation);
            }
            meetingInformation++;
        }
    }

    public int parseArrayItems(ArrayFormat arrayFormat, String[] strArr, int i, Class cls) {
        try {
            Constructor constructor = cls.getConstructor(String.class);
            if (strArr[i].contains(" null,") || !strArr[i].contains("[")) {
                Logger.m10999d(TAG, "parseArrayItems# empty");
                return i;
            }
            String str = strArr[i];
            int iIndexOf = str.indexOf(91);
            int iLastIndexOf = str.lastIndexOf(93);
            if (iIndexOf != -1 && iLastIndexOf != -1) {
                parseInlineArray(str, iIndexOf, Integer.valueOf(iLastIndexOf), arrayFormat, constructor);
                return i;
            }
            while (true) {
                i++;
                if (i >= strArr.length) {
                    break;
                }
                String str2 = strArr[i];
                if (!TextUtils.isEmpty(str2)) {
                    int iIndexOf2 = str2.indexOf(91);
                    int iIndexOf3 = str2.indexOf(93);
                    if (iIndexOf2 == -1 && iIndexOf3 > -1) {
                        break;
                    }
                    int iIndexOf4 = str2.indexOf(QUOTES) + 1;
                    int iLastIndexOf2 = str2.lastIndexOf(QUOTES);
                    if (iIndexOf4 > iLastIndexOf2) {
                        iLastIndexOf2 = str2.length();
                    }
                    try {
                        arrayFormat.mItemList.add((MeetingFormat) constructor.newInstance(str2.substring(iIndexOf4, iLastIndexOf2)));
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Logger.m10999d(TAG, "parseArrayItems# empty line");
                }
            }
            return i;
        } catch (NoSuchMethodException e2) {
            Logger.m11000e(TAG, "parseArrayItems# " + e2.getMessage());
            return i;
        }
    }

    public void setMeetingInfoLanguage(@NonNull Context context, @NonNull Locale locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        setResultLocaleContext(context.createConfigurationContext(configuration));
    }

    public void setResultLocaleContext(Context context) {
        this.mResultLocaleContext = context;
    }

    public void test() {
        this.mSrc = "{\n    \"title\" : \"마켓팅 최종 시안 확정 회의\",\n    \"date\" : \"2023.07.25\",\n    \"time\" : \"14:00\",\n    \"place\" : \"타워S, 6층 골드 회의실\",\n    \"participants\" : [\n        \"김창수 마켓팅 팀장\",\n        \"이민정 브랜드 기획담당\",\n        \"이상식 팀장\",\n        \"박성욱 프로\"\n    ],\n    \"agendas\" : [\n        \"신제품 5종 기획안 공유\",\n        \"작년 실적 부진 제품 리뷰\",\n        \"대표 보고안 작성\"\n    ],\n    \"contents\" : [\n        {\n            \"subheading\" : \"신제품 5종 기획안 공유\",\n            \"details\" : [\n                \"신제품 5종, 3종 동시 콜라보 진행\",\n                \"아이돌 마켓팅, 동남아 위주로 a멤버,구주에는 b멤버\",\n                \"구형 제품 재고 소진 활용안 필요\",\n                \"남은 2종에 대해서는 인플루언서 마켓팅 준비\",\n                \"먹방 유튜버, 패션 유튜버, 여행 유튜버 1명씩 각각 5명 후보자 선출\"\n            ]\n        },\n        {\n            \"subheading\" : \"작년 실적 부진 제품 리뷰\",\n            \"details\" : [\n                \"원인분석 필요\",\n                \"신제품 구매시 사은품 제공안\",\n                \"제3국 신규 마켓팅으로 소비 필요\"\n            ]\n        },\n        {\n            \"subheading\" : \"대표 보고안 작성\",\n            \"details\" : [\n                \"최근 보고 자료 참조 필요(반응이 좋았음)\",\n                \"그래픽 디자인 부서원 지원 요청 필요\",\n                \"28일 오전까지 draft 완성해서 마켓팀 팀장 보고\"\n            ]\n        }\n    ]\n}";
    }
}
