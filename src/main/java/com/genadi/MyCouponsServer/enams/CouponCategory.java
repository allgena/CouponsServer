package com.genadi.MyCouponsServer.enams;

public enum CouponCategory {
    FOOD("food4.jpg"),
    ELECTRONICS("electronics1.jpg"),
    TOYS("toy3.jpg"),
    COSMETICS("cosmet4.png");

    private String image;

    CouponCategory(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
