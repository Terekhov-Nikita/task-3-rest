package ru.yandex.profi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.profi.entity.Prize;
import ru.yandex.profi.entity.Promo;
import ru.yandex.profi.repository.PrizeRepository;
import ru.yandex.profi.repository.PromoActionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class PrizeService {

    PromoActionRepository promoRepository;
    PrizeRepository prizeRepository;

    public Long save(Long promoId, Prize data){
        Promo action = promoRepository.findById(promoId).orElseThrow(EntityNotFoundException::new);
        Prize prize = prizeRepository.save(new Prize(0L,data.getDescription(), action));
        return prize.getId();
    }

    public void update(Long promoId,Long id,Prize data){
        Promo action = promoRepository.findById(promoId).orElseThrow(EntityNotFoundException::new);
        Prize prize = prizeRepository.findByActionAndId(action,id).orElseThrow(EntityNotFoundException::new);
        prize.setDescription(data.getDescription());
        prizeRepository.save(prize);
    }

    public Prize get(long promoId, long id){
        Promo action = promoRepository.findById(promoId).orElseThrow(EntityNotFoundException::new);
        return prizeRepository.findByActionAndId(action,id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Prize> get(long promoId){
        Promo action = promoRepository.findById(promoId).orElseThrow(EntityNotFoundException::new);
        return prizeRepository.findAllByAction(action);
    }

    public void delete(Long promoId,Long id){
        Promo action = promoRepository.findById(promoId).orElseThrow(EntityNotFoundException::new);
        Prize prize = prizeRepository.findByActionAndId(action,id).orElseThrow(EntityNotFoundException::new);
        prizeRepository.delete(prize);
    }

}
