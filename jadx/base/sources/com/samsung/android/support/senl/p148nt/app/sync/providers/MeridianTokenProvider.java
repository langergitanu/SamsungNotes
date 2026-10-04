package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MeridianTokenProvider extends ContentProvider {
    public static final String MERIDIAN_STATUS = "MERIDIAN_STATUS";
    private static final String ONEDRIVE_PACKAGE_NAME = "com.microsoft.skydrive";
    private static final String ONEDRIVE_PACKAGE_SIGNATURE = "30820716308204fea00302010202133300000015f089dbf10b587c28000000000015300d06092a864886f70d01010b0500308190310b3009060355040613025553311330110603550408130a57617368696e67746f6e3110300e060355040713075265646d6f6e64311e301c060355040a13154d6963726f736f667420436f72706f726174696f6e313a3038060355040313314d6963726f736f667420436f72706f726174696f6e205468697264205061727479204d61726b6574706c61636520504341301e170d3132303832343230323030375a170d3333313132343230323030375a3081cc310b3009060355040613025553311330110603550408130a57617368696e67746f6e3110300e060355040713075265646d6f6e64311e301c060355040a13154d6963726f736f667420436f72706f726174696f6e312f302d060355040b1326416e64726f6964205369676e696e6720666f72204d6963726f736f667420536b794472697665314530430603550403133c4d6963726f736f667420436f72706f726174696f6e205468697264205061727479204d61726b6574706c6163652028446f204e6f742054727573742930820222300d06092a864886f70d01010105000382020f003082020a0282020100c2a4eaa7934f2b98d89a26c035e29eb9df7f5b9a586b1a412b04c7157c1b09c327e30b8e376b16fd8f721fec86ef8e59783817e250653dbaf89e4b7ca0051c473fd19284b9e7c101be6a0131c69c5d21e9ec46ce668c5e89293821b30760029e9823154c7cf07603ee347861598e5f55704ece84c5c340e13c9b74ccbf57dd601dac64b38801f268f3c1b0e448961150537f29f2b33a94dd3870780aee1f43df0bae0254c2df18fc10c5a2d137913cf5a94955d1c60ba5477d7bb094c6c3bbc9d1ee2221cb31846dfd2224ee0dd7f44c3b0aebf0d2d0d8f6d07339cf1c45f3f4f2073e0980f4ab3768e1bf0a02810a2781a54dc332f67955b959a5f505df7d086dc1eba95da5a1e5f3a345d2da581a354e8de77710f1ca17d1c451e6791c0c544c507b10e761bb1c4f782ae2394f9ecf5c2615a49466c2f91f66791e6a28056172a08873fbadffacdf4737e949b6d60a8a94810a0ccad8c80970a99d6017529e85695a8d3c9650b8904039f418dd31615dd018f8b40b45bd4da9bc726e668afea12ca13330a097a907ba9d69f16dda2677d0742ac4cafc48f25a086cceb5c46edbb0ef778c9c95f4ae9a6791c8cfa37763b8d68a4b3e2e222db265a5e68506429baf91f5abaf3689b805fd790e88d0b504161e6b8bb5a050a118104f27531c9d25fd9ea51dff7f066d2d3671e9aa9eb4123be0609e0a53308ab6158d27b1d3fd0203010001a382012930820125301d0603551d0e04160414d2de9924477dcb84cac7cfb1fa318c8f87d0c7a6301f0603551d23041830168014ae91e4609f98c00bdf1a0b6bf056332747acc7c7305c0603551d1f045530533051a04fa04d864b687474703a2f2f63726c2e6d6963726f736f66742e636f6d2f706b692f63726c2f70726f64756374732f4d6963436f725468695061724d61725043415f323031302d31302d30352e63726c306006082b0601050507010104543052305006082b060105050730028644687474703a2f2f7777772e6d6963726f736f66742e636f6d2f706b692f63657274732f4d6963436f725468695061724d61725043415f323031302d31302d30352e637274300c0603551d130101ff0402300030150603551d25040e300c060a2b0601040182374c0201300d06092a864886f70d01010b050003820201003904246a396127812aaa79c3bb472040424cc707f94d69b635c81e3266b5bca8e1206f6ba490b0db20d712ee1cbb0869a38ac8f894cfe97dd2028735dd19e08926e30d4e7e279432a107d4dcbe611e2f2d2bac6b73c4d8cc4c6019745422718702179b997cd50194c49f805e2bef3be39468a8d3fc8758952ad79e2b7c6a848dd871b76f18177c15a9b286a6fe42b11a5ce10c10244bbb75662b0c7438bd0b985fbdd517b605ac9e4adcdba79d391f3cfe45f3cb09ce86d949c8a7830f3bddc99ec4200ce191c0fa56aef4aa50667e3d9a95126a60445fe0141be2fd3b5b8670b2140b570487897bd9bfe57dcfeb26f8d27f37e6482643dd53c696fa545b39031470759491ed5c3496d97f2be0f2fd026cfe981ff6755730a401bf23ca4801811fa104cba58e5a1858973f58d3475978ac1932bcf905cbea95970ffe23d8974e86b9e19bd7a7ad32ab4a9d2925f5b9ab3edbb94fb48581c52e5a55a6f23d1b97455bee5d70974f9b3256e987ab31b59a2e3fa5ba06815d4afa01430cc96d09622e41e53e3bd9308bb21028600228f9ec499de43c19c52e11eac13cc307b9f47eaff1ee3ae7a409330198178a9e3d8ee2e3d2b1c4d8fd346bb9cf056b4d60a2cb6d7b821fa26012cbd6faf15d0d97109818ff707aeb18377b30c23c79a1d3804104ea9dce4482c04192c1b9ea3de4a9efaf76876cd4f8d6c5399e5ccadec42371";
    public static final String SAVE_REFRESH_TOKEN = "SAVE_REFRESH_TOKEN";
    private static final String TAG = "MeridianTokenProvider";

    private Uri getIconUri(Resources resources, int i) {
        return new Uri.Builder().scheme("android.resource").authority(resources.getResourcePackageName(i)).appendPath(resources.getResourceTypeName(i)).appendPath(Integer.toString(i)).build();
    }

    private Uri getImageUri(Resources resources) {
        return new Uri.Builder().scheme("android.resource").authority(resources.getResourcePackageName(C8003R.drawable.meridian_info_image)).appendPath(resources.getResourceTypeName(C8003R.drawable.meridian_info_image)).appendPath(Integer.toString(C8003R.drawable.meridian_info_image)).build();
    }

    private Bundle getLargeCard(Resources resources, String str, Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("headerText", resources.getString(C8003R.string.msa_header_take_note));
        if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
            bundle.putString(ExternalDataConstants.Column.BODY_TEXT, resources.getString(C8003R.string.msa_body_see_your_notes_jp));
        } else {
            bundle.putString(ExternalDataConstants.Column.BODY_TEXT, resources.getString(C8003R.string.msa_body_see_your_notes));
        }
        bundle.putParcelable(MarketingConstants.LINK_TYPE_INTENT, getLaunchIntentForLargeCard(str, context));
        bundle.putParcelable(Bixby2Constants.BIXBY_PARAM_IMAGE_URI, getImageUri(resources));
        bundle.putString("buttonText", resources.getString(C8003R.string.msa_button_set_up));
        return bundle;
    }

    private Intent getLaunchIntentForLargeCard(String str, Context context) {
        PostLaunchManager.getInstance().executeBaseLogic(1);
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction(Constants.ACTION_START_MS_SETTINGS);
        intent.setClass(context, NoteListAccessHandler.getNoteListBaseActivityClass());
        return intent;
    }

    private Intent getLaunchIntentForSignOut(String str, Context context) {
        PostLaunchManager.getInstance().executeBaseLogic(1);
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction(Constants.ACTION_START_SIGNOUT_MS_FEED);
        intent.setClass(context, NoteListAccessHandler.getNoteListBaseActivityClass());
        return intent;
    }

    private Bundle getSmallCard(Resources resources, String str, Context context) {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        bundle2.putString("buttonText", resources.getString(C8003R.string.settings_log_out));
        bundle2.putParcelable(MarketingConstants.LINK_TYPE_INTENT, getLaunchIntentForSignOut(str, context));
        arrayList.add(bundle2);
        bundle.putParcelableArrayList("actions", arrayList);
        return bundle;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        MSLogger.m8632d(TAG, "start call");
        String callingPackage = getCallingPackage();
        if (!ONEDRIVE_PACKAGE_NAME.equals(callingPackage)) {
            return null;
        }
        if (getContext() == null) {
            MSLogger.m8632d(TAG, "getContext null");
            return null;
        }
        if (!DeviceUtils.verifySignatureNoHash(getContext(), callingPackage, ONEDRIVE_PACKAGE_SIGNATURE)) {
            return null;
        }
        if (SAVE_REFRESH_TOKEN.equals(str2)) {
            MSLogger.m8632d(TAG, "wait for api");
        } else if (MERIDIAN_STATUS.equals(str2)) {
            C6785g c6785g = AbstractC6784f.f4180a;
            c6785g.m4946f();
            return getMeridianStatus(getContext().getResources(), getContext().getPackageName(), getContext(), c6785g.f4185e);
        }
        return new Bundle();
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    public Bundle getMeridianStatus(Resources resources, String str, Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("iconUri", getIconUri(resources, context.getApplicationInfo().icon));
        if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
            bundle.putString("titleText", resources.getString(C8003R.string.notes_jp));
        } else {
            bundle.putString("titleText", resources.getString(C8003R.string.notes));
        }
        if (z) {
            bundle.putBoolean("showLargeCard", false);
            bundle.putBoolean("showSmallCard", true);
            bundle.putBundle("smallCardInfo", getSmallCard(resources, str, context));
            return bundle;
        }
        bundle.putBoolean("showLargeCard", true);
        bundle.putBoolean("showSmallCard", false);
        bundle.putBundle("largeCardInfo", getLargeCard(resources, str, context));
        return bundle;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
