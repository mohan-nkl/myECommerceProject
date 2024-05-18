package dev.mohannkl.demoonapis.repositories.projections;

public interface ProductProjection {
    long getId();
    String getTitle();
    String getDescription();
    double getPrice();
    boolean getIsDeleted();


}
