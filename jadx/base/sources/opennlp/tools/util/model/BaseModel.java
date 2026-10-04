package opennlp.tools.util.model;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Version;
import opennlp.tools.util.ext.ExtensionLoader;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseModel implements ArtifactProvider, Serializable {
    private static final String COMPONENT_NAME_PROPERTY = "Component-Name";
    protected static final String FACTORY_NAME = "factory";
    private static final String LANGUAGE_PROPERTY = "Language";
    protected static final String MANIFEST_ENTRY = "manifest.properties";
    private static final String MANIFEST_VERSION_PROPERTY = "Manifest-Version";
    private static final String SERIALIZER_CLASS_NAME_PREFIX = "serializer-class-";
    private static final String TIMESTAMP_PROPERTY = "Timestamp";
    public static final String TRAINING_CUTOFF_PROPERTY = "Training-Cutoff";
    public static final String TRAINING_EVENTHASH_PROPERTY = "Training-Eventhash";
    public static final String TRAINING_ITERATIONS_PROPERTY = "Training-Iterations";
    private static final String VERSION_PROPERTY = "OpenNLP-Version";
    private static final long serialVersionUID = -4593612444791752264L;
    protected Map<String, Object> artifactMap;
    private Map<String, ArtifactSerializer<?>> artifactSerializers;
    private String componentName;
    private boolean finishedLoadingArtifacts;
    private boolean isLoadedFromSerialized;
    private boolean subclassSerializersInitiated;
    protected BaseToolFactory toolFactory;

    private BaseModel(String str, boolean z) {
        this.artifactSerializers = new HashMap();
        this.artifactMap = new HashMap();
        this.subclassSerializersInitiated = false;
        this.finishedLoadingArtifacts = false;
        this.isLoadedFromSerialized = z;
        Objects.requireNonNull(str, "componentName must not be null!");
        this.componentName = str;
    }

    public static Map<String, ArtifactSerializer<?>> createArtifactSerializers() {
        HashMap map = new HashMap();
        GenericModelSerializer.register(map);
        PropertiesSerializer.register(map);
        DictionarySerializer.register(map);
        map.put(Constants.TEXT_EXTENSION, new ByteArraySerializer());
        map.put("html", new ByteArraySerializer());
        return map;
    }

    private void createBaseArtifactSerializers(Map<String, ArtifactSerializer<?>> map) {
        map.putAll(createArtifactSerializers());
    }

    private void finishLoadingArtifacts(InputStream inputStream) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        try {
            HashMap map = new HashMap();
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    this.artifactMap.putAll(map);
                    this.finishedLoadingArtifacts = true;
                    zipInputStream.close();
                    return;
                }
                String name = nextEntry.getName();
                String entryExtension = getEntryExtension(name);
                ArtifactSerializer<?> artifactSerializer = this.artifactSerializers.get(entryExtension);
                String manifestProperty = getManifestProperty(SERIALIZER_CLASS_NAME_PREFIX + name);
                if (manifestProperty != null) {
                    artifactSerializer = (ArtifactSerializer) ExtensionLoader.instantiateExtension(ArtifactSerializer.class, manifestProperty);
                }
                if (artifactSerializer == null) {
                    throw new InvalidFormatException("Unknown artifact format: " + entryExtension);
                }
                map.put(name, artifactSerializer.create(zipInputStream));
                zipInputStream.closeEntry();
            }
        } catch (Throwable th) {
            try {
                zipInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private String getEntryExtension(String str) throws InvalidFormatException {
        int iLastIndexOf = str.lastIndexOf(46) + 1;
        if (iLastIndexOf < str.length()) {
            return str.substring(iLastIndexOf);
        }
        throw new InvalidFormatException("Entry name must have type extension: ".concat(str));
    }

    private void initializeFactory() {
        String manifestProperty = getManifestProperty(FACTORY_NAME);
        if (manifestProperty != null) {
            try {
                this.toolFactory = BaseToolFactory.create(manifestProperty, this);
            } catch (InvalidFormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            Class<? extends BaseToolFactory> defaultFactory = getDefaultFactory();
            if (defaultFactory != null) {
                this.toolFactory = BaseToolFactory.create(defaultFactory, this);
            }
        }
    }

    private void loadArtifactSerializers() {
        if (!this.subclassSerializersInitiated) {
            createArtifactSerializers(this.artifactSerializers);
        }
        this.subclassSerializersInitiated = true;
    }

    private void loadModel(InputStream inputStream) throws IOException {
        Objects.requireNonNull(inputStream, "in must not be null");
        createBaseArtifactSerializers(this.artifactSerializers);
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        inputStream.mark(Integer.MAX_VALUE);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        boolean z = true;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null || !z) {
                break;
            }
            if (MANIFEST_ENTRY.equals(nextEntry.getName())) {
                this.artifactMap.put(nextEntry.getName(), this.artifactSerializers.get(StringLookupFactory.KEY_PROPERTIES).create(zipInputStream));
                z = false;
            }
            zipInputStream.closeEntry();
        }
        initializeFactory();
        loadArtifactSerializers();
        inputStream.reset();
        finishLoadingArtifacts(inputStream);
        checkArtifactMap();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.isLoadedFromSerialized = true;
        this.artifactSerializers = new HashMap();
        this.artifactMap = new HashMap();
        this.componentName = objectInputStream.readUTF();
        loadModel(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.componentName);
        serialize(objectOutputStream);
    }

    public void checkArtifactMap() {
        if (!this.finishedLoadingArtifacts) {
            throw new IllegalStateException("The method BaseModel.finishLoadingArtifacts(..) was not called by BaseModel subclass.");
        }
        try {
            validateArtifactMap();
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // opennlp.tools.util.model.ArtifactProvider
    public <T> T getArtifact(String str) {
        T t = (T) this.artifactMap.get(str);
        if (t == null) {
            return null;
        }
        return t;
    }

    public ArtifactSerializer<?> getArtifactSerializer(String str) {
        try {
            return this.artifactSerializers.get(getEntryExtension(str));
        } catch (InvalidFormatException e) {
            throw new IllegalStateException(e);
        }
    }

    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return null;
    }

    @Override // opennlp.tools.util.model.ArtifactProvider
    public final String getLanguage() {
        return getManifestProperty(LANGUAGE_PROPERTY);
    }

    @Override // opennlp.tools.util.model.ArtifactProvider
    public final String getManifestProperty(String str) {
        return ((Properties) this.artifactMap.get(MANIFEST_ENTRY)).getProperty(str);
    }

    public final Version getVersion() {
        return Version.parse(getManifestProperty(VERSION_PROPERTY));
    }

    @Override // opennlp.tools.util.model.ArtifactProvider
    public boolean isLoadedFromSerialized() {
        return this.isLoadedFromSerialized;
    }

    public final void serialize(OutputStream outputStream) throws IOException {
        if (!this.subclassSerializersInitiated) {
            throw new IllegalStateException("The method BaseModel.loadArtifactSerializers() was not called by BaseModel subclass constructor.");
        }
        for (Map.Entry<String, Object> entry : this.artifactMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof SerializableArtifact) {
                setManifestProperty(SERIALIZER_CLASS_NAME_PREFIX + key, ((SerializableArtifact) value).getArtifactSerializerClass().getName());
            }
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        for (Map.Entry<String, Object> entry2 : this.artifactMap.entrySet()) {
            String key2 = entry2.getKey();
            zipOutputStream.putNextEntry(new ZipEntry(key2));
            Object value2 = entry2.getValue();
            if (!skipEntryForSerialization(entry2)) {
                ArtifactSerializer<?> artifactSerializer = getArtifactSerializer(key2);
                if (value2 instanceof SerializableArtifact) {
                    artifactSerializer = (ArtifactSerializer) ExtensionLoader.instantiateExtension(ArtifactSerializer.class, ((SerializableArtifact) value2).getArtifactSerializerClass().getName());
                }
                if (artifactSerializer == null) {
                    throw new IllegalStateException(AbstractC0541b.m772n("Missing serializer for ", key2));
                }
                artifactSerializer.serialize(this.artifactMap.get(key2), zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
        zipOutputStream.finish();
        zipOutputStream.flush();
    }

    public final void setManifestProperty(String str, String str2) {
        ((Properties) this.artifactMap.get(MANIFEST_ENTRY)).setProperty(str, str2);
    }

    public boolean skipEntryForSerialization(Map.Entry<String, Object> entry) {
        return false;
    }

    public void validateArtifactMap() throws InvalidFormatException {
        if (!(this.artifactMap.get(MANIFEST_ENTRY) instanceof Properties)) {
            throw new InvalidFormatException("Missing the manifest.properties!");
        }
        String manifestProperty = getManifestProperty(VERSION_PROPERTY);
        if (manifestProperty == null) {
            throw new InvalidFormatException("Missing OpenNLP-Version property in manifest.properties!");
        }
        try {
            Version version = Version.parse(manifestProperty);
            if (!Version.currentVersion().equals(Version.DEV_VERSION)) {
                if (version.getMajor() != 1 && version.getMajor() != 2) {
                    throw new InvalidFormatException("Model version " + version + " is not supported by this (" + Version.currentVersion() + ") version of OpenNLP!");
                }
                if (!Version.currentVersion().isSnapshot() && version.isSnapshot()) {
                    throw new InvalidFormatException("Model version " + version + " is a snapshot - snapshot models are not supported by this non-snapshot version (" + Version.currentVersion() + ") of OpenNLP!");
                }
            }
            if (getManifestProperty(COMPONENT_NAME_PROPERTY) == null) {
                throw new InvalidFormatException("Missing Component-Name property in manifest.properties!");
            }
            if (!getManifestProperty(COMPONENT_NAME_PROPERTY).equals(this.componentName)) {
                throw new InvalidFormatException(AbstractC0541b.m775q("The ", this.componentName, " cannot load a model for the ", getManifestProperty(COMPONENT_NAME_PROPERTY), "!"));
            }
            if (getManifestProperty(LANGUAGE_PROPERTY) == null) {
                throw new InvalidFormatException("Missing Language property in manifest.properties!");
            }
            String manifestProperty2 = getManifestProperty(FACTORY_NAME);
            if (manifestProperty2 != null) {
                try {
                    if (ExtensionLoader.instantiateExtension(BaseToolFactory.class, manifestProperty2) == null) {
                        throw new InvalidFormatException("Could not load an user extension specified by the model: ".concat(manifestProperty2));
                    }
                } catch (Exception e) {
                    throw new InvalidFormatException("Could not load an user extension specified by the model: ".concat(manifestProperty2), e);
                }
            }
            BaseToolFactory baseToolFactory = this.toolFactory;
            if (baseToolFactory != null) {
                baseToolFactory.validateArtifactMap();
            }
        } catch (NumberFormatException e2) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Unable to parse model version '", manifestProperty, "'!"), e2);
        }
    }

    public void createArtifactSerializers(Map<String, ArtifactSerializer<?>> map) {
        BaseToolFactory baseToolFactory = this.toolFactory;
        if (baseToolFactory != null) {
            map.putAll(baseToolFactory.createArtifactSerializersMap());
        }
    }

    public BaseModel(String str, String str2, Map<String, String> map, BaseToolFactory baseToolFactory) {
        this(str, false);
        Objects.requireNonNull(str2, "languageCode must not be null");
        createBaseArtifactSerializers(this.artifactSerializers);
        Properties properties = new Properties();
        properties.setProperty(MANIFEST_VERSION_PROPERTY, "1.0");
        properties.setProperty(LANGUAGE_PROPERTY, str2);
        properties.setProperty(VERSION_PROPERTY, Version.currentVersion().toString());
        properties.setProperty("Timestamp", Long.toString(System.currentTimeMillis()));
        properties.setProperty(COMPONENT_NAME_PROPERTY, str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
        }
        this.artifactMap.put(MANIFEST_ENTRY, properties);
        this.finishedLoadingArtifacts = true;
        if (baseToolFactory != null) {
            setManifestProperty(FACTORY_NAME, baseToolFactory.getClass().getCanonicalName());
            this.artifactMap.putAll(baseToolFactory.createArtifactMap());
            for (Map.Entry<String, String> entry2 : baseToolFactory.createManifestEntries().entrySet()) {
                setManifestProperty(entry2.getKey(), entry2.getValue());
            }
        }
        try {
            initializeFactory();
            loadArtifactSerializers();
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException("Could not initialize tool factory. ", e);
        }
    }

    public BaseModel(String str, String str2, Map<String, String> map) {
        this(str, str2, map, null);
    }

    public BaseModel(String str, InputStream inputStream) throws IOException {
        this(str, true);
        loadModel(inputStream);
    }

    public final void serialize(File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            serialize(bufferedOutputStream);
            bufferedOutputStream.close();
        } catch (Throwable th) {
            try {
                bufferedOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public BaseModel(String str, File file) throws IOException {
        this(str, true);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            loadModel(bufferedInputStream);
            bufferedInputStream.close();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void serialize(Path path) throws IOException {
        serialize(path.toFile());
    }

    public BaseModel(String str, Path path) throws IOException {
        this(str, true);
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            loadModel(inputStreamNewInputStream);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
        } catch (Throwable th) {
            if (inputStreamNewInputStream != null) {
                try {
                    inputStreamNewInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public BaseModel(String str, URL url) throws IOException {
        this(str, true);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
        try {
            loadModel(bufferedInputStream);
            bufferedInputStream.close();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
