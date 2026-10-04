package com.samsung.mmfw.mediatool;

import java.io.FileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MediaToolWrapper {
    public static final int ERROR_INVALID_ARG = -4;
    public static final int ERROR_INVALID_PATH = -7;
    public static final int ERROR_INVALID_STAT = -8;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED = -3;
    static String LOGTAG = "MediaTool : Wrapper";
    private static final int SMTU_ERR = -1;
    private static final int SMTU_ERR_INSUFF_MEM = -2;
    private static final int SMTU_ERR_INVALID_ARG = -4;
    private static final int SMTU_ERR_INVALID_DATA = -6;
    private static final int SMTU_ERR_INVALID_STAT = -5;
    private static final int SMTU_ERR_NOT_OPEN_FILE = -7;
    private static final int SMTU_ERR_UNKNOWN = -255;
    private static final int SMTU_ERR_UNSUPPORT = -3;
    public static final int SMTU_EXTRACT_DONE = 6;
    public static final int SMTU_NEXT_READY = 2;
    private static final int SMTU_OK = 0;
    public static final int SMTU_QUIT_DONE = 7;
    private static final int SMTU_READY = 1;
    private static boolean isNativeLibraryReady;
    private long mBufferSize;
    private int mMode;
    private int mOutputChannelCount;
    private ResultListener mListener = null;
    private int lastError = -1;
    private int mHandle = -1;
    private long mStartTime = 0;
    private long mEndTime = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onDone(ByteBuffer byteBuffer, long j, int i);

        void onError(int i);
    }

    static {
        System.loadLibrary("mediatool");
        isNativeLibraryReady = true;
    }

    public MediaToolWrapper(int i, long j, int i2) {
        this.mMode = i;
        this.mBufferSize = j;
        this.mOutputChannelCount = i2;
    }

    private native int decode(int i);

    private native int decodeNext(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int deinit(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native ByteBuffer getBuffer(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native long getBufferSize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int getErrorCode(int i);

    private native long getInfo(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int getStat(int i);

    private native int init(String str, int i, long j, long j2, long j3, int i2);

    private native int initialize(FileDescriptor fileDescriptor, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void sendErrorMessage(ResultListener resultListener, int i) {
        this.mListener = resultListener;
        this.lastError = i;
        new Thread("MediaToolWrapper thread") { // from class: com.samsung.mmfw.mediatool.MediaToolWrapper.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (MediaToolWrapper.this.mListener != null) {
                        MediaToolWrapper.this.mListener.onError(MediaToolWrapper.this.lastError);
                    }
                } catch (NullPointerException | Exception unused) {
                }
            }
        }.start();
    }

    public boolean checkFile(String str) {
        if (isNativeLibraryReady && str != null) {
            try {
                try {
                    int iInit = init(str, this.mMode, this.mBufferSize, this.mStartTime, this.mEndTime, this.mOutputChannelCount);
                    if (iInit < 0) {
                        return false;
                    }
                    deinit(iInit);
                    return true;
                } catch (Exception | UnsatisfiedLinkError unused) {
                }
            } catch (Exception unused2) {
            } catch (UnsatisfiedLinkError unused3) {
            }
        }
        return false;
    }

    public void decode(String str, ResultListener resultListener) {
        decode(str, 0L, 0L, resultListener);
    }

    public void decode_next(final ResultListener resultListener) {
        if (resultListener == null) {
            throw new RuntimeException("listener is null.");
        }
        if (!isNativeLibraryReady) {
            sendErrorMessage(resultListener, -1);
            return;
        }
        if (getStat(this.mHandle) != 2) {
            sendErrorMessage(resultListener, -8);
            return;
        }
        try {
            this.mListener = resultListener;
            int i = this.mHandle;
            if (i >= 0) {
                if (decodeNext(i) == 0) {
                    new Thread("MediaToolWrapper thread") { // from class: com.samsung.mmfw.mediatool.MediaToolWrapper.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            boolean z = false;
                            int i2 = -1;
                            while (!z) {
                                try {
                                    try {
                                        Thread.sleep(100L);
                                        MediaToolWrapper mediaToolWrapper = MediaToolWrapper.this;
                                        int stat = mediaToolWrapper.getStat(mediaToolWrapper.mHandle);
                                        if (i2 != stat) {
                                            if (stat == -4 || stat == -1) {
                                                MediaToolWrapper mediaToolWrapper2 = MediaToolWrapper.this;
                                                int errorCode = mediaToolWrapper2.getErrorCode(mediaToolWrapper2.mHandle);
                                                MediaToolWrapper mediaToolWrapper3 = MediaToolWrapper.this;
                                                mediaToolWrapper3.deinit(mediaToolWrapper3.mHandle);
                                                MediaToolWrapper.this.sendErrorMessage(resultListener, errorCode);
                                                i2 = stat;
                                                z = true;
                                            } else if (stat == 2 || stat == 6) {
                                                MediaToolWrapper mediaToolWrapper4 = MediaToolWrapper.this;
                                                ByteBuffer buffer = mediaToolWrapper4.getBuffer(mediaToolWrapper4.mHandle);
                                                MediaToolWrapper mediaToolWrapper5 = MediaToolWrapper.this;
                                                long bufferSize = mediaToolWrapper5.getBufferSize(mediaToolWrapper5.mHandle);
                                                if (MediaToolWrapper.this.mListener != null) {
                                                    MediaToolWrapper.this.mListener.onDone(buffer, bufferSize, stat);
                                                }
                                                i2 = stat;
                                                z = true;
                                            } else if (stat != 7) {
                                                i2 = stat;
                                            } else {
                                                MediaToolWrapper mediaToolWrapper6 = MediaToolWrapper.this;
                                                int errorCode2 = mediaToolWrapper6.getErrorCode(mediaToolWrapper6.mHandle);
                                                MediaToolWrapper mediaToolWrapper7 = MediaToolWrapper.this;
                                                mediaToolWrapper7.deinit(mediaToolWrapper7.mHandle);
                                                if (MediaToolWrapper.this.mListener != null) {
                                                    MediaToolWrapper.this.mListener.onDone(null, errorCode2, stat);
                                                }
                                                i2 = stat;
                                                z = true;
                                            }
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                        MediaToolWrapper mediaToolWrapper8 = MediaToolWrapper.this;
                                        mediaToolWrapper8.deinit(mediaToolWrapper8.mHandle);
                                        return;
                                    }
                                } catch (NullPointerException | Exception unused) {
                                    return;
                                }
                            }
                        }
                    }.start();
                    return;
                } else {
                    sendErrorMessage(resultListener, -1);
                    return;
                }
            }
            this.lastError = i;
            if (i == -7) {
                sendErrorMessage(resultListener, -7);
            } else if (i != -3) {
                sendErrorMessage(resultListener, -1);
            } else {
                sendErrorMessage(resultListener, -3);
            }
        } catch (Exception unused) {
        } catch (UnsatisfiedLinkError unused2) {
            sendErrorMessage(resultListener, -1);
        }
    }

    public void deinit() {
        deinit(this.mHandle);
    }

    public void finalize() {
    }

    public void reset() {
        deinit(this.mHandle);
    }

    public native String stringFromJNI();

    public void decode(String str, long j, long j2, final ResultListener resultListener) {
        if (resultListener == null) {
            throw new RuntimeException("listener is null.");
        }
        if (str == null) {
            sendErrorMessage(resultListener, -7);
            return;
        }
        if (!isNativeLibraryReady) {
            sendErrorMessage(resultListener, -1);
            return;
        }
        try {
            int iInit = init(str, this.mMode, this.mBufferSize, j, j2, this.mOutputChannelCount);
            this.mHandle = iInit;
            this.mListener = resultListener;
            if (iInit >= 0) {
                if (decode(iInit) == 0) {
                    new Thread("MediaToolWrapper thread") { // from class: com.samsung.mmfw.mediatool.MediaToolWrapper.3
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            boolean z = false;
                            int i = -1;
                            while (!z) {
                                try {
                                    try {
                                        Thread.sleep(100L);
                                        MediaToolWrapper mediaToolWrapper = MediaToolWrapper.this;
                                        int stat = mediaToolWrapper.getStat(mediaToolWrapper.mHandle);
                                        if (i != stat) {
                                            if (stat == -4 || stat == -1) {
                                                MediaToolWrapper mediaToolWrapper2 = MediaToolWrapper.this;
                                                int errorCode = mediaToolWrapper2.getErrorCode(mediaToolWrapper2.mHandle);
                                                MediaToolWrapper mediaToolWrapper3 = MediaToolWrapper.this;
                                                mediaToolWrapper3.deinit(mediaToolWrapper3.mHandle);
                                                MediaToolWrapper.this.sendErrorMessage(resultListener, errorCode);
                                                i = stat;
                                                z = true;
                                            } else if (stat == 2 || stat == 6) {
                                                MediaToolWrapper mediaToolWrapper4 = MediaToolWrapper.this;
                                                ByteBuffer buffer = mediaToolWrapper4.getBuffer(mediaToolWrapper4.mHandle);
                                                MediaToolWrapper mediaToolWrapper5 = MediaToolWrapper.this;
                                                long bufferSize = mediaToolWrapper5.getBufferSize(mediaToolWrapper5.mHandle);
                                                if (MediaToolWrapper.this.mListener != null) {
                                                    MediaToolWrapper.this.mListener.onDone(buffer, bufferSize, stat);
                                                }
                                                i = stat;
                                                z = true;
                                            } else if (stat != 7) {
                                                i = stat;
                                            } else {
                                                MediaToolWrapper mediaToolWrapper6 = MediaToolWrapper.this;
                                                int errorCode2 = mediaToolWrapper6.getErrorCode(mediaToolWrapper6.mHandle);
                                                MediaToolWrapper mediaToolWrapper7 = MediaToolWrapper.this;
                                                mediaToolWrapper7.deinit(mediaToolWrapper7.mHandle);
                                                if (MediaToolWrapper.this.mListener != null) {
                                                    MediaToolWrapper.this.mListener.onDone(null, errorCode2, stat);
                                                }
                                                i = stat;
                                                z = true;
                                            }
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                        MediaToolWrapper mediaToolWrapper8 = MediaToolWrapper.this;
                                        mediaToolWrapper8.deinit(mediaToolWrapper8.mHandle);
                                        return;
                                    }
                                } catch (NullPointerException | Exception unused) {
                                    return;
                                }
                            }
                        }
                    }.start();
                    return;
                } else {
                    sendErrorMessage(resultListener, -1);
                    return;
                }
            }
            this.lastError = iInit;
            if (iInit == -7) {
                sendErrorMessage(resultListener, -7);
            } else if (iInit != -3) {
                sendErrorMessage(resultListener, -1);
            } else {
                sendErrorMessage(resultListener, -3);
            }
        } catch (Exception unused) {
        } catch (UnsatisfiedLinkError unused2) {
            sendErrorMessage(resultListener, -1);
        }
    }

    public void decode(String str, int i, ResultListener resultListener) {
        decode(str, 0L, i, resultListener);
    }

    public void decode(FileDescriptor fileDescriptor, final ResultListener resultListener) {
        if (resultListener == null) {
            throw new RuntimeException("listener is null.");
        }
        if (fileDescriptor == null) {
            sendErrorMessage(resultListener, -4);
            return;
        }
        if (!isNativeLibraryReady) {
            sendErrorMessage(resultListener, -1);
            return;
        }
        try {
            int iInitialize = initialize(fileDescriptor, 0);
            this.mHandle = iInitialize;
            this.mListener = resultListener;
            if (iInitialize >= 0) {
                if (decode(iInitialize) == 0) {
                    new Thread("MediaToolWrapper thread") { // from class: com.samsung.mmfw.mediatool.MediaToolWrapper.4
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            boolean z = false;
                            int i = -1;
                            while (!z) {
                                try {
                                    try {
                                        Thread.sleep(100L);
                                        MediaToolWrapper mediaToolWrapper = MediaToolWrapper.this;
                                        int stat = mediaToolWrapper.getStat(mediaToolWrapper.mHandle);
                                        if (i != stat) {
                                            if (stat == -4 || stat == -1) {
                                                MediaToolWrapper.this.sendErrorMessage(resultListener, -1);
                                                i = stat;
                                                z = true;
                                            } else {
                                                if (stat == 6) {
                                                    MediaToolWrapper mediaToolWrapper2 = MediaToolWrapper.this;
                                                    ByteBuffer buffer = mediaToolWrapper2.getBuffer(mediaToolWrapper2.mHandle);
                                                    MediaToolWrapper mediaToolWrapper3 = MediaToolWrapper.this;
                                                    long bufferSize = mediaToolWrapper3.getBufferSize(mediaToolWrapper3.mHandle);
                                                    MediaToolWrapper mediaToolWrapper4 = MediaToolWrapper.this;
                                                    mediaToolWrapper4.deinit(mediaToolWrapper4.mHandle);
                                                    if (MediaToolWrapper.this.mListener != null) {
                                                        MediaToolWrapper.this.mListener.onDone(buffer, bufferSize, stat);
                                                    }
                                                } else if (stat != 7) {
                                                    i = stat;
                                                } else {
                                                    MediaToolWrapper mediaToolWrapper5 = MediaToolWrapper.this;
                                                    mediaToolWrapper5.deinit(mediaToolWrapper5.mHandle);
                                                    if (MediaToolWrapper.this.mListener != null) {
                                                        MediaToolWrapper.this.mListener.onDone(null, 0L, stat);
                                                    }
                                                }
                                                i = stat;
                                                z = true;
                                            }
                                        }
                                    } catch (NullPointerException | Exception unused) {
                                        return;
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    MediaToolWrapper mediaToolWrapper6 = MediaToolWrapper.this;
                                    mediaToolWrapper6.deinit(mediaToolWrapper6.mHandle);
                                    return;
                                }
                            }
                        }
                    }.start();
                    return;
                } else {
                    sendErrorMessage(resultListener, -1);
                    return;
                }
            }
            this.lastError = iInitialize;
            if (iInitialize == -7) {
                sendErrorMessage(resultListener, -4);
            } else if (iInitialize != -3) {
                sendErrorMessage(resultListener, -1);
            } else {
                sendErrorMessage(resultListener, -3);
            }
        } catch (Exception unused) {
        } catch (UnsatisfiedLinkError unused2) {
            sendErrorMessage(resultListener, -1);
        }
    }
}
