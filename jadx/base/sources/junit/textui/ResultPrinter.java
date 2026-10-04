package junit.textui;

import androidx.compose.runtime.AbstractC1974b;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;
import opennlp.tools.tokenize.TokenizerME;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ResultPrinter implements TestListener {
    int fColumn = 0;
    PrintStream fWriter;

    public ResultPrinter(PrintStream printStream) {
        this.fWriter = printStream;
    }

    @Override // junit.framework.TestListener
    public void addError(Test test, Throwable th) {
        getWriter().print(ExifInterface.LONGITUDE_EAST);
    }

    @Override // junit.framework.TestListener
    public void addFailure(Test test, AssertionFailedError assertionFailedError) {
        getWriter().print(TokenizerME.NO_SPLIT);
    }

    public String elapsedTimeAsString(long j) {
        return NumberFormat.getInstance().format(j / 1000.0d);
    }

    public PrintStream getWriter() {
        return this.fWriter;
    }

    public synchronized void print(TestResult testResult, long j) {
        printHeader(j);
        printErrors(testResult);
        printFailures(testResult);
        printFooter(testResult);
    }

    public void printDefect(TestFailure testFailure, int i) {
        printDefectHeader(testFailure, i);
        printDefectTrace(testFailure);
    }

    public void printDefectHeader(TestFailure testFailure, int i) {
        PrintStream writer = getWriter();
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, ") ");
        sbM1322o.append(testFailure.failedTest());
        writer.print(sbM1322o.toString());
    }

    public void printDefectTrace(TestFailure testFailure) {
        getWriter().print(BaseTestRunner.getFilteredTrace(testFailure.trace()));
    }

    public void printDefects(Enumeration<TestFailure> enumeration, int i, String str) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            getWriter().println(AbstractC11014a.m12321f("There was ", i, " ", str, ":"));
        } else {
            getWriter().println(AbstractC11014a.m12321f("There were ", i, " ", str, "s:"));
        }
        int i2 = 1;
        while (enumeration.hasMoreElements()) {
            printDefect(enumeration.nextElement(), i2);
            i2++;
        }
    }

    public void printErrors(TestResult testResult) {
        printDefects(testResult.errors(), testResult.errorCount(), "error");
    }

    public void printFailures(TestResult testResult) {
        printDefects(testResult.failures(), testResult.failureCount(), Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
    }

    public void printFooter(TestResult testResult) {
        if (testResult.wasSuccessful()) {
            getWriter().println();
            getWriter().print(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK);
            PrintStream writer = getWriter();
            StringBuilder sb = new StringBuilder(" (");
            sb.append(testResult.runCount());
            sb.append(" test");
            sb.append(testResult.runCount() == 1 ? "" : "s");
            sb.append(")");
            writer.println(sb.toString());
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            getWriter().println("Tests run: " + testResult.runCount() + ",  Failures: " + testResult.failureCount() + ",  Errors: " + testResult.errorCount());
        }
        getWriter().println();
    }

    public void printHeader(long j) {
        getWriter().println();
        getWriter().println("Time: " + elapsedTimeAsString(j));
    }

    public void printWaitPrompt() {
        getWriter().println();
        getWriter().println("<RETURN> to continue");
    }

    @Override // junit.framework.TestListener
    public void startTest(Test test) {
        getWriter().print(Extension.DOT);
        int i = this.fColumn;
        this.fColumn = i + 1;
        if (i >= 40) {
            getWriter().println();
            this.fColumn = 0;
        }
    }

    @Override // junit.framework.TestListener
    public void endTest(Test test) {
    }
}
