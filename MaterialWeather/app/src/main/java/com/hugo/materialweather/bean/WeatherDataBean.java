package com.hugo.materialweather.bean;

import java.util.List;

/**
 * @auther Hugo
 * Created on 2016/4/13 20:03.
 */
public class WeatherDataBean {


    /**
     * EpochTime : 1460269260
     * LocalObservationDateTime : 2016-04-10T14:21:00+08:00
     * Pressure : 1009.4
     * RealFeelTemperature : 24.3
     * RelativeHumidity : 58
     * UVIndex : 6
     * Visibility : 20.9
     * WindDirectionDegrees : 90
     * WindSpeed : 3.2
     */

    private AccuCcBean accu_cc;
    /**
     * DailyForecasts : [{"Date":"2016-04-10T07:00:00+08:00","EpochDate":"1460242800","PrecipitationProbability":"25","Sun_EpochRise":"1460241600","Sun_EpochSet":"1460287200","Sun_Rise":"2016-04-10T06:40:00+08:00","Sun_Set":"2016-04-10T19:20:00+08:00"},{"Date":"2016-04-11T07:00:00+08:00","EpochDate":"1460329200","PrecipitationProbability":"25","Sun_EpochRise":"1460327940","Sun_EpochSet":"1460373660","Sun_Rise":"2016-04-11T06:39:00+08:00","Sun_Set":"2016-04-11T19:21:00+08:00"},{"Date":"2016-04-12T07:00:00+08:00","EpochDate":"1460415600","PrecipitationProbability":"25","Sun_EpochRise":"1460414280","Sun_EpochSet":"1460460060","Sun_Rise":"2016-04-12T06:38:00+08:00","Sun_Set":"2016-04-12T19:21:00+08:00"},{"Date":"2016-04-13T07:00:00+08:00","EpochDate":"1460502000","PrecipitationProbability":"11","Sun_EpochRise":"1460500620","Sun_EpochSet":"1460546520","Sun_Rise":"2016-04-13T06:37:00+08:00","Sun_Set":"2016-04-13T19:22:00+08:00"},{"Date":"2016-04-14T07:00:00+08:00","EpochDate":"1460588400","PrecipitationProbability":"25","Sun_EpochRise":"1460586960","Sun_EpochSet":"1460632920","Sun_Rise":"2016-04-14T06:36:00+08:00","Sun_Set":"2016-04-14T19:22:00+08:00"}]
     * EffectiveDate : 2016-04-12T01:00:00+08:00
     * EffectiveEpochDate : 1460394000
     */

    private AccuF5Bean accu_f5;
    /**
     * aqi : 80
     * city : 六枝
     * city_id : 101260802
     * no2 : 32
     * pm10 : 106
     * pm25 : 51
     * pub_time : 2016-04-10 13:00
     * so2 : 10
     * spot :
     * src : 中国环境监测总站
     */

    private AqiBean aqi;
    /**
     * city : 六枝
     * city_en : liuzhi
     * cityid : 101260802
     * date :
     * date_y : 2016年04月10日
     * fchh : 11
     * fl1 : 小于3级
     * fl2 : 小于3级
     * fl3 : 小于3级
     * fl4 : 小于3级
     * fl5 : 小于3级
     * fl6 : 微风
     * fx1 : 东南风
     * fx2 : 东南风
     * img1 :
     * img10 :
     * img11 :
     * img12 :
     * img2 :
     * img3 :
     * img4 :
     * img5 :
     * img6 :
     * img7 :
     * img8 :
     * img9 :
     * img_single :
     * img_title1 : 多云
     * img_title10 : 晴
     * img_title11 : 晴
     * img_title12 : 晴
     * img_title2 : 阴
     * img_title3 : 多云
     * img_title4 : 阴
     * img_title5 : 阵雨
     * img_title6 : 阵雨
     * img_title7 : 多云
     * img_title8 : 雷阵雨
     * img_title9 : 晴
     * img_title_single :
     * index : 较舒适
     * index48 :
     * index48_d :
     * index48_uv :
     * index_ag : 极易发
     * index_cl : 较适宜
     * index_co : 舒适
     * index_d :
     * index_ls : 适宜
     * index_tr : 适宜
     * index_uv : 最弱
     * index_xc : 较适宜
     * st1 :
     * st2 :
     * st3 :
     * st4 :
     * st5 :
     * st6 :
     * temp1 : 20℃~14℃
     * temp2 : 20℃~14℃
     * temp3 : 23℃~14℃
     * temp4 : 25℃~15℃
     * temp5 : 25℃~17℃
     * temp6 : 0℃~0℃
     * tempF1 :
     * tempF2 :
     * tempF3 :
     * tempF4 :
     * tempF5 :
     * tempF6 :
     * weather1 : 多云转阴
     * weather2 : 多云转阴
     * weather3 : 阵雨
     * weather4 : 多云转雷阵雨
     * weather5 : 晴
     * weather6 : 晴
     * week : 星期二
     * wind1 : 东南风
     * wind2 : 东南风
     * wind3 : 东南风
     * wind4 : 南风
     * wind5 : 南风
     * wind6 : 微风
     */

