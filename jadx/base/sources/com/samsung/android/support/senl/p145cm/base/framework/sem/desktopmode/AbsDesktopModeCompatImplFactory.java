package com.samsung.android.support.senl.p145cm.base.framework.sem.desktopmode;

import android.content.Context;
import com.samsung.android.settings.search.provider.SecSearchIndexablesContract;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IDesktopModeCompatImpl", "DexModeCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsDesktopModeCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$DexModeCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl;", "<init>", "()V", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "context", "Landroid/content/Context;", "getDexModeType", "", "getScreenLocation", "isDexModeType", "type", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DexModeCompatPureImpl implements IDesktopModeCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getDexModeType(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getScreenLocation(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexMode(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexModeType(@Nullable Context context, int type) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isSupportedWindowingMode() {
            return IDesktopModeCompatImpl.DefaultImpls.isSupportedWindowingMode(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl;", "", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "context", "Landroid/content/Context;", "getDexModeType", "", "getScreenLocation", "isDexModeType", "type", "isSupportedWindowingMode", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDesktopModeCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int DEX_DUAL_MODE = 36864;
        public static final int DEX_NEW_DEX_MODE = 40960;
        public static final int DEX_OFF_MODE = 0;
        public static final int DEX_ON_DEVICE = 512;
        public static final int DEX_ON_MODE = 32768;
        public static final int DEX_ON_SCREEN = 256;
        public static final int DEX_STAND_ALONE_MODE = 32768;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl$Companion;", "", "<init>", "()V", "DEX_OFF_MODE", "", "DEX_ON_MODE", "DEX_STAND_ALONE_MODE", "DEX_DUAL_MODE", "DEX_NEW_DEX_MODE", "DEX_ON_SCREEN", "DEX_ON_DEVICE", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DEX_DUAL_MODE = 36864;
            public static final int DEX_NEW_DEX_MODE = 40960;
            public static final int DEX_OFF_MODE = 0;
            public static final int DEX_ON_DEVICE = 512;
            public static final int DEX_ON_MODE = 32768;
            public static final int DEX_ON_SCREEN = 256;
            public static final int DEX_STAND_ALONE_MODE = 32768;

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static boolean isSupportedWindowingMode(@NotNull IDesktopModeCompatImpl iDesktopModeCompatImpl) {
                return false;
            }
        }

        int getDexModeType(@Nullable Context context);

        int getScreenLocation(@Nullable Context context);

        boolean isDexMode(@Nullable Context context);

        boolean isDexModeType(@Nullable Context context, int type);

        boolean isSupportedWindowingMode();
    }

    @NotNull
    public IDesktopModeCompatImpl create(int deviceType) {
        return new DexModeCompatPureImpl();
    }
}
