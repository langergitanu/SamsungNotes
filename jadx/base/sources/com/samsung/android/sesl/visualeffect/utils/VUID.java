package com.samsung.android.sesl.visualeffect.utils;

import android.util.Log;
import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R6\u0010\b\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/VUID;", "", "tagKey", "", "<init>", "(I)V", "getTagKey", "()I", "idMap", "Ljava/util/HashMap;", "Ljava/util/UUID;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "getOrCreateMemoized", VPathDataCmd.RCurveTo, "get", "forget", "clear", "", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class VUID {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "VUID";
    private static final int UUID_TAG_KEY = 1029537645;

    @NotNull
    private final HashMap<UUID, WeakReference<View>> idMap;
    private final int tagKey;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/VUID$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "UUID_TAG_KEY", "", "getUUID_TAG_KEY", "()I", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return VUID.TAG;
        }

        public final int getUUID_TAG_KEY() {
            return VUID.UUID_TAG_KEY;
        }

        private Companion() {
        }
    }

    public VUID() {
        this(0, 1, null);
    }

    public final void clear() {
        this.idMap.clear();
    }

    @Nullable
    public final WeakReference<View> forget(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Object tag = v.getTag(this.tagKey);
        if (tag == null) {
            return null;
        }
        v.setTag(this.tagKey, null);
        WeakReference<View> weakReference = this.idMap.get(tag);
        TypeIntrinsics.asMutableMap(this.idMap).remove(tag);
        return weakReference;
    }

    @Nullable
    public final WeakReference<View> get(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Object tag = v.getTag(this.tagKey);
        if (tag != null) {
            UUID uuid = tag instanceof UUID ? (UUID) tag : null;
            if (uuid != null && this.idMap.containsKey(uuid)) {
                return this.idMap.get(uuid);
            }
        }
        return null;
    }

    @NotNull
    public final WeakReference<View> getOrCreateMemoized(@NotNull View v) {
        UUID uuidRandomUUID;
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getTag(this.tagKey) != null) {
            Object tag = v.getTag(this.tagKey);
            if ((tag instanceof UUID ? (UUID) tag : null) != null) {
                WeakReference<View> weakReference = this.idMap.get(tag);
                if (weakReference != null) {
                    return weakReference;
                }
                uuidRandomUUID = (UUID) tag;
            } else {
                Log.e(TAG, "key(=" + this.tagKey + ") of the tag on a view has corrupted by me.");
                uuidRandomUUID = UUID.randomUUID();
            }
        } else {
            uuidRandomUUID = UUID.randomUUID();
        }
        v.setTag(this.tagKey, uuidRandomUUID);
        WeakReference<View> weakReference2 = new WeakReference<>(v);
        this.idMap.put(uuidRandomUUID, weakReference2);
        return weakReference2;
    }

    public final int getTagKey() {
        return this.tagKey;
    }

    public VUID(int i) {
        this.tagKey = i;
        this.idMap = new HashMap<>();
    }

    public /* synthetic */ VUID(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? UUID_TAG_KEY : i);
    }
}
