package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsPasteLogic {
    public static final int ERROR_SUB_TYPE_FAIL_IS_INFINITE_NOTE = 1;
    public static final int ERROR_SUB_TYPE_FAIL_IS_LANDSCAPE_NOTE = 3;
    public static final int ERROR_SUB_TYPE_FAIL_IS_PORTRAIT_NOTE = 2;
    public static final int ERROR_TYPE_COEDIT_PASTE_PAGE = 64;
    public static final int ERROR_TYPE_COEDIT_RESTRICTION = 32;
    public static final int ERROR_TYPE_COEDIT_RESTRICTION_LARGE_ITEMS = 128;
    public static final int ERROR_TYPE_DND_ONLY_ONE_AUDIO = 2;
    public static final int ERROR_TYPE_FAIL_IS_DYNAMIC_TEMPLATE_NOTE = 16384;
    public static final int ERROR_TYPE_FAIL_IS_FOLDER = 4096;
    public static final int ERROR_TYPE_FAIL_IS_NOTE = 8192;
    public static final int ERROR_TYPE_FAIL_TO_LOAD_DOC = 4;
    public static final int ERROR_TYPE_PASTE_PAGE_BODY_TEXT_LIMIT = 16;
    public static final int ERROR_TYPE_PASTE_PAGE_ON_SINGLE = 1;
    public static final int ERROR_TYPE_PDF_READER_NOT_SUPPORT = 8;
    public static final int MESSAGE_GET_CONTENTS = 2;
    public static final int MESSAGE_PASTE_CONTENT_IN_TITLE = 6;
    public static final int MESSAGE_PASTE_NEXT_CONTENT = 3;
    public static final int MESSAGE_PASTE_NEXT_OBJECT = 4;
    public static final int MESSAGE_PASTE_PAGE = 7;
    public static final int MESSAGE_PASTE_PDF = 8;
    public static final int MESSAGE_POST_SET_FILE = 5;
    public static final int MESSAGE_RELEASE = 9;
    public static final int MESSAGE_WEB_CARD_PREVIEW_DIALOG = 10;
    protected Context mContext;
    protected Contract mContract;
    protected Handler mHandler;
    protected boolean mIsReleased;
    protected boolean mUpdateInvertBG = false;
    private int mErrorCode = 0;
    private int mErrorCodeSubType = 0;
    private boolean mSkipAiSuggestion = false;
    public String mSASourceType = "c";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void release();
    }

    public AbsPasteLogic(Contract contract, Context context, Handler handler) {
        this.mContract = contract;
        this.mContext = context;
        this.mHandler = handler;
    }

    public static String messageToString(int i) {
        switch (i) {
            case 2:
                return "MESSAGE_GET_CONTENTS";
            case 3:
                return "MESSAGE_PASTE_NEXT_CONTENT";
            case 4:
                return "MESSAGE_PASTE_NEXT_OBJECT";
            case 5:
                return "MESSAGE_POST_SET_FILE";
            case 6:
                return "MESSAGE_PASTE_CONTENT_IN_TITLE";
            case 7:
            default:
                return AbstractC0000a.m11h(i, "message: ");
            case 8:
                return "MESSAGE_PASTE_PDF";
            case 9:
                return "MESSAGE_RELEASE";
            case 10:
                return "MESSAGE_WEB_CARD_PREVIEW_DIALOG";
        }
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getErrorCodeSubType() {
        return this.mErrorCodeSubType;
    }

    public abstract void handleMessage(@NonNull Message message);

    public void insertSourceSALog() {
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_COPY_PASTE_SOURCE, this.mSASourceType);
    }

    public boolean isSkipAiSuggestion() {
        return this.mSkipAiSuggestion;
    }

    public boolean isUpdateInvertBG() {
        return this.mUpdateInvertBG;
    }

    @WorkerThread
    public abstract void readyContents();

    public abstract void release();

    public void setErrorCode(int i) {
        this.mErrorCode = i | this.mErrorCode;
    }

    public void setErrorCodeSubType(int i) {
        this.mErrorCodeSubType = i;
    }

    public void setReleased(boolean z) {
        this.mIsReleased = z;
    }

    public void setSASourceType(String str) {
        this.mSASourceType = str;
    }

    public void setSkipAiSuggestion(boolean z) {
        this.mSkipAiSuggestion = z;
    }
}
