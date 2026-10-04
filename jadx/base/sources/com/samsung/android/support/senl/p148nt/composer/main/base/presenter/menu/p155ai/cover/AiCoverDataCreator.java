package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCoverSticker;
import com.samsung.android.support.senl.p148nt.model.assist.llm.CoverMaker;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiCoverDataCreator {
    private static final String CLASSIFICATION = "\"classification\"";
    private static final String INVALID_ACCOUNT = "INVALID_ACCOUNT";
    public static final String INVALID_RESULT = "INVALID_RESULT";
    private static final String SUMMARY = "\"summary\"";
    private static final String TAG = Logger.createTag("AiCoverDataCreator");
    private static final String TITLE = "\"title\"";
    private static final String UNKNOWN_LANGUAGE = "Unknown";
    public static final String USER_CANCEL = "USER_CANCEL_ERROR";
    private Callback mCallback;
    private CoverMaker mCoverMaker;
    private ResultData mCoverResult;
    private String mSrc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        @WorkerThread
        void onCompleted(String str, String str2, String str3);

        @WorkerThread
        void onFailed(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProcessCallback extends Callback {
        @MainThread
        void onStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultData {
        String mData;
        String mTitle = "";
        String mSummary = "";
        String mCategory = "";
        String mErrMsg = "";

        public ResultData(String str) {
            this.mData = str;
        }

        public void setErrMsg(String str) {
            this.mErrMsg = str;
        }
    }

    private boolean canExtractCoverData(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 100) {
            return true;
        }
        Logger.m10999d(TAG, "canExtractCoverData# fail");
        this.mCallback.onCompleted("", str, CoverStickerConstants.Category.NONE.UUID);
        this.mCallback = null;
        return false;
    }

    private void clear() {
        CoverMaker coverMaker = this.mCoverMaker;
        if (coverMaker != null) {
            coverMaker.registerCallback(null);
        }
        this.mCoverResult = null;
    }

    private void extractCoverData(String str) {
        CoverMaker coverMaker = new CoverMaker(str);
        this.mCoverMaker = coverMaker;
        coverMaker.registerCallback(new Operator.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.1
            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(@NonNull String str2) {
                AbstractC8014b.m7196B("extractCoverData#onFailed# ", str2, AiCoverDataCreator.TAG);
                AiCoverDataCreator.this.mCoverResult = new ResultData("");
                AiCoverDataCreator.this.mCoverResult.setErrMsg(str2);
                AiCoverDataCreator.this.updateResult();
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
            public void onRetry(Runnable runnable) {
                AiCommonUtil.executeRetryAction(runnable);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(@NonNull String str2, boolean z) {
                AbstractC8014b.m7220v("extractCoverData#onCompleted# ", AiCoverDataCreator.TAG, z);
                AiCoverDataCreator.this.mCoverResult = new ResultData(str2);
                AiCoverDataCreator.this.updateResult();
            }
        });
        boolean zExecute = this.mCoverMaker.execute();
        if (!zExecute) {
            ResultData resultData = new ResultData("");
            this.mCoverResult = resultData;
            resultData.setErrMsg("UNEXPECTED_ERROR");
            updateResult();
        }
        AbstractC8014b.m7220v("extractCoverData# execute start : ", TAG, zExecute);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getErrorMessage(String str) {
        String str2;
        String string;
        if (str.isEmpty()) {
            string = "unexpected error";
        } else if ("SAFE_FILTER_ERROR_CHILD".equals(str)) {
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_msg_safety_filter_cover);
        } else if ("SAFE_FILTER_ERROR_RECITATION".equals(str)) {
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_msg_safety_filter_recitation_cover);
        } else if ("SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE".equals(str)) {
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_msg_safety_filter_unsupported_language_cover);
        } else if ("SAFE_FILTER_ERROR_CHN_SENSITIVE".equals(str)) {
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_msg_safety_filter_chn_sensitive_cover);
        } else if ("SAFE_FILTER_ERROR".equals(str)) {
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_ai_error_msg_safety_filter_in_other_cases_cover);
        } else if ("NETWORK_ERROR".equals(str)) {
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_network_connection_error_msg);
        } else {
            if (!INVALID_RESULT.equals(str)) {
                if (SCSTools.getAppInfoErrMsg().equals(str)) {
                    str2 = INVALID_ACCOUNT;
                } else if ("UNEXPECTED_ERROR".equals(str)) {
                    string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_something_went_wrong);
                } else {
                    str2 = str;
                }
                AbstractC8014b.m7196B("getErrorMessage# ", str, TAG);
                return needToastForUser(str2) ? "" : str;
            }
            string = BaseUtils.getApplicationContext().getString(C9086R.string.ai_error_ai_error_msg_safety_filter_in_other_cases_cover);
        }
        String str3 = string;
        str2 = str;
        str = str3;
        AbstractC8014b.m7196B("getErrorMessage# ", str, TAG);
        if (needToastForUser(str2)) {
        }
    }

    public static boolean isSafetyFilterError(String str) {
        str.getClass();
        switch (str) {
            case "SAFE_FILTER_ERROR":
            case "SAFE_FILTER_ERROR_CHN_SENSITIVE":
            case "SAFE_FILTER_ERROR_CHILD":
            case "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE":
            case "SAFE_FILTER_ERROR_RECITATION":
                return true;
            default:
                return false;
        }
    }

    private static boolean needToastForUser(String str) {
        str.getClass();
        switch (str) {
            case "SAFE_FILTER_ERROR":
            case "NETWORK_ERROR":
            case "SAFE_FILTER_ERROR_CHN_SENSITIVE":
            case "UNEXPECTED_ERROR":
            case "INVALID_RESULT":
            case "INVALID_ACCOUNT":
            case "SAFE_FILTER_ERROR_CHILD":
            case "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE":
            case "SAFE_FILTER_ERROR_RECITATION":
                return true;
            default:
                return false;
        }
    }

    private String parse(String str, String str2) {
        int length = str.length() + str2.indexOf(str);
        if (length < str.length()) {
            return "";
        }
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("parse# target : ", str, ", target length : ");
        sbM15l.append(str.length());
        sbM15l.append(", begin : ");
        sbM15l.append(length);
        Logger.m10999d(str3, sbM15l.toString());
        String strSubstring = str2.substring(length);
        String strReplaceAll = strSubstring.substring(strSubstring.indexOf(":") + 1).replace("\"", "").replaceAll(",$", "");
        int length2 = strReplaceAll.length();
        int iCharCount = 0;
        while (iCharCount < length2) {
            int iCodePointAt = strReplaceAll.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return strReplaceAll.substring(iCharCount, length2);
    }

    private String parseCategory(String str) {
        String strReplaceAll = parse(CLASSIFICATION, str).replaceAll("[\\s,]+", "");
        for (PredefinedCoverSticker predefinedCoverSticker : PredefinedCoverSticker.values()) {
            if (predefinedCoverSticker.getName().equalsIgnoreCase(strReplaceAll)) {
                return predefinedCoverSticker.getUuid();
            }
        }
        return "Unknown".equalsIgnoreCase(strReplaceAll) ? "Unknown" : CoverStickerConstants.Category.NONE.UUID;
    }

    private boolean parseResultData() {
        String[] strArrSplit = this.mCoverResult.mData.replace("\\n", "\n").split("\n");
        AbstractC8014b.m7221w(new StringBuilder("parseResultData# extractResult size : "), TAG, strArrSplit.length);
        for (String str : strArrSplit) {
            String strTrim = str.trim();
            if (strTrim.startsWith(TITLE)) {
                this.mCoverResult.mTitle = StringUtils.convertUnexpectedChars(parse(TITLE, strTrim));
            } else if (strTrim.startsWith(CLASSIFICATION)) {
                this.mCoverResult.mCategory = parseCategory(strTrim);
            } else if (strTrim.startsWith(SUMMARY)) {
                this.mCoverResult.mSummary = StringUtils.convertUnexpectedChars(parseSummary(strTrim));
            }
        }
        if ("Unknown".equalsIgnoreCase(this.mCoverResult.mCategory)) {
            this.mCoverResult.setErrMsg("SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE");
            return false;
        }
        if (!TextUtils.isEmpty(this.mCoverResult.mTitle) && !TextUtils.isEmpty(this.mCoverResult.mCategory) && !TextUtils.isEmpty(this.mCoverResult.mSummary)) {
            return true;
        }
        this.mCoverResult.setErrMsg(CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? "SAFE_FILTER_ERROR_CHN_SENSITIVE" : INVALID_RESULT);
        return false;
    }

    private String parseSummary(String str) {
        return parseSummaryUnderMaxChar(parse(SUMMARY, str));
    }

    public static String parseSummaryUnderMaxChar(String str) {
        if (str.length() < 200) {
            return str;
        }
        String strSubstring = str.substring(0, 200);
        int iLastIndexOf = strSubstring.lastIndexOf(" ");
        return iLastIndexOf <= 180 ? strSubstring : strSubstring.substring(0, iLastIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateResult() {
        if (this.mCoverResult == null) {
            return;
        }
        Logger.m10999d(TAG, "updateResult#");
        if (this.mCallback == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.mCoverResult.mData) && parseResultData()) {
            Callback callback = this.mCallback;
            ResultData resultData = this.mCoverResult;
            callback.onCompleted(resultData.mTitle, resultData.mSummary, resultData.mCategory);
        } else {
            this.mCallback.onFailed(this.mCoverResult.mErrMsg);
        }
        this.mCallback = null;
    }

    public void cancel() {
        clear();
        ResultData resultData = new ResultData("");
        this.mCoverResult = resultData;
        resultData.setErrMsg(USER_CANCEL);
        updateResult();
    }

    public void createCoverData(String str, Callback callback) {
        Logger.m10999d(TAG, "createCoverData#");
        clear();
        this.mSrc = str;
        this.mCallback = callback;
        if (canExtractCoverData(str)) {
            extractCoverData(str);
        }
    }

    public String getSrcContent() {
        return this.mSrc;
    }
}
