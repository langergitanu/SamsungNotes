package org.junit.runners.parameterized;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class BlockJUnit4ClassRunnerWithParameters extends BlockJUnit4ClassRunner {
    private final String name;
    private final Object[] parameters;

    /* JADX INFO: renamed from: org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144221 {

        /* JADX INFO: renamed from: $SwitchMap$org$junit$runners$parameterized$BlockJUnit4ClassRunnerWithParameters$InjectionType */
        static final /* synthetic */ int[] f10203x98c99894;

        static {
            int[] iArr = new int[InjectionType.values().length];
            f10203x98c99894 = iArr;
            try {
                iArr[InjectionType.CONSTRUCTOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10203x98c99894[InjectionType.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum InjectionType {
        CONSTRUCTOR,
        FIELD
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunAfterParams extends RunAfters {
        public RunAfterParams(Statement statement, List<FrameworkMethod> list) {
            super(statement, list, null);
        }

        @Override // org.junit.internal.runners.statements.RunAfters
        public void invokeMethod(FrameworkMethod frameworkMethod) {
            frameworkMethod.invokeExplosively(null, frameworkMethod.getMethod().getParameterTypes().length == 0 ? null : BlockJUnit4ClassRunnerWithParameters.this.parameters);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunBeforeParams extends RunBefores {
        public RunBeforeParams(Statement statement, List<FrameworkMethod> list) {
            super(statement, list, null);
        }

        @Override // org.junit.internal.runners.statements.RunBefores
        public void invokeMethod(FrameworkMethod frameworkMethod) {
            frameworkMethod.invokeExplosively(null, frameworkMethod.getMethod().getParameterTypes().length == 0 ? null : BlockJUnit4ClassRunnerWithParameters.this.parameters);
        }
    }

    public BlockJUnit4ClassRunnerWithParameters(TestWithParameters testWithParameters) {
        super(testWithParameters.getTestClass());
        this.parameters = testWithParameters.getParameters().toArray(new Object[testWithParameters.getParameters().size()]);
        this.name = testWithParameters.getName();
    }

    private Object createTestUsingConstructorInjection() {
        return getTestClass().getOnlyConstructor().newInstance(this.parameters);
    }

    private Object createTestUsingFieldInjection() throws Exception {
        List<FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
        if (annotatedFieldsByParameter.size() != this.parameters.length) {
            StringBuilder sb = new StringBuilder("Wrong number of parameters and @Parameter fields. @Parameter fields counted: ");
            sb.append(annotatedFieldsByParameter.size());
            sb.append(", available parameters: ");
            throw new Exception(AbstractC2821a.m2223n(sb, Extension.DOT, this.parameters.length));
        }
        Object objNewInstance = getTestClass().getJavaClass().newInstance();
        Iterator<FrameworkField> it = annotatedFieldsByParameter.iterator();
        while (it.hasNext()) {
            Field field = it.next().getField();
            int iValue = ((Parameterized.Parameter) field.getAnnotation(Parameterized.Parameter.class)).value();
            try {
                field.set(objNewInstance, this.parameters[iValue]);
            } catch (IllegalAccessException e) {
                IllegalAccessException illegalAccessException = new IllegalAccessException("Cannot set parameter '" + field.getName() + "'. Ensure that the field '" + field.getName() + "' is public.");
                illegalAccessException.initCause(e);
                throw illegalAccessException;
            } catch (IllegalArgumentException e2) {
                throw new Exception(getTestClass().getName() + ": Trying to set " + field.getName() + " with the value " + this.parameters[iValue] + " that is not the right type (" + this.parameters[iValue].getClass().getSimpleName() + " instead of " + field.getType().getSimpleName() + ").", e2);
            }
        }
        return objNewInstance;
    }

    private boolean fieldsAreAnnotated() {
        return !getAnnotatedFieldsByParameter().isEmpty();
    }

    private List<FrameworkField> getAnnotatedFieldsByParameter() {
        return getTestClass().getAnnotatedFields(Parameterized.Parameter.class);
    }

    private InjectionType getInjectionType() {
        return fieldsAreAnnotated() ? InjectionType.FIELD : InjectionType.CONSTRUCTOR;
    }

    private Statement withAfterParams(Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Parameterized.AfterParam.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfterParams(statement, annotatedMethods);
    }

    private Statement withBeforeParams(Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Parameterized.BeforeParam.class);
        return annotatedMethods.isEmpty() ? statement : new RunBeforeParams(statement, annotatedMethods);
    }

    @Override // org.junit.runners.ParentRunner
    public Statement classBlock(RunNotifier runNotifier) {
        return withAfterParams(withBeforeParams(childrenInvoker(runNotifier)));
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public Object createTest() {
        InjectionType injectionType = getInjectionType();
        int i = C144221.f10203x98c99894[injectionType.ordinal()];
        if (i == 1) {
            return createTestUsingConstructorInjection();
        }
        if (i == 2) {
            return createTestUsingFieldInjection();
        }
        throw new IllegalStateException("The injection type " + injectionType + " is not supported.");
    }

    @Override // org.junit.runners.ParentRunner
    public String getName() {
        return this.name;
    }

    @Override // org.junit.runners.ParentRunner
    public Annotation[] getRunnerAnnotations() {
        Annotation[] annotationArr = new Annotation[r0.length - 1];
        int i = 0;
        for (Annotation annotation : super.getRunnerAnnotations()) {
            if (!annotation.annotationType().equals(RunWith.class)) {
                annotationArr[i] = annotation;
                i++;
            }
        }
        return annotationArr;
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName() + getName();
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
        if (getInjectionType() != InjectionType.CONSTRUCTOR) {
            validateZeroArgConstructor(list);
        }
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public void validateFields(List<Throwable> list) {
        super.validateFields(list);
        if (getInjectionType() == InjectionType.FIELD) {
            List<FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
            int size = annotatedFieldsByParameter.size();
            int[] iArr = new int[size];
            Iterator<FrameworkField> it = annotatedFieldsByParameter.iterator();
            while (it.hasNext()) {
                int iValue = ((Parameterized.Parameter) it.next().getField().getAnnotation(Parameterized.Parameter.class)).value();
                if (iValue < 0 || iValue > annotatedFieldsByParameter.size() - 1) {
                    StringBuilder sbM778t = AbstractC0541b.m778t(iValue, "Invalid @Parameter value: ", ". @Parameter fields counted: ");
                    sbM778t.append(annotatedFieldsByParameter.size());
                    sbM778t.append(". Please use an index between 0 and ");
                    sbM778t.append(annotatedFieldsByParameter.size() - 1);
                    sbM778t.append(Extension.DOT);
                    list.add(new Exception(sbM778t.toString()));
                } else {
                    iArr[iValue] = iArr[iValue] + 1;
                }
            }
            for (int i = 0; i < size; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    list.add(new Exception(AbstractC0541b.m767i(i, "@Parameter(", ") is never used.")));
                } else if (i2 > 1) {
                    list.add(new Exception(AbstractC0622a.m1164j(i, i2, "@Parameter(", ") is used more than once (", ").")));
                }
            }
        }
    }
}
