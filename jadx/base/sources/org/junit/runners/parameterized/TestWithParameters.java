package org.junit.runners.parameterized;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Checks;
import org.junit.runners.model.TestClass;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class TestWithParameters {
    private final String name;
    private final List<Object> parameters;
    private final TestClass testClass;

    public TestWithParameters(String str, TestClass testClass, List<Object> list) {
        Checks.notNull(str, "The name is missing.");
        Checks.notNull(testClass, "The test class is missing.");
        Checks.notNull(list, "The parameters are missing.");
        this.name = str;
        this.testClass = testClass;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestWithParameters testWithParameters = (TestWithParameters) obj;
        return this.name.equals(testWithParameters.name) && this.parameters.equals(testWithParameters.parameters) && this.testClass.equals(testWithParameters.testClass);
    }

    public String getName() {
        return this.name;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public TestClass getTestClass() {
        return this.testClass;
    }

    public int hashCode() {
        return this.parameters.hashCode() + ((this.testClass.hashCode() + AbstractC1038a.m1202c(14747, 14747, this.name)) * 14747);
    }

    public String toString() {
        return this.testClass.getName() + " '" + this.name + "' with parameters " + this.parameters;
    }
}
