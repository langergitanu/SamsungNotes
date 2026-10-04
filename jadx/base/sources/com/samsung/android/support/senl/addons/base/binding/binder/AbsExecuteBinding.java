package com.samsung.android.support.senl.addons.base.binding.binder;

import android.content.Context;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.View;
import androidx.profileinstaller.ChoreographerFrameCallbackC3727b;
import com.samsung.android.sdk.scs.base.utils.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0019\u0010\u000e\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0015R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "T", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "<init>", "()V", "mChoreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "mFrameCallback", "Landroid/view/Choreographer$FrameCallback;", "bind", "", "unbind", "execute", "convertStringToData", "data", "", "(Ljava/lang/String;)Ljava/lang/Object;", "convertStringToRes", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/Object;)V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsExecuteBinding<T> extends AbsBinding<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TYPE_COLOR = "color";

    @NotNull
    public static final String TYPE_DIMEN = "dimen";

    @NotNull
    public static final String TYPE_STRING = "string";
    private Choreographer mChoreographer = Choreographer.getInstance();

    @Nullable
    private Choreographer.FrameCallback mFrameCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding$Companion;", "", "<init>", "()V", "TYPE_COLOR", "", "TYPE_STRING", "TYPE_DIMEN", "getResId", "", "context", "Landroid/content/Context;", "type", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getResId(@NotNull Context context, @NotNull String type, @NotNull String data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(data, "data");
            return context.getResources().getIdentifier(StringsKt.m14139M(data, Log.TAG_SEPARATOR + type + new Regex("/"), ""), type, context.getPackageName());
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(AbsExecuteBinding absExecuteBinding, Object obj, long j) {
        View view = absExecuteBinding.getView();
        if (view != null) {
            absExecuteBinding.execute(view, obj);
            view.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    public void bind() {
        execute();
    }

    @Nullable
    public T convertStringToData(@Nullable String data) {
        return null;
    }

    @Nullable
    public T convertStringToRes(@Nullable String data) {
        return null;
    }

    public void execute() {
        T data;
        if (TextUtils.isEmpty(getMViewModelId())) {
            String bindId = getMBindId();
            Intrinsics.checkNotNull(bindId);
            data = (bindId.length() <= 0 || bindId.charAt(0) != '@') ? convertStringToData(bindId) : convertStringToRes(bindId);
        } else {
            String bindId2 = getMBindId();
            Intrinsics.checkNotNull(bindId2);
            data = getData(bindId2);
        }
        int executeType = getMExecuteType();
        if (executeType == 0) {
            if (getView() != null) {
                View view = getView();
                Intrinsics.checkNotNull(view);
                execute(view, data);
                return;
            }
            return;
        }
        if (executeType != 1) {
            return;
        }
        ChoreographerFrameCallbackC3727b choreographerFrameCallbackC3727b = new ChoreographerFrameCallbackC3727b(this, data, 1);
        this.mFrameCallback = choreographerFrameCallbackC3727b;
        Choreographer choreographer = this.mChoreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(choreographerFrameCallbackC3727b);
        }
    }

    public abstract void execute(@NotNull View view, @Nullable T data);

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
    public void unbind() {
        Choreographer.FrameCallback frameCallback = this.mFrameCallback;
        if (frameCallback != null) {
            Choreographer choreographer = this.mChoreographer;
            if (choreographer != null) {
                choreographer.removeFrameCallback(frameCallback);
            }
            this.mFrameCallback = null;
            this.mChoreographer = null;
        }
    }
}
