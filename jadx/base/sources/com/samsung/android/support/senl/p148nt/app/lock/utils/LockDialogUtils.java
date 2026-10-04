package com.samsung.android.support.senl.p148nt.app.lock.utils;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\"\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007JF\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/utils/LockDialogUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "showRetryIrisDialogWithError", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "errMsg", "", "onPositive", "Landroid/content/DialogInterface$OnClickListener;", "onNegative", "showTimerDialog", "startTime", "", "showNoAccountWarningDialog", "", "showSdocMigrationDialog", "showDialog", "title", "message", "positive", "negative", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockDialogUtils {

    @NotNull
    public static final LockDialogUtils INSTANCE = new LockDialogUtils();

    @NotNull
    private static final String TAG = LockLogger.createTag("LockDialogUtils");

    private LockDialogUtils() {
    }

    private final AlertDialog showDialog(Context context, CharSequence title, CharSequence message, CharSequence positive, CharSequence negative, DialogInterface.OnClickListener onPositive, DialogInterface.OnClickListener onNegative) {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(context, 0, 2, null).setTitle(title).setMessage(message).setPositiveButton(positive, onPositive).setNegativeButton(negative, onNegative).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        return alertDialogCreate;
    }

    @JvmStatic
    @NotNull
    public static final AlertDialog showRetryIrisDialogWithError(@NotNull Context context, @NotNull CharSequence errMsg, @NotNull DialogInterface.OnClickListener onPositive, @Nullable DialogInterface.OnClickListener onNegative) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(onPositive, "onPositive");
        LockLogger.m7356d(TAG, "showRetryIrisDialogWithError");
        String string = context.getResources().getString(C8003R.string.lock_iris_error_dialog_try_again);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getResources().getString(C8003R.string.lock_retry);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return INSTANCE.showDialog(context, string, errMsg, string2, string3, onPositive, onNegative);
    }

    @JvmStatic
    public static final void showSdocMigrationDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener onPositive, @Nullable DialogInterface.OnClickListener onNegative) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onPositive, "onPositive");
        LockLogger.m7356d(TAG, "showSdocMigrationDialog");
        String strM757C = AbstractC0541b.m757C(context.getResources().getString(C8003R.string.lock_note_cannot_open_another_account), "\n", context.getResources().getString(C8003R.string.lock_iris_dialog_failed));
        String string = context.getResources().getString(C8003R.string.sync_tipcard_btn_verify);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        INSTANCE.showDialog(context, null, strM757C, string, string2, onPositive, onNegative);
    }

    @JvmStatic
    @NotNull
    public static final AlertDialog showTimerDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener onPositive, int startTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onPositive, "onPositive");
        LockLogger.m7356d(TAG, "showTimerDialog");
        String string = context.getResources().getString(C8003R.string.lock_out_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String quantityString = context.getResources().getQuantityString(C8003R.plurals.lock_out_dialog_message, startTime, Integer.valueOf(startTime));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        String string2 = context.getResources().getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        AlertDialog alertDialogShowDialog = INSTANCE.showDialog(context, string, quantityString, string2, null, onPositive, null);
        alertDialogShowDialog.setCanceledOnTouchOutside(true);
        Handler handler = new Handler(context.getMainLooper());
        Timer timer = new Timer(true);
        timer.schedule(new LockDialogUtils$showTimerDialog$timerTask$1(startTime, timer, alertDialogShowDialog, context, handler), 0L, 1000L);
        return alertDialogShowDialog;
    }

    public final void showNoAccountWarningDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener onPositive, @Nullable DialogInterface.OnClickListener onNegative) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onPositive, "onPositive");
        String string = context.getResources().getString(C8003R.string.lock_dialog_do_not_forget_password_knox);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getResources().getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        showDialog(context, null, string, string2, string3, onPositive, onNegative);
    }
}
