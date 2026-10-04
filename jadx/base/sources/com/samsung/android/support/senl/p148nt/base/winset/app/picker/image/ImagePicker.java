package com.samsung.android.support.senl.p148nt.base.winset.app.picker.image;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 S2\u00020\u0001:\u0003QRSB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016J<\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001aJK\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00162\b\u0010$\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0016H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010+\u001a\u00020\u0016H\u0002J(\u0010.\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020\u001cH\u0002J!\u00109\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010:J\u001d\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010=J\"\u0010>\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020-2\u0006\u0010&\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J,\u0010>\u001a\u00020\u001c2\b\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020-2\u0006\u0010&\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010@H\u0002JA\u0010B\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00162\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0D\"\u00020\f2\u0006\u0010E\u001a\u00020F2\b\u0010?\u001a\u0004\u0018\u00010@¢\u0006\u0002\u0010GJ\"\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010I2\b\u0010K\u001a\u0004\u0018\u00010-2\u0006\u0010L\u001a\u00020\u0016J\u0006\u0010M\u001a\u00020\u001cJ\b\u0010P\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker;", "", "<init>", "()V", "mActivity", "Landroid/app/Activity;", "mFragment", "Landroidx/fragment/app/Fragment;", "mAppList", "", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/AppInfo;", "mRecentList", "", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mAdapter", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$AttachMenuAdapter;", "mGridView", "Landroid/widget/GridView;", "mIsMultiple", "", "mGalleryMaxPickItemCount", "", "mOnItemClickedListener", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$OnItemClickedListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "setGalleryPickMaxItemCount", "", "galleryMaxPickItemCount", Constants.IntentExtraValue.SHOW, "fragment", "anchorView", "Landroid/view/View;", "type", "isMultiple", "onItemClickedListener", "onDismissListener", "requestCode", "(Landroidx/fragment/app/Fragment;Landroid/view/View;IZLjava/lang/Integer;Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$OnItemClickedListener;Landroid/content/DialogInterface$OnDismissListener;)Z", "initAppList", "setupAppList", "loadApplicationList", "appType", "getAppIntent", "Landroid/content/Intent;", "addAppList", MarketingConstants.LINK_TYPE_INTENT, "pm", "Landroid/content/pm/PackageManager;", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "sortAppList", "initRecentAppList", "addRecentList", "packageName", "saveRecentAppList", "showDialog", "(Landroid/view/View;Ljava/lang/Integer;)Z", "onItemClick", "position", "(ILjava/lang/Integer;)V", "startApplication", "pendingData", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/PendingData;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[ILcom/samsung/android/support/senl/nt/base/winset/app/picker/image/PendingData;)Z", "getUrisFromResult", "", "Landroid/net/Uri;", "data", "resultCode", "hide", "isShowing", "()Z", "release", "OnItemClickedListener", "AttachMenuAdapter", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImagePicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImagePicker.kt\ncom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,612:1\n1#2:613\n37#3:614\n36#3,3:615\n*S KotlinDebug\n*F\n+ 1 ImagePicker.kt\ncom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker\n*L\n400#1:614\n400#1:615,3\n*E\n"})
public final class ImagePicker {

    @NotNull
    private static final String CAMERA_PACKAGE_NAME = "com.sec.android.app.camera";

    @NotNull
    private static final String GALLERY_MULTI_PICK = "multi-pick";

    @NotNull
    private static final String GALLERY_PACKAGE_NAME = "com.sec.android.gallery3d";

    @NotNull
    private static final String GALLERY_PICK_MAX_ITEM = "pick-max-item";

    @NotNull
    private static final String GALLERY_SELECTED_COUNT = "selectedCount";

    @NotNull
    private static final String GALLERY_SELECTED_ITEMS = "selectedItems";

    @NotNull
    private static final String LAST_PICKER_SELECTED_PACKAGE = "lastPickerSelectedPackage_";

    @NotNull
    private static final String LAST_PICKER_SELECTED_PACKAGE_NUM = "lastPickerSelectedPackageNum";

    @NotNull
    private static final String MY_FILES_PACKAGE_NAME = "com.sec.android.app.myfiles";

    @NotNull
    private static final String PHOTOPICKER_PACKAGE = "com.google.android.photopicker";

    @NotNull
    private static final String PROVIDERS_MEDIA_CLASS = "com.google.android.providers.media.module";
    public static final int REQUEST_CODE_CAMERA = 30001;
    public static final int REQUEST_CODE_GALLERY = 30000;

    @NotNull
    private static final String TAG = "ImagePicker";

    @Nullable
    private Activity mActivity;

    @Nullable
    private AttachMenuAdapter mAdapter;

    @Nullable
    private List<AppInfo> mAppList;

    @Nullable
    private AlertDialog mDialog;

    @Nullable
    private Fragment mFragment;
    private int mGalleryMaxPickItemCount;

    @Nullable
    private GridView mGridView;
    private boolean mIsMultiple;

    @Nullable
    private DialogInterface.OnDismissListener mOnDismissListener;

    @Nullable
    private OnItemClickedListener mOnItemClickedListener;

    @Nullable
    private List<String> mRecentList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$AttachMenuAdapter;", "Landroid/widget/BaseAdapter;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "AppItemViewHolder", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class AttachMenuAdapter extends BaseAdapter {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$AttachMenuAdapter$AppItemViewHolder;", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$AttachMenuAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public final class AppItemViewHolder {

            @Nullable
            private ImageView icon;

            @Nullable
            private TextView name;

            public AppItemViewHolder() {
            }

            @Nullable
            public final ImageView getIcon() {
                return this.icon;
            }

            @Nullable
            public final TextView getName() {
                return this.name;
            }

            public final void setIcon(@Nullable ImageView imageView) {
                this.icon = imageView;
            }

            public final void setName(@Nullable TextView textView) {
                this.name = textView;
            }
        }

        public AttachMenuAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (ImagePicker.this.mAppList == null) {
                return 0;
            }
            List list = ImagePicker.this.mAppList;
            Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            return numValueOf.intValue();
        }

        @Override // android.widget.Adapter
        @Nullable
        public Object getItem(int position) {
            List list = ImagePicker.this.mAppList;
            if (list == null) {
                return null;
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        @Nullable
        public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
            AppItemViewHolder appItemViewHolder;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(C8875R.layout.image_picker_item_layout, parent, false);
                appItemViewHolder = new AppItemViewHolder();
                View viewFindViewById = convertView.findViewById(C8875R.id.icon);
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
                appItemViewHolder.setIcon((ImageView) viewFindViewById);
                View viewFindViewById2 = convertView.findViewById(C8875R.id.name);
                Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
                appItemViewHolder.setName((TextView) viewFindViewById2);
                convertView.setTag(appItemViewHolder);
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.AttachMenuAdapter.AppItemViewHolder");
                appItemViewHolder = (AppItemViewHolder) tag;
            }
            List list = ImagePicker.this.mAppList;
            AppInfo appInfo = list != null ? (AppInfo) list.get(position) : null;
            if (appInfo != null) {
                TextView name = appItemViewHolder.getName();
                if (name != null) {
                    name.setText(appInfo.getTitleString());
                }
                ImageView icon = appItemViewHolder.getIcon();
                if (icon != null) {
                    icon.setImageDrawable(appInfo.getIconDrawable());
                }
                return convertView;
            }
            Logger.m8698e(ImagePicker.TAG, "AttachMenuAdapter#getView# appInfo is null. getCount:" + getCount() + ", position:" + position);
            return convertView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker$OnItemClickedListener;", "", "onItemClicked", "", "requestCode", "", "pendingData", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/PendingData;", "setRequestCode", "printMemory", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnItemClickedListener {
        void onItemClicked(int requestCode, @Nullable PendingData pendingData);

        void printMemory();

        void setRequestCode(int requestCode);
    }

    private final void addAppList(int appType, Intent intent, PackageManager pm, ResolveInfo resolveInfo) {
        List<AppInfo> list;
        String str = resolveInfo.activityInfo.packageName;
        Object objClone = intent.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type android.content.Intent");
        Intent intent2 = (Intent) objClone;
        intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
        intent2.setPackage(str);
        Drawable applicationIconForIconTray = PackageManagerCompat.INSTANCE.getInstance().getApplicationIconForIconTray(this.mActivity, str, resolveInfo);
        if (applicationIconForIconTray == null) {
            AbstractC4539a.m3214x("fail getApplicationIconForIconTray: ", str, TAG);
            return;
        }
        String string = resolveInfo.loadLabel(pm).toString();
        Intrinsics.checkNotNull(str);
        AppInfo appInfo = new AppInfo(string, applicationIconForIconTray, intent2, appType, str);
        List<AppInfo> list2 = this.mAppList;
        Boolean boolValueOf = list2 != null ? Boolean.valueOf(list2.contains(appInfo)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        if (boolValueOf.booleanValue() || (list = this.mAppList) == null) {
            return;
        }
        list.add(appInfo);
    }

    private final void addRecentList(String packageName) {
        AbstractC4539a.m3206p("addRecentList# packageName:", packageName, TAG);
        List<String> list = this.mRecentList;
        if (list == null || (list != null && list.isEmpty())) {
            initRecentAppList();
        }
        List<String> list2 = this.mRecentList;
        if (list2 != null && list2.isEmpty()) {
            List<String> list3 = this.mRecentList;
            if (list3 != null) {
                list3.add(packageName);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(packageName);
        List<String> list4 = this.mRecentList;
        Intrinsics.checkNotNull(list4);
        for (String str : list4) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        this.mRecentList = arrayList;
    }

    private final Intent getAppIntent(int appType) {
        if (appType == AppInfo.APP_CAMERA) {
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }
        if (appType != AppInfo.APP_GALLERY) {
            if (appType == AppInfo.INSTANCE.getAPP_MORE_APPS()) {
                return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }
            return null;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_IMAGE);
        if (this.mIsMultiple) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            intent.putExtra(GALLERY_MULTI_PICK, true);
            int i = this.mGalleryMaxPickItemCount;
            if (i > 0) {
                intent.putExtra(GALLERY_PICK_MAX_ITEM, i);
            }
        }
        return intent;
    }

    private final void initAppList(int type) {
        setupAppList(type);
        sortAppList();
    }

    private final void initRecentAppList() {
        List<String> list = this.mRecentList;
        if (list == null) {
            this.mRecentList = new ArrayList();
        } else if (list != null) {
            list.clear();
        }
        int i = 0;
        int i2 = SharedPreferencesCompat.INSTANCE.getInstance(TAG).getInt(LAST_PICKER_SELECTED_PACKAGE_NUM, 0);
        while (true) {
            if (i >= i2) {
                break;
            }
            List<String> list2 = this.mRecentList;
            if (list2 != null) {
                list2.add(SharedPreferencesCompat.INSTANCE.getInstance(TAG).getString(LAST_PICKER_SELECTED_PACKAGE + i, null));
            }
            i++;
        }
        List<String> list3 = this.mRecentList;
        Logger.m8702i(TAG, "initRecentAppList# RecentList:" + (list3 != null ? Integer.valueOf(list3.size()) : null));
    }

    private final void loadApplicationList(int appType) {
        boolean z;
        Intent appIntent = getAppIntent(appType);
        if (appIntent == null) {
            return;
        }
        Activity activity = this.mActivity;
        PackageManager packageManager = activity != null ? activity.getPackageManager() : null;
        List<ResolveInfo> listQueryIntentActivities = packageManager != null ? packageManager.queryIntentActivities(appIntent, 65536) : null;
        if (appType == AppInfo.INSTANCE.getAPP_MORE_APPS()) {
            appType = AppInfo.APP_GALLERY;
        }
        if (listQueryIntentActivities == null) {
            return;
        }
        if (appType == AppInfo.APP_GALLERY) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(PHOTOPICKER_PACKAGE, it.next().activityInfo.packageName)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (!z || !Intrinsics.areEqual(PROVIDERS_MEDIA_CLASS, resolveInfo.activityInfo.packageName)) {
                Intrinsics.checkNotNull(resolveInfo);
                addAppList(appType, appIntent, packageManager, resolveInfo);
            }
        }
    }

    private final void release() {
        Logger.m8702i(TAG, "release#");
        GridView gridView = this.mGridView;
        if (gridView != null) {
            gridView.setAdapter((ListAdapter) null);
        }
        this.mGridView = null;
        this.mAdapter = null;
        this.mDialog = null;
        this.mFragment = null;
        this.mActivity = null;
        List<AppInfo> list = this.mAppList;
        if (list != null) {
            list.clear();
        }
        saveRecentAppList();
    }

    private final void saveRecentAppList() {
        List<String> list = this.mRecentList;
        if (list == null) {
            return;
        }
        if (list != null && list.isEmpty()) {
            return;
        }
        List<String> list2 = this.mRecentList;
        Logger.m8702i(TAG, "saveRecentAppList# RecentList:" + (list2 != null ? Integer.valueOf(list2.size()) : null));
        List<String> list3 = this.mRecentList;
        if (list3 != null) {
            SharedPreferencesCompat.INSTANCE.getInstance(TAG).putInt(LAST_PICKER_SELECTED_PACKAGE_NUM, list3.size());
        }
        List<String> list4 = this.mRecentList;
        IntRange indices = list4 != null ? CollectionsKt.getIndices(list4) : null;
        Intrinsics.checkNotNull(indices);
        int first = indices.getFirst();
        int last = indices.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance(TAG);
            String strM11h = AbstractC0000a.m11h(first, LAST_PICKER_SELECTED_PACKAGE);
            List<String> list5 = this.mRecentList;
            companion.putString(strM11h, list5 != null ? list5.get(first) : null);
            if (first == last) {
                return;
            } else {
                first++;
            }
        }
    }

    private final void setupAppList(int type) {
        AbstractC4539a.m3212v(type, "setupAppList# start:", TAG);
        List<AppInfo> list = this.mAppList;
        if (list == null) {
            this.mAppList = new ArrayList();
        } else if (list != null) {
            list.clear();
        }
        int i = AppInfo.APP_CAMERA;
        if (type == i) {
            loadApplicationList(i);
        } else {
            loadApplicationList(AppInfo.APP_GALLERY);
            if (Build.VERSION.SDK_INT <= 35 && UserHandleCompat.INSTANCE.getInstance().isSecureFolderMode()) {
                loadApplicationList(AppInfo.INSTANCE.getAPP_MORE_APPS());
            }
        }
        List<AppInfo> list2 = this.mAppList;
        Logger.m8702i(TAG, "setupAppList# end, App count : " + (list2 != null ? Integer.valueOf(list2.size()) : null));
    }

    private final boolean showDialog(View anchorView, Integer requestCode) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mActivity);
        int i = 0;
        if (layoutInflaterFrom == null) {
            return false;
        }
        View viewInflate = layoutInflaterFrom.inflate(C8875R.layout.image_picker_layout, (ViewGroup) null);
        Activity activity = this.mActivity;
        AlertDialog.Builder builder = activity != null ? new AlertDialog.Builder(activity) : null;
        if (builder != null) {
            builder.setView(viewInflate);
        }
        this.mAdapter = new AttachMenuAdapter();
        View viewFindViewById = viewInflate.findViewById(C8875R.id.app_chooser);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.GridView");
        GridView gridView = (GridView) viewFindViewById;
        this.mGridView = gridView;
        if (gridView != null) {
            gridView.setAdapter((ListAdapter) this.mAdapter);
        }
        GridView gridView2 = this.mGridView;
        if (gridView2 != null) {
            gridView2.setOnItemClickListener(new C8971a(this, requestCode, 0));
        }
        View viewFindViewById2 = viewInflate.findViewById(C8875R.id.no_item_text);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById2;
        GridView gridView3 = this.mGridView;
        if (gridView3 != null) {
            List<AppInfo> list = this.mAppList;
            gridView3.setVisibility((list == null || !list.isEmpty()) ? 0 : 4);
        }
        if (this.mAppList != null && (!r0.isEmpty())) {
            i = 4;
        }
        textView.setVisibility(i);
        AlertDialog alertDialogCreate = builder != null ? builder.create() : null;
        this.mDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 6));
        }
        DesktopModeCompat companion = DesktopModeCompat.INSTANCE.getInstance();
        Activity activity2 = this.mActivity;
        if (!companion.isDexMode(activity2 != null ? activity2.getApplicationContext() : null)) {
            AlertDialogWrapper.setAnchorView(this.mDialog, anchorView, AlertDialogWrapper.AnchorType.INSTANCE.getTOOLBAR());
        }
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$3(ImagePicker imagePicker, Integer num, AdapterView adapterView, View view, int i, long j) {
        AbstractC4539a.m3203m(i, "onItemClick# ", TAG);
        CommonSamsungAnalytics.INSTANCE.insertLog("401", "4100");
        imagePicker.onItemClick(i, num);
        AlertDialog alertDialog = imagePicker.mDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$4(ImagePicker imagePicker, DialogInterface dialogInterface) {
        Logger.m8697d(TAG, "onDismiss#");
        DialogInterface.OnDismissListener onDismissListener = imagePicker.mOnDismissListener;
        if (onDismissListener != null && onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        imagePicker.release();
    }

    private final void sortAppList() {
        List<AppInfo> list = this.mAppList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.size() <= 1) {
                return;
            }
            initRecentAppList();
            List<AppInfo> list2 = this.mAppList;
            if (list2 != null) {
                CollectionsKt.sortWith(list2, new Comparator<AppInfo>() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.sortAppList.1
                    @Override // java.util.Comparator
                    public int compare(AppInfo o12, AppInfo o22) {
                        Boolean boolValueOf;
                        Boolean boolValueOf2;
                        Boolean boolValueOf3;
                        if (o22 == null) {
                            Logger.m8698e(ImagePicker.TAG, "sortAppList# compare o2 is null");
                            return 0;
                        }
                        if (ImagePicker.this.mRecentList != null && (!r0.isEmpty())) {
                            List list3 = ImagePicker.this.mRecentList;
                            if (list3 != null) {
                                boolValueOf = Boolean.valueOf(list3.contains(o12 != null ? o12.getPackageName() : null));
                            } else {
                                boolValueOf = null;
                            }
                            Intrinsics.checkNotNull(boolValueOf);
                            if (boolValueOf.booleanValue()) {
                                List list4 = ImagePicker.this.mRecentList;
                                Boolean boolValueOf4 = list4 != null ? Boolean.valueOf(list4.contains(o22.getPackageName())) : null;
                                Intrinsics.checkNotNull(boolValueOf4);
                                if (boolValueOf4.booleanValue()) {
                                    List list5 = ImagePicker.this.mRecentList;
                                    if (list5 != null) {
                                        int iIndexOf = list5.indexOf(o12 != null ? o12.getPackageName() : null);
                                        List list6 = ImagePicker.this.mRecentList;
                                        numValueOf = list6 != null ? Integer.valueOf(list6.indexOf(o22.getPackageName())) : null;
                                        Intrinsics.checkNotNull(numValueOf);
                                        numValueOf = Integer.valueOf(iIndexOf - numValueOf.intValue());
                                    }
                                    Intrinsics.checkNotNull(numValueOf);
                                    return numValueOf.intValue();
                                }
                            }
                            List list7 = ImagePicker.this.mRecentList;
                            if (list7 != null) {
                                boolValueOf2 = Boolean.valueOf(list7.contains(o12 != null ? o12.getPackageName() : null));
                            } else {
                                boolValueOf2 = null;
                            }
                            Intrinsics.checkNotNull(boolValueOf2);
                            if (boolValueOf2.booleanValue()) {
                                List list8 = ImagePicker.this.mRecentList;
                                Boolean boolValueOf5 = list8 != null ? Boolean.valueOf(list8.contains(o22.getPackageName())) : null;
                                Intrinsics.checkNotNull(boolValueOf5);
                                if (!boolValueOf5.booleanValue()) {
                                    return -1;
                                }
                            }
                            List list9 = ImagePicker.this.mRecentList;
                            if (list9 != null) {
                                boolValueOf3 = Boolean.valueOf(list9.contains(o12 != null ? o12.getPackageName() : null));
                            } else {
                                boolValueOf3 = null;
                            }
                            Intrinsics.checkNotNull(boolValueOf3);
                            if (!boolValueOf3.booleanValue()) {
                                List list10 = ImagePicker.this.mRecentList;
                                Boolean boolValueOf6 = list10 != null ? Boolean.valueOf(list10.contains(o22.getPackageName())) : null;
                                Intrinsics.checkNotNull(boolValueOf6);
                                if (boolValueOf6.booleanValue()) {
                                    return 1;
                                }
                            }
                        }
                        String packageName = o12 != null ? o12.getPackageName() : null;
                        if (packageName != null) {
                            int iHashCode = packageName.hashCode();
                            if (iHashCode != -319861862) {
                                if (iHashCode != 469096949) {
                                    if (iHashCode == 1923638331 && packageName.equals(ImagePicker.CAMERA_PACKAGE_NAME)) {
                                        return Intrinsics.areEqual("com.sec.android.gallery3d", o22.getPackageName()) ? 1 : -1;
                                    }
                                } else if (packageName.equals("com.sec.android.app.myfiles")) {
                                    return (Intrinsics.areEqual("com.sec.android.gallery3d", o22.getPackageName()) || Intrinsics.areEqual(ImagePicker.CAMERA_PACKAGE_NAME, o22.getPackageName())) ? 1 : -1;
                                }
                            } else if (packageName.equals("com.sec.android.gallery3d")) {
                                return -1;
                            }
                        }
                        numValueOf = o12 != null ? Integer.valueOf(o12.getAppType() - o22.getAppType()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        return numValueOf.intValue();
                    }
                });
            }
        }
    }

    private final void startApplication(Intent intent, int requestCode, PendingData pendingData) {
        startApplication(this.mActivity, intent, requestCode, pendingData);
    }

    @Nullable
    public final List<Uri> getUrisFromResult(@Nullable Intent data, int resultCode) {
        if (resultCode == -1 && data != null) {
            if (data.getClipData() != null) {
                ClipData clipData = data.getClipData();
                Logger.m8697d(TAG, "getUrisFromResult# " + (clipData != null ? Integer.valueOf(clipData.getItemCount()) : null));
                ArrayList arrayList = clipData != null ? new ArrayList(clipData.getItemCount()) : null;
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i = 0; i < itemCount; i++) {
                        ClipData.Item itemAt = clipData.getItemAt(i);
                        if (itemAt != null && arrayList != null) {
                            arrayList.add(itemAt.getUri());
                        }
                    }
                }
                return arrayList;
            }
            int intExtra = data.getIntExtra(GALLERY_SELECTED_COUNT, 0);
            AbstractC4539a.m3203m(intExtra, "getUrisFromResult# selectedCount: ", TAG);
            if (intExtra > 0) {
                return data.getParcelableArrayListExtra(GALLERY_SELECTED_ITEMS);
            }
            Uri data2 = data.getData();
            if (data2 != null) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(data2);
                return arrayList2;
            }
        }
        return null;
    }

    public final void hide() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.mDialog;
        if (alertDialog2 == null || alertDialog2 == null || !alertDialog2.isShowing() || (alertDialog = this.mDialog) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    public final boolean isShowing() {
        AlertDialog alertDialog = this.mDialog;
        return (alertDialog == null || alertDialog == null || !alertDialog.isShowing()) ? false : true;
    }

    public final void onItemClick(int position, @Nullable Integer requestCode) {
        PendingData pendingData = null;
        try {
            List<AppInfo> list = this.mAppList;
            AppInfo appInfo = list != null ? list.get(position) : null;
            if (appInfo != null && appInfo.getAppType() == AppInfo.APP_GALLERY) {
                if (requestCode == null) {
                    requestCode = 30000;
                }
                CommonSamsungAnalytics.INSTANCE.insertLog("401", "4042");
                startApplication(appInfo.getIntent(), requestCode.intValue(), null);
            } else if (appInfo != null && appInfo.getAppType() == AppInfo.APP_CAMERA) {
                Activity activity = this.mActivity;
                Intrinsics.checkNotNull(activity);
                if (PolicyManager.getCameraDisabled(activity)) {
                    return;
                }
                Intent intent = appInfo.getIntent();
                PendingData pendingData2 = new PendingData();
                try {
                    requestCode = Integer.valueOf(REQUEST_CODE_CAMERA);
                    String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(8)).toArray(new String[0]);
                    if (PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                        intent.putExtra("output", pendingData2.getTakePictureUri(this.mActivity));
                        startApplication(intent, REQUEST_CODE_CAMERA, pendingData2);
                    } else {
                        pendingData2.setPendingIntent(intent);
                        Fragment fragment = this.mFragment;
                        Intrinsics.checkNotNull(fragment);
                        PermissionHelper.requestPermissions(fragment, REQUEST_CODE_CAMERA, (String[]) Arrays.copyOf(strArr, strArr.length));
                    }
                    pendingData = pendingData2;
                } catch (ActivityNotFoundException e) {
                    e = e;
                    pendingData = pendingData2;
                    AbstractC4539a.m3214x("onItemClick ActivityNotFoundException : ", e.getMessage(), TAG);
                }
            }
        } catch (ActivityNotFoundException e2) {
            e = e2;
        }
        OnItemClickedListener onItemClickedListener = this.mOnItemClickedListener;
        if (onItemClickedListener != null) {
            onItemClickedListener.onItemClicked(requestCode != null ? requestCode.intValue() : -1, pendingData);
        }
    }

    public final boolean onRequestPermissionsResult(@NotNull Activity activity, int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults, @Nullable PendingData pendingData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode != 30001) {
            return false;
        }
        if (!PermissionHelper.verifyRequestResult(activity, grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
            if (pendingData != null) {
                pendingData.deleteFileForTakePicture();
            }
            if (pendingData == null) {
                return true;
            }
            pendingData.clear();
            return true;
        }
        if (pendingData == null) {
            return true;
        }
        if (pendingData.getTakenPictureUri() == null) {
            Uri takePictureUri = pendingData.getTakePictureUri(activity);
            Intent pendingIntent = pendingData.getPendingIntent();
            if (pendingIntent != null) {
                pendingIntent.putExtra("output", takePictureUri);
            }
        }
        Intent pendingIntent2 = pendingData.getPendingIntent();
        if (pendingIntent2 == null) {
            return true;
        }
        startApplication(activity, pendingIntent2, REQUEST_CODE_CAMERA, pendingData);
        return true;
    }

    public final void setGalleryPickMaxItemCount(int galleryMaxPickItemCount) {
        this.mGalleryMaxPickItemCount = galleryMaxPickItemCount;
        AbstractC4539a.m3212v(galleryMaxPickItemCount, "setGalleryPickMaxItemCount# count:", TAG);
    }

    public final boolean show(@NotNull Fragment fragment, @Nullable View anchorView, int type, boolean isMultiple, @Nullable OnItemClickedListener onItemClickedListener, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return show(fragment, anchorView, type, isMultiple, null, onItemClickedListener, onDismissListener);
    }

    private final void startApplication(Activity activity, Intent intent, int requestCode, PendingData pendingData) {
        AbstractC4539a.m3203m(requestCode, "startApplication, code: ", TAG);
        if (requestCode == 30001) {
            try {
                OnItemClickedListener onItemClickedListener = this.mOnItemClickedListener;
                if (onItemClickedListener != null) {
                    onItemClickedListener.printMemory();
                }
            } catch (Exception e) {
                AbstractC4539a.m3214x("startApplication, exception.", e.getMessage(), TAG);
                if (pendingData != null) {
                    pendingData.deleteFileForTakePicture();
                    pendingData.clear();
                }
                OnItemClickedListener onItemClickedListener2 = this.mOnItemClickedListener;
                if (onItemClickedListener2 != null) {
                    onItemClickedListener2.setRequestCode(-1);
                    return;
                }
                return;
            }
        }
        if (activity != null) {
            activity.startActivityForResult(intent, requestCode);
        }
        OnItemClickedListener onItemClickedListener3 = this.mOnItemClickedListener;
        if (onItemClickedListener3 != null) {
            onItemClickedListener3.setRequestCode(requestCode);
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            addRecentList(packageName);
        }
    }

    public final boolean show(@NotNull Fragment fragment, @Nullable View anchorView, int type, boolean isMultiple, @Nullable Integer requestCode, @Nullable OnItemClickedListener onItemClickedListener, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        Resources resources;
        Resources resources2;
        AlertDialog alertDialog;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        AlertDialog alertDialog2 = this.mDialog;
        if (alertDialog2 != null && alertDialog2 != null && alertDialog2.isShowing() && (alertDialog = this.mDialog) != null) {
            alertDialog.dismiss();
        }
        this.mFragment = fragment;
        this.mActivity = fragment.getActivity();
        this.mOnItemClickedListener = onItemClickedListener;
        this.mOnDismissListener = onDismissListener;
        this.mIsMultiple = isMultiple;
        initAppList(type);
        List<AppInfo> list = this.mAppList;
        string = null;
        String string = null;
        string = null;
        String string2 = null;
        if (list == null || !list.isEmpty()) {
            List<AppInfo> list2 = this.mAppList;
            Integer numValueOf = list2 != null ? Integer.valueOf(list2.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (numValueOf.intValue() == 1) {
                onItemClick(0, requestCode);
            } else if (showDialog(anchorView, requestCode)) {
                Logger.m8702i(TAG, "show# success!!");
                return true;
            }
        } else {
            Activity activity = this.mActivity;
            if (activity != null && SettingsCompat.INSTANCE.getInstance().isUPSM(activity)) {
                Activity activity2 = this.mActivity;
                if (activity2 != null && (resources2 = activity2.getResources()) != null) {
                    int i = C8875R.string.app_chooser_upsm_mode_add_gallery_or_camera_to_the_home_screen;
                    Activity activity3 = this.mActivity;
                    String string3 = activity3 != null ? activity3.getString(C8875R.string.gallery_title) : null;
                    Activity activity4 = this.mActivity;
                    string = resources2.getString(i, string3, activity4 != null ? activity4.getString(C8875R.string.camera_title) : null);
                }
                if (string != null) {
                    ToastHandler.show(this.mActivity, string, 1);
                }
            } else if (EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(this.mActivity)) {
                Activity activity5 = this.mActivity;
                if (activity5 != null && (resources = activity5.getResources()) != null) {
                    int i2 = C8875R.string.app_chooser_emergency_mode_unable_to_use_attach;
                    Activity activity6 = this.mActivity;
                    string2 = resources.getString(i2, activity6 != null ? activity6.getString(C8875R.string.app_chooser_attach) : null);
                }
                if (string2 != null) {
                    ToastHandler.show(this.mActivity, string2, 1);
                }
            }
        }
        release();
        return false;
    }
}
