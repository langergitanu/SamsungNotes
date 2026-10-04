package com.samsung.android.sdk.pen.document;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u001b\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u000eH\u0082 J\u001b\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u000eH\u0082 R(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectCodeBlock;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "title", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "setTitle", "(Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;)V", "body", "getBody", "setBody", "type", "", "getType", "()I", "throwUncheckedException", "", "errno", "ObjectCodeBlock_setTitle", "", "handle", "ObjectCodeBlock_getTitle", "ObjectCodeBlock_setBody", "ObjectCodeBlock_getBody", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectCodeBlock extends SpenObjectBase {
    public SpenObjectCodeBlock() {
        super(23);
    }

    private final native SpenObjectTextBox ObjectCodeBlock_getBody(int handle);

    private final native SpenObjectTextBox ObjectCodeBlock_getTitle(int handle);

    private final native boolean ObjectCodeBlock_setBody(int handle, SpenObjectTextBox body);

    private final native boolean ObjectCodeBlock_setTitle(int handle, SpenObjectTextBox title);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectCodeBlock(" + this + ") is already closed");
    }

    @Nullable
    public final SpenObjectTextBox getBody() {
        return ObjectCodeBlock_getBody(getMHandle());
    }

    @Nullable
    public final SpenObjectTextBox getTitle() {
        return ObjectCodeBlock_getTitle(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    public final void setBody(@Nullable SpenObjectTextBox spenObjectTextBox) {
        if (ObjectCodeBlock_setBody(getMHandle(), spenObjectTextBox)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTitle(@Nullable SpenObjectTextBox spenObjectTextBox) {
        if (ObjectCodeBlock_setTitle(getMHandle(), spenObjectTextBox)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
