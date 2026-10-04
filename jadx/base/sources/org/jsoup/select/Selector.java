package org.jsoup.select;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Selector {
    private final Evaluator evaluator;
    private final Element root;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector(String str, Element element) {
        Validate.notNull(str);
        String strTrim = str.trim();
        Validate.notEmpty(strTrim);
        Validate.notNull(element);
        this.evaluator = QueryParser.parse(strTrim);
        this.root = element;
    }

    public static Elements filterOut(Collection<Element> collection, Collection<Element> collection2) {
        Elements elements = new Elements();
        for (Element element : collection) {
            Iterator<Element> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    elements.add(element);
                    break;
                }
                if (element.equals(it.next())) {
                    break;
                }
            }
        }
        return elements;
    }

    public static Elements select(String str, Element element) {
        return new Selector(str, element).select();
    }

    public static Elements select(Evaluator evaluator, Element element) {
        return new Selector(evaluator, element).select();
    }

    public static Elements select(String str, Iterable<Element> iterable) {
        Validate.notEmpty(str);
        Validate.notNull(iterable);
        Evaluator evaluator = QueryParser.parse(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Element> it = iterable.iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(select(evaluator, it.next()));
        }
        return new Elements(linkedHashSet);
    }

    private Selector(Evaluator evaluator, Element element) {
        Validate.notNull(evaluator);
        Validate.notNull(element);
        this.evaluator = evaluator;
        this.root = element;
    }

    private Elements select() {
        return Collector.collect(this.evaluator, this.root);
    }
}
