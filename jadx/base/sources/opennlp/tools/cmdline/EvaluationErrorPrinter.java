package opennlp.tools.cmdline;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.Span;
import opennlp.tools.util.eval.EvaluationMonitor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public abstract class EvaluationErrorPrinter<T> implements EvaluationMonitor<T> {
    protected PrintStream printStream;

    public EvaluationErrorPrinter(OutputStream outputStream) {
        this(new PrintStream(outputStream));
    }

    private void findErrors(Span[] spanArr, Span[] spanArr2, List<Span> list, List<Span> list2) {
        list.addAll(Arrays.asList(spanArr));
        list2.addAll(Arrays.asList(spanArr2));
        for (Span span : spanArr) {
            for (Span span2 : spanArr2) {
                if (span.equals(span2)) {
                    list.remove(span);
                    list2.remove(span2);
                }
            }
        }
    }

    private String print(List<Span> list, String[] strArr) {
        return Arrays.toString(Span.spansToStrings((Span[]) list.toArray(new Span[0]), strArr));
    }

    private void printErrors(List<String> list, List<String> list2, List<String> list3) {
        this.printStream.println("Errors: {");
        this.printStream.println("Tok: Ref | Pred");
        this.printStream.println("---------------");
        for (int i = 0; i < list.size(); i++) {
            this.printStream.println(AbstractC2322a.m1622l(list.get(i), ": ", list2.get(i), " | ", list3.get(i)));
        }
        this.printStream.println("}\n");
    }

    private <S> void printSamples(S s, S s2) {
        this.printStream.println("Expected: {\n" + s + "}\nPredicted: {\n" + s2 + "}");
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public abstract void misclassified(T t, T t2);

    public void printError(Span[] spanArr, Span[] spanArr2, T t, T t2, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        findErrors(spanArr, spanArr2, arrayList, arrayList2);
        if (arrayList.size() + arrayList2.size() > 0) {
            printSamples(t, t2);
            printErrors(arrayList2, arrayList, str);
        }
    }

    public EvaluationErrorPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printError(String str, Span[] spanArr, Span[] spanArr2, T t, T t2, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        findErrors(spanArr, spanArr2, arrayList, arrayList2);
        if (arrayList.size() + arrayList2.size() > 0) {
            if (str != null) {
                this.printStream.println("Id: {" + str + "}");
            }
            printSamples(t, t2);
            printErrors(arrayList2, arrayList, strArr);
        }
    }

    public void printError(Span[] spanArr, Span[] spanArr2, T t, T t2, String[] strArr) {
        printError(null, spanArr, spanArr2, t, t2, strArr);
    }

    public void printError(String[] strArr, String[] strArr2, T t, T t2, String[] strArr3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].equals(strArr2[i])) {
                arrayList.add(strArr3[i]);
                arrayList2.add(strArr[i]);
                arrayList3.add(strArr2[i]);
            }
        }
        if (arrayList.size() > 0) {
            printSamples(t, t2);
            printErrors(arrayList, arrayList2, arrayList3);
        }
    }

    private void printErrors(List<Span> list, List<Span> list2, String str) {
        this.printStream.println("False positives: {");
        Iterator<Span> it = list.iterator();
        while (it.hasNext()) {
            this.printStream.println(it.next().getCoveredText(str));
        }
        this.printStream.println("} False negatives: {");
        Iterator<Span> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.printStream.println(it2.next().getCoveredText(str));
        }
        this.printStream.println("}\n");
    }

    private void printErrors(List<Span> list, List<Span> list2, String[] strArr) {
        this.printStream.println("False positives: {");
        this.printStream.println(print(list, strArr));
        this.printStream.println("} False negatives: {");
        this.printStream.println(print(list2, strArr));
        this.printStream.println("}\n");
    }

    public void printError(T t, T t2) {
        printSamples(t, t2);
        this.printStream.println();
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(T t, T t2) {
    }
}
