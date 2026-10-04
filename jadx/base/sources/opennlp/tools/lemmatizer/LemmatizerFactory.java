package opennlp.tools.lemmatizer;

import androidx.appcompat.widget.AbstractC0541b;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.ext.ExtensionLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmatizerFactory extends BaseToolFactory {
    public static LemmatizerFactory create(String str) throws InvalidFormatException {
        if (str == null) {
            return new LemmatizerFactory();
        }
        try {
            return (LemmatizerFactory) ExtensionLoader.instantiateExtension(LemmatizerFactory.class, str);
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
        }
    }

    public LemmatizerContextGenerator getContextGenerator() {
        return new DefaultLemmatizerContextGenerator();
    }

    public SequenceValidator<String> getSequenceValidator() {
        return new DefaultLemmatizerSequenceValidator();
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() {
    }
}
