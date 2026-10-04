package opennlp.tools.util.featuregen;

import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FeatureGeneratorUtil {
    private static final Pattern capPeriod = Pattern.compile("^[A-ZÄÖÜ]\\.$");

    public static String tokenFeature(String str) {
        StringPattern stringPatternRecognize = StringPattern.recognize(str);
        return stringPatternRecognize.isAllHiragana() ? "jah" : stringPatternRecognize.isAllKatakana() ? "jak" : stringPatternRecognize.isAllLowerCaseLetter() ? NetworkConfig.CLIENTS_LANGUAGE : stringPatternRecognize.digits() == 2 ? "2d" : stringPatternRecognize.digits() == 4 ? "4d" : stringPatternRecognize.containsDigit() ? stringPatternRecognize.containsLetters() ? "an" : stringPatternRecognize.containsHyphen() ? "dd" : stringPatternRecognize.containsSlash() ? "ds" : stringPatternRecognize.containsComma() ? "dc" : stringPatternRecognize.containsPeriod() ? JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT : "num" : stringPatternRecognize.isAllCapitalLetter() ? str.length() == 1 ? "sc" : "ac" : capPeriod.matcher(str).find() ? "cp" : stringPatternRecognize.isInitialCapitalLetter() ? "ic" : "other";
    }
}
