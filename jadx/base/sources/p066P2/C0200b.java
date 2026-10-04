package p066P2;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appsearch.platformstorage.converter.SearchSuggestionResultToPlatformConverter;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import com.samsung.android.app.sdk.deepsky.classifier.TextClassifierExtraUtils;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: renamed from: P2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0200b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f621a;

    public /* synthetic */ C0200b(int i) {
        this.f621a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f621a) {
            case 0:
                return Integer.valueOf(((TipCard) obj).getType());
            case 1:
                return (Bundle) Bundle.class.cast((Parcelable) obj);
            case 2:
                return TextClassifierExtraUtils.lambda$getEntityText$1((Bundle) obj);
            case 3:
                return TextClassifierExtraUtils.lambda$getEntityType$0((Bundle) obj);
            case 4:
                return TextClassifierExtraUtils.lambda$getEntityIndex$3((Bundle) obj);
            case 5:
                return TextClassifierExtraUtils.lambda$getActionId$10((Bundle) obj);
            case 6:
                return TextClassifierExtraUtils.lambda$getEntityExtras$6((Bundle) obj);
            case 7:
                return Long.valueOf(((SharedItem) obj).getCreatedTime());
            case 8:
                return ((DocumentData) obj).getUuid();
            case 9:
                return SearchSuggestionResultToPlatformConverter.toJetpackSearchSuggestionResults((List) obj);
            case 10:
                return ((DynamicScheme) obj).neutralPalette;
            case 11:
                return ((DynamicScheme) obj).secondaryPalette;
            case 12:
                return MaterialDynamicColors.lambda$onSecondary$71((DynamicScheme) obj);
            case 13:
                return ((DynamicScheme) obj).secondaryPalette;
            case 14:
                return MaterialDynamicColors.lambda$secondary$68((DynamicScheme) obj);
            case 15:
                return ((DynamicScheme) obj).neutralPalette;
            case 16:
                return MaterialDynamicColors.lambda$surfaceContainerLowest$22((DynamicScheme) obj);
            case 17:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 18:
                return MaterialDynamicColors.lambda$outline$43((DynamicScheme) obj);
            case 19:
                return ((DynamicScheme) obj).neutralPalette;
            case 20:
                return ((DynamicScheme) obj).primaryPalette;
            case 21:
                return MaterialDynamicColors.lambda$surfaceTint$51((DynamicScheme) obj);
            case 22:
                return ((DynamicScheme) obj).secondaryPalette;
            case 23:
                return MaterialDynamicColors.lambda$onSecondaryFixed$124((DynamicScheme) obj);
            case 24:
                return ((DynamicScheme) obj).neutralPalette;
            case 25:
                return MaterialDynamicColors.lambda$inverseOnSurface$40((DynamicScheme) obj);
            case 26:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 27:
                return MaterialDynamicColors.lambda$neutralPaletteKeyColor$7((DynamicScheme) obj);
            case 28:
                return ((DynamicScheme) obj).secondaryPalette;
            default:
                return ((DynamicScheme) obj).primaryPalette;
        }
    }
}
