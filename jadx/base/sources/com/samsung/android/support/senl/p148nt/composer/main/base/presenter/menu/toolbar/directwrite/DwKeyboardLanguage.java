package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.DirectWriteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DwKeyboardLanguage {
    private static final String MISSING_LANGUAGE = "";
    public static final String TAG = Logger.createTag("DwKeyboardLanguage");
    private final DialogPresenterManager mDialogManager;
    private final DirectWriteManager mDirectWriteManager;
    private final InputMethodManager mInputMM;
    private final TextRecognitionLanguage mTextRecognitionLanguage;
    private final WritingToolManager mWritingToolManager;

    public DwKeyboardLanguage(Context context, WritingToolManager writingToolManager, DirectWriteManager directWriteManager, DialogPresenterManager dialogPresenterManager) {
        this.mWritingToolManager = writingToolManager;
        this.mDirectWriteManager = directWriteManager;
        this.mDialogManager = dialogPresenterManager;
        this.mInputMM = (InputMethodManager) context.getSystemService("input_method");
        this.mTextRecognitionLanguage = new TextRecognitionLanguage(context);
    }

    private String getCurrentKeyboardLanguage() {
        InputMethodSubtype currentInputMethodSubtype = this.mInputMM.getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype != null) {
            return currentInputMethodSubtype.getLanguageTag();
        }
        throw new UnsupportedOperationException("InputMethodSubtype is null");
    }

    private List<String> getLanguageListForTextRecognition() {
        this.mTextRecognitionLanguage.initTextRecognitionLanguage(false);
        return this.mTextRecognitionLanguage.getLanguageListForTextRecognition();
    }

    private String normalize(String str) {
        return str.replaceAll(DirectWriteConstant.IGNORE_CASE_IN_LANGUAGE, " ");
    }

    private String translateSupportedLanguageName(String str) {
        List<String> languageListForTextRecognition = getLanguageListForTextRecognition();
        if (!str.isEmpty() && languageListForTextRecognition != null) {
            String strNormalize = normalize(str);
            for (String str2 : languageListForTextRecognition) {
                String strNormalize2 = normalize(str2);
                if (strNormalize2.contains(strNormalize) || strNormalize.contains(strNormalize2)) {
                    return str2;
                }
            }
        }
        return "";
    }

    private void updateCurrentKeyboardLanguage() {
        String currentKeyboardLanguage;
        try {
            currentKeyboardLanguage = getCurrentKeyboardLanguage();
        } catch (UnsupportedOperationException unused) {
            currentKeyboardLanguage = "";
        }
        this.mDirectWriteManager.setKeyboardLanguage(currentKeyboardLanguage);
        updateRecognitionLanguageMatch(currentKeyboardLanguage);
    }

    private void updateLanguage(String str) {
        String strValueOf = String.valueOf(hashCode());
        String str2 = TAG;
        Logger.startTime(strValueOf, str2, "updateLanguage");
        String strTranslateSupportedLanguageName = translateSupportedLanguageName(str);
        if (strTranslateSupportedLanguageName.isEmpty()) {
            Logger.m11003i(str2, "Mismatched between stored value (" + str + ") and recognition list ");
            DirectWriteManager directWriteManager = this.mDirectWriteManager;
            strTranslateSupportedLanguageName = DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;
            directWriteManager.setDirectWriteLanguage(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE);
        }
        Logger.m11003i(str2, "current supported language is ".concat(strTranslateSupportedLanguageName));
        this.mWritingToolManager.updateSTTRecognitionLanguage(strTranslateSupportedLanguageName);
        Logger.endTime(String.valueOf(hashCode()), str2, "updateLanguage");
    }

    private void updateRecognitionLanguageMatch(String str) {
        this.mDirectWriteManager.setLanguageMatching(!translateSupportedLanguageName(str).isEmpty());
    }

    public void applyRecognitionLanguage() {
        String directWriteLanguage = this.mDirectWriteManager.getDirectWriteLanguage();
        if (directWriteLanguage.equals(DirectWriteConstant.NEED_RECOGNITION_LANGUAGE)) {
            updateCurrentKeyboardLanguage();
            directWriteLanguage = this.mDirectWriteManager.isLanguageMatched() ? translateSupportedLanguageName(this.mDirectWriteManager.getKeyboardLanguage()) : DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;
            this.mDirectWriteManager.setDirectWriteLanguage(directWriteLanguage);
            this.mDialogManager.showDirectWriteSettingDialog();
        }
        updateLanguage(directWriteLanguage);
    }
}
