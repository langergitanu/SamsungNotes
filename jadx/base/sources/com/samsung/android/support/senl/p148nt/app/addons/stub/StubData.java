package com.samsung.android.support.senl.p148nt.app.addons.stub;

import com.microsoft.identity.common.java.constants.FidoConstants;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u0004\u0018\u00010\u0005J\u0010\u0010-\u001a\u00020.2\b\u0010%\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u0010\u0010%\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR\u001c\u0010)\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR\u0014\u0010/\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0007¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/stub/StubData;", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "<init>", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "resultCode", "getResultCode", "setResultCode", "resultMsg", "getResultMsg", "setResultMsg", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "contentSize", "getContentSize", "setContentSize", "downloadURI", "getDownloadURI", "setDownloadURI", "deltaDownloadURI", "getDeltaDownloadURI", "setDeltaDownloadURI", "deltaContentSize", "getDeltaContentSize", "setDeltaContentSize", FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, "getSignature", "setSignature", "gSignatureDownloadURL", "productId", "getProductId", "setProductId", "productName", "getProductName", "setProductName", "getgSignatureDownloadURL", "setgSignatureDownloadURL", "", "type", "getType", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StubData implements AsyncTaskManager.TaskResult {

    @Nullable
    private String appId;

    @Nullable
    private String contentSize;

    @Nullable
    private String deltaContentSize;

    @Nullable
    private String deltaDownloadURI;

    @Nullable
    private String downloadURI;

    @Nullable
    private String gSignatureDownloadURL;

    @Nullable
    private String productId;

    @Nullable
    private String productName;

    @Nullable
    private String resultCode;

    @Nullable
    private String resultMsg;

    @Nullable
    private String signature;

    @Nullable
    private String versionCode;

    @Nullable
    private String versionName;

    @Nullable
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    public final String getContentSize() {
        return this.contentSize;
    }

    @Nullable
    public final String getDeltaContentSize() {
        return this.deltaContentSize;
    }

    @Nullable
    public final String getDeltaDownloadURI() {
        return this.deltaDownloadURI;
    }

    @Nullable
    public final String getDownloadURI() {
        return this.downloadURI;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final String getProductName() {
        return this.productName;
    }

    @Nullable
    public final String getResultCode() {
        return this.resultCode;
    }

    @Nullable
    public final String getResultMsg() {
        return this.resultMsg;
    }

    @Nullable
    public final String getSignature() {
        return this.signature;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.task.AsyncTaskManager.TaskResult
    @NotNull
    public String getType() {
        return "";
    }

    @Nullable
    public final String getVersionCode() {
        return this.versionCode;
    }

    @Nullable
    public final String getVersionName() {
        return this.versionName;
    }

    @Nullable
    /* JADX INFO: renamed from: getgSignatureDownloadURL, reason: from getter */
    public final String getGSignatureDownloadURL() {
        return this.gSignatureDownloadURL;
    }

    public final void setAppId(@Nullable String str) {
        this.appId = str;
    }

    public final void setContentSize(@Nullable String str) {
        this.contentSize = str;
    }

    public final void setDeltaContentSize(@Nullable String str) {
        this.deltaContentSize = str;
    }

    public final void setDeltaDownloadURI(@Nullable String str) {
        this.deltaDownloadURI = str;
    }

    public final void setDownloadURI(@Nullable String str) {
        this.downloadURI = str;
    }

    public final void setProductId(@Nullable String str) {
        this.productId = str;
    }

    public final void setProductName(@Nullable String str) {
        this.productName = str;
    }

    public final void setResultCode(@Nullable String str) {
        this.resultCode = str;
    }

    public final void setResultMsg(@Nullable String str) {
        this.resultMsg = str;
    }

    public final void setSignature(@Nullable String str) {
        this.signature = str;
    }

    public final void setVersionCode(@Nullable String str) {
        this.versionCode = str;
    }

    public final void setVersionName(@Nullable String str) {
        this.versionName = str;
    }

    public final void setgSignatureDownloadURL(@Nullable String gSignatureDownloadURL) {
        this.gSignatureDownloadURL = gSignatureDownloadURL;
    }
}
