package p065P1;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;

/* JADX INFO: renamed from: P1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0198d implements ImageDecoder$OnHeaderDecodedListener {
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        WidgetSingleGlanceSettingPresenter.getWallpaperBitmap$lambda$5(imageDecoder, imageInfo, source);
    }
}
