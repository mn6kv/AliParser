package ru.itis.mn6kv.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class ProductDto {
    private String productId;
    private String sellerId;
    private String oriMinPrice;
    private String oriMaxPrice;
    private String promotionId;
    private String startTime;
    private String endTime;
    private int phase;
    private String productTitle;
    private String discount;
    private String totalStock;
    private String stock;
    private String orders;
    private boolean soldout;
    private String productImage;
    private String productDetailUrl;
    private String trace;
    private String pvid;
    private String totalTranpro3;
    private String productPositiveRate;
    private String productAverageStar;
    private int itemEvalTotalNum;
    private String icon;
    private String iconHeight;
    private String iconWidth;
    private String gmtCreate;
}
