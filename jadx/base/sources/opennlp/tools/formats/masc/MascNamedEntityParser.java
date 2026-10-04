package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascNamedEntityParser extends DefaultHandler {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MascNamedEntityParser.class);
    private final Map<Integer, String> entityIDtoEntityType = new HashMap();
    private final Map<Integer, List<Integer>> entityIDsToTokens = new HashMap();
    private final Map<Integer, String> tokenToEntity = new HashMap();

    public Map<Integer, List<Integer>> getEntityIDsToTokens() {
        return this.entityIDsToTokens;
    }

    public Map<Integer, String> getEntityIDtoEntityType() {
        return this.entityIDtoEntityType;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        try {
            if (str3.equals("a")) {
                int i = Integer.parseInt(attributes.getValue("ref").replaceFirst("ne-n", ""));
                String value = attributes.getValue("label");
                if (this.entityIDtoEntityType.containsKey(Integer.valueOf(i))) {
                    throw new SAXException("Multiple labels for one named entity");
                }
                this.entityIDtoEntityType.put(Integer.valueOf(i), value);
            }
            if (str3.equals("edge")) {
                int i2 = Integer.parseInt(attributes.getValue(Constants.MessagePayloadKeys.FROM).replaceFirst("ne-n", ""));
                int i4 = Integer.parseInt(attributes.getValue("to").replaceFirst("penn-n", ""));
                if (this.entityIDsToTokens.containsKey(Integer.valueOf(i2))) {
                    this.entityIDsToTokens.get(Integer.valueOf(i2)).add(Integer.valueOf(i4));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(i4));
                    this.entityIDsToTokens.put(Integer.valueOf(i2), arrayList);
                }
                String str4 = this.entityIDtoEntityType.get(Integer.valueOf(i2));
                if (this.tokenToEntity.containsKey(Integer.valueOf(i4)) && !str4.equals(this.tokenToEntity.get(Integer.valueOf(i4)))) {
                    logger.warn("One token assigned to different named entity types.\n\tPenn-TokenID: {}\n\tToken types: \"{}\", \"{}\"\n\tKeeping only \"type\"", Integer.valueOf(i4), str4, this.tokenToEntity.get(Integer.valueOf(i4)));
                }
                this.tokenToEntity.put(Integer.valueOf(i4), str4);
            }
        } catch (Exception e) {
            throw new SAXException(AbstractC0541b.m772n("Could not parse the named entity annotation file.\n", e.getMessage()), e);
        }
    }
}
