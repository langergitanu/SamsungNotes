package opennlp.tools.namefind;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class RegexNameFinder implements TokenNameFinder {
    private Pattern[] mPatterns;
    private Map<String, Pattern[]> regexMap;
    private String sType;

    public RegexNameFinder(Map<String, Pattern[]> map) {
        Objects.requireNonNull(map, "regexMap must not be null");
        this.regexMap = map;
    }

    private Span[] getAnnotations(String str) {
        LinkedList linkedList = new LinkedList();
        Map<String, Pattern[]> map = this.regexMap;
        if (map != null) {
            for (Map.Entry<String, Pattern[]> entry : map.entrySet()) {
                for (Pattern pattern : entry.getValue()) {
                    Matcher matcher = pattern.matcher(str);
                    while (matcher.find()) {
                        linkedList.add(new Span(matcher.start(), matcher.end(), entry.getKey()));
                    }
                }
            }
        } else {
            for (Pattern pattern2 : this.mPatterns) {
                Matcher matcher2 = pattern2.matcher(str);
                while (matcher2.find()) {
                    linkedList.add(new Span(matcher2.start(), matcher2.end(), this.sType));
                }
            }
        }
        return (Span[]) linkedList.toArray(new Span[0]);
    }

    @Override // opennlp.tools.namefind.TokenNameFinder
    public Span[] find(String[] strArr) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder(strArr.length * 10);
        int i = 0;
        while (i < strArr.length) {
            map.put(Integer.valueOf(sb.length()), Integer.valueOf(i));
            sb.append(strArr[i]);
            int i2 = i + 1;
            map.put(Integer.valueOf(sb.length()), Integer.valueOf(i2));
            if (i < strArr.length - 1) {
                sb.append(' ');
            }
            i = i2;
        }
        LinkedList linkedList = new LinkedList();
        Map<String, Pattern[]> map2 = this.regexMap;
        if (map2 != null) {
            for (Map.Entry<String, Pattern[]> entry : map2.entrySet()) {
                for (Pattern pattern : entry.getValue()) {
                    Matcher matcher = pattern.matcher(sb);
                    while (matcher.find()) {
                        Integer num = (Integer) map.get(Integer.valueOf(matcher.start()));
                        Integer num2 = (Integer) map.get(Integer.valueOf(matcher.end()));
                        if (num != null && num2 != null) {
                            linkedList.add(new Span(num.intValue(), num2.intValue(), entry.getKey()));
                        }
                    }
                }
            }
        } else {
            for (Pattern pattern2 : this.mPatterns) {
                Matcher matcher2 = pattern2.matcher(sb);
                while (matcher2.find()) {
                    Integer num3 = (Integer) map.get(Integer.valueOf(matcher2.start()));
                    Integer num4 = (Integer) map.get(Integer.valueOf(matcher2.end()));
                    if (num3 != null && num4 != null) {
                        linkedList.add(new Span(num3.intValue(), num4.intValue(), this.sType));
                    }
                }
            }
        }
        return (Span[]) linkedList.toArray(new Span[0]);
    }

    public Pattern[] getMatchingPatterns() {
        return this.mPatterns;
    }

    public String getSpanType() {
        return this.sType;
    }

    public void setMatchingPatterns(Pattern[] patternArr) {
        this.mPatterns = patternArr;
    }

    public void setSpanType(String str) {
        this.sType = str;
    }

    public RegexNameFinder(Pattern[] patternArr, String str) {
        if (patternArr != null && patternArr.length != 0) {
            this.mPatterns = patternArr;
            this.sType = str;
            return;
        }
        throw new IllegalArgumentException("patterns must not be null or empty!");
    }

    @Override // opennlp.tools.namefind.TokenNameFinder
    public void clearAdaptiveData() {
    }

    public Span[] find(String str) {
        return getAnnotations(str);
    }
}
