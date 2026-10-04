package org.junit.internal;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class Throwables {
    private static final Method getSuppressed = initGetSuppressed();
    private static final String[] TEST_FRAMEWORK_METHOD_NAME_PREFIXES = {"org.junit.runner.", "org.junit.runners.", "org.junit.experimental.runners.", "org.junit.internal.", "junit.extensions", "junit.framework", "junit.runner", "junit.textui"};
    private static final String[] TEST_FRAMEWORK_TEST_METHOD_NAME_PREFIXES = {"org.junit.internal.StackTracesTest"};
    private static final String[] REFLECTION_METHOD_NAME_PREFIXES = {"sun.reflect.", "java.lang.reflect.", "jdk.internal.reflect.", "org.junit.rules.RunRules.<init>(", "org.junit.rules.RunRules.applyAll(", "org.junit.runners.RuleContainer.apply(", "junit.framework.TestCase.runBare("};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        PROCESSING_OTHER_CODE { // from class: org.junit.internal.Throwables.State.1
            @Override // org.junit.internal.Throwables.State
            public State processLine(String str) {
                return Throwables.isTestFrameworkMethod(str) ? State.PROCESSING_TEST_FRAMEWORK_CODE : this;
            }
        },
        PROCESSING_TEST_FRAMEWORK_CODE { // from class: org.junit.internal.Throwables.State.2
            @Override // org.junit.internal.Throwables.State
            public State processLine(String str) {
                return Throwables.isReflectionMethod(str) ? State.PROCESSING_REFLECTION_CODE : Throwables.isTestFrameworkMethod(str) ? this : State.PROCESSING_OTHER_CODE;
            }
        },
        PROCESSING_REFLECTION_CODE { // from class: org.junit.internal.Throwables.State.3
            @Override // org.junit.internal.Throwables.State
            public State processLine(String str) {
                return Throwables.isReflectionMethod(str) ? this : Throwables.isTestFrameworkMethod(str) ? State.PROCESSING_TEST_FRAMEWORK_CODE : State.DONE;
            }
        },
        DONE { // from class: org.junit.internal.Throwables.State.4
            @Override // org.junit.internal.Throwables.State
            public State processLine(String str) {
                return this;
            }
        };

        public abstract State processLine(String str);

        public final State processStackTraceElement(StackTraceElement stackTraceElement) {
            return processLine(stackTraceElement.getClassName() + Extension.DOT + stackTraceElement.getMethodName() + "()");
        }
    }

    private Throwables() {
    }

    private static void appendStackTraceLines(List<String> list, StringBuilder sb) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(String.format("%s%n", it.next()));
        }
    }

    private static <T> List<T> asReversedList(final List<T> list) {
        return new AbstractList<T>() { // from class: org.junit.internal.Throwables.1
            @Override // java.util.AbstractList, java.util.List
            public T get(int i) {
                return (T) list.get((r0.size() - i) - 1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return list.size();
            }
        };
    }

    private static List<String> getCauseStackTraceLines(Throwable th) {
        String line;
        if (th.getCause() != null || hasSuppressed(th)) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(getFullStackTrace(th).substring(th.toString().length())));
            ArrayList arrayList = new ArrayList();
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        if (line.startsWith("Caused by: ")) {
                            break;
                        }
                    }
                } catch (IOException unused) {
                }
            } while (!line.trim().startsWith("Suppressed: "));
            arrayList.add(line);
            while (true) {
                String line2 = bufferedReader.readLine();
                if (line2 == null) {
                    return arrayList;
                }
                arrayList.add(line2);
            }
        }
        return Collections.EMPTY_LIST;
    }

    private static String getFullStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String getStacktrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String getTrimmedStackTrace(Throwable th) {
        List<String> trimmedStackTraceLines = getTrimmedStackTraceLines(th);
        if (trimmedStackTraceLines.isEmpty()) {
            return getFullStackTrace(th);
        }
        StringBuilder sb = new StringBuilder(th.toString());
        appendStackTraceLines(trimmedStackTraceLines, sb);
        appendStackTraceLines(getCauseStackTraceLines(th), sb);
        return sb.toString();
    }

    private static List<String> getTrimmedStackTraceLines(Throwable th) {
        List listAsList = Arrays.asList(th.getStackTrace());
        int size = listAsList.size();
        State stateProcessStackTraceElement = State.PROCESSING_OTHER_CODE;
        Iterator it = asReversedList(listAsList).iterator();
        while (it.hasNext()) {
            stateProcessStackTraceElement = stateProcessStackTraceElement.processStackTraceElement((StackTraceElement) it.next());
            if (stateProcessStackTraceElement == State.DONE) {
                ArrayList arrayList = new ArrayList(size + 2);
                arrayList.add("");
                Iterator it2 = listAsList.subList(0, size).iterator();
                while (it2.hasNext()) {
                    arrayList.add("\tat " + ((StackTraceElement) it2.next()));
                }
                if (th.getCause() != null) {
                    arrayList.add("\t... " + (listAsList.size() - arrayList.size()) + " trimmed");
                }
                return arrayList;
            }
            size--;
        }
        return Collections.EMPTY_LIST;
    }

    private static boolean hasSuppressed(Throwable th) {
        Method method = getSuppressed;
        if (method == null) {
            return false;
        }
        return ((Throwable[]) method.invoke(th, null)).length != 0;
    }

    private static Method initGetSuppressed() {
        try {
            return Throwable.class.getMethod("getSuppressed", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isMatchingMethod(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isReflectionMethod(String str) {
        return isMatchingMethod(str, REFLECTION_METHOD_NAME_PREFIXES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTestFrameworkMethod(String str) {
        return isMatchingMethod(str, TEST_FRAMEWORK_METHOD_NAME_PREFIXES) && !isMatchingMethod(str, TEST_FRAMEWORK_TEST_METHOD_NAME_PREFIXES);
    }

    public static Exception rethrowAsException(Throwable th) throws Throwable {
        rethrow(th);
        return null;
    }

    private static <T extends Throwable> void rethrow(Throwable th) throws Throwable {
        throw th;
    }
}
