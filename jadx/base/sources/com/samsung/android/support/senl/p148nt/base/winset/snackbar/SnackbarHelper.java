package com.samsung.android.support.senl.p148nt.base.winset.snackbar;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.C4548R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u0007J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0007H\u0007J4\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0007JD\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0007J\u0085\u0001\u0010\t\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/snackbar/SnackbarHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LENGTH_LONG", "", "LENGTH_SHORT", Constants.IntentExtraValue.SHOW, "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "stringResId", XmlErrorCodes.DURATION, "text", "", "action", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/google/android/material/snackbar/BaseTransientBottomBar$BaseCallback;", "Lcom/google/android/material/snackbar/Snackbar;", "", "msg", "msgIconRes", "actionColor", "msgColor", "bgColor", "(Landroid/app/Activity;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/view/View$OnClickListener;Lcom/google/android/material/snackbar/BaseTransientBottomBar$BaseCallback;)Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SnackbarHelper {

    @NotNull
    public static final SnackbarHelper INSTANCE = new SnackbarHelper();
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;

    @NotNull
    private static final String TAG = "SnackbarHelper";

    private SnackbarHelper() {
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @IntRange(from = -2, m706to = 0) int i) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, null, i, null, null, null, null, null, null, 1012, null);
    }

    public static /* synthetic */ boolean show$default(Activity activity, CharSequence charSequence, CharSequence charSequence2, int i, Integer num, Integer num2, Integer num3, Integer num4, View.OnClickListener onClickListener, BaseTransientBottomBar.BaseCallback baseCallback, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charSequence2 = null;
        }
        if ((i2 & 16) != 0) {
            num = null;
        }
        if ((i2 & 32) != 0) {
            num2 = null;
        }
        if ((i2 & 64) != 0) {
            num3 = null;
        }
        if ((i2 & 128) != 0) {
            num4 = null;
        }
        if ((i2 & 256) != 0) {
            onClickListener = null;
        }
        if ((i2 & 512) != 0) {
            baseCallback = null;
        }
        return show(activity, charSequence, charSequence2, i, num, num2, num3, num4, onClickListener, baseCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @Nullable CharSequence charSequence, @IntRange(from = -2, m706to = 0) int i) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, charSequence, i, null, null, null, null, null, null, 1008, null);
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @Nullable CharSequence charSequence, @IntRange(from = -2, m706to = 0) int i, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, charSequence, i, num, null, null, null, null, null, 992, null);
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @Nullable CharSequence charSequence, @IntRange(from = -2, m706to = 0) int i, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, charSequence, i, num, num2, null, null, null, null, 960, null);
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @Nullable CharSequence charSequence, @IntRange(from = -2, m706to = 0) int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, charSequence, i, num, num2, num3, null, null, null, 896, null);
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @Nullable CharSequence charSequence, @IntRange(from = -2, m706to = 0) int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, charSequence, i, num, num2, num3, num4, null, null, 768, null);
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull CharSequence msg, @Nullable CharSequence charSequence, @IntRange(from = -2, m706to = 0) int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return show$default(activity, msg, charSequence, i, num, num2, num3, num4, onClickListener, null, 512, null);
    }

    public final void show(@Nullable Activity activity, int stringResId, @IntRange(from = -2, m706to = 0) int duration) {
        if (activity == null) {
            Logger.m8698e(TAG, "show# error - activity is null");
            return;
        }
        String string = activity.getString(stringResId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        show$default(activity, string, null, duration, null, null, null, null, null, null, 240, null);
    }

    @JvmStatic
    public static final void show(@Nullable Activity activity, @NotNull String text, @IntRange(from = -2, m706to = 0) int duration) {
        Intrinsics.checkNotNullParameter(text, "text");
        show$default(activity, text, null, duration, null, null, null, null, null, null, 240, null);
    }

    @JvmStatic
    public static final void show(@Nullable Activity activity, @NotNull CharSequence text, @NotNull CharSequence action, @IntRange(from = -2, m706to = 0) int duration, @NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(listener, "listener");
        show$default(activity, text, action, duration, null, null, null, null, listener, null, 752, null);
    }

    @JvmStatic
    public static final void show(@Nullable Activity activity, @NotNull CharSequence text, @NotNull CharSequence action, @IntRange(from = -2, m706to = 0) int duration, @NotNull View.OnClickListener listener, @NotNull BaseTransientBottomBar.BaseCallback<Snackbar> callback) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(callback, "callback");
        show$default(activity, text, action, duration, null, null, null, null, listener, callback, 240, null);
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"Range", "SetTextI18n"})
    public static final boolean show(@Nullable Activity activity, @NotNull final CharSequence msg, @Nullable CharSequence action, @IntRange(from = -2, m706to = 0) int duration, @Nullable Integer msgIconRes, @Nullable Integer actionColor, @Nullable Integer msgColor, @Nullable Integer bgColor, @Nullable View.OnClickListener listener, @Nullable BaseTransientBottomBar.BaseCallback<Snackbar> callback) {
        View viewFindViewById;
        TextView textView;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (activity == null) {
            Logger.m8698e(TAG, "show# error - activity is null");
            return false;
        }
        Window window = activity.getWindow();
        if (window == null) {
            Logger.m8698e(TAG, "show# error - window is null");
            return false;
        }
        View viewFindViewById2 = window.getDecorView().findViewById(R.id.content);
        if (viewFindViewById2 == null) {
            Logger.m8698e(TAG, "show# error - can't find content view!");
            return false;
        }
        Snackbar snackbarMake = Snackbar.make(viewFindViewById2, msg, duration);
        Intrinsics.checkNotNullExpressionValue(snackbarMake, "make(...)");
        if (29 <= Build.VERSION.SDK_INT && msgIconRes != null && (textView = (TextView) snackbarMake.getView().findViewById(C4548R.id.snackbar_text)) != null && (drawable = ContextCompat.getDrawable(textView.getContext(), msgIconRes.intValue())) != null) {
            int iApplyDimension = (int) TypedValue.applyDimension(1, 24.0f, textView.getContext().getResources().getDisplayMetrics());
            drawable.setBounds(0, 0, iApplyDimension, iApplyDimension);
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding((int) TypedValue.applyDimension(1, 10.0f, textView.getContext().getResources().getDisplayMetrics()));
        }
        if (msgColor != null) {
            snackbarMake.setTextColor(msgColor.intValue());
        }
        if (action != null) {
            snackbarMake.setAction(action, new ViewOnClickListenerC8556a(listener, 10));
            if (actionColor != null) {
                snackbarMake.setActionTextColor(actionColor.intValue());
            }
        }
        if (bgColor != null && (viewFindViewById = snackbarMake.getView().findViewById(C4548R.id.snackbar_content_layout)) != null) {
            viewFindViewById.setBackgroundTintList(ColorStateList.valueOf(bgColor.intValue()));
            viewFindViewById.setElevation(8.0f);
        }
        if (callback != null) {
            snackbarMake.addCallback(callback);
        }
        snackbarMake.getView().setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.base.winset.snackbar.SnackbarHelper.show.4
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setContentDescription(msg);
            }
        });
        snackbarMake.show();
        return true;
    }
}
