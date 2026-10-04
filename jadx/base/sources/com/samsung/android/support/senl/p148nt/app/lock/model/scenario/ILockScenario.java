package com.samsung.android.support.senl.p148nt.app.lock.model.scenario;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R&\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/scenario/ILockScenario;", "", "nextViewType", "", "getNextViewType", "()I", "insertFront", "", "lockViewType", "hasNext", "", "viewQueue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getViewQueue", "()Ljava/util/ArrayList;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILockScenario {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int SCENARIO_CHANGE_PASSWORD = 2;
    public static final int SCENARIO_CREATE_PASSWORD = 1;
    public static final int SCENARIO_CREATE_PASSWORD_NO_ACCOUNT_CHECK = 11;
    public static final int SCENARIO_NONE = 0;
    public static final int SCENARIO_VERIFY = 5;
    public static final int SCENARIO_VERIFY_BACKUP_PASSWORD = 6;
    public static final int SCENARIO_VERIFY_PASSWORD = 3;
    public static final int SCENARIO_VERIFY_PASSWORD_FOR_BIOMETRIC = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/scenario/ILockScenario$Companion;", "", "<init>", "()V", "SCENARIO_NONE", "", "SCENARIO_CREATE_PASSWORD", "SCENARIO_CREATE_PASSWORD_NO_ACCOUNT_CHECK", "SCENARIO_CHANGE_PASSWORD", "SCENARIO_VERIFY_PASSWORD", "SCENARIO_VERIFY_PASSWORD_FOR_BIOMETRIC", "SCENARIO_VERIFY", "SCENARIO_VERIFY_BACKUP_PASSWORD", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SCENARIO_CHANGE_PASSWORD = 2;
        public static final int SCENARIO_CREATE_PASSWORD = 1;
        public static final int SCENARIO_CREATE_PASSWORD_NO_ACCOUNT_CHECK = 11;
        public static final int SCENARIO_NONE = 0;
        public static final int SCENARIO_VERIFY = 5;
        public static final int SCENARIO_VERIFY_BACKUP_PASSWORD = 6;
        public static final int SCENARIO_VERIFY_PASSWORD = 3;
        public static final int SCENARIO_VERIFY_PASSWORD_FOR_BIOMETRIC = 4;

        private Companion() {
        }
    }

    int getNextViewType();

    @Nullable
    ArrayList<Integer> getViewQueue();

    boolean hasNext();

    void insertFront(int lockViewType);
}
