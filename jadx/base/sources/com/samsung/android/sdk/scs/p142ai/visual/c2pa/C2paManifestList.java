package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p092W3.C0332a;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001?B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0000J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J;\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012J\b\u0010 \u001a\u0004\u0018\u00010\u0012J\b\u0010!\u001a\u0004\u0018\u00010\u0012J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$2\u0006\u0010\u000e\u001a\u00020\u0003J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00112\u0006\u0010\u000e\u001a\u00020\u0003J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\u0003J\u0018\u0010*\u001a\u0004\u0018\u00010\u00122\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010,\u001a\u0004\u0018\u00010\u00122\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020\u0003H\u0002J\u0016\u00100\u001a\u00020\u00162\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0011H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0015\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifestList;", "", "activeManifest", "", "manifests", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifest;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getActiveManifest", "()Ljava/lang/String;", "getManifests", "()Ljava/util/Map;", "getSingleTreeC2paManifestList", "manifestKey", "getSingleTreeC2paManifestListLatest", "getAllActions", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action;", "getFilteredActions", "actionType", "isAi", "", "isValid", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/util/List;", "getAllValidActions", "isAiGenerated", "isEnhanced", Constants.IntentExtraName.IS_EDITED, "getManifestKeys", "getManifest", "getLatestAiAction", "getLatestEditAction", "getSourceAction", "getAllEditActions", "getExif", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Exif;", "getExifFromSource", "getIngredientManifestInfo", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/IngredientManifestInfo;", "getActionsFromManifestKey", "getOldestAction", "actions", "getLatestAction", "calculateValidation", "", "getRootParentManifestKey", "checkInvalid", "validationStatusList", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationStatus;", "validationResult", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationResults;", "setValidationStatus", "sortedByManifest", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nC2paManifestList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2paManifestList.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifestList\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n216#2,2:365\n1368#3:367\n1454#3,5:368\n774#3:373\n865#3,2:374\n774#3:376\n865#3,2:377\n827#3:379\n855#3,2:380\n774#3:382\n865#3,2:383\n774#3:385\n865#3,2:386\n1755#3,3:388\n1755#3,3:391\n1755#3,3:394\n827#3:397\n855#3,2:398\n1755#3,3:401\n774#3:406\n865#3,2:407\n774#3:409\n865#3,2:410\n13409#4:400\n13410#4:405\n1#5:404\n*S KotlinDebug\n*F\n+ 1 C2paManifestList.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifestList\n*L\n53#1:365,2\n62#1:367\n62#1:368,5\n75#1:373\n75#1:374,2\n79#1:376\n79#1:377,2\n81#1:379\n81#1:380,2\n86#1:382\n86#1:383,2\n88#1:385\n88#1:386,2\n106#1:388,3\n114#1:391,3\n122#1:394,3\n178#1:397\n178#1:398,2\n194#1:401,3\n246#1:406\n246#1:407,2\n353#1:409\n353#1:410,2\n194#1:400\n194#1:405\n*E\n"})
public final /* data */ class C2paManifestList {

    @NotNull
    public static final String EXIF_LABEL = "stds.exif";

    @NotNull
    public static final String METADATA_LABEL = "c2pa.metadata";

    @NotNull
    public static final String PARENT_RELATION = "parentOf";

    @NotNull
    public static final String UNKNOWN_TIME = "1970-01-01T00:00:00+00:00";

    @NotNull
    public static final String UNKNOWN_VALUE = "Unknown";

    @NotNull
    private final String activeManifest;

    @NotNull
    private final Map<String, C2paManifest> manifests;

    public C2paManifestList(@NotNull String activeManifest, @NotNull Map<String, C2paManifest> manifests) {
        Intrinsics.checkNotNullParameter(activeManifest, "activeManifest");
        Intrinsics.checkNotNullParameter(manifests, "manifests");
        this.activeManifest = activeManifest;
        this.manifests = manifests;
    }

    private final boolean checkInvalid(List<ValidationStatus> validationStatusList) {
        C2paSoVersionInfo c2paSoVersionInfo = ((Integer) Optional.ofNullable(SemFloatingFeature.getInstance()).map(new C0332a(new C7791a(), 6)).orElse(-1)).intValue() >= 20261 ? C2paSoVersionInfo.f5250V2 : C2paSoVersionInfo.f5249V1;
        if (validationStatusList.isEmpty()) {
            return false;
        }
        return C2paError.INSTANCE.checkInvalid(CollectionsKt.m13955n(validationStatusList, "::", null, null, new C0348a(3), 30), c2paSoVersionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer checkInvalid$lambda$20(SemFloatingFeature semFloatingFeature) {
        return Integer.valueOf(semFloatingFeature.getInt("SEC_FLOATING_FEATURE_COMMON_CONFIG_AI_VERSION"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer checkInvalid$lambda$21(Function1 function1, Object obj) {
        return (Integer) function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence checkInvalid$lambda$22(ValidationStatus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2paManifestList copy$default(C2paManifestList c2paManifestList, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c2paManifestList.activeManifest;
        }
        if ((i & 2) != 0) {
            map = c2paManifestList.manifests;
        }
        return c2paManifestList.copy(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getFilteredActions$default(C2paManifestList c2paManifestList, List list, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            bool2 = null;
        }
        return c2paManifestList.getFilteredActions(list, bool, bool2);
    }

    private final Action getLatestAction(List<Action> actions) {
        return (Action) CollectionsKt.firstOrNull((List) sortedByManifest(actions));
    }

    private final Action getOldestAction(List<Action> actions) {
        return (Action) CollectionsKt.firstOrNull((List) sortedByManifest(actions));
    }

    private final String getRootParentManifestKey() {
        List<Ingredients> listEmptyList;
        Ingredients next;
        String activeManifest = this.activeManifest;
        while (true) {
            for (boolean z = true; z; z = false) {
                C2paManifest c2paManifest = this.manifests.get(activeManifest);
                if (c2paManifest == null || (listEmptyList = c2paManifest.getIngredients()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Iterator<Ingredients> it = listEmptyList.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (!Intrinsics.areEqual(next.getRelationship(), PARENT_RELATION) || next.getActiveManifest() == null) {
                    }
                }
            }
            return activeManifest;
            activeManifest = next.getActiveManifest();
        }
    }

    public static /* synthetic */ C2paManifestList getSingleTreeC2paManifestList$default(C2paManifestList c2paManifestList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c2paManifestList.activeManifest;
        }
        return c2paManifestList.getSingleTreeC2paManifestList(str);
    }

    private final void setValidationStatus(String manifestKey) {
        C2paManifest c2paManifest = this.manifests.get(manifestKey);
        if (c2paManifest == null) {
            return;
        }
        c2paManifest.setInvalid(true);
        C2paManifest c2paManifest2 = this.manifests.get(manifestKey);
        List<Ingredients> ingredients = c2paManifest2 != null ? c2paManifest2.getIngredients() : null;
        if (ingredients != null) {
            Iterator<Ingredients> it = ingredients.iterator();
            while (it.hasNext()) {
                String activeManifest = it.next().getActiveManifest();
                if (activeManifest != null) {
                    setValidationStatus(activeManifest);
                }
            }
        }
    }

    private final List<Action> sortedByManifest(List<Action> actions) {
        ArrayList arrayList = new ArrayList();
        sortedByManifest$preOrderSearch(arrayList, CollectionsKt.asReversed(actions), this, this.activeManifest);
        return arrayList;
    }

    private static final void sortedByManifest$preOrderSearch(List<Action> list, List<Action> list2, C2paManifestList c2paManifestList, String str) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (Intrinsics.areEqual(((Action) obj).getActiveManifest(), str)) {
                arrayList.add(obj);
            }
        }
        list.addAll(arrayList);
        Iterator<IngredientManifestInfo> it = c2paManifestList.getIngredientManifestInfo(str).iterator();
        while (it.hasNext()) {
            sortedByManifest$preOrderSearch(list, list2, c2paManifestList, it.next().getManifestKey());
        }
    }

    public final void calculateValidation() {
        ValidationResults validationResults;
        Iterator<String> it = getManifestKeys().iterator();
        while (it.hasNext()) {
            C2paManifest c2paManifest = this.manifests.get(it.next());
            List<Ingredients> ingredients = c2paManifest != null ? c2paManifest.getIngredients() : null;
            if (ingredients != null) {
                for (Ingredients ingredients2 : ingredients) {
                    List<ValidationStatus> validationStatus = ingredients2.getValidationStatus();
                    if ((validationStatus != null && checkInvalid(validationStatus)) || ((validationResults = ingredients2.getValidationResults()) != null && checkInvalid(validationResults))) {
                        String activeManifest = ingredients2.getActiveManifest();
                        if (activeManifest != null) {
                            setValidationStatus(activeManifest);
                        }
                    }
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActiveManifest() {
        return this.activeManifest;
    }

    @NotNull
    public final Map<String, C2paManifest> component2() {
        return this.manifests;
    }

    @NotNull
    public final C2paManifestList copy(@NotNull String activeManifest, @NotNull Map<String, C2paManifest> manifests) {
        Intrinsics.checkNotNullParameter(activeManifest, "activeManifest");
        Intrinsics.checkNotNullParameter(manifests, "manifests");
        return new C2paManifestList(activeManifest, manifests);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C2paManifestList)) {
            return false;
        }
        C2paManifestList c2paManifestList = (C2paManifestList) other;
        return Intrinsics.areEqual(this.activeManifest, c2paManifestList.activeManifest) && Intrinsics.areEqual(this.manifests, c2paManifestList.manifests);
    }

    @NotNull
    public final List<Action> getActionsFromManifestKey(@NotNull String manifestKey) {
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        List<Action> allActions = getAllActions();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allActions) {
            if (Intrinsics.areEqual(((Action) obj).getActiveManifest(), manifestKey)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getActiveManifest() {
        return this.activeManifest;
    }

    @NotNull
    public final List<Action> getAllActions() {
        List<Action> listEmptyList;
        for (Map.Entry<String, C2paManifest> entry : this.manifests.entrySet()) {
            String key = entry.getKey();
            List<C2paAssertion> assertions = entry.getValue().getAssertions();
            if (assertions == null) {
                assertions = CollectionsKt.emptyList();
            }
            Iterator<C2paAssertion> it = assertions.iterator();
            while (it.hasNext()) {
                Data data = it.next().getData();
                if (data == null || (listEmptyList = data.getActions()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Iterator<Action> it2 = listEmptyList.iterator();
                while (it2.hasNext()) {
                    it2.next().setActiveManifest(key);
                }
            }
        }
        Collection<C2paManifest> collectionValues = this.manifests.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it3 = collectionValues.iterator();
        while (it3.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((C2paManifest) it3.next()).getActions());
        }
        return sortedByManifest(CollectionsKt.toList(arrayList));
    }

    @NotNull
    public final List<Action> getAllEditActions() {
        List mutableList = CollectionsKt.toMutableList((Collection) getAllValidActions());
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            if (!Intrinsics.areEqual((Action) obj, getSourceAction())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Action> getAllValidActions() {
        return getFilteredActions(null, null, Boolean.TRUE);
    }

    @NotNull
    public final Map<Exif, String> getExif(@NotNull String manifestKey) {
        JsonArray assertionsJsonArray;
        Object next;
        JsonElement jsonElement;
        String asString;
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C2paManifest manifest = getManifest(manifestKey);
        if (manifest != null && (assertionsJsonArray = manifest.getAssertionsJsonArray()) != null) {
            Iterator<JsonElement> it = assertionsJsonArray.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                JsonObject asJsonObject = it.next().getAsJsonObject();
                if (CollectionsKt.listOf((Object[]) new String[]{EXIF_LABEL, METADATA_LABEL}).contains(asJsonObject.get("label").getAsString())) {
                    JsonObject asJsonObject2 = asJsonObject.get("data").getAsJsonObject();
                    for (Exif exif : Exif.values()) {
                        Set<String> setKeySet = asJsonObject2.keySet();
                        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
                        Set<String> set = setKeySet;
                        if (!(set instanceof Collection) || !set.isEmpty()) {
                            Iterator<T> it2 = set.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                if (StringsKt__StringsJVMKt.equals((String) it2.next(), exif.getStr(), true)) {
                                    Set<String> setKeySet2 = asJsonObject2.keySet();
                                    Intrinsics.checkNotNullExpressionValue(setKeySet2, "keySet(...)");
                                    Iterator<T> it3 = setKeySet2.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it3.next();
                                        if (StringsKt__StringsJVMKt.equals((String) next, exif.getStr(), true)) {
                                            break;
                                        }
                                    }
                                    String str = (String) next;
                                    if (str != null && (jsonElement = asJsonObject2.get(str)) != null && (asString = jsonElement.getAsString()) != null) {
                                        linkedHashMap.put(exif, asString);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public final Map<Exif, String> getExifFromSource() {
        return getExif(getRootParentManifestKey());
    }

    @NotNull
    public final List<Action> getFilteredActions(@Nullable List<String> actionType, @Nullable Boolean isAi, @Nullable Boolean isValid) {
        ArrayList arrayList;
        List<Action> allActions = getAllActions();
        if (actionType != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allActions) {
                if (CollectionsKt.contains(actionType, ((Action) obj).getAction())) {
                    arrayList2.add(obj);
                }
            }
            allActions = arrayList2;
        }
        if (isAi != null) {
            if (isAi.booleanValue()) {
                arrayList = new ArrayList();
                for (Object obj2 : allActions) {
                    if (((Action) obj2).isAiGenerated()) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                for (Object obj3 : allActions) {
                    if (!((Action) obj3).isAiGenerated()) {
                        arrayList.add(obj3);
                    }
                }
            }
            allActions = arrayList;
        }
        if (isValid == null) {
            return allActions;
        }
        if (isValid.booleanValue()) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj4 : allActions) {
                if (Intrinsics.areEqual(((Action) obj4).isInvalid(), Boolean.FALSE)) {
                    arrayList3.add(obj4);
                }
            }
            return arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj5 : allActions) {
            if (Intrinsics.areEqual(((Action) obj5).isInvalid(), Boolean.TRUE)) {
                arrayList4.add(obj5);
            }
        }
        return arrayList4;
    }

    @NotNull
    public final List<IngredientManifestInfo> getIngredientManifestInfo(@NotNull String manifestKey) {
        List<Ingredients> listEmptyList;
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        ArrayList arrayList = new ArrayList();
        C2paManifest c2paManifest = this.manifests.get(manifestKey);
        if (c2paManifest == null || (listEmptyList = c2paManifest.getIngredients()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (Ingredients ingredients : listEmptyList) {
            String activeManifest = ingredients.getActiveManifest();
            boolean zAreEqual = Intrinsics.areEqual(ingredients.getRelationship(), PARENT_RELATION);
            if (activeManifest != null) {
                if (zAreEqual) {
                    arrayList.add(0, new IngredientManifestInfo(activeManifest, zAreEqual));
                } else {
                    arrayList.add(new IngredientManifestInfo(activeManifest, zAreEqual));
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final Action getLatestAiAction() {
        Boolean bool = Boolean.TRUE;
        return getLatestAction(getFilteredActions(null, bool, bool));
    }

    @Nullable
    public final Action getLatestEditAction() {
        return (Action) CollectionsKt.lastOrNull((List) getAllEditActions());
    }

    @Nullable
    public final C2paManifest getManifest(@NotNull String manifestKey) {
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        return this.manifests.get(manifestKey);
    }

    @NotNull
    public final List<String> getManifestKeys() {
        return CollectionsKt.toList(this.manifests.keySet());
    }

    @NotNull
    public final Map<String, C2paManifest> getManifests() {
        return this.manifests;
    }

    @NotNull
    public final C2paManifestList getSingleTreeC2paManifestList(@NotNull String manifestKey) {
        Intrinsics.checkNotNullParameter(manifestKey, "manifestKey");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String manifestKey2 = manifestKey;
        while (true) {
            C2paManifest manifest = getManifest(manifestKey2);
            if (manifest == null) {
                break;
            }
            linkedHashMap.put(manifestKey2, manifest);
            List<IngredientManifestInfo> ingredientManifestInfo = getIngredientManifestInfo(manifestKey2);
            if (ingredientManifestInfo.size() != 1) {
                break;
            }
            manifestKey2 = ingredientManifestInfo.get(0).getManifestKey();
        }
        return new C2paManifestList(manifestKey, linkedHashMap);
    }

    @NotNull
    public final C2paManifestList getSingleTreeC2paManifestListLatest() {
        return getSingleTreeC2paManifestList(this.activeManifest);
    }

    @Nullable
    public final Action getSourceAction() {
        String rootParentManifestKey = getRootParentManifestKey();
        for (Action action : getFilteredActions(CollectionsKt.listOf(C2paAction.C2PA_CREATED.getStr()), null, Boolean.TRUE)) {
            if (Intrinsics.areEqual(action.getActiveManifest(), rootParentManifestKey)) {
                return action;
            }
        }
        return null;
    }

    public int hashCode() {
        return this.manifests.hashCode() + (this.activeManifest.hashCode() * 31);
    }

    public final boolean isAiGenerated() {
        List<Action> allValidActions = getAllValidActions();
        if ((allValidActions instanceof Collection) && allValidActions.isEmpty()) {
            return false;
        }
        Iterator<T> it = allValidActions.iterator();
        while (it.hasNext()) {
            if (((Action) it.next()).isAiGenerated()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEdited() {
        List<Action> allValidActions = getAllValidActions();
        if ((allValidActions instanceof Collection) && allValidActions.isEmpty()) {
            return false;
        }
        Iterator<T> it = allValidActions.iterator();
        while (it.hasNext()) {
            if (((Action) it.next()).isEdited()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEnhanced() {
        List<Action> allValidActions = getAllValidActions();
        if ((allValidActions instanceof Collection) && allValidActions.isEmpty()) {
            return false;
        }
        Iterator<T> it = allValidActions.iterator();
        while (it.hasNext()) {
            if (((Action) it.next()).isEnhanced()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "C2paManifestList(activeManifest=" + this.activeManifest + ", manifests=" + this.manifests + ")";
    }

    private final boolean checkInvalid(ValidationResults validationResult) {
        ValidationResultMap activeManifest = validationResult.getActiveManifest();
        List<ValidationStatus> failure = activeManifest != null ? activeManifest.getFailure() : null;
        if (failure == null || failure.isEmpty()) {
            return false;
        }
        ValidationResultMap activeManifest2 = validationResult.getActiveManifest();
        Intrinsics.checkNotNull(activeManifest2);
        List<ValidationStatus> failure2 = activeManifest2.getFailure();
        Intrinsics.checkNotNull(failure2);
        return checkInvalid(failure2);
    }
}
