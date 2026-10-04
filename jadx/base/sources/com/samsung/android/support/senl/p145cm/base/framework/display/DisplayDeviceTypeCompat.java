package com.samsung.android.support.senl.p145cm.base.framework.display;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p145cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.display.DisplayDeviceTypeImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/display/DisplayDeviceTypeCompat;", "", "impl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;)V", "mImpl", "setImpl", "", "getDisplayDeviceType", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "isSubDisplay", "", "isMainDisplay", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayDeviceTypeCompat {
    private static int DISPLAY_DEVICE_TYPE_MAIN = 0;

    @NotNull
    private static final String TAG = "DisplayDeviceTypeCompat";

    @Nullable
    private static DisplayDeviceTypeCompat mInstance;

    @NotNull
    private AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl mImpl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int DISPLAY_DEVICE_TYPE_NONE = -1;

    @JvmField
    public static int DISPLAY_DEVICE_TYPE_SUB = 5;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0012\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/display/DisplayDeviceTypeCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/display/DisplayDeviceTypeCompat;", "DISPLAY_DEVICE_TYPE_NONE", "", "getDISPLAY_DEVICE_TYPE_NONE", "()I", "setDISPLAY_DEVICE_TYPE_NONE", "(I)V", "DISPLAY_DEVICE_TYPE_MAIN", "getDISPLAY_DEVICE_TYPE_MAIN", "setDISPLAY_DEVICE_TYPE_MAIN", "DISPLAY_DEVICE_TYPE_SUB", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/display/DisplayDeviceTypeCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getDISPLAY_DEVICE_TYPE_MAIN() {
            return DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_MAIN;
        }

        public final int getDISPLAY_DEVICE_TYPE_NONE() {
            return DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_NONE;
        }

        @NotNull
        public final synchronized DisplayDeviceTypeCompat getInstance() {
            DisplayDeviceTypeCompat displayDeviceTypeCompat;
            try {
                if (DisplayDeviceTypeCompat.mInstance == null) {
                    DisplayDeviceTypeCompat.mInstance = new DisplayDeviceTypeCompat(new DisplayDeviceTypeImplFactory().create(DeviceInfo.isSemDevice()), null);
                }
                displayDeviceTypeCompat = DisplayDeviceTypeCompat.mInstance;
                Intrinsics.checkNotNull(displayDeviceTypeCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.display.DisplayDeviceTypeCompat");
            } catch (Throwable th) {
                throw th;
            }
            return displayDeviceTypeCompat;
        }

        public final void setDISPLAY_DEVICE_TYPE_MAIN(int i) {
            DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_MAIN = i;
        }

        public final void setDISPLAY_DEVICE_TYPE_NONE(int i) {
            DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_NONE = i;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DisplayDeviceTypeCompat(AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl iDisplayDeviceTypeImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iDisplayDeviceTypeImpl);
    }

    public final int getDisplayDeviceType(@Nullable Context context) {
        return this.mImpl.getDisplayDeviceType(context);
    }

    public final boolean isMainDisplay(@Nullable Configuration configuration) {
        return this.mImpl.isMainDisplay(configuration);
    }

    public final boolean isSubDisplay(@Nullable Configuration configuration) {
        return this.mImpl.isSubDisplay(configuration);
    }

    @VisibleForTesting
    public final void setImpl(@NotNull AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.mImpl = impl;
    }

    private DisplayDeviceTypeCompat(AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl iDisplayDeviceTypeImpl) {
        this.mImpl = iDisplayDeviceTypeImpl;
        setImpl(iDisplayDeviceTypeImpl);
    }

    public final int getDisplayDeviceType(@Nullable Configuration configuration) {
        return this.mImpl.getDisplayDeviceType(configuration);
    }
}
