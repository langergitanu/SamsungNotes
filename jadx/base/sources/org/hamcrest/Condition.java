package org.hamcrest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Condition<T> {
    public static final NotMatched<Object> NOT_MATCHED = new NotMatched<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Matched<T> extends Condition<T> {
        private final Description mismatch;
        private final T theValue;

        @Override // org.hamcrest.Condition
        public <U> Condition<U> and(Step<? super T, U> step) {
            return step.apply(this.theValue, this.mismatch);
        }

        @Override // org.hamcrest.Condition
        public boolean matching(Matcher<T> matcher, String str) {
            if (matcher.matches(this.theValue)) {
                return true;
            }
            this.mismatch.appendText(str);
            matcher.describeMismatch(this.theValue, this.mismatch);
            return false;
        }

        private Matched(T t, Description description) {
            super();
            this.theValue = t;
            this.mismatch = description;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NotMatched<T> extends Condition<T> {
        private NotMatched() {
            super();
        }

        @Override // org.hamcrest.Condition
        public <U> Condition<U> and(Step<? super T, U> step) {
            return Condition.notMatched();
        }

        @Override // org.hamcrest.Condition
        public boolean matching(Matcher<T> matcher, String str) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Step<I, O> {
        Condition<O> apply(I i, Description description);
    }

    public static <T> Condition<T> matched(T t, Description description) {
        return new Matched(t, description);
    }

    public static <T> Condition<T> notMatched() {
        return NOT_MATCHED;
    }

    public abstract <U> Condition<U> and(Step<? super T, U> step);

    public final boolean matching(Matcher<T> matcher) {
        return matching(matcher, "");
    }

    public abstract boolean matching(Matcher<T> matcher, String str);

    public final <U> Condition<U> then(Step<? super T, U> step) {
        return and(step);
    }

    private Condition() {
    }
}
