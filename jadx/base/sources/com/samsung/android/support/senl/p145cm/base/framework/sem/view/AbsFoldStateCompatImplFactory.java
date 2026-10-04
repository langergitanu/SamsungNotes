package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl;", "isFoldableDevice", "", "IFoldStateCompatImpl", "FoldStateChangeListener", "FolderStateCallback", "FoldStateCompatGeneralFormImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsFoldStateCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;", "", "<init>", "()V", "mProxy", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", "getMProxy", "()Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", "setMProxy", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;)V", "onChanged", "", "b", "", "FoldStateProxy", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class FoldStateChangeListener {

        @Nullable
        private FoldStateProxy mProxy;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", "", "register", "", "unregister", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public interface FoldStateProxy {
            void register();

            void unregister();
        }

        @Nullable
        public final FoldStateProxy getMProxy() {
            return this.mProxy;
        }

        public abstract void onChanged(boolean b);

        public final void setMProxy(@Nullable FoldStateProxy foldStateProxy) {
            this.mProxy = foldStateProxy;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateCompatGeneralFormImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl;", "<init>", "()V", "setFolderStateCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;", "createProxy", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FoldStateCompatGeneralFormImpl implements IFoldStateCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.IFoldStateCompatImpl
        @NotNull
        public FoldStateChangeListener.FoldStateProxy createProxy(@Nullable FoldStateChangeListener listener) {
            return new FoldStateChangeListener.FoldStateProxy() { // from class: com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory$FoldStateCompatGeneralFormImpl$createProxy$1
                @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy
                public void register() {
                }

                @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy
                public void unregister() {
                }
            };
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.IFoldStateCompatImpl
        public void setFolderStateCallback(@Nullable FolderStateCallback callback) {
            if (callback != null) {
                callback.onFailed();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;", "", "onSuccess", "", "foldState", "", "onFailed", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface FolderStateCallback {
        void onFailed();

        void onSuccess(int foldState);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl;", "", "setFolderStateCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;", "createProxy", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IFoldStateCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FOLD_STATE_CLOSED = 1;
        public static final int FOLD_STATE_FLIPPED = 4;
        public static final int FOLD_STATE_FULL_OPENED = 3;
        public static final int FOLD_STATE_HALF_OPENED = 2;
        public static final int FOLD_STATE_NONE = 0;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl$Companion;", "", "<init>", "()V", "FOLD_STATE_NONE", "", "FOLD_STATE_CLOSED", "FOLD_STATE_HALF_OPENED", "FOLD_STATE_FULL_OPENED", "FOLD_STATE_FLIPPED", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int FOLD_STATE_CLOSED = 1;
            public static final int FOLD_STATE_FLIPPED = 4;
            public static final int FOLD_STATE_FULL_OPENED = 3;
            public static final int FOLD_STATE_HALF_OPENED = 2;
            public static final int FOLD_STATE_NONE = 0;

            private Companion() {
            }
        }

        @Nullable
        FoldStateChangeListener.FoldStateProxy createProxy(@Nullable FoldStateChangeListener listener);

        void setFolderStateCallback(@Nullable FolderStateCallback callback);
    }

    @NotNull
    public IFoldStateCompatImpl create(boolean isFoldableDevice) {
        return new FoldStateCompatGeneralFormImpl();
    }
}
