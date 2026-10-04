package com.samsung.android.support.senl.p148nt.base.common;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002+,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0017\"\u00020\u000f¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015J!\u0010\u001f\u001a\u00020\u00152\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0017\"\u00020\u000fH\u0007¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0007J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0007J\u0012\u0010\"\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0007J\u0006\u0010\"\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000fH\u0007J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000fH\u0007J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000fH\u0007J)\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0017\"\u00020\u000fH\u0007¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001e¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEFAULT_SKIP_TIME", "", "MENU_SELECT_SKIP_SHORT_TIME", "mSkipEventTime", "Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Times;", "mHoldingEventTime", "mHoldingSingleActionEventTime", "mHoldingTagMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Tag;", "mHoldingSingleActionTagMap", "resetFn", "", "reset", "resetSkipEventTime", "", "remainTags", "", "(Z[Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Tag;)V", "setSkipEventTime", "skipTime", "checkCurrentValidity", "setDefaultSkipEventTime", "isValidEventFn", "()Z", "isValidEvent", "tags", "([Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Tag;)Z", "setHoldingEventTime", "time", "tag", "releaseHoldingEventTimeByTag", "setHoldingSingleActionEventTime", "releaseHoldingSingleActionEventTimeByTag", "isValidSingleActionEvent", "checkAllEvent", "(Z[Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Tag;)Z", FolderConstants.Tag.DISPLAY_NAME, "Times", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UserInputSkipper {
    public static final long DEFAULT_SKIP_TIME = 700;
    public static final long MENU_SELECT_SKIP_SHORT_TIME = 300;

    @NotNull
    private static final String TAG = "UserInputSkipper";

    @NotNull
    public static final UserInputSkipper INSTANCE = new UserInputSkipper();

    @NotNull
    private static final Times mSkipEventTime = new Times(0, 0);

    @NotNull
    private static final Times mHoldingEventTime = new Times(0, 0);

    @NotNull
    private static final Times mHoldingSingleActionEventTime = new Times(0, 0);

    @NotNull
    private static ConcurrentHashMap<Tag, Times> mHoldingTagMap = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<Tag, Times> mHoldingSingleActionTagMap = new ConcurrentHashMap<>(5);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Tag;", "", "<init>", "(Ljava/lang/String;I)V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "ShareViaChooser", "DocumentSave", "MemoList", FolderConstants.Lock.DISPLAY_NAME, "SettingsMain", "SettingsDetail", "OpenActivity", "ManageCategory", "SharedNoteBooks", "Folder", "Drawer", "ComposerActivity", "Menu", "DocumentScan", CategoryConstants.Coedit.DISPLAY_NAME, "ContextMenu", "VoiceRecorder", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Tag {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Tag[] $VALUES;
        public static final Tag Default = new Tag(AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, 0);
        public static final Tag ShareViaChooser = new Tag("ShareViaChooser", 1);
        public static final Tag DocumentSave = new Tag("DocumentSave", 2);
        public static final Tag MemoList = new Tag("MemoList", 3);
        public static final Tag Lock = new Tag(FolderConstants.Lock.DISPLAY_NAME, 4);
        public static final Tag SettingsMain = new Tag("SettingsMain", 5);
        public static final Tag SettingsDetail = new Tag("SettingsDetail", 6);
        public static final Tag OpenActivity = new Tag("OpenActivity", 7);
        public static final Tag ManageCategory = new Tag("ManageCategory", 8);
        public static final Tag SharedNoteBooks = new Tag("SharedNoteBooks", 9);
        public static final Tag Folder = new Tag("Folder", 10);
        public static final Tag Drawer = new Tag("Drawer", 11);
        public static final Tag ComposerActivity = new Tag("ComposerActivity", 12);
        public static final Tag Menu = new Tag("Menu", 13);
        public static final Tag DocumentScan = new Tag("DocumentScan", 14);
        public static final Tag Coedit = new Tag(CategoryConstants.Coedit.DISPLAY_NAME, 15);
        public static final Tag ContextMenu = new Tag("ContextMenu", 16);
        public static final Tag VoiceRecorder = new Tag("VoiceRecorder", 17);

        private static final /* synthetic */ Tag[] $values() {
            return new Tag[]{Default, ShareViaChooser, DocumentSave, MemoList, Lock, SettingsMain, SettingsDetail, OpenActivity, ManageCategory, SharedNoteBooks, Folder, Drawer, ComposerActivity, Menu, DocumentScan, Coedit, ContextMenu, VoiceRecorder};
        }

        static {
            Tag[] tagArr$values = $values();
            $VALUES = tagArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(tagArr$values);
        }

        private Tag(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Tag> getEntries() {
            return $ENTRIES;
        }

        public static Tag valueOf(String str) {
            return (Tag) Enum.valueOf(Tag.class, str);
        }

        public static Tag[] values() {
            return (Tag[]) $VALUES.clone();
        }
    }

    private UserInputSkipper() {
    }

    private final boolean isValidEventFn() {
        Times times = mSkipEventTime;
        if (!times.isActive() && !mHoldingEventTime.isActive()) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (times.isValid(jCurrentTimeMillis) && times.endTime() >= jCurrentTimeMillis) {
            return false;
        }
        times.reset();
        Times times2 = mHoldingEventTime;
        if (times2.isValid(jCurrentTimeMillis) && times2.endTime() >= jCurrentTimeMillis) {
            return false;
        }
        times2.reset();
        return true;
    }

    @JvmStatic
    public static final synchronized boolean isValidSingleActionEvent(boolean checkAllEvent, @NotNull Tag... tags) {
        boolean z;
        Tag tag;
        try {
            Intrinsics.checkNotNullParameter(tags, "tags");
            z = false;
            boolean z2 = !checkAllEvent || INSTANCE.isValidEventFn();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z2) {
                int length = tags.length;
                for (int i = 0; i < length; i++) {
                    tag = tags[i];
                    ConcurrentHashMap<Tag, Times> concurrentHashMap = mHoldingSingleActionTagMap;
                    if (concurrentHashMap.containsKey(tag)) {
                        Times times = concurrentHashMap.get(tag);
                        if (times != null && times.isValid(jCurrentTimeMillis) && times.endTime() > jCurrentTimeMillis) {
                            break;
                        }
                        concurrentHashMap.remove(tag);
                    }
                }
                tag = null;
                z = z2;
            } else {
                tag = null;
                z = z2;
            }
            Logger.m8697d(TAG, "isValidSingleActionEvent, invalidTag: " + tag + ", ret: " + z);
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    @JvmStatic
    public static final synchronized void releaseHoldingEventTimeByTag(@NotNull Tag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8697d(TAG, "releaseHoldingEventTimeByTag, request tag: " + tag);
        mHoldingTagMap.remove(tag);
    }

    @JvmStatic
    public static final synchronized void releaseHoldingSingleActionEventTimeByTag(@NotNull Tag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8697d(TAG, "releaseHoldingEventTimeByTag, request tag: " + tag);
        mHoldingSingleActionTagMap.remove(tag);
    }

    private final void resetFn() {
        Logger.m8697d(TAG, "resetFn");
        mHoldingTagMap.clear();
        mHoldingEventTime.reset();
        mSkipEventTime.reset();
    }

    @JvmStatic
    public static final synchronized void setHoldingEventTime(long time, @Nullable Tag tag) {
        if (tag == null) {
            try {
                tag = Tag.Default;
            } catch (Throwable th) {
                throw th;
            }
        }
        Logger.m8697d(TAG, "setHoldingEventTime, request time: " + time + ", tag : " + tag);
        long jCurrentTimeMillis = System.currentTimeMillis();
        mHoldingTagMap.put(tag, new Times(jCurrentTimeMillis, time));
        Times times = mHoldingEventTime;
        if (!times.isValid(jCurrentTimeMillis) || times.endTime() < jCurrentTimeMillis + time) {
            times.setTime(jCurrentTimeMillis, time);
        }
    }

    @JvmStatic
    public static final synchronized void setHoldingSingleActionEventTime(long time, @NotNull Tag tag) {
        try {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8697d(TAG, "setHoldingSingleActionEventTime, request time: " + time + ", tag : " + tag);
            long jCurrentTimeMillis = System.currentTimeMillis();
            mHoldingSingleActionTagMap.put(tag, new Times(jCurrentTimeMillis, time));
            Times times = mHoldingSingleActionEventTime;
            if (!times.isValid(jCurrentTimeMillis) || times.endTime() < jCurrentTimeMillis + time) {
                times.setTime(jCurrentTimeMillis, time);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean isValidEvent() {
        return isValidEventFn();
    }

    public final synchronized void reset() {
        resetFn();
    }

    public final boolean setDefaultSkipEventTime(boolean checkCurrentValidity) {
        return setSkipEventTime(700L, checkCurrentValidity);
    }

    public final synchronized boolean setSkipEventTime(long skipTime, boolean checkCurrentValidity) {
        if (!checkCurrentValidity) {
            mSkipEventTime.setTime(System.currentTimeMillis(), skipTime);
            return true;
        }
        if (!isValidEventFn()) {
            return false;
        }
        mSkipEventTime.setTime(System.currentTimeMillis(), skipTime);
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/UserInputSkipper$Times;", "", "startTime", "", "skipTime", "<init>", "(JJ)V", "getStartTime", "()J", "setStartTime", "(J)V", "getSkipTime", "setSkipTime", "setTime", "", "start", "skip", "time", "reset", "endTime", "isValid", "", "currentTime", "isActive", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Times {
        private long skipTime;
        private long startTime;

        public Times(long j, long j2) {
            this.startTime = j;
            this.skipTime = j2;
        }

        public final long endTime() {
            return this.startTime + this.skipTime;
        }

        public final long getSkipTime() {
            return this.skipTime;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final boolean isActive() {
            return this.skipTime > 0;
        }

        public final boolean isValid(long currentTime) {
            return this.startTime <= currentTime;
        }

        public final void reset() {
            this.startTime = 0L;
            this.skipTime = 0L;
        }

        public final void setSkipTime(long j) {
            this.skipTime = j;
        }

        public final void setStartTime(long j) {
            this.startTime = j;
        }

        public final void setTime(long start, long skip) {
            this.startTime = start;
            this.skipTime = skip;
        }

        public final void setTime(@Nullable Times time) {
            if (time != null) {
                this.startTime = time.startTime;
                this.skipTime = time.skipTime;
            }
        }
    }

    @JvmStatic
    public static final synchronized boolean isValidEvent(@NotNull Tag... tags) {
        boolean z;
        Tag tag;
        try {
            Intrinsics.checkNotNullParameter(tags, "tags");
            long jCurrentTimeMillis = System.currentTimeMillis();
            int length = tags.length;
            z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    tag = null;
                    z = true;
                    break;
                }
                tag = tags[i];
                if (mHoldingTagMap.containsKey(tag)) {
                    Times times = mHoldingTagMap.get(tag);
                    if (times != null && times.isValid(jCurrentTimeMillis) && times.endTime() > jCurrentTimeMillis) {
                        break;
                    }
                    mHoldingTagMap.remove(tag);
                }
                i++;
            }
            Logger.m8697d(TAG, "isValidEvent, invalidTag: " + tag + ", ret: " + z);
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final synchronized void reset(boolean resetSkipEventTime, @NotNull Tag... remainTags) {
        Intrinsics.checkNotNullParameter(remainTags, "remainTags");
        if (remainTags.length != 0 && !mHoldingTagMap.isEmpty()) {
            ConcurrentHashMap<Tag, Times> concurrentHashMap = new ConcurrentHashMap<>();
            for (Tag tag : remainTags) {
                if (mHoldingTagMap.containsKey(tag)) {
                    Logger.m8697d(TAG, "reset, remainTag : " + tag);
                    Times times = mHoldingTagMap.get(tag);
                    Intrinsics.checkNotNull(times);
                    concurrentHashMap.put(tag, times);
                }
            }
            mHoldingTagMap = concurrentHashMap;
            mHoldingEventTime.reset();
            if (!mHoldingTagMap.isEmpty()) {
                Iterator<Times> it = mHoldingTagMap.values().iterator();
                while (it.hasNext()) {
                    Times next = it.next();
                    Long lValueOf = next != null ? Long.valueOf(next.endTime()) : null;
                    Intrinsics.checkNotNull(lValueOf);
                    long jLongValue = lValueOf.longValue();
                    Times times2 = mHoldingEventTime;
                    if (jLongValue > times2.endTime()) {
                        times2.setTime(next);
                    }
                }
            }
            if (resetSkipEventTime) {
                mSkipEventTime.reset();
            }
            return;
        }
        resetFn();
    }

    public final void setHoldingEventTime(long time) {
        setHoldingEventTime(time, Tag.Default);
    }

    @JvmStatic
    public static final void setHoldingEventTime(@Nullable Tag tag) {
        setHoldingEventTime(700L, tag);
    }

    public final void setHoldingEventTime() {
        setHoldingEventTime(700L, Tag.Default);
    }
}
