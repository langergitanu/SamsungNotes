package opennlp.tools.util.eval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Evaluator<T> {
    private final List<EvaluationMonitor<T>> listeners;

    @SafeVarargs
    public Evaluator(EvaluationMonitor<T>... evaluationMonitorArr) {
        if (evaluationMonitorArr == null) {
            this.listeners = Collections.EMPTY_LIST;
            return;
        }
        ArrayList arrayList = new ArrayList(evaluationMonitorArr.length);
        for (EvaluationMonitor<T> evaluationMonitor : evaluationMonitorArr) {
            if (evaluationMonitor != null) {
                arrayList.add(evaluationMonitor);
            }
        }
        this.listeners = Collections.unmodifiableList(arrayList);
    }

    public void evaluate(ObjectStream<T> objectStream) {
        while (true) {
            T t = objectStream.read();
            if (t == null) {
                return;
            } else {
                evaluateSample(t);
            }
        }
    }

    public void evaluateSample(T t) {
        T tProcessSample = processSample(t);
        if (this.listeners.isEmpty()) {
            return;
        }
        if (t.equals(tProcessSample)) {
            Iterator<EvaluationMonitor<T>> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().correctlyClassified(t, tProcessSample);
            }
        } else {
            Iterator<EvaluationMonitor<T>> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().misclassified(t, tProcessSample);
            }
        }
    }

    public abstract T processSample(T t);
}
