package com.samsung.android.support.senl.p148nt.base.winset.builder;

import android.content.Context;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/builder/AlertDialogBuilderForAppCompat;", "Landroidx/appcompat/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", BaseWidgetConstant.WIDGET_THEME, "", "<init>", "(Landroid/content/Context;I)V", "create", "Landroidx/appcompat/app/AlertDialog;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AlertDialogBuilderForAppCompat extends AlertDialog.Builder {

    @NotNull
    private static final String TAG = "AlertDialogBuilder";

    @JvmOverloads
    public AlertDialogBuilderForAppCompat(@Nullable Context context) {
        this(context, 0, 2, null);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NotNull
    public AlertDialog create() {
        Logger.m8697d(TAG, "create");
        AlertDialog alertDialogCreate = super.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        return alertDialogCreate;
    }

    public /* synthetic */ AlertDialogBuilderForAppCompat(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? C8875R.style.NoteAlertDialogThemeForAppCompat : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlertDialogBuilderForAppCompat(@Nullable Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNull(context);
        Logger.m8697d(TAG, "AlertDialogBuilder(Context context, int theme)");
    }
}
