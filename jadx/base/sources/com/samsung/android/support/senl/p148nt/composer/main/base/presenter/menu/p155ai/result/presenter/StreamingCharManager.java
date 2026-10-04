package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
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
public class StreamingCharManager {
    private static final String JSON_VALUE_EMPTY_CONTENT = "[]";
    private static final String JSON_VALUE_NULL = "null";
    private static final char LINE_BREAK = '\n';
    private static final char QUOTES = '\"';
    private static final int STREAMING_CHAR_DELAY_THRESHOLD = 30;
    private static final String TAG = Logger.createTag("StreamingCharManager", AiConstants.PREFIX_TAG);
    private Consumer<Void> mOnCharPostCompleteListener;
    private Consumer<String> mUIHandlingCallback;
    private Future<?> mResultPostFuture = null;
    private final ScheduledExecutorService mSingleThreadPool = Executors.newSingleThreadScheduledExecutor();
    private boolean mIsCompleted = false;
    private AtomicReference<StringBuilder> mResultContent = new AtomicReference<>(new StringBuilder());
    private AtomicReference<ArrayList<StringBuilder>> mResultContentList = null;
    private int mIndex = 1;
    final HashSet<String> JSON_KEY_LIST = new HashSet<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.StreamingCharManager.1
        {
            add("title");
            add("subheading");
            add("details");
            add("title");
            add("date");
            add("time");
            add(ServerResultMeetingParser.PLACE);
            add(ServerResultMeetingParser.PARTICIPANTS);
            add(ServerResultMeetingParser.AGENDAS);
            add("contents");
            add("subheading");
            add("details");
        }
    };
    private Runnable mResultPostRunnable = new RunnableC94532();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.StreamingCharManager$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC94532 implements Runnable {
        public RunnableC94532() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StreamingCharManager.this.mUIHandlingCallback == null || StreamingCharManager.this.mResultPostFuture == null || StreamingCharManager.this.mResultPostFuture.isCancelled()) {
                if (StreamingCharManager.this.mIsCompleted) {
                    return;
                }
                Logger.m11000e(StreamingCharManager.TAG, "mResultPostFuture cancelled, skip posting");
                return;
            }
            String string = ((StringBuilder) StreamingCharManager.this.mResultContent.get()).toString();
            StreamingCharManager.this.partlySkipPosting(string);
            if (StreamingCharManager.this.mIndex > string.length() && StreamingCharManager.this.mIsCompleted) {
                Logger.m10999d(StreamingCharManager.TAG, "index out of bounds and completed, need callback.");
                StreamingCharManager.this.mResultPostFuture.cancel(true);
                Optional.ofNullable(StreamingCharManager.this.mOnCharPostCompleteListener).ifPresent(new C9472q(0));
                return;
            }
            StreamingCharManager.this.mUIHandlingCallback.accept(string.substring(0, StreamingCharManager.this.mIndex));
            StreamingCharManager.this.mIndex++;
            if (StreamingCharManager.this.mIndex > string.length()) {
                Logger.m10999d(StreamingCharManager.TAG, "ResultPostFuture cancel");
                StreamingCharManager.this.mResultPostFuture.cancel(true);
                if (StreamingCharManager.this.mIsCompleted) {
                    Logger.m10999d(StreamingCharManager.TAG, "is completed: call OnCharPostCompleteListener");
                    Optional.ofNullable(StreamingCharManager.this.mOnCharPostCompleteListener).ifPresent(new C9472q(1));
                }
            }
        }
    }

    public StreamingCharManager(Consumer<String> consumer) {
        Logger.m10999d(TAG, "StreamingCharManager");
        this.mUIHandlingCallback = consumer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void partlySkipPosting(String str) {
        int iIndexOf;
        int i;
        int length = str.length();
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
                                if (!strTrim.equals(JSON_VALUE_NULL) && !strTrim.equals("[]")) {
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

    public void addOnCharPostCompleteListener(Consumer<Void> consumer) {
        this.mOnCharPostCompleteListener = consumer;
    }

    public void cancel() {
        Logger.m10999d(TAG, "cancel");
        Future<?> future = this.mResultPostFuture;
        if (future != null && (!future.isCancelled() || !this.mResultPostFuture.isDone())) {
            this.mResultPostFuture.cancel(true);
        }
        this.mSingleThreadPool.shutdownNow();
        this.mUIHandlingCallback = null;
        this.mResultContentList = null;
        this.mResultContent = null;
    }

    public String getFullContent() {
        Logger.m10999d(TAG, "getFullContent： " + this.mResultContent.toString().length());
        return this.mResultContent.toString();
    }

    public AtomicReference<ArrayList<StringBuilder>> getResultContentList() {
        return this.mResultContentList;
    }

    public void onResult(String str, boolean z) {
        boolean zIsEmpty = this.mResultContent.get().toString().isEmpty();
        this.mIsCompleted = z;
        this.mResultContent.get().append(str);
        if (z && zIsEmpty) {
            Logger.m11004w(TAG, "onetime post (CACHE)");
            Optional.ofNullable(this.mOnCharPostCompleteListener).ifPresent(new C9472q(4));
            return;
        }
        Future<?> future = this.mResultPostFuture;
        if (future != null && !future.isDone() && !this.mResultPostFuture.isCancelled()) {
            Logger.m11004w(TAG, "mResultPostFuture exist, skip multiple posting!");
        } else {
            Logger.m10999d(TAG, "scheduleAtFixedRate");
            this.mResultPostFuture = this.mSingleThreadPool.scheduleAtFixedRate(this.mResultPostRunnable, 0L, 30L, TimeUnit.MILLISECONDS);
        }
    }

    public void onStreamingMergeResult(String str, boolean z) {
        this.mResultContent.get().delete(0, this.mResultContent.get().length());
        this.mIsCompleted = z;
        this.mResultContent.get().append(str);
        if (z) {
            this.mUIHandlingCallback = null;
            Optional.ofNullable(this.mOnCharPostCompleteListener).ifPresent(new C9472q(5));
        }
    }

    public void setResultContentSize() {
        this.mResultContentList = new AtomicReference<>(new ArrayList());
    }
}
