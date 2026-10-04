package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import opennlp.tools.util.InsufficientTrainingDataException;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractTrainerTool<T, P> extends AbstractEvaluatorTool<T, P> {
    protected TrainingParameters mlParams;

    public AbstractTrainerTool(Class<T> cls, Class<P> cls2) {
        super(cls, cls2);
    }

    public TerminateToolException createTerminationIOException(IOException iOException) {
        return iOException instanceof InsufficientTrainingDataException ? new TerminateToolException(-1, "\n\nERROR: Not enough training data\nThe provided training data is not sufficient to create enough events to train a model.\nTo resolve this error use more training data, if this doesn't help there might\nbe some fundamental problem with the training data itself.") : new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading training data or indexing data: ", iOException.getMessage()), iOException);
    }
}
