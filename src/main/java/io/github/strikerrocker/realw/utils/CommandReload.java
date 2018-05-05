package io.github.strikerrocker.realw.utils;

import com.google.common.collect.Lists;
import io.github.strikerrocker.realw.Constants;
import io.github.strikerrocker.realw.RealisticWeight;
import io.github.strikerrocker.realw.mapping.Mapper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by StrikerRocker on 3/5/18.
 */
public class CommandReload extends CommandBase {

    private final List<String> aliases = Lists.newArrayList(Constants.MOD_ID, "reloadweight");

    public CommandReload() {
    }

    @Override
    @Nonnull
    public String getName() {
        return "reloadrw";
    }

    @Override
    @Nonnull
    public String getUsage(ICommandSender sender) {
        return "reloadweight";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Mapper.init(RealisticWeight.PRE_GENERATED_WEIGHT_FILE);
        sender.getCommandSenderEntity().sendMessage(new TextComponentTranslation("realw.cmds.done"));
    }

}
