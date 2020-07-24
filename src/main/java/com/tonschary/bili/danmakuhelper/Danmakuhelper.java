package com.tonschary.bili.danmakuhelper;

import com.tonschary.bili.danmakuhelper.HttpTool.RequestRoomInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Danmakuhelper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("插件已启用");
    }//onEnable end

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("插件已禁用");
    }//onDisable end

    //指令监听
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            //roominfo  查询房间信息
            if(cmd.getName().equalsIgnoreCase("roominfo")){
                if(args.length == 1){//判定参数数量是否为一个
                    String RoomID = args[0];
                    player.sendMessage(ChatColor.YELLOW + "[弹幕助手]" +
                            ChatColor.WHITE + "正在查询房间ID为 " + RoomID + " 的信息...");
                    //http请求查询数据
                    try {
                        String getResult = RequestRoomInfo.getRoomInfo(RoomID);
                        player.sendMessage(ChatColor.YELLOW + "[弹幕助手]" +
                                ChatColor.WHITE + "房间信息如下：\n" + getResult);
                    }catch (Exception e){
                        player.sendMessage("获取房间信息出错！");
                    }//try-catch:GetRoomInfo end
                    return true;
                }else{//参数数量不为1时
                    player.sendMessage(ChatColor.YELLOW + "[弹幕助手]" +
                            ChatColor.RED + "语法错误，请检查语法是否正确");
                    player.sendMessage(ChatColor.YELLOW + "[弹幕助手]" +
                            ChatColor.RED + "正确用法: /roominfo <roomid>");
                }//if-else end
            }//roominfo-if end

            return false;
        }else{
            System.out.println("该命令只能由玩家执行.");
            return  false;
        }//if-else end
    }//onCommand end

}//class end
