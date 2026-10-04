package junit.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;
import org.junit.internal.Throwables;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class TestSuite implements Test {
    private String fName;
    private Vector<Test> fTests;

    public TestSuite() {
        this.fTests = new Vector<>(10);
    }

    private void addTestMethod(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (isPublicTestMethod(method)) {
            list.add(name);
            addTest(createTest(cls, name));
        } else if (isTestMethod(method)) {
            addTest(warning("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
        }
    }

    private void addTestsFromTestCase(Class<?> cls) {
        this.fName = cls.getName();
        try {
            getTestConstructor(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                addTest(warning("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = cls; Test.class.isAssignableFrom(superclass); superclass = superclass.getSuperclass()) {
                for (Method method : MethodSorter.getDeclaredMethods(superclass)) {
                    addTestMethod(method, arrayList, cls);
                }
            }
            if (this.fTests.size() == 0) {
                addTest(warning("No tests found in ".concat(cls.getName())));
            }
        } catch (NoSuchMethodException unused) {
            addTest(warning("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public static Test createTest(Class<?> cls, String str) {
        Object objNewInstance;
        try {
            Constructor<?> testConstructor = getTestConstructor(cls);
            try {
                if (testConstructor.getParameterTypes().length == 0) {
                    objNewInstance = testConstructor.newInstance(null);
                    if (objNewInstance instanceof TestCase) {
                        ((TestCase) objNewInstance).setName(str);
                    }
                } else {
                    objNewInstance = testConstructor.newInstance(str);
                }
                return (Test) objNewInstance;
            } catch (IllegalAccessException e) {
                StringBuilder sbM15l = AbstractC0000a.m15l("Cannot access test case: ", str, " (");
                sbM15l.append(Throwables.getStacktrace(e));
                sbM15l.append(")");
                return warning(sbM15l.toString());
            } catch (InstantiationException e2) {
                StringBuilder sbM15l2 = AbstractC0000a.m15l("Cannot instantiate test case: ", str, " (");
                sbM15l2.append(Throwables.getStacktrace(e2));
                sbM15l2.append(")");
                return warning(sbM15l2.toString());
            } catch (InvocationTargetException e3) {
                StringBuilder sbM15l3 = AbstractC0000a.m15l("Exception in constructor: ", str, " (");
                sbM15l3.append(Throwables.getStacktrace(e3.getTargetException()));
                sbM15l3.append(")");
                return warning(sbM15l3.toString());
            }
        } catch (NoSuchMethodException unused) {
            return warning("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    public static Constructor<?> getTestConstructor(Class<?> cls) {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(null);
        }
    }

    private boolean isPublicTestMethod(Method method) {
        return isTestMethod(method) && Modifier.isPublic(method.getModifiers());
    }

    private boolean isTestMethod(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    private Test testCaseForClass(Class<?> cls) {
        if (TestCase.class.isAssignableFrom(cls)) {
            return new TestSuite(cls.asSubclass(TestCase.class));
        }
        return warning(cls.getCanonicalName() + " does not extend TestCase");
    }

    public static Test warning(final String str) {
        return new TestCase("warning") { // from class: junit.framework.TestSuite.1
            @Override // junit.framework.TestCase
            public void runTest() {
                TestCase.fail(str);
            }
        };
    }

    public void addTest(Test test) {
        this.fTests.add(test);
    }

    public void addTestSuite(Class<? extends TestCase> cls) {
        addTest(new TestSuite(cls));
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        Iterator<Test> it = this.fTests.iterator();
        int iCountTestCases = 0;
        while (it.hasNext()) {
            iCountTestCases += it.next().countTestCases();
        }
        return iCountTestCases;
    }

    public String getName() {
        return this.fName;
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        for (Test test : this.fTests) {
            if (testResult.shouldStop()) {
                return;
            } else {
                runTest(test, testResult);
            }
        }
    }

    public void runTest(Test test, TestResult testResult) {
        test.run(testResult);
    }

    public void setName(String str) {
        this.fName = str;
    }

    public Test testAt(int i) {
        return this.fTests.get(i);
    }

    public int testCount() {
        return this.fTests.size();
    }

    public Enumeration<Test> tests() {
        return this.fTests.elements();
    }

    public String toString() {
        return getName() != null ? getName() : super.toString();
    }

    public TestSuite(Class<?> cls) {
        this.fTests = new Vector<>(10);
        addTestsFromTestCase(cls);
    }

    public TestSuite(Class<? extends TestCase> cls, String str) {
        this(cls);
        setName(str);
    }

    public TestSuite(String str) {
        this.fTests = new Vector<>(10);
        setName(str);
    }

    public TestSuite(Class<?>... clsArr) {
        this.fTests = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            addTest(testCaseForClass(cls));
        }
    }

    public TestSuite(Class<? extends TestCase>[] clsArr, String str) {
        this(clsArr);
        setName(str);
    }
}
