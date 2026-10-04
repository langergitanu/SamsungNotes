package opennlp.tools.postag;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.Version;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;
import opennlp.tools.util.featuregen.GeneratorFactory;
import opennlp.tools.util.model.ArtifactProvider;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.UncloseableInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTaggerFactory extends BaseToolFactory {
    private static final String NGRAM_DICTIONARY_ENTRY_NAME = "ngram.dictionary";
    private static final String TAG_DICTIONARY_ENTRY_NAME = "tags.tagdict";
    private byte[] featureGeneratorBytes;
    protected Dictionary ngramDictionary;
    protected TagDictionary posDictionary;
    private Map<String, Object> resources;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class POSDictionarySerializer implements ArtifactSerializer<POSDictionary> {
        public static void register(Map<String, ArtifactSerializer<?>> map) {
            map.put("tagdict", new POSDictionarySerializer());
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public POSDictionary create(InputStream inputStream) {
            return POSDictionary.create(new UncloseableInputStream(inputStream));
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public void serialize(POSDictionary pOSDictionary, OutputStream outputStream) {
            pOSDictionary.serialize(outputStream);
        }
    }

    public POSTaggerFactory() {
    }

    @Deprecated
    public static POSTaggerFactory create(String str, Dictionary dictionary, TagDictionary tagDictionary) throws InvalidFormatException {
        if (str == null) {
            return new POSTaggerFactory(dictionary, tagDictionary);
        }
        try {
            POSTaggerFactory pOSTaggerFactory = (POSTaggerFactory) ExtensionLoader.instantiateExtension(POSTaggerFactory.class, str);
            pOSTaggerFactory.init(dictionary, tagDictionary);
            return pOSTaggerFactory;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization throw an exception."), e);
        }
    }

    @Deprecated(forRemoval = true)
    private Dictionary getDictionary() {
        ArtifactProvider artifactProvider;
        if (this.ngramDictionary == null && (artifactProvider = this.artifactProvider) != null) {
            this.ngramDictionary = (Dictionary) artifactProvider.getArtifact(NGRAM_DICTIONARY_ENTRY_NAME);
        }
        return this.ngramDictionary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$createFeatureGenerators$0(String str) {
        ArtifactProvider artifactProvider = this.artifactProvider;
        return artifactProvider != null ? artifactProvider.getArtifact(str) : this.resources.get(str);
    }

    private static byte[] loadDefaultFeatureGeneratorBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream resourceAsStream = POSTaggerFactory.class.getResourceAsStream("/opennlp/tools/postag/pos-default-features.xml");
        if (resourceAsStream == null) {
            throw new IllegalStateException("Classpath must contain 'pos-default-features.xml' file!");
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i <= 0) {
                        bufferedInputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (IOException unused) {
            throw new IllegalStateException("Failed reading from 'pos-default-features.xml' file on classpath!");
        }
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public Map<String, Object> createArtifactMap() {
        Map<String, Object> mapCreateArtifactMap = super.createArtifactMap();
        TagDictionary tagDictionary = this.posDictionary;
        if (tagDictionary != null) {
            mapCreateArtifactMap.put(TAG_DICTIONARY_ENTRY_NAME, tagDictionary);
        }
        Dictionary dictionary = this.ngramDictionary;
        if (dictionary != null) {
            mapCreateArtifactMap.put(NGRAM_DICTIONARY_ENTRY_NAME, dictionary);
        }
        return mapCreateArtifactMap;
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public Map<String, ArtifactSerializer<?>> createArtifactSerializersMap() {
        Map<String, ArtifactSerializer<?>> mapCreateArtifactSerializersMap = super.createArtifactSerializersMap();
        POSDictionarySerializer.register(mapCreateArtifactSerializersMap);
        return mapCreateArtifactSerializersMap;
    }

    public TagDictionary createEmptyTagDictionary() {
        POSDictionary pOSDictionary = new POSDictionary(true);
        this.posDictionary = pOSDictionary;
        return pOSDictionary;
    }

    public AdaptiveFeatureGenerator createFeatureGenerators() {
        ArtifactProvider artifactProvider;
        if (this.featureGeneratorBytes == null && (artifactProvider = this.artifactProvider) != null) {
            this.featureGeneratorBytes = (byte[]) artifactProvider.getArtifact("generator.featuregen");
        }
        if (this.featureGeneratorBytes == null) {
            this.featureGeneratorBytes = loadDefaultFeatureGeneratorBytes();
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.featureGeneratorBytes);
            try {
                AdaptiveFeatureGenerator adaptiveFeatureGeneratorCreate = GeneratorFactory.create(byteArrayInputStream, new C11253j(this, 21));
                byteArrayInputStream.close();
                return adaptiveFeatureGeneratorCreate;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (InvalidFormatException e) {
            throw new IllegalStateException(e);
        } catch (IOException e2) {
            throw new IllegalStateException("Reading from mem cannot result in an I/O error", e2);
        }
    }

    public TagDictionary createTagDictionary(File file) {
        return createTagDictionary(new BufferedInputStream(new FileInputStream(file)));
    }

    public byte[] getFeatureGenerator() {
        return this.featureGeneratorBytes;
    }

    public POSContextGenerator getPOSContextGenerator() {
        return getPOSContextGenerator(0);
    }

    public Map<String, Object> getResources() {
        Map<String, Object> map = this.resources;
        return map != null ? map : Collections.EMPTY_MAP;
    }

    public SequenceValidator<String> getSequenceValidator() {
        return new DefaultPOSSequenceValidator(getTagDictionary());
    }

    public TagDictionary getTagDictionary() {
        ArtifactProvider artifactProvider;
        if (this.posDictionary == null && (artifactProvider = this.artifactProvider) != null) {
            this.posDictionary = (TagDictionary) artifactProvider.getArtifact(TAG_DICTIONARY_ENTRY_NAME);
        }
        return this.posDictionary;
    }

    @Deprecated(forRemoval = true)
    public void init(Dictionary dictionary, TagDictionary tagDictionary) {
        this.ngramDictionary = dictionary;
        this.posDictionary = tagDictionary;
    }

    public void setTagDictionary(TagDictionary tagDictionary) {
        if (this.artifactProvider != null) {
            throw new IllegalStateException("Can not set tag dictionary while using artifact provider.");
        }
        this.posDictionary = tagDictionary;
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() throws InvalidFormatException {
        Object artifact = this.artifactProvider.getArtifact(TAG_DICTIONARY_ENTRY_NAME);
        if (artifact != null) {
            if (!(artifact instanceof POSDictionary)) {
                throw new InvalidFormatException("POSTag dictionary has wrong type!");
            }
            if (!this.artifactProvider.isLoadedFromSerialized()) {
                validatePOSDictionary((POSDictionary) artifact, (AbstractModel) this.artifactProvider.getArtifact("pos.model"));
            }
        }
        Object artifact2 = this.artifactProvider.getArtifact(NGRAM_DICTIONARY_ENTRY_NAME);
        if (artifact2 != null && !(artifact2 instanceof Dictionary)) {
            throw new InvalidFormatException("NGram dictionary has wrong type!");
        }
    }

    public void validatePOSDictionary(POSDictionary pOSDictionary, AbstractModel abstractModel) throws InvalidFormatException {
        HashSet<String> hashSet = new HashSet();
        Iterator<String> it = pOSDictionary.iterator();
        while (it.hasNext()) {
            Collections.addAll(hashSet, pOSDictionary.getTags(it.next()));
        }
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < abstractModel.getNumOutcomes(); i++) {
            hashSet2.add(abstractModel.getOutcome(i));
        }
        if (hashSet2.containsAll(hashSet)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : hashSet) {
            if (!hashSet2.contains(str)) {
                sb.append(str);
                sb.append(" ");
            }
        }
        throw new InvalidFormatException("Tag dictionary contains tags which are unknown by the model! The unknown tags are: " + ((Object) sb));
    }

    public POSTaggerFactory(byte[] bArr, Map<String, Object> map, TagDictionary tagDictionary) {
        this.featureGeneratorBytes = bArr;
        if (bArr == null) {
            this.featureGeneratorBytes = loadDefaultFeatureGeneratorBytes();
        }
        this.resources = map;
        this.posDictionary = tagDictionary;
    }

    public TagDictionary createTagDictionary(InputStream inputStream) {
        return POSDictionary.create(inputStream);
    }

    public POSContextGenerator getPOSContextGenerator(int i) {
        ArtifactProvider artifactProvider = this.artifactProvider;
        if (artifactProvider != null) {
            Version version = Version.parse(((Properties) artifactProvider.getArtifact("manifest.properties")).getProperty("OpenNLP-Version"));
            if (version.getMajor() == 1 && version.getMinor() < 8) {
                return new DefaultPOSContextGenerator(i, getDictionary());
            }
        }
        return new ConfigurablePOSContextGenerator(i, createFeatureGenerators());
    }

    public void init(byte[] bArr, Map<String, Object> map, TagDictionary tagDictionary) {
        this.featureGeneratorBytes = bArr;
        this.resources = map;
        this.posDictionary = tagDictionary;
    }

    @Deprecated(forRemoval = true)
    public POSTaggerFactory(Dictionary dictionary, TagDictionary tagDictionary) {
        init(dictionary, tagDictionary);
    }

    public static POSTaggerFactory create(String str, byte[] bArr, Map<String, Object> map, TagDictionary tagDictionary) throws InvalidFormatException {
        POSTaggerFactory pOSTaggerFactory;
        if (str == null) {
            pOSTaggerFactory = new POSTaggerFactory();
            pOSTaggerFactory.init(bArr, map, tagDictionary);
        } else {
            try {
                pOSTaggerFactory = (POSTaggerFactory) ExtensionLoader.instantiateExtension(POSTaggerFactory.class, str);
            } catch (Exception e) {
                throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization throw an exception."), e);
            }
        }
        pOSTaggerFactory.init(bArr, map, tagDictionary);
        return pOSTaggerFactory;
    }
}
