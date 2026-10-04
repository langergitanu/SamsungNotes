package com.samsung.android.sdk.pen.document;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b6\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0017J\u0010\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u001cH\u0002J\u0019\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001b\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u001b\u0010E\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010F\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u0019\u0010G\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0005H\u0082 J\u0011\u0010H\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u001b\u0010I\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010J\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u0019\u0010K\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082 J\u0011\u0010L\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001cH\u0082 JE\u0010M\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c22\u0010!\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#\u0018\u00010\"j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#\u0018\u0001`%H\u0082 J9\u0010N\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#0\"j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#`%2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u001b\u0010O\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010P\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u001b\u0010Q\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010R\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u0019\u0010S\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001cH\u0082 J\u0011\u0010T\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001cH\u0082 J!\u0010U\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u001cH\u0082 J\u001d\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0#2\u0006\u0010B\u001a\u00020\u001cH\u0082 J\u0019\u0010Y\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u001cH\u0082 J\u0011\u0010Z\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001cH\u0082 R(\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0006R(\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R|\u0010&\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#\u0018\u00010\"j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#\u0018\u0001`%22\u0010!\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#\u0018\u00010\"j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0#\u0018\u0001`%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR(\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR$\u00101\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R<\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0#2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u0014\u0010:\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001e¨\u0006["}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "title", "", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "time", DBSchema.DocumentThumbnail.PLAY_TIME, "getPlayTime", "setPlayTime", "isRecorded", "()Z", "setRecorded", "path", "attachedFile", "getAttachedFile", "setAttachedFile", "attachFile", "", "filePath", "state", "", "getState", "()I", "setState", "(I)V", "colorList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "backgroundGradientColors", "getBackgroundGradientColors", "()Ljava/util/ArrayList;", "setBackgroundGradientColors", "(Ljava/util/ArrayList;)V", "thumbnailPath", "getThumbnailPath", "setThumbnailPath", "body", "getBody", "setBody", "version", "getVersion", "setVersion", "colors", "dummyThumbnailColors", "getDummyThumbnailColors", "()Lkotlin/Pair;", "setDummyThumbnailColors", "(Lkotlin/Pair;)V", "type", "viewType", "getViewType", "setViewType", "getType", "throwUncheckedException", "errno", "ObjectVoice_init", "handle", "ObjectVoice_setTitle", "ObjectVoice_getTitle", "ObjectVoice_setPlayTime", "ObjectVoice_getPlayTime", "ObjectVoice_setRecorded", "ObjectVoice_isRecorded", "ObjectVoice_attachFile", "ObjectVoice_getAttachedFile", "ObjectVoice_setState", "ObjectVoice_getState", "ObjectVoice_setBackgroundGradientColors", "ObjectVoice_getBackgroundGradientColors", "ObjectVoice_setThumbnailPath", "ObjectVoice_getThumbnailPath", "ObjectVoice_setBody", "ObjectVoice_getBody", "ObjectVoice_setVersion", "ObjectVoice_getVersion", "ObjectVoice_setDummyThumbnailColors", "tintColor", "backgroundColor", "ObjectVoice_getDummyThumbnailColors", "ObjectVoice_setViewType", "ObjectVoice_getViewType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectVoice extends SpenObjectBase {
    public SpenObjectVoice() {
        super(10);
    }

    private final native boolean ObjectVoice_attachFile(int handle, String path);

    private final native String ObjectVoice_getAttachedFile(int handle);

    private final native ArrayList<Pair<Integer, Float>> ObjectVoice_getBackgroundGradientColors(int handle);

    private final native String ObjectVoice_getBody(int handle);

    private final native Pair<Integer, Integer> ObjectVoice_getDummyThumbnailColors(int handle);

    private final native String ObjectVoice_getPlayTime(int handle);

    private final native int ObjectVoice_getState(int handle);

    private final native String ObjectVoice_getThumbnailPath(int handle);

    private final native String ObjectVoice_getTitle(int handle);

    private final native int ObjectVoice_getVersion(int handle);

    private final native int ObjectVoice_getViewType(int handle);

    private final native boolean ObjectVoice_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectVoice_isRecorded(int handle);

    private final native boolean ObjectVoice_setBackgroundGradientColors(int handle, ArrayList<Pair<Integer, Float>> colorList);

    private final native boolean ObjectVoice_setBody(int handle, String body);

    private final native boolean ObjectVoice_setDummyThumbnailColors(int handle, int tintColor, int backgroundColor);

    private final native boolean ObjectVoice_setPlayTime(int handle, String time);

    private final native boolean ObjectVoice_setRecorded(int handle, boolean isRecorded);

    private final native boolean ObjectVoice_setState(int handle, int state);

    private final native boolean ObjectVoice_setThumbnailPath(int handle, String path);

    private final native boolean ObjectVoice_setTitle(int handle, String title);

    private final native boolean ObjectVoice_setVersion(int handle, int version);

    private final native boolean ObjectVoice_setViewType(int handle, int viewType);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectVoice(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @Deprecated(message = "Use attachedFile instead.")
    public void attachFile(@Nullable String filePath) {
        setAttachedFile(filePath);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @Nullable
    public String getAttachedFile() {
        return ObjectVoice_getAttachedFile(getMHandle());
    }

    @Nullable
    public final ArrayList<Pair<Integer, Float>> getBackgroundGradientColors() {
        return ObjectVoice_getBackgroundGradientColors(getMHandle());
    }

    @Nullable
    public final String getBody() {
        return ObjectVoice_getBody(getMHandle());
    }

    @NotNull
    public final Pair<Integer, Integer> getDummyThumbnailColors() {
        return ObjectVoice_getDummyThumbnailColors(getMHandle());
    }

    @Nullable
    public final String getPlayTime() {
        return ObjectVoice_getPlayTime(getMHandle());
    }

    public final int getState() {
        return ObjectVoice_getState(getMHandle());
    }

    @Nullable
    public final String getThumbnailPath() {
        return ObjectVoice_getThumbnailPath(getMHandle());
    }

    @Nullable
    public final String getTitle() {
        return ObjectVoice_getTitle(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    public final int getVersion() {
        return ObjectVoice_getVersion(getMHandle());
    }

    public final int getViewType() {
        return ObjectVoice_getViewType(getMHandle());
    }

    public final boolean isRecorded() {
        return ObjectVoice_isRecorded(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setAttachedFile(@Nullable String str) {
        if (ObjectVoice_attachFile(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundGradientColors(@Nullable ArrayList<Pair<Integer, Float>> arrayList) {
        if (ObjectVoice_setBackgroundGradientColors(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBody(@Nullable String str) {
        if (ObjectVoice_setBody(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDummyThumbnailColors(@NotNull Pair<Integer, Integer> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (ObjectVoice_setDummyThumbnailColors(getMHandle(), colors.getFirst().intValue(), colors.getSecond().intValue())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPlayTime(@Nullable String str) {
        if (ObjectVoice_setPlayTime(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRecorded(boolean z) {
        if (ObjectVoice_setRecorded(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setState(int i) {
        if (ObjectVoice_setState(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (ObjectVoice_setThumbnailPath(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTitle(@Nullable String str) {
        if (ObjectVoice_setTitle(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setVersion(int i) {
        if (ObjectVoice_setVersion(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setViewType(int i) {
        if (ObjectVoice_setViewType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectVoice(boolean z) {
        super(10);
        if (ObjectVoice_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
