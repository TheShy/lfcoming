package com.zwtx.swing.lfcoming.MVP.Entity;

/**
 * Created by SuperSow
 */

public class BannerDto {

        /**
         * news_link : https://read.qidian.com/chapter/pIgHEqTNkOZqqtWmhQLkJA2/uRUznuywbO34p8iEw--PPw2
         * photo_url : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509699953&di=dbc85ad7db7f46b05affafaf40591830&imgtype=jpg&er=1&src=http%3A%2F%2Fpic1.16pic.com%2F00%2F11%2F51%2F16pic_1151178_b.jpg
         */

        private String news_link;
        private String photo_url;

        public String getNews_link() {
            return news_link;
        }

        public void setNews_link(String news_link) {
            this.news_link = news_link;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }
}
