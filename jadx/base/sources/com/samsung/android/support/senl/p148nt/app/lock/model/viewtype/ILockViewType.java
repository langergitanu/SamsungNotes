package com.samsung.android.support.senl.p148nt.app.lock.model.viewtype;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/viewtype/ILockViewType;", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILockViewType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int VIEW_TYPE_CREATE_PASSWORD = 1;
    public static final int VIEW_TYPE_CREATE_PASSWORD_NO_ACCOUNT_CHECK = 11;
    public static final int VIEW_TYPE_NONE = -1;
    public static final int VIEW_TYPE_VERIFY_BACKUP_PASSWORD = 7;
    public static final int VIEW_TYPE_VERIFY_BACKUP_PASSWORD_ONLY = 8;
    public static final int VIEW_TYPE_VERIFY_CHANGE_PASSWORD = 6;
    public static final int VIEW_TYPE_VERIFY_FINGER = 3;
    public static final int VIEW_TYPE_VERIFY_FINGER_AND_IRIS = 5;
    public static final int VIEW_TYPE_VERIFY_FINGER_OLD = 31;
    public static final int VIEW_TYPE_VERIFY_IRIS = 4;
    public static final int VIEW_TYPE_VERIFY_IRIS_OLD = 41;
    public static final int VIEW_TYPE_VERIFY_PASSWORD = 2;
    public static final int VIEW_TYPE_VERIFY_PASSWORD_NO_BIOMETRIC_CHECKBOX = 21;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/viewtype/ILockViewType$Companion;", "", "<init>", "()V", "VIEW_TYPE_NONE", "", "VIEW_TYPE_CREATE_PASSWORD", "VIEW_TYPE_CREATE_PASSWORD_NO_ACCOUNT_CHECK", "VIEW_TYPE_VERIFY_PASSWORD", "VIEW_TYPE_VERIFY_PASSWORD_NO_BIOMETRIC_CHECKBOX", "VIEW_TYPE_VERIFY_FINGER", "VIEW_TYPE_VERIFY_FINGER_OLD", "VIEW_TYPE_VERIFY_IRIS", "VIEW_TYPE_VERIFY_IRIS_OLD", "VIEW_TYPE_VERIFY_FINGER_AND_IRIS", "VIEW_TYPE_VERIFY_CHANGE_PASSWORD", "VIEW_TYPE_VERIFY_BACKUP_PASSWORD", "VIEW_TYPE_VERIFY_BACKUP_PASSWORD_ONLY", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int VIEW_TYPE_CREATE_PASSWORD = 1;
        public static final int VIEW_TYPE_CREATE_PASSWORD_NO_ACCOUNT_CHECK = 11;
        public static final int VIEW_TYPE_NONE = -1;
        public static final int VIEW_TYPE_VERIFY_BACKUP_PASSWORD = 7;
        public static final int VIEW_TYPE_VERIFY_BACKUP_PASSWORD_ONLY = 8;
        public static final int VIEW_TYPE_VERIFY_CHANGE_PASSWORD = 6;
        public static final int VIEW_TYPE_VERIFY_FINGER = 3;
        public static final int VIEW_TYPE_VERIFY_FINGER_AND_IRIS = 5;
        public static final int VIEW_TYPE_VERIFY_FINGER_OLD = 31;
        public static final int VIEW_TYPE_VERIFY_IRIS = 4;
        public static final int VIEW_TYPE_VERIFY_IRIS_OLD = 41;
        public static final int VIEW_TYPE_VERIFY_PASSWORD = 2;
        public static final int VIEW_TYPE_VERIFY_PASSWORD_NO_BIOMETRIC_CHECKBOX = 21;

        private Companion() {
        }
    }
}
