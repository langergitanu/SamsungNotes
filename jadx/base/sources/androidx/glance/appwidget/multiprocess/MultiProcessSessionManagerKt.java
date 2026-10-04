package androidx.glance.appwidget.multiprocess;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a:\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0086@¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "currentThread", "kotlin.jvm.PlatformType", "getCurrentThread", "()Ljava/lang/String;", "sessionThread", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "key", "withMultiProcessContext", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMainProcess", "", "Landroid/content/Context;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class MultiProcessSessionManagerKt {

    @NotNull
    private static final String TAG = "GWT:MultiProcessContext";
    private static final String currentThread = Thread.currentThread().getName();

    public static final String getCurrentThread() {
        return currentThread;
    }

    public static final boolean isMainProcess(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT > 28) {
            return context.getPackageName().equals(Application.getProcessName());
        }
        return false;
    }

    private static final ExecutorCoroutineDispatcher sessionThread(String str) {
        return ThreadPoolDispatcherKt.newSingleThreadContext("sessionT-" + str);
    }

    @Nullable
    public static final Object withMultiProcessContext(@NotNull String str, @NotNull Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcherSessionThread = sessionThread(str);
        GlanceLog.INSTANCE.m2301i(TAG, "Start " + str + " coroutine at multi-process context / " + executorCoroutineDispatcherSessionThread);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(executorCoroutineDispatcherSessionThread), null, null, new MultiProcessSessionManagerKt$withMultiProcessContext$2$1(function2, str, executorCoroutineDispatcherSessionThread, null), 3, null);
        return Unit.INSTANCE;
    }
}
