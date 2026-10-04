package opennlp.tools.langdetect;

import androidx.appcompat.widget.AbstractC0541b;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.normalizer.EmojiCharSequenceNormalizer;
import opennlp.tools.util.normalizer.NumberCharSequenceNormalizer;
import opennlp.tools.util.normalizer.ShrinkCharSequenceNormalizer;
import opennlp.tools.util.normalizer.TwitterCharSequenceNormalizer;
import opennlp.tools.util.normalizer.UrlCharSequenceNormalizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorFactory extends BaseToolFactory {
    public static LanguageDetectorFactory create(String str) throws InvalidFormatException {
        if (str == null) {
            return new LanguageDetectorFactory();
        }
        try {
            LanguageDetectorFactory languageDetectorFactory = (LanguageDetectorFactory) ExtensionLoader.instantiateExtension(LanguageDetectorFactory.class, str);
            languageDetectorFactory.init();
            return languageDetectorFactory;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
        }
    }

    public LanguageDetectorContextGenerator getContextGenerator() {
        return new DefaultLanguageDetectorContextGenerator(1, 3, EmojiCharSequenceNormalizer.getInstance(), UrlCharSequenceNormalizer.getInstance(), TwitterCharSequenceNormalizer.getInstance(), NumberCharSequenceNormalizer.getInstance(), ShrinkCharSequenceNormalizer.getInstance());
    }

    public void init() {
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() {
    }
}
