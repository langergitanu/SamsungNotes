package com.samsung.android.support.senl.p148nt.base.common.data;

import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0002#$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0006J\u001a\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u0014\u0010\u0015\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u0006\u0010\u0016\u001a\u00020\tJ\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u001e\u0010\u0018\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0006J\u001e\u0010\u001b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/DataUpdateManager;", "", "<init>", "()V", "observers", "", "", "Lcom/samsung/android/support/senl/nt/base/common/data/DataUpdateManager$DataUpdateObserver;", "addObserver", "", "type", "observer", "onDataUpdated", "source", "onDocumentFileDeleted", "uuid", "", "onDocumentLocked", "uuids", "", "onDocumentUnlocked", "onDocumentUpdated", "onFolderUpdated", "onDocumentMovedToTrash", "onDocumentDeleted", "", "deletedBy", "onFolderDeleted", "onOldNoteSaved", "savePath", "onOldNoteRestored", "observersToNotify", "", "getObserversToNotify", "()Ljava/util/Set;", "DataUpdateObserver", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DataUpdateManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static DataUpdateManager sInstance;

    @NotNull
    private final Map<Integer, DataUpdateObserver> observers;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/DataUpdateManager$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/data/DataUpdateManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/data/DataUpdateManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized DataUpdateManager getInstance() {
            DataUpdateManager dataUpdateManager;
            try {
                if (DataUpdateManager.sInstance == null) {
                    DataUpdateManager.sInstance = new DataUpdateManager(null);
                }
                dataUpdateManager = DataUpdateManager.sInstance;
                Intrinsics.checkNotNull(dataUpdateManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.data.DataUpdateManager");
            } catch (Throwable th) {
                throw th;
            }
            return dataUpdateManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J \u0010\u0012\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J \u0010\u0015\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\u0003H&¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/DataUpdateManager$DataUpdateObserver;", "", "onDataUpdated", "", "source", "", "type", "onSearchDataCollected", "uuid", "", "onDocumentFileDeleted", "onDocumentLocked", "uuids", "", "onDocumentUnlocked", "onDocumentUpdated", "onFolderUpdated", "onDocumentMovedToTrash", "onDocumentDeleted", "", "deletedBy", "onFolderDeleted", "onOldNoteSaved", "savePath", "onOldNoteRestored", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DataUpdateObserver {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void onFolderUpdated(@NotNull DataUpdateObserver dataUpdateObserver) {
            }
        }

        void onDataUpdated(@DataBaseConstants.Source int source, @DataBaseConstants.EventType int type);

        void onDocumentDeleted(@NotNull List<String> uuids, @DataBaseConstants.DeletedBy int deletedBy);

        void onDocumentFileDeleted(@NotNull String uuid);

        void onDocumentLocked(@NotNull Collection<String> uuids);

        void onDocumentMovedToTrash(@NotNull Collection<String> uuids);

        void onDocumentUnlocked(@NotNull Collection<String> uuids);

        void onDocumentUpdated(@NotNull Collection<String> uuids);

        void onFolderDeleted(@NotNull List<String> uuids, @DataBaseConstants.DeletedBy int deletedBy);

        void onFolderUpdated();

        void onOldNoteRestored();

        void onOldNoteSaved(@NotNull String uuid, @NotNull String savePath);

        void onSearchDataCollected(@NotNull String uuid);
    }

    public /* synthetic */ DataUpdateManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public static final synchronized DataUpdateManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final synchronized Set<DataUpdateObserver> getObserversToNotify() {
        return new HashSet(this.observers.values());
    }

    public final synchronized void addObserver(@DataBaseConstants.ObserverType int type, @NotNull DataUpdateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.put(Integer.valueOf(type), observer);
    }

    public final void onDataUpdated(@DataBaseConstants.EventType int type) {
        onDataUpdated(0, type);
    }

    public final void onDocumentDeleted(@NotNull List<String> uuids, @DataBaseConstants.DeletedBy int deletedBy) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDocumentDeleted(uuids, deletedBy);
        }
    }

    public final void onDocumentFileDeleted(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDocumentFileDeleted(uuid);
        }
    }

    public final void onDocumentLocked(@NotNull Collection<String> uuids) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDocumentLocked(uuids);
        }
    }

    public final void onDocumentMovedToTrash(@NotNull Collection<String> uuids) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDocumentMovedToTrash(uuids);
        }
    }

    public final void onDocumentUnlocked(@NotNull Collection<String> uuids) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDocumentUnlocked(uuids);
        }
    }

    public final void onDocumentUpdated(@NotNull Collection<String> uuids) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDocumentUpdated(uuids);
        }
    }

    public final void onFolderDeleted(@NotNull List<String> uuids, @DataBaseConstants.DeletedBy int deletedBy) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onFolderDeleted(uuids, deletedBy);
        }
    }

    public final void onFolderUpdated() {
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onFolderUpdated();
        }
    }

    public final void onOldNoteRestored() {
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onOldNoteRestored();
        }
    }

    public final void onOldNoteSaved(@NotNull String uuid, @NotNull String savePath) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onOldNoteSaved(uuid, savePath);
        }
    }

    private DataUpdateManager() {
        this.observers = new HashMap();
    }

    public final void onDataUpdated(@DataBaseConstants.Source int source, @DataBaseConstants.EventType int type) {
        Iterator<DataUpdateObserver> it = getObserversToNotify().iterator();
        while (it.hasNext()) {
            it.next().onDataUpdated(source, type);
        }
    }
}
