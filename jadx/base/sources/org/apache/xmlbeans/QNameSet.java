package org.apache.xmlbeans;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.javax.xml.namespace.QName;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class QNameSet implements QNameSetSpecification, Serializable {
    public static final QNameSet ALL;
    public static final QNameSet EMPTY;
    public static final QNameSet LOCAL;
    public static final QNameSet NONLOCAL;
    private static final long serialVersionUID = 1;
    private final Set _excludedQNames;
    private final Set _includedQNames;
    private final Set _includedURIs;
    private final boolean _inverted;

    static {
        Set set = Collections.EMPTY_SET;
        EMPTY = new QNameSet(null, set, set, set);
        ALL = new QNameSet(set, null, set, set);
        LOCAL = new QNameSet(null, Collections.singleton(""), set, set);
        NONLOCAL = new QNameSet(Collections.singleton(""), null, set, set);
    }

    private QNameSet(Set set, Set set2, Set set3, Set set4) {
        if (set2 != null && set == null) {
            this._inverted = false;
            this._includedURIs = set2;
            this._excludedQNames = set3;
            this._includedQNames = set4;
            return;
        }
        if (set == null || set2 != null) {
            throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
        }
        this._inverted = true;
        this._includedURIs = set;
        this._excludedQNames = set4;
        this._includedQNames = set3;
    }

    public static QNameSet forArray(QName[] qNameArr) {
        if (qNameArr == null) {
            throw new IllegalArgumentException("includedQNames cannot be null");
        }
        Set set = Collections.EMPTY_SET;
        return new QNameSet(null, set, set, new HashSet(Arrays.asList(qNameArr)));
    }

    public static QNameSet forSets(Set set, Set set2, Set set3, Set set4) {
        if ((set != null) != (set2 != null)) {
            return (set == null && set2.isEmpty() && set4.isEmpty()) ? EMPTY : (set2 == null && set.isEmpty() && set3.isEmpty()) ? ALL : (set == null && set2.size() == 1 && set2.contains("") && set4.isEmpty() && set3.isEmpty()) ? LOCAL : (set2 == null && set.size() == 1 && set.contains("") && set3.isEmpty() && set4.isEmpty()) ? NONLOCAL : new QNameSet(minSetCopy(set), minSetCopy(set2), minSetCopy(set3), minSetCopy(set4));
        }
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    }

    public static QNameSet forSpecification(QNameSetSpecification qNameSetSpecification) {
        return qNameSetSpecification instanceof QNameSet ? (QNameSet) qNameSetSpecification : forSets(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
    }

    public static QNameSet forWildcardNamespaceString(String str, String str2) {
        return forSpecification(new QNameSetBuilder(str, str2));
    }

    private boolean isDisjointImpl(QNameSetSpecification qNameSetSpecification, QNameSetSpecification qNameSetSpecification2) {
        Set setIncludedURIs = qNameSetSpecification.includedURIs();
        Set setIncludedURIs2 = qNameSetSpecification2.includedURIs();
        if (setIncludedURIs2 != null) {
            Iterator it = setIncludedURIs.iterator();
            while (it.hasNext()) {
                if (setIncludedURIs2.contains(it.next())) {
                    return false;
                }
            }
        } else {
            Set setExcludedURIs = qNameSetSpecification2.excludedURIs();
            Iterator it2 = setIncludedURIs.iterator();
            while (it2.hasNext()) {
                if (!setExcludedURIs.contains(it2.next())) {
                    return false;
                }
            }
        }
        Iterator it3 = qNameSetSpecification.includedQNamesInExcludedURIs().iterator();
        while (it3.hasNext()) {
            if (qNameSetSpecification2.contains((QName) it3.next())) {
                return false;
            }
        }
        if (setIncludedURIs.size() <= 0) {
            return true;
        }
        Iterator it4 = qNameSetSpecification2.includedQNamesInExcludedURIs().iterator();
        while (it4.hasNext()) {
            if (qNameSetSpecification.contains((QName) it4.next())) {
                return false;
            }
        }
        return true;
    }

    private static Set minSetCopy(Set set) {
        if (set == null) {
            return null;
        }
        return set.isEmpty() ? Collections.EMPTY_SET : set.size() == 1 ? Collections.singleton(set.iterator().next()) : new HashSet(set);
    }

    private static String nsFromName(QName qName) {
        String namespaceURI = qName.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    private String prettyQName(QName qName) {
        if (qName.getNamespaceURI() == null) {
            return qName.getLocalPart();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(qName.getLocalPart());
        stringBuffer.append(Log.TAG_SEPARATOR);
        stringBuffer.append(qName.getNamespaceURI());
        return stringBuffer.toString();
    }

    public static QNameSet singleton(QName qName) {
        Set set = Collections.EMPTY_SET;
        return new QNameSet(null, set, set, Collections.singleton(qName));
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean contains(QName qName) {
        return (this._includedURIs.contains(nsFromName(qName)) ? !this._excludedQNames.contains(qName) : this._includedQNames.contains(qName)) ^ this._inverted;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean containsAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted || qNameSetSpecification.excludedURIs() == null) {
            return inverse().isDisjoint(qNameSetSpecification);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set excludedQNamesInIncludedURIs() {
        return Collections.unmodifiableSet(this._inverted ? this._includedQNames : this._excludedQNames);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set excludedURIs() {
        if (this._inverted) {
            return Collections.unmodifiableSet(this._includedURIs);
        }
        return null;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set includedQNamesInExcludedURIs() {
        return Collections.unmodifiableSet(this._inverted ? this._excludedQNames : this._includedQNames);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set includedURIs() {
        if (this._inverted) {
            return null;
        }
        return this._includedURIs;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet intersect(QNameSetSpecification qNameSetSpecification) {
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
        qNameSetBuilder.restrict(qNameSetSpecification);
        return qNameSetBuilder.toQNameSet();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet inverse() {
        QNameSet qNameSet = EMPTY;
        if (this == qNameSet) {
            return ALL;
        }
        if (this == ALL) {
            return qNameSet;
        }
        QNameSet qNameSet2 = LOCAL;
        return this == qNameSet2 ? NONLOCAL : this == NONLOCAL ? qNameSet2 : new QNameSet(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isAll() {
        return this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isDisjoint(QNameSetSpecification qNameSetSpecification) {
        if (!this._inverted || qNameSetSpecification.excludedURIs() == null) {
            return this._inverted ? isDisjointImpl(qNameSetSpecification, this) : isDisjointImpl(this, qNameSetSpecification);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isEmpty() {
        return !this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("QNameSet");
        stringBuffer.append(this._inverted ? "-(" : "+(");
        Iterator it = this._includedURIs.iterator();
        while (it.hasNext()) {
            stringBuffer.append("+*@");
            stringBuffer.append(it.next());
            stringBuffer.append(SQLKeyword.COMMA);
        }
        Iterator it2 = this._excludedQNames.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            stringBuffer.append(prettyQName((QName) it2.next()));
            stringBuffer.append(SQLKeyword.COMMA);
        }
        Iterator it3 = this._includedQNames.iterator();
        while (it3.hasNext()) {
            stringBuffer.append(Marker.ANY_NON_NULL_MARKER);
            stringBuffer.append(prettyQName((QName) it3.next()));
            stringBuffer.append(SQLKeyword.COMMA);
        }
        int iLastIndexOf = stringBuffer.lastIndexOf(SQLKeyword.COMMA);
        if (iLastIndexOf > 0) {
            stringBuffer.setLength(iLastIndexOf);
        }
        stringBuffer.append(PropertyUtils.MAPPED_DELIM2);
        return stringBuffer.toString();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet union(QNameSetSpecification qNameSetSpecification) {
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
        qNameSetBuilder.addAll(qNameSetSpecification);
        return qNameSetBuilder.toQNameSet();
    }
}
