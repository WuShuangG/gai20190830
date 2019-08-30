package com.bawei.day20190830;

import java.util.List;

/**
 * author: 盖磊
 * data: 2019/8/30 19:19:41
 * function:
 */
public class ListBean {

    private List<ResultInfo> result;

    public List<ResultInfo> getResult() {
        return result;
    }

    public void setResult(List<ResultInfo> result) {
        this.result = result;
    }

    public class ResultInfo {

        private String imageUrl;
        private String name;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
