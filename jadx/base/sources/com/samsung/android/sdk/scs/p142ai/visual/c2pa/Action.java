package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.glance.AbstractC2821a;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b8\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001LB\u0085\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u00104\u001a\u00020\rJ\u0006\u00105\u001a\u00020\rJ\u0006\u00106\u001a\u00020\rJ\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011J\u0012\u00108\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¤\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\r2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b\f\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u0011\u00102\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b3\u0010\u0016¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action;", "", "action", "", "digitalSourceType", "softwareAgentElement", "Lcom/google/gson/JsonElement;", "parameters", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Parameters;", "actionTime", OpenIdProviderConfiguration.SerializedNames.ISSUER, "claimGenerator", "isInvalid", "", "title", "activeManifest", "ingredientsFile", "", "instanceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getDigitalSourceType", "getSoftwareAgentElement", "()Lcom/google/gson/JsonElement;", "getParameters", "()Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Parameters;", "getActionTime", "setActionTime", "getIssuer", "setIssuer", "getClaimGenerator", "setClaimGenerator", "()Ljava/lang/Boolean;", "setInvalid", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "getActiveManifest", "setActiveManifest", "getIngredientsFile", "()Ljava/util/List;", "setIngredientsFile", "(Ljava/util/List;)V", "getInstanceId", "setInstanceId", "softwareAgent", "getSoftwareAgent", "isAiGenerated", "isEnhanced", Constants.IntentExtraName.IS_EDITED, "getAuthorsList", "hasAiSourceType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action;", "equals", "other", "hashCode", "", "toString", "Builder", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nC2paManifest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2paManifest.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/Action\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,449:1\n1611#2,9:450\n1863#2:459\n1864#2:461\n1620#2:462\n1#3:460\n*S KotlinDebug\n*F\n+ 1 C2paManifest.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/Action\n*L\n352#1:450,9\n352#1:459\n352#1:461\n352#1:462\n352#1:460\n*E\n"})
public final /* data */ class Action {

    @Nullable
    private String action;

    @Nullable
    private String actionTime;

    @Nullable
    private String activeManifest;

    @Nullable
    private String claimGenerator;

    @SerializedName("digitalSourceType")
    @Nullable
    private final String digitalSourceType;

    @Nullable
    private List<String> ingredientsFile;

    @SerializedName("instanceId")
    @Nullable
    private String instanceId;

    @Nullable
    private Boolean isInvalid;

    @Nullable
    private String issuer;

    @Nullable
    private final Parameters parameters;

    @SerializedName("softwareAgent")
    @Nullable
    private final JsonElement softwareAgentElement;

    @Nullable
    private String title;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\fJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J:\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action$Builder;", "", "<init>", "()V", "action", "", "digitalSourceType", "softwareAgent", "parameters", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Parameters;", "c2PaAction", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paAction;", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/DigitalSourceType;", "type", "version", "value", "authors", "", "build", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action;", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nC2paManifest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2paManifest.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/Action$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,449:1\n1#2:450\n*E\n"})
    public static final class Builder {

        @Nullable
        private String action;

        @Nullable
        private String digitalSourceType;

        @Nullable
        private Parameters parameters;

        @Nullable
        private String softwareAgent;

        public static /* synthetic */ Builder parameters$default(Builder builder, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return builder.parameters(str, str2, str3, list);
        }

        @NotNull
        public final Builder action(@NotNull C2paAction c2PaAction) {
            Intrinsics.checkNotNullParameter(c2PaAction, "c2PaAction");
            this.action = c2PaAction.getStr();
            return this;
        }

        @NotNull
        public final Action build() {
            String str = this.action;
            String str2 = this.digitalSourceType;
            String str3 = this.softwareAgent;
            return new Action(str, str2, str3 != null ? new JsonPrimitive(str3) : null, this.parameters, null, null, null, null, null, null, null, null);
        }

        @NotNull
        public final Builder digitalSourceType(@NotNull DigitalSourceType digitalSourceType) {
            Intrinsics.checkNotNullParameter(digitalSourceType, "digitalSourceType");
            this.digitalSourceType = digitalSourceType.getUri();
            return this;
        }

        @NotNull
        public final Builder parameters(@Nullable String type, @Nullable String version, @Nullable String value, @Nullable List<String> authors) {
            if (authors == null) {
                this.parameters = new Parameters(null, type, version, value, null);
                return this;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = authors.iterator();
            while (it.hasNext()) {
                arrayList.add(new Author(it.next()));
            }
            this.parameters = new Parameters(null, type, version, value, arrayList);
            return this;
        }

        @NotNull
        public final Builder softwareAgent(@NotNull String softwareAgent) {
            Intrinsics.checkNotNullParameter(softwareAgent, "softwareAgent");
            this.softwareAgent = softwareAgent;
            return this;
        }
    }

    public Action(@Nullable String str, @Nullable String str2, @Nullable JsonElement jsonElement, @Nullable Parameters parameters, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable String str6, @Nullable String str7, @Nullable List<String> list, @Nullable String str8) {
        this.action = str;
        this.digitalSourceType = str2;
        this.softwareAgentElement = jsonElement;
        this.parameters = parameters;
        this.actionTime = str3;
        this.issuer = str4;
        this.claimGenerator = str5;
        this.isInvalid = bool;
        this.title = str6;
        this.activeManifest = str7;
        this.ingredientsFile = list;
        this.instanceId = str8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Action copy$default(Action action, String str, String str2, JsonElement jsonElement, Parameters parameters, String str3, String str4, String str5, Boolean bool, String str6, String str7, List list, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = action.action;
        }
        if ((i & 2) != 0) {
            str2 = action.digitalSourceType;
        }
        if ((i & 4) != 0) {
            jsonElement = action.softwareAgentElement;
        }
        if ((i & 8) != 0) {
            parameters = action.parameters;
        }
        if ((i & 16) != 0) {
            str3 = action.actionTime;
        }
        if ((i & 32) != 0) {
            str4 = action.issuer;
        }
        if ((i & 64) != 0) {
            str5 = action.claimGenerator;
        }
        if ((i & 128) != 0) {
            bool = action.isInvalid;
        }
        if ((i & 256) != 0) {
            str6 = action.title;
        }
        if ((i & 512) != 0) {
            str7 = action.activeManifest;
        }
        if ((i & 1024) != 0) {
            list = action.ingredientsFile;
        }
        if ((i & 2048) != 0) {
            str8 = action.instanceId;
        }
        List list2 = list;
        String str9 = str8;
        String str10 = str6;
        String str11 = str7;
        String str12 = str5;
        Boolean bool2 = bool;
        String str13 = str3;
        String str14 = str4;
        return action.copy(str, str2, jsonElement, parameters, str13, str14, str12, bool2, str10, str11, list2, str9);
    }

    private final boolean hasAiSourceType(String digitalSourceType) {
        if (digitalSourceType == null) {
            return false;
        }
        return StringsKt.m14162r(digitalSourceType, DigitalSourceType.TRAINED_ALGORITHMIC_MEDIA.getUri()) || StringsKt.m14162r(digitalSourceType, DigitalSourceType.C2PA_TRAINED_ALGORITHMIC_MEDIA_NEW.getUri()) || StringsKt.m14162r(digitalSourceType, DigitalSourceType.C2PA_TRAINED_ALGORITHMIC_MEDIA_OLD.getUri()) || StringsKt.m14162r(digitalSourceType, DigitalSourceType.COMPOSITE_SYNTHETIC.getUri()) || StringsKt.m14162r(digitalSourceType, DigitalSourceType.COMPOSITE_WITH_TRAINED_ALGORITHMIC_MEDIA.getUri());
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getActiveManifest() {
        return this.activeManifest;
    }

    @Nullable
    public final List<String> component11() {
        return this.ingredientsFile;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDigitalSourceType() {
        return this.digitalSourceType;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JsonElement getSoftwareAgentElement() {
        return this.softwareAgentElement;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Parameters getParameters() {
        return this.parameters;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getActionTime() {
        return this.actionTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIssuer() {
        return this.issuer;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getClaimGenerator() {
        return this.claimGenerator;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsInvalid() {
        return this.isInvalid;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final Action copy(@Nullable String action, @Nullable String digitalSourceType, @Nullable JsonElement softwareAgentElement, @Nullable Parameters parameters, @Nullable String actionTime, @Nullable String issuer, @Nullable String claimGenerator, @Nullable Boolean isInvalid, @Nullable String title, @Nullable String activeManifest, @Nullable List<String> ingredientsFile, @Nullable String instanceId) {
        return new Action(action, digitalSourceType, softwareAgentElement, parameters, actionTime, issuer, claimGenerator, isInvalid, title, activeManifest, ingredientsFile, instanceId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Action)) {
            return false;
        }
        Action action = (Action) other;
        return Intrinsics.areEqual(this.action, action.action) && Intrinsics.areEqual(this.digitalSourceType, action.digitalSourceType) && Intrinsics.areEqual(this.softwareAgentElement, action.softwareAgentElement) && Intrinsics.areEqual(this.parameters, action.parameters) && Intrinsics.areEqual(this.actionTime, action.actionTime) && Intrinsics.areEqual(this.issuer, action.issuer) && Intrinsics.areEqual(this.claimGenerator, action.claimGenerator) && Intrinsics.areEqual(this.isInvalid, action.isInvalid) && Intrinsics.areEqual(this.title, action.title) && Intrinsics.areEqual(this.activeManifest, action.activeManifest) && Intrinsics.areEqual(this.ingredientsFile, action.ingredientsFile) && Intrinsics.areEqual(this.instanceId, action.instanceId);
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final String getActionTime() {
        return this.actionTime;
    }

    @Nullable
    public final String getActiveManifest() {
        return this.activeManifest;
    }

    @NotNull
    public final List<String> getAuthorsList() {
        ArrayList arrayList;
        List<Author> author;
        Parameters parameters = this.parameters;
        if (parameters == null || (author = parameters.getAuthor()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            Iterator<T> it = author.iterator();
            while (it.hasNext()) {
                String name = ((Author) it.next()).getName();
                if (name != null) {
                    arrayList.add(name);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    @Nullable
    public final String getClaimGenerator() {
        return this.claimGenerator;
    }

    @Nullable
    public final String getDigitalSourceType() {
        return this.digitalSourceType;
    }

    @Nullable
    public final List<String> getIngredientsFile() {
        return this.ingredientsFile;
    }

    @Nullable
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Nullable
    public final String getIssuer() {
        return this.issuer;
    }

    @Nullable
    public final Parameters getParameters() {
        return this.parameters;
    }

    @NotNull
    public final String getSoftwareAgent() {
        JsonElement jsonElement = this.softwareAgentElement;
        if (jsonElement != null && jsonElement.isJsonPrimitive()) {
            String asString = this.softwareAgentElement.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
            return asString;
        }
        JsonElement jsonElement2 = this.softwareAgentElement;
        if (jsonElement2 == null || !jsonElement2.isJsonObject() || !this.softwareAgentElement.getAsJsonObject().has("name")) {
            return "";
        }
        String asString2 = this.softwareAgentElement.getAsJsonObject().get("name").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString2, "getAsString(...)");
        return asString2;
    }

    @Nullable
    public final JsonElement getSoftwareAgentElement() {
        return this.softwareAgentElement;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.action;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.digitalSourceType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonElement jsonElement = this.softwareAgentElement;
        int iHashCode3 = (iHashCode2 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        Parameters parameters = this.parameters;
        int iHashCode4 = (iHashCode3 + (parameters == null ? 0 : parameters.hashCode())) * 31;
        String str3 = this.actionTime;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.issuer;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.claimGenerator;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isInvalid;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.title;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.activeManifest;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<String> list = this.ingredientsFile;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str8 = this.instanceId;
        return iHashCode11 + (str8 != null ? str8.hashCode() : 0);
    }

    public final boolean isAiGenerated() {
        String str;
        Ingredient ingredient;
        if (!hasAiSourceType(this.digitalSourceType)) {
            Parameters parameters = this.parameters;
            if (!hasAiSourceType((parameters == null || (ingredient = parameters.getIngredient()) == null) ? null : ingredient.getDigitalSourceType()) || (str = this.action) == null || !StringsKt.m14162r(str, C2paAction.C2PA_PLACED.getStr())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEdited() {
        String str = this.action;
        if (str == null) {
            return false;
        }
        return StringsKt.m14162r(str, C2paAction.C2PA_EDITED.getStr());
    }

    public final boolean isEnhanced() {
        String str = this.digitalSourceType;
        if (str == null) {
            return false;
        }
        return StringsKt.m14162r(str, DigitalSourceType.ALGORITHMICALLY_ENHANCED.getUri());
    }

    @Nullable
    public final Boolean isInvalid() {
        return this.isInvalid;
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
    }

    public final void setActionTime(@Nullable String str) {
        this.actionTime = str;
    }

    public final void setActiveManifest(@Nullable String str) {
        this.activeManifest = str;
    }

    public final void setClaimGenerator(@Nullable String str) {
        this.claimGenerator = str;
    }

    public final void setIngredientsFile(@Nullable List<String> list) {
        this.ingredientsFile = list;
    }

    public final void setInstanceId(@Nullable String str) {
        this.instanceId = str;
    }

    public final void setInvalid(@Nullable Boolean bool) {
        this.isInvalid = bool;
    }

    public final void setIssuer(@Nullable String str) {
        this.issuer = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.action;
        String str2 = this.digitalSourceType;
        JsonElement jsonElement = this.softwareAgentElement;
        Parameters parameters = this.parameters;
        String str3 = this.actionTime;
        String str4 = this.issuer;
        String str5 = this.claimGenerator;
        Boolean bool = this.isInvalid;
        String str6 = this.title;
        String str7 = this.activeManifest;
        List<String> list = this.ingredientsFile;
        String str8 = this.instanceId;
        StringBuilder sbM16m = AbstractC0000a.m16m("Action(action=", str, ", digitalSourceType=", str2, ", softwareAgentElement=");
        sbM16m.append(jsonElement);
        sbM16m.append(", parameters=");
        sbM16m.append(parameters);
        sbM16m.append(", actionTime=");
        AbstractC2821a.m2207B(sbM16m, str3, ", issuer=", str4, ", claimGenerator=");
        sbM16m.append(str5);
        sbM16m.append(", isInvalid=");
        sbM16m.append(bool);
        sbM16m.append(", title=");
        AbstractC2821a.m2207B(sbM16m, str6, ", activeManifest=", str7, ", ingredientsFile=");
        sbM16m.append(list);
        sbM16m.append(", instanceId=");
        sbM16m.append(str8);
        sbM16m.append(")");
        return sbM16m.toString();
    }
}
