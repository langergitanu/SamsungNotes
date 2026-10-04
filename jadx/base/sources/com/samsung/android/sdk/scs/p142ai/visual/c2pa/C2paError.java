package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import p123b3.C4202b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b;\b\u0086\u0081\u0002\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001=B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paError;", "", "errString", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrString", "()Ljava/lang/String;", "NO_C2PA_MANIFEST", "CLAIM_MISSING", "CLAIM_MULTIPLE", "HARD_BINDINGS_MISSING", "CLAIM_REQUIRED_MISSING", "CLAIM_CBOR_INVALID", "INGREDIENT_HASHEDURI_MISMATCH", "CLAIM_SIGNATURE_MISSING", "CLAIM_SIGNATURE_MISMATCH", "MANIFEST_INACCESSIBLE", "MANIFEST_MULTIPLE_PARENTS", "MANIFEST_UPDATE_INVALID", "MANIFEST_UPDATE_WRONG_PARENTS", "SIGNING_CREDENTIAL_UNTRUSTED", "SIGNING_CREDENTIAL_INVALID", "SIGNING_CREDENTIAL_REVOKED", "SIGNING_CREDENTIAL_EXPIRED", "TIMESTAMP_MISMATCH", "TIMESTAMP_UNTRUSTED", "TIMESTAMP_OUTSIDE_VALIDITY", "ASSERTION_HASHEDURI_MISMATCH", "ASSERTION_MISSING", "ASSERTION_UNDECLARED", "ASSERTION_INACCESSIBLE", "ASSERTION_NOT_REDACTED", "ASSERTION_SELF_REDACTED", "ASSERTION_REQUIRED_MISSING", "ASSERTION_JSON_INVALID", "ASSERTION_CBOR_INVALID", "ACTION_ASSERTION_INGREDIENT_MISMATCH", "ACTION_ASSERTION_REDACTED", "ASSERTION_DATAHASH_MISMATCH", "ASSERTION_BMFFHASH_MISMATCH", "ASSERTION_BOXHASH_MISMATCH", "ASSERTION_BOXHASH_UNKNOWN", "ASSERTION_CLOUD_DATA_HARD_BINDING", "ASSERTION_CLOUD_DATA_ACTIONS", "ALGORITHM_UNSUPPORTED", "GENERAL_ERROR", "OLD_VERSION", "UNSUPPORTED_TYPE", "INVALID_CLAIM_SIGNATURE", "INVALID_PATH", "MANIFEST_PARSING_ERROR", "INVALID_SIGN_ALG", "C2PA_ERROR_UNKNOWN", "SERVICE_NOT_INITIALIZED", "INVALID_PARENT_PATH", "INVALID_INGREDIENT_PATH", "INTERNAL_SERVICE_ERROR", "PFD_READ_ERROR", "MISSING_CONFIG_ERROR", "TRUST_SET_ERROR", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class C2paError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ C2paError[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private final String errString;
    public static final C2paError NO_C2PA_MANIFEST = new C2paError("NO_C2PA_MANIFEST", 0, "no JUMBF data found");
    public static final C2paError CLAIM_MISSING = new C2paError("CLAIM_MISSING", 1, "claim.missing");
    public static final C2paError CLAIM_MULTIPLE = new C2paError("CLAIM_MULTIPLE", 2, "claim.multiple");
    public static final C2paError HARD_BINDINGS_MISSING = new C2paError("HARD_BINDINGS_MISSING", 3, "claim.hardBindings.missing");
    public static final C2paError CLAIM_REQUIRED_MISSING = new C2paError("CLAIM_REQUIRED_MISSING", 4, "claim.required.missing");
    public static final C2paError CLAIM_CBOR_INVALID = new C2paError("CLAIM_CBOR_INVALID", 5, "claim.cbor.invalid");
    public static final C2paError INGREDIENT_HASHEDURI_MISMATCH = new C2paError("INGREDIENT_HASHEDURI_MISMATCH", 6, "ingredient.hashedURI.mismatch");
    public static final C2paError CLAIM_SIGNATURE_MISSING = new C2paError("CLAIM_SIGNATURE_MISSING", 7, "claimSignature.missing");
    public static final C2paError CLAIM_SIGNATURE_MISMATCH = new C2paError("CLAIM_SIGNATURE_MISMATCH", 8, "claimSignature.mismatch");
    public static final C2paError MANIFEST_INACCESSIBLE = new C2paError("MANIFEST_INACCESSIBLE", 9, "manifest.inaccessible");
    public static final C2paError MANIFEST_MULTIPLE_PARENTS = new C2paError("MANIFEST_MULTIPLE_PARENTS", 10, "manifest.multipleParents");
    public static final C2paError MANIFEST_UPDATE_INVALID = new C2paError("MANIFEST_UPDATE_INVALID", 11, "manifest.update.invalid");
    public static final C2paError MANIFEST_UPDATE_WRONG_PARENTS = new C2paError("MANIFEST_UPDATE_WRONG_PARENTS", 12, "manifest.update.wrongParents");
    public static final C2paError SIGNING_CREDENTIAL_UNTRUSTED = new C2paError("SIGNING_CREDENTIAL_UNTRUSTED", 13, "signingCredential.untrusted");
    public static final C2paError SIGNING_CREDENTIAL_INVALID = new C2paError("SIGNING_CREDENTIAL_INVALID", 14, "signingCredential.invalid");
    public static final C2paError SIGNING_CREDENTIAL_REVOKED = new C2paError("SIGNING_CREDENTIAL_REVOKED", 15, "signingCredential.revoked");
    public static final C2paError SIGNING_CREDENTIAL_EXPIRED = new C2paError("SIGNING_CREDENTIAL_EXPIRED", 16, "signingCredential.expired");
    public static final C2paError TIMESTAMP_MISMATCH = new C2paError("TIMESTAMP_MISMATCH", 17, "timeStamp.mismatch");
    public static final C2paError TIMESTAMP_UNTRUSTED = new C2paError("TIMESTAMP_UNTRUSTED", 18, "timeStamp.untrusted");
    public static final C2paError TIMESTAMP_OUTSIDE_VALIDITY = new C2paError("TIMESTAMP_OUTSIDE_VALIDITY", 19, "timeStamp.outsideValidity");
    public static final C2paError ASSERTION_HASHEDURI_MISMATCH = new C2paError("ASSERTION_HASHEDURI_MISMATCH", 20, "assertion.hashedURI.mismatch");
    public static final C2paError ASSERTION_MISSING = new C2paError("ASSERTION_MISSING", 21, "assertion.missing");
    public static final C2paError ASSERTION_UNDECLARED = new C2paError("ASSERTION_UNDECLARED", 22, "assertion.undeclared");
    public static final C2paError ASSERTION_INACCESSIBLE = new C2paError("ASSERTION_INACCESSIBLE", 23, "assertion.inaccessible");
    public static final C2paError ASSERTION_NOT_REDACTED = new C2paError("ASSERTION_NOT_REDACTED", 24, "assertion.notRedacted");
    public static final C2paError ASSERTION_SELF_REDACTED = new C2paError("ASSERTION_SELF_REDACTED", 25, "assertion.selfRedacted");
    public static final C2paError ASSERTION_REQUIRED_MISSING = new C2paError("ASSERTION_REQUIRED_MISSING", 26, "assertion.required.missing");
    public static final C2paError ASSERTION_JSON_INVALID = new C2paError("ASSERTION_JSON_INVALID", 27, "assertion.json.invalid");
    public static final C2paError ASSERTION_CBOR_INVALID = new C2paError("ASSERTION_CBOR_INVALID", 28, "assertion.cbor.invalid");
    public static final C2paError ACTION_ASSERTION_INGREDIENT_MISMATCH = new C2paError("ACTION_ASSERTION_INGREDIENT_MISMATCH", 29, "assertion.action.ingredientMismatch");
    public static final C2paError ACTION_ASSERTION_REDACTED = new C2paError("ACTION_ASSERTION_REDACTED", 30, "assertion.action.redacted");
    public static final C2paError ASSERTION_DATAHASH_MISMATCH = new C2paError("ASSERTION_DATAHASH_MISMATCH", 31, "assertion.dataHash.mismatch");
    public static final C2paError ASSERTION_BMFFHASH_MISMATCH = new C2paError("ASSERTION_BMFFHASH_MISMATCH", 32, "assertion.bmffHash.mismatch");
    public static final C2paError ASSERTION_BOXHASH_MISMATCH = new C2paError("ASSERTION_BOXHASH_MISMATCH", 33, "assertion.boxesHash.mismatch");
    public static final C2paError ASSERTION_BOXHASH_UNKNOWN = new C2paError("ASSERTION_BOXHASH_UNKNOWN", 34, "::assertion.boxesHash.");
    public static final C2paError ASSERTION_CLOUD_DATA_HARD_BINDING = new C2paError("ASSERTION_CLOUD_DATA_HARD_BINDING", 35, "assertion.cloud-data.hardBinding");
    public static final C2paError ASSERTION_CLOUD_DATA_ACTIONS = new C2paError("ASSERTION_CLOUD_DATA_ACTIONS", 36, "assertion.cloud-data.actions");
    public static final C2paError ALGORITHM_UNSUPPORTED = new C2paError("ALGORITHM_UNSUPPORTED", 37, "algorithm.unsupported");
    public static final C2paError GENERAL_ERROR = new C2paError("GENERAL_ERROR", 38, "general.error");
    public static final C2paError OLD_VERSION = new C2paError("OLD_VERSION", 39, "prerelease content detected");
    public static final C2paError UNSUPPORTED_TYPE = new C2paError("UNSUPPORTED_TYPE", 40, "type is unsupported");
    public static final C2paError INVALID_CLAIM_SIGNATURE = new C2paError("INVALID_CLAIM_SIGNATURE", 41, "claim signature");
    public static final C2paError INVALID_PATH = new C2paError("INVALID_PATH", 42, "invalid path");
    public static final C2paError MANIFEST_PARSING_ERROR = new C2paError("MANIFEST_PARSING_ERROR", 43, "ManifestParsingError");
    public static final C2paError INVALID_SIGN_ALG = new C2paError("INVALID_SIGN_ALG", 44, "InvalidSignAlg");
    public static final C2paError C2PA_ERROR_UNKNOWN = new C2paError("C2PA_ERROR_UNKNOWN", 45, "C2PAUnKnown");
    public static final C2paError SERVICE_NOT_INITIALIZED = new C2paError("SERVICE_NOT_INITIALIZED", 46, "ServiceNotInitialized");
    public static final C2paError INVALID_PARENT_PATH = new C2paError("INVALID_PARENT_PATH", 47, "ParentPathSetError");
    public static final C2paError INVALID_INGREDIENT_PATH = new C2paError("INVALID_INGREDIENT_PATH", 48, "IngredietPathError");
    public static final C2paError INTERNAL_SERVICE_ERROR = new C2paError("INTERNAL_SERVICE_ERROR", 49, "InternalServiceError");
    public static final C2paError PFD_READ_ERROR = new C2paError("PFD_READ_ERROR", 50, "PfdReadError");
    public static final C2paError MISSING_CONFIG_ERROR = new C2paError("MISSING_CONFIG_ERROR", 51, "MissingConfigError");
    public static final C2paError TRUST_SET_ERROR = new C2paError("TRUST_SET_ERROR", 52, "TrustSetError");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Keep
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paError$Companion;", "", "<init>", "()V", "fromErrorString", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paError;", "errString", "", "checkInvalidV1", "", "checkInvalidV2", "checkInvalid", "soVersion", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paSoVersionInfo;", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nC2paError.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2paError.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paError$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n1755#2,3:136\n1782#2,4:139\n1782#2,4:143\n1782#2,4:147\n1782#2,4:151\n1782#2,4:155\n1782#2,4:159\n1782#2,4:163\n*S KotlinDebug\n*F\n+ 1 C2paError.kt\ncom/samsung/android/sdk/scs/ai/visual/c2pa/C2paError$Companion\n*L\n78#1:136,3\n93#1:139,4\n94#1:143,4\n95#1:147,4\n96#1:151,4\n109#1:155,4\n114#1:159,4\n115#1:163,4\n*E\n"})
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[C2paSoVersionInfo.values().length];
                try {
                    iArr[C2paSoVersionInfo.f5250V2.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[C2paSoVersionInfo.f5249V1.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean checkInvalidV1(String errString) {
            int i;
            int i2;
            int i4;
            int i5;
            List<C2paError> listFromErrorString = fromErrorString(errString);
            List<C2paError> list = listFromErrorString;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!SetsKt.setOf((Object[]) new C2paError[]{C2paError.CLAIM_SIGNATURE_MISMATCH, C2paError.SIGNING_CREDENTIAL_UNTRUSTED, C2paError.GENERAL_ERROR}).contains((C2paError) it.next())) {
                        return true;
                    }
                }
            }
            if (listFromErrorString.contains(C2paError.CLAIM_SIGNATURE_MISMATCH) && !listFromErrorString.contains(C2paError.SIGNING_CREDENTIAL_UNTRUSTED)) {
                return true;
            }
            List<C2paError> list2 = listFromErrorString;
            boolean z = list2 instanceof Collection;
            if (z && list2.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it2 = list2.iterator();
                i = 0;
                while (it2.hasNext()) {
                    if (((C2paError) it2.next()) == C2paError.SIGNING_CREDENTIAL_UNTRUSTED && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (z && list2.isEmpty()) {
                i2 = 0;
            } else {
                Iterator<T> it3 = list2.iterator();
                i2 = 0;
                while (it3.hasNext()) {
                    if (((C2paError) it3.next()) == C2paError.GENERAL_ERROR && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i != i2) {
                if (z && list2.isEmpty()) {
                    i4 = 0;
                } else {
                    Iterator<T> it4 = list2.iterator();
                    i4 = 0;
                    while (it4.hasNext()) {
                        if (((C2paError) it4.next()) == C2paError.SIGNING_CREDENTIAL_UNTRUSTED && (i4 = i4 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                if (z && list2.isEmpty()) {
                    i5 = 0;
                } else {
                    Iterator<T> it5 = list2.iterator();
                    i5 = 0;
                    while (it5.hasNext()) {
                        if (((C2paError) it5.next()) == C2paError.CLAIM_SIGNATURE_MISMATCH && (i5 = i5 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                if (i4 != i5) {
                    return true;
                }
            }
            return false;
        }

        private final boolean checkInvalidV2(String errString) {
            int i;
            int i2;
            int i4;
            List mutableList = CollectionsKt.toMutableList((Collection) fromErrorString(errString));
            if (mutableList.isEmpty()) {
                return false;
            }
            List<C2paError> list = mutableList;
            boolean z = list instanceof Collection;
            if (z && list.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                for (C2paError c2paError : list) {
                    if (c2paError != C2paError.SIGNING_CREDENTIAL_EXPIRED && c2paError != C2paError.SIGNING_CREDENTIAL_REVOKED && c2paError != C2paError.CLAIM_SIGNATURE_MISMATCH && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i > 0) {
                return true;
            }
            if (z && list.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                for (C2paError c2paError2 : list) {
                    if ((c2paError2 == C2paError.SIGNING_CREDENTIAL_EXPIRED || c2paError2 == C2paError.SIGNING_CREDENTIAL_REVOKED) && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (z && list.isEmpty()) {
                i4 = 0;
            } else {
                Iterator it = list.iterator();
                i4 = 0;
                while (it.hasNext()) {
                    if ((((C2paError) it.next()) == C2paError.CLAIM_SIGNATURE_MISMATCH) && (i4 = i4 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            return i2 <= 0 || i2 < i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2paError fromErrorString$lambda$0(C2paError c2paError, MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return c2paError;
        }

        public final boolean checkInvalid(@NotNull String errString, @NotNull C2paSoVersionInfo soVersion) {
            Intrinsics.checkNotNullParameter(errString, "errString");
            Intrinsics.checkNotNullParameter(soVersion, "soVersion");
            int i = WhenMappings.$EnumSwitchMapping$0[soVersion.ordinal()];
            if (i == 1) {
                return checkInvalidV2(errString);
            }
            if (i == 2) {
                return checkInvalidV1(errString);
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public final List<C2paError> fromErrorString(@NotNull String errString) {
            Intrinsics.checkNotNullParameter(errString, "errString");
            ArrayList arrayList = new ArrayList();
            for (C2paError c2paError : C2paError.getEntries()) {
                arrayList.addAll(SequencesKt.toMutableList(SequencesKt.map(Regex.findAll$default(new Regex(Regex.INSTANCE.escape(c2paError.getErrString())), errString, 0, 2, null), new C4202b(c2paError, 1))));
            }
            if (errString.length() > 0 && arrayList.isEmpty()) {
                arrayList.add(C2paError.C2PA_ERROR_UNKNOWN);
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ C2paError[] $values() {
        return new C2paError[]{NO_C2PA_MANIFEST, CLAIM_MISSING, CLAIM_MULTIPLE, HARD_BINDINGS_MISSING, CLAIM_REQUIRED_MISSING, CLAIM_CBOR_INVALID, INGREDIENT_HASHEDURI_MISMATCH, CLAIM_SIGNATURE_MISSING, CLAIM_SIGNATURE_MISMATCH, MANIFEST_INACCESSIBLE, MANIFEST_MULTIPLE_PARENTS, MANIFEST_UPDATE_INVALID, MANIFEST_UPDATE_WRONG_PARENTS, SIGNING_CREDENTIAL_UNTRUSTED, SIGNING_CREDENTIAL_INVALID, SIGNING_CREDENTIAL_REVOKED, SIGNING_CREDENTIAL_EXPIRED, TIMESTAMP_MISMATCH, TIMESTAMP_UNTRUSTED, TIMESTAMP_OUTSIDE_VALIDITY, ASSERTION_HASHEDURI_MISMATCH, ASSERTION_MISSING, ASSERTION_UNDECLARED, ASSERTION_INACCESSIBLE, ASSERTION_NOT_REDACTED, ASSERTION_SELF_REDACTED, ASSERTION_REQUIRED_MISSING, ASSERTION_JSON_INVALID, ASSERTION_CBOR_INVALID, ACTION_ASSERTION_INGREDIENT_MISMATCH, ACTION_ASSERTION_REDACTED, ASSERTION_DATAHASH_MISMATCH, ASSERTION_BMFFHASH_MISMATCH, ASSERTION_BOXHASH_MISMATCH, ASSERTION_BOXHASH_UNKNOWN, ASSERTION_CLOUD_DATA_HARD_BINDING, ASSERTION_CLOUD_DATA_ACTIONS, ALGORITHM_UNSUPPORTED, GENERAL_ERROR, OLD_VERSION, UNSUPPORTED_TYPE, INVALID_CLAIM_SIGNATURE, INVALID_PATH, MANIFEST_PARSING_ERROR, INVALID_SIGN_ALG, C2PA_ERROR_UNKNOWN, SERVICE_NOT_INITIALIZED, INVALID_PARENT_PATH, INVALID_INGREDIENT_PATH, INTERNAL_SERVICE_ERROR, PFD_READ_ERROR, MISSING_CONFIG_ERROR, TRUST_SET_ERROR};
    }

    static {
        C2paError[] c2paErrorArr$values = $values();
        $VALUES = c2paErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(c2paErrorArr$values);
        INSTANCE = new Companion(null);
    }

    private C2paError(String str, int i, String str2) {
        this.errString = str2;
    }

    @NotNull
    public static EnumEntries<C2paError> getEntries() {
        return $ENTRIES;
    }

    public static C2paError valueOf(String str) {
        return (C2paError) Enum.valueOf(C2paError.class, str);
    }

    public static C2paError[] values() {
        return (C2paError[]) $VALUES.clone();
    }

    @NotNull
    public final String getErrString() {
        return this.errString;
    }
}
