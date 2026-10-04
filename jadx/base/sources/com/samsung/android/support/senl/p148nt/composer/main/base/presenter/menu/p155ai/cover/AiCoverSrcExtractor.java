package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover;

import android.content.Context;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfSearch;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.assist.llm.preprocessor.LinePreProcessor;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.facade.RecognitionFacade;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiCoverSrcExtractor {
    private static final int HW_RECOGNIZED_MAX_PAGE_COUNT = 2;
    private static final int PDF_MAX_PAGE_COUNT = 100;
    private static final String TAG = Logger.createTag("AiCoverSrcExtractor");
    private final LinePreProcessor mLinePreProcessor = new LinePreProcessor();

    private String extractHwText(Context context, String str) {
        Logger.m10999d(TAG, "extractHwText# start");
        StringBuilder sb = new StringBuilder();
        for (TextInfo textInfo : new RecognitionFacade().recognizeWord(context, str, 2, new CancellationSignal())) {
            sb.append(TextUtils.isEmpty(textInfo.str) ? "" : textInfo.str);
            sb.append(" ");
        }
        Logger.m10999d(TAG, "extractHwText# end " + sb.length());
        return sb.substring(0, Math.min(sb.length(), 500));
    }

    @NonNull
    private String extractTextFromBodyText(SpenWNote spenWNote) {
        SpenObjectTextBox bodyText;
        String text;
        if (spenWNote == null || (bodyText = spenWNote.getBodyText()) == null || (text = bodyText.getText()) == null) {
            return "";
        }
        String strLinePreProcessor = linePreProcessor(text.replaceAll(String.valueOf(Constants.OBJECT_REPLACEMENT_CHARACTER), " "));
        if (TextUtils.isEmpty(strLinePreProcessor)) {
            return "";
        }
        int length = strLinePreProcessor.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = strLinePreProcessor.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        while (length > iCharCount) {
            int iCodePointBefore = Character.codePointBefore(strLinePreProcessor, length);
            if (!Character.isWhitespace(iCodePointBefore)) {
                break;
            }
            length -= Character.charCount(iCodePointBefore);
        }
        String strSubstring = strLinePreProcessor.substring(iCharCount, length);
        return strSubstring.substring(0, Math.min(strSubstring.length(), 500));
    }

    private String extractTextFromPDF(SpenWNote spenWNote) {
        if (spenWNote == null) {
            return "";
        }
        SpenNotePdfSearch spenNotePdfSearch = new SpenNotePdfSearch();
        spenNotePdfSearch.setDocument(spenWNote);
        int iMin = Math.min(spenWNote.getPageCount(), 100);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iMin; i++) {
            String pageText = spenNotePdfSearch.getPageText(spenWNote.getPage(i));
            if (TextUtils.isEmpty(pageText)) {
                pageText = "";
            }
            sb.append(linePreProcessor(pageText.replaceAll(String.valueOf(Constants.OBJECT_REPLACEMENT_CHARACTER), " ")));
            if (sb.length() >= 500) {
                break;
            }
        }
        spenNotePdfSearch.close();
        return sb.substring(0, Math.min(sb.length(), 500));
    }

    private String linePreProcessor(String str) {
        return this.mLinePreProcessor.removeRepeatedEmptyLine(str);
    }

    private String returnWithSALogging(String str) {
        int length = str.length();
        if (length < 100) {
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "a");
            return str;
        }
        if (length > 100 && length <= 200) {
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "b");
            return str;
        }
        if (length > 200 && length <= 300) {
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "c");
            return str;
        }
        if (length > 300 && length <= 400) {
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "d");
            return str;
        }
        if (length > 400 && length <= 500) {
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "e");
            return str;
        }
        if (length <= 500 || length > 1000) {
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "g");
            return str;
        }
        ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, "8355", "f");
        return str;
    }

    @NonNull
    public String extractText(Context context, SpenWNote spenWNote, String str) {
        String strExtractTextFromBodyText = extractTextFromBodyText(spenWNote);
        if (!TextUtils.isEmpty(strExtractTextFromBodyText) && strExtractTextFromBodyText.length() >= 100) {
            return returnWithSALogging(strExtractTextFromBodyText);
        }
        String strExtractTextFromPDF = extractTextFromPDF(spenWNote);
        if (!TextUtils.isEmpty(strExtractTextFromPDF) && strExtractTextFromPDF.length() >= 100) {
            return returnWithSALogging(strExtractTextFromPDF);
        }
        String strExtractHwText = extractHwText(context, str);
        return (TextUtils.isEmpty(strExtractHwText) || strExtractHwText.length() < 100) ? (strExtractTextFromBodyText.length() < strExtractTextFromPDF.length() || strExtractTextFromBodyText.length() < strExtractHwText.length()) ? strExtractTextFromPDF.length() >= strExtractHwText.length() ? returnWithSALogging(strExtractTextFromPDF) : returnWithSALogging(strExtractHwText) : returnWithSALogging(strExtractTextFromBodyText) : returnWithSALogging(strExtractHwText);
    }
}
