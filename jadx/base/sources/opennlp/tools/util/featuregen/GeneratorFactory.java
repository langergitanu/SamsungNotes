package opennlp.tools.util.featuregen;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.util.html.Attribute;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.XmlUtil;
import opennlp.tools.util.model.ArtifactSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GeneratorFactory {
    private static Map<String, ArtifactSerializer<?>> addMappingsFromXmlChildren(NodeList nodeList, Map<String, ArtifactSerializer<?>> map) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem instanceof Element) {
                Element element = (Element) nodeItem;
                if ("generator".equals(element.getTagName())) {
                    extractArtifactSerializerMappings(map, element);
                }
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AdaptiveFeatureGenerator buildGenerator(Element element, FeatureGeneratorResourceProvider featureGeneratorResourceProvider) throws InvalidFormatException {
        if (element == null) {
            throw new IllegalArgumentException("generatorElement must not be NULL");
        }
        String attribute = element.getAttribute(Attribute.CLASS_ATTR);
        int length = attribute.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = attribute.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                try {
                    try {
                        AbstractXmlFeatureGeneratorFactory abstractXmlFeatureGeneratorFactory = (AbstractXmlFeatureGeneratorFactory) Class.forName(attribute).getConstructor(null).newInstance(null);
                        abstractXmlFeatureGeneratorFactory.init(element, featureGeneratorResourceProvider);
                        return abstractXmlFeatureGeneratorFactory.create();
                    } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | InvalidFormatException e) {
                        throw new RuntimeException(e);
                    }
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        throw new InvalidFormatException("generator must have class attribute");
    }

    public static AdaptiveFeatureGenerator create(InputStream inputStream, FeatureGeneratorResourceProvider featureGeneratorResourceProvider) {
        return createGenerator(createDOM(inputStream).getDocumentElement(), featureGeneratorResourceProvider);
    }

    private static Document createDOM(InputStream inputStream) throws InvalidFormatException {
        try {
            return XmlUtil.createDocumentBuilder().parse(inputStream);
        } catch (SAXException e) {
            throw new InvalidFormatException("Descriptor is not valid XML!", e);
        }
    }

    private static AdaptiveFeatureGenerator createGenerator(Element element, FeatureGeneratorResourceProvider featureGeneratorResourceProvider) throws InvalidFormatException {
        AdaptiveFeatureGenerator aggregatedFeatureGenerator;
        if (element == null) {
            throw new IllegalArgumentException("generatorElement must not be NULL");
        }
        String tagName = element.getTagName();
        if (!"featureGenerators".equals(tagName)) {
            throw new IllegalArgumentException("[OPENNLP-1174] - Classic configuration format is no longer supported!");
        }
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                if (!"generator".equals(element2.getTagName())) {
                    throw new InvalidFormatException(AbstractC0541b.m772n("Unexpected element: ", tagName));
                }
                arrayList.add(buildGenerator(element2, featureGeneratorResourceProvider));
            }
        }
        if (arrayList.size() == 1) {
            aggregatedFeatureGenerator = (AdaptiveFeatureGenerator) arrayList.get(0);
        } else {
            if (arrayList.size() <= 1) {
                throw new InvalidFormatException("featureGenerators must have one or more generators");
            }
            aggregatedFeatureGenerator = new AggregatedFeatureGenerator((AdaptiveFeatureGenerator[]) arrayList.toArray(new AdaptiveFeatureGenerator[0]));
        }
        if (aggregatedFeatureGenerator instanceof CachedFeatureGenerator) {
            throw new InvalidFormatException("CachedFeatureGeneratorFactory cannot be specified manually.Use cache=\"true\" attribute in featureGenerators element instead.");
        }
        return Boolean.parseBoolean(element.getAttribute("cache")) ? new CachedFeatureGenerator(aggregatedFeatureGenerator) : aggregatedFeatureGenerator;
    }

    public static Map<String, ArtifactSerializer<?>> extractArtifactSerializerMappings(InputStream inputStream) {
        Element documentElement = createDOM(inputStream).getDocumentElement();
        if ("featureGenerators".equals(documentElement.getTagName())) {
            return addMappingsFromXmlChildren(documentElement.getChildNodes(), new HashMap());
        }
        throw new IllegalArgumentException("[OPENNLP-1174] - Classic configuration format is no longer supported!");
    }

    public static List<Element> getDescriptorElements(InputStream inputStream) throws InvalidFormatException {
        ArrayList arrayList = new ArrayList();
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*").evaluate(createDOM(inputStream).getDocumentElement(), XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nodeItem = nodeList.item(i);
                if (nodeItem instanceof Element) {
                    arrayList.add((Element) nodeItem);
                }
            }
            return arrayList;
        } catch (XPathExpressionException unused) {
            throw new InvalidFormatException("The hard coded XPath expression should always be valid!");
        }
    }

    private static void extractArtifactSerializerMappings(Map<String, ArtifactSerializer<?>> map, Element element) {
        String attribute = element.getAttribute(Attribute.CLASS_ATTR);
        int length = attribute.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                break;
            }
            int iCodePointAt = attribute.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                try {
                    try {
                        AbstractXmlFeatureGeneratorFactory abstractXmlFeatureGeneratorFactory = (AbstractXmlFeatureGeneratorFactory) Class.forName(attribute).getConstructor(null).newInstance(null);
                        abstractXmlFeatureGeneratorFactory.init(element, null);
                        Map<String, ArtifactSerializer<?>> artifactSerializerMapping = abstractXmlFeatureGeneratorFactory.getArtifactSerializerMapping();
                        if (artifactSerializerMapping != null) {
                            map.putAll(artifactSerializerMapping);
                        }
                    } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (InvalidFormatException unused) {
                    }
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        addMappingsFromXmlChildren(element.getChildNodes(), map);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbstractXmlFeatureGeneratorFactory {
        protected LinkedHashMap<String, Object> args = new LinkedHashMap<>();
        protected Element generatorElement;
        protected FeatureGeneratorResourceProvider resourceManager;

        public abstract AdaptiveFeatureGenerator create();

        public Map<String, ArtifactSerializer<?>> getArtifactSerializerMapping() {
            return null;
        }

        public boolean getBool(String str) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be set!"));
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be boolean!"));
        }

        public double getDouble(String str) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be set!"));
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be double!"));
        }

        public float getFloat(String str) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be set!"));
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be float!"));
        }

        public int getInt(String str) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be set!"));
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be integer!"));
        }

        public long getLong(String str) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be set!"));
            }
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be long!"));
        }

        public String getStr(String str) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be set!"));
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be double!"));
        }

        public final void init(Element element, FeatureGeneratorResourceProvider featureGeneratorResourceProvider) throws InvalidFormatException {
            String attribute;
            Text text;
            this.generatorElement = element;
            this.resourceManager = featureGeneratorResourceProvider;
            ArrayList arrayList = new ArrayList();
            NodeList childNodes = this.generatorElement.getChildNodes();
            int i = 0;
            while (true) {
                if (i >= childNodes.getLength()) {
                    if (arrayList.size() > 1) {
                        this.args.put("generator#0", new AggregatedFeatureGenerator((AdaptiveFeatureGenerator[]) arrayList.toArray(new AdaptiveFeatureGenerator[0])));
                        return;
                    }
                    return;
                }
                Node nodeItem = childNodes.item(i);
                if (nodeItem instanceof Element) {
                    Element element2 = (Element) nodeItem;
                    String tagName = element2.getTagName();
                    if (tagName.equals("generator")) {
                        String strM11h = AbstractC0000a.m11h(arrayList.size(), "generator#");
                        AdaptiveFeatureGenerator adaptiveFeatureGeneratorBuildGenerator = GeneratorFactory.buildGenerator(element2, featureGeneratorResourceProvider);
                        if (adaptiveFeatureGeneratorBuildGenerator != null) {
                            arrayList.add(adaptiveFeatureGeneratorBuildGenerator);
                            this.args.put(strM11h, adaptiveFeatureGeneratorBuildGenerator);
                        }
                    } else {
                        attribute = element2.getAttribute("name");
                        text = (Text) element2.getFirstChild();
                        switch (tagName) {
                            case "double":
                                this.args.put(attribute, Double.valueOf(Double.parseDouble(text.getWholeText())));
                                break;
                            case "int":
                                this.args.put(attribute, Integer.valueOf(Integer.parseInt(text.getWholeText())));
                                break;
                            case "str":
                                this.args.put(attribute, text.getWholeText());
                                break;
                            case "bool":
                                this.args.put(attribute, Boolean.valueOf(Boolean.parseBoolean(text.getWholeText())));
                                break;
                            case "long":
                                this.args.put(attribute, Long.valueOf(Long.parseLong(text.getWholeText())));
                                break;
                            case "float":
                                this.args.put(attribute, Float.valueOf(Float.parseFloat(text.getWholeText())));
                                break;
                            default:
                                throw new InvalidFormatException("child element must be one of generator, int, long, float, double, str or bool");
                        }
                    }
                }
                i++;
            }
        }

        public boolean getBool(String str, boolean z) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                return z;
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be boolean!"));
        }

        public double getDouble(String str, double d) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                return d;
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be double!"));
        }

        public float getFloat(String str, float f) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                return f;
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be float!"));
        }

        public int getInt(String str, int i) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                return i;
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be integer!"));
        }

        public long getLong(String str, long j) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                return j;
            }
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be long!"));
        }

        public String getStr(String str, String str2) throws InvalidFormatException {
            Object obj = this.args.get(str);
            if (obj == null) {
                return str2;
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            throw new InvalidFormatException(AbstractC0541b.m773o("parameter ", str, " must be String!"));
        }
    }
}
