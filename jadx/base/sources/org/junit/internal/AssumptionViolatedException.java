package org.junit.internal;

import java.io.IOException;
import java.io.ObjectOutputStream;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class AssumptionViolatedException extends RuntimeException implements SelfDescribing {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final Matcher<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z, Object obj, Matcher<?> matcher) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = matcher;
        this.fValueMatcher = z;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("fAssumption", this.fAssumption);
        putFieldPutFields.put("fValueMatcher", this.fValueMatcher);
        putFieldPutFields.put("fMatcher", SerializableMatcherDescription.asSerializableMatcher(this.fMatcher));
        putFieldPutFields.put("fValue", SerializableValueDescription.asSerializableValue(this.fValue));
        objectOutputStream.writeFields();
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        String str = this.fAssumption;
        if (str != null) {
            description.appendText(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                description.appendText(": ");
            }
            description.appendText("got: ");
            description.appendValue(this.fValue);
            if (this.fMatcher != null) {
                description.appendText(", expected: ");
                description.appendDescriptionOf(this.fMatcher);
            }
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringDescription.asString(this);
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, Matcher<?> matcher) {
        this(null, true, obj, matcher);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, Matcher<?> matcher) {
        this(str, true, obj, matcher);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }
}
