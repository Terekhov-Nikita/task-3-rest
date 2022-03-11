package ru.yandex.profi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.profi.entity.Prize;
import ru.yandex.profi.entity.Promo;

import java.util.List;
import java.util.Optional;

public interface PrizeRepository extends JpaRepository<Prize, Long> {
    List<Prize> findAllByAction(Promo action);
    Optional<Prize> findByActionAndId(Promo action, Long id);

}
