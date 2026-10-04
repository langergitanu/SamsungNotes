package com.samsung.android.support.senl.p145cm.base.framework.sem.display;

import android.content.Context;
import android.content.res.Configuration;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;", "isSemDevice", "", "IDisplayDeviceTypeImpl", "DisplayDevicePureCompat", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsDisplayDeviceTypeImplFactory {

    @NotNull
    public static final String TAG = "DisplayDeviceTypeCompat";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$DisplayDevicePureCompat;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;", "<init>", "()V", "getDisplayDeviceType", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "isMainDisplay", "", "isSubDisplay", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DisplayDevicePureCompat implements IDisplayDeviceTypeImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public int getDisplayDeviceType(@Nullable Context context) {
            return -1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public boolean isMainDisplay(@Nullable Configuration configuration) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public boolean isSubDisplay(@Nullable Configuration configuration) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.display.AbsDisplayDeviceTypeImplFactory.IDisplayDeviceTypeImpl
        public int getDisplayDeviceType(@Nullable Configuration configuration) {
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl;", "", "getDisplayDeviceType", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "isMainDisplay", "", "isSubDisplay", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDisplayDeviceTypeImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int DISPLAY_DEVICE_TYPE_MAIN = 0;
        public static final int DISPLAY_DEVICE_TYPE_NONE = -1;
        public static final int DISPLAY_DEVICE_TYPE_SUB = 5;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/display/AbsDisplayDeviceTypeImplFactory$IDisplayDeviceTypeImpl$Companion;", "", "<init>", "()V", "DISPLAY_DEVICE_TYPE_NONE", "", "DISPLAY_DEVICE_TYPE_MAIN", "DISPLAY_DEVICE_TYPE_SUB", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DISPLAY_DEVICE_TYPE_MAIN = 0;
            public static final int DISPLAY_DEVICE_TYPE_NONE = -1;
            public static final int DISPLAY_DEVICE_TYPE_SUB = 5;

            private Companion() {
            }
        }

        int getDisplayDeviceType(@Nullable Context context);

        int getDisplayDeviceType(@Nullable Configuration configuration);

        boolean isMainDisplay(@Nullable Configuration configuration);

        boolean isSubDisplay(@Nullable Configuration configuration);
    }

    @NotNull
    public IDisplayDeviceTypeImpl create(boolean isSemDevice) {
        return new DisplayDevicePureCompat();
    }
}
