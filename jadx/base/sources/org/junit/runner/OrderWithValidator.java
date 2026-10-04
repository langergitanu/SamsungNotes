package org.junit.runner;

import java.util.Collections;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationValidator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class OrderWithValidator extends AnnotationValidator {
    @Override // org.junit.validator.AnnotationValidator
    public List<Exception> validateAnnotatedClass(TestClass testClass) {
        return testClass.getAnnotation(FixMethodOrder.class) != null ? Collections.singletonList(new Exception("@FixMethodOrder cannot be combined with @OrderWith")) : Collections.EMPTY_LIST;
    }
}
