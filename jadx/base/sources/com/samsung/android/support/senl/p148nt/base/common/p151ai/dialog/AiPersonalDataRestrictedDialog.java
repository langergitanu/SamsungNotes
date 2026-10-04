package com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p046K2.DialogInterfaceOnClickListenerC0161a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/dialog/AiPersonalDataRestrictedDialog;", "", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiPersonalDataRestrictedDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/dialog/AiPersonalDataRestrictedDialog$Companion;", "", "<init>", "()V", "makeDialog", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "closeButtonListener", "Landroid/content/DialogInterface$OnClickListener;", Constants.IntentExtraValue.SHOW, "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AlertDialog makeDialog(Context context, DialogInterface.OnClickListener closeButtonListener) {
            AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, 0, 2, null);
            alertDialogBuilderForAppCompat.setTitle(C8875R.string.ai_error_personal_data_restriced_title).setMessage(C8875R.string.ai_error_personal_data_restriced_message).setCancelable(false).setNegativeButton(C8875R.string.button_string_close, new DialogInterfaceOnClickListenerC0161a(closeButtonListener, 8));
            return alertDialogBuilderForAppCompat.create();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void makeDialog$lambda$0(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i) {
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i);
            }
        }

        public final void show(@NotNull Context context, @Nullable DialogInterface.OnClickListener closeButtonListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            makeDialog(context, closeButtonListener).show();
        }

        private Companion() {
        }
    }
}
