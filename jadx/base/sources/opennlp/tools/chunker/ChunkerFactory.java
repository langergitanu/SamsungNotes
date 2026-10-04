package opennlp.tools.chunker;

import androidx.appcompat.widget.AbstractC0541b;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.TokenTag;
import opennlp.tools.util.ext.ExtensionLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerFactory extends BaseToolFactory {
    public static ChunkerFactory create(String str) throws InvalidFormatException {
        if (str == null) {
            return new ChunkerFactory();
        }
        try {
            return (ChunkerFactory) ExtensionLoader.instantiateExtension(ChunkerFactory.class, str);
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
        }
    }

    public ChunkerContextGenerator getContextGenerator() {
        return new DefaultChunkerContextGenerator();
    }

    public SequenceValidator<TokenTag> getSequenceValidator() {
        return new DefaultChunkerSequenceValidator();
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() {
    }
}
