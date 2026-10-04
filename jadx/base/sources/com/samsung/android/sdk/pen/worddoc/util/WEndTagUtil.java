package com.samsung.android.sdk.pen.worddoc.util;

import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0004J,\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010$\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010&\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0013\u0010'\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0082 J\u0011\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0007H\u0082 J7\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0082 J\u0011\u0010+\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u0011\u0010,\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u0011\u0010-\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u0011\u0010.\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u0011\u0010/\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u0011\u00100\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u0019\u00101\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00072\u0006\u00102\u001a\u00020\fH\u0082 J\u0011\u00103\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0007H\u0082 J\u001b\u00104\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0082 J\u001b\u00105\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0082 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/util/WEndTagUtil;", "", "filePath", "", "<init>", "(Ljava/lang/String;)V", "mNativeHandle", "", "finalize", "", "setEncryptionInfo", "size", "", "salt", "", HeaderParameterNames.INITIALIZATION_VECTOR, "key", "isEncrypted", "", "()Z", "encryptionSize", "getEncryptionSize", "()I", "encryptionSalt", "getEncryptionSalt", "()[B", "encryptionIv", "getEncryptionIv", "encryptionKey", "getEncryptionKey", "documentType", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$DocumentType;", "getDocumentType", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$DocumentType;", "setDocumentType", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$DocumentType;)V", "removeEncryptionInfo", RtspHeaders.Values.APPEND, Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "WEndTagUtil_init", "WEndTagUtil_finalize", "handle", "WEndTagUtil_setEncryptionInfo", "WEndTagUtil_removeEncryptionInfo", "WEndTagUtil_isEncrypted", "WEndTagUtil_getEncryptionSize", "WEndTagUtil_getEncryptionIv", "WEndTagUtil_getEncryptionSalt", "WEndTagUtil_getEncryptionKey", "WEndTagUtil_setDocumentType", "type", "WEndTagUtil_getDocumentType", "WEndTagUtil_append", "WEndTagUtil_replace", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class WEndTagUtil {
    private long mNativeHandle;

    public WEndTagUtil(@Nullable String str) throws SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        if (str == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        long jWEndTagUtil_init = WEndTagUtil_init(str);
        this.mNativeHandle = jWEndTagUtil_init;
        if (jWEndTagUtil_init == -1) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                    throw new SpenUnsupportedVersionException("E_UNSUPPORTED_VERSION : Unsupported version of WNote file format");
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the WNote file format");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    private final native boolean WEndTagUtil_append(long handle, String filePath);

    private final native void WEndTagUtil_finalize(long handle);

    private final native int WEndTagUtil_getDocumentType(long handle);

    private final native byte[] WEndTagUtil_getEncryptionIv(long handle);

    private final native byte[] WEndTagUtil_getEncryptionKey(long handle);

    private final native byte[] WEndTagUtil_getEncryptionSalt(long handle);

    private final native int WEndTagUtil_getEncryptionSize(long handle);

    private final native long WEndTagUtil_init(String filePath);

    private final native boolean WEndTagUtil_isEncrypted(long handle);

    private final native boolean WEndTagUtil_removeEncryptionInfo(long handle);

    private final native boolean WEndTagUtil_replace(long handle, String filePath);

    private final native boolean WEndTagUtil_setDocumentType(long handle, int type);

    private final native boolean WEndTagUtil_setEncryptionInfo(long handle, int size, byte[] salt, byte[] iv, byte[] key);

    public final void append(@Nullable String filePath) {
        WEndTagUtil_append(this.mNativeHandle, filePath);
    }

    public final void finalize() {
        WEndTagUtil_finalize(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    @NotNull
    public final SpenWNote.DocumentType getDocumentType() {
        return SpenWNote.DocumentType.values()[WEndTagUtil_getDocumentType(this.mNativeHandle)];
    }

    @NotNull
    public final byte[] getEncryptionIv() {
        return WEndTagUtil_getEncryptionIv(this.mNativeHandle);
    }

    @NotNull
    public final byte[] getEncryptionKey() {
        return WEndTagUtil_getEncryptionKey(this.mNativeHandle);
    }

    @NotNull
    public final byte[] getEncryptionSalt() {
        return WEndTagUtil_getEncryptionSalt(this.mNativeHandle);
    }

    public final int getEncryptionSize() {
        return WEndTagUtil_getEncryptionSize(this.mNativeHandle);
    }

    public final boolean isEncrypted() {
        return WEndTagUtil_isEncrypted(this.mNativeHandle);
    }

    public final void removeEncryptionInfo() {
        WEndTagUtil_removeEncryptionInfo(this.mNativeHandle);
    }

    public final void replace(@Nullable String filePath) {
        WEndTagUtil_replace(this.mNativeHandle, filePath);
    }

    public final void setDocumentType(@NotNull SpenWNote.DocumentType documentType) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        WEndTagUtil_setDocumentType(this.mNativeHandle, documentType.ordinal());
    }

    public final void setEncryptionInfo(int size, @Nullable byte[] salt, @Nullable byte[] iv, @Nullable byte[] key) {
        WEndTagUtil_setEncryptionInfo(this.mNativeHandle, size, salt, iv, key);
    }
}
