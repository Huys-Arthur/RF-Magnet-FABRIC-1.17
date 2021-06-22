package com.rangetuur.rfmagnet.blocks.blockentities.renderers;

import com.rangetuur.rfmagnet.blocks.blockentities.MagnetJarBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

public class MagnetJarBlockEntityRenderer implements BlockEntityRenderer<MagnetJarBlockEntity> {

    public MagnetJarBlockEntityRenderer(BlockEntityRendererFactory.Context dispatcher) {
    }

    @Override
    public void render(MagnetJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity.getStack(0)!=ItemStack.EMPTY){
            matrices.push();

            matrices.translate(0.5, 0.25, 0.5);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((entity.getWorld().getTime() + tickDelta) * 4));
            int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(0), ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

            matrices.pop();
        }
    }
}
