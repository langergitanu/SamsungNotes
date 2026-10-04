package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupMemberContract;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebCardDataBase;", "", "<init>", "()V", "title", "", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", GroupMemberContract.GroupMember.IMAGE_URL, "getImageUrl", "setImageUrl", "url", "getUrl", "setUrl", "path", "getPath", "setPath", "imageTypeId", "", "getImageTypeId", "()I", "setImageTypeId", "(I)V", "toStringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class WebCardDataBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int IMAGE_TYPE_ID_CONTENT = 1;
    public static final int IMAGE_TYPE_ID_FAVICON = 2;
    public static final int IMAGE_TYPE_ID_NONE = 0;

    @NotNull
    private static final String TAG = "WebCardDataBase";
    private int imageTypeId;

    @NotNull
    private String title = "";

    @NotNull
    private String description = "";

    @NotNull
    private String imageUrl = "";

    @NotNull
    private String url = "";

    @NotNull
    private String path = "";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0005J<\u0010\r\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000ej\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u0001`\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebCardDataBase$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "IMAGE_TYPE_ID_NONE", "", "IMAGE_TYPE_ID_CONTENT", "IMAGE_TYPE_ID_FAVICON", "getFirstChar", "", "strUrl", "makeGradientColorList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "bgColor", "applyAlpha", "color", "alpha", "getDummyColorSet", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int applyAlpha(int color, int alpha) {
            return (color & 16777215) | (alpha << 24);
        }

        @JvmStatic
        @NotNull
        public final Pair<Integer, Integer> getDummyColorSet(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int iRandom = RangesKt___RangesKt.random(new IntRange(0, 7), Random.INSTANCE);
            return new Pair<>(Integer.valueOf(context.getResources().getIntArray(C7968R.array.insert_card_dummy_color_set1)[iRandom]), Integer.valueOf(context.getResources().getIntArray(C7968R.array.insert_card_dummy_color_set2)[iRandom]));
        }

        @JvmStatic
        public final char getFirstChar(@Nullable String strUrl) {
            int iM14128B;
            String strValueOf = String.valueOf(Uri.parse(strUrl).getHost());
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(WebCardDataBase.TAG, "getFirstChar, host: ".concat(strValueOf));
            if (TextUtils.isEmpty(strValueOf)) {
                return 'W';
            }
            char cCharAt = strValueOf.charAt(0);
            int length = strValueOf.length() - StringsKt.m14139M(strValueOf, Extension.DOT, "").length();
            companion.m7132d(WebCardDataBase.TAG, "getFirstChar, dotCount: " + length);
            if (length > 1 && (iM14128B = StringsKt.m14128B(strValueOf, '.', 0, 6) + 1) < strValueOf.length()) {
                cCharAt = strValueOf.charAt(iM14128B);
            }
            companion.m7132d(WebCardDataBase.TAG, "getFirstChar, ret: " + cCharAt);
            return cCharAt;
        }

        @JvmStatic
        @Nullable
        public final ArrayList<Pair<Integer, Float>> makeGradientColorList(int bgColor) {
            int iApplyAlpha = applyAlpha(bgColor, 21);
            int iApplyAlpha2 = applyAlpha(bgColor, 51);
            ArrayList<Pair<Integer, Float>> arrayList = new ArrayList<>();
            arrayList.add(new Pair<>(Integer.valueOf(iApplyAlpha), Float.valueOf(0.0f)));
            arrayList.add(new Pair<>(Integer.valueOf(iApplyAlpha2), Float.valueOf(1.0f)));
            return arrayList;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final Pair<Integer, Integer> getDummyColorSet(@NotNull Context context) {
        return INSTANCE.getDummyColorSet(context);
    }

    @JvmStatic
    public static final char getFirstChar(@Nullable String str) {
        return INSTANCE.getFirstChar(str);
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<Pair<Integer, Float>> makeGradientColorList(int i) {
        return INSTANCE.makeGradientColorList(i);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getImageTypeId() {
        return this.imageTypeId;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setImageTypeId(int i) {
        this.imageTypeId = i;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public final StringBuilder toStringBuilder() {
        StringBuilder sbM1324q = AbstractC1974b.m1324q("title: ");
        sbM1324q.append(this.title);
        sbM1324q.append(", description: ");
        sbM1324q.append(this.description);
        sbM1324q.append(", imageUrl: ");
        sbM1324q.append(this.imageUrl);
        sbM1324q.append(", imageTypeId: ");
        sbM1324q.append(this.imageTypeId);
        sbM1324q.append(", path: ");
        sbM1324q.append(this.path);
        return sbM1324q;
    }
}
