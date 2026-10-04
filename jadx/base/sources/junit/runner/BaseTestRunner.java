package junit.runner;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;
import org.junit.internal.Throwables;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseTestRunner implements TestListener {
    public static final String SUITE_METHODNAME = "suite";
    private static Properties fPreferences = null;
    static boolean fgFilterStack = true;
    static int fgMaxMessageLength = getPreference("maxmessage", 500);
    boolean fLoading = true;

    public static boolean filterLine(String str) {
        String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
        for (int i = 0; i < 8; i++) {
            if (str.indexOf(strArr[i]) > 0) {
                return true;
            }
        }
        return false;
    }

    public static String getFilteredTrace(Throwable th) {
        return getFilteredTrace(Throwables.getStacktrace(th));
    }

    public static String getPreference(String str) {
        return getPreferences().getProperty(str);
    }

    public static Properties getPreferences() throws Throwable {
        if (fPreferences == null) {
            Properties properties = new Properties();
            fPreferences = properties;
            properties.put("loading", "true");
            fPreferences.put("filterstack", "true");
            readPreferences();
        }
        return fPreferences;
    }

    private static File getPreferencesFile() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    private static void readPreferences() throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(getPreferencesFile());
                try {
                    setPreferences(new Properties(getPreferences()));
                    getPreferences().load(fileInputStream);
                    fileInputStream.close();
                } catch (IOException unused) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 == null) {
                        return;
                    }
                    fileInputStream2.close();
                } catch (SecurityException unused2) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 == null) {
                        return;
                    }
                    fileInputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        } catch (IOException unused5) {
        } catch (SecurityException unused6) {
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static void savePreferences() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(getPreferencesFile());
        try {
            getPreferences().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    public static void setPreference(String str, String str2) {
        getPreferences().put(str, str2);
    }

    public static void setPreferences(Properties properties) {
        fPreferences = properties;
    }

    public static boolean showStackRaw() {
        return (getPreference("filterstack").equals("true") && fgFilterStack) ? false : true;
    }

    public static String truncate(String str) {
        if (fgMaxMessageLength == -1 || str.length() <= fgMaxMessageLength) {
            return str;
        }
        return str.substring(0, fgMaxMessageLength) + "...";
    }

    @Override // junit.framework.TestListener
    public synchronized void addError(Test test, Throwable th) {
        testFailed(1, test, th);
    }

    @Override // junit.framework.TestListener
    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        testFailed(2, test, assertionFailedError);
    }

    public String elapsedTimeAsString(long j) {
        return NumberFormat.getInstance().format(j / 1000.0d);
    }

    @Override // junit.framework.TestListener
    public synchronized void endTest(Test test) {
        testEnded(test.toString());
    }

    public String extractClassName(String str) {
        return str.startsWith("Default package for") ? str.substring(str.lastIndexOf(Extension.DOT) + 1) : str;
    }

    public Test getTest(String str) {
        if (str.length() <= 0) {
            clearStatus();
            return null;
        }
        try {
            Class<?> clsLoadSuiteClass = loadSuiteClass(str);
            try {
                Method method = clsLoadSuiteClass.getMethod(SUITE_METHODNAME, null);
                if (!Modifier.isStatic(method.getModifiers())) {
                    runFailed("Suite() method must be static");
                    return null;
                }
                try {
                    Test test = (Test) method.invoke(null, null);
                    if (test == null) {
                        return test;
                    }
                    clearStatus();
                    return test;
                } catch (IllegalAccessException e) {
                    runFailed("Failed to invoke suite():" + e.toString());
                    return null;
                } catch (InvocationTargetException e2) {
                    runFailed("Failed to invoke suite():" + e2.getTargetException().toString());
                    return null;
                }
            } catch (Exception unused) {
                clearStatus();
                return new TestSuite(clsLoadSuiteClass);
            }
        } catch (ClassNotFoundException e3) {
            String message = e3.getMessage();
            if (message != null) {
                str = message;
            }
            runFailed("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e5) {
            runFailed("Error: " + e5.toString());
            return null;
        }
    }

    public Class<?> loadSuiteClass(String str) {
        return Class.forName(str);
    }

    public String processArguments(String[] strArr) {
        String strExtractClassName = null;
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].equals("-noloading")) {
                setLoading(false);
            } else if (strArr[i].equals("-nofilterstack")) {
                fgFilterStack = false;
            } else if (strArr[i].equals("-c")) {
                i++;
                if (strArr.length > i) {
                    strExtractClassName = extractClassName(strArr[i]);
                } else {
                    System.out.println("Missing Test class name");
                }
            } else {
                strExtractClassName = strArr[i];
            }
            i++;
        }
        return strExtractClassName;
    }

    public abstract void runFailed(String str);

    public void setLoading(boolean z) {
        this.fLoading = z;
    }

    @Override // junit.framework.TestListener
    public synchronized void startTest(Test test) {
        testStarted(test.toString());
    }

    public abstract void testEnded(String str);

    public abstract void testFailed(int i, Test test, Throwable th);

    public abstract void testStarted(String str);

    public boolean useReloadingTestSuiteLoader() {
        return getPreference("loading").equals("true") && this.fLoading;
    }

    public static String getFilteredTrace(String str) {
        if (showStackRaw()) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return stringWriter.toString();
                }
                if (!filterLine(line)) {
                    printWriter.println(line);
                }
            } catch (Exception unused) {
                return str;
            }
        }
    }

    public static int getPreference(String str, int i) {
        String preference = getPreference(str);
        if (preference == null) {
            return i;
        }
        try {
            return Integer.parseInt(preference);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public void clearStatus() {
    }
}
