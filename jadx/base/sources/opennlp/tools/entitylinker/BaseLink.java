package opennlp.tools.entitylinker;

import androidx.glance.AbstractC2821a;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseLink {
    private String itemID;
    private String itemName;
    private String itemParentID;
    private String itemType;
    private Map<String, Double> scoreMap = new HashMap();

    public BaseLink(String str, String str2, String str3, String str4) {
        this.itemParentID = str;
        this.itemID = str2;
        this.itemName = str3;
        this.itemType = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BaseLink) {
            BaseLink baseLink = (BaseLink) obj;
            if (Objects.equals(this.itemParentID, baseLink.itemParentID) && Objects.equals(this.itemID, baseLink.itemID) && Objects.equals(this.itemName, baseLink.itemName) && Objects.equals(this.itemType, baseLink.itemType)) {
                return true;
            }
        }
        return false;
    }

    public String getItemID() {
        return this.itemID;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemParentID() {
        return this.itemParentID;
    }

    public String getItemType() {
        return this.itemType;
    }

    public Map<String, Double> getScoreMap() {
        return this.scoreMap;
    }

    public int hashCode() {
        return Objects.hash(this.itemParentID, this.itemID, this.itemName, this.itemType);
    }

    public void setItemID(String str) {
        this.itemID = str;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public void setItemParentID(String str) {
        this.itemParentID = str;
    }

    public void setItemType(String str) {
        this.itemType = str;
    }

    public void setScoreMap(Map<String, Double> map) {
        this.scoreMap = map;
    }

    public String toString() {
        String str = this.itemParentID;
        String str2 = this.itemID;
        String str3 = this.itemName;
        String str4 = this.itemType;
        Map<String, Double> map = this.scoreMap;
        StringBuilder sbM16m = AbstractC0000a.m16m("\tBaseLink\n\titemParentID=", str, ", \n\titemID=", str2, ", \n\titemName=");
        AbstractC2821a.m2207B(sbM16m, str3, ", \n\titemType=", str4, ", \n\tscoreMap=");
        sbM16m.append(map);
        sbM16m.append("\n");
        return sbM16m.toString();
    }
}
