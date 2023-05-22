package com.genadi.MyCouponsServer.enams;

public enum CouponCategory {
    FOOD("/public/img/food3.jpg"),
    ELECTRICS("/public/img/electro2.jpg"),
    TOYS("/public/img/toy3.jpg"),
    COSMETICS("/public/img/cosmet4.jpg");

    private String image;

    CouponCategory(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
