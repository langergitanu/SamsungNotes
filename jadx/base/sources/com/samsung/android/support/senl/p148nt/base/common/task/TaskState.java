package com.samsung.android.support.senl.p148nt.base.common.task;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/TaskState;", "", "<init>", "()V", "setIsRunning", "", "type", "", "isRunning", "", "countUp", "countDown", "getInfo", "Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$TaskStateInfo;", "isSyncBlocked", "()Z", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$TaskStateListener;", "removeListener", PackageRelationship.TYPE_ATTRIBUTE_NAME, "TaskStateInfo", "TaskStateListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TaskState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "TaskState";

    @NotNull
    private static final Map<String, TaskStateInfo> sInfo = new ConcurrentHashMap();

    @Nullable
    private static TaskState sInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInfo", "", "Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$TaskStateInfo;", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/task/TaskState;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/task/TaskState;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized TaskState getInstance() {
            TaskState taskState;
            try {
                if (TaskState.sInstance == null) {
                    TaskState.sInstance = new TaskState(null);
                }
                taskState = TaskState.sInstance;
                Intrinsics.checkNotNull(taskState);
            } catch (Throwable th) {
                throw th;
            }
            return taskState;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$TaskStateInfo;", "", "mType", "", "<init>", "(Ljava/lang/String;)V", "mIsRunning", "", "value", "", "count", "getCount", "()I", "mListeners", "", "Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$TaskStateListener;", "isRunning", "()Z", "setRunning", "(Z)V", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "notifyStateChanged", "countUp", "countDown", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TaskStateInfo {
        private int count;
        private boolean mIsRunning;

        @NotNull
        private final Set<TaskStateListener> mListeners;

        @Type
        @NotNull
        private final String mType;

        public TaskStateInfo(@Type @NotNull String mType) {
            Intrinsics.checkNotNullParameter(mType, "mType");
            this.mType = mType;
            this.mListeners = new HashSet();
        }

        private final synchronized void notifyStateChanged() {
            Iterator it = new HashSet(this.mListeners).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                ((TaskStateListener) next).onTaskStateChanged(this.mType, this.mIsRunning);
            }
        }

        public final synchronized void addListener(@NotNull TaskStateListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mListeners.add(listener);
        }

        public final synchronized void countDown() {
            this.count = (int) Math.max(0.0d, this.count - 1);
        }

        public final synchronized void countUp() {
            this.count++;
        }

        public final int getCount() {
            return this.count;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized boolean isRunning() {
            boolean z;
            if (!this.mIsRunning) {
                z = this.count > 0;
            }
            return z;
        }

        public final synchronized void removeListener(@NotNull TaskStateListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mListeners.remove(listener);
        }

        public final synchronized void setRunning(boolean z) {
            if (this.mIsRunning != z) {
                this.mIsRunning = z;
                notifyStateChanged();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$TaskStateListener;", "", "onTaskStateChanged", "", "taskType", "", "isRunning", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TaskStateListener {
        void onTaskStateChanged(@Nullable String taskType, boolean isRunning);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$Type;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Type {

        @NotNull
        public static final String COEDIT_SERVICE = "COEDIT_SERVICE";

        @NotNull
        public static final String CONVERT = "CONVERT";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String DELETE_DATA = "DELETE_DATA";

        @NotNull
        public static final String DOC_SERVICE = "DOC_SERVICE";

        @NotNull
        public static final String DUPLICATE_NOTES = "DUPLICATE_NOTES";

        @NotNull
        public static final String IMPORT_BY_NOTEPICKER = "IMPORT_BY_NOTEPICKER";

        @NotNull
        public static final String IMPORT_BY_SETTING = "IMPORT_BY_SETTING";

        @NotNull
        public static final String IMPORT_CLOUD_DATA_BY_SETTING = "IMPORT_CLOUD_DATA_BY_SETTING";

        @NotNull
        public static final String RESTORE_DATA = "RESTORE_DATA";

        @NotNull
        public static final String RESTORE_TASK = "RESTORE_TASK";

        @NotNull
        public static final String TRIGGER = "TRIGGER";

        @NotNull
        public static final String WIDGET_CAPTURE_TEXT_ONLY_NOTE = "WIDGET_CAPTURE_TEXT_ONLY_NOTE";

        @NotNull
        public static final String WIDGET_CREATE_THUMBNAIL = "WIDGET_CREATE_THUMBNAIL";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/TaskState$Type$Companion;", "", "<init>", "()V", "DOC_SERVICE", "", "CONVERT", "DELETE_DATA", "RESTORE_DATA", "RESTORE_TASK", "TRIGGER", "IMPORT_BY_SETTING", "IMPORT_CLOUD_DATA_BY_SETTING", "IMPORT_BY_NOTEPICKER", "DUPLICATE_NOTES", "COEDIT_SERVICE", "WIDGET_CAPTURE_TEXT_ONLY_NOTE", "WIDGET_CREATE_THUMBNAIL", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String COEDIT_SERVICE = "COEDIT_SERVICE";

            @NotNull
            public static final String CONVERT = "CONVERT";

            @NotNull
            public static final String DELETE_DATA = "DELETE_DATA";

            @NotNull
            public static final String DOC_SERVICE = "DOC_SERVICE";

            @NotNull
            public static final String DUPLICATE_NOTES = "DUPLICATE_NOTES";

            @NotNull
            public static final String IMPORT_BY_NOTEPICKER = "IMPORT_BY_NOTEPICKER";

            @NotNull
            public static final String IMPORT_BY_SETTING = "IMPORT_BY_SETTING";

            @NotNull
            public static final String IMPORT_CLOUD_DATA_BY_SETTING = "IMPORT_CLOUD_DATA_BY_SETTING";

            @NotNull
            public static final String RESTORE_DATA = "RESTORE_DATA";

            @NotNull
            public static final String RESTORE_TASK = "RESTORE_TASK";

            @NotNull
            public static final String TRIGGER = "TRIGGER";

            @NotNull
            public static final String WIDGET_CAPTURE_TEXT_ONLY_NOTE = "WIDGET_CAPTURE_TEXT_ONLY_NOTE";

            @NotNull
            public static final String WIDGET_CREATE_THUMBNAIL = "WIDGET_CREATE_THUMBNAIL";

            private Companion() {
            }
        }
    }

    public /* synthetic */ TaskState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final synchronized TaskStateInfo getInfo(@Type String type) {
        TaskStateInfo taskStateInfo;
        Map<String, TaskStateInfo> map = sInfo;
        taskStateInfo = map.get(type);
        if (taskStateInfo == null) {
            taskStateInfo = new TaskStateInfo(type);
            map.put(type, taskStateInfo);
        }
        return taskStateInfo;
    }

    public final void addListener(@Type @NotNull String type, @NotNull TaskStateListener listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        getInfo(type).addListener(listener);
    }

    public final synchronized void countDown(@Type @NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TaskStateInfo info = getInfo(type);
        Logger.m8702i(TAG, "type: " + type + ", countDown: " + info.getCount() + " > " + (info.getCount() - 1));
        info.countDown();
    }

    public final synchronized void countUp(@Type @NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TaskStateInfo info = getInfo(type);
        Logger.m8702i(TAG, "type: " + type + ", countUp: " + info.getCount() + " > " + (info.getCount() + 1));
        info.countUp();
    }

    public final synchronized boolean isRunning(@Type @NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return getInfo(type).isRunning();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean isSyncBlocked() {
        boolean z;
        if (getInfo("CONVERT").isRunning() || getInfo("RESTORE_TASK").isRunning()) {
            z = true;
        } else if (!getInfo("COEDIT_SERVICE").isRunning()) {
            z = false;
        }
        return z;
    }

    public final void removeListener(@Type @NotNull String type, @NotNull TaskStateListener listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        getInfo(type).removeListener(listener);
    }

    public final synchronized void setIsRunning(@Type @NotNull String type, boolean isRunning) {
        Intrinsics.checkNotNullParameter(type, "type");
        Logger.m8702i(TAG, "type: " + type + ", isRunning: " + isRunning);
        getInfo(type).setRunning(isRunning);
    }

    private TaskState() {
    }
}
