package org.jsoup.safety;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import com.samsung.scsp.common.Header;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Whitelist {
    private Set<TagName> tagNames = new HashSet();
    private Map<TagName, Set<AttributeKey>> attributes = new HashMap();
    private Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes = new HashMap();
    private Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols = new HashMap();
    private boolean preserveRelativeLinks = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AttributeKey extends TypedValue {
        public AttributeKey(String str) {
            super(str);
        }

        public static AttributeKey valueOf(String str) {
            return new AttributeKey(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AttributeValue extends TypedValue {
        public AttributeValue(String str) {
            super(str);
        }

        public static AttributeValue valueOf(String str) {
            return new AttributeValue(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Protocol extends TypedValue {
        public Protocol(String str) {
            super(str);
        }

        public static Protocol valueOf(String str) {
            return new Protocol(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TagName extends TypedValue {
        public TagName(String str) {
            super(str);
        }

        public static TagName valueOf(String str) {
            return new TagName(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TypedValue {
        private String value;

        public TypedValue(String str) {
            Validate.notNull(str);
            this.value = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TypedValue typedValue = (TypedValue) obj;
            String str = this.value;
            if (str == null) {
                if (typedValue.value != null) {
                    return false;
                }
            } else if (!str.equals(typedValue.value)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.value;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return this.value;
        }
    }

    public static Whitelist basic() {
        return new Whitelist().addTags("a", "b", "blockquote", Header.f8126BR, "cite", "code", "dd", "dl", "dt", "em", "i", "li", "ol", "p", "pre", JWKParameterNames.RSA_SECOND_PRIME_FACTOR, "small", "span", "strike", "strong", "sub", "sup", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE, "ul").addAttributes("a", "href").addAttributes("blockquote", "cite").addAttributes(JWKParameterNames.RSA_SECOND_PRIME_FACTOR, "cite").addProtocols("a", "href", "ftp", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING, "mailto").addProtocols("blockquote", "cite", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING).addProtocols("cite", "cite", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING).addEnforcedAttribute("a", Constants.VALUE_LOG_TYPE_REL, "nofollow");
    }

    public static Whitelist basicWithImages() {
        return basic().addTags("img").addAttributes("img", "align", "alt", "height", "src", "title", "width").addProtocols("img", "src", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING);
    }

    private boolean isValidAnchor(String str) {
        return str.startsWith(ContentUtils.HASH_SYMBOL) && !str.matches(".*\\s.*");
    }

    public static Whitelist none() {
        return new Whitelist();
    }

    public static Whitelist relaxed() {
        return new Whitelist().addTags("a", "b", "blockquote", Header.f8126BR, "caption", "cite", "code", "col", "colgroup", "dd", "div", "dl", "dt", "em", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6", "i", "img", "li", "ol", "p", "pre", JWKParameterNames.RSA_SECOND_PRIME_FACTOR, "small", "span", "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE, "ul").addAttributes("a", "href", "title").addAttributes("blockquote", "cite").addAttributes("col", "span", "width").addAttributes("colgroup", "span", "width").addAttributes("img", "align", "alt", "height", "src", "title", "width").addAttributes("ol", "start", "type").addAttributes(JWKParameterNames.RSA_SECOND_PRIME_FACTOR, "cite").addAttributes("table", DBSchema.DocumentCover.SUMMARY, "width").addAttributes("td", "abbr", "axis", "colspan", "rowspan", "width").addAttributes("th", "abbr", "axis", "colspan", "rowspan", "scope", "width").addAttributes("ul", "type").addProtocols("a", "href", "ftp", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING, "mailto").addProtocols("blockquote", "cite", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING).addProtocols("cite", "cite", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING).addProtocols("img", "src", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING).addProtocols(JWKParameterNames.RSA_SECOND_PRIME_FACTOR, "cite", "http", AuthenticationConstants.HTTPS_PROTOCOL_STRING);
    }

    public static Whitelist simpleText() {
        return new Whitelist().addTags("b", "em", "i", "strong", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
    }

    private boolean testValidProtocol(Element element, Attribute attribute, Set<Protocol> set) {
        String strAbsUrl = element.absUrl(attribute.getKey());
        if (strAbsUrl.length() == 0) {
            strAbsUrl = attribute.getValue();
        }
        if (!this.preserveRelativeLinks) {
            attribute.setValue(strAbsUrl);
        }
        Iterator<Protocol> it = set.iterator();
        while (it.hasNext()) {
            String string = it.next().toString();
            if (!string.equals(ContentUtils.HASH_SYMBOL)) {
                if (strAbsUrl.toLowerCase().startsWith(string.concat(":"))) {
                    return true;
                }
            } else if (isValidAnchor(strAbsUrl)) {
                return true;
            }
        }
        return false;
    }

    public Whitelist addAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attributes supplied.");
        TagName tagNameValueOf = TagName.valueOf(str);
        if (!this.tagNames.contains(tagNameValueOf)) {
            this.tagNames.add(tagNameValueOf);
        }
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.attributes.containsKey(tagNameValueOf)) {
            this.attributes.get(tagNameValueOf).addAll(hashSet);
            return this;
        }
        this.attributes.put(tagNameValueOf, hashSet);
        return this;
    }

    public Whitelist addEnforcedAttribute(String str, String str2, String str3) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notEmpty(str3);
        TagName tagNameValueOf = TagName.valueOf(str);
        if (!this.tagNames.contains(tagNameValueOf)) {
            this.tagNames.add(tagNameValueOf);
        }
        AttributeKey attributeKeyValueOf = AttributeKey.valueOf(str2);
        AttributeValue attributeValueValueOf = AttributeValue.valueOf(str3);
        if (this.enforcedAttributes.containsKey(tagNameValueOf)) {
            this.enforcedAttributes.get(tagNameValueOf).put(attributeKeyValueOf, attributeValueValueOf);
            return this;
        }
        HashMap map = new HashMap();
        map.put(attributeKeyValueOf, attributeValueValueOf);
        this.enforcedAttributes.put(tagNameValueOf, map);
        return this;
    }

    public Whitelist addProtocols(String str, String str2, String... strArr) {
        Map<AttributeKey, Set<Protocol>> map;
        Set<Protocol> set;
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName tagNameValueOf = TagName.valueOf(str);
        AttributeKey attributeKeyValueOf = AttributeKey.valueOf(str2);
        if (this.protocols.containsKey(tagNameValueOf)) {
            map = this.protocols.get(tagNameValueOf);
        } else {
            HashMap map2 = new HashMap();
            this.protocols.put(tagNameValueOf, map2);
            map = map2;
        }
        if (map.containsKey(attributeKeyValueOf)) {
            set = map.get(attributeKeyValueOf);
        } else {
            HashSet hashSet = new HashSet();
            map.put(attributeKeyValueOf, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.add(Protocol.valueOf(str3));
        }
        return this;
    }

    public Whitelist addTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            this.tagNames.add(TagName.valueOf(str));
        }
        return this;
    }

    public Attributes getEnforcedAttributes(String str) {
        Attributes attributes = new Attributes();
        TagName tagNameValueOf = TagName.valueOf(str);
        if (this.enforcedAttributes.containsKey(tagNameValueOf)) {
            for (Map.Entry<AttributeKey, AttributeValue> entry : this.enforcedAttributes.get(tagNameValueOf).entrySet()) {
                attributes.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return attributes;
    }

    public boolean isSafeAttribute(String str, Element element, Attribute attribute) {
        TagName tagNameValueOf = TagName.valueOf(str);
        AttributeKey attributeKeyValueOf = AttributeKey.valueOf(attribute.getKey());
        if (!this.attributes.containsKey(tagNameValueOf) || !this.attributes.get(tagNameValueOf).contains(attributeKeyValueOf)) {
            return !str.equals(":all") && isSafeAttribute(":all", element, attribute);
        }
        if (this.protocols.containsKey(tagNameValueOf)) {
            Map<AttributeKey, Set<Protocol>> map = this.protocols.get(tagNameValueOf);
            if (map.containsKey(attributeKeyValueOf) && !testValidProtocol(element, attribute, map.get(attributeKeyValueOf))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSafeTag(String str) {
        return this.tagNames.contains(TagName.valueOf(str));
    }

    public Whitelist preserveRelativeLinks(boolean z) {
        this.preserveRelativeLinks = z;
        return this;
    }

    public Whitelist removeAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attributes supplied.");
        TagName tagNameValueOf = TagName.valueOf(str);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.tagNames.contains(tagNameValueOf) && this.attributes.containsKey(tagNameValueOf)) {
            Set<AttributeKey> set = this.attributes.get(tagNameValueOf);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.attributes.remove(tagNameValueOf);
            }
        }
        if (str.equals(":all")) {
            for (TagName tagName : this.attributes.keySet()) {
                Set<AttributeKey> set2 = this.attributes.get(tagName);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.attributes.remove(tagName);
                }
            }
        }
        return this;
    }

    public Whitelist removeEnforcedAttribute(String str, String str2) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        TagName tagNameValueOf = TagName.valueOf(str);
        if (this.tagNames.contains(tagNameValueOf) && this.enforcedAttributes.containsKey(tagNameValueOf)) {
            AttributeKey attributeKeyValueOf = AttributeKey.valueOf(str2);
            Map<AttributeKey, AttributeValue> map = this.enforcedAttributes.get(tagNameValueOf);
            map.remove(attributeKeyValueOf);
            if (map.isEmpty()) {
                this.enforcedAttributes.remove(tagNameValueOf);
            }
        }
        return this;
    }

    public Whitelist removeProtocols(String str, String str2, String... strArr) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName tagNameValueOf = TagName.valueOf(str);
        AttributeKey attributeKeyValueOf = AttributeKey.valueOf(str2);
        if (this.protocols.containsKey(tagNameValueOf)) {
            Map<AttributeKey, Set<Protocol>> map = this.protocols.get(tagNameValueOf);
            if (map.containsKey(attributeKeyValueOf)) {
                Set<Protocol> set = map.get(attributeKeyValueOf);
                for (String str3 : strArr) {
                    Validate.notEmpty(str3);
                    set.remove(Protocol.valueOf(str3));
                }
                if (set.isEmpty()) {
                    map.remove(attributeKeyValueOf);
                    if (map.isEmpty()) {
                        this.protocols.remove(tagNameValueOf);
                    }
                }
            }
        }
        return this;
    }

    public Whitelist removeTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            TagName tagNameValueOf = TagName.valueOf(str);
            if (this.tagNames.remove(tagNameValueOf)) {
                this.attributes.remove(tagNameValueOf);
                this.enforcedAttributes.remove(tagNameValueOf);
                this.protocols.remove(tagNameValueOf);
            }
        }
        return this;
    }
}
