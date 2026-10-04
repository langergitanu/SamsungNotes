package com.samsung.android.support.senl.p148nt.base.common.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheMap;", "", "<init>", "()V", "mNoteInfoMap", "", "", "Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheMap$NoteInfo;", "getNoteInfo", "uuid", "release", "", "NoteInfo", "MapContract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoeditCacheMap {

    @NotNull
    public static final CoeditCacheMap INSTANCE = new CoeditCacheMap();

    @NotNull
    private static final Map<String, NoteInfo> mNoteInfoMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheMap$MapContract;", "", "getEntry", "", "key", "", "value", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface MapContract {
        void getEntry(@Nullable String key, @Nullable String value);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#J\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheMap$NoteInfo;", "", "uuid", "", "<init>", "(Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "mUndownloadedStroke", "", "mDownloadedStroke", "mUndownloadedStrokeLock", "mDownloadedStrokeLock", "isRestored", "", "()Z", "setRestored", "(Z)V", "isReleased", "setReleased", "undownloadedStroke", "getUndownloadedStroke", "()Ljava/util/Map;", "downloadedStroke", "getDownloadedStroke", "removeUndownloadedStroke", "", "key", "removeDownloadedStroke", "putUndownloadedStroke", "value", "putDownloadedStroke", "containsDownloadedStrokeKey", "getUndownloadedStrokeEntrySet", "mapContract", "Lcom/samsung/android/support/senl/nt/base/common/util/CoeditCacheMap$MapContract;", "getDownloadedStrokeEntrySet", "clearUndownloadedStroke", "clearDownloadedStroke", "undownloadedStrokeSize", "", "getUndownloadedStrokeSize", "()I", "downloadedStrokeSize", "getDownloadedStrokeSize", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class NoteInfo {
        private boolean isReleased;
        private boolean isRestored;

        @NotNull
        private final Map<String, String> mDownloadedStroke;

        @NotNull
        private final Object mDownloadedStrokeLock;

        @NotNull
        private final Map<String, String> mUndownloadedStroke;

        @NotNull
        private final Object mUndownloadedStrokeLock;

        @NotNull
        private final String uuid;

        public NoteInfo(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.uuid = uuid;
            this.mUndownloadedStroke = new ConcurrentHashMap();
            this.mDownloadedStroke = new ConcurrentHashMap();
            this.mUndownloadedStrokeLock = new Object();
            this.mDownloadedStrokeLock = new Object();
        }

        private final Map<String, String> getDownloadedStroke() {
            Map<String, String> map;
            synchronized (this.mDownloadedStrokeLock) {
                map = this.mDownloadedStroke;
            }
            return map;
        }

        private final Map<String, String> getUndownloadedStroke() {
            Map<String, String> map;
            synchronized (this.mUndownloadedStrokeLock) {
                map = this.mUndownloadedStroke;
            }
            return map;
        }

        public final void clearDownloadedStroke() {
            getDownloadedStroke().clear();
        }

        public final void clearUndownloadedStroke() {
            getUndownloadedStroke().clear();
        }

        public final boolean containsDownloadedStrokeKey(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return getDownloadedStroke().containsKey(key);
        }

        public final void getDownloadedStrokeEntrySet(@NotNull MapContract mapContract) {
            Intrinsics.checkNotNullParameter(mapContract, "mapContract");
            synchronized (this.mDownloadedStrokeLock) {
                try {
                    for (Map.Entry<String, String> entry : this.mDownloadedStroke.entrySet()) {
                        mapContract.getEntry(entry.getKey(), entry.getValue());
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int getDownloadedStrokeSize() {
            return getDownloadedStroke().size();
        }

        public final void getUndownloadedStrokeEntrySet(@NotNull MapContract mapContract) {
            Intrinsics.checkNotNullParameter(mapContract, "mapContract");
            synchronized (this.mUndownloadedStrokeLock) {
                try {
                    for (Map.Entry<String, String> entry : this.mUndownloadedStroke.entrySet()) {
                        mapContract.getEntry(entry.getKey(), entry.getValue());
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int getUndownloadedStrokeSize() {
            return getUndownloadedStroke().size();
        }

        @NotNull
        public final String getUuid() {
            return this.uuid;
        }

        /* JADX INFO: renamed from: isReleased, reason: from getter */
        public final boolean getIsReleased() {
            return this.isReleased;
        }

        /* JADX INFO: renamed from: isRestored, reason: from getter */
        public final boolean getIsRestored() {
            return this.isRestored;
        }

        public final boolean putDownloadedStroke(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (this.mDownloadedStrokeLock) {
                String str = this.mDownloadedStroke.get(key);
                if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(str, value)) {
                    return false;
                }
                this.mDownloadedStroke.put(key, value);
                return true;
            }
        }

        public final void putUndownloadedStroke(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (this.mUndownloadedStrokeLock) {
                String str = this.mUndownloadedStroke.get(key);
                if (TextUtils.isEmpty(str) || !Intrinsics.areEqual(str, value)) {
                    this.mUndownloadedStroke.put(key, value);
                }
            }
        }

        public final void removeDownloadedStroke(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            getDownloadedStroke().remove(key);
        }

        public final void removeUndownloadedStroke(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            getUndownloadedStroke().remove(key);
        }

        public final void setReleased(boolean z) {
            this.isReleased = z;
        }

        public final void setRestored(boolean z) {
            this.isRestored = z;
        }
    }

    private CoeditCacheMap() {
    }

    @JvmStatic
    @NotNull
    public static final synchronized NoteInfo getNoteInfo(@NotNull String uuid) {
        NoteInfo noteInfo;
        try {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Map<String, NoteInfo> map = mNoteInfoMap;
            if (!map.containsKey(uuid)) {
                map.put(uuid, new NoteInfo(uuid));
            }
            noteInfo = map.get(uuid);
            Intrinsics.checkNotNull(noteInfo);
        } catch (Throwable th) {
            throw th;
        }
        return noteInfo;
    }

    @JvmStatic
    public static final synchronized void release(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        mNoteInfoMap.remove(uuid);
    }
}
