package com.ps.novelapp.model;

public class BannerBean {
    /**
     * code : 0
     * message : 请求成功
     * data : {"top":{"img_url":"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1932297764,1562619257&fm=173&app=25&f=JPEG?w=218&h=146&s=4175A366DFA9936C127C12A90300F081","url":"https://www.baidu.com"},"bottom":{"img_url":"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=413094490,259374856&fm=173&app=25&f=JPEG?w=218&h=146&s=1AA27C23EEB06B963D382DE50100E0E0","url":"https://www.jd.com"},"plugin":{"img_url":"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4194851996,3673630951&fm=173&app=25&f=JPEG?w=218&h=146&s=0A80E002E3061B5BDBA1CF870300F0A7","url":"https://www.taobao.com"}}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * top : {"img_url":"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1932297764,1562619257&fm=173&app=25&f=JPEG?w=218&h=146&s=4175A366DFA9936C127C12A90300F081","url":"https://www.baidu.com"}
         * bottom : {"img_url":"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=413094490,259374856&fm=173&app=25&f=JPEG?w=218&h=146&s=1AA27C23EEB06B963D382DE50100E0E0","url":"https://www.jd.com"}
         * plugin : {"img_url":"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4194851996,3673630951&fm=173&app=25&f=JPEG?w=218&h=146&s=0A80E002E3061B5BDBA1CF870300F0A7","url":"https://www.taobao.com"}
         */

        private TopBean top;
        private BottomBean bottom;
        private PluginBean plugin;

        public TopBean getTop() {
            return top;
        }

        public void setTop(TopBean top) {
            this.top = top;
        }

        public BottomBean getBottom() {
            return bottom;
        }

        public void setBottom(BottomBean bottom) {
            this.bottom = bottom;
        }

        public PluginBean getPlugin() {
            return plugin;
        }

        public void setPlugin(PluginBean plugin) {
            this.plugin = plugin;
        }

        public static class TopBean {
            /**
             * img_url : https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1932297764,1562619257&fm=173&app=25&f=JPEG?w=218&h=146&s=4175A366DFA9936C127C12A90300F081
             * url : https://www.baidu.com
             */

            private String img_url;
            private String url;

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class BottomBean {
            /**
             * img_url : https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=413094490,259374856&fm=173&app=25&f=JPEG?w=218&h=146&s=1AA27C23EEB06B963D382DE50100E0E0
             * url : https://www.jd.com
             */

            private String img_url;
            private String url;

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class PluginBean {
            /**
             * img_url : https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4194851996,3673630951&fm=173&app=25&f=JPEG?w=218&h=146&s=0A80E002E3061B5BDBA1CF870300F0A7
             * url : https://www.taobao.com
             */

            private String img_url;
            private String url;

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
