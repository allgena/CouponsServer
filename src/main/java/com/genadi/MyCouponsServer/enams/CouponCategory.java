package com.genadi.MyCouponsServer.enams;

public enum CouponCategory {
    FOOD("food4.jpg"),
    ELECTRICS("electro2.jpg"),
    TOYS("toy3.jpg"),
    COSMETICS("cosmet1.jpg");

    private String image;

    CouponCategory(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
