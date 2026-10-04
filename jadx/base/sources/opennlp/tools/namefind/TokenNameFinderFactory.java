package opennlp.tools.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;
import opennlp.tools.util.featuregen.BigramNameFeatureGenerator;
import opennlp.tools.util.featuregen.CachedFeatureGenerator;
import opennlp.tools.util.featuregen.GeneratorFactory;
import opennlp.tools.util.featuregen.OutcomePriorFeatureGenerator;
import opennlp.tools.util.featuregen.PreviousMapFeatureGenerator;
import opennlp.tools.util.featuregen.SentenceFeatureGenerator;
import opennlp.tools.util.featuregen.TokenClassFeatureGenerator;
import opennlp.tools.util.featuregen.TokenFeatureGenerator;
import opennlp.tools.util.featuregen.WindowFeatureGenerator;
import opennlp.tools.util.model.ArtifactProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenNameFinderFactory extends BaseToolFactory {
    private byte[] featureGeneratorBytes;
    private Map<String, Object> resources;
    private SequenceCodec<String> seqCodec;

    public TokenNameFinderFactory() {
        this.seqCodec = new BioCodec();
    }

    public static TokenNameFinderFactory create(String str, byte[] bArr, Map<String, Object> map, SequenceCodec<String> sequenceCodec) throws InvalidFormatException {
        TokenNameFinderFactory tokenNameFinderFactory;
        if (str == null) {
            tokenNameFinderFactory = new TokenNameFinderFactory();
        } else {
            try {
                tokenNameFinderFactory = (TokenNameFinderFactory) ExtensionLoader.instantiateExtension(TokenNameFinderFactory.class, str);
            } catch (Exception e) {
                throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
            }
        }
        tokenNameFinderFactory.init(bArr, map, sequenceCodec);
        return tokenNameFinderFactory;
    }

    public static SequenceCodec<String> instantiateSequenceCodec(String str) throws InvalidFormatException {
        if (str == null) {
            return new BioCodec();
        }
        try {
            return (SequenceCodec) ExtensionLoader.instantiateExtension(SequenceCodec.class, str);
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$createFeatureGenerators$0(String str) {
        ArtifactProvider artifactProvider = this.artifactProvider;
        return artifactProvider != null ? artifactProvider.getArtifact(str) : this.resources.get(str);
    }

    private static byte[] loadDefaultFeatureGeneratorBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream resourceAsStream = TokenNameFinderFactory.class.getResourceAsStream("/opennlp/tools/namefind/ner-default-features.xml");
        if (resourceAsStream == null) {
            throw new IllegalStateException("Classpath must contain 'ner-default-features.xml' file!");
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
            throw new IllegalStateException("Failed reading from 'ner-default-features.xml' file on classpath!");
        }
    }

    public NameContextGenerator createContextGenerator() {
        AdaptiveFeatureGenerator adaptiveFeatureGeneratorCreateFeatureGenerators = createFeatureGenerators();
        if (adaptiveFeatureGeneratorCreateFeatureGenerators == null) {
            adaptiveFeatureGeneratorCreateFeatureGenerators = new CachedFeatureGenerator(new WindowFeatureGenerator(new TokenFeatureGenerator(), 2, 2), new WindowFeatureGenerator(new TokenClassFeatureGenerator(true), 2, 2), new OutcomePriorFeatureGenerator(), new PreviousMapFeatureGenerator(), new BigramNameFeatureGenerator(), new SentenceFeatureGenerator(true, false));
        }
        return new DefaultNameContextGenerator(adaptiveFeatureGeneratorCreateFeatureGenerators);
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
                AdaptiveFeatureGenerator adaptiveFeatureGeneratorCreate = GeneratorFactory.create(byteArrayInputStream, new C11253j(this, 18));
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
            throw new TokenNameFinderModel.FeatureGeneratorCreationError(e);
        } catch (IOException e2) {
            throw new IllegalStateException("Reading from mem cannot result in an I/O error", e2);
        }
    }

    public SequenceCodec<String> createSequenceCodec() {
        ArtifactProvider artifactProvider = this.artifactProvider;
        if (artifactProvider == null) {
            return this.seqCodec;
        }
        try {
            return instantiateSequenceCodec(artifactProvider.getManifestProperty("sequenceCodecImplName"));
        } catch (InvalidFormatException unused) {
            return this.seqCodec;
        }
    }

    public byte[] getFeatureGenerator() {
        return this.featureGeneratorBytes;
    }

    public Map<String, Object> getResources() {
        return this.resources;
    }

    public SequenceCodec<String> getSequenceCodec() {
        return this.seqCodec;
    }

    public void init(byte[] bArr, Map<String, Object> map, SequenceCodec<String> sequenceCodec) {
        this.featureGeneratorBytes = bArr;
        this.resources = map;
        this.seqCodec = sequenceCodec;
    }

    public TokenNameFinderFactory(byte[] bArr, Map<String, Object> map, SequenceCodec<String> sequenceCodec) {
        init(bArr, map, sequenceCodec);
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() {
    }
}
