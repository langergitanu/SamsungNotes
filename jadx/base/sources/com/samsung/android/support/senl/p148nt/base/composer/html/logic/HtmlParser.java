package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlHelper;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.common.Header;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlParser;", "", "<init>", "()V", "parseElement", "", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "element", "Lorg/jsoup/nodes/Element;", "parentHtmlNode", "parseHtmlToNodes", "htmlString", "", "parseHtmlToNodes$ntBase_release", "convertToObject", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "htmlInput", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHtmlParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HtmlParser.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlParser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,566:1\n1374#2:567\n1460#2,2:568\n1462#2,3:571\n1374#2:574\n1460#2,5:575\n808#2,11:580\n808#2,11:591\n808#2,11:602\n774#2:613\n865#2,2:614\n1869#2,2:616\n1374#2:618\n1460#2,5:619\n1869#2,2:624\n1563#2:626\n1634#2,3:627\n1#3:570\n*S KotlinDebug\n*F\n+ 1 HtmlParser.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlParser\n*L\n410#1:567\n410#1:568,2\n410#1:571,3\n426#1:574\n426#1:575,5\n469#1:580,11\n470#1:591,11\n471#1:602,11\n472#1:613\n472#1:614,2\n494#1:616,2\n520#1:618\n520#1:619,5\n542#1:624,2\n447#1:626\n447#1:627,3\n*E\n"})
public final class HtmlParser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "HtmlParser";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlParser$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return HtmlParser.TAG;
        }

        private Companion() {
        }
    }

    private static final List<ListItem> parseElement$wrapListTag(List<? extends HtmlNode> list) {
        List<? extends HtmlNode> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
        for (HtmlNode htmlNode : list2) {
            arrayList.add(htmlNode instanceof ListItem ? (ListItem) htmlNode : new ListItem(null, CollectionsKt.listOf(htmlNode), 1, 1, null));
        }
        return arrayList;
    }

    @NotNull
    public final List<SpenObjectBase> convertToObject(@NotNull String htmlInput) {
        Intrinsics.checkNotNullParameter(htmlInput, "htmlInput");
        List<DocumentElement> listConvertNodesToDocumentElements = DocumentElementKt.convertNodesToDocumentElements(parseHtmlToNodes$ntBase_release(htmlInput));
        if (HtmlHelper.INSTANCE.getENABLED_LOG()) {
            DocumentElementKt.printDocumentElements(listConvertNodesToDocumentElements);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = listConvertNodesToDocumentElements.iterator();
        while (it.hasNext()) {
            SpenObjectBase spenObjectBaseConvertObject = ((DocumentElement) it.next()).convertObject();
            if (spenObjectBaseConvertObject != null) {
                arrayList.add(spenObjectBaseConvertObject);
                String simpleName = spenObjectBaseConvertObject.getClass().getSimpleName();
                Intrinsics.checkNotNull(simpleName);
                String strSubstring = simpleName.substring(simpleName.length() - 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb.append(strSubstring);
                sb.append(',');
            }
        }
        Logger.m8697d(TAG, "convertToObject# " + ((Object) sb));
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0246  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<HtmlNode> parseElement(@NotNull Element element, @Nullable HtmlNode parentHtmlNode) {
        HtmlNode htmlNodeCopy;
        List<HtmlNode> listEmptyList;
        List<HtmlNode> listEmptyList2;
        Intrinsics.checkNotNullParameter(element, "element");
        JsoupAttributes jsoupAttributes = new JsoupAttributes(element);
        String strTagName = element.tagName();
        if (strTagName != null) {
            int iHashCode = strTagName.hashCode();
            if (iHashCode == 97) {
                htmlNodeCopy = !strTagName.equals("a") ? null : new Anchor(jsoupAttributes.getHref(), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 32, null);
            } else if (iHashCode != 98) {
                switch (iHashCode) {
                    case -891985998:
                        htmlNodeCopy = strTagName.equals("strike") ? new StrikeThrough(CollectionsKt.emptyList()) : null;
                        break;
                    case -891980137:
                        htmlNodeCopy = strTagName.equals("strong") ? new Bold(CollectionsKt.emptyList()) : null;
                        break;
                    case -732377866:
                        htmlNodeCopy = strTagName.equals("article") ? new Article(jsoupAttributes.getId(), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 32, null) : null;
                        break;
                    case 105:
                        htmlNodeCopy = strTagName.equals("i") ? new Italic(CollectionsKt.emptyList()) : null;
                        break;
                    case 112:
                        htmlNodeCopy = strTagName.equals("p") ? new Paragraph(jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 16, null) : null;
                        break;
                    case 115:
                        if (!strTagName.equals("s")) {
                            htmlNodeCopy = null;
                            break;
                        }
                        break;
                    case 117:
                        htmlNodeCopy = strTagName.equals(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE) ? new Underline(CollectionsKt.emptyList()) : null;
                        break;
                    case 3152:
                        htmlNodeCopy = strTagName.equals(Header.f8126BR) ? new LineBreak(jsoupAttributes.getClasses()) : null;
                        break;
                    case 3240:
                        if (!strTagName.equals("em")) {
                            htmlNodeCopy = null;
                            break;
                        }
                        break;
                    case 3338:
                        htmlNodeCopy = strTagName.equals("hr") ? new HorizontalRule(jsoupAttributes.getClasses()) : null;
                        break;
                    case 3453:
                        htmlNodeCopy = strTagName.equals("li") ? new ListItem(jsoupAttributes.getClasses(), null, 0, 6, null) : null;
                        break;
                    case 3549:
                        htmlNodeCopy = strTagName.equals("ol") ? new OrderedList(jsoupAttributes.getStart(), jsoupAttributes.getClasses(), null, 4, null) : null;
                        break;
                    case 3696:
                        htmlNodeCopy = strTagName.equals("td") ? new TableCell(jsoupAttributes.getColSpan(), jsoupAttributes.getRowSpan(), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getTextSize(), jsoupAttributes.getTextAlign(), jsoupAttributes.getBackgroundColor(), null, 128, null) : null;
                        break;
                    case 3700:
                        htmlNodeCopy = strTagName.equals("th") ? new TableHeaderCell(jsoupAttributes.getColSpan(), jsoupAttributes.getRowSpan(), jsoupAttributes.getClasses(), null, 8, null) : null;
                        break;
                    case 3710:
                        htmlNodeCopy = strTagName.equals("tr") ? new TableRow(jsoupAttributes.getClasses(), null, 2, null) : null;
                        break;
                    case 3735:
                        htmlNodeCopy = strTagName.equals("ul") ? new UnorderedList(jsoupAttributes.getClasses(), null, 2, null) : null;
                        break;
                    case 99339:
                        if (!strTagName.equals("del")) {
                            htmlNodeCopy = null;
                            break;
                        }
                        break;
                    case 99473:
                        htmlNodeCopy = strTagName.equals("div") ? new Div(jsoupAttributes.getId(), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 32, null) : null;
                        break;
                    case 104387:
                        htmlNodeCopy = strTagName.equals("img") ? new Image(jsoupAttributes.getSrc(), jsoupAttributes.getAlt(), jsoupAttributes.getClasses()) : null;
                        break;
                    case 111267:
                        if (!strTagName.equals("pre")) {
                            htmlNodeCopy = null;
                            break;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(jsoupAttributes.getClasses());
                            List<Node> listChildNodes = element.childNodes();
                            Intrinsics.checkNotNullExpressionValue(listChildNodes, "childNodes(...)");
                            if (!listChildNodes.isEmpty()) {
                                Node node = element.childNodes().get(0);
                                if (node instanceof Element) {
                                    Element element2 = (Element) node;
                                    if (Intrinsics.areEqual(element2.tagName(), "code")) {
                                        arrayList.addAll(new JsoupAttributes(element2).getClasses());
                                        String strText = element.text();
                                        Intrinsics.checkNotNullExpressionValue(strText, "text(...)");
                                        htmlNodeCopy = new CodeBlock(strText, arrayList);
                                    } else {
                                        htmlNodeCopy = null;
                                    }
                                    if (htmlNodeCopy == null) {
                                        htmlNodeCopy = new Pre(jsoupAttributes.getId(), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 32, null);
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case 114240:
                        htmlNodeCopy = strTagName.equals("sub") ? new Subscript(CollectionsKt.emptyList()) : null;
                        break;
                    case 114254:
                        htmlNodeCopy = strTagName.equals("sup") ? new Superscript(CollectionsKt.emptyList()) : null;
                        break;
                    case 3059181:
                        if (strTagName.equals("code")) {
                            Element elementParent = element.parent();
                            if (Intrinsics.areEqual(elementParent != null ? elementParent.tagName() : null, "pre")) {
                                htmlNodeCopy = null;
                            } else {
                                String strText2 = element.text();
                                Intrinsics.checkNotNullExpressionValue(strText2, "text(...)");
                                htmlNodeCopy = new Code(strText2, jsoupAttributes.getClasses());
                            }
                        } else {
                            htmlNodeCopy = null;
                        }
                        break;
                    case 3536714:
                        htmlNodeCopy = strTagName.equals("span") ? new Span(jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 16, null) : null;
                        break;
                    case 100358090:
                        htmlNodeCopy = (!strTagName.equals("input") || !Intrinsics.areEqual(element.attr("type"), "checkbox")) ? null : new Checkbox(jsoupAttributes.getName(), jsoupAttributes.getValue(), jsoupAttributes.isChecked(), jsoupAttributes.isDisabled(), jsoupAttributes.getClasses());
                        break;
                    case 102727412:
                        htmlNodeCopy = strTagName.equals("label") ? new Label(jsoupAttributes.getForAttr(), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 32, null) : null;
                        break;
                    case 110115790:
                        htmlNodeCopy = strTagName.equals("table") ? new Table(jsoupAttributes.getClasses(), null, 2, null) : null;
                        break;
                    case 110157846:
                        htmlNodeCopy = strTagName.equals("tbody") ? new TableBody(CollectionsKt.emptyList()) : null;
                        break;
                    case 110277346:
                        htmlNodeCopy = strTagName.equals("tfoot") ? new TableFoot(CollectionsKt.emptyList()) : null;
                        break;
                    case 110326868:
                        htmlNodeCopy = strTagName.equals("thead") ? new TableHead(CollectionsKt.emptyList()) : null;
                        break;
                    case 1303202319:
                        htmlNodeCopy = strTagName.equals("blockquote") ? new Blockquote(jsoupAttributes.getClasses(), null, 2, null) : null;
                        break;
                    default:
                        switch (iHashCode) {
                            case 3273:
                                if (strTagName.equals("h1")) {
                                    String strTagName2 = element.tagName();
                                    Intrinsics.checkNotNullExpressionValue(strTagName2, "tagName(...)");
                                    String strSubstring = strTagName2.substring(1);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                    htmlNodeCopy = new Heading(Integer.parseInt(strSubstring), jsoupAttributes.getClasses(), jsoupAttributes.getTextColor(), jsoupAttributes.getBackgroundColor(), jsoupAttributes.getTextAlign(), null, 32, null);
                                } else {
                                    htmlNodeCopy = null;
                                }
                                break;
                            case 3274:
                                if (!strTagName.equals(ApplicationProtocolNames.HTTP_2)) {
                                    htmlNodeCopy = null;
                                    break;
                                }
                                break;
                            case 3275:
                                if (!strTagName.equals("h3")) {
                                    htmlNodeCopy = null;
                                    break;
                                }
                                break;
                            case 3276:
                                if (!strTagName.equals("h4")) {
                                    htmlNodeCopy = null;
                                    break;
                                }
                                break;
                            case 3277:
                                if (!strTagName.equals("h5")) {
                                    htmlNodeCopy = null;
                                    break;
                                }
                                break;
                            case 3278:
                                if (!strTagName.equals("h6")) {
                                    htmlNodeCopy = null;
                                    break;
                                }
                                break;
                            default:
                                htmlNodeCopy = null;
                                break;
                        }
                        break;
                }
            } else if (!strTagName.equals("b")) {
                htmlNodeCopy = null;
            }
        } else {
            htmlNodeCopy = null;
        }
        if (htmlNodeCopy == null) {
            List<Node> listChildNodes2 = element.childNodes();
            Intrinsics.checkNotNullExpressionValue(listChildNodes2, "childNodes(...)");
            ArrayList arrayList2 = new ArrayList();
            for (Node node2 : listChildNodes2) {
                if (node2 instanceof Element) {
                    listEmptyList2 = parseElement((Element) node2, parentHtmlNode);
                } else if (node2 instanceof TextNode) {
                    TextNode textNode = (TextNode) node2;
                    String strText3 = textNode.text();
                    Intrinsics.checkNotNullExpressionValue(strText3, "text(...)");
                    if (StringsKt.isBlank(strText3)) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        String strText4 = textNode.text();
                        Intrinsics.checkNotNullExpressionValue(strText4, "text(...)");
                        TextNode textNode2 = new TextNode(strText4);
                        textNode2.setParent(parentHtmlNode);
                        listEmptyList2 = CollectionsKt.listOf(textNode2);
                    }
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, listEmptyList2);
            }
            return arrayList2;
        }
        if (!(htmlNodeCopy instanceof ParentCapableNode)) {
            htmlNodeCopy.setParent(parentHtmlNode);
            return CollectionsKt.listOf(htmlNodeCopy);
        }
        List<Node> listChildNodes3 = element.childNodes();
        Intrinsics.checkNotNullExpressionValue(listChildNodes3, "childNodes(...)");
        ArrayList arrayList3 = new ArrayList();
        for (Node node3 : listChildNodes3) {
            if (node3 instanceof Element) {
                listEmptyList = parseElement((Element) node3, htmlNodeCopy);
            } else if (node3 instanceof TextNode) {
                TextNode textNode3 = (TextNode) node3;
                String strText5 = textNode3.text();
                Intrinsics.checkNotNullExpressionValue(strText5, "text(...)");
                if (strText5.length() > 0) {
                    String strText6 = textNode3.text();
                    Intrinsics.checkNotNullExpressionValue(strText6, "text(...)");
                    if (!StringsKt.isBlank(strText6)) {
                        String strText7 = textNode3.text();
                        Intrinsics.checkNotNullExpressionValue(strText7, "text(...)");
                        TextNode textNode4 = new TextNode(strText7);
                        textNode4.setParent(htmlNodeCopy);
                        listEmptyList = CollectionsKt.listOf(textNode4);
                    } else if ((htmlNodeCopy instanceof TableHeaderCell) || (htmlNodeCopy instanceof TableCell)) {
                        String strText8 = textNode3.text();
                        Intrinsics.checkNotNullExpressionValue(strText8, "text(...)");
                        TextNode textNode5 = new TextNode(strText8);
                        textNode5.setParent(htmlNodeCopy);
                        listEmptyList = CollectionsKt.listOf(textNode5);
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, listEmptyList);
        }
        if (htmlNodeCopy instanceof Div) {
            htmlNodeCopy = Div.copy$default((Div) htmlNodeCopy, null, null, null, null, null, arrayList3, 31, null);
        } else if (htmlNodeCopy instanceof Pre) {
            htmlNodeCopy = Pre.copy$default((Pre) htmlNodeCopy, null, null, null, null, null, arrayList3, 31, null);
        } else if (htmlNodeCopy instanceof Article) {
            htmlNodeCopy = Article.copy$default((Article) htmlNodeCopy, null, null, null, null, null, arrayList3, 31, null);
        } else if (htmlNodeCopy instanceof Paragraph) {
            htmlNodeCopy = Paragraph.copy$default((Paragraph) htmlNodeCopy, null, null, null, null, arrayList3, 15, null);
        } else if (htmlNodeCopy instanceof Anchor) {
            htmlNodeCopy = Anchor.copy$default((Anchor) htmlNodeCopy, null, null, null, null, null, arrayList3, 31, null);
        } else if (htmlNodeCopy instanceof Span) {
            htmlNodeCopy = Span.copy$default((Span) htmlNodeCopy, null, null, null, null, arrayList3, 15, null);
        } else if (htmlNodeCopy instanceof Bold) {
            htmlNodeCopy = ((Bold) htmlNodeCopy).copy(arrayList3);
        } else if (htmlNodeCopy instanceof Italic) {
            htmlNodeCopy = ((Italic) htmlNodeCopy).copy(arrayList3);
        } else if (htmlNodeCopy instanceof Underline) {
            htmlNodeCopy = ((Underline) htmlNodeCopy).copy(arrayList3);
        } else if (htmlNodeCopy instanceof StrikeThrough) {
            htmlNodeCopy = ((StrikeThrough) htmlNodeCopy).copy(arrayList3);
        } else if (htmlNodeCopy instanceof Heading) {
            htmlNodeCopy = Heading.copy$default((Heading) htmlNodeCopy, 0, null, null, null, null, arrayList3, 31, null);
        } else if (htmlNodeCopy instanceof Table) {
            htmlNodeCopy = Table.copy$default((Table) htmlNodeCopy, null, arrayList3, 1, null);
        } else if (htmlNodeCopy instanceof TableHead) {
            TableHead tableHead = (TableHead) htmlNodeCopy;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                if (obj instanceof TableRow) {
                    arrayList4.add(obj);
                }
            }
            htmlNodeCopy = tableHead.copy(arrayList4);
        } else if (htmlNodeCopy instanceof TableBody) {
            TableBody tableBody = (TableBody) htmlNodeCopy;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (obj2 instanceof TableRow) {
                    arrayList5.add(obj2);
                }
            }
            htmlNodeCopy = tableBody.copy(arrayList5);
        } else if (htmlNodeCopy instanceof TableFoot) {
            TableFoot tableFoot = (TableFoot) htmlNodeCopy;
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : arrayList3) {
                if (obj3 instanceof TableRow) {
                    arrayList6.add(obj3);
                }
            }
            htmlNodeCopy = tableFoot.copy(arrayList6);
        } else if (htmlNodeCopy instanceof TableRow) {
            TableRow tableRow = (TableRow) htmlNodeCopy;
            ArrayList arrayList7 = new ArrayList();
            for (Object obj4 : arrayList3) {
                HtmlNode htmlNode = (HtmlNode) obj4;
                if ((htmlNode instanceof TableHeaderCell) || (htmlNode instanceof TableCell)) {
                    arrayList7.add(obj4);
                }
            }
            htmlNodeCopy = TableRow.copy$default(tableRow, null, arrayList7, 1, null);
        } else if (htmlNodeCopy instanceof TableHeaderCell) {
            htmlNodeCopy = TableHeaderCell.copy$default((TableHeaderCell) htmlNodeCopy, 0, 0, null, arrayList3, 7, null);
        } else if (htmlNodeCopy instanceof TableCell) {
            htmlNodeCopy = TableCell.copy$default((TableCell) htmlNodeCopy, 0, 0, null, null, 0.0f, null, null, arrayList3, 127, null);
        } else if (htmlNodeCopy instanceof Blockquote) {
            htmlNodeCopy = Blockquote.copy$default((Blockquote) htmlNodeCopy, null, arrayList3, 1, null);
        } else if (htmlNodeCopy instanceof UnorderedList) {
            htmlNodeCopy = UnorderedList.copy$default((UnorderedList) htmlNodeCopy, null, parseElement$wrapListTag(arrayList3), 1, null);
        } else if (htmlNodeCopy instanceof OrderedList) {
            htmlNodeCopy = OrderedList.copy$default((OrderedList) htmlNodeCopy, 0, null, parseElement$wrapListTag(arrayList3), 3, null);
        } else if (htmlNodeCopy instanceof ListItem) {
            htmlNodeCopy = ListItem.copy$default((ListItem) htmlNodeCopy, null, arrayList3, 0, 5, null);
        } else if (htmlNodeCopy instanceof Label) {
            htmlNodeCopy = Label.copy$default((Label) htmlNodeCopy, null, null, null, null, null, arrayList3, 31, null);
        } else if (htmlNodeCopy instanceof Subscript) {
            htmlNodeCopy = ((Subscript) htmlNodeCopy).copy(arrayList3);
        } else if (htmlNodeCopy instanceof Superscript) {
            htmlNodeCopy = ((Superscript) htmlNodeCopy).copy(arrayList3);
        }
        htmlNodeCopy.setParent(parentHtmlNode);
        Iterator<T> it = ((ParentCapableNode) htmlNodeCopy).getChildren().iterator();
        while (it.hasNext()) {
            ((HtmlNode) it.next()).setParent(htmlNodeCopy);
        }
        return CollectionsKt.listOf(htmlNodeCopy);
    }

    @NotNull
    public final List<HtmlNode> parseHtmlToNodes$ntBase_release(@NotNull String htmlString) {
        List<HtmlNode> listEmptyList;
        Intrinsics.checkNotNullParameter(htmlString, "htmlString");
        Document document = Jsoup.parse(htmlString);
        HtmlHelper htmlHelper = HtmlHelper.INSTANCE;
        if (htmlHelper.getENABLED_LOG()) {
            Intrinsics.checkNotNull(document);
            String strPrettyPrintHtml = htmlHelper.prettyPrintHtml(document);
            HtmlParserKt.println("input: " + strPrettyPrintHtml.length());
            if (strPrettyPrintHtml.length() > 100000) {
                int i = 0;
                while (i < strPrettyPrintHtml.length()) {
                    int iMin = Math.min(i + 100000, strPrettyPrintHtml.length());
                    String strSubstring = strPrettyPrintHtml.substring(i, iMin);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    HtmlParserKt.println(strSubstring);
                    i = iMin;
                }
            } else {
                HtmlParserKt.println(strPrettyPrintHtml);
            }
        }
        List<Node> listChildNodes = document.body().childNodes();
        Intrinsics.checkNotNullExpressionValue(listChildNodes, "childNodes(...)");
        ArrayList arrayList = new ArrayList();
        for (Node node : listChildNodes) {
            if (node instanceof Element) {
                listEmptyList = parseElement((Element) node, null);
            } else if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                String strText = textNode.text();
                Intrinsics.checkNotNullExpressionValue(strText, "text(...)");
                if (StringsKt.isBlank(strText)) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    String strText2 = textNode.text();
                    Intrinsics.checkNotNullExpressionValue(strText2, "text(...)");
                    TextNode textNode2 = new TextNode(strText2);
                    textNode2.setParent(null);
                    listEmptyList = CollectionsKt.listOf(textNode2);
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, listEmptyList);
        }
        return arrayList;
    }
}
