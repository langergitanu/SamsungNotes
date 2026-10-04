package com.samsung.mmfw.mediatool;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.samsung.mmfw.mediatool.MediaToolWrapper;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MediaTool extends Thread {
    static String LOGTAG = "MediaTool";
    public static final int MT_DECODE_DONE = 3;
    public static final int MT_DECODE_DONE_NEXT_READY = 4;
    public static final int MT_QUIT_DONE = 5;
    public static final int MT_UPDATE_TIME = 6;
    private static final String MediaTool_version = "1.4.5";
    private String Songname;
    private Handler handler;
    private boolean isOpen;
    private long mBufferSize;
    private long mEndTime;
    private int mMode;
    private int mOutputChannelCount;
    private long mStartTime;
    private MediaToolWrapper smtujni;

    public MediaTool(Handler handler) {
        this.isOpen = false;
        this.handler = handler;
        this.mMode = 0;
        this.mBufferSize = 15728640L;
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mOutputChannelCount = 1;
        this.smtujni = new MediaToolWrapper(this.mMode, this.mBufferSize, this.mOutputChannelCount);
        Log.i(LOGTAG, "smtu MediaTool Create, Version : 1.4.5");
    }

    public boolean decode(String str) {
        this.smtujni.decode(str, new MediaToolWrapper.ResultListener() { // from class: com.samsung.mmfw.mediatool.MediaTool.1
            @Override // com.samsung.mmfw.mediatool.MediaToolWrapper.ResultListener
            public void onDone(ByteBuffer byteBuffer, long j, int i) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = byteBuffer;
                messageObtain.arg1 = (int) j;
                if (i == 2) {
                    messageObtain.what = 4;
                } else {
                    messageObtain.what = 3;
                }
                if (MediaTool.this.handler != null) {
                    MediaTool.this.handler.sendMessage(messageObtain);
                }
            }

            @Override // com.samsung.mmfw.mediatool.MediaToolWrapper.ResultListener
            public void onError(int i) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 5;
                if (MediaTool.this.handler != null) {
                    MediaTool.this.handler.sendMessage(messageObtain);
                }
            }
        });
        return true;
    }

    public boolean decode_next() {
        Log.v(LOGTAG, "Smtu decode_next");
        this.smtujni.decode_next(new MediaToolWrapper.ResultListener() { // from class: com.samsung.mmfw.mediatool.MediaTool.3
            @Override // com.samsung.mmfw.mediatool.MediaToolWrapper.ResultListener
            public void onDone(ByteBuffer byteBuffer, long j, int i) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = byteBuffer;
                messageObtain.arg1 = (int) j;
                if (i == 2) {
                    Log.v(MediaTool.LOGTAG, "Smtu decode_next OnResultListener SMTU_NEXT_READY");
                    messageObtain.what = 4;
                } else if (i == 6) {
                    Log.v(MediaTool.LOGTAG, "Smtu decode_next OnResultListener SMTU_EXTRACT_DONE");
                    messageObtain.what = 3;
                } else if (i == 7) {
                    Log.v(MediaTool.LOGTAG, "Smtu decode_next OnResultListener SMTU_QUIT_DONE");
                    messageObtain.what = 5;
                }
                if (MediaTool.this.handler != null) {
                    MediaTool.this.handler.sendMessage(messageObtain);
                }
            }

            @Override // com.samsung.mmfw.mediatool.MediaToolWrapper.ResultListener
            public void onError(int i) {
                Log.e(MediaTool.LOGTAG, "Smtu decode_next OnResultListener onERROR" + i);
                Message messageObtain = Message.obtain();
                messageObtain.what = 5;
                messageObtain.arg1 = i;
                if (MediaTool.this.handler != null) {
                    MediaTool.this.handler.sendMessage(messageObtain);
                }
            }
        });
        return true;
    }

    public boolean deinit() {
        Log.i(LOGTAG, "smtu MediaTool deinit");
        this.smtujni.deinit();
        return true;
    }

    public boolean decode(String str, long j, long j2) {
        Log.i(LOGTAG, "decode filepath : " + str + " Start : " + j + " End : " + j2);
        if ((j2 != 0 && j >= j2) || j < 0 || j2 < 0) {
            Log.e(LOGTAG, "Smtu decode The time is wrong");
            return false;
        }
        if (j2 == 0 || j2 - j >= 1000) {
            this.smtujni.decode(str, j * 10000, j2 * 10000, new MediaToolWrapper.ResultListener() { // from class: com.samsung.mmfw.mediatool.MediaTool.2
                @Override // com.samsung.mmfw.mediatool.MediaToolWrapper.ResultListener
                public void onDone(ByteBuffer byteBuffer, long j3, int i) {
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = byteBuffer;
                    messageObtain.arg1 = (int) j3;
                    if (i == 2) {
                        messageObtain.what = 4;
                    } else {
                        messageObtain.what = 3;
                    }
                    if (MediaTool.this.handler != null) {
                        MediaTool.this.handler.sendMessage(messageObtain);
                    }
                }

                @Override // com.samsung.mmfw.mediatool.MediaToolWrapper.ResultListener
                public void onError(int i) {
                    Log.e(MediaTool.LOGTAG, "Smtu decode OnResultListener onERROR" + i);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 5;
                    if (MediaTool.this.handler != null) {
                        MediaTool.this.handler.sendMessage(messageObtain);
                    }
                }
            });
            return true;
        }
        Log.e(LOGTAG, "Smtu decode The time is small");
        return false;
    }

    public MediaTool(Handler handler, int i) {
        this.isOpen = false;
        this.handler = handler;
        this.mMode = 300;
        this.mBufferSize = 15728640 * i;
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mOutputChannelCount = i;
        this.smtujni = new MediaToolWrapper(this.mMode, this.mBufferSize, this.mOutputChannelCount);
        Log.i(LOGTAG, "smtu MediaTool Create, Version : 1.4.5");
    }

    public MediaTool(Handler handler, long j) {
        this.isOpen = false;
        this.handler = handler;
        this.mMode = 0;
        this.mBufferSize = j;
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mOutputChannelCount = 1;
        this.smtujni = new MediaToolWrapper(this.mMode, this.mBufferSize, this.mOutputChannelCount);
        Log.v(LOGTAG, "smtu MediaTool Create, Version : 1.4.5");
    }

    public MediaTool(Handler handler, long j, int i) {
        this.isOpen = false;
        this.handler = handler;
        this.mMode = 300;
        this.mBufferSize = j;
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mOutputChannelCount = i;
        this.smtujni = new MediaToolWrapper(this.mMode, this.mBufferSize, this.mOutputChannelCount);
        Log.v(LOGTAG, "smtu MediaTool Create, Version : 1.4.5");
    }
}
