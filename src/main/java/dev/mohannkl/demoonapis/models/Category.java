package dev.mohannkl.demoonapis.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel {
    private String title;
    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    // @JsonIgnore
//    @OneToMany(fetch = FetchType.EAGER)
//    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;
}
