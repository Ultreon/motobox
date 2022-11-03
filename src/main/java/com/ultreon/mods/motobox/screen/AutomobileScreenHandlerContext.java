package com.ultreon.mods.motobox.screen;

import com.ultreon.mods.motobox.automobile.attachment.rear.BlockRearAttachment;
import com.ultreon.mods.motobox.entity.AutomobileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.function.BiFunction;

public class AutomobileScreenHandlerContext implements ScreenHandlerContext {
    private final World world;
    private final AutomobileEntity automobile;

    public AutomobileScreenHandlerContext(AutomobileEntity automobile) {
        this.world = automobile.getWorld();
        this.automobile = automobile;
    }

    @Override
    public <T> Optional<T> get(BiFunction<World, BlockPos, T> getter) {
        return Optional.of(getter.apply(world, automobile.getBlockPos()));
    }

    public BlockState getAttachmentBlockState() {
        return automobile.getRearAttachment() instanceof BlockRearAttachment att ? att.block : Blocks.AIR.getDefaultState();
    }
}
