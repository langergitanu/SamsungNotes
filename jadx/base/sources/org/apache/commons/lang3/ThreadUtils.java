package org.apache.commons.lang3;

import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.C8365a;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.Predicates;
import org.apache.commons.lang3.time.DurationUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ThreadUtils {

    @Deprecated
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static final class AlwaysTruePredicate implements ThreadPredicate, ThreadGroupPredicate {
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return true;
        }

        private AlwaysTruePredicate() {
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static class NamePredicate implements ThreadPredicate, ThreadGroupPredicate {
        private final String name;

        public NamePredicate(String str) {
            Objects.requireNonNull(str, "name");
            this.name = str;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getName().equals(this.name);
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return threadGroup != null && threadGroup.getName().equals(this.name);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface ThreadGroupPredicate {
        boolean test(ThreadGroup threadGroup);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static class ThreadIdPredicate implements ThreadPredicate {
        private final long threadId;

        public ThreadIdPredicate(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("The thread id must be greater than zero");
            }
            this.threadId = j;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getId() == this.threadId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface ThreadPredicate {
        boolean test(Thread thread);
    }

    @Deprecated
    public ThreadUtils() {
    }

    public static Thread findThreadById(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("The thread id must be greater than zero");
        }
        Collection<Thread> collectionFindThreads = findThreads(new C8365a(j, 1));
        if (collectionFindThreads.isEmpty()) {
            return null;
        }
        return collectionFindThreads.iterator().next();
    }

    public static Collection<ThreadGroup> findThreadGroups(Predicate<ThreadGroup> predicate) {
        return findThreadGroups(getSystemThreadGroup(), true, predicate);
    }

    public static Collection<ThreadGroup> findThreadGroupsByName(String str) {
        return findThreadGroups(predicateThreadGroup(str));
    }

    public static Collection<Thread> findThreads(Predicate<Thread> predicate) {
        return findThreads(getSystemThreadGroup(), true, predicate);
    }

    public static Collection<Thread> findThreadsByName(String str) {
        return findThreads(predicateThread(str));
    }

    public static Collection<ThreadGroup> getAllThreadGroups() {
        return findThreadGroups((Predicate<ThreadGroup>) Predicates.truePredicate());
    }

    public static Collection<Thread> getAllThreads() {
        return findThreads((Predicate<Thread>) Predicates.truePredicate());
    }

    public static ThreadGroup getSystemThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup != null && threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    public static void join(Thread thread, Duration duration) {
        Objects.requireNonNull(thread);
        DurationUtils.accept(new C13929w(thread, 1), duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findThreadById$0(long j, Thread thread) {
        return thread != null && thread.getId() == j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$findThreadsByName$1(String str, ThreadGroup threadGroup) {
        return findThreads(threadGroup, false, predicateThread(str)).stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$namePredicate$2(Function function, String str, Object obj) {
        if (obj == null) {
            return false;
        }
        Object objApply = function.apply(obj);
        Objects.requireNonNull(str);
        return Objects.equals(objApply, str);
    }

    private static <T> Predicate<T> namePredicate(String str, Function<T, String> function) {
        return new C13891p(function, str);
    }

    private static Predicate<Thread> predicateThread(String str) {
        return namePredicate(str, new C13791b(18));
    }

    private static Predicate<ThreadGroup> predicateThreadGroup(String str) {
        return namePredicate(str, new C13791b(17));
    }

    public static void sleep(Duration duration) {
        DurationUtils.accept(new C13812c(1), duration);
    }

    public static void sleepQuietly(Duration duration) {
        try {
            sleep(duration);
        } catch (InterruptedException unused) {
        }
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z, Predicate<ThreadGroup> predicate) {
        Objects.requireNonNull(threadGroup, "threadGroup");
        Objects.requireNonNull(predicate, "predicate");
        int iActiveGroupCount = threadGroup.activeGroupCount();
        while (true) {
            int i = (iActiveGroupCount / 2) + iActiveGroupCount + 1;
            ThreadGroup[] threadGroupArr = new ThreadGroup[i];
            int iEnumerate = threadGroup.enumerate(threadGroupArr, z);
            if (iEnumerate < i) {
                return Collections.unmodifiableCollection((Collection) Stream.of((Object[]) threadGroupArr).limit(iEnumerate).filter(predicate).collect(Collectors.toList()));
            }
            iActiveGroupCount = iEnumerate;
        }
    }

    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z, Predicate<Thread> predicate) {
        Objects.requireNonNull(threadGroup, "The group must not be null");
        Objects.requireNonNull(predicate, "The predicate must not be null");
        int iActiveCount = threadGroup.activeCount();
        while (true) {
            int i = (iActiveCount / 2) + iActiveCount + 1;
            Thread[] threadArr = new Thread[i];
            int iEnumerate = threadGroup.enumerate(threadArr, z);
            if (iEnumerate < i) {
                return Collections.unmodifiableCollection((Collection) Stream.of((Object[]) threadArr).limit(iEnumerate).filter(predicate).collect(Collectors.toList()));
            }
            iActiveCount = iEnumerate;
        }
    }

    public static Collection<Thread> findThreadsByName(String str, String str2) {
        Objects.requireNonNull(str, "threadName");
        Objects.requireNonNull(str2, "threadGroupName");
        return Collections.unmodifiableCollection((Collection) findThreadGroups(predicateThreadGroup(str2)).stream().flatMap(new C13928v(str, 2)).collect(Collectors.toList()));
    }

    public static Thread findThreadById(long j, String str) {
        Objects.requireNonNull(str, "threadGroupName");
        Thread threadFindThreadById = findThreadById(j);
        if (threadFindThreadById == null || threadFindThreadById.getThreadGroup() == null || !threadFindThreadById.getThreadGroup().getName().equals(str)) {
            return null;
        }
        return threadFindThreadById;
    }

    public static Thread findThreadById(long j, ThreadGroup threadGroup) {
        Objects.requireNonNull(threadGroup, "threadGroup");
        Thread threadFindThreadById = findThreadById(j);
        if (threadFindThreadById == null || !threadGroup.equals(threadFindThreadById.getThreadGroup())) {
            return null;
        }
        return threadFindThreadById;
    }

    public static Collection<Thread> findThreadsByName(String str, ThreadGroup threadGroup) {
        return findThreads(threadGroup, false, predicateThread(str));
    }

    @Deprecated
    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z, ThreadGroupPredicate threadGroupPredicate) {
        Objects.requireNonNull(threadGroupPredicate);
        return findThreadGroups(threadGroup, z, new C7233a(threadGroupPredicate, 13));
    }

    @Deprecated
    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z, ThreadPredicate threadPredicate) {
        Objects.requireNonNull(threadPredicate);
        return findThreads(threadGroup, z, new C7233a(threadPredicate, 14));
    }

    @Deprecated
    public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate threadGroupPredicate) {
        return findThreadGroups(getSystemThreadGroup(), true, threadGroupPredicate);
    }

    @Deprecated
    public static Collection<Thread> findThreads(ThreadPredicate threadPredicate) {
        return findThreads(getSystemThreadGroup(), true, threadPredicate);
    }
}