    private ForecastBean forecast;
    /**
     * SD : 62%
     * WD : 东北风
     * WS : 1级
     * WSE :
     * city :
     * cityid : 101260802
     * isRadar : 1
     * radar : JC_RADAR_AZ9010_JB
     * temp : 20
     * time : 14:15
     * weather : 阴
     */

    private RealtimeBean realtime;
    /**
     * cityCode : 101260802
     * date : 2016-04-10
     * humidityMax : 80
     * humidityMin : 58
     * precipitationMax : 1
     * precipitationMin : 0
     * tempMax : 20
     * tempMin : 14
     * weatherEnd : 阴
     * weatherStart : 雷阵雨
     * windDirectionEnd : 东北风
     * windDirectionStart : 北风
     * windMax : 3
     * windMin : 0
     */

    private TodayBean today;
    /**
     * cityCode : 101260802
     * date : 2016-04-09
     * humidityMax : 99
     * humidityMin : 67
     * precipitationMax : 1
     * precipitationMin : 0
     * tempMax : 23
     * tempMin : 15
     * weatherEnd : 雷阵雨
     * weatherStart : 阵雨
     * windDirectionEnd : 东北风
     * windDirectionStart : 南风
     * windMax : 3
     * windMin : 0
     */

    private YestodayBean yestoday;
    /**
     * accu_cc : {"EpochTime":"1460269260","LocalObservationDateTime":"2016-04-10T14:21:00+08:00","Pressure":"1009.4","RealFeelTemperature":"24.3","RelativeHumidity":"58","UVIndex":"6","Visibility":"20.9","WindDirectionDegrees":"90","WindSpeed":"3.2"}
     * accu_f5 : {"DailyForecasts":[{"Date":"2016-04-10T07:00:00+08:00","EpochDate":"1460242800","PrecipitationProbability":"25","Sun_EpochRise":"1460241600","Sun_EpochSet":"1460287200","Sun_Rise":"2016-04-10T06:40:00+08:00","Sun_Set":"2016-04-10T19:20:00+08:00"},{"Date":"2016-04-11T07:00:00+08:00","EpochDate":"1460329200","PrecipitationProbability":"25","Sun_EpochRise":"1460327940","Sun_EpochSet":"1460373660","Sun_Rise":"2016-04-11T06:39:00+08:00","Sun_Set":"2016-04-11T19:21:00+08:00"},{"Date":"2016-04-12T07:00:00+08:00","EpochDate":"1460415600","PrecipitationProbability":"25","Sun_EpochRise":"1460414280","Sun_EpochSet":"1460460060","Sun_Rise":"2016-04-12T06:38:00+08:00","Sun_Set":"2016-04-12T19:21:00+08:00"},{"Date":"2016-04-13T07:00:00+08:00","EpochDate":"1460502000","PrecipitationProbability":"11","Sun_EpochRise":"1460500620","Sun_EpochSet":"1460546520","Sun_Rise":"2016-04-13T06:37:00+08:00","Sun_Set":"2016-04-13T19:22:00+08:00"},{"Date":"2016-04-14T07:00:00+08:00","EpochDate":"1460588400","PrecipitationProbability":"25","Sun_EpochRise":"1460586960","Sun_EpochSet":"1460632920","Sun_Rise":"2016-04-14T06:36:00+08:00","Sun_Set":"2016-04-14T19:22:00+08:00"}],"EffectiveDate":"2016-04-12T01:00:00+08:00","EffectiveEpochDate":"1460394000"}
     * alert : []
     * aqi : {"aqi":"80","city":"六枝","city_id":"101260802","no2":"32","pm10":"106","pm25":"51","pub_time":"2016-04-10 13:00","so2":"10","spot":"","src":"中国环境监测总站"}
     * forecast : {"city":"六枝","city_en":"liuzhi","cityid":"101260802","date":"","date_y":"2016年04月10日","fchh":"11","fl1":"小于3级","fl2":"小于3级","fl3":"小于3级","fl4":"小于3级","fl5":"小于3级","fl6":"微风","fx1":"东南风","fx2":"东南风","img1":"","img10":"","img11":"","img12":"","img2":"","img3":"","img4":"","img5":"","img6":"","img7":"","img8":"","img9":"","img_single":"","img_title1":"多云","img_title10":"晴","img_title11":"晴","img_title12":"晴","img_title2":"阴","img_title3":"多云","img_title4":"阴","img_title5":"阵雨","img_title6":"阵雨","img_title7":"多云","img_title8":"雷阵雨","img_title9":"晴","img_title_single":"","index":"较舒适","index48":"","index48_d":"","index48_uv":"","index_ag":"极易发","index_cl":"较适宜","index_co":"舒适","index_d":"","index_ls":"适宜","index_tr":"适宜","index_uv":"最弱","index_xc":"较适宜","st1":"","st2":"","st3":"","st4":"","st5":"","st6":"","temp1":"20℃~14℃","temp2":"20℃~14℃","temp3":"23℃~14℃","temp4":"25℃~15℃","temp5":"25℃~17℃","temp6":"0℃~0℃","tempF1":"","tempF2":"","tempF3":"","tempF4":"","tempF5":"","tempF6":"","weather1":"多云转阴","weather2":"多云转阴","weather3":"阵雨","weather4":"多云转雷阵雨","weather5":"晴","weather6":"晴","week":"星期二","wind1":"东南风","wind2":"东南风","wind3":"东南风","wind4":"南风","wind5":"南风","wind6":"微风"}
     * index : [{"code":"fs","details":"属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","index":"弱","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","index":"较舒适","name":"穿衣指数","otherName":""},{"code":"yd","details":"天气较好，但考虑气温较低，推荐您进行室内运动，若户外适当增减衣物并注意防晒。","index":"较适宜","name":"运动指数","otherName":""},{"code":"xc","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","index":"较适宜","name":"洗车指数","otherName":""},{"code":"ls","details":"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！","index":"适宜","name":"晾晒指数","otherName":""}]
     * realtime : {"SD":"62%","WD":"东北风","WS":"1级","WSE":"","city":"","cityid":"101260802","isRadar":"1","radar":"JC_RADAR_AZ9010_JB","temp":"20","time":"14:15","weather":"阴"}
     * today : {"cityCode":"101260802","date":"2016-04-10","humidityMax":80,"humidityMin":58,"precipitationMax":1,"precipitationMin":0,"tempMax":20,"tempMin":14,"weatherEnd":"阴","weatherStart":"雷阵雨","windDirectionEnd":"东北风","windDirectionStart":"北风","windMax":3,"windMin":0}
     * yestoday : {"cityCode":"101260802","date":"2016-04-09","humidityMax":99,"humidityMin":67,"precipitationMax":1,"precipitationMin":0,"tempMax":23,"tempMin":15,"weatherEnd":"雷阵雨","weatherStart":"阵雨","windDirectionEnd":"东北风","windDirectionStart":"南风","windMax":3,"windMin":0}
     */

