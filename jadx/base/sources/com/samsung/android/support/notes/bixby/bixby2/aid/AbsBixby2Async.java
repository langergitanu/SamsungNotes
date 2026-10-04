package com.samsung.android.support.notes.bixby.bixby2.aid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b&\u0018\u0000 \"2\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0014J#\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001c\"\u00020\u0002H\u0004¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0014J\n\u0010 \u001a\u0004\u0018\u00010\u0003H$R8\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b \f*\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n0\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResult;", "param", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "<init>", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;)V", "mCallbackWeakReference", "Ljava/lang/ref/WeakReference;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;", "", "kotlin.jvm.PlatformType", "getMCallbackWeakReference", "()Ljava/lang/ref/WeakReference;", "setMCallbackWeakReference", "(Ljava/lang/ref/WeakReference;)V", "mCallback", "getMCallback", "()Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;", "setMCallback", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;)V", "mContext", "Landroid/content/Context;", "onPreExecute", "", "doInBackground", "voids", "", "([Ljava/lang/Void;)Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResult;", "onPostExecute", "response", "backgroundOperation", "AsyncParam", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBixby2Async extends AsyncTask<Void, Void, ActionResult> {

    @NotNull
    public static final String TAG = "AbsBixby2Async";

    @Nullable
    private ActionResponseCallback<Object> mCallback;

    @NotNull
    private WeakReference<ActionResponseCallback<Object>> mCallbackWeakReference;

    @JvmField
    @SuppressLint({"StaticFieldLeak"})
    @NotNull
    public Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "", "mContext", "Landroid/content/Context;", "mCallback", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMCallback", "()Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;", "setMCallback", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;)V", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AsyncParam {

        @NotNull
        private ActionResponseCallback<Object> mCallback;

        @NotNull
        private Context mContext;

        public AsyncParam(@NotNull Context mContext, @NotNull ActionResponseCallback<Object> mCallback) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            Intrinsics.checkNotNullParameter(mCallback, "mCallback");
            this.mContext = mContext;
            this.mCallback = mCallback;
        }

        @NotNull
        public final ActionResponseCallback<Object> getMCallback() {
            return this.mCallback;
        }

        @NotNull
        public final Context getMContext() {
            return this.mContext;
        }

        public final void setMCallback(@NotNull ActionResponseCallback<Object> actionResponseCallback) {
            Intrinsics.checkNotNullParameter(actionResponseCallback, "<set-?>");
            this.mCallback = actionResponseCallback;
        }

        public final void setMContext(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    public AbsBixby2Async(@NotNull AsyncParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        WeakReference<ActionResponseCallback<Object>> weakReference = new WeakReference<>(param.getMCallback());
        this.mCallbackWeakReference = weakReference;
        this.mCallback = weakReference.get();
        this.mContext = param.getMContext();
    }

    @Nullable
    public abstract ActionResult backgroundOperation();

    @Nullable
    public final ActionResponseCallback<Object> getMCallback() {
        return this.mCallback;
    }

    @NotNull
    public final WeakReference<ActionResponseCallback<Object>> getMCallbackWeakReference() {
        return this.mCallbackWeakReference;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        Logger.m8697d(TAG, "onPreExecute");
        super.onPreExecute();
        ActionResponseCallback<Object> actionResponseCallback = this.mCallback;
        if (actionResponseCallback != null) {
            actionResponseCallback.onPreExecuteRequest();
        }
    }

    public final void setMCallback(@Nullable ActionResponseCallback<Object> actionResponseCallback) {
        this.mCallback = actionResponseCallback;
    }

    public final void setMCallbackWeakReference(@NotNull WeakReference<ActionResponseCallback<Object>> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.mCallbackWeakReference = weakReference;
    }

    @Override // android.os.AsyncTask
    @Nullable
    public final ActionResult doInBackground(@NotNull Void... voids) {
        Intrinsics.checkNotNullParameter(voids, "voids");
        Thread.currentThread().setName("Bixby_doInBackground");
        return backgroundOperation();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable ActionResult response) {
        Logger.m8697d(TAG, "onPostExecute");
        if ((response != null ? response.getResult() : null) == null) {
            ActionResponseCallback<Object> actionResponseCallback = this.mCallback;
            if (actionResponseCallback != null) {
                actionResponseCallback.onError();
                return;
            }
            return;
        }
        Gson gson = new Gson();
        ActionResponseCallback<Object> actionResponseCallback2 = this.mCallback;
        if (actionResponseCallback2 != null) {
            actionResponseCallback2.onRequestComplete(gson.toJson(response));
        }
    }
}
