package org.example;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure, CompositeBlock {
    private List<Block> blocks;

    private Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .toList();
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return blocks.stream()
                .filter(block -> block.getColor() != null)
                .findFirst()
                .map(Block::getColor)
                .orElse(null);
    }

    @Override
    public String getMaterial() {
        return blocks.stream()
                .filter(block -> block.getMaterial() != null)
                .findFirst()
                .map(Block::getMaterial)
                .orElse(null);
    }
}
