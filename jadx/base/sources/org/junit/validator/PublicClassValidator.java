package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class PublicClassValidator implements TestClassValidator {
    private static final List<Exception> NO_VALIDATION_ERRORS = Collections.EMPTY_LIST;

    @Override // org.junit.validator.TestClassValidator
    public List<Exception> validateTestClass(TestClass testClass) {
        if (testClass.isPublic()) {
            return NO_VALIDATION_ERRORS;
        }
        return Collections.singletonList(new Exception("The class " + testClass.getName() + " is not public."));
    }
}
