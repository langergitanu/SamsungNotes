package com.samsung.android.support.senl.p148nt.composer.main.base.model.web;

import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.LinkSourceContentVer3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LinkSourceContent extends LinkSourceContentVer3 {
    private String raw = "";
    private String cannonicalUrl = "";
    private HashMap<String, String> metaTags = new HashMap<>();
    private List<String> images = new ArrayList();
    private String[] urlData = new String[2];

    public String getCannonicalUrl() {
        return this.cannonicalUrl;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.LinkSourceContentVer3
    public List<String> getImages() {
        return this.images;
    }

    public HashMap<String, String> getMetaTags() {
        return this.metaTags;
    }

    public String getRaw() {
        return this.raw;
    }

    public String[] getUrlData() {
        return this.urlData;
    }

    public void setCannonicalUrl(String str) {
        this.cannonicalUrl = str;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.LinkSourceContentVer3
    public void setImages(List<String> list) {
        this.images = list;
    }

    public void setMetaTags(HashMap<String, String> map) {
        this.metaTags = map;
    }

    public void setRaw(String str) {
        this.raw = str;
    }

    public void setUrlData(String[] strArr) {
        this.urlData = strArr;
    }
}
