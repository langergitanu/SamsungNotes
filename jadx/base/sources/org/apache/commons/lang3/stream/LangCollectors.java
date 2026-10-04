package org.apache.commons.lang3.stream;

import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.samsung.android.vexfwk.sdk.bokeheffect.C11571a;
import com.vladsch.flexmark.util.ast.C11836a;
import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import org.apache.commons.lang3.exception.C13833a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LangCollectors {
    private static final Set<Collector.Characteristics> CH_NOID = Collections.EMPTY_SET;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SimpleCollector<T, A, R> implements Collector<T, A, R> {
        private final BiConsumer<A, T> accumulator;
        private final Set<Collector.Characteristics> characteristics;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Supplier<A> supplier;

        @Override // java.util.stream.Collector
        public BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }

        @Override // java.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return this.characteristics;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator<A> combiner() {
            return this.combiner;
        }

        @Override // java.util.stream.Collector
        public Function<A, R> finisher() {
            return this.finisher;
        }

        @Override // java.util.stream.Collector
        public Supplier<A> supplier() {
            return this.supplier;
        }

        private SimpleCollector(Supplier<A> supplier, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator, Function<A, R> function, Set<Collector.Characteristics> set) {
            this.supplier = supplier;
            this.accumulator = biConsumer;
            this.combiner = binaryOperator;
            this.finisher = function;
            this.characteristics = set;
        }
    }

    private LangCollectors() {
    }

    @SafeVarargs
    public static <T, R, A> R collect(Collector<? super T, A, R> collector, T... tArr) {
        return (R) Streams.m14874of(tArr).collect(collector);
    }

    public static Collector<Object, ?, String> joining() {
        return new SimpleCollector(new C2747a(15), new C13900a(), new C13901b(0), new C13833a(7), CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StringJoiner lambda$joining$0(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$joining$1(Function function, StringJoiner stringJoiner, Object obj) {
        stringJoiner.add((CharSequence) function.apply(obj));
    }

    public static Collector<Object, ?, String> joining(CharSequence charSequence) {
        return joining(charSequence, "", "");
    }

    public static Collector<Object, ?, String> joining(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return joining(charSequence, charSequence2, charSequence3, new C11419a(28));
    }

    public static Collector<Object, ?, String> joining(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function<Object, String> function) {
        return new SimpleCollector(new C11571a(charSequence, 2, charSequence2, charSequence3), new C11836a(function, 6), new C13901b(1), new C13833a(8), CH_NOID);
    }
}
