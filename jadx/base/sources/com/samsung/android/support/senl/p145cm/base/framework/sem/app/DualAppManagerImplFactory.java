package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import com.samsung.android.app.SemDualAppManager;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsDualAppManagerCompatImplFactory;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/DualAppManagerImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDualAppManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDualAppManagerCompatImplFactory$IDualAppManagerCompatImpl;", "isSemDevice", "", "DualAppManagerCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DualAppManagerImplFactory extends AbsDualAppManagerCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/DualAppManagerImplFactory$DualAppManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDualAppManagerCompatImplFactory$IDualAppManagerCompatImpl;", "<init>", "()V", "isDualAppId", "", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "", "getAllWhitelistedPackages", "", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DualAppManagerCompatSemImpl implements AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl
        @Nullable
        public List<String> getAllWhitelistedPackages() {
            String[] allWhitelistedPackages = SemDualAppManager.getAllWhitelistedPackages();
            if (allWhitelistedPackages != null) {
                return ArraysKt.toList(allWhitelistedPackages);
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl
        public boolean isDualAppId(int userId) {
            return SemDualAppManager.isDualAppId(userId);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsDualAppManagerCompatImplFactory
    @NotNull
    public AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl create(boolean isSemDevice) {
        return isSemDevice ? new DualAppManagerCompatSemImpl() : super.create(isSemDevice);
    }
}
