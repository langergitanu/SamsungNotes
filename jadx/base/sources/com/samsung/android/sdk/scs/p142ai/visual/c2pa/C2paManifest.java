package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001?B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0005J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0012HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u009d\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u00122\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifest;", "", "claimGenerator", "", "claimGeneratorInfo", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ClaimGeneratorInfo;", "title", "format", "instanceId", "ingredients", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Ingredients;", "assertions", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paAssertion;", "signatureInfo", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/SignatureInfo;", "label", "isInvalid", "", "assertionsJsonArray", "Lcom/google/gson/JsonArray;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/samsung/android/sdk/scs/ai/visual/c2pa/SignatureInfo;Ljava/lang/String;ZLcom/google/gson/JsonArray;)V", "getClaimGenerator", "()Ljava/lang/String;", "getClaimGeneratorInfo", "()Ljava/util/List;", "setClaimGeneratorInfo", "(Ljava/util/List;)V", DynamicActionBarProvider.METHOD_GET_DATA, "getFormat", "getInstanceId", "getIngredients", "getAssertions", "getSignatureInfo", "()Lcom/samsung/android/sdk/scs/ai/visual/c2pa/SignatureInfo;", "getLabel", "()Z", "setInvalid", "(Z)V", "getAssertionsJsonArray", "()Lcom/google/gson/JsonArray;", "setAssertionsJsonArray", "(Lcom/google/gson/JsonArray;)V", "getActions", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "Builder", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nC2paManifest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2paManifest.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifest\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,449:1\n1611#2,9:450\n1863#2:459\n1864#2:461\n1620#2:462\n1611#2,9:464\n1863#2:473\n1864#2:475\n1620#2:476\n1#3:460\n1#3:463\n1#3:474\n*S KotlinDebug\n*F\n+ 1 C2paManifest.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifest\n*L\n103#1:450,9\n103#1:459\n103#1:461\n103#1:462\n114#1:464,9\n114#1:473\n114#1:475\n114#1:476\n103#1:460\n114#1:474\n*E\n"})
public final /* data */ class C2paManifest {

    @Nullable
    private final List<C2paAssertion> assertions;

    @Nullable
    private JsonArray assertionsJsonArray;

    @Nullable
    private final String claimGenerator;

    @Nullable
    private List<ClaimGeneratorInfo> claimGeneratorInfo;

    @Nullable
    private final String format;

    @Nullable
    private final List<Ingredients> ingredients;

    @Nullable
    private final String instanceId;
    private boolean isInvalid;

    @Nullable
    private final String label;

    @Nullable
    private final SignatureInfo signatureInfo;

    @Nullable
    private final String title;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifest$Builder;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "claimGenerator", "assertions", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paAssertion;", "addAssertion", AbstractJwtRequest.ClaimNames.ASSERTION, "build", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nC2paManifest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2paManifest.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paManifest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,449:1\n1#2:450\n*E\n"})
    public static final class Builder {

        @Nullable
        private String TAG = Reflection.getOrCreateKotlinClass(Builder.class).getSimpleName();

        @NotNull
        private String claimGenerator = Constant.CLAIM_GENERATOR;

        @NotNull
        private List<C2paAssertion> assertions = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence build$lambda$2(C2paAssertion it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Data data = it.getData();
            List<Action> actions = data != null ? data.getActions() : null;
            if (actions == null) {
                actions = CollectionsKt.emptyList();
            }
            return CollectionsKt.asSequence(actions);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String build$lambda$3(Action it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getAction();
        }

        @NotNull
        public final Builder addAssertion(@NotNull C2paAssertion assertion) {
            Intrinsics.checkNotNullParameter(assertion, "assertion");
            this.assertions.add(assertion);
            return this;
        }

        @NotNull
        public final String build() {
            boolean zContains = CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{C2paAction.C2PA_CREATED.getStr(), C2paAction.C2PA_OPENED.getStr()}), SequencesKt.firstOrNull(SequencesKt.map(SequencesKt.flatMap(CollectionsKt.asSequence(this.assertions), new C0348a(1)), new C0348a(2))));
            if (!zContains) {
                Log.m6487e(this.TAG, "firstActionCheck = " + zContains + "c2pa.created or c2pa.opened should used for the first action in the manifest of c2pa V2 onlyIgnore this error for c2pa V1");
            }
            String json = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create().toJson(new C2paManifest(this.claimGenerator, null, null, null, null, null, this.assertions, null, null, false, null));
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            return json;
        }

        @NotNull
        public final Builder claimGenerator(@NotNull String claimGenerator) {
            Intrinsics.checkNotNullParameter(claimGenerator, "claimGenerator");
            this.claimGenerator = claimGenerator;
            return this;
        }
    }

    public C2paManifest(@Nullable String str, @Nullable List<ClaimGeneratorInfo> list, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<Ingredients> list2, @Nullable List<C2paAssertion> list3, @Nullable SignatureInfo signatureInfo, @Nullable String str5, boolean z, @Nullable JsonArray jsonArray) {
        this.claimGenerator = str;
        this.claimGeneratorInfo = list;
        this.title = str2;
        this.format = str3;
        this.instanceId = str4;
        this.ingredients = list2;
        this.assertions = list3;
        this.signatureInfo = signatureInfo;
        this.label = str5;
        this.isInvalid = z;
        this.assertionsJsonArray = jsonArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2paManifest copy$default(C2paManifest c2paManifest, String str, List list, String str2, String str3, String str4, List list2, List list3, SignatureInfo signatureInfo, String str5, boolean z, JsonArray jsonArray, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c2paManifest.claimGenerator;
        }
        if ((i & 2) != 0) {
            list = c2paManifest.claimGeneratorInfo;
        }
        if ((i & 4) != 0) {
            str2 = c2paManifest.title;
        }
        if ((i & 8) != 0) {
            str3 = c2paManifest.format;
        }
        if ((i & 16) != 0) {
            str4 = c2paManifest.instanceId;
        }
        if ((i & 32) != 0) {
            list2 = c2paManifest.ingredients;
        }
        if ((i & 64) != 0) {
            list3 = c2paManifest.assertions;
        }
        if ((i & 128) != 0) {
            signatureInfo = c2paManifest.signatureInfo;
        }
        if ((i & 256) != 0) {
            str5 = c2paManifest.label;
        }
        if ((i & 512) != 0) {
            z = c2paManifest.isInvalid;
        }
        if ((i & 1024) != 0) {
            jsonArray = c2paManifest.assertionsJsonArray;
        }
        boolean z2 = z;
        JsonArray jsonArray2 = jsonArray;
        SignatureInfo signatureInfo2 = signatureInfo;
        String str6 = str5;
        List list4 = list2;
        List list5 = list3;
        String str7 = str4;
        String str8 = str2;
        return c2paManifest.copy(str, list, str8, str3, str7, list4, list5, signatureInfo2, str6, z2, jsonArray2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClaimGenerator() {
        return this.claimGenerator;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsInvalid() {
        return this.isInvalid;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final JsonArray getAssertionsJsonArray() {
        return this.assertionsJsonArray;
    }

    @Nullable
    public final List<ClaimGeneratorInfo> component2() {
        return this.claimGeneratorInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Nullable
    public final List<Ingredients> component6() {
        return this.ingredients;
    }

    @Nullable
    public final List<C2paAssertion> component7() {
        return this.assertions;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SignatureInfo getSignatureInfo() {
        return this.signatureInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final C2paManifest copy(@Nullable String claimGenerator, @Nullable List<ClaimGeneratorInfo> claimGeneratorInfo, @Nullable String title, @Nullable String format, @Nullable String instanceId, @Nullable List<Ingredients> ingredients, @Nullable List<C2paAssertion> assertions, @Nullable SignatureInfo signatureInfo, @Nullable String label, boolean isInvalid, @Nullable JsonArray assertionsJsonArray) {
        return new C2paManifest(claimGenerator, claimGeneratorInfo, title, format, instanceId, ingredients, assertions, signatureInfo, label, isInvalid, assertionsJsonArray);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C2paManifest)) {
            return false;
        }
        C2paManifest c2paManifest = (C2paManifest) other;
        return Intrinsics.areEqual(this.claimGenerator, c2paManifest.claimGenerator) && Intrinsics.areEqual(this.claimGeneratorInfo, c2paManifest.claimGeneratorInfo) && Intrinsics.areEqual(this.title, c2paManifest.title) && Intrinsics.areEqual(this.format, c2paManifest.format) && Intrinsics.areEqual(this.instanceId, c2paManifest.instanceId) && Intrinsics.areEqual(this.ingredients, c2paManifest.ingredients) && Intrinsics.areEqual(this.assertions, c2paManifest.assertions) && Intrinsics.areEqual(this.signatureInfo, c2paManifest.signatureInfo) && Intrinsics.areEqual(this.label, c2paManifest.label) && this.isInvalid == c2paManifest.isInvalid && Intrinsics.areEqual(this.assertionsJsonArray, c2paManifest.assertionsJsonArray);
    }

    @NotNull
    public final List<Action> getActions() {
        String time;
        String issuer;
        String strM757C;
        List<String> listEmptyList;
        ClaimGeneratorInfo claimGeneratorInfo;
        List<C2paAssertion> list = this.assertions;
        List listEmptyList2 = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Data data = ((C2paAssertion) it.next()).getData();
                List<Action> actions = data != null ? data.getActions() : null;
                if (actions != null) {
                    arrayList.add(actions);
                }
            }
            listEmptyList2 = arrayList;
        }
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        List<Action> listFlatten = CollectionsKt.flatten(listEmptyList2);
        if (!listFlatten.isEmpty()) {
            for (Action action : listFlatten) {
                SignatureInfo signatureInfo = this.signatureInfo;
                if (signatureInfo == null || (time = signatureInfo.getTime()) == null) {
                    time = C2paManifestList.UNKNOWN_TIME;
                }
                action.setActionTime(time);
                SignatureInfo signatureInfo2 = this.signatureInfo;
                if (signatureInfo2 == null || (issuer = signatureInfo2.getIssuer()) == null) {
                    issuer = "Unknown";
                }
                action.setIssuer(issuer);
                List<ClaimGeneratorInfo> list2 = this.claimGeneratorInfo;
                action.setClaimGenerator(((list2 == null || (claimGeneratorInfo = (ClaimGeneratorInfo) CollectionsKt.firstOrNull((List) list2)) == null || (strM757C = AbstractC0541b.m757C(claimGeneratorInfo.getName(), " ", claimGeneratorInfo.getVersion())) == null) && (strM757C = this.claimGenerator) == null) ? "Unknown" : strM757C);
                action.setInvalid(Boolean.valueOf(this.isInvalid));
                action.setTitle(this.title);
                List<Ingredients> list3 = this.ingredients;
                if (list3 != null) {
                    listEmptyList = new ArrayList<>();
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        String title = ((Ingredients) it2.next()).getTitle();
                        if (title != null) {
                            listEmptyList.add(title);
                        }
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                action.setIngredientsFile(listEmptyList);
            }
        }
        return listFlatten;
    }

    @Nullable
    public final List<C2paAssertion> getAssertions() {
        return this.assertions;
    }

    @Nullable
    public final JsonArray getAssertionsJsonArray() {
        return this.assertionsJsonArray;
    }

    @Nullable
    public final String getClaimGenerator() {
        return this.claimGenerator;
    }

    @Nullable
    public final List<ClaimGeneratorInfo> getClaimGeneratorInfo() {
        return this.claimGeneratorInfo;
    }

    @Nullable
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    public final List<Ingredients> getIngredients() {
        return this.ingredients;
    }

    @Nullable
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final SignatureInfo getSignatureInfo() {
        return this.signatureInfo;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.claimGenerator;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ClaimGeneratorInfo> list = this.claimGeneratorInfo;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.format;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.instanceId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<Ingredients> list2 = this.ingredients;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<C2paAssertion> list3 = this.assertions;
        int iHashCode7 = (iHashCode6 + (list3 == null ? 0 : list3.hashCode())) * 31;
        SignatureInfo signatureInfo = this.signatureInfo;
        int iHashCode8 = (iHashCode7 + (signatureInfo == null ? 0 : signatureInfo.hashCode())) * 31;
        String str5 = this.label;
        int iM1160f = AbstractC0622a.m1160f(this.isInvalid, (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31, 31);
        JsonArray jsonArray = this.assertionsJsonArray;
        return iM1160f + (jsonArray != null ? jsonArray.hashCode() : 0);
    }

    public final boolean isInvalid() {
        return this.isInvalid;
    }

    public final void setAssertionsJsonArray(@Nullable JsonArray jsonArray) {
        this.assertionsJsonArray = jsonArray;
    }

    public final void setClaimGeneratorInfo(@Nullable List<ClaimGeneratorInfo> list) {
        this.claimGeneratorInfo = list;
    }

    public final void setInvalid(boolean z) {
        this.isInvalid = z;
    }

    @NotNull
    public String toString() {
        String str = this.claimGenerator;
        List<ClaimGeneratorInfo> list = this.claimGeneratorInfo;
        String str2 = this.title;
        String str3 = this.format;
        String str4 = this.instanceId;
        List<Ingredients> list2 = this.ingredients;
        List<C2paAssertion> list3 = this.assertions;
        SignatureInfo signatureInfo = this.signatureInfo;
        String str5 = this.label;
        boolean z = this.isInvalid;
        JsonArray jsonArray = this.assertionsJsonArray;
        StringBuilder sb = new StringBuilder("C2paManifest(claimGenerator=");
        sb.append(str);
        sb.append(", claimGeneratorInfo=");
        sb.append(list);
        sb.append(", title=");
        AbstractC2821a.m2207B(sb, str2, ", format=", str3, ", instanceId=");
        sb.append(str4);
        sb.append(", ingredients=");
        sb.append(list2);
        sb.append(", assertions=");
        sb.append(list3);
        sb.append(", signatureInfo=");
        sb.append(signatureInfo);
        sb.append(", label=");
        sb.append(str5);
        sb.append(", isInvalid=");
        sb.append(z);
        sb.append(", assertionsJsonArray=");
        sb.append(jsonArray);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ C2paManifest(String str, List list, String str2, String str3, String str4, List list2, List list3, SignatureInfo signatureInfo, String str5, boolean z, JsonArray jsonArray, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2, str3, str4, list2, list3, signatureInfo, str5, (i & 512) != 0 ? false : z, jsonArray);
    }
}
