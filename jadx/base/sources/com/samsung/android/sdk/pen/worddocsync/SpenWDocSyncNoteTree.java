package com.samsung.android.sdk.pen.worddocsync;

import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenInvalidCacheException;
import com.samsung.android.sdk.pen.document.SpenInvalidPasswordException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0004J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree;", "", "<init>", "()V", "mNativeHandle", "", "isInitialized", "", IdentityApiContract.Parameter.MODEL_NAME, "", "getModelName", "()Ljava/lang/String;", SyncDBSchema.SyncInfo.COMMIT_ID, "getCommitId", "deviceId", "getDeviceId", "parseXml", "", "xmlString", "composeXml", "printInfo", "getNativeHandle", "", "finalize", "checkInitialized", "throwCheckedExceptionLoadWNote", "throwCheckedExceptionSaveWNote", "throwUncheckedException", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWDocSyncNoteTree.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWDocSyncNoteTree.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
public final class SpenWDocSyncNoteTree {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG = "Model_WDocSyncNoteTree";
    private boolean isInitialized;
    private int mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0083 J\t\u0010\u000b\u001a\u00020\fH\u0083 J\u0011\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0083 J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0083 J\u0011\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0083 J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0083 J\u0011\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0083 J\u0011\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree$Companion;", "", "<init>", "()V", "LOG_TAG", "", "composeEmptyXml", "printXml", "", "sml_str", "WDocSyncNoteTree_composeEmptyXml", "WDocSyncNoteTree_init", "", "WDocSyncNoteTree_finalize", "nativeHandle", "WDocSyncNoteTree_parseXml", "", "xmlString", "WDocSyncNoteTree_composeXml", "WDocSyncNoteTree_getModelName", "WDocSyncNoteTree_getCommitId", "WDocSyncNoteTree_getDeviceId", "WDocSyncNoteTree_printInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenWDocSyncNoteTree.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWDocSyncNoteTree.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,193:1\n731#2,9:194\n731#2,9:205\n37#3,2:203\n37#3,2:214\n*S KotlinDebug\n*F\n+ 1 SpenWDocSyncNoteTree.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree$Companion\n*L\n162#1:194,9\n167#1:205,9\n162#1:203,2\n167#1:214,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final String WDocSyncNoteTree_composeEmptyXml() {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_composeEmptyXml();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncNoteTree_composeXml(int nativeHandle) {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_composeXml(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void WDocSyncNoteTree_finalize(int nativeHandle) {
            SpenWDocSyncNoteTree.WDocSyncNoteTree_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncNoteTree_getCommitId(int nativeHandle) {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_getCommitId(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncNoteTree_getDeviceId(int nativeHandle) {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_getDeviceId(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncNoteTree_getModelName(int nativeHandle) {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_getModelName(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WDocSyncNoteTree_init() {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncNoteTree_parseXml(int nativeHandle, String xmlString) {
            return SpenWDocSyncNoteTree.WDocSyncNoteTree_parseXml(nativeHandle, xmlString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void WDocSyncNoteTree_printInfo(int nativeHandle) {
            SpenWDocSyncNoteTree.WDocSyncNoteTree_printInfo(nativeHandle);
        }

        @Nullable
        public final String composeEmptyXml() {
            return WDocSyncNoteTree_composeEmptyXml();
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ce A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void printXml(@NotNull String sml_str) {
            List listEmptyList;
            List listEmptyList2;
            String[] strArr;
            Intrinsics.checkNotNullParameter(sml_str, "sml_str");
            Log.d(SpenWDocSyncNoteTree.LOG_TAG, "printXml");
            List<String> listSplit = new Regex("<").split(sml_str, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            int length = 0;
            for (String str : (String[]) listEmptyList.toArray(new String[0])) {
                if (!TextUtils.isEmpty(str)) {
                    Log.d(SpenWDocSyncNoteTree.LOG_TAG, length + " : <" + str);
                    List<String> listSplit2 = new Regex(">").split(str, 0);
                    if (listSplit2.isEmpty()) {
                        listEmptyList2 = CollectionsKt.emptyList();
                        strArr = (String[]) listEmptyList2.toArray(new String[0]);
                        if (!StringsKt.m14167w(strArr[0], "/")) {
                        }
                        if (strArr.length <= 1) {
                        }
                    } else {
                        ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() != 0) {
                                listEmptyList2 = AbstractC12991c.m14000u(listIterator2, 1, listSplit2);
                                break;
                            }
                        }
                        listEmptyList2 = CollectionsKt.emptyList();
                        strArr = (String[]) listEmptyList2.toArray(new String[0]);
                        length = !StringsKt.m14167w(strArr[0], "/") ? length + 2 : length + 1;
                        if (strArr.length <= 1) {
                            length += strArr[1].length();
                        }
                    }
                }
            }
            AbstractC0541b.m755A(length, "Size = ", SpenWDocSyncNoteTree.LOG_TAG);
        }

        private Companion() {
        }
    }

    public SpenWDocSyncNoteTree() {
        int iWDocSyncNoteTree_init = INSTANCE.WDocSyncNoteTree_init();
        this.mNativeHandle = iWDocSyncNoteTree_init;
        if (iWDocSyncNoteTree_init == 0) {
            throwUncheckedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncNoteTree_composeEmptyXml();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncNoteTree_composeXml(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void WDocSyncNoteTree_finalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncNoteTree_getCommitId(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncNoteTree_getDeviceId(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncNoteTree_getModelName(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WDocSyncNoteTree_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncNoteTree_parseXml(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void WDocSyncNoteTree_printInfo(int i);

    private final void checkInitialized() {
        if (this.mNativeHandle == 0) {
            throw new IllegalStateException("native handle is not initialized");
        }
    }

    private final void throwCheckedExceptionLoadWNote() throws SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        int error = SpenError.getError();
        if (error == 17) {
            throw new SpenInvalidPasswordException(AbstractC0541b.m772n("E_INVALID_PASSWORD : the password is wrong. : ", SpenError.getErrorModule()));
        }
        if (error == 19) {
            throw new SpenAlreadyClosedException("SpenWDocSyncNoteTree(" + this + ") is already closed.: " + SpenError.getErrorModule());
        }
        if (error == 24) {
            throw new SpenBoundFileNotFoundException(AbstractC0541b.m772n("E_BOUND_FILE_NOT_FOUND - Can not find bound file.: ", SpenError.getErrorModule()));
        }
        if (error == 25) {
            throw new SpenInvalidCacheException(AbstractC0541b.m772n("E_INVALID_CACHE - Cache is invalid.: ", SpenError.getErrorModule()));
        }
        switch (error) {
            case 10:
            case 11:
                throw new IOException(AbstractC2322a.m1616f(error, "errno(", ") ", SpenError.getErrorModule()));
            case 12:
                throw new SpenUnsupportedVersionException(AbstractC0541b.m772n("E_UNSUPPORTED_VERSION - Unsupported version of WNote file format. : ", SpenError.getErrorModule()));
            case 13:
                throw new SpenUnsupportedTypeException(AbstractC0541b.m772n("E_UNSUPPORTED_TYPE - It does not correspond to the WNote file format. : ", SpenError.getErrorModule()));
            default:
                SpenError.ThrowUncheckedException(error);
                return;
        }
    }

    private final void throwCheckedExceptionSaveWNote() throws IOException {
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException(AbstractC2322a.m1616f(error, "errno(", ") ", SpenError.getErrorModule()));
        }
        if (error != 19) {
            if (error == 24) {
                throw new SpenBoundFileNotFoundException(AbstractC0541b.m772n("E_BOUND_FILE_NOT_FOUND - Can not find bound file.: ", SpenError.getErrorModule()));
            }
            if (error == 25) {
                throw new SpenInvalidCacheException(AbstractC0541b.m772n("E_INVALID_CACHE - Cache is invalid.: ", SpenError.getErrorModule()));
            }
            SpenError.ThrowUncheckedException(error);
            return;
        }
        throw new SpenAlreadyClosedException("SpenWDocSyncNoteTree(" + this + ") is already closed.: " + SpenError.getErrorModule());
    }

    private final void throwUncheckedException() {
        int error = SpenError.getError();
        if (error != 19) {
            SpenError.ThrowUncheckedException(error);
            return;
        }
        throw new SpenAlreadyClosedException("SpenWDocSyncNoteTree(" + this + ") is already closed");
    }

    @Nullable
    public final String composeXml() {
        checkInitialized();
        return INSTANCE.WDocSyncNoteTree_composeXml(this.mNativeHandle);
    }

    public final void finalize() {
        Log.i(LOG_TAG, "finalize() : " + hashCode());
        INSTANCE.WDocSyncNoteTree_finalize(this.mNativeHandle);
        this.mNativeHandle = 0;
    }

    @NotNull
    public final String getCommitId() {
        checkInitialized();
        return INSTANCE.WDocSyncNoteTree_getCommitId(this.mNativeHandle);
    }

    @NotNull
    public final String getDeviceId() {
        checkInitialized();
        return INSTANCE.WDocSyncNoteTree_getDeviceId(this.mNativeHandle);
    }

    @NotNull
    public final String getModelName() {
        checkInitialized();
        return INSTANCE.WDocSyncNoteTree_getModelName(this.mNativeHandle);
    }

    public final long getNativeHandle() {
        return this.mNativeHandle;
    }

    public final void parseXml(@Nullable String xmlString) throws SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        if (this.isInitialized) {
            throw new IllegalStateException("parseXml() - WDocSyncNoteTree is already initialized");
        }
        if (TextUtils.isEmpty(xmlString)) {
            throw new IllegalArgumentException("parseXml() - xml string is invalid");
        }
        if (!INSTANCE.WDocSyncNoteTree_parseXml(this.mNativeHandle, xmlString)) {
            throwCheckedExceptionLoadWNote();
        }
        this.isInitialized = true;
    }

    public final void printInfo() {
        checkInitialized();
        INSTANCE.WDocSyncNoteTree_printInfo(this.mNativeHandle);
    }
}
