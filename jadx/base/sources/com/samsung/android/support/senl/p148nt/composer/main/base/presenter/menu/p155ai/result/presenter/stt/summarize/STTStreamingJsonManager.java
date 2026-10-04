package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashSet;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTStreamingJsonManager {
    private static final String JSON_KEYWORDS_KEY = "keywords";
    private static final String JSON_SUMMARY_KEY = "summary";
    private static final String JSON_VALUE_BEGIN = "```json";
    private static final String JSON_VALUE_CACHE_BRIDGE_CONTENT = "][";
    private static final String JSON_VALUE_EMPTY_CONTENT = "[]";
    private static final String JSON_VALUE_NULL = "null";
    private static final char LINE_BREAK = '\n';
    private static final char QUOTES = '\"';
    private static final int STREAMING_CHAR_DELAY_THRESHOLD = 30;
    private Consumer<Void> mOnCharPostCompleteListener;
    private Consumer<StreamingSummaryParser> mUIHandlingCallback;
    private StreamingSummaryParser streamingSummaryParser;
    private static final String TAG = Logger.createTag("STTStreamingJsonManager", AiConstants.PREFIX_TAG);
    private static final String JSON_VALUE_END = "```" + System.lineSeparator();
    private Future<?> mResultPostFuture = null;
    private final ScheduledExecutorService mSingleThreadPool = Executors.newSingleThreadScheduledExecutor();
    private boolean mIsCompleted = false;
    private int mIndex = 1;
    private AtomicReference<StringBuilder> mResultJson = new AtomicReference<>(new StringBuilder());
    final HashSet<String> JSON_KEY_LIST = new HashSet<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.STTStreamingJsonManager.1
        {
            add("title");
            add("summary");
            add("keywords");
            add("subheading");
            add("details");
            add("date");
            add("time");
            add(ServerResultMeetingParser.PLACE);
            add(ServerResultMeetingParser.PARTICIPANTS);
            add(ServerResultMeetingParser.AGENDAS);
            add("contents");
        }
    };
    private Runnable mResultPostRunnable = new RunnableC94752();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.STTStreamingJsonManager$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC94752 implements Runnable {
        public RunnableC94752() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (STTStreamingJsonManager.this.mUIHandlingCallback == null || STTStreamingJsonManager.this.mResultPostFuture == null || STTStreamingJsonManager.this.mResultPostFuture.isCancelled()) {
                if (STTStreamingJsonManager.this.mIsCompleted) {
                    return;
                }
                Logger.m11000e(STTStreamingJsonManager.TAG, "mResultPostFuture cancelled, skip posting");
                return;
            }
            String string = ((StringBuilder) STTStreamingJsonManager.this.mResultJson.get()).toString();
            STTStreamingJsonManager.this.partlySkipPosting(string);
            STTStreamingJsonManager.this.streamingSummaryParser.parse(string.substring(0, STTStreamingJsonManager.this.mIndex));
            if (STTStreamingJsonManager.this.streamingSummaryParser.getKeywords().size() > 0 && STTStreamingJsonManager.this.streamingSummaryParser.getSummaries().size() > 0) {
                int iIndexOf = string.indexOf("\"keywords");
                int iIndexOf2 = string.indexOf("\"title");
                int iIndexOf3 = string.indexOf("\"summary");
                AbstractC8014b.m7221w(AbstractC0622a.m1173s(iIndexOf, iIndexOf2, "skip keyword stream index: keywordOffset: ", " titleOffset: ", " summaryOffset: "), STTStreamingJsonManager.TAG, iIndexOf3);
                if (iIndexOf > iIndexOf2 && iIndexOf > iIndexOf3) {
                    STTStreamingJsonManager.this.mIndex = string.length();
                }
            }
            STTStreamingJsonManager.this.mIndex++;
            STTStreamingJsonManager.this.mUIHandlingCallback.accept(STTStreamingJsonManager.this.streamingSummaryParser);
            int length = string.length();
            String str = STTStreamingJsonManager.TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(length, "mResultPostRunnable ", " index ");
            sbM778t.append(STTStreamingJsonManager.this.mIndex);
            Logger.m10999d(str, sbM778t.toString());
            if (STTStreamingJsonManager.this.mIndex > string.length()) {
                STTStreamingJsonManager.this.mResultPostFuture.cancel(true);
                if (STTStreamingJsonManager.this.mIsCompleted) {
                    Logger.m10999d(STTStreamingJsonManager.TAG, "is completed: call OnCharPostCompleteListener");
                    Optional.ofNullable(STTStreamingJsonManager.this.mOnCharPostCompleteListener).ifPresent(new C9479d());
                }
            }
        }
    }

    public STTStreamingJsonManager(Consumer<StreamingSummaryParser> consumer) {
        Logger.m10999d(TAG, "STTStreamingJsonManager");
        this.mUIHandlingCallback = consumer;
        this.streamingSummaryParser = new StreamingSummaryParser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void partlySkipPosting(String str) {
        int iIndexOf;
        int i;
        int length = str.length();
        if (this.mIndex > length) {
            this.mIndex = str.length();
            return;
        }
        while (true) {
            int i2 = this.mIndex;
            if (i2 >= length) {
                return;
            }
            try {
                char cCharAt = str.charAt(i2);
                if (!Character.isWhitespace(cCharAt) && cCharAt != '\"') {
                    return;
                }
                if (Character.isWhitespace(cCharAt)) {
                    continue;
                } else {
                    int i4 = this.mIndex;
                    if (i4 + 1 <= length) {
                        int iIndexOf2 = str.indexOf(34, i4 + 1);
                        if (iIndexOf2 < 0) {
                            return;
                        }
                        if (this.JSON_KEY_LIST.contains(str.substring(this.mIndex + 1, iIndexOf2))) {
                            this.mIndex = iIndexOf2 + 1;
                            String str2 = TAG;
                            Logger.m10999d(str2, "Skip key: " + this.mIndex);
                            int iIndexOf3 = str.indexOf(10, this.mIndex);
                            if (iIndexOf3 >= 0 && (iIndexOf = str.indexOf(58, this.mIndex)) >= 1 && (i = iIndexOf + 1) <= length) {
                                String strTrim = str.substring(i, iIndexOf3 - 1).trim();
                                if (!strTrim.equals(JSON_VALUE_NULL) && !strTrim.equals("[]") && !strTrim.equals(JSON_VALUE_CACHE_BRIDGE_CONTENT)) {
                                    return;
                                }
                                this.mIndex = iIndexOf3;
                                Logger.m10999d(str2, "Skip empty content: " + this.mIndex);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                Logger.m11000e(TAG, "partlySkipPosting IndexOutOfBoundsException: " + e);
            }
            this.mIndex++;
        }
    }

    private void trimResultJson() {
        AtomicReference<StringBuilder> atomicReference = this.mResultJson;
        if (atomicReference == null || atomicReference.get().length() == 0) {
            return;
        }
        if (this.mResultJson.get().toString().startsWith(JSON_VALUE_BEGIN)) {
            this.mResultJson.get().replace(0, 7, "");
        } else if (this.mResultJson.get().toString().startsWith("json")) {
            this.mResultJson.get().replace(0, 4, "");
        }
        String string = this.mResultJson.get().toString();
        String str = JSON_VALUE_END;
        if (string.endsWith(str)) {
            this.mResultJson.get().replace(this.mResultJson.get().toString().length() - str.length(), this.mResultJson.get().toString().length(), "");
        }
    }

    public void cancel() {
        Logger.m10999d(TAG, "cancel");
        Future<?> future = this.mResultPostFuture;
        if (future != null && (!future.isCancelled() || !this.mResultPostFuture.isDone())) {
            this.mResultPostFuture.cancel(true);
        }
        this.mSingleThreadPool.shutdownNow();
        this.mUIHandlingCallback = null;
    }

    public String getFullContent() {
        return this.mResultJson.toString();
    }

    public boolean isCompleted() {
        return this.mIsCompleted;
    }

    public void onResult(String str, boolean z) {
        boolean zIsEmpty = this.mResultJson.get().toString().isEmpty();
        this.mIsCompleted = z;
        if (str != null && str.startsWith("[") && str.endsWith("]")) {
            str = AbstractC2322a.m1614d(1, 1, str);
        }
        if (!z || !zIsEmpty) {
            this.mResultJson.get().append(str);
            trimResultJson();
            return;
        }
        Logger.m11004w(TAG, "onetime post (CACHE)");
        if (str != null) {
            str = str.replace(JSON_VALUE_CACHE_BRIDGE_CONTENT, "");
        }
        this.mResultJson.get().append(str);
        trimResultJson();
    }

    public void setOnCharPostCompleteListener(Consumer<Void> consumer) {
        this.mOnCharPostCompleteListener = consumer;
    }

    public void startStreaming() {
        Future<?> future = this.mResultPostFuture;
        if (future != null && !future.isDone() && !this.mResultPostFuture.isCancelled()) {
            Logger.m11004w(TAG, "mResultPostFuture exist, skip multiple posting!");
        } else {
            Logger.m10999d(TAG, "scheduleAtFixedRate");
            this.mResultPostFuture = this.mSingleThreadPool.scheduleWithFixedDelay(this.mResultPostRunnable, 0L, 30L, TimeUnit.MILLISECONDS);
        }
    }
}
