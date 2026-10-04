package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.ExtraDataHelper;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MessageSuggestionInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LinkCardFactory {
    public static final String FILE_PREFIX = "quickNote";

    public static Content.LinkCard createMessageCard(MessageSuggestionInfo messageSuggestionInfo, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ExtraDataHelper extraDataHelper = new ExtraDataHelper();
        extraDataHelper.createJson(jSONObject, "android.intent.action.SENDTO", Uri.fromParts("smsto", messageSuggestionInfo.getRecipientList(), null).toString(), null);
        extraDataHelper.putDeviceId(jSONObject, new MsgPermissionAction().getAndroidId());
        new ExtraDataHelper.ExtraPutter(2).put(jSONObject, messageSuggestionInfo.getIntentExtraBooleanValues());
        new ExtraDataHelper.ExtraPutter(3).put(jSONObject, messageSuggestionInfo.getIntentExtraLongValues());
        ExtraDataHelper.ExtraPutter extraPutter = new ExtraDataHelper.ExtraPutter(1);
        List<Pair<String, String>> intentExtraStringValues = messageSuggestionInfo.getIntentExtraStringValues();
        if (!intentExtraStringValues.isEmpty()) {
            extraPutter.put(jSONObject, intentExtraStringValues);
        }
        Content.LinkCard linkCard = new Content.LinkCard(messageSuggestionInfo.getQueriedTitle(), "", messageSuggestionInfo.getPackageName(), jSONObject.toString());
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(FileExtensions.getFileNameByTime(FILE_PREFIX, Constants.THUMBNAIL_PNG_EXTENSION));
        String string = sbM1324q.toString();
        ImageUtil.saveBitmapToFileCache(ImageUtil.convertDrawableToBitmap(messageSuggestionInfo.getAppIcon()), string, Bitmap.CompressFormat.PNG, 95);
        linkCard.setPath(string);
        return linkCard;
    }
}
