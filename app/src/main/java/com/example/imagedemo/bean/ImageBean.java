package com.example.imagedemo.bean;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageBean {

    @SerializedName("total")
    private Integer total;
    @SerializedName("end")
    private Boolean end;
    @SerializedName("sid")
    private String sid;
    @SerializedName("ran")
    private Integer ran;
    @SerializedName("ras")
    private Integer ras;
    @SerializedName("cuben")
    private Integer cuben;
    @SerializedName("manun")
    private Integer manun;
    @SerializedName("pornn")
    private Integer pornn;
    @SerializedName("kn")
    private Integer kn;
    @SerializedName("cn")
    private Integer cn;
    @SerializedName("gn")
    private Integer gn;
    @SerializedName("ps")
    private Integer ps;
    @SerializedName("pc")
    private Integer pc;
    @SerializedName("adstar")
    private Integer adstar;
    @SerializedName("lastindex")
    private Integer lastindex;
    @SerializedName("ceg")
    private Boolean ceg;
    @SerializedName("list")
    private List<ListDTO> list;
    @SerializedName("boxresult")
    private Object boxresult;
    @SerializedName("wordguess")
    private Object wordguess;
    @SerializedName("prevsn")
    private Integer prevsn;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getRan() {
        return ran;
    }

    public void setRan(Integer ran) {
        this.ran = ran;
    }

    public Integer getRas() {
        return ras;
    }

    public void setRas(Integer ras) {
        this.ras = ras;
    }

    public Integer getCuben() {
        return cuben;
    }

    public void setCuben(Integer cuben) {
        this.cuben = cuben;
    }

    public Integer getManun() {
        return manun;
    }

    public void setManun(Integer manun) {
        this.manun = manun;
    }

    public Integer getPornn() {
        return pornn;
    }

    public void setPornn(Integer pornn) {
        this.pornn = pornn;
    }

    public Integer getKn() {
        return kn;
    }

    public void setKn(Integer kn) {
        this.kn = kn;
    }

    public Integer getCn() {
        return cn;
    }

    public void setCn(Integer cn) {
        this.cn = cn;
    }

    public Integer getGn() {
        return gn;
    }

    public void setGn(Integer gn) {
        this.gn = gn;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public Integer getAdstar() {
        return adstar;
    }

    public void setAdstar(Integer adstar) {
        this.adstar = adstar;
    }

    public Integer getLastindex() {
        return lastindex;
    }

    public void setLastindex(Integer lastindex) {
        this.lastindex = lastindex;
    }

    public Boolean getCeg() {
        return ceg;
    }

    public void setCeg(Boolean ceg) {
        this.ceg = ceg;
    }

    public List<ListDTO> getList() {
        return list;
    }

    public void setList(List<ListDTO> list) {
        this.list = list;
    }

    public Object getBoxresult() {
        return boxresult;
    }

    public void setBoxresult(Object boxresult) {
        this.boxresult = boxresult;
    }

    public Object getWordguess() {
        return wordguess;
    }

    public void setWordguess(Object wordguess) {
        this.wordguess = wordguess;
    }

    public Integer getPrevsn() {
        return prevsn;
    }

    public void setPrevsn(Integer prevsn) {
        this.prevsn = prevsn;
    }

    public  class ListDTO extends BaseObservable {
        @SerializedName("id")
        private String id;
        @SerializedName("qqface_down_url")
        private Boolean qqfaceDownUrl;
        @SerializedName("downurl")
        private Boolean downurl;
        @SerializedName("downurl_true")
        private String downurlTrue;
        @SerializedName("grpmd5")
        private Boolean grpmd5;
        @SerializedName("type")
        private Integer type;
        @SerializedName("src")
        private String src;
        @SerializedName("color")
        private Integer color;
        @SerializedName("index")
        private Integer index;
        @SerializedName("title")
        private String title;
        @SerializedName("litetitle")
        private String litetitle;
        @SerializedName("width")
        private String width;
        @SerializedName("height")
        private String height;
        @SerializedName("imgsize")
        private String imgsize;
        @SerializedName("imgtype")
        private String imgtype;
        @SerializedName("key")
        private String key;
        @SerializedName("dspurl")
        private String dspurl;
        @SerializedName("link")
        private String link;
        @SerializedName("source")
        private Integer source;
        @SerializedName("img")
        private String img;
        @SerializedName("thumb_bak")
        private String thumbBak;
        @SerializedName("thumb")
        private String thumb;
        @SerializedName("imgkey")
        private String imgkey;
        @SerializedName("thumbWidth")
        private Integer thumbWidth;
        @SerializedName("dsptime")
        private String dsptime;
        @SerializedName("thumbHeight")
        private Integer thumbHeight;
        @SerializedName("grpcnt")
        private String grpcnt;
        @SerializedName("fixedSize")
        private Boolean fixedSize;
        @SerializedName("fnum")
        private String fnum;
        @SerializedName("comm_purl")
        private String commPurl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getQqfaceDownUrl() {
            return qqfaceDownUrl;
        }

        public void setQqfaceDownUrl(Boolean qqfaceDownUrl) {
            this.qqfaceDownUrl = qqfaceDownUrl;
        }

        public Boolean getDownurl() {
            return downurl;
        }

        public void setDownurl(Boolean downurl) {
            this.downurl = downurl;
        }

        public String getDownurlTrue() {
            return downurlTrue;
        }

        public void setDownurlTrue(String downurlTrue) {
            this.downurlTrue = downurlTrue;
        }

        public Boolean getGrpmd5() {
            return grpmd5;
        }

        public void setGrpmd5(Boolean grpmd5) {
            this.grpmd5 = grpmd5;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public Integer getColor() {
            return color;
        }

        public void setColor(Integer color) {
            this.color = color;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLitetitle() {
            return litetitle;
        }

        public void setLitetitle(String litetitle) {
            this.litetitle = litetitle;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getImgsize() {
            return imgsize;
        }

        public void setImgsize(String imgsize) {
            this.imgsize = imgsize;
        }

        public String getImgtype() {
            return imgtype;
        }

        public void setImgtype(String imgtype) {
            this.imgtype = imgtype;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getDspurl() {
            return dspurl;
        }

        public void setDspurl(String dspurl) {
            this.dspurl = dspurl;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getThumbBak() {
            return thumbBak;
        }

        public void setThumbBak(String thumbBak) {
            this.thumbBak = thumbBak;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }


        public String getImgkey() {
            return imgkey;
        }

        public void setImgkey(String imgkey) {
            this.imgkey = imgkey;
        }

        public Integer getThumbWidth() {
            return thumbWidth;
        }

        public void setThumbWidth(Integer thumbWidth) {
            this.thumbWidth = thumbWidth;
        }

        public String getDsptime() {
            return dsptime;
        }

        public void setDsptime(String dsptime) {
            this.dsptime = dsptime;
        }

        public Integer getThumbHeight() {
            return thumbHeight;
        }

        public void setThumbHeight(Integer thumbHeight) {
            this.thumbHeight = thumbHeight;
        }

        public String getGrpcnt() {
            return grpcnt;
        }

        public void setGrpcnt(String grpcnt) {
            this.grpcnt = grpcnt;
        }

        public Boolean getFixedSize() {
            return fixedSize;
        }

        public void setFixedSize(Boolean fixedSize) {
            this.fixedSize = fixedSize;
        }

        public String getFnum() {
            return fnum;
        }

        public void setFnum(String fnum) {
            this.fnum = fnum;
        }

        public String getCommPurl() {
            return commPurl;
        }

        public void setCommPurl(String commPurl) {
            this.commPurl = commPurl;
        }
    }
}
