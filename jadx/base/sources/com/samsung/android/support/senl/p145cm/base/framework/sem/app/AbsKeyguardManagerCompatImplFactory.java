package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;", "isSemDevice", "", "IKeyguardManagerCompatImpl", "KeyguardManagerCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsKeyguardManagerCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;", "", "requestDismissKeyguard", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "semSetPendingIntentAfterUnlock", "context", "Landroid/content/Context;", "p", "Landroid/app/PendingIntent;", "fillInIntent", "Landroid/content/Intent;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IKeyguardManagerCompatImpl {
        void requestDismissKeyguard(@Nullable Activity activity, @Nullable KeyguardManager.KeyguardDismissCallback callback);

        void semSetPendingIntentAfterUnlock(@NotNull Context context, @NotNull PendingIntent p, @NotNull Intent fillInIntent);
    }

    @NotNull
    public IKeyguardManagerCompatImpl create(boolean isSemDevice) {
        return new KeyguardManagerCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$KeyguardManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;", "<init>", "()V", "requestDismissKeyguard", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "semSetPendingIntentAfterUnlock", "context", "Landroid/content/Context;", "p", "Landroid/app/PendingIntent;", "fillInIntent", "Landroid/content/Intent;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class KeyguardManagerCompatPureImpl implements IKeyguardManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl
        public void semSetPendingIntentAfterUnlock(@NotNull Context context, @NotNull PendingIntent p, @NotNull Intent fillInIntent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(fillInIntent, "fillInIntent");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl
        public void requestDismissKeyguard(@Nullable Activity activity, @Nullable KeyguardManager.KeyguardDismissCallback callback) {
        }
    }
}
