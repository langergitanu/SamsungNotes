package org.jsoup.select;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class QueryParser {
    private List<Evaluator> evals = new ArrayList();
    private String query;

    /* JADX INFO: renamed from: tq */
    private TokenQueue f10202tq;
    private static final String[] combinators = {",", ">", Marker.ANY_NON_NULL_MARKER, "~", " "};
    private static final String[] AttributeEvals = {MarketingConstants.REFERRER_DELIMITER_U003D, "!=", "^=", "$=", "*=", "~="};
    private static final Pattern NTH_AB = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
    private static final Pattern NTH_B = Pattern.compile("(\\+|-)?(\\d+)");

    private QueryParser(String str) {
        this.query = str;
        this.f10202tq = new TokenQueue(str);
    }

    private void allElements() {
        this.evals.add(new Evaluator.AllElements());
    }

    private void byAttribute() {
        TokenQueue tokenQueue = new TokenQueue(this.f10202tq.chompBalanced(PropertyUtils.INDEXED_DELIM, PropertyUtils.INDEXED_DELIM2));
        String strConsumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(strConsumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (strConsumeToAny.startsWith("^")) {
                this.evals.add(new Evaluator.AttributeStarting(strConsumeToAny.substring(1)));
                return;
            } else {
                this.evals.add(new Evaluator.Attribute(strConsumeToAny));
                return;
            }
        }
        if (tokenQueue.matchChomp(MarketingConstants.REFERRER_DELIMITER_U003D)) {
            this.evals.add(new Evaluator.AttributeWithValue(strConsumeToAny, tokenQueue.remainder()));
            return;
        }
        if (tokenQueue.matchChomp("!=")) {
            this.evals.add(new Evaluator.AttributeWithValueNot(strConsumeToAny, tokenQueue.remainder()));
            return;
        }
        if (tokenQueue.matchChomp("^=")) {
            this.evals.add(new Evaluator.AttributeWithValueStarting(strConsumeToAny, tokenQueue.remainder()));
            return;
        }
        if (tokenQueue.matchChomp("$=")) {
            this.evals.add(new Evaluator.AttributeWithValueEnding(strConsumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("*=")) {
            this.evals.add(new Evaluator.AttributeWithValueContaining(strConsumeToAny, tokenQueue.remainder()));
        } else {
            if (!tokenQueue.matchChomp("~=")) {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
            }
            this.evals.add(new Evaluator.AttributeWithValueMatching(strConsumeToAny, Pattern.compile(tokenQueue.remainder())));
        }
    }

    private void byClass() {
        String strConsumeCssIdentifier = this.f10202tq.consumeCssIdentifier();
        Validate.notEmpty(strConsumeCssIdentifier);
        this.evals.add(new Evaluator.Class(strConsumeCssIdentifier.trim().toLowerCase()));
    }

    private void byId() {
        String strConsumeCssIdentifier = this.f10202tq.consumeCssIdentifier();
        Validate.notEmpty(strConsumeCssIdentifier);
        this.evals.add(new Evaluator.C14355Id(strConsumeCssIdentifier));
    }

    private void byTag() {
        String strConsumeElementSelector = this.f10202tq.consumeElementSelector();
        Validate.notEmpty(strConsumeElementSelector);
        if (strConsumeElementSelector.contains("|")) {
            strConsumeElementSelector = strConsumeElementSelector.replace("|", ":");
        }
        this.evals.add(new Evaluator.Tag(strConsumeElementSelector.trim().toLowerCase()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void combinator(char c) {
        Evaluator and;
        Evaluator evaluator;
        boolean z;
        Evaluator and2;
        Evaluator evaluator2;
        this.f10202tq.consumeWhitespace();
        Evaluator evaluator3 = parse(consumeSubQuery());
        if (this.evals.size() == 1) {
            and = this.evals.get(0);
            if ((and instanceof CombiningEvaluator.C14354Or) && c != ',') {
                evaluator = and;
                and = ((CombiningEvaluator.C14354Or) and).rightMostEvaluator();
                z = true;
            }
            this.evals.clear();
            if (c != '>') {
                and2 = new CombiningEvaluator.And(evaluator3, new StructuralEvaluator.ImmediateParent(and));
            } else if (c == ' ') {
                and2 = new CombiningEvaluator.And(evaluator3, new StructuralEvaluator.Parent(and));
            } else if (c == '+') {
                and2 = new CombiningEvaluator.And(evaluator3, new StructuralEvaluator.ImmediatePreviousSibling(and));
            } else if (c == '~') {
                and2 = new CombiningEvaluator.And(evaluator3, new StructuralEvaluator.PreviousSibling(and));
            } else {
                if (c != ',') {
                    throw new Selector.SelectorParseException("Unknown combinator: " + c, new Object[0]);
                }
                if (and instanceof CombiningEvaluator.C14354Or) {
                    CombiningEvaluator.C14354Or c14354Or = (CombiningEvaluator.C14354Or) and;
                    c14354Or.add(evaluator3);
                    and2 = c14354Or;
                } else {
                    CombiningEvaluator.C14354Or c14354Or2 = new CombiningEvaluator.C14354Or();
                    c14354Or2.add(and);
                    c14354Or2.add(evaluator3);
                    and2 = c14354Or2;
                }
            }
            if (z) {
                evaluator2 = and2;
            } else {
                ((CombiningEvaluator.C14354Or) evaluator).replaceRightMostEvaluator(and2);
                evaluator2 = evaluator;
            }
            this.evals.add(evaluator2);
        }
        and = new CombiningEvaluator.And(this.evals);
        evaluator = and;
        z = false;
        this.evals.clear();
        if (c != '>') {
        }
        if (z) {
        }
        this.evals.add(evaluator2);
    }

    private int consumeIndex() {
        String strTrim = this.f10202tq.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(strTrim), "Index must be numeric");
        return Integer.parseInt(strTrim);
    }

    private String consumeSubQuery() {
        StringBuilder sb = new StringBuilder();
        while (!this.f10202tq.isEmpty()) {
            if (this.f10202tq.matches("(")) {
                sb.append("(");
                sb.append(this.f10202tq.chompBalanced(PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2));
                sb.append(")");
            } else if (this.f10202tq.matches("[")) {
                sb.append("[");
                sb.append(this.f10202tq.chompBalanced(PropertyUtils.INDEXED_DELIM, PropertyUtils.INDEXED_DELIM2));
                sb.append("]");
            } else {
                if (this.f10202tq.matchesAny(combinators)) {
                    break;
                }
                sb.append(this.f10202tq.consume());
            }
        }
        return sb.toString();
    }

    private void contains(boolean z) {
        this.f10202tq.consume(z ? ":containsOwn" : ":contains");
        String strUnescape = TokenQueue.unescape(this.f10202tq.chompBalanced(PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2));
        Validate.notEmpty(strUnescape, ":contains(text) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.ContainsOwnText(strUnescape));
        } else {
            this.evals.add(new Evaluator.ContainsText(strUnescape));
        }
    }

    private void cssNthChild(boolean z, boolean z2) {
        String lowerCase = this.f10202tq.chompTo(")").trim().toLowerCase();
        Matcher matcher = NTH_AB.matcher(lowerCase);
        Matcher matcher2 = NTH_B.matcher(lowerCase);
        int i = 2;
        int i2 = 1;
        if (!"odd".equals(lowerCase)) {
            if ("even".equals(lowerCase)) {
                i2 = 0;
            } else if (matcher.matches()) {
                int i4 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                i2 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i = i4;
            } else {
                if (!matcher2.matches()) {
                    throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", lowerCase);
                }
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            }
        }
        if (z2) {
            if (z) {
                this.evals.add(new Evaluator.IsNthLastOfType(i, i2));
                return;
            } else {
                this.evals.add(new Evaluator.IsNthOfType(i, i2));
                return;
            }
        }
        if (z) {
            this.evals.add(new Evaluator.IsNthLastChild(i, i2));
        } else {
            this.evals.add(new Evaluator.IsNthChild(i, i2));
        }
    }

    private void findElements() {
        if (this.f10202tq.matchChomp(ContentUtils.HASH_SYMBOL)) {
            byId();
            return;
        }
        if (this.f10202tq.matchChomp(Extension.DOT)) {
            byClass();
            return;
        }
        if (this.f10202tq.matchesWord()) {
            byTag();
            return;
        }
        if (this.f10202tq.matches("[")) {
            byAttribute();
            return;
        }
        if (this.f10202tq.matchChomp("*")) {
            allElements();
            return;
        }
        if (this.f10202tq.matchChomp(":lt(")) {
            indexLessThan();
            return;
        }
        if (this.f10202tq.matchChomp(":gt(")) {
            indexGreaterThan();
            return;
        }
        if (this.f10202tq.matchChomp(":eq(")) {
            indexEquals();
            return;
        }
        if (this.f10202tq.matches(":has(")) {
            has();
            return;
        }
        if (this.f10202tq.matches(":contains(")) {
            contains(false);
            return;
        }
        if (this.f10202tq.matches(":containsOwn(")) {
            contains(true);
            return;
        }
        if (this.f10202tq.matches(":matches(")) {
            matches(false);
            return;
        }
        if (this.f10202tq.matches(":matchesOwn(")) {
            matches(true);
            return;
        }
        if (this.f10202tq.matches(":not(")) {
            not();
            return;
        }
        if (this.f10202tq.matchChomp(":nth-child(")) {
            cssNthChild(false, false);
            return;
        }
        if (this.f10202tq.matchChomp(":nth-last-child(")) {
            cssNthChild(true, false);
            return;
        }
        if (this.f10202tq.matchChomp(":nth-of-type(")) {
            cssNthChild(false, true);
            return;
        }
        if (this.f10202tq.matchChomp(":nth-last-of-type(")) {
            cssNthChild(true, true);
            return;
        }
        if (this.f10202tq.matchChomp(":first-child")) {
            this.evals.add(new Evaluator.IsFirstChild());
            return;
        }
        if (this.f10202tq.matchChomp(":last-child")) {
            this.evals.add(new Evaluator.IsLastChild());
            return;
        }
        if (this.f10202tq.matchChomp(":first-of-type")) {
            this.evals.add(new Evaluator.IsFirstOfType());
            return;
        }
        if (this.f10202tq.matchChomp(":last-of-type")) {
            this.evals.add(new Evaluator.IsLastOfType());
            return;
        }
        if (this.f10202tq.matchChomp(":only-child")) {
            this.evals.add(new Evaluator.IsOnlyChild());
            return;
        }
        if (this.f10202tq.matchChomp(":only-of-type")) {
            this.evals.add(new Evaluator.IsOnlyOfType());
        } else if (this.f10202tq.matchChomp(":empty")) {
            this.evals.add(new Evaluator.IsEmpty());
        } else {
            if (!this.f10202tq.matchChomp(":root")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.f10202tq.remainder());
            }
            this.evals.add(new Evaluator.IsRoot());
        }
    }

    private void has() {
        this.f10202tq.consume(":has");
        String strChompBalanced = this.f10202tq.chompBalanced(PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2);
        Validate.notEmpty(strChompBalanced, ":has(el) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Has(parse(strChompBalanced)));
    }

    private void indexEquals() {
        this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
    }

    private void indexGreaterThan() {
        this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
    }

    private void indexLessThan() {
        this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
    }

    private void matches(boolean z) {
        this.f10202tq.consume(z ? ":matchesOwn" : ":matches");
        String strChompBalanced = this.f10202tq.chompBalanced(PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2);
        Validate.notEmpty(strChompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.MatchesOwn(Pattern.compile(strChompBalanced)));
        } else {
            this.evals.add(new Evaluator.Matches(Pattern.compile(strChompBalanced)));
        }
    }

    private void not() {
        this.f10202tq.consume(":not");
        String strChompBalanced = this.f10202tq.chompBalanced(PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2);
        Validate.notEmpty(strChompBalanced, ":not(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Not(parse(strChompBalanced)));
    }

    public static Evaluator parse(String str) {
        return new QueryParser(str).parse();
    }

    public Evaluator parse() {
        this.f10202tq.consumeWhitespace();
        if (this.f10202tq.matchesAny(combinators)) {
            this.evals.add(new StructuralEvaluator.Root());
            combinator(this.f10202tq.consume());
        } else {
            findElements();
        }
        while (!this.f10202tq.isEmpty()) {
            boolean zConsumeWhitespace = this.f10202tq.consumeWhitespace();
            if (this.f10202tq.matchesAny(combinators)) {
                combinator(this.f10202tq.consume());
            } else if (zConsumeWhitespace) {
                combinator(' ');
            } else {
                findElements();
            }
        }
        if (this.evals.size() == 1) {
            return this.evals.get(0);
        }
        return new CombiningEvaluator.And(this.evals);
    }
}
