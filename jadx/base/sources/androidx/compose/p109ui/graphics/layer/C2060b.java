package androidx.compose.p109ui.graphics.layer;

import android.media.ImageReader;

/* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C2060b implements ImageReader.OnImageAvailableListener {
    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        LayerManager.persistLayers$lambda$3$lambda$2(imageReader);
    }
}
