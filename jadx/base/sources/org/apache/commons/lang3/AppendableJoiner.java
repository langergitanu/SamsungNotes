package org.apache.commons.lang3;

import java.io.IOException;
import java.util.Iterator;
import java.util.function.Supplier;
import org.apache.commons.lang3.exception.UncheckedException;
import org.apache.commons.lang3.function.FailableBiConsumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class AppendableJoiner<T> {
    private final FailableBiConsumer<Appendable, T, IOException> appender;
    private final CharSequence delimiter;
    private final CharSequence prefix;
    private final CharSequence suffix;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder<T> implements Supplier<AppendableJoiner<T>> {
        private FailableBiConsumer<Appendable, T, IOException> appender;
        private CharSequence delimiter;
        private CharSequence prefix;
        private CharSequence suffix;

        public Builder<T> setDelimiter(CharSequence charSequence) {
            this.delimiter = charSequence;
            return this;
        }

        public Builder<T> setElementAppender(FailableBiConsumer<Appendable, T, IOException> failableBiConsumer) {
            this.appender = failableBiConsumer;
            return this;
        }

        public Builder<T> setPrefix(CharSequence charSequence) {
            this.prefix = charSequence;
            return this;
        }

        public Builder<T> setSuffix(CharSequence charSequence) {
            this.suffix = charSequence;
            return this;
        }

        @Override // java.util.function.Supplier
        public AppendableJoiner<T> get() {
            return new AppendableJoiner<>(this.prefix, this.suffix, this.delimiter, this.appender);
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    @SafeVarargs
    public static <A extends Appendable, T> A joinA(A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer<Appendable, T, IOException> failableBiConsumer, T... tArr) {
        return (A) joinArray(a, charSequence, charSequence2, charSequence3, failableBiConsumer, tArr);
    }

    private static <A extends Appendable, T> A joinArray(A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer<Appendable, T, IOException> failableBiConsumer, T[] tArr) throws IOException {
        a.append(charSequence);
        if (tArr != null) {
            if (tArr.length > 0) {
                failableBiConsumer.accept(a, tArr[0]);
            }
            for (int i = 1; i < tArr.length; i++) {
                a.append(charSequence3);
                failableBiConsumer.accept(a, tArr[i]);
            }
        }
        a.append(charSequence2);
        return a;
    }

    public static <T> StringBuilder joinI(StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer<Appendable, T, IOException> failableBiConsumer, Iterable<T> iterable) {
        try {
            return (StringBuilder) joinIterable(sb, charSequence, charSequence2, charSequence3, failableBiConsumer, iterable);
        } catch (IOException e) {
            throw new UncheckedException(e);
        }
    }

    private static <A extends Appendable, T> A joinIterable(A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer<Appendable, T, IOException> failableBiConsumer, Iterable<T> iterable) throws IOException {
        a.append(charSequence);
        if (iterable != null) {
            Iterator<T> it = iterable.iterator();
            if (it.hasNext()) {
                failableBiConsumer.accept(a, it.next());
            }
            while (it.hasNext()) {
                a.append(charSequence3);
                failableBiConsumer.accept(a, it.next());
            }
        }
        a.append(charSequence2);
        return a;
    }

    @SafeVarargs
    public static <T> StringBuilder joinSB(StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer<Appendable, T, IOException> failableBiConsumer, T... tArr) {
        try {
            return (StringBuilder) joinArray(sb, charSequence, charSequence2, charSequence3, failableBiConsumer, tArr);
        } catch (IOException e) {
            throw new UncheckedException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Appendable appendable, Object obj) throws IOException {
        appendable.append(String.valueOf(obj));
    }

    private static CharSequence nonNull(CharSequence charSequence) {
        return charSequence != null ? charSequence : "";
    }

    public StringBuilder join(StringBuilder sb, Iterable<T> iterable) {
        return joinI(sb, this.prefix, this.suffix, this.delimiter, this.appender, iterable);
    }

    private AppendableJoiner(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer<Appendable, T, IOException> failableBiConsumer) {
        this.prefix = nonNull(charSequence);
        this.suffix = nonNull(charSequence2);
        this.delimiter = nonNull(charSequence3);
        this.appender = failableBiConsumer == null ? new C13812c(0) : failableBiConsumer;
    }

    public StringBuilder join(StringBuilder sb, T... tArr) {
        return joinSB(sb, this.prefix, this.suffix, this.delimiter, this.appender, tArr);
    }

    public <A extends Appendable> A joinA(A a, Iterable<T> iterable) {
        return (A) joinIterable(a, this.prefix, this.suffix, this.delimiter, this.appender, iterable);
    }

    public <A extends Appendable> A joinA(A a, T... tArr) {
        return (A) joinA(a, this.prefix, this.suffix, this.delimiter, this.appender, tArr);
    }
}
