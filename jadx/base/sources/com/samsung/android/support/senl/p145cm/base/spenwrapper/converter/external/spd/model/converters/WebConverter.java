package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import android.text.TextUtils;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.WebCardDataVer3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\n\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/WebConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/AbsObjectConverter;", "Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "<init>", "()V", "convertObject", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IConvertParams;", "isShowWebPreviewsEnabled", "()Z", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WebConverter extends AbsObjectConverter<SpenObjectImage> {

    @NotNull
    private static final String SETTINGS_PREFS_NAME = "Settings";

    @NotNull
    private static final String SETTINGS_SHOW_WEB_PREVIEWS = "settings_show_web_previews";

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$WebConverter";

    private final boolean isShowWebPreviewsEnabled() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean("settings_show_web_previews", false);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.AbsObjectConverter
    public boolean convertObject(@NotNull SpenObjectImage src, @Nullable IConvertParams params) {
        IResourceGetter resourceGetter;
        Intrinsics.checkNotNullParameter(src, "src");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "convert object");
        INoteComposer noteComposer = params != null ? params.getNoteComposer() : null;
        SpenObjectWeb spenObjectWebMakeObjectWeb = SpenObjectConstructor.makeObjectWeb();
        String extraDataString = src.getExtraDataString("Info");
        if (TextUtils.isEmpty(extraDataString)) {
            companion.m7138w(TAG, "convert fail:  URL is empty");
            return false;
        }
        WebCardDataVer3 webCardDataVer3CreateWebCard = WebCardDataVer3.INSTANCE.createWebCard(extraDataString, noteComposer != null ? noteComposer.getCachePath() : null, isShowWebPreviewsEnabled(), (params == null || (resourceGetter = params.getResourceGetter()) == null) ? 0.0f : resourceGetter.getScreenMinSize());
        spenObjectWebMakeObjectWeb.setUri(webCardDataVer3CreateWebCard.getUrl());
        spenObjectWebMakeObjectWeb.setThumbnailPath(webCardDataVer3CreateWebCard.getPath());
        spenObjectWebMakeObjectWeb.setTitle(webCardDataVer3CreateWebCard.getTitle());
        spenObjectWebMakeObjectWeb.setImageTypeId(webCardDataVer3CreateWebCard.getImageTypeId());
        spenObjectWebMakeObjectWeb.setBody(webCardDataVer3CreateWebCard.getDescription());
        spenObjectWebMakeObjectWeb.setRect(src.getRect(), true);
        if (noteComposer != null) {
            noteComposer.removeObject(src);
        }
        if (noteComposer != null) {
            noteComposer.appendObject(spenObjectWebMakeObjectWeb);
        }
        return true;
    }
}
