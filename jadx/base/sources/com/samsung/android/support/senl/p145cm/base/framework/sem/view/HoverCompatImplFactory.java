package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsListView;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsHoverCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.widget.SemHoverPopupWindow;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/HoverCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "HoverCompatSemImpl", "HoverCompatSdlImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HoverCompatImplFactory extends AbsHoverCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/HoverCompatImplFactory$HoverCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", "<init>", "()V", "setPopupType", "", "view", "Landroid/view/View;", "type", "", "setText", "text", "", "setCustomView", "customView", "setThumb", "hoverView", "getHoverPopup", "", Constants.IntentExtraValue.SHOW, "dismiss", "setHoverScrollEnabled", "listView", "Landroid/widget/AbsListView;", "enable", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HoverCompatSemImpl implements AbsHoverCompatImplFactory.IHoverCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void dismiss(@Nullable View view) {
            SemHoverPopupWindow semHoverPopupWindowSemGetHoverPopup;
            if (view != null) {
                try {
                    semHoverPopupWindowSemGetHoverPopup = view.semGetHoverPopup(false);
                } catch (NoClassDefFoundError e) {
                    AbstractC0000a.m23t("dismiss: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                } catch (NoSuchMethodError e2) {
                    AbstractC0000a.m23t("dismiss: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                }
            } else {
                semHoverPopupWindowSemGetHoverPopup = null;
            }
            if (semHoverPopupWindowSemGetHoverPopup != null) {
                semHoverPopupWindowSemGetHoverPopup.dismiss();
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        @Nullable
        public Object getHoverPopup(@Nullable View view) {
            if (view != null) {
                try {
                    return view.semGetHoverPopup(true);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("dismiss: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                }
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setCustomView(@Nullable View view, @Nullable View customView) {
            if (view != null) {
                try {
                    view.semSetHoverPopupType(3);
                } catch (NoClassDefFoundError e) {
                    AbstractC0000a.m23t("dismiss: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                } catch (NoSuchMethodError e2) {
                    AbstractC0000a.m23t("dismiss: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                }
            }
            SemHoverPopupWindow semHoverPopupWindowSemGetHoverPopup = view != null ? view.semGetHoverPopup(true) : null;
            if (semHoverPopupWindowSemGetHoverPopup != null) {
                semHoverPopupWindowSemGetHoverPopup.setGravity(12849);
                semHoverPopupWindowSemGetHoverPopup.setContent(customView);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setHoverScrollEnabled(@Nullable AbsListView listView, boolean enable) {
            if (listView != null) {
                try {
                    listView.semSetHoverScrollEnabled(enable);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("disableHoverScroll: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "ViewCompat");
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000c A[PHI: r0
          0x000c: PHI (r0v2 int) = (r0v1 int), (r0v3 int), (r0v4 int) binds: [B:4:0x0003, B:6:0x0006, B:8:0x0009] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setPopupType(@Nullable View view, int type) {
            if (type != 0) {
                int i = 1;
                if (type != 1) {
                    i = 2;
                    if (type != 2) {
                        i = 3;
                        if (type == 3) {
                            type = i;
                        }
                    }
                }
            } else {
                type = 0;
            }
            if (view != null) {
                try {
                    view.semSetHoverPopupType(type);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("dismiss: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setText(@Nullable View view, @Nullable CharSequence text) {
            SemHoverPopupWindow semHoverPopupWindowSemGetHoverPopup;
            if (view != null) {
                try {
                    semHoverPopupWindowSemGetHoverPopup = view.semGetHoverPopup(true);
                } catch (NoClassDefFoundError e) {
                    AbstractC0000a.m23t("setText: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                } catch (NoSuchMethodError e2) {
                    AbstractC0000a.m23t("setText: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                }
            } else {
                semHoverPopupWindowSemGetHoverPopup = null;
            }
            if (view != null) {
                view.semSetHoverPopupType(2);
            }
            if (semHoverPopupWindowSemGetHoverPopup != null) {
                semHoverPopupWindowSemGetHoverPopup.setContent(text);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setThumb(@Nullable View view, @Nullable View hoverView) {
            if (view != null) {
                try {
                    view.semSetHoverPopupType(3);
                } catch (NoClassDefFoundError e) {
                    AbstractC0000a.m23t("setThumb: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                } catch (NoSuchMethodError e2) {
                    AbstractC0000a.m23t("setThumb: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                } catch (NullPointerException e3) {
                    AbstractC0000a.m23t("setThumb: NullPointerException ", e3.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                }
            }
            SemHoverPopupWindow semHoverPopupWindowSemGetHoverPopup = view != null ? view.semGetHoverPopup(true) : null;
            if (semHoverPopupWindowSemGetHoverPopup != null) {
                WindowManagerCompat companion = WindowManagerCompat.INSTANCE.getInstance();
                Context context = view.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (companion.isFreeFormWindow((Activity) context)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                    ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    if (iArr[0] + (view.getWidth() / 2) < displayMetrics.widthPixels / 2) {
                        semHoverPopupWindowSemGetHoverPopup.setGravity(19);
                    } else {
                        semHoverPopupWindowSemGetHoverPopup.setGravity(21);
                    }
                } else {
                    semHoverPopupWindowSemGetHoverPopup.setGravity(17);
                }
                semHoverPopupWindowSemGetHoverPopup.setContent(hoverView);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void show(@Nullable View view, int type) {
            SemHoverPopupWindow semHoverPopupWindowSemGetHoverPopup;
            if (view != null) {
                try {
                    semHoverPopupWindowSemGetHoverPopup = view.semGetHoverPopup(false);
                } catch (NoClassDefFoundError e) {
                    AbstractC0000a.m23t("show: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                } catch (NoSuchMethodError e2) {
                    AbstractC0000a.m23t("show: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "HoverDelegateSemImpl");
                    return;
                }
            } else {
                semHoverPopupWindowSemGetHoverPopup = null;
            }
            if (semHoverPopupWindowSemGetHoverPopup != null) {
                setPopupType(view, type);
                semHoverPopupWindowSemGetHoverPopup.show();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsHoverCompatImplFactory
    @NotNull
    public AbsHoverCompatImplFactory.IHoverCompatImpl create(int deviceType) {
        return deviceType != 2 ? deviceType != 3 ? super.create(deviceType) : new HoverCompatSdlImpl() : new HoverCompatSemImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/HoverCompatImplFactory$HoverCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", "<init>", "()V", "setPopupType", "", "view", "Landroid/view/View;", "type", "", "setText", "text", "", "setCustomView", "customView", "setThumb", "hoverView", "getHoverPopup", "", Constants.IntentExtraValue.SHOW, "dismiss", "setHoverScrollEnabled", "listView", "Landroid/widget/AbsListView;", "enable", "", "setGravity", "gravity", "setContent", "hoverPopup", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HoverCompatSdlImpl implements AbsHoverCompatImplFactory.IHoverCompatImpl {

        @NotNull
        private static final String TAG = "HoverDelegateSdlImpl";

        private final void setContent(Object hoverPopup, CharSequence text) {
            Method method;
            if (hoverPopup != null) {
                try {
                    method = hoverPopup.getClass().getMethod("setContent", CharSequence.class);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepSetContent() ", e);
                    return;
                } catch (NoSuchMethodException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepSetContent() ", e2);
                    return;
                } catch (InvocationTargetException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepSetContent() ", e3);
                    return;
                }
            } else {
                method = null;
            }
            if (method != null) {
                method.invoke(hoverPopup, text);
            }
        }

        private final Object setGravity(View view, int gravity) {
            Method method;
            Method method2;
            if (view != null) {
                try {
                    method = view.getClass().getMethod("getHoverPopup", null);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetGravity : ", e);
                } catch (IllegalArgumentException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetGravity : ", e2);
                } catch (NoSuchMethodException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetGravity : ", e3);
                } catch (InvocationTargetException e5) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetGravity : ", e5);
                }
            } else {
                method = null;
            }
            objInvoke = method != null ? method.invoke(view, null) : null;
            if (objInvoke != null && (method2 = objInvoke.getClass().getMethod("setPopupGravity", Integer.TYPE)) != null) {
                method2.invoke(objInvoke, Integer.valueOf(gravity));
                return objInvoke;
            }
            return objInvoke;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void dismiss(@Nullable View view) {
            Method method;
            Method method2;
            if (view != null) {
                try {
                    method = view.getClass().getMethod("getHoverPopup", null);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "dismiss() ", e);
                    return;
                } catch (NoSuchMethodException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "dismiss() ", e2);
                    return;
                } catch (InvocationTargetException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "dismiss() ", e3);
                    return;
                }
            } else {
                method = null;
            }
            Object objInvoke = method != null ? method.invoke(view, null) : null;
            if (objInvoke == null || (method2 = objInvoke.getClass().getMethod("dismiss", null)) == null) {
                return;
            }
            method2.invoke(objInvoke, null);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        @Nullable
        public Object getHoverPopup(@Nullable View view) {
            Method method;
            if (view != null) {
                try {
                    method = view.getClass().getMethod("getHoverPopupWindow", null);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepGetHoverPopup() ", e);
                } catch (NoSuchMethodException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepGetHoverPopup() ", e2);
                } catch (InvocationTargetException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepGetHoverPopup() ", e3);
                }
            } else {
                method = null;
            }
            if (method != null) {
                return method.invoke(view, null);
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setCustomView(@Nullable View view, @Nullable View customView) {
            setPopupType(view, 3);
            Object gravity = setGravity(view, 12849);
            if (gravity != null) {
                setContent(gravity, customView);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setHoverScrollEnabled(@Nullable AbsListView listView, boolean enable) {
            try {
                Method declaredMethod = AbsListView.class.getDeclaredMethod("setHoverScrollMode", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(listView, Boolean.FALSE);
            } catch (IllegalAccessException e) {
                LoggerBase.INSTANCE.m7134e("ViewCompat", e.getMessage(), e);
            } catch (NoSuchMethodException e2) {
                LoggerBase.INSTANCE.m7134e("ViewCompat", e2.getMessage(), e2);
            } catch (InvocationTargetException e3) {
                LoggerBase.INSTANCE.m7134e("ViewCompat", e3.getMessage(), e3);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setPopupType(@Nullable View view, int type) {
            Method method;
            if (view != null) {
                try {
                    method = view.getClass().getMethod("setHoverPopupType", Integer.TYPE);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetHoverPopupType() ", e);
                    return;
                } catch (NoSuchMethodException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetHoverPopupType() ", e2);
                    return;
                } catch (InvocationTargetException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sdlSetHoverPopupType() ", e3);
                    return;
                }
            } else {
                method = null;
            }
            if (method != null) {
                method.invoke(view, Integer.valueOf(type));
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setText(@Nullable View view, @Nullable CharSequence text) {
            Object hoverPopup = getHoverPopup(view);
            setPopupType(view, 2);
            if (hoverPopup != null) {
                setContent(hoverPopup, text);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setThumb(@Nullable View view, @Nullable View hoverView) {
            Object gravity;
            setPopupType(view, 3);
            WindowManagerCompat companion = WindowManagerCompat.INSTANCE.getInstance();
            Context context = view != null ? view.getContext() : null;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (companion.isFreeFormWindow((Activity) context)) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Context context2 = view.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                gravity = (view.getWidth() / 2) + iArr[0] < displayMetrics.widthPixels / 2 ? setGravity(view, 19) : setGravity(view, 21);
            } else {
                gravity = setGravity(view, 17);
            }
            if (gravity != null) {
                setContent(gravity, hoverView);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void show(@Nullable View view, int type) {
            Method method;
            Method method2;
            if (view != null) {
                try {
                    method = view.getClass().getMethod("getHoverPopup", null);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "show() ", e);
                    return;
                } catch (NoSuchMethodException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "show() ", e2);
                    return;
                } catch (InvocationTargetException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "show() ", e3);
                    return;
                }
            } else {
                method = null;
            }
            Object objInvoke = method != null ? method.invoke(view, null) : null;
            if (objInvoke == null || (method2 = objInvoke.getClass().getMethod(Constants.IntentExtraValue.SHOW, Integer.TYPE)) == null) {
                return;
            }
            method2.invoke(objInvoke, Integer.valueOf(type));
        }

        private final void setContent(Object hoverPopup, View view) {
            Method method;
            if (hoverPopup != null) {
                try {
                    method = hoverPopup.getClass().getMethod("setContent", View.class);
                } catch (IllegalAccessException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepSetContent() ", e);
                    return;
                } catch (NoSuchMethodException e2) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepSetContent() ", e2);
                    return;
                } catch (InvocationTargetException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "sepSetContent() ", e3);
                    return;
                }
            } else {
                method = null;
            }
            if (method != null) {
                method.invoke(hoverPopup, view);
            }
        }
    }
}
