package com.example.hello;

public class DealerItems {

    private String dddname;
    private String dddbrand;
    private String dddprice;
    private String dddquantity;

    public DealerItems(String dddname, String dddbrand, String dddprice, String dddquantity) {
        this.dddname = dddname;
        this.dddbrand = dddbrand;
        this.dddprice = dddprice;
        this.dddquantity = dddquantity;
    }

    public String getDddname() {
        return dddname;
    }

    public void setDddname(String dddname) {
        this.dddname = dddname;
    }

    public String getDddbrand() {
        return dddbrand;
    }

    public void setDddbrand(String dddbrand) {
        this.dddbrand = dddbrand;
    }

    public String getDddprice() {
        return dddprice;
    }

    public void setDddprice(String dddprice) {
        this.dddprice = dddprice;
    }

    public String getDddquantity() {
        return dddquantity;
    }

    public void setDddquantity(String dddquantity) {
        this.dddquantity = dddquantity;
    }
}
