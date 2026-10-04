package com.samsung.android.sdk.composer.document.sdoc;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0082 J\u0019\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0082 J#\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0082 J\u0019\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0082 J\u0011\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0082 R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentImage;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", TextConst.KEY_PARAM_NUMBER, "", "paragraphNumber", "getParagraphNumber", "()I", "setParagraphNumber", "(I)V", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "copy", "", "source", "throwUncheckedException", "errno", "ContentImage_init", "", "handle", "ContentImage_setParagraphNumber", "ContentImage_getParagraphNumber", "ContentImage_copy", "sourceHandle", "ContentImage_setRatio", "ContentImage_getRatio", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentImage extends SpenContentBase {
    public SpenContentImage() {
        super(2);
    }

    private final native boolean ContentImage_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native int ContentImage_getParagraphNumber(int handle);

    private final native float ContentImage_getRatio(int handle);

    private final native boolean ContentImage_init(int handle);

    private final native boolean ContentImage_setParagraphNumber(int handle, int number);

    private final native boolean ContentImage_setRatio(int handle, float ratio);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentImage(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 2) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentImage_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final int getParagraphNumber() {
        return ContentImage_getParagraphNumber(getMHandle());
    }

    public final float getRatio() {
        return ContentImage_getRatio(getMHandle());
    }

    public final void setParagraphNumber(int i) {
        if (ContentImage_setParagraphNumber(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRatio(float f) {
        if (ContentImage_setRatio(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
