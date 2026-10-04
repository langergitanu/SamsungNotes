package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class TestCase extends Assert implements Test {
    private String fName;

    public TestCase() {
        this.fName = null;
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        Assert.assertEquals(str, obj, obj2);
    }

    public static void assertFalse(String str, boolean z) {
        Assert.assertFalse(str, z);
    }

    public static void assertNotNull(Object obj) {
        Assert.assertNotNull(obj);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        Assert.assertNotSame(str, obj, obj2);
    }

    public static void assertNull(Object obj) {
        Assert.assertNull(obj);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        Assert.assertSame(str, obj, obj2);
    }

    public static void assertTrue(String str, boolean z) {
        Assert.assertTrue(str, z);
    }

    public static void fail(String str) {
        Assert.fail(str);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        Assert.failNotEquals(str, obj, obj2);
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        Assert.failNotSame(str, obj, obj2);
    }

    public static void failSame(String str) {
        Assert.failSame(str);
    }

    public static String format(String str, Object obj, Object obj2) {
        return Assert.format(str, obj, obj2);
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return 1;
    }

    public TestResult createResult() {
        return new TestResult();
    }

    public String getName() {
        return this.fName;
    }

    public TestResult run() {
        TestResult testResultCreateResult = createResult();
        run(testResultCreateResult);
        return testResultCreateResult;
    }

    public void runBare() {
        setUp();
        try {
            runTest();
            try {
                tearDown();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                tearDown();
            } catch (Throwable unused) {
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public void runTest() throws Throwable {
        Method method;
        assertNotNull("TestCase.fName cannot be null", this.fName);
        try {
            method = getClass().getMethod(this.fName, null);
        } catch (NoSuchMethodException unused) {
            fail("Method \"" + this.fName + "\" not found");
            method = null;
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            fail("Method \"" + this.fName + "\" should be public");
        }
        try {
            method.invoke(this, null);
        } catch (IllegalAccessException e) {
            e.fillInStackTrace();
            throw e;
        } catch (InvocationTargetException e2) {
            e2.fillInStackTrace();
            throw e2.getTargetException();
        }
    }

    public void setName(String str) {
        this.fName = str;
    }

    public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }

    public static void assertEquals(Object obj, Object obj2) {
        Assert.assertEquals(obj, obj2);
    }

    public static void assertFalse(boolean z) {
        Assert.assertFalse(z);
    }

    public static void assertNotNull(String str, Object obj) {
        Assert.assertNotNull(str, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        Assert.assertNotSame(obj, obj2);
    }

    public static void assertNull(String str, Object obj) {
        Assert.assertNull(str, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        Assert.assertSame(obj, obj2);
    }

    public static void assertTrue(boolean z) {
        Assert.assertTrue(z);
    }

    public static void fail() {
        Assert.fail();
    }

    public TestCase(String str) {
        this.fName = str;
    }

    public static void assertEquals(String str, String str2, String str3) {
        Assert.assertEquals(str, str2, str3);
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        testResult.run(this);
    }

    public static void assertEquals(String str, String str2) {
        Assert.assertEquals(str, str2);
    }

    public static void assertEquals(String str, double d, double d2, double d3) {
        Assert.assertEquals(str, d, d2, d3);
    }

    public static void assertEquals(double d, double d2, double d3) {
        Assert.assertEquals(d, d2, d3);
    }

    public static void assertEquals(String str, float f, float f4, float f5) {
        Assert.assertEquals(str, f, f4, f5);
    }

    public static void assertEquals(float f, float f4, float f5) {
        Assert.assertEquals(f, f4, f5);
    }

    public static void assertEquals(String str, long j, long j2) {
        Assert.assertEquals(str, j, j2);
    }

    public static void assertEquals(long j, long j2) {
        Assert.assertEquals(j, j2);
    }

    public static void assertEquals(String str, boolean z, boolean z2) {
        Assert.assertEquals(str, z, z2);
    }

    public static void assertEquals(boolean z, boolean z2) {
        Assert.assertEquals(z, z2);
    }

    public static void assertEquals(String str, byte b, byte b5) {
        Assert.assertEquals(str, b, b5);
    }

    public static void assertEquals(byte b, byte b5) {
        Assert.assertEquals(b, b5);
    }

    public static void assertEquals(String str, char c, char c2) {
        Assert.assertEquals(str, c, c2);
    }

    public static void assertEquals(char c, char c2) {
        Assert.assertEquals(c, c2);
    }

    public static void assertEquals(String str, short s, short s2) {
        Assert.assertEquals(str, s, s2);
    }

    public static void assertEquals(short s, short s2) {
        Assert.assertEquals(s, s2);
    }

    public static void assertEquals(String str, int i, int i2) {
        Assert.assertEquals(str, i, i2);
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public static void assertEquals(int i, int i2) {
        Assert.assertEquals(i, i2);
    }
}
