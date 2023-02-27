package com.example.JobPortal.model;

import com.example.JobPortal.model.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    Rating rating;

    @OneToOne
    Account commenter;

    @ManyToOne
    Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRating that = (AccountRating) o;
        return id.equals(that.id) && rating == that.rating && commenter.equals(that.commenter) && account.equals(that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, commenter, account);
    }
}
