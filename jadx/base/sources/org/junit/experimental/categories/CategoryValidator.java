package org.junit.experimental.categories;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.model.FrameworkMethod;
import org.junit.validator.AnnotationValidator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CategoryValidator extends AnnotationValidator {
    private static final Set<Class<? extends Annotation>> INCOMPATIBLE_ANNOTATIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(BeforeClass.class, AfterClass.class, Before.class, After.class)));

    private void addErrorMessage(List<Exception> list, Class<?> cls) {
        list.add(new Exception(AbstractC0541b.m773o(Log.TAG_SEPARATOR, cls.getSimpleName(), " can not be combined with @Category")));
    }

    @Override // org.junit.validator.AnnotationValidator
    public List<Exception> validateAnnotatedMethod(FrameworkMethod frameworkMethod) {
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : frameworkMethod.getAnnotations()) {
            for (Class<? extends Annotation> cls : INCOMPATIBLE_ANNOTATIONS) {
                if (annotation.annotationType().isAssignableFrom(cls)) {
                    addErrorMessage(arrayList, cls);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
