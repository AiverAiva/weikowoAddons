package xyz.weikuwu.cute.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandKill;
import net.minecraft.command.ICommand;
import net.minecraft.network.login.server.S02PacketLoginSuccess;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

//This is a qwq
//        __ ___      ____ _
//     / _` \ \ /\ / / _` |
//    | (_| |\ V  V / (_| |
//     \__, | \_/\_/ \__, |
//        | |           | |
//        |_|           |_|
public class ChatLib {
    private static final Map<Class<?>, String> weirdMap = new HashMap<>();

    public static boolean loadCommands(){
        if (weirdMap.size() > 0) return false;
        ClientCommandHandler.instance.getCommands().forEach((cmdName, cmd) -> weirdMap.put(cmd.getClass(), cmdName));
        return true;
    }

    public static void thingy(String qwq){
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(qwq));
    }

    public static void Chat(String string){
        thingy(string);
    }

    public static void Log(String string){
        thingy("§bweikowoAddons > §r" + string);
    }

//    public static void Error(Exception e) {
//        Error(e.getClass().getSimpleName() + ":" + e.getMessage(), e);
//    }
//    public static void Error(String message) {
//        Error(message, new Exception());
//    }
//    private static void Error(String string, Exception e){
//        StackTraceElement[] qwq = e.getStackTrace();
//        Optional<String> cmd = Arrays.stream(qwq)
//                .map(qmq-> {
//                    try { return Class.forName(qmq.getClassName());} catch (ClassNotFoundException pwp) {return System.class;}
//                })
//                .filter(weirdMap::containsKey)
//                .findFirst()
//                .map(weirdMap::get);
//        /*Arrays.stream(qwq).forEach( ste -> {
//            String uwu = "at " + ste.getClassName() + "." + ste.getMethodName() +
//                    "(" + ((ste.getFileName()!=null)?ste.getFileName()+":"+ste.getLineNumber():(ste.isNativeMethod()?"Native Method":"Unknown Source") + ")");
//            Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(uwu));
//        });*/
//        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§bweikowoAddons > §r§cPlease report this: " + cmd.orElse("unknown") + "$" + string));
//    }

    public static void Send(String string){
        Minecraft.getMinecraft().thePlayer.sendChatMessage(string);
    }
}
