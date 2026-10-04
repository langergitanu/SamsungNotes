package opennlp.tools.langdetect;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorConfig {
    public static final int DEFAULT_CHUNK_SIZE = 200;
    public static final LanguageDetectorConfig DEFAULT_LANGUAGE_DETECTOR_CONFIG = new ImmutableLanguageDetectorConfig(0);
    public static final int DEFAULT_MAX_LENGTH = 10000;
    public static final int DEFAULT_MIN_CONSEC_IMPROVEMENTS = 2;
    public static final double DEFAULT_MIN_DIFF = 0.2d;
    private int maxLength = 10000;
    private int chunkSize = 200;
    private int minConsecImprovements = 2;
    private double minDiff = 0.2d;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImmutableLanguageDetectorConfig extends LanguageDetectorConfig {
        public /* synthetic */ ImmutableLanguageDetectorConfig(int i) {
            this();
        }

        private ImmutableLanguageDetectorConfig() {
        }

        @Override // opennlp.tools.langdetect.LanguageDetectorConfig
        public void setChunkSize(int i) {
        }

        @Override // opennlp.tools.langdetect.LanguageDetectorConfig
        public void setMaxLength(int i) {
        }

        @Override // opennlp.tools.langdetect.LanguageDetectorConfig
        public void setMinConsecImprovements(int i) {
        }

        @Override // opennlp.tools.langdetect.LanguageDetectorConfig
        public void setMinDiff(double d) {
        }
    }

    public int getChunkSize() {
        return this.chunkSize;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public int getMinConsecImprovements() {
        return this.minConsecImprovements;
    }

    public double getMinDiff() {
        return this.minDiff;
    }

    public void setChunkSize(int i) {
        this.chunkSize = i;
    }

    public void setMaxLength(int i) {
        this.maxLength = i;
    }

    public void setMinConsecImprovements(int i) {
        this.minConsecImprovements = i;
    }

    public void setMinDiff(double d) {
        this.minDiff = d;
    }
}