    private List<?> alert;
    /**
     * code : fs
     * details : 属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
     * index : 弱
     * name : 防晒指数
     * otherName :
     */

    private List<IndexBean> index;

    public AccuCcBean getAccu_cc() {
        return accu_cc;
    }

    public void setAccu_cc(AccuCcBean accu_cc) {
        this.accu_cc = accu_cc;
    }

    public AccuF5Bean getAccu_f5() {
        return accu_f5;
    }

    public void setAccu_f5(AccuF5Bean accu_f5) {
        this.accu_f5 = accu_f5;
    }

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

    public ForecastBean getForecast() {
        return forecast;
    }

    public void setForecast(ForecastBean forecast) {
        this.forecast = forecast;
    }

    public RealtimeBean getRealtime() {
        return realtime;
    }

    public void setRealtime(RealtimeBean realtime) {
        this.realtime = realtime;
    }

    public TodayBean getToday() {
        return today;
    }

    public void setToday(TodayBean today) {
        this.today = today;
    }

    public YestodayBean getYestoday() {
        return yestoday;
    }

    public void setYestoday(YestodayBean yestoday) {
        this.yestoday = yestoday;
    }

    public List<?> getAlert() {
        return alert;
    }

    public void setAlert(List<?> alert) {
        this.alert = alert;
    }

