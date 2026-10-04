package org.apache.commons.lang3.concurrent.locks;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;
import org.apache.commons.lang3.builder.AbstractSupplier;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.Suppliers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LockingVisitors {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LockVisitor<O, L> {
        private final L lock;
        private final O object;
        private final Supplier<Lock> readLockSupplier;
        private final Supplier<Lock> writeLockSupplier;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class LVBuilder<O, L, B extends LVBuilder<O, L, B>> extends AbstractSupplier<LockVisitor<O, L>, B, RuntimeException> {
            L lock;
            O object;
            private Supplier<Lock> readLockSupplier;
            private Supplier<Lock> writeLockSupplier;

            public Supplier<Lock> getReadLockSupplier() {
                return this.readLockSupplier;
            }

            public Supplier<Lock> getWriteLockSupplier() {
                return this.writeLockSupplier;
            }

            public B setLock(L l) {
                this.lock = l;
                return asThis();
            }

            public B setObject(O o) {
                this.object = o;
                return asThis();
            }

            public B setReadLockSupplier(Supplier<Lock> supplier) {
                this.readLockSupplier = supplier;
                return asThis();
            }

            public B setWriteLockSupplier(Supplier<Lock> supplier) {
                this.writeLockSupplier = supplier;
                return asThis();
            }

            @Override // org.apache.commons.lang3.function.FailableSupplier
            public LockVisitor<O, L> get() {
                return new LockVisitor<>(this);
            }
        }

        public void acceptReadLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.readLockSupplier, failableConsumer);
        }

        public void acceptWriteLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.writeLockSupplier, failableConsumer);
        }

        public <T> T applyReadLocked(FailableFunction<O, T, ?> failableFunction) {
            return (T) lockApplyUnlock(this.readLockSupplier, failableFunction);
        }

        public <T> T applyWriteLocked(FailableFunction<O, T, ?> failableFunction) {
            return (T) lockApplyUnlock(this.writeLockSupplier, failableFunction);
        }

        public L getLock() {
            return this.lock;
        }

        public O getObject() {
            return this.object;
        }

        public void lockAcceptUnlock(Supplier<Lock> supplier, FailableConsumer<O, ?> failableConsumer) {
            Lock lock = (Lock) Suppliers.get(supplier);
            Objects.requireNonNull(lock, "lock");
            Lock lock2 = lock;
            lock2.lock();
            try {
                Failable.accept((FailableConsumer<O, E>) failableConsumer, this.object);
            } finally {
                lock2.unlock();
            }
        }

        public <T> T lockApplyUnlock(Supplier<Lock> supplier, FailableFunction<O, T, ?> failableFunction) {
            Lock lock = (Lock) Suppliers.get(supplier);
            Objects.requireNonNull(lock, "lock");
            Lock lock2 = lock;
            lock2.lock();
            try {
                return (T) Failable.apply(failableFunction, this.object);
            } finally {
                lock2.unlock();
            }
        }

        private LockVisitor(LVBuilder<O, L, ?> lVBuilder) {
            O o = lVBuilder.object;
            Objects.requireNonNull(o, CoeditServiceConstants.Element.NAME_OBJECT);
            this.object = o;
            L l = lVBuilder.lock;
            Objects.requireNonNull(l, "lock");
            this.lock = l;
            Supplier<Lock> supplier = ((LVBuilder) lVBuilder).readLockSupplier;
            Objects.requireNonNull(supplier, "readLockSupplier");
            this.readLockSupplier = supplier;
            Supplier<Lock> supplier2 = ((LVBuilder) lVBuilder).writeLockSupplier;
            Objects.requireNonNull(supplier2, "writeLockSupplier");
            this.writeLockSupplier = supplier2;
        }

        public LockVisitor(O o, L l, Supplier<Lock> supplier, Supplier<Lock> supplier2) {
            Objects.requireNonNull(o, CoeditServiceConstants.Element.NAME_OBJECT);
            this.object = o;
            Objects.requireNonNull(l, "lock");
            this.lock = l;
            Objects.requireNonNull(supplier, "readLockSupplier");
            this.readLockSupplier = supplier;
            Objects.requireNonNull(supplier2, "writeLockSupplier");
            this.writeLockSupplier = supplier2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReadWriteLockVisitor<O> extends LockVisitor<O, ReadWriteLock> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Builder<O> extends LockVisitor.LVBuilder<O, ReadWriteLock, Builder<O>> {
            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder
            public Builder<O> setLock(ReadWriteLock readWriteLock) {
                Objects.requireNonNull(readWriteLock);
                setReadLockSupplier(new C13827a(readWriteLock, 0));
                setWriteLockSupplier(new C13827a(readWriteLock, 1));
                return (Builder) super.setLock(readWriteLock);
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder, org.apache.commons.lang3.function.FailableSupplier
            public ReadWriteLockVisitor<O> get() {
                return new ReadWriteLockVisitor<>(this);
            }
        }

        public static <O> Builder<O> builder() {
            return new Builder<>();
        }

        private ReadWriteLockVisitor(Builder<O> builder) {
            super(builder);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadWriteLockVisitor(O o, ReadWriteLock readWriteLock) {
            super(o, readWriteLock, new C13827a(readWriteLock, 0), new C13827a(readWriteLock, 1));
            Objects.requireNonNull(readWriteLock);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReentrantLockVisitor<O> extends LockVisitor<O, ReentrantLock> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Builder<O> extends LockVisitor.LVBuilder<O, ReentrantLock, Builder<O>> {
            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder
            public Builder<O> setLock(ReentrantLock reentrantLock) {
                setReadLockSupplier(new C13828b(reentrantLock, 2));
                setWriteLockSupplier(new C13828b(reentrantLock, 3));
                return (Builder) super.setLock(reentrantLock);
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder, org.apache.commons.lang3.function.FailableSupplier
            public ReentrantLockVisitor<O> get() {
                return new ReentrantLockVisitor<>(this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ Lock lambda$setLock$0(ReentrantLock reentrantLock) {
                return reentrantLock;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ Lock lambda$setLock$1(ReentrantLock reentrantLock) {
                return reentrantLock;
            }
        }

        public static <O> Builder<O> builder() {
            return new Builder<>();
        }

        private ReentrantLockVisitor(Builder<O> builder) {
            super(builder);
        }

        public ReentrantLockVisitor(O o, ReentrantLock reentrantLock) {
            super(o, reentrantLock, new C13828b(reentrantLock, 0), new C13828b(reentrantLock, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Lock lambda$new$0(ReentrantLock reentrantLock) {
            return reentrantLock;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Lock lambda$new$1(ReentrantLock reentrantLock) {
            return reentrantLock;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StampedLockVisitor<O> extends LockVisitor<O, StampedLock> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Builder<O> extends LockVisitor.LVBuilder<O, StampedLock, Builder<O>> {
            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder
            public Builder<O> setLock(StampedLock stampedLock) {
                Objects.requireNonNull(stampedLock);
                setReadLockSupplier(new C13829c(stampedLock, 0));
                setWriteLockSupplier(new C13829c(stampedLock, 1));
                return (Builder) super.setLock(stampedLock);
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder, org.apache.commons.lang3.function.FailableSupplier
            public StampedLockVisitor<O> get() {
                return new StampedLockVisitor<>(this);
            }
        }

        public static <O> Builder<O> builder() {
            return new Builder<>();
        }

        private StampedLockVisitor(Builder<O> builder) {
            super(builder);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StampedLockVisitor(O o, StampedLock stampedLock) {
            super(o, stampedLock, new C13829c(stampedLock, 0), new C13829c(stampedLock, 1));
            Objects.requireNonNull(stampedLock);
        }
    }

    @Deprecated
    public LockingVisitors() {
    }

    public static <O> ReadWriteLockVisitor<O> create(O o, ReadWriteLock readWriteLock) {
        return new ReadWriteLockVisitor<>(o, readWriteLock);
    }

    public static <O> ReentrantLockVisitor<O> reentrantLockVisitor(O o) {
        return create(o, new ReentrantLock());
    }

    public static <O> ReadWriteLockVisitor<O> reentrantReadWriteLockVisitor(O o) {
        return create(o, new ReentrantReadWriteLock());
    }

    public static <O> StampedLockVisitor<O> stampedLockVisitor(O o) {
        return new StampedLockVisitor<>(o, new StampedLock());
    }

    public static <O> ReentrantLockVisitor<O> create(O o, ReentrantLock reentrantLock) {
        return new ReentrantLockVisitor<>(o, reentrantLock);
    }
}
