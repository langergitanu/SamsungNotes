package opennlp.tools.formats.p216ad;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.StringUtil;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class PortugueseContractionUtility {
    protected static final Map<String, String> CONTRACTIONS;

    static {
        HashMap mapM13996q = AbstractC12991c.m13996q("a+a", "à", "a+as", "às");
        mapM13996q.put("a+aquele", "àquele");
        mapM13996q.put("a+aqueles", "àqueles");
        mapM13996q.put("a+aquela", "àquela");
        mapM13996q.put("a+aquelas", "àquelas");
        mapM13996q.put("a+aquilo", "àquilo");
        mapM13996q.put("a+o", "ao");
        mapM13996q.put("a+os", "aos");
        mapM13996q.put("com+mim", "comigo");
        mapM13996q.put("com+nòs", "conosco");
        mapM13996q.put("com+si", "consigo");
        mapM13996q.put("com+ti", "contigo");
        mapM13996q.put("com+vòs", "convosco");
        mapM13996q.put("de+aí", "daí");
        mapM13996q.put("de+alguém", "dalguém");
        mapM13996q.put("de+algum", "dalgum");
        mapM13996q.put("de+alguma", "dalguma");
        mapM13996q.put("de+alguns", "dalguns");
        mapM13996q.put("de+algumas", "dalgumas");
        mapM13996q.put("de+ali", "dali");
        mapM13996q.put("de+aquém", "daquém");
        mapM13996q.put("de+aquele", "daquele");
        mapM13996q.put("de+aquela", "daquela");
        mapM13996q.put("de+aqueles", "daqueles");
        mapM13996q.put("de+aquelas", "daquelas");
        mapM13996q.put("de+aqui", "daqui");
        mapM13996q.put("de+aquilo", "daquilo");
        mapM13996q.put("de+ele", "dele");
        mapM13996q.put("de+ela", "dela");
        mapM13996q.put("de+eles", "deles");
        mapM13996q.put("de+elas", "delas");
        mapM13996q.put("de+entre", "dentre");
        mapM13996q.put("de+esse", "desse");
        mapM13996q.put("de+essa", "dessa");
        mapM13996q.put("de+esses", "desses");
        mapM13996q.put("de+essas", "dessas");
        mapM13996q.put("de+este", "deste");
        mapM13996q.put("de+esta", "desta");
        mapM13996q.put("de+estes", "destes");
        mapM13996q.put("de+estas", "destas");
        mapM13996q.put("de+isso", "disso");
        mapM13996q.put("de+isto", "disto");
        mapM13996q.put("de+o", "do");
        mapM13996q.put("de+a", "da");
        mapM13996q.put("de+os", "dos");
        mapM13996q.put("de+as", "das");
        mapM13996q.put("de+outrem", "doutrem");
        mapM13996q.put("de+outro", "doutro");
        mapM13996q.put("de+outra", "doutra");
        mapM13996q.put("de+outros", "doutros");
        mapM13996q.put("de+outras", "doutras");
        mapM13996q.put("de+um", "dum");
        mapM13996q.put("de+uma", "duma");
        mapM13996q.put("de+uns", "duns");
        mapM13996q.put("de+umas", "dumas");
        mapM13996q.put("esse+outro", "essoutro");
        mapM13996q.put("essa+outra", "essoutra");
        mapM13996q.put("este+outro", "estoutro");
        mapM13996q.put("este+outra", "estoutra");
        mapM13996q.put("ele+o", "lho");
        mapM13996q.put("ele+a", "lha");
        mapM13996q.put("ele+os", "lhos");
        mapM13996q.put("ele+as", "lhas");
        mapM13996q.put("em+algum", "nalgum");
        mapM13996q.put("em+alguma", "nalguma");
        mapM13996q.put("em+alguns", "nalguns");
        mapM13996q.put("em+algumas", "nalgumas");
        mapM13996q.put("em+aquele", "naquele");
        mapM13996q.put("em+aquela", "naquela");
        mapM13996q.put("em+aqueles", "naqueles");
        mapM13996q.put("em+aquelas", "naquelas");
        mapM13996q.put("em+aquilo", "naquilo");
        mapM13996q.put("em+ele", "nele");
        mapM13996q.put("em+ela", "nela");
        mapM13996q.put("em+eles", "neles");
        mapM13996q.put("em+elas", "nelas");
        mapM13996q.put("em+esse", "nesse");
        mapM13996q.put("em+essa", "nessa");
        mapM13996q.put("em+esses", "nesses");
        mapM13996q.put("em+essas", "nessas");
        mapM13996q.put("em+este", "neste");
        mapM13996q.put("em+esta", "nesta");
        mapM13996q.put("em+estes", "nestes");
        mapM13996q.put("em+estas", "nestas");
        mapM13996q.put("em+isso", "nisso");
        mapM13996q.put("em+isto", "nisto");
        mapM13996q.put("em+o", BooleanUtils.f9757NO);
        mapM13996q.put("em+a", "na");
        mapM13996q.put("em+os", "nos");
        mapM13996q.put("em+as", "nas");
        mapM13996q.put("em+outro", "noutro");
        mapM13996q.put("em+outra", "noutra");
        mapM13996q.put("em+outros", "noutros");
        mapM13996q.put("em+outras", "noutras");
        mapM13996q.put("em+um", "num");
        mapM13996q.put("em+uma", "numa");
        mapM13996q.put("em+uns", "nuns");
        mapM13996q.put("em+umas", "numas");
        mapM13996q.put("por+o", "pelo");
        mapM13996q.put("por+a", "pela");
        mapM13996q.put("por+os", "pelos");
        mapM13996q.put("por+as", "pelas");
        mapM13996q.put("para+a", "pra");
        mapM13996q.put("para+o", "pro");
        mapM13996q.put("para+as", "pras");
        mapM13996q.put("para+os", "pros");
        CONTRACTIONS = Collections.unmodifiableMap(mapM13996q);
    }

    public static String toContraction(String str, String str2) {
        String strM757C = AbstractC0541b.m757C(str, Marker.ANY_NON_NULL_MARKER, str2);
        Map<String, String> map = CONTRACTIONS;
        if (map.containsKey(strM757C)) {
            return map.get(strM757C);
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split("_");
        for (int iM2213d = 0; iM2213d < strArrSplit.length - 1; iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, strArrSplit[iM2213d], " ")) {
        }
        String strM757C2 = AbstractC0541b.m757C(strArrSplit[strArrSplit.length - 1], Marker.ANY_NON_NULL_MARKER, str2);
        Map<String, String> map2 = CONTRACTIONS;
        if (map2.containsKey(strM757C2)) {
            sb.append(map2.get(strM757C2));
            return sb.toString();
        }
        if (str2.contains("_")) {
            strArrSplit = str2.split("_");
            String strM757C3 = AbstractC0541b.m757C(str, Marker.ANY_NON_NULL_MARKER, strArrSplit[0]);
            if (map2.containsKey(strM757C3)) {
                sb.append(map2.get(strM757C3));
                sb.append(" ");
                for (int iM2213d2 = 1; iM2213d2 < strArrSplit.length; iM2213d2 = AbstractC2821a.m2213d(sb, iM2213d2, 1, strArrSplit[iM2213d2], " ")) {
                }
                return sb.toString();
            }
        }
        String strM757C4 = AbstractC0541b.m757C(StringUtil.toLowerCase(strArrSplit[strArrSplit.length - 1]), Marker.ANY_NON_NULL_MARKER, str2);
        if (!map2.containsKey(strM757C4)) {
            return null;
        }
        String str3 = map2.get(strM757C4);
        sb.append(StringUtil.toUpperCase(str3.substring(0, 1)) + str3.substring(1));
        return sb.toString();
    }
}