    public List<IndexBean> getIndex() {
        return index;
    }

    public void setIndex(List<IndexBean> index) {
        this.index = index;
    }

    public static class AccuCcBean {
        private String EpochTime;
        private String LocalObservationDateTime;
        private String Pressure;
        private String RealFeelTemperature;
        private String RelativeHumidity;
        private String UVIndex;
        private String Visibility;
        private String WindDirectionDegrees;
        private String WindSpeed;

        public String getEpochTime() {
            return EpochTime;
        }

        public void setEpochTime(String EpochTime) {
            this.EpochTime = EpochTime;
        }

        public String getLocalObservationDateTime() {
            return LocalObservationDateTime;
        }

        public void setLocalObservationDateTime(String LocalObservationDateTime) {
            this.LocalObservationDateTime = LocalObservationDateTime;
        }

        public String getPressure() {
            return Pressure;
        }

        public void setPressure(String Pressure) {
            this.Pressure = Pressure;
        }

        public String getRealFeelTemperature() {
            return RealFeelTemperature;
        }

        public void setRealFeelTemperature(String RealFeelTemperature) {
            this.RealFeelTemperature = RealFeelTemperature;
        }

        public String getRelativeHumidity() {
            return RelativeHumidity;
        }

        public void setRelativeHumidity(String RelativeHumidity) {
            this.RelativeHumidity = RelativeHumidity;
        }

        public String getUVIndex() {
            return UVIndex;
        }

        public void setUVIndex(String UVIndex) {
            this.UVIndex = UVIndex;
        }

        public String getVisibility() {
            return Visibility;
        }

        public void setVisibility(String Visibility) {
            this.Visibility = Visibility;
        }

        public String getWindDirectionDegrees() {
            return WindDirectionDegrees;
        }

        public void setWindDirectionDegrees(String WindDirectionDegrees) {
            this.WindDirectionDegrees = WindDirectionDegrees;
        }

        public String getWindSpeed() {
            return WindSpeed;
        }

        public void setWindSpeed(String WindSpeed) {
            this.WindSpeed = WindSpeed;
        }
    }

    public static class AccuF5Bean {
        private String EffectiveDate;
        private String EffectiveEpochDate;
        /**
         * Date : 2016-04-10T07:00:00+08:00
         * EpochDate : 1460242800
         * PrecipitationProbability : 25
         * Sun_EpochRise : 1460241600
         * Sun_EpochSet : 1460287200
         * Sun_Rise : 2016-04-10T06:40:00+08:00
         * Sun_Set : 2016-04-10T19:20:00+08:00
         */

        private List<DailyForecastsBean> DailyForecasts;

        public String getEffectiveDate() {
            return EffectiveDate;
        }

        public void setEffectiveDate(String EffectiveDate) {
            this.EffectiveDate = EffectiveDate;
        }

        public String getEffectiveEpochDate() {
            return EffectiveEpochDate;
        }

        public void setEffectiveEpochDate(String EffectiveEpochDate) {
            this.EffectiveEpochDate = EffectiveEpochDate;
        }

        public List<DailyForecastsBean> getDailyForecasts() {
            return DailyForecasts;
        }

        public void setDailyForecasts(List<DailyForecastsBean> DailyForecasts) {
            this.DailyForecasts = DailyForecasts;
        }

        public static class DailyForecastsBean {
            private String Date;
            private String EpochDate;
            private String PrecipitationProbability;
            private String Sun_EpochRise;
            private String Sun_EpochSet;
            private String Sun_Rise;
            private String Sun_Set;

            public String getDate() {
                return Date;
            }

            public void setDate(String Date) {
                this.Date = Date;
            }

            public String getEpochDate() {
                return EpochDate;
            }

            public void setEpochDate(String EpochDate) {
                this.EpochDate = EpochDate;
            }

            public String getPrecipitationProbability() {
                return PrecipitationProbability;
            }

            public void setPrecipitationProbability(String PrecipitationProbability) {
                this.PrecipitationProbability = PrecipitationProbability;
            }

            public String getSun_EpochRise() {
                return Sun_EpochRise;
            }

