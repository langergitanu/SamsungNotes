package org.jsoup.nodes;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    public Elements elements() {
        return this.elements;
    }

    public List<Connection.KeyVal> formData() {
        Element elementFirst;
        ArrayList arrayList = new ArrayList();
        for (Element element : this.elements) {
            if (element.tag().isFormSubmittable() && !element.hasAttr("disabled")) {
                String strAttr = element.attr("name");
                if (strAttr.length() != 0) {
                    String strAttr2 = element.attr("type");
                    if (Bixby2Constants.BIXBY_PARAM_SELECT.equals(element.tagName())) {
                        Iterator<Element> it = element.select("option[selected]").iterator();
                        boolean z = false;
                        while (it.hasNext()) {
                            arrayList.add(HttpConnection.KeyVal.create(strAttr, it.next().val()));
                            z = true;
                        }
                        if (!z && (elementFirst = element.select("option").first()) != null) {
                            arrayList.add(HttpConnection.KeyVal.create(strAttr, elementFirst.val()));
                        }
                    } else if (!"checkbox".equalsIgnoreCase(strAttr2) && !"radio".equalsIgnoreCase(strAttr2)) {
                        arrayList.add(HttpConnection.KeyVal.create(strAttr, element.val()));
                    } else if (element.hasAttr("checked")) {
                        arrayList.add(HttpConnection.KeyVal.create(strAttr, element.val().length() > 0 ? element.val() : "on"));
                    }
                }
            }
        }
        return arrayList;
    }

    public Connection submit() {
        String strAbsUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(strAbsUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.connect(strAbsUrl).data(formData()).method(attr("method").toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }
}
