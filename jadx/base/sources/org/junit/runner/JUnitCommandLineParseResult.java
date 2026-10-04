package org.junit.runner;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runners.model.InitializationError;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
class JUnitCommandLineParseResult {
    private final List<String> filterSpecs = new ArrayList();
    private final List<Class<?>> classes = new ArrayList();
    private final List<Throwable> parserErrors = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }

    private Request applyFilterSpecs(Request request) {
        try {
            Iterator<String> it = this.filterSpecs.iterator();
            while (it.hasNext()) {
                request = request.filterWith(FilterFactories.createFilterFromFilterSpec(request, it.next()));
            }
            return request;
        } catch (FilterFactory.FilterNotCreatedException e) {
            return errorReport(e);
        }
    }

    private String[] copyArray(String[] strArr, int i, int i2) {
        String[] strArr2 = new String[i2 - i];
        for (int i4 = i; i4 != i2; i4++) {
            strArr2[i4 - i] = strArr[i4];
        }
        return strArr2;
    }

    private Request errorReport(Throwable th) {
        return Request.errorReport(JUnitCommandLineParseResult.class, th);
    }

    public static JUnitCommandLineParseResult parse(String[] strArr) {
        JUnitCommandLineParseResult jUnitCommandLineParseResult = new JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.parseArgs(strArr);
        return jUnitCommandLineParseResult;
    }

    private void parseArgs(String[] strArr) {
        parseParameters(parseOptions(strArr));
    }

    public Request createRequest(Computer computer) {
        if (!this.parserErrors.isEmpty()) {
            return errorReport(new InitializationError(this.parserErrors));
        }
        List<Class<?>> list = this.classes;
        return applyFilterSpecs(Request.classes(computer, (Class[]) list.toArray(new Class[list.size()])));
    }

    public List<Class<?>> getClasses() {
        return Collections.unmodifiableList(this.classes);
    }

    public List<String> getFilterSpecs() {
        return Collections.unmodifiableList(this.filterSpecs);
    }

    public String[] parseOptions(String... strArr) {
        String strSubstring;
        int i = 0;
        while (true) {
            if (i == strArr.length) {
                break;
            }
            String str = strArr[i];
            if (str.equals("--")) {
                return copyArray(strArr, i + 1, strArr.length);
            }
            if (!str.startsWith("--")) {
                return copyArray(strArr, i, strArr.length);
            }
            if (str.startsWith("--filter=") || str.equals("--filter")) {
                if (str.equals("--filter")) {
                    i++;
                    if (i >= strArr.length) {
                        this.parserErrors.add(new CommandLineParserError(str.concat(" value not specified")));
                        break;
                    }
                    strSubstring = strArr[i];
                } else {
                    strSubstring = str.substring(str.indexOf(61) + 1);
                }
                this.filterSpecs.add(strSubstring);
            } else {
                this.parserErrors.add(new CommandLineParserError(AbstractC0541b.m773o("JUnit knows nothing about the ", str, " option")));
            }
            i++;
        }
        return new String[0];
    }

    public void parseParameters(String[] strArr) {
        for (String str : strArr) {
            try {
                this.classes.add(Classes.getClass(str));
            } catch (ClassNotFoundException e) {
                this.parserErrors.add(new IllegalArgumentException(AbstractC0541b.m773o("Could not find class [", str, "]"), e));
            }
        }
    }
}
