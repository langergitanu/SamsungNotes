package opennlp.tools.stemmer.snowball;

import opennlp.tools.stemmer.Stemmer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SnowballStemmer implements Stemmer {
    private final int repeat;
    private final AbstractSnowballStemmer stemmer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ALGORITHM {
        ARABIC,
        DANISH,
        DUTCH,
        CATALAN,
        ENGLISH,
        FINNISH,
        FRENCH,
        GERMAN,
        GREEK,
        HUNGARIAN,
        INDONESIAN,
        IRISH,
        ITALIAN,
        NORWEGIAN,
        PORTER,
        PORTUGUESE,
        ROMANIAN,
        RUSSIAN,
        SPANISH,
        SWEDISH,
        TURKISH
    }

    public SnowballStemmer(ALGORITHM algorithm, int i) {
        this.repeat = i;
        if (ALGORITHM.ARABIC.equals(algorithm)) {
            this.stemmer = new arabicStemmer();
            return;
        }
        if (ALGORITHM.DANISH.equals(algorithm)) {
            this.stemmer = new danishStemmer();
            return;
        }
        if (ALGORITHM.DUTCH.equals(algorithm)) {
            this.stemmer = new dutchStemmer();
            return;
        }
        if (ALGORITHM.CATALAN.equals(algorithm)) {
            this.stemmer = new catalanStemmer();
            return;
        }
        if (ALGORITHM.ENGLISH.equals(algorithm)) {
            this.stemmer = new englishStemmer();
            return;
        }
        if (ALGORITHM.FINNISH.equals(algorithm)) {
            this.stemmer = new finnishStemmer();
            return;
        }
        if (ALGORITHM.FRENCH.equals(algorithm)) {
            this.stemmer = new frenchStemmer();
            return;
        }
        if (ALGORITHM.GERMAN.equals(algorithm)) {
            this.stemmer = new germanStemmer();
            return;
        }
        if (ALGORITHM.GREEK.equals(algorithm)) {
            this.stemmer = new greekStemmer();
            return;
        }
        if (ALGORITHM.HUNGARIAN.equals(algorithm)) {
            this.stemmer = new hungarianStemmer();
            return;
        }
        if (ALGORITHM.INDONESIAN.equals(algorithm)) {
            this.stemmer = new indonesianStemmer();
            return;
        }
        if (ALGORITHM.IRISH.equals(algorithm)) {
            this.stemmer = new irishStemmer();
            return;
        }
        if (ALGORITHM.ITALIAN.equals(algorithm)) {
            this.stemmer = new italianStemmer();
            return;
        }
        if (ALGORITHM.NORWEGIAN.equals(algorithm)) {
            this.stemmer = new norwegianStemmer();
            return;
        }
        if (ALGORITHM.PORTER.equals(algorithm)) {
            this.stemmer = new porterStemmer();
            return;
        }
        if (ALGORITHM.PORTUGUESE.equals(algorithm)) {
            this.stemmer = new portugueseStemmer();
            return;
        }
        if (ALGORITHM.ROMANIAN.equals(algorithm)) {
            this.stemmer = new romanianStemmer();
            return;
        }
        if (ALGORITHM.RUSSIAN.equals(algorithm)) {
            this.stemmer = new russianStemmer();
            return;
        }
        if (ALGORITHM.SPANISH.equals(algorithm)) {
            this.stemmer = new spanishStemmer();
            return;
        }
        if (ALGORITHM.SWEDISH.equals(algorithm)) {
            this.stemmer = new swedishStemmer();
        } else if (ALGORITHM.TURKISH.equals(algorithm)) {
            this.stemmer = new turkishStemmer();
        } else {
            throw new IllegalStateException("Unexpected stemmer algorithm: " + algorithm);
        }
    }

    @Override // opennlp.tools.stemmer.Stemmer
    public CharSequence stem(CharSequence charSequence) {
        this.stemmer.setCurrent(charSequence.toString());
        for (int i = 0; i < this.repeat; i++) {
            this.stemmer.stem();
        }
        return this.stemmer.getCurrent();
    }

    public SnowballStemmer(ALGORITHM algorithm) {
        this(algorithm, 1);
    }
}
