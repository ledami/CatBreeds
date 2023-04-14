package com.ledami.catbreeds.model;

public class CatBreed {
    private String breedName;
    private String origin;
    private int affectionLevel;
    private int intelligence;
    private String imageUrl;

    public CatBreed() {
    }

    public CatBreed(String breedName, String origin, int affectionLevel, int intelligence, String imageUrl) {
        this.breedName = breedName;
        this.origin = origin;
        this.affectionLevel = affectionLevel;
        this.intelligence = intelligence;
        this.imageUrl = imageUrl;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(int affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
