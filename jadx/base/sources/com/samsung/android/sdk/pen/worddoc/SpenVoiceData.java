package com.samsung.android.sdk.pen.worddoc;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\nJ\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u0019J\b\u00100\u001a\u00020\u0019H\u0004J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0005H\u0002J\u0011\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u0005H\u0082 J\u001b\u00105\u001a\u00020*2\u0006\u00104\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0082 J\u0011\u00106\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0005H\u0082 J\u001b\u00107\u001a\u00020*2\u0006\u00104\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0082 J\u0011\u00108\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0005H\u0082 J\u001b\u00109\u001a\u00020*2\u0006\u00104\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0082 J\u0011\u0010:\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0005H\u0082 J\u0019\u0010;\u001a\u00020*2\u0006\u00104\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020 H\u0082 J\u0011\u0010<\u001a\u00020 2\u0006\u00104\u001a\u00020\u0005H\u0082 J\u0019\u0010=\u001a\u00020*2\u0006\u00104\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020 H\u0082 J\u0011\u0010>\u001a\u00020 2\u0006\u00104\u001a\u00020\u0005H\u0082 J\u0019\u0010?\u001a\u00020*2\u0006\u00104\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0082 J!\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0006\u00104\u001a\u00020\u0005H\u0082 R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR(\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR%\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "", "<init>", "()V", "value", "", "mHandle", "getMHandle", "()I", "title", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "time", DBSchema.DocumentThumbnail.PLAY_TIME, "getPlayTime", "setPlayTime", "path", "attachedFile", "getAttachedFile", "setAttachedFile", "attachFile", "", "voicePropertyList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData$VoiceProperty;", "Lkotlin/collections/ArrayList;", "getVoicePropertyList", "()Ljava/util/ArrayList;", "", "creationTime", "getCreationTime", "()J", "setCreationTime", "(J)V", "recordingTime", "getRecordingTime", "setRecordingTime", "equals", "", "o", "start", "pause", "resume", "stop", "finalize", "throwUncheckedException", "errno", "VoiceData_finalize", "handle", "VoiceData_setName", "VoiceData_getName", "VoiceData_setPlayTime", "VoiceData_getPlayTime", "VoiceData_attachFile", "VoiceData_getAttachedFile", "VoiceData_setCreationTime", "VoiceData_getCreationTime", "VoiceData_setRecordingTime", "VoiceData_getRecordingTime", "VoiceData_setAction", "action", "VoiceData_getVoicePropertyList", "VoiceProperty", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenVoiceData {
    private int mHandle = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData$VoiceProperty;", "", "<init>", "()V", "action", "", "timeStamp", "", "getTimeStamp", "()J", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class VoiceProperty {
        public static final int VOICE_ACTION_NONE = 0;
        public static final int VOICE_ACTION_PAUSE = 2;
        public static final int VOICE_ACTION_RESUME = 3;
        public static final int VOICE_ACTION_START = 1;
        public static final int VOICE_ACTION_STOP = 4;

        @JvmField
        public final int action;
        private final long timeStamp;

        public final long getTimeStamp() {
            return this.timeStamp;
        }
    }

    private final native boolean VoiceData_attachFile(int handle, String path);

    private final native boolean VoiceData_finalize(int handle);

    private final native String VoiceData_getAttachedFile(int handle);

    private final native long VoiceData_getCreationTime(int handle);

    private final native String VoiceData_getName(int handle);

    private final native String VoiceData_getPlayTime(int handle);

    private final native long VoiceData_getRecordingTime(int handle);

    private final native ArrayList<VoiceProperty> VoiceData_getVoicePropertyList(int handle);

    private final native boolean VoiceData_setAction(int handle, int action);

    private final native boolean VoiceData_setCreationTime(int handle, long time);

    private final native boolean VoiceData_setName(int handle, String title);

    private final native boolean VoiceData_setPlayTime(int handle, String time);

    private final native boolean VoiceData_setRecordingTime(int handle, long time);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenVoiceData(" + this + ") is already closed");
    }

    public final void attachFile(@Nullable String path) {
        setAttachedFile(path);
    }

    public boolean equals(@Nullable Object o) {
        return (o instanceof SpenVoiceData) && this.mHandle == ((SpenVoiceData) o).mHandle;
    }

    public final void finalize() {
        VoiceData_finalize(this.mHandle);
        this.mHandle = -1;
    }

    @Nullable
    public final String getAttachedFile() {
        return VoiceData_getAttachedFile(this.mHandle);
    }

    public final long getCreationTime() {
        return VoiceData_getCreationTime(this.mHandle);
    }

    public final int getMHandle() {
        return this.mHandle;
    }

    @Nullable
    public final String getName() {
        return VoiceData_getName(this.mHandle);
    }

    @Nullable
    public final String getPlayTime() {
        return VoiceData_getPlayTime(this.mHandle);
    }

    public final long getRecordingTime() {
        return VoiceData_getRecordingTime(this.mHandle);
    }

    @Nullable
    public final ArrayList<VoiceProperty> getVoicePropertyList() {
        return VoiceData_getVoicePropertyList(this.mHandle);
    }

    public final void pause() {
        if (VoiceData_setAction(this.mHandle, 2)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void resume() {
        if (VoiceData_setAction(this.mHandle, 3)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAttachedFile(@Nullable String str) {
        if (VoiceData_attachFile(this.mHandle, str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCreationTime(long j) {
        if (VoiceData_setCreationTime(this.mHandle, j)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setName(@Nullable String str) {
        if (VoiceData_setName(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPlayTime(@Nullable String str) {
        if (VoiceData_setPlayTime(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRecordingTime(long j) {
        if (VoiceData_setRecordingTime(this.mHandle, j)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void start() {
        if (VoiceData_setAction(this.mHandle, 1)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void stop() {
        if (VoiceData_setAction(this.mHandle, 4)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
