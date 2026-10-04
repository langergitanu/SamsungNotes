package com.samsung.android.sdk.composer.document.sdoc;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import java.util.ArrayList;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b*\b\u0016\u0018\u0000 f2\u00020\u0001:\u0001fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u00109\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,j\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u0001`.2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0003H\u0016J\u0012\u0010<\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010>\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\u0006\u0010?\u001a\u00020=J\u0006\u0010@\u001a\u000207J\u0006\u0010A\u001a\u00020\u0003J\b\u0010B\u001a\u00020=H\u0014J\u0013\u0010C\u001a\u0002072\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010E\u001a\u00020=2\b\u0010F\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\u0003H\u0002J\u0011\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0011\u0010K\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u001b\u0010L\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0082 J\u0011\u0010M\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0019\u0010N\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0082 J\u0011\u0010O\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0019\u0010P\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0082 J\u0011\u0010Q\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u001b\u0010R\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0082 J\u0011\u0010S\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0019\u0010T\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0082 J\u0011\u0010U\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0019\u0010V\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0082 J\u0011\u0010W\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0019\u0010X\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0082 J\u0011\u0010Y\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0011\u0010Z\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0011\u0010[\u001a\u0002072\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0011\u0010\\\u001a\u00020=2\u0006\u0010J\u001a\u00020\u0003H\u0082 J-\u0010]\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.H\u0082 J!\u0010_\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.2\u0006\u0010J\u001a\u00020\u0003H\u0082 J9\u0010`\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,j\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u0001`.2\u0006\u0010J\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0003H\u0082 J\u001b\u0010a\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010-H\u0082 J\u001b\u0010b\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010-H\u0082 J\u0019\u0010c\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0082 J\u0011\u0010d\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0082 J\u0011\u0010e\u001a\u0002072\u0006\u0010J\u001a\u00020\u0003H\u0082 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0005R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u0005R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u0005R$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u0005R$\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u0005R(\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R$\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u0005RL\u0010/\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.2\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b5\u0010\tR\u0011\u00106\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b6\u00108¨\u0006g"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "", "mType", "", "<init>", "(I)V", "mHandle", "type", "getType", "()I", "path", "", "thumbnailPath", "getThumbnailPath", "()Ljava/lang/String;", "setThumbnailPath", "(Ljava/lang/String;)V", "id", "taskId", "getTaskId", "setTaskId", TextConst.KEY_PARAM_NUMBER, "taskNumber", "getTaskNumber", "setTaskNumber", "style", "taskStyle", "getTaskStyle", "setTaskStyle", "state", "getState", "setState", "align", "alignment", "getAlignment", "setAlignment", "text", "getText", "setText", "height", "itemHeight", "getItemHeight", "setItemHeight", "spanList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/document/sdoc/textspan/SpenTextSpan;", "Lkotlin/collections/ArrayList;", "span", "getSpan", "()Ljava/util/ArrayList;", "setSpan", "(Ljava/util/ArrayList;)V", "length", "getLength", "isChanged", "", "()Z", "findSpan", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "removeSpan", "", "appendSpan", "clearChangedFlag", "prepareHistoryForSaving", "getHandle", "finalize", "equals", "o", "copy", "source", "throwUncheckedException", "errno", "ContentBase_finalize", "handle", "ContentBase_getType", "ContentBase_setThumbnailPath", "ContentBase_getThumbnailPath", "ContentBase_setTaskId", "ContentBase_getTaskId", "ContentBase_setTaskStyle", "ContentBase_getTaskStyle", "ContentBase_setText", "ContentBase_getText", "ContentBase_setItemHeight", "ContentBase_getItemHeight", "ContentBase_setState", "ContentBase_getState", "ContentBase_setTaskNumber", "ContentBase_getTaskNumber", "ContentBase_getLength", "ContentBase_isChanged", "ContentBase_clearChangedFlag", "ContentBase_setSpan", XmlErrorCodes.LIST, "ContentBase_getSpan", "ContentBase_findSpan", "ContentBase_removeSpan", "ContentBase_appendSpan", "ContentBase_setAlignment", "ContentBase_getAlignment", "ContentBase_prepareHistoryForSaving", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenContentBase {
    public static final int ALIGN_BOTH = 3;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_NONE = 4;
    public static final int ALIGN_RIGHT = 1;
    public static final int STATE_CANCELED = 7;
    public static final int STATE_DONE = 4;
    public static final int STATE_EXCEPTION = 6;
    public static final int STATE_FAIL = 5;
    public static final int STATE_INIT = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_READY = 2;
    public static final int STATE_RUNNING = 3;
    public static final int TASK_BULLET = 3;
    public static final int TASK_DONE = 2;
    public static final int TASK_NONE = 0;
    public static final int TASK_NUMBER = 4;
    public static final int TASK_TODO = 1;
    public static final int TYPE_DRAWING = 4;
    public static final int TYPE_HANDWRITING = 3;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_MAP = 6;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_PDF = 8;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_VIDEO = 9;
    public static final int TYPE_VOICE = 7;
    public static final int TYPE_WEB = 5;
    private int mHandle = -1;
    private final int mType;

    public SpenContentBase(int i) {
        this.mType = i;
    }

    private final native boolean ContentBase_appendSpan(int handle, SpenTextSpan span);

    private final native void ContentBase_clearChangedFlag(int handle);

    private final native void ContentBase_finalize(int handle);

    private final native ArrayList<SpenTextSpan> ContentBase_findSpan(int handle, int startIndex, int endIndex);

    private final native int ContentBase_getAlignment(int handle);

    private final native int ContentBase_getItemHeight(int handle);

    private final native int ContentBase_getLength(int handle);

    private final native ArrayList<SpenTextSpan> ContentBase_getSpan(int handle);

    private final native int ContentBase_getState(int handle);

    private final native int ContentBase_getTaskId(int handle);

    private final native int ContentBase_getTaskNumber(int handle);

    private final native int ContentBase_getTaskStyle(int handle);

    private final native String ContentBase_getText(int handle);

    private final native String ContentBase_getThumbnailPath(int handle);

    private final native int ContentBase_getType(int handle);

    private final native boolean ContentBase_isChanged(int handle);

    private final native boolean ContentBase_prepareHistoryForSaving(int handle);

    private final native boolean ContentBase_removeSpan(int handle, SpenTextSpan span);

    private final native boolean ContentBase_setAlignment(int handle, int align);

    private final native boolean ContentBase_setItemHeight(int handle, int height);

    private final native boolean ContentBase_setSpan(int handle, ArrayList<SpenTextSpan> list);

    private final native boolean ContentBase_setState(int handle, int state);

    private final native boolean ContentBase_setTaskId(int handle, int id);

    private final native boolean ContentBase_setTaskNumber(int handle, int number);

    private final native boolean ContentBase_setTaskStyle(int handle, int state);

    private final native boolean ContentBase_setText(int handle, String text);

    private final native boolean ContentBase_setThumbnailPath(int handle, String path);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentBase(" + this + ") is already closed");
    }

    public void appendSpan(@Nullable SpenTextSpan span) {
        if (ContentBase_appendSpan(this.mHandle, span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void clearChangedFlag() {
        ContentBase_clearChangedFlag(this.mHandle);
    }

    public void copy(@Nullable SpenContentBase source) {
    }

    public boolean equals(@Nullable Object o) {
        return (o instanceof SpenContentBase) && this.mHandle == ((SpenContentBase) o).mHandle;
    }

    public void finalize() {
        ContentBase_finalize(this.mHandle);
        this.mHandle = -1;
    }

    @Nullable
    public ArrayList<SpenTextSpan> findSpan(int startIndex, int endIndex) {
        return ContentBase_findSpan(this.mHandle, startIndex, endIndex);
    }

    public final int getAlignment() {
        return ContentBase_getAlignment(this.mHandle);
    }

    /* JADX INFO: renamed from: getHandle, reason: from getter */
    public final int getMHandle() {
        return this.mHandle;
    }

    public final int getItemHeight() {
        return ContentBase_getItemHeight(this.mHandle);
    }

    public final int getLength() {
        return ContentBase_getLength(this.mHandle);
    }

    @Nullable
    public ArrayList<SpenTextSpan> getSpan() {
        return ContentBase_getSpan(this.mHandle);
    }

    public final int getState() {
        return ContentBase_getState(this.mHandle);
    }

    public final int getTaskId() {
        return ContentBase_getTaskId(this.mHandle);
    }

    public final int getTaskNumber() {
        return ContentBase_getTaskNumber(this.mHandle);
    }

    public final int getTaskStyle() {
        return ContentBase_getTaskStyle(this.mHandle);
    }

    @Nullable
    public final String getText() {
        return ContentBase_getText(this.mHandle);
    }

    @Nullable
    public final String getThumbnailPath() {
        return ContentBase_getThumbnailPath(this.mHandle);
    }

    public final int getType() {
        return ContentBase_getType(this.mHandle);
    }

    public final boolean isChanged() {
        return ContentBase_isChanged(this.mHandle);
    }

    public final boolean prepareHistoryForSaving() {
        boolean zContentBase_prepareHistoryForSaving = ContentBase_prepareHistoryForSaving(this.mHandle);
        if (!zContentBase_prepareHistoryForSaving) {
            throwUncheckedException(SpenError.getError());
        }
        return zContentBase_prepareHistoryForSaving;
    }

    public void removeSpan(@Nullable SpenTextSpan span) {
        if (ContentBase_removeSpan(this.mHandle, span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAlignment(int i) {
        if (ContentBase_setAlignment(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setItemHeight(int i) {
        if (ContentBase_setItemHeight(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setSpan(@Nullable ArrayList<SpenTextSpan> arrayList) {
        if (ContentBase_setSpan(this.mHandle, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setState(int i) {
        if (ContentBase_setState(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTaskId(int i) {
        if (ContentBase_setTaskId(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTaskNumber(int i) {
        if (ContentBase_setTaskNumber(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTaskStyle(int i) {
        if (ContentBase_setTaskStyle(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setText(@Nullable String str) {
        if (ContentBase_setText(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (ContentBase_setThumbnailPath(this.mHandle, str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }
}
