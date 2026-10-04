package opennlp.tools.namefind;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RegexNameFinderFactory {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class DEFAULT_REGEX_NAME_FINDER implements RegexAble {
        public static final DEFAULT_REGEX_NAME_FINDER USA_PHONE_NUM = new C136371();
        public static final DEFAULT_REGEX_NAME_FINDER EMAIL = new C136382();
        public static final DEFAULT_REGEX_NAME_FINDER URL = new C136393();
        public static final DEFAULT_REGEX_NAME_FINDER MGRS = new C136404();
        public static final DEFAULT_REGEX_NAME_FINDER DEGREES_MIN_SEC_LAT_LON = new C136415();
        private static final /* synthetic */ DEFAULT_REGEX_NAME_FINDER[] $VALUES = $values();

        /* JADX INFO: renamed from: opennlp.tools.namefind.RegexNameFinderFactory$DEFAULT_REGEX_NAME_FINDER$1 */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum C136371 extends DEFAULT_REGEX_NAME_FINDER {
            public /* synthetic */ C136371() {
                this("USA_PHONE_NUM", 0);
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public Map<String, Pattern[]> getRegexMap() {
                Pattern[] patternArr = {Pattern.compile("((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}")};
                HashMap map = new HashMap();
                map.put(getType(), patternArr);
                return map;
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public String getType() {
                return "PHONE_NUM";
            }

            private C136371(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: opennlp.tools.namefind.RegexNameFinderFactory$DEFAULT_REGEX_NAME_FINDER$2 */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum C136382 extends DEFAULT_REGEX_NAME_FINDER {
            public /* synthetic */ C136382() {
                this("EMAIL", 1);
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public Map<String, Pattern[]> getRegexMap() {
                Pattern[] patternArr = {Pattern.compile("([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]([a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", 2)};
                HashMap map = new HashMap();
                map.put(getType(), patternArr);
                return map;
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public String getType() {
                return "EMAIL";
            }

            private C136382(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: opennlp.tools.namefind.RegexNameFinderFactory$DEFAULT_REGEX_NAME_FINDER$3 */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum C136393 extends DEFAULT_REGEX_NAME_FINDER {
            public /* synthetic */ C136393() {
                this(TextConst.ENTITY_TYPE_URL, 2);
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public Map<String, Pattern[]> getRegexMap() {
                Pattern[] patternArr = {Pattern.compile("\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov|mil|biz|info|mobi|name|aero|jobs|museum|travel|[a-z]{2}))(:[\\d]{1,5})?(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b", 2)};
                HashMap map = new HashMap();
                map.put(getType(), patternArr);
                return map;
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public String getType() {
                return TextConst.ENTITY_TYPE_URL;
            }

            private C136393(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: opennlp.tools.namefind.RegexNameFinderFactory$DEFAULT_REGEX_NAME_FINDER$4 */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum C136404 extends DEFAULT_REGEX_NAME_FINDER {
            public /* synthetic */ C136404() {
                this("MGRS", 3);
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public Map<String, Pattern[]> getRegexMap() {
                Pattern[] patternArr = {Pattern.compile("\\d{1,2}[A-Za-z]\\s*[A-Za-z]{2}\\s*\\d{1,5}\\s*\\d{1,5}", 2)};
                HashMap map = new HashMap();
                map.put(getType(), patternArr);
                return map;
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public String getType() {
                return "MGRS";
            }

            private C136404(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: opennlp.tools.namefind.RegexNameFinderFactory$DEFAULT_REGEX_NAME_FINDER$5 */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum C136415 extends DEFAULT_REGEX_NAME_FINDER {
            public /* synthetic */ C136415() {
                this("DEGREES_MIN_SEC_LAT_LON", 4);
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public Map<String, Pattern[]> getRegexMap() {
                Pattern[] patternArr = {Pattern.compile("([-|\\+]?\\d{1,3}[d|D|\\u00B0|\\s](\\s*\\d{1,2}['|\\u2019|\\s])?(\\s*\\d{1,2}[\\\"|\\u201d])?\\s*[N|n|S|s]?)(\\s*|,|,\\s*)([-|\\+]?\\d{1,3}[d|D|\\u00B0|\\s](\\s*\\d{1,2}['|\\u2019|\\s])?(\\s*\\d{1,2}[\\\"|\\u201d])?\\s*[E|e|W|w]?)", 2)};
                HashMap map = new HashMap();
                map.put(getType(), patternArr);
                return map;
            }

            @Override // opennlp.tools.namefind.RegexNameFinderFactory.RegexAble
            public String getType() {
                return "DEGREES_MIN_SEC_LAT_LON";
            }

            private C136415(String str, int i) {
                super(str, i, 0);
            }
        }

        private static /* synthetic */ DEFAULT_REGEX_NAME_FINDER[] $values() {
            return new DEFAULT_REGEX_NAME_FINDER[]{USA_PHONE_NUM, EMAIL, URL, MGRS, DEGREES_MIN_SEC_LAT_LON};
        }

        public /* synthetic */ DEFAULT_REGEX_NAME_FINDER(String str, int i, int i2) {
            this(str, i);
        }

        public static DEFAULT_REGEX_NAME_FINDER valueOf(String str) {
            return (DEFAULT_REGEX_NAME_FINDER) Enum.valueOf(DEFAULT_REGEX_NAME_FINDER.class, str);
        }

        public static DEFAULT_REGEX_NAME_FINDER[] values() {
            return (DEFAULT_REGEX_NAME_FINDER[]) $VALUES.clone();
        }

        private DEFAULT_REGEX_NAME_FINDER(String str, int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RegexAble {
        Map<String, Pattern[]> getRegexMap();

        String getType();
    }

    private static synchronized Map<String, Pattern[]> defaultsToMap(DEFAULT_REGEX_NAME_FINDER... default_regex_name_finderArr) {
        HashMap map;
        map = new HashMap();
        for (DEFAULT_REGEX_NAME_FINDER default_regex_name_finder : default_regex_name_finderArr) {
            map.putAll(default_regex_name_finder.getRegexMap());
        }
        return map;
    }

    public static synchronized RegexNameFinder getDefaultRegexNameFinders(Map<String, Pattern[]> map, DEFAULT_REGEX_NAME_FINDER... default_regex_name_finderArr) {
        Map map2;
        try {
            Objects.requireNonNull(map, "config must not be null");
            map2 = new HashMap();
            if (default_regex_name_finderArr != null) {
                map2 = defaultsToMap(default_regex_name_finderArr);
            }
            map2.putAll(map);
        } catch (Throwable th) {
            throw th;
        }
        return new RegexNameFinder(map2);
    }

    public static synchronized RegexNameFinder getDefaultRegexNameFinders(DEFAULT_REGEX_NAME_FINDER... default_regex_name_finderArr) {
        Objects.requireNonNull(default_regex_name_finderArr, "defaults must not be null");
        return new RegexNameFinder(defaultsToMap(default_regex_name_finderArr));
    }
}
