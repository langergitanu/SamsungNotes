package com.samsung.android.sdk.pen.document;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b*\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u001dH\u0002J\u0019\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001b\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010C\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u001b\u0010D\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010E\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u001b\u0010F\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010G\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u001b\u0010H\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010I\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u001b\u0010J\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010K\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u0019\u0010L\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u0011\u0010M\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u0019\u0010N\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0082 J\u0011\u0010O\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u0011\u0010P\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u0019\u0010Q\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001dH\u0082 J\u0011\u0010R\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dH\u0082 J\u0019\u0010S\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001dH\u0082 J\u0011\u0010T\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dH\u0082 JE\u0010U\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d22\u0010-\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/\u0018\u00010.j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/\u0018\u0001`1H\u0082 J9\u0010V\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/0.j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/`12\u0006\u0010A\u001a\u00020\u001dH\u0082 J!\u0010W\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u001dH\u0082 J\u001d\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0/2\u0006\u0010A\u001a\u00020\u001dH\u0082 R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR(\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR(\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR(\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010&\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R$\u0010*\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R|\u00102\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/\u0018\u00010.j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/\u0018\u0001`122\u0010-\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/\u0018\u00010.j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/\u0018\u0001`18F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R<\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0/2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010)\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010 ¨\u0006["}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectWeb;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "path", "", "attachedHTMLFile", "getAttachedHTMLFile", "()Ljava/lang/String;", "setAttachedHTMLFile", "(Ljava/lang/String;)V", "attachHTMLFile", "", "thumbnailPath", "getThumbnailPath", "setThumbnailPath", "body", "getBody", "setBody", "title", DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "uri", "getUri", "setUri", "typeId", "", "imageTypeId", "getImageTypeId", "()I", "setImageTypeId", "(I)V", "state", "getState", "setState", "version", "getVersion", "setVersion", "type", "viewType", "getViewType", "setViewType", "colorList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "backgroundGradientColors", "getBackgroundGradientColors", "()Ljava/util/ArrayList;", "setBackgroundGradientColors", "(Ljava/util/ArrayList;)V", "colors", "dummyThumbnailColors", "getDummyThumbnailColors", "()Lkotlin/Pair;", "setDummyThumbnailColors", "(Lkotlin/Pair;)V", "getType", "throwUncheckedException", "errno", "ObjectWeb_init", "handle", "ObjectWeb_attachHTMLFile", "ObjectWeb_getAttachedHTMLFile", "ObjectWeb_setThumbnailPath", "ObjectWeb_getThumbnailPath", "ObjectWeb_setBody", "ObjectWeb_getBody", "ObjectWeb_setTitle", "ObjectWeb_getTitle", "ObjectWeb_setUri", "ObjectWeb_getUri", "ObjectWeb_setImageTypeId", "ObjectWeb_getImageTypeId", "ObjectWeb_setState", "ObjectWeb_getState", "ObjectWeb_hasHTML", "ObjectWeb_setVersion", "ObjectWeb_getVersion", "ObjectWeb_setViewType", "ObjectWeb_getViewType", "ObjectWeb_setBackgroundGradientColors", "ObjectWeb_getBackgroundGradientColors", "ObjectWeb_setDummyThumbnailColors", "tintColor", "backgroundColor", "ObjectWeb_getDummyThumbnailColors", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectWeb extends SpenObjectBase {
    public SpenObjectWeb() {
        super(13);
    }

    private final native boolean ObjectWeb_attachHTMLFile(int handle, String path);

    private final native String ObjectWeb_getAttachedHTMLFile(int handle);

    private final native ArrayList<Pair<Integer, Float>> ObjectWeb_getBackgroundGradientColors(int handle);

    private final native String ObjectWeb_getBody(int handle);

    private final native Pair<Integer, Integer> ObjectWeb_getDummyThumbnailColors(int handle);

    private final native int ObjectWeb_getImageTypeId(int handle);

    private final native int ObjectWeb_getState(int handle);

    private final native String ObjectWeb_getThumbnailPath(int handle);

    private final native String ObjectWeb_getTitle(int handle);

    private final native String ObjectWeb_getUri(int handle);

    private final native int ObjectWeb_getVersion(int handle);

    private final native int ObjectWeb_getViewType(int handle);

    private final native boolean ObjectWeb_hasHTML(int handle);

    private final native boolean ObjectWeb_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectWeb_setBackgroundGradientColors(int handle, ArrayList<Pair<Integer, Float>> colorList);

    private final native boolean ObjectWeb_setBody(int handle, String title);

    private final native boolean ObjectWeb_setDummyThumbnailColors(int handle, int tintColor, int backgroundColor);

    private final native boolean ObjectWeb_setImageTypeId(int handle, int typeId);

    private final native boolean ObjectWeb_setState(int handle, int state);

    private final native boolean ObjectWeb_setThumbnailPath(int handle, String path);

    private final native boolean ObjectWeb_setTitle(int handle, String title);

    private final native boolean ObjectWeb_setUri(int handle, String uri);

    private final native boolean ObjectWeb_setVersion(int handle, int version);

    private final native boolean ObjectWeb_setViewType(int handle, int viewType);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectWeb(" + this + ") is already closed");
    }

    public final void attachHTMLFile(@Nullable String path) {
        setAttachedHTMLFile(path);
    }

    @Nullable
    public final String getAttachedHTMLFile() {
        return ObjectWeb_getAttachedHTMLFile(getMHandle());
    }

    @Nullable
    public final ArrayList<Pair<Integer, Float>> getBackgroundGradientColors() {
        return ObjectWeb_getBackgroundGradientColors(getMHandle());
    }

    @Nullable
    public final String getBody() {
        return ObjectWeb_getBody(getMHandle());
    }

    @NotNull
    public final Pair<Integer, Integer> getDummyThumbnailColors() {
        return ObjectWeb_getDummyThumbnailColors(getMHandle());
    }

    public final int getImageTypeId() {
        return ObjectWeb_getImageTypeId(getMHandle());
    }

    public final int getState() {
        return ObjectWeb_getState(getMHandle());
    }

    @Nullable
    public final String getThumbnailPath() {
        return ObjectWeb_getThumbnailPath(getMHandle());
    }

    @Nullable
    public final String getTitle() {
        return ObjectWeb_getTitle(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    @Nullable
    public final String getUri() {
        return ObjectWeb_getUri(getMHandle());
    }

    public final int getVersion() {
        return ObjectWeb_getVersion(getMHandle());
    }

    public final int getViewType() {
        return ObjectWeb_getViewType(getMHandle());
    }

    public final void setAttachedHTMLFile(@Nullable String str) {
        if (ObjectWeb_attachHTMLFile(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundGradientColors(@Nullable ArrayList<Pair<Integer, Float>> arrayList) {
        if (ObjectWeb_setBackgroundGradientColors(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBody(@Nullable String str) {
        if (ObjectWeb_setBody(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDummyThumbnailColors(@NotNull Pair<Integer, Integer> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (ObjectWeb_setDummyThumbnailColors(getMHandle(), colors.getFirst().intValue(), colors.getSecond().intValue())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImageTypeId(int i) {
        if (ObjectWeb_setImageTypeId(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setState(int i) {
        if (ObjectWeb_setState(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (ObjectWeb_setThumbnailPath(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTitle(@Nullable String str) {
        if (ObjectWeb_setTitle(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setUri(@Nullable String str) {
        if (ObjectWeb_setUri(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setVersion(int i) {
        if (ObjectWeb_setVersion(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setViewType(int i) {
        if (ObjectWeb_setViewType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectWeb(boolean z) {
        super(13);
        if (ObjectWeb_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
