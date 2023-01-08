package com.ultreon.mods.motobox.block;

import com.ultreon.mods.motobox.item.CourseElementItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class RoadBlockBlock extends HorizontalFacingBlock implements CourseElementItem {
    private static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 3, 6, 16, 10, 10), Block.createCuboidShape(0, 0, 5, 16, 3, 11), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_ROT = VoxelShapes.combineAndSimplify(Block.createCuboidShape(6, 3, 0, 10, 10, 16), Block.createCuboidShape(5, 0, 0, 11, 3, 16), BooleanBiFunction.OR);

    private static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(0, 3, 5, 16, 24, 11);
    private static final VoxelShape COLLISION_SHAPE_ROT = Block.createCuboidShape(5, 3, 0, 11, 24, 16);

    public RoadBlockBlock(Settings settings) {
        super(settings);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH, SOUTH -> SHAPE;
            case EAST, WEST -> SHAPE_ROT;
            default -> throw new IllegalStateException("Unexpected value: " + state.get(FACING));
        };
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH, SOUTH -> COLLISION_SHAPE;
            case EAST, WEST -> COLLISION_SHAPE_ROT;
            default -> throw new IllegalStateException("Unexpected value: " + state.get(FACING));
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