            public void setSun_EpochRise(String Sun_EpochRise) {
                this.Sun_EpochRise = Sun_EpochRise;
            }

            public String getSun_EpochSet() {
                return Sun_EpochSet;
            }

            public void setSun_EpochSet(String Sun_EpochSet) {
                this.Sun_EpochSet = Sun_EpochSet;
            }

            public String getSun_Rise() {
                return Sun_Rise;
            }

            public void setSun_Rise(String Sun_Rise) {
                this.Sun_Rise = Sun_Rise;
            }

            public String getSun_Set() {
                return Sun_Set;
            }

            public void setSun_Set(String Sun_Set) {
                this.Sun_Set = Sun_Set;
            }
        }
    }

    public static class AqiBean {
        private String aqi;
        private String city;
        private String city_id;
        private String no2;
        private String pm10;
        private String pm25;
        private String pub_time;
        private String so2;
        private String spot;
        private String src;

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getSpot() {
            return spot;
        }

        public void setSpot(String spot) {
            this.spot = spot;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }

    public static class ForecastBean {
        private String city;
        private String city_en;
        private String cityid;
        private String date;
        private String date_y;
        private String fchh;
        private String fl1;
        private String fl2;
        private String fl3;
        private String fl4;
        private String fl5;
        private String fl6;
        private String fx1;
        private String fx2;
        private String img1;
        private String img10;
        private String img11;
        private String img12;
        private String img2;
        private String img3;
        private String img4;
        private String img5;
        private String img6;
        private String img7;
        private String img8;
        private String img9;
        private String img_single;
        private String img_title1;
        private String img_title10;
        private String img_title11;
        private String img_title12;
        private String img_title2;
        private String img_title3;
        private String img_title4;
        private String img_title5;
        private String img_title6;
        private String img_title7;
        private String img_title8;
        private String img_title9;
        private String img_title_single;
        private String index;
        private String index48;
        private String index48_d;
        private String index48_uv;
        private String index_ag;
        private String index_cl;
        private String index_co;
        private String index_d;
        private String index_ls;
        private String index_tr;
        private String index_uv;
        private String index_xc;
        private String st1;
        private String st2;
        private String st3;
        private String st4;
        private String st5;
        private String st6;
        private String temp1;
        private String temp2;
        private String temp3;
        private String temp4;
        private String temp5;
        private String temp6;
        private String tempF1;
        private String tempF2;
        private String tempF3;
        private String tempF4;
        private String tempF5;
        private String tempF6;
        private String weather1;
        private String weather2;
        private String weather3;
        private String weather4;
        private String weather5;
        private String weather6;
        private String week;
        private String wind1;
        private String wind2;
        private String wind3;
        private String wind4;
        private String wind5;
        private String wind6;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_en() {
            return city_en;
        }

