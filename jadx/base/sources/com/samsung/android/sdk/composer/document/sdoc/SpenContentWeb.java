package com.samsung.android.sdk.composer.document.sdoc;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0011\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0015H\u0082 J\u001b\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015H\u0082 J\u001b\u0010'\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010(\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015H\u0082 J\u001b\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015H\u0082 J\u0019\u0010+\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0082 J\u0011\u0010,\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0082 J#\u0010-\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0082 J\u0011\u0010/\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0015H\u0082 J\u001b\u00100\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u00101\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015H\u0082 R(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentWeb;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", "title", "", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "body", "getBody", "setBody", "uri", "getUri", "setUri", "path", "attachedHTMLFile", "getAttachedHTMLFile", "setAttachedHTMLFile", "typeId", "", "imageTypeId", "getImageTypeId", "()I", "setImageTypeId", "(I)V", "hasHTML", "", "attachHTMLFile", "", "copy", "source", "throwUncheckedException", "errno", "ContentWeb_init", "handle", "ContentWeb_setTitle", "ContentWeb_getTitle", "ContentWeb_setBody", "ContentWeb_getBody", "ContentWeb_setUri", "ContentWeb_getUri", "ContentWeb_setImageTypeId", "ContentWeb_getImageTypeId", "ContentWeb_copy", "sourceHandle", "ContentWeb_hasHTML", "ContentWeb_attachHTMLFile", "ContentWeb_getAttachedHTMLFile", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentWeb extends SpenContentBase {
    public SpenContentWeb() {
        super(5);
    }

    private final native boolean ContentWeb_attachHTMLFile(int handle, String path);

    private final native boolean ContentWeb_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native String ContentWeb_getAttachedHTMLFile(int handle);

    private final native String ContentWeb_getBody(int handle);

    private final native int ContentWeb_getImageTypeId(int handle);

    private final native String ContentWeb_getTitle(int handle);

    private final native String ContentWeb_getUri(int handle);

    private final native boolean ContentWeb_hasHTML(int handle);

    private final native boolean ContentWeb_init(int handle);

    private final native boolean ContentWeb_setBody(int handle, String body);

    private final native boolean ContentWeb_setImageTypeId(int handle, int typeId);

    private final native boolean ContentWeb_setTitle(int handle, String title);

    private final native boolean ContentWeb_setUri(int handle, String uri);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentWeb(" + this + ") is already closed");
    }

    @Deprecated(message = "Please use [.attachedHTMLFile] instead.")
    public final void attachHTMLFile(@Nullable String path) {
        if (ContentWeb_attachHTMLFile(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 5) {
            SpenError.ThrowUncheckedException(7);
        }
        int handle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentWeb_copy(handle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final String getAttachedHTMLFile() {
        return ContentWeb_getAttachedHTMLFile(getMHandle());
    }

    @Nullable
    public final String getBody() {
        return ContentWeb_getBody(getMHandle());
    }

    public final int getImageTypeId() {
        return ContentWeb_getImageTypeId(getMHandle());
    }

    @Nullable
    public final String getTitle() {
        return ContentWeb_getTitle(getMHandle());
    }

    @Nullable
    public final String getUri() {
        return ContentWeb_getUri(getMHandle());
    }

    public final boolean hasHTML() {
        return ContentWeb_hasHTML(getMHandle());
    }

    public final void setAttachedHTMLFile(@Nullable String str) {
        if (ContentWeb_attachHTMLFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBody(@Nullable String str) {
        if (ContentWeb_setBody(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImageTypeId(int i) {
        if (ContentWeb_setImageTypeId(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTitle(@Nullable String str) {
        if (ContentWeb_setTitle(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setUri(@Nullable String str) {
        if (ContentWeb_setUri(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
