package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.XmlTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.scsp.common.Header;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jsoup.helper.Validate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Tag {
    private static final String[] blockTags;
    private static final String[] emptyTags;
    private static final String[] formListedTags;
    private static final String[] formSubmitTags;
    private static final String[] formatAsInlineTags;
    private static final String[] inlineTags;
    private static final String[] preserveWhitespaceTags;
    private static final Map<String, Tag> tags = new HashMap();
    private String tagName;
    private boolean isBlock = true;
    private boolean formatAsBlock = true;
    private boolean canContainBlock = true;
    private boolean canContainInline = true;
    private boolean empty = false;
    private boolean selfClosing = false;
    private boolean preserveWhitespace = false;
    private boolean formList = false;
    private boolean formSubmit = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", StringLookupFactory.KEY_SCRIPT, "noscript", "style", "meta", "link", "title", TypedValues.Attributes.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", ComposerSAConstants.DETAIL_VIDEO, "audio", "canvas", "details", ExternalSettingsProvider.EXTRA_MENU, "plaintext", XmlTemplateConstants.TEMPLATE, "article", "main", "svg", "math"};
        blockTags = strArr;
        inlineTags = new String[]{CoeditServiceConstants.Element.NAME_OBJECT, "base", "font", "tt", "i", "b", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE, "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", Header.f8126BR, "wbr", "map", JWKParameterNames.RSA_SECOND_PRIME_FACTOR, "sub", "sup", "bdo", "iframe", "embed", "span", "input", Bixby2Constants.BIXBY_PARAM_SELECT, "textarea", "label", MarketingConstants.BUTTON, "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", DBSchema.DocumentCover.SUMMARY, Contract.COMMAND, "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi"};
        emptyTags = new String[]{"meta", "link", "base", TypedValues.Attributes.S_FRAME, "img", Header.f8126BR, "wbr", "embed", "hr", "input", "keygen", "col", Contract.COMMAND, "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        formatAsInlineTags = new String[]{"title", "a", "p", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", StringLookupFactory.KEY_SCRIPT, "style", "ins", "del", "s"};
        preserveWhitespaceTags = new String[]{"pre", "plaintext", "title", "textarea"};
        formListedTags = new String[]{MarketingConstants.BUTTON, "fieldset", "input", "keygen", CoeditServiceConstants.Element.NAME_OBJECT, "output", Bixby2Constants.BIXBY_PARAM_SELECT, "textarea"};
        formSubmitTags = new String[]{"input", "keygen", CoeditServiceConstants.Element.NAME_OBJECT, Bixby2Constants.BIXBY_PARAM_SELECT, "textarea"};
        for (String str : strArr) {
            register(new Tag(str));
        }
        for (String str2 : inlineTags) {
            Tag tag = new Tag(str2);
            tag.isBlock = false;
            tag.canContainBlock = false;
            tag.formatAsBlock = false;
            register(tag);
        }
        for (String str3 : emptyTags) {
            Tag tag2 = tags.get(str3);
            Validate.notNull(tag2);
            tag2.canContainBlock = false;
            tag2.canContainInline = false;
            tag2.empty = true;
        }
        for (String str4 : formatAsInlineTags) {
            Tag tag3 = tags.get(str4);
            Validate.notNull(tag3);
            tag3.formatAsBlock = false;
        }
        for (String str5 : preserveWhitespaceTags) {
            Tag tag4 = tags.get(str5);
            Validate.notNull(tag4);
            tag4.preserveWhitespace = true;
        }
        for (String str6 : formListedTags) {
            Tag tag5 = tags.get(str6);
            Validate.notNull(tag5);
            tag5.formList = true;
        }
        for (String str7 : formSubmitTags) {
            Tag tag6 = tags.get(str7);
            Validate.notNull(tag6);
            tag6.formSubmit = true;
        }
    }

    private Tag(String str) {
        this.tagName = str.toLowerCase();
    }

    private static void register(Tag tag) {
        tags.put(tag.tagName, tag);
    }

    public static Tag valueOf(String str) {
        Validate.notNull(str);
        Map<String, Tag> map = tags;
        Tag tag = map.get(str);
        if (tag != null) {
            return tag;
        }
        String lowerCase = str.trim().toLowerCase();
        Validate.notEmpty(lowerCase);
        Tag tag2 = map.get(lowerCase);
        if (tag2 != null) {
            return tag2;
        }
        Tag tag3 = new Tag(lowerCase);
        tag3.isBlock = false;
        tag3.canContainBlock = true;
        return tag3;
    }

    public boolean canContainBlock() {
        return this.canContainBlock;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return this.tagName.equals(tag.tagName) && this.canContainBlock == tag.canContainBlock && this.canContainInline == tag.canContainInline && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit;
    }

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public String getName() {
        return this.tagName;
    }

    public int hashCode() {
        return (((((((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.canContainBlock ? 1 : 0)) * 31) + (this.canContainInline ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean isData() {
        return (this.canContainInline || isEmpty()) ? false : true;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isKnownTag() {
        return tags.containsKey(this.tagName);
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public String toString() {
        return this.tagName;
    }

    public static boolean isKnownTag(String str) {
        return tags.containsKey(str);
    }
}
