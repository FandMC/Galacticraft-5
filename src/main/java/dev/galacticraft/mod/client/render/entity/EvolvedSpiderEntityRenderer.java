/*
 * Copyright (c) 2019-2025 Team Galacticraft
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.galacticraft.mod.client.render.entity;

import dev.galacticraft.mod.Constant;
import dev.galacticraft.mod.client.render.entity.feature.EvolvedSpiderEyesRenderLayer;
import dev.galacticraft.mod.client.render.entity.feature.EvolvedSpiderMaskRenderLayer;
import dev.galacticraft.mod.client.render.entity.feature.OxygenTanksRenderLayer;
import dev.galacticraft.mod.content.entity.EvolvedSpiderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class EvolvedSpiderEntityRenderer extends MobRenderer<EvolvedSpiderEntity, SpiderModel<EvolvedSpiderEntity>> {
    public static final ResourceLocation TEXTURE = Constant.id("textures/entity/evolved/spider.png");

    public EvolvedSpiderEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SpiderModel<>(context.bakeLayer(ModelLayers.SPIDER)), 0.8f);
        this.addLayer(new EvolvedSpiderEyesRenderLayer<>(this));
        this.addLayer(new EvolvedSpiderMaskRenderLayer<>(this));
        this.addLayer(new OxygenTanksRenderLayer<>(this));
    }

    @Override
    protected float getFlipDegrees(EvolvedSpiderEntity spiderEntity) {
        return 180.0F;
    }

    @Override
    public ResourceLocation getTextureLocation(EvolvedSpiderEntity spiderEntity) {
        return TEXTURE;
    }
}
