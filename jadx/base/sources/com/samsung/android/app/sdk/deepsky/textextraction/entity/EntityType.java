package com.samsung.android.app.sdk.deepsky.textextraction.entity;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "", "typeId", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeId", "()Ljava/lang/String;", "UNKNOWN", "EMAIL", "PHONE", TextConst.ENTITY_TYPE_URL, TextConst.ENTITY_TYPE_DATE_TIME, "ADDRESS", TextConst.DATE_TIME_UNIT_DATE, "FLIGHT_NUMBER", TextConst.ENTITY_TYPE_UNIT, "BANK_ACCOUNT_NUMBER", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public enum EntityType {
    UNKNOWN(""),
    EMAIL("email"),
    PHONE("phone"),
    URL("url"),
    DATE_TIME("datetime"),
    ADDRESS("address"),
    DATE("date"),
    FLIGHT_NUMBER("flight"),
    UNIT(BilouCodec.UNIT),
    BANK_ACCOUNT_NUMBER("bank_account_number");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String typeId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType$Companion;", "", "()V", "listOfEntityType", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "listOfOrderEntityType", "toEntityType", "typeId", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<EntityType> listOfEntityType() {
            return CollectionsKt.listOf((Object[]) new EntityType[]{EntityType.ADDRESS, EntityType.EMAIL, EntityType.FLIGHT_NUMBER, EntityType.PHONE, EntityType.URL, EntityType.DATE_TIME, EntityType.DATE, EntityType.BANK_ACCOUNT_NUMBER, EntityType.UNIT});
        }

        @NotNull
        public final List<EntityType> listOfOrderEntityType() {
            return CollectionsKt.listOf((Object[]) new EntityType[]{EntityType.URL, EntityType.PHONE, EntityType.EMAIL, EntityType.DATE_TIME, EntityType.DATE, EntityType.ADDRESS, EntityType.BANK_ACCOUNT_NUMBER, EntityType.UNIT});
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        
            if (r2.equals("phone") == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
        
            if (r2.equals("phone_e164") == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x008a, code lost:
        
            return com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType.PHONE;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final EntityType toEntityType(@NotNull String typeId) {
            Intrinsics.checkNotNullParameter(typeId, "typeId");
            switch (typeId.hashCode()) {
                case -1824434085:
                    break;
                case -1422091778:
                    if (typeId.equals("bank_account_number")) {
                        return EntityType.BANK_ACCOUNT_NUMBER;
                    }
                    return EntityType.UNKNOWN;
                case -1271823248:
                    if (typeId.equals("flight")) {
                        return EntityType.FLIGHT_NUMBER;
                    }
                    return EntityType.UNKNOWN;
                case -1147692044:
                    if (typeId.equals("address")) {
                        return EntityType.ADDRESS;
                    }
                    return EntityType.UNKNOWN;
                case 116079:
                    if (typeId.equals("url")) {
                        return EntityType.URL;
                    }
                    return EntityType.UNKNOWN;
                case 3076014:
                    if (typeId.equals("date")) {
                        return EntityType.DATE;
                    }
                    return EntityType.UNKNOWN;
                case 3594628:
                    if (typeId.equals(BilouCodec.UNIT)) {
                        return EntityType.UNIT;
                    }
                    return EntityType.UNKNOWN;
                case 96619420:
                    if (typeId.equals("email")) {
                        return EntityType.EMAIL;
                    }
                    return EntityType.UNKNOWN;
                case 106642798:
                    break;
                case 1793702779:
                    if (typeId.equals("datetime")) {
                        return EntityType.DATE_TIME;
                    }
                    return EntityType.UNKNOWN;
                default:
                    return EntityType.UNKNOWN;
            }
        }

        private Companion() {
        }
    }

    EntityType(String str) {
        this.typeId = str;
    }

    @NotNull
    public final String getTypeId() {
        return this.typeId;
    }
}
