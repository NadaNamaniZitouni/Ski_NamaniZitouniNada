package tn.esprit.ds.ski_nada_namanizitouni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import tn.esprit.ds.ski_nada_namanizitouni.Entities.BaseEntity;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}