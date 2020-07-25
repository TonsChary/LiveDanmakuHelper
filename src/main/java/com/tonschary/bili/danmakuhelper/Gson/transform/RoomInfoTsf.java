package com.tonschary.bili.danmakuhelper.Gson.transform;

import com.google.gson.Gson;
import com.tonschary.bili.danmakuhelper.Gson.Bean.RoomInfoBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomInfoTsf {
    public static List<String> getRoomInfoList(String RawJsonText){
       List<String> result = new ArrayList<>();
       Gson gson = new Gson();
       try {
           //最外层
           RoomInfoBean roomInfoBean = gson.fromJson(RawJsonText,RoomInfoBean.class);
           //第二层嵌套
           RoomInfoBean.RoomData inRIB = roomInfoBean.new RoomData();
           inRIB = roomInfoBean.getRoomData();
           //赋值
           String Code = roomInfoBean.getCode();                //状态码
           String RoomID = inRIB.getRealRoomID();               //真实房间ID
           String UpUid = inRIB.getUpUid();                     //UpUid
           String isLiving = inRIB.getIsLiving();               //直播状态
           String RawLastLiveTime = inRIB.getLastLiveTime();    //最后直播时间 时间戳
           //打包数据
           if(Code != null && RoomID != null && UpUid != null && isLiving != null
           && RawLastLiveTime != null){
               String LastLiveTime = StampToDate(RawLastLiveTime);//最后直播时间 格式化
               //打包结果
               result.add(Code);
               result.add(RoomID);
               result.add(UpUid);
               result.add(isLiving);
               result.add(LastLiveTime);
               return result;
           }//if end
       }catch (Exception e){
           System.out.println("解析JSON信息时发生错误");
       }//try-catch end
        result.add("Err");
        return result;
    }//gRIL end

    //将时间戳转换为时间
    private static String StampToDate(String s){
        String result;
        Long timeStamp = new Long(s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        result = sdf.format(new Date(timeStamp * 1000L));
        return result;
    }//STD end
}//class end
