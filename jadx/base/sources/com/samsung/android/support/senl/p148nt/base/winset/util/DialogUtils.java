package com.samsung.android.support.senl.p148nt.base.winset.util;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ConfirmDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DialogInterfaceOnDismissListenerC9877a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003()*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020!H\u0007J\u0014\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u001c\u0010\"\u001a\u00020!2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/util/DialogUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "BTN_REPLACED_PROGRESS_TAG", "sOverSizeItemsDialog", "Landroidx/appcompat/app/AlertDialog;", "showNotEnoughStorageDialog", "context", "Landroid/content/Context;", "postRun", "Ljava/lang/Runnable;", "getNotEnoughStorageString", "content", "showNotEnoughStorageDialogFragment", "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/ConfirmDialogFragment;", "fm", "Landroidx/fragment/app/FragmentManager;", "showOverSizeItemsDialog", "maxSizeMB", "", "getsOverSizeItemsDialog", "clearOverSizeItemsDialog", "", "getOverSizeString", "showWidgetNoteWarning", "replaceBtnToProgress", "view", "Landroid/view/View;", "removeProgressFromBtn", "createProgressDialogFragment", "Landroidx/fragment/app/DialogFragment;", "createCircleProgressDialogFragment", "keyListener", "Landroid/content/DialogInterface$OnKeyListener;", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "text", "ProgressDialogFragment", "CircleProgressDialogFragment", "ProgressDialog", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DialogUtils {

    @NotNull
    private static final String BTN_REPLACED_PROGRESS_TAG = "btn_replaced_progress_tag";

    @NotNull
    public static final DialogUtils INSTANCE = new DialogUtils();

    @NotNull
    private static final String TAG = "DialogUtils";

    @Nullable
    private static AlertDialog sOverSizeItemsDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/util/DialogUtils$CircleProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "keyListener", "Landroid/content/DialogInterface$OnKeyListener;", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "dialogText", "", "<init>", "(Landroid/content/DialogInterface$OnKeyListener;Landroidx/activity/OnBackPressedCallback;Ljava/lang/String;)V", "getKeyListener", "()Landroid/content/DialogInterface$OnKeyListener;", "getBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "getDialogText", "()Ljava/lang/String;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CircleProgressDialogFragment extends DialogFragment {

        @Nullable
        private final OnBackPressedCallback backPressedCallback;

        @Nullable
        private final String dialogText;

        @Nullable
        private final DialogInterface.OnKeyListener keyListener;

        public CircleProgressDialogFragment() {
            this(null, null, null, 7, null);
        }

        @Nullable
        public final OnBackPressedCallback getBackPressedCallback() {
            return this.backPressedCallback;
        }

        @Nullable
        public final String getDialogText() {
            return this.dialogText;
        }

        @Nullable
        public final DialogInterface.OnKeyListener getKeyListener() {
            return this.keyListener;
        }

        @Override // androidx.fragment.app.DialogFragment
        @NotNull
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            super.onCreateDialog(savedInstanceState);
            Logger.m8697d(DialogUtils.TAG, "CircleProgressDialogFragment# create");
            AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), R.style.Theme.DeviceDefault.Dialog.NoActionBar).create();
            Window window = alertDialogCreate.getWindow();
            if (window == null) {
                Logger.m8703w(DialogUtils.TAG, "CircleProgressDialogFragment# create, window is null, just return dialog");
                return alertDialogCreate;
            }
            String str = this.dialogText;
            if (str == null || StringsKt.isBlank(str)) {
                LayoutInflater layoutInflater = getLayoutInflater();
                int i = C8875R.layout.notes_progress_circle;
                View decorView = window.getDecorView();
                Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                layoutInflater.inflate(i, (ViewGroup) decorView, true);
            } else {
                LayoutInflater layoutInflater2 = getLayoutInflater();
                int i2 = C8875R.layout.notes_progress_text_view_vertical;
                View decorView2 = window.getDecorView();
                Intrinsics.checkNotNull(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
                TextView textView = (TextView) layoutInflater2.inflate(i2, (ViewGroup) decorView2, true).findViewById(C8875R.id.progress_text_view);
                if (textView != null) {
                    textView.setText(this.dialogText);
                }
            }
            window.setGravity(17);
            window.clearFlags(2);
            window.getDecorView().setBackgroundColor(0);
            window.setWindowAnimations(0);
            DialogInterface.OnKeyListener onKeyListener = this.keyListener;
            if (onKeyListener != null) {
                alertDialogCreate.setOnKeyListener(onKeyListener);
            }
            OnBackPressedCallback onBackPressedCallback = this.backPressedCallback;
            if (onBackPressedCallback != null) {
                alertDialogCreate.getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
            }
            return alertDialogCreate;
        }

        public /* synthetic */ CircleProgressDialogFragment(DialogInterface.OnKeyListener onKeyListener, OnBackPressedCallback onBackPressedCallback, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : onKeyListener, (i & 2) != 0 ? null : onBackPressedCallback, (i & 4) != 0 ? null : str);
        }

        public CircleProgressDialogFragment(@Nullable DialogInterface.OnKeyListener onKeyListener, @Nullable OnBackPressedCallback onBackPressedCallback, @Nullable String str) {
            this.keyListener = onKeyListener;
            this.backPressedCallback = onBackPressedCallback;
            this.dialogText = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/util/DialogUtils$ProgressDialog;", "Landroid/app/ProgressDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "init", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ProgressDialog extends android.app.ProgressDialog {
        public ProgressDialog(@Nullable Context context) {
            super(context);
            init();
        }

        private final void init() {
            setCancelable(false);
            setProgressStyle(R.style.Widget.Material.ProgressBar);
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.setGravity(17);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/util/DialogUtils$ProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "progressText", "", "mOnCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setTextInProgressDialog", "", "text", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "isShowing", "", "setCanceledOnTouchOutside", "cancel", "setOnCancelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCancel", "dialog", "Landroid/content/DialogInterface;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ProgressDialogFragment extends DialogFragment {

        @Nullable
        private DialogInterface.OnCancelListener mOnCancelListener;

        @Nullable
        private String progressText;

        public final boolean isShowing() {
            Dialog dialog = getDialog();
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            DialogInterface.OnCancelListener onCancelListener = this.mOnCancelListener;
            if (onCancelListener != null) {
                onCancelListener.onCancel(dialog);
            }
        }

        @Override // androidx.fragment.app.DialogFragment
        @NotNull
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            String str;
            Logger.m8697d(DialogUtils.TAG, "ProgressDialogFragment# create");
            View viewInflate = LayoutInflater.from(getContext()).inflate(C8875R.layout.notes_progress_text_view, (ViewGroup) null);
            AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null).create();
            alertDialogCreate.setView(viewInflate);
            Window window = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window);
            window.setGravity(17);
            TextView textView = (TextView) viewInflate.findViewById(C8875R.id.progress_text_view);
            if (textView != null && (str = this.progressText) != null) {
                textView.setText(str);
            }
            return alertDialogCreate;
        }

        public final void setCanceledOnTouchOutside(boolean cancel) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.setCanceledOnTouchOutside(cancel);
            }
        }

        public final void setOnCancelListener(@NotNull DialogInterface.OnCancelListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mOnCancelListener = listener;
        }

        public final void setTextInProgressDialog(@Nullable String text) {
            this.progressText = text;
        }

        public final void showAllowingStateLoss(@Nullable FragmentManager fragmentManager, @Nullable String tag) {
            if (fragmentManager == null || fragmentManager.isDestroyed()) {
                return;
            }
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.add(this, tag);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    private DialogUtils() {
    }

    @JvmStatic
    public static final synchronized void clearOverSizeItemsDialog() {
        sOverSizeItemsDialog = null;
    }

    @JvmStatic
    @NotNull
    public static final DialogFragment createCircleProgressDialogFragment() {
        return new CircleProgressDialogFragment(null, null, null, 7, null);
    }

    public static /* synthetic */ DialogFragment createCircleProgressDialogFragment$default(DialogInterface.OnKeyListener onKeyListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onKeyListener = null;
        }
        return createCircleProgressDialogFragment(onKeyListener);
    }

    @JvmStatic
    @NotNull
    public static final DialogFragment createProgressDialogFragment() {
        return new ProgressDialogFragment();
    }

    @JvmStatic
    @NotNull
    public static final String getNotEnoughStorageString(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        String string = resources.getString(C8875R.string.not_enough_space_content, resources.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8875R.string.composer_save_to_image_dir_galaxy : C8875R.string.composer_save_to_image_dir));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final String getOverSizeString(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getOverSizeString(context, 1024L);
    }

    @JvmStatic
    @Nullable
    public static final synchronized AlertDialog getsOverSizeItemsDialog() {
        return sOverSizeItemsDialog;
    }

    @JvmStatic
    public static final void removeProgressFromBtn(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        View viewFindViewWithTag = ((ViewGroup) parent).findViewWithTag(BTN_REPLACED_PROGRESS_TAG);
        if (viewFindViewWithTag == null) {
            view.setVisibility(0);
            return;
        }
        ViewParent parent2 = viewFindViewWithTag.getParent();
        if (parent2 != null) {
            ((ViewGroup) parent2).removeView(viewFindViewWithTag);
        }
        view.setVisibility(0);
    }

    @JvmStatic
    public static final void replaceBtnToProgress(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup.findViewWithTag(BTN_REPLACED_PROGRESS_TAG) != null) {
            return;
        }
        Context context = view.getContext();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = view.getMeasuredHeight();
        layoutParams.width = view.getMeasuredHeight();
        try {
            View viewInflate = LayoutInflater.from(context).inflate(C8875R.layout.notes_progress_circle_small, viewGroup, false);
            viewInflate.setTag(BTN_REPLACED_PROGRESS_TAG);
            viewInflate.setForegroundGravity(17);
            viewInflate.setLayoutParams(layoutParams);
            viewGroup.addView(viewInflate);
        } catch (Resources.NotFoundException unused) {
            Logger.m8698e(TAG, "replaceBtnToProgress# NotFoundException");
        }
        view.setVisibility(8);
    }

    @JvmStatic
    @Nullable
    public static final AlertDialog showNotEnoughStorageDialog(@Nullable Context context, @Nullable Runnable postRun) {
        if (context == null) {
            return null;
        }
        String string = context.getResources().getString(C8875R.string.not_enough_space);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ConfirmDialog confirmDialog = new ConfirmDialog(string, getNotEnoughStorageString(context));
        if (postRun != null) {
            confirmDialog.setPostRunnable(postRun);
        }
        return confirmDialog.buildDialog(context, null).show();
    }

    @JvmStatic
    @NotNull
    public static final ConfirmDialogFragment showNotEnoughStorageDialogFragment(@NotNull Context context, @NotNull FragmentManager fm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fm, "fm");
        ConfirmDialogFragment confirmDialogFragmentNewInstance = new ConfirmDialogFragment().newInstance(context.getResources().getString(C8875R.string.not_enough_space), getNotEnoughStorageString(context));
        fm.beginTransaction().add(confirmDialogFragmentNewInstance, "not_enougn_space").commitAllowingStateLoss();
        return confirmDialogFragmentNewInstance;
    }

    @JvmStatic
    @Nullable
    public static final synchronized AlertDialog showOverSizeItemsDialog(@NotNull Context context, long maxSizeMB) {
        AlertDialog alertDialog;
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            AlertDialog alertDialog2 = sOverSizeItemsDialog;
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (alertDialog2 != null) {
                if (alertDialog2 != null && alertDialog2.isShowing() && (alertDialog = sOverSizeItemsDialog) != null) {
                    alertDialog.dismiss();
                }
                sOverSizeItemsDialog = null;
            }
            AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, 0, 2, defaultConstructorMarker);
            alertDialogBuilderForAppCompat.setMessage(getOverSizeString(context, maxSizeMB)).setPositiveButton(context.getResources().getString(C8875R.string.f6384OK), new DialogInterfaceOnClickListenerC0140a(27));
            alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterfaceOnDismissListenerC9877a(1));
            AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
            sOverSizeItemsDialog = alertDialogCreate;
            if (alertDialogCreate != null) {
                alertDialogCreate.show();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sOverSizeItemsDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOverSizeItemsDialog$lambda$0(DialogInterface dialogInterface, int i) {
        Logger.m8697d(TAG, "OverSizeConfirmDialog# confirm btn is clicked");
        dialogInterface.dismiss();
    }

    @JvmStatic
    public static final void showWidgetNoteWarning(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, 0, 2, null);
        alertDialogBuilderForAppCompat.setPositiveButton(context.getResources().getString(C8875R.string.f6384OK), new DialogInterfaceOnClickListenerC0140a(26));
        alertDialogBuilderForAppCompat.setTitle(C8875R.string.widget_dialog_try_to_lock_title);
        alertDialogBuilderForAppCompat.setMessage(context.getResources().getString(C8875R.string.widget_dialog_try_to_lock));
        alertDialogBuilderForAppCompat.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWidgetNoteWarning$lambda$2(DialogInterface dialogInterface, int i) {
        NotesSamsungAnalytics.INSTANCE.insertLog("721", "7211");
        dialogInterface.dismiss();
    }

    @JvmStatic
    @NotNull
    public static final DialogFragment createCircleProgressDialogFragment(@Nullable DialogInterface.OnKeyListener keyListener) {
        return new CircleProgressDialogFragment(keyListener, null, null, 6, null);
    }

    public static /* synthetic */ DialogFragment createCircleProgressDialogFragment$default(OnBackPressedCallback onBackPressedCallback, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            onBackPressedCallback = null;
        }
        return createCircleProgressDialogFragment(onBackPressedCallback, str);
    }

    @JvmStatic
    @NotNull
    public static final String getOverSizeString(@NotNull Context context, long maxSizeMB) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C8875R.string.note_file_size_over_notify, Long.valueOf(maxSizeMB));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final DialogFragment createCircleProgressDialogFragment(@Nullable OnBackPressedCallback backPressedCallback, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new CircleProgressDialogFragment(null, backPressedCallback, text);
    }

    @JvmStatic
    @NotNull
    public static final AlertDialog showNotEnoughStorageDialog(@NotNull Context context, @Nullable String content, @Nullable Runnable postRun) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(C8875R.string.not_enough_space);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ConfirmDialog confirmDialog = new ConfirmDialog(string, content);
        if (postRun != null) {
            confirmDialog.setPostRunnable(postRun);
        }
        AlertDialog alertDialogShow = confirmDialog.buildDialog(context, null).show();
        Intrinsics.checkNotNullExpressionValue(alertDialogShow, "show(...)");
        return alertDialogShow;
    }
}
