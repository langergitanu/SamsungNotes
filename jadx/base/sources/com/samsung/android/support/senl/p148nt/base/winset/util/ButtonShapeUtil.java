package com.samsung.android.support.senl.p148nt.base.winset.util;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p107a4.RunnableC0355a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\"\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J7\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0018\"\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/util/ButtonShapeUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "changeCustomButtonBackground", "", "view", "Landroid/view/View;", "buttonShapeBgId", "", "buttonShapeBgId2", "buttonBgId", "changeCustomButtonBackgroundUnchangedTextColor", "changeButtonTextColor", "setButtonShapeEnabled", "setButtonShapeEnabledWithTextColor", "textColor", "updateContainedButtonLayout", "context", "Landroid/content/Context;", "container", "buttons", "", "(Landroid/content/Context;Landroid/view/View;[Landroid/view/View;)V", "getViewWidth", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ButtonShapeUtil {

    @NotNull
    public static final ButtonShapeUtil INSTANCE = new ButtonShapeUtil();

    @NotNull
    private static final String TAG = "ButtonShapeUtil";

    private ButtonShapeUtil() {
    }

    private final void changeButtonTextColor(View view) {
        boolean zIsShowButtonShapeEnabled = ButtonBackgroundUtils.isShowButtonShapeEnabled(view.getContext());
        if (Build.VERSION.SDK_INT < 28 || !zIsShowButtonShapeEnabled) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            textView.setTextColor(textView.getResources().getColor(C8875R.color.notes_primary_color, null));
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) view;
            textView2.setTextColor(textView2.getResources().getColor(C8875R.color.button_text_color, null));
        }
    }

    @JvmStatic
    public static final void changeCustomButtonBackgroundUnchangedTextColor(@Nullable View view, int buttonShapeBgId, int buttonShapeBgId2) {
        if (!(view instanceof Button) && !(view instanceof TextView)) {
            Logger.m8698e(TAG, "Can not apply button shape. ");
            return;
        }
        TextView textView = (TextView) view;
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(textView.getContext())) {
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setBackgroundResource(buttonShapeBgId);
            } else {
                textView.setBackgroundResource(buttonShapeBgId2);
            }
        }
    }

    private final int getViewWidth(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(-2, -2);
        return view.getMeasuredWidth();
    }

    @JvmStatic
    public static final void setButtonShapeEnabled(@Nullable View view) {
        Method method = null;
        Class<?> cls = view != null ? view.getClass() : null;
        if (cls != null) {
            try {
                method = cls.getMethod("semSetButtonShapeEnabled", Boolean.TYPE);
            } catch (IllegalAccessException e) {
                AbstractC4539a.m3214x("setButtonShapeEnabled# invoke Exception:", e.getMessage(), TAG);
                return;
            } catch (IllegalArgumentException e2) {
                AbstractC4539a.m3214x("setButtonShapeEnabled# invoke Exception:", e2.getMessage(), TAG);
                return;
            } catch (NoSuchMethodException e3) {
                AbstractC4539a.m3214x("setButtonShapeEnabled# getMethod Exception:", e3.getMessage(), TAG);
                return;
            } catch (SecurityException e5) {
                AbstractC4539a.m3214x("setButtonShapeEnabled# getMethod Exception:", e5.getMessage(), TAG);
                return;
            } catch (InvocationTargetException e6) {
                AbstractC4539a.m3214x("setButtonShapeEnabled# invoke Exception:", e6.getMessage(), TAG);
                return;
            }
        }
        if (method != null) {
            method.invoke(view, Boolean.TRUE);
        }
    }

    @JvmStatic
    public static final void setButtonShapeEnabledWithTextColor(@NotNull View view, int textColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            view.getClass().getMethod("semSetButtonShapeEnabled", Boolean.TYPE, Integer.TYPE).invoke(view, Boolean.TRUE, Integer.valueOf(textColor));
        } catch (IllegalAccessException e) {
            AbstractC4539a.m3214x("setButtonShapeEnabledWithTextColor# invoke Exception:", e.getMessage(), TAG);
        } catch (IllegalArgumentException e2) {
            AbstractC4539a.m3214x("setButtonShapeEnabledWithTextColor# invoke Exception:", e2.getMessage(), TAG);
        } catch (NoSuchMethodException e3) {
            AbstractC4539a.m3214x("setButtonShapeEnabledWithTextColor# getMethod Exception:", e3.getMessage(), TAG);
        } catch (SecurityException e5) {
            AbstractC4539a.m3214x("setButtonShapeEnabledWithTextColor# getMethod Exception:", e5.getMessage(), TAG);
        } catch (InvocationTargetException e6) {
            AbstractC4539a.m3214x("setButtonShapeEnabledWithTextColor# invoke Exception:", e6.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateContainedButtonLayout$lambda$0(View[] viewArr, int i, Context context, View view) {
        int i2;
        int measuredWidth;
        ViewGroup.LayoutParams[] layoutParamsArr = new ViewGroup.LayoutParams[viewArr.length];
        for (int i4 = 0; i4 < i; i4++) {
            View view2 = viewArr[i4];
            if (view2 != null) {
                layoutParamsArr[i4] = view2 != null ? view2.getLayoutParams() : null;
            }
        }
        if (context.getResources().getConfiguration().orientation == 2) {
            measuredWidth = (int) (((double) view.getMeasuredWidth()) * 0.6d);
            view.setPaddingRelative(view.getPaddingStart(), 0, view.getPaddingEnd(), 0);
            i2 = measuredWidth;
        } else {
            int measuredWidth2 = (int) (((double) view.getMeasuredWidth()) * 0.6d);
            int measuredWidth3 = (int) (((double) view.getMeasuredWidth()) * (ResourceUtils.isTabletLayout(context) ? 0.6d : 0.75d));
            view.setPaddingRelative(view.getPaddingStart(), (int) (((double) view.getMeasuredHeight()) * 0.05d), view.getPaddingEnd(), (int) (((double) view.getMeasuredHeight()) * 0.05d));
            i2 = measuredWidth3;
            measuredWidth = measuredWidth2;
        }
        int iMax = 0;
        for (View view3 : viewArr) {
            iMax = (int) Math.max(iMax, INSTANCE.getViewWidth(view3));
        }
        int iMin = (int) Math.min((int) Math.max(iMax, measuredWidth), i2);
        for (int i5 = 0; i5 < i; i5++) {
            View view4 = viewArr[i5];
            if (view4 != null) {
                ViewGroup.LayoutParams layoutParams = layoutParamsArr[i5];
                if (layoutParams != null) {
                    layoutParams.width = iMin;
                }
                if (view4 != null) {
                    view4.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void changeCustomButtonBackground(@NotNull View view, int buttonShapeBgId, int buttonShapeBgId2, int buttonBgId) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof Button) && !(view instanceof TextView)) {
            Logger.m8698e(TAG, "Can not apply button shape. ");
            return;
        }
        if (!ButtonBackgroundUtils.isShowButtonShapeEnabled(((TextView) view).getContext())) {
            view.setBackgroundResource(buttonBgId);
        } else if (Build.VERSION.SDK_INT >= 28) {
            view.setBackgroundResource(buttonShapeBgId);
        } else {
            view.setBackgroundResource(buttonShapeBgId2);
        }
        changeButtonTextColor(view);
    }

    public final void updateContainedButtonLayout(@Nullable Context context, @Nullable View container, @NotNull View... buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        int length = buttons.length;
        if (context == null || container == null || length <= 0) {
            return;
        }
        container.post(new RunnableC0355a(buttons, length, context, container));
    }
}
