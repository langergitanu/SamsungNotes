package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u000234B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0002J$\u0010)\u001a\u0004\u0018\u00010&2\b\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u001a\u0010.\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0014\u0010/\u001a\u0004\u0018\u00010&2\b\u0010*\u001a\u0004\u0018\u00010&H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\u0006\u00102\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragViewMaker;", "", "tag", "", "targetView", "Landroid/view/View;", "contract", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragViewMaker$Contract;", "<init>", "(Ljava/lang/String;Landroid/view/View;Lcom/samsung/android/support/senl/nt/base/composer/drag/DragViewMaker$Contract;)V", "getTag", "()Ljava/lang/String;", "getTargetView", "()Landroid/view/View;", "setTargetView", "(Landroid/view/View;)V", "getContract", "()Lcom/samsung/android/support/senl/nt/base/composer/drag/DragViewMaker$Contract;", "createClipData", "Landroid/content/ClipData;", "dropContent", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContent;", "hashCode", "", "pageIndex", "pastePosition", "Landroid/graphics/PointF;", "startDragAndDrop", "", "data", "createShadowView", "inflater", "Landroid/view/LayoutInflater;", "createShadowViewObject", "shadowView", "setSelectedObjectBitmapToShadowView", "createShadowViewPlainText", "createImageTypeBitmap", "Landroid/graphics/Bitmap;", "imageTypeObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "createComposerScaledBitmap", "bitmap", "width", "", "height", "setBitmapToShadowView", "resize", "setShadowViewLayout", "getMaxScreenWidth", "release", "Contract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DragViewMaker {
    public static final float BIG_SHADOW_VIEW_WIDTH_RATIO = 0.55f;
    public static final float SMALL_SHADOW_VIEW_WIDTH_RATIO = 0.75f;

    @NotNull
    private final Contract contract;

    @NotNull
    private final String tag;

    @Nullable
    private View targetView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragViewMaker$Contract;", "", "setShadowSize", "", "width", "", "height", "getScale", "", "getSelectedObjectBitmap", "Landroid/graphics/Bitmap;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static float getScale(@NotNull Contract contract) {
                return 1.0f;
            }
        }

        float getScale();

        @Nullable
        Bitmap getSelectedObjectBitmap();

        void setShadowSize(int width, int height);
    }

    public DragViewMaker(@NotNull String tag, @Nullable View view, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.tag = tag;
        this.targetView = view;
        this.contract = contract;
    }

    private final Bitmap createComposerScaledBitmap(Bitmap bitmap, float width, float height) {
        if (bitmap != null && bitmap.getWidth() >= 1 && bitmap.getHeight() >= 1) {
            float scale = this.contract.getScale();
            return Bitmap.createScaledBitmap(bitmap, (int) (width * scale), (int) (height * scale), true);
        }
        Logger.m8698e(this.tag, "createComposerScaledBitmap, invalid bitmap, bitmap: " + bitmap);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap createImageTypeBitmap(SpenObjectBase imageTypeObject) {
        String thumbnailPath;
        Bitmap bitmapDecodeFile;
        Rect cropRect;
        if (imageTypeObject.getType() == 3 && (imageTypeObject instanceof SpenObjectImage)) {
            SpenObjectImage spenObjectImage = (SpenObjectImage) imageTypeObject;
            thumbnailPath = spenObjectImage.getImagePath();
            bitmapDecodeFile = spenObjectImage.getImage();
            cropRect = spenObjectImage.getCropRect();
        } else {
            Intrinsics.checkNotNull(imageTypeObject, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectPainting");
            SpenObjectPainting spenObjectPainting = (SpenObjectPainting) imageTypeObject;
            thumbnailPath = spenObjectPainting.getThumbnailPath();
            Intrinsics.checkNotNull(thumbnailPath);
            bitmapDecodeFile = BitmapFactory.decodeFile(thumbnailPath);
            cropRect = spenObjectPainting.getCropRect();
        }
        if (TextUtils.isEmpty(thumbnailPath)) {
            return null;
        }
        if (cropRect != null && !cropRect.isEmpty()) {
            int iWidth = cropRect.width() + cropRect.left;
            Intrinsics.checkNotNull(bitmapDecodeFile);
            if (iWidth <= bitmapDecodeFile.getWidth()) {
                if (cropRect.height() + cropRect.top <= bitmapDecodeFile.getHeight()) {
                    bitmapDecodeFile = Bitmap.createBitmap(bitmapDecodeFile, cropRect.left, cropRect.top, cropRect.width(), cropRect.height());
                } else {
                    Logger.m8698e(this.tag, "createImageTypeBitmap, cropRect is wrong. " + cropRect);
                }
            }
        }
        Bitmap bitmapCreateBitmap = bitmapDecodeFile;
        if (bitmapCreateBitmap != null && imageTypeObject.getRotation() != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postRotate(imageTypeObject.getRotation());
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        }
        RectF drawnRect = imageTypeObject.getDrawnRect();
        if (drawnRect != null && drawnRect.width() >= 1.0f && drawnRect.height() >= 1.0f) {
            return createComposerScaledBitmap(bitmapCreateBitmap, drawnRect.width(), drawnRect.height());
        }
        Logger.m8698e(this.tag, "createImageTypeBitmap, invalid contentRect : " + drawnRect);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View createShadowView(LayoutInflater inflater, DropContent dropContent) {
        View viewInflate = inflater.inflate(C8875R.layout.drag_n_drop_shadow_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        ArrayList<SpenObjectBase> contentList = dropContent.contentList;
        if (contentList != null) {
            Intrinsics.checkNotNullExpressionValue(contentList, "contentList");
            if (contentList.isEmpty()) {
                createShadowViewPlainText(dropContent, viewInflate);
            } else if (dropContent.contentList.size() <= 1 || dropContent.contentType != 1) {
                createShadowViewObject(dropContent, viewInflate);
            } else {
                setSelectedObjectBitmapToShadowView(viewInflate);
            }
        }
        setShadowViewLayout(viewInflate);
        return viewInflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void createShadowViewObject(DropContent dropContent, View shadowView) {
        SpenObjectBase object = dropContent.contentList.get(0);
        int type = object.getType();
        AbstractC4539a.m3203m(type, "createShadowView, contentType: ", this.tag);
        if (type == 2 && dropContent.contentType == 3) {
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
            object = ((SpenObjectTextBox) object).getObjectSpanAtTextIndex(0).getObject();
            type = object.getType();
        }
        TextView textView = (TextView) shadowView.findViewById(C8875R.id.shadow_view_text);
        if (type == 1) {
            if (dropContent.contentType == 2) {
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                textView.setText(((SpenObjectShape) object).getText());
            } else {
                setSelectedObjectBitmapToShadowView(shadowView);
            }
        } else if (type == 2) {
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
            textView.setText(((SpenObjectTextBox) object).getText());
        } else if (type == 3) {
            Intrinsics.checkNotNull(object);
            setBitmapToShadowView(createImageTypeBitmap(object), shadowView);
        } else if (type != 4 && type != 7 && type != 8) {
            if (type == 10) {
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectVoice");
                textView.setText(((SpenObjectVoice) object).getTitle());
            } else if (type == 17) {
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLink");
                textView.setText(((SpenObjectLink) object).getTitle());
            } else if (type == 13) {
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectWeb");
                textView.setText(((SpenObjectWeb) object).getUri());
            } else if (type != 14) {
                if (type == 20 || type == 21) {
                }
            }
        }
        if (TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.setVisibility(0);
    }

    private final void createShadowViewPlainText(DropContent dropContent, View shadowView) {
        Logger.m8697d(this.tag, "createShadowViewPlainText, set plain text.");
        ((TextView) shadowView.findViewById(C8875R.id.shadow_view_text)).setText(dropContent.plainText);
    }

    private final int getMaxScreenWidth() {
        View view = this.targetView;
        Intrinsics.checkNotNull(view);
        int width = view.getRootView().getWidth();
        View view2 = this.targetView;
        Intrinsics.checkNotNull(view2);
        return width < view2.getResources().getDimensionPixelSize(C8875R.dimen.composer_shadow_view_max_width) ? MathKt.roundToInt(width * 0.75f) : MathKt.roundToInt(width * 0.55f);
    }

    private final Bitmap resize(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        View view = this.targetView;
        Intrinsics.checkNotNull(view);
        int width = view.getRootView().getWidth();
        int i = (int) (width * 0.9f);
        Logger.m8697d(this.tag, "resize, resizeWidth: " + i + ", decorViewWidth: " + width);
        return (i <= 0 || bitmap.getWidth() <= i) ? bitmap : ImageUtils.resizeBitmapImage(bitmap, i);
    }

    private final void setBitmapToShadowView(Bitmap bitmap, View shadowView) {
        if (bitmap == null) {
            return;
        }
        ImageView imageView = (ImageView) shadowView.findViewById(C8875R.id.shadow_view_image);
        View view = this.targetView;
        Intrinsics.checkNotNull(view);
        RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(view.getResources(), resize(bitmap));
        Intrinsics.checkNotNullExpressionValue(roundedBitmapDrawableCreate, "create(...)");
        Intrinsics.checkNotNull(this.targetView);
        roundedBitmapDrawableCreate.setCornerRadius(r0.getResources().getDimensionPixelSize(C8875R.dimen.composer_shadow_view_radius));
        imageView.setImageDrawable(roundedBitmapDrawableCreate);
        imageView.setVisibility(0);
    }

    private final void setSelectedObjectBitmapToShadowView(View shadowView) {
        Bitmap bitmapCreateComposerScaledBitmap;
        Bitmap selectedObjectBitmap = this.contract.getSelectedObjectBitmap();
        if (selectedObjectBitmap == null || (bitmapCreateComposerScaledBitmap = createComposerScaledBitmap(selectedObjectBitmap, selectedObjectBitmap.getWidth(), selectedObjectBitmap.getHeight())) == null) {
            return;
        }
        setBitmapToShadowView(bitmapCreateComposerScaledBitmap, shadowView);
    }

    private final void setShadowViewLayout(View shadowView) {
        shadowView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        shadowView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredWidth = shadowView.getMeasuredWidth();
        int measuredHeight = shadowView.getMeasuredHeight();
        int maxScreenWidth = getMaxScreenWidth();
        View view = this.targetView;
        Intrinsics.checkNotNull(view);
        int height = view.getRootView().getHeight();
        String str = this.tag;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(measuredWidth, measuredHeight, "setShadowViewLayout, shadowView: ", "*", ", decorView : ");
        sbM1173s.append(maxScreenWidth);
        sbM1173s.append("*");
        sbM1173s.append(height);
        Logger.m8697d(str, sbM1173s.toString());
        if (maxScreenWidth < measuredWidth) {
            shadowView.setLayoutParams(new ViewGroup.LayoutParams(maxScreenWidth, -2));
            shadowView.measure(View.MeasureSpec.makeMeasureSpec(maxScreenWidth, 1073741824), iMakeMeasureSpec);
            measuredHeight = shadowView.getMeasuredHeight();
            measuredWidth = maxScreenWidth;
        }
        if (height < measuredHeight) {
            shadowView.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth, height));
            shadowView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        } else {
            height = measuredHeight;
        }
        Logger.m8697d(this.tag, "setShadowViewLayout, result: " + measuredWidth + "*" + height);
        shadowView.layout(0, 0, measuredWidth, height);
        shadowView.invalidate();
    }

    @NotNull
    public final ClipData createClipData(@NotNull DropContent dropContent, int hashCode, int pageIndex, @NotNull PointF pastePosition) {
        Intrinsics.checkNotNullParameter(dropContent, "dropContent");
        Intrinsics.checkNotNullParameter(pastePosition, "pastePosition");
        ClipData.Item item = new ClipData.Item(dropContent.plainText, dropContent.htmlText);
        String[] strArr = new String[dropContent.uriList.size() + 1];
        Arrays.fill(strArr, "image/jpeg");
        strArr[dropContent.uriList.size()] = Constants.MIME_HTML;
        Objects.requireNonNull(pastePosition);
        String strCreateClipLabel = dropContent.createClipLabel(hashCode, pageIndex, pastePosition);
        AbstractC4539a.m3206p("createClipData - ", strCreateClipLabel, this.tag);
        ArrayList<Uri> uriList = dropContent.uriList;
        Intrinsics.checkNotNullExpressionValue(uriList, "uriList");
        if (uriList.isEmpty()) {
            return new ClipData(strCreateClipLabel, strArr, item);
        }
        ClipData clipData = new ClipData(strCreateClipLabel, strArr, new ClipData.Item(dropContent.uriList.get(0)));
        int size = dropContent.uriList.size();
        for (int i = 1; i < size; i++) {
            clipData.addItem(new ClipData.Item(dropContent.uriList.get(i)));
        }
        clipData.addItem(item);
        return clipData;
    }

    @NotNull
    public final Contract getContract() {
        return this.contract;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final View getTargetView() {
        return this.targetView;
    }

    public final void release() {
        this.targetView = null;
    }

    public final void setTargetView(@Nullable View view) {
        this.targetView = view;
    }

    public final void startDragAndDrop(@NotNull View targetView, @NotNull ClipData data, @NotNull DropContent dropContent) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(dropContent, "dropContent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(targetView.getContext());
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(...)");
        View viewCreateShadowView = createShadowView(layoutInflaterFrom, dropContent);
        if (viewCreateShadowView.getWidth() != 0 && viewCreateShadowView.getHeight() != 0) {
            this.contract.setShadowSize(viewCreateShadowView.getWidth(), viewCreateShadowView.getWidth());
            targetView.startDragAndDrop(data, new View.DragShadowBuilder(viewCreateShadowView), null, 257);
            return;
        }
        String str = this.tag;
        int width = viewCreateShadowView.getWidth();
        int height = viewCreateShadowView.getHeight();
        int itemCount = data.getItemCount();
        int size = dropContent.contentList.size();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "startDragAndDrop#shadowView size is wrong : ", "*", ", ClipData : ");
        sbM1173s.append(itemCount);
        sbM1173s.append(", dropContent : ");
        sbM1173s.append(size);
        Logger.m8698e(str, sbM1173s.toString());
    }
}
