package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.DetokenizerParameter;
import opennlp.tools.tokenize.DetokenizationDictionary;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.tokenize.DictionaryDetokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class DetokenizerSampleStreamFactory<T, P> extends AbstractSampleStreamFactory<T, P> {
    public DetokenizerSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public Detokenizer createDetokenizer(DetokenizerParameter detokenizerParameter) {
        try {
            return new DictionaryDetokenizer(new DetokenizationDictionary(new BufferedInputStream(new FileInputStream(detokenizerParameter.getDetokenizer()))));
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while loading detokenizer dict: ", e.getMessage()), e);
        }
    }
}
