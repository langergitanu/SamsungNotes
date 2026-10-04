package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ResultNoteManager {
    private static final String TAG = Logger.createTag("ResultNoteManger", AiConstants.PREFIX_TAG);
    SpenObjectTextBox mBackupOriginTextBox;
    List<SpenObjectTextBox> mBackupResultTextBoxList;
    SpenWNote mOriginNote;
    List<Integer> mResultNoteList;
    List<SpenWNote> mFormattedNoteList = new ArrayList(5);
    List<SpenWNote> mOriginalFormattedNoteList = new ArrayList(5);

    public static SpenObjectTextBox createWatermark(Context context) {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.setText(context.getString(C9086R.string.cover_ai_generated_label).replace(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "‑").replace(" ", UnicodeUtils.NBSP));
        spenObjectTextBox.setTextColor(context.getColor(C9086R.color.ai_watermark_text_watermark));
        spenObjectTextBox.appendTextSpan(new SpenBoldSpan(0, spenObjectTextBox.getText().length(), 1, true));
        return spenObjectTextBox;
    }

    public static SpannableString getWatermarkSpannableString(Context context) {
        if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(context.getString(C9086R.string.cover_ai_generated_label));
        spannableString.setSpan(new ForegroundColorSpan(context.getColor(C9086R.color.ai_watermark_text_watermark)), 0, spannableString.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static SpenWNote makeNote(Context context, SpenWNote spenWNote) {
        Exception exc;
        SpenWNote spenWNote2;
        SpenWNote spenWNote3 = null;
        if (spenWNote != null) {
            try {
                spenWNote2 = new SpenWNote(context, null, SpenWNote.PageMode.SINGLE, spenWNote.getOrientation(), spenWNote.getPageDefaultWidth(), false);
            } catch (Exception e) {
                exc = e;
            }
            try {
                initResultNote(context, spenWNote, spenWNote2);
                return spenWNote2;
            } catch (Exception e2) {
                exc = e2;
                spenWNote3 = spenWNote2;
                AbstractC8014b.m7207i("makePreview# ", exc, TAG);
                return spenWNote3;
            }
        }
        return spenWNote3;
    }

    public static void replaceStreamingResultText(SpenWNote spenWNote, SpenObjectTextBox spenObjectTextBox) {
        if (spenWNote == null) {
            Logger.m11000e(TAG, "replaceStreamingResultText# note is null");
            return;
        }
        String text = spenWNote.getBodyText().getText();
        if (text == null || text.isEmpty()) {
            spenWNote.getBodyText().copy(spenObjectTextBox);
            return;
        }
        int length = spenObjectTextBox.getText().length();
        int length2 = text.length();
        spenWNote.getBodyText().insertText(0, spenObjectTextBox, 0, length);
        spenWNote.getBodyText().removeText(length, length2);
    }

    public void clear() {
        clear(this.mOriginNote);
        this.mOriginNote = null;
        Iterator<SpenWNote> it = this.mFormattedNoteList.iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.mFormattedNoteList.clear();
    }

    public void clearResultText() {
        Iterator<SpenWNote> it = this.mFormattedNoteList.iterator();
        while (it.hasNext()) {
            it.next().getBodyText().setText(" ");
        }
    }

    public List<SpenWNote> getFormattedNoteList() {
        return this.mFormattedNoteList;
    }

    public SpenWNote getOriginNote() {
        return this.mOriginNote;
    }

    public List<SpenWNote> getOriginalFormattedNoteList() {
        return this.mOriginalFormattedNoteList;
    }

    public List<Integer> getResultNoteList() {
        return this.mResultNoteList;
    }

    public boolean hasResult() {
        if (this.mFormattedNoteList.isEmpty()) {
            return false;
        }
        for (SpenWNote spenWNote : this.mFormattedNoteList) {
            if (spenWNote.getBodyText() == null || TextUtils.isEmpty(spenWNote.getBodyText().getText())) {
                return false;
            }
        }
        return true;
    }

    public void initOriginNote(Context context, SpenWNote spenWNote, int i, int i2) {
        if (this.mOriginNote != null) {
            return;
        }
        SpenWNote spenWNoteMakeNote = makeNote(context, spenWNote);
        this.mOriginNote = spenWNoteMakeNote;
        if (spenWNoteMakeNote == null) {
            return;
        }
        int i4 = i == i2 ? 0 : 1;
        SpenObjectTextBox bodyText = spenWNoteMakeNote.getBodyText();
        String text = spenWNote.getBodyText().getText();
        int iMax = Math.max(Math.min(i2 - i4, (text == null ? 0 : text.length()) - 1), 0);
        try {
            if (text == null) {
                bodyText.setText("");
            } else {
                bodyText.copyText(spenWNote.getBodyText(), i, iMax);
            }
        } catch (Exception e) {
            AbstractC8014b.m7207i("initOriginNote# ", e, TAG);
        }
    }

    public void initResultNote(Context context, SpenWNote spenWNote) {
        if (this.mFormattedNoteList.size() != 0) {
            Iterator<SpenWNote> it = this.mFormattedNoteList.iterator();
            while (it.hasNext()) {
                it.next().getBodyText().removeAllText();
            }
        } else {
            for (int i = 0; i < 5; i++) {
                this.mFormattedNoteList.add(makeNote(context, spenWNote));
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        List<SpenObjectTextBox> list = this.mBackupResultTextBoxList;
        if (list == null) {
            this.mBackupResultTextBoxList = new ArrayList();
        } else {
            list.clear();
        }
        SpenWNote spenWNote = this.mOriginNote;
        if (spenWNote != null && spenWNote.getBodyText() == null) {
            SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
            this.mBackupOriginTextBox = newSpenObjectTextBox;
            newSpenObjectTextBox.copy(this.mOriginNote.getBodyText());
        }
        boolean zHasResult = hasResult();
        if (zHasResult) {
            for (SpenWNote spenWNote2 : this.mFormattedNoteList) {
                SpenObjectTextBox newSpenObjectTextBox2 = ObjectTextFactory.getNewSpenObjectTextBox();
                newSpenObjectTextBox2.copy(spenWNote2.getBodyText());
                this.mBackupResultTextBoxList.add(newSpenObjectTextBox2);
            }
        }
        bundle.putBoolean(TAG, zHasResult);
    }

    public void restore(Bundle bundle, Context context, SpenWNote spenWNote, Runnable runnable) {
        String str = TAG;
        if (bundle.containsKey(str)) {
            Logger.m10999d(str, "restore#");
            if (this.mBackupOriginTextBox != null) {
                SpenWNote spenWNoteMakeNote = makeNote(context, spenWNote);
                this.mOriginNote = spenWNoteMakeNote;
                if (spenWNoteMakeNote != null) {
                    spenWNoteMakeNote.getBodyText().copy(this.mBackupOriginTextBox);
                }
            }
            this.mBackupOriginTextBox = null;
            if (!bundle.getBoolean(str)) {
                runnable.run();
                return;
            }
            initResultNote(context, spenWNote);
            for (int i = 0; i < this.mBackupResultTextBoxList.size(); i++) {
                this.mFormattedNoteList.get(i).getBodyText().copy(this.mBackupResultTextBoxList.get(i));
            }
            this.mBackupResultTextBoxList.clear();
            this.mBackupResultTextBoxList = null;
        }
    }

    public void setOriginalFormattedNoteList(Context context, List<SpenWNote> list) {
        this.mOriginalFormattedNoteList.clear();
        for (int i = 0; i < 5; i++) {
            SpenWNote spenWNote = list.get(i);
            SpenWNote spenWNoteMakeNote = makeNote(context, spenWNote);
            if (spenWNoteMakeNote == null) {
                Logger.m11000e(TAG, "Failed to create original note for index: " + i);
                return;
            }
            spenWNoteMakeNote.getBodyText().copy(spenWNote.getBodyText());
            this.mOriginalFormattedNoteList.add(spenWNoteMakeNote);
        }
    }

    public void setResultNoteList(List<SpenWNote> list) {
        this.mResultNoteList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            this.mResultNoteList.add(Integer.valueOf(list.get(i).getBodyText().getText().length()));
        }
    }

    private static void initResultNote(Context context, SpenWNote spenWNote, SpenWNote spenWNote2) {
        spenWNote2.setPageDefaultHeight((int) (spenWNote2.getPageDefaultWidth() * 1.4142857f));
        spenWNote2.appendPage(spenWNote.getPageDefaultWidth(), spenWNote.getPageDefaultHeight());
        spenWNote2.setBackgroundColor(context.getResources().getColor(C9086R.color.composer_main_background, null), true);
        spenWNote2.setBodyTextFontSizeDelta(FeatureInfo.isVSTModel() ? -3 : 0);
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        SpenObjectTextBox bodyText2 = spenWNote2.getBodyText();
        bodyText2.setTextAlignment(LocaleUtils.isRTLMode() ? 1 : 0);
        bodyText2.setFontSize(bodyText.getFontSize());
        bodyText2.setTextColor(bodyText.getTextColor());
        bodyText2.setAutoFitOption(2);
    }

    private void clear(SpenWNote spenWNote) {
        if (spenWNote != null) {
            try {
                spenWNote.close(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
