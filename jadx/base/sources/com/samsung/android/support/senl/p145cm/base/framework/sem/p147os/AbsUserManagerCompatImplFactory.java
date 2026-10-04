package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;", HandoffConstant.KEY_DEVICE_TYPE, "", "IUserManagerCompat", "Pure", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsUserManagerCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;", "", "isGuestMode", "", "context", "Landroid/content/Context;", "isDigitalLegacyMode", "isFeatureSupportDigitalLegacy", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IUserManagerCompat {
        boolean isDigitalLegacyMode(@Nullable Context context);

        boolean isFeatureSupportDigitalLegacy();

        boolean isGuestMode(@Nullable Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$Pure;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;", "<init>", "()V", "isGuestMode", "", "context", "Landroid/content/Context;", "isDigitalLegacyMode", "isFeatureSupportDigitalLegacy", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Pure implements IUserManagerCompat {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isDigitalLegacyMode(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isFeatureSupportDigitalLegacy() {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isGuestMode(@Nullable Context context) {
            return false;
        }
    }

    @NotNull
    public IUserManagerCompat create(int deviceType) {
        return new Pure();
    }
}
