package me.alpha432.oyvey.util;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

public class SkinStorageManipulationer {
    public static ResourceLocation getTexture() {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("oyvey/tmp/skin.png"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        DynamicTexture texture = new DynamicTexture(bufferedImage);
        WrappedResource wr = new WrappedResource(FMLClientHandler.instance().getClient().getTextureManager().getDynamicTextureLocation("skin.png", texture));
        return wr.location;
    }

    public static class WrappedResource {
        public final ResourceLocation location;

        public WrappedResource(ResourceLocation location) {
            this.location = location;
        }
    }
}