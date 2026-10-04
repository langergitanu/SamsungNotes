package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastDecoder;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.mmfw.mediatool.MediaTool;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder;", "", "mSession", "", "<init>", "(Ljava/lang/String;)V", "mThreadCount", "", "mFastDecoderThread", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder$FastDecoderThread;", "mStartDecoderTime", "", "mStartMediaToolTime", "mStartResampleTime", "mStartWriteTime", "mTotalTime", "mMediaToolTime", "mResampleTime", "mWriteTime", "startFastDecoder", "", "filePath", "cancelFastDecoder", "mDecoderListener", "Lcom/samsung/android/support/senl/nt/stt/base/audio/OnDecoderListener;", "registerListener", "decoderListener", "unregisterListener", "FastDecoderThread", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastDecoder {
    private static final int CHANNEL_MONO = 1;
    private static final int DECODE_ONLY_MODE = 0;
    private static final int DECODE_OUT_CHANNEL = 1;
    private static final long MAX_BUFFER_SIZE = 10485760;
    private static final int MAX_NUM_OF_PENDING_BUFFER = 3;
    public static final int MSG_HANDLE_OUTPUT_BUFFER = 1;
    public static final int MSG_HANDLE_OUTPUT_LAST_BUFFER = 2;
    private static final int REQUEST_PUT_BUFFER_TO_DEQUE = 100;
    private static final int REQUEST_PUT_LAST_BUFFER_TO_DEQUE = 101;

    @NotNull
    private static final String RESAMPLE_TAG = "FastDecoder#ResampleHandelThread";

    @NotNull
    private static final String TAG = "FastDecoder";

    @NotNull
    private static final String THREAD_TAG = "FastDecoder#FastDecoderThread";

    @Nullable
    private static ResampleJNI mResampleJNI;

    @Nullable
    private OnDecoderListener mDecoderListener;

    @Nullable
    private FastDecoderThread mFastDecoderThread;
    private long mMediaToolTime;
    private long mResampleTime;

    @NotNull
    private final String mSession;
    private long mStartDecoderTime;
    private long mStartMediaToolTime;
    private long mStartResampleTime;
    private long mStartWriteTime;
    private int mThreadCount;
    private long mTotalTime;
    private long mWriteTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final ConcurrentHashMap<String, FastDecoder> mFastDecoderMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "THREAD_TAG", "RESAMPLE_TAG", "MAX_BUFFER_SIZE", "", "MAX_NUM_OF_PENDING_BUFFER", "", "CHANNEL_MONO", "mFastDecoderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder;", "MSG_HANDLE_OUTPUT_BUFFER", "MSG_HANDLE_OUTPUT_LAST_BUFFER", "mResampleJNI", "Lcom/samsung/android/support/senl/nt/stt/base/audio/ResampleJNI;", "REQUEST_PUT_BUFFER_TO_DEQUE", "REQUEST_PUT_LAST_BUFFER_TO_DEQUE", "DECODE_ONLY_MODE", "DECODE_OUT_CHANNEL", "getInstance", "session", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized FastDecoder getInstance(@NotNull String session) {
            FastDecoder fastDecoder;
            Intrinsics.checkNotNullParameter(session, "session");
            ConcurrentHashMap concurrentHashMap = FastDecoder.mFastDecoderMap;
            Intrinsics.checkNotNull(concurrentHashMap);
            fastDecoder = (FastDecoder) concurrentHashMap.get(session);
            if (fastDecoder == null) {
                fastDecoder = new FastDecoder(session);
                FastDecoder.mFastDecoderMap.putIfAbsent(session, fastDecoder);
            }
            return fastDecoder;
        }

        private Companion() {
        }
    }

    public FastDecoder(@NotNull String mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
    }

    public final void cancelFastDecoder() {
        Logger.m12713i(TAG, "cancel current FastDecoderThread");
        FastDecoderThread fastDecoderThread = this.mFastDecoderThread;
        if (fastDecoderThread != null) {
            Intrinsics.checkNotNull(fastDecoderThread);
            fastDecoderThread.setCancelFastDecoder();
            FastDecoderThread fastDecoderThread2 = this.mFastDecoderThread;
            Intrinsics.checkNotNull(fastDecoderThread2);
            fastDecoderThread2.cancelFastDecoder();
        }
    }

    public final void registerListener(@Nullable OnDecoderListener decoderListener) {
        this.mDecoderListener = decoderListener;
    }

    public final void startFastDecoder(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mWriteTime = 0L;
        this.mResampleTime = 0L;
        this.mMediaToolTime = 0L;
        this.mTotalTime = 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mStartDecoderTime = jCurrentTimeMillis;
        Logger.m12713i(TAG, " startFastDecoder " + jCurrentTimeMillis);
        Logger.m12714w(TAG, "create new FastDecoderThread");
        FastDecoderThread fastDecoderThread = new FastDecoderThread(this, filePath);
        this.mFastDecoderThread = fastDecoderThread;
        Intrinsics.checkNotNull(fastDecoderThread);
        fastDecoderThread.start();
    }

    public final void unregisterListener() {
        this.mDecoderListener = null;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J \u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\b\u0010+\u001a\u00020#H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0018\u00010\u0015R\u00060\u0000R\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder$FastDecoderThread;", "Ljava/lang/Thread;", "path", "", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder;Ljava/lang/String;)V", "EMPTY_DEQUEUE_SIZE", "", "mMediaPath", "pcmFileIndex", "mOutputStream", "Ljava/io/FileOutputStream;", "mPcmFileName", "isCancel", "", "mMediaTool", "Lcom/samsung/mmfw/mediatool/MediaTool;", "mPendingByteBufferForResampleList", "Ljava/util/concurrent/LinkedBlockingDeque;", "Ljava/nio/ByteBuffer;", "mResampleHandlerThread", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder$FastDecoderThread$ResampleHandlerThread;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder;", "mBufferDequeHandler", "Landroid/os/Handler;", "getMBufferDequeHandler", "()Landroid/os/Handler;", "setMBufferDequeHandler", "(Landroid/os/Handler;)V", "mLooper", "Landroid/os/Looper;", "mBuffer", "mDecodeFileSize", "", "run", "", "handleDequeHandleMessage", "msg", "Landroid/os/Message;", "handlePutBufferToDeque", "isLastBuffer", "message", "dequeSize", "startDecodeWithMediaTool", "mMediaToolHandler", "handleMediaToolError", "errorCode", "handleResample", "setCancelFastDecoder", "cancelFastDecoder", "releaseBuffer", "nextOutputStream", "getNextOutputStream", "()Ljava/io/FileOutputStream;", "ResampleHandlerThread", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class FastDecoderThread extends Thread {
        private final int EMPTY_DEQUEUE_SIZE;
        private boolean isCancel;

        @Nullable
        private ByteBuffer mBuffer;

        @Nullable
        private Handler mBufferDequeHandler;
        private long mDecodeFileSize;

        @Nullable
        private Looper mLooper;

        @NotNull
        private final String mMediaPath;

        @Nullable
        private MediaTool mMediaTool;

        @Nullable
        private Handler mMediaToolHandler;

        @Nullable
        private FileOutputStream mOutputStream;

        @Nullable
        private String mPcmFileName;

        @Nullable
        private LinkedBlockingDeque<ByteBuffer> mPendingByteBufferForResampleList;

        @Nullable
        private ResampleHandlerThread mResampleHandlerThread;
        private int pcmFileIndex;
        final /* synthetic */ FastDecoder this$0;

        public FastDecoderThread(@NotNull FastDecoder fastDecoder, String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.this$0 = fastDecoder;
            this.EMPTY_DEQUEUE_SIZE = -1;
            fastDecoder.mThreadCount++;
            AbstractC11014a.m12327l(fastDecoder.mThreadCount, "FastDecoderThread Thread count: ", FastDecoder.THREAD_TAG);
            this.mMediaPath = path;
            this.isCancel = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FileOutputStream getNextOutputStream() {
            this.pcmFileIndex++;
            String strMakeSttCacheFilePath = ConvertUtils.makeSttCacheFilePath(this.this$0.mSession, this.pcmFileIndex);
            this.mPcmFileName = strMakeSttCacheFilePath;
            Logger.m12713i(FastDecoder.RESAMPLE_TAG, "getNextOutputStream : " + strMakeSttCacheFilePath);
            try {
                return new FileOutputStream(this.mPcmFileName);
            } catch (FileNotFoundException e) {
                AbstractC12991c.m14005z("FileNotFoundException ", e.getMessage(), FastDecoder.RESAMPLE_TAG);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleDequeHandleMessage(Message msg) {
            int i = msg.what;
            int size = this.EMPTY_DEQUEUE_SIZE;
            LinkedBlockingDeque<ByteBuffer> linkedBlockingDeque = this.mPendingByteBufferForResampleList;
            if (linkedBlockingDeque == null) {
                return;
            }
            try {
                Intrinsics.checkNotNull(linkedBlockingDeque);
                size = linkedBlockingDeque.size();
            } catch (NullPointerException e) {
                Logger.m12711e(FastDecoder.THREAD_TAG, "handleDequeHandleMessage# get deque size false: " + e);
            }
            if (i == 100) {
                handlePutBufferToDeque(false, i, size);
            } else if (i != 101) {
                Logger.m12711e(FastDecoder.THREAD_TAG, "handleDequeHandleMessage# default");
            } else {
                handlePutBufferToDeque(true, i, size);
            }
        }

        private final void handleMediaToolError(int errorCode) {
            String strM11h = AbstractC0000a.m11h(errorCode, "smtu analysis Failed - error code: ");
            AbstractC12991c.m14005z("MediaToolHandler MT_QUIT_DONE ", strM11h, FastDecoder.THREAD_TAG);
            if (this.this$0.mDecoderListener != null) {
                OnDecoderListener onDecoderListener = this.this$0.mDecoderListener;
                Intrinsics.checkNotNull(onDecoderListener);
                onDecoderListener.onDecoderError(strM11h, errorCode);
            }
            MediaTool mediaTool = this.mMediaTool;
            if (mediaTool != null) {
                Intrinsics.checkNotNull(mediaTool);
                mediaTool.deinit();
            }
        }

        private final void handlePutBufferToDeque(boolean isLastBuffer, int message, int dequeSize) {
            if (this.isCancel) {
                cancelFastDecoder();
                return;
            }
            if (this.mBuffer == null || this.mPendingByteBufferForResampleList == null) {
                return;
            }
            if (dequeSize == 3) {
                Handler handler = this.mBufferDequeHandler;
                if (handler != null) {
                    Intrinsics.checkNotNull(handler);
                    if (handler.hasMessages(message)) {
                        Handler handler2 = this.mBufferDequeHandler;
                        Intrinsics.checkNotNull(handler2);
                        handler2.removeMessages(message);
                    }
                    Handler handler3 = this.mBufferDequeHandler;
                    Intrinsics.checkNotNull(handler3);
                    handler3.sendEmptyMessageDelayed(message, 10L);
                    return;
                }
                return;
            }
            try {
                Logger.m12713i(FastDecoder.THREAD_TAG, "mPendingByteBufferForResampleList: " + dequeSize);
                LinkedBlockingDeque<ByteBuffer> linkedBlockingDeque = this.mPendingByteBufferForResampleList;
                Intrinsics.checkNotNull(linkedBlockingDeque);
                linkedBlockingDeque.put(this.mBuffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!isLastBuffer) {
                MediaTool mediaTool = this.mMediaTool;
                Intrinsics.checkNotNull(mediaTool);
                mediaTool.decode_next();
            }
            handleResample(isLastBuffer);
            FastDecoder fastDecoder = this.this$0;
            fastDecoder.mMediaToolTime = (System.currentTimeMillis() - this.this$0.mStartMediaToolTime) + fastDecoder.mMediaToolTime;
            this.this$0.mStartMediaToolTime = System.currentTimeMillis();
        }

        private final void handleResample(boolean isLastBuffer) {
            if (this.isCancel) {
                Logger.m12713i(FastDecoder.THREAD_TAG, this.this$0.mSession + " is cancelled - sendResampleMsg");
                cancelFastDecoder();
                return;
            }
            if (this.mResampleHandlerThread == null) {
                return;
            }
            if (isLastBuffer) {
                Logger.m12713i(FastDecoder.THREAD_TAG, "Send Message resample last buffer");
                ResampleHandlerThread resampleHandlerThread = this.mResampleHandlerThread;
                Intrinsics.checkNotNull(resampleHandlerThread);
                resampleHandlerThread.sendMessage(2);
                return;
            }
            Logger.m12713i(FastDecoder.THREAD_TAG, "Send Message resample buffer");
            ResampleHandlerThread resampleHandlerThread2 = this.mResampleHandlerThread;
            Intrinsics.checkNotNull(resampleHandlerThread2);
            resampleHandlerThread2.sendMessage(1);
        }

        private final void startDecodeWithMediaTool() {
            this.this$0.mStartMediaToolTime = System.currentTimeMillis();
            Logger.m12713i(FastDecoder.THREAD_TAG, "startDecodeWithMediaTool " + this.this$0.mStartMediaToolTime);
            this.pcmFileIndex = 0;
            this.mDecodeFileSize = 0L;
            this.mOutputStream = getNextOutputStream();
            this.mPendingByteBufferForResampleList = new LinkedBlockingDeque<>(3);
            if (this.mResampleHandlerThread == null) {
                Logger.m12710d(FastDecoder.THREAD_TAG, "notify pending convert");
                ResampleHandlerThread resampleHandlerThread = new ResampleHandlerThread();
                this.mResampleHandlerThread = resampleHandlerThread;
                Intrinsics.checkNotNull(resampleHandlerThread);
                resampleHandlerThread.start();
            }
            MediaTool mediaTool = this.mMediaTool;
            if (mediaTool != null) {
                Intrinsics.checkNotNull(mediaTool);
                mediaTool.deinit();
                this.mMediaTool = null;
            }
            Logger.m12713i(FastDecoder.THREAD_TAG, "create new MediaTool");
            Looper looperMyLooper = Looper.myLooper();
            Intrinsics.checkNotNull(looperMyLooper);
            final FastDecoder fastDecoder = this.this$0;
            Handler handler = new Handler(looperMyLooper, new Handler.Callback() { // from class: com.samsung.android.support.senl.nt.stt.base.audio.a
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return FastDecoder.FastDecoderThread.startDecodeWithMediaTool$lambda$0(this.f7860a, fastDecoder, message);
                }
            });
            this.mMediaToolHandler = handler;
            MediaTool mediaTool2 = new MediaTool(handler);
            this.mMediaTool = mediaTool2;
            Intrinsics.checkNotNull(mediaTool2);
            mediaTool2.decode(this.mMediaPath);
            FastDecoder fastDecoder2 = this.this$0;
            fastDecoder2.mMediaToolTime = (System.currentTimeMillis() - this.this$0.mStartMediaToolTime) + fastDecoder2.mMediaToolTime;
            this.this$0.mStartMediaToolTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean startDecodeWithMediaTool$lambda$0(FastDecoderThread fastDecoderThread, FastDecoder fastDecoder, Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (fastDecoderThread.isCancel) {
                Logger.m12713i(FastDecoder.THREAD_TAG, fastDecoder.mSession + " is cancelled - mMediaToolHandler");
                fastDecoderThread.cancelFastDecoder();
                return true;
            }
            AbstractC11014a.m12327l(msg.what, "MediaToolHandler CODE ", FastDecoder.THREAD_TAG);
            int i = msg.what;
            if (i == 3) {
                fastDecoder.mStartMediaToolTime = System.currentTimeMillis();
                AbstractC11014a.m12327l(msg.arg1, "MediaToolHandler MT_DECODE_DONE  - Size : ", FastDecoder.THREAD_TAG);
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.nio.ByteBuffer");
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                int i2 = msg.arg1;
                fastDecoderThread.mBuffer = null;
                if (i2 > 0) {
                    fastDecoderThread.mDecodeFileSize += (long) i2;
                    try {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
                        fastDecoderThread.mBuffer = byteBufferAllocate;
                        if (byteBufferAllocate == null) {
                            Logger.m12711e(FastDecoder.THREAD_TAG, fastDecoder.mSession + "handleMessage mBuffer is null after allocation");
                            return false;
                        }
                        Intrinsics.checkNotNull(byteBufferAllocate);
                        byteBufferAllocate.order(byteBuffer.order());
                        ByteBuffer byteBuffer2 = fastDecoderThread.mBuffer;
                        Intrinsics.checkNotNull(byteBuffer2);
                        byteBuffer2.put(byteBuffer);
                    } catch (OutOfMemoryError e) {
                        Logger.m12711e(FastDecoder.THREAD_TAG, fastDecoder.mSession + "handleMessage OutOfMemoryError mBuffer" + e);
                        fastDecoderThread.cancelFastDecoder();
                        return false;
                    }
                }
                Logger.m12713i(FastDecoder.THREAD_TAG, "Decode file size total: " + fastDecoderThread.mDecodeFileSize);
                Handler handler = fastDecoderThread.mBufferDequeHandler;
                if (handler != null) {
                    Intrinsics.checkNotNull(handler);
                    handler.sendEmptyMessage(101);
                }
                MediaTool mediaTool = fastDecoderThread.mMediaTool;
                if (mediaTool != null) {
                    Intrinsics.checkNotNull(mediaTool);
                    mediaTool.deinit();
                }
                fastDecoder.mMediaToolTime = (System.currentTimeMillis() - fastDecoder.mStartMediaToolTime) + fastDecoder.mMediaToolTime;
            } else if (i == 4) {
                fastDecoder.mMediaToolTime = (System.currentTimeMillis() - fastDecoder.mStartMediaToolTime) + fastDecoder.mMediaToolTime;
                fastDecoder.mStartMediaToolTime = System.currentTimeMillis();
                AbstractC11014a.m12327l(msg.arg1, "MediaToolHandler MT_DECODE_DONE_NEXT_READY  - Size : ", FastDecoder.THREAD_TAG);
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.nio.ByteBuffer");
                ByteBuffer byteBuffer3 = (ByteBuffer) obj2;
                int i4 = msg.arg1;
                fastDecoderThread.mBuffer = null;
                if (i4 > 0) {
                    fastDecoderThread.mDecodeFileSize += (long) i4;
                    try {
                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i4);
                        fastDecoderThread.mBuffer = byteBufferAllocate2;
                        if (byteBufferAllocate2 == null) {
                            Logger.m12711e(FastDecoder.THREAD_TAG, fastDecoder.mSession + "handleMessage mBuffer is null after allocation");
                            return false;
                        }
                        Intrinsics.checkNotNull(byteBufferAllocate2);
                        byteBufferAllocate2.order(byteBuffer3.order());
                        ByteBuffer byteBuffer4 = fastDecoderThread.mBuffer;
                        Intrinsics.checkNotNull(byteBuffer4);
                        byteBuffer4.put(byteBuffer3);
                    } catch (OutOfMemoryError e2) {
                        Logger.m12711e(FastDecoder.THREAD_TAG, fastDecoder.mSession + "handleMessage OutOfMemoryError " + e2);
                        fastDecoderThread.cancelFastDecoder();
                        return false;
                    }
                }
                Handler handler2 = fastDecoderThread.mBufferDequeHandler;
                if (handler2 != null) {
                    Intrinsics.checkNotNull(handler2);
                    handler2.sendEmptyMessage(100);
                }
            } else if (i == 5) {
                fastDecoder.mStartMediaToolTime = System.currentTimeMillis();
                fastDecoderThread.handleMediaToolError(msg.arg1);
                fastDecoder.mMediaToolTime = (System.currentTimeMillis() - fastDecoder.mStartMediaToolTime) + fastDecoder.mMediaToolTime;
            }
            return false;
        }

        public final void cancelFastDecoder() {
            Looper looper = this.mLooper;
            if (looper != null) {
                Intrinsics.checkNotNull(looper);
                looper.quit();
                this.mLooper = null;
            }
            releaseBuffer();
            MediaTool mediaTool = this.mMediaTool;
            if (mediaTool != null) {
                Intrinsics.checkNotNull(mediaTool);
                mediaTool.deinit();
                this.mMediaTool = null;
            }
            this.mMediaToolHandler = null;
            interrupt();
        }

        @Nullable
        public final Handler getMBufferDequeHandler() {
            return this.mBufferDequeHandler;
        }

        public final void releaseBuffer() {
            ByteBuffer byteBuffer = this.mBuffer;
            if (byteBuffer != null) {
                Intrinsics.checkNotNull(byteBuffer);
                byteBuffer.clear();
                this.mBuffer = null;
            }
            LinkedBlockingDeque<ByteBuffer> linkedBlockingDeque = this.mPendingByteBufferForResampleList;
            if (linkedBlockingDeque != null) {
                Intrinsics.checkNotNull(linkedBlockingDeque);
                linkedBlockingDeque.clear();
                this.mPendingByteBufferForResampleList = null;
            }
            this.mBufferDequeHandler = null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            final Looper looperMyLooper = Looper.myLooper();
            this.mLooper = looperMyLooper;
            try {
                Intrinsics.checkNotNull(looperMyLooper);
                this.mBufferDequeHandler = new Handler(looperMyLooper) { // from class: com.samsung.android.support.senl.nt.stt.base.audio.FastDecoder$FastDecoderThread$run$1
                    @Override // android.os.Handler
                    public void handleMessage(Message msg) {
                        Intrinsics.checkNotNullParameter(msg, "msg");
                        this.this$0.handleDequeHandleMessage(msg);
                    }
                };
                startDecodeWithMediaTool();
            } catch (Exception e) {
                Logger.m12711e(FastDecoder.THREAD_TAG, "decode error: " + e);
            }
            Looper.loop();
        }

        public final void setCancelFastDecoder() {
            this.isCancel = true;
            ResampleHandlerThread resampleHandlerThread = this.mResampleHandlerThread;
            if (resampleHandlerThread != null) {
                Intrinsics.checkNotNull(resampleHandlerThread);
                resampleHandlerThread.setCancelResample();
            }
            interrupt();
        }

        public final void setMBufferDequeHandler(@Nullable Handler handler) {
            this.mBufferDequeHandler = handler;
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder$FastDecoderThread$ResampleHandlerThread;", "Ljava/lang/Thread;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder$FastDecoderThread;)V", "isCancelResample", "", "mThreadId", "", "mResampleHandler", "Landroid/os/Handler;", "mLooper", "Landroid/os/Looper;", "run", "", "handleResampleMessage", "msg", "Landroid/os/Message;", "initResampleJni", "sendMessage", "", "resample", "buf", "Ljava/nio/ByteBuffer;", "setCancelResample", "cancelResampleThread", "handleOutputEOS", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public final class ResampleHandlerThread extends Thread {
            private boolean isCancelResample;

            @Nullable
            private Looper mLooper;

            @Nullable
            private Handler mResampleHandler;
            private long mThreadId;

            public ResampleHandlerThread() {
            }

            private final void cancelResampleThread() {
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "handle cancle - Tid:" + this.mThreadId);
                if (FastDecoder.mResampleJNI != null) {
                    ResampleJNI resampleJNI = FastDecoder.mResampleJNI;
                    Intrinsics.checkNotNull(resampleJNI);
                    resampleJNI.destroy(this.mThreadId);
                    FastDecoder.mResampleJNI = null;
                }
                ConcurrentHashMap concurrentHashMap = FastDecoder.mFastDecoderMap;
                if (concurrentHashMap != null) {
                }
                if (FastDecoderThread.this.mPendingByteBufferForResampleList != null) {
                    LinkedBlockingDeque linkedBlockingDeque = FastDecoderThread.this.mPendingByteBufferForResampleList;
                    Intrinsics.checkNotNull(linkedBlockingDeque);
                    linkedBlockingDeque.clear();
                    FastDecoderThread.this.mPendingByteBufferForResampleList = null;
                }
                this.mResampleHandler = null;
                Looper looper = this.mLooper;
                if (looper != null) {
                    looper.quit();
                }
                this.mLooper = null;
                interrupt();
            }

            private final void handleOutputEOS() {
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "handlerOutputEOS");
                try {
                    if (FastDecoderThread.this.mOutputStream != null) {
                        FileOutputStream fileOutputStream = FastDecoderThread.this.mOutputStream;
                        Intrinsics.checkNotNull(fileOutputStream);
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    Logger.m12711e(FastDecoder.RESAMPLE_TAG, e.toString());
                }
                if (FastDecoder.mResampleJNI != null) {
                    Logger.m12713i(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + " destroy  - Tid: " + this.mThreadId);
                    ResampleJNI resampleJNI = FastDecoder.mResampleJNI;
                    Intrinsics.checkNotNull(resampleJNI);
                    resampleJNI.destroy(this.mThreadId);
                }
                FastDecoderThread.this.this$0.mTotalTime = System.currentTimeMillis() - FastDecoderThread.this.this$0.mStartDecoderTime;
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "Decoder total time: " + FastDecoderThread.this.this$0.mTotalTime);
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "MediaTool time: " + FastDecoderThread.this.this$0.mMediaToolTime);
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "Resample time: " + FastDecoderThread.this.this$0.mResampleTime);
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "WriteFile time: " + FastDecoderThread.this.this$0.mWriteTime);
                FastDecoderThread.this.mMediaTool = null;
                if (FastDecoderThread.this.this$0.mDecoderListener != null) {
                    OnDecoderListener onDecoderListener = FastDecoderThread.this.this$0.mDecoderListener;
                    Intrinsics.checkNotNull(onDecoderListener);
                    onDecoderListener.onDecodeComplete(FastDecoderThread.this.mPcmFileName);
                }
                cancelResampleThread();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void handleResampleMessage(Message msg) {
                int i = msg.what;
                if (i == 1) {
                    resample();
                    if (this.isCancelResample) {
                        Logger.m12714w(FastDecoder.RESAMPLE_TAG, "handle cancel in ResampleHandlerThread - Tid: " + this.mThreadId);
                        cancelResampleThread();
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    return;
                }
                resample();
                if (!this.isCancelResample) {
                    handleOutputEOS();
                    return;
                }
                Logger.m12714w(FastDecoder.RESAMPLE_TAG, "handle cancel in ResampleHandlerThread - Tid: " + this.mThreadId);
                cancelResampleThread();
            }

            private final void initResampleJni() {
                FastDecoderThread.this.this$0.mStartResampleTime = System.currentTimeMillis();
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + " initResampleJni - Tid: " + this.mThreadId);
                if (FastDecoder.mResampleJNI == null) {
                    FastDecoder.mResampleJNI = new ResampleJNI();
                }
                ResampleJNI resampleJNI = FastDecoder.mResampleJNI;
                Intrinsics.checkNotNull(resampleJNI);
                resampleJNI.create(this.mThreadId);
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(FastDecoderThread.this.mMediaPath);
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(0);
                    Intrinsics.checkNotNullExpressionValue(trackFormat, "getTrackFormat(...)");
                    int integer = trackFormat.getInteger("sample-rate");
                    int integer2 = trackFormat.getInteger("channel-count");
                    Logger.m12713i(FastDecoder.RESAMPLE_TAG, " BitRate = " + trackFormat.getInteger("bitrate") + " : SampleRate = " + integer + " : ChannelCount = " + integer2);
                    Logger.m12713i(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + " initResampleJni - Tid: " + this.mThreadId);
                    if (integer == 44100) {
                        ResampleJNI resampleJNI2 = FastDecoder.mResampleJNI;
                        Intrinsics.checkNotNull(resampleJNI2);
                        resampleJNI2.init(3, 7, 1, 0, this.mThreadId);
                    } else {
                        ResampleJNI resampleJNI3 = FastDecoder.mResampleJNI;
                        Intrinsics.checkNotNull(resampleJNI3);
                        resampleJNI3.init(3, 8, 1, 0, this.mThreadId);
                    }
                    FastDecoder fastDecoder = FastDecoderThread.this.this$0;
                    fastDecoder.mResampleTime = (System.currentTimeMillis() - FastDecoderThread.this.this$0.mStartResampleTime) + fastDecoder.mResampleTime;
                } catch (Exception e) {
                    Logger.m12711e(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + " mExtractor - Tid: " + this.mThreadId + " error initResampleJni: " + e.getMessage());
                }
            }

            private final void resample() {
                if (FastDecoderThread.this.mPendingByteBufferForResampleList == null) {
                    return;
                }
                FastDecoderThread.this.this$0.mStartResampleTime = System.currentTimeMillis();
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "resample ");
                LinkedBlockingDeque linkedBlockingDeque = FastDecoderThread.this.mPendingByteBufferForResampleList;
                Intrinsics.checkNotNull(linkedBlockingDeque);
                ByteBuffer byteBuffer = (ByteBuffer) linkedBlockingDeque.poll();
                if (byteBuffer == null) {
                    return;
                }
                resample(byteBuffer);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                this.mThreadId = Thread.currentThread().getId();
                initResampleJni();
                Logger.m12713i(FastDecoder.RESAMPLE_TAG, "run ResampleHandlerThread - Tid: " + this.mThreadId);
                if (FastDecoderThread.this.mPendingByteBufferForResampleList != null) {
                    do {
                        LinkedBlockingDeque linkedBlockingDeque = FastDecoderThread.this.mPendingByteBufferForResampleList;
                        Intrinsics.checkNotNull(linkedBlockingDeque);
                        if (linkedBlockingDeque.size() > 0) {
                            resample();
                        }
                    } while (!this.isCancelResample);
                    Logger.m12714w(FastDecoder.RESAMPLE_TAG, "handle cancel in ResampleHandlerThread - Tid: " + this.mThreadId);
                    cancelResampleThread();
                    return;
                }
                Looper.prepare();
                final Looper looperMyLooper = Looper.myLooper();
                this.mLooper = looperMyLooper;
                Intrinsics.checkNotNull(looperMyLooper);
                this.mResampleHandler = new Handler(looperMyLooper) { // from class: com.samsung.android.support.senl.nt.stt.base.audio.FastDecoder$FastDecoderThread$ResampleHandlerThread$run$1
                    @Override // android.os.Handler
                    public void handleMessage(Message msg) {
                        Intrinsics.checkNotNullParameter(msg, "msg");
                        this.this$0.handleResampleMessage(msg);
                    }
                };
                Looper.loop();
            }

            public final void sendMessage(int msg) {
                Handler handler = this.mResampleHandler;
                if (handler != null) {
                    Intrinsics.checkNotNull(handler);
                    handler.sendEmptyMessage(msg);
                }
            }

            public final void setCancelResample() {
                this.isCancelResample = true;
            }

            private final void resample(ByteBuffer buf) {
                if (FastDecoder.mResampleJNI == null) {
                    Logger.m12711e(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + " mResampleJNI = null");
                    return;
                }
                buf.flip();
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                buf.order(byteOrder);
                int iLimit = buf.limit();
                try {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iLimit);
                    Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
                    byteBufferAllocate.order(byteOrder);
                    int i = iLimit / 2;
                    short[] sArr = new short[i];
                    short[] sArr2 = new short[i];
                    buf.asShortBuffer().get(sArr);
                    Logger.m12713i(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + " resample");
                    ResampleJNI resampleJNI = FastDecoder.mResampleJNI;
                    Intrinsics.checkNotNull(resampleJNI);
                    int iExe = resampleJNI.exe(sArr2, sArr, i, this.mThreadId);
                    FastDecoder fastDecoder = FastDecoderThread.this.this$0;
                    fastDecoder.mResampleTime = (System.currentTimeMillis() - FastDecoderThread.this.this$0.mStartResampleTime) + fastDecoder.mResampleTime;
                    FastDecoderThread.this.this$0.mStartWriteTime = System.currentTimeMillis();
                    if (iExe > 0) {
                        byteBufferAllocate.asShortBuffer().put(sArr2);
                        byteBufferAllocate.position(0);
                        byteBufferAllocate.limit(iExe * 2);
                        try {
                            if (FastDecoderThread.this.mOutputStream == null) {
                                FastDecoderThread fastDecoderThread = FastDecoderThread.this;
                                fastDecoderThread.mOutputStream = fastDecoderThread.getNextOutputStream();
                            }
                            if (FastDecoderThread.this.mOutputStream != null) {
                                FileOutputStream fileOutputStream = FastDecoderThread.this.mOutputStream;
                                Intrinsics.checkNotNull(fileOutputStream);
                                fileOutputStream.getChannel().write(byteBufferAllocate);
                            }
                        } catch (IOException e) {
                            Logger.m12711e(FastDecoder.RESAMPLE_TAG, e.toString());
                        }
                    }
                    FastDecoderThread.this.this$0.mWriteTime = System.currentTimeMillis() - FastDecoderThread.this.this$0.mStartWriteTime;
                } catch (OutOfMemoryError e2) {
                    Logger.m12711e(FastDecoder.RESAMPLE_TAG, FastDecoderThread.this.this$0.mSession + "OutOfMemoryError " + e2);
                    this.isCancelResample = true;
                }
            }
        }
    }
}
