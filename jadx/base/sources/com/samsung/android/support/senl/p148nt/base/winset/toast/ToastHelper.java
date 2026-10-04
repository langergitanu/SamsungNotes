package com.samsung.android.support.senl.p148nt.base.winset.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.SemBlurInfoCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.ActivityManagerUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J \u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0003J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0007J*\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010!\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0007J9\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010#J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0013J\u0018\u0010'\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010(\u001a\u00020%H\u0002J(\u0010'\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0005H\u0002J \u0010-\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010!\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\u001e\u0010-\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007J\u001e\u0010.\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020\u0013H\u0002J4\u00104\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u00106\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00108\u001a\u0004\u0018\u00010\f2\b\u00107\u001a\u0004\u0018\u00010\f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/toast/ToastHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LENGTH_LONG", "", "LENGTH_SHORT", "DELAY_TIME", "mToast", "Ljava/lang/ref/WeakReference;", "Landroid/widget/Toast;", "mHandler", "Landroid/os/Handler;", "mQueue", "Ljava/util/LinkedList;", "Lcom/samsung/android/support/senl/nt/base/winset/toast/ToastHelper$ToastItem;", "showActionToast", "", "context", "Landroid/content/Context;", "text", "", XmlErrorCodes.DURATION, "action", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "makeText", Constants.IntentExtraValue.SHOW, "message", "isCancelable", "", "resId", "customLayout", "(Landroid/content/Context;Ljava/lang/String;IZLjava/lang/Integer;)V", "param", "Lcom/samsung/android/support/senl/nt/base/winset/toast/ToastHelper$ToastParam;", "cancelAll", "getToast", "toastParam", "str", "isIgnoreCustomLayout", "log", "msg", "showDirectly", "showToastOnFlipCoverScreen", "removeDuplicationMessage", "showDelay", "rPostShow", "Ljava/lang/Runnable;", "mRunnableShowCompleted", "makeActionToast", "getApplicationContextInner", "makeTextForFlipCoverScreen", "toast", "lastToast", "getLastToast", "()Landroid/widget/Toast;", "setLastToast", "(Landroid/widget/Toast;)V", "ToastParam", "ToastItem", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToastHelper {
    private static final int DELAY_TIME = 4000;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    @NotNull
    private static final String TAG = "ToastHelper";

    @Nullable
    private static WeakReference<Toast> mToast;

    @NotNull
    public static final ToastHelper INSTANCE = new ToastHelper();

    @NotNull
    private static final Handler mHandler = new Handler();

    @NotNull
    private static final LinkedList<ToastItem> mQueue = new LinkedList<>();

    @NotNull
    private static final Runnable rPostShow = new RunnableC0284b(27);

    @NotNull
    private static final Runnable mRunnableShowCompleted = new RunnableC0284b(28);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/toast/ToastHelper$ToastItem;", "", "toast", "Landroid/widget/Toast;", "msg", "", "<init>", "(Landroid/widget/Toast;Ljava/lang/String;)V", "getToast", "()Landroid/widget/Toast;", "setToast", "(Landroid/widget/Toast;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "showTime", "", "getShowTime", "()J", "setShowTime", "(J)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ToastItem {

        @NotNull
        private String msg;
        private long showTime;

        @NotNull
        private Toast toast;

        public ToastItem(@NotNull Toast toast, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(toast, "toast");
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.toast = toast;
            this.msg = msg;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        public final long getShowTime() {
            return this.showTime;
        }

        @NotNull
        public final Toast getToast() {
            return this.toast;
        }

        public final void setMsg(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        public final void setShowTime(long j) {
            this.showTime = j;
        }

        public final void setToast(@NotNull Toast toast) {
            Intrinsics.checkNotNullParameter(toast, "<set-?>");
            this.toast = toast;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u00020\"2\b\b\u0001\u0010\u001a\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0018\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/toast/ToastHelper$ToastParam;", "", "<init>", "()V", "message", "", XmlErrorCodes.DURATION, "", "isCancelable", "", "isGravityBottom", "isEncodeLog", "(Ljava/lang/String;IZZZ)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getDuration", "()I", "setDuration", "(I)V", "()Z", "setCancelable", "(Z)V", "setGravityBottom", "setEncodeLog", "customLayout", "getCustomLayout", "()Ljava/lang/Integer;", "setCustomLayout", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isIgnoreCustomLayout", "setIgnoreCustomLayout", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ToastParam {

        @Nullable
        private Integer customLayout;
        private int duration;
        private boolean isCancelable;
        private boolean isEncodeLog;
        private boolean isGravityBottom;
        private boolean isIgnoreCustomLayout;

        @NotNull
        private String message;

        public ToastParam() {
            this.message = "";
            this.isCancelable = true;
        }

        @Nullable
        public final Integer getCustomLayout() {
            return this.customLayout;
        }

        public final int getDuration() {
            return this.duration;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: isCancelable, reason: from getter */
        public final boolean getIsCancelable() {
            return this.isCancelable;
        }

        /* JADX INFO: renamed from: isEncodeLog, reason: from getter */
        public final boolean getIsEncodeLog() {
            return this.isEncodeLog;
        }

        /* JADX INFO: renamed from: isGravityBottom, reason: from getter */
        public final boolean getIsGravityBottom() {
            return this.isGravityBottom;
        }

        /* JADX INFO: renamed from: isIgnoreCustomLayout, reason: from getter */
        public final boolean getIsIgnoreCustomLayout() {
            return this.isIgnoreCustomLayout;
        }

        public final void setCancelable(boolean z) {
            this.isCancelable = z;
        }

        public final void setCustomLayout(@Nullable Integer num) {
            this.customLayout = num;
        }

        public final void setDuration(int i) {
            this.duration = i;
        }

        public final void setEncodeLog(boolean z) {
            this.isEncodeLog = z;
        }

        public final void setGravityBottom(boolean z) {
            this.isGravityBottom = z;
        }

        public final void setIgnoreCustomLayout(boolean z) {
            this.isIgnoreCustomLayout = z;
        }

        public final void setMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setCustomLayout(@LayoutRes int customLayout) {
            this.customLayout = Integer.valueOf(customLayout);
        }

        public ToastParam(@NotNull String message, int i, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            this.duration = i;
            this.isCancelable = z;
            this.isGravityBottom = z2;
            this.isEncodeLog = z3;
        }
    }

    private ToastHelper() {
    }

    private final Context getApplicationContextInner(Context context) {
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(context)) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    private final Toast getLastToast() {
        WeakReference<Toast> weakReference = mToast;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private final Toast getToast(Context context, ToastParam toastParam) {
        if (toastParam.getCustomLayout() == null || ActivityManagerUtil.isAppInBackground(context)) {
            return getToast(context, toastParam.getMessage(), toastParam.getDuration(), toastParam.getIsIgnoreCustomLayout());
        }
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        Integer customLayout = toastParam.getCustomLayout();
        Intrinsics.checkNotNull(customLayout);
        View viewInflate = ((LayoutInflater) systemService).inflate(customLayout.intValue(), (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(C8875R.id.toast_text);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setText(toastParam.getMessage());
        Toast toast = new Toast(getApplicationContextInner(context));
        toast.setDuration(toastParam.getDuration());
        toast.setView(viewInflate);
        return toast;
    }

    private final void log(String msg) {
        if (Build.VERSION.SDK_INT > 28) {
            LoggerBase.INSTANCE.m7132d(TAG, msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnableShowCompleted$lambda$1() {
        LinkedList<ToastItem> linkedList = mQueue;
        if (linkedList.isEmpty()) {
            return;
        }
        linkedList.removeFirst();
    }

    private final Toast makeActionToast(Context context, CharSequence text, @IntRange(from = 0, m706to = 1) int duration, CharSequence action, View.OnClickListener listener) {
        Toast toast;
        Class[] clsArr = {Context.class, CharSequence.class, Integer.TYPE, CharSequence.class, View.OnClickListener.class};
        try {
            Class<?> cls = Class.forName("android.widget.Toast");
            Object objInvoke = cls.getDeclaredMethod("semMakeAction", (Class[]) Arrays.copyOf(clsArr, 5)).invoke(cls, context, text, Integer.valueOf(duration), action, listener);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.widget.Toast");
            toast = (Toast) objInvoke;
        } catch (ClassNotFoundException e) {
            log(AbstractC0541b.m772n("ClassNotFoundException : ", e.getMessage()));
            toast = null;
        } catch (IllegalAccessException e2) {
            log(AbstractC0541b.m772n("IllegalAccessException : ", e2.getMessage()));
            toast = null;
        } catch (NoSuchMethodException e3) {
            log(AbstractC0541b.m772n("NoSuchMethodException : ", e3.getMessage()));
            toast = null;
        } catch (InvocationTargetException e5) {
            log(AbstractC0541b.m772n("InvocationTargetException : ", e5.getMessage()));
            toast = null;
        }
        return toast == null ? Toast.makeText(getApplicationContextInner(context), text, duration) : toast;
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "InflateParams"})
    private final Toast makeText(Context context, CharSequence text, int duration) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C8875R.layout.toast_popup, (ViewGroup) null);
        if (ResourceUtils.isSupportBackgroundBlur()) {
            viewInflate.setClipToOutline(true);
            ViewCompat companion = ViewCompat.INSTANCE.getInstance();
            Intrinsics.checkNotNull(viewInflate);
            companion.semSetBlurInfo(viewInflate, new SemBlurInfoCompat.Builder(0).setRadius(300).setColorCurve(0.5f, -15.0f, 0.0f, 255.0f, 33.8f, 153.7f).setBackgroundCornerRadius(context.getResources().getDimensionPixelSize(C8875R.dimen.toast_popup_radius)));
        } else {
            viewInflate.setBackground(context.getResources().getDrawable(C8875R.drawable.toast_popup_bg, null));
        }
        View viewFindViewById = viewInflate.findViewById(C8875R.id.toast_text);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setText(text);
        Toast toast = new Toast(getApplicationContextInner(context));
        toast.setDuration(duration);
        toast.setView(viewInflate);
        return toast;
    }

    private final Toast makeTextForFlipCoverScreen(Context context, CharSequence text, int duration) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C8875R.layout.toast_popup, (ViewGroup) null);
        viewInflate.setBackground(context.getResources().getDrawable(C8875R.drawable.toast_popup_bg, null));
        View viewFindViewById = viewInflate.findViewById(C8875R.id.toast_text);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setText(text);
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(viewInflate);
        return toast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rPostShow$lambda$0() {
        INSTANCE.showDelay();
    }

    private final void removeDuplicationMessage(String msg) {
        Iterator<ToastItem> it = mQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ToastItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ToastItem toastItem = next;
            if (Intrinsics.areEqual(toastItem.getMsg(), msg)) {
                toastItem.getToast().cancel();
                it.remove();
            }
        }
    }

    private final void setLastToast(Toast toast) {
        if (toast == null) {
            mToast = null;
        } else {
            mToast = new WeakReference<>(toast);
        }
    }

    @JvmStatic
    public static final void show(@NotNull Context context, @NotNull String message, int duration, boolean isCancelable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.show(context, new ToastParam(message, duration, isCancelable, false, false));
    }

    @JvmStatic
    public static final void showActionToast(@NotNull Context context, @NotNull CharSequence text, @IntRange(from = 0, m706to = 1) int duration, @NotNull CharSequence action, @NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Toast toastMakeActionToast = INSTANCE.makeActionToast(context, text, duration, action, listener);
        if (toastMakeActionToast != null) {
            toastMakeActionToast.show();
        }
    }

    private final synchronized void showDelay() {
        LinkedList<ToastItem> linkedList = mQueue;
        log("showDelay# queue size " + linkedList.size());
        if (linkedList.isEmpty()) {
            log("showDelay# queue is empty ");
            return;
        }
        if (linkedList.size() == 1) {
            ToastItem first = linkedList.getFirst();
            first.setShowTime(System.currentTimeMillis());
            first.getToast().show();
            Handler handler = mHandler;
            Runnable runnable = mRunnableShowCompleted;
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 4000L);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - linkedList.getFirst().getShowTime();
        log("showDelay# diffTime " + jCurrentTimeMillis);
        if (jCurrentTimeMillis >= 4000 || jCurrentTimeMillis <= 0) {
            linkedList.removeFirst();
            ToastItem first2 = linkedList.getFirst();
            first2.setShowTime(System.currentTimeMillis());
            first2.getToast().show();
            if (linkedList.size() > 1) {
                mHandler.postDelayed(rPostShow, jCurrentTimeMillis);
            }
        } else if (linkedList.size() > 1) {
            mHandler.postDelayed(rPostShow, ((long) 4000) - jCurrentTimeMillis);
        }
    }

    public final void cancelAll() {
        log("cancelAll#");
        Toast lastToast = getLastToast();
        if (lastToast != null) {
            lastToast.cancel();
        }
        Iterator<ToastItem> it = mQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ToastItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.getToast().cancel();
            it.remove();
        }
        mHandler.removeCallbacksAndMessages(null);
    }

    public final void showDirectly(@NotNull Context context, @StringRes int resId, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        getToast(context, string, duration, false).show();
    }

    public final void showToastOnFlipCoverScreen(@NotNull Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast toastMakeTextForFlipCoverScreen = makeTextForFlipCoverScreen(context, message, duration);
        log(AbstractC0541b.m772n("show# ", message));
        toastMakeTextForFlipCoverScreen.show();
    }

    @JvmStatic
    public static final void show(@NotNull Context context, @StringRes int resId, int duration, boolean isCancelable) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        INSTANCE.show(context, new ToastParam(string, duration, isCancelable, false, false));
    }

    public final void showDirectly(@NotNull Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(context, message, duration).show();
    }

    @JvmStatic
    public static final void show(@NotNull Context context, @NotNull String message, int duration, boolean isCancelable, @LayoutRes @Nullable Integer customLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        ToastParam toastParam = new ToastParam(message, duration, isCancelable, false, false);
        if (customLayout != null) {
            toastParam.setCustomLayout(customLayout.intValue());
        }
        INSTANCE.show(context, toastParam);
    }

    public final void show(@NotNull Context context, @NotNull ToastParam param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Toast toast = getToast(context, param);
        if (!DeviceInfo.isVSTModel() && param.getIsGravityBottom()) {
            Toast toast2 = new Toast(getApplicationContextInner(context));
            toast.setGravity(80, toast2.getXOffset(), toast2.getYOffset());
        }
        LinkedList<ToastItem> linkedList = mQueue;
        int size = linkedList.size();
        int iHashCode = toast.hashCode();
        String encode = param.getIsEncodeLog() ? LoggerBase.INSTANCE.getEncode(param.getMessage()) : param.getMessage();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(size, iHashCode, "show# ", " / ", " / ");
        sbM1173s.append(encode);
        log(sbM1173s.toString());
        Toast lastToast = getLastToast();
        if (lastToast != null && param.getIsCancelable()) {
            log("show# mToast is not null and param is cancelable ");
            if (!linkedList.isEmpty() && System.currentTimeMillis() - linkedList.getFirst().getShowTime() < 4000) {
                log("show# call showDelay1");
                removeDuplicationMessage(param.getMessage());
                linkedList.add(new ToastItem(toast, param.getMessage()));
                showDelay();
                return;
            }
            lastToast.cancel();
        } else {
            log("show# call showDelay2");
        }
        removeDuplicationMessage(param.getMessage());
        linkedList.add(new ToastItem(toast, param.getMessage()));
        showDelay();
    }

    private final Toast getToast(Context context, String str, int duration, boolean isIgnoreCustomLayout) {
        Toast toastMakeText;
        if (!ActivityManagerUtil.isAppInBackground(context) && !isIgnoreCustomLayout) {
            toastMakeText = makeText(context, str, duration);
        } else {
            toastMakeText = Toast.makeText(getApplicationContextInner(context), str, duration);
        }
        Intrinsics.checkNotNull(toastMakeText);
        return toastMakeText;
    }
}
