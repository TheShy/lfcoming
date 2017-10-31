package com.zwtx.swing.lfcoming.MVP.Entity;

import java.util.List;

/**
 * Created by SuperSow
 */

public class HomeDto {

    private List<BannerDto> banner;
    
    public List<BannerDto> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerDto> banner) {
        this.banner = banner;
    }
}
