package com.KPMG_wiseuniv.fitting_room;

//class for ThirdSurveyStyleAdapter(ArrayAdapter)

public class ThirdSurveyStyleList {
    String style;
    String desc;
    int resId;

    //생성
    public ThirdSurveyStyleList(String style, String desc, int resId) {
        this.style = style;
        this.desc = desc;
        this.resId = resId;
    }

    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "SingleStyle{" +
                "style='" + style + '\'' +
                ", desc='" + desc + '\'' +
                ", resId=" + resId +
                '}';
    }
}
