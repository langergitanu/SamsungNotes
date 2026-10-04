package com.samsung.android.sdk.pen.graphics;

import android.os.AsyncTask;
import android.os.Process;
import android.util.Log;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \t2\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/graphics/SpenBitmapLoader;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "<init>", "()V", "doInBackground", ActionHandler.PARAMS, "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBitmapLoader extends AsyncTask<Void, Void, Void> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenBitmapLoader";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/graphics/SpenBitmapLoader$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_startEventLoop", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_startEventLoop() {
            SpenBitmapLoader.Native_startEventLoop();
        }

        private Companion() {
        }
    }

    public SpenBitmapLoader() {
        Log.d(TAG, "SpenBitmapLoader:: SpenBitmapLoader()");
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_startEventLoop();

    @Override // android.os.AsyncTask
    @Nullable
    public Void doInBackground(@NotNull Void... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Process.setThreadPriority(11);
        Thread.currentThread().setName("BitmapLoader");
        INSTANCE.Native_startEventLoop();
        Log.d(TAG, "SpenBitmapLoader:: doInBackground()");
        return null;
    }
}
