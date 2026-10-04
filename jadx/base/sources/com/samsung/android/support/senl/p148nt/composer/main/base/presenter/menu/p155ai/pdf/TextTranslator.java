package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextTranslator {
    private static final int PARTIAL_UPDATE_COUNT_MAX = 5;
    private static final int PARTIAL_UPDATE_DEFAULT_INDEX = -1;
    private static final String TAG = Logger.createTag("AI#TextTranslator");
    private CountDownLatch mCountDownLatch;
    private String mFromLanguageTag;
    private AtomicInteger mPartialResultEndIndex;
    private AtomicInteger mPartialResultStartIndex;
    private AtomicInteger mPartialUpdateCnt;
    private final String[] mResultArray;
    private ResultListener mResultListener;
    private final String[] mStringArray;
    private String mToLanguageTag;
    private int mTotalTranslateCnt;
    private AtomicInteger mTranslateCnt;
    private final Executor mExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
    private boolean mIsCanceled = false;
    private final List<String> mPartialResultList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ResultListener {
        public abstract void onResult(@NonNull String[] strArr, String str, String str2);

        public abstract void onUpdate(int i, @NonNull String[] strArr, String str, String str2);
    }

    public TextTranslator(String[] strArr) {
        this.mStringArray = (String[]) strArr.clone();
        this.mResultArray = (String[]) strArr.clone();
    }

    public static String getEncode(String str) {
        return "";
    }

    public static boolean isNeedToTranslate(String str) {
        for (String str2 : str.split(">")) {
            if (!TextUtils.isEmpty(str2) && isValidText(str2.split("<")[0])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidText(String str) {
        if (str != null && str.length() != 0) {
            for (char c : str.toCharArray()) {
                if (!Character.isHighSurrogate(c) && !Character.isLowSurrogate(c) && !Character.isDigit(c) && c != '.' && c != 183 && !Character.isSpaceChar(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0() {
        String[] strArr = this.mStringArray;
        if (strArr == null || strArr.length == 0) {
            Logger.m10999d(TAG, "execute# Ignored by empty.");
            return;
        }
        AbstractC8014b.m7221w(new StringBuilder("execute# string list : "), TAG, this.mStringArray.length);
        translateText(this.mStringArray);
    }

    private void partialUpdate(int i, @NonNull String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(int i, String str) {
        partialUpdate(i, str);
        this.mResultArray[i] = str;
        if (this.mTranslateCnt.decrementAndGet() == 0 || this.mIsCanceled) {
            updateResult();
            this.mCountDownLatch.countDown();
        }
    }

    private void updateResult() {
    }

    public void execute() {
        this.mExecutor.execute(new RunnableC9414a(this, 0));
    }

    public void initializeLanguage(String str, String str2) {
        this.mFromLanguageTag = str;
        this.mToLanguageTag = str2;
    }

    public void release() {
        this.mIsCanceled = true;
        this.mResultListener = null;
    }

    public void setResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public void translateText(String[] strArr) {
        String str = TAG;
        Logger.startTime(str, str, "translateText#Start size : " + strArr.length);
        this.mPartialUpdateCnt = new AtomicInteger(0);
        this.mTranslateCnt = new AtomicInteger(strArr.length);
        this.mCountDownLatch = new CountDownLatch(1);
        this.mTotalTranslateCnt = this.mTranslateCnt.get();
        int length = 0;
        for (final int i = 0; i < strArr.length; i++) {
            if (this.mIsCanceled) {
                return;
            }
            if (isNeedToTranslate(strArr[i])) {
                SCSOperator sCSOperator = new SCSOperator();
                sCSOperator.setCallback(new SCSTextResultListener.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TextTranslator.1
                    @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                    public boolean onFailed(@NonNull String str2) {
                        if (TextTranslator.this.mIsCanceled) {
                            Logger.m10999d(TextTranslator.TAG, "onFailed# Ignored by cancel. index : " + i + SQLKeyword.COMMA + str2);
                            return true;
                        }
                        Logger.m10999d(TextTranslator.TAG, "onFailed# index : " + i + SQLKeyword.COMMA + str2);
                        TextTranslator textTranslator = TextTranslator.this;
                        textTranslator.update(i, textTranslator.mStringArray[i]);
                        return true;
                    }

                    @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                    public void onSuccess(@NonNull String str2, boolean z) {
                        if (TextTranslator.this.mIsCanceled) {
                            String str3 = TextTranslator.TAG;
                            StringBuilder sbM3200j = AbstractC4539a.m3200j("translate#onSuccess Ignored by cancel. ", ", index : ", z);
                            sbM3200j.append(i);
                            sbM3200j.append(", result : (");
                            sbM3200j.append(str2.length());
                            sbM3200j.append(") ");
                            sbM3200j.append(TextTranslator.getEncode(str2));
                            Logger.m10999d(str3, sbM3200j.toString());
                            return;
                        }
                        String str4 = TextTranslator.TAG;
                        StringBuilder sbM3200j2 = AbstractC4539a.m3200j("translate#onSuccess ", ", index : ", z);
                        sbM3200j2.append(i);
                        sbM3200j2.append(", result : (");
                        sbM3200j2.append(str2.length());
                        sbM3200j2.append(") ");
                        sbM3200j2.append(TextTranslator.getEncode(str2));
                        Logger.m10999d(str4, sbM3200j2.toString());
                        TextTranslator.this.update(i, str2);
                    }
                });
                String str2 = TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "translate# ", ", from : ");
                sbM778t.append(this.mFromLanguageTag);
                sbM778t.append(", to : ");
                sbM778t.append(this.mToLanguageTag);
                sbM778t.append(", text : (");
                sbM778t.append(strArr[i].length());
                sbM778t.append(") ");
                sbM778t.append(getEncode(strArr[i]));
                Logger.m10999d(str2, sbM778t.toString());
                String strConvertToScsLanguage = AiLanguageHelper.convertToScsLanguage(this.mFromLanguageTag);
                String strConvertToScsLanguage2 = AiLanguageHelper.convertToScsLanguage(this.mToLanguageTag);
                if (!TextUtils.isEmpty(strConvertToScsLanguage) && !TextUtils.isEmpty(strConvertToScsLanguage2)) {
                    sCSOperator.translate(strArr[i], strConvertToScsLanguage, strConvertToScsLanguage2, true);
                    length += strArr[i].length();
                }
            } else {
                String str3 = TAG;
                StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "translate#isNeedToTranslate false, index : ", ", result : (");
                sbM778t2.append(strArr[i].length());
                sbM778t2.append(") ");
                sbM778t2.append(getEncode(strArr[i]));
                Logger.m10999d(str3, sbM778t2.toString());
                update(i, strArr[i]);
            }
        }
        AbstractC0000a.m3D(length, "translate# Total Length : ", TAG);
        try {
            this.mCountDownLatch.await();
        } catch (InterruptedException unused) {
            Logger.m11000e(TAG, "translateText# interrupted");
        }
        if (this.mResultListener != null) {
            if (this.mPartialUpdateCnt.get() == this.mTotalTranslateCnt) {
                this.mResultListener.onResult(new String[0], this.mFromLanguageTag, this.mToLanguageTag);
            } else {
                this.mResultListener.onResult(this.mResultArray, this.mFromLanguageTag, this.mToLanguageTag);
            }
        }
        String str4 = TAG;
        Logger.endTime(str4, str4, "translateText#End " + strArr.length + " / mTranslateCnt = " + this.mTranslateCnt);
    }
}
