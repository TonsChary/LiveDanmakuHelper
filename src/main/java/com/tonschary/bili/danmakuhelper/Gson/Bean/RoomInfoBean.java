package com.tonschary.bili.danmakuhelper.Gson.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomInfoBean {

    /*
    * 返回的JSON数据结构:
    * {
    *   "code":                         //状态码 * 0-ok 60004-房间不存在
    *   “msg”: ok                       //信息
    *   "message": ok                   //信息
    *   "data":{                        //数据
    *       "room_id": ------,          //房间真实ID *
    *       "short_id": 0,              //临时ID？？？
    *       "uid": ------,              //UP UID *
    *       "need_p2p": 0,              //需要P2P
    *       "is_hidden": false,         //是否被隐藏
    *       "is_locked": false,         //是否被锁
    *       "is_portrait": false,       //是否为竖屏直播（比如9:16
    *       "live_status": 0,           //查询时直播状态 0未开播 1正在直播 *
    *       "hidden_till": 0,           //还隐藏呢
    *       "lock_till": 0,             //还锁着呢
    *       "encrypted": false,         //是否加密
    *       "pwd_verified": false,      //密码验证
    *       "live_time": ------------,  //最后开始直播时间 时间戳 *
    *       "room_shield": 0,           //房间盾？？？？
    *       "is_sp": 0,                 //标准化病人？？？？
    *       "special_type": 0           //特殊类型
    *   }
    * }
    */

    private String code;        //返回的状态码
    @SerializedName("data")     //data -> RoomData
    private RoomData roomData;  //data 内数据

    public class RoomData{
        @SerializedName("room_id")      //room_id -> RealRoomID
        private String RealRoomID;      //真实房间ID
        @SerializedName("uid")          //uid -> UpUid
        private String UpUid;           //Up的uid
        @SerializedName("live_status")  //live_status -> isLiving
        private String isLiving;        //直播状态
        @SerializedName("live_time")    //live_time -> LastLivingTime
        private String LastLiveTime;    //最后直播时间
        //---------- Get & Set ----------
            //--真实房间ID
        public String getRealRoomID() {
            return RealRoomID;
        }
        public void setRealRoomID(String realRoomID) {
            RealRoomID = realRoomID;
        }
            //--Up的Uid
        public String getUpUid() {
            return UpUid;
        }
        public void setUpUid(String upUid) {
            UpUid = upUid;
        }
            //--直播状态
        public String getIsLiving() {
            return isLiving;
        }
        public void setIsLiving(String isLiving) {
            this.isLiving = isLiving;
        }
            //--最后直播时间
        public String getLastLiveTime() {
            return LastLiveTime;
        }
        public void setLastLiveTime(String lastLiveTime) {
            LastLiveTime = lastLiveTime;
        }
    }//class end
    //---------- Get & Set ----------
        //--code
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    //--RoomData
    public RoomData getRoomData() {
        return roomData;
    }
    public void setRoomData(RoomData roomData) {
        this.roomData = roomData;
    }
}//class end