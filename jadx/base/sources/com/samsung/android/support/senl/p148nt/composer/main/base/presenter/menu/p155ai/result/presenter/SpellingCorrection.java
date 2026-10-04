package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenSpellCorrectionSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.util.color.SpenReverseColorTheme;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.ChunkSizePolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObjectType;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.utils.MarkdownTableParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.SpellingCorrector;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.StringComparator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpellingCorrection implements AiMenuContract.IAiAction {
    public static final int COLOR_INSERTED_TEXT = -16776961;
    public static final int COLOR_ORIGINAL_LINE = -65536;
    private static final boolean DEBUG = false;
    private SpenObjectTextBox mBackupOriginTextBox;
    private SpenObjectTextBox mBackupResultTextBox;
    private SpenObjectTextBox mBackupViewerTextBox;
    protected final ComposerViewPresenter mComposerViewPresenter;
    private int mCountDiff;
    private boolean mIsCNStyleLanguage;
    protected LanguageIdentifier mLanguageIdentifier;
    private String mLastErrorMessage;
    private boolean mNotRevisedState;
    private boolean mNotRevisedToastFlag;
    private SpenWNote mOriginalNote;
    private ArrayList<SpenTextSpanBase> mOriginalTextSpanList;
    protected ResultListener mResultListener;
    protected SpenWNote mResultNote;
    private SpenObjectTextBox mSourceTextBox;
    protected SpellingCorrector mSpellingCorrector;
    protected SrcContentInfo mSrcContentInfo;
    protected SpenWNote mViewerNote;
    private static final String TAG = Logger.createTag("SpellingCorrection", AiConstants.PREFIX_TAG);
    public static final int COLOR_CORRECTION_LINE = Color.parseColor("#387AFF");
    public static final int COLOR_CORRECTION_TEXT = Color.parseColor("#376FDE");
    public static final int COLOR_ORIGINAL_TEXT = Color.parseColor("#D93E36");
    public static final int COLOR_REMOVED_TEXT = Color.parseColor("#A0888888");
    protected boolean mIsSupportedContinues = true;
    boolean mIsRestore = false;
    private int mSelectionMaxLength = 0;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CallbackImpl implements Operator.Callback {
        public CallbackImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            AbstractC8014b.m7196B("onFailed#", str, SpellingCorrection.TAG);
            SpellingCorrection spellingCorrection = SpellingCorrection.this;
            if (spellingCorrection.mSpellingCorrector == null) {
                Logger.m10999d(SpellingCorrection.TAG, "onFailed# is canceled");
                return true;
            }
            spellingCorrection.mSpellingCorrector = null;
            final String errorMessage = spellingCorrection.getErrorMessage(str);
            SpellingCorrection.this.mLastErrorMessage = errorMessage;
            SpellingCorrection.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.CallbackImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ResultListener resultListener = SpellingCorrection.this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onFailed(errorMessage);
                        SpellingCorrection.this.mResultListener.setCountDiff(-1);
                    }
                }
            });
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
        public void onRetry(Runnable runnable) {
            AiCommonUtil.executeRetryAction(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, final boolean z) {
            Logger.m10999d(SpellingCorrection.TAG, "onCompleted# ");
            SpellingCorrection spellingCorrection = SpellingCorrection.this;
            if (spellingCorrection.mSpellingCorrector == null) {
                Logger.m10999d(SpellingCorrection.TAG, "onSuccess# is canceled");
                return;
            }
            spellingCorrection.mSpellingCorrector = null;
            spellingCorrection.makeResult(str);
            SpellingCorrection.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.CallbackImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ResultListener resultListener = SpellingCorrection.this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onCompleted(z);
                        SpellingCorrection spellingCorrection2 = SpellingCorrection.this;
                        spellingCorrection2.mResultListener.setCountDiff(spellingCorrection2.mCountDiff);
                    }
                }
            });
            updateState();
        }

        public void updateState() {
            SrcContentInfo srcContentInfo = SpellingCorrection.this.mSrcContentInfo;
            srcContentInfo.setCompletedIndex(srcContentInfo.getCompletedIndex() + 1);
            Activity activity = SpellingCorrection.this.mComposerViewPresenter.getActivity();
            SpellingCorrection spellingCorrection = SpellingCorrection.this;
            AiViewUtils.updateOriginalTextColor(activity, spellingCorrection.mSrcContentInfo, spellingCorrection.mOriginalNote, SpellingCorrection.this.mOriginalTextSpanList);
            SpellingCorrection spellingCorrection2 = SpellingCorrection.this;
            if (spellingCorrection2.mResultNote == null || !spellingCorrection2.mSrcContentInfo.hasNextInputUnit()) {
                return;
            }
            SpellingCorrection spellingCorrection3 = SpellingCorrection.this;
            spellingCorrection3.executeInternal(spellingCorrection3.mSrcContentInfo.getNextResolvedInput(), false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class NextCallbackImpl extends CallbackImpl {
        public NextCallbackImpl() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.CallbackImpl, com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            SpellingCorrection spellingCorrection = SpellingCorrection.this;
            if (spellingCorrection.mSpellingCorrector == null) {
                Logger.m10999d(SpellingCorrection.TAG, "onSuccess# is canceled");
                return;
            }
            spellingCorrection.mSpellingCorrector = null;
            spellingCorrection.makeResult(str);
            final boolean zHasNextInputUnit = SpellingCorrection.this.mSrcContentInfo.hasNextInputUnit();
            SpellingCorrection.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.NextCallbackImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ResultListener resultListener = SpellingCorrection.this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onNextCompleted(!zHasNextInputUnit);
                        SpellingCorrection spellingCorrection2 = SpellingCorrection.this;
                        spellingCorrection2.mResultListener.setCountDiff(spellingCorrection2.mCountDiff);
                    }
                }
            });
            updateState();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onCompleted(boolean z);

        void onFailed(String str);

        void onNextCompleted(boolean z);

        void onProgressing();

        void setCountDiff(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpanInfo {
        static final String SEPARATOR = "&#&";
        static final String TYPE_ADD = "ADD";
        static final String TYPE_DELETE = "DELETE";
        String mCorrectedWords;
        String mEndWord;
        String mFrontWord;
        boolean mTypeAdd;

        private SpanInfo(String str, String str2, String str3, boolean z) {
            this.mCorrectedWords = str;
            this.mFrontWord = str2;
            this.mEndWord = str3;
            this.mTypeAdd = z;
        }

        private static SpanInfo makeSpanInfo(boolean z, String str) {
            String[] strArrSplit = str.split(SEPARATOR);
            int iIndexOf = strArrSplit[2].indexOf(strArrSplit[1]);
            if (iIndexOf != 0) {
                return new SpanInfo(strArrSplit[1], strArrSplit[2].substring(0, iIndexOf), strArrSplit[1].length() + iIndexOf < strArrSplit[2].length() ? strArrSplit[2].substring(strArrSplit[1].length() + iIndexOf) : "", z);
            }
            String str2 = strArrSplit[1];
            return new SpanInfo(str2, "", strArrSplit[2].substring(str2.length() + iIndexOf), z);
        }

        @Nullable
        public static SpanInfo parseSpanInfo(String str) {
            if (str.startsWith("ADD&#&")) {
                return makeSpanInfo(true, str);
            }
            if (str.startsWith("DELETE&#&")) {
                return makeSpanInfo(false, str);
            }
            return null;
        }

        public String getCorrectedWords() {
            return this.mCorrectedWords;
        }

        public String getEndWord() {
            return this.mEndWord;
        }

        public String getFrontWord() {
            return this.mFrontWord;
        }

        public boolean isTypeAdd() {
            return this.mTypeAdd;
        }
    }

    public SpellingCorrection(SrcContentInfo srcContentInfo, ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSrcContentInfo = srcContentInfo;
        srcContentInfo.setBGColorInverted(composerViewPresenter.getActivity(), composerViewPresenter.getComposerModel().getDoc());
        this.mLanguageIdentifier = new LanguageIdentifier();
        this.mCountDiff = 0;
    }

    private void applyDeleteDelta(SpenObjectTextBox spenObjectTextBox, StringComparator.DeltaInfo deltaInfo, String[] strArr, int i) {
        String string;
        String string2;
        int originalPosition = deltaInfo.getOriginalPosition();
        string = "";
        if (originalPosition <= 0 || originalPosition > strArr.length) {
            string2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(originalPosition > 1 ? strArr[originalPosition - 2] : "");
            sb.append(strArr[originalPosition - 1]);
            string2 = sb.toString();
            if (!string2.endsWith(" ")) {
                string2 = string2.concat(" ");
            }
        }
        int originalSize = deltaInfo.getOriginalSize() + originalPosition;
        if (originalSize < strArr.length) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr[originalSize]);
            int i2 = originalSize + 1;
            sb2.append(i2 < strArr.length ? strArr[i2] : "");
            string = sb2.toString();
        }
        int startPosition = deltaInfo.getStartPosition() + i;
        String originalWords = deltaInfo.getOriginalWords();
        int length = originalWords.length() + startPosition;
        int i4 = COLOR_CORRECTION_LINE;
        StringBuilder sbM16m = AbstractC0000a.m16m("DELETE&#&", originalWords, "&#&", string2, originalWords);
        sbM16m.append(string);
        SpenSpellCorrectionSpan spenSpellCorrectionSpan = new SpenSpellCorrectionSpan(startPosition, length, 2, i4, sbM16m.toString());
        spenSpellCorrectionSpan.setTextColor(COLOR_REMOVED_TEXT);
        spenSpellCorrectionSpan.setTextColorEnabled(true);
        spenSpellCorrectionSpan.setStrikeThroughEnabled(true);
        spenObjectTextBox.appendTextSpan(spenSpellCorrectionSpan);
    }

    private void applyInsertDelta(SpenObjectTextBox spenObjectTextBox, StringComparator.DeltaInfo deltaInfo, String[] strArr, int i) {
        String string;
        String string2;
        int originalPosition = deltaInfo.getOriginalPosition();
        string = "";
        if (originalPosition <= 0 || originalPosition > strArr.length) {
            string2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(originalPosition > 1 ? strArr[originalPosition - 2] : "");
            sb.append(strArr[originalPosition - 1]);
            string2 = sb.toString();
            if (!string2.endsWith(" ")) {
                string2 = string2.concat(" ");
            }
        }
        int originalSize = deltaInfo.getOriginalSize() + originalPosition;
        if (originalSize < strArr.length) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr[originalSize]);
            int i2 = originalSize + 1;
            sb2.append(i2 < strArr.length ? strArr[i2] : "");
            string = sb2.toString();
        }
        int startPosition = deltaInfo.getStartPosition() + i;
        String correctedWords = deltaInfo.getCorrectedWords();
        int length = correctedWords.length() + startPosition;
        int i4 = COLOR_CORRECTION_LINE;
        StringBuilder sbM16m = AbstractC0000a.m16m("ADD&#&", correctedWords, "&#&", string2, correctedWords);
        sbM16m.append(string);
        SpenSpellCorrectionSpan spenSpellCorrectionSpan = new SpenSpellCorrectionSpan(startPosition, length, 2, i4, sbM16m.toString());
        spenObjectTextBox.insertText(correctedWords, startPosition);
        spenObjectTextBox.appendTextSpan(spenSpellCorrectionSpan);
    }

    public static boolean checkLimitationAndSplit(Context context, SrcContentInfo srcContentInfo, Locale locale) {
        String selectedText = srcContentInfo.getSelectedText();
        if (isLimitedMinLength(context, selectedText)) {
            return false;
        }
        int i = AiMaxLength.LEN_SELECTED_MAX;
        if (selectedText.length() <= i) {
            return true;
        }
        Logger.m10999d(TAG, "checkLimitationAndSplit# " + locale + " : " + i);
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_reselect_maximum_characters));
        fixSelection(srcContentInfo, i);
        return false;
    }

    public static int checkMaxLimitation(Context context, @NonNull String str, Locale locale) {
        if (str.length() <= AiMaxLength.LEN_SELECTED_MAX) {
            return 0;
        }
        Logger.m10999d(TAG, "checkLimitation# over");
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_cant_correct_spelling_in_text_with_more_than));
        return AiMaxLength.LEN_SELECTED_MAX;
    }

    private void convertFontReverseColor(SpenObjectTextBox spenObjectTextBox) {
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        if (textSpan == null) {
            return;
        }
        ArrayList<SpenTextSpanBase> arrayList = new ArrayList();
        for (SpenTextSpanBase spenTextSpanBase : textSpan) {
            if (spenTextSpanBase.getType() == 1) {
                arrayList.add(spenTextSpanBase);
            }
        }
        SpenReverseColorTheme spenReverseColorTheme = new SpenReverseColorTheme(this.mComposerViewPresenter.getActivity());
        for (SpenTextSpanBase spenTextSpanBase2 : arrayList) {
            textSpan.remove(spenTextSpanBase2);
            spenObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(spenTextSpanBase2.getStart(), spenTextSpanBase2.getEnd(), spenTextSpanBase2.getExpansion(), spenReverseColorTheme.getColor(((SpenForegroundColorSpan) spenTextSpanBase2).getColor())));
        }
    }

    private void copySourceTextBox() {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        this.mSourceTextBox = newSpenObjectTextBox;
        newSpenObjectTextBox.copyText(this.mSrcContentInfo.mSrcNote.getBodyText(), this.mSrcContentInfo.mStartPos, r2.mEndPos - 1);
    }

    private void copyTextBox(SpenObjectTextBox spenObjectTextBox, Context context) {
        if (this.mSrcContentInfo.getSrcType() == 2 && SpenConfiguration.isTabletUX(context)) {
            AiViewUtils.setDefApplyFontSizeAll(null, spenObjectTextBox, this.mSrcContentInfo);
        }
        this.mResultNote.getBodyText().copy(spenObjectTextBox);
        AiViewUtils.applyDefViewerSpFontSizeAll(context, spenObjectTextBox);
        this.mViewerNote.getBodyText().copy(spenObjectTextBox);
    }

    private void fallback(SpenObjectTextBox spenObjectTextBox, String str, List<MarkdownTableParser.TableInfo> list, String str2) {
        Logger.m11000e(TAG, "fallback# " + str2);
        reviseTextBox(spenObjectTextBox, 0, spenObjectTextBox.getText().length(), MarkdownTableParser.replaceTablesWithPlaceholder(str, list));
        setSelectionMaxLength(spenObjectTextBox.getText().length());
        updateResult(spenObjectTextBox, true);
    }

    private List<SpenObjectSpan> filterSpanObjectList(List<SpenObjectSpan> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (SpenObjectSpan spenObjectSpan : list) {
            SpenObjectBase obj = spenObjectSpan.getObj();
            if (obj != null && ResolvableSpanObjectType.INSTANCE.from(obj.getType()) != ResolvableSpanObjectType.OTHER) {
                arrayList.add(spenObjectSpan);
            }
        }
        list.sort(Comparator.comparing(new C9461f(1)));
        return arrayList;
    }

    private static void fixSelection(SrcContentInfo srcContentInfo, int i) {
        if (srcContentInfo.mSrcType == 1) {
            srcContentInfo.mEndPos = srcContentInfo.mStartPos + i;
        }
        srcContentInfo.setSelectedText(TextUtil.subString(srcContentInfo.getSelectedText(), 0, i, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMaxLength(Locale locale) {
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            return 1400;
        }
        return AiMaxLength.getSpellingCorrectionMax(locale);
    }

    private Pair<Integer, Integer> getStartEndPosition() {
        List<String> inputList = this.mSrcContentInfo.getInputList();
        String str = inputList.get(this.mSrcContentInfo.getInputIndex() - 1);
        int length = 0;
        for (int i = 0; i < this.mSrcContentInfo.getInputIndex() - 1; i++) {
            length += inputList.get(i).length();
        }
        return new Pair<>(Integer.valueOf(CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? 0 : length), Integer.valueOf(str.length() + length));
    }

    private static boolean isLimitedCNMaxLength(Context context, @NonNull String str) {
        if (str.length() <= 1400) {
            return false;
        }
        AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_cant_correct_spelling_in_text_with_more_than));
        return true;
    }

    public static boolean isLimitedMinLength(Context context, @NonNull String str) {
        if (str.trim().length() >= 1) {
            return false;
        }
        AiCommonUtil.showCustomToast(context, context.getString(C9086R.string.ai_error_can_not_find_any_text));
        return true;
    }

    public static boolean isOriginal(SpenSpellCorrectionSpan spenSpellCorrectionSpan) {
        return spenSpellCorrectionSpan.getUnderlineColor() == -65536;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$makeResult$0(SpenObjectSpan spenObjectSpan) {
        return Integer.valueOf(spenObjectSpan.getTextIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeNotResolvedObjectCharacters$1(List list, Integer num) {
        return !list.contains(num);
    }

    private void removeNotResolvedObjectCharacters(SpenObjectTextBox spenObjectTextBox, final List<Integer> list) {
        String text = spenObjectTextBox.getText();
        if (text == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int iIndexOf = text.indexOf(65532); iIndexOf >= 0; iIndexOf = text.indexOf(65532, AbstractC1038a.m1200a(iIndexOf, iIndexOf, 1, arrayList))) {
        }
        Iterator it = ((List) arrayList.stream().filter(new Predicate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpellingCorrection.lambda$removeNotResolvedObjectCharacters$1(list, (Integer) obj);
            }
        }).collect(Collectors.toList())).iterator();
        while (it.hasNext()) {
            spenObjectTextBox.replaceText(" ", ((Integer) it.next()).intValue(), 1);
        }
    }

    private void removeSpellCorrectionSpan(SpenObjectTextBox spenObjectTextBox) {
        SpanInfo spanInfo;
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = spenObjectTextBox.findTextSpan(0, spenObjectTextBox.getText().length(), 4194304);
        if (arrayListFindTextSpan == null) {
            return;
        }
        Collections.sort(arrayListFindTextSpan, new Comparator<SpenTextSpanBase>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.2
            @Override // java.util.Comparator
            public int compare(SpenTextSpanBase spenTextSpanBase, SpenTextSpanBase spenTextSpanBase2) {
                return spenTextSpanBase.getStart() - spenTextSpanBase2.getStart();
            }
        });
        for (int size = arrayListFindTextSpan.size() - 1; size >= 0; size--) {
            SpenTextSpanBase spenTextSpanBase = arrayListFindTextSpan.get(size);
            if (spenTextSpanBase instanceof SpenSpellCorrectionSpan) {
                SpenSpellCorrectionSpan spenSpellCorrectionSpan = (SpenSpellCorrectionSpan) spenTextSpanBase;
                if (spenSpellCorrectionSpan.getIsTextColorEnabled() && (spanInfo = SpanInfo.parseSpanInfo(spenSpellCorrectionSpan.getOriginalText())) != null) {
                    boolean zIsOriginal = isOriginal(spenSpellCorrectionSpan);
                    if (spanInfo.isTypeAdd()) {
                        if (zIsOriginal) {
                            spenObjectTextBox.removeText(spenSpellCorrectionSpan.getStart(), spenSpellCorrectionSpan.getEnd() - spenSpellCorrectionSpan.getStart());
                        }
                    } else if (!zIsOriginal) {
                        spenObjectTextBox.removeText(spenSpellCorrectionSpan.getStart(), spenSpellCorrectionSpan.getEnd() - spenSpellCorrectionSpan.getStart());
                    }
                }
            }
        }
        spenObjectTextBox.removeTextSpan(4194304);
    }

    private void revise(StringComparator.DiffBase diffBase, SpenObjectTextBox spenObjectTextBox, int i, int i2) {
        int length = spenObjectTextBox.getText().length();
        if (length < i2 || i < 0) {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(length, i2, "revise# wrong index. len=", ", endPos=", ", startPos=");
            sbM1173s.append(i);
            Logger.m11000e(str, sbM1173s.toString());
            return;
        }
        for (int size = diffBase.getSize() - 1; size >= 0; size--) {
            StringComparator.DeltaInfo deltaInfoAt = diffBase.getDeltaInfoAt(size);
            int startPosition = deltaInfoAt.getStartPosition() + i;
            String originalWords = deltaInfoAt.getOriginalWords();
            String correctedWords = deltaInfoAt.getCorrectedWords();
            if (deltaInfoAt.isChange()) {
                String str2 = TAG;
                StringBuilder sbM1173s2 = AbstractC0622a.m1173s(length, startPosition, "makeResult# change: ", " ", " ");
                sbM1173s2.append(originalWords.length());
                Logger.m10999d(str2, sbM1173s2.toString());
                int length2 = originalWords.length() - 1;
                if (length < startPosition + length2) {
                    length2 = (length - startPosition) - 1;
                    Logger.m11004w(str2, "makeResult# change: fix replace Size " + length2);
                }
                int i4 = startPosition + 1;
                spenObjectTextBox.removeText(i4, length2);
                spenObjectTextBox.insertText(correctedWords, i4);
                spenObjectTextBox.removeText(startPosition, 1);
                spenObjectTextBox.appendTextSpan(new SpenSpellCorrectionSpan(startPosition, correctedWords.length() + startPosition, 2, COLOR_CORRECTION_LINE, originalWords));
            } else if (deltaInfoAt.isDelete()) {
                String str3 = TAG;
                StringBuilder sbM1173s3 = AbstractC0622a.m1173s(length, startPosition, "makeResult# remove: ", " ", " ");
                sbM1173s3.append(originalWords.length());
                Logger.m10999d(str3, sbM1173s3.toString());
                applyDeleteDelta(spenObjectTextBox, deltaInfoAt, diffBase.getOriginalWords(), i);
            } else if (deltaInfoAt.isInsert()) {
                String str4 = TAG;
                StringBuilder sbM1173s4 = AbstractC0622a.m1173s(length, startPosition, "makeResult# insert: ", " ", " ");
                sbM1173s4.append(originalWords.length());
                Logger.m10999d(str4, sbM1173s4.toString());
                applyInsertDelta(spenObjectTextBox, deltaInfoAt, diffBase.getOriginalWords(), i);
            }
        }
    }

    private void reviseTextBox(SpenObjectTextBox spenObjectTextBox, int i, int i2, String str) {
        String text = spenObjectTextBox.getText();
        if (text == null || text.length() < i2) {
            return;
        }
        String strSubstring = text.substring(i, i2);
        if (strSubstring.isEmpty() || str.isEmpty()) {
            return;
        }
        StringComparator.DiffBase diff = StringComparator.getDiff(strSubstring, str, this.mIsCNStyleLanguage);
        if (diff.isEmpty()) {
            return;
        }
        this.mCountDiff = diff.getSize() + this.mCountDiff;
        revise(diff, spenObjectTextBox, i, i2);
        setNotRevisedState(this.mNotRevisedToastFlag && !diff.hasEffectiveDiff());
    }

    private void setNotRevisedState(boolean z) {
        this.mNotRevisedState = z;
        this.mNotRevisedToastFlag = z;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void addTo(ResultOperation.AddTo addTo) {
        ResultOperation resultOperation = new ResultOperation();
        SpenObjectTextBox bodyText = this.mResultNote.getBodyText();
        removeSpellCorrectionSpan(bodyText);
        if (ResultOperation.AddTo.EndOfNote == addTo) {
            if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
                resultOperation.insertToBottom(this.mComposerViewPresenter, this.mSrcContentInfo, bodyText);
                return;
            } else {
                resultOperation.insertNewPageEndOfNote(this.mComposerViewPresenter, this.mSrcContentInfo, bodyText);
                return;
            }
        }
        if (ResultOperation.AddTo.NewPageBefore == addTo) {
            resultOperation.insertInNewPageFront(this.mComposerViewPresenter, this.mSrcContentInfo, bodyText);
        } else if (ResultOperation.AddTo.NewNote == addTo) {
            if (this.mSrcContentInfo.mIsBGColorInverted) {
                convertFontReverseColor(bodyText);
            }
            resultOperation.addToNewNote(this.mComposerViewPresenter, bodyText);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public boolean canDoAction() {
        SpenObjectTextBox bodyText;
        SpenWNote spenWNote = this.mViewerNote;
        return (spenWNote == null || (bodyText = spenWNote.getBodyText()) == null || bodyText.getText().length() <= 0) ? false : true;
    }

    public void cancel() {
        LanguageIdentifier languageIdentifier = this.mLanguageIdentifier;
        if (languageIdentifier != null) {
            languageIdentifier.release();
        }
        SpellingCorrector spellingCorrector = this.mSpellingCorrector;
        if (spellingCorrector != null) {
            spellingCorrector.registerCallback(null);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mSpellingCorrector = null;
    }

    public void clear() {
        cancel();
        SpenWNote spenWNote = this.mViewerNote;
        if (spenWNote != null) {
            try {
                spenWNote.close(true);
            } catch (IOException e) {
                AbstractC8014b.m7204f(e, new StringBuilder("clear# result note "), TAG);
            }
            this.mViewerNote = null;
        }
        SpenWNote spenWNote2 = this.mResultNote;
        if (spenWNote2 != null) {
            try {
                spenWNote2.close(true);
            } catch (IOException e2) {
                AbstractC8014b.m7204f(e2, new StringBuilder("clear# result note "), TAG);
            }
            this.mResultNote = null;
        }
        SpenWNote spenWNote3 = this.mOriginalNote;
        if (spenWNote3 != null) {
            try {
                spenWNote3.close(true);
            } catch (IOException e3) {
                AbstractC8014b.m7204f(e3, new StringBuilder("clear# original note "), TAG);
            }
            this.mOriginalNote = null;
        }
        this.mSpellingCorrector = null;
        this.mResultListener = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void copy() {
        new ResultOperation().copy(this.mComposerViewPresenter, getResultToCopy());
    }

    public void execute() {
        execute(true);
    }

    public void executeInternal(String str, boolean z) {
        SpellingCorrector spellingCorrector = new SpellingCorrector(str);
        this.mSpellingCorrector = spellingCorrector;
        spellingCorrector.registerCallback(z ? new CallbackImpl() : new NextCallbackImpl());
        this.mSpellingCorrector.execute();
        if (z) {
            return;
        }
        this.mResultListener.onProgressing();
    }

    public int getCountDiff() {
        return this.mCountDiff;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public String getDetailSAAiType() {
        return "d";
    }

    public String getErrorMessage(String str) {
        return str.isEmpty() ? "unexpected error" : "SAFE_FILTER_ERROR_CHILD".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_child_spelling_correction) : "SAFE_FILTER_ERROR_RECITATION".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_recitation_spelling_correction) : "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.f6720x2fe9272c) : "SAFE_FILTER_ERROR_CHN_SENSITIVE".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_msg_safety_filter_chn_sensitive_spelling_correction) : "SAFE_FILTER_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.f6719x6351c636) : "NETWORK_ERROR".equals(str) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_network_connection_error_msg) : ("INTERNAL_SERVER_ERROR".equals(str) || "UNEXPECTED_ERROR".equals(str)) ? this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_something_went_wrong) : str;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public String getLastErrorMessage() {
        return this.mLastErrorMessage;
    }

    public SpenWNote getOriginalNote() {
        return this.mOriginalNote;
    }

    public SpenWNote getResultNote() {
        return this.mResultNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SpenObjectTextBox getResultToCopy() {
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(this.mResultNote.getBodyText());
        removeSpellCorrectionSpan(newSpenObjectTextBox);
        if (this.mSrcContentInfo.mIsBGColorInverted) {
            convertFontReverseColor(newSpenObjectTextBox);
        }
        return newSpenObjectTextBox;
    }

    public int getSelectionMaxLength() {
        return this.mSelectionMaxLength;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public SrcContentInfo getSrcContentInfo() {
        return this.mSrcContentInfo;
    }

    public SpenWNote getViewerNote() {
        return this.mViewerNote;
    }

    public boolean hasNext() {
        return this.mSrcContentInfo.hasNextInputUnit();
    }

    public boolean hasResult() {
        SpenWNote spenWNote;
        return (this.mViewerNote == null || (spenWNote = this.mResultNote) == null || spenWNote.getBodyText() == null || TextUtils.isEmpty(this.mResultNote.getBodyText().getText())) ? false : true;
    }

    public boolean isNotRevised() {
        return this.mNotRevisedState;
    }

    public boolean isRestore() {
        return this.mIsRestore;
    }

    public boolean isWorking() {
        return this.mSpellingCorrector != null;
    }

    public void makeOriginNote() {
        if (this.mOriginalNote != null) {
            Logger.m10999d(TAG, "makeOriginNote# already created");
            return;
        }
        SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.mSrcNote);
        this.mOriginalNote = spenWNoteMakeNote;
        if (spenWNoteMakeNote == null) {
            Logger.m11000e(TAG, "makeOriginNote# mOriginalNote is null");
            return;
        }
        this.mOriginalNote.getBodyText().copyText(this.mSrcContentInfo.mSrcNote.getBodyText(), this.mSrcContentInfo.mStartPos, Math.min(this.mSrcContentInfo.mEndPos - 1, r0.getText().length() - 1));
        AiViewUtils.setResultTextBoxState(this.mOriginalNote.getBodyText());
        AiViewUtils.applyDefViewerSpFontSizeAll(this.mComposerViewPresenter.getActivity(), this.mOriginalNote.getBodyText());
        this.mOriginalTextSpanList = this.mOriginalNote.getBodyText().getTextSpan();
    }

    public void makeResult(String str) {
        Pair<Integer, Integer> startEndPosition = getStartEndPosition();
        int iIntValue = ((Integer) startEndPosition.first).intValue();
        int iIntValue2 = ((Integer) startEndPosition.second).intValue();
        SpenObjectTextBox newBodyText = this.mComposerViewPresenter.getObjectManager().getNewBodyText();
        boolean z = true;
        newBodyText.copyText(this.mSourceTextBox, iIntValue, iIntValue2 - 1);
        AiViewUtils.setResultTextBoxState(newBodyText);
        List<SpenObjectSpan> listFilterSpanObjectList = filterSpanObjectList(newBodyText.findObjectSpan(0, newBodyText.getText().length()));
        List<MarkdownTableParser.TableInfo> listExtractTables = MarkdownTableParser.extractTables(str);
        if (listFilterSpanObjectList.size() != listExtractTables.size()) {
            fallback(newBodyText, str, listExtractTables, "the number of tables not match - " + listFilterSpanObjectList.size() + SQLKeyword.COMMA + listExtractTables.size());
            return;
        }
        int size = listFilterSpanObjectList.size();
        for (int i = 0; i < size; i++) {
            SpenObjectTable spenObjectTable = (SpenObjectTable) listFilterSpanObjectList.get(i).getObj();
            MarkdownTableParser.TableInfo tableInfo = listExtractTables.get(i);
            if (spenObjectTable.getRowsCount() != tableInfo.getRowCount() || spenObjectTable.getColumnsCount() != tableInfo.getColumnCount()) {
                fallback(newBodyText, str, listExtractTables, "table shape not match - " + spenObjectTable.getRowsCount() + SQLKeyword.COMMA + spenObjectTable.getColumnsCount() + " / " + tableInfo.getRowCount() + SQLKeyword.COMMA + tableInfo.getColumnCount());
                return;
            }
            for (int i2 = 0; i2 < spenObjectTable.getRowsCount(); i2++) {
                int i4 = 0;
                while (i4 < spenObjectTable.getColumnsCount()) {
                    SpenObjectTextBox contentObject = spenObjectTable.getContentObject(i2, i4);
                    String text = contentObject.getText();
                    if (text == null || text.trim().isEmpty()) {
                        text = " ";
                    }
                    boolean z2 = z;
                    String str2 = tableInfo.getCells().get(i2).get(i4);
                    if (str2 == null || str2.trim().isEmpty()) {
                        str2 = " ";
                    }
                    reviseTextBox(contentObject, 0, text.length(), str2);
                    spenObjectTable.setContentText(contentObject, i2, i4);
                    i4++;
                    z = z2;
                }
            }
        }
        boolean z3 = z;
        removeNotResolvedObjectCharacters(newBodyText, (List) listFilterSpanObjectList.stream().map(new C9461f(2)).collect(Collectors.toList()));
        int length = newBodyText.getText().length();
        int length2 = str.length();
        int i5 = size - 1;
        while (i5 >= 0) {
            SpenObjectSpan spenObjectSpan = listFilterSpanObjectList.get(i5);
            MarkdownTableParser.TableInfo tableInfo2 = listExtractTables.get(i5);
            int textIndex = spenObjectSpan.getTextIndex();
            reviseTextBox(newBodyText, textIndex + 1, length, str.substring(tableInfo2.getEnd(), length2));
            length2 = tableInfo2.getStart();
            i5--;
            length = textIndex;
        }
        int length3 = newBodyText.getText().length();
        reviseTextBox(newBodyText, 0, length, str.substring(0, length2));
        setSelectionMaxLength(length3);
        updateResult(newBodyText, z3);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (!TextUtils.isEmpty(this.mLastErrorMessage)) {
            Logger.m10999d(TAG, "onSaveInstanceState# failed state");
            return;
        }
        boolean zHasResult = hasResult();
        if (zHasResult) {
            Logger.m10999d(TAG, "onSaveInstanceState# completed");
            SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
            this.mBackupViewerTextBox = newSpenObjectTextBox;
            newSpenObjectTextBox.copy(this.mViewerNote.getBodyText());
            SpenObjectTextBox newSpenObjectTextBox2 = ObjectTextFactory.getNewSpenObjectTextBox();
            this.mBackupResultTextBox = newSpenObjectTextBox2;
            newSpenObjectTextBox2.copy(this.mResultNote.getBodyText());
        }
        bundle.putBoolean(TAG, zHasResult);
        if (this.mOriginalNote != null) {
            SpenObjectTextBox newSpenObjectTextBox3 = ObjectTextFactory.getNewSpenObjectTextBox();
            this.mBackupOriginTextBox = newSpenObjectTextBox3;
            newSpenObjectTextBox3.copy(this.mOriginalNote.getBodyText());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void overwrite() {
        ResultOperation resultOperation = new ResultOperation();
        removeSpellCorrectionSpan(this.mResultNote.getBodyText());
        this.mSrcContentInfo.setOverwriteNextLineFlag(false);
        resultOperation.setShouldRemoveTableOnOverwrite(true);
        resultOperation.overwrite(this.mComposerViewPresenter, this.mResultNote.getBodyText(), this.mSrcContentInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiAction
    public void restoreState(Bundle bundle, SrcContentInfo srcContentInfo) {
        String str = TAG;
        if (!bundle.containsKey(str)) {
            Logger.m10999d(str, "restoreState# no data");
            return;
        }
        Logger.m10999d(str, "restore#");
        this.mIsRestore = true;
        this.mSrcContentInfo = srcContentInfo;
        if (this.mBackupOriginTextBox != null) {
            SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.mSrcNote);
            this.mOriginalNote = spenWNoteMakeNote;
            if (spenWNoteMakeNote == null) {
                Logger.m10999d(str, "restore# fail make original note");
                return;
            } else {
                spenWNoteMakeNote.getBodyText().copy(this.mBackupOriginTextBox);
                this.mBackupOriginTextBox = null;
            }
        }
        if (!bundle.getBoolean(str)) {
            execute(false);
            return;
        }
        SpenWNote spenWNoteMakeNote2 = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.mSrcNote);
        this.mViewerNote = spenWNoteMakeNote2;
        if (spenWNoteMakeNote2 != null) {
            spenWNoteMakeNote2.getBodyText().copy(this.mBackupViewerTextBox);
        }
        SpenWNote spenWNoteMakeNote3 = ResultNoteManager.makeNote(this.mComposerViewPresenter.getActivity(), this.mSrcContentInfo.mSrcNote);
        this.mResultNote = spenWNoteMakeNote3;
        if (spenWNoteMakeNote3 != null) {
            spenWNoteMakeNote3.getBodyText().copy(this.mBackupResultTextBox);
        }
        this.mBackupOriginTextBox = null;
        this.mBackupResultTextBox = null;
    }

    public void setResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void setSelectionMaxLength(int i) {
        this.mSelectionMaxLength = i;
    }

    public void showNoRevisedToast(Context context) {
        if (this.mNotRevisedToastFlag) {
            ToastHandler.show(context, C9086R.string.ai_speling_correciton_no_revised, 0);
            this.mNotRevisedToastFlag = false;
        }
    }

    public void updateAddDelete(SpenObjectShape spenObjectShape, SpenSpellCorrectionSpan spenSpellCorrectionSpan, boolean z, boolean z2, int i) {
        spenSpellCorrectionSpan.setUnderlineColor(z ? COLOR_CORRECTION_LINE : -65536);
        if (z2) {
            spenSpellCorrectionSpan.setTextColor(COLOR_REMOVED_TEXT);
            spenSpellCorrectionSpan.setStrikeThroughEnabled(true);
            spenSpellCorrectionSpan.setTextColorEnabled(true);
        } else {
            spenSpellCorrectionSpan.setTextColor(i);
            spenSpellCorrectionSpan.setStrikeThroughEnabled(false);
            spenSpellCorrectionSpan.setTextColorEnabled(false);
        }
        spenObjectShape.appendTextSpan(spenSpellCorrectionSpan);
        SpenSpellCorrectionSpan spenSpellCorrectionSpan2 = new SpenSpellCorrectionSpan(spenSpellCorrectionSpan.getStart(), spenSpellCorrectionSpan.getEnd(), spenSpellCorrectionSpan.getExpansion(), spenSpellCorrectionSpan.getUnderlineColor(), spenSpellCorrectionSpan.getOriginalText());
        spenSpellCorrectionSpan2.setTextColorEnabled(spenSpellCorrectionSpan.getIsTextColorEnabled());
        spenSpellCorrectionSpan2.setStrikeThroughEnabled(spenSpellCorrectionSpan.getIsStrikeThroughEnabled());
        this.mResultNote.getBodyText().appendTextSpan(spenSpellCorrectionSpan2);
    }

    public void updateChange(SpenObjectShape spenObjectShape, SpenSpellCorrectionSpan spenSpellCorrectionSpan, boolean z) {
        String strSubstring = spenObjectShape.getText().substring(spenSpellCorrectionSpan.getStart(), spenSpellCorrectionSpan.getEnd());
        String originalText = spenSpellCorrectionSpan.getOriginalText();
        spenObjectShape.replaceText(originalText, spenSpellCorrectionSpan.getStart(), spenSpellCorrectionSpan.getEnd() - spenSpellCorrectionSpan.getStart());
        this.mResultNote.getBodyText().replaceText(originalText, spenSpellCorrectionSpan.getStart(), spenSpellCorrectionSpan.getEnd() - spenSpellCorrectionSpan.getStart());
        spenSpellCorrectionSpan.setPosition(spenSpellCorrectionSpan.getStart(), originalText.length() + spenSpellCorrectionSpan.getStart());
        spenSpellCorrectionSpan.setUnderlineColor(z ? COLOR_CORRECTION_LINE : -65536);
        spenSpellCorrectionSpan.setOriginalText(strSubstring);
        spenObjectShape.appendTextSpan(spenSpellCorrectionSpan);
    }

    public void updateResult(SpenObjectTextBox spenObjectTextBox, boolean z) {
        Activity activity = this.mComposerViewPresenter.getActivity();
        if (this.mViewerNote == null || this.mResultNote == null) {
            this.mViewerNote = ResultNoteManager.makeNote(activity, this.mSrcContentInfo.mSrcNote);
            SpenWNote spenWNoteMakeNote = ResultNoteManager.makeNote(activity, this.mSrcContentInfo.mSrcNote);
            this.mResultNote = spenWNoteMakeNote;
            if (this.mViewerNote == null || spenWNoteMakeNote == null) {
                Logger.m11000e(TAG, "makeResult# fail to make note");
                return;
            } else {
                copyTextBox(spenObjectTextBox, activity);
                return;
            }
        }
        if (!this.mIsSupportedContinues || !z) {
            copyTextBox(spenObjectTextBox, activity);
            return;
        }
        if (this.mSrcContentInfo.getSrcType() == 2 && SpenConfiguration.isTabletUX(activity)) {
            AiViewUtils.setDefApplyFontSizeAll(null, spenObjectTextBox, this.mSrcContentInfo);
        }
        this.mResultNote.getBodyText().insertText(this.mResultNote.getBodyText().getText().length(), spenObjectTextBox, 0, spenObjectTextBox.getText().length());
        AiViewUtils.applyDefViewerSpFontSizeAll(activity, spenObjectTextBox);
        this.mViewerNote.getBodyText().insertText(this.mViewerNote.getBodyText().getText().length(), spenObjectTextBox, 0, spenObjectTextBox.getText().length());
    }

    private void execute(boolean z) {
        Logger.m10999d(TAG, "execute# " + this.mSrcContentInfo.getSelectedText().length());
        this.mLastErrorMessage = null;
        this.mIsCNStyleLanguage = false;
        this.mSrcContentInfo.resetInputIndex();
        this.mLanguageIdentifier.identifyLanguage(this.mSrcContentInfo.getSelectedText(), new LanguageIdentifier.AsyncCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
            public void onCompleted(Locale locale) {
                Logger.m10999d(SpellingCorrection.TAG, "execute# " + locale);
                if (locale != null && locale.getLanguage().equals(Locale.CHINA.getLanguage())) {
                    SpellingCorrection.this.mIsCNStyleLanguage = true;
                }
                SpellingCorrection.this.mSrcContentInfo.chunk(ChunkSizePolicy.builder().unitMinLength(1).unitMaxLength(SpellingCorrection.getMaxLength(locale)).extraLength(500).build());
                SpellingCorrection spellingCorrection = SpellingCorrection.this;
                spellingCorrection.executeInternal(spellingCorrection.mSrcContentInfo.getNextResolvedInput(), true);
            }
        });
        setNotRevisedState(true);
        if (z) {
            copySourceTextBox();
        }
    }
}
