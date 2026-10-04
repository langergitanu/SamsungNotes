package com.samsung.android.support.senl.p145cm.base.framework.sem.display;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/display/DisplayDeviceTypeImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;", "isSemDevice", "", "DisplayDeviceSemPosCompat", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayDeviceTypeImplFactory extends AbsDisplayDeviceTypeImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/display/DisplayDeviceTypeImplFactory$DisplayDeviceSemPosCompat;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;", "<init>", "()V", "getDisplayDeviceType", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "isMainDisplay", "", "isSubDisplay", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DisplayDeviceSemPosCompat implements AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public int getDisplayDeviceType(@Nullable Context context) {
            Resources resources;
            return getDisplayDeviceType((context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration());
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public boolean isMainDisplay(@Nullable Configuration configuration) {
            return getDisplayDeviceType(configuration) == 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public boolean isSubDisplay(@Nullable Configuration configuration) {
            return getDisplayDeviceType(configuration) == 5;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public int getDisplayDeviceType(@Nullable Configuration configuration) {
            Integer numValueOf;
            if (configuration != null) {
                try {
                    numValueOf = Integer.valueOf(configuration.semDisplayDeviceType);
                } catch (NoSuchFieldError e) {
                    LoggerBase.INSTANCE.m7133e(AbsDisplayDeviceTypeImplFactory.TAG, e.getMessage());
                    return -1;
                }
            } else {
                numValueOf = null;
            }
            Intrinsics.checkNotNull(numValueOf);
            return numValueOf.intValue();
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory
    @NotNull
    public AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl create(boolean isSemDevice) {
        return (!isSemDevice || Build.VERSION.SDK_INT < 28) ? super.create(isSemDevice) : new DisplayDeviceSemPosCompat();
    }
}
