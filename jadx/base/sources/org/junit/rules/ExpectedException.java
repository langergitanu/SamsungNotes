package org.junit.rules;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ExpectedException implements TestRule {
    private final ExpectedExceptionMatcherBuilder matcherBuilder = new ExpectedExceptionMatcherBuilder();
    private String missingExceptionMessage = "Expected test to throw %s";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ExpectedExceptionStatement extends Statement {
        private final Statement next;

        public ExpectedExceptionStatement(Statement statement) {
            this.next = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            try {
                this.next.evaluate();
                if (ExpectedException.this.isAnyExceptionExpected()) {
                    ExpectedException.this.failDueToMissingException();
                }
            } catch (Throwable th) {
                ExpectedException.this.handleException(th);
            }
        }
    }

    private ExpectedException() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failDueToMissingException() {
        Assert.fail(missingExceptionMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(Throwable th) throws Throwable {
        if (!isAnyExceptionExpected()) {
            throw th;
        }
        Assert.assertThat(th, this.matcherBuilder.build());
    }

    private String missingExceptionMessage() {
        return String.format(this.missingExceptionMessage, StringDescription.toString(this.matcherBuilder.build()));
    }

    @Deprecated
    public static ExpectedException none() {
        return new ExpectedException();
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new ExpectedExceptionStatement(statement);
    }

    public void expect(Matcher<?> matcher) {
        this.matcherBuilder.add(matcher);
    }

    public void expectCause(Matcher<?> matcher) {
        expect(ThrowableCauseMatcher.hasCause(matcher));
    }

    public void expectMessage(String str) {
        expectMessage(CoreMatchers.containsString(str));
    }

    public final boolean isAnyExceptionExpected() {
        return this.matcherBuilder.expectsThrowable();
    }

    public ExpectedException reportMissingExceptionWithMessage(String str) {
        this.missingExceptionMessage = str;
        return this;
    }

    public void expect(Class<? extends Throwable> cls) {
        expect(CoreMatchers.instanceOf(cls));
    }

    public void expectMessage(Matcher<String> matcher) {
        expect(ThrowableMessageMatcher.hasMessage(matcher));
    }

    @Deprecated
    public ExpectedException handleAssertionErrors() {
        return this;
    }

    @Deprecated
    public ExpectedException handleAssumptionViolatedExceptions() {
        return this;
    }
}
