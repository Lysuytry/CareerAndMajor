package com.example.sss.careerandfuturemajor;

public class Creator {
    private String name,phone,facebook;
    private int pic;
    public Creator(){

    }
    public Creator(String name,String phone ,String fb,int pic){
        this.name=name;
        this.phone=phone;
        this.facebook=fb;
        this.pic=pic;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
