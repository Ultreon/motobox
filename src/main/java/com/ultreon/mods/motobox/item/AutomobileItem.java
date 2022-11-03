package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.automobile.AutomobileData;
import com.ultreon.mods.motobox.automobile.AutomobilePrefab;
import com.ultreon.mods.motobox.automobile.AutomobileStats;
import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.entity.AutomobilityEntities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutomobileItem extends Item {
    public static final List<AutomobilePrefab> PREFABS = new ArrayList<>();
    private static final AutomobileData data = new AutomobileData();
    private static final AutomobileStats stats = new AutomobileStats();

    public AutomobileItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            var stack = context.getStack();
            data.read(stack.getOrCreateSubNbt("Automobile"));
            var e = new AutomobileEntity(AutomobilityEntities.AUTOMOBILE, context.getWorld());
            var pos = context.getHitPos();
            e.refreshPositionAndAngles(pos.x, pos.y, pos.z, context.getPlayerFacing().asRotation(), 0);
            e.setComponents(data.getFrame(), data.getWheel(), data.getEngine());
            context.getWorld().spawnEntity(e);
            stack.decrement(1);
            return ActionResult.PASS;
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        data.read(stack.getOrCreateSubNbt("Automobile"));
        if (Screen.hasShiftDown()) {
            stats.from(data.getFrame(), data.getWheel(), data.getEngine());
            stats.appendTexts(tooltip, stats);
        } else {
            if (!data.isPrefab()) {
                tooltip.add(
                        Text.translatable("tooltip.motobox.frameLabel").formatted(Formatting.BLUE)
                                .append(Text.translatable(data.getFrame().getTranslationKey()).formatted(Formatting.DARK_GREEN))
                );
                tooltip.add(
                        Text.translatable("tooltip.motobox.wheelLabel").formatted(Formatting.BLUE)
                                .append(Text.translatable(data.getWheel().getTranslationKey()).formatted(Formatting.DARK_GREEN))
                );
                tooltip.add(
                        Text.translatable("tooltip.motobox.engineLabel").formatted(Formatting.BLUE)
                                .append(Text.translatable(data.getEngine().getTranslationKey()).formatted(Formatting.DARK_GREEN))
                );
            }
            tooltip.add(Text.translatable("tooltip.motobox.shiftForStats").formatted(Formatting.GOLD));
        }
    }

    public static void addPrefabs(AutomobilePrefab ... prefabs) {
        PREFABS.addAll(Arrays.asList(prefabs));
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (isIn(group) || group == ItemGroup.TRANSPORTATION) {
            for (var prefab : PREFABS) {
                stacks.add(prefab.toStack());
            }
        }
    }
}
