package org.apache.xmlbeans.impl.schema;

import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.QNameSetSpecification;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StscComplexTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int ANY_ATTRIBUTE_CODE = 102;
    private static final int ATTRIBUTE_CODE = 100;
    private static final int ATTRIBUTE_GROUP_CODE = 101;
    private static final int MODEL_GROUP_CODE = 100;
    private static Map attributeCodeMap;
    private static CodeForNameEntry[] attributeCodes;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscComplexTypeResolver;
    private static Map particleCodeMap;
    private static CodeForNameEntry[] particleCodes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CodeForNameEntry {
        public int code;
        public QName name;

        public CodeForNameEntry(QName qName, int i) {
            this.name = qName;
            this.code = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RedefinitionForGroup {
        private SchemaModelGroupImpl group;
        private boolean seenRedefinition = false;

        public RedefinitionForGroup(SchemaModelGroupImpl schemaModelGroupImpl) {
            this.group = schemaModelGroupImpl;
        }

        public SchemaModelGroupImpl getGroup() {
            return this.group;
        }

        public boolean isSeenRedefinition() {
            return this.seenRedefinition;
        }

        public void setSeenRedefinition(boolean z) {
            this.seenRedefinition = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WildcardResult {
        boolean hasWildcards;
        QNameSet typedWildcards;

        public WildcardResult(QNameSet qNameSet, boolean z) {
            this.typedWildcards = qNameSet;
            this.hasWildcards = z;
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscComplexTypeResolver == null) {
            class$org$apache$xmlbeans$impl$schema$StscComplexTypeResolver = class$("org.apache.xmlbeans.impl.schema.StscComplexTypeResolver");
        }
        $assertionsDisabled = true;
        particleCodes = new CodeForNameEntry[]{new CodeForNameEntry(QNameHelper.forLNS("all", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("element", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("any", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("group", "http://www.w3.org/2001/XMLSchema"), 100)};
        particleCodeMap = buildParticleCodeMap();
        attributeCodes = new CodeForNameEntry[]{new CodeForNameEntry(QNameHelper.forLNS("attribute", "http://www.w3.org/2001/XMLSchema"), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", "http://www.w3.org/2001/XMLSchema"), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", "http://www.w3.org/2001/XMLSchema"), 102)};
        attributeCodeMap = buildAttributeCodeMap();
    }

    public static void addMinusPointlessParticles(List list, SchemaParticle schemaParticle, int i) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 2) {
            if (particleType == 3 && i == 3 && schemaParticle.isSingleton()) {
                list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
                return;
            }
        } else if (i == 2 && schemaParticle.isSingleton()) {
            list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
            return;
        }
        list.add(schemaParticle);
    }

    private static boolean afterMapSubsumedByStartMap(Map map, Map map2) {
        if (map2.size() > map.size()) {
            return false;
        }
        if (map2.isEmpty()) {
            return true;
        }
        for (SchemaParticle schemaParticle : map.keySet()) {
            if (schemaParticle.getParticleType() == 5 && map2.containsKey(schemaParticle) && !((QNameSet) map.get(schemaParticle)).containsAll((QNameSet) map2.get(schemaParticle))) {
                return false;
            }
            map2.remove(schemaParticle);
            if (map2.isEmpty()) {
                return true;
            }
        }
        return map2.isEmpty();
    }

    private static Map buildAttributeCodeMap() {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = attributeCodes;
            if (i >= codeForNameEntryArr.length) {
                return map;
            }
            CodeForNameEntry codeForNameEntry = codeForNameEntryArr[i];
            map.put(codeForNameEntry.name, new Integer(codeForNameEntry.code));
            i++;
        }
    }

    public static Map buildAttributePropertyModelByQName(SchemaAttributeModel schemaAttributeModel, SchemaType schemaType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SchemaLocalAttribute[] attributes = schemaAttributeModel.getAttributes();
        for (int i = 0; i < attributes.length; i++) {
            linkedHashMap.put(attributes[i].getName(), buildUseProperty(attributes[i], schemaType));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.LinkedHashMap, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map buildContentPropertyModelByQName(SchemaParticle schemaParticle, SchemaType schemaType) {
        ?? linkedHashMap;
        Map mapBuildElementPropertyModel;
        if (schemaParticle == null) {
            return Collections.EMPTY_MAP;
        }
        int particleType = schemaParticle.getParticleType();
        boolean z = true;
        if (particleType == 1) {
            linkedHashMap = 0;
        } else {
            if (particleType != 2) {
                if (particleType != 3) {
                    if (particleType == 4) {
                        mapBuildElementPropertyModel = buildElementPropertyModel((SchemaLocalElement) schemaParticle, schemaType);
                    } else {
                        if (particleType != 5) {
                            if ($assertionsDisabled) {
                                throw new IllegalStateException();
                            }
                            throw new AssertionError();
                        }
                        mapBuildElementPropertyModel = Collections.EMPTY_MAP;
                    }
                }
                linkedHashMap = 0;
            } else {
                mapBuildElementPropertyModel = null;
            }
            z = false;
            linkedHashMap = mapBuildElementPropertyModel;
        }
        if (linkedHashMap == 0) {
            linkedHashMap = new LinkedHashMap();
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                for (SchemaProperty schemaProperty : buildContentPropertyModelByQName(schemaParticle2, schemaType).values()) {
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) linkedHashMap.get(schemaProperty.getName());
                    if (schemaPropertyImpl == null) {
                        if (!z) {
                            ((SchemaPropertyImpl) schemaProperty).setMinOccurs(BigInteger.ZERO);
                        }
                        linkedHashMap.put(schemaProperty.getName(), schemaProperty);
                    } else {
                        if (!$assertionsDisabled && !schemaPropertyImpl.getType().equals(schemaProperty.getType())) {
                            throw new AssertionError();
                        }
                        mergeProperties(schemaPropertyImpl, schemaProperty, z);
                    }
                }
            }
            BigInteger minOccurs = schemaParticle.getMinOccurs();
            BigInteger maxOccurs = schemaParticle.getMaxOccurs();
            for (SchemaProperty schemaProperty2 : linkedHashMap.values()) {
                BigInteger minOccurs2 = schemaProperty2.getMinOccurs();
                BigInteger maxOccurs2 = schemaProperty2.getMaxOccurs();
                BigInteger bigIntegerMultiply = minOccurs2.multiply(minOccurs);
                if (maxOccurs != null) {
                    BigInteger bigInteger = BigInteger.ZERO;
                    if (maxOccurs.equals(bigInteger)) {
                        maxOccurs2 = bigInteger;
                    } else if (maxOccurs2 != null && !maxOccurs2.equals(BigInteger.ZERO)) {
                        maxOccurs2 = maxOccurs == null ? null : maxOccurs2.multiply(maxOccurs);
                    }
                }
                SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaProperty2;
                schemaPropertyImpl2.setMinOccurs(bigIntegerMultiply);
                schemaPropertyImpl2.setMaxOccurs(maxOccurs2);
            }
        }
        return linkedHashMap;
    }

    public static Map buildElementPropertyModel(SchemaLocalElement schemaLocalElement, SchemaType schemaType) {
        HashMap map = new HashMap(1);
        SchemaProperty schemaPropertyBuildUseProperty = buildUseProperty(schemaLocalElement, schemaType);
        map.put(schemaPropertyBuildUseProperty.getName(), schemaPropertyBuildUseProperty);
        return map;
    }

    private static Map buildParticleCodeMap() {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = particleCodes;
            if (i >= codeForNameEntryArr.length) {
                return map;
            }
            CodeForNameEntry codeForNameEntry = codeForNameEntryArr[i];
            map.put(codeForNameEntry.name, new Integer(codeForNameEntry.code));
            i++;
        }
    }

    public static void buildStateMachine(SchemaParticle schemaParticle) {
        boolean zAfterMapSubsumedByStartMap;
        boolean z;
        if (schemaParticle == null) {
            return;
        }
        SchemaParticleImpl schemaParticleImpl = (SchemaParticleImpl) schemaParticle;
        if (schemaParticleImpl.hasTransitionNotes()) {
            return;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        boolean z2 = schemaParticleImpl.getMinOccurs().signum() == 0;
        int particleType = schemaParticleImpl.getParticleType();
        if (particleType != 1) {
            if (particleType == 2) {
                SchemaParticle[] schemaParticleArrEnsureStateMachine = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                z = false;
                for (int i = 0; !z && i < schemaParticleArrEnsureStateMachine.length; i++) {
                    if (schemaParticleArrEnsureStateMachine[i].isSkippable()) {
                        z = true;
                    }
                }
                zAfterMapSubsumedByStartMap = true;
                for (int i2 = 0; zAfterMapSubsumedByStartMap && i2 < schemaParticleArrEnsureStateMachine.length; i2++) {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine[i2]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                }
                for (int i4 = 0; i4 < schemaParticleArrEnsureStateMachine.length; i4++) {
                    if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticleArrEnsureStateMachine[i4].acceptedStartNames())) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                    qNameSetBuilder.addAll(schemaParticleArrEnsureStateMachine[i4].acceptedStartNames());
                    qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine[i4]).getExcludeNextSet());
                }
            } else if (particleType != 3) {
                if (particleType != 4) {
                    if (particleType != 5) {
                        throw new IllegalStateException("Unrecognized schema particle");
                    }
                    qNameSetBuilder.addAll(schemaParticleImpl.getWildcardSet());
                } else if (schemaParticleImpl.hasTransitionRules()) {
                    qNameSetBuilder.addAll(schemaParticleImpl.acceptedStartNames());
                } else {
                    qNameSetBuilder.add(schemaParticleImpl.getName());
                }
                zAfterMapSubsumedByStartMap = true;
            } else {
                SchemaParticle[] schemaParticleArrEnsureStateMachine2 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                z = true;
                for (int i5 = 0; z && i5 < schemaParticleArrEnsureStateMachine2.length; i5++) {
                    if (!schemaParticleArrEnsureStateMachine2[i5].isSkippable()) {
                        z = false;
                    }
                }
                zAfterMapSubsumedByStartMap = true;
                for (int i6 = 0; zAfterMapSubsumedByStartMap && i6 < schemaParticleArrEnsureStateMachine2.length; i6++) {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i6]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                }
                for (int i7 = 1; i7 < schemaParticleArrEnsureStateMachine2.length; i7++) {
                    qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i7 - 1]).getExcludeNextSet());
                    if (zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(schemaParticleArrEnsureStateMachine2[i7].acceptedStartNames())) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                    if (schemaParticleArrEnsureStateMachine2[i7].isSkippable()) {
                        qNameSetBuilder2.addAll(schemaParticleArrEnsureStateMachine2[i7].acceptedStartNames());
                    } else {
                        qNameSetBuilder2.clear();
                    }
                }
                for (int i8 = 0; i8 < schemaParticleArrEnsureStateMachine2.length; i8++) {
                    qNameSetBuilder.addAll(schemaParticleArrEnsureStateMachine2[i8].acceptedStartNames());
                    if (!schemaParticleArrEnsureStateMachine2[i8].isSkippable()) {
                        break;
                    }
                }
            }
            z2 = z;
        } else {
            SchemaParticle[] schemaParticleArrEnsureStateMachine3 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            boolean z3 = true;
            for (int i9 = 0; z3 && i9 < schemaParticleArrEnsureStateMachine3.length; i9++) {
                if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i9]).isDeterministic()) {
                    z3 = false;
                }
            }
            zAfterMapSubsumedByStartMap = z3;
            for (int i10 = 0; i10 < schemaParticleArrEnsureStateMachine3.length; i10++) {
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticleArrEnsureStateMachine3[i10].acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                qNameSetBuilder.addAll(schemaParticleArrEnsureStateMachine3[i10].acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i10]).getExcludeNextSet());
            }
            qNameSetBuilder2.addAll(qNameSetBuilder);
            z2 = true;
        }
        BigInteger minOccurs = schemaParticleImpl.getMinOccurs();
        BigInteger maxOccurs = schemaParticleImpl.getMaxOccurs();
        boolean z4 = maxOccurs == null || maxOccurs.compareTo(BigInteger.ONE) > 0;
        boolean z5 = maxOccurs == null || minOccurs.compareTo(maxOccurs) < 0;
        if (z4 && zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(qNameSetBuilder)) {
            QNameSet qNameSetIntersect = qNameSetBuilder2.intersect(qNameSetBuilder);
            HashMap map = new HashMap();
            particlesMatchingStart(schemaParticleImpl, qNameSetIntersect, map, new QNameSetBuilder());
            HashMap map2 = new HashMap();
            particlesMatchingAfter(schemaParticleImpl, qNameSetIntersect, map2, new QNameSetBuilder(), true);
            zAfterMapSubsumedByStartMap = afterMapSubsumedByStartMap(map, map2);
        }
        if (z5) {
            qNameSetBuilder2.addAll(qNameSetBuilder);
        }
        schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), z2 || minOccurs.signum() == 0);
        schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), zAfterMapSubsumedByStartMap);
    }

    public static SchemaProperty buildUseProperty(SchemaField schemaField, SchemaType schemaType) {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(schemaField.getName());
        schemaPropertyImpl.setContainerTypeRef(schemaType.getRef());
        schemaPropertyImpl.setTypeRef(schemaField.getType().getRef());
        schemaPropertyImpl.setAttribute(schemaField.isAttribute());
        schemaPropertyImpl.setDefault(schemaField.isDefault() ? 2 : 0);
        schemaPropertyImpl.setFixed(schemaField.isFixed() ? 2 : 0);
        schemaPropertyImpl.setNillable(schemaField.isNillable() ? 2 : 0);
        schemaPropertyImpl.setDefaultText(schemaField.getDefaultText());
        schemaPropertyImpl.setMinOccurs(schemaField.getMinOccurs());
        schemaPropertyImpl.setMaxOccurs(schemaField.getMaxOccurs());
        if (schemaField instanceof SchemaLocalElementImpl) {
            schemaPropertyImpl.setAcceptedNames(((SchemaLocalElementImpl) schemaField).acceptedStartNames());
        }
        return schemaPropertyImpl;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static SchemaParticle[] ensureStateMachine(SchemaParticle[] schemaParticleArr) {
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            buildStateMachine(schemaParticle);
        }
        return schemaParticleArr;
    }

    public static SchemaParticle extendContentModel(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, XmlObject xmlObject) {
        if (schemaParticle2 == null) {
            return schemaParticle;
        }
        if (schemaParticle == null) {
            return schemaParticle2;
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        ArrayList arrayList = new ArrayList();
        addMinusPointlessParticles(arrayList, schemaParticle, 3);
        addMinusPointlessParticles(arrayList, schemaParticle2, 3);
        BigInteger bigInteger = BigInteger.ONE;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigInteger);
        schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[arrayList.size()]));
        return filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject);
    }

    public static Map extractElementModel(SchemaType schemaType) {
        HashMap map = new HashMap();
        if (schemaType != null) {
            SchemaProperty[] properties = schemaType.getProperties();
            for (int i = 0; i < properties.length; i++) {
                if (!properties[i].isAttribute()) {
                    map.put(properties[i].getName(), properties[i].getType());
                }
            }
        }
        return map;
    }

    public static BigInteger extractMaxOccurs(AllNNI allNNI) {
        if (allNNI == null) {
            return BigInteger.ONE;
        }
        if (allNNI.instanceType().getPrimitiveType().getBuiltinTypeCode() == 11) {
            return ((XmlInteger) allNNI).getBigIntegerValue();
        }
        return null;
    }

    public static BigInteger extractMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        if (xmlNonNegativeInteger == null) {
            return BigInteger.ONE;
        }
        BigInteger bigIntegerValue = xmlNonNegativeInteger.getBigIntegerValue();
        return bigIntegerValue == null ? BigInteger.ONE : bigIntegerValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SchemaParticle filterPointlessParticlesAndVerifyAllParticles(SchemaParticle schemaParticle, XmlObject xmlObject) {
        boolean z;
        if (schemaParticle.getMaxOccurs() != null && schemaParticle.getMaxOccurs().signum() == 0) {
            return null;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            if (schemaParticle.getParticleChildren().length != 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
            z = schemaParticle.getParticleType() != 1;
            if (z && (schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_MIN_MAX_1_PARTICLE, (Object[]) null, xmlObject);
            }
            for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
                SchemaParticle particleChild = schemaParticle.getParticleChild(i);
                if (particleChild.getParticleType() == 1) {
                    StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_COMPLEX_TYPE_DEF_PARTICLE, (Object[]) null, xmlObject);
                } else if (z && (particleChild.getParticleType() != 4 || particleChild.getMaxOccurs() == null || particleChild.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
                    StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$CHILD_PARTICLES_MAX_LTE_1, (Object[]) null, xmlObject);
                }
            }
        } else if (particleType != 2) {
            if (particleType != 3) {
                if (particleType != 4 && particleType != 5) {
                    if ($assertionsDisabled) {
                        throw new IllegalStateException();
                    }
                    throw new AssertionError();
                }
            }
            if (schemaParticle.getParticleChildren().length != 0) {
            }
        } else {
            if (schemaParticle.getParticleChildren().length == 0 && schemaParticle.getMinOccurs().compareTo(BigInteger.ZERO) == 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
            if (schemaParticle.getParticleType() != 1) {
            }
            if (z) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_MIN_MAX_1_PARTICLE, (Object[]) null, xmlObject);
            }
            while (i < schemaParticle.countOfParticleChild()) {
            }
        }
        return schemaParticle;
    }

    public static Group getContentModel(ComplexType complexType) {
        if (complexType.getAll() != null) {
            return complexType.getAll();
        }
        if (complexType.getSequence() != null) {
            return complexType.getSequence();
        }
        if (complexType.getChoice() != null) {
            return complexType.getChoice();
        }
        if (complexType.getGroup() != null) {
            return complexType.getGroup();
        }
        return null;
    }

    public static SchemaDocument.Schema getSchema(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.toParent()) {
            try {
                SchemaDocument.Schema object = xmlCursorNewCursor.getObject();
                if (object.schemaType().equals(SchemaDocument.Schema.type)) {
                    return object;
                }
            } finally {
                xmlCursorNewCursor.dispose();
            }
        }
        xmlCursorNewCursor.dispose();
        return null;
    }

    private static SchemaType.Ref[] makeRefArray(Collection collection) {
        SchemaType.Ref[] refArr = new SchemaType.Ref[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            refArr[i] = ((SchemaType) it.next()).getRef();
            i++;
        }
        return refArr;
    }

    public static void mergeProperties(SchemaPropertyImpl schemaPropertyImpl, SchemaProperty schemaProperty, boolean z) {
        BigInteger bigIntegerMin;
        BigInteger bigIntegerMax;
        BigInteger minOccurs = schemaPropertyImpl.getMinOccurs();
        BigInteger maxOccurs = schemaPropertyImpl.getMaxOccurs();
        if (z) {
            bigIntegerMin = minOccurs.add(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() != null) {
                    bigIntegerMax = maxOccurs.add(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
                maxOccurs = null;
            }
        } else {
            bigIntegerMin = minOccurs.min(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() != null) {
                    bigIntegerMax = maxOccurs.max(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
                maxOccurs = null;
            }
        }
        schemaPropertyImpl.setMinOccurs(bigIntegerMin);
        schemaPropertyImpl.setMaxOccurs(maxOccurs);
        if (schemaProperty.hasNillable() != schemaPropertyImpl.hasNillable()) {
            schemaPropertyImpl.setNillable(1);
        }
        if (schemaProperty.hasDefault() != schemaPropertyImpl.hasDefault()) {
            schemaPropertyImpl.setDefault(1);
        }
        if (schemaProperty.hasFixed() != schemaPropertyImpl.hasFixed()) {
            schemaPropertyImpl.setFixed(1);
        }
        if (schemaPropertyImpl.getDefaultText() != null) {
            if (schemaProperty.getDefaultText() == null || !schemaPropertyImpl.getDefaultText().equals(schemaProperty.getDefaultText())) {
                schemaPropertyImpl.setDefaultText(null);
            }
        }
    }

    private static void particlesMatchingAfter(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map map, QNameSetBuilder qNameSetBuilder, boolean z) {
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                particlesMatchingAfter(schemaParticle2, qNameSetSpecification, map, qNameSetBuilder, false);
            }
        } else if (particleType == 3) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            if (particleChildren.length != 0) {
                if (particleChildren[particleChildren.length - 1].isSkippable()) {
                    QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
                    QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
                    for (int length = particleChildren.length - 1; length >= 0; length--) {
                        particlesMatchingAfter(particleChildren[length], qNameSetBuilder2, map, qNameSetBuilder3, false);
                        qNameSetBuilder.addAll(qNameSetBuilder3);
                        if (!particleChildren[length].isSkippable()) {
                            break;
                        }
                        qNameSetBuilder2.removeAll(qNameSetBuilder3);
                        if (qNameSetBuilder2.isEmpty()) {
                            break;
                        }
                        qNameSetBuilder3.clear();
                    }
                } else {
                    particlesMatchingAfter(particleChildren[0], qNameSetSpecification, map, qNameSetBuilder, false);
                }
            }
        }
        if (z) {
            return;
        }
        BigInteger minOccurs = schemaParticle.getMinOccurs();
        BigInteger maxOccurs = schemaParticle.getMaxOccurs();
        if (maxOccurs == null || minOccurs.compareTo(maxOccurs) < 0) {
            particlesMatchingStart(schemaParticle, qNameSetSpecification, map, qNameSetBuilder);
        }
    }

    private static void particlesMatchingStart(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map map, QNameSetBuilder qNameSetBuilder) {
        int particleType = schemaParticle.getParticleType();
        int i = 0;
        if (particleType == 1 || particleType == 2) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            while (i < particleChildren.length) {
                particlesMatchingStart(particleChildren[i], qNameSetSpecification, map, qNameSetBuilder);
                i++;
            }
            return;
        }
        if (particleType != 3) {
            if (particleType == 4) {
                if (qNameSetSpecification.contains(schemaParticle.getName())) {
                    map.put(schemaParticle, null);
                    qNameSetBuilder.add(schemaParticle.getName());
                    return;
                }
                return;
            }
            if (particleType == 5 && !qNameSetSpecification.isDisjoint(schemaParticle.getWildcardSet())) {
                map.put(schemaParticle, schemaParticle.getWildcardSet().intersect(qNameSetSpecification));
                qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
                return;
            }
            return;
        }
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        if (particleChildren2.length == 0) {
            return;
        }
        if (!particleChildren2[0].isSkippable()) {
            particlesMatchingStart(particleChildren2[0], qNameSetSpecification, map, qNameSetBuilder);
            return;
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
        QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
        while (i < particleChildren2.length) {
            particlesMatchingStart(particleChildren2[i], qNameSetBuilder2, map, qNameSetBuilder3);
            qNameSetBuilder.addAll(qNameSetBuilder3);
            if (!particleChildren2[i].isSkippable()) {
                return;
            }
            qNameSetBuilder2.removeAll(qNameSetBuilder3);
            if (qNameSetBuilder2.isEmpty()) {
                return;
            }
            qNameSetBuilder3.clear();
            i++;
        }
    }

    public static void resolveBasicComplexType(SchemaTypeImpl schemaTypeImpl) {
        ArrayList arrayList = new ArrayList();
        XmlObject xmlObject = (ComplexType) schemaTypeImpl.getParseObject();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = false;
        boolean z2 = schemaTypeImpl.getChameleonNamespace() != null;
        XmlObject contentModel = getContentModel((ComplexType) xmlObject);
        if (schemaTypeImpl.isRedefinition()) {
            StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<complexType>"}, xmlObject);
        }
        boolean z3 = z2;
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z3, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode((Group) contentModel), arrayList, new LinkedHashMap(), false, null);
        if (schemaParticleTranslateContentModel != null && schemaParticleTranslateContentModel.getParticleType() == 1) {
            z = true;
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        translateAttributeModel(xmlObject, targetNamespace, z3, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, null, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        int i = xmlObject.getMixed() ? 4 : schemaParticleTranslateContentModel == null ? 1 : 3;
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    public static void resolveCcExtension(SchemaTypeImpl schemaTypeImpl, ExtensionType extensionType, boolean z) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        int i;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z2 = schemaTypeImpl.getChameleonNamespace() != null;
        if (extensionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, (XmlObject) extensionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) extensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(extensionType.getBase(), 0, extensionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType != null && !StscResolver.resolveType(schemaTypeImplFindGlobalType)) {
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$COMPLEX_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, extensionType.xgetBase());
        }
        SchemaParticle contentModel = schemaTypeImplFindGlobalType == null ? null : schemaTypeImplFindGlobalType.getContentModel();
        ArrayList arrayList = new ArrayList();
        Map mapExtractElementModel = extractElementModel(schemaTypeImplFindGlobalType);
        XmlObject contentModel2 = getContentModel(extensionType);
        if (schemaTypeImplFindGlobalType == null || schemaTypeImplFindGlobalType.getContentType() != 2) {
            schemaTypeImpl2 = schemaTypeImplFindGlobalType;
        } else if (contentModel2 == null) {
            resolveScExtensionPart2(schemaTypeImpl, schemaTypeImplFindGlobalType, extensionType, targetNamespace, z2);
            return;
        } else {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$EXTENDING_SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaTypeImpl2 = null;
        }
        SchemaParticle schemaParticle = contentModel;
        boolean z3 = z2;
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel2, targetNamespace, z3, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode((Group) contentModel2), arrayList, mapExtractElementModel, false, null);
        boolean z4 = (schemaParticleTranslateContentModel != null || z) ? z : schemaTypeImpl2 != null && schemaTypeImpl2.getContentType() == 4;
        if (schemaTypeImpl2 != null && schemaTypeImpl2.getContentType() != 1) {
            if ((schemaTypeImpl2.getContentType() == 4) != z4) {
                stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$BOTH_ELEMEMENT_OR_MIXED, (Object[]) null, extensionType.xgetBase());
            }
        }
        if (schemaTypeImpl2 != null && schemaTypeImpl2.hasAllContent() && schemaParticleTranslateContentModel != null) {
            stscState.error("Cannot extend a type with 'all' content model", 42, extensionType.xgetBase());
            schemaParticleTranslateContentModel = null;
        }
        SchemaParticle schemaParticleExtendContentModel = extendContentModel(schemaParticle, schemaParticleTranslateContentModel, extensionType);
        boolean z5 = schemaParticleExtendContentModel != null && schemaParticleExtendContentModel.getParticleType() == 1;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImpl2 == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        int i2 = 4;
        SchemaTypeImpl schemaTypeImpl3 = schemaTypeImpl2;
        boolean z6 = z4;
        translateAttributeModel(extensionType, targetNamespace, z3, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl3, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleExtendContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleExtendContentModel != null) {
            buildStateMachine(schemaParticleExtendContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleExtendContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel2);
            }
        }
        Map mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleExtendContentModel, schemaTypeImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (schemaParticleExtendContentModel == null && schemaTypeImpl3 != null && schemaTypeImpl3.getContentType() == 2) {
            schemaTypeImpl.setContentBasedOnTypeRef(schemaTypeImpl3.getContentBasedOnType().getRef());
            i = 2;
        } else {
            if (!z6) {
                i2 = schemaParticleExtendContentModel == null ? 1 : 3;
            }
            i = i2;
        }
        SchemaType schemaType = schemaTypeImpl3 == null ? XmlObject.type : schemaTypeImpl3;
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        schemaTypeImpl.setBaseDepth(((SchemaTypeImpl) schemaType).getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(schemaParticleExtendContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z5);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    public static void resolveCcRestriction(SchemaTypeImpl schemaTypeImpl, ComplexRestrictionType complexRestrictionType, boolean z) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z2 = false;
        boolean z3 = schemaTypeImpl.getChameleonNamespace() != null;
        if (complexRestrictionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, (XmlObject) complexRestrictionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) complexRestrictionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(complexRestrictionType.getBase(), 0, complexRestrictionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType == null) {
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl2 = (schemaTypeImplFindGlobalType == null || StscResolver.resolveType(schemaTypeImplFindGlobalType)) ? schemaTypeImplFindGlobalType : null;
        ArrayList arrayList = new ArrayList();
        XmlObject contentModel = getContentModel(complexRestrictionType);
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z3, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode((Group) contentModel), arrayList, new LinkedHashMap(), false, null);
        boolean z4 = z3;
        if (schemaParticleTranslateContentModel != null && schemaParticleTranslateContentModel.getParticleType() == 1) {
            z2 = true;
        }
        SchemaTypeImpl schemaTypeImpl3 = schemaTypeImpl2;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImpl2 == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        translateAttributeModel(complexRestrictionType, targetNamespace, z4, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl3, false, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        int i = z ? 4 : schemaParticleTranslateContentModel == null ? 1 : 3;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void resolveComplexType(SchemaTypeImpl schemaTypeImpl) {
        SchemaTypeImpl schemaTypeImpl2;
        boolean zContains;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zContains2;
        SimpleContentDocument.SimpleContent simpleContent;
        XmlObject xmlObject = (ComplexType) schemaTypeImpl.getParseObject();
        StscState stscState = StscState.get();
        SchemaDocument.Schema schema = getSchema(xmlObject);
        boolean z5 = xmlObject.isSetAbstract() ? xmlObject.getAbstract() : false;
        Object obj = xmlObject.isSetFinal() ? xmlObject.getFinal() : (schema == null || !schema.isSetFinalDefault()) ? null : schema.getFinalDefault();
        if (obj == null) {
            schemaTypeImpl2 = schemaTypeImpl;
            zContains = false;
            z3 = zContains;
            z2 = z3;
            z = z2;
        } else if ((obj instanceof String) && obj.equals("#all")) {
            schemaTypeImpl2 = schemaTypeImpl;
            zContains = true;
            z3 = zContains;
            z2 = z3;
            z = z2;
        } else {
            if (obj instanceof List) {
                List list = (List) obj;
                zContains = list.contains(BundleContract.EXTRA_DATA);
                if (list.contains("restriction")) {
                    schemaTypeImpl2 = schemaTypeImpl;
                    z2 = false;
                    z = false;
                    z3 = true;
                } else {
                    schemaTypeImpl2 = schemaTypeImpl;
                    z3 = false;
                    z2 = z3;
                    z = z2;
                }
            }
            schemaTypeImpl2 = schemaTypeImpl;
            zContains = false;
            z3 = zContains;
            z2 = z3;
            z = z2;
        }
        schemaTypeImpl2.setAbstractFinal(z5, zContains, z3, z2, z);
        Object block = xmlObject.isSetBlock() ? xmlObject.getBlock() : (schema == null || !schema.isSetBlockDefault()) ? null : schema.getBlockDefault();
        if (block == null) {
            z4 = false;
            zContains2 = z4;
        } else if ((block instanceof String) && block.equals("#all")) {
            z4 = true;
            zContains2 = z4;
        } else {
            if (block instanceof List) {
                List list2 = (List) block;
                zContains2 = list2.contains(BundleContract.EXTRA_DATA);
                z4 = list2.contains("restriction");
            }
            z4 = false;
            zContains2 = z4;
        }
        schemaTypeImpl.setBlock(zContains2, z4);
        ComplexContentDocument.ComplexContent complexContent = xmlObject.getComplexContent();
        SimpleContentDocument.SimpleContent simpleContent2 = xmlObject.getSimpleContent();
        if ((complexContent != null ? 1 : 0) + (simpleContent2 != null ? 1 : 0) + (getContentModel((ComplexType) xmlObject) != null ? 1 : 0) > 1) {
            stscState.error("A complex type must define either a content model, or a simpleContent or complexContent derivation: more than one found.", 26, xmlObject);
            simpleContent = (complexContent == null || simpleContent2 == null) ? simpleContent2 : null;
        }
        if (complexContent != null) {
            if (complexContent.getExtension() != null && complexContent.getRestriction() != null) {
                stscState.error("Restriction conflicts with extension", 26, (XmlObject) complexContent.getRestriction());
            }
            boolean mixed = complexContent.isSetMixed() ? complexContent.getMixed() : xmlObject.getMixed();
            if (complexContent.getExtension() != null) {
                resolveCcExtension(schemaTypeImpl, complexContent.getExtension(), mixed);
                return;
            } else if (complexContent.getRestriction() != null) {
                resolveCcRestriction(schemaTypeImpl, complexContent.getRestriction(), mixed);
                return;
            } else {
                stscState.error("Missing restriction or extension", 27, (XmlObject) complexContent);
                resolveErrorType(schemaTypeImpl);
                return;
            }
        }
        if (simpleContent == null) {
            resolveBasicComplexType(schemaTypeImpl);
            return;
        }
        if (simpleContent.getExtension() != null && simpleContent.getRestriction() != null) {
            stscState.error("Restriction conflicts with extension", 26, (XmlObject) simpleContent.getRestriction());
        }
        if (simpleContent.getExtension() != null) {
            resolveScExtension(schemaTypeImpl, simpleContent.getExtension());
        } else if (simpleContent.getRestriction() != null) {
            resolveScRestriction(schemaTypeImpl, simpleContent.getRestriction());
        } else {
            stscState.error("Missing restriction or extension", 27, (XmlObject) simpleContent);
            resolveErrorType(schemaTypeImpl);
        }
    }

    public static void resolveErrorType(SchemaTypeImpl schemaTypeImpl) {
        throw new RuntimeException("This type of error recovery not yet implemented.");
    }

    public static void resolveScExtension(SchemaTypeImpl schemaTypeImpl, SimpleExtensionType simpleExtensionType) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        if (simpleExtensionType.getBase() == null) {
            stscState.error("A simpleContent extension must define a base type", 28, (XmlObject) simpleExtensionType);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) simpleExtensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(simpleExtensionType.getBase(), 0, simpleExtensionType.xgetBase(), true);
                schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            } else {
                schemaTypeImpl2 = schemaTypeImplFindGlobalType;
            }
        }
        StscResolver.resolveType(schemaTypeImpl2);
        if (!schemaTypeImpl2.isSimpleType() && schemaTypeImpl2.getContentType() != 2) {
            stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImpl2.getName())}, (XmlObject) simpleExtensionType);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImpl2 != null && schemaTypeImpl2.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImpl2.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType.xgetBase());
        }
        resolveScExtensionPart2(schemaTypeImpl, schemaTypeImpl2, simpleExtensionType, targetNamespace, z);
    }

    public static void resolveScExtensionPart2(SchemaTypeImpl schemaTypeImpl, SchemaType schemaType, ExtensionType extensionType, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        translateAttributeModel(extensionType, str, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaType;
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getRef());
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaType.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaType.getPrimitiveType() == null ? null : schemaType.getPrimitiveType().getRef());
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaType.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, (XmlObject) null, schemaTypeImpl2);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    public static void resolveScRestriction(SchemaTypeImpl schemaTypeImpl, SimpleRestrictionType simpleRestrictionType) {
        SchemaTypeImpl schemaTypeImpl2;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl3;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        ArrayList arrayList = new ArrayList();
        if (simpleRestrictionType.getSimpleType() != null) {
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(simpleRestrictionType.getSimpleType(), targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl);
            arrayList = arrayList;
            schemaTypeImpl2 = schemaTypeImpl;
        } else {
            schemaTypeImpl2 = schemaTypeImpl;
            schemaTypeImplTranslateAnonymousSimpleType = null;
        }
        if (simpleRestrictionType.getBase() == null) {
            stscState.error("A simpleContent restriction must define a base type", 28, (XmlObject) simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl2.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl2.getChameleonNamespace(), schemaTypeImpl2);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl2.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl2.getName())}, (XmlObject) simpleRestrictionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl2.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(simpleRestrictionType.getBase(), 0, simpleRestrictionType.xgetBase(), true);
                schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        }
        StscResolver.resolveType(schemaTypeImplFindGlobalType);
        if (schemaTypeImplTranslateAnonymousSimpleType != null) {
            StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
            schemaTypeImpl3 = schemaTypeImplTranslateAnonymousSimpleType;
        } else {
            schemaTypeImpl3 = schemaTypeImplFindGlobalType;
        }
        if (schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$SIMPLE_TYPE_EXTENSION, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else if (schemaTypeImplFindGlobalType.getContentType() != 2 && schemaTypeImpl3 == null) {
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl2.getName())}, simpleRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl4 = schemaTypeImplFindGlobalType;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImplFindGlobalType == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImplFindGlobalType.getAttributeModel());
        translateAttributeModel(simpleRestrictionType, targetNamespace, z, schemaTypeImpl2.getAttFormDefault(), arrayList, schemaTypeImpl2, null, schemaAttributeModelImpl, schemaTypeImpl4, false, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        ArrayList arrayList2 = arrayList;
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl2);
        schemaTypeImpl2.setBaseTypeRef(schemaTypeImpl4.getRef());
        schemaTypeImpl2.setBaseDepth(schemaTypeImpl4.getBaseDepth() + 1);
        schemaTypeImpl2.setContentBasedOnTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl2.setDerivationType(1);
        schemaTypeImpl2.setAnonymousTypeRefs(makeRefArray(arrayList2));
        schemaTypeImpl2.setWildcardSummary(QNameSet.EMPTY, false, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl2.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl3.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl3.getPrimitiveType() != null ? schemaTypeImpl3.getPrimitiveType().getRef() : null);
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl3.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaTypeImpl3.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, simpleRestrictionType, schemaTypeImpl3);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    public static WildcardResult summarizeAttrWildcards(SchemaAttributeModel schemaAttributeModel) {
        return schemaAttributeModel.getWildcardProcess() == 0 ? new WildcardResult(QNameSet.EMPTY, false) : schemaAttributeModel.getWildcardProcess() == 3 ? new WildcardResult(QNameSet.EMPTY, true) : new WildcardResult(schemaAttributeModel.getWildcardSet(), true);
    }

    public static WildcardResult summarizeEltWildcards(SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType != 5) {
                return new WildcardResult(QNameSet.EMPTY, false);
            }
            return new WildcardResult(schemaParticle.getWildcardProcess() == 3 ? QNameSet.EMPTY : schemaParticle.getWildcardSet(), true);
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        boolean z = false;
        for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
            WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticle.getParticleChild(i));
            qNameSetBuilder.addAll(wildcardResultSummarizeEltWildcards.typedWildcards);
            z |= wildcardResultSummarizeEltWildcards.hasWildcards;
        }
        return new WildcardResult(qNameSetBuilder.toQNameSet(), z);
    }

    public static int translateAttributeCode(QName qName) {
        Integer num = (Integer) attributeCodeMap.get(qName);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void translateAttributeModel(XmlObject xmlObject, String str, boolean z, String str2, List list, SchemaType schemaType, Set set, SchemaAttributeModelImpl schemaAttributeModelImpl, SchemaType schemaType2, boolean z2, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        boolean z3;
        boolean z4;
        SchemaAttributeModel schemaAttributeModel;
        SchemaAttributeGroupImpl schemaAttributeGroupImplFindAttributeGroup;
        boolean z5;
        boolean z6;
        String targetNamespace;
        String str3 = str;
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2 = schemaAttributeGroupImpl;
        StscState stscState = StscState.get();
        Set hashSet = set == null ? new HashSet() : set;
        Object[] objArr = null;
        SchemaAttributeModel attributeModel = schemaType2 != null ? schemaType2.getAttributeModel() : null;
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        boolean z7 = false;
        boolean firstChild = xmlCursorNewCursor.toFirstChild();
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = z;
        while (firstChild) {
            switch (translateAttributeCode(xmlCursorNewCursor.getName())) {
                case 100:
                    z3 = z7;
                    XmlObject xmlObject2 = (Attribute) xmlCursorNewCursor.getObject();
                    SchemaAttributeModel schemaAttributeModel2 = attributeModel;
                    z4 = z10;
                    SchemaLocalAttributeImpl schemaLocalAttributeImplTranslateAttribute = StscTranslator.translateAttribute(xmlObject2, str3, str2, z4, list, schemaType, schemaAttributeModel2, true);
                    schemaAttributeModel = schemaAttributeModel2;
                    if (schemaLocalAttributeImplTranslateAttribute != null) {
                        if (hashSet.contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$DUPLICATE_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, xmlObject2.xgetName());
                        } else {
                            hashSet.add(schemaLocalAttributeImplTranslateAttribute.getName());
                            if (schemaAttributeModel != null) {
                                SchemaLocalAttribute attribute = schemaAttributeModel.getAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                if (attribute == null) {
                                    if (!z2 && !schemaAttributeModel.getWildcardSet().contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_IN_BASE_WILDCARD_SET, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, xmlObject2);
                                    }
                                } else if (z2) {
                                    if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                        stscState.error("An extension cannot prohibit an attribute from the base type; use restriction instead.", 37, xmlObject2.xgetUse());
                                    }
                                } else if (schemaLocalAttributeImplTranslateAttribute.getUse() != 3) {
                                    if (attribute.getUse() == 3) {
                                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_REQUIRED, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, xmlObject2);
                                    }
                                    if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                        schemaAttributeModelImpl.removeProhibitedAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                    }
                                }
                            }
                            if (schemaLocalAttributeImplTranslateAttribute.getUse() != 1) {
                                schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImplTranslateAttribute);
                            } else {
                                SchemaType type = schemaLocalAttributeImplTranslateAttribute.getType();
                                if (list != null && list.contains(type)) {
                                    list.remove(type);
                                }
                            }
                            if (schemaLocalAttributeImplTranslateAttribute.getDefaultText() != null && !schemaLocalAttributeImplTranslateAttribute.isFixed() && schemaLocalAttributeImplTranslateAttribute.getUse() != 2) {
                                stscState.error(XmlErrorCodes.SCHEMA_ATTR$DEFAULT_AND_USE_OPTIONAL, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName())}, xmlObject2);
                            }
                        }
                    }
                    z10 = z4;
                    break;
                case 101:
                    XmlObject xmlObject3 = (AttributeGroupRef) xmlCursorNewCursor.getObject();
                    QName ref = xmlObject3.getRef();
                    if (ref != null) {
                        if (schemaAttributeGroupImpl2 != null) {
                            schemaAttributeGroupImplFindAttributeGroup = stscState.findRedefinedAttributeGroup(ref, z10 ? str3 : objArr, schemaAttributeGroupImpl2);
                            if (schemaAttributeGroupImplFindAttributeGroup != null && schemaAttributeGroupImpl2.getName().equals(schemaAttributeGroupImplFindAttributeGroup.getName())) {
                                if (z8) {
                                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$ATTR_GROUP_SELF_REF, new Object[]{QNameHelper.pretty(schemaAttributeGroupImpl2.getName())}, xmlObject3);
                                }
                                z5 = true;
                            }
                            if (schemaAttributeGroupImplFindAttributeGroup != null) {
                                stscState.notFoundError(ref, 4, xmlObject3.xgetRef(), true);
                            } else if (!stscState.isProcessing(schemaAttributeGroupImplFindAttributeGroup)) {
                                if (schemaAttributeGroupImplFindAttributeGroup.getTargetNamespace() != null) {
                                    targetNamespace = schemaAttributeGroupImplFindAttributeGroup.getTargetNamespace();
                                    z6 = schemaAttributeGroupImplFindAttributeGroup.getChameleonNamespace() == null ? z7 : true;
                                } else {
                                    z6 = z10;
                                    targetNamespace = str3;
                                }
                                stscState.startProcessing(schemaAttributeGroupImplFindAttributeGroup);
                                z3 = z7;
                                translateAttributeModel(schemaAttributeGroupImplFindAttributeGroup.getParseObject(), targetNamespace, z6, schemaAttributeGroupImplFindAttributeGroup.getFormDefault(), list, schemaType, hashSet, schemaAttributeModelImpl, schemaType2, z2, schemaAttributeGroupImplFindAttributeGroup.isRedefinition() ? schemaAttributeGroupImplFindAttributeGroup : objArr);
                                stscState.finishProcessing(schemaAttributeGroupImplFindAttributeGroup);
                                schemaAttributeModel = attributeModel;
                                z10 = z6;
                                z8 = z5;
                            } else {
                                stscState.error(XmlErrorCodes.SCHEMA_ATTR_GROUP$SELF_REF, new Object[]{QNameHelper.pretty(schemaAttributeGroupImplFindAttributeGroup.getName())}, schemaAttributeGroupImplFindAttributeGroup.getParseObject());
                            }
                            schemaAttributeModel = attributeModel;
                            z3 = z7;
                            z8 = z5;
                        } else {
                            schemaAttributeGroupImplFindAttributeGroup = stscState.findAttributeGroup(ref, z10 ? str3 : objArr, str3);
                        }
                        z5 = z8;
                        if (schemaAttributeGroupImplFindAttributeGroup != null) {
                        }
                        schemaAttributeModel = attributeModel;
                        z3 = z7;
                        z8 = z5;
                    } else {
                        stscState.error("Attribute group reference must have a ref attribute", 39, xmlObject3);
                        schemaAttributeModel = attributeModel;
                        z3 = z7;
                        z4 = z10;
                        z10 = z4;
                    }
                    break;
                case 102:
                    XmlObject xmlObject4 = (Wildcard) xmlCursorNewCursor.getObject();
                    if (!z9) {
                        NamespaceList namespaceListXgetNamespace = xmlObject4.xgetNamespace();
                        String stringValue = namespaceListXgetNamespace == null ? "##any" : namespaceListXgetNamespace.getStringValue();
                        QNameSet qNameSetForWildcardNamespaceString = QNameSet.forWildcardNamespaceString(stringValue, str3);
                        if (attributeModel == null || z2) {
                            int iTranslateWildcardProcess = translateWildcardProcess(xmlObject4.xgetProcessContents());
                            if (schemaAttributeModelImpl.getWildcardProcess() == 0) {
                                schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString);
                                schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                            } else if (z2) {
                                schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.union(schemaAttributeModelImpl.getWildcardSet()));
                                schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                            } else {
                                schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.intersect(schemaAttributeModelImpl.getWildcardSet()));
                            }
                            schemaAttributeModel = attributeModel;
                            z3 = z7;
                            z9 = true;
                        } else {
                            if (attributeModel.getWildcardSet() == null) {
                                stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$BASE_HAS_ATTR_WILDCARD, objArr, xmlObject4);
                            } else if (!attributeModel.getWildcardSet().containsAll(qNameSetForWildcardNamespaceString)) {
                                stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_WILDCARD_SUBSET, new Object[]{stringValue}, xmlObject4);
                            }
                            schemaAttributeModel = attributeModel;
                            z3 = z7;
                            z9 = true;
                        }
                    } else {
                        stscState.error("Only one attribute wildcard allowed", 38, xmlObject4);
                        schemaAttributeModel = attributeModel;
                        z3 = z7;
                        z4 = z10;
                        z10 = z4;
                    }
                    break;
                default:
                    schemaAttributeModel = attributeModel;
                    z3 = z7;
                    z4 = z10;
                    z10 = z4;
                    break;
            }
            firstChild = xmlCursorNewCursor.toNextSibling();
            str3 = str;
            z7 = z3;
            attributeModel = schemaAttributeModel;
            objArr = null;
            schemaAttributeGroupImpl2 = schemaAttributeGroupImpl;
            z8 = z8;
            z9 = z9;
        }
        boolean z11 = z7;
        if (z2 || z9) {
            return;
        }
        schemaAttributeModelImpl.setWildcardSet(null);
        schemaAttributeModelImpl.setWildcardProcess(z11 ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02fa  */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object[], org.apache.xmlbeans.SchemaParticle] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SchemaParticle translateContentModel(SchemaType schemaType, XmlObject xmlObject, String str, boolean z, String str2, String str3, int i, List list, Map map, boolean z2, RedefinitionForGroup redefinitionForGroup) {
        String str4;
        SchemaParticle schemaParticle;
        boolean z3;
        String elemFormDefault;
        String attFormDefault;
        BigInteger bigIntegerExtractMaxOccurs;
        boolean z4;
        SchemaParticleImpl schemaParticleImpl;
        XmlObject xmlObject2;
        BigInteger bigInteger;
        String str5;
        String str6;
        String str7;
        boolean z5;
        SchemaParticleImpl schemaParticleImpl2;
        BigInteger bigIntegerExtractMinOccurs;
        ?? r7;
        RedefinitionForGroup redefinitionForGroup2;
        XmlCursor xmlCursor;
        ArrayList arrayList;
        XmlObject xmlObject3 = xmlObject;
        int iTranslateParticleCode = i;
        Map map2 = map;
        RedefinitionForGroup redefinitionForGroup3 = redefinitionForGroup;
        if (xmlObject3 == null || iTranslateParticleCode == 0) {
            return null;
        }
        StscState stscState = StscState.get();
        if (!$assertionsDisabled && iTranslateParticleCode == 0) {
            throw new AssertionError();
        }
        if (iTranslateParticleCode == 4) {
            if (!z2) {
                stscState.error("Must be a sequence, choice or all here", 32, xmlObject3);
            }
            LocalElement localElement = (LocalElement) xmlObject3;
            str4 = str;
            schemaParticleImpl2 = StscTranslator.translateElement(localElement, str4, z, str2, str3, list, schemaType);
            if (schemaParticleImpl2 == null) {
                return null;
            }
            bigIntegerExtractMinOccurs = extractMinOccurs(localElement.xgetMinOccurs());
            bigIntegerExtractMaxOccurs = extractMaxOccurs(localElement.xgetMaxOccurs());
            SchemaType schemaType2 = (SchemaType) map2.get(schemaParticleImpl2.getName());
            if (schemaType2 == null) {
                map2.put(schemaParticleImpl2.getName(), schemaParticleImpl2.getType());
            } else if (!schemaParticleImpl2.getType().equals(schemaType2)) {
                stscState.error(XmlErrorCodes.ELEM_CONSISTANT, new Object[]{QNameHelper.pretty(schemaParticleImpl2.getName())}, xmlObject3);
                return null;
            }
        } else {
            str4 = str;
            if (iTranslateParticleCode != 5) {
                Group group = (Group) xmlObject3;
                SchemaParticleImpl schemaParticleImpl3 = new SchemaParticleImpl();
                BigInteger bigIntegerExtractMinOccurs2 = extractMinOccurs(group.xgetMinOccurs());
                BigInteger bigIntegerExtractMaxOccurs2 = extractMaxOccurs(group.xgetMaxOccurs());
                if (iTranslateParticleCode == 100) {
                    QName ref = group.getRef();
                    if (ref == null) {
                        stscState.error("Group reference must have a ref attribute", 33, xmlObject3);
                        return null;
                    }
                    if (redefinitionForGroup3 != null) {
                        schemaParticle = null;
                        strFindModelGroup = stscState.findRedefinedModelGroup(ref, z ? str4 : null, redefinitionForGroup3.getGroup());
                        if (strFindModelGroup != null && strFindModelGroup.getName().equals(redefinitionForGroup3.getGroup().getName())) {
                            if (redefinitionForGroup3.isSeenRedefinition()) {
                                stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$GROUP_SELF_REF, new Object[]{QNameHelper.pretty(strFindModelGroup.getName())}, xmlObject3);
                            }
                            BigInteger bigInteger2 = BigInteger.ONE;
                            if (!bigInteger2.equals(bigIntegerExtractMaxOccurs2) || !bigInteger2.equals(bigIntegerExtractMinOccurs2)) {
                                stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$GROUP_SELF_REF_MIN_MAX_1, new Object[]{QNameHelper.pretty(strFindModelGroup.getName())}, xmlObject3);
                            }
                            redefinitionForGroup3.setSeenRedefinition(true);
                        }
                    } else {
                        schemaParticle = null;
                        strFindModelGroup = stscState.findModelGroup(ref, z ? str4 : null, str4);
                    }
                    if (strFindModelGroup == null) {
                        stscState.notFoundError(ref, 6, group.xgetRef(), true);
                        return schemaParticle;
                    }
                    if (stscState.isProcessing(strFindModelGroup)) {
                        stscState.error(XmlErrorCodes.MODEL_GROUP_PROPERTIES$CIRCULAR, new Object[]{QNameHelper.pretty(strFindModelGroup.getName())}, strFindModelGroup.getParseObject());
                        return schemaParticle;
                    }
                    XmlCursor xmlCursorNewCursor = strFindModelGroup.getParseObject().newCursor();
                    boolean firstChild = xmlCursorNewCursor.toFirstChild();
                    while (true) {
                        if (!firstChild) {
                            break;
                        }
                        iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
                        if (iTranslateParticleCode != 0) {
                            xmlObject3 = (Group) xmlCursorNewCursor.getObject();
                            break;
                        }
                        firstChild = xmlCursorNewCursor.toNextSibling();
                    }
                    if (iTranslateParticleCode == 0) {
                        StringBuffer stringBuffer = new StringBuffer("Model group ");
                        stringBuffer.append(QNameHelper.pretty(strFindModelGroup.getName()));
                        stringBuffer.append(" is empty");
                        stscState.error(stringBuffer.toString(), 32, strFindModelGroup.getParseObject());
                        return schemaParticle;
                    }
                    if (iTranslateParticleCode != 1 && iTranslateParticleCode != 3 && iTranslateParticleCode != 2) {
                        StringBuffer stringBuffer2 = new StringBuffer("Model group ");
                        stringBuffer2.append(QNameHelper.pretty(strFindModelGroup.getName()));
                        stringBuffer2.append(" is not a sequence, all, or choice");
                        stscState.error(stringBuffer2.toString(), 32, strFindModelGroup.getParseObject());
                    }
                    String targetNamespace = strFindModelGroup.getTargetNamespace();
                    if (targetNamespace != null) {
                        str4 = targetNamespace;
                    }
                    elemFormDefault = strFindModelGroup.getElemFormDefault();
                    attFormDefault = strFindModelGroup.getAttFormDefault();
                    z3 = strFindModelGroup.getChameleonNamespace() != null;
                } else {
                    schemaParticle = null;
                    z3 = z;
                    elemFormDefault = str2;
                    attFormDefault = str3;
                }
                if (iTranslateParticleCode != 1 && iTranslateParticleCode != 2 && iTranslateParticleCode != 3) {
                    if ($assertionsDisabled) {
                        throw new IllegalStateException();
                    }
                    throw new AssertionError();
                }
                schemaParticleImpl3.setParticleType(iTranslateParticleCode);
                bigIntegerExtractMaxOccurs = bigIntegerExtractMaxOccurs2;
                z4 = true;
                schemaParticleImpl = schemaParticleImpl3;
                xmlObject2 = xmlObject3;
                bigInteger = bigIntegerExtractMinOccurs2;
                str5 = strFindModelGroup;
                str6 = attFormDefault;
                str7 = elemFormDefault;
                z5 = z3;
                if (bigIntegerExtractMaxOccurs != null || bigInteger.compareTo(bigIntegerExtractMaxOccurs) <= 0) {
                    r7 = schemaParticle;
                } else {
                    Object[] objArr = schemaParticle;
                    stscState.error(XmlErrorCodes.PARTICLE_PROPERTIES$MIN_LTE_MAX, objArr, xmlObject2);
                    bigIntegerExtractMaxOccurs = bigInteger;
                    r7 = objArr;
                }
                if (bigIntegerExtractMaxOccurs == null && bigIntegerExtractMaxOccurs.compareTo(BigInteger.ONE) < 0) {
                    stscState.warning(XmlErrorCodes.PARTICLE_PROPERTIES$MAX_GTE_1, (Object[]) r7, xmlObject2);
                    list.remove(schemaParticleImpl.getType());
                    return r7;
                }
                schemaParticleImpl.setMinOccurs(bigInteger);
                schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
                if (str5 != null) {
                    stscState.startProcessing(str5);
                    redefinitionForGroup3 = str5.isRedefinition() ? new RedefinitionForGroup(str5) : null;
                }
                if (z4) {
                    XmlCursor xmlCursorNewCursor2 = xmlObject2.newCursor();
                    ArrayList arrayList2 = new ArrayList();
                    boolean firstChild2 = xmlCursorNewCursor2.toFirstChild();
                    while (firstChild2) {
                        int iTranslateParticleCode2 = translateParticleCode(xmlCursorNewCursor2.getName());
                        if (iTranslateParticleCode2 == 0) {
                            redefinitionForGroup2 = redefinitionForGroup3;
                            xmlCursor = xmlCursorNewCursor2;
                            arrayList = arrayList2;
                        } else {
                            XmlObject object = xmlCursorNewCursor2.getObject();
                            redefinitionForGroup2 = redefinitionForGroup3;
                            xmlCursor = xmlCursorNewCursor2;
                            arrayList = arrayList2;
                            addMinusPointlessParticles(arrayList, translateContentModel(schemaType, object, str4, z5, str7, str6, iTranslateParticleCode2, list, map2, true, redefinitionForGroup2), schemaParticleImpl.getParticleType());
                        }
                        firstChild2 = xmlCursor.toNextSibling();
                        map2 = map;
                        redefinitionForGroup3 = redefinitionForGroup2;
                        arrayList2 = arrayList;
                        xmlCursorNewCursor2 = xmlCursor;
                    }
                    XmlCursor xmlCursor2 = xmlCursorNewCursor2;
                    ArrayList arrayList3 = arrayList2;
                    schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList3.toArray(new SchemaParticle[arrayList3.size()]));
                    xmlCursor2.dispose();
                }
                SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject2);
                if (str5 != null) {
                    stscState.finishProcessing(str5);
                }
                return schemaParticleFilterPointlessParticlesAndVerifyAllParticles;
            }
            if (!z2) {
                stscState.error("Must be a sequence, choice or all here", 32, xmlObject3);
            }
            AnyDocument.Any any = (AnyDocument.Any) xmlObject3;
            schemaParticleImpl2 = new SchemaParticleImpl();
            schemaParticleImpl2.setParticleType(5);
            NamespaceList namespaceListXgetNamespace = any.xgetNamespace();
            schemaParticleImpl2.setWildcardSet(namespaceListXgetNamespace == null ? QNameSet.ALL : QNameSet.forWildcardNamespaceString(namespaceListXgetNamespace.getStringValue(), str4));
            schemaParticleImpl2.setWildcardProcess(translateWildcardProcess(any.xgetProcessContents()));
            bigIntegerExtractMinOccurs = extractMinOccurs(any.xgetMinOccurs());
            bigIntegerExtractMaxOccurs = extractMaxOccurs(any.xgetMaxOccurs());
        }
        str7 = str2;
        str6 = str3;
        xmlObject2 = xmlObject3;
        bigInteger = bigIntegerExtractMinOccurs;
        schemaParticle = null;
        schemaParticleImpl = schemaParticleImpl2;
        z4 = false;
        z5 = z;
        str5 = null;
        if (bigIntegerExtractMaxOccurs != null) {
            r7 = schemaParticle;
        }
        if (bigIntegerExtractMaxOccurs == null) {
        }
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
        if (str5 != null) {
        }
        if (z4) {
        }
        SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles2 = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject2);
        if (str5 != null) {
        }
        return schemaParticleFilterPointlessParticlesAndVerifyAllParticles2;
    }

    private static int translateParticleCode(Group group) {
        if (group == null) {
            return 0;
        }
        return translateParticleCode(group.newCursor().getName());
    }

    public static int translateWildcardProcess(Wildcard.ProcessContents processContents) {
        if (processContents == null) {
            return 1;
        }
        String stringValue = processContents.getStringValue();
        if ("lax".equals(stringValue)) {
            return 2;
        }
        return "skip".equals(stringValue) ? 3 : 1;
    }

    private static int translateParticleCode(QName qName) {
        Integer num = (Integer) particleCodeMap.get(qName);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static Group getContentModel(ComplexRestrictionType complexRestrictionType) {
        if (complexRestrictionType.getAll() != null) {
            return complexRestrictionType.getAll();
        }
        if (complexRestrictionType.getSequence() != null) {
            return complexRestrictionType.getSequence();
        }
        if (complexRestrictionType.getChoice() != null) {
            return complexRestrictionType.getChoice();
        }
        if (complexRestrictionType.getGroup() != null) {
            return complexRestrictionType.getGroup();
        }
        return null;
    }

    public static Group getContentModel(ExtensionType extensionType) {
        if (extensionType.getAll() != null) {
            return extensionType.getAll();
        }
        if (extensionType.getSequence() != null) {
            return extensionType.getSequence();
        }
        if (extensionType.getChoice() != null) {
            return extensionType.getChoice();
        }
        if (extensionType.getGroup() != null) {
            return extensionType.getGroup();
        }
        return null;
    }
}
