package opennlp.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.BaseModel;
import opennlp.tools.util.model.ChunkerModelSerializer;
import opennlp.tools.util.model.POSModelSerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserModel extends BaseModel {
    private static final String ATTACH_MODEL_ENTRY_NAME = "attach.model";
    private static final String BUILD_MODEL_ENTRY_NAME = "build.model";
    private static final String CHECK_MODEL_ENTRY_NAME = "check.model";
    private static final String CHUNKER_TAGGER_MODEL_ENTRY_NAME = "parserchunker.chunker";
    private static final String COMPONENT_NAME = "Parser";
    private static final String HEAD_RULES_MODEL_ENTRY_NAME = "head-rules.headrules";
    private static final String PARSER_TAGGER_MODEL_ENTRY_NAME = "parsertager.postagger";
    private static final String PARSER_TYPE = "parser-type";
    private static final long serialVersionUID = 8130378166122870498L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeadRulesSerializer implements ArtifactSerializer<opennlp.tools.parser.lang.p219en.HeadRules> {
        public /* synthetic */ HeadRulesSerializer(int i) {
            this();
        }

        private HeadRulesSerializer() {
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public opennlp.tools.parser.lang.p219en.HeadRules create(InputStream inputStream) {
            return new opennlp.tools.parser.lang.p219en.HeadRules(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public void serialize(opennlp.tools.parser.lang.p219en.HeadRules headRules, OutputStream outputStream) throws IOException {
            headRules.serialize(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        }
    }

    public ParserModel(String str, MaxentModel maxentModel, MaxentModel maxentModel2, MaxentModel maxentModel3, POSModel pOSModel, ChunkerModel chunkerModel, HeadRules headRules, ParserType parserType, Map<String, String> map) {
        super(COMPONENT_NAME, str, map);
        setManifestProperty(PARSER_TYPE, parserType.name());
        this.artifactMap.put(BUILD_MODEL_ENTRY_NAME, maxentModel);
        this.artifactMap.put(CHECK_MODEL_ENTRY_NAME, maxentModel2);
        if (ParserType.CHUNKING.equals(parserType)) {
            if (maxentModel3 != null) {
                throw new IllegalArgumentException("attachModel must be null for chunking parser!");
            }
        } else {
            if (!ParserType.TREEINSERT.equals(parserType)) {
                throw new IllegalStateException("Unknown ParserType '" + parserType + "'!");
            }
            Objects.requireNonNull(maxentModel3, "attachModel must not be null");
            this.artifactMap.put(ATTACH_MODEL_ENTRY_NAME, maxentModel3);
        }
        this.artifactMap.put(PARSER_TAGGER_MODEL_ENTRY_NAME, pOSModel);
        this.artifactMap.put(CHUNKER_TAGGER_MODEL_ENTRY_NAME, chunkerModel);
        this.artifactMap.put(HEAD_RULES_MODEL_ENTRY_NAME, headRules);
        checkArtifactMap();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void createArtifactSerializers(Map<String, ArtifactSerializer<?>> map) {
        super.createArtifactSerializers(map);
        if (getVersion().getMajor() == 1 && getVersion().getMinor() == 5) {
            map.put("headrules", new HeadRulesSerializer(0));
        }
        map.put("postagger", new POSModelSerializer());
        map.put("chunker", new ChunkerModelSerializer());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ParserModel) {
            Map<String, Object> map = ((ParserModel) obj).artifactMap;
            AbstractModel abstractModel = (AbstractModel) map.get(BUILD_MODEL_ENTRY_NAME);
            if (this.artifactMap.get("manifest.properties").equals(map.get("manifest.properties")) && this.artifactMap.get(BUILD_MODEL_ENTRY_NAME).equals(abstractModel)) {
                return true;
            }
        }
        return false;
    }

    public MaxentModel getAttachModel() {
        return (MaxentModel) this.artifactMap.get(ATTACH_MODEL_ENTRY_NAME);
    }

    public MaxentModel getBuildModel() {
        return (MaxentModel) this.artifactMap.get(BUILD_MODEL_ENTRY_NAME);
    }

    public MaxentModel getCheckModel() {
        return (MaxentModel) this.artifactMap.get(CHECK_MODEL_ENTRY_NAME);
    }

    public HeadRules getHeadRules() {
        return (HeadRules) this.artifactMap.get(HEAD_RULES_MODEL_ENTRY_NAME);
    }

    public ChunkerModel getParserChunkerModel() {
        return (ChunkerModel) this.artifactMap.get(CHUNKER_TAGGER_MODEL_ENTRY_NAME);
    }

    public POSModel getParserTaggerModel() {
        return (POSModel) this.artifactMap.get(PARSER_TAGGER_MODEL_ENTRY_NAME);
    }

    public ParserType getParserType() {
        return ParserType.parse(getManifestProperty(PARSER_TYPE));
    }

    public int hashCode() {
        return Objects.hash(this.artifactMap.get("manifest.properties"), this.artifactMap.get(PARSER_TAGGER_MODEL_ENTRY_NAME));
    }

    public ParserModel updateBuildModel(MaxentModel maxentModel) {
        return new ParserModel(getLanguage(), maxentModel, getCheckModel(), getAttachModel(), getParserTaggerModel(), getParserChunkerModel(), getHeadRules(), getParserType());
    }

    public ParserModel updateCheckModel(MaxentModel maxentModel) {
        return new ParserModel(getLanguage(), getBuildModel(), maxentModel, getAttachModel(), getParserTaggerModel(), getParserChunkerModel(), getHeadRules(), getParserType());
    }

    public ParserModel updateChunkerModel(ChunkerModel chunkerModel) {
        return new ParserModel(getLanguage(), getBuildModel(), getCheckModel(), getAttachModel(), getParserTaggerModel(), chunkerModel, getHeadRules(), getParserType());
    }

    public ParserModel updateTaggerModel(POSModel pOSModel) {
        return new ParserModel(getLanguage(), getBuildModel(), getCheckModel(), getAttachModel(), pOSModel, getParserChunkerModel(), getHeadRules(), getParserType());
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(BUILD_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
            throw new InvalidFormatException("Missing the build model!");
        }
        ParserType parserType = getParserType();
        if (parserType == null) {
            throw new InvalidFormatException("Missing the parser type property!");
        }
        if (ParserType.CHUNKING.equals(parserType)) {
            if (this.artifactMap.get(ATTACH_MODEL_ENTRY_NAME) != null) {
                throw new InvalidFormatException("attachModel must be null for chunking parser!");
            }
        } else {
            if (!ParserType.TREEINSERT.equals(parserType)) {
                throw new InvalidFormatException("Unknown ParserType '" + parserType + "'!");
            }
            if (!(this.artifactMap.get(ATTACH_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
                throw new InvalidFormatException("attachModel must not be null!");
            }
        }
        if (!(this.artifactMap.get(CHECK_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
            throw new InvalidFormatException("Missing the check model!");
        }
        if (!(this.artifactMap.get(PARSER_TAGGER_MODEL_ENTRY_NAME) instanceof POSModel)) {
            throw new InvalidFormatException("Missing the tagger model!");
        }
        if (!(this.artifactMap.get(CHUNKER_TAGGER_MODEL_ENTRY_NAME) instanceof ChunkerModel)) {
            throw new InvalidFormatException("Missing the chunker model!");
        }
        if (!(this.artifactMap.get(HEAD_RULES_MODEL_ENTRY_NAME) instanceof HeadRules)) {
            throw new InvalidFormatException("Missing the head rules!");
        }
    }

    public ParserModel(String str, MaxentModel maxentModel, MaxentModel maxentModel2, MaxentModel maxentModel3, POSModel pOSModel, ChunkerModel chunkerModel, HeadRules headRules, ParserType parserType) {
        this(str, maxentModel, maxentModel2, maxentModel3, pOSModel, chunkerModel, headRules, parserType, null);
    }

    public ParserModel(String str, MaxentModel maxentModel, MaxentModel maxentModel2, POSModel pOSModel, ChunkerModel chunkerModel, HeadRules headRules, ParserType parserType, Map<String, String> map) {
        this(str, maxentModel, maxentModel2, null, pOSModel, chunkerModel, headRules, parserType, map);
    }

    public ParserModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public ParserModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public ParserModel(Path path) {
        this(path.toFile());
    }

    public ParserModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
