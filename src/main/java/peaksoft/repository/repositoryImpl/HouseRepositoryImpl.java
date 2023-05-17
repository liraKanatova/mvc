package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.House;
import peaksoft.entity.User;
import peaksoft.repository.HouseRepository;
@Repository

public class HouseRepositoryImpl implements HouseRepository {
    @PersistenceContext
    private final EntityManager entityManager;
@Autowired
    public HouseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void assignHouseToUser(Long userId, Long houseId) {
        User user = entityManager.find(User.class, userId);
        House house1 = entityManager.find(House.class, houseId);


    }
}
