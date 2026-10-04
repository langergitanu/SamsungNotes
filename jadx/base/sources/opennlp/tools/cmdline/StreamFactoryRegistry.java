package opennlp.tools.cmdline;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.formats.BioNLP2004NameSampleStreamFactory;
import opennlp.tools.formats.ChunkerSampleStreamFactory;
import opennlp.tools.formats.Conll02NameSampleStreamFactory;
import opennlp.tools.formats.Conll03NameSampleStreamFactory;
import opennlp.tools.formats.ConllXPOSSampleStreamFactory;
import opennlp.tools.formats.ConllXSentenceSampleStreamFactory;
import opennlp.tools.formats.ConllXTokenSampleStreamFactory;
import opennlp.tools.formats.DocumentSampleStreamFactory;
import opennlp.tools.formats.EvalitaNameSampleStreamFactory;
import opennlp.tools.formats.LanguageDetectorSampleStreamFactory;
import opennlp.tools.formats.LemmatizerSampleStreamFactory;
import opennlp.tools.formats.NameSampleDataStreamFactory;
import opennlp.tools.formats.ParseSampleStreamFactory;
import opennlp.tools.formats.SentenceSampleStreamFactory;
import opennlp.tools.formats.TokenSampleStreamFactory;
import opennlp.tools.formats.TwentyNewsgroupSampleStreamFactory;
import opennlp.tools.formats.WordTagSampleStreamFactory;
import opennlp.tools.formats.brat.BratNameSampleStreamFactory;
import opennlp.tools.formats.conllu.ConlluLemmaSampleStreamFactory;
import opennlp.tools.formats.conllu.ConlluPOSSampleStreamFactory;
import opennlp.tools.formats.conllu.ConlluSentenceSampleStreamFactory;
import opennlp.tools.formats.conllu.ConlluTokenSampleStreamFactory;
import opennlp.tools.formats.convert.NameToSentenceSampleStreamFactory;
import opennlp.tools.formats.convert.NameToTokenSampleStreamFactory;
import opennlp.tools.formats.convert.POSToSentenceSampleStreamFactory;
import opennlp.tools.formats.convert.POSToTokenSampleStreamFactory;
import opennlp.tools.formats.convert.ParseToPOSSampleStreamFactory;
import opennlp.tools.formats.convert.ParseToSentenceSampleStreamFactory;
import opennlp.tools.formats.convert.ParseToTokenSampleStreamFactory;
import opennlp.tools.formats.frenchtreebank.ConstitParseSampleStreamFactory;
import opennlp.tools.formats.irishsentencebank.IrishSentenceBankSentenceStreamFactory;
import opennlp.tools.formats.irishsentencebank.IrishSentenceBankTokenSampleStreamFactory;
import opennlp.tools.formats.leipzig.LeipzigLanguageSampleStreamFactory;
import opennlp.tools.formats.letsmt.LetsmtSentenceStreamFactory;
import opennlp.tools.formats.masc.MascNamedEntitySampleStreamFactory;
import opennlp.tools.formats.masc.MascPOSSampleStreamFactory;
import opennlp.tools.formats.masc.MascSentenceSampleStreamFactory;
import opennlp.tools.formats.masc.MascTokenSampleStreamFactory;
import opennlp.tools.formats.moses.MosesSentenceSampleStreamFactory;
import opennlp.tools.formats.muc.Muc6NameSampleStreamFactory;
import opennlp.tools.formats.nkjp.NKJPSentenceSampleStreamFactory;
import opennlp.tools.formats.ontonotes.OntoNotesNameSampleStreamFactory;
import opennlp.tools.formats.ontonotes.OntoNotesPOSSampleStreamFactory;
import opennlp.tools.formats.ontonotes.OntoNotesParseSampleStreamFactory;
import opennlp.tools.formats.p216ad.ADChunkSampleStreamFactory;
import opennlp.tools.formats.p216ad.ADNameSampleStreamFactory;
import opennlp.tools.formats.p216ad.ADPOSSampleStreamFactory;
import opennlp.tools.formats.p216ad.ADSentenceSampleStreamFactory;
import opennlp.tools.formats.p216ad.ADTokenSampleStreamFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class StreamFactoryRegistry {
    public static final String DEFAULT_FORMAT = "opennlp";
    private static final Map<Class<?>, Map<String, ObjectStreamFactory<?, ?>>> registry = new HashMap();

    static {
        ChunkerSampleStreamFactory.registerFactory();
        DocumentSampleStreamFactory.registerFactory();
        NameSampleDataStreamFactory.registerFactory();
        ParseSampleStreamFactory.registerFactory();
        SentenceSampleStreamFactory.registerFactory();
        TokenSampleStreamFactory.registerFactory();
        WordTagSampleStreamFactory.registerFactory();
        LemmatizerSampleStreamFactory.registerFactory();
        LanguageDetectorSampleStreamFactory.registerFactory();
        NameToSentenceSampleStreamFactory.registerFactory();
        NameToTokenSampleStreamFactory.registerFactory();
        POSToSentenceSampleStreamFactory.registerFactory();
        POSToTokenSampleStreamFactory.registerFactory();
        ParseToPOSSampleStreamFactory.registerFactory();
        ParseToSentenceSampleStreamFactory.registerFactory();
        ParseToTokenSampleStreamFactory.registerFactory();
        OntoNotesNameSampleStreamFactory.registerFactory();
        OntoNotesParseSampleStreamFactory.registerFactory();
        OntoNotesPOSSampleStreamFactory.registerFactory();
        BioNLP2004NameSampleStreamFactory.registerFactory();
        Conll02NameSampleStreamFactory.registerFactory();
        Conll03NameSampleStreamFactory.registerFactory();
        EvalitaNameSampleStreamFactory.registerFactory();
        ConllXPOSSampleStreamFactory.registerFactory();
        ConllXSentenceSampleStreamFactory.registerFactory();
        ConllXTokenSampleStreamFactory.registerFactory();
        ADChunkSampleStreamFactory.registerFactory();
        ADNameSampleStreamFactory.registerFactory();
        ADSentenceSampleStreamFactory.registerFactory();
        ADPOSSampleStreamFactory.registerFactory();
        ADTokenSampleStreamFactory.registerFactory();
        TwentyNewsgroupSampleStreamFactory.registerFactory();
        Muc6NameSampleStreamFactory.registerFactory();
        ConstitParseSampleStreamFactory.registerFactory();
        BratNameSampleStreamFactory.registerFactory();
        LetsmtSentenceStreamFactory.registerFactory();
        MosesSentenceSampleStreamFactory.registerFactory();
        ConlluTokenSampleStreamFactory.registerFactory();
        ConlluSentenceSampleStreamFactory.registerFactory();
        ConlluPOSSampleStreamFactory.registerFactory();
        ConlluLemmaSampleStreamFactory.registerFactory();
        IrishSentenceBankSentenceStreamFactory.registerFactory();
        IrishSentenceBankTokenSampleStreamFactory.registerFactory();
        LeipzigLanguageSampleStreamFactory.registerFactory();
        NKJPSentenceSampleStreamFactory.registerFactory();
        MascNamedEntitySampleStreamFactory.registerFactory();
        MascPOSSampleStreamFactory.registerFactory();
        MascSentenceSampleStreamFactory.registerFactory();
        MascTokenSampleStreamFactory.registerFactory();
    }

    private StreamFactoryRegistry() {
    }

    public static <T, P> Map<String, ObjectStreamFactory<T, P>> getFactories(Class<T> cls) {
        return (Map) registry.get(cls);
    }

    public static <T, P> ObjectStreamFactory<T, P> getFactory(Class<T> cls, String str) {
        if (str == null) {
            str = "opennlp";
        }
        Map<Class<?>, Map<String, ObjectStreamFactory<?, ?>>> map = registry;
        ObjectStreamFactory<T, P> objectStreamFactory = map.containsKey(cls) ? (ObjectStreamFactory) map.get(cls).get(str) : null;
        if (objectStreamFactory != null) {
            return objectStreamFactory;
        }
        try {
            return (ObjectStreamFactory) Class.forName(str).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <T, P> boolean registerFactory(Class<T> cls, String str, ObjectStreamFactory<T, P> objectStreamFactory) {
        Map<Class<?>, Map<String, ObjectStreamFactory<?, ?>>> map = registry;
        Map<String, ObjectStreamFactory<?, ?>> map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (map2.containsKey(str)) {
            return false;
        }
        map2.put(str, objectStreamFactory);
        map.put(cls, map2);
        return true;
    }

    public static <T> void unregisterFactory(Class<T> cls, String str) {
        Map<String, ObjectStreamFactory<?, ?>> map = registry.get(cls);
        if (map != null) {
            map.remove(str);
        }
    }
}
