package io.github.strikerrocker.realw.integrations.gamestages;

import io.github.strikerrocker.realw.handlers.ConfigHandler;
import net.minecraftforge.common.config.Config;

import java.util.ArrayList;
import java.util.List;

public class GameStagesSupport {

    public static List<String> priorityList = new ArrayList<>();

    public static void load(){
        loadConfig();
    }

    public static void loadConfig(){
        priorityList.clear();
        for(String str : ConfigHandler.gameStagesSupportConfig.priorityList) priorityList.add(str);
    }

    public static class GameStagesSupportConfig {
        @Config.Name("Priority Method")
        @Config.Comment({"The method used to pick which stage to use",
                        "list: use the list specified in the Priority List",
                        "biggest: use the biggest weight",
                        "smallest: use the smallest weight"})
        public String priorityMethod = "list";

        @Config.Name("Priority List")
        @Config.Comment("the list of stages priorities")
        public String[] priorityList = {};
    }
}
