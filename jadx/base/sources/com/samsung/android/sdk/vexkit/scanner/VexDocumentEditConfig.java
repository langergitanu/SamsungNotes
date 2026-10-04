package com.samsung.android.sdk.vexkit.scanner;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000e¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentEditConfig;", "", "()V", "docRect", "", "getDocRect", "()[F", "setDocRect", "([F)V", "externalStorageImport", "", "getExternalStorageImport", "()Z", "setExternalStorageImport", "(Z)V", "inputPath", "", "getInputPath", "()Ljava/lang/String;", "setInputPath", "(Ljava/lang/String;)V", "inputUri", "Landroid/net/Uri;", "getInputUri", "()Landroid/net/Uri;", "setInputUri", "(Landroid/net/Uri;)V", "isHeif", "setHeif", "isSecure", "setSecure", "nonDestruction", "getNonDestruction", "setNonDestruction", "objectRemover", "getObjectRemover", "setObjectRemover", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class VexDocumentEditConfig {
    private Uri inputUri;
    private boolean isHeif;
    private boolean isSecure;
    private boolean nonDestruction;
    private boolean objectRemover;
    private String inputPath = "";
    private float[] docRect = {0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private boolean externalStorageImport = true;

    public final float[] getDocRect() {
        return this.docRect;
    }

    public final boolean getExternalStorageImport() {
        return this.externalStorageImport;
    }

    public final String getInputPath() {
        return this.inputPath;
    }

    public final Uri getInputUri() {
        return this.inputUri;
    }

    public final boolean getNonDestruction() {
        return this.nonDestruction;
    }

    public final boolean getObjectRemover() {
        return this.objectRemover;
    }

    /* JADX INFO: renamed from: isHeif, reason: from getter */
    public final boolean getIsHeif() {
        return this.isHeif;
    }

    /* JADX INFO: renamed from: isSecure, reason: from getter */
    public final boolean getIsSecure() {
        return this.isSecure;
    }

    public final void setDocRect(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.docRect = fArr;
    }

    public final void setExternalStorageImport(boolean z) {
        this.externalStorageImport = z;
    }

    public final void setHeif(boolean z) {
        this.isHeif = z;
    }

    public final void setInputPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inputPath = str;
    }

    public final void setInputUri(Uri uri) {
        this.inputUri = uri;
    }

    public final void setNonDestruction(boolean z) {
        this.nonDestruction = z;
    }

    public final void setObjectRemover(boolean z) {
        this.objectRemover = z;
    }

    public final void setSecure(boolean z) {
        this.isSecure = z;
    }
}
