package com.samsung.android.support.senl.p148nt.base.common.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/DocumentUpdateManager;", "", "<init>", "()V", "mObserverMap", "", "", "", "Lcom/samsung/android/support/senl/nt/base/common/data/DocumentUpdateManager$DocumentUpdateObserver;", "addObserver", "", "uuid", "observer", "removeObserver", "onCoEditDocumentClosed", "DocumentUpdateObserver", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocumentUpdateManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static DocumentUpdateManager sInstance;

    @NotNull
    private final Map<String, Set<DocumentUpdateObserver>> mObserverMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/DocumentUpdateManager$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/data/DocumentUpdateManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/data/DocumentUpdateManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized DocumentUpdateManager getInstance() {
            DocumentUpdateManager documentUpdateManager;
            try {
                if (DocumentUpdateManager.sInstance == null) {
                    DocumentUpdateManager.sInstance = new DocumentUpdateManager(null);
                }
                documentUpdateManager = DocumentUpdateManager.sInstance;
                Intrinsics.checkNotNull(documentUpdateManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.data.DocumentUpdateManager");
            } catch (Throwable th) {
                throw th;
            }
            return documentUpdateManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/DocumentUpdateManager$DocumentUpdateObserver;", "", "onCoEditDocumentClosed", "", "uuid", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DocumentUpdateObserver {
        void onCoEditDocumentClosed(@NotNull String uuid);
    }

    public /* synthetic */ DocumentUpdateManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public static final synchronized DocumentUpdateManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final synchronized void addObserver(@NotNull String uuid, @NotNull DocumentUpdateObserver observer) {
        try {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(observer, "observer");
            Set<DocumentUpdateObserver> hashSet = this.mObserverMap.get(uuid);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mObserverMap.put(uuid, hashSet);
            }
            hashSet.add(observer);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void onCoEditDocumentClosed(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Set<DocumentUpdateObserver> set = this.mObserverMap.get(uuid);
        if (set == null) {
            return;
        }
        Iterator it = new HashSet(set).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((DocumentUpdateObserver) it.next()).onCoEditDocumentClosed(uuid);
        }
    }

    public final synchronized void removeObserver(@NotNull String uuid, @NotNull DocumentUpdateObserver observer) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Set<DocumentUpdateObserver> set = this.mObserverMap.get(uuid);
        if (set == null) {
            return;
        }
        set.remove(observer);
        if (set.isEmpty()) {
            this.mObserverMap.remove(uuid);
        }
    }

    private DocumentUpdateManager() {
        this.mObserverMap = new ConcurrentHashMap();
    }
}
