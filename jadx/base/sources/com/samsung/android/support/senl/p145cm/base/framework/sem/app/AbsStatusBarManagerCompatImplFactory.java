package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$IStatusBarManagerCompatImpl;", "isSemDevice", "", "IStatusBarManagerCompatImpl", "StatusBarManagerDelegateSemUnderNMR1Impl", "StatusBarManagerCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsStatusBarManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "StatusBarManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$IStatusBarManagerCompatImpl;", "", "disable", "", "context", "Landroid/content/Context;", "what", "", "collapsePanels", "disableExpand", "getDisableExpand", "()I", "disableNone", "getDisableNone", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IStatusBarManagerCompatImpl {
        void collapsePanels(@Nullable Context context);

        void disable(@Nullable Context context, int what);

        int getDisableExpand();

        int getDisableNone();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$StatusBarManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$IStatusBarManagerCompatImpl;", "<init>", "()V", "disable", "", "context", "Landroid/content/Context;", "what", "", "collapsePanels", "disableExpand", "getDisableExpand", "()I", "disableNone", "getDisableNone", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class StatusBarManagerCompatPureImpl implements IStatusBarManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl
        public void collapsePanels(@Nullable Context context) {
            Object systemService;
            LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "collapsePanels ");
            if (context != null) {
                try {
                    systemService = context.getSystemService("statusbar");
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "collapsePanels, exception " + e);
                    return;
                }
            } else {
                systemService = null;
            }
            Method method = Class.forName("android.app.StatusBarManager").getMethod("collapsePanels", null);
            method.setAccessible(true);
            method.invoke(systemService, null);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl
        public void disable(@Nullable Context context, int what) {
            Object systemService;
            LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "disable " + what);
            if (context != null) {
                try {
                    systemService = context.getSystemService("statusbar");
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "disable, exception " + e);
                    return;
                }
            } else {
                systemService = null;
            }
            Method method = Class.forName("android.app.StatusBarManager").getMethod("disable", Integer.TYPE);
            method.setAccessible(true);
            method.invoke(systemService, Integer.valueOf(what));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl
        public int getDisableExpand() {
            return 65536;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl
        public int getDisableNone() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$StatusBarManagerDelegateSemUnderNMR1Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$StatusBarManagerCompatPureImpl;", "<init>", "()V", "disable", "", "context", "Landroid/content/Context;", "what", "", "collapsePanels", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StatusBarManagerDelegateSemUnderNMR1Impl extends StatusBarManagerCompatPureImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.StatusBarManagerCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl
        public void collapsePanels(@Nullable Context context) {
            Object systemService;
            LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "collapsePanels ");
            if (context != null) {
                try {
                    systemService = context.getSystemService("statusbar");
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "collapsePanels, exception " + e);
                    return;
                }
            } else {
                systemService = null;
            }
            Method method = Class.forName("android.app.StatusBarManager").getMethod("collapsePanels", null);
            method.setAccessible(true);
            method.invoke(systemService, null);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.StatusBarManagerCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl
        public void disable(@Nullable Context context, int what) {
            Object systemService;
            LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "disable " + what);
            if (context != null) {
                try {
                    systemService = context.getSystemService("statusbar");
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7132d(AbsStatusBarManagerCompatImplFactory.TAG, "disable, exception " + e);
                    return;
                }
            } else {
                systemService = null;
            }
            Method method = Class.forName("android.app.StatusBarManager").getMethod("disable", Integer.TYPE);
            method.setAccessible(true);
            method.invoke(systemService, Integer.valueOf(what));
        }
    }

    @NotNull
    public IStatusBarManagerCompatImpl create(boolean isSemDevice) {
        return isSemDevice ? new StatusBarManagerDelegateSemUnderNMR1Impl() : new StatusBarManagerCompatPureImpl();
    }
}
