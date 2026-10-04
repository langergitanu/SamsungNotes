package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnShowListenerC0176c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020%H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u0019X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/dialog/AbsDialog;", "Landroid/app/Dialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mMessage", "Landroid/widget/TextView;", "getMMessage", "()Landroid/widget/TextView;", "setMMessage", "(Landroid/widget/TextView;)V", "mNeutralButton", "Landroid/widget/Button;", "getMNeutralButton", "()Landroid/widget/Button;", "setMNeutralButton", "(Landroid/widget/Button;)V", "mNegativeButton", "getMNegativeButton", "setMNegativeButton", "mPositiveButton", "getMPositiveButton", "setMPositiveButton", "mResources", "Landroid/content/res/Resources;", "getMResources", "()Landroid/content/res/Resources;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setSystemUiVisibility", "setWindowAttribute", "setLayout", "setPosition", "getDialogMinWidth", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsDialog extends Dialog {

    @NotNull
    private static final String TAG = SOLogger.createTag("AbsDialog");

    @Nullable
    private TextView mMessage;

    @Nullable
    private Button mNegativeButton;

    @Nullable
    private Button mNeutralButton;

    @Nullable
    private Button mPositiveButton;

    @NotNull
    private final Resources mResources;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsDialog(@NotNull Activity activity) {
        super(activity, C9086R.style.ScreenOffDialogTheme);
        Intrinsics.checkNotNullParameter(activity, "activity");
        SOLogger.INSTANCE.SOLoggerD(TAG, "AbsDialog#");
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        this.mResources = resources;
    }

    private final int getDialogMinWidth() {
        int i = getContext().getResources().getConfiguration().orientation;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Rect screenSize = DisplayUtils.getScreenSize(context);
        int iWidth = 1 == i ? screenSize.width() : screenSize.height();
        if (ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            iWidth = (int) (iWidth * 0.55f);
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "getDialogMinWidth# orientation/screenSize/minWidth " + i + "/" + screenSize + "/" + iWidth);
        return iWidth;
    }

    private final void setLayout() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setLayout#");
        LinearLayout linearLayout = (LinearLayout) findViewById(C9086R.id.dialog_layout);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = getDialogMinWidth();
        linearLayout.setLayoutParams(layoutParams);
    }

    private final void setPosition() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setPosition#");
        if (getWindow() == null) {
            return;
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 80;
        }
    }

    private final void setSystemUiVisibility() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setSystemUiVisibility#");
        int i = ConfigurationModel.INSTANCE.isPinnedPanelRunning() ? 5382 : 5380;
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Window window = getWindow();
        companion.setSystemUiVisibility(window != null ? window.getDecorView() : null, i, true, false, false);
    }

    private final void setWindowAttribute() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setWindowAttribute#");
        if (getWindow() == null) {
            return;
        }
        Window window = getWindow();
        if (window != null) {
            window.setFlags(8, 8);
        }
        setOnShowListener(new DialogInterfaceOnShowListenerC0176c(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWindowAttribute$lambda$0(AbsDialog absDialog, DialogInterface dialogInterface) {
        if (absDialog.getWindow() == null) {
            return;
        }
        Window window = absDialog.getWindow();
        if (window != null) {
            window.addFlags(131072);
        }
        Window window2 = absDialog.getWindow();
        if (window2 != null) {
            window2.clearFlags(8);
        }
    }

    @Nullable
    public final TextView getMMessage() {
        return this.mMessage;
    }

    @Nullable
    public final Button getMNegativeButton() {
        return this.mNegativeButton;
    }

    @Nullable
    public final Button getMNeutralButton() {
        return this.mNeutralButton;
    }

    @Nullable
    public final Button getMPositiveButton() {
        return this.mPositiveButton;
    }

    @NotNull
    public final Resources getMResources() {
        return this.mResources;
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setSystemUiVisibility();
        setWindowAttribute();
        setLayout();
        setPosition();
        setCanceledOnTouchOutside(true);
    }

    public final void setMMessage(@Nullable TextView textView) {
        this.mMessage = textView;
    }

    public final void setMNegativeButton(@Nullable Button button) {
        this.mNegativeButton = button;
    }

    public final void setMNeutralButton(@Nullable Button button) {
        this.mNeutralButton = button;
    }

    public final void setMPositiveButton(@Nullable Button button) {
        this.mPositiveButton = button;
    }
}