        public void setCity_en(String city_en) {
            this.city_en = city_en;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate_y() {
            return date_y;
        }

        public void setDate_y(String date_y) {
            this.date_y = date_y;
        }

        public String getFchh() {
            return fchh;
        }

        public void setFchh(String fchh) {
            this.fchh = fchh;
        }

        public String getFl1() {
            return fl1;
        }

        public void setFl1(String fl1) {
            this.fl1 = fl1;
        }

        public String getFl2() {
            return fl2;
        }

        public void setFl2(String fl2) {
            this.fl2 = fl2;
        }

        public String getFl3() {
            return fl3;
        }

        public void setFl3(String fl3) {
            this.fl3 = fl3;
        }

        public String getFl4() {
            return fl4;
        }

        public void setFl4(String fl4) {
            this.fl4 = fl4;
        }

        public String getFl5() {
            return fl5;
        }

        public void setFl5(String fl5) {
            this.fl5 = fl5;
        }

        public String getFl6() {
            return fl6;
        }

        public void setFl6(String fl6) {
            this.fl6 = fl6;
        }

        public String getFx1() {
            return fx1;
        }

        public void setFx1(String fx1) {
            this.fx1 = fx1;
        }

        public String getFx2() {
            return fx2;
        }

        public void setFx2(String fx2) {
            this.fx2 = fx2;
        }

        public String getImg1() {
            return img1;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }

        public String getImg10() {
            return img10;
        }

        public void setImg10(String img10) {
            this.img10 = img10;
        }

        public String getImg11() {
            return img11;
        }

        public void setImg11(String img11) {
            this.img11 = img11;
        }

        public String getImg12() {
            return img12;
        }

        public void setImg12(String img12) {
            this.img12 = img12;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getImg3() {
            return img3;
        }

        public void setImg3(String img3) {
            this.img3 = img3;
        }

        public String getImg4() {
            return img4;
        }

        public void setImg4(String img4) {
            this.img4 = img4;
        }

        public String getImg5() {
            return img5;
        }

        public void setImg5(String img5) {
            this.img5 = img5;
        }

        public String getImg6() {
            return img6;
        }

        public void setImg6(String img6) {
            this.img6 = img6;
        }

        public String getImg7() {
            return img7;
        }

        public void setImg7(String img7) {
            this.img7 = img7;
        }

        public String getImg8() {
            return img8;
        }

        public void setImg8(String img8) {
            this.img8 = img8;
        }

        public String getImg9() {
            return img9;
        }

        public void setImg9(String img9) {
            this.img9 = img9;
        }

        public String getImg_single() {
            return img_single;
        }

        public void setImg_single(String img_single) {
            this.img_single = img_single;
        }

        public String getImg_title1() {
            return img_title1;
        }

        public void setImg_title1(String img_title1) {
            this.img_title1 = img_title1;
        }

        public String getImg_title10() {
            return img_title10;
        }

        public void setImg_title10(String img_title10) {
            this.img_title10 = img_title10;
        }

        public String getImg_title11() {
            return img_title11;
        }

        public void setImg_title11(String img_title11) {
            this.img_title11 = img_title11;
        }

        public String getImg_title12() {
            return img_title12;
        }

        public void setImg_title12(String img_title12) {
            this.img_title12 = img_title12;
        }

        public String getImg_title2() {
            return img_title2;
        }

        public void setImg_title2(String img_title2) {
            this.img_title2 = img_title2;
        }

        public String getImg_title3() {
            return img_title3;
        }

        public void setImg_title3(String img_title3) {
            this.img_title3 = img_title3;
        }

        public String getImg_title4() {
            return img_title4;
        }

        public void setImg_title4(String img_title4) {
            this.img_title4 = img_title4;
        }

        public String getImg_title5() {
            return img_title5;
        }

        public void setImg_title5(String img_title5) {
            this.img_title5 = img_title5;
        }

        public String getImg_title6() {
            return img_title6;
        }

        public void setImg_title6(String img_title6) {
            this.img_title6 = img_title6;
        }

        public String getImg_title7() {
            return img_title7;
        }

        public void setImg_title7(String img_title7) {
            this.img_title7 = img_title7;
        }

        public String getImg_title8() {
            return img_title8;
        }

        public void setImg_title8(String img_title8) {
            this.img_title8 = img_title8;
        }

        public String getImg_title9() {
            return img_title9;
        }

        public void setImg_title9(String img_title9) {
            this.img_title9 = img_title9;
        }

        public String getImg_title_single() {
            return img_title_single;
        }

        public void setImg_title_single(String img_title_single) {
            this.img_title_single = img_title_single;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getIndex48() {
            return index48;
        }

        public void setIndex48(String index48) {
            this.index48 = index48;
        }

        public String getIndex48_d() {
            return index48_d;
        }

        public void setIndex48_d(String index48_d) {
            this.index48_d = index48_d;
        }

        public String getIndex48_uv() {
            return index48_uv;
        }

        public void setIndex48_uv(String index48_uv) {
            this.index48_uv = index48_uv;
        }

        public String getIndex_ag() {
            return index_ag;
        }

        public void setIndex_ag(String index_ag) {
            this.index_ag = index_ag;
        }

        public String getIndex_cl() {
            return index_cl;
        }

        public void setIndex_cl(String index_cl) {
            this.index_cl = index_cl;
        }

        public String getIndex_co() {
            return index_co;
        }

        public void setIndex_co(String index_co) {
            this.index_co = index_co;
        }

        public String getIndex_d() {
            return index_d;
        }

        public void setIndex_d(String index_d) {
            this.index_d = index_d;
        }

        public String getIndex_ls() {
            return index_ls;
        }

        public void setIndex_ls(String index_ls) {
            this.index_ls = index_ls;
        }

        public String getIndex_tr() {
            return index_tr;
        }

        public void setIndex_tr(String index_tr) {
            this.index_tr = index_tr;
        }

        public String getIndex_uv() {
            return index_uv;
        }

        public void setIndex_uv(String index_uv) {
            this.index_uv = index_uv;
        }

        public String getIndex_xc() {
            return index_xc;
        }

        public void setIndex_xc(String index_xc) {
            this.index_xc = index_xc;
        }

        public String getSt1() {
            return st1;
        }

        public void setSt1(String st1) {
            this.st1 = st1;
        }

        public String getSt2() {
            return st2;
        }

        public void setSt2(String st2) {
            this.st2 = st2;
        }

        public String getSt3() {
            return st3;
        }

        public void setSt3(String st3) {
            this.st3 = st3;
        }

        public String getSt4() {
            return st4;
        }

        public void setSt4(String st4) {
            this.st4 = st4;
        }

        public String getSt5() {
            return st5;
        }

        public void setSt5(String st5) {
            this.st5 = st5;
        }

        public String getSt6() {
            return st6;
        }

        public void setSt6(String st6) {
            this.st6 = st6;
        }

        public String getTemp1() {
            return temp1;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }

        public String getTemp3() {
            return temp3;
        }

        public void setTemp3(String temp3) {
            this.temp3 = temp3;
        }

        public String getTemp4() {
            return temp4;
        }

        public void setTemp4(String temp4) {
            this.temp4 = temp4;
        }

        public String getTemp5() {
            return temp5;
        }

        public void setTemp5(String temp5) {
            this.temp5 = temp5;
        }

        public String getTemp6() {
            return temp6;
        }

        public void setTemp6(String temp6) {
            this.temp6 = temp6;
        }

        public String getTempF1() {
            return tempF1;
        }

        public void setTempF1(String tempF1) {
            this.tempF1 = tempF1;
        }

        public String getTempF2() {
            return tempF2;
        }

        public void setTempF2(String tempF2) {
            this.tempF2 = tempF2;
        }

        public String getTempF3() {
            return tempF3;
        }

        public void setTempF3(String tempF3) {
            this.tempF3 = tempF3;
        }

        public String getTempF4() {
            return tempF4;
        }

        public void setTempF4(String tempF4) {
            this.tempF4 = tempF4;
        }

        public String getTempF5() {
            return tempF5;
        }

        public void setTempF5(String tempF5) {
            this.tempF5 = tempF5;
        }

        public String getTempF6() {
            return tempF6;
        }

        public void setTempF6(String tempF6) {
            this.tempF6 = tempF6;
        }

        public String getWeather1() {
            return weather1;
        }

        public void setWeather1(String weather1) {
            this.weather1 = weather1;
        }

        public String getWeather2() {
            return weather2;
        }

        public void setWeather2(String weather2) {
            this.weather2 = weather2;
        }

        public String getWeather3() {
            return weather3;
        }

        public void setWeather3(String weather3) {
            this.weather3 = weather3;
        }

        public String getWeather4() {
            return weather4;
        }

        public void setWeather4(String weather4) {
            this.weather4 = weather4;
        }

        public String getWeather5() {
            return weather5;
        }

        public void setWeather5(String weather5) {
            this.weather5 = weather5;
        }

        public String getWeather6() {
            return weather6;
        }

        public void setWeather6(String weather6) {
            this.weather6 = weather6;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWind1() {
            return wind1;
        }

        public void setWind1(String wind1) {
            this.wind1 = wind1;
        }

        public String getWind2() {
            return wind2;
        }

        public void setWind2(String wind2) {
            this.wind2 = wind2;
        }

        public String getWind3() {
            return wind3;
        }

        public void setWind3(String wind3) {
            this.wind3 = wind3;
        }

        public String getWind4() {
            return wind4;
        }

        public void setWind4(String wind4) {
            this.wind4 = wind4;
        }

        public String getWind5() {
            return wind5;
        }

        public void setWind5(String wind5) {
            this.wind5 = wind5;
        }

        public String getWind6() {
            return wind6;
        }

        public void setWind6(String wind6) {
            this.wind6 = wind6;
        }
    }

    public static class RealtimeBean {
        private String SD;
        private String WD;
        private String WS;
        private String WSE;
        private String city;
        private String cityid;
        private String isRadar;
        private String radar;
        private String temp;
        private String time;
        private String weather;

        public String getSD() {
            return SD;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getWSE() {
            return WSE;
        }

        public void setWSE(String WSE) {
            this.WSE = WSE;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public String getRadar() {
            return radar;
        }

        public void setRadar(String radar) {
            this.radar = radar;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
    }

    public static class TodayBean {
        private String cityCode;
        private String date;
        private String humidityMax;
        private String humidityMin;
        private String precipitationMax;
        private String precipitationMin;
        private String tempMax;
        private String tempMin;
        private String weatherEnd;
        private String weatherStart;
        private String windDirectionEnd;
        private String windDirectionStart;
        private String windMax;
        private String windMin;

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHumidityMax() {
            return humidityMax;
        }

        public void setHumidityMax(String humidityMax) {
            this.humidityMax = humidityMax;
        }

        public String getHumidityMin() {
            return humidityMin;
        }

        public void setHumidityMin(String humidityMin) {
            this.humidityMin = humidityMin;
        }

        public String getPrecipitationMax() {
            return precipitationMax;
        }

        public void setPrecipitationMax(String precipitationMax) {
            this.precipitationMax = precipitationMax;
        }

        public String getPrecipitationMin() {
            return precipitationMin;
        }

        public void setPrecipitationMin(String precipitationMin) {
            this.precipitationMin = precipitationMin;
        }

        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getWeatherEnd() {
            return weatherEnd;
        }

        public void setWeatherEnd(String weatherEnd) {
            this.weatherEnd = weatherEnd;
        }

        public String getWeatherStart() {
            return weatherStart;
        }

        public void setWeatherStart(String weatherStart) {
            this.weatherStart = weatherStart;
        }

        public String getWindDirectionEnd() {
            return windDirectionEnd;
        }

        public void setWindDirectionEnd(String windDirectionEnd) {
            this.windDirectionEnd = windDirectionEnd;
        }

        public String getWindDirectionStart() {
            return windDirectionStart;
        }

        public void setWindDirectionStart(String windDirectionStart) {
            this.windDirectionStart = windDirectionStart;
        }

        public String getWindMax() {
            return windMax;
        }

        public void setWindMax(String windMax) {
            this.windMax = windMax;
        }

        public String getWindMin() {
            return windMin;
        }

        public void setWindMin(String windMin) {
            this.windMin = windMin;
        }
    }

    public static class YestodayBean {
        private String cityCode;
        private String date;
        private String humidityMax;
        private String humidityMin;
        private String precipitationMax;
        private String precipitationMin;
        private String tempMax;
        private String tempMin;
        private String weatherEnd;
        private String weatherStart;
        private String windDirectionEnd;
        private String windDirectionStart;
        private String windMax;
        private String windMin;

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHumidityMax() {
            return humidityMax;
        }

        public void setHumidityMax(String humidityMax) {
            this.humidityMax = humidityMax;
        }

        public String getHumidityMin() {
            return humidityMin;
        }

        public void setHumidityMin(String humidityMin) {
            this.humidityMin = humidityMin;
        }

        public String getPrecipitationMax() {
            return precipitationMax;
        }

        public void setPrecipitationMax(String precipitationMax) {
            this.precipitationMax = precipitationMax;
        }

        public String getPrecipitationMin() {
            return precipitationMin;
        }

        public void setPrecipitationMin(String precipitationMin) {
            this.precipitationMin = precipitationMin;
        }

        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getWeatherEnd() {
            return weatherEnd;
        }

        public void setWeatherEnd(String weatherEnd) {
            this.weatherEnd = weatherEnd;
        }

        public String getWeatherStart() {
            return weatherStart;
        }

        public void setWeatherStart(String weatherStart) {
            this.weatherStart = weatherStart;
        }

        public String getWindDirectionEnd() {
            return windDirectionEnd;
        }

        public void setWindDirectionEnd(String windDirectionEnd) {
            this.windDirectionEnd = windDirectionEnd;
        }

        public String getWindDirectionStart() {
            return windDirectionStart;
        }

        public void setWindDirectionStart(String windDirectionStart) {
            this.windDirectionStart = windDirectionStart;
        }

        public String getWindMax() {
            return windMax;
        }

        public void setWindMax(String windMax) {
            this.windMax = windMax;
        }

        public String getWindMin() {
            return windMin;
        }

        public void setWindMin(String windMin) {
            this.windMin = windMin;
        }
    }

    public static class IndexBean {
        private String code;
        private String details;
        private String index;
        private String name;
        private String otherName;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOtherName() {
            return otherName;
        }

        public void setOtherName(String otherName) {
            this.otherName = otherName;
        }
    }
}
