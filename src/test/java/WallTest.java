
import org.example.Block;
import org.example.Wall;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Block createBlock(String color, String material) {
        return new Block() {
            @Override
            public String getColor() {
                return color;
            }

            @Override
            public String getMaterial() {
                return material;
            }
        };
    }

    @Test
    void findBlockByColor() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        Optional<Block> foundBlock = wall.findBlockByColor("Red");

        assertTrue(foundBlock.isPresent());
        assertEquals(block1, foundBlock.orElse(null));
    }

    @Test
    void findBlockByColorWhenNotFound() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        Optional<Block> foundBlock = wall.findBlockByColor("Green");

        assertTrue(foundBlock.isEmpty());
    }

    @Test
    void findBlocksByMaterial() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", "Wood");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        List<Block> foundBlocks = wall.findBlocksByMaterial("Wood");

        assertEquals(2, foundBlocks.size());
        assertTrue(foundBlocks.contains(block1));
        assertTrue(foundBlocks.contains(block2));
    }

    @Test
    void findBlocksByMaterialWhenNotFound() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        List<Block> foundBlocks = wall.findBlocksByMaterial("Metal");

        assertEquals(0, foundBlocks.size());
    }

    @Test
    void count() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        int numberOfBlocks = wall.count();

        assertEquals(2, numberOfBlocks);
    }

    @Test
    void getBlocks() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        List<Block> blocks = wall.getBlocks();

        assertEquals(2, blocks.size());
        assertTrue(blocks.contains(block1));
        assertTrue(blocks.contains(block2));
    }

    @Test
    void getColor() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock(null, "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        String color = wall.getColor();

        assertEquals("Red", color);
    }

    @Test
    void getColorWhenNoColorSet() {
        Block block1 = createBlock(null, "Wood");
        Block block2 = createBlock(null, "Stone");
        Wall wall = new Wall(Arrays.asList(block1, block2));

        String color = wall.getColor();

        assertNull(color);
    }

    @Test
    void getMaterial() {
        Block block1 = createBlock("Red", "Wood");
        Block block2 = createBlock("Blue", null);
        Wall wall = new Wall(Arrays.asList(block1, block2));

        String material = wall.getMaterial();

        assertEquals("Wood", material);
    }

    @Test
    void getMaterialWhenNoMaterialSet() {
        Block block1 = createBlock("Red", null);
        Block block2 = createBlock("Blue", null);
        Wall wall = new Wall(Arrays.asList(block1, block2));

        String material = wall.getMaterial();

        assertNull(material);
    }
}
