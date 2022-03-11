package ru.yandex.profi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.profi.entity.Promo;

public interface PromoActionRepository extends JpaRepository<Promo, Long>  {
  }
