package com.samsung.android.support.senl.p148nt.app.settings.hwr.listener;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.listener.ListenerCallback;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B+\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/listener/DeleteListener;", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/TextRecognitionLanguageDownloadHelper$DeleteListener;", "mContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mLocale", "", "mDeleteResultCallback", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/listener/ListenerCallback$DeleteResultCallback;", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Lcom/samsung/android/support/senl/nt/app/settings/hwr/listener/ListenerCallback$DeleteResultCallback;)V", "release", "", "onComplete", "status", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeleteListener implements TextRecognitionLanguageDownloadHelper.DeleteListener {

    @NotNull
    private static final String TAG = "DeleteListener";

    @Nullable
    private WeakReference<Context> mContext;

    @Nullable
    private ListenerCallback.DeleteResultCallback mDeleteResultCallback;

    @Nullable
    private String mLocale;

    public DeleteListener(@Nullable WeakReference<Context> weakReference, @Nullable String str, @Nullable ListenerCallback.DeleteResultCallback deleteResultCallback) {
        this.mContext = weakReference;
        this.mLocale = str;
        this.mDeleteResultCallback = deleteResultCallback;
    }

    @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.DeleteListener
    public void onComplete(int status) {
        if (status != 0) {
            if (status != 1) {
                AbstractC8014b.m7201c(status, "unexpected status: ", TAG);
                return;
            } else {
                AbstractC8014b.m7209k("Cannot Delete ", this.mLocale, TAG);
                return;
            }
        }
        ListenerCallback.DeleteResultCallback deleteResultCallback = this.mDeleteResultCallback;
        Intrinsics.checkNotNull(deleteResultCallback);
        deleteResultCallback.onDeleted(this.mLocale);
        MainLogger.m7258i(TAG, this.mLocale + " Deleted");
    }

    public final void release() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return;
        }
        Intrinsics.checkNotNull(weakReference);
        weakReference.clear();
        this.mContext = null;
        this.mLocale = null;
        this.mDeleteResultCallback = null;
    }
}
