package org.apache.commons.lang3.stream;

import androidx.emoji2.text.flatbuffer.C2747a;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.C13790a;
import org.apache.commons.lang3.C13886k;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.reflect.C13895a;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Streams {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ArrayCollector<E> implements Collector<E, List<E>, E[]> {
        private static final Set<Collector.Characteristics> characteristics = Collections.EMPTY_SET;
        private final Class<E> elementType;

        public ArrayCollector(Class<E> cls) {
            Objects.requireNonNull(cls, "elementType");
            this.elementType = cls;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$combiner$0(List list, List list2) {
            list.addAll(list2);
            return list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object[] lambda$finisher$1(List list) {
            return list.toArray(ArrayUtils.newInstance(this.elementType, list.size()));
        }

        @Override // java.util.stream.Collector
        public BiConsumer<List<E>, E> accumulator() {
            return new C13886k(1);
        }

        @Override // java.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return characteristics;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator<List<E>> combiner() {
            return new C13901b(2);
        }

        @Override // java.util.stream.Collector
        public Function<List<E>, E[]> finisher() {
            return new C0332a(this, 21);
        }

        @Override // java.util.stream.Collector
        public Supplier<List<E>> supplier() {
            return new C2747a(26);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EnumerationSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
        private final Enumeration<T> enumeration;

        public EnumerationSpliterator(long j, int i, Enumeration<T> enumeration) {
            super(j, i);
            Objects.requireNonNull(enumeration, "enumeration");
            this.enumeration = enumeration;
        }

        private boolean next(Consumer<? super T> consumer) {
            consumer.accept(this.enumeration.nextElement());
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> consumer) {
            while (this.enumeration.hasMoreElements()) {
                next(consumer);
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            return this.enumeration.hasMoreElements() && next(consumer);
        }
    }

    @Deprecated
    public Streams() {
    }

    public static <T> FailableStream<T> failableStream(Collection<T> collection) {
        return failableStream(m14870of((Collection) collection));
    }

    public static <E> Stream<E> instancesOf(Class<? super E> cls, Collection<? super E> collection) {
        return instancesOf(cls, (Stream<?>) m14870of((Collection) collection));
    }

    public static <E> Stream<E> nonNull(Collection<E> collection) {
        return m14870of((Collection) collection).filter(new C13790a(2));
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m14870of(Collection<E> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }

    @Deprecated
    public static <E> FailableStream<E> stream(Collection<E> collection) {
        return failableStream((Collection) collection);
    }

    private static <T> Stream<T> streamOf(T t) {
        return t == null ? Stream.empty() : Stream.of(t);
    }

    public static <T> Collector<T, List<T>, T[]> toArray(Class<T> cls) {
        return new ArrayCollector(cls);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FailableStream<T> {
        private Stream<T> stream;
        private boolean terminated;

        public FailableStream(Stream<T> stream) {
            this.stream = stream;
        }

        public boolean allMatch(FailablePredicate<T, ?> failablePredicate) {
            assertNotTerminated();
            return stream().allMatch(Failable.asPredicate(failablePredicate));
        }

        public boolean anyMatch(FailablePredicate<T, ?> failablePredicate) {
            assertNotTerminated();
            return stream().anyMatch(Failable.asPredicate(failablePredicate));
        }

        public void assertNotTerminated() {
            if (this.terminated) {
                throw new IllegalStateException("This stream is already terminated.");
            }
        }

        public <A, R> R collect(Collector<? super T, A, R> collector) {
            makeTerminated();
            return (R) stream().collect(collector);
        }

        public FailableStream<T> filter(FailablePredicate<T, ?> failablePredicate) {
            assertNotTerminated();
            this.stream = this.stream.filter(Failable.asPredicate(failablePredicate));
            return this;
        }

        public void forEach(FailableConsumer<T, ?> failableConsumer) {
            makeTerminated();
            stream().forEach(Failable.asConsumer(failableConsumer));
        }

        public void makeTerminated() {
            assertNotTerminated();
            this.terminated = true;
        }

        public <R> FailableStream<R> map(FailableFunction<T, R, ?> failableFunction) {
            assertNotTerminated();
            return new FailableStream<>(this.stream.map(Failable.asFunction(failableFunction)));
        }

        public T reduce(T t, BinaryOperator<T> binaryOperator) {
            makeTerminated();
            return stream().reduce(t, binaryOperator);
        }

        public Stream<T> stream() {
            return this.stream;
        }

        public <A, R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> biConsumer, BiConsumer<R, R> biConsumer2) {
            makeTerminated();
            return (R) stream().collect(supplier, biConsumer, biConsumer2);
        }
    }

    public static <T> FailableStream<T> failableStream(Stream<T> stream) {
        return new FailableStream<>(stream);
    }

    private static <E> Stream<E> instancesOf(Class<? super E> cls, Stream<?> stream) {
        Stream streamM14873of = m14873of(stream);
        Objects.requireNonNull(cls);
        return streamM14873of.filter(new C13895a(cls, 2));
    }

    public static <E> Stream<E> nonNull(E e) {
        return nonNull(streamOf(e));
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m14871of(Enumeration<E> enumeration) {
        return StreamSupport.stream(new EnumerationSpliterator(Long.MAX_VALUE, 16, enumeration), false);
    }

    @Deprecated
    public static <T> FailableStream<T> stream(Stream<T> stream) {
        return failableStream((Stream) stream);
    }

    public static <T> FailableStream<T> failableStream(T t) {
        return failableStream(streamOf(t));
    }

    @SafeVarargs
    public static <E> Stream<E> nonNull(E... eArr) {
        return nonNull(m14874of(eArr));
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m14869of(Iterable<E> iterable) {
        return iterable == null ? Stream.empty() : StreamSupport.stream(iterable.spliterator(), false);
    }

    @SafeVarargs
    public static <T> FailableStream<T> failableStream(T... tArr) {
        return failableStream(m14874of(tArr));
    }

    public static <E> Stream<E> nonNull(Stream<E> stream) {
        return m14873of(stream).filter(new C13790a(2));
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m14872of(Iterator<E> it) {
        return it == null ? Stream.empty() : StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 16), false);
    }

    /* JADX INFO: renamed from: of */
    private static <E> Stream<E> m14873of(Stream<E> stream) {
        return stream == null ? Stream.empty() : stream;
    }

    @SafeVarargs
    /* JADX INFO: renamed from: of */
    public static <T> Stream<T> m14874of(T... tArr) {
        return tArr == null ? Stream.empty() : Stream.of((Object[]) tArr);
    }
}
